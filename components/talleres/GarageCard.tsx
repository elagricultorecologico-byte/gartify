import Link from "next/link";
import { MapPin, Star, Clock, ShieldCheck, ExternalLink, Crown } from "lucide-react";
import { Badge } from "@/components/ui/badge";
import { Button } from "@/components/ui/button";
import { formatPrice, SERVICE_LABELS, VEHICLE_LABELS, VEHICLE_ICONS, VEHICLE_TYPES, type VehicleType } from "@/lib/utils";

type Service = { id: string; type: string; name: string; price: number; duration: number };

type GarageCardProps = {
  id: string;
  name: string;
  description: string | null;
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
};

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

function StarRating({ rating }: { rating: number }) {
  return (
    <div className="flex items-center gap-0.5">
      {[1, 2, 3, 4, 5].map((i) => (
        <Star
          key={i}
          className={`h-3.5 w-3.5 ${i <= Math.round(rating) ? "fill-yellow-400 text-yellow-400" : "fill-gray-200 text-gray-200"}`}
        />
      ))}
    </div>
  );
}

export function GarageCard({ id, name, description, city, address, rating, reviewCount, isVerified, services, logo, lat, lng, vehicleTypes, plan }: GarageCardProps) {
  const cheapest = services.length > 0 ? Math.min(...services.map((s) => s.price)) : null;
  const tiposVehiculo = parsearTiposVehiculo(vehicleTypes);
  const hasMap = lat != null && lng != null;
  const mapsUrl = lat != null && lng != null
    ? `https://www.google.com/maps/dir/?api=1&destination=${lat},${lng}`
    : `https://www.google.com/maps/dir/?api=1&destination=${encodeURIComponent(`${address}, ${city}`)}`;

  return (
    <div className="bg-white rounded-xl border border-gray-200 shadow-sm hover:shadow-md hover:border-gartify-orange/40 transition-all overflow-hidden flex flex-col sm:flex-row">
      {/* Left: logo / avatar */}
      <div className="relative sm:w-36 sm:shrink-0 bg-gradient-to-br from-gartify-hero to-gartify-mid flex items-center justify-center min-h-[100px] sm:min-h-0 overflow-hidden border-r border-gray-200">
        {/* eslint-disable-next-line @next/next/no-img-element */}
        <img
          src={logo ?? "/logo-taller-def.png"}
          alt={logo ? `Logo de ${name}` : "Gartify"}
          className="h-20 w-20 object-contain p-2 rounded-xl"
        />
        {plan === "PREMIUM" && (
          <div className="absolute top-2 left-2 flex items-center gap-1 bg-amber-400 text-white text-[10px] font-bold px-2 py-0.5 rounded-full shadow-md">
            <Crown className="h-2.5 w-2.5" />
            Premium
          </div>
        )}
      </div>

      {/* Center: content */}
      <div className="flex-1 p-4 flex flex-col gap-3 min-w-0">
        {/* Badges + rating */}
        <div className="flex items-start justify-between gap-2 flex-wrap">
          <div className="flex items-center gap-2 flex-wrap">
            {isVerified && (
              <Badge className="bg-gartify-blue/10 text-gartify-blue border-gartify-blue/20 text-xs font-semibold gap-1 hover:bg-gartify-blue/10">
                <ShieldCheck className="h-3 w-3" />
                Verificado
              </Badge>
            )}
            <Badge variant="outline" className="text-xs text-gartify-gray border-gray-200 gap-1">
              <MapPin className="h-3 w-3" />
              {city}
            </Badge>
          </div>
          <div className="flex items-center gap-1.5 shrink-0">
            <StarRating rating={rating} />
            <span className="text-sm font-bold text-foreground">{rating.toFixed(1)}</span>
            <span className="text-xs text-muted-foreground">({reviewCount})</span>
          </div>
        </div>

        {/* Name + address */}
        <div>
          <h3 className="font-bold text-gartify-blue text-base leading-tight mb-0.5">{name}</h3>
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
        </div>

        {description && (
          <p className="text-xs text-muted-foreground line-clamp-2">{description}</p>
        )}

        {/* Service chips */}
        <div className="flex flex-wrap gap-1.5">
          {services.slice(0, 3).map((s) => (
            <span key={s.id} className="inline-flex items-center gap-1 rounded-full bg-blue-50 text-gartify-hero text-xs px-2.5 py-0.5 font-medium border border-blue-100">
              {SERVICE_LABELS[s.type] ?? s.name}
            </span>
          ))}
          {services.length > 3 && (
            <span className="inline-flex items-center rounded-full bg-gray-100 text-gartify-gray text-xs px-2.5 py-0.5 font-medium">
              +{services.length - 3} más
            </span>
          )}
        </div>

        {/* Tipos de vehículo aceptados */}
        <div className="flex flex-wrap gap-1.5">
          {tiposVehiculo.map((tipo) => (
            <span
              key={tipo}
              title={VEHICLE_LABELS[tipo]}
              className="inline-flex items-center gap-1 rounded-full bg-orange-50 text-gartify-orange text-xs px-2.5 py-0.5 font-medium border border-orange-100"
              aria-label={VEHICLE_LABELS[tipo]}
            >
              <span aria-hidden="true">{VEHICLE_ICONS[tipo]}</span>
              {VEHICLE_LABELS[tipo]}
            </span>
          ))}
        </div>

        {/* Price + CTA */}
        <div className="flex items-center justify-between gap-4 mt-auto pt-1 border-t border-gray-100">
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
      </div>

      {/* Right: mini map (Google Maps Embed) */}
      {hasMap && (
        <div className="hidden sm:block sm:w-44 sm:shrink-0 overflow-hidden border-l border-gray-100 relative group">
          <iframe
            title={`Mapa ${name}`}
            src={`https://www.google.com/maps/embed/v1/place?key=${process.env.NEXT_PUBLIC_GOOGLE_MAPS_API_KEY}&q=${lat},${lng}&zoom=15`}
            className="w-full h-full border-0 pointer-events-none"
            loading="lazy"
            allowFullScreen
            referrerPolicy="no-referrer-when-downgrade"
          />
          <a
            href={`https://www.google.com/maps?q=${lat},${lng}`}
            target="_blank"
            rel="noopener noreferrer"
            aria-label={`Ver ${name} en Google Maps`}
            className="absolute inset-0 flex items-end justify-end p-2 opacity-0 group-hover:opacity-100 transition-opacity"
          >
            <span className="inline-flex items-center gap-1 rounded bg-white/90 border border-gray-200 text-xs text-gartify-blue font-medium px-2 py-1 shadow-sm">
              <ExternalLink className="h-3 w-3" /> Ver mapa
            </span>
          </a>
        </div>
      )}
    </div>
  );
}
