"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import { Search, MapPin } from "lucide-react";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";

const SERVICES = [
  { value: "ITV",          label: "ITV" },
  { value: "PRE_ITV",      label: "Pre-ITV" },
  { value: "REVISION",     label: "Revisión / Mantenimiento" },
  { value: "CAMBIO_ACEITE",label: "Cambio de aceite" },
  { value: "FRENOS",       label: "Frenos" },
  { value: "NEUMATICOS",   label: "Neumáticos" },
  { value: "CLIMATIZACION",label: "Aire acondicionado" },
  { value: "DIAGNOSTICO",  label: "Diagnóstico" },
  { value: "ELECTRICIDAD", label: "Electricidad" },
];

export function SearchBar({ className }: { className?: string }) {
  const router = useRouter();
  const [servicio, setServicio] = useState("");
  const [ciudad, setCiudad] = useState("");

  const handleSearch = (e: React.FormEvent) => {
    e.preventDefault();
    const params = new URLSearchParams();
    if (servicio) params.set("servicio", servicio);
    if (ciudad.trim()) params.set("ciudad", ciudad.trim());
    router.push(`/talleres?${params.toString()}`);
  };

  return (
    <form onSubmit={handleSearch} className={`flex flex-col sm:flex-row gap-3 ${className}`}>
      <Select onValueChange={setServicio}>
        <SelectTrigger className="sm:w-64 bg-background/80 border-border/60 h-12">
          <SelectValue placeholder="¿Qué necesitas?" />
        </SelectTrigger>
        <SelectContent>
          {SERVICES.map((s) => (
            <SelectItem key={s.value} value={s.value}>{s.label}</SelectItem>
          ))}
        </SelectContent>
      </Select>

      <div className="relative flex-1">
        <MapPin className="absolute left-3 top-1/2 -translate-y-1/2 h-4 w-4 text-muted-foreground" />
        <Input
          placeholder="Ciudad o código postal"
          value={ciudad}
          onChange={(e) => setCiudad(e.target.value)}
          className="pl-9 bg-background/80 border-border/60 h-12"
        />
      </div>

      <Button type="submit" size="lg" className="h-12 gap-2 px-8">
        <Search className="h-4 w-4" />
        Buscar
      </Button>
    </form>
  );
}
