import type { Metadata } from "next";
import { redirect } from "next/navigation";
import Link from "next/link";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Badge } from "@/components/ui/badge";
import { Button } from "@/components/ui/button";
import { Calendar, MapPin, Car, Wrench, ChevronRight, Star } from "lucide-react";
import { AutoRefresh } from "@/components/cuenta/AutoRefresh";
import { CancelBookingButton } from "@/components/cuenta/CancelBookingButton";
import {
  formatPrice, formatDateTime,
  BOOKING_STATUS_LABELS, BOOKING_STATUS_COLORS, SERVICE_LABELS,
} from "@/lib/utils";

export const dynamic = "force-dynamic";

export const metadata: Metadata = {
  title: "Mis reservas",
  robots: { index: false, follow: false },
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

  type BookingItem = (typeof bookings)[number];

  // Pendientes/confirmadas: ascendente (próxima primero)
  const pending = bookings.filter(
    (b) => b.status === "PENDING" || b.status === "CONFIRMED"
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

  function BookingCard({ b }: { b: BookingItem }) {
    const initials = b.garage.name
      .split(" ")
      .slice(0, 2)
      .map((w) => w[0])
      .join("")
      .toUpperCase();
    const isPast = b.status !== "PENDING" && b.status !== "CONFIRMED";

    return (
      <article
        className={`bg-white rounded-xl border shadow-sm hover:shadow-md transition-all overflow-hidden flex flex-col sm:flex-row ${
          isPast
            ? "opacity-80"
            : "border-gray-200 hover:border-gartify-orange/40"
        }`}
      >
        {/* Franja lateral */}
        <div
          className={`sm:w-36 shrink-0 flex items-center justify-center min-h-[90px] sm:min-h-0 ${
            isPast
              ? "bg-gradient-to-br from-gray-400 to-gray-500"
              : "bg-gradient-to-br from-gartify-hero to-gartify-mid"
          }`}
          aria-hidden="true"
        >
          <div className="flex flex-col items-center gap-1 p-3">
            <div className="h-12 w-12 rounded-full bg-white/20 flex items-center justify-center">
              <span className="text-base font-bold text-white">{initials}</span>
            </div>
            <Wrench className="h-3.5 w-3.5 text-white/60" />
          </div>
        </div>

        {/* Contenido */}
        <div className="flex-1 p-4 flex flex-col gap-2">
          <div className="flex items-start justify-between gap-2 flex-wrap">
            <h3 className="font-bold text-gartify-blue text-sm leading-tight">
              {b.garage.name}
            </h3>
            <Badge className={`text-xs shrink-0 ${BOOKING_STATUS_COLORS[b.status]}`}>
              {BOOKING_STATUS_LABELS[b.status]}
            </Badge>
          </div>

          <span className="inline-flex items-center gap-1 self-start rounded-full bg-blue-50 text-gartify-hero text-xs px-2.5 py-0.5 font-medium border border-blue-100">
            {SERVICE_LABELS[b.service.type] ?? b.service.name}
          </span>

          <div className="flex flex-wrap items-center gap-3 text-xs text-muted-foreground">
            <span className="flex items-center gap-1">
              <Calendar className="h-3.5 w-3.5 text-gartify-mid" aria-hidden="true" />
              {formatDateTime(b.date)}
            </span>
            <span className="flex items-center gap-1">
              <MapPin className="h-3.5 w-3.5 text-gartify-mid" aria-hidden="true" />
              {b.garage.city}
            </span>
            {b.vehicleModel && (
              <span className="flex items-center gap-1">
                <Car className="h-3.5 w-3.5 text-gartify-mid" aria-hidden="true" />
                {b.vehicleModel}
              </span>
            )}
          </div>

          <div className="flex items-center justify-between gap-4 pt-1 mt-auto border-t border-gray-100">
            <span className="text-xl font-bold text-gartify-orange">
              {formatPrice(b.totalPrice)}
            </span>
            <div className="flex items-center gap-1">
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
                  Ver detalle{" "}
                  <ChevronRight className="h-3.5 w-3.5" aria-hidden="true" />
                </Button>
              </Link>
            </div>
          </div>
        </div>
      </article>
    );
  }
}
