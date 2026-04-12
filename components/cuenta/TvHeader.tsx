"use client";
import { useState } from "react";
import Link from "next/link";
import { BarChart3 } from "lucide-react";
import { TvReloj } from "./TvReloj";

interface TvHeaderProps {
  tallerName: string;
  citasHoy: number;
  completadasHoy: number;
  nPendientes: number;
  proximaHora: string | null;
  proximaFecha: string | null;
}

export function TvHeader({ tallerName, citasHoy, completadasHoy, nPendientes, proximaHora, proximaFecha }: TvHeaderProps) {
  const [kpisVisible, setKpisVisible] = useState(false);

  return (
    <header className="sticky top-0 z-10 bg-gartify-dark/95 backdrop-blur border-b border-white/10 px-4 lg:px-10 py-2 lg:py-4">

      {/* Fila principal */}
      <div className="flex items-center gap-3 lg:gap-6">

        {/* Logo + badge */}
        <div className="flex items-center gap-2 shrink-0">
          <span aria-hidden="true">🔧</span>
          <span className="text-sm lg:text-lg font-black text-white tracking-tight">Gartify</span>
          <span className="flex items-center gap-1 rounded-full bg-red-500/20 border border-red-500/40 text-red-400 text-[10px] lg:text-xs font-bold px-2 lg:px-3 py-0.5 lg:py-1 uppercase tracking-widest">
            <span className="h-1.5 w-1.5 rounded-full bg-red-400 animate-pulse" />
            <span className="hidden sm:inline">En vivo</span>
          </span>
        </div>

        {/* Nombre del taller */}
        <span className="text-sm font-semibold text-slate-300 truncate flex-1 lg:flex-none lg:shrink-0 lg:max-w-xs">{tallerName}</span>

        {/* KPIs — siempre visibles en desktop, toggle en móvil */}
        <div className={`hidden lg:flex flex-1 items-center justify-center gap-4`}>
          <KpiBox label="Hoy" value={citasHoy} color="text-white" bg="bg-white/5 border-white/10" />
          <KpiBox label="Listas" value={completadasHoy} color="text-green-300" bg="bg-green-500/10 border-green-500/20" />
          <KpiBox label="Pendientes" value={nPendientes} color="text-yellow-300" bg="bg-yellow-500/10 border-yellow-500/20" />
          <div className="flex flex-1 flex-col items-center px-4 py-2 rounded-xl bg-white/5 border border-white/10">
            <span className="text-[10px] text-slate-500 uppercase tracking-widest font-semibold">Próxima</span>
            <span className="text-2xl font-black text-white leading-tight">{proximaHora ?? "—"}</span>
            {proximaFecha && <span className="text-[9px] text-slate-400 capitalize">{proximaFecha}</span>}
          </div>
        </div>

        {/* Reloj + toggle KPIs (móvil) + volver */}
        <div className="flex items-center gap-2 shrink-0">
          <TvReloj />
          <button
            type="button"
            onClick={() => setKpisVisible((v) => !v)}
            className="lg:hidden rounded-lg bg-white/10 hover:bg-white/20 transition-colors px-2 py-1 text-xs font-semibold text-slate-300 hover:text-white"
            aria-label="Ver KPIs"
          >
            <BarChart3 className="h-4 w-4" />
          </button>
          <Link
            href="/cuenta/taller"
            className="rounded-lg bg-white/10 hover:bg-white/20 transition-colors px-2 lg:px-4 py-1 lg:py-2 text-xs lg:text-sm font-semibold text-slate-300 hover:text-white"
          >
            ← Volver
          </Link>
        </div>

      </div>

      {/* KPIs expandibles en móvil */}
      {kpisVisible && (
        <div className="lg:hidden grid grid-cols-4 gap-2 mt-2">
          <KpiBox label="Hoy" value={citasHoy} color="text-white" bg="bg-white/5 border-white/10" />
          <KpiBox label="Listas" value={completadasHoy} color="text-green-300" bg="bg-green-500/10 border-green-500/20" />
          <KpiBox label="Pendientes" value={nPendientes} color="text-yellow-300" bg="bg-yellow-500/10 border-yellow-500/20" />
          <div className="flex flex-col items-center px-2 py-1.5 rounded-lg bg-white/5 border border-white/10">
            <span className="text-[9px] text-slate-500 uppercase font-semibold">Próxima</span>
            <span className="text-lg font-black text-white leading-tight">{proximaHora ?? "—"}</span>
            {proximaFecha && <span className="text-[9px] text-slate-400 capitalize">{proximaFecha}</span>}
          </div>
        </div>
      )}

    </header>
  );
}

function KpiBox({ label, value, color, bg }: { label: string; value: number; color: string; bg: string }) {
  return (
    <div className={`flex flex-1 flex-col items-center px-2 lg:px-4 py-1.5 lg:py-2 rounded-lg lg:rounded-xl border ${bg}`}>
      <span className="text-[9px] lg:text-[10px] text-slate-500 uppercase tracking-widest font-semibold">{label}</span>
      <span className={`text-lg lg:text-2xl font-black leading-tight ${color}`}>{value}</span>
    </div>
  );
}
