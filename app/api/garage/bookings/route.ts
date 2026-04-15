import { NextResponse } from "next/server";
import { z } from "zod";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import type { GarageBookingItem } from "@/components/cuenta/GarageBookingList";

function generateCode(): string {
  const date = new Date().toISOString().slice(0, 10).replace(/-/g, "");
  const rand = Math.floor(1000 + Math.random() * 9000);
  return `MAN-${date}-${rand}`;
}

const schemaManual = z.object({
  clientName:   z.string().min(1).max(100),
  clientPhone:  z.string().max(20).optional(),
  serviceLabel: z.string().min(1).max(100),
  date:         z.string().datetime(),
  vehiclePlate: z.string().max(20).optional(),
  vehicleModel: z.string().max(100).optional(),
  totalPrice:   z.number().min(0).default(0),
  notes:        z.string().max(500).optional(),
});

/**
 * GET /api/garage/bookings
 *
 * Devuelve las reservas del taller autenticado para polling con SWR.
 * Solo accesible por usuarios con rol GARAGE_OWNER.
 */
export async function GET(req: Request): Promise<NextResponse> {
  const sesion = await auth();

  if (!sesion?.user?.id) {
    return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  }

  const usuario = sesion.user as { id: string; role?: string };

  if (usuario.role !== "GARAGE_OWNER") {
    return NextResponse.json({ error: "Acceso denegado" }, { status: 403 });
  }

  const garage = await db.garage.findUnique({
    where: { ownerId: usuario.id },
    select: { id: true },
  });

  if (!garage) {
    return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });
  }

  // Usamos el mismo cast que en app/cuenta/taller/page.tsx porque el cliente
  // Prisma generado puede no incluir aún el modelo ServiceRecord. En tiempo de
  // ejecución Prisma devuelve los datos correctos del schema real.
  const { searchParams } = new URL(req.url);
  const from = searchParams.get("from");
  const to   = searchParams.get("to");

  const findManyBookings = db.booking.findMany as unknown as (
    args: unknown
  ) => Promise<GarageBookingItem[]>;

  const reservas = await findManyBookings({
    where: {
      garageId: garage.id,
      ...(from && to ? { date: { gte: new Date(from), lte: new Date(to) } } : {}),
    },
    select: {
      id: true,
      code: true,
      source: true,
      status: true,
      date: true,
      totalPrice: true,
      clientName: true,
      clientPhone: true,
      serviceLabel: true,
      vehicleModel: true,
      vehiclePlate: true,
      notes: true,
      user: { select: { name: true, phone: true } },
      service: { select: { type: true, name: true, duration: true } },
      serviceRecord: { select: { id: true } },
    },
    orderBy: { date: "asc" },
  });

  return NextResponse.json(reservas);
}

// ─── POST /api/garage/bookings — crear reserva manual ────────────────────────

export async function POST(req: Request): Promise<NextResponse> {
  const sesion = await auth();
  if (!sesion?.user?.id) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const usuario = sesion.user as { id: string; role?: string };
  if (usuario.role !== "GARAGE_OWNER") return NextResponse.json({ error: "No autorizado" }, { status: 403 });

  const garage = await db.garage.findUnique({ where: { ownerId: usuario.id }, select: { id: true } });
  if (!garage) return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });

  const body = await req.json() as unknown;
  const parsed = schemaManual.safeParse(body);
  if (!parsed.success) return NextResponse.json({ error: "Datos inválidos" }, { status: 400 });

  const d = parsed.data;

  const booking = await db.booking.create({
    data: {
      code:         generateCode(),
      source:       "MANUAL",
      garageId:     garage.id,
      clientName:   d.clientName,
      clientPhone:  d.clientPhone ?? null,
      serviceLabel: d.serviceLabel,
      date:         new Date(d.date),
      status:       "CONFIRMED",
      vehiclePlate: d.vehiclePlate ?? null,
      vehicleModel: d.vehicleModel ?? null,
      totalPrice:   d.totalPrice,
      notes:        d.notes ?? null,
    },
  });

  return NextResponse.json({ id: booking.id, code: booking.code }, { status: 201 });
}
