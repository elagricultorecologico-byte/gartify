import { NextResponse } from "next/server";

// Tiempo de revalidación para el caché de marcas (1 hora)
export const revalidate = 3600;

// Headers necesarios para imitar una petición de navegador real
const HEADERS_NAVEGADOR: HeadersInit = {
  "User-Agent":
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36",
  Accept: "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
  "Accept-Language": "es-ES,es;q=0.9",
  Referer: "https://www.distri-auto.es/",
};

const BASE_URL = "https://www.distri-auto.es";

type OpcionSelector = { value: string; label: string; img?: string };

/**
 * Extrae las opciones de un <select> del HTML devuelto por distri-auto.es.
 * Para manufacturers también extrae el atributo data-img (logo de la marca).
 */
function extraerOpciones(html: string, idSelect: string, conImg = false): OpcionSelector[] {
  const regexSelect = new RegExp(
    `<select[^>]*id="${idSelect}"[^>]*>([\\s\\S]*?)<\\/select>`,
    "i"
  );
  const matchSelect = regexSelect.exec(html);
  if (!matchSelect) return [];

  const contenidoSelect = matchSelect[1];

  const regexOpcion = conImg
    ? /<option value="(\d+)"[^>]*data-img="([^"]*)"[^>]*>([^<]+)<\/option>/g
    : /<option value="(\d+)"[^>]*>([^<]+)<\/option>/g;

  const opciones: OpcionSelector[] = [];
  let match: RegExpExecArray | null;

  const seen = new Set<string>();
  while ((match = regexOpcion.exec(contenidoSelect)) !== null) {
    if (conImg) {
      const value = match[1].trim();
      const img   = match[2].trim();
      const label = match[3].trim();
      if (value && label && !seen.has(value)) { seen.add(value); opciones.push({ value, label, img }); }
    } else {
      const value = match[1].trim();
      const label = match[2].trim();
      if (value && label && !seen.has(value)) { seen.add(value); opciones.push({ value, label }); }
    }
  }

  return opciones;
}

export async function GET(request: Request): Promise<NextResponse> {
  const { searchParams } = new URL(request.url);
  const step = searchParams.get("step");

  try {
    if (step === "manufacturers") {
      // Las marcas vienen del modal de búsqueda completo de distri-auto
      const respuesta = await fetch(`${BASE_URL}/ajax/modal/vehicle?full=1`, {
        headers: HEADERS_NAVEGADOR,
        // Siguiente.js respeta este campo para el cache de Data Cache
        next: { revalidate: 3600 },
      });

      if (!respuesta.ok) {
        return NextResponse.json(
          { error: "Error al obtener marcas del proveedor externo" },
          { status: 502 }
        );
      }

      const html = await respuesta.text();
      const opciones = extraerOpciones(html, "search_vehicle_manufacturer", true);

      return NextResponse.json({ options: opciones });
    }

    if (step === "models") {
      const manufacturerId = searchParams.get("manufacturerId");
      if (!manufacturerId || !/^\d+$/.test(manufacturerId)) {
        return NextResponse.json(
          { error: "Parámetro manufacturerId inválido o ausente" },
          { status: 400 }
        );
      }

      const url = `${BASE_URL}/ajax/search/vehicle?search_vehicle[manufacturer]=${manufacturerId}`;
      const respuesta = await fetch(url, {
        headers: HEADERS_NAVEGADOR,
        // Sin caché: los modelos pueden cambiar con frecuencia
        cache: "no-store",
      });

      if (!respuesta.ok) {
        return NextResponse.json(
          { error: "Error al obtener modelos del proveedor externo" },
          { status: 502 }
        );
      }

      const html = await respuesta.text();
      const opciones = extraerOpciones(html, "search_vehicle_modelSeries");

      return NextResponse.json({ options: opciones });
    }

    if (step === "vehicles") {
      const manufacturerId = searchParams.get("manufacturerId");
      const modelId = searchParams.get("modelId");

      if (!manufacturerId || !/^\d+$/.test(manufacturerId)) {
        return NextResponse.json(
          { error: "Parámetro manufacturerId inválido o ausente" },
          { status: 400 }
        );
      }
      if (!modelId || !/^\d+$/.test(modelId)) {
        return NextResponse.json(
          { error: "Parámetro modelId inválido o ausente" },
          { status: 400 }
        );
      }

      const url = `${BASE_URL}/ajax/search/vehicle?search_vehicle[manufacturer]=${manufacturerId}&search_vehicle[modelSeries]=${modelId}`;
      const respuesta = await fetch(url, {
        headers: HEADERS_NAVEGADOR,
        cache: "no-store",
      });

      if (!respuesta.ok) {
        return NextResponse.json(
          { error: "Error al obtener vehículos del proveedor externo" },
          { status: 502 }
        );
      }

      const html = await respuesta.text();
      const opciones = extraerOpciones(html, "search_vehicle_vehicle");

      return NextResponse.json({ options: opciones });
    }

    return NextResponse.json(
      { error: "Parámetro step inválido. Valores permitidos: manufacturers, models, vehicles" },
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
