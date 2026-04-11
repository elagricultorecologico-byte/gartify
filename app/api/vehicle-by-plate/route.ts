import { NextResponse } from "next/server";

export const dynamic = "force-dynamic";

export async function GET(request: Request): Promise<NextResponse> {
  const { searchParams } = new URL(request.url);
  const plate = searchParams.get("plate")?.trim().toUpperCase().replace(/\s+/g, "");

  if (!plate) {
    return NextResponse.json({ error: "Matrícula requerida" }, { status: 400 });
  }

  const apiKey = process.env.RAPIDAPI_MATRICULAS_KEY;
  if (!apiKey) {
    return NextResponse.json({ error: "API no configurada" }, { status: 500 });
  }

  try {
    const res = await fetch(
      `https://api-matriculas-espana.p.rapidapi.com/es?plate=${plate}`,
      {
        headers: {
          "x-rapidapi-key": apiKey,
          "x-rapidapi-host": "api-matriculas-espana.p.rapidapi.com",
        },
      }
    );

    if (res.status === 404) {
      return NextResponse.json({ error: "Matrícula no encontrada" }, { status: 404 });
    }
    if (!res.ok) {
      return NextResponse.json({ error: "Error al consultar la matrícula" }, { status: 502 });
    }

    const data = await res.json() as {
      MARCA?: string;
      MODELO?: string;
      TPMOTOR?: string;
      MATRICULA?: string;
    };

    return NextResponse.json({
      marca:     data.MARCA    ?? "",
      modelo:    data.MODELO   ?? "",
      motor:     data.TPMOTOR  ?? "",
      matricula: data.MATRICULA ?? plate,
    });
  } catch {
    return NextResponse.json({ error: "Error de conexión con la API" }, { status: 502 });
  }
}
