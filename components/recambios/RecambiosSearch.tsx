"use client";
import { useState, useMemo } from "react";
import {
  Search, ShoppingCart, Trash2, Package, Loader2,
  ChevronDown, ChevronUp, CheckCircle, Clock, X,
} from "lucide-react";

const CATEGORIAS = [
  { value: "", label: "Todas las categorías" },
  { value: "FRENOS",        label: "Frenos" },
  { value: "FILTROS",       label: "Filtros" },
  { value: "ACEITE",        label: "Aceite y lubricantes" },
  { value: "NEUMATICOS",    label: "Neumáticos" },
  { value: "SUSPENSION",    label: "Suspensión" },
  { value: "MOTOR",         label: "Motor" },
  { value: "ELECTRICIDAD",  label: "Electricidad" },
  { value: "ILUMINACION",   label: "Iluminación" },
  { value: "CARROCERIA",    label: "Carrocería" },
  { value: "CLIMATIZACION", label: "Climatización" },
  { value: "TRANSMISION",   label: "Transmisión" },
  { value: "OTRO",          label: "Otro" },
];

type DistributorPart = {
  id: string;
  distributorId: string;
  distributor: { id: string; name: string; logoUrl: string | null };
  referenciaProveedor: string;
  precioCoste: number;
  ivaPct: number;
  stock: number;
  unidad: string;
  plazoEntregaHoras: number;
  notas: string | null;
};

type Part = {
  id: string;
  referenciaOem: string;
  nombre: string;
  marcaFabricante: string;
  categoria: string;
  subcategoria: string | null;
  marcaVehiculo: string | null;
  modeloVehiculo: string | null;
  anioDesde: number | null;
  anioHasta: number | null;
  imagenUrl: string | null;
  distributorParts: DistributorPart[];
};

type CartItem = {
  distributorPartId: string;
  distributorId: string;
  distributorName: string;
  partNombre: string;
  referenciaOem: string;
  refProveedor: string;
  precio: number;
  ivaPct: number;
  unidad: string;
  cantidad: number;
};

function formatEur(n: number) {
  return new Intl.NumberFormat("es-ES", { style: "currency", currency: "EUR" }).format(n);
}

function PlazoChip({ horas }: { horas: number }) {
  const label = horas <= 4 ? "< 4 h" : horas <= 24 ? "24 h" : horas <= 48 ? "48 h" : `${Math.ceil(horas / 24)} días`;
  const color = horas <= 24 ? "text-green-600" : horas <= 48 ? "text-yellow-600" : "text-red-500";
  return (
    <span className={`flex items-center gap-0.5 text-xs font-medium ${color}`}>
      <Clock className="h-3 w-3" />
      {label}
    </span>
  );
}

export function RecambiosSearch() {
  const [query,     setQuery]     = useState("");
  const [categoria, setCategoria] = useState("");
  const [vehiculo,  setVehiculo]  = useState("");
  const [results,   setResults]   = useState<Part[]>([]);
  const [loading,   setLoading]   = useState(false);
  const [searched,  setSearched]  = useState(false);
  const [expanded,  setExpanded]  = useState<Set<string>>(new Set());
  const [cart,      setCart]      = useState<CartItem[]>([]);
  const [notes,     setNotes]     = useState("");
  const [submitting, setSubmitting] = useState<string | null>(null); // distributorId being submitted
  const [submitted,  setSubmitted]  = useState<string[]>([]);
  const [orderError, setOrderError] = useState("");

  async function handleSearch(e: React.FormEvent) {
    e.preventDefault();
    setLoading(true);
    setSearched(true);
    try {
      const params = new URLSearchParams();
      if (query)     params.set("q", query);
      if (categoria) params.set("categoria", categoria);
      if (vehiculo)  params.set("vehiculo", vehiculo);
      const res = await fetch(`/api/parts/search?${params}`);
      const data = await res.json() as Part[];
      setResults(data);
      // Auto-expand first 3 results
      setExpanded(new Set(data.slice(0, 3).map((p) => p.id)));
    } finally {
      setLoading(false);
    }
  }

  function toggleExpand(partId: string) {
    setExpanded((prev) => {
      const next = new Set(prev);
      if (next.has(partId)) next.delete(partId); else next.add(partId);
      return next;
    });
  }

  function addToCart(dp: DistributorPart, part: Part) {
    setCart((prev) => {
      const existing = prev.find((c) => c.distributorPartId === dp.id);
      if (existing) {
        return prev.map((c) => c.distributorPartId === dp.id ? { ...c, cantidad: c.cantidad + 1 } : c);
      }
      return [...prev, {
        distributorPartId: dp.id,
        distributorId:     dp.distributorId,
        distributorName:   dp.distributor.name,
        partNombre:        part.nombre,
        referenciaOem:     part.referenciaOem,
        refProveedor:      dp.referenciaProveedor,
        precio:            dp.precioCoste,
        ivaPct:            dp.ivaPct,
        unidad:            dp.unidad,
        cantidad:          1,
      }];
    });
  }

  function updateQty(dpId: string, qty: number) {
    if (qty < 1) { removeFromCart(dpId); return; }
    setCart((prev) => prev.map((c) => c.distributorPartId === dpId ? { ...c, cantidad: qty } : c));
  }

  function removeFromCart(dpId: string) {
    setCart((prev) => prev.filter((c) => c.distributorPartId !== dpId));
  }

  // Group cart by distributor
  const cartByDistributor = useMemo(() => {
    const map = new Map<string, { name: string; items: CartItem[] }>();
    for (const item of cart) {
      const entry = map.get(item.distributorId) ?? { name: item.distributorName, items: [] };
      entry.items.push(item);
      map.set(item.distributorId, entry);
    }
    return map;
  }, [cart]);

  async function submitOrder(distributorId: string) {
    const group = cartByDistributor.get(distributorId);
    if (!group) return;
    setSubmitting(distributorId);
    setOrderError("");
    try {
      const res = await fetch("/api/parts/orders", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          distributorId,
          lines: group.items.map((i) => ({ distributorPartId: i.distributorPartId, cantidad: i.cantidad })),
          notes: notes || undefined,
        }),
      });
      if (!res.ok) {
        const data = await res.json() as { error?: string };
        setOrderError(data.error ?? "Error al enviar el pedido");
      } else {
        setSubmitted((prev) => [...prev, distributorId]);
        setCart((prev) => prev.filter((c) => c.distributorId !== distributorId));
      }
    } finally {
      setSubmitting(null);
    }
  }

  const cartTotal = cart.reduce((s, c) => s + c.precio * c.cantidad, 0);

  return (
    <div className="flex gap-6 items-start">
      {/* ── Panel principal ── */}
      <div className="flex-1 min-w-0">

        {/* Buscador */}
        <form onSubmit={handleSearch} className="bg-white rounded-xl border border-gartify-blue/15 shadow-sm p-4 mb-6">
          <div className="flex flex-col sm:flex-row gap-3">
            <div className="relative flex-1">
              <Search className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-gartify-blue/40 pointer-events-none" />
              <input
                type="text"
                value={query}
                onChange={(e) => setQuery(e.target.value)}
                placeholder="Referencia OEM, nombre de pieza, marca…"
                className="w-full pl-9 pr-3 py-2 text-sm rounded-lg border border-gartify-blue/20 focus:outline-none focus:border-gartify-blue/50 focus:ring-2 focus:ring-gartify-blue/10 transition placeholder:text-gray-400"
              />
            </div>
            <select
              value={categoria}
              onChange={(e) => setCategoria(e.target.value)}
              className="py-2 px-3 text-sm rounded-lg border border-gartify-blue/20 focus:outline-none focus:border-gartify-blue/50 text-gray-700 bg-white"
            >
              {CATEGORIAS.map((c) => (
                <option key={c.value} value={c.value}>{c.label}</option>
              ))}
            </select>
            <input
              type="text"
              value={vehiculo}
              onChange={(e) => setVehiculo(e.target.value)}
              placeholder="Vehículo (marca/modelo)"
              className="py-2 px-3 text-sm rounded-lg border border-gartify-blue/20 focus:outline-none focus:border-gartify-blue/50 w-44 transition placeholder:text-gray-400"
            />
            <button
              type="submit"
              disabled={loading}
              className="shrink-0 bg-gartify-blue hover:bg-gartify-blue/90 text-white font-semibold text-sm px-5 py-2 rounded-lg transition disabled:opacity-50 flex items-center gap-2 shadow-sm"
            >
              {loading ? <Loader2 className="h-4 w-4 animate-spin" /> : <Search className="h-4 w-4" />}
              Buscar
            </button>
          </div>
        </form>

        {/* Resultados */}
        {loading && (
          <div className="text-center py-16 text-muted-foreground text-sm">
            <Loader2 className="h-6 w-6 animate-spin mx-auto mb-2 text-gartify-mid" />
            Buscando…
          </div>
        )}

        {!loading && searched && results.length === 0 && (
          <div className="text-center py-16 rounded-xl border border-dashed border-gartify-blue/20 bg-blue-50/30">
            <Package className="h-10 w-10 mx-auto mb-3 text-gartify-blue/20" />
            <p className="font-semibold text-gartify-blue/60">Sin resultados</p>
            <p className="text-sm text-gray-400 mt-1">Prueba con otro término o cambia los filtros</p>
          </div>
        )}

        {!loading && results.length > 0 && (
          <div className="space-y-3">
            <p className="text-xs text-gartify-gray font-medium">{results.length} resultado{results.length !== 1 ? "s" : ""}</p>
            {results.map((part) => (
              <div key={part.id} className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
                {/* Cabecera de la pieza */}
                <button
                  type="button"
                  onClick={() => toggleExpand(part.id)}
                  className="w-full flex items-center justify-between px-4 py-3.5 hover:bg-blue-50/30 transition text-left"
                >
                  <div className="flex items-center gap-3 min-w-0">
                    <div className="shrink-0 h-10 w-10 rounded-xl bg-gartify-blue/10 border border-gartify-blue/15 flex items-center justify-center">
                      <Package className="h-5 w-5 text-gartify-blue" />
                    </div>
                    <div className="min-w-0">
                      <p className="font-semibold text-gartify-blue text-sm truncate">{part.nombre}</p>
                      <p className="text-xs text-gartify-gray mt-0.5">
                        {part.marcaFabricante} · OEM: <span className="font-mono text-gray-500">{part.referenciaOem}</span>
                        {part.marcaVehiculo && ` · ${part.marcaVehiculo} ${part.modeloVehiculo ?? ""}`}
                        {part.anioDesde && ` (${part.anioDesde}–${part.anioHasta ?? ""})`}
                      </p>
                    </div>
                  </div>
                  <div className="flex items-center gap-3 shrink-0 ml-3">
                    <span className="text-xs bg-gartify-orange/10 text-gartify-orange border border-gartify-orange/20 rounded-full px-2.5 py-0.5 font-semibold capitalize">
                      {part.categoria.charAt(0) + part.categoria.slice(1).toLowerCase()}
                    </span>
                    <span className="text-sm font-bold text-gartify-orange">
                      Desde {formatEur(Math.min(...part.distributorParts.map((d) => d.precioCoste)))}
                    </span>
                    <span className="text-xs text-gartify-gray bg-gray-100 rounded-full px-2 py-0.5">{part.distributorParts.length} prov.</span>
                    {expanded.has(part.id)
                      ? <ChevronUp className="h-4 w-4 text-gartify-blue/50" />
                      : <ChevronDown className="h-4 w-4 text-gartify-blue/50" />}
                  </div>
                </button>

                {/* Tabla de distribuidores */}
                {expanded.has(part.id) && (
                  <div className="border-t border-gartify-blue/10">
                    <table className="w-full text-sm">
                      <thead>
                        <tr className="bg-gartify-blue/5 text-xs text-gartify-blue/60 font-semibold uppercase tracking-wide">
                          <th className="text-left px-4 py-2.5">Distribuidor</th>
                          <th className="text-left px-4 py-2.5">Ref. prov.</th>
                          <th className="text-right px-4 py-2.5">Precio</th>
                          <th className="text-right px-4 py-2.5">IVA</th>
                          <th className="text-right px-4 py-2.5">Stock</th>
                          <th className="text-right px-4 py-2.5">Plazo</th>
                          <th className="px-4 py-2.5" />
                        </tr>
                      </thead>
                      <tbody className="divide-y divide-gray-100">
                        {part.distributorParts.map((dp, i) => {
                          const inCart = cart.some((c) => c.distributorPartId === dp.id);
                          return (
                            <tr key={dp.id} className={`transition ${i === 0 ? "bg-green-50 hover:bg-green-100/50" : "hover:bg-blue-50/40"}`}>
                              <td className="px-4 py-3 font-semibold text-gartify-blue">
                                <div className="flex items-center gap-1.5 flex-wrap">
                                  {i === 0 && (
                                    <span className="text-xs bg-green-500 text-white rounded-full px-2 py-0.5 font-bold leading-none">
                                      Mejor precio
                                    </span>
                                  )}
                                  {dp.distributor.name}
                                </div>
                              </td>
                              <td className="px-4 py-3 font-mono text-xs text-gartify-gray">{dp.referenciaProveedor}</td>
                              <td className="px-4 py-3 text-right font-bold text-gartify-orange">
                                {formatEur(dp.precioCoste)}
                                <span className="text-xs text-gray-400 font-normal">/{dp.unidad}</span>
                              </td>
                              <td className="px-4 py-3 text-right text-gartify-gray text-xs">{dp.ivaPct}%</td>
                              <td className="px-4 py-3 text-right">
                                <span className={`text-xs font-semibold ${dp.stock > 10 ? "text-green-600" : dp.stock > 0 ? "text-yellow-600" : "text-red-500"}`}>
                                  {dp.stock} {dp.unidad}
                                </span>
                              </td>
                              <td className="px-4 py-3 text-right">
                                <PlazoChip horas={dp.plazoEntregaHoras} />
                              </td>
                              <td className="px-4 py-3 text-right">
                                <button
                                  type="button"
                                  onClick={() => addToCart(dp, part)}
                                  className={`text-xs font-bold px-3 py-1.5 rounded-lg transition shadow-sm ${
                                    inCart
                                      ? "bg-green-50 text-green-700 border border-green-200"
                                      : i === 0
                                        ? "bg-gartify-orange hover:bg-gartify-orange/90 text-white"
                                        : "bg-gartify-blue hover:bg-gartify-blue/90 text-white"
                                  }`}
                                >
                                  {inCart ? "✓ En carrito" : "+ Añadir"}
                                </button>
                              </td>
                            </tr>
                          );
                        })}
                      </tbody>
                    </table>
                  </div>
                )}
              </div>
            ))}
          </div>
        )}
      </div>

      {/* ── Carrito ── */}
      <aside className="w-80 shrink-0 sticky top-24">
        <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
          <div className="flex items-center justify-between px-4 py-3 bg-gradient-to-r from-gartify-hero to-gartify-mid">
            <div className="flex items-center gap-2 text-white">
              <ShoppingCart className="h-4 w-4" />
              <span className="font-bold text-sm">Pedido</span>
            </div>
            {cart.length > 0 && (
              <span className="text-xs font-bold bg-white/20 text-white rounded-full px-2.5 py-0.5">
                {formatEur(cartTotal)} s/IVA
              </span>
            )}
          </div>

          {cart.length === 0 ? (
            <div className="p-8 text-center">
              <div className="h-14 w-14 rounded-full bg-blue-50 border border-blue-100 flex items-center justify-center mx-auto mb-3">
                <ShoppingCart className="h-6 w-6 text-gartify-blue/30" />
              </div>
              <p className="text-sm font-semibold text-gartify-blue/50">Carrito vacío</p>
              <p className="text-xs text-gray-400 mt-1">Añade piezas desde los resultados</p>
            </div>
          ) : (
            <div className="p-3 space-y-4">
              {submitted.length > 0 && (
                <div className="flex items-center gap-2 rounded-lg bg-green-50 border border-green-200 px-3 py-2 text-xs text-green-700 font-semibold">
                  <CheckCircle className="h-3.5 w-3.5" />
                  {submitted.length} pedido{submitted.length > 1 ? "s" : ""} enviado{submitted.length > 1 ? "s" : ""}
                </div>
              )}
              {orderError && (
                <div className="text-xs text-red-600 bg-red-50 border border-red-100 rounded-lg px-3 py-2">
                  {orderError}
                </div>
              )}

              {/* Grupos por distribuidor */}
              {Array.from(cartByDistributor.entries()).map(([distId, group]) => {
                const groupTotal = group.items.reduce((s, i) => s + i.precio * i.cantidad, 0);
                const isSubmitting = submitting === distId;
                const isDone = submitted.includes(distId);
                return (
                  <div key={distId} className={`rounded-xl border overflow-hidden ${isDone ? "border-green-200 bg-green-50/40" : "border-gartify-blue/15"}`}>
                    <div className="flex items-center justify-between px-3 py-2 bg-gartify-blue/5 border-b border-gartify-blue/10">
                      <span className="text-xs font-bold text-gartify-blue truncate">{group.name}</span>
                      <span className="text-xs font-bold text-gartify-orange shrink-0 ml-2">{formatEur(groupTotal)}</span>
                    </div>
                    <div className="divide-y divide-gray-100">
                      {group.items.map((item) => (
                        <div key={item.distributorPartId} className="flex items-center gap-2 px-3 py-2">
                          <div className="flex-1 min-w-0">
                            <p className="text-xs font-semibold text-gartify-blue truncate">{item.partNombre}</p>
                            <p className="text-xs text-gartify-gray font-mono">{item.referenciaOem}</p>
                          </div>
                          <div className="flex items-center gap-1 shrink-0">
                            <button type="button" onClick={() => updateQty(item.distributorPartId, item.cantidad - 1)} className="h-5 w-5 rounded-md border border-gartify-blue/20 text-xs font-bold text-gartify-blue hover:bg-blue-50 flex items-center justify-center transition">−</button>
                            <span className="w-6 text-center text-xs font-bold text-gartify-blue">{item.cantidad}</span>
                            <button type="button" onClick={() => updateQty(item.distributorPartId, item.cantidad + 1)} className="h-5 w-5 rounded-md border border-gartify-blue/20 text-xs font-bold text-gartify-blue hover:bg-blue-50 flex items-center justify-center transition">+</button>
                          </div>
                          <span className="text-xs font-bold text-gartify-orange shrink-0 w-14 text-right">
                            {formatEur(item.precio * item.cantidad)}
                          </span>
                          <button type="button" onClick={() => removeFromCart(item.distributorPartId)} className="text-gray-300 hover:text-red-400 transition shrink-0">
                            <X className="h-3.5 w-3.5" />
                          </button>
                        </div>
                      ))}
                    </div>
                    {!isDone && (
                      <div className="px-3 pb-3 pt-2">
                        <button
                          type="button"
                          onClick={() => submitOrder(distId)}
                          disabled={isSubmitting}
                          className="w-full bg-gartify-orange hover:bg-gartify-orange/90 disabled:opacity-50 text-white text-xs font-bold py-2 rounded-lg transition flex items-center justify-center gap-1.5 shadow-sm"
                        >
                          {isSubmitting ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : null}
                          Confirmar pedido
                        </button>
                      </div>
                    )}
                    {isDone && (
                      <div className="px-3 pb-3 pt-2 flex items-center gap-1.5 text-xs text-green-700 font-semibold">
                        <CheckCircle className="h-3.5 w-3.5" />
                        Pedido enviado
                      </div>
                    )}
                  </div>
                );
              })}

              {/* Notas globales */}
              <div>
                <label className="text-xs font-semibold text-gartify-blue/70 block mb-1">Notas del pedido</label>
                <textarea
                  value={notes}
                  onChange={(e) => setNotes(e.target.value)}
                  rows={2}
                  placeholder="Indicaciones especiales…"
                  className="w-full text-xs rounded-lg border border-gartify-blue/20 px-2.5 py-1.5 focus:outline-none focus:border-gartify-blue/50 resize-none placeholder:text-gray-400"
                />
              </div>

              <button
                type="button"
                onClick={() => setCart([])}
                className="w-full flex items-center justify-center gap-1.5 text-xs text-red-400 hover:text-red-600 py-1 transition"
              >
                <Trash2 className="h-3.5 w-3.5" />
                Vaciar carrito
              </button>
            </div>
          )}
        </div>
      </aside>
    </div>
  );
}
