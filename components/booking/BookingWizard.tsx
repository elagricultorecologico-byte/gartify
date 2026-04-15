"use client";
import { useState, useCallback } from "react";
import { useRouter } from "next/navigation";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Textarea } from "@/components/ui/textarea";
import {
  Clock, CheckCircle, AlertCircle, Loader2,
  CalendarDays, Car, Banknote, Search, X,
} from "lucide-react";
import {
  formatPrice, SERVICE_LABELS,
  VEHICLE_TYPES, VEHICLE_LABELS, VEHICLE_ICONS, type VehicleType,
} from "@/lib/utils";
import { VehicleModelSelector } from "@/components/booking/VehicleModelSelector";

type Service = {
  id: string;
  type: string;
  name: string;
  description: string | null;
  price: number;
  duration: number;
};

type VehicleItem = {
  id: string;
  alias: string | null;
  plate: string;
  brand: string;
  model: string;
};

type Props = {
  garageId: string;
  garageName: string;
  services: Service[];
  preselectedServiceId?: string;
  userVehicles?: VehicleItem[];
};

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
  return new Date(iso).toLocaleTimeString("es-ES", { hour: "2-digit", minute: "2-digit" });
}

const STEPS = ["Vehículo", "Servicio", "Fecha y hora", "Confirmación"];

export function BookingWizard({ garageId, garageName, services, preselectedServiceId, userVehicles }: Props) {
  const router = useRouter();
  // Step 1: tipo de vehículo, Step 2: servicio, Step 3: fecha/hora, Step 4: confirmación
  const [step, setStep] = useState(1);
  const [selectedVehicleType, setSelectedVehicleType] = useState<VehicleType>("COCHE");
  const [selectedService, setSelectedService] = useState<Service | null>(
    services.find((s) => s.id === preselectedServiceId) ?? null
  );
  const [selectedDate, setSelectedDate] = useState("");
  const [selectedSlot, setSelectedSlot] = useState("");
  const [blockedSlots, setBlockedSlots] = useState<Set<string>>(new Set());
  const [dayOpen,      setDayOpen]      = useState<boolean | null>(null);
  const [openTime,     setOpenTime]     = useState("08:00");
  const [closeTime,    setCloseTime]    = useState("18:00");
  const [loadingSlots, setLoadingSlots] = useState(false);
  const [vehiclePlate, setVehiclePlate] = useState("");
  const [vehicleModel, setVehicleModel] = useState("");
  const [notes, setNotes] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");
  const [plateSearching, setPlateSearching] = useState(false);
  const [plateResult, setPlateResult] = useState<{ marca: string; modelo: string; motor: string } | null>(null);
  const [plateError, setPlateError] = useState("");
  // Estados para el selector de vehículos registrados
  const [selectedVehicleId, setSelectedVehicleId] = useState<string | null>(null);
  const [usingOtherVehicle, setUsingOtherVehicle] = useState(false);
  const [currentMileage, setCurrentMileage] = useState("");

  async function buscarMatricula() {
    const plate = vehiclePlate.trim();
    if (!plate) return;
    setPlateSearching(true);
    setPlateError("");
    setPlateResult(null);
    try {
      const res = await fetch(`/api/vehicle-by-plate?plate=${encodeURIComponent(plate)}`);
      const data = await res.json() as { marca?: string; modelo?: string; motor?: string; error?: string };
      if (!res.ok) {
        setPlateError(data.error ?? "Matrícula no encontrada");
      } else {
        const resultado = { marca: data.marca ?? "", modelo: data.modelo ?? "", motor: data.motor ?? "" };
        setPlateResult(resultado);
        const modeloFinal = `${resultado.marca} ${resultado.modelo} ${resultado.motor}`.replace(/\s+/g, " ").trim();
        setVehicleModel(modeloFinal);
      }
    } catch {
      setPlateError("Error de conexión. Inténtalo de nuevo.");
    } finally {
      setPlateSearching(false);
    }
  }

  function limpiarBusquedaMatricula() {
    setPlateResult(null);
    setPlateError("");
    setVehicleModel("");
  }

  // Rellena los campos de matrícula y modelo con los datos del vehículo registrado seleccionado
  function selectRegisteredVehicle(v: VehicleItem) {
    setSelectedVehicleId(v.id);
    setVehiclePlate(v.plate);
    setVehicleModel(`${v.brand} ${v.model}`);
    setPlateResult(null);
    setPlateError("");
  }

  const today = new Date().toISOString().split("T")[0];
  const slots = generateSlots(selectedDate, openTime, closeTime);
  const amSlots = slots.filter((s) => parseInt(s.split("T")[1].split(":")[0]) < 12);
  const pmSlots = slots.filter((s) => parseInt(s.split("T")[1].split(":")[0]) >= 12);

  const fetchBlockedSlots = useCallback(
    async (date: string) => {
      setLoadingSlots(true);
      try {
        const res  = await fetch(`/api/garage/slots?garageId=${garageId}&date=${date}`);
        const data = await res.json() as {
          open: boolean; openTime: string; closeTime: string; blocked: string[];
        };
        setDayOpen(data.open ?? true);
        setOpenTime(data.openTime ?? "08:00");
        setCloseTime(data.closeTime ?? "18:00");
        setBlockedSlots(new Set(data.blocked ?? []));
      } catch {
        setDayOpen(true);
        setBlockedSlots(new Set());
      } finally {
        setLoadingSlots(false);
      }
    },
    [garageId]
  );

  async function handleConfirm() {
    if (!selectedService || !selectedSlot) return;
    setLoading(true);
    setError("");

    const res = await fetch("/api/bookings", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        garageId,
        serviceId: selectedService.id,
        date: selectedSlot,
        vehicleType: selectedVehicleType,
        vehiclePlate: vehiclePlate || undefined,
        vehicleModel: vehicleModel || undefined,
        vehicleId: selectedVehicleId || undefined,
        currentMileage: currentMileage ? parseInt(currentMileage) : undefined,
        notes: notes || undefined,
      }),
    });

    const data = await res.json();
    setLoading(false);

    if (!res.ok) {
      setError(data.error ?? "Error al crear la reserva");
    } else {
      router.push(`/reserva/${data.bookingId}`);
    }
  }

  return (
    <div className="max-w-xl mx-auto">

      {/* ── Stepper ── */}
      <div className="flex items-start mb-8">
        {STEPS.map((label, i) => (
          <div key={label} className="flex items-start flex-1 last:flex-none">
            <div className="flex flex-col items-center gap-1.5 min-w-0">
              <div
                className={`flex h-9 w-9 items-center justify-center rounded-full text-xs font-bold
                  transition-all duration-300 ring-2 ring-offset-2 ${
                  i + 1 < step
                    ? "bg-gartify-green text-white ring-gartify-green/30"
                    : i + 1 === step
                    ? "bg-gartify-blue text-white ring-gartify-blue/30"
                    : "bg-white text-gartify-gray border-2 border-gray-200 ring-transparent"
                }`}
              >
                {i + 1 < step ? <CheckCircle className="h-4 w-4" /> : i + 1}
              </div>
              <span
                className={`text-xs font-semibold whitespace-nowrap ${
                  i + 1 === step
                    ? "text-gartify-blue"
                    : i + 1 < step
                    ? "text-gartify-green"
                    : "text-gray-400"
                }`}
              >
                {label}
              </span>
            </div>
            {i < STEPS.length - 1 && (
              <div
                className={`flex-1 h-0.5 mx-2 mt-4 rounded-full transition-all duration-500 ${
                  i + 1 < step ? "bg-gartify-green" : "bg-gray-200"
                }`}
              />
            )}
          </div>
        ))}
      </div>

      {/* ── Sticky service summary (steps 3 & 4) ── */}
      {selectedService && step > 2 && (
        <div className="sticky top-16 z-10 -mx-1 px-1 mb-5">
          <div className="flex items-center justify-between gap-3 bg-white/90 backdrop-blur-sm border border-gray-200 shadow-sm rounded-xl px-4 py-2.5">
            <div className="flex items-center gap-2 min-w-0">
              <div className="h-2 w-2 rounded-full bg-gartify-orange shrink-0" />
              <span className="text-sm font-semibold text-gartify-blue truncate">
                {selectedService.name}
              </span>
              <span className="text-xs text-gartify-gray hidden sm:inline">
                · {selectedService.duration} min
              </span>
            </div>
            <span className="text-base font-bold text-gartify-orange shrink-0">
              {formatPrice(selectedService.price)}
            </span>
          </div>
        </div>
      )}

      {/* ── Step 1 — Tipo de vehículo ── */}
      {step === 1 && (
        <div className="space-y-4">
          <h2 className="text-lg font-bold text-gartify-blue mb-4">¿Qué tipo de vehículo traes?</h2>
          <div className="grid grid-cols-2 sm:grid-cols-3 gap-3">
            {VEHICLE_TYPES.map((tipo) => {
              const seleccionado = selectedVehicleType === tipo;
              return (
                <button
                  key={tipo}
                  type="button"
                  onClick={() => setSelectedVehicleType(tipo)}
                  aria-pressed={seleccionado}
                  className={`relative flex flex-col items-center gap-2 p-4 rounded-xl border-2 cursor-pointer transition-all duration-200 ${
                    seleccionado
                      ? "border-gartify-orange bg-gartify-orange/5 shadow-md scale-[1.02]"
                      : "border-gray-200 bg-white hover:border-gartify-orange/40 hover:shadow-sm"
                  }`}
                >
                  {seleccionado && (
                    <CheckCircle className="absolute top-2 right-2 h-4 w-4 text-gartify-orange" aria-hidden="true" />
                  )}
                  <span className="text-3xl" aria-hidden="true">{VEHICLE_ICONS[tipo]}</span>
                  <span className={`text-sm font-semibold ${seleccionado ? "text-gartify-orange" : "text-gartify-blue"}`}>
                    {VEHICLE_LABELS[tipo]}
                  </span>
                </button>
              );
            })}
          </div>
          <Button
            className="w-full mt-2 h-11 font-semibold bg-gartify-green hover:bg-gartify-green/90 text-white"
            onClick={() => setStep(2)}
          >
            Continuar con {VEHICLE_LABELS[selectedVehicleType]}
          </Button>
        </div>
      )}

      {/* ── Step 2 — Service ── */}
      {step === 2 && (
        <div className="space-y-3">
          <h2 className="text-lg font-bold text-gartify-blue mb-4">Elige un servicio</h2>
          {services.map((s) => (
            <div
              key={s.id}
              onClick={() => setSelectedService(s)}
              className={`bg-white rounded-xl border shadow-sm cursor-pointer transition-all overflow-hidden flex ${
                selectedService?.id === s.id
                  ? "border-gartify-orange shadow-md"
                  : "border-gray-200 hover:border-gartify-orange/40 hover:shadow-md"
              }`}
            >
              {/* Accent strip */}
              <div
                className={`w-1.5 shrink-0 transition-colors ${
                  selectedService?.id === s.id
                    ? "bg-gartify-orange"
                    : "bg-gradient-to-b from-gartify-hero to-gartify-mid"
                }`}
              />
              <div className="flex-1 p-4 flex items-center justify-between gap-4">
                <div className="flex-1 min-w-0">
                  <span
                    className={`inline-flex items-center rounded-full text-xs px-2.5 py-0.5 font-medium border mb-1.5 ${
                      selectedService?.id === s.id
                        ? "bg-gartify-orange/10 text-gartify-orange border-gartify-orange/20"
                        : "bg-blue-50 text-gartify-hero border-blue-100"
                    }`}
                  >
                    {SERVICE_LABELS[s.type] ?? s.type}
                  </span>
                  <p className="font-bold text-gartify-blue text-sm">{s.name}</p>
                  {s.description && (
                    <p className="text-xs text-muted-foreground mt-0.5">{s.description}</p>
                  )}
                  <div className="flex items-center gap-1 text-xs text-muted-foreground mt-1.5">
                    <Clock className="h-3.5 w-3.5 text-gartify-mid" /> {s.duration} min
                  </div>
                </div>
                <p className="text-xl font-bold text-gartify-orange shrink-0">
                  {formatPrice(s.price)}
                </p>
              </div>
            </div>
          ))}
          <div className="flex gap-3">
            <Button
              variant="outline"
              className="border-gray-300 text-gartify-gray"
              onClick={() => setStep(1)}
            >
              Atrás
            </Button>
            <Button
              className="flex-1 h-11 font-semibold transition-all duration-200 bg-gartify-green hover:bg-gartify-green/90 text-white disabled:bg-gray-100 disabled:text-gray-400 disabled:border disabled:border-gray-200 disabled:shadow-none"
              disabled={!selectedService}
              onClick={() => setStep(3)}
            >
              {selectedService ? `Continuar con ${selectedService.name}` : "Selecciona un servicio"}
            </Button>
          </div>
        </div>
      )}

      {/* ── Step 3 — Date / Time ── */}
      {step === 3 && (
        <div className="space-y-5">
          <h2 className="text-lg font-bold text-gartify-blue mb-4">Elige fecha y hora</h2>

          <div className="bg-white rounded-xl border border-gray-200 shadow-sm p-4 space-y-4">
            {/* Date input */}
            <div className="space-y-1.5">
              <Label className="text-sm font-semibold text-gartify-blue">Fecha</Label>
              <Input
                type="date"
                min={today}
                value={selectedDate}
                onChange={(e) => {
                  const d = e.target.value;
                  setSelectedDate(d);
                  setSelectedSlot("");
                  setBlockedSlots(new Set());
                  setDayOpen(null);
                  if (d) fetchBlockedSlots(d);
                }}
              />
            </div>

            {/* Empty state */}
            {!selectedDate && (
              <div className="flex flex-col items-center gap-3 py-8 px-4 border-2 border-dashed border-gray-200 rounded-xl text-center">
                <div className="flex h-12 w-12 items-center justify-center rounded-full bg-gartify-blue/5">
                  <CalendarDays className="h-6 w-6 text-gartify-mid" />
                </div>
                <div>
                  <p className="text-sm font-semibold text-gartify-blue">Selecciona una fecha</p>
                  <p className="text-xs text-gartify-gray mt-0.5">
                    Verás los horarios disponibles al instante
                  </p>
                </div>
              </div>
            )}

            {/* Día cerrado */}
            {selectedDate && dayOpen === false && !loadingSlots && (
              <div className="flex flex-col items-center gap-3 py-8 px-4 border-2 border-dashed border-red-100 rounded-xl text-center bg-red-50">
                <Clock className="h-8 w-8 text-red-300" />
                <div>
                  <p className="text-sm font-semibold text-red-700">Cerrado este día</p>
                  <p className="text-xs text-red-500 mt-0.5">El taller no atiende en la fecha seleccionada. Elige otro día.</p>
                </div>
              </div>
            )}

            {/* Slots grouped by AM/PM */}
            {selectedDate && dayOpen !== false && (
              <div className="space-y-2">
                <div className="flex items-center gap-2">
                  <Label className="text-sm font-semibold text-gartify-blue">Hora disponible</Label>
                  {loadingSlots && <Loader2 className="h-3.5 w-3.5 animate-spin text-gartify-mid" />}
                </div>

                <div className="space-y-4">
                  {[
                    { label: "Mañana", range: `${openTime} – 11:30`,  group: amSlots },
                    { label: "Tarde",  range: `12:00 – ${closeTime}`, group: pmSlots },
                  ].filter(({ group }) => group.length > 0).map(({ label, range, group }) => (
                    <div key={label}>
                      <div className="flex items-baseline gap-2 mb-2">
                        <span className="text-xs font-bold uppercase tracking-wide text-gartify-gray">
                          {label}
                        </span>
                        <span className="text-xs text-gray-400">{range}</span>
                      </div>
                      <div className="grid grid-cols-4 gap-2">
                        {group.map((slot) => {
                          const isBlocked  = blockedSlots.has(slot);
                          const isSelected = selectedSlot === slot;
                          return (
                            <button
                              key={slot}
                              disabled={isBlocked || loadingSlots}
                              onClick={() => !isBlocked && setSelectedSlot(slot)}
                              className={`rounded-lg border py-2.5 text-sm font-semibold transition-all duration-150 ${
                                isBlocked
                                  ? "border-gray-100 bg-gray-50 text-gray-300 cursor-not-allowed line-through"
                                  : isSelected
                                  ? "border-gartify-blue bg-gartify-blue text-white shadow-sm scale-[1.02]"
                                  : "border-gray-200 text-gartify-gray bg-white hover:border-gartify-blue/40 hover:text-gartify-blue hover:bg-blue-50/40"
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

                <p className="text-xs text-muted-foreground">
                  Las horas <span className="line-through">tachadas</span> ya están reservadas.
                </p>
              </div>
            )}
          </div>

          <div className="flex gap-3">
            <Button
              variant="outline"
              className="border-gray-300 text-gartify-gray"
              onClick={() => setStep(2)}
            >
              Atrás
            </Button>
            <Button
              className="flex-1 bg-gartify-green hover:bg-gartify-green/90 text-white font-semibold h-11"
              disabled={!selectedSlot}
              onClick={() => setStep(4)}
            >
              Continuar
            </Button>
          </div>
        </div>
      )}

      {/* ── Step 4 — Confirm ── */}
      {step === 4 && selectedService && (
        <div className="space-y-4">
          <h2 className="text-lg font-bold text-gartify-blue mb-4">Confirmar reserva</h2>

          {/* Summary card */}
          <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
            <div className="bg-gradient-to-r from-gartify-hero to-gartify-mid px-4 py-2">
              <p className="text-xs font-bold text-white/80 uppercase tracking-wide">Resumen</p>
            </div>
            <div className="p-4 space-y-2.5 text-sm">
              {[
                { label: "Taller",         value: garageName },
                {
                  label: "Vehículo",
                  value: `${VEHICLE_ICONS[selectedVehicleType]} ${VEHICLE_LABELS[selectedVehicleType]}`,
                },
                { label: "Servicio",       value: selectedService.name },
                {
                  label: "Fecha y hora",
                  value: new Date(selectedSlot).toLocaleString("es-ES", {
                    day: "2-digit",
                    month: "short",
                    hour: "2-digit",
                    minute: "2-digit",
                  }),
                },
                { label: "Duración", value: `${selectedService.duration} min` },
              ].map(({ label, value }) => (
                <div key={label} className="flex justify-between gap-4">
                  <span className="text-muted-foreground">{label}</span>
                  <span className="font-medium text-gartify-blue text-right">{value}</span>
                </div>
              ))}
              {/* Total row */}
              <div className="flex justify-between items-center pt-3 mt-1 border-t-2 border-gartify-orange/20 bg-gartify-orange/5 -mx-4 px-4 -mb-4 pb-4 rounded-b-xl">
                <span className="font-bold text-gartify-blue text-base">Total estimado</span>
                <div className="text-right">
                  <span className="text-2xl font-bold text-gartify-orange">
                    {formatPrice(selectedService.price)}
                  </span>
                  <p className="text-xs text-gartify-gray">IVA incluido</p>
                </div>
              </div>
            </div>
          </div>

          {/* Vehicle info */}
          <div className="bg-white rounded-xl border border-gray-200 shadow-sm p-4 space-y-3">
            <div className="flex items-center gap-2 mb-1">
              <Car className="h-4 w-4 text-gartify-mid" />
              <p className="text-sm font-bold text-gartify-blue">Datos del vehículo</p>
              <span className="text-xs text-gartify-gray ml-auto">(opcional)</span>
            </div>

            {/* Selector de vehículos registrados */}
            {userVehicles && userVehicles.length > 0 && !usingOtherVehicle ? (
              <div className="space-y-2">
                {userVehicles.map((v) => (
                  <button
                    key={v.id}
                    type="button"
                    onClick={() => selectRegisteredVehicle(v)}
                    className={`w-full flex items-center gap-3 p-3 rounded-xl border-2 transition-all text-left ${
                      selectedVehicleId === v.id
                        ? "border-gartify-orange bg-gartify-orange/5 shadow-sm"
                        : "border-gray-200 hover:border-gartify-orange/40"
                    }`}
                  >
                    <Car className="h-5 w-5 text-gartify-mid shrink-0" />
                    <div className="flex-1 min-w-0">
                      <p className="text-sm font-semibold text-gartify-blue">
                        {v.alias || `${v.brand} ${v.model}`}
                      </p>
                      <p className="text-xs text-muted-foreground font-mono tracking-wider">{v.plate}</p>
                    </div>
                    {selectedVehicleId === v.id && (
                      <CheckCircle className="h-4 w-4 text-gartify-orange shrink-0" />
                    )}
                  </button>
                ))}
                {!selectedVehicleId && (
                  <p className="text-xs text-amber-600 flex items-center gap-1.5 bg-amber-50 border border-amber-200 rounded-lg px-3 py-2">
                    <AlertCircle className="h-3.5 w-3.5 shrink-0" />
                    Selecciona un vehículo para continuar
                  </p>
                )}
                <button
                  type="button"
                  onClick={() => {
                    setUsingOtherVehicle(true);
                    setSelectedVehicleId(null);
                    setVehiclePlate("");
                    setVehicleModel("");
                    setPlateResult(null);
                    setPlateError("");
                  }}
                  className="text-xs text-gartify-blue hover:underline mt-1 pl-1"
                >
                  + Usar otro vehículo
                </button>
              </div>
            ) : (
              <div className="space-y-3">
                {/* Enlace para volver al selector cuando el usuario tiene vehículos registrados */}
                {userVehicles && userVehicles.length > 0 && usingOtherVehicle && (
                  <button
                    type="button"
                    onClick={() => {
                      setUsingOtherVehicle(false);
                      setVehiclePlate("");
                      setVehicleModel("");
                      setPlateResult(null);
                      setPlateError("");
                    }}
                    className="text-xs text-gartify-blue hover:underline flex items-center gap-1"
                  >
                    ← Volver a mis vehículos
                  </button>
                )}

                {/* Matrícula + botón buscar */}
                <div className="space-y-1.5">
                  <Label className="text-xs font-semibold text-gartify-gray">Matrícula</Label>
                  <div className="flex gap-2 items-center">
                    {/* Placa estilo europeo */}
                    <div className="flex rounded-md border-2 border-gray-300 overflow-hidden shadow-sm flex-1">
                      {/* Franja azul EU */}
                      <div className="flex flex-col items-center justify-center bg-blue-700 px-1.5 py-1 shrink-0 min-w-[32px]">
                        <span className="text-[10px] leading-none">🇪🇸</span>
                        <span className="text-white text-[9px] font-bold leading-none mt-0.5">E</span>
                      </div>
                      {/* Input */}
                      <input
                        type="text"
                        placeholder="1234 ABC"
                        maxLength={10}
                        value={vehiclePlate}
                        onChange={(e) => {
                          setVehiclePlate(e.target.value.toUpperCase());
                          limpiarBusquedaMatricula();
                        }}
                        onKeyDown={(e) => { if (e.key === "Enter") void buscarMatricula(); }}
                        className="flex-1 bg-white px-3 py-2 text-sm font-mono font-bold uppercase tracking-widest text-gray-800 outline-none placeholder:text-gray-300 placeholder:font-normal placeholder:tracking-normal"
                      />
                    </div>
                    <Button
                      type="button"
                      variant="outline"
                      size="sm"
                      className="shrink-0 gap-1.5 border-gartify-blue/30 text-gartify-blue hover:bg-gartify-blue/5"
                      disabled={!vehiclePlate.trim() || plateSearching}
                      onClick={() => void buscarMatricula()}
                    >
                      {plateSearching
                        ? <Loader2 className="h-3.5 w-3.5 animate-spin" />
                        : <Search className="h-3.5 w-3.5" />
                      }
                      Buscar
                    </Button>
                  </div>
                </div>

                {/* Resultado de búsqueda por matrícula */}
                {plateResult && (
                  <div className="flex items-start gap-2 rounded-lg bg-green-50 border border-green-200 px-3 py-2.5">
                    <CheckCircle className="h-4 w-4 text-green-600 mt-0.5 shrink-0" />
                    <div className="flex-1 min-w-0">
                      <p className="text-xs font-bold text-green-800">Vehículo encontrado</p>
                      <p className="text-xs text-green-700 mt-0.5">
                        {plateResult.marca} {plateResult.modelo} · {plateResult.motor}
                      </p>
                    </div>
                    <button
                      type="button"
                      onClick={limpiarBusquedaMatricula}
                      className="shrink-0 text-green-600 hover:text-green-800"
                      aria-label="Limpiar resultado"
                    >
                      <X className="h-3.5 w-3.5" />
                    </button>
                  </div>
                )}

                {plateError && (
                  <p className="text-xs text-red-600 flex items-center gap-1">
                    <AlertCircle className="h-3.5 w-3.5 shrink-0" />
                    {plateError}
                  </p>
                )}

                {/* Selector encadenado solo si no se encontró vehículo por matrícula */}
                {!plateResult && (
                  <div className="space-y-1.5">
                    <Label className="text-xs font-semibold text-gartify-gray">
                      Marca y modelo
                      <span className="font-normal text-gray-400 ml-1">— o selecciona manualmente</span>
                    </Label>
                    <VehicleModelSelector value={vehicleModel} onChange={setVehicleModel} />
                  </div>
                )}
              </div>
            )}

            {/* Kilometraje actual — solo si hay vehículo registrado seleccionado */}
            {selectedVehicleId && !usingOtherVehicle && (
              <div className="space-y-1.5">
                <Label className="text-xs font-semibold text-gartify-gray">
                  Kilometraje actual
                  <span className="font-normal text-gray-400 ml-1">(opcional — actualiza tu ficha)</span>
                </Label>
                <div className="relative">
                  <input
                    type="number"
                    min={0}
                    placeholder="Ej: 125000"
                    value={currentMileage}
                    onChange={(e) => setCurrentMileage(e.target.value)}
                    className="w-full rounded-xl border border-gray-200 px-4 py-2.5 pr-10 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-blue focus:border-transparent transition"
                  />
                  <span className="absolute right-3 top-1/2 -translate-y-1/2 text-xs text-gray-400">km</span>
                </div>
              </div>
            )}

            {/* Notas adicionales — siempre visible */}
            <div className="space-y-1.5">
              <Label className="text-xs font-semibold text-gartify-gray">
                Notas adicionales
                <span className="font-normal text-gray-400 ml-1">(opcional)</span>
              </Label>
              <Textarea
                placeholder="Indícanos cualquier detalle: ruido extraño, avería específica, urgencia..."
                value={notes}
                onChange={(e) => setNotes(e.target.value)}
                rows={3}
                className="resize-none text-sm"
              />
            </div>
          </div>

          {/* Payment notice */}
          <div className="flex items-center gap-2 bg-amber-50 border border-amber-200 rounded-lg px-4 py-2.5">
            <Banknote className="h-4 w-4 text-amber-600 shrink-0" />
            <p className="text-sm font-medium text-amber-800">
              Pago presencial al recoger el vehículo. Sin coste online.
            </p>
          </div>

          {/* Error */}
          {error && (
            <div className="flex items-start gap-2 rounded-lg bg-red-50 border border-red-200 px-3 py-2.5 text-sm text-red-700">
              <AlertCircle className="h-4 w-4 mt-0.5 shrink-0" />
              <span>{error}</span>
            </div>
          )}

          <div className="flex gap-3">
            <Button
              variant="outline"
              className="border-gray-300 text-gartify-gray"
              onClick={() => setStep(3)}
            >
              Atrás
            </Button>
            <Button
              className="flex-1 bg-gartify-green hover:bg-gartify-green/90 text-white font-bold h-12 text-base rounded-xl shadow-md hover:shadow-lg transition-all duration-200 active:scale-[0.98]"
              onClick={handleConfirm}
              disabled={loading || (!!userVehicles?.length && !usingOtherVehicle && !selectedVehicleId)}
            >
              {loading ? (
                <span className="flex items-center gap-2">
                  <Loader2 className="h-4 w-4 animate-spin" />
                  Confirmando reserva...
                </span>
              ) : (
                <span className="flex items-center gap-2">
                  <CheckCircle className="h-4 w-4" />
                  Confirmar reserva
                </span>
              )}
            </Button>
          </div>
        </div>
      )}
    </div>
  );
}
