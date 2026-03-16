import { NextResponse } from "next/server";
import { z } from "zod";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

const schema = z.object({
  name:    z.string().min(2),
  email:   z.string().email(),
  phone:   z.string().optional(),
  website: z.string().url().optional().or(z.literal("")),
  logoUrl: z.string().url().optional().or(z.literal("")),
});

// GET /api/admin/distributor — list all distributors
export async function GET() {
  const session = await auth();
  const user = session?.user as { role?: string } | undefined;
  if (user?.role !== "ADMIN") return NextResponse.json({ error: "Forbidden" }, { status: 403 });

  const distributors = await db.distributor.findMany({
    orderBy: { name: "asc" },
    include: {
      _count: { select: { parts: true, orders: true } },
    },
  });
  return NextResponse.json(distributors);
}

// POST /api/admin/distributor — create distributor
export async function POST(request: Request) {
  const session = await auth();
  const user = session?.user as { role?: string } | undefined;
  if (user?.role !== "ADMIN") return NextResponse.json({ error: "Forbidden" }, { status: 403 });

  const body = await request.json();
  const parsed = schema.safeParse(body);
  if (!parsed.success) return NextResponse.json({ error: parsed.error.issues[0].message }, { status: 400 });

  const existing = await db.distributor.findUnique({ where: { email: parsed.data.email } });
  if (existing) return NextResponse.json({ error: "Ya existe un distribuidor con ese email" }, { status: 409 });

  const distributor = await db.distributor.create({
    data: {
      name:    parsed.data.name,
      email:   parsed.data.email,
      phone:   parsed.data.phone || null,
      website: parsed.data.website || null,
      logoUrl: parsed.data.logoUrl || null,
    },
  });
  return NextResponse.json(distributor, { status: 201 });
}
