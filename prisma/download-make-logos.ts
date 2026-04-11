/**
 * Descarga los logos de marcas desde cdn.distriauto.eu
 * y actualiza las URLs en la BD para servirlos localmente.
 *
 * Uso:
 *   npx tsx prisma/download-make-logos.ts
 */

import { PrismaClient } from "@prisma/client";
import { writeFileSync, mkdirSync } from "fs";
import { join } from "path";

const db = new PrismaClient({ log: ["error"] });

const DEST_DIR = join(process.cwd(), "public", "images", "makes");
const PUBLIC_PATH = "/images/makes";
const DELAY_MS = 100;

const HEADERS: HeadersInit = {
  "User-Agent":
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36",
};

function esperar(ms: number) {
  return new Promise((r) => setTimeout(r, ms));
}

async function descargar() {
  mkdirSync(DEST_DIR, { recursive: true });

  const marcas = await db.vehicleMake.findMany({
    where: { logoUrl: { not: null } },
    select: { id: true, name: true, logoUrl: true },
  });

  console.log(`Descargando logos de ${marcas.length} marcas...\n`);

  let ok = 0;
  let errores = 0;

  for (const marca of marcas) {
    if (!marca.logoUrl) continue;

    // Extraer nombre de fichero de la URL remota
    const nombreFichero = marca.logoUrl.split("/").pop()!;
    const destFichero   = join(DEST_DIR, nombreFichero);
    const urlLocal      = `${PUBLIC_PATH}/${nombreFichero}`;

    process.stdout.write(`[${String(marca.id).padStart(5)}] ${marca.name}... `);

    try {
      const res = await fetch(marca.logoUrl, { headers: HEADERS });
      if (!res.ok) throw new Error(`HTTP ${res.status}`);

      const buffer = Buffer.from(await res.arrayBuffer());
      writeFileSync(destFichero, buffer);

      // Actualizar URL en BD
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
  if (errores > 0) console.warn(`Errores           : ${errores}`);
  console.log("─────────────────────────────────────\n");
}

descargar()
  .catch((err: unknown) => {
    console.error("Error fatal:", err);
    process.exit(1);
  })
  .finally(() => void db.$disconnect());
