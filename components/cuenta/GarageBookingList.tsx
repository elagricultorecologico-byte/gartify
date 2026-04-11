"use client";
import { useState, useMemo } from "react";
import { Car, Clock, FileText, Hash, Phone, Search, Wrench, ChevronLeft, ChevronRight, ArrowUp, ArrowDown } from "lucide-react";
import { Input } from "@/components/ui/input";
import { BookingStatusUpdater } from "@/components/cuenta/BookingStatusUpdater";
import { formatPrice, formatDateTime, SERVICE_LABELS } from "@/lib/utils";

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
};

const STATUS_TABS = [
  { value: "ALL",       label: "Todas" },
  { value: "PENDING",   label: "Pendientes" },
  { value: "PROPOSED",  label: "Propuestas" },
  { value: "CONFIRMED", label: "Confirmadas" },
  { value: "COMPLETED", label: "Completadas" },
  { value: "CANCELLED", label: "Canceladas" },
] as const;

const POR_PAGINA = 10;

export function GarageBookingList({ bookings, garageId }: { bookings: GarageBookingItem[]; garageId: string }) {
  const [search, setSearch] = useState("");
  const [statusFilter, setStatusFilter] = useState<string>("PENDING");
  const [orden, setOrden] = useState<"asc" | "desc">("asc");
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

  // Resetear a página 1 cuando cambia el filtro o búsqueda
  // eslint-disable-next-line react-hooks/exhaustive-deps
  useMemo(() => { setPagina(1); }, [search, statusFilter]);

  const totalPaginas = Math.max(1, Math.ceil(filtered.length / POR_PAGINA));
  const paginados = filtered.slice((pagina - 1) * POR_PAGINA, pagina * POR_PAGINA);

  if (bookings.length === 0) {
    return (
      <div className="text-center py-16 rounded-xl border border-dashed border-gray-200 bg-gray-50">
        <Clock className="h-10 w-10 mx-auto mb-3 text-gartify-mid opacity-50" aria-hidden="true" />
        <p className="font-semibold text-foreground">Aún no hay reservas</p>
        <p className="text-sm text-muted-foreground mt-1">Cuando recibas citas aparecerán aquí</p>
      </div>
    );
  }

  return (
    <div className="space-y-4">
      {/* Barra única: búsqueda + orden + filtros */}
      <div className="flex items-center gap-2 flex-wrap">
        <div className="relative w-48 shrink-0">
          <Search className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-muted-foreground pointer-events-none" />
          <Input
            placeholder="Nombre, matrícula…"
            value={search}
            onChange={(e) => setSearch(e.target.value)}
            className="pl-9 text-sm border-gray-200 focus-visible:ring-gartify-blue/30"
          />
        </div>
        <button
          onClick={() => setOrden((o) => (o === "asc" ? "desc" : "asc"))}
          className="flex items-center gap-1 px-3 py-1.5 rounded-lg text-xs font-semibold border border-gray-200 bg-white text-gartify-gray hover:bg-gray-50 transition-colors shrink-0"
          aria-label="Ordenar por fecha"
        >
          {orden === "asc" ? <ArrowUp className="h-3.5 w-3.5" /> : <ArrowDown className="h-3.5 w-3.5" />}
          Fecha
        </button>
        <div className="h-4 w-px bg-gray-200 shrink-0" />
        {STATUS_TABS.map((tab) => (
          <button
            key={tab.value}
            onClick={() => setStatusFilter(tab.value)}
            className={`px-3 py-1.5 rounded-lg text-xs font-semibold transition-colors shrink-0 ${
              statusFilter === tab.value
                ? "bg-gartify-blue text-white"
                : "bg-gray-100 text-gartify-gray hover:bg-gray-200"
            }`}
          >
            {tab.label}
          </button>
        ))}
      </div>

      {/* Resultados */}
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

function BookingCard({ b, garageId }: { b: GarageBookingItem; garageId: string }) {
  const isPast = b.status !== "PENDING" && b.status !== "CONFIRMED";
  const initials = (b.user.name ?? "C")
    .split(" ")
    .slice(0, 2)
    .map((w) => w[0])
    .join("")
    .toUpperCase();

  return (
    <article
      className={`bg-white rounded-xl border shadow-sm hover:shadow-md transition-all p-4 ${
        isPast ? "opacity-75 border-gray-100" : "border-gray-200 hover:border-gartify-orange/40"
      }`}
    >
      <div className="flex items-start gap-3">
        {/* Avatar */}
        <div className={`h-9 w-9 rounded-full flex items-center justify-center shrink-0 text-white text-xs font-bold ${
          isPast ? "bg-gray-400" : "bg-gradient-to-br from-gartify-hero to-gartify-mid"
        }`}>
          {initials}
        </div>

        {/* Contenido */}
        <div className="flex-1 min-w-0">
          {/* Fila 1: nombre + estado */}
          <div className="flex items-center justify-between gap-2 flex-wrap">
            <div className="flex items-center gap-2 flex-wrap">
              <span className="font-bold text-gartify-blue text-sm">{b.user.name ?? "Cliente"}</span>
              {b.user.phone && (
                <a
                  href={`tel:${b.user.phone}`}
                  className="flex items-center gap-1 text-xs text-muted-foreground hover:text-gartify-blue transition-colors"
                >
                  <Phone className="h-3 w-3" aria-hidden="true" />
                  {b.user.phone}
                </a>
              )}
            </div>
            <BookingStatusUpdater bookingId={b.id} currentStatus={b.status} garageId={garageId} />
          </div>

          {/* Fila 2: servicio + fecha + duración + vehículo */}
          <div className="flex flex-wrap items-center gap-x-3 gap-y-1 mt-1.5 text-xs text-muted-foreground">
            <span className="inline-flex items-center gap-1 rounded-full bg-blue-50 text-gartify-hero px-2 py-0.5 font-medium border border-blue-100">
              <Wrench className="h-3 w-3" aria-hidden="true" />
              {SERVICE_LABELS[b.service.type] ?? b.service.name}
            </span>
            <span className="flex items-center gap-1">
              <Clock className="h-3 w-3 text-gartify-mid" aria-hidden="true" />
              {formatDateTime(b.date instanceof Date ? b.date : new Date(b.date))}
            </span>
            <span className="flex items-center gap-1">
              <Clock className="h-3 w-3 text-gartify-mid" aria-hidden="true" />
              {b.service.duration} min
            </span>
            {b.vehicleModel && (
              <span className="flex items-center gap-1">
                <Car className="h-3 w-3 text-gartify-mid" aria-hidden="true" />
                {b.vehicleModel}
              </span>
            )}
            {b.vehiclePlate && (
              <span className="flex items-center gap-1 font-mono font-semibold tracking-wider text-gartify-blue">
                <Hash className="h-3 w-3 text-gartify-mid font-normal" aria-hidden="true" />
                {b.vehiclePlate}
              </span>
            )}
            <span className="ml-auto font-bold text-gartify-orange text-sm">
              {formatPrice(b.totalPrice)}
            </span>
          </div>

          {/* Fila 3: notas + código */}
          <div className="flex items-center justify-between mt-2 gap-2 flex-wrap">
            {b.notes && (
              <div className="flex items-start gap-1.5 rounded-lg bg-gray-50 border border-gray-100 px-3 py-1.5 text-xs text-muted-foreground flex-1">
                <FileText className="h-3 w-3 shrink-0 mt-0.5 text-gartify-mid" aria-hidden="true" />
                <span>{b.notes}</span>
              </div>
            )}
            <span className="ml-auto text-xs font-mono text-muted-foreground shrink-0">
              {b.code || b.id.slice(-8).toUpperCase()}
            </span>
          </div>
        </div>
      </div>
    </article>
  );
}
