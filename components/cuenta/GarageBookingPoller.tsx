"use client";

import useSWR from "swr";
import { useEffect, useRef, useState, useMemo } from "react";
import { Bell, X } from "lucide-react";
import { GarageBookingList, type GarageBookingItem } from "@/components/cuenta/GarageBookingList";
import { TallerKpis, type KpiData } from "@/components/cuenta/TallerKpis";
import { formatPrice } from "@/lib/utils";

// ── Tipos ────────────────────────────────────────────────────────────────────

interface Props {
  initialBookings: GarageBookingItem[];
  garageId: string;
  garageRating: number;
}

interface DatosToast {
  nombre: string;
  servicio: string;
}

// ── Fetcher genérico para SWR ────────────────────────────────────────────────

const fetcher = (url: string): Promise<GarageBookingItem[]> =>
  fetch(url).then((r) => {
    if (!r.ok) throw new Error("Error al obtener reservas");
    return r.json() as Promise<GarageBookingItem[]>;
  });

// ── Componente principal ─────────────────────────────────────────────────────

/**
 * GarageBookingPoller
 *
 * Envuelve GarageBookingList y añade polling cada 20 segundos mediante SWR.
 * Cuando llega una nueva reserva con estado PENDING muestra un toast de
 * notificación durante 6 segundos en la esquina inferior derecha.
 *
 * Los datos SSR iniciales se pasan como `fallbackData` para evitar parpadeo
 * en la primera carga — SWR los usa directamente sin hacer un fetch inicial
 * visible para el usuario.
 */
export function GarageBookingPoller({ initialBookings, garageId, garageRating }: Props) {
  const { data } = useSWR<GarageBookingItem[]>("/api/garage/bookings", fetcher, {
    refreshInterval: 20000,        // polling cada 20s
    revalidateOnFocus: true,       // revalida al volver a la pestaña
    fallbackData: initialBookings, // datos SSR iniciales — sin parpadeo
  });

  // Usamos `data ?? initialBookings` por seguridad aunque fallbackData
  // garantiza que `data` nunca sea undefined tras el montaje.
  const reservas = data ?? initialBookings;

  // ── KPIs derivados de las reservas actuales ───────────────────────────────

  const stats = useMemo<KpiData[]>(() => {
    const pending   = reservas.filter((b) => b.status === "PENDING").length;
    const confirmed = reservas.filter((b) => b.status === "CONFIRMED").length;
    const revenue   = reservas
      .filter((b) => b.status === "COMPLETED")
      .reduce((s, b) => s + b.totalPrice, 0);

    return [
      { icon: "Calendar"    as const, label: "Pendientes",  value: pending,                   color: "text-yellow-500",     bg: "bg-blue-50", border: "border-gartify-blue/40" },
      { icon: "TrendingUp"  as const, label: "Confirmadas", value: confirmed,                 color: "text-gartify-mid",    bg: "bg-blue-50", border: "border-gartify-blue/40" },
      { icon: "Euro"        as const, label: "Facturado",   value: formatPrice(revenue),      color: "text-gartify-orange", bg: "bg-blue-50", border: "border-gartify-blue/40" },
      { icon: "Star"        as const, label: "Valoración",  value: garageRating.toFixed(1),   color: "text-yellow-500",     bg: "bg-blue-50", border: "border-gartify-blue/40" },
    ];
  }, [reservas, garageRating]);

  // ── Detección de reservas nuevas PENDING ─────────────────────────────────

  // Guardamos los IDs de reservas PENDING que ya conocemos para detectar
  // las que llegan en posteriores actualizaciones de SWR.
  const prevPendingIds = useRef<Set<string>>(
    new Set(
      initialBookings
        .filter((b) => b.status === "PENDING")
        .map((b) => b.id)
    )
  );

  const [toast, setToast] = useState<DatosToast | null>(null);
  const toastTimer = useRef<ReturnType<typeof setTimeout> | null>(null);

  useEffect(() => {
    // Solo actuamos cuando SWR trae datos frescos del servidor
    if (!data) return;

    const pendientesActuales = data.filter((b) => b.status === "PENDING");
    const nuevas = pendientesActuales.filter(
      (b) => !prevPendingIds.current.has(b.id)
    );

    if (nuevas.length > 0) {
      const primera = nuevas[0];
      setToast({
        nombre: primera.user.name ?? "Cliente",
        servicio: primera.service.name,
      });

      // Limpiamos cualquier timer previo para reiniciar los 6s si llegan
      // varias reservas seguidas en distintos ciclos de polling.
      if (toastTimer.current) clearTimeout(toastTimer.current);
      toastTimer.current = setTimeout(() => setToast(null), 6000);
    }

    // Actualizamos la referencia con los IDs pendientes actuales
    prevPendingIds.current = new Set(pendientesActuales.map((b) => b.id));
  }, [data]);

  // Limpiamos el timer al desmontar el componente
  useEffect(() => {
    return () => {
      if (toastTimer.current) clearTimeout(toastTimer.current);
    };
  }, []);

  // ── Render ───────────────────────────────────────────────────────────────

  return (
    <>
      <TallerKpis stats={stats} />
      <GarageBookingList bookings={reservas} garageId={garageId} />

      {/* Toast de nueva reserva — esquina inferior derecha, estilo Teams */}
      {toast && (
        <div
          role="alert"
          aria-live="polite"
          className="fixed bottom-6 right-6 z-50 flex items-start gap-3 bg-white border border-gray-200 shadow-xl rounded-2xl px-4 py-3.5 w-80 animate-in slide-in-from-bottom-4 duration-300"
        >
          {/* Keyframe para la barra de progreso del toast */}
          <style>{`
            @keyframes shrink { from { width: 100%; } to { width: 0%; } }
          `}</style>

          {/* Icono */}
          <div className="flex h-9 w-9 shrink-0 items-center justify-center rounded-full bg-gartify-blue">
            <Bell className="h-4 w-4 text-white" aria-hidden="true" />
          </div>

          {/* Contenido */}
          <div className="flex-1 min-w-0">
            <p className="text-sm font-bold text-gartify-blue leading-tight">
              Nueva reserva
            </p>
            <p className="text-xs text-muted-foreground mt-0.5 leading-snug">
              <span className="font-semibold text-foreground">{toast.nombre}</span>
              {" · "}
              {toast.servicio}
            </p>
          </div>

          {/* Botón de cierre */}
          <button
            type="button"
            onClick={() => setToast(null)}
            className="shrink-0 text-muted-foreground hover:text-foreground transition-colors mt-0.5"
            aria-label="Cerrar notificación"
          >
            <X className="h-4 w-4" />
          </button>

          {/* Barra de progreso — indica cuánto tiempo queda antes del cierre */}
          <div
            className="absolute bottom-0 left-0 h-0.5 bg-gartify-blue rounded-full"
            style={{
              width: "100%",
              animation: "shrink 6s linear forwards",
            }}
          />
        </div>
      )}
    </>
  );
}
