import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import type { GarageBookingItem } from "@/components/cuenta/GarageBookingList";

/**
 * GET /api/garage/bookings
 *
 * Devuelve las reservas del taller autenticado para polling con SWR.
 * Solo accesible por usuarios con rol GARAGE_OWNER.
 */
export async function GET(): Promise<NextResponse> {
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
  const findManyBookings = db.booking.findMany as unknown as (
    args: unknown
  ) => Promise<GarageBookingItem[]>;

  const reservas = await findManyBookings({
    where: { garageId: garage.id },
    select: {
      id: true,
      code: true,
      status: true,
      date: true,
      totalPrice: true,
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
