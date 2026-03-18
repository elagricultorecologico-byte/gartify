import {
  FileSearch, CheckCircle, Cog, Droplets, Disc3, RotateCcw,
  Gauge, Wind, Zap, Car, Flame, Settings, Filter, SprayCan,
  Lightbulb, Battery, Thermometer, AlertTriangle,
  type LucideIcon,
} from "lucide-react";

// ─── Tipos ─────────────────────────────────────────────────────────────────────

export interface ServiceMeta {
  type: string;
  label: string;
  icon: LucideIcon;
  color: string;
  bg: string;
  border: string;
  desc: string;
  examples: string[];
}

// ─── Catálogo completo de servicios (fuente única de verdad) ──────────────────

export const ALL_SERVICES: ServiceMeta[] = [
  {
    type: "ITV",
    icon: FileSearch,
    color: "text-blue-600",
    bg: "bg-blue-50",
    border: "border-blue-100",
    label: "ITV",
    desc: "Inspección Técnica de Vehículos obligatoria. Verifica que el vehículo cumple los requisitos legales de seguridad y emisiones.",
    examples: ["ITV ordinaria", "ITV con reformas", "Pre-ITV completa"],
  },
  {
    type: "PRE_ITV",
    icon: CheckCircle,
    color: "text-cyan-600",
    bg: "bg-cyan-50",
    border: "border-cyan-100",
    label: "Pre-ITV",
    desc: "Revisión previa a la ITV para detectar y corregir fallos antes de presentar el vehículo a la inspección oficial.",
    examples: ["Revisión de luces", "Comprobación de frenos", "Diagnóstico OBD"],
  },
  {
    type: "REVISION",
    icon: Cog,
    color: "text-gartify-hero",
    bg: "bg-indigo-50",
    border: "border-indigo-100",
    label: "Revisión",
    desc: "Revisión periódica completa del vehículo según el manual del fabricante. Prolonga la vida útil y previene averías.",
    examples: ["Revisión 10.000 km", "Revisión 30.000 km", "Revisión anual"],
  },
  {
    type: "CAMBIO_ACEITE",
    icon: Droplets,
    color: "text-yellow-600",
    bg: "bg-yellow-50",
    border: "border-yellow-100",
    label: "Cambio de aceite",
    desc: "Sustitución del aceite del motor y filtro de aceite. Fundamental para el correcto funcionamiento y longevidad del motor.",
    examples: ["Aceite sintético 5W30", "Aceite semisintético", "Pack aceite + filtros"],
  },
  {
    type: "FRENOS",
    icon: Disc3,
    color: "text-red-600",
    bg: "bg-red-50",
    border: "border-red-100",
    label: "Frenos",
    desc: "Revisión, mantenimiento y sustitución del sistema de frenado. Esencial para la seguridad del conductor y ocupantes.",
    examples: ["Pastillas de freno", "Discos de freno", "Líquido de frenos"],
  },
  {
    type: "NEUMATICOS",
    icon: RotateCcw,
    color: "text-gray-700",
    bg: "bg-gray-50",
    border: "border-gray-200",
    label: "Neumáticos",
    desc: "Venta, montaje, equilibrado y alineación de neumáticos. Cambio de ruedas de verano a invierno y viceversa.",
    examples: ["Montaje y equilibrado", "Alineación de dirección", "Cambio de temporada"],
  },
  {
    type: "DIAGNOSTICO",
    icon: Gauge,
    color: "text-gartify-orange",
    bg: "bg-orange-50",
    border: "border-orange-100",
    label: "Diagnóstico",
    desc: "Lectura de códigos de error con escáner OBD, diagnóstico de averías y emisión de informe técnico del estado del vehículo.",
    examples: ["Diagnóstico OBD2", "Lectura de errores", "Informe técnico completo"],
  },
  {
    type: "CLIMATIZACION",
    icon: Wind,
    color: "text-sky-600",
    bg: "bg-sky-50",
    border: "border-sky-100",
    label: "Climatización",
    desc: "Mantenimiento, recarga y reparación del sistema de aire acondicionado y climatización del habitáculo.",
    examples: ["Recarga de gas R134a", "Recarga R1234yf", "Limpieza evaporador"],
  },
  {
    type: "ELECTRICIDAD",
    icon: Zap,
    color: "text-yellow-500",
    bg: "bg-yellow-50",
    border: "border-yellow-100",
    label: "Electricidad",
    desc: "Diagnóstico y reparación del sistema eléctrico del vehículo. Baterías, alternadores, arranque y sistemas auxiliares.",
    examples: ["Cambio de batería", "Revisión alternador", "Instalación accesorios"],
  },
  {
    type: "SUSPENSION",
    icon: Car,
    color: "text-violet-600",
    bg: "bg-violet-50",
    border: "border-violet-100",
    label: "Suspensión",
    desc: "Revisión y reparación de los elementos de suspensión y dirección. Amortiguadores, rótulas, silentblocks y geometría.",
    examples: ["Amortiguadores", "Rótulas y silentblocks", "Geometría de dirección"],
  },
  {
    type: "ESCAPE",
    icon: Flame,
    color: "text-orange-600",
    bg: "bg-orange-50",
    border: "border-orange-100",
    label: "Escape y emisiones",
    desc: "Revisión, reparación y sustitución de elementos del sistema de escape. Control de emisiones y catalizador.",
    examples: ["Tubo de escape", "Catalizador", "Filtro de partículas DPF"],
  },
  {
    type: "MOTOR",
    icon: Settings,
    color: "text-zinc-700",
    bg: "bg-zinc-50",
    border: "border-zinc-200",
    label: "Motor",
    desc: "Revisión, reparación y puesta a punto del motor. Distribución, correas, juntas, culata y componentes internos.",
    examples: ["Cambio correa distribución", "Junta de culata", "Puesta a punto"],
  },
  {
    type: "FILTROS",
    icon: Filter,
    color: "text-teal-600",
    bg: "bg-teal-50",
    border: "border-teal-100",
    label: "Filtros",
    desc: "Sustitución de filtros del vehículo: aire, habitáculo, gasoil y aceite. Mantenimiento básico y económico.",
    examples: ["Filtro de aire", "Filtro de habitáculo", "Filtro de gasoil"],
  },
  {
    type: "CARROCERIA",
    icon: SprayCan,
    color: "text-pink-600",
    bg: "bg-pink-50",
    border: "border-pink-100",
    label: "Carrocería y pintura",
    desc: "Reparación de abolladuras, arañazos y daños en la carrocería. Pintura parcial y total, preparación y acabados.",
    examples: ["Reparación de golpes", "Pintura parcial", "Preparación y barniz"],
  },
  {
    type: "LUCES",
    icon: Lightbulb,
    color: "text-amber-500",
    bg: "bg-amber-50",
    border: "border-amber-100",
    label: "Luces e iluminación",
    desc: "Revisión, regulación y sustitución de sistemas de iluminación. Faros, pilotos, luces LED y xenón.",
    examples: ["Cambio de bombillas", "Faros LED", "Regulación de faros"],
  },
  {
    type: "BATERIA_ELECTRICO",
    icon: Battery,
    color: "text-green-600",
    bg: "bg-green-50",
    border: "border-green-100",
    label: "Vehículo eléctrico e híbrido",
    desc: "Mantenimiento especializado para vehículos eléctricos e híbridos. Diagnóstico de batería de alto voltaje y sistemas específicos.",
    examples: ["Diagnóstico batería EV", "Mantenimiento híbrido", "Actualización software"],
  },
  {
    type: "REFRIGERACION",
    icon: Thermometer,
    color: "text-blue-500",
    bg: "bg-blue-50",
    border: "border-blue-100",
    label: "Refrigeración",
    desc: "Revisión y reparación del sistema de refrigeración del motor. Radiador, termostato, bomba de agua y líquido refrigerante.",
    examples: ["Cambio líquido refrigerante", "Radiador", "Bomba de agua"],
  },
  {
    type: "REVISION_PRECOMPRA",
    icon: AlertTriangle,
    color: "text-gartify-mid",
    bg: "bg-sky-50",
    border: "border-sky-100",
    label: "Revisión pre-compra",
    desc: "Inspección completa de un vehículo de segunda mano antes de su adquisición. Informe detallado del estado real del coche.",
    examples: ["Informe pre-compra", "Historial de averías", "Valoración del estado"],
  },
];

// ─── Subconjuntos derivados ───────────────────────────────────────────────────

const POPULAR_TYPES = ["ITV", "REVISION", "DIAGNOSTICO", "CLIMATIZACION", "CAMBIO_ACEITE", "FRENOS", "NEUMATICOS", "ELECTRICIDAD"];
const SEARCHABLE_TYPES = [
  "ITV", "PRE_ITV", "REVISION", "CAMBIO_ACEITE",
  "FRENOS", "NEUMATICOS", "CLIMATIZACION", "DIAGNOSTICO", "ELECTRICIDAD",
];

/** 4 servicios para las cards de la Home */
export const POPULAR_SERVICES = ALL_SERVICES.filter((s) =>
  POPULAR_TYPES.includes(s.type)
);

/** 9 servicios para el desplegable del SearchBar */
export const SEARCHABLE_SERVICES = ALL_SERVICES.filter((s) =>
  SEARCHABLE_TYPES.includes(s.type)
);

// ─── SERVICE_LABELS derivado (mantiene retrocompatibilidad con lib/utils.ts) ──

export const SERVICE_LABELS: Record<string, string> = Object.fromEntries(
  ALL_SERVICES.map((s) => [s.type, s.label])
);
