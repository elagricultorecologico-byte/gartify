import type { Metadata } from "next";
import { redirect } from "next/navigation";
import Link from "next/link";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Button } from "@/components/ui/button";
import {
  Settings, Plus, Calendar, Euro, Star,
  TrendingUp, CalendarClock, Package, Tag, Wrench, Zap, Crown, CreditCard,
} from "lucide-react";
import { formatPrice } from "@/lib/utils";
import { GarageBookingList } from "@/components/cuenta/GarageBookingList";
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
      bookings: {
        select: {
          id: true,
          status: true,
          date: true,
          totalPrice: true,
          vehicleModel: true,
          vehiclePlate: true,
          notes: true,
          user: { select: { name: true, phone: true } },
          service: { select: { type: true, name: true, duration: true } },
        },
        orderBy: { date: "asc" },
      },
    },
  });

  if (!garage) redirect("/cuenta/taller/perfil");

  const pending   = garage.bookings.filter((b) => b.status === "PENDING").length;
  const confirmed = garage.bookings.filter((b) => b.status === "CONFIRMED").length;
  const revenue   = garage.bookings
    .filter((b) => b.status === "COMPLETED")
    .reduce((s, b) => s + b.totalPrice, 0);

  const stats = [
    { icon: Calendar,   label: "Pendientes",  value: pending,                  color: "text-yellow-500",     bg: "bg-yellow-50",  border: "border-yellow-100" },
    { icon: TrendingUp, label: "Confirmadas", value: confirmed,                color: "text-gartify-mid",    bg: "bg-blue-50",    border: "border-blue-100" },
    { icon: Euro,       label: "Facturado",   value: formatPrice(revenue),     color: "text-gartify-orange", bg: "bg-orange-50",  border: "border-orange-100" },
    { icon: Star,       label: "Valoración",  value: garage.rating.toFixed(1), color: "text-yellow-500",     bg: "bg-yellow-50",  border: "border-yellow-100" },
  ];

  return (
    <div className="container max-w-5xl py-10">
      {/* Banner de confirmación de suscripción exitosa */}
      {suscripcionActivada && <BannerExitoSuscripcion plan={garage.plan} />}

      <div className="flex items-center justify-between mb-8">
        <div>
          <div className="flex items-center gap-3 mb-1">
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
          <p className="text-muted-foreground text-sm">Panel de gestión del taller</p>
          {/* Fecha de próxima renovación para planes de pago */}
          {garage.planExpiresAt && garage.plan !== "STARTER" && (
            <p className="text-xs text-muted-foreground">
              Renueva el{" "}
              {new Intl.DateTimeFormat("es-ES", { dateStyle: "medium" }).format(garage.planExpiresAt)}
            </p>
          )}
        </div>
        <div className="flex gap-2 flex-wrap">
          <Link href="/cuenta/taller/planes">
            <Button
              variant="outline"
              size="sm"
              className="gap-2 border-gartify-orange/50 text-gartify-orange hover:bg-orange-50 font-semibold"
            >
              <CreditCard className="h-4 w-4" aria-hidden="true" />
              {garage.stripeSubscriptionId ? "Gestionar plan" : "Mejorar plan"}
            </Button>
          </Link>
          <Link href="/cuenta/taller/servicios">
            <Button variant="outline" size="sm" className="gap-2 border-gartify-blue/30 text-gartify-blue hover:bg-gartify-blue/5">
              <Plus className="h-4 w-4" aria-hidden="true" />
              Servicios
            </Button>
          </Link>
          <Link href="/cuenta/taller/horario">
            <Button variant="outline" size="sm" className="gap-2 border-gartify-blue/30 text-gartify-blue hover:bg-gartify-blue/5">
              <CalendarClock className="h-4 w-4" aria-hidden="true" />
              Horario
            </Button>
          </Link>
          <Link href="/cuenta/taller/ofertas">
            <Button variant="outline" size="sm" className="gap-2 border-gartify-orange/40 text-gartify-orange hover:bg-orange-50">
              <Tag className="h-4 w-4" aria-hidden="true" />
              Ofertas
            </Button>
          </Link>
          <Link href="/cuenta/taller/recambios">
            <Button variant="outline" size="sm" className="gap-2 border-gartify-orange/40 text-gartify-orange hover:bg-orange-50">
              <Package className="h-4 w-4" aria-hidden="true" />
              Recambios
            </Button>
          </Link>
          <Link href="/cuenta/taller/perfil">
            <Button variant="outline" size="sm" className="gap-2 border-gartify-blue/30 text-gartify-blue hover:bg-gartify-blue/5">
              <Settings className="h-4 w-4" aria-hidden="true" />
              Perfil
            </Button>
          </Link>
        </div>
      </div>

      <div className="grid grid-cols-2 md:grid-cols-4 gap-4 mb-8">
        {stats.map(({ icon: Icon, label, value, color, bg, border }) => (
          <div key={label} className={`rounded-xl border ${border} ${bg} p-4 flex items-center gap-3`}>
            <div className="h-10 w-10 rounded-full bg-white flex items-center justify-center shadow-sm shrink-0">
              <Icon className={`h-5 w-5 ${color}`} aria-hidden="true" />
            </div>
            <div>
              <p className="text-xs text-muted-foreground">{label}</p>
              <p className="font-bold text-foreground text-lg leading-tight">{value}</p>
            </div>
          </div>
        ))}
      </div>

      <GarageBookingList bookings={garage.bookings} />
    </div>
  );
}
