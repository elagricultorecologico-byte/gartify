"use client";

import useSWR from "swr";
import { useEffect, useRef, useState } from "react";
import { Bell, X } from "lucide-react";
import {
  CustomerBookingList,
  type CustomerBookingItem,
} from "@/components/cuenta/CustomerBookingList";
import { BOOKING_STATUS_LABELS } from "@/lib/utils";

// ── Tipos ────────────────────────────────────────────────────────────────────

interface Props {
  initialBookings: CustomerBookingItem[];
}

interface DatosToast {
  taller: string;
  servicio: string;
  nuevoEstado: string;
}

// ── Fetcher genérico para SWR ────────────────────────────────────────────────

const fetcher = (url: string): Promise<CustomerBookingItem[]> =>
  fetch(url).then((r) => {
    if (!r.ok) throw new Error("Error al obtener reservas");
    return r.json() as Promise<CustomerBookingItem[]>;
  });

// ── Componente principal ─────────────────────────────────────────────────────

/**
 * CustomerBookingPoller
 *
 * Envuelve CustomerBookingList y añade polling cada 20 segundos mediante SWR.
 * Cuando el estado de una reserva cambia (ej: PENDING → CONFIRMED, o PROPOSED)
 * muestra un toast de notificación durante 6 segundos en la esquina inferior derecha.
 *
 * A diferencia de GarageBookingPoller (que detecta IDs nuevos), este componente
 * detecta cambios de estado en reservas ya existentes, ya que el cliente
 * necesita saber cuándo el taller modifica el estado de su cita.
 *
 * Los datos SSR iniciales se pasan como `fallbackData` para evitar parpadeo
 * en la primera carga.
 */
export function CustomerBookingPoller({ initialBookings }: Props) {
  const { data } = useSWR<CustomerBookingItem[]>("/api/bookings/my", fetcher, {
    refreshInterval: 20000,        // polling cada 20 segundos
    revalidateOnFocus: true,       // revalida al volver a la pestaña
    fallbackData: initialBookings, // datos SSR iniciales — sin parpadeo
  });

  // `data` nunca será undefined gracias a fallbackData, pero usamos
  // el operador ?? por seguridad tipológica.
  const reservas = data ?? initialBookings;

  // ── Detección de cambios de estado ───────────────────────────────────────

  // Guardamos un mapa de id → status para comparar con cada actualización
  // de SWR y detectar cuándo el taller cambia el estado de una reserva.
  const prevStatuses = useRef<Map<string, string>>(
    new Map(initialBookings.map((b) => [b.id, b.status]))
  );

  const [toast, setToast] = useState<DatosToast | null>(null);
  const toastTimer = useRef<ReturnType<typeof setTimeout> | null>(null);

  useEffect(() => {
    // Solo actuamos cuando SWR trae datos frescos del servidor
    if (!data) return;

    for (const booking of data) {
      const prevStatus = prevStatuses.current.get(booking.id);

      // Solo notificamos si la reserva ya existía y su estado cambió.
      // Reservas nuevas (sin prevStatus) no generan toast aquí —
      // el cambio relevante para el cliente es la actualización de estado.
      if (prevStatus !== undefined && prevStatus !== booking.status) {
        setToast({
          taller: booking.garage.name,
          servicio: booking.service.name,
          nuevoEstado: booking.status,
        });

        // Reiniciamos el temporizador si llegan varios cambios seguidos
        if (toastTimer.current) clearTimeout(toastTimer.current);
        toastTimer.current = setTimeout(() => setToast(null), 6000);

        // Solo un toast a la vez — mostramos el primer cambio detectado
        break;
      }
    }

    // Actualizamos el mapa de estados con los datos más recientes
    prevStatuses.current = new Map(data.map((b) => [b.id, b.status]));
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
      <CustomerBookingList bookings={reservas} />

      {/* Toast de cambio de estado — esquina inferior derecha */}
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

          {/* Icono — color gartify-orange para diferenciar visualmente del toast del taller */}
          <div className="flex h-9 w-9 shrink-0 items-center justify-center rounded-full bg-gartify-orange">
            <Bell className="h-4 w-4 text-white" aria-hidden="true" />
          </div>

          {/* Contenido */}
          <div className="flex-1 min-w-0">
            <p className="text-sm font-bold text-gartify-orange leading-tight">
              Tu reserva ha sido actualizada
            </p>
            <p className="text-xs text-muted-foreground mt-0.5 leading-snug">
              <span className="font-semibold text-foreground">{toast.taller}</span>
              {" · "}
              {BOOKING_STATUS_LABELS[toast.nuevoEstado] ?? toast.nuevoEstado}
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
            className="absolute bottom-0 left-0 h-0.5 bg-gartify-orange rounded-full"
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
