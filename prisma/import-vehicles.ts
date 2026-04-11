/**
 * Script de importación del catálogo de vehículos desde distri-auto.es
 *
 * Uso:
 *   npx tsx prisma/import-vehicles.ts
 *
 * El script es idempotente: puede ejecutarse varias veces sin duplicar datos
 * gracias al uso de `upsert`. Los IDs son los de distri-auto.es para mantener
 * coherencia con los datos del proveedor externo.
 */

import { PrismaClient } from "@prisma/client";

const db = new PrismaClient({ log: ["error"] });

// ─── Tipos ────────────────────────────────────────────────────────────────────

type OpcionSelector = { value: string; label: string; img?: string };

// ─── Constantes ───────────────────────────────────────────────────────────────

const BASE_URL = "https://www.distri-auto.es";

/** Delay entre peticiones para no sobrecargar distri-auto.es */
const DELAY_MS = 200;

/** Headers que imitan una petición de navegador real */
const HEADERS_NAVEGADOR: HeadersInit = {
  "User-Agent":
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36",
  Accept: "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
  "Accept-Language": "es-ES,es;q=0.9",
  Referer: "https://www.distri-auto.es/",
};

// ─── Helpers de scraping ──────────────────────────────────────────────────────

/**
 * Extrae las opciones de un <select> del HTML devuelto por distri-auto.es.
 * Para marcas también extrae el atributo data-img (logo de la marca).
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
      if (value && label && !seen.has(value)) {
        seen.add(value);
        opciones.push({ value, label, img });
      }
    } else {
      const value = match[1].trim();
      const label = match[2].trim();
      if (value && label && !seen.has(value)) {
        seen.add(value);
        opciones.push({ value, label });
      }
    }
  }

  return opciones;
}

/** Pausa la ejecución durante `ms` milisegundos */
function esperar(ms: number): Promise<void> {
  return new Promise((resolve) => setTimeout(resolve, ms));
}

// ─── Funciones de fetch ───────────────────────────────────────────────────────

async function obtenerMarcas(): Promise<OpcionSelector[]> {
  const respuesta = await fetch(`${BASE_URL}/ajax/modal/vehicle?full=1`, {
    headers: HEADERS_NAVEGADOR,
  });
  if (!respuesta.ok) throw new Error(`Error al obtener marcas: HTTP ${respuesta.status}`);
  const html = await respuesta.text();
  return extraerOpciones(html, "search_vehicle_manufacturer", true);
}

async function obtenerModelos(manufacturerId: string): Promise<OpcionSelector[]> {
  const url = `${BASE_URL}/ajax/search/vehicle?search_vehicle[manufacturer]=${manufacturerId}`;
  const respuesta = await fetch(url, { headers: HEADERS_NAVEGADOR });
  if (!respuesta.ok) throw new Error(`Error al obtener modelos de marca ${manufacturerId}: HTTP ${respuesta.status}`);
  const html = await respuesta.text();
  return extraerOpciones(html, "search_vehicle_modelSeries");
}

async function obtenerVersiones(manufacturerId: string, modelId: string): Promise<OpcionSelector[]> {
  const url = `${BASE_URL}/ajax/search/vehicle?search_vehicle[manufacturer]=${manufacturerId}&search_vehicle[modelSeries]=${modelId}`;
  const respuesta = await fetch(url, { headers: HEADERS_NAVEGADOR });
  if (!respuesta.ok) throw new Error(`Error al obtener versiones del modelo ${modelId}: HTTP ${respuesta.status}`);
  const html = await respuesta.text();
  return extraerOpciones(html, "search_vehicle_vehicle");
}

// ─── Lógica principal ─────────────────────────────────────────────────────────

async function importar() {
  console.log("Iniciando importación del catálogo de vehículos desde distri-auto.es...\n");

  // 1. Obtener todas las marcas
  console.log("Obteniendo marcas...");
  const marcas = await obtenerMarcas();
  console.log(`  ${marcas.length} marcas encontradas.\n`);

  let totalModelos = 0;
  let totalVersiones = 0;
  let marcasConError = 0;

  // 2. Para cada marca, obtener modelos y versiones
  for (let i = 0; i < marcas.length; i++) {
    const marca = marcas[i];
    const progresoPct = Math.round(((i + 1) / marcas.length) * 100);
    process.stdout.write(`[${String(i + 1).padStart(3)}/${marcas.length}] (${progresoPct}%) ${marca.label}... `);

    try {
      // Guardar / actualizar la marca en la BD
      // Nota: El ID de distri-auto es un número, lo usamos directamente
      const vehicleMake = await db.vehicleMake.upsert({
        where: { id: parseInt(marca.value, 10) },
        update: { name: marca.label, logoUrl: marca.img ?? null },
        create: { id: parseInt(marca.value, 10), name: marca.label, logoUrl: marca.img ?? null },
      });

      // Obtener modelos de esta marca
      await esperar(DELAY_MS);
      const modelos = await obtenerModelos(marca.value);

      for (const modelo of modelos) {
        // Guardar / actualizar el modelo
        const vehicleModel = await db.vehicleModel.upsert({
          where: { id: parseInt(modelo.value, 10) },
          update: { name: modelo.label, makeId: vehicleMake.id },
          create: { id: parseInt(modelo.value, 10), name: modelo.label, makeId: vehicleMake.id },
        });

        // Obtener versiones de este modelo
        await esperar(DELAY_MS);
        const versiones = await obtenerVersiones(marca.value, modelo.value);

        for (const version of versiones) {
          await db.vehicleVersion.upsert({
            where: { id: parseInt(version.value, 10) },
            update: { name: version.label, modelId: vehicleModel.id },
            create: { id: parseInt(version.value, 10), name: version.label, modelId: vehicleModel.id },
          });
          totalVersiones++;
        }

        totalModelos++;
      }

      console.log(`${modelos.length} modelos OK`);
    } catch (err) {
      marcasConError++;
      console.error(`ERROR - ${err instanceof Error ? err.message : String(err)}`);
    }
  }

  console.log("\n─────────────────────────────────────────");
  console.log("Importación finalizada:");
  console.log(`  Marcas procesadas : ${marcas.length - marcasConError} / ${marcas.length}`);
  console.log(`  Modelos guardados : ${totalModelos}`);
  console.log(`  Versiones guardadas: ${totalVersiones}`);
  if (marcasConError > 0) {
    console.warn(`  Marcas con error  : ${marcasConError} (revisar salida anterior)`);
  }
  console.log("─────────────────────────────────────────\n");
}

// ─── Punto de entrada ─────────────────────────────────────────────────────────

importar()
  .catch((err: unknown) => {
    console.error("Error fatal en la importación:", err);
    process.exit(1);
  })
  .finally(() => {
    void db.$disconnect();
  });
