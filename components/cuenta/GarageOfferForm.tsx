"use client";

import { useState } from "react";
import { useRouter } from "next/navigation";
import { Tag, Trash2, Clock, AlertCircle } from "lucide-react";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { formatPrice } from "@/lib/utils";
import { cn } from "@/lib/utils";

// Días de la semana con su etiqueta abreviada y código interno
const DIAS_SEMANA = [
  { codigo: "LUN", etiqueta: "Lun" },
  { codigo: "MAR", etiqueta: "Mar" },
  { codigo: "MIE", etiqueta: "Mié" },
  { codigo: "JUE", etiqueta: "Jue" },
  { codigo: "VIE", etiqueta: "Vie" },
  { codigo: "SAB", etiqueta: "Sáb" },
  { codigo: "DOM", etiqueta: "Dom" },
] as const;

type CodigoDia = (typeof DIAS_SEMANA)[number]["codigo"];

type Oferta = {
  id:        string;
  label:     string;
  days:      string;   // JSON serializado
  startTime: string;
  endTime:   string;
  price:     number;
  isActive:  boolean;
};

type Props = {
  ofertas: Oferta[];
};

/** Parsea el JSON de días almacenado en SQLite y devuelve array tipado */
function parsearDias(raw: string): CodigoDia[] {
  try {
    const parsed = JSON.parse(raw) as string[];
    const codigosValidos = DIAS_SEMANA.map((d) => d.codigo as string);
    return parsed.filter((d): d is CodigoDia => codigosValidos.includes(d));
  } catch {
    return [];
  }
}

/** Formatea el rango de días de una oferta para mostrar en la card */
function formatearDias(dias: CodigoDia[]): string {
  if (dias.length === 0) return "—";
  const etiquetas = DIAS_SEMANA
    .filter((d) => dias.includes(d.codigo))
    .map((d) => d.etiqueta);
  return etiquetas.join(", ");
}

export function GarageOfferForm({ ofertas: ofertasIniciales }: Props) {
  const router = useRouter();

  // Estado local para edición optimista antes de que router.refresh() refresque el server
  const [ofertas, setOfertas] = useState<Oferta[]>(ofertasIniciales);
  const [diasSeleccionados, setDiasSeleccionados] = useState<CodigoDia[]>([]);
  const [cargando, setCargando] = useState(false);
  const [eliminando, setEliminando] = useState<string | null>(null);
  const [error, setError] = useState("");

  /** Alterna la selección de un día en el formulario */
  function toggleDia(codigo: CodigoDia) {
    setDiasSeleccionados((prev) =>
      prev.includes(codigo)
        ? prev.filter((d) => d !== codigo)
        : [...prev, codigo]
    );
  }

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    if (diasSeleccionados.length === 0) {
      setError("Selecciona al menos un día de la semana");
      return;
    }

    setCargando(true);
    setError("");

    const fd = new FormData(e.currentTarget);

    const respuesta = await fetch("/api/garage/offers", {
      method:  "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        label:     fd.get("label"),
        days:      diasSeleccionados,
        startTime: fd.get("startTime"),
        endTime:   fd.get("endTime"),
        price:     parseFloat(fd.get("price") as string),
      }),
    });

    const datos = await respuesta.json() as { error?: string } & Oferta;
    setCargando(false);

    if (!respuesta.ok) {
      setError(datos.error ?? "Error al crear la oferta");
      return;
    }

    // Actualización optimista: agregar la nueva oferta al estado local
    setOfertas((prev) => [datos, ...prev]);
    setDiasSeleccionados([]);
    (e.target as HTMLFormElement).reset();

    router.refresh();
  }

  async function handleEliminar(id: string) {
    setEliminando(id);

    const respuesta = await fetch(`/api/garage/offers/${id}`, { method: "DELETE" });

    if (respuesta.ok) {
      // Actualización optimista: quitar la oferta del estado local
      setOfertas((prev) => prev.filter((o) => o.id !== id));
      router.refresh();
    }

    setEliminando(null);
  }

  return (
    <div className="space-y-8">
      {/* ── Formulario de nueva oferta ─────────────────────────────────────── */}
      <form onSubmit={handleSubmit} className="space-y-5">
        {/* Etiqueta */}
        <div className="space-y-1.5">
          <Label htmlFor="oferta-label" className="text-xs font-semibold text-gartify-blue uppercase tracking-wide">Nombre de la oferta</Label>
          <Input
            id="oferta-label"
            name="label"
            placeholder="Ej: Cambio de aceite express"
            maxLength={80}
            required
          />
        </div>

        {/* Selector de días */}
        <div className="space-y-2">
          <Label className="text-xs font-semibold text-gartify-blue uppercase tracking-wide">Días de la semana</Label>
          <div className="flex flex-wrap gap-2">
            {DIAS_SEMANA.map(({ codigo, etiqueta }) => (
              <button
                key={codigo}
                type="button"
                onClick={() => toggleDia(codigo)}
                aria-pressed={diasSeleccionados.includes(codigo)}
                className={cn(
                  "rounded-none px-3 py-1 text-sm font-medium border transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-gartify-orange",
                  diasSeleccionados.includes(codigo)
                    ? "bg-gartify-orange text-white border-gartify-orange"
                    : "bg-white text-gartify-gray border-gray-300 hover:border-gartify-orange/60 hover:text-gartify-orange"
                )}
              >
                {etiqueta}
              </button>
            ))}
          </div>
        </div>

        {/* Horario */}
        <div className="grid grid-cols-2 gap-3">
          <div className="space-y-1.5">
            <Label htmlFor="oferta-startTime" className="text-xs font-semibold text-gartify-blue uppercase tracking-wide">Hora inicio</Label>
            <Input
              id="oferta-startTime"
              name="startTime"
              type="time"
              required
            />
          </div>
          <div className="space-y-1.5">
            <Label htmlFor="oferta-endTime" className="text-xs font-semibold text-gartify-blue uppercase tracking-wide">Hora fin</Label>
            <Input
              id="oferta-endTime"
              name="endTime"
              type="time"
              required
            />
          </div>
        </div>

        {/* Precio */}
        <div className="space-y-1.5">
          <Label htmlFor="oferta-price" className="text-xs font-semibold text-gartify-blue uppercase tracking-wide">Precio de oferta (€)</Label>
          <Input
            id="oferta-price"
            name="price"
            type="number"
            step="0.01"
            min="0.01"
            placeholder="19.99"
            required
          />
        </div>

        {/* Error de validación */}
        {error && (
          <p className="flex items-center gap-1.5 text-sm text-red-500" role="alert">
            <AlertCircle className="h-4 w-4 shrink-0" aria-hidden="true" />
            {error}
          </p>
        )}

        <Button
          type="submit"
          disabled={cargando}
          className="bg-gartify-orange hover:bg-gartify-orange/90 text-white"
        >
          {cargando ? "Guardando..." : "Añadir oferta"}
        </Button>
      </form>

      {/* ── Listado de ofertas existentes ──────────────────────────────────── */}
      {ofertas.length > 0 ? (
        <section>
          <h2 className="text-sm font-bold uppercase tracking-wide text-gartify-gray mb-3">
            Ofertas activas ({ofertas.length})
          </h2>
          <div className="space-y-3">
            {ofertas.map((oferta) => {
              const dias = parsearDias(oferta.days);
              return (
                <div
                  key={oferta.id}
                  className="bg-white border border-gray-200 overflow-hidden flex flex-col sm:flex-row hover:border-gartify-orange/40 transition-all"
                >
                  {/* Acento de color izquierdo */}
                  <div className="sm:w-2 shrink-0 bg-gradient-to-b from-gartify-orange to-amber-400" />

                  {/* Contenido */}
                  <div className="flex-1 p-4 flex items-center justify-between gap-4">
                    <div className="space-y-1.5 min-w-0">
                      <div className="flex items-center gap-2">
                        <Tag className="h-3.5 w-3.5 text-gartify-orange shrink-0" aria-hidden="true" />
                        <span className="font-bold text-gartify-blue text-sm truncate">{oferta.label}</span>
                      </div>
                      <div className="flex items-center gap-1 text-xs text-muted-foreground">
                        <Clock className="h-3.5 w-3.5 text-gartify-mid shrink-0" aria-hidden="true" />
                        <span>{formatearDias(dias)}</span>
                        <span className="mx-1 text-gray-300">·</span>
                        <span>{oferta.startTime} – {oferta.endTime}</span>
                      </div>
                    </div>
                    <div className="flex items-center gap-3 shrink-0">
                      <span className="text-lg font-bold text-gartify-orange">
                        {formatPrice(oferta.price)}
                      </span>
                      <Button
                        variant="ghost"
                        size="icon"
                        onClick={() => handleEliminar(oferta.id)}
                        disabled={eliminando === oferta.id}
                        aria-label={`Eliminar oferta ${oferta.label}`}
                        className="h-8 w-8 text-red-400 hover:text-red-600 hover:bg-red-50"
                      >
                        <Trash2 className="h-4 w-4" aria-hidden="true" />
                      </Button>
                    </div>
                  </div>
                </div>
              );
            })}
          </div>
        </section>
      ) : (
        <div className="text-center py-10 border border-dashed border-gray-200 bg-gray-50">
          <Tag className="h-8 w-8 mx-auto mb-3 text-gartify-mid opacity-50" aria-hidden="true" />
          <p className="font-semibold text-foreground">Sin ofertas todavía</p>
          <p className="text-sm text-muted-foreground mt-1">
            Añade tu primera oferta con el formulario de arriba
          </p>
        </div>
      )}
    </div>
  );
}
