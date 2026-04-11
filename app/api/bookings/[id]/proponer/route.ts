import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

export async function PATCH(req: Request, { params }: { params: { id: string } }) {
  const session = await auth();
  if (!session?.user?.id) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const { proposedDate } = await req.json();
  if (!proposedDate) return NextResponse.json({ error: "Falta proposedDate" }, { status: 400 });

  const fecha = new Date(proposedDate);
  if (isNaN(fecha.getTime())) return NextResponse.json({ error: "Fecha no válida" }, { status: 400 });

  const booking = await db.booking.findUnique({
    where: { id: params.id },
    include: {
      garage:  { select: { ownerId: true, name: true, phone: true } },
      service: { select: { name: true, duration: true } },
      user:    { select: { name: true, phone: true, email: true } },
    },
  });

  if (!booking) return NextResponse.json({ error: "Reserva no encontrada" }, { status: 404 });
  if (booking.garage.ownerId !== session.user.id) return NextResponse.json({ error: "Sin permisos" }, { status: 403 });
  if (booking.status !== "PENDING" && booking.status !== "CONFIRMED") {
    return NextResponse.json({ error: "No se puede proponer hora en este estado" }, { status: 400 });
  }

  // ── Comprobar solapamiento ──────────────────────────────────────────────────
  // Buscar reservas activas del mismo taller que se solapen con el nuevo slot
  const duracionMs   = booking.service.duration * 60 * 1000;
  const nuevaInicio  = fecha;
  const nuevaFin     = new Date(fecha.getTime() + duracionMs);

  const solapamiento = await db.booking.findFirst({
    where: {
      id:       { not: params.id },           // excluir la propia reserva
      garageId: booking.garageId,
      status:   { in: ["PENDING", "PROPOSED", "CONFIRMED"] },
      AND: [
        { date: { lt: nuevaFin } },           // otra reserva empieza antes de que esta acabe
        // otra reserva acaba después de que esta empiece
        // date + duration > nuevaInicio  →  date > nuevaInicio - duration
        { date: { gt: new Date(nuevaInicio.getTime() - duracionMs) } },
      ],
    },
  });

  if (solapamiento) {
    return NextResponse.json(
      { error: "Ese horario ya está ocupado por otra reserva activa" },
      { status: 409 }
    );
  }
  // ───────────────────────────────────────────────────────────────────────────

  // Actualizar la fecha de la reserva — estado PROPOSED: pendiente de aceptación del cliente
  const updated = await db.booking.update({
    where: { id: params.id },
    data: { date: fecha, status: "PROPOSED" },
  });

  return NextResponse.json(updated);
}
