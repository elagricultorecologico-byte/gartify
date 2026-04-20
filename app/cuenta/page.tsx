import type { Metadata } from "next";
import { redirect } from "next/navigation";
import Link from "next/link";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Button } from "@/components/ui/button";
import { Calendar, Car, Search } from "lucide-react";
import { CustomerBookingPoller } from "@/components/cuenta/CustomerBookingPoller";

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
      serviceLabel: true,
      service: { select: { type: true, name: true } },
      review: { select: { id: true } },
    },
    orderBy: { date: "asc" },
  });

  return (
    <div className="container max-w-5xl py-10 px-4 sm:px-8">
      <div className="bg-white border border-gray-200 overflow-hidden mb-8">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
          <div className="flex items-center justify-between gap-4">
            <div className="flex items-center gap-3">
              <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
                <Calendar className="h-5 w-5 text-gartify-blue" />
              </div>
              <div>
                <h1 className="text-base font-bold text-gartify-blue">Mis reservas</h1>
                <p className="text-xs text-gartify-gray mt-0.5">
                  Hola, <span className="font-semibold">{user.name?.split(" ")[0]}</span>. Aquí puedes gestionar tus citas.
                </p>
              </div>
            </div>
            <div className="flex items-center gap-2 flex-wrap shrink-0">
              <Link href="/cuenta/vehiculos">
                <button className="flex items-center gap-2 border border-gartify-blue/30 bg-white px-3 py-2 text-xs font-semibold text-gartify-blue hover:bg-gartify-blue/5 transition-colors">
                  <Car className="h-4 w-4 shrink-0" aria-hidden="true" />
                  Mis vehículos
                </button>
              </Link>
              <Link href="/talleres">
                <button className="flex items-center gap-2 bg-gartify-orange hover:bg-orange-600 px-4 py-2 text-xs font-bold text-white transition-colors">
                  <Search className="h-4 w-4 shrink-0" aria-hidden="true" />
                  Nueva cita
                </button>
              </Link>
            </div>
          </div>
        </div>
      </div>

      {bookings.length === 0 ? (
        <div className="text-center py-16 border border-dashed border-gray-200 bg-gray-50">
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
        <CustomerBookingPoller initialBookings={bookings} />
      )}
    </div>
  );
}
