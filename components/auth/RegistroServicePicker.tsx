"use client";

import { useState, useMemo } from "react";
import { Plus, X, Search, ChevronDown } from "lucide-react";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Dialog, DialogContent, DialogHeader, DialogTitle } from "@/components/ui/dialog";
import { CATALOG_SERVICES, getCatalogTypes } from "@/lib/service-catalog";
import { formatPrice } from "@/lib/utils";

/** Servicio seleccionado durante el registro, con precio y duración editables */
export interface ServicioSeleccionado {
  type: string;
  name: string;
  description: string;
  price: number;
  duration: number;
}

interface RegistroServicePickerProps {
  selected: ServicioSeleccionado[];
  onChange: (services: ServicioSeleccionado[]) => void;
  maxServices?: number;
}

/** Etiquetas legibles para cada ServiceType del catálogo */
const TYPE_LABELS: Record<string, string> = {
  ITV:          "ITV",
  PRE_ITV:      "Pre-ITV",
  REVISION:     "Revisión",
  CAMBIO_ACEITE:"Cambio aceite",
  FRENOS:       "Frenos",
  NEUMATICOS:   "Neumáticos",
  DIAGNOSTICO:  "Diagnóstico",
  CLIMATIZACION:"Climatización",
  MOTOR:        "Motor",
  CARROCERIA:   "Carrocería",
  ELECTRICIDAD: "Electricidad",
  SUSPENSION:   "Suspensión",
  FILTROS:      "Filtros",
};

export function RegistroServicePicker({
  selected,
  onChange,
  maxServices = 3,
}: RegistroServicePickerProps) {
  const [dialogAbierto, setDialogAbierto] = useState(false);
  const [busqueda, setBusqueda] = useState("");
  const [filtroTipo, setFiltroTipo] = useState<string>("TODOS");
  const [tipoDropdownAbierto, setTipoDropdownAbierto] = useState(false);

  const tipos = useMemo(() => getCatalogTypes(), []);

  /** Servicios filtrados según búsqueda y tipo seleccionado */
  const serviciosFiltrados = useMemo(() => {
    const termino = busqueda.toLowerCase().trim();
    return CATALOG_SERVICES.filter((svc) => {
      const coincideTipo = filtroTipo === "TODOS" || svc.type === filtroTipo;
      const coincideBusqueda =
        !termino ||
        svc.name.toLowerCase().includes(termino) ||
        (svc.description ?? "").toLowerCase().includes(termino);
      return coincideTipo && coincideBusqueda;
    });
  }, [busqueda, filtroTipo]);

  /** Añade un servicio del catálogo a los seleccionados */
  function agregarServicio(catalogId: string) {
    if (selected.length >= maxServices) return;
    const catalogo = CATALOG_SERVICES.find((s) => s.id === catalogId);
    if (!catalogo) return;
    // Evitar duplicados por id de catálogo (usando el nombre como proxy)
    const yaTiene = selected.some((s) => s.name === catalogo.name);
    if (yaTiene) return;

    const nuevo: ServicioSeleccionado = {
      type:        catalogo.type,
      name:        catalogo.name,
      description: catalogo.description ?? "",
      price:       catalogo.suggestedPrice,
      duration:    catalogo.duration,
    };
    onChange([...selected, nuevo]);

    // Cerrar dialog si se alcanzó el límite
    if (selected.length + 1 >= maxServices) {
      setDialogAbierto(false);
    }
  }

  /** Elimina un servicio de los seleccionados por índice */
  function eliminarServicio(indice: number) {
    onChange(selected.filter((_, i) => i !== indice));
  }

  /** Actualiza precio o duración de un servicio seleccionado */
  function actualizarCampo(
    indice: number,
    campo: "price" | "duration",
    valor: string,
  ) {
    const parsed = parseFloat(valor);
    if (isNaN(parsed) || parsed < 0) return;
    const actualizados = selected.map((s, i) =>
      i === indice
        ? { ...s, [campo]: campo === "duration" ? Math.round(parsed) : parsed }
        : s,
    );
    onChange(actualizados);
  }

  const limiteAlcanzado = selected.length >= maxServices;

  return (
    <div className="space-y-3">
      {/* Cards de servicios seleccionados */}
      {selected.length > 0 && (
        <div className="space-y-2">
          {selected.map((svc, idx) => (
            <div
              key={idx}
              className="border border-gartify-blue/20 bg-blue-50/50 p-3 relative"
            >
              <button
                type="button"
                onClick={() => eliminarServicio(idx)}
                className="absolute top-2 right-2 text-gartify-gray hover:text-red-500 transition-colors"
                aria-label={`Eliminar ${svc.name}`}
              >
                <X className="h-4 w-4" />
              </button>

              {/* Nombre y tipo */}
              <p className="text-xs font-semibold text-gartify-blue pr-6 leading-snug">
                {svc.name}
              </p>
              <p className="text-[11px] text-gartify-gray mt-0.5">
                {TYPE_LABELS[svc.type] ?? svc.type}
              </p>

              {/* Precio y duración editables */}
              <div className="grid grid-cols-2 gap-2 mt-2">
                <div className="space-y-1">
                  <Label className="text-[11px] font-semibold text-gartify-blue">
                    Precio (€)
                  </Label>
                  <Input
                    type="number"
                    min="0"
                    step="1"
                    value={svc.price}
                    onChange={(e) => actualizarCampo(idx, "price", e.target.value)}
                    className="h-8 text-xs"
                  />
                </div>
                <div className="space-y-1">
                  <Label className="text-[11px] font-semibold text-gartify-blue">
                    Duración (min)
                  </Label>
                  <Input
                    type="number"
                    min="1"
                    step="5"
                    value={svc.duration}
                    onChange={(e) => actualizarCampo(idx, "duration", e.target.value)}
                    className="h-8 text-xs"
                  />
                </div>
              </div>
            </div>
          ))}
        </div>
      )}

      {/* Botón para abrir el catálogo */}
      <Button
        type="button"
        variant="outline"
        onClick={() => setDialogAbierto(true)}
        disabled={limiteAlcanzado}
        className="w-full border-dashed border-gartify-blue/40 text-gartify-blue hover:bg-blue-50 hover:border-gartify-blue text-xs font-semibold h-9 gap-2"
      >
        <Plus className="h-4 w-4" />
        {limiteAlcanzado
          ? `Límite de ${maxServices} servicios alcanzado`
          : `Añadir servicio del catálogo (${selected.length}/${maxServices})`}
      </Button>

      {/* Dialog del catálogo */}
      <Dialog open={dialogAbierto} onOpenChange={setDialogAbierto}>
        <DialogContent className="max-w-lg max-h-[80vh] flex flex-col p-0 gap-0">
          <DialogHeader className="px-5 pt-5 pb-4 border-b border-gray-100 shrink-0">
            <DialogTitle className="text-sm font-bold text-gartify-blue">
              Seleccionar servicio del catálogo
            </DialogTitle>
            <p className="text-xs text-gartify-gray mt-0.5">
              {selected.length}/{maxServices} servicios seleccionados
            </p>
          </DialogHeader>

          {/* Controles de búsqueda y filtro */}
          <div className="px-5 py-3 space-y-2 border-b border-gray-100 shrink-0">
            {/* Buscador */}
            <div className="relative">
              <Search className="absolute left-2.5 top-1/2 -translate-y-1/2 h-3.5 w-3.5 text-gartify-gray" />
              <Input
                placeholder="Buscar servicio..."
                value={busqueda}
                onChange={(e) => setBusqueda(e.target.value)}
                className="pl-8 h-8 text-xs"
              />
            </div>

            {/* Filtro por tipo — dropdown accesible */}
            <div className="relative">
              <button
                type="button"
                onClick={() => setTipoDropdownAbierto((v) => !v)}
                className="w-full flex items-center justify-between h-8 px-3 border border-gray-200 bg-white text-xs text-gartify-dark hover:border-gartify-blue/40 transition-colors"
                aria-haspopup="listbox"
                aria-expanded={tipoDropdownAbierto}
              >
                <span>
                  {filtroTipo === "TODOS"
                    ? "Todos los tipos"
                    : (TYPE_LABELS[filtroTipo] ?? filtroTipo)}
                </span>
                <ChevronDown className="h-3.5 w-3.5 text-gartify-gray" />
              </button>

              {tipoDropdownAbierto && (
                <div
                  role="listbox"
                  className="absolute z-50 top-full left-0 right-0 mt-1 bg-white border border-gray-200 shadow-md max-h-48 overflow-y-auto"
                >
                  {["TODOS", ...tipos].map((tipo) => (
                    <button
                      key={tipo}
                      type="button"
                      role="option"
                      aria-selected={filtroTipo === tipo}
                      onClick={() => {
                        setFiltroTipo(tipo);
                        setTipoDropdownAbierto(false);
                      }}
                      className={`w-full text-left px-3 py-2 text-xs hover:bg-blue-50 transition-colors ${
                        filtroTipo === tipo
                          ? "bg-blue-50 text-gartify-blue font-semibold"
                          : "text-gartify-dark"
                      }`}
                    >
                      {tipo === "TODOS" ? "Todos los tipos" : (TYPE_LABELS[tipo] ?? tipo)}
                    </button>
                  ))}
                </div>
              )}
            </div>
          </div>

          {/* Lista de servicios del catálogo */}
          <div className="flex-1 overflow-y-auto px-5 py-3 space-y-1.5">
            {serviciosFiltrados.length === 0 ? (
              <p className="text-xs text-gartify-gray text-center py-6">
                No se encontraron servicios para tu búsqueda.
              </p>
            ) : (
              serviciosFiltrados.map((svc) => {
                const yaSeleccionado = selected.some((s) => s.name === svc.name);
                const deshabilitado = limiteAlcanzado && !yaSeleccionado;

                return (
                  <button
                    key={svc.id}
                    type="button"
                    onClick={() => !yaSeleccionado && !deshabilitado && agregarServicio(svc.id)}
                    disabled={yaSeleccionado || deshabilitado}
                    className={`w-full text-left p-3 border transition-all ${
                      yaSeleccionado
                        ? "border-gartify-blue/30 bg-blue-50 opacity-60 cursor-default"
                        : deshabilitado
                        ? "border-gray-100 bg-gray-50 opacity-40 cursor-not-allowed"
                        : "border-gray-200 hover:border-gartify-blue/40 hover:bg-blue-50/30 cursor-pointer"
                    }`}
                  >
                    <div className="flex items-start justify-between gap-2">
                      <div className="min-w-0">
                        <p className="text-xs font-semibold text-gartify-blue leading-snug truncate">
                          {svc.name}
                        </p>
                        {svc.description && (
                          <p className="text-[11px] text-gartify-gray mt-0.5 leading-relaxed line-clamp-2">
                            {svc.description}
                          </p>
                        )}
                      </div>
                      <div className="shrink-0 text-right">
                        <p className="text-xs font-bold text-gartify-orange">
                          {svc.suggestedPrice === 0 ? "Gratis" : formatPrice(svc.suggestedPrice)}
                        </p>
                        <p className="text-[11px] text-gartify-gray">{svc.duration} min</p>
                      </div>
                    </div>
                    {yaSeleccionado && (
                      <p className="text-[11px] text-gartify-blue font-semibold mt-1">
                        Ya añadido
                      </p>
                    )}
                  </button>
                );
              })
            )}
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
}
