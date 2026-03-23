"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import { Loader2, ExternalLink, XCircle, Search, ChevronLeft, ChevronRight, AlertTriangle } from "lucide-react";

// ─── Tipos ────────────────────────────────────────────────────────────────────

type EstadoPedido = "PENDING" | "CONFIRMED" | "SHIPPED" | "DELIVERED" | "CANCELLED";

type LineaPedido = {
  id: string;
  cantidad: number;
  precioUnitario: number;
  distributorPart: {
    referenciaProveedor: string;
    part: { nombre: string };
  };
};

type Pedido = {
  id: string;
  createdAt: string;
  statusUpdatedAt: string;
  totalAmount: number;
  status: EstadoPedido;
  notes: string | null;
  garage: { id: string; name: string };
  lines: LineaPedido[];
};

// ─── Helper: determina si un pedido lleva más de 24h en su estado actual ─────

function esVencido(statusUpdatedAt: string, status: EstadoPedido): boolean {
  // Los estados terminales no se consideran vencidos
  if (status === "DELIVERED" || status === "CANCELLED") return false;
  return Date.now() - new Date(statusUpdatedAt).getTime() > 24 * 60 * 60 * 1000;
}

// ─── Flujo de estados (orden lineal) ─────────────────────────────────────────

const FLUJO: EstadoPedido[] = ["PENDING", "CONFIRMED", "SHIPPED", "DELIVERED"];

const ESTADO_LABEL: Record<EstadoPedido, string> = {
  PENDING:   "Pendiente",
  CONFIRMED: "Confirmado",
  SHIPPED:   "En camino",
  DELIVERED: "Entregado",
  CANCELLED: "Cancelado",
};

// Estados a los que se puede avanzar desde cada uno
const SIGUIENTES: Record<EstadoPedido, EstadoPedido[]> = {
  PENDING:   ["CONFIRMED", "CANCELLED"],
  CONFIRMED: ["SHIPPED",   "CANCELLED"],
  SHIPPED:   ["DELIVERED"],
  DELIVERED: [],
  CANCELLED: [],
};

// ─── Badge de estado ──────────────────────────────────────────────────────────

const ESTADO_BADGE: Record<EstadoPedido, string> = {
  PENDING:   "bg-yellow-100 text-yellow-700 border-yellow-200",
  CONFIRMED: "bg-teal-100 text-teal-700 border-teal-200",
  SHIPPED:   "bg-orange-100 text-orange-700 border-orange-200",
  DELIVERED: "bg-green-100 text-green-700 border-green-200",
  CANCELLED: "bg-red-100 text-red-700 border-red-200",
};

// ─── Timeline compacto (solo puntos, sin texto) ───────────────────────────────

function TimelineCompacto({ estado }: { estado: EstadoPedido }) {
  if (estado === "CANCELLED") {
    return <XCircle className="h-4 w-4 text-red-400 shrink-0" title="Cancelado" />;
  }
  const indiceActual = FLUJO.indexOf(estado);
  return (
    <div className="flex items-center gap-0.5">
      {FLUJO.map((paso, i) => {
        const completado = i < indiceActual;
        const activo     = i === indiceActual;
        const ultimo     = i === FLUJO.length - 1;
        return (
          <div key={paso} className="flex items-center gap-0.5" title={ESTADO_LABEL[paso]}>
            <div className={`h-2.5 w-2.5 rounded-full shrink-0 ${
              completado ? "bg-gartify-blue" :
              activo     ? "bg-gartify-orange ring-2 ring-gartify-orange/30" :
                           "bg-gray-200"
            }`} />
            {!ultimo && (
              <div className={`h-0.5 w-4 ${i < indiceActual ? "bg-gartify-blue" : "bg-gray-200"}`} />
            )}
          </div>
        );
      })}
    </div>
  );
}

// ─── Columna: solo badge ──────────────────────────────────────────────────────

function EstadoBadge({ estado }: { estado: EstadoPedido }) {
  return (
    <span className={`text-xs font-semibold border rounded-full px-2.5 py-0.5 whitespace-nowrap ${ESTADO_BADGE[estado]}`}>
      {ESTADO_LABEL[estado]}
    </span>
  );
}

// ─── Columna: acción / cambio de estado ───────────────────────────────────────

function AccionEstado({
  pedidoId,
  estado,
  onActualizado,
}: {
  pedidoId: string;
  estado: EstadoPedido;
  onActualizado: (nuevoEstado: EstadoPedido) => void;
}) {
  const [cargando, setCargando] = useState(false);
  const [error, setError] = useState("");
  const siguientes = SIGUIENTES[estado];

  async function cambiarEstado(nuevoEstado: EstadoPedido) {
    setCargando(true);
    setError("");
    const res = await fetch(`/api/distribuidor/orders/${pedidoId}`, {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ status: nuevoEstado }),
    });
    setCargando(false);
    if (res.ok) {
      onActualizado(nuevoEstado);
    } else {
      const data = await res.json() as { error?: string };
      setError(data.error ?? "Error al actualizar");
    }
  }

  return (
    <div className="flex flex-col gap-1">
      {siguientes.length > 0 ? (
        cargando
          ? <Loader2 className="h-3.5 w-3.5 animate-spin text-gray-400" />
          : <select
              disabled={cargando}
              defaultValue=""
              onChange={(e) => cambiarEstado(e.target.value as EstadoPedido)}
              className="text-xs border border-gray-200 rounded-lg px-2 py-1 bg-white text-gray-600 focus:outline-none focus:ring-2 focus:ring-gartify-blue/30 cursor-pointer"
            >
              <option value="" disabled>Mover a...</option>
              {siguientes.map((sig) => (
                <option key={sig} value={sig}>{ESTADO_LABEL[sig]}</option>
              ))}
            </select>
      ) : (
        <span className="text-xs text-gray-400">—</span>
      )}
      {error && <span className="text-xs text-red-500">{error}</span>}
    </div>
  );
}

// ─── Tipos para los filtros ───────────────────────────────────────────────────

const ESTADOS_FILTRO = {
  TODOS:     "TODOS",
  PENDING:   "PENDING",
  CONFIRMED: "CONFIRMED",
  SHIPPED:   "SHIPPED",
  DELIVERED: "DELIVERED",
  CANCELLED: "CANCELLED",
} as const;
type EstadoFiltro = (typeof ESTADOS_FILTRO)[keyof typeof ESTADOS_FILTRO];

const PERIODOS = {
  TODO:   "TODO",
  HOY:    "HOY",
  SEMANA: "SEMANA",
  MES:    "MES",
} as const;
type Periodo = (typeof PERIODOS)[keyof typeof PERIODOS];

const PERIODO_LABEL: Record<Periodo, string> = {
  TODO:   "Todo el tiempo",
  HOY:    "Hoy",
  SEMANA: "Esta semana",
  MES:    "Este mes",
};

// ─── Tabla principal de pedidos ───────────────────────────────────────────────

export function OrdersTable({ pedidosIniciales }: { pedidosIniciales: Pedido[] }) {
  const router = useRouter();
  const [pedidos, setPedidos] = useState<Pedido[]>(pedidosIniciales);
  const [expandidoId, setExpandidoId] = useState<string | null>(null);

  // ─── Estado de los filtros ────────────────────────────────────────────────
  const [busqueda, setBusqueda] = useState("");
  const [estadoFiltro, setEstadoFiltro] = useState<EstadoFiltro>(ESTADOS_FILTRO.TODOS);
  const [periodo, setPeriodo] = useState<Periodo>(PERIODOS.TODO);

  // ─── Estado de paginación ─────────────────────────────────────────────────
  const [paginaActual, setPaginaActual] = useState(1);
  const [filasPorPagina, setFilasPorPagina] = useState(10);
  const [soloVencidos, setSoloVencidos] = useState(false);

  function cambiarFiltro<T>(setter: (v: T) => void) {
    return (v: T) => { setter(v); setPaginaActual(1); };
  }

  function actualizarEstado(pedidoId: string, nuevoEstado: EstadoPedido) {
    setPedidos((prev) =>
      prev.map((p) => (p.id === pedidoId ? { ...p, status: nuevoEstado } : p))
    );
    router.refresh();
  }

  // ─── Lógica de filtrado + paginación ─────────────────────────────────────
  const pedidosFiltrados = pedidos
    .filter((p) => !soloVencidos || esVencido(p.statusUpdatedAt, p.status))
    .filter((p) => estadoFiltro === ESTADOS_FILTRO.TODOS || p.status === estadoFiltro)
    .filter((p) => {
      if (!busqueda) return true;
      const q = busqueda.toLowerCase();
      return (
        p.garage.name.toLowerCase().includes(q) ||
        p.id.slice(-8).toLowerCase().includes(q)
      );
    })
    .filter((p) => {
      const fecha = new Date(p.createdAt);
      const ahora = new Date();
      if (periodo === PERIODOS.HOY) {
        return fecha.toDateString() === ahora.toDateString();
      }
      if (periodo === PERIODOS.SEMANA) {
        const inicioSemana = new Date(ahora);
        inicioSemana.setDate(ahora.getDate() - ahora.getDay());
        inicioSemana.setHours(0, 0, 0, 0);
        return fecha >= inicioSemana;
      }
      if (periodo === PERIODOS.MES) {
        return (
          fecha.getMonth() === ahora.getMonth() &&
          fecha.getFullYear() === ahora.getFullYear()
        );
      }
      return true;
    });

  const totalPaginas = Math.max(1, Math.ceil(pedidosFiltrados.length / filasPorPagina));
  const paginaReal = Math.min(paginaActual, totalPaginas);
  const pedidosPaginados = pedidosFiltrados.slice(
    (paginaReal - 1) * filasPorPagina,
    paginaReal * filasPorPagina,
  );
  const inicio = pedidosFiltrados.length === 0 ? 0 : (paginaReal - 1) * filasPorPagina + 1;
  const fin = Math.min(paginaReal * filasPorPagina, pedidosFiltrados.length);

  // Genera los números de página a mostrar (con "..." cuando hay muchas)
  function paginasVisibles(): (number | "...")[] {
    if (totalPaginas <= 7) return Array.from({ length: totalPaginas }, (_, i) => i + 1);
    const pages: (number | "...")[] = [1];
    if (paginaReal > 3) pages.push("...");
    for (let i = Math.max(2, paginaReal - 1); i <= Math.min(totalPaginas - 1, paginaReal + 1); i++) pages.push(i);
    if (paginaReal < totalPaginas - 2) pages.push("...");
    pages.push(totalPaginas);
    return pages;
  }

  // Calcula qué estados tienen al menos un pedido (para mostrar solo las pills relevantes)
  const estadosConPedidos = new Set(pedidos.map((p) => p.status));

  if (pedidos.length === 0) {
    return (
      <div className="text-center py-16 rounded-xl border border-dashed border-gray-200 bg-gray-50">
        <p className="text-gray-500 font-semibold">Sin pedidos todavía</p>
        <p className="text-sm text-gray-400 mt-1">Los pedidos de los talleres aparecerán aquí</p>
      </div>
    );
  }

  return (
    <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
      {/* ─── Barra de filtros ──────────────────────────────────────────────── */}
      <div className="flex flex-col md:flex-row md:items-center gap-3 px-5 py-4 border-b border-gray-100 bg-gray-50/60">
        {/* Input de búsqueda */}
        <div className="relative flex-shrink-0 md:w-56">
          <Search className="absolute left-2.5 top-1/2 -translate-y-1/2 h-3.5 w-3.5 text-gray-400 pointer-events-none" />
          <input
            type="text"
            value={busqueda}
            onChange={(e) => cambiarFiltro(setBusqueda)(e.target.value)}
            placeholder="Taller o nº de pedido..."
            className="w-full pl-8 pr-3 py-1.5 text-xs border border-gray-200 rounded-lg bg-white text-gray-700 placeholder:text-gray-400 focus:outline-none focus:ring-2 focus:ring-gartify-blue/30"
          />
        </div>

        {/* Pills de estado */}
        <div className="flex flex-wrap gap-1.5 flex-1">
          {/* Pill "Todos" */}
          <button
            type="button"
            onClick={() => cambiarFiltro(setEstadoFiltro)(ESTADOS_FILTRO.TODOS)}
            className={`text-xs font-semibold border rounded-full px-3 py-1 transition-colors whitespace-nowrap ${
              estadoFiltro === ESTADOS_FILTRO.TODOS
                ? "bg-gartify-blue text-white border-gartify-blue"
                : "bg-gray-100 text-gray-500 border-gray-200 hover:bg-gray-200"
            }`}
          >
            Todos
          </button>
          {/* Pills por cada estado que tiene pedidos */}
          {(Object.keys(ESTADO_LABEL) as EstadoPedido[]).filter((e) => estadosConPedidos.has(e)).map((estado) => {
            const activo = estadoFiltro === estado;
            return (
              <button
                key={estado}
                type="button"
                onClick={() => cambiarFiltro(setEstadoFiltro)(estado)}
                className={`text-xs font-semibold border rounded-full px-3 py-1 transition-colors whitespace-nowrap ${
                  activo
                    ? ESTADO_BADGE[estado]
                    : "bg-gray-100 text-gray-500 border-gray-200 hover:bg-gray-200"
                }`}
              >
                {ESTADO_LABEL[estado]}
              </button>
            );
          })}
        </div>

        {/* Filtro rápido: pedidos vencidos */}
        <button
          type="button"
          onClick={() => { setSoloVencidos((v) => !v); setPaginaActual(1); }}
          title={soloVencidos ? "Mostrando solo pedidos con +24h sin avanzar" : "Filtrar pedidos con +24h sin avanzar"}
          className={`flex items-center justify-center h-7 w-7 rounded-lg border transition-colors shrink-0 ${
            soloVencidos
              ? "bg-amber-400 border-amber-400 text-white"
              : "bg-white border-gray-200 text-gray-400 hover:border-amber-300 hover:text-amber-500"
          }`}
        >
          <AlertTriangle className="h-3.5 w-3.5" />
        </button>

        {/* Select de período */}
        <select
          value={periodo}
          onChange={(e) => cambiarFiltro(setPeriodo)(e.target.value as Periodo)}
          className="text-xs border border-gray-200 rounded-lg px-2 py-1.5 bg-white text-gray-600 focus:outline-none focus:ring-2 focus:ring-gartify-blue/30 cursor-pointer flex-shrink-0"
        >
          {(Object.keys(PERIODOS) as Periodo[]).map((p) => (
            <option key={p} value={p}>{PERIODO_LABEL[p]}</option>
          ))}
        </select>
      </div>

      {/* Cabecera de columnas */}
      <div className="hidden md:grid grid-cols-[0.7fr_1.2fr_0.9fr_0.7fr_1fr_1.2fr_1.1fr_0.5fr] gap-4 px-5 py-3 bg-gray-50 border-b border-gray-100 text-xs font-semibold text-gray-500 uppercase tracking-wide">
        <span>Nº Pedido</span>
        <span>Taller</span>
        <span>Fecha</span>
        <span>Total</span>
        <span>Estado</span>
        <span>Progreso</span>
        <span>Acción</span>
        <span></span>
      </div>

      {/* Mensaje cuando los filtros no devuelven resultados */}
      {pedidosFiltrados.length === 0 && (
        <div className="text-center py-12 text-gray-400">
          <p className="font-semibold text-gray-500">No hay pedidos que coincidan con los filtros</p>
          <p className="text-sm mt-1">Prueba a ajustar la búsqueda o el período seleccionado</p>
        </div>
      )}

      <div className="divide-y divide-gray-100">
        {pedidosPaginados.map((pedido) => {
          const estaExpandido = expandidoId === pedido.id;
          const vencido = esVencido(pedido.statusUpdatedAt, pedido.status);

          const fechaFormateada = new Intl.DateTimeFormat("es-ES", {
            day: "2-digit", month: "2-digit", year: "numeric",
            hour: "2-digit", minute: "2-digit",
          }).format(new Date(pedido.createdAt));

          const precioFormateado = new Intl.NumberFormat("es-ES", {
            style: "currency", currency: "EUR",
          }).format(pedido.totalAmount);

          return (
            <div key={pedido.id}>
              {/* Fila principal: fondo ámbar si lleva >24h en estado activo */}
              <div className={`grid grid-cols-1 md:grid-cols-[0.7fr_1.2fr_0.9fr_0.7fr_1fr_1.2fr_1.1fr_0.5fr] gap-2 md:gap-4 px-5 py-4 items-center ${vencido ? "bg-amber-50 border-l-4 border-l-amber-400" : ""}`}>
                {/* Nº pedido */}
                <span className="font-mono text-xs font-bold text-gartify-blue">
                  #{pedido.id.slice(-8).toUpperCase()}
                </span>

                {/* Taller */}
                <span className="text-sm font-semibold text-gray-800 truncate">
                  {pedido.garage.name}
                </span>

                {/* Fecha */}
                <span className="text-xs text-gray-500">{fechaFormateada}</span>

                {/* Total */}
                <span className="text-sm font-bold text-gartify-orange">{precioFormateado}</span>

                {/* Col: Estado + indicador de vencimiento */}
                <div className="flex items-center gap-1.5">
                  <EstadoBadge estado={pedido.status} />
                  {vencido && (
                    <AlertTriangle
                      className="h-3.5 w-3.5 text-amber-500 shrink-0"
                      title="+24h sin actualizar"
                    />
                  )}
                </div>

                {/* Col: Progreso */}
                <TimelineCompacto estado={pedido.status} />

                {/* Col: Acción */}
                <AccionEstado
                  pedidoId={pedido.id}
                  estado={pedido.status}
                  onActualizado={(nuevoEstado) => actualizarEstado(pedido.id, nuevoEstado)}
                />

                {/* Expandir líneas */}
                <button
                  type="button"
                  onClick={() => setExpandidoId(estaExpandido ? null : pedido.id)}
                  className="text-xs text-gartify-blue hover:underline flex items-center gap-1 justify-end"
                >
                  <ExternalLink className="h-3.5 w-3.5" />
                  {estaExpandido ? "Ocultar" : "Detalle"}
                </button>
              </div>

              {/* Líneas del pedido (expandible) */}
              {estaExpandido && (
                <div className="border-t border-gray-100 bg-gray-50 px-5 py-3">
                  {pedido.notes && (
                    <p className="text-xs text-gray-500 mb-2 italic">Nota: {pedido.notes}</p>
                  )}
                  <table className="w-full text-xs">
                    <thead>
                      <tr className="text-gray-400 uppercase text-[10px] tracking-wide">
                        <th className="text-left pb-1 font-semibold">Referencia</th>
                        <th className="text-left pb-1 font-semibold">Descripción</th>
                        <th className="text-right pb-1 font-semibold">Cant.</th>
                        <th className="text-right pb-1 font-semibold">P. unitario</th>
                        <th className="text-right pb-1 font-semibold">Subtotal</th>
                      </tr>
                    </thead>
                    <tbody className="divide-y divide-gray-200">
                      {pedido.lines.map((linea) => {
                        const subtotal = linea.cantidad * linea.precioUnitario;
                        return (
                          <tr key={linea.id} className="text-gray-600">
                            <td className="py-1 font-mono text-[11px] text-gartify-blue">
                              {linea.distributorPart.referenciaProveedor}
                            </td>
                            <td className="py-1 truncate max-w-[200px]">
                              {linea.distributorPart.part.nombre}
                            </td>
                            <td className="py-1 text-right">{linea.cantidad}</td>
                            <td className="py-1 text-right">
                              {new Intl.NumberFormat("es-ES", { style: "currency", currency: "EUR" }).format(linea.precioUnitario)}
                            </td>
                            <td className="py-1 text-right font-semibold">
                              {new Intl.NumberFormat("es-ES", { style: "currency", currency: "EUR" }).format(subtotal)}
                            </td>
                          </tr>
                        );
                      })}
                    </tbody>
                  </table>
                </div>
              )}
            </div>
          );
        })}
      </div>

      {/* ─── Footer de paginación ──────────────────────────────────────────── */}
      <div className="flex flex-col md:flex-row md:items-center justify-between gap-3 px-5 py-3 border-t border-gray-100 bg-gray-50/60">
        {/* Info + filas por página */}
        <div className="flex items-center gap-3 text-xs text-gray-500">
          <span>
            {pedidosFiltrados.length === 0
              ? "0 pedidos"
              : `${inicio}–${fin} de ${pedidosFiltrados.length} pedidos`}
          </span>
          <span className="text-gray-300">|</span>
          <label className="flex items-center gap-1.5">
            Filas por página
            <select
              value={filasPorPagina}
              onChange={(e) => { setFilasPorPagina(Number(e.target.value)); setPaginaActual(1); }}
              className="border border-gray-200 rounded-lg px-2 py-1 bg-white text-gray-600 focus:outline-none focus:ring-2 focus:ring-gartify-blue/30 cursor-pointer"
            >
              {[5, 10, 25, 50].map((n) => <option key={n} value={n}>{n}</option>)}
            </select>
          </label>
        </div>

        {/* Controles de página */}
        <div className="flex items-center gap-1">
          <button
            type="button"
            onClick={() => setPaginaActual((p) => Math.max(1, p - 1))}
            disabled={paginaReal === 1}
            className="h-7 w-7 flex items-center justify-center rounded-lg border border-gray-200 bg-white text-gray-500 hover:bg-gray-50 disabled:opacity-40 disabled:cursor-not-allowed"
          >
            <ChevronLeft className="h-3.5 w-3.5" />
          </button>

          {paginasVisibles().map((p, i) =>
            p === "..." ? (
              <span key={`ellipsis-${i}`} className="px-1 text-xs text-gray-400">…</span>
            ) : (
              <button
                key={p}
                type="button"
                onClick={() => setPaginaActual(p)}
                className={`h-7 min-w-[28px] px-2 text-xs rounded-lg border transition-colors ${
                  p === paginaReal
                    ? "bg-gartify-blue text-white border-gartify-blue font-semibold"
                    : "bg-white text-gray-600 border-gray-200 hover:bg-gray-50"
                }`}
              >
                {p}
              </button>
            )
          )}

          <button
            type="button"
            onClick={() => setPaginaActual((p) => Math.min(totalPaginas, p + 1))}
            disabled={paginaReal === totalPaginas}
            className="h-7 w-7 flex items-center justify-center rounded-lg border border-gray-200 bg-white text-gray-500 hover:bg-gray-50 disabled:opacity-40 disabled:cursor-not-allowed"
          >
            <ChevronRight className="h-3.5 w-3.5" />
          </button>
        </div>
      </div>
    </div>
  );
}
