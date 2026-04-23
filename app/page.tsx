import type React from "react";
import Link from "next/link";
import Image from "next/image";
import {
  Star, Shield, Users, ChevronRight,
  CheckCircle2, BadgeCheck, Quote, AlertTriangle,
  Phone, Banknote, Clock, Eye, Smartphone, ClipboardList,
} from "lucide-react";
import { Button } from "@/components/ui/button";
import { POPULAR_SERVICES } from "@/lib/constants";
import { db } from "@/lib/db";
import { HeroSection } from "@/components/home/HeroSection";

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

function SectionDivider() {
  return (
    <div className="flex items-center justify-center gap-3 py-2">
      <span className="h-px flex-1 max-w-xs bg-gradient-to-r from-transparent to-slate-200" />
      <span className="flex gap-1">
        <span className="h-1.5 w-1.5 rounded-full bg-gartify-orange/40" />
        <span className="h-1.5 w-1.5 rounded-full bg-gartify-orange" />
        <span className="h-1.5 w-1.5 rounded-full bg-gartify-orange/40" />
      </span>
      <span className="h-px flex-1 max-w-xs bg-gradient-to-l from-transparent to-slate-200" />
    </div>
  );
}

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

export default async function HomePage() {
  // Obtener los talleres con coordenadas para mostrarlos en el mapa del hero
  const talleresCrudos = await db.garage.findMany({
    where: { lat: { not: null }, lng: { not: null } },
    select: {
      id: true,
      name: true,
      city: true,
      address: true,
      lat: true,
      lng: true,
      rating: true,
      reviewCount: true,
      plan: true,
    },
  });

  // Forzamos los tipos de lat/lng a number (el where garantiza que no son null)
  const pinsHero = talleresCrudos.map((g) => ({
    ...g,
    lat: g.lat as number,
    lng: g.lng as number,
  }));

  return (
    <>
      {/* ══════════════════════════════════════════════════
          1. HERO
      ══════════════════════════════════════════════════ */}
      <section className="relative overflow-hidden min-h-[560px] md:min-h-[640px] flex items-center bg-gartify-dark">
        {/* Imagen de fondo full-width */}
        <Image
          src="/portada-hero.jpeg"
          alt="Taller mecánico profesional"
          fill
          className="object-cover object-center"
          priority
        />

        {/* Overlay oscuro con gradiente izquierda → derecha.
            En pantallas lg+ el gradiente llega hasta el extremo derecho para
            que el panel del mapa tenga suficiente contraste con el fondo. */}
        <div className="absolute inset-0 bg-gradient-to-r from-gartify-dark/90 via-gartify-dark/75 to-gartify-dark/55" />

        {/* Contenido sobre la imagen — HeroSection gestiona el layout de dos columnas */}
        <div className="relative w-full px-6 sm:px-10 lg:px-16 xl:px-24 py-16 md:py-24 flex justify-start">
          <HeroSection garages={pinsHero} />
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

      <SectionDivider />

      {/* ══════════════════════════════════════════════════
          3. SERVICIOS POPULARES
      ══════════════════════════════════════════════════ */}
      <section className="py-16 bg-white">
        <div className="w-full px-6 sm:px-10 lg:px-16 xl:px-24">
          <div className="text-center mb-10">
            <SectionLabel>Servicios más reservados</SectionLabel>
            <h2 className="text-2xl md:text-3xl font-bold text-gartify-dark">
              ¿Qué necesitas para tu coche?
            </h2>
          </div>

          <div className="grid grid-cols-2 sm:grid-cols-4 gap-3 max-w-4xl mx-auto">
            {POPULAR_SERVICES.slice(0, 8).map(({ type, label, icon: Icon, color }) => (
              <Link
                key={type}
                href={`/talleres?servicio=${type}`}
                className="group flex flex-col sm:flex-row items-center gap-2 sm:gap-3 border border-slate-200 bg-slate-50 hover:bg-gartify-blue/5 hover:border-gartify-blue/30 transition-all duration-200 p-3 sm:px-4 sm:py-3 text-center sm:text-left"
              >
                <div className="flex h-9 w-9 sm:h-8 sm:w-8 shrink-0 items-center justify-center bg-white shadow-sm">
                  <Icon className={`h-5 w-5 ${color}`} />
                </div>
                <span className="font-semibold text-xs sm:text-sm text-gartify-dark leading-tight">{label}</span>
              </Link>
            ))}
          </div>

          <div className="mt-8 text-center">
            <Link href="/talleres">
              <Button variant="outline" className="border-gartify-hero text-gartify-hero hover:bg-gartify-hero hover:text-white transition-colors">
                Ver todos los servicios
                <ChevronRight className="ml-2 h-4 w-4" />
              </Button>
            </Link>
          </div>
        </div>
      </section>


      <SectionDivider />

      {/* ══════════════════════════════════════════════════
          5. SOCIAL PROOF
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
