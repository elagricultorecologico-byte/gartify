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
      "Perfil verificado en el directorio",
      "Hasta 4 servicios publicados",
      "Gestión de reservas online",
      "Reseñas y valoraciones de clientes",
      "Soporte por email",
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
    precioAnual: 261,
    descripcion: "Para talleres en crecimiento que quieren más visibilidad.",
    caracteristicas: [
      "Todo lo del plan Starter",
      "Servicios ilimitados",
      "Ofertas especiales de horario",
      "Posición destacada en búsqueda",
      "Notificaciones automáticas al cliente",
      "Panel de estadísticas",
      "Modo TV — pantalla de citas en tiempo real",
      "Gestión de reservas por WhatsApp",
    ],
    limitaciones: [
      "Sin estadísticas avanzadas con informes PDF",
    ],
  },
  PREMIUM: {
    nombre: "Premium",
    precioMensual: 79,
    precioAnual: 711,
    descripcion: "La experiencia completa para talleres líderes en su zona.",
    caracteristicas: [
      "Todo lo del plan Pro",
      "Red de distribuidores de recambios",
      'Badge "Taller Premium" visible',
      "Soporte prioritario 24 h",
      "Cupones y promociones de marketing",
      "Estadísticas avanzadas e informes PDF",
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
