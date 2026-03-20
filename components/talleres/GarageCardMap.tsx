"use client";

export function GarageCardMap({ lat, lng, address, mapsUrl }: { lat?: number | null; lng?: number | null; address: string; mapsUrl: string }) {
  const q = lat != null && lng != null ? `${lat},${lng}` : encodeURIComponent(address);
  const embedUrl = `https://www.google.com/maps/embed/v1/place?key=${process.env.NEXT_PUBLIC_GOOGLE_MAPS_API_KEY}&q=${q}&zoom=15`;

  return (
    <div className="relative h-full w-full group">
      <iframe
        src={embedUrl}
        className="w-full h-full border-0"
        allowFullScreen={false}
        loading="lazy"
        referrerPolicy="no-referrer-when-downgrade"
        title="Mapa del taller"
      />
      {/* Overlay para abrir Google Maps al hacer click */}
      <a
        href={mapsUrl}
        target="_blank"
        rel="noopener noreferrer"
        className="absolute inset-0 z-10"
        aria-label="Ver en Google Maps"
      />
      {/* Hover label */}
      <div className="absolute bottom-2 right-2 z-20 opacity-0 group-hover:opacity-100 transition-opacity pointer-events-none">
        <span className="inline-flex items-center gap-1 rounded bg-white/90 border border-gray-200 text-xs text-gartify-blue font-medium px-2 py-1 shadow-sm">
          Ver mapa
        </span>
      </div>
    </div>
  );
}
