"use client";

import { useState } from "react";
import Link from "next/link";
import { Globe, Copy, Check, ExternalLink, Lock } from "lucide-react";
import { cn } from "@/lib/utils";

interface PropsTarjetaPaginaPublica {
  plan: string;
  slug: string | null;
}

/**
 * Tarjeta en el portal del taller que muestra la URL de la landing pública.
 * Solo visible para planes PRO y PREMIUM. Los talleres Starter ven un CTA de upgrade.
 */
export function TarjetaPaginaPublica({ plan, slug }: PropsTarjetaPaginaPublica) {
  const [copiado, setCopiado] = useState(false);

  const esPremium = plan === "PRO" || plan === "PREMIUM";

  // URL pública del taller
  const baseUrl =
    typeof window !== "undefined"
      ? window.location.origin
      : "https://gartify.es";
  const urlPublica = slug ? `${baseUrl}/t/${slug}` : null;

  async function copiarUrl() {
    if (!urlPublica) return;
    try {
      await navigator.clipboard.writeText(urlPublica);
      setCopiado(true);
      setTimeout(() => setCopiado(false), 2000);
    } catch {
      // Fallback para navegadores sin soporte de clipboard API
      const input = document.createElement("input");
      input.value = urlPublica;
      document.body.appendChild(input);
      input.select();
      document.execCommand("copy");
      document.body.removeChild(input);
      setCopiado(true);
      setTimeout(() => setCopiado(false), 2000);
    }
  }

  return (
    <div className="bg-white border border-gray-200 overflow-hidden mb-5">
      <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
        <div className="flex items-center gap-3">
          <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
            <Globe className="h-5 w-5 text-gartify-blue" aria-hidden="true" />
          </div>
          <div>
            <h2 className="text-base font-bold text-gartify-blue">Tu página de taller</h2>
            <p className="text-xs text-gartify-gray mt-0.5">
              URL pública para compartir con tus clientes
            </p>
          </div>
          {(plan === "PRO" || plan === "PREMIUM") && (
            <span
              className={cn(
                "ml-auto px-2.5 py-0.5 text-xs font-bold uppercase tracking-wider border",
                plan === "PREMIUM"
                  ? "bg-yellow-50 text-yellow-700 border-yellow-200"
                  : "bg-gartify-blue/5 text-gartify-blue border-gartify-blue/20"
              )}
            >
              {plan}
            </span>
          )}
        </div>
      </div>

      <div className="px-6 py-5">
        {esPremium && urlPublica ? (
          /* — Taller PRO/PREMIUM con slug generado — */
          <div className="space-y-3">
            <p className="text-sm text-gartify-gray">
              Comparte esta URL con tus clientes para que puedan ver tu perfil y reservar directamente.
            </p>
            <div className="flex items-center gap-2 flex-wrap sm:flex-nowrap">
              {/* URL con fondo destacado */}
              <div className="flex-1 min-w-0 flex items-center gap-2 px-3 py-2 bg-gray-50 border border-gray-200 text-sm text-gartify-dark font-mono overflow-hidden">
                <Globe className="h-3.5 w-3.5 text-gartify-gray shrink-0" aria-hidden="true" />
                <span className="truncate">{urlPublica}</span>
              </div>

              {/* Botón copiar */}
              <button
                type="button"
                onClick={copiarUrl}
                aria-label="Copiar URL"
                className={cn(
                  "inline-flex items-center gap-1.5 px-3 py-2 border text-sm font-semibold transition-all shrink-0",
                  copiado
                    ? "bg-green-50 border-green-200 text-green-700"
                    : "bg-white border-gray-200 text-gartify-blue hover:bg-gartify-blue/5"
                )}
              >
                {copiado ? (
                  <><Check className="h-3.5 w-3.5" aria-hidden="true" />Copiado</>
                ) : (
                  <><Copy className="h-3.5 w-3.5" aria-hidden="true" />Copiar</>
                )}
              </button>

              {/* Botón abrir */}
              <a
                href={urlPublica}
                target="_blank"
                rel="noopener noreferrer"
                className="inline-flex items-center gap-1.5 px-3 py-2 border border-gartify-blue/30 bg-gartify-blue/5 text-gartify-blue text-sm font-semibold hover:bg-gartify-blue/10 transition-colors shrink-0"
                aria-label="Ver página pública"
              >
                <ExternalLink className="h-3.5 w-3.5" aria-hidden="true" />
                Ver
              </a>
            </div>

            {/* Enlace a editar slug */}
            <p className="text-xs text-gartify-gray">
              Puedes personalizar esta URL en{" "}
              <Link href="/cuenta/taller/perfil" className="text-gartify-blue hover:underline font-medium">
                Perfil del taller
              </Link>
              .
            </p>
          </div>
        ) : esPremium && !urlPublica ? (
          /* — Taller PRO/PREMIUM sin slug todavía (migración, borde de caso) — */
          <div className="flex items-start gap-3 p-4 bg-yellow-50 border border-yellow-200">
            <Globe className="h-4 w-4 text-yellow-600 shrink-0 mt-0.5" aria-hidden="true" />
            <div>
              <p className="text-sm font-semibold text-yellow-800">Generando tu URL...</p>
              <p className="text-xs text-yellow-700 mt-0.5">
                Tu página pública se generará en breve. Si no aparece, guarda los datos en{" "}
                <Link href="/cuenta/taller/perfil" className="underline font-medium">
                  Perfil del taller
                </Link>
                .
              </p>
            </div>
          </div>
        ) : (
          /* — Taller Starter — */
          <div className="flex items-start gap-3 p-4 bg-gray-50 border border-gray-200">
            <Lock className="h-4 w-4 text-gartify-gray shrink-0 mt-0.5" aria-hidden="true" />
            <div>
              <p className="text-sm font-semibold text-gartify-dark">Disponible en el plan Pro</p>
              <p className="text-xs text-gartify-gray mt-0.5">
                Con el plan Pro obtienes una URL personalizada para compartir con tus clientes,
                aparecer en Google y recibir más reservas.
              </p>
              <Link
                href="/precios"
                className="inline-block mt-3 px-4 py-2 bg-gartify-orange hover:bg-gartify-orange/90 text-white text-xs font-bold transition-colors"
              >
                Ver planes
              </Link>
            </div>
          </div>
        )}
      </div>
    </div>
  );
}
