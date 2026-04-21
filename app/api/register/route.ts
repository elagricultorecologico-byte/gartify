import { NextResponse } from "next/server";
import bcrypt from "bcryptjs";
import { z } from "zod";
import { db } from "@/lib/db";
import { sendMail } from "@/lib/mailer";
import { welcomeCustomerEmail } from "@/lib/emails/templates";

const schema = z.object({
  name:          z.string().min(2),
  email:         z.string().email(),
  password:      z.string().min(6),
  phone:         z.string().optional(),
  whatsappOptIn: z.boolean().optional(),
});

export async function POST(req: Request) {
  try {
    const body = await req.json();
    const { name, email, password, phone, whatsappOptIn } = schema.parse(body);

    const exists = await db.user.findUnique({ where: { email } });
    if (exists) return NextResponse.json({ error: "Ya existe una cuenta con ese email" }, { status: 400 });

    const hashed = await bcrypt.hash(password, 10);
    await db.user.create({ data: { name, email, password: hashed, phone, whatsappOptIn: whatsappOptIn ?? false, role: "CUSTOMER" } });

    const { subject, html } = welcomeCustomerEmail(name);
    void sendMail({ to: email, subject, html });

    return NextResponse.json({ ok: true });
  } catch {
    return NextResponse.json({ error: "Error al crear la cuenta" }, { status: 500 });
  }
}
