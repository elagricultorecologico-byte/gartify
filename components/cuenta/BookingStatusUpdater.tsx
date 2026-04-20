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
  PROPOSED:  ["CONFIRMED", "CANCELLED"],
  CONFIRMED: ["COMPLETED", "CANCELLED"],
  COMPLETED: [],
  CANCELLED: [],
};

const ACTION_LABEL: Record<string, string> = {
  CONFIRMED: "Confirmar",
  COMPLETED: "Completar",
  CANCELLED: "Cancelar",
};

const ACTION_STYLE: Record<string, string> = {
  CONFIRMED: "bg-gartify-blue text-white hover:bg-gartify-blue/90",
  COMPLETED: "bg-green-600 text-white hover:bg-green-700",
  CANCELLED: "border border-red-200 text-red-500 hover:bg-red-50",
};

// PROPONER HORA — desactivado temporalmente (descomentar cuando se reactive)
// const CAN_PROPOSE = ["PENDING", "CONFIRMED"];

export function BookingStatusUpdater({
  bookingId,
  currentStatus,
  variant = "select",
}: {
  bookingId: string;
  currentStatus: string;
  garageId: string;
  variant?: "select" | "badge" | "buttons";
}) {
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

  // Sin transiciones posibles → siempre badge
  if (next.length === 0) {
    return variant === "buttons"
      ? null
      : <Badge className={`text-xs ${BOOKING_STATUS_COLORS[status]}`}>{BOOKING_STATUS_LABELS[status]}</Badge>;
  }

  // Solo badge
  if (variant === "badge") {
    return <Badge className={`text-xs ${BOOKING_STATUS_COLORS[status]}`}>{BOOKING_STATUS_LABELS[status]}</Badge>;
  }

  // Solo botones de acción (fila inferior en móvil)
  if (variant === "buttons") {
    return (
      <div className="flex gap-2">
        {next.map((s) => (
          <button
            key={s}
            onClick={() => void handleChange(s)}
            disabled={loading}
            className={`flex-1 text-xs font-semibold px-3 py-1.5 transition-colors disabled:opacity-50 ${ACTION_STYLE[s] ?? ""}`}
          >
            {ACTION_LABEL[s] ?? BOOKING_STATUS_LABELS[s]}
          </button>
        ))}
      </div>
    );
  }

  // Select (desktop)
  return (
    <Select value={status} onValueChange={handleChange} disabled={loading}>
      <SelectTrigger className="h-7 w-36 text-xs font-medium bg-white border border-gartify-blue/30 shadow-none px-2.5 text-gartify-blue/70 hover:border-gartify-blue/50 transition-colors">
        <SelectValue />
      </SelectTrigger>
      <SelectContent className="text-xs font-medium text-gartify-blue">
        <SelectItem value={status} className="text-xs text-gartify-blue/70">{BOOKING_STATUS_LABELS[status]}</SelectItem>
        {next.map((s) => (
          <SelectItem key={s} value={s} className="text-xs text-gartify-blue">{BOOKING_STATUS_LABELS[s]}</SelectItem>
        ))}
      </SelectContent>
    </Select>
  );
}
