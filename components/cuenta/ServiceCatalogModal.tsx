"use client";

import { useState, useMemo, useTransition } from "react";
import { BookOpen, Search, ChevronDown, Loader2, Check } from "lucide-react";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
  DialogFooter,
} from "@/components/ui/dialog";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
import { CATALOG_SERVICES, getCatalogTypes, type CatalogService } from "@/lib/service-catalog";
import { SERVICE_LABELS } from "@/lib/utils";
import { VEHICLE_TYPES } from "@/lib/utils";
import { cn } from "@/lib/utils";

// ── Tipos locales ─────────────────────────────────────────────────────────────

/** Estado de un servicio seleccionado en el modal */
interface ServicioSeleccionado {
  catalogo: CatalogService;
  /** Precio que el taller quiere cobrar (editable) */
  precio: number;
  /** Duración en minutos (editable) */
  duracion: number;
}

interface ServiceCatalogModalProps {
  /** ID del taller al que se añadirán los servicios */
  garageId: string;
  /**
   * Nombres exactos de los servicios que el taller ya tiene dados de alta.
   * Los servicios del catálogo cuyo `name` coincida aparecerán como "Ya añadido".
   */
  existingNames: string[];
  /** Controla la apertura del modal desde fuera */
  open: boolean;
  onOpenChange: (open: boolean) => void;
  /** Se llama tras guardar con éxito con los servicios recién creados */
  onSuccess: (created: { id: string; type: string; name: string; description: string | null; price: number; duration: number; isActive: boolean; vehicleTypes: string }[]) => void;
}

// ── Utilidades ────────────────────────────────────────────────────────────────

const TODOS_LOS_VEHICULOS = [...VEHICLE_TYPES] as string[];

const MAS_DEMANDADOS = new Set(["ITV", "REVISION", "CAMBIO_ACEITE", "FRENOS", "NEUMATICOS", "DIAGNOSTICO", "CLIMATIZACION", "ELECTRICIDAD"]);

function formatEur(n: number): string {
  if (n === 0) return "Gratuito";
  return new Intl.NumberFormat("es-ES", {
    style: "currency",
    currency: "EUR",
    minimumFractionDigits: 0,
    maximumFractionDigits: 0,
  }).format(n);
}

// ── Fila de servicio del catálogo ─────────────────────────────────────────────

interface FilaCatalogoProps {
  svc: CatalogService;
  yaExiste: boolean;
  seleccionado: ServicioSeleccionado | undefined;
  onToggle: (svc: CatalogService) => void;
  onCambioPrecio: (id: string, precio: number) => void;
  onCambioDuracion: (id: string, duracion: number) => void;
}

function FilaCatalogo({
  svc,
  yaExiste,
  seleccionado,
  onToggle,
  onCambioPrecio,
  onCambioDuracion,
}: FilaCatalogoProps) {
  const activo = !!seleccionado;

  return (
    <div
      className={cn(
        "border px-3 py-2.5 transition-colors",
        yaExiste
          ? "bg-gray-50 border-gray-100 opacity-60"
          : activo
          ? "bg-gartify-blue/5 border-gartify-blue/30"
          : "bg-white border-gray-100 hover:border-gray-200"
      )}
    >
      {/* Fila principal: checkbox + info + precio orientativo */}
      <div className="flex items-start gap-3">
        {/* Checkbox personalizado */}
        <button
          type="button"
          disabled={yaExiste}
          onClick={() => !yaExiste && onToggle(svc)}
          aria-pressed={activo || yaExiste}
          aria-label={yaExiste ? `${svc.name} — ya añadido` : svc.name}
          className={cn(
            "mt-0.5 h-4 w-4 shrink-0 border flex items-center justify-center transition-colors focus-visible:outline-none focus-visible:ring-1 focus-visible:ring-gartify-blue",
            yaExiste
              ? "bg-gray-200 border-gray-300 cursor-not-allowed"
              : activo
              ? "bg-gartify-blue border-gartify-blue"
              : "bg-white border-gray-300 hover:border-gartify-blue"
          )}
        >
          {(activo || yaExiste) && (
            <Check className="h-2.5 w-2.5 text-white" strokeWidth={3} />
          )}
        </button>

        {/* Nombre y descripción */}
        <div className="flex-1 min-w-0">
          <div className="flex items-center gap-2 flex-wrap">
            <span className="text-sm font-semibold text-gartify-dark leading-tight">
              {svc.name}
            </span>
            {yaExiste && (
              <span className="text-[10px] font-bold uppercase tracking-wide px-1.5 py-0.5 bg-green-100 text-green-700 border border-green-200 leading-tight">
                Ya añadido
              </span>
            )}
          </div>
          {svc.description && (
            <p className="text-xs text-gartify-gray mt-0.5 leading-snug">{svc.description}</p>
          )}
        </div>

        {/* Precio orientativo */}
        <div className="shrink-0 text-right">
          <span className="text-xs font-bold text-gartify-orange tabular-nums">
            {formatEur(svc.suggestedPrice)}
          </span>
          <p className="text-[10px] text-gartify-gray">{svc.duration} min</p>
        </div>
      </div>

      {/* Inputs de precio/duración — solo visibles si está seleccionado */}
      {activo && (
        <div className="mt-2.5 pl-7 flex gap-2">
          <div className="flex-1">
            <label className="text-[10px] font-semibold text-gartify-blue uppercase tracking-wide block mb-1">
              Precio (€)
            </label>
            <Input
              type="number"
              min="0"
              step="1"
              value={seleccionado.precio}
              onChange={(e) =>
                onCambioPrecio(svc.id, Math.max(0, parseFloat(e.target.value) || 0))
              }
              className="h-7 text-sm text-right font-semibold text-gartify-orange border-gartify-orange/40 focus:border-gartify-orange"
            />
          </div>
          <div className="flex-1">
            <label className="text-[10px] font-semibold text-gartify-blue uppercase tracking-wide block mb-1">
              Duración (min)
            </label>
            <Input
              type="number"
              min="15"
              step="15"
              value={seleccionado.duracion}
              onChange={(e) =>
                onCambioDuracion(svc.id, Math.max(15, parseInt(e.target.value) || 15))
              }
              className="h-7 text-sm text-right font-semibold text-gartify-blue border-gartify-blue/40 focus:border-gartify-blue"
            />
          </div>
        </div>
      )}
    </div>
  );
}

// ── Componente principal ──────────────────────────────────────────────────────

export function ServiceCatalogModal({
  garageId,
  existingNames,
  open,
  onOpenChange,
  onSuccess,
}: ServiceCatalogModalProps) {
  // Conjunto de nombres existentes para O(1) en la comprobación
  const conjuntoExistentes = useMemo(
    () => new Set(existingNames.map((n) => n.toLowerCase().trim())),
    [existingNames]
  );

  const [busqueda, setBusqueda] = useState("");
  const [tipoFiltro, setTipoFiltro] = useState<string>("TODOS");
  const [seleccionados, setSeleccionados] = useState<Map<string, ServicioSeleccionado>>(new Map());
  const [error, setError] = useState<string | null>(null);
  const [isPending, startTransition] = useTransition();

  // Tipos únicos del catálogo para el select de filtros
  const tiposDisponibles = useMemo(() => getCatalogTypes(), []);

  // Lista filtrada por búsqueda y tipo
  const serviciosFiltrados = useMemo(() => {
    const textoBusqueda = busqueda.toLowerCase().trim();
    return CATALOG_SERVICES.filter((svc) => {
      const coincideTipo =
        tipoFiltro === "TODOS"
          ? true
          : tipoFiltro === "MAS_DEMANDADOS"
          ? MAS_DEMANDADOS.has(svc.type)
          : svc.type === tipoFiltro;
      const coincideTexto =
        !textoBusqueda ||
        svc.name.toLowerCase().includes(textoBusqueda) ||
        (svc.description?.toLowerCase().includes(textoBusqueda) ?? false);
      return coincideTipo && coincideTexto;
    });
  }, [busqueda, tipoFiltro]);

  // ── Handlers de selección ──────────────────────────────────────────────────

  function toggleServicio(svc: CatalogService) {
    setSeleccionados((prev) => {
      const siguiente = new Map(prev);
      if (siguiente.has(svc.id)) {
        siguiente.delete(svc.id);
      } else {
        siguiente.set(svc.id, {
          catalogo: svc,
          precio: svc.suggestedPrice,
          duracion: svc.duration,
        });
      }
      return siguiente;
    });
  }

  function cambioPrecio(id: string, precio: number) {
    setSeleccionados((prev) => {
      const siguiente = new Map(prev);
      const entrada = siguiente.get(id);
      if (entrada) siguiente.set(id, { ...entrada, precio });
      return siguiente;
    });
  }

  function cambioDuracion(id: string, duracion: number) {
    setSeleccionados((prev) => {
      const siguiente = new Map(prev);
      const entrada = siguiente.get(id);
      if (entrada) siguiente.set(id, { ...entrada, duracion });
      return siguiente;
    });
  }

  // ── Guardar ────────────────────────────────────────────────────────────────

  async function guardar() {
    if (seleccionados.size === 0) return;
    setError(null);

    const entradas = Array.from(seleccionados.values());

    startTransition(async () => {
      try {
        // Enviamos las peticiones en paralelo para mayor velocidad
        const resultados = await Promise.all(
          entradas.map((entrada) =>
            fetch("/api/garage/services", {
              method: "POST",
              headers: { "Content-Type": "application/json" },
              body: JSON.stringify({
                garageId,
                type: entrada.catalogo.type,
                name: entrada.catalogo.name,
                description: entrada.catalogo.description ?? undefined,
                price: entrada.precio,
                duration: entrada.duracion,
                vehicleTypes: TODOS_LOS_VEHICULOS,
              }),
            })
          )
        );

        // Verificar si alguna petición ha fallado
        const fallidas = resultados.filter((r) => !r.ok);
        if (fallidas.length > 0) {
          const primerError = await fallidas[0].json().catch(() => ({})) as { error?: string };
          throw new Error(primerError.error ?? "Error al guardar algunos servicios");
        }

        // Parsear las respuestas para obtener los servicios creados
        const creados = await Promise.all(resultados.map((r) => r.json()));

        // Todo correcto: limpiar estado y notificar al padre con los nuevos servicios
        setSeleccionados(new Map());
        setBusqueda("");
        setTipoFiltro("TODOS");
        onOpenChange(false);
        onSuccess(creados);
      } catch (err: unknown) {
        const mensaje =
          err instanceof Error ? err.message : "Error inesperado al guardar";
        setError(mensaje);
      }
    });
  }

  const totalSeleccionados = seleccionados.size;

  return (
    <Dialog open={open} onOpenChange={onOpenChange}>
      <DialogContent className="flex flex-col w-full max-w-2xl max-h-[90dvh] p-0 gap-0 overflow-hidden rounded-none">
        {/* ── Cabecera ────────────────────────────────────────────────────── */}
        <DialogHeader className="bg-gray-50 border-b border-gray-200 px-5 py-4 shrink-0">
          <div className="flex items-center gap-3">
            <div className="flex h-9 w-9 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <BookOpen className="h-4 w-4 text-gartify-blue" />
            </div>
            <div>
              <DialogTitle className="text-base font-bold text-gartify-blue leading-tight">
                Importar del catálogo
              </DialogTitle>
              <p className="text-xs text-gartify-gray mt-0.5">
                {CATALOG_SERVICES.length} servicios predefinidos — selecciona los que ofrece tu taller
              </p>
            </div>
          </div>
        </DialogHeader>

        {/* ── Barra de filtros ────────────────────────────────────────────── */}
        <div className="shrink-0 px-5 py-3 border-b border-gray-100 bg-white flex flex-col sm:flex-row gap-2">
          {/* Búsqueda por texto */}
          <div className="relative flex-1">
            <Search className="absolute left-2.5 top-1/2 -translate-y-1/2 h-3.5 w-3.5 text-gartify-gray pointer-events-none" />
            <Input
              placeholder="Buscar servicio..."
              value={busqueda}
              onChange={(e) => setBusqueda(e.target.value)}
              className="pl-8 h-8 text-sm"
            />
          </div>

          {/* Filtro por categoría */}
          <Select value={tipoFiltro} onValueChange={setTipoFiltro}>
            <SelectTrigger className="h-8 text-sm w-full sm:w-52">
              <SelectValue placeholder="Todas las categorías" />
              <ChevronDown className="h-3.5 w-3.5 opacity-50 ml-auto shrink-0" />
            </SelectTrigger>
            <SelectContent>
              <SelectItem value="TODOS">Todas las categorías</SelectItem>
              <SelectItem value="MAS_DEMANDADOS">⭐ Más demandados</SelectItem>
              {tiposDisponibles.map((tipo) => (
                <SelectItem key={tipo} value={tipo}>
                  {SERVICE_LABELS[tipo] ?? tipo}
                </SelectItem>
              ))}
            </SelectContent>
          </Select>
        </div>

        {/* ── Lista de servicios (scroll interno) ─────────────────────────── */}
        <div className="flex-1 overflow-y-auto px-5 py-3 space-y-1.5 min-h-0">
          {serviciosFiltrados.length === 0 ? (
            <div className="flex flex-col items-center justify-center py-16 text-gartify-gray">
              <Search className="h-8 w-8 mb-2 opacity-30" />
              <p className="text-sm">Sin resultados para &ldquo;{busqueda}&rdquo;</p>
            </div>
          ) : (
            serviciosFiltrados.map((svc) => {
              const yaExiste = conjuntoExistentes.has(svc.name.toLowerCase().trim());
              return (
                <FilaCatalogo
                  key={svc.id}
                  svc={svc}
                  yaExiste={yaExiste}
                  seleccionado={seleccionados.get(svc.id)}
                  onToggle={toggleServicio}
                  onCambioPrecio={cambioPrecio}
                  onCambioDuracion={cambioDuracion}
                />
              );
            })
          )}
        </div>

        {/* ── Footer fijo ──────────────────────────────────────────────────── */}
        <DialogFooter className="shrink-0 px-5 py-4 border-t border-gray-200 bg-white flex flex-col sm:flex-row items-center gap-3 sm:justify-end">
          {/* Mensaje de error */}
          {error && (
            <p className="text-xs text-red-500 flex-1 text-left">{error}</p>
          )}

          {/* Contador de seleccionados */}
          {!error && totalSeleccionados > 0 && (
            <p className="text-xs text-gartify-gray flex-1 text-left">
              {`${totalSeleccionados} servicio${totalSeleccionados !== 1 ? "s" : ""} seleccionado${totalSeleccionados !== 1 ? "s" : ""}`}
            </p>
          )}
          {!error && totalSeleccionados === 0 && <span className="flex-1" />}

          <div className="flex gap-2 shrink-0">
            <Button
              type="button"
              variant="outline"
              size="sm"
              onClick={() => onOpenChange(false)}
              disabled={isPending}
              className="text-gartify-gray"
            >
              Cancelar
            </Button>
            <Button
              type="button"
              size="sm"
              onClick={guardar}
              disabled={totalSeleccionados === 0 || isPending}
              className="bg-gartify-blue hover:bg-gartify-blue/90 text-white min-w-36"
            >
              {isPending ? (
                <>
                  <Loader2 className="h-3.5 w-3.5 mr-1.5 animate-spin" />
                  Añadiendo...
                </>
              ) : (
                `Añadir ${totalSeleccionados > 0 ? totalSeleccionados : ""} servicio${totalSeleccionados !== 1 ? "s" : ""}`
              )}
            </Button>
          </div>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  );
}
