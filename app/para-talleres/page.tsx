import type { Metadata } from "next";
import Link from "next/link";
import Image from "next/image";
import { LeadForm } from "@/components/para-talleres/LeadForm";
import { Star, Wrench, CalendarCheck, Banknote, ChevronRight } from "lucide-react";

// ─── Metadata SEO ─────────────────────────────────────────────────────────────

export const metadata: Metadata = {
  title: "Consigue nuevos clientes para tu taller — Gartify para talleres",
  description:
    "Gartify te conecta con conductores de tu zona que buscan un taller de confianza. Cero costes de alta, sin exclusividad, sin permanencia. Empieza hoy.",
  openGraph: {
    title: "Consigue nuevos clientes para tu taller — Gartify",
    description:
      "Recibe reservas online de conductores de tu zona sin levantar el teléfono. Alta gratuita en 5 minutos.",
    type: "website",
  },
  alternates: { canonical: "/para-talleres" },
};

// ─── JSON-LD estructurado ─────────────────────────────────────────────────────

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
      name: "Consigue nuevos clientes para tu taller — Gartify",
      description:
        "Plataforma para talleres mecánicos que quieren recibir reservas online sin intermediarios en sus cobros.",
      url: "https://gartify.es/para-talleres",
    },
  ],
};

// ─── Datos de las secciones ───────────────────────────────────────────────────

const PAIN_POINTS = [
  {
    icon: Wrench,
    titulo: "Sin tiempo para el marketing",
    descripcion:
      "Atiendes a los clientes mientras el taller rueda. Cada llamada para dar presupuestos te quita 20 minutos que necesitas en el foso. Nosotros captamos al cliente por ti.",
  },
  {
    icon: CalendarCheck,
    titulo: "Huecos sin rentabilizar",
    descripcion:
      "Algunos días el taller va lleno y otros están vacíos. Gartify te trae reservas que llenan esos huecos con trabajos rentables, sin que muevas un dedo.",
  },
  {
    icon: Banknote,
    titulo: "El dinero va directo a tu caja",
    descripcion:
      "El pago se hace en tu taller. Gartify no toca tus cobros ni cobra comisión por reserva. Cuota fija mensual, sin sorpresas en tu facturación.",
  },
];

const PASOS = [
  {
    numero: "01",
    titulo: "Alta en 5 minutos",
    descripcion:
      "Rellenas el formulario con los datos de tu taller. Nosotros configuramos tu perfil en la plataforma y lo dejamos listo para recibir reservas.",
  },
  {
    numero: "02",
    titulo: "Recibe la alerta de reserva",
    descripcion:
      "Cuando un conductor de tu zona reserva un servicio, te llega una notificación al instante en tu móvil y en el panel de control: servicio solicitado y modelo del vehículo.",
  },
  {
    numero: "03",
    titulo: "Repara y fideliza",
    descripcion:
      "El cliente acude a tu taller con toda la información. Tú das un servicio excelente, cobras tu tarifa y consigues un cliente recurrente para toda la vida.",
  },
];

// ─── Página ───────────────────────────────────────────────────────────────────

export default function ParaTalleresPage() {
  return (
    <div className="min-h-screen bg-white">
      <script
        type="application/ld+json"
        dangerouslySetInnerHTML={{ __html: JSON.stringify(jsonLd) }}
      />

      {/* ══════════════════════════════════════════════════════════════════════
          1. HERO — fondo azul marino oscuro, texto blanco
      ══════════════════════════════════════════════════════════════════════ */}
      <section className="relative overflow-hidden bg-gartify-dark min-h-[calc(100vh-4rem)]">
        {/* Imagen de fondo */}
        <Image
          src="/para-talleres.png"
          alt=""
          fill
          className="object-cover object-center"
          priority
          aria-hidden="true"
        />
        {/* Overlay: transparente a la izquierda (mecánico visible), oscuro a la derecha (texto legible) */}
        <div className="absolute inset-0 bg-gradient-to-r from-black/20 via-gartify-dark/60 to-gartify-dark/90" aria-hidden="true" />

        {/* Animación de entrada */}
        <style>{`
          @keyframes heroSlideIn {
            from { opacity: 0; transform: translateX(-70px); }
            to   { opacity: 1; transform: translateX(0); }
          }
          .pt-hero-in { animation: heroSlideIn 0.75s cubic-bezier(0.22, 0.61, 0.36, 1) both; }
          .pt-d1 { animation-delay: 0ms; }
          .pt-d2 { animation-delay: 130ms; }
          .pt-d3 { animation-delay: 260ms; }
          .pt-d4 { animation-delay: 390ms; }
        `}</style>

        <div className="relative container max-w-6xl mx-auto px-4 flex items-center min-h-[calc(100vh-4rem)]">
          <div className="grid md:grid-cols-2 gap-8 items-center">

            {/* Columna izquierda — vacía: el mecánico es el protagonista */}
            <div className="hidden md:block" aria-hidden="true" />

            {/* Columna derecha — copy de conversión */}
            <div>
              <h1 className="pt-hero-in pt-d1 text-3xl md:text-4xl lg:text-[2.75rem] font-black text-white leading-tight mb-4">
                Consigue nuevos clientes para tu taller{" "}
                <span className="text-gartify-orange">sin levantar el teléfono.</span>
              </h1>

              <p className="pt-hero-in pt-d2 text-blue-200 mb-6 leading-relaxed">
                Gartify te conecta con conductores de tu zona que buscan taller de confianza.
                Sin llamadas, sin intermediarios en tus cobros, sin exclusividad.
              </p>

              <div className="pt-hero-in pt-d3 flex flex-wrap items-center gap-4">
                <Link
                  href="/registro?tipo=taller"
                  className="inline-flex items-center gap-2 rounded-xl bg-gartify-green px-7 py-3.5 text-white font-bold text-base hover:bg-green-600 transition-colors focus:outline-none focus:ring-2 focus:ring-gartify-green focus:ring-offset-2 focus:ring-offset-gartify-dark"
                >
                  Únete a la red de talleres
                  <ChevronRight className="h-5 w-5" aria-hidden="true" />
                </Link>
                <p className="text-sm text-blue-300">Alta gratuita · Sin permanencia</p>
              </div>

              {/* Ticker de reservas en directo */}
              <div className="pt-hero-in pt-d4 mt-6 rounded-xl border border-white/10 bg-white/5 backdrop-blur-sm px-4 py-3">
                <span className="flex items-center gap-1.5 text-xs font-bold text-blue-300 uppercase tracking-widest mb-2">
                  <span className="inline-flex h-2 w-2 rounded-full bg-gartify-green animate-pulse" />
                  En directo
                </span>
                <div className="flex flex-col gap-1.5">
                  {[
                    { hora: "09:00", servicio: "Cambio de aceite",   coche: "Seat León" },
                    { hora: "10:30", servicio: "Revisión frenos",    coche: "Toyota Yaris" },
                    { hora: "12:00", servicio: "ITV pre-inspección", coche: "VW Golf" },
                  ].map(({ hora, servicio, coche }) => (
                    <div key={hora} className="flex items-center gap-2 rounded-lg bg-white/5 border border-white/10 px-3 py-1.5 w-full">
                      <Wrench className="h-3 w-3 text-gartify-orange shrink-0" aria-hidden="true" />
                      <span className="text-white text-xs font-semibold w-10 shrink-0">{hora}</span>
                      <span className="text-blue-300 text-xs">{servicio} · {coche}</span>
                    </div>
                  ))}
                </div>
              </div>
            </div>

          </div>
        </div>
      </section>

      {/* ══════════════════════════════════════════════════════════════════════
          2. PAIN POINTS — fondo blanco
      ══════════════════════════════════════════════════════════════════════ */}
      <section className="bg-white py-20 px-4">
        <div className="container max-w-5xl mx-auto">

          {/* Etiqueta de sección */}
          <span className="inline-block rounded-full border border-gray-200 bg-gray-50 px-3 py-1 text-xs font-bold uppercase tracking-widest text-gartify-gray mb-6">
            Puntos de dolor
          </span>

          <h2 className="text-3xl md:text-4xl font-black text-gartify-dark mb-12 max-w-2xl leading-tight">
            Sabemos que tu negocio está en el elevador,{" "}
            <span className="text-gartify-blue">no en la oficina.</span>
          </h2>

          <div className="grid sm:grid-cols-3 gap-6">
            {PAIN_POINTS.map(({ icon: Icon, titulo, descripcion }) => (
              <div
                key={titulo}
                className="rounded-2xl border border-gray-100 bg-gray-50 p-6 hover:shadow-md transition-shadow"
              >
                <div className="mb-4 inline-flex h-12 w-12 items-center justify-center rounded-xl bg-gartify-blue/10 border border-gartify-blue/20">
                  <Icon className="h-6 w-6 text-gartify-blue" aria-hidden="true" />
                </div>
                <h3 className="font-bold text-gartify-dark mb-2">{titulo}</h3>
                <p className="text-sm text-gartify-gray leading-relaxed">{descripcion}</p>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* ══════════════════════════════════════════════════════════════════════
          3. CÓMO FUNCIONA — fondo gris muy claro
      ══════════════════════════════════════════════════════════════════════ */}
      <section className="bg-slate-50 py-20 px-4">
        <div className="container max-w-6xl mx-auto">

          {/* Etiqueta de sección */}
          <span className="inline-block rounded-full border border-gray-200 bg-white px-3 py-1 text-xs font-bold uppercase tracking-widest text-gartify-gray mb-6">
            Cómo funciona
          </span>

          <div className="grid md:grid-cols-2 gap-12 items-center">

            {/* Columna izquierda — pasos */}
            <div>
              <h2 className="text-3xl md:text-4xl font-black text-gartify-dark mb-10 leading-tight">
                Empieza a recibir reservas{" "}
                <span className="text-gartify-orange">en 3 pasos.</span>{" "}
                <br className="hidden sm:block" />
                <span className="text-2xl font-bold text-gartify-blue">
                  Nosotros hacemos el trabajo sucio.
                </span>
              </h2>

              <div className="space-y-8">
                {PASOS.map(({ numero, titulo, descripcion }) => (
                  <div key={numero} className="flex gap-5">
                    <div className="flex-shrink-0 flex h-12 w-12 items-center justify-center rounded-full bg-gartify-dark text-gartify-orange font-black text-xl border-2 border-gartify-orange/30">
                      {numero}
                    </div>
                    <div>
                      <h3 className="font-bold text-gartify-dark mb-1">{titulo}</h3>
                      <p className="text-sm text-gartify-gray leading-relaxed">{descripcion}</p>
                    </div>
                  </div>
                ))}
              </div>
            </div>

            {/* Columna derecha — mock visual de notificación en móvil */}
            <div className="hidden md:flex justify-center">
              <div className="relative w-64">
                {/* Cuerpo del "teléfono" */}
                <div className="rounded-[2rem] bg-gartify-dark border-4 border-gray-700 p-4 shadow-2xl">
                  <div className="rounded-2xl bg-slate-800 min-h-[360px] p-4 flex flex-col gap-3">
                    <p className="text-xs text-gray-400 text-center mb-1">Panel Gartify</p>

                    {/* Tarjeta notificación */}
                    <div className="rounded-xl bg-gartify-green/20 border border-gartify-green/40 p-3">
                      <p className="text-gartify-green text-xs font-bold mb-1">Nueva reserva</p>
                      <p className="text-white text-xs">Cambio de aceite</p>
                      <p className="text-gray-400 text-xs">Seat León · Hoy 09:00</p>
                    </div>

                    {/* Estadísticas simuladas */}
                    <div className="mt-2 rounded-xl bg-white/5 border border-white/10 p-3">
                      <p className="text-gray-400 text-xs mb-2">Este mes</p>
                      <div className="flex justify-between">
                        <div className="text-center">
                          <p className="text-white font-black text-xl">18</p>
                          <p className="text-gray-400 text-xs">Reservas</p>
                        </div>
                        <div className="text-center">
                          <p className="text-gartify-orange font-black text-xl">4,8</p>
                          <p className="text-gray-400 text-xs">Valoración</p>
                        </div>
                        <div className="text-center">
                          <p className="text-gartify-green font-black text-xl">12</p>
                          <p className="text-gray-400 text-xs">Nuevos</p>
                        </div>
                      </div>
                    </div>

                    {/* Barra de progreso simulada */}
                    <div className="rounded-xl bg-white/5 border border-white/10 p-3">
                      <p className="text-gray-400 text-xs mb-2">Ocupación semanal</p>
                      <div className="flex items-end gap-1 h-10">
                        {[40, 70, 55, 90, 65, 80, 30].map((h, i) => (
                          <div
                            key={i}
                            className="flex-1 rounded-sm bg-gartify-blue"
                            style={{ height: `${h}%` }}
                          />
                        ))}
                      </div>
                      <div className="flex justify-between mt-1">
                        {["L", "M", "X", "J", "V", "S", "D"].map((d) => (
                          <span key={d} className="flex-1 text-center text-gray-500 text-xs">{d}</span>
                        ))}
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>
        </div>
      </section>

      {/* ══════════════════════════════════════════════════════════════════════
          4. PRUEBA SOCIAL — fondo blanco
      ══════════════════════════════════════════════════════════════════════ */}
      <section className="bg-white py-20 px-4">
        <div className="container max-w-3xl mx-auto text-center">

          {/* Etiqueta de sección */}
          <span className="inline-block rounded-full border border-gray-200 bg-gray-50 px-3 py-1 text-xs font-bold uppercase tracking-widest text-gartify-gray mb-6">
            Prueba social
          </span>

          <h2 className="text-3xl md:text-4xl font-black text-gartify-dark mb-12 leading-tight">
            Ya generamos negocio para{" "}
            <span className="text-gartify-blue">más de 500 talleres</span>{" "}
            en España.
          </h2>

          {/* Testimonio destacado */}
          <div className="relative rounded-2xl border border-gray-100 bg-slate-50 p-8 md:p-10 text-left shadow-sm">
            {/* Comillas decorativas */}
            <span
              className="absolute top-4 left-6 text-7xl text-gartify-blue/10 font-black leading-none select-none"
              aria-hidden="true"
            >
              &ldquo;
            </span>

            {/* Estrellas */}
            <div className="flex gap-1 mb-4" role="img" aria-label="5 estrellas">
              {Array.from({ length: 5 }).map((_, i) => (
                <Star key={i} className="h-5 w-5 fill-gartify-orange text-gartify-orange" aria-hidden="true" />
              ))}
            </div>

            <blockquote className="text-gartify-dark text-lg md:text-xl font-medium leading-relaxed mb-6">
              Desde que estamos en Gartify recibimos entre 15 y 20 reservas nuevas al mes sin
              hacer nada especial. Los clientes llegan informados, el proceso es muy limpio y no
              hay que andar negociando precios por teléfono.
            </blockquote>

            <div className="flex items-center gap-3">
              {/* Avatar con iniciales */}
              <div className="h-12 w-12 rounded-full bg-gartify-dark flex items-center justify-center shrink-0">
                <span className="text-white font-bold text-sm">MR</span>
              </div>
              <div>
                <p className="font-bold text-gartify-dark text-sm">Mecánica Rivas</p>
                <p className="text-gartify-gray text-xs">Taller independiente — Barcelona</p>
              </div>
            </div>
          </div>

          {/* Métrica secundaria */}
          <div className="mt-10 grid grid-cols-3 gap-4">
            {[
              { valor: "+500", etiqueta: "talleres activos" },
              { valor: "4,9★", etiqueta: "valoración media" },
              { valor: "18", etiqueta: "reservas/mes por taller" },
            ].map(({ valor, etiqueta }) => (
              <div key={etiqueta} className="rounded-xl bg-gray-50 border border-gray-100 py-5 px-3">
                <p className="text-2xl font-black text-gartify-blue">{valor}</p>
                <p className="text-xs text-gartify-gray mt-1">{etiqueta}</p>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* ══════════════════════════════════════════════════════════════════════
          5. CIERRE + FORMULARIO DE LEAD — fondo azul marino oscuro
      ══════════════════════════════════════════════════════════════════════ */}
      <section className="bg-gartify-dark py-20 px-4">
        <div className="container max-w-2xl mx-auto">

          {/* Etiqueta de sección */}
          <span className="inline-block rounded-full border border-white/20 bg-white/5 px-3 py-1 text-xs font-bold uppercase tracking-widest text-blue-300 mb-6">
            Empieza hoy
          </span>

          <h2 className="text-3xl md:text-4xl font-black text-white mb-4 leading-tight">
            ¿Listo para aumentar{" "}
            <span className="text-gartify-orange">tu facturación?</span>
          </h2>
          <p className="text-blue-200 mb-10 text-lg">
            Únete a Gartify y empieza a recibir reservas en menos de 45 días,
            o te ayudamos a encontrar qué mejorar.
          </p>

          {/* Formulario de captación de lead (Client Component) */}
          <LeadForm />

          {/* Alternativa directa */}
          <p className="mt-6 text-center text-sm text-blue-300">
            ¿Prefieres registrarte directamente?{" "}
            <Link
              href="/registro?tipo=taller"
              className="text-white font-semibold underline underline-offset-2 hover:text-gartify-orange transition-colors"
            >
              Crea tu perfil ahora
            </Link>
          </p>
        </div>
      </section>
    </div>
  );
}
