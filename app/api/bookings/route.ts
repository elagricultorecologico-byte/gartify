import { NextResponse } from "next/server";
import { z } from "zod";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { sendMail } from "@/lib/mailer";
import { bookingConfirmationEmail, garageNewBookingEmail } from "@/lib/emails/templates";

const schema = z.object({
  garageId:     z.string(),
  serviceId:    z.string(),
  date:         z.string(),
  vehiclePlate: z.string().optional(),
  vehicleModel: z.string().optional(),
  notes:        z.string().optional(),
});

export async function POST(req: Request) {
  const session = await auth();
  if (!session?.user?.id) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  try {
    const body = await req.json();
    const data = schema.parse(body);

    const service = await db.garageService.findUnique({ where: { id: data.serviceId } });
    if (!service) return NextResponse.json({ error: "Servicio no encontrado" }, { status: 404 });

    const booking = await db.booking.create({
      data: {
        userId:       session.user.id,
        garageId:     data.garageId,
        serviceId:    data.serviceId,
        date:         new Date(data.date),
        totalPrice:   service.price,
        vehiclePlate: data.vehiclePlate,
        vehicleModel: data.vehicleModel,
        notes:        data.notes,
        status:       "PENDING",
      },
      include: {
        garage: { include: { owner: { select: { email: true } } } },
        user:   { select: { name: true, email: true } },
      },
    });

    // ── Send emails (non-blocking) ──────────────────────────────────────────
    const emailData = {
      customerName:  booking.user.name  ?? "Cliente",
      customerEmail: booking.user.email ?? "",
      garageName:    booking.garage.name,
      garageAddress: `${booking.garage.address}, ${booking.garage.city}`,
      garagePhone:   booking.garage.phone,
      serviceName:   service.name,
      serviceType:   service.type,
      date:          booking.date,
      duration:      service.duration,
      totalPrice:    booking.totalPrice,
      vehiclePlate:  booking.vehiclePlate ?? undefined,
      vehicleModel:  booking.vehicleModel ?? undefined,
      notes:         booking.notes        ?? undefined,
      bookingId:     booking.id,
    };

    // 1. Confirmation to customer
    if (booking.user.email) {
      const mail = bookingConfirmationEmail(emailData);
      sendMail({ to: booking.user.email, ...mail }).catch(console.error);
    }

    // 2. Notification to garage owner
    const garageOwnerEmail = booking.garage.owner?.email;
    if (garageOwnerEmail) {
      const mail = garageNewBookingEmail(emailData);
      sendMail({ to: garageOwnerEmail, ...mail }).catch(console.error);
    }
    // ───────────────────────────────────────────────────────────────────────

    return NextResponse.json({ bookingId: booking.id });
  } catch {
    return NextResponse.json({ error: "Error al crear la reserva" }, { status: 500 });
  }
}

export async function GET() {
  const session = await auth();
  if (!session?.user?.id) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const bookings = await db.booking.findMany({
    where: { userId: session.user.id },
    include: { garage: true, service: true, review: true },
    orderBy: { createdAt: "desc" },
  });

  return NextResponse.json(bookings);
}
