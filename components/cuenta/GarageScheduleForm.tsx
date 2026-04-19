"use client";
import { useState } from "react";
import { Button } from "@/components/ui/button";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";
import { CheckCircle, AlertCircle, Loader2, Copy, X } from "lucide-react";
import { cn } from "@/lib/utils";

const DAY_LABELS = ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];
const DAY_ORDER = [1, 2, 3, 4, 5, 6, 0];

type DaySchedule = {
  dayOfWeek:      number;
  isOpen:         boolean;
  openTime:       string;
  closeTime:      string;
  afternoonStart: string | null;
  afternoonEnd:   string | null;
};

const TIME_OPTIONS: string[] = [];
for (let h = 6; h <= 23; h++) {
  TIME_OPTIONS.push(`${String(h).padStart(2, "0")}:00`);
  if (h < 23) TIME_OPTIONS.push(`${String(h).padStart(2, "0")}:30`);
}

const LABEL_CLS = "text-xs font-semibold text-gartify-blue uppercase tracking-wide w-14 shrink-0";

function TimeSelect({
  value,
  options,
  onChange,
}: {
  value: string;
  options: string[];
  onChange: (v: string) => void;
}) {
  return (
    <Select value={value} onValueChange={onChange}>
      <SelectTrigger className="h-8 w-24 text-sm font-medium text-gartify-blue">
        <SelectValue />
      </SelectTrigger>
      <SelectContent className="max-h-52">
        {options.map((t) => (
          <SelectItem key={t} value={t} className="text-sm">{t}</SelectItem>
        ))}
      </SelectContent>
    </Select>
  );
}

export function GarageScheduleForm({ initial }: { initial: DaySchedule[] }) {
  const [schedule, setSchedule] = useState<DaySchedule[]>(() =>
    Array.from({ length: 7 }, (_, i) => {
      const found = initial.find((d) => d.dayOfWeek === i);
      return found ?? {
        dayOfWeek:      i,
        isOpen:         i >= 1 && i <= 5,
        openTime:       "08:00",
        closeTime:      "14:00",
        afternoonStart: i >= 1 && i <= 5 ? "16:00" : null,
        afternoonEnd:   i >= 1 && i <= 5 ? "20:00" : null,
      };
    })
  );

  const [loading, setLoading] = useState(false);
  const [error,   setError]   = useState("");
  const [success, setSuccess] = useState(false);

  function updateDay(dayOfWeek: number, patch: Partial<DaySchedule>) {
    setSchedule((prev) =>
      prev.map((d) => (d.dayOfWeek === dayOfWeek ? { ...d, ...patch } : d))
    );
    setSuccess(false);
  }

  function copyMonToFri() {
    const mon = schedule[1];
    setSchedule((prev) =>
      prev.map((d) =>
        d.dayOfWeek >= 2 && d.dayOfWeek <= 5
          ? { ...d, openTime: mon.openTime, closeTime: mon.closeTime, afternoonStart: mon.afternoonStart, afternoonEnd: mon.afternoonEnd }
          : d
      )
    );
    setSuccess(false);
  }

  async function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    setLoading(true);
    setError("");
    setSuccess(false);
    const res = await fetch("/api/garage/schedule", {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(schedule),
    });
    setLoading(false);
    if (!res.ok) {
      const d = await res.json() as { error?: string };
      setError(d.error ?? "Error al guardar el horario");
      return;
    }
    setSuccess(true);
  }

  return (
    <form onSubmit={handleSubmit} className="space-y-2">
      {DAY_ORDER.map((dow) => {
        const day = schedule[dow];
        return (
          <div
            key={dow}
            className={cn(
              "border px-4 py-3 transition-colors",
              day.isOpen ? "bg-white border-gray-200" : "bg-gray-50 border-gray-100"
            )}
          >
            <div className="flex flex-col sm:flex-row sm:items-start gap-3">
              {/* Toggle + nombre */}
              <div className="flex items-center gap-3 sm:w-36 shrink-0 pt-1">
                <button
                  type="button"
                  role="switch"
                  aria-checked={day.isOpen}
                  onClick={() => updateDay(dow, { isOpen: !day.isOpen })}
                  className={cn(
                    "relative inline-flex h-5 w-9 shrink-0 cursor-pointer rounded-full border-2 border-transparent transition-colors focus-visible:outline-none",
                    day.isOpen ? "bg-gartify-hero" : "bg-gray-200"
                  )}
                >
                  <span
                    className={cn(
                      "pointer-events-none inline-block h-4 w-4 rounded-full bg-white shadow-lg ring-0 transition-transform",
                      day.isOpen ? "translate-x-4" : "translate-x-0"
                    )}
                  />
                </button>
                <span className={cn("text-sm font-semibold w-20", day.isOpen ? "text-gartify-blue" : "text-gray-400")}>
                  {DAY_LABELS[dow]}
                </span>
              </div>

              {/* Horarios */}
              {day.isOpen ? (
                <div className="flex flex-col gap-2 flex-1">

                  {/* Mañana */}
                  <div className="flex items-center gap-2 flex-wrap">
                    <span className={LABEL_CLS}>Mañana</span>
                    <TimeSelect
                      value={day.openTime}
                      options={TIME_OPTIONS}
                      onChange={(v) => updateDay(dow, { openTime: v })}
                    />
                    <span className="text-xs text-gartify-gray">–</span>
                    <TimeSelect
                      value={day.closeTime}
                      options={TIME_OPTIONS.filter((t) => t > day.openTime)}
                      onChange={(v) => updateDay(dow, { closeTime: v })}
                    />
                  </div>

                  {/* Tarde */}
                  <div className="flex items-center gap-2 flex-wrap">
                    <span className={LABEL_CLS}>Tarde</span>
                    {day.afternoonStart ? (
                      <>
                        <TimeSelect
                          value={day.afternoonStart}
                          options={TIME_OPTIONS.filter((t) => t > day.closeTime)}
                          onChange={(v) => updateDay(dow, { afternoonStart: v })}
                        />
                        <span className="text-xs text-gartify-gray">–</span>
                        <TimeSelect
                          value={day.afternoonEnd ?? "20:00"}
                          options={TIME_OPTIONS.filter((t) => t > (day.afternoonStart ?? "16:00"))}
                          onChange={(v) => updateDay(dow, { afternoonEnd: v })}
                        />
                        <button
                          type="button"
                          onClick={() => updateDay(dow, { afternoonStart: null, afternoonEnd: null })}
                          className="p-1 text-gray-300 hover:text-red-400 transition-colors"
                          title="Sin horario de tarde"
                        >
                          <X className="h-3.5 w-3.5" />
                        </button>
                      </>
                    ) : (
                      <button
                        type="button"
                        onClick={() => {
                          const [h, m] = day.closeTime.split(":").map(Number);
                          const afterMins = h * 60 + m + 60;
                          const afterH = String(Math.floor(afterMins / 60)).padStart(2, "0");
                          const afterM = String(afterMins % 60).padStart(2, "0");
                          const start = `${afterH}:${afterM}`;
                          const sh = Math.floor(afterMins / 60) + 2;
                          const sm = afterMins % 60;
                          const end = `${String(sh).padStart(2, "0")}:${String(sm).padStart(2, "0")}`;
                          updateDay(dow, { afternoonStart: start, afternoonEnd: end });
                        }}
                        className="text-xs text-gray-400 hover:text-gartify-blue underline underline-offset-2 transition-colors"
                      >
                        Sin horario de tarde — añadir
                      </button>
                    )}
                  </div>

                  {/* Botón copiar Lun→Vie */}
                  {dow === 1 && (
                    <button
                      type="button"
                      onClick={copyMonToFri}
                      className="self-start mt-0.5 flex items-center gap-1.5 border border-dashed border-gray-300 px-2.5 py-1 text-xs text-gray-400 hover:border-gartify-blue/40 hover:text-gartify-blue transition-colors"
                    >
                      <Copy className="h-3 w-3" />
                      Aplicar a Lun–Vie
                    </button>
                  )}
                </div>
              ) : (
                <span className="text-sm text-gray-400 italic pt-1">Cerrado</span>
              )}
            </div>
          </div>
        );
      })}

      {error && (
        <div role="alert" className="flex items-center gap-2 bg-red-50 border border-red-100 px-3 py-2 text-sm text-red-600 mt-3">
          <AlertCircle className="h-4 w-4 shrink-0" />
          {error}
        </div>
      )}
      {success && (
        <div role="status" className="flex items-center gap-2 bg-green-50 border border-green-100 px-3 py-2 text-sm text-green-700 mt-3">
          <CheckCircle className="h-4 w-4 shrink-0" />
          Horario guardado correctamente.
        </div>
      )}

      <div className="pt-2">
        <Button type="submit" disabled={loading} className="bg-gartify-green hover:bg-gartify-green/90 text-white font-semibold gap-2">
          {loading
            ? <><Loader2 className="h-4 w-4 animate-spin" />Guardando...</>
            : <><CheckCircle className="h-4 w-4" />Guardar horario</>
          }
        </Button>
      </div>
    </form>
  );
}
