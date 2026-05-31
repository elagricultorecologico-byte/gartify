"use client";
import { useRouter, useSearchParams } from "next/navigation";
import { useState } from "react";
import {
  Select, SelectContent, SelectItem, SelectTrigger, SelectValue,
} from "@/components/ui/select";
import {
  Collapsible, CollapsibleContent, CollapsibleTrigger,
} from "@/components/ui/collapsible";
import {
  X, Star, Euro, SlidersHorizontal,
  Car, PackageCheck, CheckCircle, Crown, ChevronDown, Zap, Tag,
} from "lucide-react";
import { GARAGE_CATEGORIES } from "@/lib/constants";
import { cn } from "@/lib/utils";

const PRICE_RANGES = [
  { value: "0-30",   label: "Hasta 30 €" },
  { value: "30-60",  label: "30 € – 60 €" },
  { value: "60-100", label: "60 € – 100 €" },
  { value: "100-",   label: "Más de 100 €" },
];

const RATING_OPTIONS = [
  { value: "4.5", stars: 4.5 },
  { value: "4",   stars: 4   },
  { value: "3.5", stars: 3.5 },
];


function RatingStars({ stars }: { stars: number }) {
  return (
    <span className="flex items-center gap-1">
      {[1, 2, 3, 4, 5].map((i) => (
        <Star
          key={i}
          className={cn(
            "h-3.5 w-3.5",
            i <= Math.floor(stars)
              ? "fill-yellow-400 text-yellow-400"
              : i - 0.5 <= stars
              ? "fill-yellow-200 text-yellow-400"
              : "fill-gray-200 text-gray-200"
          )}
        />
      ))}
      <span className="text-xs font-medium ml-0.5">{stars}+</span>
    </span>
  );
}

function Section({
  label,
  icon,
  active,
  defaultOpen = true,
  children,
}: {
  label: string;
  icon: React.ReactNode;
  active?: boolean;
  defaultOpen?: boolean;
  children: React.ReactNode;
}) {
  const [open, setOpen] = useState(defaultOpen);
  return (
    <Collapsible open={open} onOpenChange={setOpen}>
      <CollapsibleTrigger className="w-full flex items-center justify-between py-2 group">
        <span className={cn(
          "flex items-center gap-1.5 text-[11px] font-bold uppercase tracking-widest select-none",
          active ? "text-gartify-hero" : "text-gartify-gray"
        )}>
          {icon}
          {label}
          {active && <span className="h-1.5 w-1.5 rounded-full bg-gartify-hero" />}
        </span>
        <ChevronDown className={cn(
          "h-3.5 w-3.5 text-gartify-gray/60 transition-transform duration-200",
          open && "rotate-180"
        )} />
      </CollapsibleTrigger>
      <CollapsibleContent className="pb-3">
        {children}
      </CollapsibleContent>
    </Collapsible>
  );
}

export function GarageFilters() {
  const router = useRouter();
  const sp = useSearchParams();

  function update(key: string, value: string) {
    const params = new URLSearchParams(sp.toString());
    if (value && value !== "ALL") params.set(key, value);
    else params.delete(key);
    router.push(`/talleres?${params.toString()}`);
  }

  function isActive(key: string): boolean {
    const v = sp.get(key);
    return v !== null && v !== "" && v !== "ALL";
  }

  function activeRing(key: string): string {
    return isActive(key) ? "ring-2 ring-gartify-hero/50 border-gartify-hero/60" : "";
  }

  const activeCount = ["precio", "rating", "cocheCortesia", "recogida", "premium", "conOfertas", "categoria"]
    .filter(isActive).length;
  const hasFilters = activeCount > 0;

  const [mobileOpen, setMobileOpen] = useState(false);

  return (
    <div className="bg-white border border-gray-200 overflow-hidden">
      {/* Cabecera — en móvil actúa como toggle */}
      <button
        type="button"
        className="w-full flex items-center justify-between px-4 py-3 border-b border-gray-100 lg:cursor-default"
        onClick={() => setMobileOpen((v) => !v)}
        aria-expanded={mobileOpen}
      >
        <div className="flex items-center gap-2 text-gartify-blue">
          <SlidersHorizontal className="h-4 w-4 shrink-0" />
          <span className="text-sm font-semibold">Filtros</span>
          {hasFilters && (
            <span className="flex h-4 min-w-4 items-center justify-center bg-gartify-hero px-1 text-[10px] font-bold text-white leading-none">
              {activeCount}
            </span>
          )}
        </div>
        <div className="flex items-center gap-2">
          {hasFilters && (
            <span
              role="button"
              tabIndex={0}
              onClick={(e) => { e.stopPropagation(); router.push("/talleres"); }}
              className="flex items-center gap-1 text-xs text-red-500 hover:text-red-600"
            >
              <X className="h-3.5 w-3.5" />
              Limpiar
            </span>
          )}
          <ChevronDown className={cn("h-4 w-4 text-gartify-gray transition-transform lg:hidden", mobileOpen && "rotate-180")} />
        </div>
      </button>

      {/* Secciones — ocultas en móvil hasta que se abra el toggle */}
      <div className={cn("px-4 divide-y divide-gray-100", !mobileOpen && "hidden lg:block")}>

        {/* Tipo de taller — multiselección */}
        {(() => {
          const selected = new Set((sp.get("categoria") ?? "").split(",").filter(Boolean));
          function toggleCategoria(val: string) {
            const next = new Set(selected);
            if (next.has(val)) next.delete(val); else next.add(val);
            const params = new URLSearchParams(sp.toString());
            if (next.size > 0) params.set("categoria", Array.from(next).join(","));
            else params.delete("categoria");
            router.push(`/talleres?${params.toString()}`);
          }
          return (
            <Section label="Tipo de taller" icon={<Tag className="h-3 w-3" />} active={selected.size > 0} defaultOpen={selected.size > 0}>
              <div className="max-h-52 overflow-y-auto flex flex-col gap-1 pr-1">
                {GARAGE_CATEGORIES.map((cat) => {
                  const activo = selected.has(cat.value);
                  return (
                    <button key={cat.value} type="button" onClick={() => toggleCategoria(cat.value)} aria-pressed={activo}
                      className={cn(
                        "w-full flex items-center gap-2 h-8 px-2.5 rounded-none border text-xs font-medium transition-all text-left",
                        activo ? "bg-gartify-hero/10 border-gartify-hero/40 text-gartify-hero ring-1 ring-gartify-hero/30" : "bg-white border-gray-200 text-gartify-gray hover:bg-gray-50"
                      )}>
                      <span className="flex-1">{cat.label}</span>
                      {activo && <CheckCircle className="h-3 w-3 shrink-0 text-gartify-hero" />}
                    </button>
                  );
                })}
              </div>
              {selected.size > 0 && (
                <button type="button" onClick={() => { const p = new URLSearchParams(sp.toString()); p.delete("categoria"); router.push(`/talleres?${p.toString()}`); }}
                  className="mt-1.5 text-[11px] text-red-400 hover:text-red-500 flex items-center gap-1">
                  <X className="h-3 w-3" />Quitar selección
                </button>
              )}
            </Section>
          );
        })()}

        {/* Precio */}
        <Section label="Precio" icon={<Euro className="h-3 w-3" />} active={isActive("precio")} defaultOpen={false}>
          <div className="relative">
            <Euro className={cn("pointer-events-none absolute left-2.5 top-1/2 -translate-y-1/2 h-3.5 w-3.5 z-10", isActive("precio") ? "text-gartify-hero" : "text-gartify-gray/70")} />
            <Select value={sp.get("precio") ?? "ALL"} onValueChange={(v) => update("precio", v)}>
              <SelectTrigger className={cn("h-9 w-full pl-8 text-sm transition-all", activeRing("precio"))}>
                <SelectValue placeholder="Cualquier precio" />
              </SelectTrigger>
              <SelectContent position="popper">
                <SelectItem value="ALL">Cualquier precio</SelectItem>
                {PRICE_RANGES.map((r) => <SelectItem key={r.value} value={r.value}>{r.label}</SelectItem>)}
              </SelectContent>
            </Select>
          </div>
        </Section>

        {/* Valoración */}
        <Section label="Valoración" icon={<Star className="h-3 w-3" />} active={isActive("rating")} defaultOpen={false}>
          <div className="relative">
            <Star className={cn("pointer-events-none absolute left-2.5 top-1/2 -translate-y-1/2 h-3.5 w-3.5 z-10", isActive("rating") ? "fill-yellow-400 text-yellow-400" : "text-gartify-gray/70")} />
            <Select value={sp.get("rating") ?? "ALL"} onValueChange={(v) => update("rating", v)}>
              <SelectTrigger className={cn("h-9 w-full pl-8 text-sm transition-all", activeRing("rating"))}>
                <SelectValue placeholder="Cualquier valoración" />
              </SelectTrigger>
              <SelectContent position="popper">
                <SelectItem value="ALL">Cualquier valoración</SelectItem>
                {RATING_OPTIONS.map((r) => <SelectItem key={r.value} value={r.value}><RatingStars stars={r.stars} /></SelectItem>)}
              </SelectContent>
            </Select>
          </div>
        </Section>

        {/* Extras */}
        <Section label="Extras" icon={<PackageCheck className="h-3 w-3" />} active={isActive("cocheCortesia") || isActive("recogida") || isActive("premium") || isActive("conOfertas")} defaultOpen={false}>
          <div className="flex flex-col gap-1.5">
            {[
              { key: "cocheCortesia", icon: <Car className="h-3.5 w-3.5 shrink-0" />, label: "Vehículo de cortesía" },
              { key: "recogida",      icon: <PackageCheck className="h-3.5 w-3.5 shrink-0" />, label: "Servicio de recogida" },
            ].map(({ key, icon, label }) => (
              <button key={key} type="button" onClick={() => update(key, isActive(key) ? "ALL" : "true")}
                className={cn(
                  "w-full flex items-center gap-2 h-9 px-3 rounded-none border text-sm font-medium transition-all",
                  isActive(key) ? "bg-gartify-hero/10 border-gartify-hero/40 text-gartify-hero ring-2 ring-gartify-hero/30" : "bg-white border-gray-200 text-gartify-gray hover:bg-gray-50"
                )}>
                {icon}{label}
                {isActive(key) && <CheckCircle className="h-3.5 w-3.5 ml-auto shrink-0 text-gartify-hero" />}
              </button>
            ))}
            <button type="button" onClick={() => update("premium", isActive("premium") ? "ALL" : "true")}
              className={cn(
                "w-full flex items-center gap-2 h-9 px-3 rounded-none border text-sm font-medium transition-all",
                isActive("premium") ? "bg-amber-50 border-amber-300 text-amber-700 ring-2 ring-amber-200" : "bg-white border-gray-200 text-gartify-gray hover:bg-gray-50"
              )}>
              <Crown className={cn("h-3.5 w-3.5 shrink-0", isActive("premium") ? "text-amber-500" : "")} />
              Taller Premium
              {isActive("premium") && <CheckCircle className="h-3.5 w-3.5 ml-auto shrink-0 text-amber-500" />}
            </button>
            <button type="button" onClick={() => update("conOfertas", isActive("conOfertas") ? "ALL" : "true")}
              className={cn(
                "w-full flex items-center gap-2 h-9 px-3 rounded-none border text-sm font-medium transition-all",
                isActive("conOfertas") ? "bg-green-50 border-green-300 text-green-700 ring-2 ring-green-200" : "bg-white border-gray-200 text-gartify-gray hover:bg-gray-50"
              )}>
              <Zap className={cn("h-3.5 w-3.5 shrink-0", isActive("conOfertas") ? "text-green-600 fill-green-500" : "")} />
              Con ofertas especiales
              {isActive("conOfertas") && <CheckCircle className="h-3.5 w-3.5 ml-auto shrink-0 text-green-600" />}
            </button>
          </div>
        </Section>

      </div>
    </div>
  );
}
