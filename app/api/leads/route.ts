import { NextResponse } from "next/server";
import { z } from "zod";
import { sendMail } from "@/lib/mailer";
import { nuevoLeadEmail } from "@/lib/emails/templates";

const schema = z.object({
  nombre:       z.string().min(2),
  nombreTaller: z.string().min(2),
  telefono:     z.string().min(9),
  email:        z.string().email().optional(),
  ciudad:       z.string().min(2).optional(),
  mensaje:      z.string().max(500).optional(),
});

export async function POST(req: Request) {
  const body = await req.json() as unknown;
  const parsed = schema.safeParse(body);
  if (!parsed.success) return NextResponse.json({ error: "Datos inválidos" }, { status: 400 });

  const { nombre, nombreTaller, telefono, email, ciudad, mensaje } = parsed.data;

  const { subject, html } = nuevoLeadEmail({ nombre, nombreTaller, telefono, email, ciudad, mensaje });

  await sendMail({ to: "hola@gartify.es", subject, html });

  return NextResponse.json({ ok: true });
}
