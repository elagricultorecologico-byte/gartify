import Link from "next/link";
import { SearchBar } from "@/components/home/SearchBar";
import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";
import { POPULAR_SERVICES } from "@/lib/constants";
import {
  Search, CalendarCheck, ShieldCheck, Wrench,
  Star, MapPin, Euro, Headphones,
} from "lucide-react";

const HOW_IT_WORKS = [
  {
    icon: Search,
    step: "1",
    title: "Busca y compara",
    desc: "Introduce tu ciudad y el servicio que necesitas. Compara precios, reseñas y distancia de los talleres cercanos.",
  },
  {
    icon: CalendarCheck,
    step: "2",
    title: "Reserva online",
    desc: "Elige el taller y el horario que mejor te convenga. Reserva en menos de 2 minutos, sin llamadas.",
  },
  {
    icon: ShieldCheck,
    step: "3",
    title: "Lleva tu coche",
    desc: "El taller confirma tu cita. Acude en la fecha reservada y paga directamente al taller al recoger.",
  },
];

const TRUST_BADGES = [
  {
    icon: ShieldCheck,
    title: "Talleres verificados",
    desc: "Cada taller pasa una revisión antes de publicarse en la plataforma.",
  },
  {
    icon: Star,
    title: "Reseñas reales",
    desc: "Solo clientes que han reservado pueden dejar una valoración.",
  },
  {
    icon: Euro,
    title: "Precio transparente",
    desc: "Sin cargos ocultos. El precio es el que ves. Pagas al taller.",
  },
  {
    icon: Headphones,
    title: "Soporte en español",
    desc: "Te ayudamos si algo no va bien con tu reserva. Sin esperas.",
  },
];

export default function HomePage() {
  return (
    <>
      {/* ── Hero ── */}
      <section className="bg-gartify-hero py-24 md:py-32">
        <div className="container max-w-4xl text-center">
          <div className="inline-flex items-center gap-2 rounded-full border border-gartify-orange bg-gartify-orange/30 px-4 py-1.5 text-sm text-white font-medium mb-6">
            <Star className="h-3.5 w-3.5 fill-current" />
            Más de 500 talleres verificados en España
          </div>
          <h1 className="text-5xl md:text-7xl font-bold text-white mb-6 leading-tight">
            Encuentra tu taller<br />
            <span className="text-gartify-orange">de confianza</span>
          </h1>
          <p className="text-lg text-blue-100 mb-10 max-w-2xl mx-auto">
            Compara precios, lee reseñas reales y reserva cita online en talleres mecánicos de toda España. Sin sorpresas, sin llamadas.
          </p>
          <SearchBar className="max-w-2xl mx-auto" />
          {/* Stats de social proof */}
          <div className="flex items-center justify-center gap-6 mt-5 flex-wrap">
            <span className="flex items-center gap-1.5 text-sm text-blue-100">
              <ShieldCheck className="h-4 w-4" />
              <strong className="text-white font-bold">500+</strong> talleres
            </span>
            <span className="flex items-center gap-1.5 text-sm text-blue-100">
              <Star className="h-4 w-4 fill-gartify-orange text-gartify-orange" />
              <strong className="text-white font-bold">+2.000</strong> reseñas
            </span>
            <span className="flex items-center gap-1.5 text-sm text-blue-100">
              <MapPin className="h-4 w-4" />
              <strong className="text-white font-bold">15</strong> provincias
            </span>
          </div>
        </div>
      </section>

      {/* ── Servicios populares ── */}
      <section className="container py-16">
        <h2 className="text-2xl font-bold text-foreground mb-8 text-center">Servicios más solicitados</h2>
        <div className="grid grid-cols-2 md:grid-cols-4 gap-4 max-w-2xl mx-auto">
          {POPULAR_SERVICES.map(({ type, icon: Icon, label, color }) => (
            <Link key={type} href={`/talleres?servicio=${type}`}>
              <Card className="text-center hover:shadow-md hover:-translate-y-0.5 hover:border-gartify-orange/50 transition-all duration-200 cursor-pointer">
                <CardContent className="pt-6 pb-4 flex flex-col items-center gap-2">
                  <Icon className={`h-8 w-8 ${color}`} />
                  <p className="text-sm font-medium text-foreground">{label}</p>
                </CardContent>
              </Card>
            </Link>
          ))}
        </div>
      </section>

      {/* ── Por qué confiar en Gartify ── */}
      <section className="bg-white py-12 border-t border-gray-100">
        <div className="container max-w-4xl">
          <div className="grid grid-cols-2 md:grid-cols-4 gap-6">
            {TRUST_BADGES.map(({ icon: Icon, title, desc }) => (
              <div key={title} className="flex flex-col items-center text-center gap-2 p-4">
                <div className="flex h-12 w-12 items-center justify-center rounded-full bg-gartify-hero/10">
                  <Icon className="h-6 w-6 text-gartify-hero" />
                </div>
                <p className="font-semibold text-gartify-blue text-sm">{title}</p>
                <p className="text-xs text-gartify-gray leading-relaxed">{desc}</p>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* ── Cómo funciona ── */}
      <section className="bg-blue-50 py-16">
        <div className="container max-w-4xl">
          <h2 className="text-2xl font-bold text-gartify-blue mb-12 text-center">Cómo funciona</h2>
          {/* Contenedor relative para las líneas conectoras */}
          <div className="relative grid md:grid-cols-3 gap-8">
            {/* Líneas conectoras entre círculos (solo desktop) */}
            <div className="hidden md:block absolute top-7 left-[calc(16.67%+28px)] w-[calc(33.33%-56px)] h-px bg-gartify-blue/20" />
            <div className="hidden md:block absolute top-7 left-[calc(50%+28px)] w-[calc(33.33%-56px)] h-px bg-gartify-blue/20" />

            {HOW_IT_WORKS.map(({ icon: Icon, step, title, desc }) => (
              <div key={step} className="text-center">
                <div className="mx-auto mb-4 flex h-14 w-14 items-center justify-center rounded-full bg-white border border-gartify-blue/30 shadow-sm">
                  <Icon className="h-6 w-6 text-gartify-orange" />
                </div>
                <div className="inline-flex items-center justify-center h-5 w-5 rounded-full bg-gartify-orange text-white text-xs font-bold mb-2">
                  {step}
                </div>
                <h3 className="font-semibold text-gartify-blue mb-2">{title}</h3>
                <p className="text-sm text-gartify-gray">{desc}</p>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* ── CTA talleres ── */}
      <section className="bg-gradient-to-b from-gartify-mid to-gartify-hero py-16 text-center">
        <div className="container max-w-2xl mx-auto">
          <Wrench className="h-10 w-10 text-gartify-orange mx-auto mb-4" />
          <h2 className="text-2xl font-bold text-white mb-3">¿Tienes un taller mecánico?</h2>
          <p className="text-blue-200 mb-6 max-w-lg mx-auto">
            Más de 500 conductores buscan talleres en Gartify cada mes. Publica tus servicios gratis y empieza a recibir reservas esta semana.
          </p>
          <Link href="/registro?tipo=taller">
            <Button size="lg" className="bg-gartify-orange hover:bg-gartify-orange/90 text-white font-bold">
              Publica tu taller — es gratis
            </Button>
          </Link>
          <p className="mt-3 text-xs text-blue-300">Sin permanencia · Sin comisiones · Alta en 5 minutos</p>
        </div>
      </section>
    </>
  );
}
