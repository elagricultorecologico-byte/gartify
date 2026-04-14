import type { Metadata } from "next";
import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
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
      <div className="mb-8">
        <h1 className="text-2xl font-bold text-gartify-blue">Mis vehículos</h1>
        <p className="text-muted-foreground text-sm mt-1">
          Gestiona los vehículos asociados a tu cuenta para agilizar tus reservas.
        </p>
      </div>

      <VehicleList vehiculosIniciales={vehiculos} />
    </div>
  );
}
