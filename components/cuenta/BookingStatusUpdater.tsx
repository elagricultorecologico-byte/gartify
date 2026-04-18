"use client";
import { useState, useEffect } from "react";
import { useRouter } from "next/navigation";
import { Badge } from "@/components/ui/badge";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";
import { BOOKING_STATUS_LABELS, BOOKING_STATUS_COLORS } from "@/lib/utils";
// PROPONER HORA — desactivado temporalmente (descomentar cuando se reactive)
// import { ProponerHoraPicker } from "@/components/cuenta/ProponerHoraPicker";

const TRANSITIONS: Record<string, string[]> = {
  PENDING:   ["CONFIRMED", "CANCELLED"],
  PROPOSED:  ["CONFIRMED", "CANCELLED"], // taller puede confirmar si cliente llamó por teléfono
  CONFIRMED: ["COMPLETED", "CANCELLED"],
  COMPLETED: [],
  CANCELLED: [],
};

// PROPONER HORA — desactivado temporalmente (descomentar cuando se reactive)
// const CAN_PROPOSE = ["PENDING", "CONFIRMED"];

export function BookingStatusUpdater({ bookingId, currentStatus }: { bookingId: string; currentStatus: string; garageId: string }) {
  const router = useRouter();
  const [status, setStatus] = useState(currentStatus);
  const [loading, setLoading] = useState(false);
  // const [showPropose, setShowPropose] = useState(false);
  // const [proposeError, setProposeError] = useState("");

  useEffect(() => { setStatus(currentStatus); }, [currentStatus]);

  const next = TRANSITIONS[status] ?? [];
  // const canPropose = CAN_PROPOSE.includes(status);

  async function handleChange(value: string) {
    // if (value === "__PROPOSE__") { setShowPropose(true); return; }
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

  // PROPONER HORA — desactivado temporalmente (descomentar cuando se reactive)
  // async function handlePropose(isoSlot: string) {
  //   setLoading(true);
  //   setProposeError("");
  //   const res = await fetch(`/api/bookings/${bookingId}/proponer`, {
  //     method: "PATCH",
  //     headers: { "Content-Type": "application/json" },
  //     body: JSON.stringify({ proposedDate: isoSlot }),
  //   });
  //   setLoading(false);
  //   if (res.ok) { setShowPropose(false); router.refresh(); }
  //   else {
  //     const data = await res.json().catch(() => ({}));
  //     setProposeError(data.error ?? "Error al proponer la hora");
  //   }
  // }

  if (next.length === 0) {
    return <Badge className={`text-xs ${BOOKING_STATUS_COLORS[status]}`}>{BOOKING_STATUS_LABELS[status]}</Badge>;
  }

  return (
    <div className="flex flex-col items-end gap-1.5">
      <Select value={status} onValueChange={handleChange} disabled={loading}>
        <SelectTrigger className="h-7 w-36 text-xs font-medium bg-white border border-gray-200 shadow-none px-2.5 text-gray-600 hover:border-gray-300 transition-colors">
          <SelectValue />
        </SelectTrigger>
        <SelectContent className="text-xs font-medium">
          <SelectItem value={status} className="text-xs">{BOOKING_STATUS_LABELS[status]}</SelectItem>
          {next.map((s) => (
            <SelectItem key={s} value={s} className="text-xs">{BOOKING_STATUS_LABELS[s]}</SelectItem>
          ))}
        </SelectContent>
      </Select>

      {/* PROPONER HORA — desactivado temporalmente (descomentar cuando se reactive)
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
      */}
    </div>
  );
}
