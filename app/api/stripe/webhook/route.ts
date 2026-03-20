import { NextResponse } from "next/server";
import type Stripe from "stripe";
import { stripe } from "@/lib/stripe";
import { db } from "@/lib/db";
import { planDesdePriceId } from "@/lib/plans";

/**
 * POST /api/stripe/webhook
 *
 * Recibe eventos de Stripe y sincroniza el estado de la suscripción
 * en nuestra base de datos.
 *
 * IMPORTANTE: Este handler lee el body como texto RAW (req.text())
 * para que stripe.webhooks.constructEvent() pueda verificar la firma.
 * No usar req.json() aquí.
 */
export async function POST(req: Request): Promise<NextResponse> {
  // 1. Leer body como texto para verificar firma de Stripe
  const body = await req.text();
  const firma = req.headers.get("stripe-signature");

  if (!firma) {
    return NextResponse.json({ error: "Falta la firma de Stripe" }, { status: 400 });
  }

  const webhookSecret = process.env.STRIPE_WEBHOOK_SECRET;
  if (!webhookSecret) {
    console.error("Falta STRIPE_WEBHOOK_SECRET en las variables de entorno");
    return NextResponse.json({ error: "Configuración de webhook incompleta" }, { status: 500 });
  }

  // 2. Verificar y construir el evento
  let evento: Stripe.Event;
  try {
    evento = stripe.webhooks.constructEvent(body, firma, webhookSecret);
  } catch (err) {
    const mensaje = err instanceof Error ? err.message : "Error desconocido";
    console.error(`Verificación de webhook fallida: ${mensaje}`);
    return NextResponse.json({ error: `Firma inválida: ${mensaje}` }, { status: 400 });
  }

  // 3. Manejar cada tipo de evento relevante
  try {
    switch (evento.type) {
      // ── Pago inicial completado ────────────────────────────────────────────
      case "checkout.session.completed": {
        const checkoutSession = evento.data.object as Stripe.Checkout.Session;

        // Solo procesamos sesiones de modo "subscription"
        if (checkoutSession.mode !== "subscription") break;

        const subscriptionId =
          typeof checkoutSession.subscription === "string"
            ? checkoutSession.subscription
            : checkoutSession.subscription?.id;

        if (!subscriptionId) {
          console.error("checkout.session.completed sin subscriptionId");
          break;
        }

        // Obtener la suscripción completa para conocer el priceId
        const suscripcion = await stripe.subscriptions.retrieve(subscriptionId);
        const priceId = suscripcion.items.data[0]?.price.id ?? "";
        const plan = planDesdePriceId(priceId);

        // El garageId lo guardamos en metadata al crear la checkout session
        const garageId = suscripcion.metadata?.garageId;

        if (!garageId) {
          console.error("checkout.session.completed sin garageId en metadata");
          break;
        }

        // Calcular fecha de próxima renovación
        const planExpiresAt = suscripcion.current_period_end
          ? new Date(suscripcion.current_period_end * 1000)
          : null;

        await db.garage.update({
          where: { id: garageId },
          data: {
            plan,
            stripeSubscriptionId: subscriptionId,
            stripePriceId: priceId,
            stripeCustomerId: checkoutSession.customer as string,
            ...(planExpiresAt && { planExpiresAt }),
          },
        });

        console.log(`Suscripción activada: taller=${garageId} plan=${plan}`);
        break;
      }

      // ── Suscripción actualizada (cambio de plan, renovación, etc.) ─────────
      case "customer.subscription.updated": {
        const suscripcion = evento.data.object as Stripe.Subscription;

        const garageId = suscripcion.metadata?.garageId;
        if (!garageId) {
          // Intentar recuperar el garageId desde el customer
          console.warn("customer.subscription.updated sin garageId en metadata");
          break;
        }

        const priceId = suscripcion.items.data[0]?.price.id ?? "";
        const plan = planDesdePriceId(priceId);

        const planExpiresAt = suscripcion.current_period_end
          ? new Date(suscripcion.current_period_end * 1000)
          : null;

        await db.garage.update({
          where: { id: garageId },
          data: {
            plan,
            stripePriceId: priceId,
            stripeSubscriptionId: suscripcion.id,
            ...(planExpiresAt && { planExpiresAt }),
          },
        });

        console.log(`Suscripción actualizada: taller=${garageId} plan=${plan}`);
        break;
      }

      // ── Suscripción cancelada (por el usuario o por falta de pago) ─────────
      case "customer.subscription.deleted": {
        const suscripcion = evento.data.object as Stripe.Subscription;

        const garageId = suscripcion.metadata?.garageId;
        if (!garageId) {
          // Buscar el taller por stripeCustomerId como fallback
          const customerId =
            typeof suscripcion.customer === "string"
              ? suscripcion.customer
              : suscripcion.customer?.id;

          if (customerId) {
            await db.garage.updateMany({
              where: { stripeCustomerId: customerId },
              data: {
                plan: "STARTER",
                stripeSubscriptionId: null,
                stripePriceId: null,
                planExpiresAt: null,
              },
            });
            console.log(`Suscripción cancelada por customerId=${customerId} → STARTER`);
          }
          break;
        }

        await db.garage.update({
          where: { id: garageId },
          data: {
            plan: "STARTER",
            stripeSubscriptionId: null,
            stripePriceId: null,
            planExpiresAt: null,
          },
        });

        console.log(`Suscripción cancelada: taller=${garageId} → STARTER`);
        break;
      }

      default:
        // Ignoramos eventos que no nos interesan sin error
        break;
    }
  } catch (err) {
    const mensaje = err instanceof Error ? err.message : "Error desconocido";
    console.error(`Error procesando evento ${evento.type}: ${mensaje}`);
    // Devolvemos 200 igualmente para que Stripe no reintente indefinidamente
    // errores que son de nuestra lógica, no de Stripe
    return NextResponse.json(
      { error: "Error interno al procesar el evento" },
      { status: 500 }
    );
  }

  // 4. Confirmar recepción exitosa a Stripe
  return NextResponse.json({ recibido: true });
}
