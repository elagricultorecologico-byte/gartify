/**
 * app/precios/layout.tsx
 *
 * Layout de segmento para la ruta /precios.
 * Este archivo es un Server Component y es el único lugar donde se puede
 * exportar `metadata` cuando la página principal necesita "use client".
 * Next.js 14 no permite exportar metadata desde Client Components.
 */

import type { Metadata } from "next";

export const metadata: Metadata = {
  title: "Precios para talleres — Planes sin comisiones abusivas",
  description:
    "Elige el plan que mejor se adapta a tu taller: alta gratuita, comisión por reserva o tarifa plana premium con acceso a distribuidores.",
  alternates: { canonical: "/precios" },
};

export default function PreciosLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return <>{children}</>;
}
