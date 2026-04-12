import Link from "next/link";
import dynamic from "next/dynamic";
import { MapPin, Star, Clock, ShieldCheck, Crown, Car, PackageCheck, Zap } from "lucide-react";
import { Badge } from "@/components/ui/badge";
import { Button } from "@/components/ui/button";
import { formatPrice, SERVICE_LABELS, VEHICLE_LABELS, VEHICLE_ICONS, VEHICLE_TYPES, type VehicleType } from "@/lib/utils";

const GarageCardMap = dynamic(
  () => import("./GarageCardMap").then((m) => m.GarageCardMap),
  { ssr: false, loading: () => <div className="hidden sm:block sm:w-44 sm:shrink-0 bg-gray-50 animate-pulse border-l border-gray-100" /> }
);

type Service = { id: string; type: string; name: string; price: number; duration: number };

type Oferta = {
  id:        string;
  label:     string;
  days:      string;   // JSON array serializado, ej: ["LUN","MAR"]
  startTime: string;
  endTime:   string;
  price:     number;
};

type GarageCardProps = {
  id: string;
  name: string;
  description?: string | null;
  city: string;
  address: string;
  rating: number;
  reviewCount: number;
  isVerified: boolean;
  services: Service[];
  logo?: string | null;
  lat?: number | null;
  lng?: number | null;
  vehicleTypes?: string | null;
  plan?: string | null;
  courtesyCar?: boolean;
  pickupService?: boolean;
  offers?: Oferta[];
};

// Mapeo de códigos de día a etiquetas abreviadas en español
const ETIQUETA_DIA: Record<string, string> = {
  LUN: "Lun", MAR: "Mar", MIE: "Mié",
  JUE: "Jue", VIE: "Vie", SAB: "Sáb", DOM: "Dom",
};

/** Parsea el JSON de días y formatea como texto legible */
function formatearDiasOferta(rawDays: string): string {
  try {
    const dias = JSON.parse(rawDays) as string[];
    return dias.map((d) => ETIQUETA_DIA[d] ?? d).join(", ");
  } catch {
    return "—";
  }
}

/** Parsea el JSON de vehicleTypes almacenado en SQLite y devuelve un array tipado */
function parsearTiposVehiculo(raw: string | null | undefined): VehicleType[] {
  try {
    const parsed = JSON.parse(raw ?? '["COCHE"]') as string[];
    return parsed.filter((v): v is VehicleType =>
      (VEHICLE_TYPES as readonly string[]).includes(v)
    );
  } catch {
    return ["COCHE"];
  }
}

function StarRating({ rating, size = "sm" }: { rating: number; size?: "sm" | "md" }) {
  const dimensiones = size === "md" ? "h-4 w-4" : "h-3.5 w-3.5";
  return (
    <div className="flex items-center gap-0.5">
      {[1, 2, 3, 4, 5].map((i) => (
        <Star
          key={i}
          className={`${dimensiones} ${i <= Math.round(rating) ? "fill-yellow-400 text-yellow-400" : "fill-gray-200 text-gray-200"}`}
        />
      ))}
    </div>
  );
}

export function GarageCard({ id, name, city, address, rating, reviewCount, isVerified, services, lat, lng, vehicleTypes, plan, courtesyCar, pickupService, offers }: GarageCardProps) {
  const cheapest = services.length > 0 ? Math.min(...services.map((s) => s.price)) : null;
  const tiposVehiculo = parsearTiposVehiculo(vehicleTypes);
  const mapsQuery = lat != null && lng != null
    ? `${lat},${lng}`
    : encodeURIComponent(`${address}, ${city}, España`);
  const mapsUrl = `https://www.google.com/maps/dir/?api=1&destination=${mapsQuery}`;

  const esPremium = plan === "PREMIUM";

  return (
    <div className="bg-white sm:rounded-xl border-y sm:border border-gray-200 shadow-sm hover:shadow-md hover:border-gartify-orange/40 transition-all overflow-hidden flex flex-col sm:flex-row">

      {/* ── CONTENIDO PRINCIPAL ───────────────────────────────────────────── */}
      <div className="flex-1 flex flex-col min-w-0">

        {/* ── CABECERA MÓVIL: badge de tier + verificado ──────────────────── */}
        {/* Solo visible en móvil como banda superior de color */}
        {(esPremium || isVerified) && (
          <div className="sm:hidden flex items-center gap-2 px-4 pt-3 pb-0">
            {esPremium && (
              <span className="inline-flex items-center gap-1 bg-amber-400 text-white text-[11px] font-bold px-2.5 py-1 rounded-full shadow-sm">
                <Crown className="h-3 w-3" />
                Premium
              </span>
            )}
            {isVerified && (
              <span className="inline-flex items-center gap-1 bg-gartify-hero/10 text-gartify-hero text-[11px] font-bold px-2.5 py-1 rounded-full border border-gartify-hero/20">
                <ShieldCheck className="h-3 w-3" />
                Verificado
              </span>
            )}
          </div>
        )}

        {/* ── CUERPO DE LA CARD ────────────────────────────────────────────── */}
        <div className="px-4 py-3 flex flex-col gap-2">

          {/* Fila 1 — nombre + badges de tier en desktop + rating */}
          <div className="flex items-start justify-between gap-2 min-w-0">
            <div className="flex items-center gap-2 min-w-0">
              <h3 className="font-bold text-gartify-blue text-base leading-tight truncate">{name}</h3>
              {/* Badge Premium solo visible en desktop (en móvil aparece arriba) */}
              {esPremium && (
                <span className="hidden sm:inline-flex items-center gap-1 bg-amber-400 text-white text-[10px] font-bold px-2 py-0.5 rounded-full shadow-sm shrink-0">
                  <Crown className="h-2.5 w-2.5" />
                  Premium
                </span>
              )}
            </div>
            {/* Rating — visible en desktop en la misma fila que el nombre */}
            <div className="hidden sm:flex items-center gap-1 shrink-0">
              <StarRating rating={rating} />
              <span className="text-sm font-bold text-foreground">{rating.toFixed(1)}</span>
              <span className="text-xs text-muted-foreground">({reviewCount})</span>
            </div>
          </div>

          {/* Rating en móvil — fila dedicada para mayor legibilidad */}
          <div className="flex sm:hidden items-center gap-1.5">
            <StarRating rating={rating} size="md" />
            <span className="text-sm font-bold text-foreground">{rating.toFixed(1)}</span>
            <span className="text-xs text-muted-foreground">· {reviewCount} {reviewCount === 1 ? "reseña" : "reseñas"}</span>
          </div>

          {/* Fila 2 — dirección + badge verificado (desktop) */}
          <div className="flex items-center gap-2 flex-wrap">
            <a
              href={mapsUrl}
              target="_blank"
              rel="noopener noreferrer"
              className="text-xs text-muted-foreground flex items-center gap-1 hover:text-gartify-mid transition-colors"
              aria-label={`Cómo llegar a ${name}`}
            >
              <MapPin className="h-3 w-3 shrink-0" />
              {address}, {city}
            </a>
            {/* Badge verificado solo en desktop (en móvil aparece arriba) */}
            {isVerified && (
              <Badge className="hidden sm:inline-flex bg-gartify-blue/10 text-gartify-blue border-gartify-blue/20 text-xs font-semibold gap-1 hover:bg-gartify-blue/10 shrink-0">
                <ShieldCheck className="h-3 w-3" />
                Verificado
              </Badge>
            )}
          </div>

          {/* Chips de servicios:
              - Móvil: máx 2 para no saturar el espacio vertical
              - Desktop: máx 3 como antes */}
          <div className="flex flex-wrap items-center gap-1.5">
            {services.slice(0, 2).map((s) => (
              <span
                key={s.id}
                className="sm:hidden inline-flex items-center rounded-full bg-blue-50 text-gartify-hero text-xs px-2.5 py-0.5 font-medium border border-blue-100"
              >
                {SERVICE_LABELS[s.type] ?? s.name}
              </span>
            ))}
            {/* En desktop mostramos hasta 3 */}
            {services.slice(0, 3).map((s) => (
              <span
                key={`desk-${s.id}`}
                className="hidden sm:inline-flex items-center rounded-full bg-blue-50 text-gartify-hero text-xs px-2.5 py-0.5 font-medium border border-blue-100"
              >
                {SERVICE_LABELS[s.type] ?? s.name}
              </span>
            ))}
            {/* Contador de servicios restantes */}
            <span className="sm:hidden">
              {services.length > 2 && (
                <span className="inline-flex items-center rounded-full bg-gray-100 text-gartify-gray text-xs px-2 py-0.5 font-medium">
                  +{services.length - 2}
                </span>
              )}
            </span>
            <span className="hidden sm:inline-flex">
              {services.length > 3 && (
                <span className="inline-flex items-center rounded-full bg-gray-100 text-gartify-gray text-xs px-2 py-0.5 font-medium">
                  +{services.length - 3}
                </span>
              )}
            </span>
            {/* Tipos de vehículo — igual en ambos layouts */}
            {tiposVehiculo.length > 0 && <span className="text-gray-300 text-xs">|</span>}
            {tiposVehiculo.map((tipo) => (
              <span key={tipo} title={VEHICLE_LABELS[tipo]} aria-label={VEHICLE_LABELS[tipo]} className="text-base leading-none">
                {VEHICLE_ICONS[tipo]}
              </span>
            ))}
            {/* Extras: coche de cortesía y recogida */}
            {(courtesyCar || pickupService) && (
              <span className="inline-flex items-center gap-1.5">
                {courtesyCar && (
                  <span className="inline-flex items-center gap-1 rounded-full bg-green-50 text-green-700 text-xs px-2.5 py-0.5 font-medium border border-green-100">
                    <Car className="h-3 w-3" />Coche cortesía
                  </span>
                )}
                {pickupService && (
                  <span className="inline-flex items-center gap-1 rounded-full bg-purple-50 text-purple-700 text-xs px-2.5 py-0.5 font-medium border border-purple-100">
                    <PackageCheck className="h-3 w-3" />Recogida
                  </span>
                )}
              </span>
            )}
          </div>

          {/* Ofertas especiales — igual en ambos layouts */}
          {offers && offers.length > 0 && (
            <div className="flex flex-col gap-1.5">
              <div className="flex items-center gap-1 w-full">
                <Zap className="h-3 w-3 text-green-600 fill-green-500" aria-hidden="true" />
                <span className="text-[11px] font-bold text-green-700 uppercase tracking-wide">Ofertas especiales</span>
              </div>
              {offers.slice(0, 3).map((oferta) => (
                <div key={oferta.id} className="flex items-center justify-between gap-2 rounded-lg bg-green-50 border border-green-200 px-2.5 py-1">
                  <div className="flex items-center gap-2 min-w-0">
                    <span className="text-xs font-semibold text-green-800 truncate">{oferta.label}</span>
                    <span className="text-[11px] text-green-600 whitespace-nowrap shrink-0 hidden sm:inline">
                      · {formatearDiasOferta(oferta.days)} {oferta.startTime}–{oferta.endTime}
                    </span>
                  </div>
                  <span className="text-xs font-bold text-white bg-green-600 rounded-full px-2.5 py-0.5 shrink-0 whitespace-nowrap">
                    {formatPrice(oferta.price)}
                  </span>
                </div>
              ))}
              {offers.length > 3 && (
                <span className="text-[11px] text-green-700 font-medium self-center">+{offers.length - 3} más</span>
              )}
            </div>
          )}

          {/* ── PRECIO + CTA MÓVIL ────────────────────────────────────────── */}
          {/* En móvil: precio grande centrado + botón Reservar ancho completo */}
          <div className="sm:hidden flex flex-col gap-2 mt-1 pt-3 border-t border-gray-100">
            {cheapest !== null ? (
              <div className="flex flex-col items-center gap-0">
                <span className="text-[11px] text-muted-foreground uppercase tracking-wide font-medium">desde</span>
                <span className="text-3xl font-extrabold text-gartify-orange leading-none">{formatPrice(cheapest)}</span>
              </div>
            ) : (
              <div className="flex items-center justify-center gap-1 text-sm text-muted-foreground py-1">
                <Clock className="h-4 w-4" />
                Consultar precio
              </div>
            )}
            <Link href={`/talleres/${id}`} className="w-full">
              <Button
                size="lg"
                className="w-full bg-gartify-green hover:bg-gartify-green/90 text-white font-bold text-base tracking-wide shadow-sm"
              >
                Reservar
              </Button>
            </Link>
          </div>

          {/* ── PRECIO + CTA DESKTOP ──────────────────────────────────────── */}
          {/* En desktop: precio + botón en fila horizontal (layout original) */}
          <div className="hidden sm:flex items-center justify-between gap-4 mt-auto pt-1 border-t border-gray-100">
            {cheapest !== null ? (
              <div className="flex items-baseline gap-1">
                <span className="text-xs text-muted-foreground">desde</span>
                <span className="text-xl font-bold text-gartify-orange">{formatPrice(cheapest)}</span>
              </div>
            ) : (
              <div className="flex items-center gap-1 text-xs text-muted-foreground">
                <Clock className="h-3.5 w-3.5" />
                Consultar precio
              </div>
            )}
            <Link href={`/talleres/${id}`}>
              <Button size="sm" className="bg-gartify-green hover:bg-gartify-green/90 text-white font-semibold px-5">
                Ver taller
              </Button>
            </Link>
          </div>

        </div>{/* fin .px-4.py-3 */}
      </div>{/* fin contenido principal */}

      {/* ── MAPA INTERACTIVO (solo desktop) ─────────────────────────────── */}
      <div className="hidden sm:block relative sm:w-44 sm:shrink-0 overflow-hidden border-l border-gray-100">
        <GarageCardMap lat={lat} lng={lng} address={`${address}, ${city}, España`} mapsUrl={mapsUrl} />
      </div>

    </div>
  );
}
