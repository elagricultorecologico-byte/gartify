"use client";

/**
 * TvAutoRefresh — Llama a router.refresh() cada 30 segundos de forma silenciosa.
 * No renderiza nada visible. Se usa exclusivamente en el modo TV del taller
 * para mantener los datos de reservas actualizados sin recargar la página completa.
 */

import { useEffect } from "react";
import { useRouter } from "next/navigation";

const INTERVALO_MS = 30_000; // 30 segundos

export function TvAutoRefresh() {
  const router = useRouter();

  useEffect(() => {
    const intervalo = setInterval(() => {
      // refresh() re-ejecuta los Server Components de la ruta actual
      // sin perder el estado del cliente ni producir parpadeo visual
      router.refresh();
    }, INTERVALO_MS);

    return () => clearInterval(intervalo);
  }, [router]);

  // No renderiza ningún elemento en el DOM
  return null;
}
