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
          return (
            <div key={label} className={`rounded-xl border ${border} ${bg} p-3 sm:p-4 flex items-center gap-3`}>
              <div className="h-9 w-9 rounded-full bg-white flex items-center justify-center shadow-sm shrink-0">
                <Icon className={`h-4 w-4 ${color}`} aria-hidden="true" />
              </div>
              <div>
                <p className="text-xs text-muted-foreground">{label}</p>
                <p className="font-bold text-foreground text-base leading-tight">{value}</p>
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
}
