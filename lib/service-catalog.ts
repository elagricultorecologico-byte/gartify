/**
 * Catálogo de servicios predefinidos del sector automotriz.
 * Sirve como base para que los talleres den de alta sus servicios rápidamente.
 * Los precios son orientativos (mercado español, 2025).
 */

export interface CatalogService {
  /** Slug único que identifica la entrada del catálogo */
  id: string;
  /** Nombre comercial del servicio */
  name: string;
  /** ServiceType — debe coincidir con el enum de Prisma */
  type: string;
  /** Duración sugerida en minutos */
  duration: number;
  /** Precio orientativo en EUR */
  suggestedPrice: number;
  /** Descripción breve opcional */
  description?: string;
}

export const CATALOG_SERVICES: CatalogService[] = [
  // ── ITV ──────────────────────────────────────────────────────────────────────
  {
    id: "itv-ordinaria",
    name: "ITV Ordinaria",
    type: "ITV",
    duration: 60,
    suggestedPrice: 40,
    description: "Inspección técnica periódica obligatoria en estación ITV",
  },
  {
    id: "itv-con-reformas",
    name: "ITV con Reformas",
    type: "ITV",
    duration: 90,
    suggestedPrice: 75,
    description: "ITV con gestión de reformas técnicas homologadas",
  },

  // ── PRE-ITV ───────────────────────────────────────────────────────────────────
  {
    id: "pre-itv-completa",
    name: "Pre-ITV Completa",
    type: "PRE_ITV",
    duration: 60,
    suggestedPrice: 45,
    description: "Revisión exhaustiva para garantizar el paso de la ITV",
  },
  {
    id: "pre-itv-basica",
    name: "Pre-ITV Básica",
    type: "PRE_ITV",
    duration: 30,
    suggestedPrice: 25,
    description: "Chequeo rápido de los puntos críticos de la ITV",
  },

  // ── REVISIÓN ─────────────────────────────────────────────────────────────────
  {
    id: "revision-10000km",
    name: "Revisión 10.000 km",
    type: "REVISION",
    duration: 60,
    suggestedPrice: 89,
    description: "Revisión básica con cambio de aceite y filtros según fabricante",
  },
  {
    id: "revision-20000km",
    name: "Revisión 20.000 km",
    type: "REVISION",
    duration: 90,
    suggestedPrice: 139,
    description: "Revisión intermedia con inspección de frenos y suspensión",
  },
  {
    id: "revision-30000km",
    name: "Revisión 30.000 km",
    type: "REVISION",
    duration: 120,
    suggestedPrice: 189,
    description: "Revisión mayor con inspección completa según libro de mantenimiento",
  },
  {
    id: "mantenimiento-periodico",
    name: "Mantenimiento Periódico (Km/Año)",
    type: "REVISION",
    duration: 90,
    suggestedPrice: 119,
    description: "Mantenimiento adaptado a kilómetros o tiempo según el que llegue antes",
  },
  {
    id: "revision-previa-viaje",
    name: "Revisión Previa a Viaje Largo",
    type: "REVISION",
    duration: 45,
    suggestedPrice: 35,
    description: "Chequeo rápido antes de un trayecto largo: niveles, frenos, ruedas",
  },

  // ── CAMBIO DE ACEITE ──────────────────────────────────────────────────────────
  {
    id: "cambio-aceite-filtro",
    name: "Cambio Aceite y Filtro",
    type: "CAMBIO_ACEITE",
    duration: 30,
    suggestedPrice: 49,
    description: "Aceite mineral o semisintético + filtro de aceite",
  },
  {
    id: "cambio-aceite-sintetico-5w30",
    name: "Cambio Aceite Sintético 5W30",
    type: "CAMBIO_ACEITE",
    duration: 30,
    suggestedPrice: 79,
    description: "Aceite 100% sintético 5W30 + filtro de aceite",
  },
  {
    id: "cambio-aceite-pack-filtros",
    name: "Cambio Aceite + Filtros (Pack)",
    type: "CAMBIO_ACEITE",
    duration: 45,
    suggestedPrice: 99,
    description: "Aceite sintético + filtro de aceite + filtro de aire + filtro de habitáculo",
  },

  // ── FRENOS ────────────────────────────────────────────────────────────────────
  {
    id: "pastillas-delantera",
    name: "Pastillas Freno Delantera",
    type: "FRENOS",
    duration: 45,
    suggestedPrice: 79,
    description: "Sustitución de pastillas de freno en eje delantero (mano de obra incluida)",
  },
  {
    id: "pastillas-trasera",
    name: "Pastillas Freno Trasera",
    type: "FRENOS",
    duration: 45,
    suggestedPrice: 79,
    description: "Sustitución de pastillas de freno en eje trasero (mano de obra incluida)",
  },
  {
    id: "discos-pastillas-delantera",
    name: "Discos + Pastillas Delantera",
    type: "FRENOS",
    duration: 75,
    suggestedPrice: 149,
    description: "Sustitución completa de discos y pastillas en eje delantero",
  },
  {
    id: "discos-pastillas-trasera",
    name: "Discos + Pastillas Trasera",
    type: "FRENOS",
    duration: 75,
    suggestedPrice: 149,
    description: "Sustitución completa de discos y pastillas en eje trasero",
  },
  {
    id: "liquido-frenos",
    name: "Líquido de Frenos",
    type: "FRENOS",
    duration: 30,
    suggestedPrice: 35,
    description: "Purga y sustitución del líquido de frenos DOT 4",
  },

  // ── NEUMÁTICOS ────────────────────────────────────────────────────────────────
  {
    id: "cambio-2-neumaticos",
    name: "Cambio 2 Neumáticos",
    type: "NEUMATICOS",
    duration: 45,
    suggestedPrice: 30,
    description: "Desmontaje, montaje y equilibrado de 2 neumáticos (sin precio de cubierta)",
  },
  {
    id: "cambio-4-neumaticos",
    name: "Cambio 4 Neumáticos",
    type: "NEUMATICOS",
    duration: 75,
    suggestedPrice: 55,
    description: "Desmontaje, montaje y equilibrado de 4 neumáticos (sin precio de cubierta)",
  },
  {
    id: "alineacion-direccion",
    name: "Alineación Dirección / Paralelo",
    type: "NEUMATICOS",
    duration: 30,
    suggestedPrice: 35,
    description: "Geometría de dirección: convergencia y paralelo con eje trasero",
  },
  {
    id: "equilibrado-ruedas",
    name: "Equilibrado Ruedas",
    type: "NEUMATICOS",
    duration: 30,
    suggestedPrice: 25,
    description: "Equilibrado de las 4 ruedas con máquina de equilibrado dinámica",
  },
  {
    id: "cambio-temporada",
    name: "Cambio de Temporada",
    type: "NEUMATICOS",
    duration: 30,
    suggestedPrice: 25,
    description: "Intercambio de neumáticos de verano a invierno o viceversa (con llanta)",
  },

  // ── DIAGNÓSTICO ───────────────────────────────────────────────────────────────
  {
    id: "diagnosis-electronica",
    name: "Diagnosis Electrónica (Avisos / Fallos)",
    type: "DIAGNOSTICO",
    duration: 30,
    suggestedPrice: 29,
    description: "Lectura de códigos OBD con equipo de diagnosis multimarca",
  },
  {
    id: "diagnostico-mecanico",
    name: "Mecánica - Diagnóstico de Problema",
    type: "DIAGNOSTICO",
    duration: 60,
    suggestedPrice: 45,
    description: "Diagnóstico mecánico completo para localizar el origen de una avería",
  },

  // ── CLIMATIZACIÓN ─────────────────────────────────────────────────────────────
  {
    id: "carga-aire-acondicionado",
    name: "Carga Aire Acondicionado",
    type: "CLIMATIZACION",
    duration: 45,
    suggestedPrice: 55,
    description: "Recarga de gas refrigerante R134a o R1234yf con equipo homologado",
  },
  {
    id: "revision-aire-acondicionado",
    name: "Revisión Aire Acondicionado",
    type: "CLIMATIZACION",
    duration: 30,
    suggestedPrice: 35,
    description: "Comprobación de presiones, estanqueidad y rendimiento del circuito",
  },
  {
    id: "limpieza-evaporador",
    name: "Limpieza Evaporador",
    type: "CLIMATIZACION",
    duration: 45,
    suggestedPrice: 49,
    description: "Desinfección y limpieza del evaporador para eliminar malos olores",
  },

  // ── MOTOR ─────────────────────────────────────────────────────────────────────
  {
    id: "correa-distribucion-kit",
    name: "Correa Distribución (Kit Compl.)",
    type: "MOTOR",
    duration: 180,
    suggestedPrice: 349,
    description: "Kit completo: correa, tensor, rodillos y bomba de agua (mano de obra incluida)",
  },
  {
    id: "correa-accesorios",
    name: "Correa Accesorios",
    type: "MOTOR",
    duration: 60,
    suggestedPrice: 89,
    description: "Sustitución de la correa de accesorios (alternador, compresor A/C)",
  },
  {
    id: "junta-culata",
    name: "Junta de Culata",
    type: "MOTOR",
    duration: 480,
    suggestedPrice: 799,
    description: "Sustitución de la junta de culata con rectificado de culata incluido",
  },

  // ── CARROCERÍA ────────────────────────────────────────────────────────────────
  {
    id: "carroceria-valoracion",
    name: "Carrocería - Valoración y Presupuesto",
    type: "CARROCERIA",
    duration: 30,
    suggestedPrice: 0,
    description: "Inspección visual y presupuesto sin compromiso para reparaciones de chapa",
  },
  {
    id: "reparacion-pinchazo",
    name: "Reparación Pinchazo",
    type: "CARROCERIA",
    duration: 20,
    suggestedPrice: 15,
    description: "Localización y reparación de pinchazo en neumático tubeless",
  },

  // ── ELECTRICIDAD ──────────────────────────────────────────────────────────────
  {
    id: "cambio-bateria",
    name: "Cambio Batería",
    type: "ELECTRICIDAD",
    duration: 30,
    suggestedPrice: 39,
    description: "Sustitución de batería de arranque (sin precio de la batería)",
  },
  {
    id: "revision-sistema-electrico",
    name: "Revisión Sistema Eléctrico",
    type: "ELECTRICIDAD",
    duration: 45,
    suggestedPrice: 35,
    description: "Comprobación del alternador, batería, arranque y circuitos principales",
  },

  // ── SUSPENSIÓN ────────────────────────────────────────────────────────────────
  {
    id: "amortiguadores-delanteros",
    name: "Amortiguadores Delanteros",
    type: "SUSPENSION",
    duration: 90,
    suggestedPrice: 149,
    description: "Sustitución de amortiguadores delanteros (mano de obra incluida, sin recambio)",
  },
  {
    id: "amortiguadores-traseros",
    name: "Amortiguadores Traseros",
    type: "SUSPENSION",
    duration: 90,
    suggestedPrice: 149,
    description: "Sustitución de amortiguadores traseros (mano de obra incluida, sin recambio)",
  },
  {
    id: "revision-suspension-completa",
    name: "Revisión Suspensión Completa",
    type: "SUSPENSION",
    duration: 60,
    suggestedPrice: 45,
    description: "Inspección completa de amortiguadores, rótulas, silentblocks y tren delantero",
  },

  // ── FILTROS ────────────────────────────────────────────────────────────────────
  {
    id: "cambio-filtro-aire",
    name: "Cambio Filtro de Aire",
    type: "FILTROS",
    duration: 15,
    suggestedPrice: 25,
    description: "Sustitución del filtro de aire del motor",
  },
  {
    id: "cambio-filtro-habitaculo",
    name: "Cambio Filtro de Habitáculo (Polen)",
    type: "FILTROS",
    duration: 15,
    suggestedPrice: 25,
    description: "Sustitución del filtro de habitáculo o filtro antipolén",
  },
  {
    id: "cambio-filtro-combustible",
    name: "Cambio Filtro Combustible",
    type: "FILTROS",
    duration: 30,
    suggestedPrice: 45,
    description: "Sustitución del filtro de gasolina o gasóleo",
  },
];

/**
 * Agrupa los servicios del catálogo por su ServiceType para facilitar
 * la construcción de filtros y pestañas en la UI.
 */
export function getCatalogByType(): Map<string, CatalogService[]> {
  const mapa = new Map<string, CatalogService[]>();
  for (const svc of CATALOG_SERVICES) {
    const grupo = mapa.get(svc.type) ?? [];
    grupo.push(svc);
    mapa.set(svc.type, grupo);
  }
  return mapa;
}

/**
 * Devuelve todos los ServiceType únicos presentes en el catálogo,
 * en el orden en que aparecen por primera vez.
 */
export function getCatalogTypes(): string[] {
  const tipos: string[] = [];
  for (const svc of CATALOG_SERVICES) {
    if (!tipos.includes(svc.type)) tipos.push(svc.type);
  }
  return tipos;
}
