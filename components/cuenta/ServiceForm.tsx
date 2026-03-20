"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";
import { Textarea } from "@/components/ui/textarea";
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

// Por defecto el servicio aplica a todos los tipos de vehículo
const TODOS_LOS_TIPOS = [...VEHICLE_TYPES] as string[];

export function ServiceForm({ garageId }: { garageId: string }) {
  const router = useRouter();
  const [type, setType] = useState("");
  const [vehicleTypes, setVehicleTypes] = useState<string[]>(TODOS_LOS_TIPOS);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  /** Activa o desactiva un tipo de vehículo en la selección */
  function toggleVehicleType(tipo: string) {
    setVehicleTypes((prev) =>
      prev.includes(tipo)
        ? prev.filter((t) => t !== tipo)
        : [...prev, tipo]
    );
  }

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();

    // Validación cliente: al menos un tipo de vehículo seleccionado
    if (vehicleTypes.length === 0) {
      setError("Selecciona al menos un tipo de vehículo");
      return;
    }

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

    // Reiniciar formulario al estado inicial
    (e.target as HTMLFormElement).reset();
    setType("");
    setVehicleTypes(TODOS_LOS_TIPOS);
    router.refresh();
  }

  return (
    <form onSubmit={handleSubmit} className="space-y-4">
      <div className="grid grid-cols-2 gap-3">
        <div className="space-y-1.5">
          <Label>Tipo</Label>
          <Select onValueChange={setType} required>
            <SelectTrigger><SelectValue placeholder="Selecciona tipo" /></SelectTrigger>
            <SelectContent>
              {TYPES.map((t) => <SelectItem key={t.value} value={t.value}>{t.label}</SelectItem>)}
            </SelectContent>
          </Select>
        </div>
        <div className="space-y-1.5">
          <Label>Nombre del servicio</Label>
          <Input name="name" placeholder="Revisión completa" required />
        </div>
      </div>
      <div className="grid grid-cols-2 gap-3">
        <div className="space-y-1.5">
          <Label>Precio (€)</Label>
          <Input name="price" type="number" step="0.01" min="0" placeholder="89.00" required />
        </div>
        <div className="space-y-1.5">
          <Label>Duración (min)</Label>
          <Input name="duration" type="number" min="15" step="15" placeholder="60" required />
        </div>
      </div>
      <div className="space-y-1.5">
        <Label>Descripción (opcional)</Label>
        <Textarea name="description" placeholder="Detalles del servicio..." rows={2} />
      </div>

      {/* Selector de tipos de vehículo */}
      <div className="space-y-2">
        <div className="flex items-center justify-between">
          <Label>
            Tipos de vehículo
            <span className="ml-1 text-xs font-normal text-muted-foreground">(selecciona los que apliquen)</span>
          </Label>
          <button
            type="button"
            onClick={() => setVehicleTypes(vehicleTypes.length === TODOS_LOS_TIPOS.length ? [] : TODOS_LOS_TIPOS)}
            className="text-xs text-gartify-blue hover:underline"
          >
            {vehicleTypes.length === TODOS_LOS_TIPOS.length ? "Deseleccionar todos" : "Seleccionar todos"}
          </button>
        </div>
        <div className="flex flex-wrap gap-2">
          {VEHICLE_TYPES.map((tipo) => {
            const activo = vehicleTypes.includes(tipo);
            return (
              <button
                key={tipo}
                type="button"
                onClick={() => toggleVehicleType(tipo)}
                aria-pressed={activo}
                className={`inline-flex items-center gap-1.5 rounded-full border px-3 py-1 text-xs font-medium transition-colors
                  ${activo
                    ? "bg-gartify-blue/10 border-gartify-blue/40 text-gartify-blue"
                    : "bg-gray-50 border-gray-200 text-muted-foreground hover:border-gray-300"
                  }`}
              >
                <span aria-hidden="true">{VEHICLE_ICONS[tipo]}</span>
                {VEHICLE_LABELS[tipo]}
              </button>
            );
          })}
        </div>
        {vehicleTypes.length === 0 && (
          <p className="text-xs text-red-400">Selecciona al menos un tipo de vehículo</p>
        )}
      </div>

      {error && <p className="text-sm text-red-400">{error}</p>}
      <Button type="submit" disabled={loading || !type || vehicleTypes.length === 0}>
        {loading ? "Añadiendo..." : "Añadir servicio"}
      </Button>
    </form>
  );
}
