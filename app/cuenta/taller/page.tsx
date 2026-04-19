import type { Metadata } from "next";
import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { CalendarDays } from "lucide-react";
import type { GarageBookingItem } from "@/components/cuenta/GarageBookingList";
import { GarageBookingPoller } from "@/components/cuenta/GarageBookingPoller";
import { BannerExitoSuscripcion } from "@/components/cuenta/BannerExitoSuscripcion";

export const dynamic = "force-dynamic";

export const metadata: Metadata = {
  title: "Panel del taller",
  robots: { index: false, follow: false },
};

interface PropsTallerPortalPage {
  searchParams: Promise<Record<string, string | string[] | undefined>>;
}

export default async function TallerPortalPage({ searchParams }: PropsTallerPortalPage) {
  const params = await searchParams;
  const suscripcionActivada = params.success === "1";

  const session = await auth();
  if (!session?.user?.id) redirect("/login");

  const user = session.user as { id: string; role?: string };
  if (user.role !== "GARAGE_OWNER") redirect("/cuenta");

  // ── Query 1: datos básicos del garage (sin bookings) ──────────────────────
  // Separamos la query de bookings para poder tipar serviceRecord manualmente
  // mientras el cliente Prisma no incluye aún el modelo ServiceRecord.
  const garage = await db.garage.findUnique({
    where: { ownerId: user.id },
    select: {
      id: true,
      name: true,
      plan: true,
      planExpiresAt: true,
      stripeSubscriptionId: true,
      rating: true,
      services: {
        where: { isActive: true },
        select: { id: true },
      },
    },
  });

  if (!garage) redirect("/cuenta/taller/perfil");

  // ── Query 2: reservas con sello de revisión ───────────────────────────────
  // Usamos cast a unknown → tipo propio para que TypeScript no infiera el tipo
  // desde el cliente Prisma desactualizado (que no tiene ServiceRecord aún).
  // En tiempo de ejecución Prisma devuelve los datos correctos del schema real.
  // Una vez ejecutado `npm run db:generate` este cast puede eliminarse.
  const findManyBookings = db.booking.findMany as unknown as (
    args: unknown
  ) => Promise<GarageBookingItem[]>;

  const reservasRaw = await findManyBookings({
    where: { garageId: garage.id },
    select: {
      id: true,
      code: true,
      status: true,
      date: true,
      totalPrice: true,
      vehicleModel: true,
      vehiclePlate: true,
      notes: true,
      user: { select: { name: true, phone: true } },
      service: { select: { type: true, name: true, duration: true } },
      serviceRecord: { select: { id: true } },
    },
    orderBy: { date: "asc" },
  });

  return (
    <div className="w-full max-w-6xl mx-auto py-6 px-4 sm:px-8">
      {suscripcionActivada && <BannerExitoSuscripcion plan={garage.plan} />}

      <div className="bg-white border border-gray-200 overflow-hidden mb-5">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
          <div className="flex items-center gap-3">
            <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <CalendarDays className="h-5 w-5 text-gartify-blue" />
            </div>
            <div>
              <h1 className="text-base font-bold text-gartify-blue">Reservas</h1>
              <p className="text-xs text-gartify-gray mt-0.5">Gestiona las citas de {garage.name}</p>
            </div>
          </div>
        </div>
      </div>

      <GarageBookingPoller initialBookings={reservasRaw} garageId={garage.id} garageRating={garage.rating} />
    </div>
  );
}
