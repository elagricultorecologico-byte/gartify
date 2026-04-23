import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { NextResponse } from "next/server";

/**
 * GET /api/bookings/my
 *
 * Devuelve las reservas del cliente autenticado.
 * Solo accesible para usuarios con rol CUSTOMER.
 * Usado por CustomerBookingPoller para polling cada 20 segundos.
 */
export async function GET() {
  const sesion = await auth();

  if (!sesion?.user?.id) {
    return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  }

  const usuario = sesion.user as { id: string; role?: string };

  if (usuario.role !== "CUSTOMER") {
    return NextResponse.json({ error: "Acceso denegado" }, { status: 403 });
  }

  try {
    const reservas = await db.booking.findMany({
      where: { userId: usuario.id },
      select: {
        id: true,
        code: true,
        status: true,
        date: true,
        totalPrice: true,
        vehicleModel: true,
        vehiclePlate: true,
        createdAt: true,
        garage: { select: { name: true, city: true } },
        service: { select: { type: true, name: true } },
        review: { select: { id: true } },
      },
      orderBy: { date: "asc" },
    });

    return NextResponse.json(reservas);
  } catch {
    return NextResponse.json(
      { error: "Error al obtener las reservas" },
      { status: 500 }
    );
  }
}
