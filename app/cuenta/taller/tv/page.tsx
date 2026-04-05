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
import { TvReloj } from "@/components/cuenta/TvReloj";
import { TvAutoRefresh } from "@/components/cuenta/TvAutoRefresh";
import { TvFullscreen } from "@/components/cuenta/TvFullscreen";
import { SERVICE_LABELS, BOOKING_STATUS_LABELS, formatPrice } from "@/lib/utils";
import Link from "next/link";

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

      {/* Precio + estado */}
      <div className="shrink-0 flex flex-col items-end gap-1">
        <span className="text-base font-bold text-white">{formatPrice(reserva.totalPrice)}</span>
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
  const facturableHoy  = hoy
    .filter((b) => b.status === "PENDING" || b.status === "CONFIRMED")
    .reduce((s, b) => s + b.totalPrice, 0);

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
    <div className="min-h-screen bg-gartify-dark text-white flex flex-col">

      {/* ── Cabecera ── */}
      <header className="sticky top-0 z-10 bg-gartify-dark/95 backdrop-blur border-b border-white/10 px-6 py-4">
        <div className="flex items-center justify-between gap-4">

          {/* Logo + nombre del taller */}
          <div className="flex items-center gap-3 min-w-0">
            <span className="text-2xl" aria-hidden="true">🔧</span>
            <div className="min-w-0">
              <span className="text-xl font-black text-white tracking-tight">Gartify</span>
              <span className="mx-2 text-slate-600">|</span>
              <span className="text-lg font-semibold text-slate-300 truncate">
                {taller.name}
              </span>
            </div>
            {/* Badge EN VIVO */}
            <span className="shrink-0 flex items-center gap-1.5 rounded-full bg-red-500/20 border border-red-500/40 text-red-400 text-xs font-bold px-3 py-1 uppercase tracking-widest">
              <span className="h-2 w-2 rounded-full bg-red-400 animate-pulse" aria-hidden="true" />
              En vivo
            </span>
          </div>

          {/* ── KPIs ── */}
          <div className="flex items-center gap-1 flex-1 justify-center flex-wrap">

            <div className="flex flex-col items-center justify-center px-5 py-1.5 rounded-xl bg-white/5 border border-white/10 min-w-[100px]">
              <span className="text-xs text-slate-500 uppercase tracking-widest font-semibold">Citas hoy</span>
              <span className="text-2xl font-black text-white leading-tight">{citasHoy}</span>
              <span className="text-[10px] leading-tight mt-0.5 invisible select-none">—</span>
            </div>

            <div className="flex flex-col items-center justify-center px-5 py-1.5 rounded-xl bg-green-500/10 border border-green-500/20 min-w-[120px]">
              <span className="text-xs text-green-400 uppercase tracking-widest font-semibold">Completadas</span>
              <span className="text-2xl font-black text-green-300 leading-tight">{completadasHoy}</span>
              <span className="text-[10px] leading-tight mt-0.5 invisible select-none">—</span>
            </div>

            <div className="flex flex-col items-center justify-center px-5 py-1.5 rounded-xl bg-white/5 border border-white/10 min-w-[100px]">
              <span className="text-xs text-slate-500 uppercase tracking-widest font-semibold">Próxima</span>
              <span className="text-2xl font-black text-white leading-tight">
                {proximaHora ?? "—"}
              </span>
              {proximaFecha && (
                <span className="text-[10px] text-slate-400 capitalize leading-tight mt-0.5">{proximaFecha}</span>
              )}
            </div>

          </div>

          {/* Reloj + botón volver */}
          <div className="flex items-center gap-4 shrink-0">
            {/* El reloj necesita useEffect → Client Component */}
            <TvReloj />
            <Link
              href="/cuenta/taller"
              className="rounded-lg bg-white/10 hover:bg-white/20 transition-colors px-4 py-2 text-sm font-semibold text-slate-300 hover:text-white"
            >
              ← Volver al panel
            </Link>
          </div>

        </div>
      </header>

      {/* ── Cuerpo ── */}
      <main className="flex-1 px-6 py-6 flex gap-6">

        {/* ── Columna PENDIENTES ── */}
        <div className="flex flex-col flex-1 min-w-0">
          <div className="flex items-center gap-3 mb-4">
            <span className="h-3 w-3 rounded-full bg-yellow-400 shrink-0" aria-hidden="true" />
            <h2 className="text-lg font-black text-white tracking-tight">Pendientes</h2>
            <span className="rounded-full bg-yellow-500/20 border border-yellow-500/30 text-yellow-300 text-sm font-bold px-3 py-0.5">
              {nPendientes}
            </span>
            <p className="text-xs text-slate-500 ml-1">Requieren confirmación</p>
          </div>

          {nPendientes === 0 ? (
            <div className="flex flex-col items-center justify-center flex-1 gap-3 rounded-xl border border-white/5 bg-white/3 py-16">
              <span className="text-4xl" aria-hidden="true">✅</span>
              <p className="text-slate-500 text-sm">Sin pendientes</p>
            </div>
          ) : (
            <div className="flex flex-col gap-2">
              {reservas.filter((r) => r.status === "PENDING").map((reserva) => (
                <TarjetaReserva key={reserva.id} reserva={reserva} />
              ))}
            </div>
          )}
        </div>

        {/* Separador vertical */}
        <div className="w-px bg-white/10 shrink-0" />

        {/* ── Columna CONFIRMADAS ── */}
        <div className="flex flex-col flex-1 min-w-0">
          <div className="flex items-center gap-3 mb-4">
            <span className="h-3 w-3 rounded-full bg-green-400 shrink-0" aria-hidden="true" />
            <h2 className="text-lg font-black text-white tracking-tight">Confirmadas</h2>
            <span className="rounded-full bg-green-500/20 border border-green-500/30 text-green-300 text-sm font-bold px-3 py-0.5">
              {nConfirmadas}
            </span>
            <p className="text-xs text-slate-500 ml-1">Citas aceptadas</p>
          </div>

          {nConfirmadas === 0 ? (
            <div className="flex flex-col items-center justify-center flex-1 gap-3 rounded-xl border border-white/5 bg-white/3 py-16">
              <span className="text-4xl" aria-hidden="true">📅</span>
              <p className="text-slate-500 text-sm">Sin confirmadas</p>
            </div>
          ) : (
            <div className="flex flex-col gap-2">
              {reservas.filter((r) => r.status === "CONFIRMED").map((reserva) => (
                <TarjetaReserva key={reserva.id} reserva={reserva} />
              ))}
            </div>
          )}
        </div>

        {/* Separador vertical */}
        <div className="w-px bg-white/10 shrink-0" />

        {/* ── Columna COMPLETADAS (hoy) ── */}
        <div className="flex flex-col flex-1 min-w-0">
          <div className="flex items-center gap-3 mb-4">
            <span className="h-3 w-3 rounded-full bg-slate-400 shrink-0" aria-hidden="true" />
            <h2 className="text-lg font-black text-white tracking-tight">Completadas</h2>
            <span className="rounded-full bg-slate-500/20 border border-slate-500/30 text-slate-300 text-sm font-bold px-3 py-0.5">
              {nCompletadas}
            </span>
            <p className="text-xs text-slate-500 ml-1">Realizadas hoy</p>
          </div>

          {nCompletadas === 0 ? (
            <div className="flex flex-col items-center justify-center flex-1 gap-3 rounded-xl border border-white/5 bg-white/3 py-16">
              <span className="text-4xl" aria-hidden="true">🏁</span>
              <p className="text-slate-500 text-sm">Sin completadas hoy</p>
            </div>
          ) : (
            <div className="flex flex-col gap-2">
              {reservas.filter((r) => r.status === "COMPLETED").map((reserva) => (
                <TarjetaReserva key={reserva.id} reserva={reserva} />
              ))}
            </div>
          )}
        </div>

      </main>


      {/* Auto-refresh silencioso cada 30 segundos — Client Component */}
      <TvAutoRefresh />
      {/* Pantalla completa automática al entrar en modo TV */}
      <TvFullscreen />
    </div>
  );
}
