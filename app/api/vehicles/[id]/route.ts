import { NextResponse } from "next/server";
import { z } from "zod";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

// ─── Schema parcial para actualización ───────────────────────────────────────

const EsquemaVehiculoParcial = z.object({
  alias:   z.string().max(30).nullable().optional(),
  plate:   z.string().min(1).max(20).optional(),
  brand:   z.string().min(1).max(50).optional(),
  model:   z.string().min(1).max(50).optional(),
  year:    z
    .number()
    .int()
    .min(1960)
    .max(new Date().getFullYear() + 1)
    .nullable()
    .optional(),
  color:   z.string().max(30).nullable().optional(),
  fuel:    z
    .enum(["Gasolina", "Diésel", "Híbrido", "Eléctrico", "GLP"])
    .nullable()
    .optional(),
  mileage:     z.number().int().min(0).nullable().optional(),
  itvDate:     z.string().datetime().nullable().optional(),
  itvReminder: z.boolean().optional(),
});

interface Params {
  params: Promise<{ id: string }>;
}

// ─── PATCH /api/vehicles/[id] ─────────────────────────────────────────────────
// Actualiza un vehículo verificando que pertenece al usuario autenticado

export async function PATCH(request: Request, { params }: Params) {
  const sesion = await auth();
  if (!sesion?.user?.id) {
    return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  }

  const usuario = sesion.user as { id: string; role?: string };
  const { id } = await params;

  // Verificar propiedad del vehículo
  const vehiculoExistente = await db.vehicle.findUnique({
    where: { id },
    select: { userId: true },
  });

  if (!vehiculoExistente) {
    return NextResponse.json({ error: "Vehículo no encontrado" }, { status: 404 });
  }

  if (vehiculoExistente.userId !== usuario.id) {
    return NextResponse.json(
      { error: "No tienes permiso para modificar este vehículo" },
      { status: 403 }
    );
  }

  const resultado = EsquemaVehiculoParcial.safeParse(await request.json());
  if (!resultado.success) {
    return NextResponse.json(
      { error: "Datos inválidos", detalles: resultado.error.flatten() },
      { status: 400 }
    );
  }

  const { alias, plate, brand, model, year, color, fuel, mileage, itvDate, itvReminder } = resultado.data;

  try {
    const vehiculoActualizado = await db.vehicle.update({
      where: { id },
      data: {
        ...(alias   !== undefined ? { alias: alias?.trim() || null } : {}),
        ...(plate   !== undefined ? { plate: plate.toUpperCase().trim() } : {}),
        ...(brand   !== undefined ? { brand: brand?.trim() }  : {}),
        ...(model   !== undefined ? { model: model?.trim() }  : {}),
        ...(year    !== undefined ? { year }    : {}),
        ...(color   !== undefined ? { color }   : {}),
        ...(fuel    !== undefined ? { fuel }    : {}),
        ...(mileage !== undefined ? { mileage } : {}),
        ...(itvDate     !== undefined
          ? { itvDate: itvDate ? new Date(itvDate) : null }
          : {}),
        ...(itvReminder !== undefined ? { itvReminder } : {}),
      },
    });

    return NextResponse.json(vehiculoActualizado);
  } catch {
    return NextResponse.json(
      { error: "Error al actualizar el vehículo" },
      { status: 500 }
    );
  }
}

// ─── DELETE /api/vehicles/[id] ────────────────────────────────────────────────
// Elimina un vehículo verificando que pertenece al usuario autenticado

export async function DELETE(_request: Request, { params }: Params) {
  const sesion = await auth();
  if (!sesion?.user?.id) {
    return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  }

  const usuario = sesion.user as { id: string };
  const { id } = await params;

  // Verificar propiedad antes de eliminar
  const vehiculo = await db.vehicle.findUnique({
    where: { id },
    select: { userId: true },
  });

  if (!vehiculo) {
    return NextResponse.json({ error: "Vehículo no encontrado" }, { status: 404 });
  }

  if (vehiculo.userId !== usuario.id) {
    return NextResponse.json(
      { error: "No tienes permiso para eliminar este vehículo" },
      { status: 403 }
    );
  }

  try {
    await db.vehicle.delete({ where: { id } });
    return NextResponse.json({ mensaje: "Vehículo eliminado correctamente" });
  } catch {
    return NextResponse.json(
      { error: "Error al eliminar el vehículo" },
      { status: 500 }
    );
  }
}
