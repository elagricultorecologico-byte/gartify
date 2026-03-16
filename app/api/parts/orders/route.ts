import { NextResponse } from "next/server";
import { z } from "zod";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

const lineSchema = z.object({
  distributorPartId: z.string(),
  cantidad:          z.number().int().min(1),
});

const orderSchema = z.object({
  distributorId: z.string(),
  lines:         z.array(lineSchema).min(1),
  notes:         z.string().optional(),
});

// GET /api/parts/orders — mis pedidos de recambios (taller)
export async function GET() {
  const session = await auth();
  const user = session?.user as { id?: string; role?: string } | undefined;
  if (!user?.id || user.role !== "GARAGE_OWNER") {
    return NextResponse.json({ error: "Forbidden" }, { status: 403 });
  }

  const garage = await db.garage.findUnique({ where: { ownerId: user.id }, select: { id: true } });
  if (!garage) return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });

  const orders = await db.partOrder.findMany({
    where: { garageId: garage.id },
    include: {
      distributor: { select: { id: true, name: true } },
      lines: {
        include: {
          distributorPart: {
            include: { part: { select: { nombre: true, referenciaOem: true, categoria: true } } },
          },
        },
      },
    },
    orderBy: { createdAt: "desc" },
  });

  return NextResponse.json(orders);
}

// POST /api/parts/orders — crear pedido
export async function POST(request: Request) {
  const session = await auth();
  const user = session?.user as { id?: string; role?: string } | undefined;
  if (!user?.id || user.role !== "GARAGE_OWNER") {
    return NextResponse.json({ error: "Solo los talleres pueden realizar pedidos" }, { status: 403 });
  }

  const garage = await db.garage.findUnique({ where: { ownerId: user.id }, select: { id: true } });
  if (!garage) return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });

  const body = await request.json();
  const parsed = orderSchema.safeParse(body);
  if (!parsed.success) return NextResponse.json({ error: parsed.error.issues[0].message }, { status: 400 });

  const { distributorId, lines, notes } = parsed.data;

  // Verificar que todos los distributorParts pertenecen al distribuidor
  const dpIds = lines.map((l) => l.distributorPartId);
  const dps = await db.distributorPart.findMany({
    where: { id: { in: dpIds }, distributorId },
  });

  if (dps.length !== dpIds.length) {
    return NextResponse.json({ error: "Alguna pieza no pertenece al distribuidor seleccionado" }, { status: 400 });
  }

  const dpMap = new Map(dps.map((dp) => [dp.id, dp]));

  const totalAmount = lines.reduce((sum, line) => {
    const dp = dpMap.get(line.distributorPartId)!;
    return sum + dp.precioCoste * line.cantidad;
  }, 0);

  const order = await db.partOrder.create({
    data: {
      garageId:      garage.id,
      distributorId,
      totalAmount,
      notes:         notes || null,
      lines: {
        create: lines.map((line) => ({
          distributorPartId: line.distributorPartId,
          cantidad:          line.cantidad,
          precioUnitario:    dpMap.get(line.distributorPartId)!.precioCoste,
        })),
      },
    },
    include: {
      distributor: { select: { name: true } },
      lines: { include: { distributorPart: { include: { part: true } } } },
    },
  });

  return NextResponse.json(order, { status: 201 });
}
