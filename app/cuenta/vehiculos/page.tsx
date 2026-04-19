import type { Metadata } from "next";
import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Car } from "lucide-react";
import { VehicleList } from "@/components/cuenta/VehicleList";

export const dynamic = "force-dynamic";

export const metadata: Metadata = {
  title: "Mis vehículos",
  robots: { index: false, follow: false },
};

export default async function MisVehiculosPage() {
  const sesion = await auth();
  if (!sesion?.user?.id) redirect("/login");

  const usuario = sesion.user as { id: string; role?: string };

  // Solo clientes tienen vehículos registrados
  if (usuario.role === "ADMIN") redirect("/admin");
  if (usuario.role === "GARAGE_OWNER") redirect("/cuenta/taller");

  const vehiculos = await db.vehicle.findMany({
    where: { userId: usuario.id },
    orderBy: { createdAt: "desc" },
  });

  return (
    <div className="container max-w-5xl py-10 px-4 sm:px-8">
      <div className="bg-white border border-gray-200 overflow-hidden mb-6">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
          <div className="flex items-center gap-3">
            <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <Car className="h-5 w-5 text-gartify-blue" />
            </div>
            <div>
              <h1 className="text-base font-bold text-gartify-blue">Mis vehículos</h1>
              <p className="text-xs text-gartify-gray mt-0.5">Gestiona los vehículos asociados a tu cuenta para agilizar tus reservas</p>
            </div>
          </div>
        </div>
      </div>
      <VehicleList vehiculosIniciales={vehiculos} />
    </div>
  );
}
