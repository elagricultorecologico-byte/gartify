"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import { Search, MapPin } from "lucide-react";
import { Input } from "@/components/ui/input";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";
import { SEARCHABLE_SERVICES } from "@/lib/constants";
import { VEHICLE_TYPES, VEHICLE_LABELS, VEHICLE_ICONS, type VehicleType } from "@/lib/utils";

export function SearchBar({ className }: { className?: string }) {
  const router = useRouter();
  const [servicio, setServicio] = useState("");
  const [ciudad, setCiudad] = useState("");
  const [vehicleType, setVehicleType] = useState<VehicleType | "">("");

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
      <Select onValueChange={setServicio}>
        <SelectTrigger className="sm:w-48 bg-white border-0 shadow-sm !h-12 text-sm font-semibold text-gray-500 rounded-none px-4 shrink-0 [&>span:not([data-placeholder])]:text-gray-800">
          <SelectValue placeholder="¿Qué necesitas?" />
        </SelectTrigger>
        <SelectContent>
          {SEARCHABLE_SERVICES.map((s) => (
            <SelectItem key={s.type} value={s.type}>{s.label}</SelectItem>
          ))}
        </SelectContent>
      </Select>

      {/* Campo de ciudad */}
      <div className="relative flex-1 min-w-[160px] sm:flex sm:items-center">
        <MapPin className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-gray-400" />
        <Input
          placeholder="Localidad o CP"
          value={ciudad}
          onChange={(e) => setCiudad(e.target.value)}
          className="pl-9 bg-white border-0 shadow-sm !h-12 text-sm font-semibold text-gray-800 rounded-none w-full focus-visible:ring-0 focus-visible:ring-offset-0 placeholder:font-semibold placeholder:text-gray-500 placeholder:text-sm"
        />
      </div>

      {/* Selector de tipo de vehículo */}
      <Select onValueChange={(v) => setVehicleType(v === "ALL" ? "" : v as VehicleType)}>
        <SelectTrigger className="sm:w-44 bg-white border-0 shadow-sm !h-12 text-sm font-semibold text-gray-500 rounded-none px-4 shrink-0 [&>span:not([data-placeholder])]:text-gray-800">
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
        className="flex items-center justify-center gap-2 h-12 px-6 shrink-0 bg-gartify-orange hover:bg-gartify-orange/90 transition-colors text-white font-semibold text-sm rounded-none sm:rounded-none"
        aria-label="Buscar talleres"
      >
        <Search className="h-4 w-4" />
        <span>Buscar</span>
      </button>
    </form>
  );
}
