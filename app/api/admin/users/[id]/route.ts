import { NextResponse } from "next/server";
import { z } from "zod";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

function toE164(phone: string): string {
  const digits = phone.replace(/\D/g, "");
  if (digits.startsWith("34") && digits.length === 11) return `+${digits}`;
  if (digits.length === 9) return `+34${digits}`;
  return `+${digits}`;
}

async function requireAdmin() {
  const session = await auth();
  const user = session?.user as { role?: string } | undefined;
  if (user?.role !== "ADMIN") return null;
  return user;
}

const patchSchema = z.object({
  name:  z.string().min(2).optional(),
  email: z.string().email().optional(),
  phone: z.string().nullable().optional(),
  role:  z.enum(["CUSTOMER", "GARAGE_OWNER"]).optional(),
});

export async function PATCH(req: Request, { params }: { params: { id: string } }) {
  if (!await requireAdmin()) return NextResponse.json({ error: "No autorizado" }, { status: 403 });

  try {
    const body = await req.json();
    const data = patchSchema.parse(body);
    if (data.phone) data.phone = toE164(data.phone);
    const user = await db.user.update({ where: { id: params.id }, data });
    // Si se actualiza el teléfono de un GARAGE_OWNER, sincronizarlo en Garage.phone
    if (data.phone !== undefined && user.role === "GARAGE_OWNER") {
      await db.garage.updateMany({ where: { ownerId: params.id }, data: { phone: data.phone ?? "" } });
    }
    return NextResponse.json({ ok: true, user });
  } catch {
    return NextResponse.json({ error: "Error al actualizar el usuario" }, { status: 500 });
  }
}

export async function DELETE(_req: Request, { params }: { params: { id: string } }) {
  if (!await requireAdmin()) return NextResponse.json({ error: "No autorizado" }, { status: 403 });

  try {
    // Borrar en cascada: reservas, reseñas, garage si es propietario
    await db.user.delete({ where: { id: params.id } });
    return NextResponse.json({ ok: true });
  } catch {
    return NextResponse.json({ error: "Error al eliminar el usuario" }, { status: 500 });
  }
}
