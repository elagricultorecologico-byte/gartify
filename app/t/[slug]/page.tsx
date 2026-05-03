import type { Metadata } from "next";
import { notFound } from "next/navigation";
import Link from "next/link";
import { db } from "@/lib/db";
import { formatPrice } from "@/lib/utils";
import { SERVICE_LABELS } from "@/lib/constants";
import { MapPin, Phone, Star, Clock, CheckCircle, MessageCircle, Calendar, ChevronRight } from "lucide-react";
import { LogoTaller } from "@/components/t/LogoTaller";

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

function Estrellas({ rating, size = "sm" }: { rating: number; size?: "sm" | "lg" }) {
  const cls = size === "lg" ? "h-6 w-6" : "h-4 w-4";
  return (
    <span className="flex items-center gap-0.5" aria-label={`Valoración: ${rating.toFixed(1)} de 5`}>
      {Array.from({ length: 5 }).map((_, i) => (
        <Star
          key={i}
          className={`${cls} ${
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

// ─── Helpers de horario ─────────────────────────────────────────────────────

function horaEnRango(hora: string, inicio: string, fin: string) {
  return hora >= inicio && hora <= fin;
}

// ─── Página ─────────────────────────────────────────────────────────────────

export default async function LandingTallerPage({ params }: PropsLandingTaller) {
  const { slug } = await params;

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
      coverImage: true,
      rating: true,
      reviewCount: true,
      plan: true,
      courtesyCar: true,
      pickupService: true,
      isActive: true,
      services: {
        where: { isActive: true },
        select: { id: true, type: true, name: true, description: true, price: true, duration: true },
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

  if (!garage || !["PRO", "PREMIUM"].includes(garage.plan) || !garage.isActive) {
    notFound();
  }

  // ── Cálculos de horario (servidor, zona horaria España) ──────────────────
  const nowMadrid = new Date(new Date().toLocaleString("en-US", { timeZone: "Europe/Madrid" }));
  const todayDow = nowMadrid.getDay(); // 0=Dom … 6=Sáb
  const horaActual = `${String(nowMadrid.getHours()).padStart(2, "0")}:${String(nowMadrid.getMinutes()).padStart(2, "0")}`;

  const horarioHoy = garage.schedules.find(s => s.dayOfWeek === todayDow);
  const abiertoAhora =
    horarioHoy?.isOpen &&
    horarioHoy.openTime &&
    horarioHoy.closeTime &&
    (horaEnRango(horaActual, horarioHoy.openTime, horarioHoy.closeTime) ||
      (horarioHoy.afternoonStart && horarioHoy.afternoonEnd &&
        horaEnRango(horaActual, horarioHoy.afternoonStart, horarioHoy.afternoonEnd)));

  // Próxima cita disponible (hoy si está abierto, mañana u otro día)
  const DIAS_SEMANA = ["Dom", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb"];
  let proximaCita = abiertoAhora ? "hoy" : "";
  if (!proximaCita) {
    for (let i = 1; i <= 7; i++) {
      const checkDow = (todayDow + i) % 7;
      const s = garage.schedules.find(h => h.dayOfWeek === checkDow);
      if (s?.isOpen) {
        proximaCita = i === 1 ? "mañana" : `el ${DIAS_SEMANA[checkDow]}`;
        break;
      }
    }
  }

  // ── Precio mínimo y URLs ─────────────────────────────────────────────────
  const precioDesde = garage.services.length > 0 ? Math.min(...garage.services.map(s => s.price)) : null;
  const telefonoDigitos = garage.phone.replace(/\D/g, "");
  const urlWhatsApp = telefonoDigitos
    ? `https://wa.me/${telefonoDigitos.startsWith("34") ? telefonoDigitos : `34${telefonoDigitos}`}`
    : null;
  const urlReserva = `/talleres/${garage.id}/reservar`;
  const baseUrl = process.env.NEXT_PUBLIC_BASE_URL ?? "https://gartify.es";

  return (
    <>
      {/* ── Hero ────────────────────────────────────────────────────────────── */}
      <header className="relative bg-gartify-dark text-white overflow-hidden">
        {garage.coverImage && (
          <>
            {/* eslint-disable-next-line @next/next/no-img-element */}
            <img src={garage.coverImage} alt="" aria-hidden="true" className="absolute inset-0 w-full h-full object-cover" />
            <div className="absolute inset-0 bg-gartify-dark/75" />
          </>
        )}

        <div className="relative max-w-4xl mx-auto px-4 py-8 sm:py-12">
          <div className="flex flex-col gap-3">

            <div className="flex-1 min-w-0">
              {/* Badge Premium */}
              {garage.plan === "PREMIUM" && (
                <span className="inline-block mb-2 px-2.5 py-0.5 bg-yellow-400/20 text-yellow-300 text-xs font-bold uppercase tracking-wider border border-yellow-400/30">
                  Premium
                </span>
              )}

              {/* Logo + nombre en línea */}
              <div className="flex items-center gap-3">
                <div className="shrink-0 h-12 w-12 sm:h-14 sm:w-14 overflow-hidden border-2 border-white/20 bg-white/10 flex items-center justify-center rounded-sm">
                  <LogoTaller src={garage.logo} nombre={garage.name} />
                </div>
                <h1 className="text-2xl sm:text-3xl font-bold leading-tight">{garage.name}</h1>
              </div>

              {/* Ciudad + estado abierto/cerrado */}
              <div className="flex flex-wrap items-center gap-3 mt-2">
                <span className="flex items-center gap-1.5 text-sm text-white/70">
                  <MapPin className="h-3.5 w-3.5 shrink-0" aria-hidden="true" />
                  {garage.city}{garage.province ? `, ${garage.province}` : ""}
                </span>

                {/* Badge abierto/cerrado */}
                {horarioHoy && (
                  <span className={`flex items-center gap-1.5 px-2.5 py-0.5 rounded-full text-xs font-bold border ${
                    abiertoAhora
                      ? "bg-green-500/20 text-green-300 border-green-500/30"
                      : "bg-red-500/20 text-red-300 border-red-500/30"
                  }`}>
                    <span className={`h-1.5 w-1.5 rounded-full ${abiertoAhora ? "bg-green-400 animate-pulse" : "bg-red-400"}`} />
                    {abiertoAhora
                      ? `Abierto · Cierra a las ${horarioHoy.afternoonEnd ?? horarioHoy.closeTime}`
                      : "Cerrado ahora"}
                  </span>
                )}
              </div>

              {/* ── Bloque de rating prominente ── */}
              {garage.reviewCount > 0 && (
                <div className="mt-4 inline-flex items-center gap-3 bg-white/10 border border-white/15 rounded-xl px-4 py-3">
                  <span className="text-3xl font-black text-white leading-none">
                    {garage.rating.toFixed(1)}
                  </span>
                  <div>
                    <Estrellas rating={garage.rating} size="lg" />
                    <p className="text-xs text-white/60 mt-1">
                      {garage.reviewCount} {garage.reviewCount === 1 ? "reseña verificada" : "reseñas verificadas"}
                    </p>
                  </div>
                </div>
              )}

              {/* Precio desde */}
              {precioDesde !== null && (
                <p className="mt-3 text-sm text-white/60">
                  Servicios <span className="text-white font-semibold">desde {formatPrice(precioDesde)}</span>
                </p>
              )}

              {garage.description && (
                <p className="mt-3 text-sm text-white/80 leading-relaxed max-w-2xl">{garage.description}</p>
              )}
            </div>

          {/* CTAs */}
          <div className="mt-6">
            <div className="flex flex-wrap gap-3">
              <Link
                href={urlReserva}
                className="inline-flex items-center justify-center gap-2 w-44 py-3 bg-gartify-orange hover:bg-gartify-orange/90 text-white font-bold text-sm transition-colors"
              >
                <Calendar className="h-4 w-4 shrink-0" aria-hidden="true" />
                Reservar cita
              </Link>
              {urlWhatsApp && (
                <a
                  href={urlWhatsApp}
                  target="_blank"
                  rel="noopener noreferrer"
                  className="inline-flex items-center justify-center gap-2 w-44 py-3 bg-[#25D366] hover:bg-[#22c35e] text-white font-bold text-sm transition-colors"
                >
                  <MessageCircle className="h-4 w-4 shrink-0" aria-hidden="true" />
                  WhatsApp
                </a>
              )}
              {garage.phone && (
                <a
                  href={`tel:${garage.phone}`}
                  className="inline-flex items-center justify-center gap-2 w-44 py-3 bg-white/10 hover:bg-white/20 text-white font-semibold text-sm transition-colors border border-white/20"
                >
                  <Phone className="h-4 w-4 shrink-0" aria-hidden="true" />
                  {garage.phone}
                </a>
              )}
            </div>
            {/* Próxima cita disponible */}
            {proximaCita && (
              <p className="text-xs text-white/50 mt-1.5 pl-1">
                Próxima cita disponible: <span className="text-white/80 font-medium">{proximaCita}</span>
              </p>
            )}
          </div>
          </div>{/* end flex flex-col gap-3 */}
        </div>
      </header>

      {/* ── Contenido principal ──────────────────────────────────────────────── */}
      <main className="max-w-4xl mx-auto px-4 py-8 space-y-10 pb-28 sm:pb-10">

        {/* Servicios extra */}
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

        {/* ── Servicios ── */}
        {garage.services.length > 0 && (
          <section aria-labelledby="titulo-servicios">
            <h2 id="titulo-servicios" className="text-lg font-bold text-gartify-dark mb-4">
              Servicios disponibles
            </h2>
            <div className="grid grid-cols-1 sm:grid-cols-2 gap-3">
              {garage.services.map((servicio) => (
                <div
                  key={servicio.id}
                  className="flex items-start justify-between gap-4 p-4 border border-gray-200 bg-white hover:border-gartify-orange/40 transition-colors rounded-lg"
                >
                  <div className="flex-1 min-w-0">
                    <p className="font-semibold text-gartify-dark text-sm">{servicio.name}</p>
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
                    <p className="font-bold text-gartify-orange text-base">{formatPrice(servicio.price)}</p>
                  </div>
                </div>
              ))}
            </div>
          </section>
        )}

        {/* ── Horario con día actual destacado ── */}
        {garage.schedules.length > 0 && (
          <section aria-labelledby="titulo-horario">
            <div className="flex items-center justify-between mb-4">
              <h2 id="titulo-horario" className="text-lg font-bold text-gartify-dark">Horario</h2>
              {horarioHoy && (
                <span className={`flex items-center gap-1.5 px-2.5 py-1 rounded-full text-xs font-bold ${
                  abiertoAhora ? "bg-green-100 text-green-700" : "bg-red-50 text-red-600"
                }`}>
                  <span className={`h-1.5 w-1.5 rounded-full ${abiertoAhora ? "bg-green-500 animate-pulse" : "bg-red-400"}`} />
                  {abiertoAhora ? "Abierto ahora" : "Cerrado ahora"}
                </span>
              )}
            </div>
            <div className="border border-gray-200 divide-y divide-gray-100 max-w-sm rounded-lg overflow-hidden">
              {garage.schedules.map((horario) => {
                const esHoy = horario.dayOfWeek === todayDow;
                return (
                  <div
                    key={horario.dayOfWeek}
                    className={`flex items-center justify-between px-4 py-2.5 text-sm ${
                      esHoy ? "bg-gartify-blue/5 font-semibold" : ""
                    }`}
                  >
                    <span className={`w-10 ${esHoy ? "text-gartify-blue font-bold" : "text-gartify-dark font-medium"}`}>
                      {DIAS_SEMANA[horario.dayOfWeek]}
                      {esHoy && <span className="ml-1 text-[10px] text-gartify-blue">●</span>}
                    </span>
                    {horario.isOpen ? (
                      <span className="text-gartify-gray">
                        {horario.afternoonStart
                          ? `${horario.openTime}–${horario.closeTime} / ${horario.afternoonStart}–${horario.afternoonEnd}`
                          : `${horario.openTime}–${horario.closeTime}`}
                      </span>
                    ) : (
                      <span className="text-red-400 text-xs font-medium">Cerrado</span>
                    )}
                  </div>
                );
              })}
            </div>
          </section>
        )}

        {/* ── Reseñas con resumen ── */}
        {garage.reviews.length > 0 && (
          <section aria-labelledby="titulo-resenas">
            {/* Resumen numérico */}
            <div className="flex items-center gap-4 mb-6">
              <div className="text-center">
                <p className="text-5xl font-black text-gartify-dark leading-none">{garage.rating.toFixed(1)}</p>
                <Estrellas rating={garage.rating} size="lg" />
                <p className="text-xs text-gartify-gray mt-1">
                  {garage.reviewCount} {garage.reviewCount === 1 ? "reseña" : "reseñas"}
                </p>
              </div>
              <div className="flex-1 border-l border-gray-200 pl-4">
                <h2 id="titulo-resenas" className="text-lg font-bold text-gartify-dark mb-1">
                  Opiniones de clientes
                </h2>
                <p className="text-sm text-gartify-gray">Reseñas verificadas de reservas realizadas en Gartify.</p>
              </div>
            </div>

            <div className="space-y-3">
              {garage.reviews.map((resena) => (
                <div key={resena.id} className="p-4 border border-gray-200 bg-white rounded-lg">
                  <div className="flex items-start justify-between gap-3">
                    <div>
                      <p className="text-sm font-semibold text-gartify-dark">
                        {resena.user.name ?? "Cliente verificado"}
                      </p>
                      <Estrellas rating={resena.rating} />
                    </div>
                    <time dateTime={resena.createdAt.toISOString()} className="text-xs text-gartify-gray shrink-0">
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

        {/* ── Footer como sello de confianza ── */}
        <footer className="pt-6 border-t border-gray-100">
          <div className="flex flex-col sm:flex-row items-center justify-between gap-3">
            <div className="flex items-center gap-2">
              {/* eslint-disable-next-line @next/next/no-img-element */}
              <img src="/logo-gartify-default.svg" alt="Gartify" className="h-6 w-auto" />
              <div>
                <p className="text-xs font-semibold text-gartify-dark">Reserva online segura</p>
                <p className="text-xs text-gartify-gray">Gestionada por Gartify · Taller verificado</p>
              </div>
            </div>
            <a
              href={`${baseUrl}/talleres/${garage.id}`}
              className="flex items-center gap-1 text-xs text-gartify-blue hover:underline font-medium"
            >
              Ver perfil completo en Gartify
              <ChevronRight className="h-3 w-3" />
            </a>
          </div>
        </footer>
      </main>

      {/* ── CTA fijo en mobile con teléfono ─────────────────────────────────── */}
      <div className="fixed bottom-0 left-0 right-0 sm:hidden z-50 bg-white border-t border-gray-200 p-3 flex gap-2 shadow-lg">
        <Link
          href={urlReserva}
          className="flex-1 flex items-center justify-center gap-2 py-3 bg-gartify-orange hover:bg-gartify-orange/90 text-white font-bold text-sm transition-colors rounded-lg"
        >
          <Calendar className="h-4 w-4" aria-hidden="true" />
          Reservar ahora
        </Link>
        {urlWhatsApp && (
          <a
            href={urlWhatsApp}
            target="_blank"
            rel="noopener noreferrer"
            aria-label="Contactar por WhatsApp"
            className="flex items-center justify-center px-4 py-3 bg-[#25D366] text-white font-bold text-sm rounded-lg"
          >
            <MessageCircle className="h-4 w-4" aria-hidden="true" />
          </a>
        )}
        {garage.phone && (
          <a
            href={`tel:${garage.phone}`}
            aria-label={`Llamar a ${garage.name}`}
            className="flex items-center justify-center px-4 py-3 bg-gartify-blue text-white font-bold text-sm rounded-lg"
          >
            <Phone className="h-4 w-4" aria-hidden="true" />
          </a>
        )}
      </div>
    </>
  );
}
