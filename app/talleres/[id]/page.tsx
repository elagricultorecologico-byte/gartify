import { notFound } from "next/navigation";
import type { Metadata } from "next";
import Link from "next/link";
import { db } from "@/lib/db";
import { Button } from "@/components/ui/button";
import { MapPin, Phone, Star, ShieldCheck, Clock, Wrench, CalendarCheck } from "lucide-react";
import { formatPrice, formatDate, SERVICE_LABELS } from "@/lib/utils";

function formatPhone(phone: string) {
  const digits = phone.replace(/\D/g, "");
  if (digits.startsWith("34") && digits.length === 11)
    return `+34 ${digits.slice(2, 5)} ${digits.slice(5, 7)} ${digits.slice(7, 9)} ${digits.slice(9)}`;
  if (digits.length === 9)
    return `${digits.slice(0, 3)} ${digits.slice(3, 5)} ${digits.slice(5, 7)} ${digits.slice(7)}`;
  return phone;
}
import { GarageReserveCTA } from "@/components/talleres/GarageReserveCTA";

export async function generateMetadata({ params }: { params: { id: string } }): Promise<Metadata> {
  const garage = await db.garage.findUnique({
    where: { id: params.id },
    select: { name: true, description: true, city: true },
  });
  if (!garage) return { title: "Taller no encontrado" };
  const description =
    garage.description ??
    `Reserva cita en ${garage.name}, taller mecánico en ${garage.city}. Compara precios y lee reseñas reales.`;
  return {
    title: `${garage.name} — Reserva cita online en ${garage.city}`,
    description,
    openGraph: { title: `${garage.name} | Gartify`, description, type: "website" },
    alternates: { canonical: `/talleres/${params.id}` },
  };
}

function StarRating({ rating, size = "sm" }: { rating: number; size?: "sm" | "lg" }) {
  const cls = size === "lg" ? "h-5 w-5" : "h-3.5 w-3.5";
  return (
    <div className="flex items-center gap-0.5">
      {[1, 2, 3, 4, 5].map((i) => (
        <Star
          key={i}
          className={`${cls} ${i <= Math.round(rating) ? "fill-yellow-400 text-yellow-400" : "fill-gray-200 text-gray-200"}`}
        />
      ))}
    </div>
  );
}

export default async function GarageDetailPage({ params }: { params: { id: string } }) {
  const garage = await db.garage.findUnique({
    where: { id: params.id, isActive: true },
    include: {
      services: { where: { isActive: true }, orderBy: { price: "asc" } },
      reviews: {
        include: {
          user:    { select: { name: true } },
          booking: { select: { service: { select: { name: true, type: true } } } },
        },
        orderBy: { createdAt: "desc" },
      },
    },
  });

  if (!garage) notFound();

  const initials = garage.name
    .split(" ")
    .slice(0, 2)
    .map((w) => w[0])
    .join("")
    .toUpperCase();
  const minPrice = garage.services.length > 0 ? garage.services[0].price : null;

  // Rating distribution (from loaded reviews)
  const dist = [5, 4, 3, 2, 1].map((star) => {
    const count = garage.reviews.filter((r) => r.rating === star).length;
    const pct   = garage.reviews.length > 0 ? Math.round((count / garage.reviews.length) * 100) : 0;
    return { star, count, pct };
  });

  const jsonLd = {
    "@context": "https://schema.org",
    "@type": "LocalBusiness",
    "@id": `https://gartify.es/talleres/${garage.id}`,
    name: garage.name,
    ...(garage.description && { description: garage.description }),
    url: `https://gartify.es/talleres/${garage.id}`,
    telephone: garage.phone,
    address: {
      "@type": "PostalAddress",
      streetAddress: garage.address,
      addressLocality: garage.city,
      postalCode: garage.postalCode,
      addressCountry: "ES",
    },
    ...(garage.lat &&
      garage.lng && {
        geo: { "@type": "GeoCoordinates", latitude: garage.lat, longitude: garage.lng },
      }),
    ...(garage.reviewCount > 0 && {
      aggregateRating: {
        "@type": "AggregateRating",
        ratingValue: garage.rating,
        reviewCount: garage.reviewCount,
      },
    }),
  };

  return (
    <>
      <script
        type="application/ld+json"
        dangerouslySetInnerHTML={{ __html: JSON.stringify(jsonLd) }}
      />

      <div className="container max-w-6xl py-8">
        {/* Breadcrumb */}
        <nav
          className="flex items-center gap-1.5 text-sm text-muted-foreground mb-6"
          aria-label="Migas de pan"
        >
          <Link href="/" className="hover:text-gartify-blue transition-colors">
            Inicio
          </Link>
          <span className="text-gray-300">/</span>
          <Link href="/talleres" className="hover:text-gartify-blue transition-colors">
            Talleres
          </Link>
          <span className="text-gray-300">/</span>
          <span className="text-gartify-blue font-medium truncate max-w-[200px]">
            {garage.name}
          </span>
        </nav>

        {/* Header card — full width */}
        <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden flex flex-col sm:flex-row mb-8">
          {/* Avatar strip */}
          <div className="sm:w-48 shrink-0 bg-gradient-to-br from-gartify-hero to-gartify-mid flex items-center justify-center min-h-[120px] sm:min-h-0">
            {garage.logo ? (
              // eslint-disable-next-line @next/next/no-img-element
              <img
                src={garage.logo}
                alt={garage.name}
                className="w-full h-full object-cover"
                loading="lazy"
              />
            ) : (
              <div className="flex flex-col items-center gap-3 p-6 text-center">
                <div className="h-16 w-16 rounded-2xl bg-white/20 border border-white/30 flex items-center justify-center shadow-inner">
                  <span className="text-2xl font-bold text-white tracking-tight">{initials}</span>
                </div>
                <p className="text-xs text-white/70 font-medium uppercase tracking-widest">
                  {garage.city}
                </p>
                <Wrench className="h-4 w-4 text-white/40" />
              </div>
            )}
          </div>

          {/* Info */}
          <div className="flex-1 p-6 flex flex-col gap-3">
            <div className="flex items-start justify-between gap-4 flex-wrap">
              <div>
                <div className="flex items-center gap-2 mb-1 flex-wrap">
                  <h1 className="text-2xl font-bold text-gartify-blue">{garage.name}</h1>
                  {garage.isVerified && (
                    <span className="inline-flex items-center gap-1 rounded-full bg-gartify-blue/10 text-gartify-blue border border-gartify-blue/20 text-xs font-semibold px-2 py-0.5">
                      <ShieldCheck className="h-3 w-3" />
                      Verificado
                    </span>
                  )}
                </div>
                <a
                  href={
                    garage.lat && garage.lng
                      ? `https://www.google.com/maps/dir/?api=1&destination=${garage.lat},${garage.lng}`
                      : `https://www.google.com/maps/dir/?api=1&destination=${encodeURIComponent(`${garage.address}, ${garage.city}`)}`
                  }
                  target="_blank"
                  rel="noopener noreferrer"
                  className="flex items-center gap-1 text-sm text-muted-foreground hover:text-gartify-mid transition-colors"
                  aria-label={`Cómo llegar a ${garage.name}`}
                >
                  <MapPin className="h-4 w-4 text-gartify-mid shrink-0" />
                  {garage.address}, {garage.city} {garage.postalCode}
                </a>
              </div>

              {/* Rating — enlace a la sección de valoraciones */}
              <a
                href="#valoraciones"
                className="flex flex-col items-end gap-1 shrink-0 group"
                aria-label="Ver valoraciones del taller"
              >
                <div className="flex items-center gap-2">
                  <StarRating rating={garage.rating} size="lg" />
                  <span className="text-2xl font-bold text-foreground group-hover:text-gartify-blue transition-colors">
                    {garage.rating.toFixed(1)}
                  </span>
                </div>
                <p className="text-xs text-muted-foreground group-hover:text-gartify-blue group-hover:underline transition-colors">
                  {garage.reviewCount} reseñas
                </p>
              </a>
            </div>

            {garage.description && (
              <p className="text-sm text-muted-foreground max-w-xl">{garage.description}</p>
            )}

            {/* Trust signals row */}
            <div className="flex flex-wrap items-center gap-x-5 gap-y-2 pt-3 mt-1 border-t border-gray-100">
              <div className="flex items-center gap-1.5 text-sm">
                <Wrench className="h-4 w-4 text-gartify-mid shrink-0" />
                <span className="font-semibold text-gartify-blue">{garage.services.length}</span>
                <span className="text-muted-foreground">servicios disponibles</span>
              </div>
              <a
                href={`tel:${formatPhone(garage.phone)}`}
                className="flex items-center gap-1.5 text-sm text-gartify-mid hover:text-gartify-hero transition-colors font-medium"
              >
                <Phone className="h-4 w-4 shrink-0" />
                {formatPhone(garage.phone)}
              </a>
            </div>
          </div>
        </div>

        {/* Two-column layout */}
        <div className="lg:grid lg:grid-cols-[1fr_300px] lg:gap-8 lg:items-start space-y-8 lg:space-y-0">

          {/* ── Main column ── */}
          <div className="space-y-8">

            {/* Services */}
            <section>
              <h2 className="text-xl font-bold text-gartify-blue mb-4">Servicios y precios</h2>
              <div className="grid sm:grid-cols-2 gap-3">
                {garage.services.map((service) => (
                  <div
                    key={service.id}
                    className="bg-white rounded-xl border border-gray-200 shadow-sm hover:shadow-md hover:border-gartify-mid/40 transition-all overflow-hidden flex flex-col"
                  >
                    {/* Top accent bar */}
                    <div className="h-1 w-full bg-gradient-to-r from-gartify-hero to-gartify-mid" />

                    <div className="p-4 flex flex-col gap-3 flex-1">
                      {/* Badge + duration */}
                      <div className="flex items-center justify-between gap-2">
                        <span className="inline-flex items-center rounded-full bg-blue-50 text-gartify-hero text-xs px-2.5 py-0.5 font-medium border border-blue-100">
                          {SERVICE_LABELS[service.type] ?? service.type}
                        </span>
                        <span className="flex items-center gap-1 text-xs text-muted-foreground shrink-0">
                          <Clock className="h-3.5 w-3.5 text-gartify-mid" />
                          {service.duration} min
                        </span>
                      </div>

                      {/* Name + description */}
                      <div>
                        <p className="font-bold text-gartify-blue text-sm leading-snug">
                          {service.name}
                        </p>
                        {service.description && (
                          <p className="text-xs text-muted-foreground mt-1 line-clamp-2">
                            {service.description}
                          </p>
                        )}
                      </div>

                      {/* Price + CTA */}
                      <div className="flex items-center justify-between gap-3 pt-2 border-t border-gray-100 mt-auto">
                        <div>
                          <p className="text-2xl font-bold text-gartify-blue leading-none">
                            {formatPrice(service.price)}
                          </p>
                          <p className="text-xs text-muted-foreground mt-0.5">precio estimado</p>
                        </div>
                        <Link href={`/talleres/${garage.id}/reservar?servicio=${service.id}`}>
                          <Button
                            size="lg"
                            className="bg-gartify-green hover:bg-gartify-green/90 text-white font-semibold px-5"
                          >
                            Reservar
                          </Button>
                        </Link>
                      </div>
                    </div>
                  </div>
                ))}
              </div>
            </section>

            {/* Reviews */}
            <section id="valoraciones" className="scroll-mt-24">
              <h2 className="text-xl font-bold text-gartify-blue mb-4">Valoraciones</h2>

              {garage.reviews.length === 0 ? (
                <div className="bg-white rounded-xl border border-dashed border-gray-200 p-8 text-center">
                  <Star className="h-8 w-8 mx-auto mb-3 text-gray-300" />
                  <p className="font-semibold text-gartify-blue text-sm">Aún no hay valoraciones</p>
                  <p className="text-xs text-muted-foreground mt-1">
                    Sé el primero en valorar este taller después de tu visita.
                  </p>
                </div>
              ) : (
                <>
                  {/* Summary + distribution */}
                  <div className="bg-white rounded-xl border border-gray-200 shadow-sm p-5 mb-4">
                    <div className="flex flex-col sm:flex-row items-start gap-6">
                      {/* Big score */}
                      <div className="text-center shrink-0 sm:w-28">
                        <p className="text-5xl font-bold text-gartify-blue leading-none">
                          {garage.rating.toFixed(1)}
                        </p>
                        <div className="mt-1.5 flex justify-center">
                          <StarRating rating={garage.rating} size="lg" />
                        </div>
                        <p className="text-xs text-muted-foreground mt-1">
                          {garage.reviewCount} {garage.reviewCount === 1 ? "valoración" : "valoraciones"}
                        </p>
                        {garage.rating >= 4.5 && (
                          <div className="mt-2 inline-flex items-center gap-1 text-xs font-semibold text-gartify-green bg-gartify-green/10 rounded-full px-2.5 py-1">
                            <ShieldCheck className="h-3 w-3" />
                            Top taller
                          </div>
                        )}
                      </div>

                      <div className="hidden sm:block w-px self-stretch bg-gray-100 shrink-0" />

                      {/* Distribution bars */}
                      <div className="flex-1 space-y-1.5 w-full">
                        {dist.map(({ star, count, pct }) => (
                          <div key={star} className="flex items-center gap-2">
                            <span className="text-xs text-muted-foreground w-3 shrink-0">{star}</span>
                            <Star className="h-3 w-3 fill-yellow-400 text-yellow-400 shrink-0" />
                            <div className="flex-1 h-2 bg-gray-100 rounded-full overflow-hidden">
                              <div
                                className="h-full bg-yellow-400 rounded-full transition-all"
                                style={{ width: `${pct}%` }}
                              />
                            </div>
                            <span className="text-xs text-muted-foreground w-6 text-right shrink-0">
                              {count}
                            </span>
                          </div>
                        ))}
                      </div>
                    </div>
                  </div>

                  {/* Review list */}
                  <div className="space-y-3">
                    {garage.reviews.map((review) => (
                      <div
                        key={review.id}
                        className="bg-white rounded-xl border border-gray-200 shadow-sm p-4"
                      >
                        <div className="flex items-start gap-3">
                          <div className="h-9 w-9 rounded-full bg-gartify-hero/10 flex items-center justify-center shrink-0">
                            <span className="text-xs font-bold text-gartify-hero">
                              {(review.user.name ?? "U")[0].toUpperCase()}
                            </span>
                          </div>
                          <div className="flex-1 min-w-0">
                            <div className="flex items-center gap-2 flex-wrap mb-1">
                              <p className="font-semibold text-gartify-blue text-sm">
                                {review.user.name ?? "Usuario"}
                              </p>
                              <StarRating rating={review.rating} />
                              <span className="text-xs text-muted-foreground ml-auto">
                                {formatDate(review.createdAt)}
                              </span>
                            </div>
                            <span className="inline-flex items-center rounded-full bg-blue-50 text-gartify-hero text-xs px-2 py-0.5 font-medium border border-blue-100 mb-1.5">
                              {SERVICE_LABELS[review.booking.service.type] ?? review.booking.service.name}
                            </span>
                            {review.comment && (
                              <p className="text-sm text-muted-foreground mt-1 leading-relaxed">
                                {review.comment}
                              </p>
                            )}
                          </div>
                        </div>
                      </div>
                    ))}
                  </div>
                </>
              )}
            </section>
          </div>

          {/* ── Sticky sidebar (desktop only) ── */}
          <aside className="hidden lg:block">
            <div className="sticky top-24 space-y-4">
              {/* Reserve card */}
              <div className="bg-white rounded-xl border border-gartify-blue/20 shadow-md overflow-hidden">
                <div className="bg-gradient-to-r from-gartify-hero to-gartify-mid p-4">
                  <p className="text-white font-bold text-sm">Reserva en 2 minutos</p>
                  <p className="text-white/70 text-xs mt-0.5">Sin esperas. Confirmación inmediata.</p>
                </div>
                <div className="p-4 space-y-3">
                  <div className="flex items-center gap-2">
                    <StarRating rating={garage.rating} />
                    <span className="text-sm font-bold text-gartify-blue">
                      {garage.rating.toFixed(1)}
                    </span>
                    <span className="text-xs text-muted-foreground">({garage.reviewCount})</span>
                  </div>
                  {minPrice !== null && (
                    <div className="py-2 border-y border-gray-100">
                      <p className="text-xs text-muted-foreground">Desde</p>
                      <p className="text-2xl font-bold text-gartify-blue">{formatPrice(minPrice)}</p>
                    </div>
                  )}
                  <Link href={`/talleres/${garage.id}/reservar`} className="block">
                    <Button
                      size="lg"
                      className="w-full bg-gartify-green hover:bg-gartify-green/90 text-white font-bold text-base h-12"
                    >
                      <CalendarCheck className="h-5 w-5 mr-2" />
                      Pedir cita
                    </Button>
                  </Link>
                  <a
                    href={`tel:${formatPhone(garage.phone)}`}
                    className="flex items-center justify-center gap-2 w-full h-10 rounded-lg border border-gartify-mid/30 text-gartify-mid hover:bg-gartify-mid/5 transition-colors text-sm font-medium"
                  >
                    <Phone className="h-4 w-4" />
                    {formatPhone(garage.phone)}
                  </a>
                </div>
              </div>

              {/* Guarantees card */}
              <div className="bg-white rounded-xl border border-gray-200 shadow-sm p-4 space-y-2.5">
                {[
                  { icon: ShieldCheck, text: "Taller verificado por Gartify" },
                  { icon: Clock, text: "Confirmación en menos de 1h" },
                  { icon: Star, text: "Reseñas verificadas de clientes" },
                ].map(({ icon: Icon, text }) => (
                  <div
                    key={text}
                    className="flex items-center gap-2.5 text-sm text-muted-foreground"
                  >
                    <Icon className="h-4 w-4 text-gartify-green shrink-0" />
                    {text}
                  </div>
                ))}
              </div>
            </div>
          </aside>
        </div>

        {/* Mobile FAB */}
        {minPrice !== null && (
          <GarageReserveCTA garageId={garage.id} minPrice={minPrice} />
        )}
      </div>
    </>
  );
}
