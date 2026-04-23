"use client";
import { useState, Suspense } from "react";
import dynamic from "next/dynamic";
import { Star, Users, BadgeCheck, MapPin } from "lucide-react";
import { SearchBar } from "@/components/home/SearchBar";
import type { GaragePin } from "@/components/talleres/GarageMap";

// HeroMap se importa dinámicamente con SSR desactivado porque Leaflet
// usa APIs del navegador (window, document) que no existen en el servidor.
const HeroMap = dynamic(
  () => import("@/components/home/HeroMap"),
  {
    ssr: false,
    loading: () => (
      <div className="w-full h-full flex items-center justify-center bg-white/5">
        <span className="text-white/50 text-sm">Cargando mapa…</span>
      </div>
    ),
  }
);

type Props = {
  garages: GaragePin[];
};

export function HeroSection({ garages }: Props) {
  // Las coordenadas del usuario se elevan desde SearchBar para pasarlas al mapa
  const [userCoords, setUserCoords] = useState<{ lat: number; lng: number } | null>(null);

  return (
    <>
      {/* Animaciones de entrada del hero — en el mismo componente cliente para
          evitar que el <style> quede en un Server Component que no lo renderiza */}
      <style>{`
        @keyframes heroSlideIn {
          from { opacity: 0; transform: translateX(-70px); }
          to   { opacity: 1; transform: translateX(0); }
        }
        .hero-in {
          animation: heroSlideIn 0.75s cubic-bezier(0.22, 0.61, 0.36, 1) both;
        }
        .hero-d1 { animation-delay: 0ms; }
        .hero-d2 { animation-delay: 130ms; }
        .hero-d3 { animation-delay: 260ms; }
        .hero-d4 { animation-delay: 390ms; }
        .hero-d5 { animation-delay: 520ms; }
      `}</style>

      <div className="grid grid-cols-1 lg:grid-cols-[1fr_400px] gap-8 items-center w-full max-w-6xl">

        {/* ── Columna izquierda: contenido del hero ──────────────────────── */}
        <div className="max-w-2xl">
          {/* Badge */}
          <p className="hero-in hero-d1 inline-flex items-center gap-2 border border-white/30 bg-white/10 px-4 py-2 text-sm font-semibold text-white mb-6">
            <span className="h-2 w-2 rounded-full bg-gartify-orange animate-pulse" />
            +500 talleres verificados en España
          </p>

          {/* Titular principal */}
          <h1 className="hero-in hero-d2 text-4xl md:text-5xl lg:text-6xl font-extrabold text-white mb-6 leading-[1.1] tracking-tighter">
            Reserva tu cita en el taller ideal{" "}
            <span className="text-gartify-orange">sin llamadas ni sorpresas</span>
          </h1>

          {/* Descripción */}
          <p className="hero-in hero-d3 text-lg text-blue-100 mb-8 leading-relaxed">
            Busca por servicio y ciudad, compara reseñas reales y confirma tu cita en segundos.
            El pago se realiza directamente en el taller.
          </p>

          {/* SearchBar — necesita Suspense por useSearchParams */}
          <div className="hero-in hero-d4">
            <Suspense>
              <SearchBar onUserCoords={setUserCoords} />
            </Suspense>
          </div>

          {/* Stats rápidos */}
          <div className="hero-in hero-d5 mt-6 flex flex-wrap items-center gap-5 text-sm text-white">
            <span className="flex items-center gap-2">
              <Star className="h-4 w-4 text-gartify-orange shrink-0" aria-hidden="true" />
              <strong>+2.000</strong> reseñas reales
            </span>
            <span className="flex items-center gap-2">
              <Users className="h-4 w-4 text-gartify-orange shrink-0" aria-hidden="true" />
              <strong>15</strong> provincias
            </span>
            <span className="flex items-center gap-2">
              <BadgeCheck className="h-4 w-4 text-gartify-orange shrink-0" aria-hidden="true" />
              <strong>0€</strong> comisiones
            </span>
          </div>
        </div>

        {/* ── Columna derecha: panel del mapa (solo visible en lg+) ───────── */}
        <div className="hidden lg:block">
          <div className="relative h-[420px] border border-white/20 overflow-hidden bg-white/5 backdrop-blur-sm">

            {/* Badge superpuesto sobre el mapa */}
            <div
              className="absolute top-3 left-3 z-[1000] bg-gartify-dark/80 text-white text-xs px-2 py-1 flex items-center gap-1.5"
              aria-hidden="true"
            >
              <MapPin className="h-3 w-3 text-gartify-orange shrink-0" />
              Talleres en España
            </div>

            {/* Mapa Leaflet */}
            <HeroMap garages={garages} userCoords={userCoords} />
          </div>
        </div>

      </div>
    </>
  );
}
