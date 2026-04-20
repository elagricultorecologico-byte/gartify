import type { Metadata } from "next";
import { Inter } from "next/font/google";
import "./globals.css";
import { SessionProvider } from "@/components/providers/SessionProvider";
import { NavFooterWrapper } from "@/components/layout/NavFooterWrapper";
import { CookieBanner } from "@/components/layout/CookieBanner";
import { cn } from "@/lib/utils";

const inter = Inter({ subsets: ["latin"], variable: "--font-sans" });

export const metadata: Metadata = {
  metadataBase: new URL("https://gartify.es"),
  title: {
    template: "%s | Gartify",
    default: "Gartify — Encuentra tu taller de confianza",
  },
  description: "Compara precios, lee reseñas y reserva cita en talleres mecánicos de toda España.",
  openGraph: {
    type: "website",
    locale: "es_ES",
    siteName: "Gartify",
    title: "Gartify — Encuentra tu taller de confianza",
    description: "Compara precios, lee reseñas y reserva cita en talleres mecánicos de toda España.",
    images: [{ url: "/og-image.jpg", width: 1200, height: 630, alt: "Gartify — Encuentra tu taller de confianza" }],
  },
  twitter: {
    card: "summary_large_image",
    title: "Gartify — Encuentra tu taller de confianza",
    description: "Compara precios, lee reseñas y reserva cita en talleres mecánicos de toda España.",
    images: ["/og-image.jpg"],
  },
  robots: { index: true, follow: true },
};

const jsonLd = {
  "@context": "https://schema.org",
  "@graph": [
    {
      "@type": "Organization",
      "name": "Gartify",
      "url": "https://gartify.es",
      "description": "Plataforma de búsqueda y reserva de talleres mecánicos en España.",
      "contactPoint": {
        "@type": "ContactPoint",
        "contactType": "customer service",
        "url": "https://gartify.es/contacto",
      },
    },
    {
      "@type": "WebSite",
      "name": "Gartify",
      "url": "https://gartify.es",
      "potentialAction": {
        "@type": "SearchAction",
        "target": {
          "@type": "EntryPoint",
          "urlTemplate": "https://gartify.es/talleres?ciudad={search_term_string}",
        },
        "query-input": "required name=search_term_string",
      },
    },
  ],
};

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="es" className={cn("font-sans", inter.variable)}>
      <body className={inter.className}>
        <script
          type="application/ld+json"
          dangerouslySetInnerHTML={{ __html: JSON.stringify(jsonLd) }}
        />
        <SessionProvider>
          <NavFooterWrapper>{children}</NavFooterWrapper>
          <CookieBanner />
        </SessionProvider>
      </body>
    </html>
  );
}
