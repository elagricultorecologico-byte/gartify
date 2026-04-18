import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

// GET /api/garage/blocked-slots?from=...&to=...
export async function GET(req: Request) {
  const session = await auth();
  if (!session?.user) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const garage = await db.garage.findUnique({ where: { ownerId: session.user.id } });
  if (!garage) return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });

  const { searchParams } = new URL(req.url);
  const from = searchParams.get("from");
  const to   = searchParams.get("to");

  const where = {
    garageId: garage.id,
    ...(from && to ? { date: { gte: new Date(from), lte: new Date(to) } } : {}),
  };

  const slots = await db.blockedSlot.findMany({ where, orderBy: { date: "asc" } });
  return NextResponse.json(slots.map((s) => s.date.toISOString()));
}

// POST /api/garage/blocked-slots  { date: ISO string }
export async function POST(req: Request) {
  const session = await auth();
  if (!session?.user) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const garage = await db.garage.findUnique({ where: { ownerId: session.user.id } });
  if (!garage) return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });

  const { date } = (await req.json()) as { date: string };
  if (!date) return NextResponse.json({ error: "Fecha requerida" }, { status: 400 });

  const dateObj = new Date(date);
  if (isNaN(dateObj.getTime())) return NextResponse.json({ error: "Fecha inválida" }, { status: 400 });

  try {
    await db.blockedSlot.create({ data: { garageId: garage.id, date: dateObj } });
  } catch {
    // @@unique violation → ya bloqueado, ignorar
  }

  return NextResponse.json({ ok: true });
}
