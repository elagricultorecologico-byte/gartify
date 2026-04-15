import { NextResponse } from "next/server";
import { z } from "zod";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

const schema = z.object({
  name:  z.string().min(2).max(100),
  phone: z.string().max(20).optional(),
});

export async function PATCH(req: Request) {
  const session = await auth();
  if (!session?.user?.id) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const body = await req.json() as unknown;
  const parsed = schema.safeParse(body);
  if (!parsed.success) return NextResponse.json({ error: "Datos inválidos" }, { status: 400 });

  const { name, phone } = parsed.data;

  await db.user.update({
    where: { id: session.user.id },
    data: { name, phone: phone ?? null },
  });

  return NextResponse.json({ ok: true });
}
