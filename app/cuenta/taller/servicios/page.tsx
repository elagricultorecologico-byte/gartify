import type { Metadata } from "next";
import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { ChevronLeft } from "lucide-react";
import Link from "next/link";
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
    <div className="container max-w-6xl py-8">
      <Link href="/cuenta/taller" className="inline-flex items-center gap-1.5 text-sm text-muted-foreground hover:text-gartify-blue mb-4">
        <ChevronLeft className="h-4 w-4" />
        Panel del taller
      </Link>
      <h1 className="text-2xl font-bold text-gartify-blue mb-6">Servicios</h1>

      <ServiciosManager garageId={garage.id} initialServices={garage.services} />
    </div>
  );
}
