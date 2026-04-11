"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import { Button } from "@/components/ui/button";
import { Check, X } from "lucide-react";

export function AcceptProposedBooking({ bookingId }: { bookingId: string }) {
  const router = useRouter();
  const [loading, setLoading] = useState(false);

  async function handleAction(status: "CONFIRMED" | "CANCELLED") {
    setLoading(true);
    await fetch(`/api/bookings/${bookingId}`, {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ status }),
    });
    setLoading(false);
    router.refresh();
  }

  return (
    <div className="flex items-center gap-1.5">
      <Button
        size="sm"
        disabled={loading}
        onClick={() => handleAction("CANCELLED")}
        variant="outline"
        className="h-7 text-xs gap-1 text-red-600 border-red-200 hover:bg-red-50 hover:text-red-700"
      >
        <X className="h-3.5 w-3.5" />
        Rechazar
      </Button>
      <Button
        size="sm"
        disabled={loading}
        onClick={() => handleAction("CONFIRMED")}
        className="h-7 text-xs gap-1 bg-gartify-blue hover:bg-gartify-blue/90 text-white"
      >
        <Check className="h-3.5 w-3.5" />
        Aceptar hora
      </Button>
    </div>
  );
}
