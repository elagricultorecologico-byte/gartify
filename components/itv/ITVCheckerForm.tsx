"use client";
import { useState } from "react";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { ExternalLink, AlertTriangle, Info } from "lucide-react";

const DGT_BASE_URL =
  "https://sede.dgt.gob.es/es/mi_dgt/mis-vehiculos/detalle-vehiculo/";

export function ITVCheckerForm() {
  const [plate, setPlate] = useState("");
  const formattedPlate = plate.toUpperCase().replace(/[^A-Z0-9]/g, "");

  function handleCheck(e: React.FormEvent) {
    e.preventDefault();
    if (!formattedPlate) return;
    const url = `${DGT_BASE_URL}?matricula=${formattedPlate}&entidad=usuario`;
    window.open(url, "_blank", "noopener,noreferrer");
  }

  return (
    <form onSubmit={handleCheck} className="space-y-4">
      <div className="space-y-1.5">
        <Label htmlFor="plate" className="text-xs font-semibold text-gartify-blue">
          Matrícula del vehículo
        </Label>
        <Input
          id="plate"
          placeholder="Ej: 1234 ABC"
          value={plate}
          onChange={(e) => setPlate(e.target.value)}
          className="text-center text-lg font-bold tracking-widest uppercase h-12"
          maxLength={10}
          autoComplete="off"
        />
      </div>
      <Button
        type="submit"
        disabled={!formattedPlate}
        className="w-full h-11 bg-gartify-green hover:bg-gartify-green/90 text-white font-semibold gap-2 disabled:opacity-50"
      >
        <ExternalLink className="h-4 w-4" aria-hidden="true" />
        Consultar en la DGT
      </Button>

      <div
        role="note"
        className="flex items-start gap-3 bg-amber-50 border border-amber-200 rounded-lg px-4 py-3 text-sm text-amber-800"
      >
        <AlertTriangle className="h-4 w-4 shrink-0 mt-0.5 text-amber-500" aria-hidden="true" />
        <p>
          La DGT requiere <strong>identificación previa</strong>. Consulta los
          métodos disponibles a la derecha.
        </p>
      </div>

      <div
        role="note"
        className="flex items-start gap-3 bg-blue-50 border border-blue-100 rounded-lg px-4 py-3 text-sm text-gartify-hero"
      >
        <Info className="h-4 w-4 shrink-0 mt-0.5" aria-hidden="true" />
        <p>
          La consulta se realiza en la{" "}
          <strong>Sede Electrónica oficial de la DGT</strong>. Gartify no
          almacena ni accede a los datos de tu vehículo.
        </p>
      </div>

      <p className="text-center text-xs text-muted-foreground">
        Acceso directo:{" "}
        <a
          href={DGT_BASE_URL}
          target="_blank"
          rel="noopener noreferrer"
          className="text-gartify-orange font-semibold hover:underline"
        >
          sede.dgt.gob.es
        </a>
      </p>
    </form>
  );
}
