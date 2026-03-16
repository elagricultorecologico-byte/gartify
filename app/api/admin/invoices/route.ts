import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

// POST /api/admin/invoices — genera facturas para un mes dado (YYYY-MM)
export async function POST(req: Request) {
  const session = await auth();
  const user = session?.user as { id?: string; role?: string } | undefined;
  if (!user?.id || user.role !== "ADMIN") {
    return NextResponse.json({ error: "Sin permisos" }, { status: 403 });
  }

  const { month, feeRate = 0.10 } = await req.json() as { month: string; feeRate?: number };

  if (!/^\d{4}-\d{2}$/.test(month)) {
    return NextResponse.json({ error: "Formato de mes inválido (YYYY-MM)" }, { status: 400 });
  }

  const [year, mon] = month.split("-").map(Number);
  const from = new Date(year, mon - 1, 1);
  const to   = new Date(year, mon,     1);

  // Obtener todos los garages activos
  const garages = await db.garage.findMany({
    where: { isActive: true },
    select: { id: true },
  });

  // Para cada garage calcular revenue del mes y upsert la factura
  const results = await Promise.all(
    garages.map(async (g) => {
      const agg = await db.booking.aggregate({
        where: {
          garageId: g.id,
          status: "COMPLETED",
          date: { gte: from, lt: to },
        },
        _sum: { totalPrice: true },
      });

      const revenue   = agg._sum.totalPrice ?? 0;
      const feeAmount = parseFloat((revenue * feeRate).toFixed(2));

      return db.adminInvoice.upsert({
        where:  { garageId_month: { garageId: g.id, month } },
        create: { garageId: g.id, month, revenue, feeRate, feeAmount, status: "PENDING" },
        update: { revenue, feeRate, feeAmount },
      });
    })
  );

  return NextResponse.json({ generated: results.length });
}
