import { notFound } from "next/navigation";
import Link from "next/link";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Card, CardContent } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { CheckCircle, Calendar, MapPin, Phone, Car } from "lucide-react";
import { formatPrice, formatDateTime, SERVICE_LABELS } from "@/lib/utils";

export default async function BookingConfirmationPage({ params }: { params: { id: string } }) {
  const session = await auth();

  const booking = await db.booking.findUnique({
    where: { id: params.id },
    include: { garage: true, service: true, user: { select: { name: true } } },
  });

  if (!booking) notFound();

  return (
    <div className="container max-w-lg py-16 text-center">
      <div className="mx-auto mb-6 flex h-16 w-16 items-center justify-center rounded-full bg-green-500/10 border border-green-500/20">
        <CheckCircle className="h-8 w-8 text-green-400" />
      </div>
      <h1 className="text-2xl font-bold text-foreground mb-2">¡Reserva confirmada!</h1>
      <p className="text-muted-foreground mb-8">
        Hemos enviado los detalles al taller. Te contactarán si necesitan confirmación.
      </p>

      <Card className="text-left mb-6">
        <CardContent className="p-5 space-y-3 text-sm">
          <div className="flex items-start gap-3">
            <MapPin className="h-4 w-4 text-gartify-orange mt-0.5 shrink-0" />
            <div>
              <p className="font-semibold text-foreground">{booking.garage.name}</p>
              <p className="text-muted-foreground">{booking.garage.address}, {booking.garage.city}</p>
            </div>
          </div>
          <div className="flex items-center gap-3">
            <Phone className="h-4 w-4 text-muted-foreground shrink-0" />
            <span className="text-muted-foreground">{booking.garage.phone}</span>
          </div>
          <div className="flex items-start gap-3">
            <Calendar className="h-4 w-4 text-gartify-orange mt-0.5 shrink-0" />
            <div>
              <p className="font-semibold text-foreground">{SERVICE_LABELS[booking.service.type]} — {booking.service.name}</p>
              <p className="text-muted-foreground">{formatDateTime(booking.date)}</p>
            </div>
          </div>
          {booking.vehicleModel && (
            <div className="flex items-center gap-3">
              <Car className="h-4 w-4 text-muted-foreground shrink-0" />
              <span className="text-muted-foreground">{booking.vehicleModel}{booking.vehiclePlate ? ` · ${booking.vehiclePlate}` : ""}</span>
            </div>
          )}
          <div className="flex justify-between font-bold text-base pt-2 border-t border-border">
            <span className="text-foreground">Total a pagar en taller</span>
            <span className="text-gartify-orange">{formatPrice(booking.totalPrice)}</span>
          </div>
        </CardContent>
      </Card>

      <div className="flex gap-3 justify-center">
        <Link href="/cuenta">
          <Button variant="outline">Mis reservas</Button>
        </Link>
        <Link href="/talleres">
          <Button>Buscar otro taller</Button>
        </Link>
      </div>
    </div>
  );
}
