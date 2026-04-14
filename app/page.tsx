import { Suspense } from "react";
import Link from "next/link";
import Image from "next/image";
import {
  Search, Wrench, Package, Star, Shield,
  Users, ChevronRight,
  CheckCircle2, ClipboardList, BarChart3, Upload, CalendarCheck,
  BadgeCheck, Quote,
} from "lucide-react";
import { SearchBar } from "@/components/home/SearchBar";
import { Button } from "@/components/ui/button";
import { POPULAR_SERVICES } from "@/lib/constants";

// ─── Datos ────────────────────────────────────────────────────────────────────

const GARANTIAS = [
  {
    icon: BadgeCheck,
    color: "text-gartify-hero",
    bg: "bg-gartify-hero/10",
    title: "Talleres verificados",
    desc: "Cada taller pasa un proceso de verificación antes de aparecer en Gartify. Solo los mejores.",
  },
  {
    icon: Shield,
    color: "text-gartify-orange",
    bg: "bg-gartify-orange/10",
    title: "Precio sin letra pequeña",
    desc: "Consulta tarifas reales antes de reservar. El precio que ves es el que pagas en el taller.",
  },
  {
    icon: Star,
    color: "text-yellow-500",
    bg: "bg-yellow-50",
    title: "Reseñas de clientes reales",
    desc: "Solo opinan conductores que han completado el servicio. Sin reseñas falsas ni compradas.",
  },
  {
    icon: CalendarCheck,
    color: "text-teal-600",
    bg: "bg-teal-50",
    title: "Reserva en 2 minutos",
    desc: "Sin llamadas, sin esperas. Elige fecha y hora, y confirma tu cita directamente desde el móvil.",
  },
];

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

const ROLE_DATA = [
  {
    id: "cliente",
    label: "Soy conductor",
    icon: Search,
    color: "text-gartify-hero",
    bg: "bg-gartify-hero/10",
    borderTop: "border-t-[4px] border-t-gartify-hero",
    accentClass: "bg-gartify-hero hover:bg-gartify-hero/90",
    headline: "Tu coche, en buenas manos",
    subheadline: "Reserva cita en talleres verificados con reseñas reales y precios transparentes. Sin sorpresas.",
    steps: [
      { icon: Search,        text: "Busca por servicio y ciudad" },
      { icon: CalendarCheck, text: "Elige fecha y hora sin llamadas" },
      { icon: CheckCircle2,  text: "Acude, recibe el servicio y valora" },
    ],
    cta: "Buscar taller",
    href: "/talleres",
  },
  {
    id: "taller",
    label: "Tengo un taller",
    icon: Wrench,
    color: "text-gartify-orange",
    bg: "bg-gartify-orange/10",
    borderTop: "border-t-[4px] border-t-gartify-orange",
    accentClass: "bg-gartify-orange hover:bg-gartify-orange/90",
    headline: "Llena tu agenda sin esfuerzo",
    subheadline: "Conecta con conductores de tu zona que buscan exactamente tus servicios. Gestiona todo desde tu portal.",
    steps: [
      { icon: Wrench,        text: "Crea tu perfil y añade servicios" },
      { icon: ClipboardList, text: "Recibe y gestiona reservas online" },
      { icon: BarChart3,     text: "Consulta estadísticas y reseñas" },
    ],
    cta: "Registrar mi taller",
    href: "/registro",
  },
  {
    id: "proveedor",
    label: "Soy distribuidor",
    icon: Package,
    color: "text-gartify-green",
    bg: "bg-gartify-green/10",
    borderTop: "border-t-[4px] border-t-gartify-green",
    accentClass: "bg-gartify-green hover:bg-gartify-green/90",
    headline: "Vende recambios a la red de talleres",
    subheadline: "Accede a cientos de talleres verificados que necesitan recambios. Canal B2B directo y sin intermediarios.",
    steps: [
      { icon: Upload,        text: "Sube tu catálogo de productos" },
      { icon: Package,       text: "Los talleres encuentran tus piezas" },
      { icon: ClipboardList, text: "Gestiona pedidos desde tu panel" },
    ],
    cta: "Solicitar acceso",
    href: "/contacto",
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

export default function HomePage() {
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
            <p className="hero-in hero-d1 inline-flex items-center gap-2 rounded-full border border-white/30 bg-white/10 px-4 py-2 text-sm font-semibold text-white mb-6">
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
          2. PROPUESTA DE VALOR POR ROL
      ══════════════════════════════════════════════════ */}
      <section className="py-20 bg-white">
        <div className="w-full px-6 sm:px-10 lg:px-16 xl:px-24">
          <div className="text-center mb-14">
            <SectionLabel>Para cada perfil</SectionLabel>
            <h2 className="text-2xl md:text-3xl font-bold text-gartify-dark mb-4">
              Gartify funciona para todos
            </h2>
            <p className="text-gartify-gray max-w-xl mx-auto">
              Tanto si buscas taller como si tienes uno, o distribuyes recambios,
              Gartify tiene una solución pensada para ti.
            </p>
          </div>

          <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
            {ROLE_DATA.map(({ id, label, icon: Icon, color, bg, borderTop, accentClass, headline, subheadline, steps, cta, href }) => (
              <div
                key={id}
                className={`flex flex-col rounded-2xl border border-slate-200 bg-white p-8 shadow-sm ${borderTop} hover:shadow-lg transition-shadow duration-300`}
              >
                <div className={`mb-5 flex h-14 w-14 items-center justify-center rounded-2xl ${bg}`}>
                  <Icon className={`h-7 w-7 ${color}`} />
                </div>

                <p className={`text-xs font-bold uppercase tracking-widest ${color} mb-2`}>
                  {label}
                </p>

                <h3 className="text-xl font-bold text-gartify-dark mb-3 leading-snug">
                  {headline}
                </h3>

                <p className="text-sm text-gartify-gray mb-6 leading-relaxed">
                  {subheadline}
                </p>

                <ol className="space-y-3 mb-8 flex-1">
                  {steps.map(({ icon: StepIcon, text }, i) => (
                    <li key={i} className="flex items-center gap-3 text-sm text-gartify-dark">
                      <span className={`flex h-6 w-6 shrink-0 items-center justify-center rounded-full text-xs font-bold text-white ${accentClass}`}>
                        {i + 1}
                      </span>
                      <StepIcon className={`h-4 w-4 shrink-0 ${color}`} />
                      {text}
                    </li>
                  ))}
                </ol>

                <Link href={href}>
                  <Button className={`w-full text-white font-semibold ${accentClass}`}>
                    {cta}
                    <ChevronRight className="ml-2 h-4 w-4" />
                  </Button>
                </Link>
              </div>
            ))}
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
                className="group flex flex-col sm:flex-row items-center gap-2 sm:gap-3 rounded-xl border border-slate-200 bg-slate-50 hover:bg-gartify-blue/5 hover:border-gartify-blue/30 transition-all duration-200 p-3 sm:px-4 sm:py-3 text-center sm:text-left"
              >
                <div className="flex h-9 w-9 sm:h-8 sm:w-8 shrink-0 items-center justify-center rounded-md bg-white shadow-sm">
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
          4. CADENAS DE REFERENCIA
      ══════════════════════════════════════════════════ */}
      <section className="py-14 bg-white">
        <div className="w-full px-6 sm:px-10 lg:px-16 xl:px-24">
          <div className="text-center mb-10">
            <SectionLabel>Por qué Gartify</SectionLabel>
            <h2 className="text-2xl md:text-3xl font-bold text-gartify-dark mb-3">
              La forma más inteligente de{" "}
              <span className="text-gartify-blue">cuidar tu coche</span>
            </h2>
            <p className="text-gartify-gray max-w-2xl mx-auto text-sm leading-relaxed">
              Conectamos conductores con talleres de confianza. Transparencia, comodidad y cero sorpresas en cada reserva.
            </p>
          </div>

          <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-5 max-w-4xl mx-auto">
            {GARANTIAS.map(({ icon: Icon, color, bg, title, desc }) => (
              <div key={title} className="flex flex-col gap-3 rounded-2xl border border-slate-200 bg-slate-50 p-5 hover:shadow-md transition-shadow">
                <div className={`flex h-11 w-11 items-center justify-center rounded-xl ${bg}`}>
                  <Icon className={`h-5 w-5 ${color}`} aria-hidden="true" />
                </div>
                <h3 className="font-bold text-gartify-dark text-sm leading-snug">{title}</h3>
                <p className="text-xs text-gartify-gray leading-relaxed">{desc}</p>
              </div>
            ))}
          </div>

          <div className="mt-8 text-center">
            <Link href="/talleres">
              <Button className="bg-gartify-blue hover:bg-gartify-blue/90 text-white font-semibold">
                Buscar taller ahora
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
              <div key={name} className="flex flex-col bg-slate-50 border border-slate-200 rounded-2xl p-5 hover:shadow-md transition-shadow">
                <Quote className="h-6 w-6 text-gartify-orange mb-3 shrink-0" aria-hidden="true" />
                <p className="text-sm text-gartify-gray leading-relaxed flex-1">{text}</p>
                <div className="flex mt-4 mb-3">
                  {Array.from({ length: rating }).map((_, i) => (
                    <Star key={i} className="h-3.5 w-3.5 fill-gartify-orange text-gartify-orange" aria-hidden="true" />
                  ))}
                </div>
                <div className="flex items-center gap-2.5 border-t border-slate-200 pt-3">
                  <div className={`h-8 w-8 rounded-full ${color} flex items-center justify-center text-white text-xs font-bold shrink-0`}>
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
              <div key={label} className="flex flex-col items-center text-center rounded-xl bg-slate-50 border border-slate-200 p-5">
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
