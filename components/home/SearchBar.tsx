"use client";
import { useState } from "react";
import { useRouter, useSearchParams } from "next/navigation";
import { Search, MapPin } from "lucide-react";
import { Input } from "@/components/ui/input";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";
import { SEARCHABLE_SERVICES } from "@/lib/constants";
import { VEHICLE_TYPES, VEHICLE_LABELS, VEHICLE_ICONS, type VehicleType } from "@/lib/utils";

export function SearchBar({ className }: { className?: string }) {
  const router = useRouter();
  const sp = useSearchParams();
  const [servicio, setServicio] = useState(sp.get("servicio") ?? "");
  const [ciudad, setCiudad] = useState(sp.get("ciudad") ?? "");
  const [vehicleType, setVehicleType] = useState<VehicleType | "">((sp.get("vehicleType") as VehicleType) ?? "");

  const handleSearch = (e: React.FormEvent) => {
    e.preventDefault();
    const params = new URLSearchParams();
    if (servicio) params.set("servicio", servicio);
    if (ciudad.trim()) params.set("ciudad", ciudad.trim());
    if (vehicleType) params.set("vehicleType", vehicleType);
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
        <SelectTrigger className="w-full sm:w-40 bg-white border-0 shadow-sm !h-12 text-sm font-semibold text-gray-500 rounded-xl sm:rounded-none px-4 shrink-0 [&>span:not([data-placeholder])]:text-gray-800">
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
        <MapPin className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-gray-400" />
        <Input
          placeholder="Localidad o CP"
          value={ciudad}
          onChange={(e) => setCiudad(e.target.value)}
          className="pl-9 bg-white border-0 shadow-sm !h-12 text-sm font-semibold text-gray-800 rounded-xl sm:rounded-none w-full min-w-0 focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:font-normal placeholder:text-gray-400 placeholder:text-sm"
        />
      </div>

      {/* Selector de tipo de vehículo */}
      <Select value={vehicleType || undefined} onValueChange={(v) => setVehicleType(v === "ALL" ? "" : v as VehicleType)}>
        <SelectTrigger className="w-full sm:w-40 bg-white border-0 shadow-sm !h-12 text-sm font-semibold text-gray-500 rounded-xl sm:rounded-none px-4 shrink-0 [&>span:not([data-placeholder])]:text-gray-800">
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
        className="w-full sm:w-auto flex items-center justify-center gap-2 h-12 px-6 shrink-0 bg-gartify-orange hover:bg-gartify-orange/90 transition-colors text-white font-semibold text-sm rounded-xl sm:rounded-none"
        aria-label="Buscar talleres"
      >
        <Search className="h-4 w-4" />
        <span>Buscar</span>
      </button>
    </form>
  );
}
