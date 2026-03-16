import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

// GET /api/parts/search?q=&categoria=&marca=&vehiculo=
export async function GET(request: Request) {
  const session = await auth();
  const user = session?.user as { role?: string } | undefined;
  if (user?.role !== "GARAGE_OWNER") {
    return NextResponse.json({ error: "Solo los talleres pueden buscar recambios" }, { status: 403 });
  }

  const { searchParams } = new URL(request.url);
  const q         = searchParams.get("q")?.trim() ?? "";
  const categoria = searchParams.get("categoria")?.trim().toUpperCase() ?? "";
  const marca     = searchParams.get("marca")?.trim() ?? "";
  const vehiculo  = searchParams.get("vehiculo")?.trim() ?? "";

  if (q.length < 2 && !categoria) {
    return NextResponse.json([]);
  }

  const parts = await db.part.findMany({
    where: {
      AND: [
        q ? {
          OR: [
            { referenciaOem:   { contains: q } },
            { nombre:          { contains: q } },
            { marcaFabricante: { contains: q } },
            { ean:             { contains: q } },
          ],
        } : {},
        categoria ? { categoria } : {},
        marca     ? { marcaFabricante: { contains: marca } } : {},
        vehiculo  ? {
          OR: [
            { marcaVehiculo:  { contains: vehiculo } },
            { modeloVehiculo: { contains: vehiculo } },
          ],
        } : {},
      ],
    },
    include: {
      distributorParts: {
        where: { distributor: { isActive: true }, stock: { gt: 0 } },
        include: { distributor: { select: { id: true, name: true, logoUrl: true } } },
        orderBy: { precioCoste: "asc" },
      },
    },
    take: 50,
  });

  // Solo devolver partes que tienen al menos un distribuidor con stock
  return NextResponse.json(parts.filter((p) => p.distributorParts.length > 0));
}
