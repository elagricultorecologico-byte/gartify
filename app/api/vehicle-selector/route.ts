import { NextResponse } from "next/server";
import { db } from "@/lib/db";

// Sin revalidación: los datos vienen de nuestra propia BD, siempre frescos
export const dynamic = "force-dynamic";

export async function GET(request: Request): Promise<NextResponse> {
  const { searchParams } = new URL(request.url);
  const step = searchParams.get("step");

  try {
    // ── Marcas ────────────────────────────────────────────────────────────────
    if (step === "manufacturers") {
      const marcas = await db.vehicleMake.findMany({
        orderBy: { name: "asc" },
        select: { id: true, name: true, logoUrl: true },
      });

      // Mantener compatibilidad con el formato que espera VehicleModelSelector:
      // { value: string, label: string, img?: string }
      const opciones = marcas.map((m) => ({
        value: String(m.id),
        label: m.name,
        img: m.logoUrl ?? undefined,
      }));

      return NextResponse.json({ options: opciones });
    }

    // ── Modelos ───────────────────────────────────────────────────────────────
    if (step === "models") {
      const makeIdParam = searchParams.get("makeId");

      if (!makeIdParam || !/^\d+$/.test(makeIdParam)) {
        return NextResponse.json(
          { error: "Parámetro makeId inválido o ausente" },
          { status: 400 }
        );
      }

      const makeId = parseInt(makeIdParam, 10);

      const modelos = await db.vehicleModel.findMany({
        where: { makeId },
        orderBy: { name: "asc" },
        select: { id: true, name: true },
      });

      const opciones = modelos.map((m) => ({
        value: String(m.id),
        label: m.name,
      }));

      return NextResponse.json({ options: opciones });
    }

    // ── Versiones ─────────────────────────────────────────────────────────────
    if (step === "versions") {
      const modelIdParam = searchParams.get("modelId");

      if (!modelIdParam || !/^\d+$/.test(modelIdParam)) {
        return NextResponse.json(
          { error: "Parámetro modelId inválido o ausente" },
          { status: 400 }
        );
      }

      const modelId = parseInt(modelIdParam, 10);

      const versiones = await db.vehicleVersion.findMany({
        where: { modelId },
        orderBy: { name: "asc" },
        select: { id: true, name: true },
      });

      const opciones = versiones.map((v) => ({
        value: String(v.id),
        label: v.name,
      }));

      return NextResponse.json({ options: opciones });
    }

    return NextResponse.json(
      { error: "Parámetro step inválido. Valores permitidos: manufacturers, models, versions" },
      { status: 400 }
    );
  } catch (err) {
    console.error("[vehicle-selector] Error inesperado:", err);
    return NextResponse.json(
      { error: "Error interno del servidor al consultar el selector de vehículos" },
      { status: 500 }
    );
  }
}
