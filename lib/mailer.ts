/**
 * Gartify — Email sender via SMTP (Hostalia)
 *
 * Variables requeridas en .env / .env.local:
 *   SMTP_HOST=smtp.servidor-correo.net
 *   SMTP_PORT=587
 *   SMTP_USER=hola@gartify.es
 *   SMTP_PASS=<contraseña>
 *   EMAIL_FROM=Gartify <hola@gartify.es>
 */

import nodemailer from "nodemailer";

export interface MailPayload {
  to:      string | string[];
  subject: string;
  html:    string;
}

let transporter: nodemailer.Transporter | null = null;

function getTransporter() {
  if (transporter) return transporter;

  transporter = nodemailer.createTransport({
    host:   process.env.SMTP_HOST,
    port:   Number(process.env.SMTP_PORT ?? 587),
    secure: false, // STARTTLS
    auth: {
      user: process.env.SMTP_USER,
      pass: process.env.SMTP_PASS,
    },
  });

  return transporter;
}

export async function sendMail(payload: MailPayload): Promise<void> {
  if (!process.env.SMTP_HOST || !process.env.SMTP_USER || !process.env.SMTP_PASS) {
    console.log("\n[MAIL — SMTP no configurado]");
    console.log("  To:", payload.to);
    console.log("  Subject:", payload.subject);
    return;
  }

  const from = process.env.EMAIL_FROM ?? "Gartify <hola@gartify.es>";

  try {
    await getTransporter().sendMail({ from, ...payload });
  } catch (err) {
    console.error("[MAIL] Error al enviar:", err);
  }
}
