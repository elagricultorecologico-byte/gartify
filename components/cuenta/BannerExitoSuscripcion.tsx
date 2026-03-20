"use client";

import { useState, useEffect } from "react";
import { useRouter } from "next/navigation";
import { CheckCircle2, X, Zap, Crown } from "lucide-react";
import { cn } from "@/lib/utils";

interface PropsBannerExito {
  /** Plan que el taller acaba de activar */
  plan: string;
}

/**
 * Banner de confirmación que aparece cuando el usuario vuelve de Stripe
 * con el parámetro ?success=1.
 * Se autocierra tras 8 segundos y limpia el parámetro de la URL.
 */
export function BannerExitoSuscripcion({ plan }: PropsBannerExito) {
  const router = useRouter();
  const [visible, setVisible] = useState(true);

  // Limpiar el query param de la URL sin recargar la página
  useEffect(() => {
    const url = new URL(window.location.href);
    url.searchParams.delete("success");
    router.replace(url.pathname + url.search, { scroll: false });
  }, [router]);

  // Autoclose tras 8 segundos
  useEffect(() => {
    const timer = setTimeout(() => setVisible(false), 8000);
    return () => clearTimeout(timer);
  }, []);

  if (!visible) return null;

  const Icono = plan === "PREMIUM" ? Crown : Zap;
  const colorIcono = plan === "PREMIUM" ? "text-amber-500" : "text-gartify-blue";

  return (
    <div
      role="status"
      aria-live="polite"
      className={cn(
        "mb-6 flex items-start gap-3 rounded-xl border border-green-200 bg-green-50 px-5 py-4",
        "animate-in fade-in slide-in-from-top-2 duration-300"
      )}
    >
      <CheckCircle2 className="h-5 w-5 text-green-600 mt-0.5 shrink-0" aria-hidden="true" />
      <div className="flex-1">
        <p className="font-semibold text-green-800 flex items-center gap-1.5">
          Suscripcion activada correctamente
          <Icono className={cn("h-4 w-4", colorIcono)} aria-hidden="true" />
        </p>
        <p className="text-sm text-green-700 mt-0.5">
          Ya tienes activo el plan{" "}
          <span className="font-bold capitalize">{plan.charAt(0) + plan.slice(1).toLowerCase()}</span>.
          Todas las funcionalidades estan disponibles de inmediato.
        </p>
      </div>
      <button
        onClick={() => setVisible(false)}
        className="text-green-600 hover:text-green-800 transition-colors shrink-0"
        aria-label="Cerrar notificacion"
      >
        <X className="h-4 w-4" aria-hidden="true" />
      </button>
    </div>
  );
}
