"use client";

import { useEffect } from "react";

/**
 * Dispara window.print() 800ms después de montar el componente,
 * dando tiempo al navegador a terminar de renderizar la página.
 * No renderiza ningún elemento visible.
 */
export function PrintTrigger() {
  useEffect(() => {
    const temporizador = setTimeout(() => window.print(), 800);
    return () => clearTimeout(temporizador);
  }, []);

  return null;
}
