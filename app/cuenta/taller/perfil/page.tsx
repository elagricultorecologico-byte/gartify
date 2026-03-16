import type { Metadata } from "next";
import { redirect } from "next/navigation";
import Link from "next/link";
import { ChevronLeft } from "lucide-react";
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
    <div className="container max-w-2xl py-8">
      <Link
        href="/cuenta/taller"
        className="inline-flex items-center gap-1.5 text-sm text-muted-foreground hover:text-gartify-blue mb-6 transition-colors"
      >
        <ChevronLeft className="h-4 w-4" aria-hidden="true" />
        Panel del taller
      </Link>
      <GarageProfileForm garage={garage} />
    </div>
  );
}
