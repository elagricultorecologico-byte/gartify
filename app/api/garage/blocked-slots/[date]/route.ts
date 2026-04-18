import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

// DELETE /api/garage/blocked-slots/:date  (date = ISO string, URL-encoded)
export async function DELETE(
  _req: Request,
  { params }: { params: { date: string } }
) {
  const session = await auth();
  if (!session?.user) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const garage = await db.garage.findUnique({ where: { ownerId: session.user.id } });
  if (!garage) return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });

  const dateObj = new Date(decodeURIComponent(params.date));
  if (isNaN(dateObj.getTime())) return NextResponse.json({ error: "Fecha inválida" }, { status: 400 });

  await db.blockedSlot.deleteMany({
    where: { garageId: garage.id, date: dateObj },
  });

  return NextResponse.json({ ok: true });
}
