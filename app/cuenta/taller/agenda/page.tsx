import type { Metadata } from "next";
import { redirect } from "next/navigation";
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
    <div className="w-full max-w-6xl mx-auto py-6 px-4 sm:px-8">
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
