"use client";
import { useRouter, useSearchParams } from "next/navigation";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { X } from "lucide-react";

const SERVICES = [
  { value: "ALL",           label: "Todos los servicios" },
  { value: "ITV",           label: "ITV" },
  { value: "PRE_ITV",       label: "Pre-ITV" },
  { value: "REVISION",      label: "Revisión" },
  { value: "CAMBIO_ACEITE", label: "Cambio de aceite" },
  { value: "FRENOS",        label: "Frenos" },
  { value: "NEUMATICOS",    label: "Neumáticos" },
  { value: "CLIMATIZACION", label: "Climatización" },
  { value: "DIAGNOSTICO",   label: "Diagnóstico" },
  { value: "ELECTRICIDAD",  label: "Electricidad" },
];

export function GarageFilters() {
  const router = useRouter();
  const sp = useSearchParams();

  function update(key: string, value: string) {
    const params = new URLSearchParams(sp.toString());
    if (value && value !== "ALL") params.set(key, value);
    else params.delete(key);
    router.push(`/talleres?${params.toString()}`);
  }

  const hasFilers = sp.has("servicio") || sp.has("ciudad");

  return (
    <div className="flex flex-wrap gap-3 items-center">
      <Input
        placeholder="Ciudad o CP"
        defaultValue={sp.get("ciudad") ?? ""}
        className="w-44"
        onKeyDown={(e) => {
          if (e.key === "Enter") update("ciudad", (e.target as HTMLInputElement).value);
        }}
        onBlur={(e) => update("ciudad", e.target.value)}
      />

      <Select
        defaultValue={sp.get("servicio") ?? "ALL"}
        onValueChange={(v) => update("servicio", v)}
      >
        <SelectTrigger className="w-52">
          <SelectValue placeholder="Servicio" />
        </SelectTrigger>
        <SelectContent>
          {SERVICES.map((s) => (
            <SelectItem key={s.value} value={s.value}>{s.label}</SelectItem>
          ))}
        </SelectContent>
      </Select>

      {hasFilers && (
        <Button variant="ghost" size="sm" onClick={() => router.push("/talleres")} className="gap-1 text-muted-foreground">
          <X className="h-3.5 w-3.5" /> Limpiar
        </Button>
      )}
    </div>
  );
}
