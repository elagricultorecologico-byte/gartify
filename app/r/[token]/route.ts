import { NextResponse } from "next/server";

// Redirect corto para botones de WhatsApp Business (URLs sin query params)
export async function GET(_req: Request, { params }: { params: { token: string } }) {
  const base = process.env.NEXTAUTH_URL ?? "https://gartify.es";

  try {
    const decoded = Buffer.from(params.token, "base64url").toString("utf-8");
    const [, action] = decoded.split(":");
    if (action === "reschedule") {
      return NextResponse.redirect(`${base}/cuenta/taller`, 302);
    }
  } catch {
    // token inválido — dejar que /confirmar lo gestione
  }

  return NextResponse.redirect(`${base}/confirmar/${params.token}`, 302);
}
