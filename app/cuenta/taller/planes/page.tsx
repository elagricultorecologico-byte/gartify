import type { Metadata } from "next";
import { redirect } from "next/navigation";
import Link from "next/link";
import { ArrowLeft } from "lucide-react";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { PlanSelector } from "@/components/cuenta/PlanSelector";
import type { Plan } from "@/lib/plans";

export const dynamic = "force-dynamic";

export const metadata: Metadata = {
  title: "Planes y suscripciones — Gartify",
  description: "Elige el plan que mejor se adapte a tu taller. Starter gratis, Pro y Premium con facturacion mensual o anual.",
  robots: { index: false, follow: false },
};

export default async function PlanesPage() {
  // 1. Verificar sesión y rol
  const sesion = await auth();
  if (!sesion?.user?.id) redirect("/login");

  const usuario = sesion.user as { id: string; role?: string };
  if (usuario.role !== "GARAGE_OWNER") redirect("/cuenta");

  // 2. Cargar datos del taller
  const taller = await db.garage.findUnique({
    where: { ownerId: usuario.id },
    select: {
      id: true,
      plan: true,
      stripeSubscriptionId: true,
      planExpiresAt: true,
    },
  });

  if (!taller) redirect("/cuenta/taller/perfil");

  const planActual = taller.plan as Plan;
  const tieneSuscripcionActiva = !!taller.stripeSubscriptionId;

  return (
    <div className="w-full max-w-6xl mx-auto py-6 px-4 sm:px-8">
      {/* Cabecera */}
      <div className="mb-8">
        <Link
          href="/cuenta/taller"
          className="inline-flex items-center gap-1.5 text-sm text-muted-foreground hover:text-foreground transition-colors mb-4"
        >
          <ArrowLeft className="h-4 w-4" aria-hidden="true" />
          Volver al portal
        </Link>
        <h1 className="text-3xl font-extrabold text-gartify-blue">
          Planes y suscripciones
        </h1>
        <p className="mt-2 text-muted-foreground max-w-xl">
          Elige el plan que mejor se adapte a tu taller. Puedes cambiar o cancelar cuando quieras
          desde el portal de facturacion de Stripe.
        </p>
      </div>

      {/* Información del plan actual */}
      {tieneSuscripcionActiva && taller.planExpiresAt && (
        <div className="mb-8 rounded-xl border border-blue-100 bg-blue-50 px-5 py-4 text-sm text-gartify-blue">
          <span className="font-semibold">Proxima renovacion:</span>{" "}
          {new Intl.DateTimeFormat("es-ES", { dateStyle: "long" }).format(taller.planExpiresAt)}
        </div>
      )}

      {/* Selector de planes (Client Component) */}
      <PlanSelector
        planActual={planActual}
        tieneSuscripcionActiva={tieneSuscripcionActiva}
      />

      {/* Preguntas frecuentes */}
      <div className="mt-16 border-t pt-10">
        <h2 className="text-xl font-bold text-foreground mb-6">Preguntas frecuentes</h2>
        <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
          {PREGUNTAS_FRECUENTES.map(({ pregunta, respuesta }) => (
            <div key={pregunta}>
              <h3 className="font-semibold text-foreground mb-1">{pregunta}</h3>
              <p className="text-sm text-muted-foreground">{respuesta}</p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

// ── FAQ inline para no crear componentes extra innecesarios ────────────────────

const PREGUNTAS_FRECUENTES = [
  {
    pregunta: "¿Puedo cancelar cuando quiera?",
    respuesta:
      "Si. Puedes cancelar tu suscripcion en cualquier momento desde el portal de facturacion de Stripe. Seguiras teniendo acceso hasta el final del periodo de facturacion.",
  },
  {
    pregunta: "¿Que pasa si bajo de plan?",
    respuesta:
      "Al cancelar o bajar al plan Starter, tu taller continuara visible en el directorio pero las funcionalidades exclusivas de planes de pago quedaran desactivadas.",
  },
  {
    pregunta: "¿Como funciona la facturacion anual?",
    respuesta:
      "Al elegir facturacion anual pagas el equivalente a 10 meses, con un ahorro del 30% respecto al precio mensual. El cobro es unico al inicio del periodo.",
  },
  {
    pregunta: "¿Los pagos son seguros?",
    respuesta:
      "Si. Todos los pagos se procesan a traves de Stripe, lider mundial en procesamiento de pagos. Gartify nunca almacena datos de tu tarjeta.",
  },
] as const;
