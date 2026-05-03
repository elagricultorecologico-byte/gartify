"use client";

import { useState } from "react";
import { CheckCircle } from "lucide-react";

interface Props {
  garageId: string;
}

interface CamposFormulario {
  nombre: string;
  telefono: string;
  mensaje: string;
}

const camposVacios: CamposFormulario = { nombre: "", telefono: "", mensaje: "" };

export function FormularioContacto({ garageId }: Props) {
  const [campos, setCampos] = useState<CamposFormulario>(camposVacios);
  const [enviando, setEnviando] = useState(false);
  const [enviado, setEnviado] = useState(false);
  const [error, setError] = useState<string | null>(null);

  function actualizarCampo(e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) {
    setCampos((prev) => ({ ...prev, [e.target.name]: e.target.value }));
  }

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setEnviando(true);
    setError(null);

    try {
      const respuesta = await fetch("/api/garage/contacto", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ garageId, ...campos }),
      });

      const datos: { ok?: boolean; error?: string } = await respuesta.json();

      if (!respuesta.ok || !datos.ok) {
        setError(datos.error ?? "No se pudo enviar el mensaje. Inténtalo de nuevo.");
      } else {
        setEnviado(true);
      }
    } catch {
      setError("Error de conexión. Comprueba tu red e inténtalo de nuevo.");
    } finally {
      setEnviando(false);
    }
  }

  if (enviado) {
    return (
      <div className="flex flex-col items-center gap-3 py-10 border border-gray-200 bg-white">
        <CheckCircle className="h-10 w-10 text-green-500" aria-hidden="true" />
        <p className="text-sm font-semibold text-gartify-dark">Mensaje enviado correctamente</p>
        <p className="text-xs text-gartify-gray">El taller recibirá tu mensaje y se pondrá en contacto contigo.</p>
      </div>
    );
  }

  return (
    <form onSubmit={handleSubmit} noValidate className="space-y-4">
      <div>
        <label htmlFor="contacto-nombre" className="block text-xs font-bold uppercase tracking-widest text-gartify-gray mb-1">
          Nombre <span aria-hidden="true">*</span>
        </label>
        <input
          id="contacto-nombre"
          type="text"
          name="nombre"
          required
          minLength={2}
          value={campos.nombre}
          onChange={actualizarCampo}
          autoComplete="name"
          className="border border-gray-200 px-3 py-2 text-sm w-full focus:outline-none focus:border-gartify-blue"
        />
      </div>

      <div>
        <label htmlFor="contacto-telefono" className="block text-xs font-bold uppercase tracking-widest text-gartify-gray mb-1">
          Teléfono
        </label>
        <input
          id="contacto-telefono"
          type="tel"
          name="telefono"
          value={campos.telefono}
          onChange={actualizarCampo}
          autoComplete="tel"
          placeholder="6XX XXX XXX"
          className="border border-gray-200 px-3 py-2 text-sm w-full focus:outline-none focus:border-gartify-blue"
        />
      </div>

      <div>
        <label htmlFor="contacto-mensaje" className="block text-xs font-bold uppercase tracking-widest text-gartify-gray mb-1">
          Mensaje <span aria-hidden="true">*</span>
        </label>
        <textarea
          id="contacto-mensaje"
          name="mensaje"
          required
          minLength={10}
          maxLength={1000}
          rows={5}
          value={campos.mensaje}
          onChange={actualizarCampo}
          className="border border-gray-200 px-3 py-2 text-sm w-full focus:outline-none focus:border-gartify-blue resize-none"
        />
        <p className="text-right text-xs text-gartify-gray mt-1">{campos.mensaje.length}/1000</p>
      </div>

      {error && (
        <p role="alert" className="text-sm text-red-600 border border-red-200 bg-red-50 px-3 py-2">
          {error}
        </p>
      )}

      <button
        type="submit"
        disabled={enviando}
        className="bg-gartify-blue text-white px-6 py-3 text-sm font-bold disabled:opacity-60 disabled:cursor-not-allowed hover:bg-gartify-blue/90 transition-colors"
      >
        {enviando ? "Enviando..." : "Enviar mensaje"}
      </button>
    </form>
  );
}
