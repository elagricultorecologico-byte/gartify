import type { Metadata } from "next";
import { notFound } from "next/navigation";
import Link from "next/link";
import { db } from "@/lib/db";
import { formatPrice } from "@/lib/utils";
import { SERVICE_LABELS } from "@/lib/constants";
import { MapPin, Phone, Star, Clock, CheckCircle, MessageCircle, Calendar } from "lucide-react";

// ─── Tipos locales ──────────────────────────────────────────────────────────

interface PropsLandingTaller {
  params: Promise<{ slug: string }>;
}

// ─── Metadata SEO dinámica ──────────────────────────────────────────────────

export async function generateMetadata({ params }: PropsLandingTaller): Promise<Metadata> {
  const { slug } = await params;

  const garage = await db.garage.findUnique({
    where: { slug },
    select: { name: true, city: true, description: true, plan: true },
  });

  if (!garage || !["PRO", "PREMIUM"].includes(garage.plan)) {
    return { title: "Taller no encontrado" };
  }

  return {
    title: `${garage.name} — Taller en ${garage.city} | Gartify`,
    description:
      garage.description ??
      `Reserva cita en ${garage.name}, taller de confianza en ${garage.city}. Servicios de mecánica, mantenimiento y más.`,
    openGraph: {
      title: `${garage.name} — Taller en ${garage.city}`,
      description:
        garage.description ??
        `Reserva cita en ${garage.name}, taller en ${garage.city}.`,
      type: "website",
    },
  };
}

// ─── Componente estrellas ───────────────────────────────────────────────────

function Estrellas({ rating, max = 5 }: { rating: number; max?: number }) {
  return (
    <span className="flex items-center gap-0.5" aria-label={`Valoración: ${rating.toFixed(1)} de ${max}`}>
      {Array.from({ length: max }).map((_, i) => (
        <Star
          key={i}
          className={`h-4 w-4 ${
            i < Math.floor(rating)
              ? "fill-yellow-400 text-yellow-400"
              : i < rating
              ? "fill-yellow-200 text-yellow-300"
              : "fill-gray-100 text-gray-300"
          }`}
          aria-hidden="true"
        />
      ))}
    </span>
  );
}

// ─── Página ─────────────────────────────────────────────────────────────────

export default async function LandingTallerPage({ params }: PropsLandingTaller) {
  const { slug } = await params;

  // Solo disponible para talleres PRO o PREMIUM con slug registrado
  const garage = await db.garage.findUnique({
    where: { slug },
    select: {
      id: true,
      name: true,
      description: true,
      address: true,
      city: true,
      province: true,
      phone: true,
      email: true,
      logo: true,
      rating: true,
      reviewCount: true,
      plan: true,
      courtesyCar: true,
      pickupService: true,
      isActive: true,
      services: {
        where: { isActive: true },
        select: {
          id: true,
          type: true,
          name: true,
          description: true,
          price: true,
          duration: true,
        },
        orderBy: { price: "asc" },
        take: 12,
      },
      reviews: {
        orderBy: { createdAt: "desc" },
        take: 3,
        select: {
          id: true,
          rating: true,
          comment: true,
          createdAt: true,
          user: { select: { name: true } },
        },
      },
      schedules: {
        orderBy: { dayOfWeek: "asc" },
        select: {
          dayOfWeek: true,
          isOpen: true,
          openTime: true,
          closeTime: true,
          afternoonStart: true,
          afternoonEnd: true,
        },
      },
    },
  });

  // El taller debe existir, tener plan PRO o PREMIUM y estar activo
  if (!garage || !["PRO", "PREMIUM"].includes(garage.plan) || !garage.isActive) {
    notFound();
  }

  // Construir URL de WhatsApp si hay teléfono (limpiar a solo dígitos)
  const telefonoDigitos = garage.phone.replace(/\D/g, "");
  const urlWhatsApp = telefonoDigitos
    ? `https://wa.me/${telefonoDigitos.startsWith("34") ? telefonoDigitos : `34${telefonoDigitos}`}`
    : null;

  const urlReserva = `/talleres/${garage.id}/reservar`;
  const baseUrl = process.env.NEXT_PUBLIC_BASE_URL ?? "https://gartify.es";

  // Nombres de los días de la semana en español
  const DIAS_SEMANA = ["Dom", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb"];

  return (
    <>
      {/* ── Hero del taller ────────────────────────────────────────────────── */}
      <header className="bg-gartify-dark text-white">
        <div className="max-w-4xl mx-auto px-4 py-8 sm:py-12">
          <div className="flex flex-col sm:flex-row items-start sm:items-center gap-5">
            {/* Logo */}
            <div className="shrink-0 h-20 w-20 sm:h-24 sm:w-24 overflow-hidden border-2 border-white/20 bg-white/10 flex items-center justify-center">
              {garage.logo ? (
                // eslint-disable-next-line @next/next/no-img-element
                <img
                  src={garage.logo}
                  alt={`Logo de ${garage.name}`}
                  className="w-full h-full object-cover"
                />
              ) : (
                // eslint-disable-next-line @next/next/no-img-element
                <img
                  src="/logo-letra-fondo-azul.png"
                  alt="Gartify"
                  className="w-full h-full object-cover"
                />
              )}
            </div>

            {/* Nombre, ciudad y valoración */}
            <div className="flex-1 min-w-0">
              {garage.plan === "PREMIUM" && (
                <span className="inline-block mb-2 px-2.5 py-0.5 bg-yellow-400/20 text-yellow-300 text-xs font-bold uppercase tracking-wider border border-yellow-400/30">
                  Premium
                </span>
              )}
              <h1 className="text-2xl sm:text-3xl font-bold leading-tight">{garage.name}</h1>
              <div className="flex flex-wrap items-center gap-x-4 gap-y-1.5 mt-2">
                <span className="flex items-center gap-1.5 text-sm text-white/70">
                  <MapPin className="h-3.5 w-3.5 shrink-0" aria-hidden="true" />
                  {garage.city}{garage.province ? `, ${garage.province}` : ""}
                </span>
                {garage.reviewCount > 0 && (
                  <span className="flex items-center gap-1.5">
                    <Estrellas rating={garage.rating} />
                    <span className="text-sm text-white/70">
                      {garage.rating.toFixed(1)} ({garage.reviewCount} {garage.reviewCount === 1 ? "reseña" : "reseñas"})
                    </span>
                  </span>
                )}
              </div>
              {garage.description && (
                <p className="mt-3 text-sm text-white/80 leading-relaxed max-w-2xl">
                  {garage.description}
                </p>
              )}
            </div>
          </div>

          {/* CTAs en el header */}
          <div className="flex flex-wrap gap-3 mt-6">
            <Link
              href={urlReserva}
              className="inline-flex items-center gap-2 px-6 py-3 bg-gartify-orange hover:bg-gartify-orange/90 text-white font-bold text-sm transition-colors"
            >
              <Calendar className="h-4 w-4" aria-hidden="true" />
              Reservar cita
            </Link>
            {urlWhatsApp && (
              <a
                href={urlWhatsApp}
                target="_blank"
                rel="noopener noreferrer"
                className="inline-flex items-center gap-2 px-6 py-3 bg-[#25D366] hover:bg-[#22c35e] text-white font-bold text-sm transition-colors"
              >
                <MessageCircle className="h-4 w-4" aria-hidden="true" />
                WhatsApp
              </a>
            )}
            {garage.phone && (
              <a
                href={`tel:${garage.phone}`}
                className="inline-flex items-center gap-2 px-6 py-3 bg-white/10 hover:bg-white/20 text-white font-semibold text-sm transition-colors border border-white/20"
              >
                <Phone className="h-4 w-4" aria-hidden="true" />
                {garage.phone}
              </a>
            )}
          </div>
        </div>
      </header>

      {/* ── Contenido principal ─────────────────────────────────────────────── */}
      <main className="max-w-4xl mx-auto px-4 py-8 space-y-10 pb-28 sm:pb-10">

        {/* Badges de servicios extra */}
        {(garage.courtesyCar || garage.pickupService) && (
          <section aria-label="Servicios adicionales">
            <div className="flex flex-wrap gap-2">
              {garage.courtesyCar && (
                <span className="flex items-center gap-1.5 px-3 py-1.5 bg-gartify-blue/5 border border-gartify-blue/20 text-gartify-blue text-sm font-medium">
                  <CheckCircle className="h-3.5 w-3.5" aria-hidden="true" />
                  Vehículo de cortesía
                </span>
              )}
              {garage.pickupService && (
                <span className="flex items-center gap-1.5 px-3 py-1.5 bg-gartify-blue/5 border border-gartify-blue/20 text-gartify-blue text-sm font-medium">
                  <CheckCircle className="h-3.5 w-3.5" aria-hidden="true" />
                  Servicio de recogida
                </span>
              )}
            </div>
          </section>
        )}

        {/* ── Servicios ──────────────────────────────────────────────────────── */}
        {garage.services.length > 0 && (
          <section aria-labelledby="titulo-servicios">
            <h2 id="titulo-servicios" className="text-lg font-bold text-gartify-dark mb-4 flex items-center gap-2">
              Servicios disponibles
            </h2>
            <div className="grid grid-cols-1 sm:grid-cols-2 gap-3">
              {garage.services.map((servicio) => (
                <div
                  key={servicio.id}
                  className="flex items-start justify-between gap-4 p-4 border border-gray-200 bg-white hover:border-gartify-orange/40 transition-colors"
                >
                  <div className="flex-1 min-w-0">
                    <p className="font-semibold text-gartify-dark text-sm">
                      {servicio.name}
                    </p>
                    <p className="text-xs text-gartify-gray mt-0.5 capitalize">
                      {SERVICE_LABELS[servicio.type] ?? servicio.type}
                    </p>
                    {servicio.description && (
                      <p className="text-xs text-gray-500 mt-1 line-clamp-2">{servicio.description}</p>
                    )}
                    <p className="text-xs text-gartify-gray mt-1 flex items-center gap-1">
                      <Clock className="h-3 w-3" aria-hidden="true" />
                      {servicio.duration} min
                    </p>
                  </div>
                  <div className="shrink-0 text-right">
                    <p className="font-bold text-gartify-orange text-base">
                      {formatPrice(servicio.price)}
                    </p>
                  </div>
                </div>
              ))}
            </div>
          </section>
        )}

        {/* ── Horario ─────────────────────────────────────────────────────────── */}
        {garage.schedules.length > 0 && (
          <section aria-labelledby="titulo-horario">
            <h2 id="titulo-horario" className="text-lg font-bold text-gartify-dark mb-4">
              Horario
            </h2>
            <div className="border border-gray-200 divide-y divide-gray-100 max-w-sm">
              {garage.schedules.map((horario) => (
                <div key={horario.dayOfWeek} className="flex items-center justify-between px-4 py-2.5 text-sm">
                  <span className="font-medium text-gartify-dark w-10">
                    {DIAS_SEMANA[horario.dayOfWeek]}
                  </span>
                  {horario.isOpen ? (
                    <span className="text-gartify-gray">
                      {horario.afternoonStart
                        ? `${horario.openTime}–${horario.closeTime} / ${horario.afternoonStart}–${horario.afternoonEnd}`
                        : `${horario.openTime}–${horario.closeTime}`}
                    </span>
                  ) : (
                    <span className="text-red-500 text-xs font-medium">Cerrado</span>
                  )}
                </div>
              ))}
            </div>
          </section>
        )}

        {/* ── Reseñas ─────────────────────────────────────────────────────────── */}
        {garage.reviews.length > 0 && (
          <section aria-labelledby="titulo-resenas">
            <h2 id="titulo-resenas" className="text-lg font-bold text-gartify-dark mb-4">
              Opiniones de clientes
            </h2>
            <div className="space-y-3">
              {garage.reviews.map((resena) => (
                <div key={resena.id} className="p-4 border border-gray-200 bg-white">
                  <div className="flex items-start justify-between gap-3">
                    <div>
                      <p className="text-sm font-semibold text-gartify-dark">
                        {resena.user.name ?? "Cliente verificado"}
                      </p>
                      <Estrellas rating={resena.rating} />
                    </div>
                    <time
                      dateTime={resena.createdAt.toISOString()}
                      className="text-xs text-gartify-gray shrink-0"
                    >
                      {new Intl.DateTimeFormat("es-ES", { dateStyle: "medium" }).format(resena.createdAt)}
                    </time>
                  </div>
                  {resena.comment && (
                    <p className="mt-2 text-sm text-gray-600 leading-relaxed">{resena.comment}</p>
                  )}
                </div>
              ))}
            </div>
          </section>
        )}

        {/* ── Pie de página de la landing ─────────────────────────────────────── */}
        <footer className="pt-4 border-t border-gray-100 text-center">
          <p className="text-xs text-gartify-gray">
            Esta página está gestionada por{" "}
            <a
              href={`${baseUrl}/talleres/${garage.id}`}
              className="text-gartify-blue hover:underline font-medium"
            >
              {garage.name}
            </a>{" "}
            a través de{" "}
            <a href={baseUrl} className="text-gartify-orange hover:underline font-medium">
              Gartify
            </a>
          </p>
        </footer>
      </main>

      {/* ── CTA fijo en mobile ──────────────────────────────────────────────── */}
      <div className="fixed bottom-0 left-0 right-0 sm:hidden z-50 bg-white border-t border-gray-200 p-3 flex gap-2 shadow-lg">
        <Link
          href={urlReserva}
          className="flex-1 flex items-center justify-center gap-2 py-3 bg-gartify-orange hover:bg-gartify-orange/90 text-white font-bold text-sm transition-colors"
        >
          <Calendar className="h-4 w-4" aria-hidden="true" />
          Reservar ahora
        </Link>
        {urlWhatsApp && (
          <a
            href={urlWhatsApp}
            target="_blank"
            rel="noopener noreferrer"
            className="flex items-center justify-center gap-2 px-4 py-3 bg-[#25D366] text-white font-bold text-sm"
          >
            <MessageCircle className="h-4 w-4" aria-hidden="true" />
          </a>
        )}
      </div>
    </>
  );
}
