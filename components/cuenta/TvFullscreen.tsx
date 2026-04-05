"use client";

import { useEffect } from "react";

/**
 * TvFullscreen — Solicita pantalla completa automáticamente al montar.
 * Los navegadores solo permiten fullscreen tras un gesto del usuario,
 * pero Next.js ejecuta la navegación como una interacción, lo que lo permite.
 */
export function TvFullscreen() {
  useEffect(() => {
    if (document.fullscreenElement) return; // ya está en fullscreen
    document.documentElement.requestFullscreen().catch(() => {
      // El navegador puede rechazarlo (ej. iframes) — ignorar silenciosamente
    });

    return () => {
      if (document.fullscreenElement) {
        document.exitFullscreen().catch(() => {});
      }
    };
  }, []);

  return null;
}
