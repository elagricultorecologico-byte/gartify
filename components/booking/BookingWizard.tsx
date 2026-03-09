"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Textarea } from "@/components/ui/textarea";
import { Card, CardContent } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";
import { Clock, CheckCircle, ChevronRight } from "lucide-react";
import { formatPrice, SERVICE_LABELS } from "@/lib/utils";

type Service = {
  id: string;
  type: string;
  name: string;
  description: string | null;
  price: number;
  duration: number;
};

type Props = {
  garageId: string;
  garageName: string;
  services: Service[];
  preselectedServiceId?: string;
};

function generateSlots(date: string): string[] {
  if (!date) return [];
  const slots: string[] = [];
  for (let h = 8; h <= 17; h++) {
    slots.push(`${date}T${String(h).padStart(2, "0")}:00`);
    slots.push(`${date}T${String(h).padStart(2, "0")}:30`);
  }
  return slots;
}

function formatSlot(iso: string) {
  return new Date(iso).toLocaleTimeString("es-ES", { hour: "2-digit", minute: "2-digit" });
}

export function BookingWizard({ garageId, garageName, services, preselectedServiceId }: Props) {
  const router = useRouter();
  const [step, setStep] = useState(preselectedServiceId ? 2 : 1);
  const [selectedService, setSelectedService] = useState<Service | null>(
    services.find((s) => s.id === preselectedServiceId) ?? null
  );
  const [selectedDate, setSelectedDate] = useState("");
  const [selectedSlot, setSelectedSlot] = useState("");
  const [vehiclePlate, setVehiclePlate] = useState("");
  const [vehicleModel, setVehicleModel] = useState("");
  const [notes, setNotes] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  const today = new Date().toISOString().split("T")[0];
  const slots = generateSlots(selectedDate);

  async function handleConfirm() {
    if (!selectedService || !selectedSlot) return;
    setLoading(true);
    setError("");

    const res = await fetch("/api/bookings", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        garageId,
        serviceId:    selectedService.id,
        date:         selectedSlot,
        vehiclePlate: vehiclePlate || undefined,
        vehicleModel: vehicleModel || undefined,
        notes:        notes || undefined,
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

  const STEPS = ["Servicio", "Fecha y hora", "Confirmación"];

  return (
    <div className="max-w-xl mx-auto">
      {/* Progress */}
      <div className="flex items-center gap-2 mb-8">
        {STEPS.map((label, i) => (
          <div key={label} className="flex items-center gap-2">
            <div className={`flex h-7 w-7 items-center justify-center rounded-full text-xs font-bold transition-colors ${
              i + 1 < step ? "bg-gartify-orange text-white" :
              i + 1 === step ? "bg-gartify-orange/20 border-2 border-gartify-orange text-gartify-orange" :
              "bg-muted text-muted-foreground"
            }`}>
              {i + 1 < step ? <CheckCircle className="h-4 w-4" /> : i + 1}
            </div>
            <span className={`text-sm ${i + 1 === step ? "font-medium text-foreground" : "text-muted-foreground"}`}>{label}</span>
            {i < STEPS.length - 1 && <ChevronRight className="h-4 w-4 text-muted-foreground mx-1" />}
          </div>
        ))}
      </div>

      {/* Step 1 — Service */}
      {step === 1 && (
        <div className="space-y-3">
          <h2 className="text-lg font-semibold text-foreground mb-4">Elige un servicio</h2>
          {services.map((s) => (
            <Card
              key={s.id}
              className={`cursor-pointer transition-colors ${selectedService?.id === s.id ? "border-gartify-orange bg-gartify-orange/5" : "hover:border-gartify-orange/40"}`}
              onClick={() => setSelectedService(s)}
            >
              <CardContent className="p-4 flex items-center justify-between">
                <div>
                  <div className="flex items-center gap-2 mb-0.5">
                    <Badge variant="outline" className="text-xs">{SERVICE_LABELS[s.type]}</Badge>
                  </div>
                  <p className="font-medium text-foreground">{s.name}</p>
                  {s.description && <p className="text-sm text-muted-foreground">{s.description}</p>}
                  <div className="flex items-center gap-1 text-xs text-muted-foreground mt-1">
                    <Clock className="h-3.5 w-3.5" /> {s.duration} min
                  </div>
                </div>
                <p className="text-xl font-bold text-gartify-orange shrink-0">{formatPrice(s.price)}</p>
              </CardContent>
            </Card>
          ))}
          <Button className="w-full mt-2" disabled={!selectedService} onClick={() => setStep(2)}>
            Continuar
          </Button>
        </div>
      )}

      {/* Step 2 — Date/Time */}
      {step === 2 && (
        <div className="space-y-4">
          <h2 className="text-lg font-semibold text-foreground mb-4">Elige fecha y hora</h2>
          <div className="space-y-1.5">
            <Label>Fecha</Label>
            <Input type="date" min={today} value={selectedDate} onChange={(e) => { setSelectedDate(e.target.value); setSelectedSlot(""); }} />
          </div>
          {selectedDate && (
            <div className="space-y-1.5">
              <Label>Hora disponible</Label>
              <div className="grid grid-cols-4 gap-2">
                {slots.map((slot) => (
                  <button
                    key={slot}
                    onClick={() => setSelectedSlot(slot)}
                    className={`rounded-md border py-2 text-sm font-medium transition-colors ${
                      selectedSlot === slot
                        ? "border-gartify-orange bg-gartify-orange/10 text-gartify-orange"
                        : "border-border hover:border-gartify-orange/40 text-foreground"
                    }`}
                  >
                    {formatSlot(slot)}
                  </button>
                ))}
              </div>
            </div>
          )}
          <div className="flex gap-3 pt-2">
            <Button variant="outline" onClick={() => setStep(1)}>Atrás</Button>
            <Button className="flex-1" disabled={!selectedSlot} onClick={() => setStep(3)}>
              Continuar
            </Button>
          </div>
        </div>
      )}

      {/* Step 3 — Confirm */}
      {step === 3 && selectedService && (
        <div className="space-y-4">
          <h2 className="text-lg font-semibold text-foreground mb-4">Confirmar reserva</h2>
          <Card>
            <CardContent className="p-4 space-y-2 text-sm">
              <div className="flex justify-between"><span className="text-muted-foreground">Taller</span><span className="font-medium">{garageName}</span></div>
              <div className="flex justify-between"><span className="text-muted-foreground">Servicio</span><span className="font-medium">{selectedService.name}</span></div>
              <div className="flex justify-between"><span className="text-muted-foreground">Fecha y hora</span><span className="font-medium">{new Date(selectedSlot).toLocaleString("es-ES", { day: "2-digit", month: "short", hour: "2-digit", minute: "2-digit" })}</span></div>
              <div className="flex justify-between"><span className="text-muted-foreground">Duración</span><span className="font-medium">{selectedService.duration} min</span></div>
              <div className="flex justify-between text-base font-bold pt-1 border-t border-border"><span>Total</span><span className="text-gartify-orange">{formatPrice(selectedService.price)}</span></div>
            </CardContent>
          </Card>
          <div className="grid grid-cols-2 gap-3">
            <div className="space-y-1.5">
              <Label>Matrícula</Label>
              <Input placeholder="1234 ABC" value={vehiclePlate} onChange={(e) => setVehiclePlate(e.target.value)} />
            </div>
            <div className="space-y-1.5">
              <Label>Vehículo</Label>
              <Input placeholder="Seat Ibiza 2019" value={vehicleModel} onChange={(e) => setVehicleModel(e.target.value)} />
            </div>
          </div>
          <div className="space-y-1.5">
            <Label>Notas (opcional)</Label>
            <Textarea placeholder="Indícanos cualquier detalle relevante..." value={notes} onChange={(e) => setNotes(e.target.value)} rows={3} />
          </div>
          {error && <p className="text-sm text-red-400">{error}</p>}
          <p className="text-xs text-muted-foreground">El pago se realiza directamente al taller al recoger el vehículo.</p>
          <div className="flex gap-3">
            <Button variant="outline" onClick={() => setStep(2)}>Atrás</Button>
            <Button className="flex-1" onClick={handleConfirm} disabled={loading}>
              {loading ? "Confirmando..." : "Confirmar reserva"}
            </Button>
          </div>
        </div>
      )}
    </div>
  );
}
