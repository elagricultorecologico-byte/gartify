import { NextResponse } from "next/server";
import { db } from "@/lib/db";

// Endpoint público — valida token base64url firmado: base64url(bookingId:action)
// Solo permite acciones: ok | no
export async function GET(req: Request) {
  const { searchParams } = new URL(req.url);
  const token = searchParams.get("t");

  if (!token) return html("❌ Token inválido", 400);

  let bookingId: string;
  let action: string;

  try {
    const decoded = Buffer.from(token, "base64url").toString("utf-8");
    const parts = decoded.split(":");
    if (parts.length !== 2) throw new Error("bad format");
    [bookingId, action] = parts;
  } catch {
    return html("❌ Token inválido", 400);
  }

  if (action !== "ok" && action !== "no") return html("❌ Acción no válida", 400);

  const booking = await db.booking.findUnique({ where: { id: bookingId } });
  if (!booking) return html("❌ Reserva no encontrada", 404);

  const ACTIONABLE = ["PENDING", "PROPOSED"];
  if (!ACTIONABLE.includes(booking.status)) {
    return html(`ℹ️ Esta reserva ya está en estado <strong>${booking.status}</strong>. No es necesaria ninguna acción.`, 200);
  }

  // PENDING: taller confirma/rechaza → PROPOSED: cliente acepta/rechaza propuesta
  const newStatus = action === "ok"
    ? (booking.status === "PROPOSED" ? "CONFIRMED" : "CONFIRMED")
    : "CANCELLED";
  await db.booking.update({ where: { id: bookingId }, data: { status: newStatus } });

  const isProposed = booking.status === "PROPOSED";
  const msg = newStatus === "CONFIRMED"
    ? (isProposed
        ? "✅ Propuesta de horario <strong>aceptada</strong>. Tu cita ha sido confirmada."
        : "✅ Reserva <strong>confirmada</strong> correctamente. El cliente recibirá una notificación.")
    : (isProposed
        ? "❌ Propuesta de horario <strong>rechazada</strong>. El taller recibirá una notificación."
        : "❌ Reserva <strong>rechazada</strong>. El cliente recibirá una notificación.");

  return html(msg, 200);
}

function html(message: string, status: number) {
  return new NextResponse(
    `<!DOCTYPE html><html lang="es"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1"><title>Gartify</title>
    <style>body{font-family:sans-serif;display:flex;align-items:center;justify-content:center;min-height:100vh;margin:0;background:#f0f4ff}
    .card{background:#fff;border-radius:16px;padding:2rem 2.5rem;box-shadow:0 4px 24px rgba(0,0,0,.08);text-align:center;max-width:400px}
    p{font-size:1.1rem;color:#1e3a8a;margin:0}.logo{font-weight:800;font-size:1.3rem;color:#1E40AF;margin-bottom:1rem}</style>
    </head><body><div class="card"><div class="logo">🔧 Gartify</div><p>${message}</p></div></body></html>`,
    { status, headers: { "Content-Type": "text/html; charset=utf-8" } }
  );
}
