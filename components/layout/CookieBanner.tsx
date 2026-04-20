"use client";
import { useEffect, useState } from "react";
import Link from "next/link";

const STORAGE_KEY = "gartify_cookie_consent";

export function CookieBanner() {
  const [visible, setVisible] = useState(false);

  useEffect(() => {
    if (!localStorage.getItem(STORAGE_KEY)) {
      setVisible(true);
    }
  }, []);

  function accept() {
    localStorage.setItem(STORAGE_KEY, "accepted");
    setVisible(false);
  }

  function reject() {
    localStorage.setItem(STORAGE_KEY, "rejected");
    setVisible(false);
  }

  if (!visible) return null;

  return (
    <div className="fixed bottom-4 right-4 z-50 w-80 bg-white border border-gray-200 shadow-xl">
      {/* Cabecera */}
      <div className="flex items-center gap-2 px-4 py-3 border-b border-gray-100 bg-gray-50">
        <span className="text-lg" aria-hidden="true">🍪</span>
        <p className="text-sm font-bold text-gartify-dark">Tu privacidad importa</p>
      </div>

      {/* Cuerpo */}
      <div className="px-4 py-3 space-y-2">
        <p className="text-xs text-gartify-gray leading-relaxed">
          Usamos cookies propias y de terceros para mejorar tu experiencia, recordar tus preferencias
          y analizar el uso del sitio. Puedes aceptarlas todas o rechazarlas.
        </p>
        <Link
          href="/cookies"
          className="inline-block text-xs font-semibold text-gartify-blue hover:underline"
        >
          Ver política de cookies →
        </Link>
      </div>

      {/* Acciones */}
      <div className="flex gap-2 px-4 pb-4">
        <button
          onClick={reject}
          className="flex-1 py-2 text-xs font-semibold border border-gray-300 text-gartify-gray hover:bg-gray-50 transition-colors"
        >
          Rechazar
        </button>
        <button
          onClick={accept}
          className="flex-1 py-2 text-xs font-semibold bg-gartify-dark text-white hover:bg-gartify-blue transition-colors"
        >
          Aceptar todo
        </button>
      </div>
    </div>
  );
}
