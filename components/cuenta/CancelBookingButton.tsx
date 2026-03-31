"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import { XCircle, Loader2 } from "lucide-react";
import { Button } from "@/components/ui/button";

export function CancelBookingButton({ bookingId }: { bookingId: string }) {
  const router = useRouter();
  const [loading, setLoading] = useState(false);
  const [confirmed, setConfirmed] = useState(false);

  async function handleCancel() {
    if (!confirmed) {
      setConfirmed(true);
      return;
    }
    setLoading(true);
    await fetch(`/api/bookings/${bookingId}`, {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ status: "CANCELLED" }),
    });
    router.refresh();
  }

  if (confirmed) {
    return (
      <div className="flex items-center gap-1">
        <span className="text-xs text-red-600 font-medium">¿Confirmar anulación?</span>
        <Button
          variant="ghost"
          size="sm"
          onClick={handleCancel}
          disabled={loading}
          className="text-red-600 hover:text-red-700 hover:bg-red-50 text-xs font-semibold gap-1 h-7 px-2"
        >
          {loading ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : "Sí, anular"}
        </Button>
        <Button
          variant="ghost"
          size="sm"
          onClick={() => setConfirmed(false)}
          disabled={loading}
          className="text-muted-foreground hover:text-foreground text-xs h-7 px-2"
        >
          No
        </Button>
      </div>
    );
  }

  return (
    <Button
      variant="ghost"
      size="sm"
      onClick={handleCancel}
      className="text-red-500 hover:text-red-600 hover:bg-red-50 gap-1 text-xs font-semibold"
    >
      <XCircle className="h-3.5 w-3.5" aria-hidden="true" />
      Anular
    </Button>
  );
}
