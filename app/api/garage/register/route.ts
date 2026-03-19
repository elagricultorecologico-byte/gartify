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
  postalCode:  z.string().length(5),
  description:  z.string().optional(),
  vehicleTypes: z.array(z.string()).min(1).optional(),
});

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
            postalCode:   data.postalCode,
            phone:        data.phone,
            email:        data.email,
            vehicleTypes: JSON.stringify(data.vehicleTypes ?? ["COCHE"]),
            ...(coordenadas && { lat: coordenadas.lat, lng: coordenadas.lng }),
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
