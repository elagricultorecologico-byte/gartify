import type { Metadata } from "next";
import Link from "next/link";
import { Button } from "@/components/ui/button";
import { Wrench, ChevronRight, ShieldCheck, Bell, BarChart3, Users, Settings, Star, Euro, CheckCircle, Cog } from "lucide-react";
import { PricingSection } from "@/components/para-talleres/PricingSection";
import { ALL_SERVICES } from "@/lib/constants";

export const metadata: Metadata = {
  title: "Para talleres — Publica tus servicios y recibe reservas online",
  description:
    "Únete a Gartify y haz crecer tu taller mecánico. Publica servicios, recibe reservas online 24/7 y gestiona tu agenda. Sin comisiones por reserva.",
  openGraph: {
    title: "Registra tu taller en Gartify — Sin comisiones por reserva",
    description:
      "Publica tus servicios mecánicos, recibe reservas online y llega a más clientes en tu zona. Alta gratuita en 5 minutos.",
    type: "website",
  },
  alternates: { canonical: "/para-talleres" },
};

const jsonLd = {
  "@context": "https://schema.org",
  "@graph": [
    {
      "@type": "BreadcrumbList",
      itemListElement: [
        { "@type": "ListItem", position: 1, name: "Inicio", item: "https://gartify.es" },
        { "@type": "ListItem", position: 2, name: "Para talleres", item: "https://gartify.es/para-talleres" },
      ],
    },
    {
      "@type": "WebPage",
      name: "Registra tu taller en Gartify",
      description:
        "Plataforma para talleres mecánicos que quieren publicar servicios y recibir reservas online sin comisiones.",
      url: "https://gartify.es/para-talleres",
    },
  ],
};

// ─── Platform benefits ────────────────────────────────────────────────────────

const BENEFITS = [
  { icon: Users,      title: "Nuevos clientes cada día",    desc: "Aparezcas en búsquedas de conductores que buscan exactamente lo que ofreces en tu zona." },
  { icon: Bell,       title: "Reservas online 24/7",        desc: "Los clientes reservan cuando quieren, incluso fuera de horario. Tú recibes la petición por email." },
  { icon: BarChart3,  title: "Panel de control completo",   desc: "Gestiona tus reservas, actualiza precios, activa o desactiva servicios en cualquier momento." },
  { icon: ShieldCheck,title: "Verificación y confianza",    desc: "El sello Gartify Verificado aumenta la confianza de los clientes y mejora tu posición en resultados." },
  { icon: Star,       title: "Reseñas que te diferencian",  desc: "Las valoraciones positivas de clientes reales son tu mejor carta de presentación." },
  { icon: Euro,       title: "Sin comisiones por reserva",  desc: "Cuota fija mensual, sin sorpresas. Tú cobras el 100% del servicio directamente al cliente." },
];

// ─── Page ─────────────────────────────────────────────────────────────────────

export default function ParaTalleresPage() {
  return (
    <div>
      <script
        type="application/ld+json"
        dangerouslySetInnerHTML={{ __html: JSON.stringify(jsonLd) }}
      />

      {/* ── Hero ── */}
      <section className="bg-gradient-to-br from-gartify-hero to-gartify-mid py-20 text-center px-4">
        <div className="container max-w-3xl">
          <span className="inline-flex items-center gap-2 rounded-full border border-gartify-orange/50 bg-gartify-orange/20 px-4 py-1.5 text-sm text-gartify-orange mb-6">
            <Wrench className="h-3.5 w-3.5" aria-hidden="true" />
            Para propietarios de talleres
          </span>
          <h1 className="text-4xl md:text-5xl font-bold text-white mb-5 leading-tight">
            Haz crecer tu taller<br />
            <span className="text-gartify-orange">con Gartify</span>
          </h1>
          <p className="text-lg text-blue-100 max-w-xl mx-auto mb-8">
            Publica tus servicios, recibe reservas online y gestiona tu agenda. Sin comisiones, sin complicaciones.
          </p>
          <div className="flex flex-col sm:flex-row gap-3 justify-center">
            <Link href="/registro?tipo=taller">
              <Button size="lg" className="bg-gartify-green hover:bg-gartify-green/90 text-white font-bold gap-2 h-12 px-8">
                <ChevronRight className="h-5 w-5" /> Registrar mi taller gratis
              </Button>
            </Link>
            <Link href="/como-funciona">
              <Button size="lg" className="bg-gartify-orange hover:bg-gartify-orange/90 text-white font-semibold h-12 px-8">
                Ver cómo funciona
              </Button>
            </Link>
          </div>
        </div>
      </section>

      {/* ── Benefits ── */}
      <section className="py-20 px-4">
        <div className="container max-w-5xl">
          <div className="text-center mb-12">
            <h2 className="text-3xl font-bold text-gartify-blue mb-3">¿Por qué unirte a Gartify?</h2>
            <p className="text-sm text-muted-foreground max-w-xl mx-auto">
              La plataforma pensada para que los talleres crezcan sin esfuerzo administrativo.
            </p>
          </div>
          <div className="grid sm:grid-cols-2 lg:grid-cols-3 gap-5">
            {BENEFITS.map(({ icon: Icon, title, desc }) => (
              <div key={title} className="bg-white rounded-xl border border-gray-200 shadow-sm p-5 flex gap-4">
                <div className="h-10 w-10 rounded-lg bg-gartify-blue/10 border border-gartify-blue/20 flex items-center justify-center shrink-0">
                  <Icon className="h-5 w-5 text-gartify-hero" />
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

      {/* ── Services catalog ── */}
      <section className="bg-blue-50 py-20 px-4">
        <div className="container max-w-5xl">
          <div className="text-center mb-12">
            <span className="inline-flex items-center gap-2 rounded-full bg-white border border-blue-100 px-3 py-1 text-xs font-bold text-gartify-hero uppercase tracking-wide mb-3">
              <Cog className="h-3.5 w-3.5" aria-hidden="true" /> Catálogo de servicios
            </span>
            <h2 className="text-3xl font-bold text-gartify-blue mb-3">Todos los servicios que puedes publicar</h2>
            <p className="text-sm text-muted-foreground max-w-2xl mx-auto">
              Añade cualquiera de los siguientes servicios a tu perfil con tu propio precio y duración estimada. Puedes activar o desactivar cada servicio en cualquier momento.
            </p>
          </div>

          <div className="grid sm:grid-cols-2 lg:grid-cols-3 gap-4">
            {ALL_SERVICES.map(({ icon: Icon, color, bg, border, label, desc, examples }) => (
              <div key={label} className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden flex flex-col">
                {/* Card header */}
                <div className="flex items-center gap-3 p-4 border-b border-gray-100">
                  <div className={`h-9 w-9 rounded-lg ${bg} border ${border} flex items-center justify-center shrink-0`}>
                    <Icon className={`h-5 w-5 ${color}`} />
                  </div>
                  <span className={`inline-flex items-center rounded-full ${bg} ${color} border ${border} text-xs font-bold px-2.5 py-0.5`}>
                    {label}
                  </span>
                </div>

                {/* Description */}
                <div className="p-4 flex-1">
                  <p className="text-xs text-muted-foreground leading-relaxed mb-3">{desc}</p>

                  {/* Examples */}
                  <div className="space-y-1.5">
                    {examples.map((ex) => (
                      <div key={ex} className="flex items-center gap-2 text-xs text-gartify-blue">
                        <CheckCircle className="h-3.5 w-3.5 text-gartify-green shrink-0" />
                        {ex}
                      </div>
                    ))}
                  </div>
                </div>
              </div>
            ))}
          </div>

          <p className="text-center text-xs text-muted-foreground mt-8">
            ¿No encuentras tu servicio?{" "}
            <Link href="/contacto" className="text-gartify-orange font-semibold hover:underline">
              Escríbenos y lo añadimos.
            </Link>
          </p>
        </div>
      </section>

      {/* ── How to join ── */}
      <section className="py-20 px-4">
        <div className="container max-w-4xl">
          <div className="text-center mb-12">
            <h2 className="text-3xl font-bold text-gartify-blue mb-3">Empieza en 3 pasos</h2>
          </div>

          <div className="grid sm:grid-cols-3 gap-6 mb-12">
            {[
              { step: "01", icon: Settings, title: "Crea tu perfil",        desc: "Regístrate, añade los datos de tu taller (nombre, dirección, teléfono) y una descripción de lo que ofreces." },
              { step: "02", icon: Wrench,   title: "Publica tus servicios", desc: "Añade cada servicio con tu precio real y duración estimada. Puedes añadir tantos como quieras." },
              { step: "03", icon: Bell,     title: "Recibe reservas",       desc: "Los conductores te encuentran, reservan online y tú recibes la petición por email al instante." },
            ].map(({ step, icon: Icon, title, desc }) => (
              <div key={step} className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden text-center">
                <div className="bg-gradient-to-b from-gartify-hero to-gartify-mid px-4 py-5 flex flex-col items-center gap-2">
                  <span className="text-4xl font-black text-white/20 leading-none">{step}</span>
                  <div className="h-10 w-10 rounded-full bg-white/20 border border-white/30 flex items-center justify-center">
                    <Icon className="h-5 w-5 text-white" />
                  </div>
                </div>
                <div className="p-5">
                  <p className="font-bold text-gartify-blue text-sm mb-2">{title}</p>
                  <p className="text-xs text-muted-foreground leading-relaxed">{desc}</p>
                </div>
              </div>
            ))}
          </div>

          <div className="text-center">
            <Link href="/registro?tipo=taller">
              <Button size="lg" className="bg-gartify-green hover:bg-gartify-green/90 text-white font-bold gap-2 h-12 px-10">
                <ChevronRight className="h-5 w-5" /> Registrar mi taller ahora — es gratis
              </Button>
            </Link>
          </div>
        </div>
      </section>

      {/* ── Pricing ── */}
      <PricingSection />

      {/* ── Final CTA strip ── */}
      <section className="bg-gradient-to-b from-gartify-mid to-gartify-hero py-14 text-center px-4">
        <div className="container max-w-2xl">
          <h2 className="text-2xl font-bold text-white mb-3">
            ¿Tienes dudas? Estamos aquí para ayudarte.
          </h2>
          <p className="text-blue-100 text-sm mb-7">
            Contacta con nosotros y te ayudamos a publicar tu taller en menos de 24 horas.
          </p>
          <div className="flex flex-col sm:flex-row gap-3 justify-center">
            <Link href="/contacto">
              <Button size="lg" className="bg-gartify-green hover:bg-gartify-green/90 text-white font-semibold h-11 px-8">
                Contactar con Gartify
              </Button>
            </Link>
            <Link href="/registro?tipo=taller">
              <Button size="lg" className="bg-gartify-orange hover:bg-gartify-orange/90 text-white font-bold gap-2 h-11 px-8">
                Empezar ahora
              </Button>
            </Link>
          </div>
        </div>
      </section>

    </div>
  );
}
