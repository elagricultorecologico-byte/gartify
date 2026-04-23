"use client";
import { useState } from "react";
import { useRouter, useSearchParams } from "next/navigation";
import { Search, MapPin, LocateFixed, Loader2 } from "lucide-react";
import { Input } from "@/components/ui/input";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";
import { SEARCHABLE_SERVICES } from "@/lib/constants";
import { VEHICLE_TYPES, VEHICLE_LABELS, VEHICLE_ICONS, type VehicleType } from "@/lib/utils";

type SearchBarProps = {
  className?: string;
  onUserCoords?: (coords: { lat: number; lng: number } | null) => void;
};

export function SearchBar({ className, onUserCoords }: SearchBarProps) {
  const router = useRouter();
  const sp = useSearchParams();
  const [servicio, setServicio] = useState(sp.get("servicio") ?? "");
  const [ciudad, setCiudad] = useState(sp.get("ciudad") ?? "");
  const [vehicleType, setVehicleType] = useState<VehicleType | "">((sp.get("vehicleType") as VehicleType) ?? "");
  const [userCoords, setUserCoords] = useState<{ lat: number; lng: number } | null>(null);
  const [locating, setLocating] = useState(false);

  // Notifica al padre cada vez que las coordenadas del usuario cambian
  const actualizarCoords = (coords: { lat: number; lng: number } | null) => {
    setUserCoords(coords);
    onUserCoords?.(coords);
  };

  const handleLocate = () => {
    if (!navigator.geolocation) return;
    setLocating(true);
    navigator.geolocation.getCurrentPosition(
      async (pos) => {
        const { latitude, longitude } = pos.coords;
        actualizarCoords({ lat: latitude, lng: longitude });
        try {
          const res = await fetch(
            `https://nominatim.openstreetmap.org/reverse?lat=${latitude}&lon=${longitude}&format=json&accept-language=es`
          );
          const data = await res.json() as { address?: { city?: string; town?: string; village?: string; municipality?: string } };
          const localidad =
            data.address?.city ??
            data.address?.town ??
            data.address?.village ??
            data.address?.municipality ??
            "";
          setCiudad(localidad);
        } catch {
          // Si falla el geocoding dejamos las coords igual
        } finally {
          setLocating(false);
        }
      },
      () => setLocating(false),
      { timeout: 8000 }
    );
  };

  const handleSearch = (e: React.FormEvent) => {
    e.preventDefault();
    const params = new URLSearchParams();
    if (servicio) params.set("servicio", servicio);
    if (ciudad.trim()) params.set("ciudad", ciudad.trim());
    if (vehicleType) params.set("vehicleType", vehicleType);
    if (userCoords) {
      params.set("userLat", String(userCoords.lat));
      params.set("userLng", String(userCoords.lng));
    }
    router.push(`/talleres?${params.toString()}`);
  };

  return (
    <form
      onSubmit={handleSearch}
      aria-label="Buscar talleres"
      className={`flex flex-col sm:flex-row sm:items-center gap-2 ${className}`}
    >
      {/* Selector de servicio */}
      <Select value={servicio || undefined} onValueChange={setServicio}>
        <SelectTrigger className="w-full sm:w-40 bg-white border-0 shadow-sm !h-12 text-sm font-semibold text-gray-500 px-4 shrink-0 [&>span:not([data-placeholder])]:text-gray-800">
          <SelectValue placeholder="¿Qué necesitas?" />
        </SelectTrigger>
        <SelectContent>
          {SEARCHABLE_SERVICES.map((s) => {
            const Icon = s.icon;
            return (
              <SelectItem key={s.type} value={s.type}>
                <span className="flex items-center gap-2">
                  <Icon className={`h-4 w-4 shrink-0 ${s.color}`} />
                  {s.label}
                </span>
              </SelectItem>
            );
          })}
        </SelectContent>
      </Select>

      {/* Campo de ciudad */}
      <div className="relative flex-1 min-w-0 sm:min-w-[140px] w-full">
        <MapPin className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-gray-400 pointer-events-none" />
        <Input
          placeholder="Localidad o CP"
          value={ciudad}
          onChange={(e) => { setCiudad(e.target.value); actualizarCoords(null); }}
          className="pl-9 pr-10 bg-white border-0 shadow-sm !h-12 text-sm font-semibold text-gray-800 w-full min-w-0 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:font-normal placeholder:text-gray-400 placeholder:text-sm"
        />
        <button
          type="button"
          onClick={handleLocate}
          disabled={locating}
          title="Detectar mi ubicación"
          className="absolute right-3 top-1/2 -translate-y-1/2 text-gray-400 hover:text-gartify-blue transition-colors disabled:opacity-50"
          aria-label="Detectar mi ubicación"
        >
          {locating
            ? <Loader2 className="h-4 w-4 animate-spin" />
            : <LocateFixed className="h-4 w-4" />
          }
        </button>
      </div>

      {/* Selector de tipo de vehículo */}
      <Select value={vehicleType || undefined} onValueChange={(v) => setVehicleType(v === "ALL" ? "" : v as VehicleType)}>
        <SelectTrigger className="w-full sm:w-40 bg-white border-0 shadow-sm !h-12 text-sm font-semibold text-gray-500 px-4 shrink-0 [&>span:not([data-placeholder])]:text-gray-800">
          <SelectValue placeholder="Tipo de vehículo" />
        </SelectTrigger>
        <SelectContent>
          <SelectItem value="ALL">Todos los vehículos</SelectItem>
          {VEHICLE_TYPES.map((tipo) => (
            <SelectItem key={tipo} value={tipo}>
              <span className="flex items-center gap-2">
                <span aria-hidden="true">{VEHICLE_ICONS[tipo]}</span>
                {VEHICLE_LABELS[tipo]}
              </span>
            </SelectItem>
          ))}
        </SelectContent>
      </Select>

      {/* Botón buscar */}
      <button
        type="submit"
        className="w-full sm:w-auto flex items-center justify-center gap-2 h-12 px-6 shrink-0 bg-gartify-orange hover:bg-gartify-orange/90 transition-colors text-white font-semibold text-sm"
        aria-label="Buscar talleres"
      >
        <Search className="h-4 w-4" />
        <span>Buscar</span>
      </button>
    </form>
  );
}
