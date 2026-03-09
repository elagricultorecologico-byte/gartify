import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

export async function PATCH(req: Request, { params }: { params: { id: string } }) {
  const session = await auth();
  if (!session?.user?.id) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const { status } = await req.json();

  // Only garage owner can update status
  const booking = await db.booking.findUnique({
    where: { id: params.id },
    include: { garage: true },
  });

  if (!booking) return NextResponse.json({ error: "Reserva no encontrada" }, { status: 404 });

  const userRole = (session.user as { role?: string }).role;
  const isOwner = booking.garage.ownerId === session.user.id;
  const isCustomer = booking.userId === session.user.id;

  if (!isOwner && !isCustomer) return NextResponse.json({ error: "Sin permisos" }, { status: 403 });
  if (isCustomer && status !== "CANCELLED") return NextResponse.json({ error: "Sin permisos" }, { status: 403 });

  const updated = await db.booking.update({ where: { id: params.id }, data: { status } });
  return NextResponse.json(updated);
}
