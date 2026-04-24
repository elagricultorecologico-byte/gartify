"use client";
import "leaflet/dist/leaflet.css";
import { useEffect, useState } from "react";
import { MapContainer, TileLayer, Marker, useMap } from "react-leaflet";
import L from "leaflet";
import { X, Star, MapPin, Wrench } from "lucide-react";
import { Button } from "@/components/ui/button";
import Link from "next/link";

function createMarkerIcon(_rating: number, selected: boolean): L.DivIcon {
  const border  = selected ? "#FF5722" : "white";
  const shadow  = selected
    ? "0 3px 12px rgba(255,87,34,0.55)"
    : "0 2px 8px rgba(0,0,0,0.30)";
  const scale   = selected ? "scale(1.2)" : "scale(1)";
  const size    = 38;
  const html = `
    <div style="display:inline-flex;flex-direction:column;align-items:center;transform:${scale};transform-origin:bottom center;transition:transform 0.15s;">
      <div style="width:${size}px;height:${size}px;border-radius:50%;background:#1A3562;border:2.5px solid ${border};box-shadow:${shadow};overflow:hidden;display:flex;align-items:center;justify-content:center;">
        <img src="/globo.png" width="${size - 6}" height="${size - 6}" style="display:block;object-fit:contain;" />
      </div>
      <div style="width:0;height:0;border-left:5px solid transparent;border-right:5px solid transparent;border-top:7px solid ${border};margin-top:-1px;"></div>
    </div>`;
  return L.divIcon({
    className: "",
    html,
    iconSize:   [size, size + 8],
    iconAnchor: [size / 2, size + 8],
  });
}

type GarageService = { name: string; price: number };

export type GaragePin = {
  id: string;
  name: string;
  city: string;
  address?: string | null;
  lat: number;
  lng: number;
  rating: number;
  reviewCount?: number;
  plan?: string;
  services?: GarageService[];
};

function FitBounds({ garages }: { garages: GaragePin[] }) {
  const map = useMap();
  useEffect(() => {
    if (garages.length === 0) return;
    const bounds = L.latLngBounds(garages.map((g) => [g.lat, g.lng]));
    map.fitBounds(bounds, { padding: [40, 40] });
  }, [garages, map]);
  return null;
}

function formatPrice(price: number): string {
  return price.toLocaleString("es-ES", { style: "currency", currency: "EUR", maximumFractionDigits: 0 });
}

// ── Modal interno ─────────────────────────────────────────────────────────────

function GarageModal({ garage, onClose }: { garage: GaragePin; onClose: () => void }) {
  return (
    <>
      {/* Overlay */}
      <div
        className="fixed inset-0 z-[9999] bg-black/50 backdrop-blur-sm"
        onClick={onClose}
      />

      {/* Panel */}
      <div className="fixed z-[9999] bottom-0 left-0 right-0 sm:bottom-auto sm:left-1/2 sm:top-1/2 sm:-translate-x-1/2 sm:-translate-y-1/2 sm:max-w-md w-full">
        <div className="bg-white shadow-2xl overflow-hidden">

          {/* Cabecera — formato estándar del proyecto */}
          <div className="bg-gray-50 border-b border-gray-200 px-5 py-4 flex items-start justify-between">
            <div className="flex items-center gap-3 flex-1 min-w-0">
              <div className="flex h-10 w-10 shrink-0 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20">
                <MapPin className="h-5 w-5 text-gartify-blue" />
              </div>
              <div className="min-w-0">
                <div className="flex items-center gap-2 flex-wrap">
                  <h2 className="text-base font-bold text-gartify-blue leading-tight truncate">{garage.name}</h2>
                  {garage.plan === "PREMIUM" && (
                    <span className="shrink-0 text-[10px] font-bold bg-amber-100 text-amber-700 px-2 py-0.5">PREMIUM</span>
                  )}
                </div>
                <p className="text-xs text-gartify-gray mt-0.5 truncate">{garage.address ?? garage.city}</p>
              </div>
            </div>
            <button
              onClick={onClose}
              className="ml-3 shrink-0 p-1.5 text-gartify-gray hover:text-gartify-dark hover:bg-gray-100 transition-colors"
            >
              <X className="h-5 w-5" />
            </button>
          </div>

          <div className="px-5 py-4 space-y-4">
            {/* Rating */}
            <div className="flex items-center gap-2">
              <div className="flex">
                {Array.from({ length: 5 }, (_, i) => (
                  <Star
                    key={i}
                    className={`h-4 w-4 ${i < Math.round(garage.rating) ? "fill-gartify-orange text-gartify-orange" : "text-gray-200"}`}
                  />
                ))}
              </div>
              <span className="font-bold text-gartify-blue text-sm">{garage.rating.toFixed(1)}</span>
              {garage.reviewCount !== undefined && (
                <span className="text-gray-400 text-xs">({garage.reviewCount} reseñas)</span>
              )}
            </div>

            {/* Servicios */}
            {garage.services && garage.services.length > 0 && (
              <div>
                <div className="flex items-center gap-1.5 mb-2">
                  <Wrench className="h-3.5 w-3.5 text-gartify-blue" />
                  <span className="text-xs font-semibold text-gray-500 uppercase tracking-wide">Servicios disponibles</span>
                </div>
                <div className="space-y-1.5">
                  {garage.services.slice(0, 4).map((s, i) => (
                    <div key={i} className="flex items-center justify-between bg-gray-50 border border-gray-100 px-3 py-2">
                      <span className="text-sm text-gray-700 truncate mr-3">{s.name}</span>
                      <span className="text-sm font-bold text-gartify-orange shrink-0">{formatPrice(s.price)}</span>
                    </div>
                  ))}
                </div>
              </div>
            )}

            {/* CTA */}
            <Link href={`/talleres/${garage.id}`} className="block">
              <Button className="w-full bg-gartify-orange hover:bg-orange-600 text-white font-bold text-sm">
                Ver taller y reservar
              </Button>
            </Link>
          </div>
        </div>
      </div>
    </>
  );
}

// ── Componente principal ──────────────────────────────────────────────────────

export function GarageMap({ garages }: { garages: GaragePin[] }) {
  const [selected, setSelected] = useState<GaragePin | null>(null);

  const center: [number, number] = garages.length > 0
    ? [garages[0].lat, garages[0].lng]
    : [40.4168, -3.7038];

  return (
    <>
      <MapContainer
        center={center}
        zoom={11}
        className="h-full w-full rounded-lg"
        scrollWheelZoom={false}
      >
        <TileLayer
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a>'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
        <FitBounds garages={garages} />
        {garages.map((g) => (
          <Marker
            key={g.id}
            position={[g.lat, g.lng]}
            icon={createMarkerIcon(g.rating, selected?.id === g.id)}
            eventHandlers={{ click: () => setSelected(g) }}
          />
        ))}
      </MapContainer>

      {selected && (
        <GarageModal garage={selected} onClose={() => setSelected(null)} />
      )}
    </>
  );
}
