import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { z } from "zod";

const TIPOS_VEHICULO_VALIDOS = [
  "COCHE", "MOTO", "FURGONETA", "AUTOCARAVANA", "CAMPER", "CAMION",
] as const;

const schema = z.object({
  name:        z.string().min(1),
  description: z.string().optional(),
  address:     z.string().min(1),
  city:        z.string().min(1),
  postalCode:  z.string().min(5).max(5),
  phone:       z.string().min(1),
  email:       z.string().email().optional().or(z.literal("")),
  courtesyCar:   z.boolean().optional(),
  pickupService: z.boolean().optional(),
  // Array de tipos de vehículo aceptados por el taller
  vehicleTypes: z
    .array(z.enum(TIPOS_VEHICULO_VALIDOS))
    .min(1, "Debe seleccionar al menos un tipo de vehículo")
    .optional(),
});

export async function PATCH(req: Request) {
  const session = await auth();
  if (!session?.user) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const garage = await db.garage.findUnique({ where: { ownerId: session.user.id } });
  if (!garage) return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });

  const body = await req.json();
  const parsed = schema.safeParse(body);
  if (!parsed.success) return NextResponse.json({ error: "Datos inválidos" }, { status: 400 });

  // Extraemos vehicleTypes del resto para serializar como JSON string en SQLite
  const { vehicleTypes, ...restoData } = parsed.data;

  const updated = await db.garage.update({
    where: { id: garage.id },
    data: {
      ...restoData,
      email: parsed.data.email || undefined,
      // Solo actualizamos vehicleTypes si viene en el body; mínimo ["COCHE"]
      ...(vehicleTypes !== undefined && {
        vehicleTypes: JSON.stringify(vehicleTypes),
      }),
    },
  });

  return NextResponse.json(updated);
}
