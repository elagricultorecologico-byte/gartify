"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";
import { Textarea } from "@/components/ui/textarea";

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

export function ServiceForm({ garageId }: { garageId: string }) {
  const router = useRouter();
  const [type, setType] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setLoading(true);
    setError("");
    const fd = new FormData(e.currentTarget);

    const res = await fetch("/api/garage/services", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        garageId,
        type,
        name:        fd.get("name"),
        description: fd.get("description"),
        price:       parseFloat(fd.get("price") as string),
        duration:    parseInt(fd.get("duration") as string),
      }),
    });

    const data = await res.json();
    setLoading(false);
    if (!res.ok) { setError(data.error); return; }

    (e.target as HTMLFormElement).reset();
    setType("");
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
      {error && <p className="text-sm text-red-400">{error}</p>}
      <Button type="submit" disabled={loading || !type}>
        {loading ? "Añadiendo..." : "Añadir servicio"}
      </Button>
    </form>
  );
}
