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

  try {
    if (role === "GARAGE_OWNER" && user.garage) {
      const garageId = user.garage.id;

      await db.$transaction([
        // Anonimizar bookings del taller (desvinculamos el userId del cliente)
        db.booking.updateMany({ where: { garageId }, data: { userId: null } }),
        // Eliminar reviews del taller
        db.review.deleteMany({ where: { garageId } }),
        // Eliminar bookings sin usuario y sin review (las que quedan huérfanas)
        db.booking.deleteMany({ where: { garageId, userId: null, review: null } }),
        // Tokens de verificación de email
        db.emailVerification.deleteMany({ where: { userId } }),
        // Eliminar el garage (cascada: servicios, horarios, ofertas, slots, etc.)
        db.garage.delete({ where: { id: garageId } }),
        // Eliminar el usuario
        db.user.delete({ where: { id: userId } }),
      ]);
    } else {
      await db.$transaction([
        // Anonimizar bookings del cliente
        db.booking.updateMany({ where: { userId }, data: { userId: null } }),
        // Eliminar reviews del cliente
        db.review.deleteMany({ where: { userId } }),
        // Eliminar vehículos
        db.vehicle.deleteMany({ where: { userId } }),
        // Tokens de verificación
        db.emailVerification.deleteMany({ where: { userId } }),
        // Eliminar el usuario
        db.user.delete({ where: { id: userId } }),
      ]);
    }
  } catch {
    return NextResponse.json({ error: "Error al eliminar la cuenta" }, { status: 500 });
  }

  // Emails post-eliminación (fire-and-forget, la cuenta ya no existe)
  const userName  = user.name  ?? "Usuario";
  const userEmail = user.email ?? "";

  const confirmacion = cuentaEliminadaEmail(userName, role);
  void sendMail({ to: userEmail, subject: confirmacion.subject, html: confirmacion.html });

  const interno = bajaUsuarioInternoEmail(userName, userEmail, role);
  void sendMail({ to: "hola@gartify.es", subject: interno.subject, html: interno.html });

  return NextResponse.json({ ok: true });
}
