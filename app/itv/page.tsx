import type { Metadata } from "next";
import Link from "next/link";
import { Button } from "@/components/ui/button";
import {
  Car, Search, ExternalLink,
  AlertTriangle, CheckCircle, Wrench, ChevronDown,
} from "lucide-react";
import { ITVCheckerForm } from "@/components/itv/ITVCheckerForm";

export const metadata: Metadata = {
  title: "Comprobador ITV — Consulta el estado de tu vehículo",
  description:
    "Consulta el estado de la ITV de tu vehículo a través de la Sede Electrónica de la DGT. Conoce cada cuánto debes pasarla y reserva tu pre-ITV en Gartify.",
  openGraph: {
    title: "Comprobador ITV | Gartify",
    description:
      "Consulta si tu ITV está al día en la Sede Electrónica de la DGT. Encuentra talleres para tu pre-ITV en España.",
    type: "website",
  },
  alternates: { canonical: "/itv" },
};

const FAQ = [
  {
    q: "¿Cada cuánto hay que pasar la ITV?",
    a: "Los turismos nuevos tienen 4 años para la primera ITV. Después, cada 2 años hasta los 10 años de antigüedad. A partir de ahí, cada año.",
  },
  {
    q: "¿Qué pasa si circulo sin ITV en vigor?",
    a: "Circular sin ITV es una infracción grave. Conlleva una multa de 200 € y la inmovilización del vehículo en caso de accidente o control policial.",
  },
  {
    q: "¿Qué se revisa en la ITV?",
    a: "Frenos, dirección, alumbrado, emisiones, carrocería, documentación y sistemas de seguridad activa y pasiva, entre otros.",
  },
  {
    q: "¿Qué significa el resultado «Desfavorable»?",
    a: "El vehículo tiene defectos graves o muy graves. Debes repararlo y presentarlo de nuevo a inspección en el plazo indicado.",
  },
  {
    q: "¿Puedo hacer la pre-ITV en Gartify?",
    a: "Sí. Muchos talleres de nuestra plataforma ofrecen revisión pre-ITV para detectar y corregir fallos antes de la inspección oficial.",
  },
];

const PERIODICITY = [
  { years: "0–4 años",       interval: "Primera ITV a los 4 años", color: "bg-green-50 border-green-200 text-green-700" },
  { years: "4–10 años",      interval: "Cada 2 años",              color: "bg-blue-50 border-blue-200 text-blue-700" },
  { years: "Más de 10",      interval: "Cada año",                 color: "bg-orange-50 border-orange-200 text-orange-700" },
  { years: "Taxi / alquiler", interval: "Cada 6 meses",            color: "bg-red-50 border-red-200 text-red-700" },
];

const jsonLd = {
  "@context": "https://schema.org",
  "@graph": [
    {
      "@type": "BreadcrumbList",
      itemListElement: [
        { "@type": "ListItem", position: 1, name: "Inicio", item: "https://gartify.es" },
        { "@type": "ListItem", position: 2, name: "ITV", item: "https://gartify.es/itv" },
      ],
    },
    {
      "@type": "FAQPage",
      mainEntity: FAQ.map(({ q, a }) => ({
        "@type": "Question",
        name: q,
        acceptedAnswer: { "@type": "Answer", text: a },
      })),
    },
    {
      "@type": "WebPage",
      name: "Comprobador ITV — Gartify",
      description:
        "Consulta el estado de la ITV de tu vehículo en la Sede Electrónica de la DGT y encuentra talleres pre-ITV en España.",
      url: "https://gartify.es/itv",
    },
  ],
};

export default function ITVPage() {
  return (
    <>
      <script
        type="application/ld+json"
        dangerouslySetInnerHTML={{ __html: JSON.stringify(jsonLd) }}
      />

      {/* ── Hero ── */}
      <section className="bg-gradient-to-br from-gartify-hero to-gartify-mid py-20 px-4 text-center">
        <div className="container max-w-2xl">
          <span className="inline-flex items-center gap-2 rounded-full border border-gartify-orange/50 bg-gartify-orange/20 px-4 py-1.5 text-sm text-gartify-orange mb-6">
            <Car className="h-3.5 w-3.5" aria-hidden="true" />
            Comprobador de ITV
          </span>
          <h1 className="text-4xl md:text-5xl font-bold text-white mb-4">
            ¿Está al día la ITV<br />
            <span className="text-gartify-orange">de tu vehículo?</span>
          </h1>
          <p className="text-blue-100 text-lg max-w-lg mx-auto">
            Consulta el estado de la ITV de cualquier vehículo matriculado en
            España a través de la Sede Electrónica de la DGT.
          </p>
        </div>
      </section>

      {/* ── Checker card ── */}
      <section className="bg-blue-50 py-16 px-4">
        <div className="container max-w-5xl">
          <div className="grid lg:grid-cols-2 gap-6 items-stretch">

            {/* Col 1 — formulario (cliente) */}
            <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
              <div className="bg-gradient-to-r from-gartify-hero to-gartify-mid px-6 py-4 flex items-center gap-3">
                <Search className="h-5 w-5 text-white" aria-hidden="true" />
                <p className="text-sm font-bold text-white">Consultar estado ITV</p>
              </div>
              <div className="p-6 space-y-5">
                <ITVCheckerForm />
              </div>
            </div>

            {/* Col 2 — Métodos de identificación */}
            <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
              <div className="bg-gradient-to-r from-gartify-hero to-gartify-mid px-6 py-4">
                <p className="text-xs font-bold uppercase tracking-widest text-white/80">
                  Cómo identificarte en la web de la DGT
                </p>
              </div>
              <div className="p-5 space-y-4">
                <p className="text-sm text-muted-foreground">
                  Elige el método de identificación que tengas disponible:
                </p>
                <div className="space-y-3">
                  <div className="flex items-start gap-3 p-4 rounded-lg border border-orange-200 bg-orange-50">
                    <div
                      className="h-8 w-8 rounded-full bg-orange-100 border border-orange-200 flex items-center justify-center shrink-0 text-sm font-black text-orange-600"
                      aria-hidden="true"
                    >
                      1
                    </div>
                    <div className="flex-1">
                      <div className="flex items-center gap-2 mb-1">
                        <p className="font-bold text-sm text-orange-800">Cl@ve Móvil</p>
                        <span className="text-xs bg-orange-200 text-orange-700 font-bold px-2 py-0.5 rounded-full">
                          Recomendado
                        </span>
                      </div>
                      <p className="text-xs text-orange-700 leading-relaxed">
                        Descarga la app <strong>Cl@ve</strong> en tu móvil y
                        regístrate con tu DNI. Es el método más rápido y cómodo.
                      </p>
                      <div className="flex gap-2 mt-2">
                        <a
                          href="https://apps.apple.com/es/app/cl-ve/id1469820578"
                          target="_blank"
                          rel="noopener noreferrer"
                          className="text-xs text-orange-600 font-semibold hover:underline flex items-center gap-1"
                        >
                          App Store <ExternalLink className="h-3 w-3" aria-hidden="true" />
                        </a>
                        <span className="text-orange-300" aria-hidden="true">·</span>
                        <a
                          href="https://play.google.com/store/apps/details?id=es.gob.fnmt.clave"
                          target="_blank"
                          rel="noopener noreferrer"
                          className="text-xs text-orange-600 font-semibold hover:underline flex items-center gap-1"
                        >
                          Google Play <ExternalLink className="h-3 w-3" aria-hidden="true" />
                        </a>
                      </div>
                    </div>
                  </div>

                  <div className="flex items-start gap-3 p-4 rounded-lg border border-blue-200 bg-blue-50">
                    <div
                      className="h-8 w-8 rounded-full bg-blue-100 border border-blue-200 flex items-center justify-center shrink-0 text-sm font-black text-blue-600"
                      aria-hidden="true"
                    >
                      2
                    </div>
                    <div className="flex-1">
                      <p className="font-bold text-sm text-blue-800 mb-1">
                        DNIe / Certificado electrónico
                      </p>
                      <p className="text-xs text-blue-700 leading-relaxed">
                        Si tienes un <strong>DNI electrónico</strong> o un{" "}
                        <strong>certificado digital</strong> (FNMT) instalado en
                        tu navegador. Necesitarás lector de tarjetas para el DNIe.
                      </p>
                    </div>
                  </div>

                  <div className="flex items-start gap-3 p-4 rounded-lg border border-gray-200 bg-gray-50">
                    <div
                      className="h-8 w-8 rounded-full bg-gray-200 border border-gray-300 flex items-center justify-center shrink-0 text-sm font-black text-gray-600"
                      aria-hidden="true"
                    >
                      3
                    </div>
                    <div className="flex-1">
                      <p className="font-bold text-sm text-gray-800 mb-1">
                        Cl@ve Permanente
                      </p>
                      <p className="text-xs text-gray-600 leading-relaxed">
                        Usuario y contraseña del sistema Cl@ve. Requiere registro
                        previo en una oficina de la Seguridad Social o de la AEAT
                        con tu DNI.
                      </p>
                    </div>
                  </div>
                </div>

                <p className="text-xs text-muted-foreground pt-1">
                  ¿No tienes ningún método?{" "}
                  <a
                    href="https://clave.gob.es/clave_Home/registro/Como-puedo-registrarme.html"
                    target="_blank"
                    rel="noopener noreferrer"
                    className="text-gartify-orange font-semibold hover:underline"
                  >
                    Regístrate en Cl@ve aquí.
                  </a>
                </p>
              </div>
            </div>
          </div>
        </div>
      </section>

      {/* ── Tabla de periodicidad ── */}
      <section className="py-16 px-4">
        <div className="container max-w-4xl">
          <div className="text-center mb-10">
            <h2 className="text-2xl font-bold text-gartify-blue mb-2">
              ¿Cada cuánto debes pasar la ITV?
            </h2>
            <p className="text-sm text-muted-foreground">
              Según la antigüedad y uso del vehículo.
            </p>
          </div>

          <div className="grid sm:grid-cols-2 lg:grid-cols-4 gap-4 mb-12">
            {PERIODICITY.map(({ years, interval, color }) => (
              <div key={years} className={`rounded-xl border p-5 text-center ${color}`}>
                <Car className="h-7 w-7 mx-auto mb-3 opacity-70" aria-hidden="true" />
                <p className="font-bold text-sm mb-1">{years}</p>
                <p className="text-xs font-semibold opacity-80">{interval}</p>
              </div>
            ))}
          </div>

          {/* Qué se revisa */}
          <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
            <div className="bg-gradient-to-r from-gartify-hero to-gartify-mid px-6 py-4">
              <p className="text-xs font-bold uppercase tracking-widest text-white/80">
                Qué se revisa en la ITV
              </p>
            </div>
            <div className="p-6 grid sm:grid-cols-2 gap-3">
              {[
                "Sistema de frenos",
                "Dirección y suspensión",
                "Alumbrado y señalización",
                "Emisiones contaminantes",
                "Carrocería y chasis",
                "Neumáticos y ruedas",
                "Cinturones y airbags",
                "Documentación del vehículo",
                "Niveles de fluidos",
                "Sistemas eléctricos y batería (EV)",
              ].map((item) => (
                <div key={item} className="flex items-center gap-2.5 text-sm">
                  <CheckCircle
                    className="h-4 w-4 text-gartify-green shrink-0"
                    aria-hidden="true"
                  />
                  <span className="text-gartify-blue font-medium">{item}</span>
                </div>
              ))}
            </div>
          </div>
        </div>
      </section>

      {/* ── Resultados posibles ── */}
      <section className="bg-blue-50 py-16 px-4">
        <div className="container max-w-4xl">
          <div className="text-center mb-10">
            <h2 className="text-2xl font-bold text-gartify-blue mb-2">
              Resultados posibles
            </h2>
            <p className="text-sm text-muted-foreground">
              ¿Qué significa cada resultado de la inspección?
            </p>
          </div>

          <div className="grid sm:grid-cols-3 gap-4">
            {[
              {
                icon: CheckCircle,
                label: "Favorable",
                bg: "bg-green-50",
                border: "border-green-200",
                iconColor: "text-green-600",
                textColor: "text-green-800",
                desc: "El vehículo cumple todos los requisitos. Puede circular con normalidad hasta la próxima ITV.",
              },
              {
                icon: AlertTriangle,
                label: "Desfavorable",
                bg: "bg-orange-50",
                border: "border-orange-200",
                iconColor: "text-orange-600",
                textColor: "text-orange-800",
                desc: "Tiene defectos graves. Debe repararse y volver a inspección en el plazo indicado (máx. 2 meses).",
              },
              {
                icon: AlertTriangle,
                label: "Negativo",
                bg: "bg-red-50",
                border: "border-red-200",
                iconColor: "text-red-600",
                textColor: "text-red-800",
                desc: "Defectos muy graves. El vehículo no puede circular. Debe repararse y pasar una nueva inspección.",
              },
            ].map(({ icon: Icon, label, bg, border, iconColor, textColor, desc }) => (
              <div key={label} className={`rounded-xl border p-5 ${bg} ${border}`}>
                <div className="flex items-center gap-2 mb-3">
                  <Icon className={`h-5 w-5 ${iconColor}`} aria-hidden="true" />
                  <span className={`font-bold text-sm ${textColor}`}>{label}</span>
                </div>
                <p className="text-xs text-muted-foreground leading-relaxed">{desc}</p>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* ── FAQ ── */}
      <section className="py-16 px-4">
        <div className="container max-w-3xl">
          <div className="text-center mb-10">
            <h2 className="text-2xl font-bold text-gartify-blue mb-2">
              Preguntas frecuentes sobre la ITV
            </h2>
          </div>
          <div className="space-y-3">
            {FAQ.map(({ q, a }) => (
              <details
                key={q}
                className="group bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden"
              >
                <summary className="flex items-stretch gap-0 cursor-pointer list-none [&::-webkit-details-marker]:hidden">
                  <div className="w-1 shrink-0 bg-gradient-to-b from-gartify-hero to-gartify-mid self-stretch" />
                  <div className="flex items-center justify-between gap-3 flex-1 px-5 py-4">
                    <p className="font-bold text-gartify-blue text-sm">{q}</p>
                    <ChevronDown
                      className="h-4 w-4 text-gartify-gray shrink-0 transition-transform duration-200 group-open:rotate-180"
                      aria-hidden="true"
                    />
                  </div>
                </summary>
                <div className="pl-6 pr-5 pb-4">
                  <p className="text-sm text-muted-foreground leading-relaxed">{a}</p>
                </div>
              </details>
            ))}
          </div>
        </div>
      </section>

      {/* ── CTA pre-ITV ── */}
      <section className="bg-gradient-to-b from-gartify-mid to-gartify-hero py-14 px-4 text-center">
        <div className="container max-w-2xl">
          <Wrench
            className="h-10 w-10 text-gartify-orange mx-auto mb-4"
            aria-hidden="true"
          />
          <h2 className="text-2xl font-bold text-white mb-3">
            ¿Tu ITV está próxima a vencer?
          </h2>
          <p className="text-blue-100 text-sm mb-7 max-w-lg mx-auto">
            Reserva una revisión pre-ITV en un taller de confianza. Detectamos
            los fallos antes de la inspección para que pases a la primera.
          </p>
          <div className="flex flex-col sm:flex-row gap-3 justify-center">
            <Link href="/talleres?servicio=PRE_ITV">
              <Button
                size="lg"
                className="bg-gartify-orange hover:bg-gartify-orange/90 text-white font-bold gap-2 h-12 px-8"
              >
                <Search className="h-5 w-5" aria-hidden="true" />
                Buscar taller pre-ITV
              </Button>
            </Link>
            <Link href="/talleres?servicio=ITV">
              <Button
                size="lg"
                className="bg-gartify-green hover:bg-gartify-green/90 text-white font-semibold h-12 px-8"
              >
                Ver talleres ITV
              </Button>
            </Link>
          </div>
        </div>
      </section>
    </>
  );
}
