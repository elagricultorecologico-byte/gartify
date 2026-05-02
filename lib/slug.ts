import { db } from "@/lib/db";

/**
 * Convierte un texto arbitrario en un slug válido para URLs:
 * minúsculas, sin acentos, sin caracteres especiales, espacios → guiones.
 */
export function slugify(text: string): string {
  return text
    .toLowerCase()
    .normalize("NFD")
    .replace(/[\u0300-\u036f]/g, "")   // eliminar diacríticos (acentos, etc.)
    .replace(/[^a-z0-9\s-]/g, "")      // solo alfanumérico, espacios y guiones
    .trim()
    .replace(/\s+/g, "-")              // espacios → guiones
    .replace(/-+/g, "-");              // guiones múltiples → uno solo
}

/**
 * Genera un slug único para un taller comprobando contra la base de datos.
 * Si el slug base ya existe, añade un sufijo numérico incremental (-2, -3…).
 */
export async function generateUniqueSlug(garageName: string): Promise<string> {
  const base = slugify(garageName);

  // Comprobar si el slug base está disponible
  const existente = await db.garage.findUnique({ where: { slug: base } });
  if (!existente) return base;

  // Buscar el siguiente número libre
  let n = 2;
  while (true) {
    const candidato = `${base}-${n}`;
    const encontrado = await db.garage.findUnique({ where: { slug: candidato } });
    if (!encontrado) return candidato;
    n++;
  }
}
