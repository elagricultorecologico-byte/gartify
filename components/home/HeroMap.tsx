"use client";
import "leaflet/dist/leaflet.css";
import { useEffect, useRef } from "react";
import L from "leaflet";
import type { GaragePin } from "@/components/talleres/GarageMap";

type Props = {
  garages: GaragePin[];
  userCoords?: { lat: number; lng: number } | null;
};

// Centro geográfico aproximado de España peninsular
const CENTRO_ESPANA: [number, number] = [40.0, -4.0];
const ZOOM_INICIAL = 5;
const ZOOM_USUARIO = 11;

// Icono azul pulsante para la posición del usuario
function crearIconoUsuario(): L.DivIcon {
  return L.divIcon({
    className: "",
    html: `<div class="gartify-user-pin"><div class="gartify-user-pin__ring"></div></div>`,
    iconSize: [20, 20],
    iconAnchor: [10, 10],
  });
}

export default function HeroMap({ garages, userCoords }: Props) {
  // Referencia al contenedor DOM del mapa
  const contenedorRef = useRef<HTMLDivElement>(null);
  // Referencia a la instancia de Leaflet para no recrearla en cada render
  const mapaRef = useRef<L.Map | null>(null);
  // Referencia al marcador del usuario para poder moverlo/eliminarlo
  const marcadorUsuarioRef = useRef<L.Marker | null>(null);

  // Inicialización del mapa — solo se ejecuta una vez al montar
  useEffect(() => {
    if (!contenedorRef.current || mapaRef.current) return;

    const mapa = L.map(contenedorRef.current, {
      center: CENTRO_ESPANA,
      zoom: ZOOM_INICIAL,
      zoomControl: false,
      attributionControl: false,
      scrollWheelZoom: false,
      dragging: true,
      doubleClickZoom: false,
    });

    // Tiles CartoDB Positron — estética limpia y clara
    L.tileLayer(
      "https://{s}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}{r}.png",
      {
        attribution: "&copy; OpenStreetMap &copy; CARTO",
        subdomains: "abcd",
        maxZoom: 19,
      }
    ).addTo(mapa);

    // Añadir control de atribución compacto en la esquina inferior derecha
    L.control.attribution({ position: "bottomright", prefix: false }).addTo(mapa);

    // Pintar todos los talleres con circleMarker naranja
    garages.forEach((taller) => {
      L.circleMarker([taller.lat, taller.lng], {
        radius: 6,
        fillColor: "#FF5722",
        fillOpacity: 0.9,
        color: "transparent",
        weight: 0,
      })
        .bindTooltip(taller.name, {
          direction: "top",
          offset: [0, -8],
          className: "gartify-tooltip",
        })
        .addTo(mapa);
    });

    mapaRef.current = mapa;

    return () => {
      mapa.remove();
      mapaRef.current = null;
    };
    // Los talleres solo se cargan una vez al montar; si cambian se necesitaría
    // una lógica de diff más compleja, pero en el hero son datos estáticos del servidor.
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, []);

  // Reacción a cambio de coordenadas del usuario
  useEffect(() => {
    const mapa = mapaRef.current;
    if (!mapa) return;

    // Eliminar marcador previo del usuario si existe
    if (marcadorUsuarioRef.current) {
      marcadorUsuarioRef.current.remove();
      marcadorUsuarioRef.current = null;
    }

    if (!userCoords) return;

    // Añadir marcador azul pulsante en la posición del usuario
    const marcador = L.marker([userCoords.lat, userCoords.lng], {
      icon: crearIconoUsuario(),
      zIndexOffset: 1000,
    })
      .bindTooltip("Tu ubicación", {
        direction: "top",
        offset: [0, -12],
        className: "gartify-tooltip",
        permanent: false,
      })
      .addTo(mapa);

    marcadorUsuarioRef.current = marcador;

    // Volar suavemente a la posición del usuario
    mapa.flyTo([userCoords.lat, userCoords.lng], ZOOM_USUARIO, {
      duration: 1.2,
      easeLinearity: 0.35,
    });
  }, [userCoords]);

  return (
    <>
      {/* Estilos encapsulados: pins y tooltips del mapa del hero */}
      <style>{`
        /* Pin naranja de taller */
        .gartify-taller-pin {
          width: 12px;
          height: 12px;
          background: #FF5722;
          border-radius: 50%;
          opacity: 0.9;
        }

        /* Pin azul del usuario con anillo pulsante */
        .gartify-user-pin {
          position: relative;
          width: 20px;
          height: 20px;
          display: flex;
          align-items: center;
          justify-content: center;
        }
        .gartify-user-pin::after {
          content: '';
          position: absolute;
          inset: 4px;
          background: #1E40AF;
          border-radius: 50%;
          z-index: 2;
        }
        .gartify-user-pin__ring {
          position: absolute;
          inset: 0;
          border-radius: 50%;
          background: rgba(30, 64, 175, 0.3);
          animation: gartify-pulse 1.6s ease-in-out infinite;
          z-index: 1;
        }
        @keyframes gartify-pulse {
          0%   { transform: scale(0.8); opacity: 0.8; }
          50%  { transform: scale(1.4); opacity: 0.2; }
          100% { transform: scale(0.8); opacity: 0.8; }
        }

        /* Tooltip del mapa del hero */
        .gartify-tooltip {
          background: #0F172A;
          color: white;
          border: none;
          font-size: 11px;
          font-weight: 600;
          padding: 3px 8px;
          border-radius: 0;
          box-shadow: 0 2px 8px rgba(0,0,0,0.4);
          white-space: nowrap;
        }
        .gartify-tooltip::before {
          border-top-color: #0F172A !important;
        }
        /* Ocultar borde nativo de Leaflet en los leaflet-marker-icon de esta instancia */
        .leaflet-container .leaflet-marker-icon {
          border: none !important;
          background: transparent !important;
        }
      `}</style>

      <div
        ref={contenedorRef}
        className="w-full h-full"
        aria-label="Mapa de talleres en España"
        role="img"
      />
    </>
  );
}
