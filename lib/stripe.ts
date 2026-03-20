import Stripe from "stripe";

/**
 * Singleton del cliente Stripe para uso en el servidor (Node.js runtime).
 * Nunca importar desde middleware ni Edge runtime.
 */
if (!process.env.STRIPE_SECRET_KEY) {
  throw new Error("Falta la variable de entorno STRIPE_SECRET_KEY");
}

export const stripe = new Stripe(process.env.STRIPE_SECRET_KEY, {
  apiVersion: "2026-02-25.clover",
  typescript: true,
});
