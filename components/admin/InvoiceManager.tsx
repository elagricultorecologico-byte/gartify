"use client";
import { useState, useTransition } from "react";
import { useRouter } from "next/navigation";
import { formatPrice } from "@/lib/utils";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { CheckCircle, Loader2, RefreshCw } from "lucide-react";

type Invoice = {
  id: string;
  month: string;
  revenue: number;
  feeRate: number;
  feeAmount: number;
  status: string;
  paidAt: Date | string | null;
  garage: { id: string; name: string; city: string };
};

export function InvoiceManager({ invoices }: { invoices: Invoice[] }) {
  const router = useRouter();
  const [isPending, startTransition] = useTransition();
  const [month, setMonth] = useState(() => {
    const now = new Date();
    return `${now.getFullYear()}-${String(now.getMonth() + 1).padStart(2, "0")}`;
  });
  const [generating, setGenerating] = useState(false);
  const [updatingId, setUpdatingId] = useState<string | null>(null);

  async function handleGenerate() {
    setGenerating(true);
    await fetch("/api/admin/invoices", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ month }),
    });
    setGenerating(false);
    startTransition(() => router.refresh());
  }

  async function togglePaid(inv: Invoice) {
    setUpdatingId(inv.id);
    const newStatus = inv.status === "PAID" ? "PENDING" : "PAID";
    await fetch(`/api/admin/invoices/${inv.id}`, {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ status: newStatus }),
    });
    setUpdatingId(null);
    startTransition(() => router.refresh());
  }

  const filtered = invoices.filter((inv) => inv.month === month);
  const totalRevenue  = filtered.reduce((s, i) => s + i.revenue,   0);
  const totalFees     = filtered.reduce((s, i) => s + i.feeAmount, 0);
  const paidFees      = filtered.filter((i) => i.status === "PAID").reduce((s, i) => s + i.feeAmount, 0);
  const pendingFees   = totalFees - paidFees;

  return (
    <div className="space-y-6">
      {/* Controls */}
      <div className="flex flex-col sm:flex-row items-start sm:items-center gap-3">
        <div className="flex items-center gap-2">
          <label className="text-sm font-medium text-gartify-blue">Mes:</label>
          <Input
            type="month"
            value={month}
            onChange={(e) => setMonth(e.target.value)}
            className="w-40 text-sm border-gray-200"
          />
        </div>
        <Button
          onClick={handleGenerate}
          disabled={generating || isPending}
          size="sm"
          className="bg-gartify-blue hover:bg-gartify-blue/90 text-white gap-2"
        >
          {generating ? <Loader2 className="h-4 w-4 animate-spin" /> : <RefreshCw className="h-4 w-4" />}
          Generar / actualizar facturas
        </Button>
      </div>

      {/* Resumen del mes */}
      {filtered.length > 0 && (
        <div className="grid grid-cols-3 gap-4">
          {[
            { label: "Revenue total", value: formatPrice(totalRevenue), color: "text-gartify-orange" },
            { label: "Fees pendientes", value: formatPrice(pendingFees), color: "text-red-500" },
            { label: "Fees cobrados", value: formatPrice(paidFees), color: "text-green-600" },
          ].map(({ label, value, color }) => (
            <div key={label} className="bg-white rounded-xl border border-gray-200 p-4 text-center">
              <p className="text-xs text-muted-foreground">{label}</p>
              <p className={`text-xl font-bold ${color}`}>{value}</p>
            </div>
          ))}
        </div>
      )}

      {/* Tabla de facturas */}
      {filtered.length === 0 ? (
        <div className="text-center py-12 bg-white rounded-xl border border-dashed border-gray-200">
          <p className="text-sm text-muted-foreground">
            No hay facturas para {month}. Pulsa "Generar" para crearlas.
          </p>
        </div>
      ) : (
        <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
          <table className="w-full text-sm">
            <thead className="bg-gray-50 border-b border-gray-100 text-xs font-bold uppercase tracking-wide text-gartify-gray">
              <tr>
                <th className="px-5 py-3 text-left">Taller</th>
                <th className="px-4 py-3 text-left hidden md:table-cell">Ciudad</th>
                <th className="px-4 py-3 text-right">Revenue</th>
                <th className="px-4 py-3 text-right">Fee ({(filtered[0]?.feeRate ?? 0.1) * 100}%)</th>
                <th className="px-4 py-3 text-center">Estado</th>
                <th className="px-4 py-3 text-right">Acción</th>
              </tr>
            </thead>
            <tbody className="divide-y divide-gray-50">
              {filtered.map((inv) => (
                <tr key={inv.id} className="hover:bg-gray-50/60 transition-colors">
                  <td className="px-5 py-3 font-semibold text-gartify-blue">{inv.garage.name}</td>
                  <td className="px-4 py-3 text-muted-foreground hidden md:table-cell">{inv.garage.city}</td>
                  <td className="px-4 py-3 text-right">{formatPrice(inv.revenue)}</td>
                  <td className="px-4 py-3 text-right font-bold text-gartify-orange">
                    {formatPrice(inv.feeAmount)}
                  </td>
                  <td className="px-4 py-3 text-center">
                    <span className={`inline-flex items-center gap-1 rounded-full px-2.5 py-0.5 text-xs font-semibold ${
                      inv.status === "PAID"
                        ? "bg-green-50 text-green-600 border border-green-100"
                        : "bg-yellow-50 text-yellow-600 border border-yellow-100"
                    }`}>
                      {inv.status === "PAID" && <CheckCircle className="h-3 w-3" />}
                      {inv.status === "PAID" ? "Cobrado" : "Pendiente"}
                    </span>
                  </td>
                  <td className="px-4 py-3 text-right">
                    <button
                      onClick={() => togglePaid(inv)}
                      disabled={updatingId === inv.id}
                      className={`text-xs font-semibold transition-colors ${
                        inv.status === "PAID"
                          ? "text-gray-400 hover:text-red-500"
                          : "text-green-600 hover:text-green-700"
                      }`}
                    >
                      {updatingId === inv.id ? (
                        <Loader2 className="h-3.5 w-3.5 animate-spin inline" />
                      ) : inv.status === "PAID" ? (
                        "Marcar pendiente"
                      ) : (
                        "Marcar cobrado"
                      )}
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}
