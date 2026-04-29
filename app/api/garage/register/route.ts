import { NextResponse } from "next/server";
import bcrypt from "bcryptjs";
import { z } from "zod";
import { db } from "@/lib/db";
import { sendMail } from "@/lib/mailer";
import { welcomeGarageEmail } from "@/lib/emails/templates";

const schema = z.object({
  ownerName:   z.string().min(2),
  email:       z.string().email(),
  password:    z.string().min(6),
  phone:       z.string().min(9),
  garageName:  z.string().min(3),
  address:     z.string().min(5),
  city:        z.string().min(2),
  province:    z.string().min(2),
  postalCode:  z.string().length(5),
  description:  z.string().optional(),
  vehicleTypes: z.array(z.string()).min(1).optional(),
  laborRate:    z.number().positive().optional(),
  anchorPrices: z.object({
    revisionBasica:    z.number().nonnegative().optional(),
    preItv:            z.number().nonnegative().optional(),
    aireAcondicionado: z.number().nonnegative().optional(),
  }).optional(),
  excludedBrands: z.array(z.string()).optional(),
});

/** Redondea al múltiplo de 5 más cercano */
function round5(n: number) {
  return Math.round(n / 5) * 5;
}

type ServiceInput = {
  type: string;
  name: string;
  description: string;
  price: number;
  duration: number;
};

/** Genera los GarageService iniciales a partir de los datos del formulario */
function buildInitialServices(
  laborRate: number | undefined,
  anchorPrices: { revisionBasica?: number; preItv?: number; aireAcondicionado?: number } | undefined,
): ServiceInput[] {
  const services: ServiceInput[] = [];

  // ── Servicios gancho a precio cerrado ──────────────────────────────────────
  if (anchorPrices?.revisionBasica) {
    services.push({
      type: "REVISION",
      name: "Revisión básica",
      description: "Revisión periódica del vehículo con comprobación de niveles, frenos, luces y estado general.",
      price: anchorPrices.revisionBasica,
      duration: 60,
    });
  }
  if (anchorPrices?.preItv) {
    services.push({
      type: "PRE_ITV",
      name: "Pre-ITV",
      description: "Revisión previa a la ITV para detectar y corregir posibles deficiencias antes de la inspección oficial.",
      price: anchorPrices.preItv,
      duration: 45,
    });
  }
  if (anchorPrices?.aireAcondicionado) {
    services.push({
      type: "CLIMATIZACION",
      name: "Carga de aire acondicionado",
      description: "Recarga de gas refrigerante y comprobación del sistema de climatización.",
      price: anchorPrices.aireAcondicionado,
      duration: 30,
    });
  }

  // ── Servicios por tarifa de mano de obra ───────────────────────────────────
  if (!laborRate) return services;

  // Sólo añadir si no se ha añadido ya como servicio gancho
  const addedTypes = new Set(services.map(s => s.type));

  // { type, name, desc, durationMin, partsEstimate }
  const byRate: Array<{ type: string; name: string; desc: string; durationMin: number; parts: number }> = [
    {
      type: "CAMBIO_ACEITE",
      name: "Cambio de aceite y filtro",
      desc: "Sustitución del aceite del motor y filtro de aceite con producto adecuado al vehículo.",
      durationMin: 60,
      parts: 30, // estimación coste materiales
    },
    {
      type: "FRENOS",
      name: "Revisión y sustitución de frenos",
      desc: "Inspección del sistema de frenado e instalación de pastillas o discos según necesidad.",
      durationMin: 90,
      parts: 0,
    },
    {
      type: "DIAGNOSTICO",
      name: "Diagnóstico electrónico",
      desc: "Lectura de códigos de error con escáner OBD y emisión de informe técnico.",
      durationMin: 30,
      parts: 0,
    },
    {
      type: "NEUMATICOS",
      name: "Montaje y equilibrado de neumáticos",
      desc: "Montaje, equilibrado y revisión de presiones. Cambio de temporada incluido.",
      durationMin: 30,
      parts: 0,
    },
    {
      type: "FILTROS",
      name: "Cambio de filtros",
      desc: "Sustitución de filtro de aire, habitáculo y/o gasoil según necesidad.",
      durationMin: 30,
      parts: 20,
    },
    {
      type: "ELECTRICIDAD",
      name: "Revisión eléctrica",
      desc: "Diagnóstico y reparación de sistemas eléctricos: batería, alternador y circuitos auxiliares.",
      durationMin: 60,
      parts: 0,
    },
    // Sólo si no vino como gancho
    {
      type: "REVISION",
      name: "Revisión básica",
      desc: "Revisión periódica del vehículo con comprobación de niveles, frenos, luces y estado general.",
      durationMin: 60,
      parts: 0,
    },
  ];

  for (const s of byRate) {
    if (addedTypes.has(s.type)) continue;
    const price = round5((laborRate / 60) * s.durationMin + s.parts);
    services.push({
      type: s.type,
      name: s.name,
      description: s.desc,
      price,
      duration: s.durationMin,
    });
  }

  return services;
}

/** Intenta geocodificar una dirección usando la API de Google Maps.
 *  Devuelve { lat, lng } si tiene éxito, o null si falla (para no bloquear el registro). */
async function geocodificarDireccion(
  address: string,
  city: string,
  postalCode: string,
): Promise<{ lat: number; lng: number } | null> {
  const apiKey = process.env.GOOGLE_MAPS_API_KEY;
  if (!apiKey) return null;

  const query = encodeURIComponent(`${address}, ${postalCode} ${city}, España`);
  const url = `https://maps.googleapis.com/maps/api/geocode/json?address=${query}&key=${apiKey}`;

  try {
    const respuesta = await fetch(url, { next: { revalidate: 0 } });
    if (!respuesta.ok) return null;

    const datos = (await respuesta.json()) as {
      status: string;
      results: Array<{
        geometry: { location: { lat: number; lng: number } };
      }>;
    };

    if (datos.status !== "OK" || datos.results.length === 0) return null;

    const { lat, lng } = datos.results[0].geometry.location;
    return { lat, lng };
  } catch {
    // La geocodificación es opcional: si falla, el registro continúa sin coordenadas
    return null;
  }
}

export async function POST(req: Request) {
  try {
    const body = await req.json();
    const data = schema.parse(body);

    const exists = await db.user.findUnique({ where: { email: data.email } });
    if (exists) return NextResponse.json({ error: "Ya existe una cuenta con ese email" }, { status: 400 });

    const hashed = await bcrypt.hash(data.password, 10);

    // Geocodificación no bloqueante: si falla, el taller se registra sin coordenadas
    const coordenadas = await geocodificarDireccion(data.address, data.city, data.postalCode);

    const initialServices = buildInitialServices(data.laborRate, data.anchorPrices);

    await db.user.create({
      data: {
        name:     data.ownerName,
        email:    data.email,
        password: hashed,
        phone:    data.phone,
        role:     "GARAGE_OWNER",
        garage: {
          create: {
            name:         data.garageName,
            description:  data.description,
            address:      data.address,
            city:         data.city,
            province:     data.province,
            postalCode:   data.postalCode,
            phone:        data.phone,
            email:        data.email,
            vehicleTypes: JSON.stringify(data.vehicleTypes ?? ["COCHE"]),
            ...(data.laborRate !== undefined && { laborRate: data.laborRate }),
            ...(data.anchorPrices && { anchorPrices: JSON.stringify(data.anchorPrices) }),
            ...(data.excludedBrands && data.excludedBrands.length > 0 && { excludedBrands: JSON.stringify(data.excludedBrands) }),
            ...(coordenadas && { lat: coordenadas.lat, lng: coordenadas.lng }),
            ...(initialServices.length > 0 && {
              services: {
                create: initialServices,
              },
            }),
          },
        },
      },
    });

    const { subject, html } = welcomeGarageEmail(data.ownerName, data.garageName);
    void sendMail({ to: data.email, subject, html });

    return NextResponse.json({ ok: true });
  } catch {
    return NextResponse.json({ error: "Error al registrar el taller" }, { status: 500 });
  }
}
