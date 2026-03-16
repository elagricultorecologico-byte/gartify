import type { Metadata } from "next";
import Link from "next/link";
import { Mail, Phone, MapPin, Clock, ChevronRight } from "lucide-react";
import { ContactForm } from "@/components/contacto/ContactForm";
import { ObfuscatedEmail } from "@/components/ui/ObfuscatedEmail";

export const metadata: Metadata = {
  title: "Contacto — Gartify",
  description:
    "¿Tienes una duda o quieres registrar tu taller? Escríbenos y te respondemos en menos de 24 horas.",
  openGraph: {
    title: "Contacta con Gartify",
    description:
      "Soporte para conductores y talleres. Respuesta garantizada en menos de 24 horas.",
    type: "website",
  },
  alternates: { canonical: "/contacto" },
};

const jsonLd = {
  "@context": "https://schema.org",
  "@graph": [
    {
      "@type": "BreadcrumbList",
      itemListElement: [
        { "@type": "ListItem", position: 1, name: "Inicio", item: "https://gartify.es" },
        { "@type": "ListItem", position: 2, name: "Contacto", item: "https://gartify.es/contacto" },
      ],
    },
    {
      "@type": "ContactPage",
      name: "Contacto — Gartify",
      description: "Formulario de contacto para conductores y talleres mecánicos.",
      url: "https://gartify.es/contacto",
    },
    {
      "@type": "Organization",
      name: "Gartify",
      url: "https://gartify.es",
      email: "hola@gartify.es",
      telephone: "+34900000000",
      address: {
        "@type": "PostalAddress",
        addressLocality: "Madrid",
        addressCountry: "ES",
      },
      contactPoint: {
        "@type": "ContactPoint",
        contactType: "customer service",
        availableLanguage: "Spanish",
        hoursAvailable: {
          "@type": "OpeningHoursSpecification",
          dayOfWeek: ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"],
          opens: "09:00",
          closes: "18:00",
        },
      },
    },
  ],
};

export default function ContactoPage() {
  return (
    <>
      <script
        type="application/ld+json"
        dangerouslySetInnerHTML={{ __html: JSON.stringify(jsonLd) }}
      />

      {/* ── Hero ── */}
      <section className="bg-gradient-to-br from-gartify-hero to-gartify-mid py-20 text-center px-4">
        <div className="container max-w-2xl">
          <span className="inline-flex items-center gap-2 rounded-full border border-gartify-orange/50 bg-gartify-orange/20 px-4 py-1.5 text-sm text-gartify-orange mb-6">
            <Mail className="h-3.5 w-3.5" aria-hidden="true" />
            Estamos para ayudarte
          </span>
          <h1 className="text-4xl font-bold text-white mb-4">Contacta con Gartify</h1>
          <p className="text-blue-100 text-lg max-w-lg mx-auto">
            ¿Tienes una duda, un problema o quieres unirte como taller? Escríbenos y te
            respondemos en menos de 24 horas.
          </p>
        </div>
      </section>

      {/* ── Contenido principal ── */}
      <section className="py-16 px-4 bg-blue-50">
        <div className="container max-w-5xl">
          <div className="grid lg:grid-cols-3 gap-8">

            {/* Columna izquierda — información estática */}
            <div className="space-y-5">
              {/* Datos de contacto */}
              <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
                <div className="bg-gradient-to-r from-gartify-hero to-gartify-mid px-5 py-3">
                  <p className="text-xs font-bold uppercase tracking-widest text-white/80">
                    Información de contacto
                  </p>
                </div>
                <address className="p-5 space-y-4 text-sm not-italic">
                  <div className="flex items-start gap-3">
                    <Mail className="h-4 w-4 text-gartify-mid mt-0.5 shrink-0" aria-hidden="true" />
                    <div>
                      <p className="font-semibold text-gartify-blue">Email</p>
                      <ObfuscatedEmail
                        user="hola"
                        domain="gartify.es"
                        className="text-gartify-mid hover:underline"
                      />
                    </div>
                  </div>
                  <div className="flex items-start gap-3">
                    <Phone className="h-4 w-4 text-gartify-mid mt-0.5 shrink-0" aria-hidden="true" />
                    <div>
                      <p className="font-semibold text-gartify-blue">Teléfono</p>
                      <a
                        href="tel:+34900000000"
                        className="text-gartify-mid hover:underline"
                      >
                        900 000 000
                      </a>
                      <p className="text-xs text-muted-foreground mt-0.5">
                        Lunes a viernes, 9h–18h
                      </p>
                    </div>
                  </div>
                  <div className="flex items-start gap-3">
                    <MapPin className="h-4 w-4 text-gartify-mid mt-0.5 shrink-0" aria-hidden="true" />
                    <div>
                      <p className="font-semibold text-gartify-blue">Sede</p>
                      <p className="text-muted-foreground">Madrid, España</p>
                    </div>
                  </div>
                  <div className="flex items-start gap-3">
                    <Clock className="h-4 w-4 text-gartify-mid mt-0.5 shrink-0" aria-hidden="true" />
                    <div>
                      <p className="font-semibold text-gartify-blue">Horario de atención</p>
                      <p className="text-muted-foreground">Lun – Vie: 9:00 – 18:00</p>
                      <p className="text-muted-foreground">Sáb: 10:00 – 14:00</p>
                    </div>
                  </div>
                </address>
              </div>

              {/* Accesos rápidos */}
              <nav
                aria-label="Accesos rápidos"
                className="bg-white rounded-xl border border-gray-200 shadow-sm p-5 space-y-2.5"
              >
                <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3">
                  Accesos rápidos
                </p>
                {[
                  { label: "Cómo funciona Gartify",  href: "/como-funciona" },
                  { label: "Registrar mi taller",     href: "/registro?tipo=taller" },
                  { label: "Preguntas frecuentes",    href: "/como-funciona#faq" },
                  { label: "Portal del taller",       href: "/cuenta/taller" },
                ].map(({ label, href }) => (
                  <Link
                    key={label}
                    href={href}
                    className="flex items-center justify-between text-sm text-gartify-blue hover:text-gartify-mid transition-colors group"
                  >
                    <span>{label}</span>
                    <ChevronRight
                      className="h-3.5 w-3.5 text-gray-300 group-hover:text-gartify-mid transition-colors"
                      aria-hidden="true"
                    />
                  </Link>
                ))}
              </nav>
            </div>

            {/* Columna derecha — formulario (cliente) */}
            <div className="lg:col-span-2">
              <ContactForm />
            </div>
          </div>
        </div>
      </section>
    </>
  );
}
