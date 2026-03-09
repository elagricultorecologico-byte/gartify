"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Textarea } from "@/components/ui/textarea";
import { Card, CardContent } from "@/components/ui/card";
import type { Garage } from "@prisma/client";

export function GarageProfileForm({ garage }: { garage: Garage }) {
  const router = useRouter();
  const [loading, setLoading] = useState(false);
  const [error, setError]   = useState("");
  const [success, setSuccess] = useState(false);

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setLoading(true);
    setError("");
    setSuccess(false);
    const fd = new FormData(e.currentTarget);

    const res = await fetch("/api/garage/profile", {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        name:        fd.get("name"),
        description: fd.get("description"),
        address:     fd.get("address"),
        city:        fd.get("city"),
        postalCode:  fd.get("postalCode"),
        phone:       fd.get("phone"),
        email:       fd.get("email"),
      }),
    });

    setLoading(false);
    if (!res.ok) { const d = await res.json(); setError(d.error); return; }
    setSuccess(true);
    router.refresh();
  }

  return (
    <Card>
      <CardContent className="pt-6">
        <form onSubmit={handleSubmit} className="space-y-4">
          <div className="space-y-1.5">
            <Label>Nombre del taller</Label>
            <Input name="name" defaultValue={garage.name} required />
          </div>
          <div className="space-y-1.5">
            <Label>Descripción</Label>
            <Textarea name="description" defaultValue={garage.description ?? ""} rows={3} placeholder="Describe tu taller, especialidades, años de experiencia..." />
          </div>
          <div className="grid grid-cols-2 gap-3">
            <div className="col-span-2 space-y-1.5">
              <Label>Dirección</Label>
              <Input name="address" defaultValue={garage.address} required />
            </div>
          </div>
          <div className="grid grid-cols-3 gap-3">
            <div className="col-span-2 space-y-1.5">
              <Label>Ciudad</Label>
              <Input name="city" defaultValue={garage.city} required />
            </div>
            <div className="space-y-1.5">
              <Label>Código postal</Label>
              <Input name="postalCode" defaultValue={garage.postalCode} maxLength={5} required />
            </div>
          </div>
          <div className="grid grid-cols-2 gap-3">
            <div className="space-y-1.5">
              <Label>Teléfono</Label>
              <Input name="phone" defaultValue={garage.phone} required />
            </div>
            <div className="space-y-1.5">
              <Label>Email de contacto</Label>
              <Input name="email" type="email" defaultValue={garage.email ?? ""} placeholder="info@taller.es" />
            </div>
          </div>
          {error   && <p className="text-sm text-red-400">{error}</p>}
          {success && <p className="text-sm text-green-400">Perfil actualizado correctamente.</p>}
          <div className="flex gap-3">
            <Button type="submit" disabled={loading}>
              {loading ? "Guardando..." : "Guardar cambios"}
            </Button>
            <Button type="button" variant="outline" onClick={() => router.back()}>
              Cancelar
            </Button>
          </div>
        </form>
      </CardContent>
    </Card>
  );
}
