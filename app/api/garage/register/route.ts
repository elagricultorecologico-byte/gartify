import { NextResponse } from "next/server";
import bcrypt from "bcryptjs";
import { z } from "zod";
import { db } from "@/lib/db";
import { sendMail } from "@/lib/mailer";
import { welcomeGarageEmail } from "@/lib/emails/templates";

const schema = z.object({
  ownerName:   z.string().min(2),
  email:       z.string().email(),
  password:    z.string().min(6),
  phone:       z.string().min(9),
  garageName:  z.string().min(3),
  address:     z.string().min(5),
  city:        z.string().min(2),
  postalCode:  z.string().length(5),
  description: z.string().optional(),
});

export async function POST(req: Request) {
  try {
    const body = await req.json();
    const data = schema.parse(body);

    const exists = await db.user.findUnique({ where: { email: data.email } });
    if (exists) return NextResponse.json({ error: "Ya existe una cuenta con ese email" }, { status: 400 });

    const hashed = await bcrypt.hash(data.password, 10);

    await db.user.create({
      data: {
        name:     data.ownerName,
        email:    data.email,
        password: hashed,
        phone:    data.phone,
        role:     "GARAGE_OWNER",
        garage: {
          create: {
            name:        data.garageName,
            description: data.description,
            address:     data.address,
            city:        data.city,
            postalCode:  data.postalCode,
            phone:       data.phone,
            email:       data.email,
          },
        },
      },
    });

    const { subject, html } = welcomeGarageEmail(data.ownerName, data.garageName);
    void sendMail({ to: data.email, subject, html });

    return NextResponse.json({ ok: true });
  } catch {
    return NextResponse.json({ error: "Error al registrar el taller" }, { status: 500 });
  }
}
