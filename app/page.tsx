import Link from "next/link";
import { SearchBar } from "@/components/home/SearchBar";
import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";
import { Search, CalendarCheck, Star, ShieldCheck, Wrench, Zap, Car, Thermometer } from "lucide-react";

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

const SERVICES = [
  { icon: Car,         label: "ITV",         color: "text-gartify-orange", href: "/talleres?servicio=ITV" },
  { icon: Wrench,      label: "Revisión",     color: "text-blue-400",       href: "/talleres?servicio=REVISION" },
  { icon: Zap,         label: "Diagnóstico",  color: "text-yellow-400",     href: "/talleres?servicio=DIAGNOSTICO" },
  { icon: Thermometer, label: "Climatización",color: "text-cyan-400",       href: "/talleres?servicio=CLIMATIZACION" },
];

export default function HomePage() {
  return (
    <>
      {/* Hero */}
      <section className="relative bg-gradient-to-br from-gartify-dark via-slate-900 to-slate-800 py-24 md:py-32">
        <div className="container max-w-4xl text-center">
          <div className="inline-flex items-center gap-2 rounded-full border border-gartify-orange/30 bg-gartify-orange/10 px-4 py-1.5 text-sm text-gartify-orange mb-6">
            <Star className="h-3.5 w-3.5 fill-current" />
            Más de 500 talleres verificados en España
          </div>
          <h1 className="text-4xl md:text-6xl font-bold text-foreground mb-6 leading-tight">
            Encuentra tu taller<br />
            <span className="text-gartify-orange">de confianza</span>
          </h1>
          <p className="text-lg text-muted-foreground mb-10 max-w-2xl mx-auto">
            Compara precios, lee reseñas reales y reserva cita online en talleres mecánicos de toda España. Sin sorpresas, sin llamadas.
          </p>
          <SearchBar className="max-w-2xl mx-auto" />
          <p className="mt-4 text-xs text-muted-foreground">
            ITV · Revisiones · Frenos · Neumáticos · Diagnóstico · Climatización
          </p>
        </div>
      </section>

      {/* Servicios populares */}
      <section className="container py-16">
        <h2 className="text-2xl font-bold text-foreground mb-8 text-center">Servicios más solicitados</h2>
        <div className="grid grid-cols-2 md:grid-cols-4 gap-4 max-w-2xl mx-auto">
          {SERVICES.map(({ icon: Icon, label, color, href }) => (
            <Link key={label} href={href}>
              <Card className="text-center hover:bg-accent/30 hover:border-gartify-orange/30 transition-colors cursor-pointer">
                <CardContent className="pt-6 pb-4 flex flex-col items-center gap-2">
                  <Icon className={`h-8 w-8 ${color}`} />
                  <p className="text-sm font-medium text-foreground">{label}</p>
                </CardContent>
              </Card>
            </Link>
          ))}
        </div>
      </section>

      {/* Cómo funciona */}
      <section className="bg-secondary/30 py-16">
        <div className="container max-w-4xl">
          <h2 className="text-2xl font-bold text-foreground mb-12 text-center">Cómo funciona</h2>
          <div className="grid md:grid-cols-3 gap-8">
            {HOW_IT_WORKS.map(({ icon: Icon, step, title, desc }) => (
              <div key={step} className="text-center">
                <div className="mx-auto mb-4 flex h-14 w-14 items-center justify-center rounded-full bg-gartify-orange/10 border border-gartify-orange/20">
                  <Icon className="h-6 w-6 text-gartify-orange" />
                </div>
                <div className="text-xs font-bold text-gartify-orange mb-2">PASO {step}</div>
                <h3 className="font-semibold text-foreground mb-2">{title}</h3>
                <p className="text-sm text-muted-foreground">{desc}</p>
              </div>
            ))}
          </div>
        </div>
      </section>

      {/* CTA talleres */}
      <section className="container py-16 text-center">
        <div className="max-w-2xl mx-auto rounded-2xl border border-gartify-orange/20 bg-gartify-orange/5 p-10">
          <Wrench className="h-10 w-10 text-gartify-orange mx-auto mb-4" />
          <h2 className="text-2xl font-bold text-foreground mb-3">¿Eres propietario de un taller?</h2>
          <p className="text-muted-foreground mb-6">
            Únete a Gartify y recibe nuevos clientes sin esfuerzo. Gestiona tus reservas online y aumenta tu visibilidad.
          </p>
          <Link href="/registro?tipo=taller">
            <Button variant="blue" size="lg">Registra tu taller gratis</Button>
          </Link>
        </div>
      </section>
    </>
  );
}
