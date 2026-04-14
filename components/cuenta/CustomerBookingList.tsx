"use client";
import { useState, useMemo } from "react";
import Link from "next/link";
import {
  Calendar, MapPin, Car, Wrench, ChevronRight, Star, Clock,
  Search, ArrowUp, ArrowDown, ChevronDown, ChevronLeft, SlidersHorizontal,
} from "lucide-react";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { CancelBookingButton } from "@/components/cuenta/CancelBookingButton";
import { AcceptProposedBooking } from "@/components/cuenta/AcceptProposedBooking";
import {
  formatPrice, formatDateTime,
  BOOKING_STATUS_LABELS, SERVICE_LABELS,
} from "@/lib/utils";

// ── Tipos ────────────────────────────────────────────────────────────────────

export type CustomerBookingItem = {
  id: string;
  status: string;
  date: Date | string;
  totalPrice: number;
  vehicleModel: string | null;
  vehiclePlate: string | null;
  createdAt: Date | string;
  garage: { name: string; city: string };
  service: { type: string; name: string };
  review: { id: string } | null;
};

// ── Constantes ───────────────────────────────────────────────────────────────

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

// Colores de la banda de estado superior de cada card
const STATUS_BAND: Record<string, string> = {
  PENDING:   "bg-yellow-50  text-yellow-700  border-yellow-200",
  PROPOSED:  "bg-purple-50  text-purple-700  border-purple-200",
  CONFIRMED: "bg-green-50   text-green-700   border-green-200",
  COMPLETED: "bg-slate-50   text-slate-500   border-slate-200",
  CANCELLED: "bg-red-50     text-red-500     border-red-200",
};

const POR_PAGINA = 10;

// ── Componente principal ─────────────────────────────────────────────────────

export function CustomerBookingList({ bookings }: { bookings: CustomerBookingItem[] }) {
  const [search, setSearch]               = useState("");
  const [statusFilter, setStatusFilter]   = useState<string>("ALL");
  const [orden, setOrden]                 = useState<"asc" | "desc">("asc");
  const [pagina, setPagina]               = useState(1);
  const [filtrosAbiertos, setFiltrosAbiertos] = useState(false);

  // Filtrado + ordenación
  const filtered = useMemo(() => {
    const q = search.trim().toLowerCase();
    const result = bookings.filter((b) => {
      if (statusFilter !== "ALL" && b.status !== statusFilter) return false;
      if (!q) return true;
      return (
        b.garage.name.toLowerCase().includes(q) ||
        b.vehicleModel?.toLowerCase().includes(q) ||
        b.vehiclePlate?.toLowerCase().includes(q)
      );
    });
    result.sort((a, b) => {
      const diff = new Date(a.date).getTime() - new Date(b.date).getTime();
      return orden === "asc" ? diff : -diff;
    });
    return result;
  }, [bookings, search, statusFilter, orden]);

  // Resetear a página 1 cuando cambia el filtro o la búsqueda
  // eslint-disable-next-line react-hooks/exhaustive-deps
  useMemo(() => { setPagina(1); }, [search, statusFilter]);

  // Número de filtros activos para el badge de la cabecera
  const filtrosActivos = (statusFilter !== "ALL" ? 1 : 0) + (search.trim() !== "" ? 1 : 0);

  const totalPaginas = Math.max(1, Math.ceil(filtered.length / POR_PAGINA));
  const paginados    = filtered.slice((pagina - 1) * POR_PAGINA, pagina * POR_PAGINA);

  return (
    <div className="space-y-3">
      {/* ── Panel de filtros colapsable ─────────────────────────────────── */}
      <div className="bg-white border border-gray-200 rounded-xl shadow-sm overflow-hidden">
        {/* Cabecera — siempre visible, actúa como toggle en móvil */}
        <button
          type="button"
          className="w-full flex items-center justify-between px-4 py-3 border-b border-gray-100"
          onClick={() => setFiltrosAbiertos((v) => !v)}
          aria-expanded={filtrosAbiertos}
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
          {/* La flecha rota solo en móvil; en desktop el panel está siempre abierto */}
          <ChevronDown
            className={`h-4 w-4 text-gartify-gray transition-transform lg:hidden ${
              filtrosAbiertos ? "rotate-180" : ""
            }`}
          />
        </button>

        {/* Contenido colapsable: oculto en móvil cuando cerrado, siempre visible en lg */}
        <div className={`${!filtrosAbiertos ? "hidden lg:block" : ""} px-4 py-3 space-y-3`}>
          {/* Buscador + botón de orden */}
          <div className="flex items-center gap-2">
            <div className="relative flex-1">
              <Search className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-muted-foreground pointer-events-none" />
              <Input
                placeholder="Taller, matrícula…"
                value={search}
                onChange={(e) => setSearch(e.target.value)}
                className="pl-9 text-sm border-gray-200 focus-visible:ring-gartify-blue/30"
              />
            </div>
            <button
              onClick={() => setOrden((o) => (o === "asc" ? "desc" : "asc"))}
              className="flex items-center gap-1 px-3 py-2 rounded-lg text-xs font-semibold border border-gray-200 bg-white text-gartify-gray hover:bg-gray-50 transition-colors shrink-0"
              aria-label="Ordenar por fecha"
            >
              {orden === "asc" ? <ArrowUp className="h-3.5 w-3.5" /> : <ArrowDown className="h-3.5 w-3.5" />}
              <span className="hidden sm:inline ml-1">Fecha</span>
            </button>
          </div>

          {/* Tabs de estado — grid 3x2 en móvil, fila en desktop */}
          <div className="grid grid-cols-3 sm:flex sm:flex-wrap gap-1.5">
            {STATUS_TABS.map((tab) => {
              const count  = bookings.filter((b) => tab.value === "ALL" || b.status === tab.value).length;
              const active = statusFilter === tab.value;
              return (
                <button
                  key={tab.value}
                  onClick={() => setStatusFilter(tab.value)}
                  className={`flex items-center justify-center gap-1.5 px-2 py-2 rounded-lg text-xs font-semibold transition-colors ${
                    active
                      ? "bg-gartify-blue text-white"
                      : "bg-gray-100 text-gartify-gray hover:bg-gray-200"
                  }`}
                >
                  {tab.label}
                  <span
                    className={`text-[10px] font-bold rounded-full px-1.5 py-0.5 leading-none ${
                      active ? "bg-white/20 text-white" : COUNT_COLOR[tab.value]
                    }`}
                  >
                    {count}
                  </span>
                </button>
              );
            })}
          </div>
        </div>
      </div>

      {/* ── Resultados ──────────────────────────────────────────────────── */}
      {filtered.length === 0 ? (
        <p className="text-center py-10 text-sm text-muted-foreground">
          No hay citas que coincidan con los filtros.
        </p>
      ) : (
        <>
          <div className="space-y-3">
            {paginados.map((b) => (
              <BookingCard key={b.id} b={b} />
            ))}
          </div>

          {/* Paginador */}
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
                      n === pagina
                        ? "bg-gartify-blue text-white"
                        : "hover:bg-gray-100 text-muted-foreground"
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
  );
}

// ── BookingCard ──────────────────────────────────────────────────────────────

function BookingCard({ b }: { b: CustomerBookingItem }) {
  const isPast        = b.status === "COMPLETED" || b.status === "CANCELLED";
  const bandClasses   = STATUS_BAND[b.status] ?? "bg-gray-50 text-gray-500 border-gray-200";
  const codigoReserva = b.id.slice(-8).toUpperCase();
  const fechaFormateada = formatDateTime(b.date instanceof Date ? b.date : new Date(b.date));

  // Iniciales del taller para el avatar
  const initials = b.garage.name
    .split(" ")
    .slice(0, 2)
    .map((w) => w[0])
    .join("")
    .toUpperCase();

  // Botones de acción — reutilizados en móvil y desktop
  const accionesBotones = (
    <>
      {b.status === "PROPOSED" && (
        <AcceptProposedBooking bookingId={b.id} />
      )}
      {(b.status === "PENDING" || b.status === "CONFIRMED") && (
        <CancelBookingButton bookingId={b.id} />
      )}
      {b.status === "COMPLETED" && !b.review && (
        <Link href={`/reserva/${b.id}/resena`}>
          <Button
            variant="ghost"
            size="sm"
            className="text-yellow-600 hover:text-yellow-700 hover:bg-yellow-50 gap-1 text-xs font-semibold"
          >
            <Star className="h-3.5 w-3.5 fill-yellow-400 text-yellow-400" aria-hidden="true" />
            Valorar
          </Button>
        </Link>
      )}
      <Link href={`/reserva/${b.id}`}>
        <Button
          variant="ghost"
          size="sm"
          className="text-gartify-blue hover:text-gartify-blue hover:bg-blue-50 gap-1 text-xs font-semibold"
        >
          Ver detalle
          <ChevronRight className="h-3.5 w-3.5" aria-hidden="true" />
        </Button>
      </Link>
    </>
  );

  return (
    <article
      className={`bg-white rounded-xl border shadow-sm hover:shadow-md transition-all overflow-hidden ${
        isPast
          ? "opacity-75 border-gray-100"
          : "border-gray-200 hover:border-gartify-blue/30"
      }`}
    >
      {/* ── BANDA DE ESTADO — solo móvil ─────────────────────────────── */}
      <div className={`sm:hidden flex items-center justify-between gap-2 px-4 py-2 border-b ${bandClasses}`}>
        <span className="text-xs font-bold uppercase tracking-wide">
          {BOOKING_STATUS_LABELS[b.status] ?? b.status}
        </span>
        <span className="flex items-center gap-1 text-xs opacity-75">
          <Clock className="h-3 w-3" aria-hidden="true" />
          {fechaFormateada}
        </span>
      </div>

      {/* ── CUERPO MÓVIL ─────────────────────────────────────────────── */}
      <div className="sm:hidden flex flex-col gap-2.5 px-4 py-3">
        {/* Nombre del taller */}
        <span className="font-bold text-gartify-blue text-base leading-tight">
          {b.garage.name}
        </span>

        {/* Chip de servicio */}
        <div className="flex flex-wrap items-center gap-1.5">
          <span className="inline-flex items-center gap-1 rounded-full bg-blue-50 text-gartify-hero text-xs px-2.5 py-0.5 font-medium border border-blue-100">
            <Wrench className="h-3 w-3" aria-hidden="true" />
            {SERVICE_LABELS[b.service.type] ?? b.service.name}
          </span>
        </div>

        {/* Fila de metadatos: fecha, ciudad, vehículo */}
        <div className="flex flex-wrap items-center gap-x-3 gap-y-1 text-xs text-muted-foreground">
          <span className="flex items-center gap-1">
            <Calendar className="h-3.5 w-3.5 text-gartify-mid" aria-hidden="true" />
            {fechaFormateada}
          </span>
          <span className="flex items-center gap-1">
            <MapPin className="h-3.5 w-3.5 text-gartify-mid" aria-hidden="true" />
            {b.garage.city}
          </span>
          {b.vehicleModel && (
            <span className="flex items-center gap-1">
              <Car className="h-3.5 w-3.5 text-gartify-mid" aria-hidden="true" />
              {b.vehicleModel}
              {b.vehiclePlate && (
                <span className="font-mono font-semibold tracking-wider text-gartify-blue ml-1">
                  {b.vehiclePlate}
                </span>
              )}
            </span>
          )}
        </div>

        {/* Precio centrado grande */}
        <div className="flex flex-col items-center pt-2 border-t border-gray-100">
          <span className="text-[11px] text-muted-foreground uppercase tracking-wide font-medium">
            Total
          </span>
          <span className="text-2xl font-extrabold text-gartify-orange leading-none">
            {formatPrice(b.totalPrice)}
          </span>
        </div>

        {/* Botones de acción centrados */}
        <div className="flex justify-center flex-wrap gap-1">
          {accionesBotones}
        </div>

        {/* Código de reserva centrado al final */}
        <div className="flex justify-center pt-1">
          <span className="text-[11px] font-mono text-muted-foreground">
            {codigoReserva}
          </span>
        </div>
      </div>

      {/* ── CUERPO DESKTOP ───────────────────────────────────────────── */}
      <div className="hidden sm:block px-4 py-3 relative">
        {/* Zona de acciones absolutamente posicionada arriba a la derecha */}
        <div className="absolute top-3 right-4 flex items-center gap-1">
          {accionesBotones}
        </div>

        <div className="flex items-start gap-3">
          {/* Avatar con iniciales del taller */}
          <div
            className={`h-9 w-9 rounded-full flex items-center justify-center shrink-0 text-white text-xs font-bold ${
              isPast
                ? "bg-gray-400"
                : "bg-gradient-to-br from-gartify-hero to-gartify-mid"
            }`}
            aria-hidden="true"
          >
            {initials}
          </div>

          <div className="flex-1 min-w-0">
            {/* Contenido con padding derecho para no solaparse con los botones */}
            <div className="pr-44">
              {/* Nombre del taller */}
              <span className="font-bold text-gartify-blue text-sm">
                {b.garage.name}
              </span>

              {/* Chip de servicio */}
              <div className="flex items-center gap-2 mt-1.5">
                <span className="inline-flex items-center gap-1 rounded-full bg-blue-50 text-gartify-hero px-2 py-0.5 font-medium border border-blue-100 text-xs">
                  <Wrench className="h-3 w-3" aria-hidden="true" />
                  {SERVICE_LABELS[b.service.type] ?? b.service.name}
                </span>
              </div>

              {/* Fila de metadatos: fecha, ciudad, vehículo */}
              <div className="flex flex-wrap items-center gap-x-3 gap-y-0.5 mt-1 text-xs text-muted-foreground">
                <span className="flex items-center gap-1">
                  <Calendar className="h-3 w-3 text-gartify-mid" aria-hidden="true" />
                  {fechaFormateada}
                </span>
                <span className="flex items-center gap-1">
                  <MapPin className="h-3 w-3 text-gartify-mid" aria-hidden="true" />
                  {b.garage.city}
                </span>
                {b.vehicleModel && (
                  <span className="flex items-center gap-1">
                    <Car className="h-3 w-3 text-gartify-mid" aria-hidden="true" />
                    {b.vehicleModel}
                  </span>
                )}
                {b.vehiclePlate && (
                  <span className="font-mono font-semibold tracking-wider text-gartify-blue">
                    {b.vehiclePlate}
                  </span>
                )}
              </div>
            </div>

            {/* Fila inferior: precio izquierda, código reserva derecha */}
            <div className="flex items-center justify-between mt-1">
              <span className="font-bold text-gartify-orange text-sm">
                {formatPrice(b.totalPrice)}
              </span>
              <span className="text-xs font-mono text-muted-foreground">
                {codigoReserva}
              </span>
            </div>
          </div>
        </div>
      </div>
    </article>
  );
}
