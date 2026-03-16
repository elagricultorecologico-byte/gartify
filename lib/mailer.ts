/**
 * Gartify — Email sender via Resend
 *
 * Setup:
 *   1. npm install resend          (in PowerShell / Windows Terminal)
 *   2. Create .env.local and add:
 *        RESEND_API_KEY=re_xxxxxxxxxxxx
 *        EMAIL_FROM=Gartify <noreply@gartify.es>
 *        NEXT_PUBLIC_BASE_URL=http://localhost:3000
 *
 * Free tier: 3 000 emails/month — https://resend.com
 */

export interface MailPayload {
  to:      string | string[];
  subject: string;
  html:    string;
}

export async function sendMail(payload: MailPayload): Promise<void> {
  // Dev fallback: log to console until resend is installed + configured
  if (!process.env.RESEND_API_KEY) {
    console.log("\n[MAIL — no RESEND_API_KEY]");
    console.log("  To:", payload.to);
    console.log("  Subject:", payload.subject);
    return;
  }

  try {
    // eslint-disable-next-line @typescript-eslint/no-explicit-any, @typescript-eslint/no-require-imports
    const { Resend } = require("resend") as any;
    const resend = new Resend(process.env.RESEND_API_KEY);
    const from = process.env.EMAIL_FROM ?? "Gartify <noreply@gartify.es>";
    const { error } = await resend.emails.send({ from, ...payload });
    if (error) console.error("Resend error:", error);
  } catch {
    console.warn("resend package not installed. Run: npm install resend");
  }
}
