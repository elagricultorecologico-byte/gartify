import { NextResponse } from "next/server";
import { z } from "zod";
import { db } from "@/lib/db";
import { sendMail } from "@/lib/mailer";

const esquemaContacto = z.object({
  garageId: z.string().cuid(),
  nombre: z.string().min(2, "El nombre debe tener al menos 2 caracteres"),
  telefono: z
    .string()
    .regex(/^[6789]\d{8}$/, "Teléfono español no válido")
    .optional()
    .or(z.literal("")),
  mensaje: z
    .string()
    .min(10, "El mensaje debe tener al menos 10 caracteres")
    .max(1000, "El mensaje no puede superar los 1000 caracteres"),
});

export async function POST(request: Request) {
  const resultado = esquemaContacto.safeParse(await request.json());

  if (!resultado.success) {
    return NextResponse.json(
      { error: "Datos inválidos", detalles: resultado.error.flatten() },
      { status: 400 }
    );
  }

  const { garageId, nombre, telefono, mensaje } = resultado.data;

  const garage = await db.garage.findUnique({
    where: { id: garageId },
    select: { email: true, name: true },
  });

  if (!garage?.email) {
    return NextResponse.json(
      { error: "Taller no encontrado o sin dirección de email configurada" },
      { status: 404 }
    );
  }

  const html = `
    <table cellpadding="0" cellspacing="0" border="0" width="100%" style="font-family: sans-serif; font-size: 14px; color: #0F172A;">
      <tr><td style="padding: 24px 0 8px;">
        <h2 style="margin: 0 0 16px; font-size: 18px;">Nuevo mensaje de contacto</h2>
        <table cellpadding="8" cellspacing="0" border="1" bordercolor="#e2e8f0" width="100%" style="border-collapse: collapse;">
          <tr>
            <td width="140" style="background: #f8fafc; font-weight: bold; color: #64748B; font-size: 12px; text-transform: uppercase; letter-spacing: 0.05em;">Nombre</td>
            <td>${nombre}</td>
          </tr>
          <tr>
            <td style="background: #f8fafc; font-weight: bold; color: #64748B; font-size: 12px; text-transform: uppercase; letter-spacing: 0.05em;">Teléfono</td>
            <td>${telefono || "—"}</td>
          </tr>
          <tr>
            <td style="background: #f8fafc; font-weight: bold; color: #64748B; font-size: 12px; text-transform: uppercase; letter-spacing: 0.05em;">Mensaje</td>
            <td style="white-space: pre-wrap;">${mensaje}</td>
          </tr>
        </table>
        <p style="margin: 24px 0 0; font-size: 12px; color: #64748B;">Enviado desde tu página en Gartify</p>
      </td></tr>
    </table>
  `;

  await sendMail({
    to: garage.email,
    subject: `Nuevo mensaje de contacto — ${nombre}`,
    html,
  });

  return NextResponse.json({ ok: true });
}
