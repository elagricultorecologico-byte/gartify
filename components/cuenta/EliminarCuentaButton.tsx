"use client";

import { useState } from "react";
import { useRouter } from "next/navigation";
import { signOut } from "next-auth/react";
import { Trash2, AlertTriangle, Loader2 } from "lucide-react";
import { Button } from "@/components/ui/button";

export function EliminarCuentaButton({ rol }: { rol: "cliente" | "taller" }) {
  const router = useRouter();
  const [fase, setFase] = useState<"idle" | "confirmar" | "loading" | "error">("idle");
  const [errorMsg, setErrorMsg] = useState("");

  async function handleEliminar() {
    setFase("loading");
    setErrorMsg("");

    const res = await fetch("/api/cuenta/eliminar", { method: "DELETE" });

    if (!res.ok) {
      const data = await res.json() as { error?: string };
      setErrorMsg(data.error ?? "Error al eliminar la cuenta");
      setFase("error");
      return;
    }

    // Cierra sesión y redirige al inicio
    await signOut({ redirect: false });
    router.push("/?baja=1");
  }

  if (fase === "idle") {
    return (
      <button
        type="button"
        onClick={() => setFase("confirmar")}
        className="flex items-center gap-1.5 text-xs text-red-400 hover:text-red-600 transition-colors"
      >
        <Trash2 className="h-3.5 w-3.5" />
        Eliminar mi cuenta
      </button>
    );
  }

  if (fase === "confirmar" || fase === "error") {
    return (
      <div className="border border-red-200 bg-red-50 p-4 space-y-3">
        <div className="flex items-start gap-2.5">
          <AlertTriangle className="h-4 w-4 text-red-500 shrink-0 mt-0.5" />
          <div>
            <p className="text-sm font-semibold text-red-700">
              ¿Eliminar tu cuenta de Gartify?
            </p>
            <p className="text-xs text-red-600 mt-0.5 leading-relaxed">
              {rol === "taller"
                ? "Se eliminarán tu taller, servicios, horarios y todos tus datos. Las reservas completadas quedarán anonimizadas. Esta acción es irreversible."
                : "Se eliminarán tu cuenta y todos tus datos personales. Tus reservas anteriores quedarán anonimizadas. Esta acción es irreversible."}
            </p>
            {fase === "error" && (
              <p className="text-xs text-red-700 font-medium mt-1">{errorMsg}</p>
            )}
          </div>
        </div>

        <div className="flex gap-2">
          <Button
            type="button"
            variant="outline"
            size="sm"
            onClick={() => { setFase("idle"); setErrorMsg(""); }}
            className="text-xs border-gray-300 text-gartify-gray"
          >
            Cancelar
          </Button>
          <Button
            type="button"
            size="sm"
            onClick={handleEliminar}
            className="text-xs bg-red-600 hover:bg-red-700 text-white gap-1.5"
          >
            <Trash2 className="h-3 w-3" />
            Sí, eliminar mi cuenta
          </Button>
        </div>
      </div>
    );
  }

  // loading
  return (
    <div className="flex items-center gap-2 text-xs text-gartify-gray">
      <Loader2 className="h-3.5 w-3.5 animate-spin" />
      Eliminando cuenta...
    </div>
  );
}
