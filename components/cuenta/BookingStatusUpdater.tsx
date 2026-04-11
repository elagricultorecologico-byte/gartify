"use client";
import { useState, useEffect } from "react";
import { useRouter } from "next/navigation";
import { Badge } from "@/components/ui/badge";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";
import { BOOKING_STATUS_LABELS, BOOKING_STATUS_COLORS } from "@/lib/utils";
import { ProponerHoraPicker } from "@/components/cuenta/ProponerHoraPicker";

const TRANSITIONS: Record<string, string[]> = {
  PENDING:   ["CONFIRMED", "CANCELLED"],
  PROPOSED:  ["CONFIRMED", "CANCELLED"], // taller puede confirmar si cliente llamó por teléfono
  CONFIRMED: ["COMPLETED", "CANCELLED"],
  COMPLETED: [],
  CANCELLED: [],
};

// Estados desde los que el taller puede proponer nueva hora
const CAN_PROPOSE = ["PENDING", "CONFIRMED"];

export function BookingStatusUpdater({ bookingId, currentStatus, garageId }: { bookingId: string; currentStatus: string; garageId: string }) {
  const router = useRouter();
  const [status, setStatus] = useState(currentStatus);
  const [loading, setLoading] = useState(false);
  const [showPropose, setShowPropose] = useState(false);
  const [proposeError, setProposeError] = useState("");

  useEffect(() => { setStatus(currentStatus); }, [currentStatus]);

  const next = TRANSITIONS[status] ?? [];
  const canPropose = CAN_PROPOSE.includes(status);

  async function handleChange(value: string) {
    if (value === "__PROPOSE__") {
      setShowPropose(true);
      return;
    }
    setLoading(true);
    const res = await fetch(`/api/bookings/${bookingId}`, {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ status: value }),
    });
    setLoading(false);
    if (res.ok) {
      setStatus(value);
      router.refresh();
    }
  }

  async function handlePropose(isoSlot: string) {
    setLoading(true);
    setProposeError("");
    const res = await fetch(`/api/bookings/${bookingId}/proponer`, {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ proposedDate: isoSlot }),
    });
    setLoading(false);
    if (res.ok) {
      setShowPropose(false);
      router.refresh();
    } else {
      const data = await res.json().catch(() => ({}));
      setProposeError(data.error ?? "Error al proponer la hora");
    }
  }

  if (next.length === 0 && !canPropose) {
    return <Badge className={`text-xs ${BOOKING_STATUS_COLORS[status]}`}>{BOOKING_STATUS_LABELS[status]}</Badge>;
  }

  return (
    <div className="flex flex-col items-end gap-1.5">
      <Select value={status} onValueChange={handleChange} disabled={loading}>
        <SelectTrigger className={`h-8 w-40 text-xs font-semibold bg-white border-0 shadow-sm px-3 ${BOOKING_STATUS_COLORS[status]}`}>
          <SelectValue />
        </SelectTrigger>
        <SelectContent>
          <SelectItem value={status}>{BOOKING_STATUS_LABELS[status]}</SelectItem>
          {canPropose && (
            <SelectItem value="__PROPOSE__">🕐 Proponer nueva hora</SelectItem>
          )}
          {next.map((s) => (
            <SelectItem key={s} value={s}>{BOOKING_STATUS_LABELS[s]}</SelectItem>
          ))}
        </SelectContent>
      </Select>

      {showPropose && (
        <ProponerHoraPicker
          garageId={garageId}
          excludeBookingId={bookingId}
          onSelect={handlePropose}
          onCancel={() => { setShowPropose(false); setProposeError(""); }}
          loading={loading}
          error={proposeError}
        />
      )}
    </div>
  );
}
