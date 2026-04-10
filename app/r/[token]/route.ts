import { NextResponse } from "next/server";

// Redirect corto para botones de WhatsApp Business (URLs sin query params)
// /r/[token] → /api/booking-action?t=[token]
export async function GET(_req: Request, { params }: { params: { token: string } }) {
  const base = process.env.NEXTAUTH_URL ?? "https://gartify.es";
  return NextResponse.redirect(`${base}/api/booking-action?t=${params.token}`, 302);
}
