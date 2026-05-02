import type { Metadata } from "next";
import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Building2 } from "lucide-react";
import { GarageProfileForm } from "@/components/cuenta/GarageProfileForm";
import { EliminarCuentaButton } from "@/components/cuenta/EliminarCuentaButton";

export const metadata: Metadata = {
  title: "Editar perfil del taller",
  robots: { index: false, follow: false },
};

export default async function PerfilTallerPage() {
  const session = await auth();
  if (!session?.user?.id) redirect("/login");

  const user = session.user as { id: string; role?: string };
  if (user.role !== "GARAGE_OWNER") redirect("/cuenta");

  const garage = await db.garage.findUnique({ where: { ownerId: user.id } });
  if (!garage) redirect("/cuenta/taller");

  return (
    <div className="w-full max-w-6xl mx-auto py-6 px-4 sm:px-8">
      <div className="bg-white border border-gray-200 overflow-hidden">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
          <div className="flex items-center gap-3">
            <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <Building2 className="h-5 w-5 text-gartify-blue" />
            </div>
            <div>
              <h1 className="text-base font-bold text-gartify-blue">Perfil del taller</h1>
              <p className="text-xs text-gartify-gray mt-0.5">Información pública que verán los clientes al buscar talleres</p>
            </div>
          </div>
        </div>
        <div className="p-6">
          <GarageProfileForm garage={garage} />
        </div>
        <div className="px-6 pb-5 border-t border-gray-100 pt-4 flex justify-end">
          <EliminarCuentaButton rol="taller" />
        </div>
      </div>
    </div>
  );
}
