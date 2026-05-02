import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { sendMail } from "@/lib/mailer";
import { cuentaEliminadaEmail, bajaUsuarioInternoEmail } from "@/lib/emails/templates";

export async function DELETE() {
  const session = await auth();
  if (!session?.user?.id) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const userId = session.user.id;

  const user = await db.user.findUnique({
    where: { id: userId },
    select: { id: true, name: true, email: true, role: true, garage: { select: { id: true } } },
  });

  if (!user) return NextResponse.json({ error: "Usuario no encontrado" }, { status: 404 });

  const role = user.role as "CUSTOMER" | "GARAGE_OWNER";
  const ahora = new Date();

  try {
    if (role === "GARAGE_OWNER" && user.garage) {
      const garageId = user.garage.id;

      await db.$transaction([
        // Soft delete del taller — los datos históricos quedan preservados en BD
        db.garage.update({
          where: { id: garageId },
          data:  { deletedAt: ahora },
        }),
        // Soft delete del usuario
        db.user.update({
          where: { id: userId },
          data:  { deletedAt: ahora },
        }),
        // Anonimizar bookings PENDIENTES/CONFIRMADAS del taller (privacidad del cliente)
        // Las completadas se conservan como datos históricos de negocio
        db.booking.updateMany({
          where: { garageId, status: { in: ["PENDING", "CONFIRMED"] } },
          data:  { userId: null },
        }),
        // Eliminar tokens de verificación de email (ya no tienen utilidad)
        db.emailVerification.deleteMany({ where: { userId } }),
        // Eliminar vehículos del propietario del taller (PII pura, sin valor histórico)
        db.vehicle.deleteMany({ where: { userId } }),
      ]);
    } else {
      await db.$transaction([
        // Soft delete del usuario
        db.user.update({
          where: { id: userId },
          data:  { deletedAt: ahora },
        }),
        // Anonimizar todas las bookings del cliente (desvinculamos la PII)
        db.booking.updateMany({
          where: { userId },
          data:  { userId: null },
        }),
        // Eliminar reviews del cliente (son PII vinculada al usuario)
        db.review.deleteMany({ where: { userId } }),
        // Eliminar vehículos (PII pura)
        db.vehicle.deleteMany({ where: { userId } }),
        // Eliminar tokens de verificación de email
        db.emailVerification.deleteMany({ where: { userId } }),
      ]);
    }
  } catch {
    return NextResponse.json({ error: "Error al eliminar la cuenta" }, { status: 500 });
  }

  // Emails post-eliminación (fire-and-forget, fuera de la transacción)
  // El usuario ya tiene deletedAt pero sus datos de contacto siguen disponibles en esta closure
  const userName  = user.name  ?? "Usuario";
  const userEmail = user.email ?? "";

  const confirmacion = cuentaEliminadaEmail(userName, role);
  void sendMail({ to: userEmail, subject: confirmacion.subject, html: confirmacion.html });

  const interno = bajaUsuarioInternoEmail(userName, userEmail, role);
  void sendMail({ to: "hola@gartify.es", subject: interno.subject, html: interno.html });

  return NextResponse.json({ ok: true });
}
