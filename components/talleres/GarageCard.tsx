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

export function GarageCard({ id, name, city, address, rating, reviewCount, isVerified, services, lat, lng, vehicleTypes, plan, courtesyCar, pickupService, offers }: GarageCardProps) {
  const cheapest = services.length > 0 ? Math.min(...services.map((s) => s.price)) : null;
  const tiposVehiculo = parsearTiposVehiculo(vehicleTypes);
  const mapsQuery = lat != null && lng != null
    ? `${lat},${lng}`
    : encodeURIComponent(`${address}, ${city}, España`);
  const mapsUrl = `https://www.google.com/maps/dir/?api=1&destination=${mapsQuery}`;

  return (
    <div className="bg-white rounded-xl border border-gray-200 shadow-sm hover:shadow-md hover:border-gartify-orange/40 transition-all overflow-hidden flex flex-col sm:flex-row">
      {/* Center: content */}
      <div className="flex-1 px-4 py-3 flex flex-col gap-2 min-w-0">

        {/* Fila 1: nombre + rating */}
        <div className="flex items-center justify-between gap-2 min-w-0">
          <div className="flex items-center gap-2 min-w-0">
            <h3 className="font-bold text-gartify-blue text-base leading-tight truncate">{name}</h3>
            {plan === "PREMIUM" && (
              <span className="inline-flex items-center gap-1 bg-amber-400 text-white text-[10px] font-bold px-2 py-0.5 rounded-full shadow-sm shrink-0">
                <Crown className="h-2.5 w-2.5" />
                Premium
              </span>
            )}
          </div>
          <div className="flex items-center gap-1 shrink-0">
            <StarRating rating={rating} />
            <span className="text-sm font-bold text-foreground">{rating.toFixed(1)}</span>
            <span className="text-xs text-muted-foreground">({reviewCount})</span>
          </div>
        </div>

        {/* Fila 2: dirección + badges inline */}
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
          {isVerified && (
            <Badge className="bg-gartify-blue/10 text-gartify-blue border-gartify-blue/20 text-xs font-semibold gap-1 hover:bg-gartify-blue/10 shrink-0">
              <ShieldCheck className="h-3 w-3" />
              Verificado
            </Badge>
          )}
        </div>

        {/* Servicios + vehículos (emojis) en una sola fila */}
        <div className="flex flex-wrap items-center gap-1.5">
          {services.slice(0, 3).map((s) => (
            <span key={s.id} className="inline-flex items-center rounded-full bg-blue-50 text-gartify-hero text-xs px-2.5 py-0.5 font-medium border border-blue-100">
              {SERVICE_LABELS[s.type] ?? s.name}
            </span>
          ))}
          {services.length > 3 && (
            <span className="inline-flex items-center rounded-full bg-gray-100 text-gartify-gray text-xs px-2 py-0.5 font-medium">
              +{services.length - 3}
            </span>
          )}
          {tiposVehiculo.length > 0 && <span className="text-gray-300 text-xs">|</span>}
          {tiposVehiculo.map((tipo) => (
            <span key={tipo} title={VEHICLE_LABELS[tipo]} aria-label={VEHICLE_LABELS[tipo]} className="text-base leading-none">
              {VEHICLE_ICONS[tipo]}
            </span>
          ))}
          {/* Extras inline — agrupados para que no se separen al hacer wrap */}
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

        {/* Ofertas — ancho completo */}
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

      {/* Right: mapa interactivo Google Maps */}
      <div className="hidden sm:block relative sm:w-44 sm:shrink-0 overflow-hidden border-l border-gray-100">
        <GarageCardMap lat={lat} lng={lng} address={`${address}, ${city}, España`} mapsUrl={mapsUrl} />
      </div>

    </div>
  );
}
