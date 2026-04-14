import type { Metadata } from "next";
import { redirect } from "next/navigation";
import Link from "next/link";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import {
  Plus, CalendarClock, Package, Tag, Wrench, Zap, Crown, CreditCard, Tv,
} from "lucide-react";
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
      {/* Banner de confirmación de suscripción exitosa */}
      {suscripcionActivada && <BannerExitoSuscripcion plan={garage.plan} />}

      <div className="flex flex-col sm:flex-row sm:items-center sm:justify-between gap-4 mb-8">
        <div>
          <div className="flex items-center gap-2 mb-1 flex-wrap">
            <h1 className="text-2xl font-bold text-gartify-blue">{garage.name}</h1>
            {garage.plan === "STARTER" && (
              <span className="inline-flex items-center gap-1.5 rounded-full bg-gray-100 border border-gray-200 text-gray-600 text-xs font-bold px-3 py-1">
                <Wrench className="h-3.5 w-3.5" />
                Starter
              </span>
            )}
            {garage.plan === "PRO" && (
              <span className="inline-flex items-center gap-1.5 rounded-full bg-blue-100 border border-blue-200 text-blue-700 text-xs font-bold px-3 py-1">
                <Zap className="h-3.5 w-3.5" />
                Pro
              </span>
            )}
            {garage.plan === "PREMIUM" && (
              <span className="inline-flex items-center gap-1.5 rounded-full bg-amber-100 border border-amber-300 text-amber-700 text-xs font-bold px-3 py-1">
                <Crown className="h-3.5 w-3.5" />
                Premium
              </span>
            )}
          </div>
          <p className="text-muted-foreground text-xs sm:text-sm">Panel de gestión del taller</p>
          {/* Fecha de próxima renovación para planes de pago */}
          {garage.planExpiresAt && garage.plan !== "STARTER" && (
            <p className="text-xs text-muted-foreground">
              Renueva el{" "}
              {new Intl.DateTimeFormat("es-ES", { dateStyle: "medium" }).format(garage.planExpiresAt)}
            </p>
          )}
        </div>
        {/* Botonera: grid táctil en móvil, fila en desktop */}
        <div className="grid grid-cols-3 sm:flex sm:flex-wrap gap-2">
          {[
            { href: "/cuenta/taller/planes",    icon: CreditCard,   label: garage.stripeSubscriptionId ? "Mi plan" : "Plan",      color: "text-gartify-orange border-gartify-orange/40 hover:bg-orange-50" },
            { href: "/cuenta/taller/servicios", icon: Plus,         label: "Servicios",  color: "text-gartify-blue border-gartify-blue/30 hover:bg-gartify-blue/5" },
            { href: "/cuenta/taller/horario",   icon: CalendarClock,label: "Horario",    color: "text-gartify-blue border-gartify-blue/30 hover:bg-gartify-blue/5" },
            { href: "/cuenta/taller/ofertas",   icon: Tag,          label: "Ofertas",    color: "text-gartify-orange border-gartify-orange/40 hover:bg-orange-50" },
            { href: "/cuenta/taller/recambios", icon: Package,      label: "Recambios",  color: "text-gartify-orange border-gartify-orange/40 hover:bg-orange-50" },
            { href: "/cuenta/taller/perfil",    icon: Wrench,       label: "Perfil",     color: "text-gartify-blue border-gartify-blue/30 hover:bg-gartify-blue/5" },
          ].map(({ href, icon: Icon, label, color }) => (
            <Link key={href} href={href}>
              <button className={`w-full flex flex-col sm:flex-row items-center justify-center sm:justify-start gap-1 sm:gap-2 rounded-xl border bg-white px-3 py-3 sm:py-2 text-xs font-semibold transition-colors ${color}`}>
                <Icon className="h-4 w-4 shrink-0" aria-hidden="true" />
                <span>{label}</span>
              </button>
            </Link>
          ))}
        </div>
      </div>

      {/* Acceso al modo TV */}
      <div className="flex items-center justify-end gap-3 mb-3">
        <Link
          href="/cuenta/taller/tv"
          className="hidden sm:flex items-center gap-1.5 text-xs text-muted-foreground hover:text-gartify-blue transition-colors"
          aria-label="Abrir modo TV"
        >
          <Tv className="h-3.5 w-3.5" aria-hidden="true" />
          Modo TV
        </Link>
      </div>

      <GarageBookingPoller initialBookings={reservasRaw} garageId={garage.id} garageRating={garage.rating} />
    </div>
  );
}
