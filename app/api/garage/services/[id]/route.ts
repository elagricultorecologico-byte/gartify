import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { z } from "zod";

const patchSchema = z.object({
  price:    z.number().positive().optional(),
  name:     z.string().min(1).optional(),
  duration: z.number().int().positive().optional(),
  isActive: z.boolean().optional(),
});

export async function PATCH(
  req: Request,
  { params }: { params: { id: string } },
) {
  const session = await auth();
  if (!session?.user) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const body = await req.json() as unknown;
  const parsed = patchSchema.safeParse(body);
  if (!parsed.success) return NextResponse.json({ error: "Datos inválidos" }, { status: 400 });

  // Verificar propiedad del servicio
  const service = await db.garageService.findUnique({
    where: { id: params.id },
    select: { garage: { select: { ownerId: true } } },
  });
  if (!service || service.garage.ownerId !== session.user.id) {
    return NextResponse.json({ error: "No autorizado" }, { status: 403 });
  }

  const updated = await db.garageService.update({
    where: { id: params.id },
    data: parsed.data,
  });

  return NextResponse.json(updated);
}

export async function DELETE(
  _req: Request,
  { params }: { params: { id: string } },
) {
  const session = await auth();
  if (!session?.user) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const service = await db.garageService.findUnique({
    where: { id: params.id },
    select: { garage: { select: { ownerId: true } } },
  });
  if (!service || service.garage.ownerId !== session.user.id) {
    return NextResponse.json({ error: "No autorizado" }, { status: 403 });
  }

  await db.garageService.delete({ where: { id: params.id } });
  return NextResponse.json({ ok: true });
}
