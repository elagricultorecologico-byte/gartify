import type { Metadata } from "next";
import { db } from "@/lib/db";
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
      <div className="mb-6">
        <h1 className="text-2xl font-bold text-gartify-blue">Facturación</h1>
        <p className="text-sm text-muted-foreground mt-1">
          Control de fees mensuales por taller. El fee se calcula sobre el revenue de reservas completadas.
        </p>
      </div>
      <InvoiceManager invoices={invoices} />
    </div>
  );
}
