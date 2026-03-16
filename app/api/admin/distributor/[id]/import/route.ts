import { NextResponse } from "next/server";
import * as XLSX from "xlsx";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

// Columnas requeridas del Excel (índices 0-based basados en el orden de cabecera)
const REQUIRED_COLS = ["referencia_oem", "referencia_proveedor", "nombre", "marca_fabricante", "categoria", "precio_coste", "iva_pct", "stock", "unidad", "plazo_entrega_horas"];

function toStr(v: unknown): string { return v == null ? "" : String(v).trim(); }
function toNum(v: unknown): number { const n = parseFloat(String(v)); return isNaN(n) ? 0 : n; }
function toInt(v: unknown): number { const n = parseInt(String(v)); return isNaN(n) ? 0 : n; }

export async function POST(
  request: Request,
  { params }: { params: { id: string } }
) {
  const session = await auth();
  const user = session?.user as { role?: string } | undefined;
  if (user?.role !== "ADMIN") return NextResponse.json({ error: "Forbidden" }, { status: 403 });

  const distributor = await db.distributor.findUnique({ where: { id: params.id } });
  if (!distributor) return NextResponse.json({ error: "Distribuidor no encontrado" }, { status: 404 });

  const formData = await request.formData();
  const file = formData.get("file") as File | null;
  if (!file) return NextResponse.json({ error: "Falta el archivo" }, { status: 400 });

  const buffer = Buffer.from(await file.arrayBuffer());
  const workbook = XLSX.read(buffer, { type: "buffer" });
  const sheetName = workbook.SheetNames[0];
  if (!sheetName) return NextResponse.json({ error: "El Excel está vacío" }, { status: 400 });

  const rows = XLSX.utils.sheet_to_json<Record<string, unknown>>(
    workbook.Sheets[sheetName],
    { defval: "" }
  );

  if (rows.length === 0) return NextResponse.json({ error: "El Excel no tiene filas de datos" }, { status: 400 });

  // Validar que existen las columnas requeridas
  const headers = Object.keys(rows[0]).map((h) => h.toLowerCase().trim());
  const missing = REQUIRED_COLS.filter((c) => !headers.includes(c));
  if (missing.length > 0) {
    return NextResponse.json(
      { error: `Faltan columnas obligatorias: ${missing.join(", ")}` },
      { status: 400 }
    );
  }

  let created = 0;
  let updated = 0;
  const errors: string[] = [];

  for (let i = 0; i < rows.length; i++) {
    const row = rows[i];
    // Normalise keys to lowercase
    const r: Record<string, unknown> = {};
    for (const [k, v] of Object.entries(row)) r[k.toLowerCase().trim()] = v;

    const referenciaOem = toStr(r["referencia_oem"]);
    const refProveedor  = toStr(r["referencia_proveedor"]);

    if (!referenciaOem || !refProveedor) {
      errors.push(`Fila ${i + 2}: referencia_oem y referencia_proveedor son obligatorias`);
      continue;
    }

    try {
      // Upsert Part por referencia OEM
      const part = await db.part.upsert({
        where: { referenciaOem },
        create: {
          referenciaOem,
          ean:             toStr(r["ean"]) || null,
          nombre:          toStr(r["nombre"]),
          marcaFabricante: toStr(r["marca_fabricante"]),
          categoria:       toStr(r["categoria"]).toUpperCase(),
          subcategoria:    toStr(r["subcategoria"]) || null,
          marcaVehiculo:   toStr(r["marca_vehiculo"]) || null,
          modeloVehiculo:  toStr(r["modelo_vehiculo"]) || null,
          anioDesde:       r["anio_desde"] ? toInt(r["anio_desde"]) : null,
          anioHasta:       r["anio_hasta"] ? toInt(r["anio_hasta"]) : null,
          pesoKg:          r["peso_kg"] ? toNum(r["peso_kg"]) : null,
          imagenUrl:       toStr(r["imagen_url"]) || null,
        },
        update: {
          nombre:          toStr(r["nombre"]),
          marcaFabricante: toStr(r["marca_fabricante"]),
          categoria:       toStr(r["categoria"]).toUpperCase(),
          subcategoria:    toStr(r["subcategoria"]) || null,
          marcaVehiculo:   toStr(r["marca_vehiculo"]) || null,
          modeloVehiculo:  toStr(r["modelo_vehiculo"]) || null,
          anioDesde:       r["anio_desde"] ? toInt(r["anio_desde"]) : null,
          anioHasta:       r["anio_hasta"] ? toInt(r["anio_hasta"]) : null,
        },
      });

      // Upsert DistributorPart por [distributorId, referenciaProveedor]
      const existing = await db.distributorPart.findUnique({
        where: { distributorId_referenciaProveedor: { distributorId: distributor.id, referenciaProveedor: refProveedor } },
      });

      const partData = {
        partId:             part.id,
        precioCoste:        toNum(r["precio_coste"]),
        precioPvp:          r["precio_pvp"] ? toNum(r["precio_pvp"]) : null,
        ivaPct:             toInt(r["iva_pct"]) || 21,
        stock:              toInt(r["stock"]),
        unidad:             toStr(r["unidad"]) || "ud",
        plazoEntregaHoras:  toInt(r["plazo_entrega_horas"]) || 24,
        notas:              toStr(r["notas"]) || null,
      };

      if (existing) {
        await db.distributorPart.update({ where: { id: existing.id }, data: partData });
        updated++;
      } else {
        await db.distributorPart.create({
          data: { distributorId: distributor.id, referenciaProveedor: refProveedor, ...partData },
        });
        created++;
      }
    } catch {
      errors.push(`Fila ${i + 2}: error procesando ${referenciaOem}`);
    }
  }

  return NextResponse.json({ created, updated, errors, total: rows.length });
}
