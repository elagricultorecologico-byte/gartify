"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import { Search, MapPin } from "lucide-react";
import { Button } from "@/components/ui/button";
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
    <form onSubmit={handleSearch} className={`flex flex-col sm:flex-row gap-3 ${className}`}>
      {/* Selector de tipo de vehículo */}
      <Select onValueChange={(v) => setVehicleType(v === "ALL" ? "" : v as VehicleType)}>
        <SelectTrigger className="sm:w-40 bg-white border-gartify-blue/20 !h-12 text-sm text-gray-700 rounded-lg px-3">
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

      {/* Selector de servicio */}
      <Select onValueChange={setServicio}>
        <SelectTrigger className="sm:w-48 bg-white border-gartify-blue/20 !h-12 text-sm text-gray-700 rounded-lg px-3">
          <SelectValue placeholder="¿Qué necesitas?" />
        </SelectTrigger>
        <SelectContent>
          {SEARCHABLE_SERVICES.map((s) => (
            <SelectItem key={s.type} value={s.type}>{s.label}</SelectItem>
          ))}
        </SelectContent>
      </Select>

      {/* Campo de ciudad */}
      <div className="relative flex-1">
        <MapPin className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-muted-foreground" />
        <Input
          placeholder="Ciudad o CP"
          value={ciudad}
          onChange={(e) => setCiudad(e.target.value)}
          className="pl-9 bg-white border-gartify-blue/20 !h-12 text-sm text-gray-700 rounded-lg"
        />
      </div>

      <Button type="submit" size="lg" className="h-12 gap-2 px-8 bg-gartify-green hover:bg-gartify-green/90 text-white">
        <Search className="h-4 w-4" />
        Buscar
      </Button>
    </form>
  );
}
