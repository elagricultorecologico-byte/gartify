/**
 * Descarga los logos de marcas desde cdn.distriauto.eu
 * y actualiza las URLs en la BD para servirlos localmente.
 *
 * Patrón CDN: {id[:-1]}/{id[-1]}_100.webp  (para IDs de 1 dígito: {id}_100.webp)
 *
 * Uso:
 *   npx tsx prisma/download-make-logos.ts
 */

import { PrismaClient } from "@prisma/client";
import { writeFileSync, mkdirSync } from "fs";
import { join } from "path";

const db = new PrismaClient({ log: ["error"] });

const DEST_DIR    = join(process.cwd(), "public", "images", "makes");
const PUBLIC_PATH = "/images/makes";
const CDN_BASE    = "https://cdn.distriauto.eu/assets/img/vehicle/manufacturer";
const DELAY_MS    = 150;

const HEADERS: HeadersInit = {
  "User-Agent":
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36",
};

/**
 * Construye la URL del CDN para una marca dado su ID.
 * Patrón jerárquico: cada dígito excepto el último es un nivel de directorio.
 *   ID=5    → .../manufacturer/5_100.webp
 *   ID=16   → .../manufacturer/1/6_100.webp
 *   ID=104  → .../manufacturer/1/0/4_100.webp
 *   ID=1480 → .../manufacturer/1/4/8/0_100.webp
 */
function cdnUrl(id: number): string {
  const digits = String(id).split("");
  if (digits.length === 1) {
    return `${CDN_BASE}/${digits[0]}_100.webp`;
  }
  const dirs     = digits.slice(0, -1).join("/");
  const lastChar = digits[digits.length - 1];
  return `${CDN_BASE}/${dirs}/${lastChar}_100.webp`;
}

function esperar(ms: number) {
  return new Promise((r) => setTimeout(r, ms));
}

async function descargar() {
  mkdirSync(DEST_DIR, { recursive: true });

  const marcas = await db.vehicleMake.findMany({
    select: { id: true, name: true },
    orderBy: { id: "asc" },
  });

  console.log(`Descargando logos de ${marcas.length} marcas...\n`);

  let ok = 0;
  let sinLogo = 0;
  let errores = 0;

  for (const marca of marcas) {
    // Fichero local con nombre único basado en el ID de la BD
    const nombreFichero = `${marca.id}_logo.webp`;
    const destFichero   = join(DEST_DIR, nombreFichero);
    const urlLocal      = `${PUBLIC_PATH}/${nombreFichero}`;
    const url           = cdnUrl(marca.id);

    process.stdout.write(`[${String(marca.id).padStart(5)}] ${marca.name}... `);

    try {
      const res = await fetch(url, { headers: HEADERS });

      if (res.status === 404) {
        await db.vehicleMake.update({ where: { id: marca.id }, data: { logoUrl: null } });
        console.log("sin logo");
        sinLogo++;
        continue;
      }
      if (!res.ok) throw new Error(`HTTP ${res.status}`);

      const buffer = Buffer.from(await res.arrayBuffer());
      writeFileSync(destFichero, buffer);

      await db.vehicleMake.update({
        where: { id: marca.id },
        data:  { logoUrl: urlLocal },
      });

      console.log(`OK (${buffer.length} bytes)`);
      ok++;
    } catch (err) {
      console.error(`ERROR — ${err instanceof Error ? err.message : String(err)}`);
      errores++;
    }

    await esperar(DELAY_MS);
  }

  console.log("\n─────────────────────────────────────");
  console.log(`Logos descargados : ${ok}`);
  console.log(`Sin logo en CDN   : ${sinLogo}`);
  if (errores > 0) console.warn(`Errores           : ${errores}`);
  console.log("─────────────────────────────────────\n");
}

descargar()
  .catch((err: unknown) => {
    console.error("Error fatal:", err);
    process.exit(1);
  })
  .finally(() => void db.$disconnect());
