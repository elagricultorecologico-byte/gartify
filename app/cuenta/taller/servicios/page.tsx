import type { Metadata } from "next";
import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Badge } from "@/components/ui/badge";
import { ChevronLeft, Clock, Wrench } from "lucide-react";
import Link from "next/link";
import { formatPrice, SERVICE_LABELS } from "@/lib/utils";
import { ServiceForm } from "@/components/cuenta/ServiceForm";

export const metadata: Metadata = {
  title: "Servicios del taller",
  robots: { index: false, follow: false },
};

export default async function ServiciosPage() {
  const session = await auth();
  if (!session?.user?.id) redirect("/login");
  const user = session.user as { id: string; role?: string };
  if (user.role !== "GARAGE_OWNER") redirect("/cuenta");

  const garage = await db.garage.findUnique({
    where: { ownerId: user.id },
    select: {
      id: true,
      services: {
        select: {
          id: true,
          type: true,
          name: true,
          description: true,
          duration: true,
          price: true,
          isActive: true,
        },
        orderBy: { name: "asc" },
      },
    },
  });

  if (!garage) redirect("/cuenta/taller/perfil");

  const active   = garage.services.filter((s) => s.isActive);
  const inactive = garage.services.filter((s) => !s.isActive);

  return (
    <div className="container max-w-3xl py-10">
      <Link href="/cuenta/taller" className="inline-flex items-center gap-1.5 text-sm text-muted-foreground hover:text-gartify-blue mb-6">
        <ChevronLeft className="h-4 w-4" />
        Panel del taller
      </Link>
      <h1 className="text-2xl font-bold text-gartify-blue mb-6">Servicios</h1>

      {/* Add service form */}
      <div className="bg-white rounded-xl border border-gartify-orange/25 shadow-sm p-6 mb-8">
        <h2 className="font-bold text-gartify-blue mb-4 flex items-center gap-2">
          <Wrench className="h-4 w-4 text-gartify-orange" />
          Añadir servicio
        </h2>
        <ServiceForm garageId={garage.id} />
      </div>

      {/* Active services */}
      {active.length > 0 && (
        <section className="mb-6">
          <h2 className="text-sm font-bold uppercase tracking-wide text-gartify-gray mb-3">Activos</h2>
          <div className="space-y-3">
            {active.map((s) => <ServiceRow key={s.id} s={s} />)}
          </div>
        </section>
      )}

      {/* Inactive services */}
      {inactive.length > 0 && (
        <section>
          <h2 className="text-sm font-bold uppercase tracking-wide text-gartify-gray mb-3">Inactivos</h2>
          <div className="space-y-3 opacity-60">
            {inactive.map((s) => <ServiceRow key={s.id} s={s} inactive />)}
          </div>
        </section>
      )}

      {garage.services.length === 0 && (
        <div className="text-center py-12 rounded-xl border border-dashed border-gray-200 bg-gray-50">
          <Wrench className="h-8 w-8 mx-auto mb-3 text-gartify-mid opacity-50" />
          <p className="font-semibold text-foreground">Sin servicios todavía</p>
          <p className="text-sm text-muted-foreground mt-1">Añade tu primer servicio con el formulario de arriba</p>
        </div>
      )}
    </div>
  );
}

type ServiceItem = NonNullable<typeof garage>["services"][number];

function ServiceRow({ s, inactive }: { s: ServiceItem; inactive?: boolean }) {
  return (
    <div className={`bg-white rounded-xl border shadow-sm overflow-hidden flex flex-col sm:flex-row ${inactive ? "border-gray-200" : "border-gray-200 hover:border-gartify-orange/40 hover:shadow-md"} transition-all`}>
      {/* Left accent */}
      <div className={`sm:w-2 shrink-0 ${inactive ? "bg-gray-300" : "bg-gradient-to-b from-gartify-hero to-gartify-mid"}`} />

      {/* Content */}
      <div className="flex-1 p-4 flex items-center justify-between gap-4">
        <div className="space-y-1.5">
          <div className="flex items-center gap-2 flex-wrap">
            <span className="inline-flex items-center rounded-full bg-blue-50 text-gartify-hero text-xs px-2.5 py-0.5 font-medium border border-blue-100">
              {SERVICE_LABELS[s.type] ?? s.type}
            </span>
            {inactive && (
              <Badge variant="secondary" className="text-xs">Inactivo</Badge>
            )}
          </div>
          <p className="font-bold text-gartify-blue text-sm">{s.name}</p>
          {s.description && (
            <p className="text-xs text-muted-foreground line-clamp-1">{s.description}</p>
          )}
          <div className="flex items-center gap-1 text-xs text-muted-foreground">
            <Clock className="h-3.5 w-3.5 text-gartify-mid" aria-hidden="true" />
            {s.duration} min
          </div>
        </div>
        <p className="text-xl font-bold text-gartify-orange shrink-0">{formatPrice(s.price)}</p>
      </div>
    </div>
  );
}
