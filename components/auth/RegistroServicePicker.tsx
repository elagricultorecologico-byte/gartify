"use client";

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
  {
    id: "CHAPA_PINTURA",
    label: "Chapa y Pintura",
    hijos: [
      { name: "Reparación de abolladuras", description: "Reparación de golpes y abolladuras sin necesidad de pintura.", duration: 60, suggestedPrice: 80 },
      { name: "Pintura parcial",           description: "Pintado de una o varias piezas del vehículo.", duration: 180, suggestedPrice: 200 },
      { name: "Pintura completa",          description: "Pintado completo del vehículo en el color deseado.", duration: 480, suggestedPrice: 800 },
    ],
  },
  {
    id: "LUNAS",
    label: "Lunas",
    hijos: [
      { name: "Reparación de luna",          description: "Reparación de impacto o grieta en el parabrisas.", duration: 30, suggestedPrice: 60 },
      { name: "Sustitución luna delantera",  description: "Cambio completo del parabrisas delantero.", duration: 90, suggestedPrice: 250 },
      { name: "Sustitución luna trasera",    description: "Cambio de la luna trasera del vehículo.", duration: 90, suggestedPrice: 200 },
      { name: "Sustitución luna lateral",    description: "Cambio de ventanilla lateral.", duration: 60, suggestedPrice: 150 },
    ],
  },
  {
    id: "ACCESORIOS",
    label: "Accesorios",
    hijos: [
      { name: "Instalación multimedia",     description: "Montaje de radio, pantalla o sistema de navegación.", duration: 90, suggestedPrice: 80 },
      { name: "Montaje de barras / cofre",  description: "Instalación de barras portaequipajes o cofre de techo.", duration: 60, suggestedPrice: 60 },
      { name: "Instalación de enganche",    description: "Montaje de enganche de remolque homologado.", duration: 120, suggestedPrice: 180 },
      { name: "Láminas solares",            description: "Aplicación de láminas de protección solar en lunas.", duration: 90, suggestedPrice: 120 },
    ],
  },
  {
    id: "LAVADO",
    label: "Lavados",
    hijos: [
      { name: "Lavado exterior",            description: "Lavado completo de la carrocería a mano.", duration: 30, suggestedPrice: 15 },
      { name: "Lavado interior y exterior", description: "Limpieza completa interior y exterior del vehículo.", duration: 60, suggestedPrice: 35 },
      { name: "Lavado y encerado",          description: "Lavado exterior más aplicación de cera protectora.", duration: 60, suggestedPrice: 45 },
      { name: "Desinfección y ozono",       description: "Limpieza profunda con tratamiento de ozono para eliminar bacterias y malos olores.", duration: 60, suggestedPrice: 60 },
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
  CHAPA_PINTURA: (
    /* Pistola de pintura con spray */
    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-8 w-8 text-gartify-blue">
      <rect x="8" y="9" width="7" height="11" rx="2"/>
      <rect x="10" y="6" width="3" height="3" rx="1"/>
      <circle cx="11.5" cy="5" r="0.8" fill="currentColor"/>
      <path d="M3 6l1.5 1M3 9.5l1.5-1M3 7.5h1.5" stroke="#F58B00" strokeWidth="2" strokeLinecap="round"/>
      <path d="M11 13h3M11 16h3" strokeWidth="1.2"/>
    </svg>
  ),
  LUNAS: (
    /* Parabrisas con grieta reparada */
    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-8 w-8 text-gartify-blue">
      <path d="M4 18h16l-2-11H6L4 18z"/>
      <path d="M6 18l-1 2M18 18l1 2"/>
      <path d="M11 10l1 2-1 2" stroke="#F58B00" strokeWidth="2" strokeLinejoin="round"/>
      <circle cx="12" cy="10" r="1.2" stroke="#F58B00" strokeWidth="1.5"/>
    </svg>
  ),
  ACCESORIOS: (
    /* Llave + estrella (montaje de extras) */
    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-8 w-8 text-gartify-blue">
      <path d="M14.7 6.3a1 1 0 0 0 0 1.4l1.6 1.6a1 1 0 0 0 1.4 0l3.77-3.77a6 6 0 0 1-7.94 7.94l-6.91 6.91a2.12 2.12 0 0 1-3-3l6.91-6.91a6 6 0 0 1 7.94-7.94l-3.76 3.76z"/>
      <path d="M5 2l.5 1.5L7 4l-1.5.5L5 6l-.5-1.5L3 4l1.5-.5L5 2z" stroke="#F58B00" strokeWidth="1.5" fill="#F58B00" fillOpacity="0.3"/>
    </svg>
  ),
  LAVADO: (
    /* Gota de agua grande con burbujas */
    <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-8 w-8 text-gartify-blue">
      <path d="M12 2C12 2 5 10 5 15a7 7 0 0 0 14 0c0-5-7-13-7-13z"/>
      <circle cx="9.5" cy="17" r="1" stroke="#F58B00" fill="#F58B00" fillOpacity="0.4"/>
      <circle cx="14" cy="14.5" r="1.2" stroke="#F58B00" strokeWidth="1.5"/>
      <path d="M12 18v1" stroke="#F58B00" strokeWidth="2" strokeLinecap="round"/>
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
  const limiteAlcanzado = selected.length >= maxServices;

  // Una familia está activa si alguno de sus hijos está en selected
  function familiaActiva(familiaId: string) {
    return selected.some((s) => s.type === familiaId);
  }

  function toggleFamilia(familiaId: string) {
    if (familiaActiva(familiaId)) {
      // Desactivar: eliminar todos los servicios de esta familia
      onChange(selected.filter((s) => s.type !== familiaId));
    } else {
      // Activar: auto-seleccionar el primer hijo de la familia
      if (limiteAlcanzado) return;
      const familia = FAMILIAS.find((f) => f.id === familiaId);
      const hijo = familia?.hijos[0];
      if (!hijo) return;
      onChange([
        ...selected,
        {
          type:        familiaId,
          name:        hijo.name,
          description: hijo.description,
          price:       hijo.suggestedPrice,
          duration:    hijo.duration,
        },
      ]);
    }
  }

  return (
    <div className="space-y-3">
      {/* Grid de familias */}
      <div className="grid grid-cols-2 sm:grid-cols-4 gap-2">
        {FAMILIAS.map((familia) => {
          const activa = familiaActiva(familia.id);
          const deshabilitada = limiteAlcanzado && !activa;
          return (
            <button
              key={familia.id}
              type="button"
              onClick={() => toggleFamilia(familia.id)}
              disabled={deshabilitada}
              className={[
                "flex flex-col items-center gap-2 p-3 rounded-lg border transition-all text-center",
                activa
                  ? "border-2 border-gartify-orange bg-orange-50"
                  : deshabilitada
                  ? "border border-gray-200 bg-gray-50 opacity-40 cursor-not-allowed"
                  : "border border-gray-200 bg-white hover:border-gray-300",
              ].join(" ")}
              aria-pressed={activa}
            >
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
              {activa && (
                <span className="flex items-center justify-center w-4 h-4 rounded-full bg-gartify-orange">
                  <Check className="h-2.5 w-2.5 text-white" strokeWidth={3} />
                </span>
              )}
            </button>
          );
        })}
      </div>

      {/* Contador de seleccionados */}
      {selected.length > 0 && (
        <p className="text-xs text-gartify-gray">
          <span className={`font-bold ${limiteAlcanzado ? "text-gartify-orange" : "text-gartify-blue"}`}>
            {selected.length}/{maxServices}
          </span>{" "}
          servicios seleccionados
        </p>
      )}
    </div>
  );
}
