import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

export async function GET() {
  const session = await auth();
  if (!session?.user?.id) return NextResponse.json({ services: 0, offers: 0 });

  const user = session.user as { id: string; role?: string };
  if (user.role !== "GARAGE_OWNER") return NextResponse.json({ services: 0, offers: 0 });

  const garage = await db.garage.findUnique({
    where: { ownerId: user.id },
    select: {
      _count: {
        select: {
          services: { where: { isActive: true } },
          offers:   { where: { isActive: true } },
        },
      },
    },
  });

  return NextResponse.json({
    services: garage?._count.services ?? 0,
    offers:   garage?._count.offers ?? 0,
  });
}
