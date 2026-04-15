"use client";

import { useState, useEffect, useCallback } from "react";
import {
  ChevronLeft, ChevronRight, Plus, X, Loader2,
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

const STATUS_LABELS: Record<string, string> = {
  PENDING:   "Pendiente",
  CONFIRMED: "Confirmada",
  COMPLETED: "Completada",
  CANCELLED: "Cancelada",
};

const STATUS_COLORS: Record<string, string> = {
  PENDING:   "bg-amber-100 text-amber-700 border-amber-200",
  CONFIRMED: "bg-blue-100 text-blue-700 border-blue-200",
  COMPLETED: "bg-green-100 text-green-700 border-green-200",
  CANCELLED: "bg-red-100 text-red-500 border-red-200",
};

// ─── Helpers de fecha ─────────────────────────────────────────────────────────

function startOfWeek(date: Date): Date {
  const d = new Date(date);
  const day = d.getDay(); // 0=Dom
  const diff = (day === 0 ? -6 : 1 - day);
  d.setDate(d.getDate() + diff);
  d.setHours(0, 0, 0, 0);
  return d;
}

function addDays(date: Date, n: number): Date {
  const d = new Date(date);
  d.setDate(d.getDate() + n);
  return d;
}

function isSameDay(a: Date, b: Date): boolean {
  return a.getFullYear() === b.getFullYear() &&
    a.getMonth() === b.getMonth() &&
    a.getDate() === b.getDate();
}

function toLocalISOString(date: Date): string {
  const pad = (n: number) => String(n).padStart(2, "0");
  return `${date.getFullYear()}-${pad(date.getMonth() + 1)}-${pad(date.getDate())}`;
}

// ─── Componente principal ─────────────────────────────────────────────────────

export function AgendaTaller({ garageId: _garageId }: { garageId: string }) {
  const [weekStart, setWeekStart] = useState(() => startOfWeek(new Date()));
  const [bookings, setBookings] = useState<BookingItem[]>([]);
  const [loading, setLoading] = useState(true);
  const [selectedBooking, setSelectedBooking] = useState<BookingItem | null>(null);
  const [showForm, setShowForm] = useState(false);
  const [selectedDate, setSelectedDate] = useState<string>("");

  const weekDays = Array.from({ length: 7 }, (_, i) => addDays(weekStart, i));
  const weekFrom = weekStart.toISOString();
  const weekTo   = addDays(weekStart, 6).toISOString();

  const fetchBookings = useCallback(async () => {
    setLoading(true);
    const res = await fetch(`/api/garage/bookings?from=${weekFrom}&to=${weekTo}`);
    if (res.ok) setBookings(await res.json() as BookingItem[]);
    setLoading(false);
  }, [weekFrom, weekTo]);

  useEffect(() => { void fetchBookings(); }, [fetchBookings]);

  const prevWeek = () => setWeekStart(d => addDays(d, -7));
  const nextWeek = () => setWeekStart(d => addDays(d, 7));
  const goToday  = () => setWeekStart(startOfWeek(new Date()));

  function openNewForm(dateStr?: string) {
    setSelectedDate(dateStr ?? toLocalISOString(new Date()));
    setSelectedBooking(null);
    setShowForm(true);
  }

  const today = new Date();

  return (
    <div className="space-y-4">

      {/* ── Controles de navegación ── */}
      <div className="flex items-center justify-between gap-3 flex-wrap">
        <div className="flex items-center gap-2">
          <button onClick={prevWeek} className="p-2 rounded-lg border border-gray-200 hover:bg-gray-50 transition-colors">
            <ChevronLeft className="h-4 w-4" />
          </button>
          <button onClick={goToday} className="px-3 py-1.5 text-sm font-semibold rounded-lg border border-gray-200 hover:bg-gray-50 transition-colors">
            Hoy
          </button>
          <button onClick={nextWeek} className="p-2 rounded-lg border border-gray-200 hover:bg-gray-50 transition-colors">
            <ChevronRight className="h-4 w-4" />
          </button>
          <span className="text-sm font-semibold text-gartify-blue ml-2">
            {weekStart.toLocaleDateString("es-ES", { day: "numeric", month: "long" })}
            {" — "}
            {addDays(weekStart, 6).toLocaleDateString("es-ES", { day: "numeric", month: "long", year: "numeric" })}
          </span>
        </div>
        <Button
          onClick={() => openNewForm()}
          className="bg-gartify-orange hover:bg-orange-600 text-white font-bold gap-2"
        >
          <Plus className="h-4 w-4" />
          Nueva cita
        </Button>
      </div>

      {/* ── Leyenda ── */}
      <div className="flex items-center gap-4 text-xs text-muted-foreground">
        <span className="flex items-center gap-1.5">
          <span className="h-2.5 w-2.5 rounded-full bg-gartify-blue inline-block" />
          Gartify
        </span>
        <span className="flex items-center gap-1.5">
          <span className="h-2.5 w-2.5 rounded-full bg-gartify-orange inline-block" />
          Manual
        </span>
      </div>

      {/* ── Vista semanal ── */}
      {loading ? (
        <div className="flex justify-center py-16">
          <Loader2 className="h-6 w-6 animate-spin text-gartify-blue" />
        </div>
      ) : (
        <div className="grid grid-cols-7 gap-1 overflow-x-auto">
          {weekDays.map((day) => {
            const isToday = isSameDay(day, today);
            const dayBookings = bookings.filter(b => isSameDay(new Date(b.date), day));
            const dateStr = toLocalISOString(day);

            return (
              <div key={dateStr} className="min-w-[120px]">
                {/* Cabecera del día */}
                <div
                  className={`text-center py-2 mb-1 rounded-lg text-xs font-bold ${
                    isToday
                      ? "bg-gartify-blue text-white"
                      : "bg-gray-100 text-gray-600"
                  }`}
                >
                  <div className="uppercase tracking-wide">
                    {day.toLocaleDateString("es-ES", { weekday: "short" })}
                  </div>
                  <div className={`text-lg font-extrabold ${isToday ? "text-white" : "text-gartify-blue"}`}>
                    {day.getDate()}
                  </div>
                </div>

                {/* Citas del día */}
                <div className="space-y-1 min-h-[80px]">
                  {dayBookings.map(b => (
                    <button
                      key={b.id}
                      onClick={() => { setSelectedBooking(b); setShowForm(false); }}
                      className={`w-full text-left rounded-lg px-2 py-1.5 text-xs border transition-all hover:shadow-sm ${
                        b.source === "GARTIFY"
                          ? "bg-blue-50 border-blue-200 hover:bg-blue-100"
                          : "bg-orange-50 border-orange-200 hover:bg-orange-100"
                      } ${b.status === "CANCELLED" ? "opacity-50" : ""}`}
                    >
                      <div className="font-bold text-gray-800 truncate">
                        {new Date(b.date).toLocaleTimeString("es-ES", { hour: "2-digit", minute: "2-digit" })}
                        {" "}
                        {b.source === "GARTIFY" ? (b.user?.name ?? "Cliente") : (b.clientName ?? "Manual")}
                      </div>
                      <div className="text-gray-500 truncate">
                        {b.source === "GARTIFY" ? (b.service?.name ?? "") : (b.serviceLabel ?? "")}
                      </div>
                    </button>
                  ))}

                  {/* Botón añadir */}
                  <button
                    onClick={() => openNewForm(dateStr)}
                    className="w-full text-center text-gray-300 hover:text-gartify-orange hover:bg-orange-50 rounded-lg py-1 text-xs transition-colors border border-dashed border-gray-200 hover:border-orange-200"
                  >
                    <Plus className="h-3 w-3 inline" />
                  </button>
                </div>
              </div>
            );
          })}
        </div>
      )}

      {/* ── Panel lateral: detalle o formulario ── */}
      {(selectedBooking || showForm) && (
        <div className="bg-white border border-gray-200 rounded-2xl shadow-sm p-5 mt-2">
          {showForm ? (
            <NuevaCitaForm
              initialDate={selectedDate}
              onSaved={() => { setShowForm(false); void fetchBookings(); }}
              onCancel={() => setShowForm(false)}
            />
          ) : selectedBooking ? (
            <DetalleCita
              booking={selectedBooking}
              onClose={() => setSelectedBooking(null)}
              onUpdated={() => { setSelectedBooking(null); void fetchBookings(); }}
            />
          ) : null}
        </div>
      )}
    </div>
  );
}

// ─── Detalle de una cita ──────────────────────────────────────────────────────

function DetalleCita({
  booking: b,
  onClose,
  onUpdated,
}: {
  booking: BookingItem;
  onClose: () => void;
  onUpdated: () => void;
}) {
  const [saving, setSaving] = useState(false);

  const clientName  = b.source === "GARTIFY" ? (b.user?.name ?? "—") : (b.clientName ?? "—");
  const clientPhone = b.source === "GARTIFY" ? (b.user?.phone ?? null) : b.clientPhone;
  const serviceName = b.source === "GARTIFY" ? (b.service?.name ?? "—") : (b.serviceLabel ?? "—");

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

  async function deleteBooking() {
    if (!confirm("¿Eliminar esta cita manual?")) return;
    setSaving(true);
    await fetch(`/api/garage/bookings/${b.id}`, { method: "DELETE" });
    setSaving(false);
    onUpdated();
  }

  return (
    <div>
      <div className="flex items-start justify-between mb-4">
        <div>
          <div className="flex items-center gap-2 mb-1">
            <span className={`text-[10px] font-bold px-2 py-0.5 rounded-full border ${
              b.source === "GARTIFY"
                ? "bg-blue-50 text-blue-600 border-blue-200"
                : "bg-orange-50 text-orange-600 border-orange-200"
            }`}>
              {b.source === "GARTIFY" ? "Gartify" : "Manual"}
            </span>
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
          {new Date(b.date).toLocaleString("es-ES", { weekday: "short", day: "numeric", month: "short", hour: "2-digit", minute: "2-digit" })}
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

      {/* Acciones */}
      <div className="flex flex-wrap gap-2 pt-3 border-t border-gray-100">
        {b.status !== "COMPLETED" && b.status !== "CANCELLED" && (
          <Button size="sm" onClick={() => void changeStatus("COMPLETED")} disabled={saving}
            className="bg-gartify-green hover:bg-gartify-green/90 text-white text-xs">
            Marcar completada
          </Button>
        )}
        {b.status !== "CANCELLED" && (
          <Button size="sm" variant="outline" onClick={() => void changeStatus("CANCELLED")} disabled={saving}
            className="text-red-500 border-red-200 hover:bg-red-50 text-xs">
            Cancelar cita
          </Button>
        )}
        {b.source === "MANUAL" && (
          <Button size="sm" variant="ghost" onClick={() => void deleteBooking()} disabled={saving}
            className="text-gray-400 hover:text-red-500 text-xs ml-auto">
            Eliminar
          </Button>
        )}
      </div>
    </div>
  );
}

// ─── Formulario nueva cita manual ─────────────────────────────────────────────

function NuevaCitaForm({
  initialDate,
  onSaved,
  onCancel,
}: {
  initialDate: string;
  onSaved: () => void;
  onCancel: () => void;
}) {
  const [saving, setSaving] = useState(false);
  const [error, setError] = useState("");

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setError("");
    const fd = new FormData(e.currentTarget);

    const dateStr = fd.get("date") as string;
    const timeStr = fd.get("time") as string;
    if (!dateStr || !timeStr) { setError("Fecha y hora obligatorias"); return; }

    const datetime = new Date(`${dateStr}T${timeStr}:00`).toISOString();

    const body = {
      clientName:   (fd.get("clientName") as string).trim(),
      clientPhone:  (fd.get("clientPhone") as string).trim() || undefined,
      serviceLabel: (fd.get("serviceLabel") as string).trim(),
      date:         datetime,
      vehiclePlate: (fd.get("vehiclePlate") as string).trim() || undefined,
      vehicleModel: (fd.get("vehicleModel") as string).trim() || undefined,
      totalPrice:   parseFloat(fd.get("totalPrice") as string) || 0,
      notes:        (fd.get("notes") as string).trim() || undefined,
    };

    if (!body.clientName) { setError("El nombre del cliente es obligatorio"); return; }
    if (!body.serviceLabel) { setError("El servicio es obligatorio"); return; }

    setSaving(true);
    const res = await fetch("/api/garage/bookings", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
    });
    setSaving(false);

    if (res.ok) {
      onSaved();
    } else {
      const d = await res.json() as { error?: string };
      setError(d.error ?? "Error al guardar");
    }
  }

  return (
    <form onSubmit={handleSubmit} className="space-y-4">
      <div className="flex items-center justify-between mb-2">
        <h3 className="text-base font-bold text-gartify-blue">Nueva cita manual</h3>
        <button type="button" onClick={onCancel} className="text-gray-400 hover:text-gray-600">
          <X className="h-5 w-5" />
        </button>
      </div>

      <div className="grid grid-cols-2 gap-3">
        <div>
          <label className="block text-xs font-semibold text-gray-700 mb-1">Fecha <span className="text-red-500">*</span></label>
          <input type="date" name="date" defaultValue={initialDate} required
            className="w-full rounded-xl border border-gray-200 px-3 py-2 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-blue" />
        </div>
        <div>
          <label className="block text-xs font-semibold text-gray-700 mb-1">Hora <span className="text-red-500">*</span></label>
          <input type="time" name="time" defaultValue="09:00" required
            className="w-full rounded-xl border border-gray-200 px-3 py-2 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-blue" />
        </div>
      </div>

      <div className="grid grid-cols-2 gap-3">
        <div>
          <label className="block text-xs font-semibold text-gray-700 mb-1">Cliente <span className="text-red-500">*</span></label>
          <input type="text" name="clientName" placeholder="Nombre del cliente" required
            className="w-full rounded-xl border border-gray-200 px-3 py-2 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-blue" />
        </div>
        <div>
          <label className="block text-xs font-semibold text-gray-700 mb-1">Teléfono</label>
          <input type="tel" name="clientPhone" placeholder="612 345 678"
            className="w-full rounded-xl border border-gray-200 px-3 py-2 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-blue" />
        </div>
      </div>

      <div>
        <label className="block text-xs font-semibold text-gray-700 mb-1">Servicio <span className="text-red-500">*</span></label>
        <input type="text" name="serviceLabel" placeholder="Ej: Cambio de aceite, Revisión frenos..." required
          className="w-full rounded-xl border border-gray-200 px-3 py-2 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-blue" />
      </div>

      <div className="grid grid-cols-3 gap-3">
        <div>
          <label className="block text-xs font-semibold text-gray-700 mb-1">Matrícula</label>
          <input type="text" name="vehiclePlate" placeholder="1234 ABC"
            className="w-full rounded-xl border border-gray-200 px-3 py-2 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-blue uppercase" />
        </div>
        <div>
          <label className="block text-xs font-semibold text-gray-700 mb-1">Vehículo</label>
          <input type="text" name="vehicleModel" placeholder="Seat Ibiza"
            className="w-full rounded-xl border border-gray-200 px-3 py-2 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-blue" />
        </div>
        <div>
          <label className="block text-xs font-semibold text-gray-700 mb-1">Importe (€)</label>
          <input type="number" name="totalPrice" min="0" step="0.01" placeholder="0.00"
            className="w-full rounded-xl border border-gray-200 px-3 py-2 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-blue" />
        </div>
      </div>

      <div>
        <label className="block text-xs font-semibold text-gray-700 mb-1">Notas</label>
        <textarea name="notes" rows={2} placeholder="Observaciones..."
          className="w-full rounded-xl border border-gray-200 px-3 py-2 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-blue resize-none" />
      </div>

      {error && <p className="text-sm text-red-500">{error}</p>}

      <div className="flex gap-2 pt-1">
        <Button type="submit" disabled={saving} className="bg-gartify-orange hover:bg-orange-600 text-white font-bold gap-2">
          {saving ? <><Loader2 className="h-4 w-4 animate-spin" />Guardando...</> : <><Plus className="h-4 w-4" />Añadir cita</>}
        </Button>
        <Button type="button" variant="ghost" onClick={onCancel} className="text-gray-500">
          Cancelar
        </Button>
      </div>
    </form>
  );
}

// ─── Componente auxiliar ──────────────────────────────────────────────────────

function Row({ icon, label, children }: { icon: React.ReactNode; label: string; children: React.ReactNode }) {
  return (
    <div className="flex items-start gap-2">
      <span className="shrink-0 mt-0.5">{icon}</span>
      <span className="text-muted-foreground w-20 shrink-0">{label}</span>
      <span className="text-foreground font-medium">{children}</span>
    </div>
  );
}
