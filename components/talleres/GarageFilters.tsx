"use client";
import { useRouter, useSearchParams } from "next/navigation";
import { useState } from "react";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { X, Star, MapPin, Wrench, Euro, SlidersHorizontal, Navigation, Car, PackageCheck, Loader2, CheckCircle } from "lucide-react";
import { SEARCHABLE_SERVICES } from "@/lib/constants";
import { cn, VEHICLE_TYPES, VEHICLE_LABELS, VEHICLE_ICONS } from "@/lib/utils";

const PRICE_RANGES = [
  { value: "0-30",   label: "Hasta 30 €" },
  { value: "30-60",  label: "30 € – 60 €" },
  { value: "60-100", label: "60 € – 100 €" },
  { value: "100-",   label: "Más de 100 €" },
];

const RATING_OPTIONS = [
  { value: "4.5", stars: 4.5 },
  { value: "4",   stars: 4   },
  { value: "3.5", stars: 3.5 },
];

const DISTANCE_OPTIONS = [
  { value: "5",  label: "Menos de 5 km" },
  { value: "10", label: "Menos de 10 km" },
  { value: "25", label: "Menos de 25 km" },
  { value: "50", label: "Menos de 50 km" },
];

function RatingStars({ stars }: { stars: number }) {
  return (
    <span className="flex items-center gap-1">
      {[1, 2, 3, 4, 5].map((i) => (
        <Star
          key={i}
          className={cn(
            "h-3.5 w-3.5",
            i <= Math.floor(stars)
              ? "fill-yellow-400 text-yellow-400"
              : i - 0.5 <= stars
              ? "fill-yellow-200 text-yellow-400"
              : "fill-gray-200 text-gray-200"
          )}
        />
      ))}
      <span className="text-xs font-medium ml-0.5">{stars}+</span>
    </span>
  );
}

function FilterLabel({ children }: { children: React.ReactNode }) {
  return (
    <span className="block text-[10px] font-semibold uppercase tracking-widest text-gartify-gray mb-1.5 select-none">
      {children}
    </span>
  );
}

export function GarageFilters() {
  const router = useRouter();
  const sp = useSearchParams();
  const [geoLoading, setGeoLoading] = useState(false);
  const [geoError, setGeoError] = useState("");

  function update(key: string, value: string) {
    const params = new URLSearchParams(sp.toString());
    if (value && value !== "ALL") params.set(key, value);
    else params.delete(key);
    router.push(`/talleres?${params.toString()}`);
  }

  function isActive(key: string): boolean {
    const v = sp.get(key);
    return v !== null && v !== "" && v !== "ALL";
  }

  function activeRing(key: string): string {
    return isActive(key) ? "ring-2 ring-gartify-hero/50 border-gartify-hero/60" : "";
  }

  function requestLocation() {
    if (!navigator.geolocation) {
      setGeoError("Tu navegador no soporta geolocalización.");
      return;
    }
    setGeoLoading(true);
    setGeoError("");
    navigator.geolocation.getCurrentPosition(
      (pos) => {
        const params = new URLSearchParams(sp.toString());
        params.set("userLat", pos.coords.latitude.toFixed(6));
        params.set("userLng", pos.coords.longitude.toFixed(6));
        if (!params.has("distancia")) params.set("distancia", "10");
        router.push(`/talleres?${params.toString()}`);
        setGeoLoading(false);
      },
      () => {
        setGeoError("No se pudo obtener tu ubicación.");
        setGeoLoading(false);
      },
      { timeout: 8000 }
    );
  }

  function clearLocation() {
    const params = new URLSearchParams(sp.toString());
    params.delete("userLat");
    params.delete("userLng");
    params.delete("distancia");
    router.push(`/talleres?${params.toString()}`);
  }

  const hasLocation = sp.has("userLat") && sp.has("userLng");
  const activeCount = ["servicio", "ciudad", "precio", "rating", "distancia", "cocheCortesia", "recogida", "vehicleType"]
    .filter(isActive).length;
  const hasFilters = activeCount > 0 || hasLocation;

  return (
    <div className="bg-white border border-gray-200 rounded-xl p-4 shadow-sm">
      {/* Cabecera */}
      <div className="flex items-center justify-between mb-4">
        <div className="flex items-center gap-2 text-gartify-blue">
          <SlidersHorizontal className="h-4 w-4 shrink-0" />
          <span className="text-sm font-semibold">Filtrar resultados</span>
        </div>
        {hasFilters && (
          <Button
            variant="ghost"
            size="sm"
            onClick={() => router.push("/talleres")}
            className="h-7 gap-1.5 text-red-500 hover:text-red-600 hover:bg-red-50 px-2.5"
          >
            <X className="h-3.5 w-3.5 shrink-0" />
            <span className="text-xs font-medium">Limpiar</span>
            <span className="flex h-4 min-w-4 items-center justify-center rounded-full bg-red-100 px-1 text-[10px] font-bold text-red-600 leading-none">
              {activeCount + (hasLocation ? 1 : 0)}
            </span>
          </Button>
        )}
      </div>

      <div className="grid grid-cols-1 gap-3">

        {/* Ubicación (ciudad/CP) */}
        <div>
          <FilterLabel>Ubicación</FilterLabel>
          <div className="relative">
            <MapPin
              className={cn(
                "pointer-events-none absolute left-2.5 top-1/2 h-3.5 w-3.5 -translate-y-1/2",
                isActive("ciudad") ? "text-gartify-hero" : "text-gartify-gray/70"
              )}
            />
            <Input
              placeholder="Ciudad o CP"
              defaultValue={sp.get("ciudad") ?? ""}
              className={cn("h-10 pl-8 text-sm transition-all", activeRing("ciudad"))}
              onKeyDown={(e) => {
                if (e.key === "Enter") update("ciudad", (e.target as HTMLInputElement).value);
              }}
              onBlur={(e) => update("ciudad", e.target.value)}
            />
          </div>
        </div>

        {/* Distancia (geolocalización) */}
        <div>
          <FilterLabel>Distancia</FilterLabel>
          {!hasLocation ? (
            <div className="space-y-1.5">
              <Button
                type="button"
                variant="outline"
                size="sm"
                onClick={requestLocation}
                disabled={geoLoading}
                className="w-full h-10 gap-2 text-sm font-medium text-gartify-hero border-gartify-hero/30 hover:bg-gartify-hero/5"
              >
                {geoLoading ? (
                  <Loader2 className="h-3.5 w-3.5 animate-spin" />
                ) : (
                  <Navigation className="h-3.5 w-3.5" />
                )}
                {geoLoading ? "Detectando..." : "Usar mi ubicación"}
              </Button>
              {geoError && (
                <p className="text-[11px] text-red-500">{geoError}</p>
              )}
            </div>
          ) : (
            <div className="space-y-2">
              <div className="flex items-center gap-2 px-2.5 py-1.5 rounded-lg bg-gartify-hero/5 border border-gartify-hero/20">
                <CheckCircle className="h-3.5 w-3.5 text-gartify-hero shrink-0" />
                <span className="text-xs text-gartify-hero font-medium flex-1">Ubicación detectada</span>
                <button
                  type="button"
                  onClick={clearLocation}
                  className="text-gartify-gray/60 hover:text-red-500 transition-colors"
                  aria-label="Quitar ubicación"
                >
                  <X className="h-3.5 w-3.5" />
                </button>
              </div>
              <div className="relative">
                <Navigation
                  className={cn(
                    "pointer-events-none absolute left-2.5 top-1/2 -translate-y-1/2 h-3.5 w-3.5 z-10",
                    isActive("distancia") ? "text-gartify-hero" : "text-gartify-gray/70"
                  )}
                />
                <Select
                  defaultValue={sp.get("distancia") ?? "10"}
                  onValueChange={(v) => update("distancia", v)}
                >
                  <SelectTrigger className={cn("h-10 w-full pl-8 text-sm transition-all", activeRing("distancia"))}>
                    <SelectValue placeholder="Radio de búsqueda" />
                  </SelectTrigger>
                  <SelectContent position="popper">
                    {DISTANCE_OPTIONS.map((d) => (
                      <SelectItem key={d.value} value={d.value}>{d.label}</SelectItem>
                    ))}
                  </SelectContent>
                </Select>
              </div>
            </div>
          )}
        </div>

        {/* Servicio */}
        <div>
          <FilterLabel>Servicio</FilterLabel>
          <div className="relative">
            <Wrench
              className={cn(
                "pointer-events-none absolute left-2.5 top-1/2 -translate-y-1/2 h-3.5 w-3.5 z-10",
                isActive("servicio") ? "text-gartify-hero" : "text-gartify-gray/70"
              )}
            />
            <Select
              defaultValue={sp.get("servicio") ?? "ALL"}
              onValueChange={(v) => update("servicio", v)}
            >
              <SelectTrigger className={cn("h-10 w-full pl-8 text-sm transition-all", activeRing("servicio"))}>
                <SelectValue placeholder="Todos los servicios" />
              </SelectTrigger>
              <SelectContent position="popper">
                <SelectItem value="ALL">Todos los servicios</SelectItem>
                {SEARCHABLE_SERVICES.map((s) => (
                  <SelectItem key={s.type} value={s.type}>{s.label}</SelectItem>
                ))}
              </SelectContent>
            </Select>
          </div>
        </div>

        {/* Precio */}
        <div>
          <FilterLabel>Precio</FilterLabel>
          <div className="relative">
            <Euro
              className={cn(
                "pointer-events-none absolute left-2.5 top-1/2 -translate-y-1/2 h-3.5 w-3.5 z-10",
                isActive("precio") ? "text-gartify-hero" : "text-gartify-gray/70"
              )}
            />
            <Select
              defaultValue={sp.get("precio") ?? "ALL"}
              onValueChange={(v) => update("precio", v)}
            >
              <SelectTrigger className={cn("h-10 w-full pl-8 text-sm transition-all", activeRing("precio"))}>
                <SelectValue placeholder="Cualquier precio" />
              </SelectTrigger>
              <SelectContent position="popper">
                <SelectItem value="ALL">Cualquier precio</SelectItem>
                {PRICE_RANGES.map((r) => (
                  <SelectItem key={r.value} value={r.value}>{r.label}</SelectItem>
                ))}
              </SelectContent>
            </Select>
          </div>
        </div>

        {/* Valoración */}
        <div>
          <FilterLabel>Valoración</FilterLabel>
          <div className="relative">
            <Star
              className={cn(
                "pointer-events-none absolute left-2.5 top-1/2 -translate-y-1/2 h-3.5 w-3.5 z-10",
                isActive("rating") ? "fill-yellow-400 text-yellow-400" : "text-gartify-gray/70"
              )}
            />
            <Select
              defaultValue={sp.get("rating") ?? "ALL"}
              onValueChange={(v) => update("rating", v)}
            >
              <SelectTrigger className={cn("h-10 w-full pl-8 text-sm transition-all", activeRing("rating"))}>
                <SelectValue placeholder="Cualquier valoración" />
              </SelectTrigger>
              <SelectContent position="popper">
                <SelectItem value="ALL">Cualquier valoración</SelectItem>
                {RATING_OPTIONS.map((r) => (
                  <SelectItem key={r.value} value={r.value}>
                    <RatingStars stars={r.stars} />
                  </SelectItem>
                ))}
              </SelectContent>
            </Select>
          </div>
        </div>

        {/* Tipo de vehículo */}
        <div>
          <FilterLabel>Tipo de vehículo</FilterLabel>
          <div className="grid grid-cols-2 gap-1.5">
            {VEHICLE_TYPES.map((tipo) => {
              const activo = sp.get("vehicleType") === tipo;
              return (
                <button
                  key={tipo}
                  type="button"
                  onClick={() => update("vehicleType", activo ? "ALL" : tipo)}
                  aria-pressed={activo}
                  className={cn(
                    "flex items-center gap-1.5 h-9 px-2.5 rounded-lg border text-xs font-medium transition-all",
                    activo
                      ? "bg-gartify-hero/10 border-gartify-hero/40 text-gartify-hero ring-2 ring-gartify-hero/30"
                      : "bg-white border-gray-200 text-gartify-gray hover:bg-gray-50"
                  )}
                >
                  <span aria-hidden="true">{VEHICLE_ICONS[tipo]}</span>
                  {VEHICLE_LABELS[tipo]}
                </button>
              );
            })}
          </div>
        </div>

        {/* Extras */}
        <div>
          <FilterLabel>Extras</FilterLabel>
          <div className="flex flex-col gap-2">
            <button
              type="button"
              onClick={() => update("cocheCortesia", isActive("cocheCortesia") ? "ALL" : "true")}
              className={cn(
                "w-full flex items-center gap-2.5 h-10 px-3 rounded-lg border text-sm font-medium transition-all",
                isActive("cocheCortesia")
                  ? "bg-gartify-hero/10 border-gartify-hero/40 text-gartify-hero ring-2 ring-gartify-hero/30"
                  : "bg-white border-gray-200 text-gartify-gray hover:bg-gray-50"
              )}
            >
              <Car className="h-3.5 w-3.5 shrink-0" />
              Vehículo de cortesía
              {isActive("cocheCortesia") && (
                <CheckCircle className="h-3.5 w-3.5 ml-auto shrink-0 text-gartify-hero" />
              )}
            </button>
            <button
              type="button"
              onClick={() => update("recogida", isActive("recogida") ? "ALL" : "true")}
              className={cn(
                "w-full flex items-center gap-2.5 h-10 px-3 rounded-lg border text-sm font-medium transition-all",
                isActive("recogida")
                  ? "bg-gartify-hero/10 border-gartify-hero/40 text-gartify-hero ring-2 ring-gartify-hero/30"
                  : "bg-white border-gray-200 text-gartify-gray hover:bg-gray-50"
              )}
            >
              <PackageCheck className="h-3.5 w-3.5 shrink-0" />
              Servicio de recogida
              {isActive("recogida") && (
                <CheckCircle className="h-3.5 w-3.5 ml-auto shrink-0 text-gartify-hero" />
              )}
            </button>
          </div>
        </div>

      </div>
    </div>
  );
}
