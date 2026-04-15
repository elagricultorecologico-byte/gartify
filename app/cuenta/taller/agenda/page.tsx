import type { Metadata } from "next";
import { redirect } from "next/navigation";
import Link from "next/link";
import { ChevronLeft } from "lucide-react";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { AgendaTaller } from "@/components/cuenta/AgendaTaller";

export const dynamic = "force-dynamic";

export const metadata: Metadata = {
  title: "Agenda del taller",
  robots: { index: false, follow: false },
};

export default async function AgendaPage() {
  const session = await auth();
  if (!session?.user?.id) redirect("/login");

  const user = session.user as { id: string; role?: string };
  if (user.role !== "GARAGE_OWNER") redirect("/cuenta");

  const garage = await db.garage.findUnique({
    where: { ownerId: user.id },
    select: { id: true, name: true },
  });
  if (!garage) redirect("/cuenta/taller");

  return (
    <div className="container max-w-5xl py-8 px-4 sm:px-8">
      <div className="flex items-center justify-between mb-6">
        <Link
          href="/cuenta/taller"
          className="inline-flex items-center gap-1.5 text-sm text-muted-foreground hover:text-gartify-blue transition-colors"
        >
          <ChevronLeft className="h-4 w-4" />
          Panel del taller
        </Link>
      </div>

      <div className="mb-6">
        <h1 className="text-2xl font-bold text-gartify-blue">Agenda</h1>
        <p className="text-muted-foreground text-sm mt-1">
          Gestiona todas las citas de {garage.name} — Gartify y manuales.
        </p>
      </div>

      <AgendaTaller garageId={garage.id} />
    </div>
  );
}
