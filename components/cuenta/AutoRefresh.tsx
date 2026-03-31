"use client";

import { useEffect, useRef, useState, useCallback } from "react";
import { useRouter } from "next/navigation";
import { RefreshCw } from "lucide-react";
import { cn } from "@/lib/utils";

// Intervalo de polling en segundos
const INTERVALO_SEGUNDOS = 30;

export function AutoRefresh() {
  const router = useRouter();
  const [segundosRestantes, setSegundosRestantes] = useState(INTERVALO_SEGUNDOS);
  const [refrescando, setRefrescando] = useState(false);

  // Referencia al timeout de "refrescando" para limpiarlo si hace falta
  const timeoutRefrescandoRef = useRef<ReturnType<typeof setTimeout> | null>(null);

  // Función reutilizable para ejecutar el refresh y resetear el contador
  const ejecutarRefresh = useCallback(() => {
    setRefrescando(true);
    router.refresh();

    // Tras 800ms damos el estado visual por completado y reseteamos el contador
    if (timeoutRefrescandoRef.current) {
      clearTimeout(timeoutRefrescandoRef.current);
    }
    timeoutRefrescandoRef.current = setTimeout(() => {
      setRefrescando(false);
      setSegundosRestantes(INTERVALO_SEGUNDOS);
    }, 800);
  }, [router]);

  // Cuenta regresiva cada segundo + polling automático cada INTERVALO_SEGUNDOS
  useEffect(() => {
    const intervaloContador = setInterval(() => {
      setSegundosRestantes((prev) => {
        if (prev <= 1) {
          // Ejecutamos el refresh cuando el contador llega a 0
          ejecutarRefresh();
          return INTERVALO_SEGUNDOS;
        }
        return prev - 1;
      });
    }, 1000);

    return () => {
      clearInterval(intervaloContador);
      if (timeoutRefrescandoRef.current) {
        clearTimeout(timeoutRefrescandoRef.current);
      }
    };
  }, [ejecutarRefresh]);

  return (
    <div className="flex items-center gap-2 text-xs text-muted-foreground select-none">
      <RefreshCw
        className={cn(
          "h-3.5 w-3.5 transition-transform",
          refrescando && "animate-spin"
        )}
        aria-hidden="true"
      />
      {refrescando ? (
        <span>Actualizando...</span>
      ) : (
        <span>
          Actualiza en{" "}
          <span className="tabular-nums font-medium">{segundosRestantes}s</span>
        </span>
      )}
      <button
        type="button"
        onClick={ejecutarRefresh}
        disabled={refrescando}
        className="ml-1 rounded px-1.5 py-0.5 hover:bg-muted hover:text-foreground transition-colors disabled:pointer-events-none disabled:opacity-50"
        aria-label="Actualizar reservas ahora"
      >
        Actualizar ahora
      </button>
    </div>
  );
}
