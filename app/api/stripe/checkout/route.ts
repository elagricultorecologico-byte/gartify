import { NextResponse } from "next/server";
import { z } from "zod";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { stripe } from "@/lib/stripe";

// Esquema de validación: solo aceptamos un priceId de Stripe
const esquemaCheckout = z.object({
  priceId: z.string().min(1, "priceId es obligatorio"),
});

/**
 * POST /api/stripe/checkout
 * Crea una Stripe Checkout Session para el taller autenticado.
 * Devuelve { url } con la URL de pago a la que redirigir al cliente.
 */
export async function POST(req: Request): Promise<NextResponse> {
  // 1. Verificar sesión
  const sesion = await auth();
  if (!sesion?.user?.id) {
    return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  }

  const usuario = sesion.user as { id: string; role?: string; email?: string | null };

  // 2. Solo los propietarios de taller pueden suscribirse
  if (usuario.role !== "GARAGE_OWNER") {
    return NextResponse.json({ error: "Solo los talleres pueden suscribirse" }, { status: 403 });
  }

  // 3. Validar body
  const body = await req.json();
  const resultado = esquemaCheckout.safeParse(body);
  if (!resultado.success) {
    return NextResponse.json(
      { error: "Datos inválidos", detalles: resultado.error.flatten() },
      { status: 400 }
    );
  }

  const { priceId } = resultado.data;

  // 4. Cargar el taller para verificar propiedad
  const taller = await db.garage.findUnique({
    where: { ownerId: usuario.id },
    select: {
      id: true,
      name: true,
      stripeCustomerId: true,
      stripeSubscriptionId: true,
    },
  });

  if (!taller) {
    return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });
  }

  // 5. Crear o recuperar el customer de Stripe
  let stripeCustomerId = taller.stripeCustomerId;

  if (!stripeCustomerId) {
    const customer = await stripe.customers.create({
      email: usuario.email ?? undefined,
      name: taller.name,
      metadata: {
        garageId: taller.id,
        userId: usuario.id,
      },
    });
    stripeCustomerId = customer.id;

    // Guardar en base de datos para no volver a crearlo
    await db.garage.update({
      where: { id: taller.id },
      data: { stripeCustomerId },
    });
  }

  // 6. Si ya tiene una suscripción activa, no abrir un nuevo checkout
  //    (deben usar el portal de Stripe para gestionar/cambiar)
  if (taller.stripeSubscriptionId) {
    return NextResponse.json(
      { error: "Ya tienes una suscripción activa. Usa el portal para cambiar de plan." },
      { status: 409 }
    );
  }

  // 7. Calcular la URL base
  const baseUrl = process.env.NEXT_PUBLIC_BASE_URL ?? "http://localhost:3000";

  // 8. Crear la Checkout Session
  const checkoutSession = await stripe.checkout.sessions.create({
    customer: stripeCustomerId,
    mode: "subscription",
    line_items: [{ price: priceId, quantity: 1 }],
    success_url: `${baseUrl}/cuenta/taller?success=1`,
    cancel_url: `${baseUrl}/cuenta/taller/planes`,
    // Añadir el garageId en metadata para el webhook
    subscription_data: {
      metadata: {
        garageId: taller.id,
      },
    },
    allow_promotion_codes: true,
    billing_address_collection: "auto",
  });

  if (!checkoutSession.url) {
    return NextResponse.json(
      { error: "No se pudo crear la sesión de pago" },
      { status: 500 }
    );
  }

  return NextResponse.json({ url: checkoutSession.url });
}
