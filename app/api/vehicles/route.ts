import { NextResponse } from "next/server";
import { z } from "zod";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

// ─── Schema de validación ─────────────────────────────────────────────────────

const EsquemaVehiculo = z.object({
  alias:   z.string().max(30).optional(),
  plate:   z.string().min(1, "La matrícula es obligatoria").max(20),
  brand:   z.string().min(1, "La marca es obligatoria").max(50),
  model:   z.string().min(1, "El modelo es obligatorio").max(50),
  year:    z
    .number()
    .int()
    .min(1960, "El año no puede ser anterior a 1960")
    .max(new Date().getFullYear() + 1, "El año no puede ser futuro")
    .optional(),
  color:   z.string().max(30).optional(),
  fuel:    z.enum(["Gasolina", "Diésel", "Híbrido", "Eléctrico", "GLP"]).optional(),
  mileage: z.number().int().min(0, "El kilometraje no puede ser negativo").optional(),
  itvDate: z.string().datetime().optional(),
});

// ─── GET /api/vehicles ────────────────────────────────────────────────────────
// Devuelve todos los vehículos del usuario autenticado

export async function GET() {
  const sesion = await auth();
  if (!sesion?.user?.id) {
    return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  }

  const usuario = sesion.user as { id: string; role?: string };

  // Solo los clientes tienen vehículos registrados
  if (usuario.role !== "CUSTOMER") {
    return NextResponse.json({ error: "Acceso no permitido" }, { status: 403 });
  }

  try {
    const vehiculos = await db.vehicle.findMany({
      where: { userId: usuario.id },
      orderBy: { createdAt: "desc" },
    });

    return NextResponse.json(vehiculos);
  } catch {
    return NextResponse.json(
      { error: "Error al obtener los vehículos" },
      { status: 500 }
    );
  }
}

// ─── POST /api/vehicles ───────────────────────────────────────────────────────
// Crea un nuevo vehículo para el usuario autenticado

export async function POST(request: Request) {
  const sesion = await auth();
  if (!sesion?.user?.id) {
    return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  }

  const usuario = sesion.user as { id: string; role?: string };

  if (usuario.role !== "CUSTOMER") {
    return NextResponse.json({ error: "Acceso no permitido" }, { status: 403 });
  }

  const resultado = EsquemaVehiculo.safeParse(await request.json());
  if (!resultado.success) {
    return NextResponse.json(
      { error: "Datos inválidos", detalles: resultado.error.flatten() },
      { status: 400 }
    );
  }

  const { alias, plate, brand, model, year, color, fuel, mileage, itvDate } = resultado.data;

  try {
    const vehiculo = await db.vehicle.create({
      data: {
        userId:  usuario.id,
        alias:   alias?.trim() || null,
        plate:   plate.toUpperCase().trim(),
        brand:   brand.trim(),
        model:   model.trim(),
        year,
        color,
        fuel,
        mileage,
        itvDate: itvDate ? new Date(itvDate) : undefined,
      },
    });

    return NextResponse.json(vehiculo, { status: 201 });
  } catch {
    return NextResponse.json(
      { error: "Error al crear el vehículo" },
      { status: 500 }
    );
  }
}
