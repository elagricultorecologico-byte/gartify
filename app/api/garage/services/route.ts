import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { z } from "zod";

const SERVICE_TYPES = [
  "ITV","PRE_ITV","REVISION","CAMBIO_ACEITE","FRENOS","NEUMATICOS",
  "CLIMATIZACION","DIAGNOSTICO","ELECTRICIDAD","SUSPENSION","ESCAPE",
  "MOTOR","FILTROS","CARROCERIA","LUCES","BATERIA_ELECTRICO",
  "REFRIGERACION","REVISION_PRECOMPRA","OTRO",
] as const;

const schema = z.object({
  garageId:     z.string(),
  type:         z.enum(SERVICE_TYPES),
  name:         z.string().min(1),
  description:  z.string().optional(),
  price:        z.number().min(0),
  duration:     z.number().int().positive(),
  vehicleTypes: z
    .array(z.string())
    .min(1, "Selecciona al menos un tipo de vehículo")
    .default(["COCHE", "MOTO", "FURGONETA", "AUTOCARAVANA", "CAMPER", "CAMION"]),
});

export async function POST(req: Request) {
  const session = await auth();
  if (!session?.user) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const body = await req.json();
  const parsed = schema.safeParse(body);
  if (!parsed.success) return NextResponse.json({ error: "Datos inválidos" }, { status: 400 });

  const { garageId, type, name, description, price, duration, vehicleTypes } = parsed.data;

  // Verificar que el taller pertenece al usuario autenticado
  const garage = await db.garage.findUnique({ where: { id: garageId } });
  if (!garage || garage.ownerId !== session.user.id) {
    return NextResponse.json({ error: "No autorizado" }, { status: 403 });
  }

  const service = await db.garageService.create({
    data: {
      garageId,
      type,
      name,
      description,
      price,
      duration,
      // Persiste como JSON array serializado, igual que Garage.vehicleTypes
      vehicleTypes: JSON.stringify(vehicleTypes),
    },
  });

  return NextResponse.json(service, { status: 201 });
}
