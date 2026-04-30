/**
 * Gartify — Email sender via Postmark
 *
 * Variable requerida en .env / .env.local:
 *   POSTMARK_API_TOKEN=<server api token>
 *   EMAIL_FROM=Gartify <hola@gartify.es>   (opcional, hay un default)
 */

import * as postmark from "postmark";

export interface MailPayload {
  to:      string | string[];
  subject: string;
  html:    string;
}

let client: postmark.ServerClient | null = null;

function getClient() {
  if (client) return client;
  client = new postmark.ServerClient(process.env.POSTMARK_API_TOKEN!);
  return client;
}

export async function sendMail(payload: MailPayload): Promise<void> {
  if (!process.env.POSTMARK_API_TOKEN) {
    console.log("\n[MAIL — Postmark no configurado]");
    console.log("  To:", payload.to);
    console.log("  Subject:", payload.subject);
    return;
  }

  const from = process.env.EMAIL_FROM ?? "Gartify <hola@gartify.es>";
  const toAddresses = Array.isArray(payload.to) ? payload.to.join(",") : payload.to;

  try {
    await getClient().sendEmail({
      From:     from,
      To:       toAddresses,
      Subject:  payload.subject,
      HtmlBody: payload.html,
      MessageStream: "outbound",
    });
  } catch (err) {
    console.error("[MAIL] Error al enviar con Postmark:", err);
  }
}
