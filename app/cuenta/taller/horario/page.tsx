import type { Metadata } from "next";
import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Clock } from "lucide-react";
import { GarageScheduleForm } from "@/components/cuenta/GarageScheduleForm";

export const metadata: Metadata = {
  title: "Horario del taller",
  robots: { index: false, follow: false },
};

export default async function HorarioPage() {
  const session = await auth();
  if (!session?.user?.id) redirect("/login");

  const user = session.user as { id: string; role?: string };
  if (user.role !== "GARAGE_OWNER") redirect("/cuenta");

  const garage = await db.garage.findUnique({
    where: { ownerId: user.id },
    select: {
      id: true,
      schedules: { orderBy: { dayOfWeek: "asc" } },
    },
  });

  if (!garage) redirect("/cuenta/taller/perfil");

  return (
    <div className="w-full max-w-6xl mx-auto py-6 px-4 sm:px-8">
      <div className="bg-white border border-gray-200 overflow-hidden">
        {/* Header */}
        <div className="bg-gradient-to-r from-gartify-hero to-gartify-mid px-6 py-5">
          <div className="flex items-center gap-3">
            <div className="flex h-10 w-10 items-center justify-center rounded-xl bg-white/20 border border-white/30 shrink-0">
              <Clock className="h-5 w-5 text-white" />
            </div>
            <div>
              <h1 className="text-base font-bold text-white">Horario de atención</h1>
              <p className="text-xs text-blue-100 mt-0.5">
                Los clientes solo podrán reservar en los días y horas que configures aquí
              </p>
            </div>
          </div>
        </div>

        <div className="p-6">
          <GarageScheduleForm initial={garage.schedules} />
        </div>
      </div>
    </div>
  );
}
