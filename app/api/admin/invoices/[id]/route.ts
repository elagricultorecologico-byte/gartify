import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

// PATCH /api/admin/invoices/[id] — marcar como PAID o actualizar notas
export async function PATCH(req: Request, { params }: { params: { id: string } }) {
  const session = await auth();
  const user = session?.user as { id?: string; role?: string } | undefined;
  if (!user?.id || user.role !== "ADMIN") {
    return NextResponse.json({ error: "Sin permisos" }, { status: 403 });
  }

  const { status, notes } = await req.json() as { status?: string; notes?: string };

  const data: Record<string, unknown> = {};
  if (notes !== undefined) data.notes = notes;
  if (status === "PAID") {
    data.status = "PAID";
    data.paidAt = new Date();
  } else if (status === "PENDING") {
    data.status = "PENDING";
    data.paidAt = null;
  }

  const invoice = await db.adminInvoice.update({
    where: { id: params.id },
    data,
  });

  return NextResponse.json(invoice);
}
