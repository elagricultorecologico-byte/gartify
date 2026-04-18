"use client";

import { useState, useEffect, useCallback, useMemo, useRef } from "react";
import {
  ChevronLeft, ChevronRight, X, Loader2,
  Phone, Wrench, Car, Euro, StickyNote, Calendar,
} from "lucide-react";
import { Button } from "@/components/ui/button";
import { formatPrice } from "@/lib/utils";

// ─── Tipos ────────────────────────────────────────────────────────────────────

interface BookingItem {
  id: string;
  code: string;
  source: string;
  status: string;
  date: string;
  totalPrice: number;
  clientName: string | null;
  clientPhone: string | null;
  serviceLabel: string | null;
  vehiclePlate: string | null;
  vehicleModel: string | null;
  notes: string | null;
  service: { name: string; duration: number } | null;
  user: { name: string | null; phone: string | null } | null;
}

interface ScheduleDay {
  dayOfWeek:      number; // 0=Dom, 1=Lun … 6=Sáb
  isOpen:         boolean;
  openTime:       string; // "08:00"
  closeTime:      string; // fin de mañana / fin de jornada si no hay tarde
  afternoonStart: string | null; // inicio de tarde (null = jornada continua)
  afternoonEnd:   string | null; // fin de tarde
}

const STATUS_LABELS: Record<string, string> = {
  PENDING:   "Pendiente",
  PROPOSED:  "Propuesta",
  CONFIRMED: "Confirmada",
  COMPLETED: "Completada",
  CANCELLED: "Cancelada",
};

const STATUS_COLORS: Record<string, string> = {
  PENDING:   "bg-amber-100 text-amber-700 border-amber-200",
  PROPOSED:  "bg-purple-100 text-purple-700 border-purple-200",
  CONFIRMED: "bg-blue-100 text-blue-700 border-blue-200",
  COMPLETED: "bg-green-100 text-green-700 border-green-200",
  CANCELLED: "bg-red-100 text-red-500 border-red-200",
};

const MONTH_SHORT = ["Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"];
const DAY_INITIALS = ["L","M","X","J","V","S","D"];

// ─── Helpers ──────────────────────────────────────────────────────────────────

function timeToMins(t: string): number {
  const [h, m] = t.split(":").map(Number);
  return h * 60 + m;
}

function generateSlots(from: string, to: string): string[] {
  const result: string[] = [];
  let mins = timeToMins(from);
  const end = timeToMins(to);
  while (mins <= end) {
    result.push(
      `${String(Math.floor(mins / 60)).padStart(2, "0")}:${String(mins % 60).padStart(2, "0")}`
    );
    mins += 30;
  }
  return result;
}

function startOfWeek(date: Date): Date {
  const d   = new Date(date);
  const day = d.getDay();
  d.setDate(d.getDate() + (day === 0 ? -6 : 1 - day));
  d.setHours(0, 0, 0, 0);
  return d;
}

function addDays(date: Date, n: number): Date {
  const d = new Date(date);
  d.setDate(d.getDate() + n);
  return d;
}

function isSameDay(a: Date, b: Date): boolean {
  return (
    a.getFullYear() === b.getFullYear() &&
    a.getMonth() === b.getMonth() &&
    a.getDate() === b.getDate()
  );
}

function toLocalISOString(date: Date): string {
  const pad = (n: number) => String(n).padStart(2, "0");
  return `${date.getFullYear()}-${pad(date.getMonth() + 1)}-${pad(date.getDate())}`;
}

function slotDateTime(day: Date, timeStr: string): Date {
  const [h, m] = timeStr.split(":").map(Number);
  const d = new Date(day);
  d.setHours(h, m, 0, 0);
  return d;
}

// ─── Popup calendario anual ───────────────────────────────────────────────────

function YearCalendarPopup({
  year,
  onYearChange,
  selectedWeekStart,
  onSelectWeek,
  onClose,
}: {
  year: number;
  onYearChange: (y: number) => void;
  selectedWeekStart: Date;
  onSelectWeek: (ws: Date) => void;
  onClose: () => void;
}) {
  const today = new Date();

  function handleSelectWeek(ws: Date) {
    onSelectWeek(ws);
    onClose();
  }

  return (
    <div className="bg-white border border-gray-200 rounded-xl p-4 shadow-xl w-[520px] max-w-[95vw]">
      {/* Navegación de año */}
      <div className="flex items-center justify-between mb-3">
        <button
          onClick={() => onYearChange(year - 1)}
          className="p-1.5 rounded-lg border border-gray-200 hover:bg-gray-50 transition-colors"
        >
          <ChevronLeft className="h-3.5 w-3.5" />
        </button>
        <span className="text-sm font-bold text-gartify-blue">{year}</span>
        <button
          onClick={() => onYearChange(year + 1)}
          className="p-1.5 rounded-lg border border-gray-200 hover:bg-gray-50 transition-colors"
        >
          <ChevronRight className="h-3.5 w-3.5" />
        </button>
      </div>

      {/* 12 meses — 4 columnas */}
      <div className="grid grid-cols-4 gap-x-4 gap-y-5">
        {Array.from({ length: 12 }, (_, month) => (
          <MiniMonth
            key={month}
            year={year}
            month={month}
            today={today}
            selectedWeekStart={selectedWeekStart}
            onSelectWeek={handleSelectWeek}
          />
        ))}
      </div>
    </div>
  );
}

function MiniMonth({
  year, month, today, selectedWeekStart, onSelectWeek,
}: {
  year: number;
  month: number;
  today: Date;
  selectedWeekStart: Date;
  onSelectWeek: (ws: Date) => void;
}) {
  // 42 días desde el lunes anterior al 1 del mes (6 semanas completas)
  const gridStart = startOfWeek(new Date(year, month, 1));
  const days = Array.from({ length: 42 }, (_, i) => addDays(gridStart, i));

  return (
    <div>
      <p className="text-[10px] font-bold text-center text-gartify-blue uppercase tracking-wide mb-1">
        {MONTH_SHORT[month]}
      </p>
      <div className="grid grid-cols-7">
        {DAY_INITIALS.map(d => (
          <div key={d} className="text-[8px] text-center text-muted-foreground font-medium pb-0.5">
            {d}
          </div>
        ))}
        {days.map((day, i) => {
          const inMonth     = day.getMonth() === month && day.getFullYear() === year;
          const isToday     = isSameDay(day, today);
          const ws          = startOfWeek(day);
          const isSelWeek   = ws.getTime() === selectedWeekStart.getTime();

          return (
            <button
              key={i}
              onClick={() => inMonth && onSelectWeek(ws)}
              className={[
                "text-[9px] text-center leading-none py-[3px] rounded transition-colors",
                !inMonth
                  ? "text-gray-200 pointer-events-none"
                  : "cursor-pointer",
                isToday
                  ? "bg-gartify-orange text-white font-bold rounded-full hover:bg-orange-500"
                  : isSelWeek && inMonth
                    ? "bg-gartify-blue/10 text-gartify-blue font-semibold"
                    : inMonth
                      ? "text-gray-700 hover:bg-blue-50"
                      : "",
              ].filter(Boolean).join(" ")}
            >
              {day.getDate()}
            </button>
          );
        })}
      </div>
    </div>
  );
}

// ─── Componente principal ─────────────────────────────────────────────────────

// eslint-disable-next-line @typescript-eslint/no-unused-vars
export function AgendaTaller({ garageId }: { garageId: string }) {
  const [weekStart, setWeekStart] = useState(() => startOfWeek(new Date()));
  const [calYear,   setCalYear]   = useState(() => new Date().getFullYear());
  const [showCal,   setShowCal]   = useState(false);
  const [bookings,  setBookings]  = useState<BookingItem[]>([]);
  const [blocked,   setBlocked]   = useState<Set<string>>(new Set());
  const [schedule,  setSchedule]  = useState<ScheduleDay[]>([]);
  const [loading,   setLoading]   = useState(true);
  const [toggling,  setToggling]  = useState<string | null>(null);
  const [selectedBooking, setSelectedBooking] = useState<BookingItem | null>(null);
  const calRef = useRef<HTMLDivElement>(null);

  // Sincronizar año del calendario con la semana visible
  useEffect(() => { setCalYear(weekStart.getFullYear()); }, [weekStart]);

  // Cerrar popup al hacer clic fuera
  useEffect(() => {
    if (!showCal) return;
    function handleClickOutside(e: MouseEvent) {
      if (calRef.current && !calRef.current.contains(e.target as Node)) {
        setShowCal(false);
      }
    }
    document.addEventListener("mousedown", handleClickOutside);
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, [showCal]);

  const weekDays = useMemo(
    () => Array.from({ length: 7 }, (_, i) => addDays(weekStart, i)),
    [weekStart]
  );
  const weekFrom = weekStart.toISOString();
  const weekTo   = addDays(weekStart, 6).toISOString();

  // Mapa de horario: dayOfWeek → ScheduleDay
  const scheduleMap = useMemo(() => {
    const map: Record<number, ScheduleDay> = {};
    for (const d of schedule) map[d.dayOfWeek] = d;
    return map;
  }, [schedule]);

  // Rango horario global (unión de todos los días abiertos)
  const globalFrom = useMemo(() => {
    const open = schedule.filter(d => d.isOpen).map(d => d.openTime);
    return open.length ? open.reduce((a, b) => (a < b ? a : b)) : "08:00";
  }, [schedule]);

  const globalTo = useMemo(() => {
    const open  = schedule.filter(d => d.isOpen);
    const times = open.map(d => d.afternoonEnd ?? d.closeTime);
    return times.length ? times.reduce((a, b) => (a > b ? a : b)) : "18:00";
  }, [schedule]);

  const hours = useMemo(() => generateSlots(globalFrom, globalTo), [globalFrom, globalTo]);

  // Cargar horario una vez al montar
  useEffect(() => {
    fetch("/api/garage/schedule")
      .then(r => r.ok ? r.json() : null)
      .then((data: ScheduleDay[] | null) => { if (data) setSchedule(data); })
      .catch(() => {});
  }, []);

  const fetchData = useCallback(async () => {
    setLoading(true);
    const [bRes, slRes] = await Promise.all([
      fetch(`/api/garage/bookings?from=${weekFrom}&to=${weekTo}`),
      fetch(`/api/garage/blocked-slots?from=${weekFrom}&to=${weekTo}`),
    ]);
    if (bRes.ok)  setBookings(await bRes.json() as BookingItem[]);
    if (slRes.ok) setBlocked(new Set(await slRes.json() as string[]));
    setLoading(false);
  }, [weekFrom, weekTo]);

  useEffect(() => { void fetchData(); }, [fetchData]);

  const today = new Date();

  function getDaySched(day: Date): ScheduleDay | undefined {
    return scheduleMap[day.getDay()];
  }

  function isDayClosed(day: Date): boolean {
    const s = getDaySched(day);
    return s ? !s.isOpen : false;
  }

  function isOutsideHours(day: Date, time: string): boolean {
    const s = getDaySched(day);
    if (!s || !s.isOpen) return false;
    const effectiveClose = s.afternoonEnd ?? s.closeTime;
    return time < s.openTime || time >= effectiveClose;
  }

  // Pausa de comida: entre fin de mañana y inicio de tarde
  function isLunchBreak(day: Date, time: string): boolean {
    const s = getDaySched(day);
    if (!s || !s.isOpen || !s.afternoonStart) return false;
    return time >= s.closeTime && time < s.afternoonStart;
  }

  function bookingAt(day: Date, time: string): BookingItem | undefined {
    const t = slotDateTime(day, time);
    return bookings.find(b => {
      const bd = new Date(b.date);
      return (
        isSameDay(bd, day) &&
        bd.getHours() === t.getHours() &&
        bd.getMinutes() === t.getMinutes()
      );
    });
  }

  function slotKey(day: Date, time: string): string {
    return slotDateTime(day, time).toISOString();
  }

  async function toggleBlock(day: Date, time: string) {
    const iso = slotKey(day, time);
    if (toggling) return;
    setToggling(iso);
    if (blocked.has(iso)) {
      await fetch(`/api/garage/blocked-slots/${encodeURIComponent(iso)}`, { method: "DELETE" });
      setBlocked(prev => { const s = new Set(prev); s.delete(iso); return s; });
    } else {
      await fetch("/api/garage/blocked-slots", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ date: iso }),
      });
      setBlocked(prev => new Set(prev).add(iso));
    }
    setToggling(null);
  }

  return (
    <div className="space-y-4">

      {/* ── Navegación semanal + popup calendario ── */}
      <div className="flex items-center gap-2 flex-wrap">
        <button
          onClick={() => setWeekStart(d => addDays(d, -7))}
          className="p-2 rounded-lg border border-gray-200 hover:bg-gray-50 transition-colors"
        >
          <ChevronLeft className="h-4 w-4" />
        </button>
        <button
          onClick={() => setWeekStart(startOfWeek(new Date()))}
          className="px-3 py-1.5 text-sm font-semibold rounded-lg border border-gray-200 hover:bg-gray-50 transition-colors"
        >
          Hoy
        </button>
        <button
          onClick={() => setWeekStart(d => addDays(d, 7))}
          className="p-2 rounded-lg border border-gray-200 hover:bg-gray-50 transition-colors"
        >
          <ChevronRight className="h-4 w-4" />
        </button>

        {/* Trigger del popup de calendario */}
        <div className="relative" ref={calRef}>
          <button
            onClick={() => setShowCal(v => !v)}
            className={`flex items-center gap-2 px-3 py-1.5 text-sm font-semibold rounded-lg border transition-colors ml-1 ${
              showCal
                ? "bg-gartify-blue text-white border-gartify-blue"
                : "border-gray-200 text-gartify-blue hover:bg-gartify-blue/5"
            }`}
          >
            <Calendar className="h-4 w-4 shrink-0" />
            <span>
              {weekStart.toLocaleDateString("es-ES", { day: "numeric", month: "short" })}
              {" – "}
              {addDays(weekStart, 6).toLocaleDateString("es-ES", { day: "numeric", month: "short", year: "numeric" })}
            </span>
          </button>

          {showCal && (
            <div className="absolute top-full left-0 mt-2 z-50">
              <YearCalendarPopup
                year={calYear}
                onYearChange={setCalYear}
                selectedWeekStart={weekStart}
                onSelectWeek={setWeekStart}
                onClose={() => setShowCal(false)}
              />
            </div>
          )}
        </div>

        <div className="ml-auto flex items-center gap-3 text-xs text-muted-foreground">
          <span className="flex items-center gap-1.5">
            <span className="w-3 h-3 rounded bg-blue-100 border border-blue-300 inline-block" />
            Reserva
          </span>
          <span className="flex items-center gap-1.5">
            <span className="w-3 h-3 rounded bg-amber-50 border border-amber-200 inline-block" />
            Comida
          </span>
          <span className="flex items-center gap-1.5">
            <span className="w-3 h-3 rounded bg-gray-200 border border-gray-300 inline-block" />
            Bloqueado
          </span>
          <span className="flex items-center gap-1.5">
            <span className="w-3 h-3 rounded bg-white border border-gray-200 inline-block" />
            Libre
          </span>
        </div>
      </div>

      {/* ── Grid horario ── */}
      {loading ? (
        <div className="flex justify-center py-16">
          <Loader2 className="h-6 w-6 animate-spin text-gartify-blue" />
        </div>
      ) : (
        <div className="overflow-x-auto rounded-xl border border-gray-200 shadow-sm">
          <table className="border-collapse text-xs" style={{ tableLayout: "fixed" }}>
            <colgroup>
              <col style={{ width: 52 }} />
              {weekDays.map((_, i) => <col key={i} style={{ width: 140 }} />)}
            </colgroup>
            <thead>
              <tr>
                <th className="bg-gray-50 border-b border-gray-200 py-2 sticky left-0 z-10" />
                {weekDays.map(day => {
                  const isToday  = isSameDay(day, today);
                  const isClosed = isDayClosed(day);
                  return (
                    <th
                      key={toLocalISOString(day)}
                      className={`border-b border-l border-gray-200 py-2 px-1 text-center font-bold ${
                        isClosed
                          ? "bg-gray-100 text-gray-400"
                          : isToday
                            ? "bg-gartify-blue text-white"
                            : "bg-gray-50 text-gray-700"
                      }`}
                      style={{ width: 140 }}
                    >
                      <div className="text-[10px] font-semibold uppercase tracking-wide">
                        {day.toLocaleDateString("es-ES", { weekday: "short" })}
                      </div>
                      <div className={`text-base font-extrabold ${
                        isClosed ? "text-gray-400" : isToday ? "text-white" : "text-gartify-blue"
                      }`}>
                        {day.getDate()}
                      </div>
                      {isClosed && (
                        <div className="text-[9px] font-normal text-gray-400 leading-none">Cerrado</div>
                      )}
                    </th>
                  );
                })}
              </tr>
            </thead>
            <tbody>
              {hours.map((time, rowIdx) => (
                <tr key={time} className={rowIdx % 2 === 0 ? "bg-white" : "bg-gray-50/40"}>
                  {/* Hora */}
                  <td className="px-1 py-0 text-right text-[10px] text-muted-foreground font-medium align-top pt-1 sticky left-0 bg-inherit border-r border-gray-200 z-10">
                    {time}
                  </td>

                  {weekDays.map(day => {
                    const closed  = isDayClosed(day);
                    const outside = !closed && isOutsideHours(day, time);
                    const lunch   = !closed && !outside && isLunchBreak(day, time);
                    const iso     = slotKey(day, time);
                    const isBusy  = toggling === iso;

                    // Día cerrado o fuera de horario → celda inactiva
                    if (closed || outside) {
                      return (
                        <td
                          key={toLocalISOString(day)}
                          className="border-l border-b border-gray-100 p-0"
                          style={{ width: 140 }}
                        >
                          <div className={`min-h-[32px] ${closed ? "bg-gray-100" : "bg-gray-50/60"}`} />
                        </td>
                      );
                    }

                    // Pausa de comida → celda ámbar, sin interacción
                    if (lunch) {
                      return (
                        <td
                          key={toLocalISOString(day)}
                          className="border-l border-b border-gray-100 p-0"
                          style={{ width: 140 }}
                        >
                          <div className="min-h-[32px] bg-amber-50 flex items-center justify-center">
                            <span className="text-[9px] text-amber-400 select-none">Comida</span>
                          </div>
                        </td>
                      );
                    }

                    const booking   = bookingAt(day, time);
                    const isBlocked = blocked.has(iso);

                    // Reserva existente
                    if (booking) {
                      const clientName = booking.user?.name ?? booking.clientName ?? "Cliente";
                      const svcName    = booking.service?.name ?? booking.serviceLabel ?? "";
                      return (
                        <td
                          key={toLocalISOString(day)}
                          className="border-l border-b border-gray-100 p-0.5"
                          style={{ width: 140 }}
                        >
                          <button
                            onClick={() =>
                              setSelectedBooking(prev =>
                                prev?.id === booking.id ? null : booking
                              )
                            }
                            className={[
                              "w-full min-h-[30px] text-left px-1.5 py-1 rounded-sm transition-all",
                              "bg-blue-50 border border-blue-200 hover:bg-blue-100 hover:shadow-sm",
                              booking.status === "CANCELLED" ? "opacity-40" : "",
                              selectedBooking?.id === booking.id ? "ring-2 ring-gartify-blue" : "",
                            ].filter(Boolean).join(" ")}
                          >
                            <div className="font-bold text-gartify-blue leading-tight truncate">
                              {clientName}
                            </div>
                            {svcName && (
                              <div className="text-gartify-blue/60 leading-tight truncate text-[9px]">
                                {svcName}
                              </div>
                            )}
                          </button>
                        </td>
                      );
                    }

                    // Slot bloqueado manualmente
                    if (isBlocked) {
                      return (
                        <td
                          key={toLocalISOString(day)}
                          className="border-l border-b border-gray-100 p-0"
                          style={{ width: 140 }}
                        >
                          <button
                            onClick={() => void toggleBlock(day, time)}
                            disabled={isBusy}
                            title="Clic para desbloquear"
                            className="w-full min-h-[32px] bg-gray-200 hover:bg-gray-300 transition-colors flex items-center justify-center"
                          >
                            {isBusy
                              ? <Loader2 className="h-3 w-3 animate-spin text-gray-500" />
                              : <span className="text-gray-400 text-[10px] select-none">✕</span>
                            }
                          </button>
                        </td>
                      );
                    }

                    // Slot libre
                    return (
                      <td
                        key={toLocalISOString(day)}
                        className="border-l border-b border-gray-100 p-0"
                        style={{ width: 140 }}
                      >
                        <button
                          onClick={() => void toggleBlock(day, time)}
                          disabled={isBusy}
                          title="Clic para bloquear"
                          className="w-full min-h-[32px] hover:bg-gray-100/70 transition-colors"
                        >
                          {isBusy && (
                            <Loader2 className="h-3 w-3 animate-spin text-gray-400 mx-auto" />
                          )}
                        </button>
                      </td>
                    );
                  })}
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}

      {/* ── Detalle de cita ── */}
      {selectedBooking && (
        <div className="bg-white border border-gray-200 rounded-2xl shadow-sm p-5 mt-2">
          <DetalleCita
            booking={selectedBooking}
            onClose={() => setSelectedBooking(null)}
            onUpdated={() => { setSelectedBooking(null); void fetchData(); }}
          />
        </div>
      )}
    </div>
  );
}

// ─── Detalle de una cita ──────────────────────────────────────────────────────

function DetalleCita({
  booking: b, onClose, onUpdated,
}: {
  booking: BookingItem;
  onClose: () => void;
  onUpdated: () => void;
}) {
  const [saving, setSaving] = useState(false);

  const clientName  = b.user?.name ?? b.clientName ?? "—";
  const clientPhone = b.user?.phone ?? b.clientPhone;
  const serviceName = b.service?.name ?? b.serviceLabel ?? "—";

  async function changeStatus(status: string) {
    setSaving(true);
    await fetch(`/api/garage/bookings/${b.id}`, {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ status }),
    });
    setSaving(false);
    onUpdated();
  }

  return (
    <div>
      <div className="flex items-start justify-between mb-4">
        <div>
          <div className="flex items-center gap-2 mb-1">
            <span className={`text-[10px] font-bold px-2 py-0.5 rounded-full border ${STATUS_COLORS[b.status] ?? ""}`}>
              {STATUS_LABELS[b.status] ?? b.status}
            </span>
          </div>
          <h3 className="text-base font-bold text-gartify-blue">{clientName}</h3>
          <p className="text-xs text-muted-foreground">{b.code}</p>
        </div>
        <button onClick={onClose} className="text-gray-400 hover:text-gray-600">
          <X className="h-5 w-5" />
        </button>
      </div>

      <dl className="space-y-2 text-sm mb-4">
        <Row icon={<Calendar className="h-4 w-4 text-gartify-orange" />} label="Fecha">
          {new Date(b.date).toLocaleString("es-ES", {
            weekday: "short", day: "numeric", month: "short",
            hour: "2-digit", minute: "2-digit",
          })}
        </Row>
        <Row icon={<Wrench className="h-4 w-4 text-gartify-blue" />} label="Servicio">
          {serviceName}
        </Row>
        {clientPhone && (
          <Row icon={<Phone className="h-4 w-4 text-gartify-gray" />} label="Teléfono">
            <a href={`tel:${clientPhone}`} className="text-gartify-blue hover:underline">{clientPhone}</a>
          </Row>
        )}
        {(b.vehiclePlate || b.vehicleModel) && (
          <Row icon={<Car className="h-4 w-4 text-gartify-gray" />} label="Vehículo">
            {[b.vehicleModel, b.vehiclePlate].filter(Boolean).join(" · ")}
          </Row>
        )}
        {b.totalPrice > 0 && (
          <Row icon={<Euro className="h-4 w-4 text-gartify-green" />} label="Importe">
            {formatPrice(b.totalPrice)}
          </Row>
        )}
        {b.notes && (
          <Row icon={<StickyNote className="h-4 w-4 text-gartify-gray" />} label="Notas">
            {b.notes}
          </Row>
        )}
      </dl>

      <div className="flex flex-wrap gap-2 pt-3 border-t border-gray-100">
        {b.status !== "COMPLETED" && b.status !== "CANCELLED" && (
          <Button
            size="sm"
            onClick={() => void changeStatus("COMPLETED")}
            disabled={saving}
            className="bg-gartify-green hover:bg-gartify-green/90 text-white text-xs"
          >
            Marcar completada
          </Button>
        )}
        {b.status !== "CANCELLED" && (
          <Button
            size="sm"
            variant="outline"
            onClick={() => void changeStatus("CANCELLED")}
            disabled={saving}
            className="text-red-500 border-red-200 hover:bg-red-50 text-xs"
          >
            Cancelar cita
          </Button>
        )}
      </div>
    </div>
  );
}

// ─── Componente auxiliar ──────────────────────────────────────────────────────

function Row({ icon, label, children }: {
  icon: React.ReactNode;
  label: string;
  children: React.ReactNode;
}) {
  return (
    <div className="flex items-start gap-2">
      <span className="shrink-0 mt-0.5">{icon}</span>
      <span className="text-muted-foreground w-20 shrink-0">{label}</span>
      <span className="text-foreground font-medium">{children}</span>
    </div>
  );
}
