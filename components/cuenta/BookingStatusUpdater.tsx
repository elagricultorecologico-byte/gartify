"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import { Badge } from "@/components/ui/badge";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";
import { BOOKING_STATUS_LABELS, BOOKING_STATUS_COLORS } from "@/lib/utils";

const TRANSITIONS: Record<string, string[]> = {
  PENDING:     ["CONFIRMED", "CANCELLED"],
  CONFIRMED:   ["IN_PROGRESS", "CANCELLED"],
  IN_PROGRESS: ["COMPLETED"],
  COMPLETED:   [],
  CANCELLED:   [],
};

export function BookingStatusUpdater({ bookingId, currentStatus }: { bookingId: string; currentStatus: string }) {
  const router = useRouter();
  const [status, setStatus] = useState(currentStatus);
  const [loading, setLoading] = useState(false);

  const next = TRANSITIONS[status] ?? [];

  async function handleChange(newStatus: string) {
    setLoading(true);
    const res = await fetch(`/api/bookings/${bookingId}`, {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ status: newStatus }),
    });
    setLoading(false);
    if (res.ok) {
      setStatus(newStatus);
      router.refresh();
    }
  }

  if (next.length === 0) {
    return <Badge className={`text-xs ${BOOKING_STATUS_COLORS[status]}`}>{BOOKING_STATUS_LABELS[status]}</Badge>;
  }

  return (
    <Select value={status} onValueChange={handleChange} disabled={loading}>
      <SelectTrigger className={`h-8 w-36 text-xs ${BOOKING_STATUS_COLORS[status]}`}>
        <SelectValue />
      </SelectTrigger>
      <SelectContent>
        <SelectItem value={status}>{BOOKING_STATUS_LABELS[status]}</SelectItem>
        {next.map((s) => (
          <SelectItem key={s} value={s}>{BOOKING_STATUS_LABELS[s]}</SelectItem>
        ))}
      </SelectContent>
    </Select>
  );
}
