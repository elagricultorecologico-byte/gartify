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

  let body: unknown;
  try { body = await req.json(); } catch {
    return NextResponse.json({ error: "Petición inválida" }, { status: 400 });
  }

  const parsed = patchSchema.safeParse(body);
  if (!parsed.success) {
    return NextResponse.json({ error: "Datos inválidos", details: parsed.error.flatten() }, { status: 400 });
  }

  const data = parsed.data;
  if (data.phone) data.phone = toE164(data.phone);

  // Verificar unicidad de email si se cambia
  if (data.email) {
    const existing = await db.user.findFirst({ where: { email: data.email, NOT: { id: params.id } } });
    if (existing) return NextResponse.json({ error: "Este email ya está en uso por otro usuario" }, { status: 409 });
  }

  try {
    const user = await db.user.update({ where: { id: params.id }, data });
    if (data.phone !== undefined && user.role === "GARAGE_OWNER") {
      await db.garage.updateMany({ where: { ownerId: params.id }, data: { phone: data.phone ?? "" } });
    }
    return NextResponse.json({ ok: true, user });
  } catch (e) {
    console.error("[admin/users PATCH]", e);
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
