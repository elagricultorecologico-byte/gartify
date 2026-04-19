import type { Metadata } from "next";
import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Wrench } from "lucide-react";
import { ServiciosManager } from "@/components/cuenta/ServiciosManager";

export const metadata: Metadata = {
  title: "Servicios del taller",
  robots: { index: false, follow: false },
};

export default async function ServiciosPage() {
  const session = await auth();
  if (!session?.user?.id) redirect("/login");
  const user = session.user as { id: string; role?: string };
  if (user.role !== "GARAGE_OWNER") redirect("/cuenta");

  const garage = await db.garage.findUnique({
    where: { ownerId: user.id },
    select: {
      id: true,
      services: {
        select: {
          id:           true,
          type:         true,
          name:         true,
          description:  true,
          duration:     true,
          price:        true,
          isActive:     true,
          vehicleTypes: true,
        },
        orderBy: { name: "asc" },
      },
    },
  });

  if (!garage) redirect("/cuenta/taller/perfil");

  return (
    <div className="w-full max-w-6xl mx-auto py-6 px-4 sm:px-8">
      <div className="bg-white border border-gray-200 overflow-hidden mb-5">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
          <div className="flex items-center gap-3">
            <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <Wrench className="h-5 w-5 text-gartify-blue" />
            </div>
            <div>
              <h1 className="text-base font-bold text-gartify-blue">Servicios del taller</h1>
              <p className="text-xs text-gartify-gray mt-0.5">Gestiona los servicios que ofrece tu taller a los clientes</p>
            </div>
          </div>
        </div>
      </div>
      <ServiciosManager garageId={garage.id} initialServices={garage.services} />
    </div>
  );
}
