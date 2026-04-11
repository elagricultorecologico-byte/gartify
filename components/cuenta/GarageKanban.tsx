"use client";

import { Car, Clock, Hash, Phone, Wrench } from "lucide-react";
import { BookingStatusUpdater } from "@/components/cuenta/BookingStatusUpdater";
import { formatPrice, formatDateTime, SERVICE_LABELS } from "@/lib/utils";
import type { GarageBookingItem } from "@/components/cuenta/GarageBookingList";

// ── Configuración de columnas ──────────────────────────────────────────────────

const COLUMNAS = [
  {
    status:      "PENDING",
    label:       "Pendientes",
    description: "Requieren tu confirmación",
    headerBg:    "bg-yellow-50 border-yellow-200",
    headerText:  "text-yellow-700",
    countBg:     "bg-yellow-100 text-yellow-700",
    cardBorder:  "border-yellow-200 hover:border-yellow-400",
    emptyText:   "Sin reservas pendientes",
  },
  {
    status:      "CONFIRMED",
    label:       "Confirmadas",
    description: "Citas aceptadas — marcar al completar",
    headerBg:    "bg-blue-50 border-blue-200",
    headerText:  "text-gartify-mid",
    countBg:     "bg-blue-100 text-gartify-mid",
    cardBorder:  "border-blue-200 hover:border-gartify-mid",
    emptyText:   "Sin citas confirmadas",
  },
  {
    status:      "COMPLETED",
    label:       "Completadas",
    description: "Servicios realizados",
    headerBg:    "bg-green-50 border-green-200",
    headerText:  "text-green-700",
    countBg:     "bg-green-100 text-green-700",
    cardBorder:  "border-green-100",
    emptyText:   "Sin servicios completados",
  },
  {
    status:      "CANCELLED",
    label:       "Canceladas",
    description: "Citas anuladas",
    headerBg:    "bg-gray-50 border-gray-200",
    headerText:  "text-gray-500",
    countBg:     "bg-gray-100 text-gray-500",
    cardBorder:  "border-gray-100",
    emptyText:   "Sin citas canceladas",
  },
] as const;

// ── Tarjeta de reserva ─────────────────────────────────────────────────────────

function KanbanCard({ b, isActive, garageId }: { b: GarageBookingItem; isActive: boolean; garageId: string }) {
  const fechaObj = b.date instanceof Date ? b.date : new Date(b.date);

  return (
    <article
      className={`rounded-xl bg-white border shadow-sm p-3 flex flex-col gap-2 transition-all ${
        isActive
          ? "border-gray-200 hover:shadow-md"
          : "opacity-60 border-gray-100"
      }`}
    >
      {/* Fecha y hora */}
      <div className="text-xs text-muted-foreground flex items-center gap-1">
        <Clock className="h-3 w-3 shrink-0" aria-hidden="true" />
        {formatDateTime(fechaObj)}
      </div>

      {/* Cliente */}
      <div className="flex items-center justify-between gap-1 flex-wrap">
        <span className="font-bold text-gartify-blue text-sm leading-tight">
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

      {/* Servicio */}
      <span className="inline-flex items-center gap-1 self-start rounded-full bg-blue-50 text-gartify-hero text-xs px-2 py-0.5 border border-blue-100 font-medium">
        <Wrench className="h-3 w-3" aria-hidden="true" />
        {SERVICE_LABELS[b.service.type] ?? b.service.name}
      </span>

      {/* Vehículo */}
      {(b.vehicleModel || b.vehiclePlate) && (
        <div className="flex flex-wrap items-center gap-x-2 gap-y-0.5 text-xs text-muted-foreground">
          {b.vehicleModel && (
            <span className="flex items-center gap-1">
              <Car className="h-3 w-3" aria-hidden="true" />
              {b.vehicleModel}
            </span>
          )}
          {b.vehiclePlate && (
            <span className="flex items-center gap-1 font-mono font-semibold tracking-wider text-gartify-blue">
              <Hash className="h-3 w-3 font-normal text-muted-foreground" aria-hidden="true" />
              {b.vehiclePlate}
            </span>
          )}
        </div>
      )}

      {/* Precio + acción */}
      <div className="flex items-center justify-between gap-2 pt-1 border-t border-gray-100">
        <div className="flex flex-col gap-0.5">
          <span className="font-bold text-gartify-orange text-sm">
            {formatPrice(b.totalPrice)}
          </span>
          <span className="text-xs font-mono text-muted-foreground">
            {b.code || b.id.slice(-8).toUpperCase()}
          </span>
        </div>
        <BookingStatusUpdater bookingId={b.id} currentStatus={b.status} garageId={garageId} />
      </div>
    </article>
  );
}

// ── Columna Kanban ─────────────────────────────────────────────────────────────

function KanbanColumna({
  columna,
  bookings,
  garageId,
}: {
  columna: (typeof COLUMNAS)[number];
  bookings: GarageBookingItem[];
  garageId: string;
}) {
  const isActive = columna.status === "PENDING" || columna.status === "CONFIRMED";

  return (
    <div className="flex flex-col min-w-[260px] flex-1">
      {/* Cabecera de columna */}
      <div className={`rounded-t-xl border-x border-t px-4 py-3 ${columna.headerBg}`}>
        <div className="flex items-center gap-2">
          <span className={`font-bold text-sm ${columna.headerText}`}>{columna.label}</span>
          <span className={`rounded-full px-2 py-0.5 text-xs font-bold ${columna.countBg}`}>
            {bookings.length}
          </span>
        </div>
        <p className="text-xs text-muted-foreground mt-0.5">{columna.description}</p>
      </div>

      {/* Tarjetas */}
      <div
        className={`flex-1 rounded-b-xl border-x border-b bg-gray-50/60 px-3 py-3 flex flex-col gap-2 min-h-[120px] ${
          columna.headerBg.split(" ")[1]  /* reutiliza el border color */
        }`}
      >
        {bookings.length === 0 ? (
          <p className="text-xs text-muted-foreground text-center py-6">{columna.emptyText}</p>
        ) : (
          bookings.map((b) => (
            <KanbanCard key={b.id} b={b} isActive={isActive} garageId={garageId} />
          ))
        )}
      </div>
    </div>
  );
}

// ── Componente principal ───────────────────────────────────────────────────────

export function GarageKanban({ bookings, garageId }: { bookings: GarageBookingItem[]; garageId: string }) {
  const byStatus = (status: string) =>
    bookings.filter((b) => b.status === status);

  return (
    <div className="overflow-x-auto pb-2">
      <div className="flex gap-4 min-w-max lg:min-w-0">
        {COLUMNAS.map((col) => (
          <KanbanColumna
            key={col.status}
            columna={col}
            bookings={byStatus(col.status)}
            garageId={garageId}
          />
        ))}
      </div>
    </div>
  );
}
