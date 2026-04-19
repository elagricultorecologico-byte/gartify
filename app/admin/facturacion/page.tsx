import type { Metadata } from "next";
import { db } from "@/lib/db";
import { Euro } from "lucide-react";
import { InvoiceManager } from "@/components/admin/InvoiceManager";

export const dynamic = "force-dynamic";
export const metadata: Metadata = { title: "Admin — Facturación" };

export default async function AdminFacturacionPage() {
  const invoices = await db.adminInvoice.findMany({
    orderBy: [{ month: "desc" }, { garage: { name: "asc" } }],
    select: {
      id: true, month: true, revenue: true, feeRate: true,
      feeAmount: true, status: true, paidAt: true,
      garage: { select: { id: true, name: true, city: true } },
    },
  });

  return (
    <div className="container max-w-5xl py-10">
      <div className="bg-white border border-gray-200 overflow-hidden mb-6">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
          <div className="flex items-center gap-3">
            <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <Euro className="h-5 w-5 text-gartify-blue" />
            </div>
            <div>
              <h1 className="text-base font-bold text-gartify-blue">Facturación</h1>
              <p className="text-xs text-gartify-gray mt-0.5">Control de fees mensuales por taller</p>
            </div>
          </div>
        </div>
      </div>
      <InvoiceManager invoices={invoices} />
    </div>
  );
}
