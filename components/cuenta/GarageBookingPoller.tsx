"use client";

import useSWR from "swr";
import { useEffect, useRef, useState, useMemo } from "react";
import { Bell, X, SlidersHorizontal, ChevronDown } from "lucide-react";
import { GarageBookingList, GarageBookingFilterContent, type GarageBookingItem } from "@/components/cuenta/GarageBookingList";
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

export function GarageBookingPoller({ initialBookings, garageId, garageRating }: Props) {
  const { data } = useSWR<GarageBookingItem[]>("/api/garage/bookings", fetcher, {
    refreshInterval: 20000,
    revalidateOnFocus: true,
    fallbackData: initialBookings,
  });

  const reservas = data ?? initialBookings;

  // ── Estado de filtros (dueño aquí, se pasa a lista y panel) ──────────────

  const [search, setSearch]           = useState("");
  const [statusFilter, setStatusFilter] = useState<string>("PENDING");
  const [orden, setOrden]             = useState<"asc" | "desc">("asc");
  const [filtrosMobileAbiertos, setFiltrosMobileAbiertos] = useState(false);

  const filtrosActivos = (statusFilter !== "ALL" ? 1 : 0) + (search.trim() !== "" ? 1 : 0);

  // ── KPIs ─────────────────────────────────────────────────────────────────

  const stats = useMemo<KpiData[]>(() => {
    const pending   = reservas.filter((b) => b.status === "PENDING").length;
    const confirmed = reservas.filter((b) => b.status === "CONFIRMED").length;
    const revenue   = reservas
      .filter((b) => b.status === "COMPLETED")
      .reduce((s, b) => s + b.totalPrice, 0);

    return [
      { icon: "Calendar"    as const, label: "Pendientes",  value: pending,               color: "text-yellow-500",     bg: "bg-blue-50", border: "border-gartify-blue/40" },
      { icon: "TrendingUp"  as const, label: "Confirmadas", value: confirmed,             color: "text-gartify-orange", bg: "bg-blue-50", border: "border-gartify-blue/40" },
      { icon: "Euro"        as const, label: "Facturado",   value: formatPrice(revenue),  color: "text-gartify-orange", bg: "bg-blue-50", border: "border-gartify-blue/40" },
      { icon: "Star"        as const, label: "Valoración",  value: garageRating.toFixed(1), color: "text-yellow-500",   bg: "bg-blue-50", border: "border-gartify-blue/40" },
    ];
  }, [reservas, garageRating]);

  // ── Detección de reservas nuevas PENDING ─────────────────────────────────

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
    if (!data) return;
    const pendientesActuales = data.filter((b) => b.status === "PENDING");
    const nuevas = pendientesActuales.filter((b) => !prevPendingIds.current.has(b.id));

    if (nuevas.length > 0) {
      const primera = nuevas[0];
      setToast({ nombre: primera.user.name ?? "Cliente", servicio: primera.service.name });
      if (toastTimer.current) clearTimeout(toastTimer.current);
      toastTimer.current = setTimeout(() => setToast(null), 6000);
    }

    prevPendingIds.current = new Set(pendientesActuales.map((b) => b.id));
  }, [data]);

  useEffect(() => {
    return () => { if (toastTimer.current) clearTimeout(toastTimer.current); };
  }, []);

  // ── Props compartidas del panel de filtros ───────────────────────────────

  const filterProps = { bookings: reservas, search, setSearch, statusFilter, setStatusFilter, orden, setOrden };

  // ── Render ───────────────────────────────────────────────────────────────

  return (
    <>
      <div className="flex gap-5 items-start">

        {/* ── SIDEBAR DESKTOP: filtros ──────────────────────────────────── */}
        <aside className="hidden lg:block w-56 shrink-0 sticky top-24">
          <div className="bg-white border border-gray-200 p-4">
            <div className="flex items-center gap-2 text-gartify-blue mb-4 pb-3 border-b border-gray-100">
              <SlidersHorizontal className="h-4 w-4 shrink-0" />
              <span className="text-sm font-semibold">Filtros</span>
              {filtrosActivos > 0 && (
                <span className="flex h-4 min-w-4 items-center justify-center bg-gartify-hero px-1 text-[10px] font-bold text-white leading-none">
                  {filtrosActivos}
                </span>
              )}
            </div>
            <GarageBookingFilterContent {...filterProps} />
          </div>
        </aside>

        {/* ── COLUMNA DERECHA: KPIs + filtro móvil + lista ─────────────── */}
        <div className="flex-1 min-w-0 space-y-4">

          {/* KPIs — más estrechos porque están en flex-1 */}
          <TallerKpis stats={stats} />

          {/* Panel colapsable de filtros — solo móvil */}
          <div className="lg:hidden bg-white border border-gray-200 overflow-hidden">
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
                  <span className="flex h-4 min-w-4 items-center justify-center bg-gartify-hero px-1 text-[10px] font-bold text-white leading-none">
                    {filtrosActivos}
                  </span>
                )}
              </div>
              <ChevronDown className={`h-4 w-4 text-gartify-gray transition-transform ${filtrosMobileAbiertos ? "rotate-180" : ""}`} />
            </button>
            {filtrosMobileAbiertos && (
              <div className="px-4 py-4">
                <GarageBookingFilterContent {...filterProps} />
              </div>
            )}
          </div>

          {/* Lista */}
          <GarageBookingList
            bookings={reservas}
            garageId={garageId}
            search={search}
            statusFilter={statusFilter}
            orden={orden}
          />
        </div>
      </div>

      {/* Toast de nueva reserva */}
      {toast && (
        <div
          role="alert"
          aria-live="polite"
          className="fixed bottom-6 right-6 z-50 flex items-start gap-3 bg-white border border-gray-200 shadow-xl px-4 py-3.5 w-80 animate-in slide-in-from-bottom-4 duration-300"
        >
          <style>{`
            @keyframes shrink { from { width: 100%; } to { width: 0%; } }
          `}</style>

          <div className="flex h-9 w-9 shrink-0 items-center justify-center bg-gartify-blue">
            <Bell className="h-4 w-4 text-white" aria-hidden="true" />
          </div>

          <div className="flex-1 min-w-0">
            <p className="text-sm font-bold text-gartify-blue leading-tight">Nueva reserva</p>
            <p className="text-xs text-muted-foreground mt-0.5 leading-snug">
              <span className="font-semibold text-foreground">{toast.nombre}</span>
              {" · "}
              {toast.servicio}
            </p>
          </div>

          <button
            type="button"
            onClick={() => setToast(null)}
            className="shrink-0 text-muted-foreground hover:text-foreground transition-colors mt-0.5"
            aria-label="Cerrar notificación"
          >
            <X className="h-4 w-4" />
          </button>

          <div
            className="absolute bottom-0 left-0 h-0.5 bg-gartify-blue"
            style={{ width: "100%", animation: "shrink 6s linear forwards" }}
          />
        </div>
      )}
    </>
  );
}
