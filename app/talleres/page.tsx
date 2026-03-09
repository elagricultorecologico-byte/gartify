import dynamic from "next/dynamic";
import { db } from "@/lib/db";
import { GarageCard } from "@/components/talleres/GarageCard";
import { GarageFilters } from "@/components/talleres/GarageFilters";
import { Search } from "lucide-react";

const GarageMap = dynamic(
  () => import("@/components/talleres/GarageMap").then((m) => m.GarageMap),
  { ssr: false, loading: () => <div className="h-full bg-muted/20 rounded-lg animate-pulse" /> }
);

export default async function TalleresPage({
  searchParams,
}: {
  searchParams: { servicio?: string; ciudad?: string };
}) {
  const garages = await db.garage.findMany({
    where: {
      isActive: true,
      ...(searchParams.ciudad && {
        OR: [
          { city:       { contains: searchParams.ciudad } },
          { postalCode: { contains: searchParams.ciudad } },
        ],
      }),
      ...(searchParams.servicio && {
        services: { some: { type: searchParams.servicio as never, isActive: true } },
      }),
    },
    include: {
      services: { where: { isActive: true }, orderBy: { price: "asc" } },
    },
    orderBy: { rating: "desc" },
  });

  const mapPins = garages
    .filter((g) => g.lat && g.lng)
    .map((g) => ({ id: g.id, name: g.name, city: g.city, lat: g.lat!, lng: g.lng!, rating: g.rating }));

  return (
    <div className="container py-8">
      {/* Header */}
      <div className="mb-6">
        <h1 className="text-2xl font-bold text-foreground mb-1">
          {garages.length} taller{garages.length !== 1 ? "es" : ""} encontrado{garages.length !== 1 ? "s" : ""}
          {searchParams.ciudad ? ` en ${searchParams.ciudad}` : ""}
        </h1>
        <p className="text-muted-foreground text-sm mb-4">
          {searchParams.servicio ? `Filtrando por: ${searchParams.servicio.replace(/_/g, " ")}` : "Mostrando todos los servicios"}
        </p>
        <GarageFilters />
      </div>

      {/* Split layout */}
      <div className="grid lg:grid-cols-[1fr_420px] gap-6 items-start">
        {/* List */}
        <div className="space-y-4">
          {garages.length === 0 ? (
            <div className="text-center py-16 text-muted-foreground">
              <Search className="h-10 w-10 mx-auto mb-3 opacity-40" />
              <p className="font-medium">No se encontraron talleres</p>
              <p className="text-sm mt-1">Prueba con otra ciudad o servicio</p>
            </div>
          ) : (
            garages.map((g) => (
              <GarageCard
                key={g.id}
                id={g.id}
                name={g.name}
                description={g.description}
                city={g.city}
                address={g.address}
                rating={g.rating}
                reviewCount={g.reviewCount}
                isVerified={g.isVerified}
                services={g.services}
              />
            ))
          )}
        </div>

        {/* Map — sticky on desktop */}
        <div className="hidden lg:block sticky top-24 h-[calc(100vh-8rem)]">
          <GarageMap garages={mapPins} />
        </div>
      </div>
    </div>
  );
}
