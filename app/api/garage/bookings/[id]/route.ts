import { NextResponse } from "next/server";
import { z } from "zod";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { sendConfirmacionReservaWhatsApp } from "@/lib/whatsapp";

interface Params { params: Promise<{ id: string }> }

const schemaPatch = z.object({
  clientName:   z.string().min(1).max(100).optional(),
  clientPhone:  z.string().max(20).nullable().optional(),
  serviceLabel: z.string().min(1).max(100).optional(),
  date:         z.string().datetime().optional(),
  vehiclePlate: z.string().max(20).nullable().optional(),
  vehicleModel: z.string().max(100).nullable().optional(),
  totalPrice:   z.number().min(0).optional(),
  notes:        z.string().max(500).nullable().optional(),
  status:       z.enum(["CONFIRMED", "CANCELLED", "COMPLETED", "PENDING"]).optional(),
});

async function getGarageId(userId: string): Promise<string | null> {
  const g = await db.garage.findUnique({ where: { ownerId: userId }, select: { id: true } });
  return g?.id ?? null;
}

// ─── PATCH — editar reserva (solo MANUAL, o cambiar status de cualquiera) ──

export async function PATCH(req: Request, { params }: Params) {
  const session = await auth();
  if (!session?.user?.id) return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  const user = session.user as { id: string; role?: string };
  if (user.role !== "GARAGE_OWNER") return NextResponse.json({ error: "No autorizado" }, { status: 403 });

  const { id } = await params;
  const garageId = await getGarageId(user.id);
  if (!garageId) return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });

  const booking = await db.booking.findUnique({
    where: { id },
    select: {
      garageId: true,
      source: true,
      status: true,
      date: true,
      vehicleModel: true,
      vehiclePlate: true,
      serviceLabel: true,
      garage: { select: { name: true, address: true, city: true } },
      service: { select: { name: true } },
      user: { select: { name: true, phone: true, whatsappOptIn: true } },
    },
  });
  if (!booking || booking.garageId !== garageId) return NextResponse.json({ error: "No encontrado" }, { status: 404 });

  const body = await req.json() as unknown;
  const parsed = schemaPatch.safeParse(body);
  if (!parsed.success) return NextResponse.json({ error: "Datos inválidos" }, { status: 400 });

  const d = parsed.data;

  // Solo se pueden editar datos de reservas MANUAL; las GARTIFY solo permiten cambio de status
  if (booking.source !== "MANUAL") {
    if (d.clientName || d.serviceLabel || d.date || d.vehiclePlate || d.vehicleModel || d.totalPrice) {
      return NextResponse.json({ error: "Solo el estado se puede modificar en reservas de Gartify" }, { status: 422 });
    }
  }

  const updated = await db.booking.update({
    where: { id },
    data: {
      ...(d.clientName   !== undefined ? { clientName: d.clientName }   : {}),
      ...(d.clientPhone  !== undefined ? { clientPhone: d.clientPhone }  : {}),
      ...(d.serviceLabel !== undefined ? { serviceLabel: d.serviceLabel } : {}),
      ...(d.date         !== undefined ? { date: new Date(d.date) }      : {}),
      ...(d.vehiclePlate !== undefined ? { vehiclePlate: d.vehiclePlate } : {}),
      ...(d.vehicleModel !== undefined ? { vehicleModel: d.vehicleModel } : {}),
      ...(d.totalPrice   !== undefined ? { totalPrice: d.totalPrice }    : {}),
      ...(d.notes        !== undefined ? { notes: d.notes }              : {}),
      ...(d.status       !== undefined ? { status: d.status }            : {}),
    },
    select: { id: true, status: true, code: true },
  });

  // ── WhatsApp de confirmación al conductor ────────────────────────────────
  if (d.status === "CONFIRMED" && booking.user?.phone && booking.user?.whatsappOptIn) {
    const bookingDate = d.date ? new Date(d.date) : booking.date;
    sendConfirmacionReservaWhatsApp({
      clientPhone:   booking.user.phone,
      clientName:    booking.user.name  ?? "Cliente",
      garageName:    booking.garage.name,
      garageAddress: [booking.garage.address, booking.garage.city].filter(Boolean).join(", "),
      vehicleModel:  (d.vehicleModel ?? booking.vehicleModel) ?? undefined,
      vehiclePlate:  (d.vehiclePlate ?? booking.vehiclePlate) ?? undefined,
      serviceName:   booking.service?.name ?? (d.serviceLabel ?? booking.serviceLabel) ?? "Servicio",
      date:          bookingDate,
      bookingId:     id,
      bookingCode:   updated.code || undefined,
    }).catch(console.error);
  }
  // ─────────────────────────────────────────────────────────────────────────

  return NextResponse.json(updated);
}

// ─── DELETE — eliminar reserva manual ────────────────────────────────────────

export async function DELETE(_req: Request, { params }: Params) {
  const session = await auth();
  if (!session?.user?.id) return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  const user = session.user as { id: string; role?: string };
  if (user.role !== "GARAGE_OWNER") return NextResponse.json({ error: "No autorizado" }, { status: 403 });

  const { id } = await params;
  const garageId = await getGarageId(user.id);
  if (!garageId) return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });

  const booking = await db.booking.findUnique({ where: { id }, select: { garageId: true, source: true } });
  if (!booking || booking.garageId !== garageId) return NextResponse.json({ error: "No encontrado" }, { status: 404 });
  if (booking.source !== "MANUAL") return NextResponse.json({ error: "Solo se pueden eliminar reservas manuales" }, { status: 422 });

  await db.booking.delete({ where: { id } });
  return NextResponse.json({ ok: true });
}
