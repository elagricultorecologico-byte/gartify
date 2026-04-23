import { NextResponse } from "next/server";
import { db } from "@/lib/db";
import { sendConfirmacionReservaWhatsApp } from "@/lib/whatsapp";

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

  // ok → CONFIRMED siempre (taller confirma o cliente acepta propuesta de horario)
  // no → CANCELLED
  const newStatus = action === "ok" ? "CONFIRMED" : "CANCELLED";
  await db.booking.update({ where: { id: bookingId }, data: { status: newStatus } });

  // ── WhatsApp de confirmación al conductor ──────────────────────────────────
  if (newStatus === "CONFIRMED") {
    const full = await db.booking.findUnique({
      where: { id: bookingId },
      include: {
        garage: true,
        service: true,
        user: { select: { name: true, phone: true, whatsappOptIn: true } },
      },
    });
    if (full?.user?.phone && full.user.whatsappOptIn) {
      sendConfirmacionReservaWhatsApp({
        clientPhone:   full.user.phone,
        clientName:    full.user.name ?? "Cliente",
        garageName:    full.garage.name,
        garageAddress: [full.garage.address, full.garage.city].filter(Boolean).join(", "),
        vehicleModel:  full.vehicleModel ?? undefined,
        vehiclePlate:  full.vehiclePlate ?? undefined,
        serviceName:   full.service?.name ?? full.serviceLabel ?? "Servicio",
        date:          full.date,
        bookingId,
        bookingCode:   full.code || undefined,
      }).catch(console.error);
    }
  }
  // ──────────────────────────────────────────────────────────────────────────

  const msg = action === "ok"
    ? "✅ Reserva <strong>confirmada</strong>. El cliente recibirá una notificación."
    : "❌ Reserva <strong>rechazada</strong>. El cliente recibirá una notificación.";

  return html(msg, 200);
}

function html(message: string, status: number) {
  return new NextResponse(
    `<!DOCTYPE html><html lang="es"><head><meta charset="UTF-8"><meta name="viewport" content="width=device-width,initial-scale=1"><title>Gartify</title>
    <style>body{font-family:sans-serif;display:flex;align-items:center;justify-content:center;min-height:100vh;margin:0;background:#f0f4ff}
    .card{background:#fff;border-radius:16px;padding:2rem 2.5rem;box-shadow:0 4px 24px rgba(0,0,0,.08);text-align:center;max-width:400px}
    p{font-size:1.1rem;color:#1e3a8a;margin:0 0 1.5rem}.logo{font-weight:800;font-size:1.3rem;color:#1E40AF;margin-bottom:1rem}
    a.btn{display:inline-block;margin-top:.5rem;padding:.65rem 1.5rem;background:#1E40AF;color:#fff;border-radius:8px;text-decoration:none;font-size:.95rem;font-weight:600}</style>
    </head><body><div class="card"><div class="logo">🔧 Gartify</div><p>${message}</p><a class="btn" href="/cuenta/taller">Mis reservas</a></div></body></html>`,
    { status, headers: { "Content-Type": "text/html; charset=utf-8" } }
  );
}
