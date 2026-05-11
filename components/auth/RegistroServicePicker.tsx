"use client";

import { useState } from "react";
import { Check } from "lucide-react";

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

// ---------------------------------------------------------------------------
// Catálogo interno de familias y servicios hijo
// ---------------------------------------------------------------------------

interface ServicioHijo {
  name: string;
  description: string;
  duration: number;
  suggestedPrice: number;
}

interface Familia {
  id: string;
  label: string;
  hijos: ServicioHijo[];
}

const FAMILIAS: Familia[] = [
  {
    id: "ITV",
    label: "ITV",
    hijos: [
      { name: "Pre-ITV Básica",   description: "Chequeo rápido de los puntos críticos de la ITV.", duration: 30, suggestedPrice: 25 },
      { name: "Pre-ITV Completa", description: "Revisión exhaustiva para garantizar el paso de la ITV.", duration: 60, suggestedPrice: 45 },
      { name: "ITV Ordinaria",    description: "Acompañamiento y gestión en estación ITV.", duration: 60, suggestedPrice: 40 },
    ],
  },
  {
    id: "REVISION",
    label: "Revisión",
    hijos: [
      { name: "Revisión básica",    description: "Revisión periódica con comprobación de niveles, frenos y luces.", duration: 60, suggestedPrice: 60 },
      { name: "Revisión 10.000 km", description: "Mantenimiento programado a los 10.000 km.", duration: 60, suggestedPrice: 80 },
      { name: "Revisión 20.000 km", description: "Mantenimiento programado a los 20.000 km.", duration: 90, suggestedPrice: 120 },
      { name: "Revisión 30.000 km", description: "Mantenimiento programado a los 30.000 km.", duration: 90, suggestedPrice: 150 },
      { name: "Revisión 50.000 km", description: "Mantenimiento completo a los 50.000 km.", duration: 120, suggestedPrice: 200 },
    ],
  },
  {
    id: "CAMBIO_ACEITE",
    label: "Cambio de aceite",
    hijos: [
      { name: "Cambio aceite mineral",       description: "Sustitución con aceite mineral adecuado al motor.", duration: 45, suggestedPrice: 40 },
      { name: "Cambio aceite semisintético", description: "Sustitución con aceite semisintético.", duration: 45, suggestedPrice: 55 },
      { name: "Cambio aceite sintético",     description: "Sustitución con aceite 100% sintético.", duration: 45, suggestedPrice: 75 },
      { name: "Cambio aceite + filtros",     description: "Aceite sintético más cambio de filtro de aceite y habitáculo.", duration: 60, suggestedPrice: 90 },
    ],
  },
  {
    id: "FRENOS",
    label: "Frenos",
    hijos: [
      { name: "Revisión de frenos",           description: "Inspección del sistema de frenado.", duration: 30, suggestedPrice: 0 },
      { name: "Cambio de pastillas",          description: "Sustitución de pastillas de freno delanteras o traseras.", duration: 60, suggestedPrice: 80 },
      { name: "Cambio de discos",             description: "Sustitución de discos de freno.", duration: 90, suggestedPrice: 150 },
      { name: "Cambio de discos y pastillas", description: "Sustitución completa del sistema de freno.", duration: 120, suggestedPrice: 220 },
    ],
  },
  {
    id: "NEUMATICOS",
    label: "Neumáticos",
    hijos: [
      { name: "Montaje de neumáticos",  description: "Montaje y equilibrado de neumáticos nuevos.", duration: 45, suggestedPrice: 60 },
      { name: "Equilibrado de ruedas",  description: "Equilibrado de las cuatro ruedas.", duration: 30, suggestedPrice: 30 },
      { name: "Cambio de temporada",    description: "Cambio entre neumáticos de verano e invierno.", duration: 30, suggestedPrice: 40 },
      { name: "Reparación de pinchazo", description: "Reparación de pinchazo en neumático desmontado.", duration: 20, suggestedPrice: 15 },
    ],
  },
  {
    id: "DIAGNOSTICO",
    label: "Diagnóstico",
    hijos: [
      { name: "Diagnóstico electrónico", description: "Lectura de códigos de error con escáner OBD y emisión de informe.", duration: 30, suggestedPrice: 40 },
      { name: "Diagnóstico completo",    description: "Revisión electrónica y mecánica completa del vehículo.", duration: 60, suggestedPrice: 70 },
    ],
  },
  {
    id: "CLIMATIZACION",
    label: "Climatización",
    hijos: [
      { name: "Carga de aire acondicionado", description: "Recarga de gas refrigerante y revisión del sistema.", duration: 30, suggestedPrice: 70 },
      { name: "Revisión climatización",      description: "Revisión completa del sistema de climatización.", duration: 45, suggestedPrice: 50 },
    ],
  },
  {
    id: "ELECTRICIDAD",
    label: "Electricidad",
    hijos: [
      { name: "Revisión eléctrica", description: "Diagnóstico y revisión de sistemas eléctricos del vehículo.", duration: 60, suggestedPrice: 50 },
      { name: "Cambio de batería",  description: "Sustitución de batería con codificación si es necesario.", duration: 30, suggestedPrice: 120 },
    ],
  },
];

// ---------------------------------------------------------------------------
// Iconos SVG — mismos que en app/page.tsx (línea 283)
// ---------------------------------------------------------------------------

const ICONOS_FAMILIA: Record<string, React.ReactNode> = {
  ITV: (
    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-8 w-8 text-gartify-blue">
      <path d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2"/>
      <path d="M9 14l2 2 4-4" stroke="#F58B00" strokeWidth="2"/>
      <path d="M9 10h6"/>
    </svg>
  ),
  REVISION: (
    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-8 w-8 text-gartify-blue">
      <path d="M14.7 6.3a1 1 0 0 0 0 1.4l1.6 1.6a1 1 0 0 0 1.4 0l3.77-3.77a6 6 0 0 1-7.94 7.94l-6.91 6.91a2.12 2.12 0 0 1-3-3l6.91-6.91a6 6 0 0 1 7.94-7.94l-3.76 3.76z"/>
      <path d="M9 15l-3 3" stroke="#F58B00" strokeWidth="2"/>
    </svg>
  ),
  CAMBIO_ACEITE: (
    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-8 w-8 text-gartify-blue">
      <path d="M4 19h16"/>
      <path d="M4 15V9c0-1.1.9-2 2-2h4c1.1 0 2 .9 2 2v6"/>
      <path d="M12 9h4l2-4" stroke="#F58B00" strokeWidth="2"/>
      <path d="M18 14c0 1.1-.9 2-2 2s-2-.9-2-2 2-4 2-4 2 2.9 2 4z" stroke="#F58B00" fill="#F58B00"/>
      <path d="M5 11h6"/>
    </svg>
  ),
  FRENOS: (
    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-8 w-8 text-gartify-blue">
      <circle cx="12" cy="12" r="9"/>
      <circle cx="12" cy="12" r="3"/>
      <path d="M18.36 6.64A9 9 0 0 0 12 3v4a5 5 0 0 1 3.54 1.46l2.82-1.82z" stroke="#F58B00" strokeWidth="2" fill="#F58B00"/>
      <circle cx="12" cy="6" r="0.5" fill="currentColor"/>
      <circle cx="12" cy="18" r="0.5" fill="currentColor"/>
      <circle cx="6" cy="12" r="0.5" fill="currentColor"/>
      <circle cx="18" cy="12" r="0.5" fill="currentColor"/>
    </svg>
  ),
  NEUMATICOS: (
    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-8 w-8 text-gartify-blue">
      <rect x="5" y="2" width="14" height="20" rx="4"/>
      <path d="M5 6h14M5 12h14M5 18h14"/>
      <path d="M9 2v20M15 2v20" stroke="#F58B00" strokeWidth="2"/>
    </svg>
  ),
  DIAGNOSTICO: (
    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-8 w-8 text-gartify-blue">
      <path d="M12 6V4m0 2h5a2 2 0 012 2v8a2 2 0 01-2 2h-5v2m0-2H7a2 2 0 01-2-2V8a2 2 0 012-2h5z"/>
      <path d="M5 10H3v4h2M19 10h2v4h-2"/>
      <circle cx="11" cy="13" r="3" stroke="#F58B00" strokeWidth="2"/>
      <path d="M13.5 15.5L16 18" stroke="#F58B00" strokeWidth="2"/>
    </svg>
  ),
  CLIMATIZACION: (
    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-8 w-8 text-gartify-blue">
      <path d="M12 2v20M2 12h20"/>
      <path d="M4.93 4.93l14.14 14.14M19.07 4.93L4.93 19.07"/>
      <path d="M12 6a3 3 0 00-3-3M12 18a3 3 0 003 3M6 12a3 3 0 00-3 3M18 12a3 3 0 003-3" stroke="#F58B00" strokeWidth="2"/>
    </svg>
  ),
  ELECTRICIDAD: (
    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-8 w-8 text-gartify-blue">
      <rect x="3" y="7" width="18" height="13" rx="2"/>
      <path d="M6 7V5a1 1 0 011-1h2M18 7V5a1 1 0 00-1-1h-2"/>
      <path d="M13 10l-3 4h4l-3 4" stroke="#F58B00" strokeWidth="2" fill="#F58B00"/>
      <path d="M6 4h4M14 4h4"/>
    </svg>
  ),
};

// ---------------------------------------------------------------------------
// Componente principal
// ---------------------------------------------------------------------------

export function RegistroServicePicker({
  selected,
  onChange,
  maxServices = 5,
}: RegistroServicePickerProps) {
  // Familias activas (en el orden en que se seleccionaron)
  const [familiasActivas, setFamiliasActivas] = useState<string[]>([]);

  const limiteAlcanzado = selected.length >= maxServices;

  // -------------------------------------------------------------------
  // Handlers de familias
  // -------------------------------------------------------------------

  function toggleFamilia(familiaId: string) {
    if (familiasActivas.includes(familiaId)) {
      // Desactivar familia: eliminar todos sus hijos de selected
      const hijos = FAMILIAS.find((f) => f.id === familiaId)?.hijos ?? [];
      const nombresHijos = new Set(hijos.map((h) => h.name));
      onChange(selected.filter((s) => !nombresHijos.has(s.name)));
      setFamiliasActivas((prev) => prev.filter((id) => id !== familiaId));
    } else {
      setFamiliasActivas((prev) => [...prev, familiaId]);
    }
  }

  // -------------------------------------------------------------------
  // Handlers de servicios hijo
  // -------------------------------------------------------------------

  function toggleHijo(familiaId: string, hijo: ServicioHijo) {
    const yaSeleccionado = selected.some((s) => s.name === hijo.name);

    if (yaSeleccionado) {
      // Desactivar: eliminar del array
      onChange(selected.filter((s) => s.name !== hijo.name));
    } else {
      // Activar: solo si no se alcanzó el límite
      if (limiteAlcanzado) return;
      const nuevo: ServicioSeleccionado = {
        type:        familiaId,
        name:        hijo.name,
        description: hijo.description,
        price:       hijo.suggestedPrice,
        duration:    hijo.duration,
      };
      onChange([...selected, nuevo]);
    }
  }

  function actualizarPrecio(nombreHijo: string, valor: string) {
    const parsed = parseFloat(valor);
    // Permitimos cadena vacía temporalmente — solo actualizamos si es número válido
    if (isNaN(parsed) || parsed < 0) return;
    onChange(
      selected.map((s) =>
        s.name === nombreHijo ? { ...s, price: parsed } : s,
      ),
    );
  }

  // -------------------------------------------------------------------
  // Render
  // -------------------------------------------------------------------

  return (
    <div className="space-y-4">
      {/* ----------------------------------------------------------------
          FASE 1 — Grid de familias
      ---------------------------------------------------------------- */}
      <div className="grid grid-cols-2 sm:grid-cols-4 gap-2">
        {FAMILIAS.map((familia) => {
          const activa = familiasActivas.includes(familia.id);
          return (
            <button
              key={familia.id}
              type="button"
              onClick={() => toggleFamilia(familia.id)}
              className={[
                "flex flex-col items-center gap-2 p-3 rounded-lg border transition-all text-center",
                activa
                  ? "border-2 border-gartify-orange bg-orange-50"
                  : "border border-gray-200 bg-white hover:border-gray-300",
              ].join(" ")}
              aria-pressed={activa}
            >
              {/* Círculo icono */}
              <span
                className={[
                  "flex items-center justify-center w-14 h-14 rounded-full transition-colors",
                  activa ? "bg-orange-100" : "bg-blue-50",
                ].join(" ")}
              >
                {ICONOS_FAMILIA[familia.id]}
              </span>
              <span className="text-xs font-semibold text-gartify-dark leading-tight">
                {familia.label}
              </span>
            </button>
          );
        })}
      </div>

      {/* ----------------------------------------------------------------
          FASE 2 — Accordion de familias seleccionadas
      ---------------------------------------------------------------- */}
      {familiasActivas.length > 0 && (
        <div className="space-y-4">
          {/* Contador */}
          <p className="text-xs text-gartify-gray">
            <span
              className={[
                "font-bold",
                limiteAlcanzado ? "text-gartify-orange" : "text-gartify-blue",
              ].join(" ")}
            >
              {selected.length}/{maxServices}
            </span>{" "}
            servicios seleccionados
          </p>

          {familiasActivas.map((familiaId) => {
            const familia = FAMILIAS.find((f) => f.id === familiaId);
            if (!familia) return null;

            return (
              <div key={familiaId}>
                {/* Cabecera de sección */}
                <div className="flex items-center gap-2 border-b border-gray-100 pb-1 mb-2">
                  <span className="flex items-center justify-center w-5 h-5 shrink-0">
                    {ICONOS_FAMILIA[familiaId] && (
                      // Versión pequeña del icono: reemplazamos las clases de tamaño
                      <span className="[&_svg]:h-4 [&_svg]:w-4">
                        {ICONOS_FAMILIA[familiaId]}
                      </span>
                    )}
                  </span>
                  <span className="text-xs font-bold text-gartify-blue uppercase tracking-wide">
                    {familia.label}
                  </span>
                </div>

                {/* Lista de hijos */}
                <div className="space-y-1.5">
                  {familia.hijos.map((hijo) => {
                    const seleccionado = selected.some((s) => s.name === hijo.name);
                    // Deshabilitar si se alcanzó el límite y este hijo no está seleccionado
                    const deshabilitado = limiteAlcanzado && !seleccionado;

                    return (
                      <div
                        key={hijo.name}
                        className={[
                          "flex items-center gap-3 py-1.5 px-2 rounded transition-colors",
                          deshabilitado
                            ? "opacity-40 pointer-events-none"
                            : "hover:bg-gray-50",
                        ].join(" ")}
                      >
                        {/* Checkbox visual */}
                        <button
                          type="button"
                          onClick={() => toggleHijo(familiaId, hijo)}
                          className={[
                            "shrink-0 flex items-center justify-center w-5 h-5 border rounded transition-colors",
                            seleccionado
                              ? "bg-gartify-orange border-gartify-orange"
                              : "bg-white border-gray-300 hover:border-gartify-blue",
                          ].join(" ")}
                          aria-checked={seleccionado}
                          role="checkbox"
                          aria-label={`Seleccionar ${hijo.name}`}
                        >
                          {seleccionado && (
                            <Check className="h-3 w-3 text-white" strokeWidth={3} />
                          )}
                        </button>

                        {/* Nombre del servicio */}
                        <span
                          className={[
                            "flex-1 text-sm leading-snug",
                            seleccionado
                              ? "text-gartify-dark font-medium"
                              : "text-gartify-gray",
                          ].join(" ")}
                        >
                          {hijo.name}
                        </span>

                        {/* Campo de precio — solo visible si está seleccionado */}
                        {seleccionado ? (
                          <div className="flex items-center gap-1 shrink-0">
                            <input
                              type="number"
                              min="0"
                              step="1"
                              defaultValue={
                                selected.find((s) => s.name === hijo.name)?.price ??
                                hijo.suggestedPrice
                              }
                              onChange={(e) => actualizarPrecio(hijo.name, e.target.value)}
                              className="w-20 text-xs border border-gray-200 rounded px-2 py-1 text-right focus:outline-none focus:border-gartify-blue"
                              aria-label={`Precio de ${hijo.name}`}
                            />
                            <span className="text-xs text-gartify-gray">€</span>
                          </div>
                        ) : (
                          /* Precio sugerido como referencia visual */
                          <span className="text-xs text-gartify-gray shrink-0">
                            {hijo.suggestedPrice === 0 ? "Gratis" : `${hijo.suggestedPrice} €`}
                          </span>
                        )}
                      </div>
                    );
                  })}
                </div>
              </div>
            );
          })}
        </div>
      )}
    </div>
  );
}
