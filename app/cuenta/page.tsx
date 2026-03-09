import { redirect } from "next/navigation";
import Link from "next/link";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Card, CardContent } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";
import { Button } from "@/components/ui/button";
import { Calendar, MapPin, Car } from "lucide-react";
import { formatPrice, formatDateTime, BOOKING_STATUS_LABELS, BOOKING_STATUS_COLORS, SERVICE_LABELS } from "@/lib/utils";

export default async function CuentaPage() {
  const session = await auth();
  if (!session?.user?.id) redirect("/login");

  const user = session.user as { id: string; name?: string | null; role?: string };

  // Redirect garage owners to their portal
  if (user.role === "GARAGE_OWNER") redirect("/cuenta/taller");

  const bookings = await db.booking.findMany({
    where: { userId: user.id },
    include: { garage: true, service: true, review: true },
    orderBy: { createdAt: "desc" },
  });

  return (
    <div className="container max-w-3xl py-10">
      <div className="mb-8">
        <h1 className="text-2xl font-bold text-foreground">Mis reservas</h1>
        <p className="text-muted-foreground text-sm mt-1">
          Hola, {user.name?.split(" ")[0]}. Aquí puedes gestionar tus citas.
        </p>
      </div>

      {bookings.length === 0 ? (
        <div className="text-center py-16">
          <Calendar className="h-10 w-10 mx-auto mb-3 text-muted-foreground opacity-40" />
          <p className="font-medium text-foreground">Aún no tienes reservas</p>
          <p className="text-sm text-muted-foreground mt-1 mb-6">Busca un taller y reserva tu primera cita</p>
          <Link href="/talleres"><Button>Buscar talleres</Button></Link>
        </div>
      ) : (
        <div className="space-y-4">
          {bookings.map((b) => (
            <Card key={b.id}>
              <CardContent className="p-5">
                <div className="flex items-start justify-between gap-4">
                  <div className="flex-1 space-y-1.5">
                    <div className="flex items-center gap-2">
                      <p className="font-semibold text-foreground">{b.garage.name}</p>
                      <Badge className={BOOKING_STATUS_COLORS[b.status]}>
                        {BOOKING_STATUS_LABELS[b.status]}
                      </Badge>
                    </div>
                    <p className="text-sm text-muted-foreground">
                      {SERVICE_LABELS[b.service.type]} — {b.service.name}
                    </p>
                    <div className="flex items-center gap-3 text-xs text-muted-foreground">
                      <span className="flex items-center gap-1"><Calendar className="h-3.5 w-3.5" />{formatDateTime(b.date)}</span>
                      <span className="flex items-center gap-1"><MapPin className="h-3.5 w-3.5" />{b.garage.city}</span>
                      {b.vehicleModel && <span className="flex items-center gap-1"><Car className="h-3.5 w-3.5" />{b.vehicleModel}</span>}
                    </div>
                  </div>
                  <div className="text-right shrink-0">
                    <p className="text-lg font-bold text-gartify-orange">{formatPrice(b.totalPrice)}</p>
                    <Link href={`/reserva/${b.id}`}>
                      <Button variant="ghost" size="sm" className="text-xs mt-1">Ver detalle</Button>
                    </Link>
                  </div>
                </div>
              </CardContent>
            </Card>
          ))}
        </div>
      )}
    </div>
  );
}
