import type { Metadata } from "next";
import { redirect } from "next/navigation";
import Link from "next/link";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Button } from "@/components/ui/button";
import { Calendar, Car } from "lucide-react";
import { AutoRefresh } from "@/components/cuenta/AutoRefresh";
import { CustomerBookingList } from "@/components/cuenta/CustomerBookingList";

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

  return (
    <div className="container max-w-5xl py-10 px-4 sm:px-8">
      {/* Cabecera */}
      <div className="mb-8 flex flex-col sm:flex-row sm:items-end justify-between gap-4">
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
        <div className="flex items-center gap-3 flex-wrap">
          {/* Acceso directo a mis vehículos */}
          <Link href="/cuenta/vehiculos">
            <button className="flex items-center gap-2 rounded-xl border border-gartify-blue/30 bg-white px-3 py-2 text-xs font-semibold text-gartify-blue hover:bg-gartify-blue/5 transition-colors">
              <Car className="h-4 w-4 shrink-0" aria-hidden="true" />
              Mis vehículos
            </button>
          </Link>
          <AutoRefresh />
        </div>
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
        <CustomerBookingList bookings={bookings} />
      )}
    </div>
  );
}
