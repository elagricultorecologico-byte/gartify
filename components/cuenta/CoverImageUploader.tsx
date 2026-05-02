"use client";
import { useState, useRef } from "react";
import { ImagePlus, Loader2, AlertCircle } from "lucide-react";
import { cn } from "@/lib/utils";

interface PropsCoverImageUploader {
  urlActual?: string | null;
}

export function CoverImageUploader({ urlActual }: PropsCoverImageUploader) {
  const [url, setUrl]         = useState<string>(urlActual ?? "");
  const [cargando, setCargando] = useState(false);
  const [error, setError]     = useState("");
  const inputRef              = useRef<HTMLInputElement>(null);

  async function handleCambioArchivo(e: React.ChangeEvent<HTMLInputElement>) {
    const archivo = e.target.files?.[0];
    if (!archivo) return;

    setCargando(true);
    setError("");

    try {
      const form = new FormData();
      form.append("file", archivo);

      const respuesta = await fetch("/api/garage/cover-image", {
        method: "POST",
        body:   form,
      });

      const datos = await respuesta.json() as { url?: string; error?: string };

      if (respuesta.ok && datos.url) {
        setUrl(datos.url);
      } else {
        setError(datos.error ?? "Error al subir la imagen");
      }
    } catch {
      setError("Error de conexión. Inténtalo de nuevo.");
    } finally {
      setCargando(false);
      if (inputRef.current) inputRef.current.value = "";
    }
  }

  return (
    <div className="space-y-2">
      <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray">
        Imagen de portada
      </p>

      {/* Área de preview */}
      <div className="relative w-full h-36 bg-gray-100 border border-gray-200 overflow-hidden rounded-none">
        {url ? (
          // eslint-disable-next-line @next/next/no-img-element
          <img
            src={url}
            alt="Portada del taller"
            className="w-full h-full object-cover"
          />
        ) : (
          <div className="flex items-center justify-center h-full text-gray-400 text-xs">
            Sin imagen de portada
          </div>
        )}

        {/* Botón superpuesto */}
        <button
          type="button"
          onClick={() => inputRef.current?.click()}
          disabled={cargando}
          className={cn(
            "absolute bottom-2 right-2 flex items-center gap-1.5",
            "bg-white/90 hover:bg-white border border-gray-200",
            "text-xs font-semibold text-gartify-blue px-3 py-1.5 shadow-sm transition-colors",
            "disabled:opacity-50 disabled:cursor-not-allowed"
          )}
          aria-label="Cambiar imagen de portada del taller"
        >
          {cargando ? (
            <Loader2 className="h-3.5 w-3.5 animate-spin" aria-hidden="true" />
          ) : (
            <ImagePlus className="h-3.5 w-3.5" aria-hidden="true" />
          )}
          {cargando ? "Subiendo..." : "Cambiar portada"}
        </button>
      </div>

      {/* Mensaje de error */}
      {error && (
        <div
          role="alert"
          className="flex items-center gap-2 bg-red-50 border border-red-100 px-3 py-2 text-xs text-red-600"
        >
          <AlertCircle className="h-3.5 w-3.5 shrink-0" aria-hidden="true" />
          {error}
        </div>
      )}

      <p className="text-xs text-gartify-gray">
        JPG, PNG o WebP · Máx. 5 MB · Proporción recomendada 3:1 (ej. 1200×400 px)
      </p>

      {/* Input oculto */}
      <input
        ref={inputRef}
        type="file"
        accept="image/jpeg,image/png,image/webp"
        className="sr-only"
        onChange={handleCambioArchivo}
        aria-hidden="true"
        tabIndex={-1}
      />
    </div>
  );
}
