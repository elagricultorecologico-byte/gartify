/**
 * Geocodifica una dirección postal española a coordenadas lat/lng.
 * Intenta Google Maps primero (si hay GOOGLE_MAPS_API_KEY); si no, usa Nominatim.
 * Devuelve null si ambos fallan — el caller no debe bloquearse por esto.
 */
export async function geocodificarDireccion(
  address: string,
  city: string,
  postalCode: string,
): Promise<{ lat: number; lng: number } | null> {
  const query = `${address}, ${postalCode} ${city}, España`;

  // ── Google Maps (preferido si hay API key) ────────────────────────────────
  const apiKey = process.env.GOOGLE_MAPS_API_KEY;
  if (apiKey) {
    try {
      const url = `https://maps.googleapis.com/maps/api/geocode/json?address=${encodeURIComponent(query)}&key=${apiKey}`;
      const res = await fetch(url, { next: { revalidate: 0 } });
      if (res.ok) {
        const data = (await res.json()) as {
          status: string;
          results: Array<{ geometry: { location: { lat: number; lng: number } } }>;
        };
        if (data.status === "OK" && data.results.length > 0) {
          return data.results[0].geometry.location;
        }
      }
    } catch { /* fall through to Nominatim */ }
  }

  // ── Nominatim / OpenStreetMap (fallback sin API key) ─────────────────────
  try {
    const url = `https://nominatim.openstreetmap.org/search?q=${encodeURIComponent(query)}&format=json&limit=1&countrycodes=es`;
    const res = await fetch(url, {
      headers: { "User-Agent": "Gartify/1.0 (hola@gartify.es)" },
      next: { revalidate: 0 },
    });
    if (!res.ok) return null;
    const data = (await res.json()) as Array<{ lat: string; lon: string }>;
    if (data.length === 0) return null;
    return { lat: parseFloat(data[0].lat), lng: parseFloat(data[0].lon) };
  } catch {
    return null;
  }
}
