import type { Metadata } from "next";
import { redirect } from "next/navigation";
import Link from "next/link";
import { ChevronLeft, Tag } from "lucide-react";
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

      <div className="bg-white rounded-xl border border-gartify-orange/25 shadow-sm p-6">
        <h2 className="font-bold text-gartify-blue mb-4 flex items-center gap-2">
          <Tag className="h-4 w-4 text-gartify-orange" aria-hidden="true" />
          Nueva oferta
        </h2>

        {/* Componente cliente con formulario + listado interactivo */}
        <GarageOfferForm ofertas={taller.offers} />
      </div>
    </div>
  );
}
