"use client";

import { useState } from "react";
import { Phone } from "lucide-react";

// ─── Tipos internos ───────────────────────────────────────────────────────────

interface CamposFormulario {
  nombre: string;
  nombreTaller: string;
  telefono: string;
}

// ─── Componente ───────────────────────────────────────────────────────────────

export function LeadForm() {
  const [campos, setCampos] = useState<CamposFormulario>({
    nombre: "",
    nombreTaller: "",
    telefono: "",
  });
  const [enviado, setEnviado] = useState(false);
  const [enviando, setEnviando] = useState(false);

  function handleChange(e: React.ChangeEvent<HTMLInputElement>) {
    const { name, value } = e.target;
    setCampos((prev) => ({ ...prev, [name]: value }));
  }

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();

    // Validación básica en cliente antes de enviar
    if (!campos.nombre.trim() || !campos.nombreTaller.trim() || !campos.telefono.trim()) {
      return;
    }

    setEnviando(true);

    // Simulamos el envío del lead (aquí se conectaría a una API route real)
    await new Promise<void>((resolve) => setTimeout(resolve, 800));

    setEnviando(false);
    setEnviado(true);
  }

  // ── Estado: confirmación de envío ─────────────────────────────────────────
  if (enviado) {
    return (
      <div className="rounded-2xl bg-gartify-green/20 border border-gartify-green/40 p-8 text-center">
        <div className="inline-flex h-14 w-14 items-center justify-center rounded-full bg-gartify-green/20 border border-gartify-green/40 mb-4">
          <Phone className="h-7 w-7 text-gartify-green" aria-hidden="true" />
        </div>
        <h3 className="text-white text-xl font-bold mb-2">
          ¡Perfecto! Te llamamos en menos de 24 horas.
        </h3>
        <p className="text-blue-200 text-sm">
          Hemos recibido tus datos. Un especialista de Gartify se pondrá en
          contacto contigo para completar el alta de tu taller.
        </p>
      </div>
    );
  }

  // ── Estado: formulario ────────────────────────────────────────────────────
  return (
    <form
      onSubmit={handleSubmit}
      className="rounded-2xl bg-white/5 border border-white/10 p-6 md:p-8 space-y-4"
      noValidate
    >
      {/* Campo: nombre del responsable */}
      <div>
        <label
          htmlFor="lead-nombre"
          className="block text-sm font-semibold text-blue-200 mb-1.5"
        >
          Tu nombre
        </label>
        <input
          id="lead-nombre"
          name="nombre"
          type="text"
          autoComplete="given-name"
          placeholder="Ej: Carlos García"
          value={campos.nombre}
          onChange={handleChange}
          required
          className="w-full rounded-xl bg-white/10 border border-white/20 px-4 py-3 text-white placeholder:text-blue-300/50 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-orange focus:border-transparent transition"
        />
      </div>

      {/* Campo: nombre del taller */}
      <div>
        <label
          htmlFor="lead-nombre-taller"
          className="block text-sm font-semibold text-blue-200 mb-1.5"
        >
          Nombre del taller
        </label>
        <input
          id="lead-nombre-taller"
          name="nombreTaller"
          type="text"
          autoComplete="organization"
          placeholder="Ej: Taller García Automóviles"
          value={campos.nombreTaller}
          onChange={handleChange}
          required
          className="w-full rounded-xl bg-white/10 border border-white/20 px-4 py-3 text-white placeholder:text-blue-300/50 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-orange focus:border-transparent transition"
        />
      </div>

      {/* Campo: teléfono */}
      <div>
        <label
          htmlFor="lead-telefono"
          className="block text-sm font-semibold text-blue-200 mb-1.5"
        >
          Teléfono de contacto
        </label>
        <input
          id="lead-telefono"
          name="telefono"
          type="tel"
          autoComplete="tel"
          placeholder="Ej: 612 345 678"
          value={campos.telefono}
          onChange={handleChange}
          required
          className="w-full rounded-xl bg-white/10 border border-white/20 px-4 py-3 text-white placeholder:text-blue-300/50 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-orange focus:border-transparent transition"
        />
      </div>

      {/* Botón de envío */}
      <button
        type="submit"
        disabled={enviando}
        className="w-full flex items-center justify-center gap-2 rounded-xl bg-gartify-orange px-6 py-4 text-white font-bold text-base hover:bg-orange-600 disabled:opacity-60 disabled:cursor-not-allowed transition-colors focus:outline-none focus:ring-2 focus:ring-gartify-orange focus:ring-offset-2 focus:ring-offset-gartify-dark mt-2"
      >
        <Phone className="h-5 w-5" aria-hidden="true" />
        {enviando ? "Enviando..." : "LLÁMADME para empezar"}
      </button>

      <p className="text-center text-xs text-blue-400">
        Solo usamos tu teléfono para contactarte. Sin spam.
      </p>
    </form>
  );
}
