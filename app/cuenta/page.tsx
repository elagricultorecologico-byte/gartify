import type { Metadata } from "next";
import { redirect } from "next/navigation";
import Link from "next/link";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Button } from "@/components/ui/button";
import { Calendar, MapPin, Car, Wrench, ChevronRight, Star, Clock } from "lucide-react";
import { AutoRefresh } from "@/components/cuenta/AutoRefresh";
import { CancelBookingButton } from "@/components/cuenta/CancelBookingButton";
import { AcceptProposedBooking } from "@/components/cuenta/AcceptProposedBooking";
import {
  formatPrice, formatDateTime,
  BOOKING_STATUS_LABELS, SERVICE_LABELS,
} from "@/lib/utils";

export const dynamic = "force-dynamic";

export const metadata: Metadata = {
  title: "Mis reservas",
  robots: { index: false, follow: false },
};

// Tipo inferido desde la query de Prisma — definido a nivel de módulo para
// que BookingCard pueda referenciarlo sin depender del scope de CuentaPage
type BookingItem = {
  id: string;
  status: string;
  date: Date;
  totalPrice: number;
  vehicleModel: string | null;
  vehiclePlate: string | null;
  createdAt: Date;
  garage: { name: string; city: string };
  service: { type: string; name: string };
  review: { id: string } | null;
};

// Colores de la banda de estado superior en la vista móvil
const STATUS_BAND: Record<string, string> = {
  PENDING:   "bg-yellow-50  text-yellow-700  border-yellow-200",
  PROPOSED:  "bg-purple-50  text-purple-700  border-purple-200",
  CONFIRMED: "bg-green-50   text-green-700   border-green-200",
  COMPLETED: "bg-slate-50   text-slate-500   border-slate-200",
  CANCELLED: "bg-red-50     text-red-500     border-red-200",
};

export default async function CuentaPage() {
  const session = await auth();
  if (!session?.user?.id) redirect("/login");

  const user = session.user as { id: string; name?: string | null; role?: string };
  if (user.role === "ADMIN") redirect("/admin");
  if (user.role === "GARAGE_OWNER") redirect("/cuenta/taller");

  const bookings = await db.booking.findMany({
    where: { userId: user.id },
    select: {
      id: true,
      status: true,
      date: true,
      totalPrice: true,
      vehicleModel: true,
      vehiclePlate: true,
      createdAt: true,
      garage: { select: { name: true, city: true } },
      service: { select: { type: true, name: true } },
      review: { select: { id: true } },
    },
    orderBy: { date: "asc" },
  });

  // Pendientes/propuestas/confirmadas: ascendente (próxima primero)
  const pending = bookings.filter(
    (b) => b.status === "PENDING" || b.status === "PROPOSED" || b.status === "CONFIRMED"
  );
  // Historial: descendente (más reciente primero)
  const past = bookings
    .filter((b) => b.status !== "PENDING" && b.status !== "CONFIRMED")
    .reverse();

  return (
    <div className="container max-w-3xl py-10">
      {/* Cabecera */}
      <div className="mb-8 flex items-end justify-between gap-4">
        <div>
          <h1 className="text-2xl font-bold text-gartify-blue">Mis reservas</h1>
          <p className="text-muted-foreground text-sm mt-1">
            Hola,{" "}
            <span className="font-medium text-foreground">
              {user.name?.split(" ")[0]}
            </span>
            . Aquí puedes gestionar tus citas.
          </p>
        </div>
        <AutoRefresh />
      </div>

      {bookings.length === 0 ? (
        <div className="text-center py-16 rounded-xl border border-dashed border-gray-200 bg-gray-50">
          <Calendar
            className="h-10 w-10 mx-auto mb-3 text-gartify-mid opacity-50"
            aria-hidden="true"
          />
          <p className="font-semibold text-foreground">Aún no tienes reservas</p>
          <p className="text-sm text-muted-foreground mt-1 mb-6">
            Busca un taller y reserva tu primera cita
          </p>
          <Link href="/talleres">
            <Button className="bg-gartify-green hover:bg-gartify-green/90 text-white">
              Buscar talleres
            </Button>
          </Link>
        </div>
      ) : (
        <div className="space-y-8">
          {pending.length > 0 && (
            <section aria-label="Próximas citas">
              <h2 className="text-sm font-bold uppercase tracking-wide text-gartify-gray mb-3">
                Próximas citas
              </h2>
              <div className="space-y-3">
                {pending.map((b) => (
                  <BookingCard key={b.id} b={b} />
                ))}
              </div>
            </section>
          )}

          {past.length > 0 && (
            <section aria-label="Historial de reservas">
              <h2 className="text-sm font-bold uppercase tracking-wide text-gartify-gray mb-3">
                Historial
              </h2>
              <div className="space-y-3">
                {past.map((b) => (
                  <BookingCard key={b.id} b={b} />
                ))}
              </div>
            </section>
          )}
        </div>
      )}
    </div>
  );
}

function BookingCard({ b }: { b: BookingItem }) {
  const isPast = b.status === "COMPLETED" || b.status === "CANCELLED";
  const bandClasses = STATUS_BAND[b.status] ?? "bg-gray-50 text-gray-500 border-gray-200";
  const codigoReserva = b.id.slice(-8).toUpperCase();
  const fechaFormateada = formatDateTime(b.date);

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
