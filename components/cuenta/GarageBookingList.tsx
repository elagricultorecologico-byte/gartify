"use client";
import { useState, useMemo } from "react";
import { Clock, Phone, Wrench, ChevronLeft, ChevronRight } from "lucide-react";
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

export const STATUS_TABS = [
  { value: "ALL",       label: "Todas" },
  { value: "PENDING",   label: "Pendientes" },
  { value: "PROPOSED",  label: "Propuestas" },
  { value: "CONFIRMED", label: "Confirmadas" },
  { value: "COMPLETED", label: "Completadas" },
  { value: "CANCELLED", label: "Canceladas" },
] as const;

export const STATUS_BAND: Record<string, string> = {
  PENDING:   "bg-yellow-50  text-yellow-700  border-yellow-200",
  PROPOSED:  "bg-purple-50  text-purple-700  border-purple-200",
  CONFIRMED: "bg-green-50   text-green-700   border-green-200",
  COMPLETED: "bg-slate-50   text-slate-500   border-slate-200",
  CANCELLED: "bg-red-50     text-red-500     border-red-200",
};

const COUNT_COLOR = "bg-gray-100 text-gray-500";
const POR_PAGINA  = 10;

// ── Lista de reservas (sin sidebar propio — filtros vienen del padre) ─────────

export function GarageBookingList({
  bookings,
  garageId,
  search,
  statusFilter,
  orden,
}: {
  bookings: GarageBookingItem[];
  garageId: string;
  search: string;
  statusFilter: string;
  orden: "asc" | "desc";
}) {
  const [pagina, setPagina] = useState(1);

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

  const totalPaginas = Math.max(1, Math.ceil(filtered.length / POR_PAGINA));
  const paginados    = filtered.slice((pagina - 1) * POR_PAGINA, pagina * POR_PAGINA);

  if (bookings.length === 0) {
    return (
      <div className="text-center py-16 border border-dashed border-gray-200 bg-gray-50">
        <Clock className="h-10 w-10 mx-auto mb-3 text-gartify-mid opacity-50" aria-hidden="true" />
        <p className="font-semibold text-foreground">Aún no hay reservas</p>
        <p className="text-sm text-muted-foreground mt-1">Cuando recibas citas aparecerán aquí</p>
      </div>
    );
  }

  return (
    <div className="space-y-3">
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
                  className="p-1.5 hover:bg-gray-100 disabled:opacity-40 disabled:pointer-events-none transition-colors"
                  aria-label="Página anterior"
                >
                  <ChevronLeft className="h-4 w-4" />
                </button>
                {Array.from({ length: totalPaginas }, (_, i) => i + 1).map((n) => (
                  <button
                    key={n}
                    onClick={() => setPagina(n)}
                    className={`min-w-[32px] h-8 text-xs font-semibold transition-colors ${
                      n === pagina ? "bg-gartify-blue text-white" : "hover:bg-gray-100 text-muted-foreground"
                    }`}
                  >
                    {n}
                  </button>
                ))}
                <button
                  onClick={() => setPagina((p) => Math.min(totalPaginas, p + 1))}
                  disabled={pagina === totalPaginas}
                  className="p-1.5 hover:bg-gray-100 disabled:opacity-40 disabled:pointer-events-none transition-colors"
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
  );
}

// ── Panel de filtros (exportado para usarlo en GarageBookingPoller) ────────────

export function GarageBookingFilterContent({
  bookings,
  search, setSearch,
  statusFilter, setStatusFilter,
  orden, setOrden,
}: {
  bookings: GarageBookingItem[];
  search: string;
  setSearch: (v: string) => void;
  statusFilter: string;
  setStatusFilter: (v: string) => void;
  orden: "asc" | "desc";
  setOrden: (fn: (o: "asc" | "desc") => "asc" | "desc") => void;
}) {
  return (
    <div className="space-y-4">
      <div>
        <p className="text-xs font-semibold text-gartify-gray uppercase tracking-wide mb-2">Buscar</p>
        <div className="relative">
          <svg className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-muted-foreground pointer-events-none" fill="none" viewBox="0 0 24 24" stroke="currentColor" strokeWidth={2}><circle cx="11" cy="11" r="8"/><path d="m21 21-4.35-4.35"/></svg>
          <input
            type="text"
            placeholder="Nombre, matrícula…"
            value={search}
            onChange={(e) => setSearch(e.target.value)}
            className="w-full pl-9 pr-3 py-2 text-sm border border-gray-200 bg-white focus:outline-none focus:ring-2 focus:ring-gartify-blue/30 placeholder:text-gartify-gray"
          />
        </div>
      </div>

      <div>
        <p className="text-xs font-semibold text-gartify-gray uppercase tracking-wide mb-2">Ordenar</p>
        <button
          onClick={() => setOrden((o) => (o === "asc" ? "desc" : "asc"))}
          className="flex items-center gap-2 w-full px-3 py-2 text-sm font-normal border border-gray-200 bg-white text-gartify-gray hover:bg-gray-50 transition-colors"
        >
          {orden === "asc"
            ? <><span>↑</span> Fecha: más próxima</>
            : <><span>↓</span> Fecha: más reciente</>
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
                className={`flex items-center justify-between px-3 py-2 text-sm font-medium transition-colors ${
                  active ? "bg-gartify-blue text-white" : "text-gartify-gray hover:bg-gray-100"
                }`}
              >
                <span>{tab.label}</span>
                <span className={`text-xs font-bold px-2 py-0.5 leading-none ${
                  active ? "bg-white/20 text-white" : COUNT_COLOR
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
}

// ── BookingCard ───────────────────────────────────────────────────────────────

function BookingCard({ b, garageId }: { b: GarageBookingItem; garageId: string }) {
  const isPast          = b.status === "COMPLETED" || b.status === "CANCELLED";
  const bandClasses     = STATUS_BAND[b.status] ?? "bg-gray-50 text-gray-500 border-gray-200";
  const codigoReserva   = b.code ?? b.id.slice(-8).toUpperCase();
  const fechaFormateada = formatDateTime(b.date instanceof Date ? b.date : new Date(b.date));

  return (
    <article className={`bg-white border border-gartify-blue/20 hover:border-gartify-blue/40 transition-colors overflow-hidden ${isPast ? "opacity-70" : ""}`}>

      {/* ── BANDA DE ESTADO — solo móvil ──────────────────────────────── */}
      <div className={`sm:hidden flex items-center justify-between gap-2 px-4 py-2 border-b ${bandClasses}`}>
        <span className="text-xs font-bold uppercase tracking-wide">
          {BOOKING_STATUS_LABELS[b.status] ?? b.status}
        </span>
        <span className="text-[11px] font-mono opacity-60">{codigoReserva}</span>
      </div>

      {/* ── CUERPO MÓVIL ──────────────────────────────────────────────── */}
      <div className="sm:hidden flex flex-col gap-2 px-4 py-3">
        <div className="flex items-center justify-between gap-2">
          <span className="font-bold text-gartify-blue text-base leading-tight">{b.user.name ?? "Cliente"}</span>
          {b.user.phone && (
            <a href={`tel:${b.user.phone}`} className="text-xs text-gray-500 hover:text-gartify-blue transition-colors flex items-center gap-0.5">
              <Phone className="inline h-3 w-3" aria-hidden="true" />{b.user.phone}
            </a>
          )}
        </div>
        <p className="text-xs text-gray-500">{fechaFormateada}</p>
        <p className="text-sm text-gray-700 font-medium">
          <Wrench className="inline h-3.5 w-3.5 mr-1 text-gray-400" aria-hidden="true" />
          {SERVICE_LABELS[b.service.type] ?? b.service.name}
          <span className="text-gray-400 font-normal ml-1">({b.service.duration} min)</span>
        </p>
        {(b.vehicleModel || b.vehiclePlate) && (
          <p className="text-xs text-gray-500">
            {b.vehicleModel}
            {b.vehicleModel && b.vehiclePlate && " · "}
            {b.vehiclePlate && <span className="font-mono font-semibold text-gartify-blue">{b.vehiclePlate}</span>}
          </p>
        )}
        {b.notes && <p className="text-xs text-gray-400 italic">{b.notes}</p>}
        <div className="flex items-center pt-2 border-t border-gray-100">
          <span className="text-xl font-extrabold text-gartify-orange">{formatPrice(b.totalPrice)}</span>
        </div>
        <BookingStatusUpdater bookingId={b.id} currentStatus={b.status} garageId={garageId} variant="buttons" />
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

      {/* ── CUERPO DESKTOP ────────────────────────────────────────────── */}
      <div className="hidden sm:block px-4 py-3 space-y-2">

        {/* Fila 1: cliente + estado */}
        <div className="flex items-center justify-between gap-4">
          <div className="flex items-center gap-2.5 min-w-0">
            <div className={`h-8 w-8 flex items-center justify-center shrink-0 text-white text-xs font-bold ${isPast ? "bg-gray-400" : "bg-gartify-blue"}`}>
              {(b.user.name ?? "C").split(" ").slice(0, 2).map((w) => w[0]).join("").toUpperCase()}
            </div>
            <span className="font-bold text-gartify-blue text-sm truncate">{b.user.name ?? "Cliente"}</span>
            {b.user.phone && (
              <a href={`tel:${b.user.phone}`} className="text-xs text-gray-500 hover:text-gartify-blue transition-colors flex items-center gap-0.5 shrink-0">
                <Phone className="h-3 w-3" aria-hidden="true" />{b.user.phone}
              </a>
            )}
          </div>
          <BookingStatusUpdater bookingId={b.id} currentStatus={b.status} garageId={garageId} />
        </div>

        {/* Fila 2: servicio + precio */}
        <div className="flex items-center justify-between gap-4">
          <p className="text-sm text-gray-700 font-medium flex items-center gap-1 min-w-0">
            <Wrench className="h-3.5 w-3.5 text-gray-400 shrink-0" aria-hidden="true" />
            <span className="truncate">{SERVICE_LABELS[b.service.type] ?? b.service.name}</span>
            <span className="text-gray-400 font-normal shrink-0">({b.service.duration} min)</span>
          </p>
          <span className="text-lg font-extrabold text-gartify-orange shrink-0">{formatPrice(b.totalPrice)}</span>
        </div>

        {/* Fila 3: metadatos */}
        {(b.vehicleModel || b.vehiclePlate) && (
          <p className="text-xs text-gray-500 flex flex-wrap items-center gap-x-1.5">
            {b.vehicleModel && <span>{b.vehicleModel}</span>}
            {b.vehiclePlate && <><span className="text-gray-300">·</span><span className="font-mono font-semibold text-gartify-blue">{b.vehiclePlate}</span></>}
          </p>
        )}

        {/* Fila 4: código + fecha + sello */}
        <div className="flex items-center justify-between gap-4 pt-1 border-t border-gray-100">
          <div className="flex items-center gap-3 min-w-0">
            <span className="text-[11px] font-mono text-gray-400 shrink-0">{codigoReserva}</span>
            {b.notes && <p className="text-xs text-gray-400 italic truncate">{b.notes}</p>}
          </div>
          <div className="flex items-center gap-3 shrink-0">
            <span className="text-xs text-gray-500">{fechaFormateada}</span>
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
      </div>
    </article>
  );
}
