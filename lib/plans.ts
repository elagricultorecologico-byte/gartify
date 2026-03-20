/**
 * Definición de planes de suscripción de Gartify.
 * Usamos objetos `as const` en lugar de enums de TypeScript.
 */

// ── Constantes de planes ───────────────────────────────────────────────────────

export const PLAN = {
  STARTER: "STARTER",
  PRO: "PRO",
  PREMIUM: "PREMIUM",
} as const;

export type Plan = (typeof PLAN)[keyof typeof PLAN];

// ── Metadata de cada plan ──────────────────────────────────────────────────────

export const PLANES = {
  STARTER: {
    nombre: "Starter",
    precioMensual: 0,
    precioAnual: 0,
    descripcion: "Comienza sin coste, sin compromisos.",
    caracteristicas: [
      "Listado básico en el directorio",
      "Hasta 3 servicios publicados",
      "Reservas online ilimitadas",
      "Panel de gestión de reservas",
    ],
    limitaciones: [
      "Sin ofertas especiales",
      "Sin estadísticas avanzadas",
      "Sin badge destacado",
    ],
  },
  PRO: {
    nombre: "Pro",
    precioMensual: 29,
    precioAnual: 249,
    descripcion: "Para talleres en crecimiento que quieren más visibilidad.",
    caracteristicas: [
      "Todo lo del plan Starter",
      "Hasta 10 servicios publicados",
      "Ofertas especiales y promociones",
      "Estadísticas básicas de rendimiento",
      "Badge Pro en el perfil",
      "Soporte prioritario por email",
    ],
    limitaciones: [
      "Sin posición destacada en búsquedas",
      "Sin estadísticas avanzadas con informes PDF",
    ],
  },
  PREMIUM: {
    nombre: "Premium",
    precioMensual: 59,
    precioAnual: 499,
    descripcion: "La experiencia completa para talleres líderes en su zona.",
    caracteristicas: [
      "Todo lo del plan Pro",
      "Servicios publicados ilimitados",
      "Badge Premium dorado en el perfil",
      "Posición destacada en búsquedas",
      "Estadísticas avanzadas e informes PDF",
      "Gestión de recambios integrada",
      "Soporte prioritario por teléfono",
    ],
    limitaciones: [],
  },
} as const satisfies Record<Plan, {
  nombre: string;
  precioMensual: number;
  precioAnual: number;
  descripcion: string;
  caracteristicas: readonly string[];
  limitaciones: readonly string[];
}>;

// ── Helpers de conversión priceId ↔ plan ──────────────────────────────────────

/**
 * Devuelve el plan correspondiente a un Stripe Price ID.
 * Lee los Price IDs de las variables de entorno para no hardcodear IDs.
 */
export function planDesdePriceId(priceId: string): Plan {
  const { STRIPE_PRICE_PRO_MONTHLY, STRIPE_PRICE_PRO_YEARLY, STRIPE_PRICE_PREMIUM_MONTHLY, STRIPE_PRICE_PREMIUM_YEARLY } =
    process.env;

  if (priceId === STRIPE_PRICE_PRO_MONTHLY || priceId === STRIPE_PRICE_PRO_YEARLY) {
    return PLAN.PRO;
  }
  if (priceId === STRIPE_PRICE_PREMIUM_MONTHLY || priceId === STRIPE_PRICE_PREMIUM_YEARLY) {
    return PLAN.PREMIUM;
  }
  // Si no se reconoce el priceId (ej: plan cancelado), volver a STARTER
  return PLAN.STARTER;
}

/**
 * Indica si un plan tiene una suscripción de pago activa (no es STARTER).
 */
export function esPlanDePago(plan: Plan): boolean {
  return plan !== PLAN.STARTER;
}
