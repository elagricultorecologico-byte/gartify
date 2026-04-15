import { NextResponse } from "next/server";
import { z } from "zod";
import { sendMail } from "@/lib/mailer";

const schema = z.object({
  nombre:       z.string().min(2),
  nombreTaller: z.string().min(2),
  telefono:     z.string().min(9),
});

export async function POST(req: Request) {
  const body = await req.json() as unknown;
  const parsed = schema.safeParse(body);
  if (!parsed.success) return NextResponse.json({ error: "Datos inválidos" }, { status: 400 });

  const { nombre, nombreTaller, telefono } = parsed.data;

  await sendMail({
    to: "hola@gartify.es",
    subject: `Nuevo lead /para-talleres — ${nombreTaller}`,
    html: `
      <div style="font-family:sans-serif;max-width:520px;margin:0 auto;padding:24px;background:#f8fafc;border-radius:12px">
        <h2 style="color:#1E40AF;margin-bottom:4px">Nuevo lead desde /para-talleres</h2>
        <p style="color:#64748B;font-size:14px;margin-top:0">Solicitud de llamada recibida</p>
        <table style="width:100%;border-collapse:collapse;margin-top:16px">
          <tr>
            <td style="padding:10px 12px;background:#fff;border:1px solid #e2e8f0;border-radius:8px 8px 0 0;font-size:13px;color:#64748B;width:140px">Nombre</td>
            <td style="padding:10px 12px;background:#fff;border:1px solid #e2e8f0;border-top:none;font-size:14px;font-weight:600;color:#0F172A">${nombre}</td>
          </tr>
          <tr>
            <td style="padding:10px 12px;background:#fff;border:1px solid #e2e8f0;border-top:none;font-size:13px;color:#64748B">Taller</td>
            <td style="padding:10px 12px;background:#fff;border:1px solid #e2e8f0;border-top:none;font-size:14px;font-weight:600;color:#0F172A">${nombreTaller}</td>
          </tr>
          <tr>
            <td style="padding:10px 12px;background:#fff;border:1px solid #e2e8f0;border-top:none;border-radius:0 0 0 8px;font-size:13px;color:#64748B">Teléfono</td>
            <td style="padding:10px 12px;background:#fff;border:1px solid #e2e8f0;border-top:none;border-radius:0 0 8px 0;font-size:14px;font-weight:600;color:#FF5722">
              <a href="tel:${telefono}" style="color:#FF5722;text-decoration:none">${telefono}</a>
            </td>
          </tr>
        </table>
        <p style="margin-top:20px;font-size:12px;color:#94a3b8">Enviado desde gartify.es/para-talleres</p>
      </div>
    `,
  });

  return NextResponse.json({ ok: true });
}
