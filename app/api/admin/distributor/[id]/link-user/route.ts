import { NextResponse } from "next/server";
import { z } from "zod";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

// ─── Schema de validación ──────────────────────────────────────────────────────

const esquemaVincular = z.object({
  userId: z.string().cuid({ message: "ID de usuario inválido" }),
});

// ─── PATCH /api/admin/distributor/[id]/link-user — Vincular usuario ────────────

export async function PATCH(
  request: Request,
  { params }: { params: { id: string } }
) {
  const sesion = await auth();
  const usuario = sesion?.user as { role?: string } | undefined;
  if (usuario?.role !== "ADMIN") {
    return NextResponse.json({ error: "Acceso denegado" }, { status: 403 });
  }

  const cuerpo = await request.json().catch(() => null);
  const resultado = esquemaVincular.safeParse(cuerpo);
  if (!resultado.success) {
    return NextResponse.json(
      { error: "Datos inválidos", detalles: resultado.error.flatten() },
      { status: 400 }
    );
  }

  const { userId } = resultado.data;
  const distributorId = params.id;

  try {
    // Verificar que el distribuidor existe
    const distribuidor = await db.distributor.findUnique({
      where: { id: distributorId },
      select: { id: true, userId: true },
    });
    if (!distribuidor) {
      return NextResponse.json({ error: "Distribuidor no encontrado" }, { status: 404 });
    }
    if (distribuidor.userId !== null) {
      return NextResponse.json(
        { error: "Este distribuidor ya tiene un usuario vinculado" },
        { status: 409 }
      );
    }

    // Verificar que el usuario existe y tiene rol DISTRIBUTOR
    const usuarioVincular = await db.user.findUnique({
      where: { id: userId },
      select: { id: true, role: true },
    });
    if (!usuarioVincular) {
      return NextResponse.json({ error: "Usuario no encontrado" }, { status: 404 });
    }
    if (usuarioVincular.role !== "DISTRIBUTOR") {
      return NextResponse.json(
        { error: "El usuario no tiene rol de distribuidor" },
        { status: 422 }
      );
    }

    // Verificar que el usuario no está ya vinculado a otro distribuidor
    const yaVinculado = await db.distributor.findUnique({
      where: { userId },
      select: { id: true },
    });
    if (yaVinculado) {
      return NextResponse.json(
        { error: "Este usuario ya está vinculado a otro distribuidor" },
        { status: 409 }
      );
    }

    // Vincular
    const actualizado = await db.distributor.update({
      where: { id: distributorId },
      data: { userId },
      select: { id: true, name: true, userId: true },
    });

    return NextResponse.json(actualizado);
  } catch (error) {
    console.error("[PATCH /api/admin/distributor/[id]/link-user]", error);
    return NextResponse.json({ error: "Error interno del servidor" }, { status: 500 });
  }
}

// ─── DELETE /api/admin/distributor/[id]/link-user — Desvincular usuario ────────

export async function DELETE(
  _request: Request,
  { params }: { params: { id: string } }
) {
  const sesion = await auth();
  const usuario = sesion?.user as { role?: string } | undefined;
  if (usuario?.role !== "ADMIN") {
    return NextResponse.json({ error: "Acceso denegado" }, { status: 403 });
  }

  const distributorId = params.id;

  try {
    const distribuidor = await db.distributor.findUnique({
      where: { id: distributorId },
      select: { id: true, userId: true },
    });
    if (!distribuidor) {
      return NextResponse.json({ error: "Distribuidor no encontrado" }, { status: 404 });
    }
    if (distribuidor.userId === null) {
      return NextResponse.json(
        { error: "Este distribuidor no tiene usuario vinculado" },
        { status: 409 }
      );
    }

    const actualizado = await db.distributor.update({
      where: { id: distributorId },
      data: { userId: null },
      select: { id: true, name: true, userId: true },
    });

    return NextResponse.json(actualizado);
  } catch (error) {
    console.error("[DELETE /api/admin/distributor/[id]/link-user]", error);
    return NextResponse.json({ error: "Error interno del servidor" }, { status: 500 });
  }
}
