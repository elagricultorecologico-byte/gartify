import type { Metadata } from "next";
import { Suspense } from "react";
import { db } from "@/lib/db";
import { GarageCard } from "@/components/talleres/GarageCard";
import { GarageFilters } from "@/components/talleres/GarageFilters";
import { GaragePagination } from "@/components/talleres/GaragePagination";
import { Search } from "lucide-react";
import { SERVICE_LABELS } from "@/lib/constants";
import { VEHICLE_LABELS } from "@/lib/utils";

const DEFAULT_PAGE_SIZE = 10;
const VALID_PAGE_SIZES = [5, 10, 20, 50];

type SearchParams = {
  servicio?: string; ciudad?: string; precio?: string; rating?: string;
  distancia?: string; userLat?: string; userLng?: string; cocheCortesia?: string; recogida?: string;
  vehicleType?: string; premium?: string; page?: string; pageSize?: string; conOfertas?: string;
};

function parsePrecioRange(precio: string): { gte?: number; lte?: number } {
  const [minStr, maxStr] = precio.split("-");
  const min = Number(minStr);
  const max = maxStr ? Number(maxStr) : undefined;
  return { ...(min > 0 && { gte: min }), ...(max !== undefined && max > 0 && { lte: max }) };
}

function haversineKm(lat1: number, lng1: number, lat2: number, lng2: number): number {
  const R = 6371;
  const dLat = (lat2 - lat1) * Math.PI / 180;
  const dLng = (lng2 - lng1) * Math.PI / 180;
  const a = Math.sin(dLat / 2) ** 2
    + Math.cos(lat1 * Math.PI / 180) * Math.cos(lat2 * Math.PI / 180) * Math.sin(dLng / 2) ** 2;
  return R * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
}

export async function generateMetadata({ searchParams }: { searchParams: SearchParams }): Promise<Metadata> {
  const servicioLabel = searchParams.servicio ? SERVICE_LABELS[searchParams.servicio] : null;
  const ciudad = searchParams.ciudad;
  const title = [servicioLabel ?? "Talleres mecánicos", ciudad ? `en ${ciudad}` : "en España"].join(" ");
  const params = new URLSearchParams();
  if (searchParams.servicio) params.set("servicio", searchParams.servicio);
  if (searchParams.ciudad) params.set("ciudad", searchParams.ciudad);
  const qs = params.toString();
  return {
    title,
    description: `Compara precios y reserva cita en talleres mecánicos${ciudad ? ` en ${ciudad}` : " de toda España"}. Reseñas reales, precios transparentes. Sin llamadas.`,
    alternates: { canonical: `/talleres${qs ? `?${qs}` : ""}` },
  };
}

export default async function TalleresPage({
  searchParams,
}: {
  searchParams: SearchParams;
}) {
  const precioFilter = searchParams.precio ? parsePrecioRange(searchParams.precio) : null;
  const ratingMin = searchParams.rating ? parseFloat(searchParams.rating) : null;
  const userLat = searchParams.userLat ? parseFloat(searchParams.userLat) : null;
  const userLng = searchParams.userLng ? parseFloat(searchParams.userLng) : null;
  const distanciaKm = searchParams.distancia ? parseInt(searchParams.distancia) : null;
  const cocheCortesia = searchParams.cocheCortesia === "true";
  const recogida = searchParams.recogida === "true";
  const premiumOnly = searchParams.premium === "true";
  const conOfertas = searchParams.conOfertas === "true";
  const vehicleType = searchParams.vehicleType ?? null;
  const currentPage = Math.max(1, parseInt(searchParams.page ?? "1"));
  const parsedSize = parseInt(searchParams.pageSize ?? String(DEFAULT_PAGE_SIZE));
  const pageSize = VALID_PAGE_SIZES.includes(parsedSize) ? parsedSize : DEFAULT_PAGE_SIZE;

  let garages = await db.garage.findMany({
    where: {
      isActive: true,
      ...(searchParams.ciudad && {
        OR: [
          { city:       { contains: searchParams.ciudad } },
          { postalCode: { contains: searchParams.ciudad } },
        ],
      }),
      ...(ratingMin !== null && { rating: { gte: ratingMin } }),
      ...(cocheCortesia && { courtesyCar: true }),
      ...(recogida && { pickupService: true }),
      ...(premiumOnly && { plan: "PREMIUM" }),
      ...(conOfertas && { offers: { some: { isActive: true } } }),
      // Filtro por tipo de vehículo: SQLite contains sobre el JSON array serializado
      ...(vehicleType && { vehicleTypes: { contains: vehicleType } }),
      ...((searchParams.servicio || precioFilter) && {
        services: {
          some: {
            isActive: true,
            ...(searchParams.servicio && { type: searchParams.servicio as never }),
            ...(precioFilter && { price: precioFilter }),
          },
        },
      }),
    },
    include: {
      services: { where: { isActive: true }, orderBy: { price: "asc" } },
      offers:   { where: { isActive: true }, orderBy: { createdAt: "desc" } },
    },
    orderBy: { rating: "desc" },
  });

  // Filtro de distancia (post-query, requiere coordenadas del usuario y del taller)
  if (userLat !== null && userLng !== null && distanciaKm !== null) {
    garages = garages.filter((g) =>
      g.lat != null && g.lng != null &&
      haversineKm(userLat, userLng, g.lat, g.lng) <= distanciaKm
    );
  }

  const total = garages.length;
  const totalPages = Math.max(1, Math.ceil(total / pageSize));
  const safePage = Math.min(currentPage, totalPages);
  const paginatedGarages = garages.slice((safePage - 1) * pageSize, safePage * pageSize);

  return (
    <div className="container max-w-6xl py-8 px-4 sm:px-8">
      {/* Header */}
      <div className="mb-6">
        <h1 className="text-2xl font-bold text-gartify-blue mb-1">
          {total} taller{total !== 1 ? "es" : ""} encontrado{total !== 1 ? "s" : ""}
          {searchParams.ciudad ? ` en ${searchParams.ciudad}` : ""}
        </h1>
        <p className="text-muted-foreground text-sm">
          {[
            searchParams.servicio
              ? `Servicio: ${SERVICE_LABELS[searchParams.servicio] ?? searchParams.servicio.replace(/_/g, " ")}`
              : null,
            vehicleType
              ? `Vehículo: ${VEHICLE_LABELS[vehicleType] ?? vehicleType}`
              : null,
          ]
            .filter(Boolean)
            .join(" · ") || "Mostrando todos los servicios"}
        </p>
      </div>

      {/* Layout: sidebar filtros izquierda + lista derecha */}
      <div className="flex flex-col gap-6 lg:flex-row lg:items-start">

        {/* Sidebar filtros — fijo en desktop */}
        <aside className="lg:w-72 lg:shrink-0 lg:sticky lg:top-24">
          <GarageFilters />
        </aside>

        {/* Lista de talleres */}
        <div className="flex-1 space-y-4">
          {total === 0 ? (
            <div className="text-center py-16 text-muted-foreground">
              <Search className="h-10 w-10 mx-auto mb-3 opacity-40" />
              <p className="font-medium">No se encontraron talleres</p>
              <p className="text-sm mt-1">Prueba con otra ciudad o servicio</p>
            </div>
          ) : (
            <>
              {paginatedGarages.map((g) => (
                <GarageCard
                  key={g.id}
                  id={g.id}
                  name={g.name}
                  city={g.city}
                  address={g.address}
                  rating={g.rating}
                  reviewCount={g.reviewCount}
                  isVerified={g.isVerified}
                  services={g.services}
                  logo={g.logo}
                  lat={g.lat}
                  lng={g.lng}
                  vehicleTypes={g.vehicleTypes}
                  plan={g.plan}
                  courtesyCar={g.courtesyCar}
                  pickupService={g.pickupService}
                  offers={g.offers}
                />
              ))}
              <Suspense>
                <GaragePagination
                  page={safePage}
                  totalPages={totalPages}
                  total={total}
                  pageSize={pageSize}
                />
              </Suspense>
            </>
          )}
        </div>

      </div>
    </div>
  );
}
