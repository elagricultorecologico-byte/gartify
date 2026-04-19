import type { Metadata } from "next";
import { redirect } from "next/navigation";
import Link from "next/link";
import { Tag, Lock } from "lucide-react";
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
    <div className="w-full max-w-6xl mx-auto py-6 px-4 sm:px-8">
      <div className="bg-white border border-gray-200 overflow-hidden">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
          <div className="flex items-center gap-3">
            <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <Tag className="h-5 w-5 text-gartify-blue" />
            </div>
            <div>
              <h1 className="text-base font-bold text-gartify-blue">Ofertas de horario</h1>
              <p className="text-xs text-gartify-gray mt-0.5">Crea ofertas especiales por días y horas para atraer más clientes</p>
            </div>
          </div>
        </div>
        <div className="p-6">
          {!planPermitido ? (
            <div className="bg-amber-50 border border-amber-200 p-8 text-center">
              <Lock className="h-10 w-10 text-amber-400 mx-auto mb-3" />
              <h2 className="font-bold text-amber-800 text-lg mb-1">Función disponible en Plan Pro</h2>
              <p className="text-sm text-amber-700 mb-4">
                Las ofertas especiales de horario están incluidas en los planes Pro y Premium.
              </p>
              <Link
                href="/cuenta/taller/planes"
                className="inline-flex items-center gap-2 bg-gartify-orange text-white text-sm font-semibold px-5 py-2 hover:bg-gartify-orange/90 transition-colors"
              >
                Ver planes
              </Link>
            </div>
          ) : (
            <GarageOfferForm ofertas={taller.offers} />
          )}
        </div>
      </div>
    </div>
  );
}
