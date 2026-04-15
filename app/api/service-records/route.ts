import { NextResponse } from "next/server";
import { z } from "zod";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

// ─── Schema de validación ────────────────────────────────────────────────────

const EsquemaSello = z.object({
  bookingId:      z.string().min(1, "El ID de reserva es obligatorio"),
  mileage:        z.number().int().min(0).optional(),
  workDone:       z.string().min(1, "El trabajo realizado es obligatorio").max(500),
  nextReviewDate: z.string().datetime().optional(),
  nextMileage:    z.number().int().min(0).optional(),
  stampedBy:      z.string().max(100).optional(),
});

// ─── Tipos locales para las queries que usan campos pendientes de migración ──
// Estos tipos son necesarios mientras el cliente Prisma no incluye ServiceRecord.
// Una vez ejecutado `npx prisma db push && npm run db:generate` se pueden
// reemplazar por inferencia directa de Prisma.

interface ReservaConSello {
  id:           string;
  garageId:     string;
  status:       string;
  date:         Date;
  totalPrice:   number;
  vehicleId:    string | null;
  vehiclePlate: string | null;
  vehicleModel: string | null;
  serviceRecord: { id: string } | null;
}

interface RegistroSello {
  id:             string;
  bookingId:      string;
  garageId:       string;
  vehiclePlate:   string | null;
  vehicleModel:   string | null;
  date:           Date;
  mileage:        number | null;
  workDone:       string;
  nextReviewDate: Date | null;
  nextMileage:    number | null;
  stampedBy:      string | null;
  createdAt:      Date;
}

// ─── POST /api/service-records ───────────────────────────────────────────────

export async function POST(request: Request) {
  // 1. Verificar sesión y rol
  const sesion = await auth();
  if (!sesion?.user?.id) {
    return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  }

  const usuario = sesion.user as { id: string; role?: string };
  if (usuario.role !== "GARAGE_OWNER") {
    return NextResponse.json(
      { error: "Solo los propietarios de taller pueden emitir sellos" },
      { status: 403 }
    );
  }

  // 2. Validar cuerpo de la petición
  const cuerpo = await request.json().catch(() => null);
  const resultado = EsquemaSello.safeParse(cuerpo);
  if (!resultado.success) {
    return NextResponse.json(
      { error: "Datos inválidos", detalles: resultado.error.flatten() },
      { status: 400 }
    );
  }

  const { bookingId, mileage, workDone, nextReviewDate, nextMileage, stampedBy } =
    resultado.data;

  // 3. Obtener el garage del usuario autenticado
  const garage = await db.garage.findUnique({
    where: { ownerId: usuario.id },
    select: { id: true },
  });

  if (!garage) {
    return NextResponse.json(
      { error: "No se encontró el taller asociado a este usuario" },
      { status: 404 }
    );
  }

  // 4. Verificar que la reserva pertenece al taller y está completada.
  // Usamos cast a unknown → tipo propio para manejar el campo serviceRecord,
  // que aún no está en el cliente Prisma generado.
  const findBookingUnique = db.booking.findUnique as (
    args: unknown
  ) => Promise<ReservaConSello | null>;

  const reserva = await findBookingUnique({
    where: { id: bookingId },
    select: {
      id:            true,
      garageId:      true,
      status:        true,
      date:          true,
      totalPrice:    true,
      vehicleId:     true,
      vehiclePlate:  true,
      vehicleModel:  true,
      serviceRecord: { select: { id: true } },
    },
  });

  if (!reserva) {
    return NextResponse.json({ error: "Reserva no encontrada" }, { status: 404 });
  }

  if (reserva.garageId !== garage.id) {
    return NextResponse.json(
      { error: "No tienes permiso para sellar esta reserva" },
      { status: 403 }
    );
  }

  if (reserva.status !== "COMPLETED") {
    return NextResponse.json(
      { error: "Solo se pueden sellar reservas completadas" },
      { status: 422 }
    );
  }

  // 5. Verificar que la reserva no tiene ya un sello
  if (reserva.serviceRecord) {
    return NextResponse.json(
      { error: "Esta reserva ya tiene un sello de revisión" },
      { status: 409 }
    );
  }

  // 6. Crear el ServiceRecord con datos de la reserva desnormalizados.
  // Mismo patrón de cast: accedemos a serviceRecord.create a través de unknown
  // porque el modelo aún no está en el cliente generado.
  const createSello = (db as unknown as {
    serviceRecord: {
      create: (args: unknown) => Promise<RegistroSello>;
    };
  }).serviceRecord.create;

  try {
    const sello = await createSello({
      data: {
        bookingId,
        garageId:       garage.id,
        vehicleId:      reserva.vehicleId ?? undefined,
        vehiclePlate:   reserva.vehiclePlate,
        vehicleModel:   reserva.vehicleModel,
        date:           reserva.date,
        mileage:        mileage ?? null,
        workDone,
        nextReviewDate: nextReviewDate ? new Date(nextReviewDate) : null,
        nextMileage:    nextMileage ?? null,
        price:          reserva.totalPrice,
        stampedBy:      stampedBy ?? null,
      },
      select: {
        id:             true,
        bookingId:      true,
        garageId:       true,
        vehiclePlate:   true,
        vehicleModel:   true,
        date:           true,
        mileage:        true,
        workDone:       true,
        nextReviewDate: true,
        nextMileage:    true,
        stampedBy:      true,
        createdAt:      true,
      },
    });

    return NextResponse.json({ sello }, { status: 201 });
  } catch {
    return NextResponse.json(
      { error: "Error interno al crear el sello de revisión" },
      { status: 500 }
    );
  }
}
