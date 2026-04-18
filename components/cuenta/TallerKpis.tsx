"use client";
import { useState } from "react";
import { BarChart3, Calendar, TrendingUp, Euro, Star } from "lucide-react";

const ICON_MAP = { Calendar, TrendingUp, Euro, Star } as const;
type IconKey = keyof typeof ICON_MAP;

export interface KpiData {
  icon: IconKey;
  label: string;
  value: string | number;
  color: string;
  bg: string;
  border: string;
}

export function TallerKpis({ stats }: { stats: KpiData[] }) {
  const [visible, setVisible] = useState(false);

  return (
    <div className="mb-6">
      {/* Toggle solo en móvil */}
      <button
        type="button"
        onClick={() => setVisible((v) => !v)}
        className="flex lg:hidden items-center gap-2 text-xs font-semibold text-gartify-gray mb-2"
      >
        <BarChart3 className="h-4 w-4" />
        {visible ? "Ocultar estadísticas" : "Ver estadísticas"}
      </button>

      <div className={`grid grid-cols-2 md:grid-cols-4 gap-3 ${!visible ? "hidden lg:grid" : "grid"}`}>
        {stats.map(({ icon, label, value, color, bg, border }) => {
          const Icon = ICON_MAP[icon];
          const isPendientes = label === "Pendientes" && Number(value) > 0;
          return (
            <div
              key={label}
              className={`rounded-xl border ${border} ${bg} px-4 py-3 flex flex-col gap-1 ${
                isPendientes ? "ring-2 ring-amber-400/60 ring-offset-1" : ""
              }`}
            >
              <div className="flex items-center justify-between">
                <p className="text-xs font-semibold text-muted-foreground uppercase tracking-wide">{label}</p>
                <Icon className={`h-4 w-4 ${color}`} aria-hidden="true" />
              </div>
              <p className="font-extrabold text-foreground text-2xl leading-none tracking-tight">{value}</p>
            </div>
          );
        })}
      </div>
    </div>
  );
}
