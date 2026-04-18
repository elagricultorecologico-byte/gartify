import { NextRequest, NextResponse } from "next/server";
import { db } from "@/lib/db";

// GET /api/garage/slots?garageId=xxx&date=YYYY-MM-DD
export async function GET(req: NextRequest) {
  const { searchParams } = req.nextUrl;
  const garageId = searchParams.get("garageId");
  const date     = searchParams.get("date"); // "2026-03-15"

  if (!garageId || !date) {
    return NextResponse.json({ error: "garageId and date required" }, { status: 400 });
  }

  // dayOfWeek: 0=Dom, 1=Lun ... 6=Sáb (same as JS Date.getDay())
  const dayOfWeek = new Date(`${date}T12:00:00`).getDay();

  const [schedule, bookings, blockedSlots] = await Promise.all([
    db.garageSchedule.findUnique({
      where: { garageId_dayOfWeek: { garageId, dayOfWeek } },
    }),
    db.booking.findMany({
      where: {
        garageId,
        date:   { gte: new Date(`${date}T00:00:00`), lte: new Date(`${date}T23:59:59`) },
        status: { in: ["PENDING", "CONFIRMED"] },
      },
      select: { date: true, service: { select: { duration: true } } },
    }),
    db.blockedSlot.findMany({
      where: {
        garageId,
        date: { gte: new Date(`${date}T00:00:00`), lte: new Date(`${date}T23:59:59`) },
      },
      select: { date: true },
    }),
  ]);

  // Defaults when no schedule configured: Mon–Fri 08–18, Sat 09–14, Sun closed
  const isOpen        = schedule ? schedule.isOpen    : dayOfWeek !== 0;
  const openTime      = schedule ? schedule.openTime  : dayOfWeek === 6 ? "09:00" : "08:00";
  const closeTime     = schedule ? schedule.closeTime : dayOfWeek === 6 ? "14:00" : "18:00";
  const afternoonStart = (schedule as { afternoonStart?: string | null } | null)?.afternoonStart ?? null;
  const afternoonEnd   = (schedule as { afternoonEnd?:   string | null } | null)?.afternoonEnd   ?? null;

  if (!isOpen) {
    return NextResponse.json({ open: false, openTime, closeTime, blocked: [] });
  }

  // Build set of blocked ISO strings (also block follow-on slots based on duration)
  const blocked = new Set<string>();

  // Bloquear la brecha entre mañana y tarde (p.ej. 14:00–16:00)
  if (afternoonStart && afternoonEnd) {
    const toMins = (t: string) => { const [h, m] = t.split(":").map(Number); return h * 60 + m; };
    const gapStart = toMins(closeTime);       // fin de mañana
    const gapEnd   = toMins(afternoonStart);  // inicio de tarde
    let cur = gapStart;
    while (cur < gapEnd) {
      const hh = String(Math.floor(cur / 60)).padStart(2, "0");
      const mm = String(cur % 60).padStart(2, "0");
      blocked.add(`${date}T${hh}:${mm}`);
      cur += 30;
    }
  }

  // Slots bloqueados manualmente por el taller
  for (const s of blockedSlots) {
    const t  = new Date(s.date);
    const hh = String(t.getHours()).padStart(2, "0");
    const mm = String(t.getMinutes()).padStart(2, "0");
    blocked.add(`${date}T${hh}:${mm}`);
  }

  for (const b of bookings) {
    const start = new Date(b.date);
    const slots = Math.ceil((b.service?.duration ?? 30) / 30);
    for (let i = 0; i < slots; i++) {
      const t  = new Date(start.getTime() + i * 30 * 60 * 1000);
      const hh = String(t.getHours()).padStart(2, "0");
      const mm = String(t.getMinutes()).padStart(2, "0");
      blocked.add(`${date}T${hh}:${mm}`);
    }
  }

  return NextResponse.json({ open: true, openTime, closeTime, blocked: Array.from(blocked) });
}
