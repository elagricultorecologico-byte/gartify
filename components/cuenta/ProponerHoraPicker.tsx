"use client";

import { useState, useCallback } from "react";

function generateSlots(date: string, openTime: string, closeTime: string): string[] {
  if (!date) return [];
  const [openH, openM]   = openTime.split(":").map(Number);
  const [closeH, closeM] = closeTime.split(":").map(Number);
  const slots: string[] = [];
  let h = openH, m = openM;
  while (h < closeH || (h === closeH && m < closeM)) {
    slots.push(`${date}T${String(h).padStart(2, "0")}:${String(m).padStart(2, "0")}`);
    m += 30;
    if (m >= 60) { h++; m = 0; }
  }
  return slots;
}

function formatSlot(iso: string) {
  const [, time] = iso.split("T");
  return time.slice(0, 5);
}

interface Props {
  garageId: string;
  excludeBookingId: string;
  onSelect: (isoDate: string) => void;
  onCancel: () => void;
  loading: boolean;
  error: string;
}

export function ProponerHoraPicker({ garageId, excludeBookingId, onSelect, onCancel, loading, error }: Props) {
  const today = new Date().toISOString().split("T")[0];
  const [selectedDate, setSelectedDate] = useState("");
  const [selectedSlot, setSelectedSlot] = useState("");
  const [openTime,     setOpenTime]     = useState("08:00");
  const [closeTime,    setCloseTime]    = useState("18:00");
  const [blockedSlots, setBlockedSlots] = useState<Set<string>>(new Set());
  const [dayOpen,      setDayOpen]      = useState<boolean | null>(null);
  const [loadingSlots, setLoadingSlots] = useState(false);

  const fetchSlots = useCallback(async (date: string) => {
    setLoadingSlots(true);
    setSelectedSlot("");
    try {
      const res  = await fetch(`/api/garage/slots?garageId=${garageId}&date=${date}&excludeBookingId=${excludeBookingId}`);
      const data = await res.json() as { open: boolean; openTime: string; closeTime: string; blocked: string[] };
      setDayOpen(data.open ?? true);
      setOpenTime(data.openTime ?? "08:00");
      setCloseTime(data.closeTime ?? "18:00");
      setBlockedSlots(new Set(data.blocked ?? []));
    } catch {
      setDayOpen(true);
    } finally {
      setLoadingSlots(false);
    }
  }, [garageId, excludeBookingId]);

  function handleDateChange(date: string) {
    setSelectedDate(date);
    if (date) fetchSlots(date);
  }

  const slots   = generateSlots(selectedDate, openTime, closeTime);
  const amSlots = slots.filter((s) => parseInt(s.split("T")[1].split(":")[0]) < 12);
  const pmSlots = slots.filter((s) => parseInt(s.split("T")[1].split(":")[0]) >= 12);

  return (
    <>
      {/* Overlay */}
      <div
        className="fixed inset-0 z-40 bg-black/40"
        onClick={onCancel}
        aria-hidden="true"
      />

      {/* Panel — ocupa ancho completo en móvil, panel fijo en desktop */}
      <div className="fixed inset-x-0 bottom-0 z-50 sm:inset-auto sm:right-4 sm:bottom-4 sm:w-80">
        <div className="bg-white rounded-t-2xl sm:rounded-xl border border-gray-200 shadow-xl p-4 flex flex-col gap-4">

          {/* Cabecera */}
          <div className="flex items-center justify-between">
            <p className="text-sm font-bold text-gartify-blue">Proponer nueva hora</p>
            <button
              type="button"
              onClick={onCancel}
              className="text-muted-foreground hover:text-foreground text-lg leading-none px-1"
              aria-label="Cerrar"
            >
              ✕
            </button>
          </div>

          {/* Selector de fecha */}
          <div>
            <label className="text-xs text-muted-foreground font-semibold mb-1 block">Fecha</label>
            <input
              type="date"
              min={today}
              value={selectedDate}
              onChange={(e) => handleDateChange(e.target.value)}
              className="text-sm border border-gray-200 rounded-lg px-3 py-2 w-full outline-none focus:ring-2 focus:ring-gartify-blue/30"
            />
          </div>

          {/* Slots */}
          {selectedDate && (
            <div>
              <label className="text-xs text-muted-foreground font-semibold mb-1.5 block">Hora</label>
              {loadingSlots ? (
                <p className="text-xs text-muted-foreground">Cargando horarios...</p>
              ) : dayOpen === false ? (
                <p className="text-xs text-muted-foreground">El taller está cerrado ese día.</p>
              ) : slots.length === 0 ? (
                <p className="text-xs text-muted-foreground">Sin huecos disponibles.</p>
              ) : (
                <div className="flex flex-col gap-2">
                  {[
                    { label: "Mañana", group: amSlots },
                    { label: "Tarde",  group: pmSlots },
                  ].filter(({ group }) => group.length > 0).map(({ label, group }) => (
                    <div key={label}>
                      <p className="text-[10px] font-bold uppercase tracking-widest text-muted-foreground mb-1.5">{label}</p>
                      <div className="flex flex-wrap gap-1.5">
                        {group.map((slot) => {
                          const blocked  = blockedSlots.has(slot);
                          const selected = slot === selectedSlot;
                          return (
                            <button
                              key={slot}
                              type="button"
                              disabled={blocked}
                              onClick={() => setSelectedSlot(slot)}
                              className={`px-3 py-1.5 rounded-lg text-sm font-semibold transition-colors ${
                                selected
                                  ? "bg-gartify-blue text-white"
                                  : blocked
                                  ? "bg-gray-100 text-gray-300 cursor-not-allowed line-through"
                                  : "bg-gray-100 text-gartify-gray hover:bg-gartify-blue/10 hover:text-gartify-blue"
                              }`}
                            >
                              {formatSlot(slot)}
                            </button>
                          );
                        })}
                      </div>
                    </div>
                  ))}
                </div>
              )}
            </div>
          )}

          {error && <p className="text-xs text-red-500">{error}</p>}

          {/* Acciones */}
          <div className="flex gap-2 pt-1 border-t border-gray-100">
            <button
              type="button"
              onClick={onCancel}
              className="flex-1 text-sm text-muted-foreground hover:text-foreground border border-gray-200 rounded-lg py-2 transition-colors"
            >
              Cancelar
            </button>
            <button
              type="button"
              disabled={!selectedSlot || loading}
              onClick={() => onSelect(selectedSlot)}
              className="flex-1 text-sm font-semibold text-white bg-gartify-blue rounded-lg py-2 hover:bg-gartify-blue/90 disabled:opacity-50 transition-colors"
            >
              {loading ? "Enviando..." : "Proponer"}
            </button>
          </div>
        </div>
      </div>
    </>
  );
}
