"use client";

import { useState } from "react";
import { useRouter } from "next/navigation";
import { BookOpen, CheckCircle2, X } from "lucide-react";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Textarea } from "@/components/ui/textarea";

// ─── Tipos ───────────────────────────────────────────────────────────────────

interface Props {
  bookingId:    string;
  serviceName:  string;         // Pre-rellena el campo workDone
  vehiclePlate?: string | null;
  vehicleModel?: string | null;
  hasRecord:    boolean;        // Si ya tiene sello, muestra badge en lugar del botón
}

// ─── Estado del formulario ───────────────────────────────────────────────────

interface EstadoFormulario {
  workDone:       string;
  mileage:        string;
  nextReviewDate: string;
  nextMileage:    string;
  stampedBy:      string;
}

const estadoInicial = (serviceName: string): EstadoFormulario => ({
  workDone:       serviceName,
  mileage:        "",
  nextReviewDate: "",
  nextMileage:    "",
  stampedBy:      "",
});

// ─── Componente ─────────────────────────────────────────────────────────────

export function SelloReservaButton({
  bookingId,
  serviceName,
  vehiclePlate,
  vehicleModel,
  hasRecord,
}: Props) {
  const router                    = useRouter();
  const [abierto, setAbierto]     = useState(false);
  const [enviando, setEnviando]   = useState(false);
  const [error, setError]         = useState<string | null>(null);
  const [formulario, setFormulario] = useState<EstadoFormulario>(
    estadoInicial(serviceName)
  );

  // Si ya tiene sello, mostramos un badge inmutable
  if (hasRecord) {
    return (
      <span
        className="inline-flex items-center gap-1.5 bg-green-100 text-green-700 border border-green-200 rounded-full px-2.5 py-1 text-xs font-semibold"
        aria-label="Esta revisión ya tiene sello"
      >
        <CheckCircle2 className="h-3.5 w-3.5 shrink-0" aria-hidden="true" />
        Sellado
      </span>
    );
  }

  // ── Manejadores ────────────────────────────────────────────────────────────

  function actualizarCampo(campo: keyof EstadoFormulario, valor: string) {
    setFormulario((prev) => ({ ...prev, [campo]: valor }));
  }

  function cancelar() {
    setAbierto(false);
    setError(null);
    setFormulario(estadoInicial(serviceName));
  }

  async function enviarSello(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setEnviando(true);
    setError(null);

    // Construimos el payload filtrando campos vacíos opcionales
    const payload: Record<string, unknown> = {
      bookingId,
      workDone: formulario.workDone.trim(),
    };

    const km = parseInt(formulario.mileage, 10);
    if (!isNaN(km) && formulario.mileage.trim() !== "") {
      payload.mileage = km;
    }

    if (formulario.nextReviewDate.trim() !== "") {
      // El input date devuelve "YYYY-MM-DD"; lo convertimos a ISO 8601 con hora UTC
      payload.nextReviewDate = new Date(formulario.nextReviewDate).toISOString();
    }

    const kmProximo = parseInt(formulario.nextMileage, 10);
    if (!isNaN(kmProximo) && formulario.nextMileage.trim() !== "") {
      payload.nextMileage = kmProximo;
    }

    if (formulario.stampedBy.trim() !== "") {
      payload.stampedBy = formulario.stampedBy.trim();
    }

    try {
      const respuesta = await fetch("/api/service-records", {
        method:  "POST",
        headers: { "Content-Type": "application/json" },
        body:    JSON.stringify(payload),
      });

      if (!respuesta.ok) {
        const datos = await respuesta.json().catch(() => ({})) as { error?: string };
        setError(datos.error ?? "Error al guardar el sello");
        return;
      }

      // Refrescamos la página del servidor para reflejar el nuevo estado
      router.refresh();
      setAbierto(false);
    } catch {
      setError("Error de red al guardar el sello");
    } finally {
      setEnviando(false);
    }
  }

  // ── Render ─────────────────────────────────────────────────────────────────

  if (!abierto) {
    return (
      <Button
        variant="outline"
        size="sm"
        onClick={() => setAbierto(true)}
        className="h-7 gap-1.5 text-xs border-gartify-blue/40 text-gartify-blue hover:bg-gartify-blue/5 hover:border-gartify-blue/60"
        aria-label="Añadir sello de revisión a esta reserva"
      >
        <BookOpen className="h-3.5 w-3.5 shrink-0" aria-hidden="true" />
        Sellar
      </Button>
    );
  }

  return (
    // Formulario inline con borde azul — sin modal
    <div className="mt-3 rounded-xl border border-gartify-blue/30 bg-white shadow-sm overflow-hidden">
      {/* Cabecera */}
      <div className="flex items-center justify-between px-4 py-2.5 bg-blue-50 border-b border-gartify-blue/20">
        <div className="flex items-center gap-2">
          <BookOpen className="h-4 w-4 text-gartify-blue shrink-0" aria-hidden="true" />
          <span className="text-sm font-semibold text-gartify-blue">Sello de revisión</span>
        </div>
        {/* Contexto del vehículo */}
        {(vehicleModel || vehiclePlate) && (
          <span className="text-xs text-muted-foreground hidden sm:block">
            {vehicleModel}
            {vehicleModel && vehiclePlate && " · "}
            {vehiclePlate && (
              <span className="font-mono font-semibold text-gartify-blue">{vehiclePlate}</span>
            )}
          </span>
        )}
        <button
          type="button"
          onClick={cancelar}
          className="rounded p-0.5 hover:bg-gartify-blue/10 text-gartify-gray transition-colors"
          aria-label="Cerrar formulario de sello"
        >
          <X className="h-4 w-4" aria-hidden="true" />
        </button>
      </div>

      {/* Formulario */}
      <form onSubmit={enviarSello} className="px-4 py-4 space-y-4">
        {/* Trabajo realizado — obligatorio */}
        <div className="space-y-1.5">
          <Label htmlFor={`workDone-${bookingId}`} className="text-xs font-semibold text-gartify-gray">
            Trabajo realizado <span className="text-red-500" aria-hidden="true">*</span>
          </Label>
          <Textarea
            id={`workDone-${bookingId}`}
            value={formulario.workDone}
            onChange={(e) => actualizarCampo("workDone", e.target.value)}
            placeholder="Describe el trabajo realizado…"
            required
            maxLength={500}
            rows={3}
            className="text-sm resize-none border-gray-200 focus-visible:ring-gartify-blue/30"
          />
          <p className="text-[11px] text-muted-foreground text-right">
            {formulario.workDone.length}/500
          </p>
        </div>

        {/* Km actuales */}
        <div className="space-y-1.5">
          <Label htmlFor={`mileage-${bookingId}`} className="text-xs font-semibold text-gartify-gray">
            Km actuales del vehículo
          </Label>
          <Input
            id={`mileage-${bookingId}`}
            type="number"
            min={0}
            value={formulario.mileage}
            onChange={(e) => actualizarCampo("mileage", e.target.value)}
            placeholder="Ej: 45000"
            className="text-sm border-gray-200 focus-visible:ring-gartify-blue/30"
          />
        </div>

        {/* Próxima revisión (fecha y km) — dos columnas */}
        <div className="grid grid-cols-1 sm:grid-cols-2 gap-3">
          <div className="space-y-1.5">
            <Label htmlFor={`nextReviewDate-${bookingId}`} className="text-xs font-semibold text-gartify-gray">
              Próxima revisión
            </Label>
            <Input
              id={`nextReviewDate-${bookingId}`}
              type="date"
              value={formulario.nextReviewDate}
              onChange={(e) => actualizarCampo("nextReviewDate", e.target.value)}
              className="text-sm border-gray-200 focus-visible:ring-gartify-blue/30"
            />
          </div>
          <div className="space-y-1.5">
            <Label htmlFor={`nextMileage-${bookingId}`} className="text-xs font-semibold text-gartify-gray">
              Km próxima revisión
            </Label>
            <Input
              id={`nextMileage-${bookingId}`}
              type="number"
              min={0}
              value={formulario.nextMileage}
              onChange={(e) => actualizarCampo("nextMileage", e.target.value)}
              placeholder="Ej: 55000"
              className="text-sm border-gray-200 focus-visible:ring-gartify-blue/30"
            />
          </div>
        </div>

        {/* Responsable / mecánico */}
        <div className="space-y-1.5">
          <Label htmlFor={`stampedBy-${bookingId}`} className="text-xs font-semibold text-gartify-gray">
            Responsable / mecánico
          </Label>
          <Input
            id={`stampedBy-${bookingId}`}
            type="text"
            maxLength={100}
            value={formulario.stampedBy}
            onChange={(e) => actualizarCampo("stampedBy", e.target.value)}
            placeholder="Nombre del mecánico o responsable"
            className="text-sm border-gray-200 focus-visible:ring-gartify-blue/30"
          />
        </div>

        {/* Mensaje de error */}
        {error && (
          <p role="alert" className="text-xs text-red-600 bg-red-50 border border-red-200 rounded-lg px-3 py-2">
            {error}
          </p>
        )}

        {/* Botones de acción */}
        <div className="flex justify-end gap-2 pt-1">
          <Button
            type="button"
            variant="ghost"
            size="sm"
            onClick={cancelar}
            disabled={enviando}
            className="text-xs text-gartify-gray hover:text-foreground"
          >
            Cancelar
          </Button>
          <Button
            type="submit"
            size="sm"
            disabled={enviando || formulario.workDone.trim().length === 0}
            className="text-xs bg-gartify-blue hover:bg-gartify-blue/90 text-white gap-1.5"
          >
            <BookOpen className="h-3.5 w-3.5 shrink-0" aria-hidden="true" />
            {enviando ? "Guardando…" : "Sellar revisión"}
          </Button>
        </div>
      </form>
    </div>
  );
}
