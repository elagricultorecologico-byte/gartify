import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { z } from "zod";

const VALID_STATUSES = ["PENDING", "CONFIRMED", "SHIPPED", "DELIVERED", "CANCELLED"] as const;

const bodySchema = z.object({
  status: z.enum(VALID_STATUSES),
});

export async function PATCH(
  req: Request,
  { params }: { params: { id: string } }
) {
  const session = await auth();
  const user = session?.user as { role?: string } | undefined;
  if (user?.role !== "ADMIN") return NextResponse.json({ error: "No autorizado" }, { status: 403 });

  const parsed = bodySchema.safeParse(await req.json());
  if (!parsed.success) return NextResponse.json({ error: "Estado inválido" }, { status: 400 });

  const order = await db.partOrder.findUnique({ where: { id: params.id } });
  if (!order) return NextResponse.json({ error: "Pedido no encontrado" }, { status: 404 });

  const updated = await db.partOrder.update({
    where: { id: params.id },
    data: { status: parsed.data.status },
  });

  return NextResponse.json(updated);
}
