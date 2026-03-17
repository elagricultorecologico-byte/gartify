import Link from "next/link";
import {
  Search, Wrench, Package, Star, Shield,
  Users, CalendarCheck, ChevronRight,
  CheckCircle2,
} from "lucide-react";
import { SearchBar } from "@/components/home/SearchBar";
import { Button } from "@/components/ui/button";
import { POPULAR_SERVICES } from "@/lib/constants";

// ─── Datos ────────────────────────────────────────────────────────────────────

const HOW_IT_WORKS = [
  {
    step: "1",
    icon: Search,
    title: "Busca por servicio y ciudad",
    desc: "Filtra por tipo de reparación, valoraciones y distancia. Ve precios reales antes de reservar.",
  },
  {
    step: "2",
    icon: CalendarCheck,
    title: "Elige fecha y hora",
    desc: "Selecciona el hueco que te venga bien en el calendario del taller. Sin llamadas.",
  },
  {
    step: "3",
    icon: CheckCircle2,
    title: "Acude y valora",
    desc: "Llega al taller, recibe el servicio y deja tu reseña. El pago es directo en taller.",
  },
];

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
    benefits: [
      "Compara precios antes de reservar",
      "Reseñas verificadas de clientes reales",
      "Reserva online en menos de 2 minutos",
      "Historial de servicios en tu cuenta",
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
    benefits: [
      "Perfil de taller con reseñas y servicios",
      "Gestión de reservas en tiempo real",
      "Estadísticas de rendimiento mensuales",
      "Sin comisiones por reserva recibida",
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
    benefits: [
      "Catálogo de productos con visibilidad real",
      "Contacto directo con talleres de tu zona",
      "Panel de gestión de pedidos y entregas",
      "Integración con tu ERP existente",
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

        <div className="container max-w-5xl relative">
          <div className="text-center">
            <p className="inline-flex items-center justify-center gap-2 rounded-full border border-white/30 bg-white/10 px-4 py-2 text-sm font-semibold text-white mb-6">
              <span className="h-2 w-2 rounded-full bg-gartify-orange animate-pulse" />
              +500 talleres verificados en España
            </p>

            <h1 className="text-4xl md:text-6xl font-bold text-white mb-6 leading-tight tracking-tight">
              Reserva tu cita en el taller ideal{" "}
              <br className="hidden sm:block" />
              <span className="text-gartify-orange">sin llamadas ni sorpresas</span>
            </h1>

            <p className="text-lg text-blue-100 mb-10 max-w-2xl mx-auto leading-relaxed">
              Busca por servicio y ciudad, compara reseñas reales y confirma tu cita en segundos.
              El pago se realiza directamente en el taller.
            </p>

            <div className="mx-auto max-w-2xl">
              <SearchBar className="shadow-lg" />
            </div>

            <div className="mt-8 flex flex-wrap items-center justify-center gap-6 text-sm text-white/80">
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
                <strong className="text-white">0€</strong> comisiones al reservar
              </span>
            </div>
          </div>
        </div>
      </section>

      {/* ══════════════════════════════════════════════════
          2. SERVICIOS POPULARES
      ══════════════════════════════════════════════════ */}
      <section className="py-16 bg-white">
        <div className="container max-w-5xl">
          <div className="text-center mb-10">
            <SectionLabel>Servicios más reservados</SectionLabel>
            <h2 className="text-2xl md:text-3xl font-bold text-gartify-dark">
              ¿Qué necesitas para tu coche?
            </h2>
          </div>

          <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
            {POPULAR_SERVICES.map(({ type, label, icon: Icon, color, bg, border }) => (
              <Link
                key={type}
                href={`/talleres?servicio=${type}`}
                className={`group flex flex-col items-center gap-3 rounded-xl border ${border} ${bg} p-6 text-center transition-all duration-200 hover:shadow-md hover:-translate-y-0.5`}
              >
                <div className="flex h-12 w-12 items-center justify-center rounded-full bg-white shadow-sm group-hover:scale-110 transition-transform duration-200">
                  <Icon className={`h-6 w-6 ${color}`} />
                </div>
                <span className={`text-sm font-semibold ${color}`}>{label}</span>
                <ChevronRight className={`h-4 w-4 ${color} opacity-50 group-hover:opacity-100 group-hover:translate-x-0.5 transition-all`} />
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
          3. PROPUESTA DE VALOR POR ROL
      ══════════════════════════════════════════════════ */}
      <section className="py-20 bg-slate-50">
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
            {ROLE_DATA.map(({ id, label, icon: Icon, color, bg, borderTop, accentClass, headline, subheadline, benefits, cta, href }) => (
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

                <p className="text-sm text-gartify-gray mb-6 leading-relaxed flex-1">
                  {subheadline}
                </p>

                <ul className="space-y-2.5 mb-8">
                  {benefits.map((benefit) => (
                    <li key={benefit} className="flex items-start gap-2.5 text-sm text-gartify-dark">
                      <CheckCircle2 className={`mt-0.5 h-4 w-4 shrink-0 ${color}`} />
                      {benefit}
                    </li>
                  ))}
                </ul>

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
          4. CÓMO FUNCIONA
      ══════════════════════════════════════════════════ */}
      <section className="py-20 bg-white">
        <div className="container max-w-4xl">
          <div className="text-center mb-14">
            <SectionLabel>Tan fácil como esto</SectionLabel>
            <h2 className="text-2xl md:text-3xl font-bold text-gartify-dark">
              Reserva en 3 pasos
            </h2>
          </div>

          <div className="grid md:grid-cols-3 gap-8 relative">
            <div className="hidden md:block absolute top-10 left-[calc(16.67%+1rem)] right-[calc(16.67%+1rem)] h-px bg-gradient-to-r from-gartify-hero via-gartify-mid to-gartify-green" />

            {HOW_IT_WORKS.map(({ step, icon: Icon, title, desc }) => (
              <div key={step} className="flex flex-col items-center text-center relative">
                <div className="relative mb-6">
                  <div className="flex h-20 w-20 items-center justify-center rounded-full bg-gartify-hero shadow-lg shadow-gartify-hero/25">
                    <Icon className="h-8 w-8 text-white" />
                  </div>
                  <span className="absolute -top-1 -right-1 flex h-6 w-6 items-center justify-center rounded-full bg-gartify-orange text-xs font-bold text-white shadow">
                    {step}
                  </span>
                </div>
                <h3 className="font-bold text-gartify-dark mb-2">{title}</h3>
                <p className="text-sm text-gartify-gray leading-relaxed">{desc}</p>
              </div>
            ))}
          </div>

          <div className="mt-12 text-center">
            <Link href="/como-funciona">
              <Button variant="ghost" className="text-gartify-hero hover:text-gartify-hero hover:bg-gartify-hero/10">
                Ver guía completa
                <ChevronRight className="ml-2 h-4 w-4" />
              </Button>
            </Link>
          </div>
        </div>
      </section>

      {/* ══════════════════════════════════════════════════
          5. SOCIAL PROOF
      ══════════════════════════════════════════════════ */}
      <section className="py-20 bg-gradient-to-r from-gartify-hero to-gartify-mid">
        <div className="container max-w-5xl">
          <div className="text-center mb-14">
            <h2 className="text-2xl md:text-3xl font-bold text-white">
              La plataforma en la que confía España
            </h2>
          </div>

          <div className="grid grid-cols-2 md:grid-cols-4 gap-6">
            {STATS.map(({ value, label, icon: Icon }) => (
              <div
                key={label}
                className="flex flex-col items-center text-center rounded-2xl bg-white/10 backdrop-blur-sm border border-white/20 p-6"
              >
                <Icon className="h-7 w-7 text-gartify-orange mb-3" />
                <span className="text-3xl md:text-4xl font-bold text-white mb-1">{value}</span>
                <span className="text-sm text-blue-200">{label}</span>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* ══════════════════════════════════════════════════
          6. CTA DUAL DE CIERRE
      ══════════════════════════════════════════════════ */}
      <section className="py-24 bg-gartify-dark">
        <div className="container max-w-4xl text-center">
          <p className="text-xs font-bold uppercase tracking-widest text-gartify-orange mb-4">
            Empieza hoy
          </p>
          <h2 className="text-3xl md:text-4xl font-bold text-white mb-4 leading-tight">
            ¿Listo para encontrar tu taller
            <br />o captar más clientes?
          </h2>
          <p className="text-blue-300 mb-10 max-w-lg mx-auto">
            Únete a la red de talleres y conductores más transparente de España.
            Gratuito para empezar.
          </p>

          <div className="flex flex-col sm:flex-row items-center justify-center gap-4">
            <Link href="/talleres">
              <Button size="lg" className="w-full sm:w-auto bg-gartify-orange hover:bg-gartify-orange/90 text-white font-bold px-8 h-12">
                <Search className="mr-2 h-5 w-5" />
                Buscar taller ahora
              </Button>
            </Link>
            <Link href="/registro">
              <Button size="lg" variant="outline" className="w-full sm:w-auto border-white/30 text-white bg-white/10 hover:bg-white/20 hover:border-white/50 font-semibold px-8 h-12">
                <Wrench className="mr-2 h-5 w-5" />
                Registrar mi taller
              </Button>
            </Link>
          </div>

          <p className="mt-6 text-xs text-blue-400">
            ¿Eres distribuidor de recambios?{" "}
            <Link href="/contacto" className="text-gartify-green hover:text-gartify-green/80 underline underline-offset-2">
              Solicita acceso al programa de proveedores
            </Link>
          </p>
        </div>
      </section>
    </>
  );
}
