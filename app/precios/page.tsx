"use client";

/**
 * app/precios/page.tsx
 *
 * Página de precios SaaS de Gartify para talleres.
 * Client Component exclusivamente por el toggle anual/mensual (useState).
 * Sin Prisma, sin Auth, sin llamadas a API — datos completamente estáticos.
 */

import { useState } from "react";
import Link from "next/link";
import {
  Check,
  X,
  Zap,
  Wrench,
  Crown,
  ChevronDown,
  Star,
  Headphones,
  BarChart3,
  Package,
  Tag,
  Bell,
  Search,
  Tv,
  MessageCircle,
} from "lucide-react";
import { Button } from "@/components/ui/button";
import { cn } from "@/lib/utils";

// ─── Tipos ────────────────────────────────────────────────────────────────────

type EstadoToggle = "mensual" | "anual";

interface FilaCaracteristica {
  texto: string;
  starter: boolean | string;
  pro: boolean | string;
  premium: boolean | string;
}

interface PreguntaFrecuente {
  pregunta: string;
  respuesta: string;
}

// ─── Datos de características por plan ────────────────────────────────────────

const CARACTERISTICAS: FilaCaracteristica[] = [
  {
    texto: "Alta gratuita sin permanencia",
    starter: true,
    pro: true,
    premium: true,
  },
  {
    texto: "Perfil verificado en el directorio",
    starter: true,
    pro: true,
    premium: true,
  },
  {
    texto: "Gestión de reservas online",
    starter: true,
    pro: true,
    premium: true,
  },
  {
    texto: "Reseñas y valoraciones de clientes",
    starter: true,
    pro: true,
    premium: true,
  },
  {
    texto: "Soporte por email",
    starter: true,
    pro: true,
    premium: true,
  },
  {
    texto: "Servicios publicados",
    starter: "Hasta 4",
    pro: "Ilimitados",
    premium: "Ilimitados",
  },
  {
    texto: "Posición destacada en búsqueda",
    starter: false,
    pro: true,
    premium: true,
  },
  {
    texto: "Notificaciones automáticas al cliente",
    starter: false,
    pro: true,
    premium: true,
  },
  {
    texto: "Panel de estadísticas",
    starter: false,
    pro: true,
    premium: true,
  },
  {
    texto: "Modo TV — pantalla de citas en tiempo real",
    starter: false,
    pro: true,
    premium: true,
  },
  {
    texto: "Gestión de reservas por WhatsApp",
    starter: false,
    pro: true,
    premium: true,
  },
  {
    texto: "Acceso a red de distribuidores",
    starter: false,
    pro: false,
    premium: true,
  },
  {
    texto: 'Badge "Taller Premium"',
    starter: false,
    pro: false,
    premium: true,
  },
  {
    texto: "Herramientas de marketing",
    starter: false,
    pro: false,
    premium: true,
  },
  {
    texto: "Estadísticas avanzadas e informes PDF",
    starter: false,
    pro: false,
    premium: true,
  },
  {
    texto: "Soporte prioritario 24 h",
    starter: false,
    pro: false,
    premium: true,
  },
];

const PREGUNTAS_FRECUENTES: PreguntaFrecuente[] = [
  {
    pregunta: "¿Qué incluye el plan Pro?",
    respuesta:
      "El plan Pro incluye servicios ilimitados, posición destacada en búsquedas, sello Gartify Verificado, estadísticas de visitas, gestión de horarios y huecos, y soporte prioritario, todo por 29 €/mes sin comisiones por reserva.",
  },
  {
    pregunta: "¿Puedo cambiar de plan en cualquier momento?",
    respuesta:
      "Sí. Puedes subir o bajar de plan desde el panel de tu taller sin permanencia mínima. Los cambios se aplican al inicio del siguiente ciclo de facturación. El plan Starter es siempre gratuito y siempre disponible.",
  },
  {
    pregunta: "¿Cómo funciona el descuento por pago anual en el plan Premium?",
    respuesta:
      "Al elegir facturación anual pagas 59 €/mes en lugar de 79 €/mes, lo que supone un ahorro de 237 € al año. Se cobra un único pago de 711 € al activar el plan.",
  },
  {
    pregunta: "¿Qué incluye el acceso a la red de distribuidores de recambios?",
    respuesta:
      "Con el plan Premium accedes a un marketplace B2B privado donde distribuidores homologados publican catálogos con precios exclusivos para talleres Gartify. Puedes solicitar presupuesto o hacer pedidos directamente desde tu panel.",
  },
  {
    pregunta: "¿Necesito tarjeta de crédito para darme de alta con el plan Starter?",
    respuesta:
      "No. El plan Starter es completamente gratuito y no requiere ningún dato de pago. Solo necesitas tu email y los datos básicos de tu taller.",
  },
];

// ─── Componentes auxiliares ───────────────────────────────────────────────────

function EtiquetaSeccion({ children }: { children: React.ReactNode }) {
  return (
    <p className="inline-flex items-center gap-2 text-xs font-bold uppercase tracking-widest text-gartify-orange mb-3">
      <span className="h-px w-6 bg-gartify-orange" />
      {children}
      <span className="h-px w-6 bg-gartify-orange" />
    </p>
  );
}

function IconoCaracteristica({ valor }: { valor: boolean | string }) {
  if (valor === false) {
    return <X className="h-4 w-4 text-slate-300 mx-auto" aria-label="No incluido" />;
  }
  if (valor === true) {
    return <Check className="h-4 w-4 text-gartify-green mx-auto" aria-label="Incluido" />;
  }
  return (
    <span className="text-xs font-semibold text-gartify-dark">{valor}</span>
  );
}

// ─── Page ─────────────────────────────────────────────────────────────────────

export default function PreciosPage() {
  const [ciclo, setCiclo] = useState<EstadoToggle>("mensual");

  const esMensual = ciclo === "mensual";
  const precioPro     = esMensual ? "29"  : "22";   // 261 €/año ÷ 12 ≈ 22 €/mes
  const precioPremium = esMensual ? "79"  : "59";   // 711 €/año ÷ 12 ≈ 59 €/mes

  return (
    <>
      {/* ══════════════════════════════════════════════════
          1. HERO
      ══════════════════════════════════════════════════ */}
      <section className="relative overflow-hidden bg-gradient-to-b from-gartify-hero to-gartify-mid py-20 md:py-28">
        {/* Orbes decorativos */}
        <div className="pointer-events-none absolute inset-0">
          <div className="absolute -left-20 -top-10 h-72 w-72 rounded-full bg-gartify-orange/20 blur-3xl" />
          <div className="absolute -right-16 top-1/3 h-96 w-96 rounded-full bg-white/10 blur-3xl" />
          <div className="absolute left-1/2 top-1/4 h-80 w-80 -translate-x-1/2 rounded-full bg-gartify-mid/30 blur-3xl" />
        </div>

        <div className="container relative max-w-3xl text-center">
          <p className="mb-6 inline-flex items-center gap-2 rounded-full border border-white/30 bg-white/10 px-4 py-2 text-sm font-semibold text-white">
            <span className="h-2 w-2 animate-pulse rounded-full bg-gartify-orange" />
            Sin comisiones
          </p>

          <h1 className="mb-5 text-4xl font-bold leading-tight tracking-tight text-white md:text-5xl">
            Planes pensados{" "}
            <span className="text-gartify-orange">para crecer</span>
          </h1>

          <p className="mx-auto mb-10 max-w-xl text-lg leading-relaxed text-blue-100">
            Empieza gratis o elige la cuota fija que mejor se adapta a tu
            taller. Sin comisiones por reserva en todos los planes de pago.
          </p>

          {/* Toggle anual / mensual — solo afecta al plan Premium */}
          <div className="inline-flex items-center gap-1 rounded-full border border-white/20 bg-white/10 p-1 text-sm font-semibold backdrop-blur-sm">
            <button
              onClick={() => setCiclo("mensual")}
              className={cn(
                "rounded-full px-5 py-2 transition-all duration-200",
                esMensual
                  ? "bg-white text-gartify-dark shadow"
                  : "text-white/80 hover:text-white"
              )}
              aria-pressed={esMensual}
            >
              Mensual
            </button>
            <button
              onClick={() => setCiclo("anual")}
              className={cn(
                "flex items-center gap-2 rounded-full px-5 py-2 transition-all duration-200",
                !esMensual
                  ? "bg-white text-gartify-dark shadow"
                  : "text-white/80 hover:text-white"
              )}
              aria-pressed={!esMensual}
            >
              Anual
              <span className="rounded-full bg-gartify-green px-2 py-0.5 text-[10px] font-bold uppercase text-white">
                -25 %
              </span>
            </button>
          </div>
        </div>
      </section>

      {/* ══════════════════════════════════════════════════
          2. CARDS DE PLANES
      ══════════════════════════════════════════════════ */}
      <section className="bg-slate-50 py-20">
        <div className="container max-w-6xl">
          <div className="grid grid-cols-1 gap-8 md:grid-cols-3">

            {/* ── Plan Starter ─────────────────────────── */}
            <div className="flex flex-col rounded-2xl border border-slate-200 bg-white p-8 shadow-sm hover:shadow-md transition-shadow duration-300">
              {/* Cabecera */}
              <div className="mb-6">
                <div className="mb-4 flex h-12 w-12 items-center justify-center rounded-2xl bg-slate-100">
                  <Zap className="h-6 w-6 text-gartify-gray" />
                </div>
                <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-1">
                  Starter
                </p>
                <div className="flex items-end gap-1 mb-1">
                  <span className="text-5xl font-bold text-gartify-dark">0</span>
                  <span className="mb-1 text-xl font-semibold text-gartify-dark">€</span>
                  <span className="mb-1 text-sm text-gartify-gray">/mes</span>
                </div>
                <p className="text-sm font-bold text-gartify-green mb-2">Gratis</p>
                <p className="text-sm text-gartify-gray leading-relaxed">
                  Alta gratuita sin permanencia. Ideal para empezar a recibir
                  reservas online.
                </p>
              </div>

              {/* Características */}
              <ul className="mb-8 flex-1 space-y-3">
                {[
                  { icono: Check, texto: "Perfil verificado en el directorio" },
                  { icono: Check, texto: "Hasta 4 servicios publicados" },
                  { icono: Check, texto: "Gestión de reservas online" },
                  { icono: Check, texto: "Reseñas y valoraciones" },
                  { icono: Check, texto: "Soporte por email" },
                ].map(({ icono: Icono, texto }) => (
                  <li key={texto} className="flex items-center gap-3 text-sm text-gartify-dark">
                    <Icono className="h-4 w-4 shrink-0 text-gartify-green" />
                    {texto}
                  </li>
                ))}
              </ul>

              {/* CTA */}
              <Link href="/registro/taller">
                <Button
                  variant="outline"
                  className="w-full border-gartify-gray/40 text-gartify-dark hover:bg-slate-50"
                  size="lg"
                >
                  Empezar gratis
                </Button>
              </Link>
            </div>

            {/* ── Plan Pro (destacado) ──────────────────── */}
            <div className="relative flex flex-col rounded-2xl border-2 border-gartify-orange bg-white p-8 shadow-xl ring-4 ring-gartify-orange/10 transition-shadow duration-300 hover:shadow-2xl">
              {/* Badge más popular */}
              <div className="absolute -top-4 left-1/2 -translate-x-1/2">
                <span className="inline-flex items-center gap-1.5 rounded-full bg-gartify-orange px-4 py-1.5 text-xs font-bold uppercase tracking-wide text-white shadow-md">
                  <Star className="h-3 w-3" />
                  Más popular
                </span>
              </div>

              {/* Cabecera */}
              <div className="mb-6 mt-2">
                <div className="mb-4 flex h-12 w-12 items-center justify-center rounded-2xl bg-gartify-orange/10">
                  <Zap className="h-6 w-6 text-gartify-orange" />
                </div>
                <p className="text-xs font-bold uppercase tracking-widest text-gartify-orange mb-1">
                  Pro
                </p>
                <div className="flex items-end gap-1 mb-2">
                  <span className="text-5xl font-bold text-gartify-dark">{precioPro}</span>
                  <span className="mb-1 text-xl font-semibold text-gartify-dark">€</span>
                  <span className="mb-1 text-sm text-gartify-gray">/mes</span>
                </div>
                {!esMensual && (
                  <p className="text-sm text-gartify-gray mb-1">
                    <span className="line-through">29 €/mes</span>{" "}
                    <span className="font-semibold text-gartify-green">Ahorra 87 €/año</span>
                  </p>
                )}
                <p className="text-sm text-gartify-gray leading-relaxed">
                  Cuota mensual fija. Sin comisiones por reserva. Crece con
                  todas las herramientas.
                </p>
              </div>

              {/* Características adicionales */}
              <ul className="mb-8 flex-1 space-y-3">
                {[
                  { icono: Check,          texto: "Todo lo del plan Starter" },
                  { icono: Wrench,         texto: "Servicios ilimitados" },
                  { icono: Tag,            texto: "Ofertas especiales de horario" },
                  { icono: Search,         texto: "Posición destacada en búsqueda" },
                  { icono: Bell,           texto: "Notificaciones automáticas al cliente" },
                  { icono: BarChart3,      texto: "Panel de estadísticas" },
                  { icono: Tv,             texto: "Modo TV — pantalla de citas en tiempo real" },
                  { icono: MessageCircle,  texto: "Gestión de reservas por WhatsApp" },
                ].map(({ icono: Icono, texto }) => (
                  <li key={texto} className="flex items-center gap-3 text-sm text-gartify-dark">
                    <Icono className="h-4 w-4 shrink-0 text-gartify-orange" />
                    {texto}
                  </li>
                ))}
              </ul>

              {/* CTA */}
              <Link href="/registro/taller?plan=pro">
                <Button
                  className="w-full bg-gartify-orange text-white hover:bg-gartify-orange/90 font-semibold"
                  size="lg"
                >
                  Empezar con Pro
                </Button>
              </Link>
            </div>

            {/* ── Plan Premium ──────────────────────────── */}
            <div className="flex flex-col rounded-2xl border border-slate-200 bg-gartify-dark p-8 shadow-sm hover:shadow-md transition-shadow duration-300">
              {/* Cabecera */}
              <div className="mb-6">
                <div className="mb-4 flex h-12 w-12 items-center justify-center rounded-2xl bg-gartify-orange/20">
                  <Crown className="h-6 w-6 text-gartify-orange" />
                </div>
                <p className="text-xs font-bold uppercase tracking-widest text-gartify-orange mb-1">
                  Premium
                </p>
                <div className="flex items-end gap-1 mb-1">
                  <span className="text-5xl font-bold text-white">
                    {precioPremium}
                  </span>
                  <span className="mb-1 text-xl font-semibold text-white">€</span>
                  <span className="mb-1 text-sm text-slate-400">/mes</span>
                </div>
                {/* Precio tachado mensual cuando se muestra anual */}
                {!esMensual && (
                  <p className="text-sm text-slate-400 mb-1">
                    <span className="line-through">79 €/mes</span>{" "}
                    <span className="font-semibold text-gartify-green">
                      Ahorra 237 €/año
                    </span>
                  </p>
                )}
                <p className="text-sm text-slate-400 leading-relaxed">
                  Máxima visibilidad y herramientas exclusivas para talleres que
                  quieren liderar su zona.
                </p>
              </div>

              {/* Características */}
              <ul className="mb-8 flex-1 space-y-3">
                {[
                  { icono: Check,      texto: "Todo lo del plan Pro" },
                  { icono: Package,    texto: "Red de distribuidores de recambios" },
                  { icono: Crown,      texto: 'Badge "Taller Premium" visible' },
                  { icono: Headphones, texto: "Soporte prioritario 24 h" },
                  { icono: Tag,        texto: "Cupones y promociones de marketing" },
                  { icono: BarChart3,  texto: "Estadísticas avanzadas e informes PDF" },
                ].map(({ icono: Icono, texto }) => (
                  <li key={texto} className="flex items-center gap-3 text-sm text-white">
                    <Icono className="h-4 w-4 shrink-0 text-gartify-orange" />
                    {texto}
                  </li>
                ))}
              </ul>

              {/* CTA */}
              <Link href="/contacto">
                <Button
                  className="w-full bg-gartify-green hover:bg-gartify-green/90 text-white"
                  size="lg"
                >
                  Solicitar demo
                </Button>
              </Link>
            </div>
          </div>
        </div>
      </section>

      {/* ══════════════════════════════════════════════════
          3. TABLA COMPARATIVA
      ══════════════════════════════════════════════════ */}
      <section className="bg-white py-20">
        <div className="container max-w-5xl">
          <div className="mb-12 text-center">
            <EtiquetaSeccion>Comparativa completa</EtiquetaSeccion>
            <h2 className="text-2xl font-bold text-gartify-dark md:text-3xl">
              Elige el plan que necesitas
            </h2>
          </div>

          <div className="overflow-x-auto rounded-2xl border border-slate-200 shadow-sm">
            <table className="w-full min-w-[600px] text-sm">
              {/* Cabecera de planes */}
              <thead>
                <tr className="border-b border-slate-200">
                  <th className="px-6 py-5 text-left text-sm font-semibold text-gartify-gray w-1/2">
                    Característica
                  </th>
                  <th className="px-4 py-5 text-center">
                    <span className="text-xs font-bold uppercase tracking-widest text-gartify-gray">
                      Starter
                    </span>
                    <br />
                    <span className="text-lg font-bold text-gartify-dark">Gratis</span>
                  </th>
                  <th className="bg-gartify-orange/5 px-4 py-5 text-center">
                    <span className="inline-flex items-center gap-1 text-xs font-bold uppercase tracking-widest text-gartify-orange">
                      <Star className="h-3 w-3" />
                      Pro
                    </span>
                    <br />
                    <span className="text-lg font-bold text-gartify-dark">{precioPro} €/mes</span>
                  </th>
                  <th className="bg-gartify-dark px-4 py-5 text-center rounded-tr-2xl">
                    <span className="text-xs font-bold uppercase tracking-widest text-gartify-orange">
                      Premium
                    </span>
                    <br />
                    <span className="text-lg font-bold text-white">
                      {precioPremium} €/mes
                    </span>
                  </th>
                </tr>
              </thead>
              <tbody>
                {CARACTERISTICAS.map(({ texto, starter, pro, premium }, i) => (
                  <tr
                    key={texto}
                    className={cn(
                      "border-b border-slate-100 last:border-0",
                      i % 2 === 0 ? "bg-white" : "bg-slate-50/60"
                    )}
                  >
                    <td className="px-6 py-3.5 text-gartify-dark font-medium">
                      {texto}
                    </td>
                    <td className="px-4 py-3.5 text-center">
                      <IconoCaracteristica valor={starter} />
                    </td>
                    <td className="bg-gartify-orange/5 px-4 py-3.5 text-center">
                      <IconoCaracteristica valor={pro} />
                    </td>
                    <td className="bg-gartify-dark/5 px-4 py-3.5 text-center">
                      <IconoCaracteristica valor={premium} />
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </section>

      {/* ══════════════════════════════════════════════════
          4. FAQ
      ══════════════════════════════════════════════════ */}
      <section className="bg-slate-50 py-20">
        <div className="container max-w-3xl">
          <div className="mb-12 text-center">
            <EtiquetaSeccion>Preguntas frecuentes</EtiquetaSeccion>
            <h2 className="text-2xl font-bold text-gartify-dark md:text-3xl">
              Resolvemos tus dudas
            </h2>
          </div>

          <div className="space-y-3">
            {PREGUNTAS_FRECUENTES.map(({ pregunta, respuesta }) => (
              <details
                key={pregunta}
                className="group rounded-2xl border border-slate-200 bg-white shadow-sm open:shadow-md transition-shadow duration-200"
              >
                <summary className="flex cursor-pointer list-none items-center justify-between gap-4 px-6 py-5 font-semibold text-gartify-dark select-none">
                  {pregunta}
                  <ChevronDown
                    className="h-5 w-5 shrink-0 text-gartify-gray transition-transform duration-200 group-open:rotate-180"
                    aria-hidden="true"
                  />
                </summary>
                <div className="border-t border-slate-100 px-6 py-4 text-sm leading-relaxed text-gartify-gray">
                  {respuesta}
                </div>
              </details>
            ))}
          </div>
        </div>
      </section>

      {/* ══════════════════════════════════════════════════
          5. CTA FINAL
      ══════════════════════════════════════════════════ */}
      <section className="bg-gradient-to-r from-gartify-hero to-gartify-mid py-20">
        <div className="container max-w-3xl text-center">
          <div className="pointer-events-none absolute inset-0 overflow-hidden">
            <div className="absolute -left-10 top-0 h-64 w-64 rounded-full bg-gartify-orange/20 blur-3xl" />
            <div className="absolute -right-10 bottom-0 h-64 w-64 rounded-full bg-white/10 blur-3xl" />
          </div>

          <h2 className="mb-4 text-3xl font-bold text-white md:text-4xl">
            ¿Tienes dudas?{" "}
            <span className="text-gartify-orange">Habla con nuestro equipo</span>
          </h2>
          <p className="mx-auto mb-8 max-w-xl text-lg leading-relaxed text-blue-100">
            Te ayudamos a elegir el plan más adecuado para el volumen y las
            necesidades de tu taller. Sin compromiso.
          </p>
          <div className="flex flex-col items-center justify-center gap-4 sm:flex-row">
            <Link href="/contacto">
              <Button
                className="bg-gartify-orange text-white hover:bg-gartify-orange/90 font-semibold px-8"
                size="lg"
              >
                Contactar con el equipo
              </Button>
            </Link>
            <Link href="/registro/taller">
              <Button
                className="bg-gartify-green hover:bg-gartify-green/90 text-white px-8"
                size="lg"
              >
                Empezar gratis ahora
              </Button>
            </Link>
          </div>
        </div>
      </section>
    </>
  );
}
