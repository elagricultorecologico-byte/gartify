import { NextResponse } from "next/server";
import bcrypt from "bcryptjs";
import crypto from "crypto";
import { z } from "zod";
import { db } from "@/lib/db";
import { generateUniqueSlug } from "@/lib/slug";
import { sendMail } from "@/lib/mailer";
import { verificacionEmailTaller, nuevoTallerInternoEmail } from "@/lib/emails/templates";

/** Schema de un servicio inicial enviado desde el wizard de registro */
const schemaServicioInicial = z.object({
  type:        z.string().min(1),
  name:        z.string().min(1),
  description: z.string(),
  price:       z.number().nonnegative(),
  duration:    z.number().int().positive(),
});

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
  description:     z.string().optional(),
  vehicleTypes:    z.array(z.string()).min(1).optional(),
  laborRate:       z.number().positive().optional(),
  /** Servicios seleccionados en el wizard de registro (máx. 3) */
  initialServices: z.array(schemaServicioInicial).max(3).optional(),
  excludedBrands:  z.array(z.string()).optional(),
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

    // Si el wizard envió servicios explícitos los usamos directamente;
    // en caso contrario, generamos los servicios automáticos como fallback
    // (compatibilidad con integraciones antiguas o formularios sin wizard).
    const initialServices =
      data.initialServices && data.initialServices.length > 0
        ? data.initialServices
        : buildInitialServices(data.laborRate, undefined);

    const newUser = await db.user.create({
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
            // eslint-disable-next-line @typescript-eslint/ban-ts-comment
            // @ts-ignore -- province added in schema, Prisma client needs regeneration
            province:     data.province,
            postalCode:   data.postalCode,
            phone:        data.phone,
            email:        data.email,
            vehicleTypes: JSON.stringify(data.vehicleTypes ?? ["COCHE"]),
            ...(data.laborRate !== undefined && { laborRate: data.laborRate }),
            ...(data.excludedBrands && data.excludedBrands.length > 0 && { excludedBrands: JSON.stringify(data.excludedBrands) }),
            ...(coordenadas && { lat: coordenadas.lat, lng: coordenadas.lng }),
            ...(initialServices.length > 0 && {
              services: { create: initialServices as never },
            }),
          },
        },
      },
    });

    // Generar slug único para la landing pública del taller (/t/[slug])
    const slug = await generateUniqueSlug(data.garageName);
    await db.garage.update({
      where: { ownerId: newUser.id },
      data: { slug },
    });

    // Generar token de verificación de email (válido 24 h)
    const verificationToken = crypto.randomBytes(32).toString("hex");
    const expiresAt = new Date(Date.now() + 24 * 60 * 60 * 1000);

    // eslint-disable-next-line @typescript-eslint/ban-ts-comment
    // @ts-ignore -- EmailVerification added in schema, Prisma client needs regeneration
    await db.emailVerification.create({
      data: {
        token:     verificationToken,
        userId:    newUser.id,
        expiresAt,
      },
    });

    const baseUrl = process.env.NEXT_PUBLIC_BASE_URL ?? "https://gartify.es";
    const verificationUrl = `${baseUrl}/verificar-email/${verificationToken}`;
    const { subject, html } = verificacionEmailTaller(data.ownerName, data.garageName, verificationUrl);
    void sendMail({ to: data.email, subject, html });

    // Notificación interna a Gartify
    const interno = nuevoTallerInternoEmail(data.ownerName, data.garageName, data.email, data.city, data.province);
    void sendMail({ to: "hola@gartify.es", subject: interno.subject, html: interno.html });

    return NextResponse.json({ ok: true });
  } catch {
    return NextResponse.json({ error: "Error al registrar el taller" }, { status: 500 });
  }
}
