"use client";
import { useState } from "react";

interface Tab {
  key: string;
  label: string;
  count: number;
  dot: string;
  empty: { icon: string; text: string };
  children: React.ReactNode;
}

export function TvColumnasTabs({ tabs }: { tabs: Tab[] }) {
  const [activo, setActivo] = useState(tabs[0]?.key ?? "");

  const tabActivo = tabs.find((t) => t.key === activo) ?? tabs[0];

  return (
    <>
      {/* ── Tabs (solo móvil) ── */}
      <div className="flex lg:hidden border-b border-white/10">
        {tabs.map((tab) => (
          <button
            key={tab.key}
            onClick={() => setActivo(tab.key)}
            className={`flex flex-1 items-center justify-center gap-1.5 px-2 py-2.5 text-xs font-bold border-b-2 transition-colors ${
              activo === tab.key
                ? "border-white text-white"
                : "border-transparent text-slate-400 hover:text-white"
            }`}
          >
            <span className={`h-2 w-2 rounded-full ${tab.dot}`} />
            {tab.label}
            <span className="rounded-full bg-white/10 px-1.5 py-0.5 text-[10px]">{tab.count}</span>
          </button>
        ))}
      </div>

      {/* ── Contenido móvil ── */}
      <div className="lg:hidden flex-1 overflow-y-auto px-4 py-4">
        {tabActivo.count === 0 ? (
          <div className="flex flex-col items-center justify-center gap-3 rounded-xl border border-white/5 py-16">
            <span className="text-4xl">{tabActivo.empty.icon}</span>
            <p className="text-slate-500 text-sm">{tabActivo.empty.text}</p>
          </div>
        ) : (
          <div className="flex flex-col gap-2">{tabActivo.children}</div>
        )}
      </div>

      {/* ── Layout TV desktop (3 columnas) — oculto en móvil ── */}
      <main className="hidden lg:flex flex-1 px-6 py-6 gap-6">
        {tabs.map((tab, i) => (
          <div key={tab.key} className="contents">
            {i > 0 && <div className="w-px bg-white/10 shrink-0" />}
            <div className="flex flex-col flex-1 min-w-0">
              <div className="flex items-center gap-3 mb-4">
                <span className={`h-3 w-3 rounded-full ${tab.dot} shrink-0`} />
                <h2 className="text-lg font-black text-white tracking-tight">{tab.label}</h2>
                <span className="rounded-full bg-white/10 border border-white/10 text-slate-300 text-sm font-bold px-3 py-0.5">
                  {tab.count}
                </span>
              </div>
              {tab.count === 0 ? (
                <div className="flex flex-col items-center justify-center flex-1 gap-3 rounded-xl border border-white/5 py-16">
                  <span className="text-4xl">{tab.empty.icon}</span>
                  <p className="text-slate-500 text-sm">{tab.empty.text}</p>
                </div>
              ) : (
                <div className="flex flex-col gap-2">{tab.children}</div>
              )}
            </div>
          </div>
        ))}
      </main>
    </>
  );
}
