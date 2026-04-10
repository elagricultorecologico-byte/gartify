"use client";

import { useState } from "react";
import Link from "next/link";
import { Button } from "@/components/ui/button";
import { CheckCircle, Star, Zap } from "lucide-react";
import { cn } from "@/lib/utils";

export function PricingSection() {
  const [ciclo, setCiclo] = useState<"mensual" | "anual">("mensual");
  const esMensual = ciclo === "mensual";

  const precioPro     = esMensual ? "29" : "22";  // 261 €/año ÷ 12 ≈ 22
  const precioPremium = esMensual ? "79" : "59";  // 711 €/año ÷ 12 ≈ 59

  return (
    <section className="bg-blue-50 py-20 px-4">
      <div className="container max-w-5xl">
        <div className="text-center mb-10">
          <h2 className="text-3xl font-bold text-gartify-blue mb-3">Planes simples y transparentes</h2>
          <p className="text-sm text-muted-foreground max-w-xl mx-auto mb-7">
            Sin sorpresas. Sin comisiones por reserva. Elige el plan que mejor se adapta a tu taller.
          </p>

          {/* Toggle mensual / anual */}
          <div className="inline-flex items-center gap-1 rounded-full border border-gartify-blue/20 bg-white p-1 text-sm font-semibold shadow-sm">
            <button
              onClick={() => setCiclo("mensual")}
              className={cn(
                "rounded-full px-5 py-2 transition-all duration-200",
                esMensual
                  ? "bg-gartify-blue text-white shadow"
                  : "text-gartify-gray hover:text-gartify-blue"
              )}
              aria-pressed={esMensual}
            >
              Mensual
            </button>
            <button
              onClick={() => setCiclo("anual")}
              className={cn(
                "flex items-center gap-2 rounded-full px-5 py-2 transition-all duration-200",
                !esMensual
                  ? "bg-gartify-blue text-white shadow"
                  : "text-gartify-gray hover:text-gartify-blue"
              )}
              aria-pressed={!esMensual}
            >
              Anual
              <span className="rounded-full bg-green-500 px-2 py-0.5 text-[10px] font-bold uppercase text-white">
                -25 %
              </span>
            </button>
          </div>
        </div>

        <div className="grid sm:grid-cols-3 gap-6">

          {/* Plan Gratis */}
          <div className="bg-white rounded-2xl border border-gray-200 shadow-sm p-7 flex flex-col">
            <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3">Gratuito</p>
            <div className="flex items-end gap-1 mb-1">
              <span className="text-5xl font-black text-gartify-blue">0€</span>
              <span className="text-sm text-muted-foreground mb-1.5">/mes</span>
            </div>
            <p className="text-xs text-muted-foreground mb-6">Para talleres que quieren empezar sin compromiso.</p>
            <ul className="space-y-2.5 mb-8 flex-1">
              {[
                "Perfil público en Gartify",
                "Hasta 4 servicios publicados",
                "Reservas online 24/7",
                "Notificaciones por email",
                "Panel de gestión de reservas",
              ].map(item => (
                <li key={item} className="flex items-center gap-2 text-gartify-blue">
                  <CheckCircle className="h-4 w-4 text-green-500 shrink-0" />
                  <span className="text-sm">{item}</span>
                </li>
              ))}
            </ul>
            <Link href="/registro?tipo=taller">
              <Button variant="outline" className="w-full border-gartify-blue/30 text-gartify-blue hover:bg-gartify-blue/5 font-semibold">
                Empezar gratis
              </Button>
            </Link>
          </div>

          {/* Plan Pro */}
          <div className="bg-gradient-to-b from-gartify-hero to-gartify-mid rounded-2xl shadow-lg p-7 flex flex-col relative overflow-hidden">
            <div className="absolute top-4 right-4">
              <span className="inline-flex items-center gap-1 rounded-full bg-gartify-orange px-2.5 py-0.5 text-xs font-bold text-white">
                <Zap className="h-3 w-3" /> Popular
              </span>
            </div>
            <p className="text-xs font-bold uppercase tracking-widest text-blue-300 mb-3">Pro</p>
            <div className="flex items-end gap-1 mb-1">
              <span className="text-5xl font-black text-white">{precioPro}€</span>
              <span className="text-sm text-blue-200 mb-1.5">/mes</span>
            </div>
            {!esMensual && (
              <p className="text-xs text-blue-300 mb-1">261 €/año · ahorras 87 €</p>
            )}
            <p className="text-xs text-blue-200 mb-6">Todo lo del plan gratuito, más herramientas para crecer.</p>
            <ul className="space-y-2.5 mb-8 flex-1">
              {[
                "Servicios ilimitados",
                "Posición destacada en búsquedas",
                "Sello Gartify Verificado",
                "Estadísticas y visitas al perfil",
                "Modo TV — pantalla de citas",
                "Gestión de reservas por WhatsApp",
                "Soporte prioritario",
              ].map(item => (
                <li key={item} className="flex items-center gap-2 text-white">
                  <CheckCircle className="h-4 w-4 text-gartify-orange shrink-0" />
                  <span className="text-sm">{item}</span>
                </li>
              ))}
            </ul>
            <Link href={`/registro?tipo=taller&plan=pro&ciclo=${ciclo}`}>
              <Button className="w-full bg-gartify-orange hover:bg-gartify-orange/90 text-white font-bold">
                Empezar con Pro
              </Button>
            </Link>
            <p className="text-center text-xs text-blue-300 mt-3">Sin permanencia · Cancela cuando quieras</p>
          </div>

          {/* Plan Premium */}
          <div className="bg-white rounded-2xl border-2 border-gartify-orange/40 shadow-sm p-7 flex flex-col relative">
            <div className="absolute top-4 right-4">
              <span className="inline-flex items-center gap-1 rounded-full bg-gartify-orange/10 border border-gartify-orange/30 px-2.5 py-0.5 text-xs font-bold text-gartify-orange">
                <Star className="h-3 w-3" /> Premium
              </span>
            </div>
            <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3">Premium</p>
            <div className="flex items-end gap-1 mb-1">
              <span className="text-5xl font-black text-gartify-blue">{precioPremium}€</span>
              <span className="text-sm text-muted-foreground mb-1.5">/mes</span>
            </div>
            {!esMensual && (
              <p className="text-xs text-muted-foreground mb-1">711 €/año · ahorras 237 €</p>
            )}
            <p className="text-xs text-muted-foreground mb-6">Para talleres que quieren máxima visibilidad y crecimiento.</p>
            <ul className="space-y-2.5 mb-8 flex-1">
              {[
                "Todo lo del plan Pro",
                "Red de distribuidores de recambios",
                "Badge \"Taller Premium\" visible",
                "Soporte prioritario 24 h",
                "Cupones y promociones de marketing",
                "Estadísticas avanzadas e informes PDF",
              ].map(item => (
                <li key={item} className="flex items-center gap-2 text-gartify-blue">
                  <CheckCircle className="h-4 w-4 text-gartify-orange shrink-0" />
                  <span className="text-sm">{item}</span>
                </li>
              ))}
            </ul>
            <Link href={`/registro?tipo=taller&plan=premium&ciclo=${ciclo}`}>
              <Button className="w-full bg-gartify-blue hover:bg-gartify-blue/90 text-white font-bold">
                Hablar con ventas
              </Button>
            </Link>
            <p className="text-center text-xs text-muted-foreground mt-3">Sin permanencia · Cancela cuando quieras</p>
          </div>

        </div>
      </div>
    </section>
  );
}
