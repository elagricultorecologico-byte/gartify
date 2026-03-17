"use client";
import { useState, useRef } from "react";
import {
  Plus, Building2, Upload, CheckCircle, AlertCircle,
  Package, ClipboardList, ChevronDown, ChevronUp, Loader2,
} from "lucide-react";

type Distributor = {
  id: string;
  name: string;
  email: string;
  phone: string | null;
  website: string | null;
  isActive: boolean;
  _count: { parts: number; orders: number };
};

type ImportResult = { created: number; updated: number; errors: string[]; total: number };


export function DistributorManager({ initialDistributors }: { initialDistributors: Distributor[] }) {
  const [distributors, setDistributors] = useState<Distributor[]>(initialDistributors);
  const [showCreate, setShowCreate] = useState(false);
  const [creating, setCreating] = useState(false);
  const [createError, setCreateError] = useState("");
  const [expandedId, setExpandedId] = useState<string | null>(null);
  const [importing, setImporting] = useState<string | null>(null);
  const [importResult, setImportResult] = useState<Record<string, ImportResult>>({});
  const fileRefs = useRef<Record<string, HTMLInputElement | null>>({});

  async function handleCreate(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setCreating(true);
    setCreateError("");
    const fd = new FormData(e.currentTarget);
    const body = {
      name:    fd.get("name"),
      email:   fd.get("email"),
      phone:   fd.get("phone") || undefined,
      website: fd.get("website") || undefined,
    };
    const res = await fetch("/api/admin/distributor", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
    });
    const data = await res.json() as Distributor & { error?: string };
    setCreating(false);
    if (!res.ok) { setCreateError(data.error ?? "Error al crear"); return; }
    setDistributors((prev) => [...prev, { ...data, _count: { parts: 0, orders: 0 } }]);
    setShowCreate(false);
    (e.target as HTMLFormElement).reset();
  }

  async function handleImport(distributorId: string, file: File) {
    setImporting(distributorId);
    const fd = new FormData();
    fd.append("file", file);
    const res = await fetch(`/api/admin/distributor/${distributorId}/import`, {
      method: "POST",
      body: fd,
    });
    const data = await res.json() as ImportResult & { error?: string };
    setImporting(null);
    if (!res.ok) {
      setImportResult((prev) => ({
        ...prev,
        [distributorId]: { created: 0, updated: 0, errors: [data.error ?? "Error"], total: 0 },
      }));
    } else {
      setImportResult((prev) => ({ ...prev, [distributorId]: data }));
      // Update parts count
      setDistributors((prev) =>
        prev.map((d) =>
          d.id === distributorId
            ? { ...d, _count: { ...d._count, parts: d._count.parts + data.created } }
            : d
        )
      );
    }
  }

  return (
    <div className="space-y-6">
      {/* Cabecera + botón crear */}
      <div className="flex items-center justify-between">
        <p className="text-sm text-muted-foreground">{distributors.length} distribuidor{distributors.length !== 1 ? "es" : ""}</p>
        <button
          type="button"
          onClick={() => setShowCreate((v) => !v)}
          className="flex items-center gap-2 bg-gartify-blue hover:bg-gartify-blue/90 text-white text-sm font-semibold px-4 py-2 rounded-lg transition"
        >
          <Plus className="h-4 w-4" />
          Nuevo distribuidor
        </button>
      </div>

      {/* Formulario crear */}
      {showCreate && (
        <div className="bg-white rounded-xl border border-gartify-blue/20 shadow-sm p-5">
          <h2 className="font-bold text-gartify-blue mb-4 flex items-center gap-2">
            <Building2 className="h-4 w-4" />
            Nuevo distribuidor
          </h2>
          <form onSubmit={handleCreate} className="grid grid-cols-2 gap-4">
            <div className="col-span-2 sm:col-span-1 space-y-1">
              <label className="text-xs font-semibold text-gray-600">Nombre *</label>
              <input name="name" required placeholder="Distribuciones García" className="w-full text-sm border border-gray-200 rounded-lg px-3 py-2 focus:outline-none focus:border-gartify-blue/50" />
            </div>
            <div className="col-span-2 sm:col-span-1 space-y-1">
              <label className="text-xs font-semibold text-gray-600">Email *</label>
              <input name="email" type="email" required placeholder="pedidos@distribuidor.es" className="w-full text-sm border border-gray-200 rounded-lg px-3 py-2 focus:outline-none focus:border-gartify-blue/50" />
            </div>
            <div className="space-y-1">
              <label className="text-xs font-semibold text-gray-600">Teléfono</label>
              <input name="phone" placeholder="91 000 00 00" className="w-full text-sm border border-gray-200 rounded-lg px-3 py-2 focus:outline-none focus:border-gartify-blue/50" />
            </div>
            <div className="space-y-1">
              <label className="text-xs font-semibold text-gray-600">Web</label>
              <input name="website" type="url" placeholder="https://..." className="w-full text-sm border border-gray-200 rounded-lg px-3 py-2 focus:outline-none focus:border-gartify-blue/50" />
            </div>
            {createError && (
              <div className="col-span-2 flex items-center gap-2 text-xs text-red-600 bg-red-50 border border-red-100 rounded-lg px-3 py-2">
                <AlertCircle className="h-3.5 w-3.5 shrink-0" />
                {createError}
              </div>
            )}
            <div className="col-span-2 flex gap-2 justify-end">
              <button type="button" onClick={() => setShowCreate(false)} className="text-sm text-gray-500 hover:text-gray-700 px-4 py-2 rounded-lg border border-gray-200 hover:bg-gray-50 transition">
                Cancelar
              </button>
              <button type="submit" disabled={creating} className="flex items-center gap-2 bg-gartify-orange hover:bg-gartify-orange/90 disabled:opacity-50 text-white text-sm font-semibold px-4 py-2 rounded-lg transition">
                {creating ? <Loader2 className="h-4 w-4 animate-spin" /> : <Plus className="h-4 w-4" />}
                Crear
              </button>
            </div>
          </form>
        </div>
      )}

      {/* Lista distribuidores */}
      {distributors.length === 0 ? (
        <div className="text-center py-16 rounded-xl border border-dashed border-gray-200 bg-gray-50">
          <Building2 className="h-10 w-10 mx-auto mb-3 text-gray-300" />
          <p className="text-gray-500 font-semibold">Sin distribuidores todavía</p>
          <p className="text-sm text-gray-400 mt-1">Crea el primero con el botón de arriba</p>
        </div>
      ) : (
        <div className="space-y-3">
          {distributors.map((d) => {
            const isExpanded = expandedId === d.id;
            const result = importResult[d.id];
            const isImporting = importing === d.id;
            return (
              <div key={d.id} className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
                {/* Row */}
                <div className="flex items-center gap-4 px-5 py-4">
                  <div className="h-10 w-10 rounded-full bg-blue-50 border border-blue-100 flex items-center justify-center shrink-0">
                    <Building2 className="h-5 w-5 text-gartify-mid" />
                  </div>
                  <div className="flex-1 min-w-0">
                    <p className="font-bold text-gartify-blue">{d.name}</p>
                    <p className="text-xs text-gray-400">{d.email}{d.phone ? ` · ${d.phone}` : ""}</p>
                  </div>
                  <div className="flex items-center gap-4 shrink-0 text-sm text-gray-500">
                    <span className="flex items-center gap-1 text-xs">
                      <Package className="h-3.5 w-3.5 text-gartify-mid" />
                      {d._count.parts} piezas
                    </span>
                    <span className="flex items-center gap-1 text-xs">
                      <ClipboardList className="h-3.5 w-3.5 text-gartify-mid" />
                      {d._count.orders} pedidos
                    </span>
                    <button
                      type="button"
                      onClick={() => setExpandedId(isExpanded ? null : d.id)}
                      className="flex items-center gap-1.5 text-xs font-semibold text-gartify-blue border border-gartify-blue/20 rounded-lg px-3 py-1.5 hover:bg-blue-50 transition"
                    >
                      <Upload className="h-3.5 w-3.5" />
                      Importar Excel
                      {isExpanded ? <ChevronUp className="h-3.5 w-3.5" /> : <ChevronDown className="h-3.5 w-3.5" />}
                    </button>
                  </div>
                </div>

                {/* Panel importación */}
                {isExpanded && (
                  <div className="border-t border-gray-100 bg-gray-50 px-5 py-4">
                    <p className="text-sm font-semibold text-gartify-blue mb-2">Importar catálogo de piezas</p>
                    <p className="text-xs text-gray-500 mb-3">
                      El Excel debe tener las columnas: <span className="font-mono text-xs bg-white border border-gray-200 rounded px-1">referencia_oem, referencia_proveedor, nombre, marca_fabricante, categoria, precio_coste, iva_pct, stock, unidad, plazo_entrega_horas</span>
                    </p>

                    {/* Download template hint */}
                    <p className="text-xs text-gartify-mid mb-3">
                      Columnas opcionales: ean, subcategoria, marca_vehiculo, modelo_vehiculo, anio_desde, anio_hasta, precio_pvp, peso_kg, imagen_url, notas
                    </p>

                    <div className="flex items-center gap-3">
                      <input
                        type="file"
                        accept=".xlsx,.xls,.csv"
                        ref={(el) => { fileRefs.current[d.id] = el; }}
                        onChange={(e) => {
                          const file = e.target.files?.[0];
                          if (file) handleImport(d.id, file);
                        }}
                        className="hidden"
                        id={`file-${d.id}`}
                      />
                      <label
                        htmlFor={`file-${d.id}`}
                        className={`flex items-center gap-2 cursor-pointer text-sm font-semibold px-4 py-2 rounded-lg transition ${
                          isImporting
                            ? "bg-gray-200 text-gray-400 pointer-events-none"
                            : "bg-gartify-blue hover:bg-gartify-blue/90 text-white"
                        }`}
                      >
                        {isImporting ? <Loader2 className="h-4 w-4 animate-spin" /> : <Upload className="h-4 w-4" />}
                        {isImporting ? "Procesando…" : "Seleccionar archivo"}
                      </label>
                    </div>

                    {/* Resultado de importación */}
                    {result && (
                      <div className={`mt-3 rounded-lg border px-4 py-3 text-sm ${result.errors.length > 0 && result.created + result.updated === 0 ? "bg-red-50 border-red-200" : "bg-green-50 border-green-200"}`}>
                        <div className="flex items-center gap-2 font-semibold mb-1">
                          {result.errors.length > 0 && result.created + result.updated === 0
                            ? <AlertCircle className="h-4 w-4 text-red-500" />
                            : <CheckCircle className="h-4 w-4 text-green-600" />}
                          <span className={result.errors.length > 0 && result.created + result.updated === 0 ? "text-red-700" : "text-green-700"}>
                            {result.created + result.updated > 0
                              ? `${result.created} creadas · ${result.updated} actualizadas de ${result.total} filas`
                              : result.errors[0]}
                          </span>
                        </div>
                        {result.errors.length > 0 && result.created + result.updated > 0 && (
                          <details className="mt-1">
                            <summary className="text-xs text-yellow-700 cursor-pointer">{result.errors.length} advertencia{result.errors.length > 1 ? "s" : ""}</summary>
                            <ul className="mt-1 space-y-0.5">
                              {result.errors.slice(0, 5).map((e, i) => (
                                <li key={i} className="text-xs text-gray-500">{e}</li>
                              ))}
                              {result.errors.length > 5 && <li className="text-xs text-gray-400">…y {result.errors.length - 5} más</li>}
                            </ul>
                          </details>
                        )}
                      </div>
                    )}
                  </div>
                )}
              </div>
            );
          })}
        </div>
      )}
    </div>
  );
}
