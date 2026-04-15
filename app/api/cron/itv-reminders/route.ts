import { NextResponse } from "next/server";
import { db } from "@/lib/db";
import { sendMail } from "@/lib/mailer";
import { itvReminderEmail } from "@/lib/emails/templates";

// Protección por token secreto — el cron del servidor debe incluir:
// Authorization: Bearer <CRON_SECRET>
const CRON_SECRET = process.env.CRON_SECRET;

// Días antes de la ITV en los que se envía el recordatorio
const REMINDER_DAYS = [30, 7];

export async function GET(req: Request) {
  // Verificar token si está configurado
  if (CRON_SECRET) {
    const auth = req.headers.get("authorization");
    if (auth !== `Bearer ${CRON_SECRET}`) {
      return NextResponse.json({ error: "No autorizado" }, { status: 401 });
    }
  }

  const today = new Date();
  today.setHours(0, 0, 0, 0);

  let sent = 0;
  const errors: string[] = [];

  for (const days of REMINDER_DAYS) {
    // Calcular la ventana del día objetivo (medianoche → medianoche siguiente)
    const targetDate = new Date(today);
    targetDate.setDate(today.getDate() + days);
    const targetEnd = new Date(targetDate);
    targetEnd.setDate(targetDate.getDate() + 1);

    const vehicles = await db.vehicle.findMany({
      where: {
        itvDate:     { gte: targetDate, lt: targetEnd },
        itvReminder: true,
      },
      select: {
        id: true,
        alias: true,
        brand: true,
        model: true,
        plate: true,
        itvDate: true,
        user: { select: { name: true, email: true } },
      },
    });

    for (const v of vehicles) {
      if (!v.itvDate || !v.user.email) continue;

      const vehicleName = v.alias ?? `${v.brand} ${v.model}`;
      const { subject, html } = itvReminderEmail({
        userName:    v.user.name ?? "Cliente",
        vehicleName,
        plate:       v.plate,
        itvDate:     v.itvDate,
        daysLeft:    days,
      });

      try {
        await sendMail({ to: v.user.email, subject, html });
        sent++;
      } catch (err) {
        errors.push(`${v.plate}: ${String(err)}`);
      }
    }
  }

  return NextResponse.json({
    ok: true,
    sent,
    errors: errors.length > 0 ? errors : undefined,
    checkedAt: new Date().toISOString(),
  });
}
