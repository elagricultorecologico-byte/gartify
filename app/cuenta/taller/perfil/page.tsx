import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { GarageProfileForm } from "@/components/cuenta/GarageProfileForm";

export default async function PerfilTallerPage() {
  const session = await auth();
  if (!session?.user) redirect("/login");

  const garage = await db.garage.findUnique({ where: { ownerId: session.user.id } });
  if (!garage) redirect("/cuenta/taller");

  return (
    <div className="container max-w-2xl py-8">
      <div className="mb-6">
        <h1 className="text-2xl font-bold text-foreground">Editar perfil del taller</h1>
        <p className="text-muted-foreground mt-1">Actualiza la información pública de tu taller.</p>
      </div>
      <GarageProfileForm garage={garage} />
    </div>
  );
}
