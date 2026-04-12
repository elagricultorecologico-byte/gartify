/**
 * Modo TV — Panel del taller
 *
 * Pantalla de visualización para un televisor grande.
 * Muestra las reservas PENDING y CONFIRMED del taller ordenadas por fecha ASC.
 * No usa Navbar ni Footer: tiene su propio layout.tsx en este mismo segmento.
 */
import { redirect } from "next/navigation";
import { Prisma } from "@prisma/client";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { TvHeader } from "@/components/cuenta/TvHeader";
import { TvAutoRefresh } from "@/components/cuenta/TvAutoRefresh";
import { TvFullscreen } from "@/components/cuenta/TvFullscreen";
import { TvColumnasTabs } from "@/components/cuenta/TvColumnasTabs";
import { SERVICE_LABELS, BOOKING_STATUS_LABELS } from "@/lib/utils";

export const dynamic = "force-dynamic";

// ── Tipo inferido desde Prisma ─────────────────────────────────────────────────

type ReservaTv = Prisma.BookingGetPayload<{
  select: {
    id: true;
    date: true;
    status: true;
    vehicleModel: true;
    vehiclePlate: true;
    vehicleType: true;
    totalPrice: true;
    user: { select: { name: true } };
    service: { select: { type: true; name: true; duration: true } };
  };
}>;

// ── Colores de estado para modo oscuro ────────────────────────────────────────

const ESTADO_BADGE_TV: Record<string, string> = {
  PENDING:   "bg-yellow-500/20 text-yellow-300 border border-yellow-500/30",
  PROPOSED:  "bg-purple-500/20 text-purple-300 border border-purple-500/30",
  CONFIRMED: "bg-green-500/20 text-green-300 border border-green-500/30",
};

// ── Colores de servicio para badge de tipo ────────────────────────────────────

const SERVICIO_BADGE_COLORES: Record<string, string> = {
  OIL_CHANGE:      "bg-orange-500/20 text-orange-300",
  TIRE_CHANGE:     "bg-blue-500/20 text-blue-300",
  BRAKE_SERVICE:   "bg-red-500/20 text-red-300",
  AC_SERVICE:      "bg-cyan-500/20 text-cyan-300",
  BATTERY_SERVICE: "bg-yellow-500/20 text-yellow-300",
  INSPECTION:      "bg-purple-500/20 text-purple-300",
  BODY_REPAIR:     "bg-pink-500/20 text-pink-300",
  TRANSMISSION:    "bg-indigo-500/20 text-indigo-300",
  ENGINE_REPAIR:   "bg-rose-500/20 text-rose-300",
  ELECTRICAL:      "bg-amber-500/20 text-amber-300",
  SUSPENSION:      "bg-teal-500/20 text-teal-300",
  DIAGNOSTICS:     "bg-lime-500/20 text-lime-300",
  CUSTOM:          "bg-slate-500/20 text-slate-300",
};

// ── Componente de tarjeta de reserva ──────────────────────────────────────────

function TarjetaReserva({ reserva }: { reserva: ReservaTv }) {
  const fechaObj = new Date(reserva.date);
  const hora = new Intl.DateTimeFormat("es-ES", {
    hour:   "2-digit",
    minute: "2-digit",
    hour12: false,
  }).format(fechaObj);
  const fecha = new Intl.DateTimeFormat("es-ES", {
    weekday: "short",
    day:     "numeric",
    month:   "short",
  }).format(fechaObj);

  const badgeEstado = ESTADO_BADGE_TV[reserva.status] ?? "bg-slate-500/20 text-slate-300";
  const badgeServicio =
    SERVICIO_BADGE_COLORES[reserva.service.type] ?? SERVICIO_BADGE_COLORES.CUSTOM;
  // SERVICE_LABELS es Record<string, string> → acceso directo sin cast
  const etiquetaServicio = SERVICE_LABELS[reserva.service.type] ?? reserva.service.name;

  return (
    <article className="rounded-xl bg-white/5 border border-white/10 px-4 py-3 flex items-center gap-4">
      {/* Hora + fecha */}
      <div className="shrink-0 text-center w-16">
        <span className="text-2xl font-black text-white leading-none">{hora}</span>
        <p className="text-[10px] text-slate-400 capitalize leading-tight mt-0.5">{fecha}</p>
      </div>

      {/* Separador */}
      <div className="w-px self-stretch bg-white/10 shrink-0" />

      {/* Cliente + servicio */}
      <div className="flex-1 min-w-0">
        <div className="flex items-center gap-2 flex-wrap">
          <span className="font-bold text-white text-sm truncate">{reserva.user.name ?? "Cliente"}</span>
          <span className={`rounded px-2 py-0.5 text-xs font-semibold ${badgeServicio}`}>{etiquetaServicio}</span>
        </div>
        <div className="flex items-center gap-2 mt-0.5 text-xs text-slate-400 flex-wrap">
          {reserva.vehicleModel && <span>{reserva.vehicleModel}</span>}
          {reserva.vehiclePlate && <span className="font-mono uppercase tracking-wider">{reserva.vehiclePlate}</span>}
          <span>{reserva.service.duration} min</span>
        </div>
      </div>

      {/* Estado */}
      <div className="shrink-0">
        <span className={`rounded-full px-2.5 py-0.5 text-xs font-bold ${badgeEstado}`}>
          {BOOKING_STATUS_LABELS[reserva.status] ?? reserva.status}
        </span>
      </div>
    </article>
  );
}

// ── Página principal (Server Component) ───────────────────────────────────────

export default async function ModoTvPage() {
  // Verificación de sesión y rol
  const sesion = await auth();
  if (!sesion?.user?.id) redirect("/login");

  const usuario = sesion.user as { id: string; role?: string };
  if (usuario.role !== "GARAGE_OWNER") redirect("/cuenta");

  // Rango de hoy (00:00 → 23:59:59)
  const hoyInicio = new Date();
  hoyInicio.setHours(0, 0, 0, 0);
  const hoyFin = new Date();
  hoyFin.setHours(23, 59, 59, 999);

  // Obtener el taller del propietario
  const taller = await db.garage.findUnique({
    where: { ownerId: usuario.id },
    select: {
      id:   true,
      name: true,
      bookings: {
        where: {
          OR: [
            { status: { in: ["PENDING", "PROPOSED", "CONFIRMED"] } },
            { status: "COMPLETED", date: { gte: hoyInicio, lte: hoyFin } },
          ],
        },
        select: {
          id:           true,
          date:         true,
          status:       true,
          vehicleModel: true,
          vehiclePlate: true,
          vehicleType:  true,
          totalPrice:   true,
          user:         { select: { name: true } },
          service:      { select: { type: true, name: true, duration: true } },
        },
        orderBy: { date: "asc" },
      },
    },
  });

  if (!taller) redirect("/cuenta/taller/perfil");

  // KPIs: reservas de hoy (query separada para evitar conflicto de relación)
  const reservasHoy = await db.booking.findMany({
    where: {
      garageId: taller.id,
      date:     { gte: hoyInicio, lte: hoyFin },
    },
    select: { status: true, totalPrice: true, date: true },
  });

  const reservas: ReservaTv[] = taller.bookings;
  const nPendientes   = reservas.filter((r) => r.status === "PENDING" || r.status === "PROPOSED").length;
  const nConfirmadas  = reservas.filter((r) => r.status === "CONFIRMED").length;
  const nCompletadas  = reservas.filter((r) => r.status === "COMPLETED").length;

  // ── KPIs ──────────────────────────────────────────────────────────────────
  const hoy = reservasHoy;
  const citasHoy       = hoy.filter((b) => b.status !== "CANCELLED").length;
  const completadasHoy = hoy.filter((b) => b.status === "COMPLETED").length;
  const ahora = new Date();
  const proximaReserva = reservas
    .filter((r) => new Date(r.date) > ahora)
    .sort((a, b) => new Date(a.date).getTime() - new Date(b.date).getTime())[0];
  const proximaHora = proximaReserva
    ? new Intl.DateTimeFormat("es-ES", { hour: "2-digit", minute: "2-digit", hour12: false }).format(new Date(proximaReserva.date))
    : null;
  const proximaFecha = proximaReserva
    ? new Intl.DateTimeFormat("es-ES", { weekday: "short", day: "numeric", month: "short" }).format(new Date(proximaReserva.date))
    : null;

  return (
    <div className="h-screen bg-gartify-dark text-white flex flex-col overflow-hidden">

      {/* ── Cabecera ── */}
      <TvHeader
        tallerName={taller.name}
        citasHoy={citasHoy}
        completadasHoy={completadasHoy}
        nPendientes={nPendientes}
        proximaHora={proximaHora}
        proximaFecha={proximaFecha}
      />

      {/* ── Cuerpo: tabs en móvil, columnas en desktop ── */}
      <TvColumnasTabs tabs={[
        {
          key: "pendientes",
          label: "Pendientes",
          count: nPendientes,
          dot: "bg-yellow-400",
          empty: { icon: "✅", text: "Sin pendientes" },
          children: (
            <div className="flex flex-col gap-2">
              {reservas.filter((r) => r.status === "PENDING" || r.status === "PROPOSED").map((r) => (
                <TarjetaReserva key={r.id} reserva={r} />
              ))}
            </div>
          ),
        },
        {
          key: "confirmadas",
          label: "Confirmadas",
          count: nConfirmadas,
          dot: "bg-green-400",
          empty: { icon: "📅", text: "Sin confirmadas" },
          children: (
            <div className="flex flex-col gap-2">
              {reservas.filter((r) => r.status === "CONFIRMED").map((r) => (
                <TarjetaReserva key={r.id} reserva={r} />
              ))}
            </div>
          ),
        },
        {
          key: "completadas",
          label: "Completadas",
          count: nCompletadas,
          dot: "bg-slate-400",
          empty: { icon: "🏁", text: "Sin completadas hoy" },
          children: (
            <div className="flex flex-col gap-2">
              {reservas.filter((r) => r.status === "COMPLETED").map((r) => (
                <TarjetaReserva key={r.id} reserva={r} />
              ))}
            </div>
          ),
        },
      ]} />


      <TvAutoRefresh />
      <TvFullscreen />
    </div>
  );
}
