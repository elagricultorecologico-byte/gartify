import { redirect } from "next/navigation";
import Link from "next/link";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";
import { Button } from "@/components/ui/button";
import { Settings, Plus, Calendar, Euro, Star, TrendingUp } from "lucide-react";
import { formatPrice, formatDateTime, BOOKING_STATUS_LABELS, BOOKING_STATUS_COLORS, SERVICE_LABELS } from "@/lib/utils";
import { BookingStatusUpdater } from "@/components/cuenta/BookingStatusUpdater";

export default async function TallerPortalPage() {
  const session = await auth();
  if (!session?.user?.id) redirect("/login");

  const user = session.user as { id: string; role?: string };
  if (user.role !== "GARAGE_OWNER") redirect("/cuenta");

  const garage = await db.garage.findUnique({
    where: { ownerId: user.id },
    include: {
      services: { where: { isActive: true } },
      bookings: {
        include: { user: { select: { name: true, phone: true } }, service: true },
        orderBy: { date: "desc" },
        take: 20,
      },
    },
  });

  if (!garage) redirect("/cuenta/taller/perfil");

  const pending   = garage.bookings.filter((b) => b.status === "PENDING").length;
  const confirmed = garage.bookings.filter((b) => b.status === "CONFIRMED").length;
  const revenue   = garage.bookings.filter((b) => b.status === "COMPLETED").reduce((s, b) => s + b.totalPrice, 0);

  return (
    <div className="container max-w-5xl py-10">
      <div className="flex items-center justify-between mb-8">
        <div>
          <h1 className="text-2xl font-bold text-foreground">{garage.name}</h1>
          <p className="text-muted-foreground text-sm mt-1">Panel de gestión del taller</p>
        </div>
        <div className="flex gap-2">
          <Link href="/cuenta/taller/servicios">
            <Button variant="outline" size="sm" className="gap-2"><Plus className="h-4 w-4" />Servicios</Button>
          </Link>
          <Link href="/cuenta/taller/perfil">
            <Button variant="outline" size="sm" className="gap-2"><Settings className="h-4 w-4" />Perfil</Button>
          </Link>
        </div>
      </div>

      {/* Stats */}
      <div className="grid grid-cols-2 md:grid-cols-4 gap-4 mb-8">
        {[
          { icon: Calendar,  label: "Pendientes",  value: pending,                  color: "text-yellow-400" },
          { icon: TrendingUp,label: "Confirmadas", value: confirmed,                color: "text-blue-400" },
          { icon: Euro,      label: "Facturado",   value: formatPrice(revenue),     color: "text-gartify-orange" },
          { icon: Star,      label: "Valoración",  value: garage.rating.toFixed(1), color: "text-yellow-400" },
        ].map(({ icon: Icon, label, value, color }) => (
          <Card key={label}>
            <CardContent className="p-4 flex items-center gap-3">
              <Icon className={`h-5 w-5 ${color} shrink-0`} />
              <div>
                <p className="text-xs text-muted-foreground">{label}</p>
                <p className="font-bold text-foreground">{value}</p>
              </div>
            </CardContent>
          </Card>
        ))}
      </div>

      {/* Bookings */}
      <Card>
        <CardHeader>
          <CardTitle className="text-base">Reservas recientes</CardTitle>
        </CardHeader>
        <CardContent className="p-0">
          {garage.bookings.length === 0 ? (
            <p className="text-center text-muted-foreground py-8 text-sm">Aún no hay reservas</p>
          ) : (
            <div className="divide-y divide-border">
              {garage.bookings.map((b) => (
                <div key={b.id} className="p-4 flex items-start justify-between gap-4">
                  <div className="space-y-1 flex-1">
                    <div className="flex items-center gap-2">
                      <p className="font-medium text-foreground text-sm">{b.user.name ?? "Cliente"}</p>
                      {b.user.phone && <span className="text-xs text-muted-foreground">{b.user.phone}</span>}
                    </div>
                    <p className="text-xs text-muted-foreground">
                      {SERVICE_LABELS[b.service.type]} — {b.service.name} · {formatDateTime(b.date)}
                    </p>
                    {b.vehicleModel && <p className="text-xs text-muted-foreground">{b.vehicleModel}{b.vehiclePlate ? ` (${b.vehiclePlate})` : ""}</p>}
                  </div>
                  <div className="flex items-center gap-3 shrink-0">
                    <p className="text-sm font-bold text-gartify-orange">{formatPrice(b.totalPrice)}</p>
                    <BookingStatusUpdater bookingId={b.id} currentStatus={b.status} />
                  </div>
                </div>
              ))}
            </div>
          )}
        </CardContent>
      </Card>
    </div>
  );
}
