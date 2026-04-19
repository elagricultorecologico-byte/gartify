import type { Metadata } from "next";
import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { CalendarDays } from "lucide-react";
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
      <div className="bg-white border border-gray-200 overflow-hidden mb-5">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
          <div className="flex items-center gap-3">
            <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <CalendarDays className="h-5 w-5 text-gartify-blue" />
            </div>
            <div>
              <h1 className="text-base font-bold text-gartify-blue">Agenda</h1>
              <p className="text-xs text-gartify-gray mt-0.5">Gestiona todas las citas de {garage.name} — Gartify y manuales</p>
            </div>
          </div>
        </div>
      </div>
      <AgendaTaller garageId={garage.id} />
    </div>
  );
}
