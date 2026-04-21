import type { Metadata } from "next";
import Link from "next/link";
import { Button } from "@/components/ui/button";
import {
  Search, MapPin, Star, CalendarCheck, Clock, Phone,
  Car, ShieldCheck, Euro, ThumbsUp, ChevronRight, ChevronDown,
  Wrench, Users, TrendingUp, Bell, BarChart3, Settings,
} from "lucide-react";

// ─── Metadata ─────────────────────────────────────────────────────────────────

export const metadata: Metadata = {
  title: "¿Cómo funciona Gartify?",
  description:
    "Reserva cita en talleres mecánicos en 4 pasos. Busca, compara precios, elige horario y paga en el taller. Sin comisiones. 100% transparente.",
  openGraph: {
    title: "¿Cómo funciona Gartify?",
    description:
      "Reserva cita en talleres mecánicos en 4 pasos. Busca, compara precios, elige horario y paga en el taller.",
  },
  alternates: { canonical: "/como-funciona" },
};

// ─── Steps for drivers ────────────────────────────────────────────────────────

const DRIVER_STEPS = [
  {
    step: "01",
    icon: Search,
    color: "bg-gartify-hero",
    title: "Busca el servicio que necesitas",
    desc: "Introduce tu ciudad y el tipo de servicio — ITV, revisión, frenos, neumáticos, diagnóstico… Nuestro buscador filtra los talleres más cercanos y relevantes en segundos.",
    details: [
      { icon: MapPin, text: "Filtra por ciudad o código postal" },
      { icon: Wrench, text: "Elige entre más de 10 tipos de servicio" },
      { icon: Star,   text: "Ordena por precio, valoración o distancia" },
    ],
  },
  {
    step: "02",
    icon: Star,
    color: "bg-gartify-mid",
    title: "Compara talleres con total transparencia",
    desc: "Cada taller muestra sus precios reales, fotos, servicios disponibles y reseñas verificadas de otros conductores. Sin letra pequeña, sin sorpresas.",
    details: [
      { icon: Euro,        text: "Precios publicados de antemano" },
      { icon: ShieldCheck, text: "Talleres verificados por Gartify" },
      { icon: ThumbsUp,    text: "Reseñas reales de clientes" },
    ],
  },
  {
    step: "03",
    icon: CalendarCheck,
    color: "bg-gartify-green",
    title: "Reserva tu cita en menos de 2 minutos",
    desc: "Selecciona el servicio, elige día y hora entre los disponibles, indica tu matrícula y listo. Recibirás confirmación por email al instante.",
    details: [
      { icon: Clock, text: "Franjas de 30 min disponibles en tiempo real" },
      { icon: Car,   text: "Añade matrícula y modelo de tu vehículo" },
      { icon: Bell,  text: "Email de confirmación automático" },
    ],
  },
  {
    step: "04",
    icon: Car,
    color: "bg-gartify-orange",
    title: "Lleva tu coche y paga en el taller",
    desc: "El día acordado, simplemente acude al taller. El mecánico ya sabe que llegas. El pago se realiza directamente en el taller al recoger tu vehículo — sin prepago online.",
    details: [
      { icon: Phone,       text: "El taller confirma y puede contactarte" },
      { icon: Euro,        text: "Pagas el precio acordado, sin comisiones extra" },
      { icon: ShieldCheck, text: "Precio garantizado: el que viste en la web" },
    ],
  },
];

// ─── Steps for garages ────────────────────────────────────────────────────────

const GARAGE_STEPS = [
  {
    step: "01",
    icon: Settings,
    title: "Crea tu perfil en 5 minutos",
    desc: "Registra tu taller con nombre, dirección, teléfono y descripción. Añade los servicios que ofreces con tus precios reales.",
  },
  {
    step: "02",
    icon: Users,
    title: "Recibe clientes nuevos",
    desc: "Tu taller aparece en los resultados de búsqueda de conductores que buscan exactamente lo que tú ofreces en tu zona.",
  },
  {
    step: "03",
    icon: Bell,
    title: "Gestiona reservas online",
    desc: "Recibe notificaciones por email con cada nueva reserva. Confirma, completa o gestiona citas desde tu portal en cualquier momento.",
  },
  {
    step: "04",
    icon: TrendingUp,
    title: "Aumenta tu visibilidad",
    desc: "Las reseñas positivas de tus clientes mejoran tu posición. Más visibilidad, más reservas, más ingresos.",
  },
];

// ─── FAQs ─────────────────────────────────────────────────────────────────────

const FAQS = [
  {
    q: "¿Gartify cobra algo al reservar?",
    a: "No. Gartify es completamente gratuito para los conductores. Pagas el servicio directamente al taller al recoger tu vehículo, sin comisiones ni cargos adicionales.",
  },
  {
    q: "¿Puedo cancelar una reserva?",
    a: "Sí, puedes cancelar tu reserva desde 'Mis reservas' en tu cuenta. Te recomendamos avisar con al menos 24 horas de antelación para no perjudicar al taller.",
  },
  {
    q: "¿Los precios son los definitivos?",
    a: "Los precios publicados por los talleres son orientativos para el servicio base. En casos específicos (piezas adicionales, trabajo extra detectado), el taller te informará antes de proceder.",
  },
  {
    q: "¿Cómo sé que los talleres son de confianza?",
    a: "Verificamos los datos de cada taller antes de publicarlo. Además, las reseñas solo pueden escribirlas usuarios que hayan realizado una reserva real, garantizando su autenticidad.",
  },
  {
    q: "¿Qué pasa si el taller no confirma mi reserva?",
    a: "Recibirás una notificación por email con el estado de tu reserva. Si el taller no confirma en 24h, puedes contactarles directamente o buscar otra alternativa en Gartify.",
  },
  {
    q: "Soy propietario de un taller, ¿cuánto cuesta unirme?",
    a: "El registro y la presencia en Gartify es gratuita durante el lanzamiento. Solo pagas si quieres opciones de visibilidad premium en el futuro.",
  },
];

// ─── JSON-LD ──────────────────────────────────────────────────────────────────

const jsonLd = {
  "@context": "https://schema.org",
  "@graph": [
    {
      "@type": "BreadcrumbList",
      itemListElement: [
        { "@type": "ListItem", position: 1, name: "Inicio",          item: "https://gartify.es" },
        { "@type": "ListItem", position: 2, name: "¿Cómo funciona?", item: "https://gartify.es/como-funciona" },
      ],
    },
    {
      "@type": "HowTo",
      name: "¿Cómo reservar cita en Gartify?",
      description: "Reserva tu cita en un taller mecánico en 4 pasos con Gartify. Busca, compara, reserva y paga en el taller.",
      step: DRIVER_STEPS.map((s) => ({
        "@type": "HowToStep",
        position: parseInt(s.step),
        name: s.title,
        text: s.desc,
      })),
    },
    {
      "@type": "FAQPage",
      mainEntity: FAQS.map(({ q, a }) => ({
        "@type": "Question",
        name: q,
        acceptedAnswer: { "@type": "Answer", text: a },
      })),
    },
  ],
};

// ─── Page ─────────────────────────────────────────────────────────────────────

export default function ComoFuncionaPage() {
  return (
    <>
      <script
        type="application/ld+json"
        dangerouslySetInnerHTML={{ __html: JSON.stringify(jsonLd) }}
      />

      <div>

        {/* ── Hero ── */}
        <section className="bg-gradient-to-br from-gartify-hero to-gartify-mid py-20 text-center px-4">
          <div className="container max-w-3xl">
            <span className="inline-flex items-center gap-2 rounded-full border border-gartify-orange/50 bg-gartify-orange/20 px-4 py-1.5 text-sm text-gartify-orange mb-6">
              <Star className="h-3.5 w-3.5 fill-current" />
              Sencillo, rápido y transparente
            </span>
            <h1 className="text-4xl md:text-5xl font-bold text-white mb-5 leading-tight">
              ¿Cómo funciona<br />
              <span className="text-gartify-orange">Gartify?</span>
            </h1>
            <p className="text-lg text-blue-100 max-w-xl mx-auto mb-6">
              Reservar cita en un taller mecánico nunca había sido tan fácil. En 4 pasos tienes tu cita confirmada.
            </p>
            {/* Social proof stats */}
            <div className="flex items-center justify-center gap-6 flex-wrap">
              <span className="flex items-center gap-1.5 text-sm text-blue-100">
                <ShieldCheck className="h-4 w-4" />
                <strong className="text-white font-bold">500+</strong> talleres verificados
              </span>
              <span className="flex items-center gap-1.5 text-sm text-blue-100">
                <Star className="h-4 w-4 fill-gartify-orange text-gartify-orange" />
                <strong className="text-white font-bold">+2.000</strong> reseñas reales
              </span>
              <span className="flex items-center gap-1.5 text-sm text-blue-100">
                <MapPin className="h-4 w-4" />
                <strong className="text-white font-bold">15</strong> provincias
              </span>
            </div>
          </div>
        </section>

        {/* ── Driver steps ── */}
        <section className="py-20 px-4">
          <div className="container max-w-5xl">
            <div className="text-center mb-14">
              <span className="inline-flex items-center gap-2 rounded-full bg-blue-50 border border-blue-100 px-3 py-1 text-xs font-bold text-gartify-hero uppercase tracking-wide mb-3">
                <Car className="h-3.5 w-3.5" /> Para conductores
              </span>
              <h2 className="text-3xl font-bold text-gartify-blue">Tu cita en 4 pasos</h2>
            </div>

            <div className="flex flex-col">
              {DRIVER_STEPS.map(({ step, icon: Icon, color, title, desc, details }, i) => (
                <div key={step}>
                  <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden flex flex-col sm:flex-row">
                    {/* Left accent + step number */}
                    <div className={`${color} sm:w-24 shrink-0 flex flex-col items-center justify-center py-6 sm:py-8 gap-2`}>
                      <span className="text-3xl font-black text-white/30 leading-none">{step}</span>
                      <div className="h-10 w-10 rounded-full bg-white/20 flex items-center justify-center">
                        <Icon className="h-5 w-5 text-white" />
                      </div>
                    </div>

                    {/* Content */}
                    <div className="flex-1 p-6 flex flex-col sm:flex-row gap-6">
                      <div className="flex-1">
                        <h3 className="text-lg font-bold text-gartify-blue mb-2">{title}</h3>
                        <p className="text-sm text-muted-foreground leading-relaxed">{desc}</p>
                      </div>

                      {/* Detail chips */}
                      <div className="sm:w-56 shrink-0 space-y-2">
                        {details.map(({ icon: DIcon, text }) => (
                          <div key={text} className="flex items-center gap-2.5 bg-blue-50 rounded-lg px-3 py-2">
                            <DIcon className="h-4 w-4 text-gartify-mid shrink-0" />
                            <span className="text-xs font-medium text-gartify-blue">{text}</span>
                          </div>
                        ))}
                      </div>
                    </div>
                  </div>

                  {/* Connector between cards (desktop only, not after last) */}
                  {i < DRIVER_STEPS.length - 1 && (
                    <div className="hidden sm:flex justify-start pl-12">
                      <div className="w-0.5 h-6 bg-gartify-mid/30" />
                    </div>
                  )}
                </div>
              ))}
            </div>

            <div className="text-center mt-10">
              <Link href="/talleres">
                <Button size="lg" className="bg-gartify-green hover:bg-gartify-green/90 text-white font-bold gap-2 h-12 px-8">
                  Buscar talleres ahora <ChevronRight className="h-5 w-5" />
                </Button>
              </Link>
            </div>
          </div>
        </section>

        {/* ── For garages ── */}
        <section className="bg-blue-50 py-20 px-4">
          <div className="container max-w-5xl">
            <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
              {/* Header strip */}
              <div className="bg-gradient-to-r from-gartify-hero to-gartify-mid px-8 py-6">
                <span className="inline-flex items-center gap-2 rounded-full bg-white/15 border border-white/20 px-3 py-1 text-xs font-bold text-white uppercase tracking-wide mb-3">
                  <Wrench className="h-3.5 w-3.5" /> Para talleres mecánicos
                </span>
                <h2 className="text-2xl font-bold text-white">¿Tienes un taller? Únete a Gartify</h2>
                <p className="text-blue-200 text-xs mt-1">300+ talleres ya confían en Gartify para recibir nuevas reservas.</p>
              </div>

              <div className="p-8">
                <div className="grid sm:grid-cols-2 gap-6 mb-8">
                  {GARAGE_STEPS.map(({ step, icon: Icon, title, desc }) => (
                    <div key={title} className="flex gap-4">
                      <div className="h-10 w-10 rounded-lg bg-gartify-blue/10 border border-gartify-blue/20 flex items-center justify-center shrink-0 relative">
                        <Icon className="h-5 w-5 text-gartify-hero" />
                        <span className="absolute -top-1.5 -left-1.5 text-xs font-bold text-white bg-gartify-hero rounded-full h-4 w-4 flex items-center justify-center leading-none">
                          {parseInt(step)}
                        </span>
                      </div>
                      <div>
                        <p className="font-bold text-gartify-blue text-sm mb-1">{title}</p>
                        <p className="text-xs text-muted-foreground leading-relaxed">{desc}</p>
                      </div>
                    </div>
                  ))}
                </div>

                <div className="flex flex-col sm:flex-row gap-3">
                  <Link href="/registro/taller" className="flex-1">
                    <Button className="w-full h-11 bg-gartify-green hover:bg-gartify-green/90 text-white font-semibold gap-2">
                      <ChevronRight className="h-4 w-4" /> Registrar mi taller gratis
                    </Button>
                  </Link>
                  <Link href="/para-talleres" className="flex-1">
                    <Button className="w-full h-11 bg-gartify-orange hover:bg-gartify-orange/90 text-white font-semibold">
                      Ver todos los beneficios
                    </Button>
                  </Link>
                </div>
              </div>
            </div>
          </div>
        </section>

        {/* ── Why Gartify ── */}
        <section className="py-20 px-4">
          <div className="container max-w-5xl">
            <div className="text-center mb-14">
              <h2 className="text-3xl font-bold text-gartify-blue mb-3">¿Por qué elegir Gartify?</h2>
              <p className="text-muted-foreground max-w-xl mx-auto text-sm">
                Diseñado para que el conductor siempre tenga el control y la información que necesita.
              </p>
            </div>

            <div className="grid sm:grid-cols-2 lg:grid-cols-3 gap-5">
              {[
                { icon: Euro,        color: "text-gartify-orange", bg: "bg-orange-50",  border: "border-orange-100", title: "Precio antes de reservar",     desc: "Ves el precio exacto antes de confirmar. Sin llamadas, sin presupuestos a ciegas." },
                { icon: ShieldCheck, color: "text-gartify-hero",   bg: "bg-blue-50",    border: "border-blue-100",   title: "Talleres verificados",          desc: "Comprobamos que cada taller existe y tiene los datos correctos antes de publicarlo." },
                { icon: Star,        color: "text-yellow-500",     bg: "bg-yellow-50",  border: "border-yellow-100", title: "Reseñas 100% reales",            desc: "Solo pueden valorar los clientes que han reservado a través de Gartify." },
                { icon: Clock,       color: "text-gartify-mid",    bg: "bg-cyan-50",    border: "border-cyan-100",   title: "Disponibilidad en tiempo real",  desc: "Los horarios se actualizan con cada reserva. Nunca elegirás una hora ya ocupada." },
                { icon: Bell,        color: "text-gartify-green",  bg: "bg-green-50",   border: "border-green-100",  title: "Confirmación instantánea",       desc: "Email de confirmación nada más reservar. El taller recibe notificación de inmediato." },
                { icon: BarChart3,   color: "text-purple-500",     bg: "bg-purple-50",  border: "border-purple-100", title: "Compara en segundos",            desc: "Varios talleres, varios precios, una sola pantalla. Tú decides sin presión." },
              ].map(({ icon: Icon, color, bg, border, title, desc }) => (
                <div key={title} className="bg-white rounded-xl border border-gray-200 shadow-sm p-5 flex gap-4">
                  <div className={`h-10 w-10 rounded-lg ${bg} border ${border} flex items-center justify-center shrink-0`}>
                    <Icon className={`h-5 w-5 ${color}`} />
                  </div>
                  <div>
                    <p className="font-bold text-gartify-blue text-sm mb-1">{title}</p>
                    <p className="text-xs text-muted-foreground leading-relaxed">{desc}</p>
                  </div>
                </div>
              ))}
            </div>
          </div>
        </section>

        {/* ── FAQ ── */}
        <section className="bg-blue-50 py-20 px-4">
          <div className="container max-w-3xl">
            <div className="text-center mb-12">
              <h2 className="text-3xl font-bold text-gartify-blue mb-3">Preguntas frecuentes</h2>
              <p className="text-sm text-muted-foreground">Todo lo que necesitas saber antes de reservar.</p>
            </div>

            <div className="space-y-3">
              {FAQS.map(({ q, a }) => (
                <details
                  key={q}
                  className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden group"
                >
                  {/* summary MUST be first direct child of details */}
                  <summary className="flex items-center cursor-pointer list-none [&::-webkit-details-marker]:hidden">
                    <div className="w-1 self-stretch shrink-0 bg-gradient-to-b from-gartify-hero to-gartify-mid" />
                    <div className="flex-1 p-5 flex items-center justify-between gap-2">
                      <span className="font-bold text-gartify-blue text-sm">{q}</span>
                      <ChevronDown className="h-4 w-4 text-gartify-mid shrink-0 transition-transform duration-200 group-open:rotate-180" />
                    </div>
                  </summary>
                  <div className="flex border-t border-gray-100">
                    <div className="w-1 shrink-0 bg-gartify-hero/10" />
                    <p className="flex-1 px-5 py-4 text-sm text-muted-foreground leading-relaxed">{a}</p>
                  </div>
                </details>
              ))}
            </div>
          </div>
        </section>

        {/* ── Final CTA ── */}
        <section className="bg-gradient-to-b from-gartify-mid to-gartify-hero py-16 text-center px-4">
          <div className="container max-w-2xl">
            <h2 className="text-2xl font-bold text-white mb-3">¿Listo para reservar tu cita?</h2>
            <p className="text-blue-100 mb-8 text-sm">
              Más de 500 talleres verificados en toda España esperando para atenderte.
            </p>
            <div className="flex flex-col sm:flex-row gap-3 justify-center">
              <Link href="/talleres">
                <Button size="lg" className="bg-gartify-orange hover:bg-gartify-orange/90 text-white font-bold gap-2 h-12 px-8">
                  <Search className="h-5 w-5" /> Buscar taller ahora
                </Button>
              </Link>
              <Link href="/registro">
                <Button size="lg" className="bg-gartify-green hover:bg-gartify-green/90 text-white font-semibold h-12 px-8">
                  Crear cuenta gratis
                </Button>
              </Link>
            </div>
          </div>
        </section>

      </div>
    </>
  );
}
