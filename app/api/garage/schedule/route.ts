import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { z } from "zod";

const DEFAULT_SCHEDULE = [
  { dayOfWeek: 0, isOpen: false, openTime: "09:00", closeTime: "14:00" }, // Dom
  { dayOfWeek: 1, isOpen: true,  openTime: "08:00", closeTime: "18:00" }, // Lun
  { dayOfWeek: 2, isOpen: true,  openTime: "08:00", closeTime: "18:00" }, // Mar
  { dayOfWeek: 3, isOpen: true,  openTime: "08:00", closeTime: "18:00" }, // Mié
  { dayOfWeek: 4, isOpen: true,  openTime: "08:00", closeTime: "18:00" }, // Jue
  { dayOfWeek: 5, isOpen: true,  openTime: "08:00", closeTime: "18:00" }, // Vie
  { dayOfWeek: 6, isOpen: true,  openTime: "09:00", closeTime: "14:00" }, // Sáb
];

// GET — devuelve los 7 días del horario del taller autenticado
export async function GET() {
  const session = await auth();
  if (!session?.user) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const garage = await db.garage.findUnique({ where: { ownerId: session.user.id } });
  if (!garage) return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });

  const rows = await db.garageSchedule.findMany({
    where: { garageId: garage.id },
    orderBy: { dayOfWeek: "asc" },
  });

  // Si el taller aún no tiene horario configurado, devolvemos el por defecto sin persistir
  if (rows.length === 0) return NextResponse.json(DEFAULT_SCHEDULE);

  return NextResponse.json(rows);
}

const daySchema = z.object({
  dayOfWeek: z.number().int().min(0).max(6),
  isOpen:    z.boolean(),
  openTime:  z.string().regex(/^\d{2}:\d{2}$/),
  closeTime: z.string().regex(/^\d{2}:\d{2}$/),
});

const schema = z.array(daySchema).length(7);

// PUT — guarda los 7 días del horario (upsert)
export async function PUT(req: Request) {
  const session = await auth();
  if (!session?.user) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const garage = await db.garage.findUnique({ where: { ownerId: session.user.id } });
  if (!garage) return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });

  const body = await req.json();
  const parsed = schema.safeParse(body);
  if (!parsed.success) return NextResponse.json({ error: "Datos inválidos" }, { status: 400 });

  await db.$transaction(
    parsed.data.map((day) =>
      db.garageSchedule.upsert({
        where:  { garageId_dayOfWeek: { garageId: garage.id, dayOfWeek: day.dayOfWeek } },
        create: { garageId: garage.id, ...day },
        update: { isOpen: day.isOpen, openTime: day.openTime, closeTime: day.closeTime },
      })
    )
  );

  return NextResponse.json({ ok: true });
}
