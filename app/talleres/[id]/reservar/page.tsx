import { notFound, redirect } from "next/navigation";
import Link from "next/link";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { BookingWizard } from "@/components/booking/BookingWizard";
import { ChevronLeft } from "lucide-react";

export default async function ReservarPage({
  params,
  searchParams,
}: {
  params: { id: string };
  searchParams: { servicio?: string };
}) {
  const session = await auth();
  if (!session?.user) redirect(`/login?callbackUrl=/talleres/${params.id}/reservar`);

  const garage = await db.garage.findUnique({
    where: { id: params.id, isActive: true },
    include: { services: { where: { isActive: true }, orderBy: { price: "asc" } } },
  });

  if (!garage) notFound();

  return (
    <div className="container max-w-2xl py-8">
      <Link href={`/talleres/${garage.id}`} className="inline-flex items-center gap-1.5 text-sm text-muted-foreground hover:text-foreground transition-colors mb-8">
        <ChevronLeft className="h-4 w-4" />
        {garage.name}
      </Link>

      <h1 className="text-2xl font-bold text-foreground mb-8">Reservar cita</h1>

      <BookingWizard
        garageId={garage.id}
        garageName={garage.name}
        services={garage.services}
        preselectedServiceId={searchParams.servicio}
      />
    </div>
  );
}
