"use client";
import { useEffect } from "react";
import { MapContainer, TileLayer, Marker, Popup, useMap } from "react-leaflet";
import L from "leaflet";

// Fix default Leaflet marker icon
const icon = L.divIcon({
  className: "",
  html: `<div style="width:28px;height:28px;background:#FF5722;border:3px solid white;border-radius:50% 50% 50% 0;transform:rotate(-45deg);box-shadow:0 2px 6px rgba(0,0,0,0.4)"></div>`,
  iconSize: [28, 28],
  iconAnchor: [14, 28],
  popupAnchor: [0, -30],
});

type GaragePin = {
  id: string;
  name: string;
  city: string;
  lat: number;
  lng: number;
  rating: number;
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

export function GarageMap({ garages }: { garages: GaragePin[] }) {
  const center: [number, number] = garages.length > 0 ? [garages[0].lat, garages[0].lng] : [40.4168, -3.7038];

  return (
    <MapContainer center={center} zoom={11} className="h-full w-full rounded-lg" scrollWheelZoom={false}>
      <TileLayer
        attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a>'
        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
      />
      <FitBounds garages={garages} />
      {garages.map((g) => (
        <Marker key={g.id} position={[g.lat, g.lng]} icon={icon}>
          <Popup>
            <div className="text-sm">
              <p className="font-semibold">{g.name}</p>
              <p className="text-gray-600">{g.city} · ⭐ {g.rating.toFixed(1)}</p>
              <a href={`/talleres/${g.id}`} className="text-orange-600 hover:underline font-medium">Ver taller →</a>
            </div>
          </Popup>
        </Marker>
      ))}
    </MapContainer>
  );
}
