import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { stripe } from "@/lib/stripe";

/**
 * POST /api/stripe/portal
 * Crea una Stripe Customer Portal Session para que el taller gestione
 * su suscripción (cambiar de plan, cancelar, ver facturas, etc.).
 * Devuelve { url } con la URL del portal de Stripe.
 */
export async function POST(): Promise<NextResponse> {
  // 1. Verificar sesión
  const sesion = await auth();
  if (!sesion?.user?.id) {
    return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  }

  const usuario = sesion.user as { id: string; role?: string };

  // 2. Solo propietarios de taller
  if (usuario.role !== "GARAGE_OWNER") {
    return NextResponse.json({ error: "Acceso restringido a talleres" }, { status: 403 });
  }

  // 3. Cargar el taller y verificar propiedad
  const taller = await db.garage.findUnique({
    where: { ownerId: usuario.id },
    select: { id: true, stripeCustomerId: true },
  });

  if (!taller) {
    return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });
  }

  if (!taller.stripeCustomerId) {
    return NextResponse.json(
      { error: "No tienes ninguna suscripción activa para gestionar" },
      { status: 400 }
    );
  }

  const baseUrl = process.env.NEXT_PUBLIC_BASE_URL ?? "http://localhost:3000";

  // 4. Crear la sesión del Customer Portal
  const portalSession = await stripe.billingPortal.sessions.create({
    customer: taller.stripeCustomerId,
    return_url: `${baseUrl}/cuenta/taller`,
  });

  return NextResponse.json({ url: portalSession.url });
}
