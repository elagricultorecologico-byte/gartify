"use client";
import { useState, useMemo } from "react";
import { Car, Clock, FileText, Hash, Phone, Search, Wrench } from "lucide-react";
import { Input } from "@/components/ui/input";
import { BookingStatusUpdater } from "@/components/cuenta/BookingStatusUpdater";
import { formatPrice, formatDateTime, SERVICE_LABELS } from "@/lib/utils";

export type GarageBookingItem = {
  id: string;
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
  { value: "CONFIRMED", label: "Confirmadas" },
  { value: "COMPLETED", label: "Completadas" },
  { value: "CANCELLED", label: "Canceladas" },
] as const;

export function GarageBookingList({ bookings }: { bookings: GarageBookingItem[] }) {
  const [search, setSearch] = useState("");
  const [statusFilter, setStatusFilter] = useState<string>("ALL");

  const filtered = useMemo(() => {
    const q = search.trim().toLowerCase();
    return bookings.filter((b) => {
      if (statusFilter !== "ALL" && b.status !== statusFilter) return false;
      if (!q) return true;
      return (
        b.user.name?.toLowerCase().includes(q) ||
        b.vehicleModel?.toLowerCase().includes(q) ||
        b.vehiclePlate?.toLowerCase().includes(q) ||
        b.user.phone?.includes(q)
      );
    });
  }, [bookings, search, statusFilter]);

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
      {/* Barra de búsqueda + filtros */}
      <div className="flex flex-col sm:flex-row gap-3">
        <div className="relative flex-1">
          <Search className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-muted-foreground pointer-events-none" />
          <Input
            placeholder="Buscar por nombre, matrícula o teléfono…"
            value={search}
            onChange={(e) => setSearch(e.target.value)}
            className="pl-9 text-sm border-gray-200 focus-visible:ring-gartify-blue/30"
          />
        </div>
        <div className="flex gap-1 flex-wrap">
          {STATUS_TABS.map((tab) => (
            <button
              key={tab.value}
              onClick={() => setStatusFilter(tab.value)}
              className={`px-3 py-1.5 rounded-lg text-xs font-semibold transition-colors ${
                statusFilter === tab.value
                  ? "bg-gartify-blue text-white"
                  : "bg-gray-100 text-gartify-gray hover:bg-gray-200"
              }`}
            >
              {tab.label}
            </button>
          ))}
        </div>
      </div>

      {/* Resultados */}
      {filtered.length === 0 ? (
        <p className="text-center py-10 text-sm text-muted-foreground">
          No hay citas que coincidan con los filtros.
        </p>
      ) : (
        <div className="space-y-3">
          {filtered.map((b) => (
            <BookingCard key={b.id} b={b} />
          ))}
        </div>
      )}
    </div>
  );
}

function BookingCard({ b }: { b: GarageBookingItem }) {
  const isPast = b.status !== "PENDING" && b.status !== "CONFIRMED";
  const initials = (b.user.name ?? "C")
    .split(" ")
    .slice(0, 2)
    .map((w) => w[0])
    .join("")
    .toUpperCase();

  return (
    <article
      className={`bg-white rounded-xl border shadow-sm hover:shadow-md transition-all overflow-hidden flex flex-col sm:flex-row ${
        isPast ? "opacity-75" : "border-gray-200 hover:border-gartify-orange/40"
      }`}
    >
      <div
        className={`sm:w-32 shrink-0 flex items-center justify-center min-h-[80px] sm:min-h-0 ${
          isPast
            ? "bg-gradient-to-br from-gray-400 to-gray-500"
            : "bg-gradient-to-br from-gartify-hero to-gartify-mid"
        }`}
        aria-hidden="true"
      >
        <div className="flex flex-col items-center gap-1 p-3">
          <div className="h-10 w-10 rounded-full bg-white/20 flex items-center justify-center">
            <span className="text-sm font-bold text-white">{initials}</span>
          </div>
          <Wrench className="h-3 w-3 text-white/60" />
        </div>
      </div>

      <div className="flex-1 p-4 flex flex-col gap-2">
        <div className="flex items-start justify-between gap-2 flex-wrap">
          <div className="flex items-center gap-2 flex-wrap">
            <span className="font-bold text-gartify-blue text-sm">
              {b.user.name ?? "Cliente"}
            </span>
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
          <BookingStatusUpdater bookingId={b.id} currentStatus={b.status} />
        </div>

        <span className="inline-flex items-center gap-1 self-start rounded-full bg-blue-50 text-gartify-hero text-xs px-2.5 py-0.5 font-medium border border-blue-100">
          {SERVICE_LABELS[b.service.type] ?? b.service.name}
        </span>

        <div className="flex flex-wrap items-center gap-3 text-xs text-muted-foreground">
          <span className="flex items-center gap-1">
            <Clock className="h-3.5 w-3.5 text-gartify-mid" aria-hidden="true" />
            {formatDateTime(b.date instanceof Date ? b.date : new Date(b.date))}
          </span>
          <span className="flex items-center gap-1">
            <Clock className="h-3.5 w-3.5 text-gartify-mid" aria-hidden="true" />
            {b.service.duration} min
          </span>
          {b.vehicleModel && (
            <span className="flex items-center gap-1">
              <Car className="h-3.5 w-3.5 text-gartify-mid" aria-hidden="true" />
              {b.vehicleModel}
            </span>
          )}
          {b.vehiclePlate && (
            <span className="flex items-center gap-1 font-mono font-semibold tracking-wider text-gartify-blue">
              <Hash className="h-3.5 w-3.5 text-gartify-mid font-normal" aria-hidden="true" />
              {b.vehiclePlate}
            </span>
          )}
        </div>

        {b.notes && (
          <div className="flex items-start gap-1.5 rounded-lg bg-gray-50 border border-gray-100 px-3 py-2 text-xs text-muted-foreground">
            <FileText className="h-3.5 w-3.5 shrink-0 mt-0.5 text-gartify-mid" aria-hidden="true" />
            <span>{b.notes}</span>
          </div>
        )}

        <div className="flex items-center pt-1 mt-auto border-t border-gray-100">
          <span className="text-xl font-bold text-gartify-orange">
            {formatPrice(b.totalPrice)}
          </span>
        </div>
      </div>
    </article>
  );
}
