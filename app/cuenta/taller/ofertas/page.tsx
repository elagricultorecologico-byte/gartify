import type { Metadata } from "next";
import { redirect } from "next/navigation";
import Link from "next/link";
import { ChevronLeft, Tag, Lock } from "lucide-react";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { GarageOfferForm } from "@/components/cuenta/GarageOfferForm";

export const metadata: Metadata = {
  title: "Ofertas del taller",
  robots: { index: false, follow: false },
};

export default async function OfertasPage() {
  const sesion = await auth();
  if (!sesion?.user?.id) redirect("/login");

  const usuario = sesion.user as { id: string; role?: string };
  if (usuario.role !== "GARAGE_OWNER") redirect("/cuenta");

  const taller = await db.garage.findUnique({
    where: { ownerId: usuario.id },
    select: {
      id: true,
      plan: true,
      offers: {
        orderBy: { createdAt: "desc" },
        select: {
          id:        true,
          label:     true,
          days:      true,
          startTime: true,
          endTime:   true,
          price:     true,
          isActive:  true,
        },
      },
    },
  });

  if (!taller) redirect("/cuenta/taller/perfil");

  const planPermitido = taller.plan === "PRO" || taller.plan === "PREMIUM";

  return (
    <div className="container max-w-3xl py-10">
      <Link
        href="/cuenta/taller"
        className="inline-flex items-center gap-1.5 text-sm text-muted-foreground hover:text-gartify-blue mb-6"
      >
        <ChevronLeft className="h-4 w-4" />
        Panel del taller
      </Link>

      <h1 className="text-2xl font-bold text-gartify-blue mb-6">Ofertas de horario</h1>

      {!planPermitido ? (
        <div className="bg-amber-50 border border-amber-200 rounded-xl p-8 text-center">
          <Lock className="h-10 w-10 text-amber-400 mx-auto mb-3" />
          <h2 className="font-bold text-amber-800 text-lg mb-1">Función disponible en Plan Pro</h2>
          <p className="text-sm text-amber-700 mb-4">
            Las ofertas especiales de horario están incluidas en los planes Pro y Premium.
          </p>
          <Link
            href="/cuenta/taller/planes"
            className="inline-flex items-center gap-2 bg-gartify-orange text-white text-sm font-semibold px-5 py-2 rounded-lg hover:bg-gartify-orange/90 transition-colors"
          >
            Ver planes
          </Link>
        </div>
      ) : (
        <div className="bg-white rounded-xl border border-gartify-orange/25 shadow-sm p-6">
          <h2 className="font-bold text-gartify-blue mb-4 flex items-center gap-2">
            <Tag className="h-4 w-4 text-gartify-orange" aria-hidden="true" />
            Nueva oferta
          </h2>
          <GarageOfferForm ofertas={taller.offers} />
        </div>
      )}
    </div>
  );
}
