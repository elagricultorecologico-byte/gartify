"use client";
import { useState, useMemo } from "react";
import { Clock, Phone, Search, Wrench, ChevronLeft, ChevronRight, ArrowUp, ArrowDown, ChevronDown, SlidersHorizontal } from "lucide-react";
import { Input } from "@/components/ui/input";
import { BookingStatusUpdater } from "@/components/cuenta/BookingStatusUpdater";
import { SelloReservaButton } from "@/components/cuenta/SelloReservaButton";
import { formatPrice, formatDateTime, SERVICE_LABELS, BOOKING_STATUS_LABELS } from "@/lib/utils";

export type GarageBookingItem = {
  id: string;
  code?: string;
  status: string;
  date: Date | string;
  totalPrice: number;
  vehicleModel: string | null;
  vehiclePlate: string | null;
  notes: string | null;
  user: { name: string | null; phone: string | null };
  service: { type: string; name: string; duration: number };
  serviceRecord: { id: string } | null;
};

const STATUS_TABS = [
  { value: "ALL",       label: "Todas" },
  { value: "PENDING",   label: "Pendientes" },
  { value: "PROPOSED",  label: "Propuestas" },
  { value: "CONFIRMED", label: "Confirmadas" },
  { value: "COMPLETED", label: "Completadas" },
  { value: "CANCELLED", label: "Canceladas" },
] as const;

const COUNT_COLOR: Record<string, string> = {
  ALL:       "bg-gray-200 text-gray-700",
  PENDING:   "bg-yellow-100 text-yellow-700",
  PROPOSED:  "bg-purple-100 text-purple-700",
  CONFIRMED: "bg-green-100 text-green-700",
  COMPLETED: "bg-slate-100 text-slate-600",
  CANCELLED: "bg-red-100 text-red-600",
};

const STATUS_BAND: Record<string, string> = {
  PENDING:   "bg-yellow-50  text-yellow-700  border-yellow-200",
  PROPOSED:  "bg-purple-50  text-purple-700  border-purple-200",
  CONFIRMED: "bg-green-50   text-green-700   border-green-200",
  COMPLETED: "bg-slate-50   text-slate-500   border-slate-200",
  CANCELLED: "bg-red-50     text-red-500     border-red-200",
};


const POR_PAGINA = 10;

export function GarageBookingList({ bookings, garageId }: { bookings: GarageBookingItem[]; garageId: string }) {
  const [search, setSearch]                       = useState("");
  const [statusFilter, setStatusFilter]           = useState<string>("PENDING");
  const [orden, setOrden]                         = useState<"asc" | "desc">("asc");
  const [pagina, setPagina]                       = useState(1);
  const [filtrosMobileAbiertos, setFiltrosMobileAbiertos] = useState(false);

  const filtered = useMemo(() => {
    const q = search.trim().toLowerCase();
    const result = bookings.filter((b) => {
      if (statusFilter !== "ALL" && b.status !== statusFilter) return false;
      if (!q) return true;
      return (
        b.user.name?.toLowerCase().includes(q) ||
        b.vehicleModel?.toLowerCase().includes(q) ||
        b.vehiclePlate?.toLowerCase().includes(q) ||
        b.user.phone?.includes(q)
      );
    });
    result.sort((a, b) => {
      const diff = new Date(a.date).getTime() - new Date(b.date).getTime();
      return orden === "asc" ? diff : -diff;
    });
    return result;
  }, [bookings, search, statusFilter, orden]);

  // eslint-disable-next-line react-hooks/exhaustive-deps
  useMemo(() => { setPagina(1); }, [search, statusFilter]);

  const filtrosActivos = (statusFilter !== "ALL" ? 1 : 0) + (search.trim() !== "" ? 1 : 0);
  const totalPaginas   = Math.max(1, Math.ceil(filtered.length / POR_PAGINA));
  const paginados      = filtered.slice((pagina - 1) * POR_PAGINA, pagina * POR_PAGINA);

  if (bookings.length === 0) {
    return (
      <div className="text-center py-16 rounded-xl border border-dashed border-gray-200 bg-gray-50">
        <Clock className="h-10 w-10 mx-auto mb-3 text-gartify-mid opacity-50" aria-hidden="true" />
        <p className="font-semibold text-foreground">Aún no hay reservas</p>
        <p className="text-sm text-muted-foreground mt-1">Cuando recibas citas aparecerán aquí</p>
      </div>
    );
  }

  // ── Contenido del panel de filtros (reutilizado en sidebar y móvil) ──────────
  const filtrosContenido = (
    <div className="space-y-4">
      <div>
        <p className="text-xs font-semibold text-gartify-gray uppercase tracking-wide mb-2">Buscar</p>
        <div className="relative">
          <Search className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-muted-foreground pointer-events-none" />
          <Input
            placeholder="Nombre, matrícula…"
            value={search}
            onChange={(e) => setSearch(e.target.value)}
            className="pl-9 text-sm border-gray-200 focus-visible:ring-gartify-blue/30"
          />
        </div>
      </div>

      <div>
        <p className="text-xs font-semibold text-gartify-gray uppercase tracking-wide mb-2">Ordenar</p>
        <button
          onClick={() => setOrden((o) => (o === "asc" ? "desc" : "asc"))}
          className="flex items-center gap-2 w-full px-3 py-2 rounded-lg text-sm font-medium border border-gray-200 bg-white text-gartify-gray hover:bg-gray-50 transition-colors"
          aria-label="Ordenar por fecha"
        >
          {orden === "asc"
            ? <><ArrowUp className="h-3.5 w-3.5" /> Fecha: más próxima</>
            : <><ArrowDown className="h-3.5 w-3.5" /> Fecha: más reciente</>
          }
        </button>
      </div>

      <div>
        <p className="text-xs font-semibold text-gartify-gray uppercase tracking-wide mb-2">Estado</p>
        <div className="flex flex-col gap-1">
          {STATUS_TABS.map((tab) => {
            const count  = bookings.filter((b) => tab.value === "ALL" || b.status === tab.value).length;
            const active = statusFilter === tab.value;
            return (
              <button
                key={tab.value}
                onClick={() => setStatusFilter(tab.value)}
                className={`flex items-center justify-between px-3 py-2 rounded-lg text-sm font-medium transition-colors ${
                  active ? "bg-gartify-blue text-white" : "text-gartify-gray hover:bg-gray-100"
                }`}
              >
                <span>{tab.label}</span>
                <span className={`text-xs font-bold rounded-full px-2 py-0.5 leading-none ${
                  active ? "bg-white/20 text-white" : COUNT_COLOR[tab.value]
                }`}>
                  {count}
                </span>
              </button>
            );
          })}
        </div>
      </div>
    </div>
  );

  return (
    <div className="flex flex-col gap-4 lg:flex-row lg:items-start">

      {/* ── SIDEBAR DESKTOP ─────────────────────────────────────────────── */}
      <aside className="hidden lg:block lg:w-64 lg:shrink-0 lg:sticky lg:top-24">
        <div className="bg-blue-50 border border-gartify-blue/40 rounded-xl shadow-none p-4">
          <div className="flex items-center gap-2 text-gartify-blue mb-4 pb-3 border-b border-gray-100">
            <SlidersHorizontal className="h-4 w-4 shrink-0" />
            <span className="text-sm font-semibold">Filtros</span>
            {filtrosActivos > 0 && (
              <span className="flex h-4 min-w-4 items-center justify-center rounded-full bg-gartify-hero px-1 text-[10px] font-bold text-white leading-none">
                {filtrosActivos}
              </span>
            )}
          </div>
          {filtrosContenido}
        </div>
      </aside>

      {/* ── COLUMNA DERECHA: panel móvil + lista ────────────────────────── */}
      <div className="flex-1 min-w-0 space-y-3">

        {/* Panel colapsable — solo móvil */}
        <div className="lg:hidden bg-blue-50 border border-gartify-blue/40 rounded-xl shadow-none overflow-hidden">
          <button
            type="button"
            className="w-full flex items-center justify-between px-4 py-3 border-b border-gray-100"
            onClick={() => setFiltrosMobileAbiertos((v) => !v)}
            aria-expanded={filtrosMobileAbiertos}
          >
            <div className="flex items-center gap-2 text-gartify-blue">
              <SlidersHorizontal className="h-4 w-4 shrink-0" />
              <span className="text-sm font-semibold">Filtros</span>
              {filtrosActivos > 0 && (
                <span className="flex h-4 min-w-4 items-center justify-center rounded-full bg-gartify-hero px-1 text-[10px] font-bold text-white leading-none">
                  {filtrosActivos}
                </span>
              )}
            </div>
            <ChevronDown className={`h-4 w-4 text-gartify-gray transition-transform ${filtrosMobileAbiertos ? "rotate-180" : ""}`} />
          </button>
          {filtrosMobileAbiertos && (
            <div className="px-4 py-4 space-y-4">
              <div>
                <p className="text-xs font-semibold text-gartify-gray uppercase tracking-wide mb-2">Buscar</p>
                <div className="relative">
                  <Search className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-muted-foreground pointer-events-none" />
                  <Input
                    placeholder="Nombre, matrícula…"
                    value={search}
                    onChange={(e) => setSearch(e.target.value)}
                    className="pl-9 text-sm border-gray-200 focus-visible:ring-gartify-blue/30"
                  />
                </div>
              </div>
              <div>
                <p className="text-xs font-semibold text-gartify-gray uppercase tracking-wide mb-2">Ordenar</p>
                <button
                  onClick={() => setOrden((o) => (o === "asc" ? "desc" : "asc"))}
                  className="flex items-center gap-2 w-full px-3 py-2 rounded-lg text-sm font-medium border border-gray-200 bg-white text-gartify-gray hover:bg-gray-50 transition-colors"
                >
                  {orden === "asc"
                    ? <><ArrowUp className="h-3.5 w-3.5" /> Fecha: más próxima</>
                    : <><ArrowDown className="h-3.5 w-3.5" /> Fecha: más reciente</>
                  }
                </button>
              </div>
              <div>
                <p className="text-xs font-semibold text-gartify-gray uppercase tracking-wide mb-2">Estado</p>
                <div className="grid grid-cols-2 gap-1.5">
                  {STATUS_TABS.map((tab) => {
                    const count  = bookings.filter((b) => tab.value === "ALL" || b.status === tab.value).length;
                    const active = statusFilter === tab.value;
                    return (
                      <button
                        key={tab.value}
                        onClick={() => setStatusFilter(tab.value)}
                        className={`flex items-center justify-between gap-1 px-3 py-2 rounded-lg text-xs font-semibold transition-colors ${
                          active ? "bg-gartify-blue text-white" : "bg-gray-100 text-gartify-gray hover:bg-gray-200"
                        }`}
                      >
                        <span className="truncate">{tab.label}</span>
                        <span className={`shrink-0 text-[10px] font-bold rounded-full px-1.5 py-0.5 leading-none ${
                          active ? "bg-white/20 text-white" : COUNT_COLOR[tab.value]
                        }`}>{count}</span>
                      </button>
                    );
                  })}
                </div>
              </div>
            </div>
          )}
        </div>

        {/* ── Resultados ────────────────────────────────────────────────── */}
        {filtered.length === 0 ? (
          <p className="text-center py-10 text-sm text-muted-foreground">
            No hay citas que coincidan con los filtros.
          </p>
        ) : (
          <>
            <div className="space-y-2">
              {paginados.map((b) => (
                <BookingCard key={b.id} b={b} garageId={garageId} />
              ))}
            </div>

            {totalPaginas > 1 && (
              <div className="flex items-center justify-between pt-2 text-sm text-muted-foreground">
                <span>
                  {(pagina - 1) * POR_PAGINA + 1}–{Math.min(pagina * POR_PAGINA, filtered.length)} de {filtered.length}
                </span>
                <div className="flex items-center gap-1">
                  <button
                    onClick={() => setPagina((p) => Math.max(1, p - 1))}
                    disabled={pagina === 1}
                    className="rounded p-1.5 hover:bg-gray-100 disabled:opacity-40 disabled:pointer-events-none transition-colors"
                    aria-label="Página anterior"
                  >
                    <ChevronLeft className="h-4 w-4" />
                  </button>
                  {Array.from({ length: totalPaginas }, (_, i) => i + 1).map((n) => (
                    <button
                      key={n}
                      onClick={() => setPagina(n)}
                      className={`min-w-[32px] h-8 rounded text-xs font-semibold transition-colors ${
                        n === pagina ? "bg-gartify-blue text-white" : "hover:bg-gray-100 text-muted-foreground"
                      }`}
                    >
                      {n}
                    </button>
                  ))}
                  <button
                    onClick={() => setPagina((p) => Math.min(totalPaginas, p + 1))}
                    disabled={pagina === totalPaginas}
                    className="rounded p-1.5 hover:bg-gray-100 disabled:opacity-40 disabled:pointer-events-none transition-colors"
                    aria-label="Página siguiente"
                  >
                    <ChevronRight className="h-4 w-4" />
                  </button>
                </div>
              </div>
            )}
          </>
        )}
      </div>
    </div>
  );
}

// ── BookingCard ──────────────────────────────────────────────────────────────

function BookingCard({ b, garageId }: { b: GarageBookingItem; garageId: string }) {
  const isPast        = b.status === "COMPLETED" || b.status === "CANCELLED";
  const bandClasses   = STATUS_BAND[b.status] ?? "bg-gray-50 text-gray-500 border-gray-200";
  const codigoReserva = b.code ?? b.id.slice(-8).toUpperCase();
  const fechaFormateada = formatDateTime(b.date instanceof Date ? b.date : new Date(b.date));

  return (
    <article className={`bg-white rounded-xl border border-gray-200 shadow-sm hover:shadow-md transition-shadow overflow-hidden ${isPast ? "opacity-70" : ""}`}>

      {/* ── BANDA DE ESTADO — solo móvil ──────────────────────────────── */}
      <div className={`sm:hidden flex items-center justify-between gap-2 px-4 py-2 border-b ${bandClasses}`}>
        <span className="text-xs font-bold uppercase tracking-wide">
          {BOOKING_STATUS_LABELS[b.status] ?? b.status}
        </span>
        <span className="text-xs opacity-75">{fechaFormateada}</span>
      </div>

      {/* ── CUERPO MÓVIL ──────────────────────────────────────────────── */}
      <div className="sm:hidden flex flex-col gap-2 px-4 py-3">
        <div className="flex items-center justify-between gap-2">
          <span className="font-bold text-gartify-blue text-base leading-tight">{b.user.name ?? "Cliente"}</span>
          {b.user.phone && (
            <a href={`tel:${b.user.phone}`} className="text-xs text-muted-foreground hover:text-gartify-blue transition-colors">
              {b.user.phone}
            </a>
          )}
        </div>
        <p className="text-sm text-gartify-gray font-medium">
          <Wrench className="inline h-3.5 w-3.5 mr-1 text-gartify-mid" aria-hidden="true" />
          {SERVICE_LABELS[b.service.type] ?? b.service.name}
          <span className="text-gray-400 mx-1">·</span>
          {b.service.duration} min
        </p>
        {(b.vehicleModel || b.vehiclePlate) && (
          <p className="text-xs text-muted-foreground">
            {b.vehicleModel}
            {b.vehicleModel && b.vehiclePlate && " · "}
            {b.vehiclePlate && <span className="font-mono font-semibold text-gartify-blue">{b.vehiclePlate}</span>}
          </p>
        )}
        {b.notes && <p className="text-xs text-muted-foreground italic">{b.notes}</p>}
        <div className="flex items-center justify-between pt-2 border-t border-gray-100">
          <span className="text-xl font-extrabold text-gartify-orange">{formatPrice(b.totalPrice)}</span>
          <BookingStatusUpdater bookingId={b.id} currentStatus={b.status} garageId={garageId} />
        </div>
        {b.status === "COMPLETED" && (
          <SelloReservaButton
            bookingId={b.id}
            serviceName={b.service.name}
            vehiclePlate={b.vehiclePlate}
            vehicleModel={b.vehicleModel}
            hasRecord={!!b.serviceRecord}
          />
        )}
        <span className="text-[11px] font-mono text-muted-foreground">{codigoReserva}</span>
      </div>

      {/* ── CUERPO DESKTOP ────────────────────────────────────────────── */}
      <div className="hidden sm:flex items-center gap-4 px-4 py-3">
        {/* Avatar */}
        <div className={`h-9 w-9 rounded-full flex items-center justify-center shrink-0 text-white text-xs font-bold ${isPast ? "bg-gray-400" : "bg-gradient-to-br from-gartify-hero to-gartify-mid"}`}>
          {(b.user.name ?? "C").split(" ").slice(0, 2).map((w) => w[0]).join("").toUpperCase()}
        </div>

        {/* Info principal */}
        <div className="flex-1 min-w-0">
          <div className="flex items-center gap-3">
            <span className="font-bold text-gartify-blue text-sm">{b.user.name ?? "Cliente"}</span>
            {b.user.phone && (
              <a href={`tel:${b.user.phone}`} className="text-xs text-muted-foreground hover:text-gartify-blue transition-colors">
                <Phone className="inline h-3 w-3 mr-0.5" aria-hidden="true" />{b.user.phone}
              </a>
            )}
          </div>
          <p className="text-sm text-gartify-gray mt-0.5">
            <Wrench className="inline h-3.5 w-3.5 mr-1 text-gartify-mid" aria-hidden="true" />
            {SERVICE_LABELS[b.service.type] ?? b.service.name}
          </p>
          <p className="text-xs text-muted-foreground mt-0.5 flex flex-wrap gap-x-2">
            <span>{fechaFormateada}</span>
            <span className="text-gray-300">·</span>
            <span>{b.service.duration} min</span>
            {b.vehicleModel && <><span className="text-gray-300">·</span><span>{b.vehicleModel}</span></>}
            {b.vehiclePlate && <span className="font-mono font-semibold text-gartify-blue">{b.vehiclePlate}</span>}
          </p>
          {b.notes && <p className="text-xs text-muted-foreground italic mt-0.5">{b.notes}</p>}
          <span className="text-[11px] font-mono text-muted-foreground">{codigoReserva}</span>
        </div>

        {/* Derecha: precio + estado + sello */}
        <div className="flex flex-col items-end gap-1.5 shrink-0">
          <BookingStatusUpdater bookingId={b.id} currentStatus={b.status} garageId={garageId} />
          <span className="text-lg font-extrabold text-gartify-orange">{formatPrice(b.totalPrice)}</span>
            {/* Sello de revisión — solo para reservas completadas */}
          {b.status === "COMPLETED" && (
            <SelloReservaButton
              bookingId={b.id}
              serviceName={b.service.name}
              vehiclePlate={b.vehiclePlate}
              vehicleModel={b.vehicleModel}
              hasRecord={!!b.serviceRecord}
            />
          )}
        </div>
      </div>
    </article>
  );
}
