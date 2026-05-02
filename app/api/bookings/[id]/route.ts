import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { sendMail } from "@/lib/mailer";
import { bookingStatusUpdateEmail, reservaCanceladaClienteEmail } from "@/lib/emails/templates";
import { sendConfirmacionReservaWhatsApp, sendVehiculoListoWhatsApp } from "@/lib/whatsapp";

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
      garage: { include: { owner: { select: { email: true } } } },
      service: true,
      user: { select: { name: true, email: true, phone: true, whatsappOptIn: true } },
    },
  });

  if (!booking) return NextResponse.json({ error: "Reserva no encontrada" }, { status: 404 });

  const isOwner    = booking.garage.ownerId === session.user.id;
  const isCustomer = booking.userId         === session.user.id;

  if (!isOwner && !isCustomer) return NextResponse.json({ error: "Sin permisos" }, { status: 403 });
  if (isCustomer && status === "CONFIRMED" && booking.status !== "PROPOSED") {
    return NextResponse.json({ error: "Solo puedes confirmar una reserva propuesta" }, { status: 403 });
  }
  if (isCustomer && status !== "CANCELLED" && status !== "CONFIRMED") {
    return NextResponse.json({ error: "Sin permisos" }, { status: 403 });
  }

  const updated = await db.booking.update({ where: { id: params.id }, data: { status } });

  // ── Email al conductor ───────────────────────────────────────────────────
  const notifyStatuses = ["CONFIRMED", "CANCELLED", "COMPLETED"];
  if (notifyStatuses.includes(status) && booking.user?.email) {
    const mail = bookingStatusUpdateEmail({
      customerName: booking.user.name  ?? "Cliente",
      garageName:   booking.garage.name,
      garagePhone:  booking.garage.phone,
      serviceName:  booking.service?.name ?? booking.serviceLabel ?? "Servicio",
      date:         booking.date,
      newStatus:    status as "CONFIRMED" | "CANCELLED" | "COMPLETED",
      bookingId:    booking.id,
    });
    sendMail({ to: booking.user.email, ...mail }).catch(console.error);
  }

  // ── Email al taller cuando el cliente cancela ────────────────────────────
  if (isCustomer && status === "CANCELLED") {
    const ownerEmail = booking.garage.owner?.email;
    if (ownerEmail) {
      const mail = reservaCanceladaClienteEmail({
        garageName:   booking.garage.name,
        customerName: booking.user?.name ?? "Cliente",
        serviceName:  booking.service?.name ?? booking.serviceLabel ?? "Servicio",
        date:         booking.date,
        bookingId:    booking.id,
      });
      sendMail({ to: ownerEmail, ...mail }).catch(console.error);
    }
  }

  // ── WhatsApp al conductor ────────────────────────────────────────────────
  if (booking.user?.phone && booking.user?.whatsappOptIn && isOwner) {
    const garageAddress = [booking.garage.address, booking.garage.city].filter(Boolean).join(", ");
    const serviceName   = booking.service?.name ?? booking.serviceLabel ?? "Servicio";

    if (status === "CONFIRMED") {
      sendConfirmacionReservaWhatsApp({
        clientPhone:   booking.user.phone,
        clientName:    booking.user.name ?? "Cliente",
        garageName:    booking.garage.name,
        garageAddress,
        vehicleModel:  booking.vehicleModel ?? undefined,
        vehiclePlate:  booking.vehiclePlate ?? undefined,
        serviceName,
        date:          booking.date,
        bookingId:     booking.id,
      }).catch(console.error);
    }

    if (status === "COMPLETED") {
      sendVehiculoListoWhatsApp({
        clientPhone:   booking.user.phone,
        clientName:    booking.user.name ?? "Cliente",
        garageName:    booking.garage.name,
        garageAddress,
        vehicleModel:  booking.vehicleModel ?? undefined,
        vehiclePlate:  booking.vehiclePlate ?? undefined,
        serviceName,
        totalPrice:    booking.totalPrice,
        bookingId:     booking.id,
      }).catch(console.error);
    }
  }
  // ─────────────────────────────────────────────────────────────────────────

  return NextResponse.json(updated);
}
