import { NextResponse } from "next/server";
import bcrypt from "bcryptjs";
import { z } from "zod";
import { db } from "@/lib/db";

const schema = z.object({
  name:     z.string().min(2),
  email:    z.string().email(),
  password: z.string().min(6),
  phone:    z.string().optional(),
});

export async function POST(req: Request) {
  try {
    const body = await req.json();
    const { name, email, password, phone } = schema.parse(body);

    const exists = await db.user.findUnique({ where: { email } });
    if (exists) return NextResponse.json({ error: "Ya existe una cuenta con ese email" }, { status: 400 });

    const hashed = await bcrypt.hash(password, 10);
    await db.user.create({ data: { name, email, password: hashed, phone, role: "CUSTOMER" } });

    return NextResponse.json({ ok: true });
  } catch {
    return NextResponse.json({ error: "Error al crear la cuenta" }, { status: 500 });
  }
}
