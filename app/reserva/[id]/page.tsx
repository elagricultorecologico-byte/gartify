import { notFound, redirect } from "next/navigation";
import type { Metadata } from "next";
import Link from "next/link";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Button } from "@/components/ui/button";
import {
  CheckCircle, XCircle, Calendar, MapPin, Phone,
  Car, Hash, FileText, Clock, Euro,
} from "lucide-react";
import {
  formatPrice, formatDateTime,
  SERVICE_LABELS, BOOKING_STATUS_LABELS, BOOKING_STATUS_COLORS,
  VEHICLE_LABELS, VEHICLE_ICONS,
} from "@/lib/utils";

function formatPhone(phone: string) {
  const digits = phone.replace(/\D/g, "");
  if (digits.startsWith("34") && digits.length === 11)
    return `+34 ${digits.slice(2, 5)} ${digits.slice(5, 7)} ${digits.slice(7, 9)} ${digits.slice(9)}`;
  if (digits.length === 9)
    return `${digits.slice(0, 3)} ${digits.slice(3, 5)} ${digits.slice(5, 7)} ${digits.slice(7)}`;
  return phone;
}
import { Badge } from "@/components/ui/badge";

export async function generateMetadata({
  params,
}: {
  params: { id: string };
}): Promise<Metadata> {
  const booking = await db.booking.findUnique({
    where: { id: params.id },
    select: { garage: { select: { name: true } } },
  });
  if (!booking) return { title: "Reserva no encontrada" };
  return {
    title: `Reserva confirmada en ${booking.garage.name}`,
    description: "Tu cita ha sido registrada. Aquí tienes todos los detalles.",
    robots: { index: false, follow: false },
  };
}

export default async function BookingConfirmationPage({
  params,
}: {
  params: { id: string };
}) {
  const session = await auth();
  if (!session?.user) redirect(`/login?callbackUrl=/reserva/${params.id}`);

  const booking = await db.booking.findUnique({
    where: { id: params.id },
    select: {
      id: true,
      code: true,
      date: true,
      status: true,
      totalPrice: true,
      vehicleType: true,
      vehicleModel: true,
      vehiclePlate: true,
      notes: true,
      userId: true,
      garage: {
        select: { name: true, address: true, city: true, phone: true },
      },
      service: {
        select: { name: true, type: true, duration: true },
      },
    },
  });

  if (!booking) notFound();

  // Solo el propietario de la reserva puede verla
  if (booking.userId !== session.user.id) notFound();

  const hasVehicleInfo = booking.vehicleModel || booking.vehiclePlate;

  return (
    <div className="container max-w-lg py-12">
      {/* Cabecera — varía según el estado */}
      <div className="text-center mb-8">
        {booking.status === "COMPLETED" ? (
          <>
            <div className="mx-auto mb-4 flex h-16 w-16 items-center justify-center rounded-full bg-green-50 border border-green-200">
              <CheckCircle className="h-8 w-8 text-gartify-green" aria-hidden="true" />
            </div>
            <h1 className="text-2xl font-bold text-gartify-blue mb-2">Servicio completado</h1>
            <p className="text-muted-foreground text-sm">
              El servicio ha sido realizado. Gracias por confiar en Gartify.
            </p>
          </>
        ) : booking.status === "CONFIRMED" ? (
          <>
            <div className="mx-auto mb-4 flex h-16 w-16 items-center justify-center rounded-full bg-green-50 border border-green-200">
              <CheckCircle className="h-8 w-8 text-gartify-green" aria-hidden="true" />
            </div>
            <h1 className="text-2xl font-bold text-gartify-blue mb-2">¡Reserva confirmada!</h1>
            <p className="text-muted-foreground text-sm">
              El taller ha confirmado tu cita. Te esperamos en la fecha indicada.
            </p>
          </>
        ) : booking.status === "CANCELLED" ? (
          <>
            <div className="mx-auto mb-4 flex h-16 w-16 items-center justify-center rounded-full bg-red-50 border border-red-200">
              <XCircle className="h-8 w-8 text-red-400" aria-hidden="true" />
            </div>
            <h1 className="text-2xl font-bold text-gartify-blue mb-2">Reserva cancelada</h1>
            <p className="text-muted-foreground text-sm">
              Esta cita ha sido cancelada. Puedes buscar otro taller cuando quieras.
            </p>
          </>
        ) : (
          <>
            <div className="mx-auto mb-4 flex h-16 w-16 items-center justify-center rounded-full bg-yellow-50 border border-yellow-200">
              <CheckCircle className="h-8 w-8 text-yellow-500" aria-hidden="true" />
            </div>
            <h1 className="text-2xl font-bold text-gartify-blue mb-2">¡Solicitud enviada!</h1>
            <p className="text-muted-foreground text-sm">
              Hemos enviado tu solicitud al taller. Te avisarán en breve para confirmar la cita.
            </p>
          </>
        )}
      </div>

      {/* Tarjeta principal */}
      <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden mb-4">
        {/* Franja de cabecera */}
        <div className="bg-gradient-to-r from-gartify-hero to-gartify-mid px-5 py-3 flex items-center justify-between">
          <p className="text-xs font-bold text-white/80 uppercase tracking-wide">
            Detalle de la reserva
          </p>
          <Badge className={`text-xs ${BOOKING_STATUS_COLORS[booking.status]}`}>
            {BOOKING_STATUS_LABELS[booking.status]}
          </Badge>
        </div>

        <div className="p-5 space-y-4 text-sm">
          {/* Taller */}
          <div className="flex items-start gap-3">
            <MapPin
              className="h-4 w-4 text-gartify-mid mt-0.5 shrink-0"
              aria-hidden="true"
            />
            <div>
              <p className="font-bold text-gartify-blue">{booking.garage.name}</p>
              <p className="text-muted-foreground text-xs">
                {booking.garage.address}, {booking.garage.city}
              </p>
            </div>
          </div>

          <div className="flex items-center gap-3">
            <Phone className="h-4 w-4 text-gartify-mid shrink-0" aria-hidden="true" />
            <a
              href={`tel:${booking.garage.phone}`}
              className="text-muted-foreground hover:text-gartify-blue transition-colors"
            >
              {formatPhone(booking.garage.phone)}
            </a>
          </div>

          <div className="h-px bg-gray-100" role="separator" />

          {/* Servicio + fecha */}
          <div className="flex items-start gap-3">
            <Calendar
              className="h-4 w-4 text-gartify-mid mt-0.5 shrink-0"
              aria-hidden="true"
            />
            <div>
              <p className="font-semibold text-foreground">
                <span className="inline-flex items-center rounded-full bg-blue-50 text-gartify-hero text-xs px-2 py-0.5 border border-blue-100 mr-2">
                  {SERVICE_LABELS[booking.service.type] ?? booking.service.type}
                </span>
                {booking.service.name}
              </p>
              <p className="text-muted-foreground text-xs mt-0.5">
                {formatDateTime(booking.date)}
              </p>
            </div>
          </div>

          <div className="flex items-center gap-3">
            <Clock className="h-4 w-4 text-gartify-mid shrink-0" aria-hidden="true" />
            <span className="text-muted-foreground">
              Duración estimada: {booking.service.duration} min
            </span>
          </div>

          {/* Vehículo */}
          {(hasVehicleInfo || booking.vehicleType) && (
            <>
              <div className="h-px bg-gray-100" role="separator" />
              <p className="text-xs font-bold uppercase tracking-wide text-gartify-gray">
                Vehículo
              </p>
              {/* Tipo de vehículo — siempre visible */}
              <div className="flex items-center gap-3">
                <Car className="h-4 w-4 text-gartify-mid shrink-0" aria-hidden="true" />
                <span className="flex items-center gap-1.5 text-foreground">
                  <span aria-hidden="true">{VEHICLE_ICONS[booking.vehicleType ?? "COCHE"]}</span>
                  {VEHICLE_LABELS[booking.vehicleType ?? "COCHE"] ?? booking.vehicleType}
                </span>
              </div>
              {booking.vehicleModel && (
                <div className="flex items-center gap-3">
                  <Car className="h-4 w-4 text-gartify-mid shrink-0" aria-hidden="true" />
                  <span className="text-foreground">{booking.vehicleModel}</span>
                </div>
              )}
              {booking.vehiclePlate && (
                <div className="flex items-center gap-3">
                  <Hash
                    className="h-4 w-4 text-gartify-mid shrink-0"
                    aria-hidden="true"
                  />
                  <span className="font-mono font-semibold text-gartify-blue tracking-wider">
                    {booking.vehiclePlate}
                  </span>
                </div>
              )}
            </>
          )}

          {/* Notas */}
          {booking.notes && (
            <>
              <div className="h-px bg-gray-100" role="separator" />
              <div className="flex items-start gap-3">
                <FileText
                  className="h-4 w-4 text-gartify-mid shrink-0 mt-0.5"
                  aria-hidden="true"
                />
                <div>
                  <p className="text-xs font-bold uppercase tracking-wide text-gartify-gray mb-1">
                    Notas
                  </p>
                  <p className="text-muted-foreground text-sm">{booking.notes}</p>
                </div>
              </div>
            </>
          )}

          {/* Código de reserva */}
          <div className="h-px bg-gray-100" role="separator" />
          <div className="flex items-center justify-between text-xs text-muted-foreground">
            <span>Ref. reserva</span>
            <span className="font-mono font-semibold text-gartify-blue tracking-wide">
              {booking.code || booking.id.slice(-8).toUpperCase()}
            </span>
          </div>

          {/* Total */}
          <div className="h-px bg-gray-100" role="separator" />
          <div className="flex items-center justify-between">
            <div className="flex items-center gap-2 text-muted-foreground">
              <Euro className="h-4 w-4" aria-hidden="true" />
              <span className="font-medium">Total a pagar en taller</span>
            </div>
            <span className="text-xl font-bold text-gartify-orange">
              {formatPrice(booking.totalPrice)}
            </span>
          </div>
        </div>
      </div>

      <p className="text-xs text-center text-muted-foreground mb-6">
        El pago se realiza directamente en el taller al recoger el vehículo.
      </p>

      <div className="flex gap-3 justify-center">
        {/* Navegación completa para evitar el router cache y mostrar la reserva nueva */}
        <a href="/cuenta">
          <Button variant="outline" className="border-gray-300 text-gartify-gray">
            Mis reservas
          </Button>
        </a>
        <Link href="/talleres">
          <Button className="bg-gartify-green hover:bg-gartify-green/90 text-white">
            Buscar otro taller
          </Button>
        </Link>
      </div>
    </div>
  );
}
