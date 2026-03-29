import Link from "next/link";
import Image from "next/image";
import {
  Search, Wrench, Package, Star, Shield,
  Users, ChevronRight,
  CheckCircle2, ClipboardList, BarChart3, Upload, CalendarCheck,
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

// ─── Componente auxiliar ──────────────────────────────────────────────────────

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
      <section className="relative overflow-hidden bg-gradient-to-b from-gartify-hero to-gartify-mid py-20 md:py-28">
        <div className="absolute inset-0 pointer-events-none">
          <div className="absolute -left-20 -top-10 h-72 w-72 rounded-full bg-gartify-orange/20 blur-3xl" />
          <div className="absolute -right-16 top-1/3 h-96 w-96 rounded-full bg-white/10 blur-3xl" />
          <div className="absolute left-1/2 top-1/4 h-80 w-80 -translate-x-1/2 rounded-full bg-gartify-mid/30 blur-3xl" />
        </div>

        <div className="container max-w-6xl relative">
          <div className="grid grid-cols-1 md:grid-cols-2 gap-10 items-center">

            {/* ── Columna izquierda: texto + buscador ── */}
            <div>
              <p className="inline-flex items-center gap-2 rounded-full border border-white/30 bg-white/10 px-4 py-2 text-sm font-semibold text-white mb-6">
                <span className="h-2 w-2 rounded-full bg-gartify-orange animate-pulse" />
                +500 talleres verificados en España
              </p>

              <h1 className="text-4xl md:text-5xl font-bold text-white mb-6 leading-tight tracking-tight">
                Reserva tu cita en el taller ideal{" "}
                <span className="text-gartify-orange">sin llamadas ni sorpresas</span>
              </h1>

              <p className="text-lg text-blue-100 mb-8 leading-relaxed">
                Busca por servicio y ciudad, compara reseñas reales y confirma tu cita en segundos.
                El pago se realiza directamente en el taller.
              </p>

              <SearchBar />

              <div className="mt-6 flex flex-wrap items-center gap-5 text-sm text-white/80">
                <span className="flex items-center gap-2">
                  <span className="h-2 w-2 rounded-full bg-white" />
                  <strong className="text-white">+2.000</strong> reseñas reales
                </span>
                <span className="flex items-center gap-2">
                  <span className="h-2 w-2 rounded-full bg-white" />
                  <strong className="text-white">15</strong> provincias
                </span>
                <span className="flex items-center gap-2">
                  <span className="h-2 w-2 rounded-full bg-white" />
                  <strong className="text-white">0€</strong> comisiones
                </span>
              </div>
            </div>

            {/* ── Columna derecha: imagen ── */}
            <div className="hidden md:flex justify-center items-center">
              <div className="relative w-full max-w-lg">
                <div className="absolute inset-0 rounded-2xl bg-gartify-orange/20 blur-2xl scale-95" />
                <Image
                  src="/taller-mecanico.png"
                  alt="Mecánico trabajando en un taller"
                  width={600}
                  height={500}
                  className="relative rounded-2xl object-cover shadow-2xl w-full"
                  priority
                />
              </div>
            </div>

          </div>
        </div>

      </section>

      {/* ══════════════════════════════════════════════════
          2. PROPUESTA DE VALOR POR ROL
      ══════════════════════════════════════════════════ */}
      <section className="py-20 bg-white">
        <div className="container max-w-6xl">
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

      {/* ══════════════════════════════════════════════════
          3. SERVICIOS POPULARES
      ══════════════════════════════════════════════════ */}
      <section className="py-16 bg-slate-50">
        <div className="container max-w-5xl">
          <div className="text-center mb-10">
            <SectionLabel>Servicios más reservados</SectionLabel>
            <h2 className="text-2xl md:text-3xl font-bold text-gartify-dark">
              ¿Qué necesitas para tu coche?
            </h2>
          </div>

          <div className="grid grid-cols-4 md:grid-cols-8 gap-3">
            {POPULAR_SERVICES.map(({ type, label, icon: Icon, color }) => (
              <Link
                key={type}
                href={`/talleres?servicio=${type}`}
                className="group flex flex-col items-center gap-2 rounded-xl border border-slate-200 bg-white p-4 text-center transition-all duration-200 hover:shadow-md hover:border-gartify-blue/30 hover:-translate-y-0.5"
              >
                <div className="flex h-9 w-9 items-center justify-center rounded-full bg-slate-50 shadow-sm group-hover:scale-110 transition-transform duration-200">
                  <Icon className={`h-4 w-4 ${color}`} />
                </div>
                <span className="text-xs font-semibold text-gartify-dark leading-tight">{label}</span>
                <ChevronRight className="h-3 w-3 text-gartify-gray opacity-50 group-hover:opacity-100 group-hover:translate-x-0.5 transition-all" />
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

      {/* ══════════════════════════════════════════════════
          5. SOCIAL PROOF
      ══════════════════════════════════════════════════ */}
      <section className="py-10 bg-gradient-to-r from-gartify-hero to-gartify-mid">
        <div className="container max-w-5xl">
          <div className="text-center mb-6">
            <h2 className="text-xl md:text-2xl font-bold text-white">
              La red de talleres más grande de España
            </h2>
          </div>

          <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
            {STATS.map(({ value, label, icon: Icon }) => (
              <div
                key={label}
                className="flex flex-col items-center text-center rounded-xl bg-white/10 backdrop-blur-sm border border-white/20 p-4"
              >
                <Icon className="h-5 w-5 text-gartify-orange mb-1" />
                <span className="text-2xl md:text-3xl font-bold text-white">{value}</span>
                <span className="text-xs text-blue-200">{label}</span>
              </div>
            ))}
          </div>
        </div>
      </section>

    </>
  );
}
