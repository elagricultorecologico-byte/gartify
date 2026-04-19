"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";
import { VEHICLE_LABELS, VEHICLE_ICONS, VEHICLE_TYPES } from "@/lib/utils";

const TYPES = [
  { value: "ITV",           label: "ITV" },
  { value: "PRE_ITV",       label: "Pre-ITV" },
  { value: "REVISION",      label: "Revisión" },
  { value: "CAMBIO_ACEITE", label: "Cambio de aceite" },
  { value: "FRENOS",        label: "Frenos" },
  { value: "NEUMATICOS",    label: "Neumáticos" },
  { value: "CLIMATIZACION", label: "Climatización" },
  { value: "DIAGNOSTICO",   label: "Diagnóstico" },
  { value: "ELECTRICIDAD",  label: "Electricidad" },
  { value: "OTRO",          label: "Otro" },
];

const TODOS_LOS_TIPOS = [...VEHICLE_TYPES] as string[];

export function ServiceForm({ garageId, onAdded }: { garageId: string; onAdded?: () => void }) {
  const router = useRouter();
  const [type, setType] = useState("");
  const [vehicleTypes, setVehicleTypes] = useState<string[]>(TODOS_LOS_TIPOS);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  function toggleVehicleType(tipo: string) {
    setVehicleTypes((prev) =>
      prev.includes(tipo)
        ? prev.filter((t) => t !== tipo)
        : [...prev, tipo]
    );
  }

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    if (vehicleTypes.length === 0) { setError("Selecciona al menos un tipo de vehículo"); return; }

    setLoading(true);
    setError("");
    const fd = new FormData(e.currentTarget);

    const res = await fetch("/api/garage/services", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        garageId,
        type,
        name:         fd.get("name"),
        description:  fd.get("description"),
        price:        parseFloat(fd.get("price") as string),
        duration:     parseInt(fd.get("duration") as string),
        vehicleTypes,
      }),
    });

    const data = await res.json();
    setLoading(false);
    if (!res.ok) { setError(data.error); return; }

    (e.target as HTMLFormElement).reset();
    setType("");
    setVehicleTypes(TODOS_LOS_TIPOS);
    if (onAdded) { onAdded(); } else { router.refresh(); }
  }

  return (
    <form onSubmit={handleSubmit} className="space-y-3">
      {/* Tipo */}
      <div className="space-y-1.5">
        <Label className="text-xs font-semibold text-gartify-blue">Tipo</Label>
        <Select onValueChange={setType} required>
          <SelectTrigger className="h-8 text-sm"><SelectValue placeholder="Selecciona tipo" /></SelectTrigger>
          <SelectContent>
            {TYPES.map((t) => <SelectItem key={t.value} value={t.value}>{t.label}</SelectItem>)}
          </SelectContent>
        </Select>
      </div>

      {/* Nombre */}
      <div className="space-y-1.5">
        <Label className="text-xs font-semibold text-gartify-blue">Nombre del servicio</Label>
        <Input name="name" placeholder="Revisión completa" required className="h-8 text-sm" />
      </div>

      {/* Precio + Duración */}
      <div className="grid grid-cols-2 gap-2">
        <div className="space-y-1.5">
          <Label className="text-xs font-semibold text-gartify-blue">Precio (€)</Label>
          <Input name="price" type="number" step="0.01" min="0" placeholder="89" required className="h-8 text-sm" />
        </div>
        <div className="space-y-1.5">
          <Label className="text-xs font-semibold text-gartify-blue">Duración (min)</Label>
          <Input name="duration" type="number" min="15" step="15" placeholder="60" required className="h-8 text-sm" />
        </div>
      </div>

      {/* Tipos de vehículo — fila de iconos */}
      <div className="space-y-1.5">
        <div className="flex items-center justify-between">
          <Label className="text-xs font-semibold text-gartify-blue">Vehículos</Label>
          <button
            type="button"
            onClick={() => setVehicleTypes(vehicleTypes.length === TODOS_LOS_TIPOS.length ? [] : TODOS_LOS_TIPOS)}
            className="text-[11px] text-gartify-blue hover:underline"
          >
            {vehicleTypes.length === TODOS_LOS_TIPOS.length ? "Quitar todos" : "Todos"}
          </button>
        </div>
        <div className="flex gap-1 flex-wrap">
          {VEHICLE_TYPES.map((tipo) => {
            const activo = vehicleTypes.includes(tipo);
            return (
              <button
                key={tipo}
                type="button"
                onClick={() => toggleVehicleType(tipo)}
                aria-pressed={activo}
                title={VEHICLE_LABELS[tipo]}
                className={`flex items-center gap-1 rounded-none border px-2 py-1 text-xs font-medium transition-colors
                  ${activo
                    ? "bg-gartify-blue/10 border-gartify-blue/40 text-gartify-blue"
                    : "bg-gray-50 border-gray-200 text-muted-foreground hover:border-gray-300"
                  }`}
              >
                <span aria-hidden="true">{VEHICLE_ICONS[tipo]}</span>
                <span className="hidden sm:inline">{VEHICLE_LABELS[tipo]}</span>
              </button>
            );
          })}
        </div>
        {vehicleTypes.length === 0 && (
          <p className="text-xs text-red-400">Selecciona al menos un tipo</p>
        )}
      </div>

      {error && <p className="text-xs text-red-400">{error}</p>}

      <Button
        type="submit"
        size="sm"
        className="w-full bg-gartify-green hover:bg-green-600 text-white"
        disabled={loading || !type || vehicleTypes.length === 0}
      >
        {loading ? "Añadiendo..." : "Añadir servicio"}
      </Button>
    </form>
  );
}
