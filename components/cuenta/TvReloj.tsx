"use client";

/**
 * TvReloj — Muestra la fecha y hora actuales, actualizándose cada segundo.
 * Marcado como "use client" porque usa useState y useEffect para el reloj.
 * Solo se usa en el modo TV del taller.
 */

import { useState, useEffect } from "react";

export function TvReloj() {
  const [ahora, setAhora] = useState<Date | null>(null);

  // Inicializamos en el cliente para evitar hydration mismatch
  useEffect(() => {
    setAhora(new Date());
    const intervalo = setInterval(() => setAhora(new Date()), 1_000);
    return () => clearInterval(intervalo);
  }, []);

  // Mientras hidrata, renderizamos un placeholder del mismo ancho
  if (!ahora) {
    return (
      <div className="flex flex-col items-end gap-0.5 min-w-[140px]">
        <span className="h-6 w-28 rounded bg-white/10 animate-pulse" />
        <span className="h-4 w-20 rounded bg-white/10 animate-pulse" />
      </div>
    );
  }

  const hora = new Intl.DateTimeFormat("es-ES", {
    hour:   "2-digit",
    minute: "2-digit",
    second: "2-digit",
    hour12: false,
  }).format(ahora);

  const fecha = new Intl.DateTimeFormat("es-ES", {
    weekday: "long",
    day:     "numeric",
    month:   "long",
  }).format(ahora);

  return (
    <div className="flex flex-col items-end gap-0.5 tabular-nums">
      <span className="text-xl font-black text-white tracking-tight leading-none">
        {hora}
      </span>
      <span className="text-xs text-slate-400 capitalize">
        {fecha}
      </span>
    </div>
  );
}
