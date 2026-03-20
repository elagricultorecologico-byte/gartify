"use client";

import { useState } from "react";
import { Check, Loader2, Zap, Crown, Wrench } from "lucide-react";
import { Button } from "@/components/ui/button";
import { cn } from "@/lib/utils";
import { PLANES } from "@/lib/plans";
import type { Plan } from "@/lib/plans";

// ── Tipos ─────────────────────────────────────────────────────────────────────

interface PropsPlanSelector {
  planActual: Plan;
  /** true si el taller ya tiene una suscripción activa en Stripe */
  tieneSuscripcionActiva: boolean;
}

interface PreciosPlan {
  mensual: string | null; // null para STARTER (gratis)
  anual: string | null;
}

// ── Constantes ────────────────────────────────────────────────────────────────
// Los Price IDs se leen de variables NEXT_PUBLIC_ para que estén disponibles
// en el navegador sin exponer claves secretas.

const PRECIOS_STRIPE: Record<string, PreciosPlan> = {
  PRO: {
    mensual: process.env.NEXT_PUBLIC_STRIPE_PRICE_PRO_MONTHLY ?? null,
    anual:   process.env.NEXT_PUBLIC_STRIPE_PRICE_PRO_YEARLY   ?? null,
  },
  PREMIUM: {
    mensual: process.env.NEXT_PUBLIC_STRIPE_PRICE_PREMIUM_MONTHLY ?? null,
    anual:   process.env.NEXT_PUBLIC_STRIPE_PRICE_PREMIUM_YEARLY   ?? null,
  },
};

// ── Íconos por plan ────────────────────────────────────────────────────────────

const ICONOS_PLAN: Record<Plan, React.ElementType> = {
  STARTER: Wrench,
  PRO: Zap,
  PREMIUM: Crown,
};

const COLORES_PLAN: Record<Plan, string> = {
  STARTER: "border-gray-200 bg-gray-50",
  PRO: "border-blue-200 bg-blue-50",
  PREMIUM: "border-amber-300 bg-amber-50",
};

const COLORES_ICONO: Record<Plan, string> = {
  STARTER: "text-gray-500",
  PRO: "text-gartify-blue",
  PREMIUM: "text-amber-600",
};

const COLORES_CTA: Record<Plan, string> = {
  STARTER: "bg-gray-200 text-gray-700 hover:bg-gray-300",
  PRO: "bg-gartify-blue text-white hover:bg-blue-800",
  PREMIUM: "bg-amber-500 text-white hover:bg-amber-600",
};

// ── Componente ─────────────────────────────────────────────────────────────────

export function PlanSelector({ planActual, tieneSuscripcionActiva }: PropsPlanSelector) {
  const [esMensual, setEsMensual] = useState(true);
  const [cargandoPlan, setCargandoPlan] = useState<Plan | null>(null);
  const [cargandoPortal, setCargandoPortal] = useState(false);
  const [error, setError] = useState<string | null>(null);

  /**
   * Inicia el flujo de suscripción abriendo Stripe Checkout.
   */
  async function iniciarCheckout(plan: Plan) {
    if (plan === "STARTER") return;

    const priceId = esMensual
      ? PRECIOS_STRIPE[plan]?.mensual
      : PRECIOS_STRIPE[plan]?.anual;

    if (!priceId) {
      setError("Plan no disponible en este momento. Inténtalo más tarde.");
      return;
    }

    setCargandoPlan(plan);
    setError(null);

    try {
      const res = await fetch("/api/stripe/checkout", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ priceId }),
      });

      const datos = (await res.json()) as { url?: string; error?: string };

      if (!res.ok || !datos.url) {
        setError(datos.error ?? "No se pudo iniciar el proceso de pago.");
        return;
      }

      // Redirigir a Stripe Checkout
      window.location.href = datos.url;
    } catch {
      setError("Error de red. Por favor, inténtalo de nuevo.");
    } finally {
      setCargandoPlan(null);
    }
  }

  /**
   * Abre el Stripe Customer Portal para gestionar la suscripción existente.
   */
  async function abrirPortalStripe() {
    setCargandoPortal(true);
    setError(null);

    try {
      const res = await fetch("/api/stripe/portal", { method: "POST" });
      const datos = (await res.json()) as { url?: string; error?: string };

      if (!res.ok || !datos.url) {
        setError(datos.error ?? "No se pudo abrir el portal de suscripción.");
        return;
      }

      window.location.href = datos.url;
    } catch {
      setError("Error de red. Por favor, inténtalo de nuevo.");
    } finally {
      setCargandoPortal(false);
    }
  }

  // Los planes en orden que queremos mostrarlos
  const ordenPlanes: Plan[] = ["STARTER", "PRO", "PREMIUM"];

  return (
    <div className="space-y-8">
      {/* Toggle mensual / anual */}
      <div className="flex items-center justify-center gap-4">
        <span className={cn("text-sm font-medium", esMensual ? "text-foreground" : "text-muted-foreground")}>
          Mensual
        </span>
        <button
          onClick={() => setEsMensual((prev) => !prev)}
          className={cn(
            "relative inline-flex h-6 w-11 items-center rounded-full transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-gartify-blue",
            esMensual ? "bg-gray-300" : "bg-gartify-blue"
          )}
          role="switch"
          aria-checked={!esMensual}
          aria-label="Cambiar entre facturación mensual y anual"
        >
          <span
            className={cn(
              "inline-block h-4 w-4 transform rounded-full bg-white shadow-sm transition-transform",
              esMensual ? "translate-x-1" : "translate-x-6"
            )}
          />
        </button>
        <span className={cn("text-sm font-medium flex items-center gap-1.5", !esMensual ? "text-foreground" : "text-muted-foreground")}>
          Anual
          <span className="inline-flex items-center rounded-full bg-green-100 border border-green-200 text-green-700 text-xs font-bold px-2 py-0.5">
            -25%
          </span>
        </span>
      </div>

      {/* Cards de planes */}
      <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
        {ordenPlanes.map((plan) => {
          const datos = PLANES[plan];
          const Icono = ICONOS_PLAN[plan];
          const esPlanActual = plan === planActual;
          const esPopular = plan === "PRO";

          return (
            <div
              key={plan}
              className={cn(
                "relative rounded-2xl border-2 p-6 flex flex-col gap-5 transition-shadow",
                COLORES_PLAN[plan],
                esPlanActual && "ring-2 ring-offset-2 ring-gartify-blue shadow-lg",
                !esPlanActual && "hover:shadow-md"
              )}
            >
              {/* Badge de plan popular */}
              {esPopular && (
                <div className="absolute -top-3 left-1/2 -translate-x-1/2">
                  <span className="inline-flex items-center rounded-full bg-gartify-blue text-white text-xs font-bold px-3 py-1 shadow-sm">
                    Mas popular
                  </span>
                </div>
              )}

              {/* Cabecera */}
              <div>
                <div className="flex items-center gap-2 mb-2">
                  <Icono className={cn("h-5 w-5", COLORES_ICONO[plan])} aria-hidden="true" />
                  <h3 className="font-bold text-lg text-foreground">{datos.nombre}</h3>
                  {esPlanActual && (
                    <span className="ml-auto text-xs font-bold bg-gartify-blue/10 text-gartify-blue rounded-full px-2 py-0.5">
                      Tu plan
                    </span>
                  )}
                </div>
                <p className="text-sm text-muted-foreground">{datos.descripcion}</p>
              </div>

              {/* Precio */}
              <div>
                {plan === "STARTER" ? (
                  <p className="text-3xl font-extrabold text-foreground">
                    Gratis
                  </p>
                ) : (
                  <div>
                    <p className="text-3xl font-extrabold text-foreground">
                      {esMensual ? `${datos.precioMensual} €` : `${datos.precioAnual} €`}
                      <span className="text-base font-normal text-muted-foreground">
                        {esMensual ? "/mes" : "/año"}
                      </span>
                    </p>
                    {!esMensual && (
                      <div className="flex items-center gap-2 mt-0.5">
                        <p className="text-xs text-green-600 font-medium">
                          Equivale a {(datos.precioAnual / 12).toFixed(0)} €/mes
                        </p>
                        <p className="text-xs text-green-700 font-bold bg-green-100 rounded-full px-2 py-0.5">
                          Ahorras {(datos.precioMensual * 12) - datos.precioAnual}€/año
                        </p>
                      </div>
                    )}
                  </div>
                )}
              </div>

              {/* Características */}
              <ul className="space-y-2 flex-1" role="list" aria-label={`Características del plan ${datos.nombre}`}>
                {datos.caracteristicas.map((caracteristica) => (
                  <li key={caracteristica} className="flex items-start gap-2 text-sm text-foreground">
                    <Check className="h-4 w-4 text-green-500 mt-0.5 shrink-0" aria-hidden="true" />
                    {caracteristica}
                  </li>
                ))}
              </ul>

              {/* CTA */}
              <div className="pt-2">
                {plan === "STARTER" ? (
                  esPlanActual ? (
                    <Button disabled className="w-full bg-gray-100 text-gray-400 cursor-default">
                      Plan actual
                    </Button>
                  ) : (
                    // Si tiene suscripción, puede volver a Starter desde el portal
                    tieneSuscripcionActiva ? (
                      <Button
                        variant="outline"
                        className="w-full"
                        onClick={abrirPortalStripe}
                        disabled={cargandoPortal}
                      >
                        {cargandoPortal ? (
                          <Loader2 className="h-4 w-4 animate-spin" aria-hidden="true" />
                        ) : (
                          "Cancelar suscripcion"
                        )}
                      </Button>
                    ) : (
                      <Button disabled className="w-full bg-gray-100 text-gray-400 cursor-default">
                        Empezar gratis
                      </Button>
                    )
                  )
                ) : esPlanActual ? (
                  tieneSuscripcionActiva ? (
                    <Button
                      className="w-full"
                      onClick={abrirPortalStripe}
                      disabled={cargandoPortal}
                    >
                      {cargandoPortal ? (
                        <Loader2 className="h-4 w-4 animate-spin" aria-hidden="true" />
                      ) : (
                        "Gestionar suscripcion"
                      )}
                    </Button>
                  ) : (
                    <Button disabled className="w-full bg-gray-100 text-gray-400 cursor-default">
                      Plan actual
                    </Button>
                  )
                ) : tieneSuscripcionActiva ? (
                  // Tiene suscripción de otro plan → gestionar desde portal
                  <Button
                    className={cn("w-full", COLORES_CTA[plan])}
                    onClick={abrirPortalStripe}
                    disabled={cargandoPortal}
                  >
                    {cargandoPortal ? (
                      <Loader2 className="h-4 w-4 animate-spin" aria-hidden="true" />
                    ) : (
                      "Cambiar a este plan"
                    )}
                  </Button>
                ) : (
                  // Sin suscripción → nuevo checkout
                  <Button
                    className={cn("w-full", COLORES_CTA[plan])}
                    onClick={() => iniciarCheckout(plan)}
                    disabled={cargandoPlan !== null}
                  >
                    {cargandoPlan === plan ? (
                      <Loader2 className="h-4 w-4 animate-spin" aria-hidden="true" />
                    ) : (
                      `Suscribirse a ${datos.nombre}`
                    )}
                  </Button>
                )}
              </div>
            </div>
          );
        })}
      </div>

      {/* Mensaje de error global */}
      {error && (
        <div role="alert" className="rounded-lg border border-red-200 bg-red-50 px-4 py-3 text-sm text-red-700 text-center">
          {error}
        </div>
      )}

      {/* Nota sobre gestión de suscripción */}
      {tieneSuscripcionActiva && (
        <p className="text-center text-xs text-muted-foreground">
          Para cancelar o cambiar tu metodo de pago, usa el{" "}
          <button
            onClick={abrirPortalStripe}
            className="underline hover:text-foreground transition-colors"
            disabled={cargandoPortal}
          >
            portal de facturacion de Stripe
          </button>
          .
        </p>
      )}
    </div>
  );
}
