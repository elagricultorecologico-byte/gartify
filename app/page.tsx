import { Suspense } from "react";
import type React from "react";
import Link from "next/link";
import Image from "next/image";
import {
  Star, Shield, Users, ChevronRight,
  CheckCircle2, BadgeCheck, Quote, AlertTriangle,
  Phone, Banknote, Clock, Eye, Smartphone, ClipboardList,
} from "lucide-react";
import { SearchBar } from "@/components/home/SearchBar";
import { Button } from "@/components/ui/button";
import { POPULAR_SERVICES } from "@/lib/constants";

// ─── Datos ────────────────────────────────────────────────────────────────────


const STATS = [
  { value: "+500",    label: "talleres verificados", icon: Shield },
  { value: "+2.000",  label: "reseñas reales",       icon: Star },
  { value: "15",      label: "provincias",            icon: Users },
  { value: "0€",      label: "comisiones al reservar",icon: CheckCircle2 },
];

const TESTIMONIALS = [
  {
    name: "Carlos Martínez",
    role: "Conductor · Madrid",
    initials: "CM",
    color: "bg-gartify-orange",
    rating: 5,
    text: "Reservé una revisión completa en 2 minutos desde el móvil. El taller me confirmó enseguida y el precio fue exactamente el que vi en la web. Sin sorpresas.",
  },
  {
    name: "Laura Sánchez",
    role: "Conductora · Valencia",
    initials: "LS",
    color: "bg-teal-500",
    rating: 5,
    text: "Nunca había sido tan fácil encontrar un taller de confianza. Vi las valoraciones de otros usuarios, comparé precios y reservé. Muy recomendable.",
  },
  {
    name: "Miguel Ángel Torres",
    role: "Conductor · Sevilla",
    initials: "MT",
    color: "bg-purple-500",
    rating: 5,
    text: "Llevaba meses aplazando la revisión por no querer llamar a talleres. Con Gartify lo hice en dos minutos desde el sofá. El taller me avisó por WhatsApp.",
  },
  {
    name: "Ana Gómez",
    role: "Conductora · Barcelona",
    initials: "AG",
    color: "bg-gartify-hero",
    rating: 5,
    text: "Me encanta poder ver el historial de revisiones de mi coche en la app. Sé exactamente qué se ha hecho y cuándo toca la próxima. Muy completo.",
  },
];


// ─── Componentes auxiliares ───────────────────────────────────────────────────


function SectionLabel({ children }: { children: React.ReactNode }) {
  return (
    <p className="inline-flex items-center gap-2 text-xs font-bold uppercase tracking-widest text-gartify-orange mb-3">
      <span className="h-px w-6 bg-gartify-orange" />
      {children}
      <span className="h-px w-6 bg-gartify-orange" />
    </p>
  );
}

// ─── Page ─────────────────────────────────────────────────────────────────────

export default function HomePage() {
  return (
    <>
      {/* ══════════════════════════════════════════════════
          1. HERO
      ══════════════════════════════════════════════════ */}
      <section className="relative overflow-hidden min-h-[560px] md:min-h-[640px] flex items-center bg-gartify-dark">
        {/* Imagen de fondo full-width */}
        <Image
          src="/portada-hero.jpeg?v=2"
          alt="Taller mecánico profesional"
          fill
          className="object-cover object-center"
          priority
        />

        {/* Overlay oscuro con gradiente izquierda → derecha */}
        <div className="absolute inset-0 bg-gradient-to-r from-gartify-dark/85 via-gartify-dark/60 to-gartify-dark/20" />

        {/* Animación de entrada hero */}
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

        {/* Contenido sobre la imagen */}
        <div className="relative w-full px-6 sm:px-10 lg:px-16 xl:px-24 py-16 md:py-24">
          <div className="max-w-2xl">
            <p className="hero-in hero-d1 inline-flex items-center gap-2 border border-white/30 bg-white/10 px-4 py-2 text-sm font-semibold text-white mb-6">
              <span className="h-2 w-2 rounded-full bg-gartify-orange animate-pulse" />
              +500 talleres verificados en España
            </p>

            <h1 className="hero-in hero-d2 text-4xl md:text-5xl lg:text-6xl font-extrabold text-white mb-6 leading-[1.1] tracking-tighter">
              Reserva tu cita en el taller ideal{" "}
              <span className="text-gartify-orange">sin llamadas ni sorpresas</span>
            </h1>

            <p className="hero-in hero-d3 text-lg text-blue-100 mb-8 leading-relaxed">
              Busca por servicio y ciudad, compara reseñas reales y confirma tu cita en segundos.
              El pago se realiza directamente en el taller.
            </p>

            <div className="hero-in hero-d4">
              <Suspense>
                <SearchBar />
              </Suspense>
            </div>

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
        </div>
      </section>

      {/* ══════════════════════════════════════════════════
          2. PAS — CONDUCTOR
      ══════════════════════════════════════════════════ */}
      <section className="py-20 bg-white">
        <div className="w-full px-6 sm:px-10 lg:px-16 xl:px-24 max-w-5xl mx-auto">

          {/* Encabezado */}
          <div className="text-center mb-14">
            <SectionLabel>Para conductores</SectionLabel>
            <h2 className="text-2xl md:text-4xl font-extrabold text-gartify-dark mb-4 leading-tight">
              ¿Llevas meses aplazando la revisión<br className="hidden md:block" /> porque no sabes a quién fiarte?
            </h2>
            <p className="text-gartify-gray max-w-xl mx-auto text-base leading-relaxed">
              No eres el único. Encontrar un taller de confianza sigue siendo innecesariamente complicado.
            </p>
          </div>

          {/* AGITACIÓN + SOLUCIÓN en dos columnas */}
          <div className="grid grid-cols-1 md:grid-cols-2 gap-0 mb-12 overflow-hidden border border-slate-200 shadow-sm">

            {/* Columna izquierda — Problema */}
            <div className="bg-slate-50 p-8 border-b md:border-b-0 md:border-r border-slate-200">
              <div className="flex items-center gap-2.5 mb-7">
                <div className="flex h-8 w-8 items-center justify-center bg-red-100 shrink-0">
                  <AlertTriangle className="h-4 w-4 text-red-500" />
                </div>
                <p className="text-xs font-bold uppercase tracking-widest text-red-500">Sin Gartify</p>
              </div>
              <ul className="space-y-5">
                {([
                  { icon: Phone,    text: "Llamas a tres talleres y ninguno te da un precio claro" },
                  { icon: Star,     text: "No sabes si las reseñas de Google son reales o compradas" },
                  { icon: Banknote, text: "Acabas pagando más de lo esperado sin entender por qué" },
                  { icon: Clock,    text: "Pierdes medio día gestionando algo que debería durar minutos" },
                ] as { icon: React.ElementType; text: string }[]).map(({ icon: Icon, text }) => (
                  <li key={text} className="flex items-start gap-3.5">
                    <div className="flex h-9 w-9 shrink-0 items-center justify-center bg-white border border-slate-200 shadow-sm">
                      <Icon className="h-4 w-4 text-red-400" aria-hidden="true" />
                    </div>
                    <div className="pt-1.5">
                      <p className="text-sm text-gartify-gray leading-snug">{text}</p>
                    </div>
                  </li>
                ))}
              </ul>
            </div>

            {/* Columna derecha — Solución */}
            <div className="bg-gartify-blue p-8 text-white">
              <div className="flex items-center gap-2.5 mb-7">
                <div className="flex h-8 w-8 items-center justify-center bg-gartify-orange/20 shrink-0">
                  <CheckCircle2 className="h-4 w-4 text-gartify-orange" />
                </div>
                <p className="text-xs font-bold uppercase tracking-widest text-gartify-orange">Con Gartify</p>
              </div>
              <ul className="space-y-5">
                {([
                  { icon: BadgeCheck,   text: "Talleres verificados con reseñas de conductores reales" },
                  { icon: Eye,          text: "Precios visibles antes de reservar, sin letra pequeña" },
                  { icon: Smartphone,   text: "Reserva en 2 minutos desde el móvil, sin llamadas" },
                  { icon: ClipboardList,text: "Historial de revisiones de tu coche siempre disponible" },
                ] as { icon: React.ElementType; text: string }[]).map(({ icon: Icon, text }) => (
                  <li key={text} className="flex items-start gap-3.5">
                    <div className="flex h-9 w-9 shrink-0 items-center justify-center bg-white/10 border border-white/20">
                      <Icon className="h-4 w-4 text-gartify-orange" aria-hidden="true" />
                    </div>
                    <div className="pt-1.5">
                      <p className="text-sm text-blue-100 leading-snug">{text}</p>
                    </div>
                  </li>
                ))}
              </ul>
            </div>
          </div>

          {/* CTA central */}
          <div className="text-center">
            <p className="text-gartify-gray text-sm mb-5">
              Más de <strong className="text-gartify-dark">500 talleres verificados</strong> te esperan. Gratis para conductores.
            </p>
            <Link href="/talleres">
              <Button size="lg" className="bg-gartify-orange hover:bg-orange-600 text-white font-bold px-10 text-base shadow-md">
                Buscar mi taller ahora
                <ChevronRight className="ml-2 h-5 w-5" />
              </Button>
            </Link>
          </div>

        </div>
      </section>


      {/* ══════════════════════════════════════════════════
          3. CÓMO FUNCIONA
      ══════════════════════════════════════════════════ */}
      <section className="bg-white">
        <div className="flex flex-col lg:flex-row min-h-[360px]">

          {/* Panel izquierdo — pasos */}
          <div className="bg-gartify-blue lg:w-72 xl:w-80 shrink-0 flex flex-col justify-center px-10 py-12">
            <p className="text-xs font-bold uppercase tracking-widest text-orange-300 mb-6">
              Simple y rápido
            </p>
            <h2 className="text-2xl md:text-3xl font-extrabold text-white mb-10 leading-snug">
              Cómo<br />funciona
            </h2>
            <ol className="space-y-6">
              {[
                { n: "1", label: "Busca",   desc: "Servicio, ciudad y tipo de vehículo" },
                { n: "2", label: "Compara", desc: "Precios reales y reseñas verificadas" },
                { n: "3", label: "Reserva", desc: "Confirma en segundos, sin llamadas" },
              ].map(({ n, label, desc }) => (
                <li key={n} className="flex items-start gap-4">
                  <span className="flex h-8 w-8 shrink-0 items-center justify-center bg-gartify-orange text-white text-sm font-extrabold">
                    {n}
                  </span>
                  <div>
                    <p className="text-white font-bold text-sm leading-tight">{label}</p>
                    <p className="text-blue-200 text-xs mt-0.5 leading-snug">{desc}</p>
                  </div>
                </li>
              ))}
            </ol>
            <Link href="/talleres" className="mt-10 inline-flex items-center gap-2 bg-gartify-orange hover:bg-orange-600 transition-colors text-white text-sm font-bold px-5 py-3 self-start">
              Buscar taller
              <ChevronRight className="h-4 w-4" />
            </Link>
          </div>

          {/* Panel derecho — cards de servicios con iconos */}
          {(() => {
            const HOW_ICONS: Record<string, React.ReactNode> = {
              ITV: (
                <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-14 w-14 text-white/80">
                  <path d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2"/>
                  <path d="M9 14l2 2 4-4" stroke="#F58B00" strokeWidth="2"/>
                  <path d="M9 10h6"/>
                </svg>
              ),
              REVISION: (
                <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-14 w-14 text-white/80">
                  <path d="M14.7 6.3a1 1 0 0 0 0 1.4l1.6 1.6a1 1 0 0 0 1.4 0l3.77-3.77a6 6 0 0 1-7.94 7.94l-6.91 6.91a2.12 2.12 0 0 1-3-3l6.91-6.91a6 6 0 0 1 7.94-7.94l-3.76 3.76z"/>
                  <path d="M9 15l-3 3" stroke="#F58B00" strokeWidth="2"/>
                </svg>
              ),
              CAMBIO_ACEITE: (
                <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-14 w-14 text-white/80">
                  <path d="M4 19h16"/>
                  <path d="M4 15V9c0-1.1.9-2 2-2h4c1.1 0 2 .9 2 2v6"/>
                  <path d="M12 9h4l2-4" stroke="#F58B00" strokeWidth="2"/>
                  <path d="M18 14c0 1.1-.9 2-2 2s-2-.9-2-2 2-4 2-4 2 2.9 2 4z" stroke="#F58B00" fill="#F58B00"/>
                  <path d="M5 11h6"/>
                </svg>
              ),
              FRENOS: (
                <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-14 w-14 text-white/80">
                  <circle cx="12" cy="12" r="9"/>
                  <circle cx="12" cy="12" r="3"/>
                  <path d="M18.36 6.64A9 9 0 0 0 12 3v4a5 5 0 0 1 3.54 1.46l2.82-1.82z" stroke="#F58B00" strokeWidth="2" fill="#F58B00"/>
                  <circle cx="12" cy="6" r="0.5" fill="currentColor"/>
                  <circle cx="12" cy="18" r="0.5" fill="currentColor"/>
                  <circle cx="6" cy="12" r="0.5" fill="currentColor"/>
                  <circle cx="18" cy="12" r="0.5" fill="currentColor"/>
                </svg>
              ),
              NEUMATICOS: (
                <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-14 w-14 text-white/80">
                  <rect x="5" y="2" width="14" height="20" rx="4"/>
                  <path d="M5 6h14M5 12h14M5 18h14"/>
                  <path d="M9 2v20M15 2v20" stroke="#F58B00" strokeWidth="2"/>
                </svg>
              ),
              DIAGNOSTICO: (
                <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-14 w-14 text-white/80">
                  <path d="M12 6V4m0 2h5a2 2 0 012 2v8a2 2 0 01-2 2h-5v2m0-2H7a2 2 0 01-2-2V8a2 2 0 012-2h5z"/>
                  <path d="M5 10H3v4h2M19 10h2v4h-2"/>
                  <circle cx="11" cy="13" r="3" stroke="#F58B00" strokeWidth="2"/>
                  <path d="M13.5 15.5L16 18" stroke="#F58B00" strokeWidth="2"/>
                </svg>
              ),
              CLIMATIZACION: (
                <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-14 w-14 text-white/80">
                  <path d="M12 2v20M2 12h20"/>
                  <path d="M4.93 4.93l14.14 14.14M19.07 4.93L4.93 19.07"/>
                  <path d="M12 6a3 3 0 00-3-3M12 18a3 3 0 003 3M6 12a3 3 0 00-3 3M18 12a3 3 0 003-3" stroke="#F58B00" strokeWidth="2"/>
                </svg>
              ),
              ELECTRICIDAD: (
                <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" strokeWidth="1.5" strokeLinecap="round" strokeLinejoin="round" className="h-14 w-14 text-white/80">
                  <rect x="3" y="7" width="18" height="13" rx="2"/>
                  <path d="M6 7V5a1 1 0 011-1h2M18 7V5a1 1 0 00-1-1h-2"/>
                  <path d="M13 10l-3 4h4l-3 4" stroke="#F58B00" strokeWidth="2" fill="#F58B00"/>
                  <path d="M6 4h4M14 4h4"/>
                </svg>
              ),
            };
            return (
              <div className="flex-1 grid grid-cols-2 sm:grid-cols-3 lg:grid-cols-3 xl:grid-cols-4 auto-rows-fr border-l border-t border-slate-100">
                {POPULAR_SERVICES.slice(0, 8).map(({ type, label, desc }) => (
                  <Link
                    key={type}
                    href={`/talleres?servicio=${type}`}
                    className="group relative flex flex-col h-full min-h-[160px] overflow-hidden border-b border-r border-slate-100 bg-gartify-blue"
                    aria-label={`Ver talleres de ${label}`}
                  >
                    {/* Icono centrado */}
                    <div className="absolute inset-0 flex items-center justify-center">
                      {HOW_ICONS[type]}
                    </div>
                    {/* Texto inferior */}
                    <div className="absolute inset-x-0 bottom-0 p-3">
                      <div className="mb-1 inline-flex items-center gap-1.5 bg-white/10 border border-white/20 px-2 py-0.5">
                        <span className="text-[10px] font-bold uppercase tracking-wide text-white">{label}</span>
                      </div>
                      <p className="text-white/70 text-xs leading-snug line-clamp-2">{desc}</p>
                    </div>
                    {/* Hover CTA */}
                    <div className="absolute inset-0 flex items-center justify-center bg-gartify-orange/90 opacity-0 group-hover:opacity-100 transition-opacity duration-300">
                      <span className="flex items-center gap-1.5 text-sm font-bold text-white">
                        Ver talleres <ChevronRight className="h-4 w-4" />
                      </span>
                    </div>
                  </Link>
                ))}
              </div>
            );
          })()}

        </div>
      </section>


      {/* ══════════════════════════════════════════════════
          6. SOCIAL PROOF
      ══════════════════════════════════════════════════ */}
      <section className="py-16 bg-white">
        <div className="w-full px-6 sm:px-10 lg:px-16 xl:px-24">

          {/* Título */}
          <div className="text-center mb-10">
            <SectionLabel>Opiniones</SectionLabel>
            <h2 className="text-2xl md:text-3xl font-bold text-gartify-dark">
              Lo que dicen nuestros conductores
            </h2>
            <p className="text-gartify-gray text-sm mt-2">Opiniones reales de usuarios de Gartify</p>
          </div>

          {/* Testimonios */}
          <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-5">
            {TESTIMONIALS.map(({ name, role, initials, color, rating, text }) => (
              <div key={name} className="flex flex-col bg-slate-50 border border-slate-200 p-5 hover:shadow-md transition-shadow">
                <Quote className="h-6 w-6 text-gartify-orange mb-3 shrink-0" aria-hidden="true" />
                <p className="text-sm text-gartify-gray leading-relaxed flex-1">{text}</p>
                <div className="flex mt-4 mb-3">
                  {Array.from({ length: rating }).map((_, i) => (
                    <Star key={i} className="h-3.5 w-3.5 fill-gartify-orange text-gartify-orange" aria-hidden="true" />
                  ))}
                </div>
                <div className="flex items-center gap-2.5 border-t border-slate-200 pt-3">
                  <div className={`h-8 w-8 ${color} flex items-center justify-center text-white text-xs font-bold shrink-0`}>
                    {initials}
                  </div>
                  <div>
                    <p className="text-sm font-semibold text-gartify-dark leading-tight">{name}</p>
                    <p className="text-xs text-gartify-gray">{role}</p>
                  </div>
                </div>
              </div>
            ))}
          </div>

          {/* Stats */}
          <div className="grid grid-cols-2 md:grid-cols-4 gap-4 mt-14">
            {STATS.map(({ value, label, icon: Icon }) => (
              <div key={label} className="flex flex-col items-center text-center bg-slate-50 border border-slate-200 p-5">
                <Icon className="h-5 w-5 text-gartify-orange mb-2" />
                <span className="text-2xl md:text-3xl font-bold text-gartify-dark">{value}</span>
                <span className="text-xs text-gartify-gray mt-0.5">{label}</span>
              </div>
            ))}
          </div>

        </div>
      </section>

    </>
  );
}
