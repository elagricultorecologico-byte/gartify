import type { Metadata } from "next";
import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { GarageProfileForm } from "@/components/cuenta/GarageProfileForm";

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
      <GarageProfileForm garage={garage} />
    </div>
  );
}
