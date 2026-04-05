import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { sendMail } from "@/lib/mailer";
import { bookingStatusUpdateEmail } from "@/lib/emails/templates";

export async function PATCH(req: Request, { params }: { params: { id: string } }) {
  const session = await auth();
  if (!session?.user?.id) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const { status } = await req.json();

  const VALID_STATUSES = ["PENDING", "PROPOSED", "CONFIRMED", "COMPLETED", "CANCELLED"];
  if (!VALID_STATUSES.includes(status)) {
    return NextResponse.json({ error: "Estado no válido" }, { status: 400 });
  }

  const booking = await db.booking.findUnique({
    where: { id: params.id },
    include: {
      garage: true,
      service: true,
      user: { select: { name: true, email: true } },
    },
  });

  if (!booking) return NextResponse.json({ error: "Reserva no encontrada" }, { status: 404 });

  const isOwner    = booking.garage.ownerId === session.user.id;
  const isCustomer = booking.userId         === session.user.id;

  if (!isOwner && !isCustomer) return NextResponse.json({ error: "Sin permisos" }, { status: 403 });
  if (isCustomer && status !== "CANCELLED") return NextResponse.json({ error: "Sin permisos" }, { status: 403 });

  const updated = await db.booking.update({ where: { id: params.id }, data: { status } });

  // ── Send status-update email to customer ─────────────────────────────────
  const notifyStatuses = ["CONFIRMED", "CANCELLED", "COMPLETED"];
  if (notifyStatuses.includes(status) && booking.user.email) {
    const mail = bookingStatusUpdateEmail({
      customerName: booking.user.name  ?? "Cliente",
      garageName:   booking.garage.name,
      garagePhone:  booking.garage.phone,
      serviceName:  booking.service.name,
      date:         booking.date,
      newStatus:    status as "CONFIRMED" | "CANCELLED" | "COMPLETED",
      bookingId:    booking.id,
    });
    sendMail({ to: booking.user.email, ...mail }).catch(console.error);
  }
  // ─────────────────────────────────────────────────────────────────────────

  return NextResponse.json(updated);
}
