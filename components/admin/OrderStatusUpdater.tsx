"use client";
import { useState } from "react";
import { Loader2 } from "lucide-react";

const STATUSES = [
  { value: "PENDING",   label: "Pendiente",  color: "bg-yellow-100 text-yellow-700 border-yellow-200" },
  { value: "CONFIRMED", label: "Confirmado", color: "bg-blue-100 text-blue-700 border-blue-200" },
  { value: "SHIPPED",   label: "En camino",  color: "bg-purple-100 text-purple-700 border-purple-200" },
  { value: "DELIVERED", label: "Entregado",  color: "bg-green-100 text-green-700 border-green-200" },
  { value: "CANCELLED", label: "Cancelado",  color: "bg-red-100 text-red-700 border-red-200" },
];

export function OrderStatusUpdater({ orderId, initialStatus }: { orderId: string; initialStatus: string }) {
  const [status, setStatus]   = useState(initialStatus);
  const [loading, setLoading] = useState(false);
  const [error, setError]     = useState("");

  const current = STATUSES.find((s) => s.value === status) ?? STATUSES[0];

  async function handleChange(newStatus: string) {
    if (newStatus === status) return;
    setLoading(true);
    setError("");
    const res = await fetch(`/api/admin/orders/${orderId}`, {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ status: newStatus }),
    });
    setLoading(false);
    if (res.ok) {
      setStatus(newStatus);
    } else {
      const data = await res.json() as { error?: string };
      setError(data.error ?? "Error al actualizar");
    }
  }

  return (
    <div className="flex items-center gap-2">
      {loading && <Loader2 className="h-3.5 w-3.5 animate-spin text-gartify-mid shrink-0" />}
      <select
        value={status}
        onChange={(e) => handleChange(e.target.value)}
        disabled={loading}
        className={`text-xs font-semibold border rounded-full px-2.5 py-1 focus:outline-none cursor-pointer transition disabled:opacity-60 ${current.color}`}
      >
        {STATUSES.map((s) => (
          <option key={s.value} value={s.value}>{s.label}</option>
        ))}
      </select>
      {error && <span className="text-xs text-red-500">{error}</span>}
    </div>
  );
}
