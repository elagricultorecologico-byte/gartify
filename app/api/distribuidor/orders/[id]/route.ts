import { NextResponse } from "next/server";
import { z } from "zod";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

// ─── Schema de validación ──────────────────────────────────────────────────────

const esquemaActualizarEstado = z.object({
  status: z.enum(["CONFIRMED", "SHIPPED", "DELIVERED", "CANCELLED"], {
    errorMap: () => ({
      message: "Estado inválido. Valores permitidos: CONFIRMED, SHIPPED, DELIVERED, CANCELLED",
    }),
  }),
});

// ─── PATCH /api/distribuidor/orders/[id] ──────────────────────────────────────

export async function PATCH(
  request: Request,
  { params }: { params: { id: string } }
) {
  // Verificar sesión y rol
  const sesion = await auth();
  const usuario = sesion?.user as { id?: string; role?: string } | undefined;

  if (!usuario?.id) {
    return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  }

  if (usuario.role !== "DISTRIBUTOR") {
    return NextResponse.json(
      { error: "Acceso denegado: se requiere rol de distribuidor" },
      { status: 403 }
    );
  }

  // Validar cuerpo de la petición
  const cuerpo = await request.json().catch(() => null);
  const resultado = esquemaActualizarEstado.safeParse(cuerpo);

  if (!resultado.success) {
    return NextResponse.json(
      { error: "Datos inválidos", detalles: resultado.error.flatten() },
      { status: 400 }
    );
  }

  const { status: nuevoEstado } = resultado.data;
  const pedidoId = params.id;

  try {
    // Buscar el distribuidor vinculado al usuario autenticado
    const distribuidor = await db.distributor.findUnique({
      where: { userId: usuario.id },
      select: { id: true },
    });

    if (!distribuidor) {
      return NextResponse.json(
        { error: "No se encontró un distribuidor vinculado a esta cuenta" },
        { status: 404 }
      );
    }

    // Verificar que el pedido pertenece a este distribuidor
    const pedido = await db.partOrder.findUnique({
      where: { id: pedidoId },
      select: { id: true, distributorId: true, status: true },
    });

    if (!pedido) {
      return NextResponse.json({ error: "Pedido no encontrado" }, { status: 404 });
    }

    if (pedido.distributorId !== distribuidor.id) {
      return NextResponse.json(
        { error: "No tienes permiso para modificar este pedido" },
        { status: 403 }
      );
    }

    // Verificar transiciones de estado válidas
    const transicionesPermitidas: Record<string, string[]> = {
      PENDING:   ["CONFIRMED", "CANCELLED"],
      CONFIRMED: ["SHIPPED", "CANCELLED"],
      SHIPPED:   ["DELIVERED"],
      DELIVERED: [],
      CANCELLED: [],
    };

    const siguientesEstados = transicionesPermitidas[pedido.status] ?? [];
    if (!siguientesEstados.includes(nuevoEstado)) {
      return NextResponse.json(
        {
          error: `Transición no permitida: no se puede pasar de ${pedido.status} a ${nuevoEstado}`,
        },
        { status: 422 }
      );
    }

    // Actualizar el estado del pedido y registrar el momento exacto del cambio
    const pedidoActualizado = await db.partOrder.update({
      where: { id: pedidoId },
      data: { status: nuevoEstado, statusUpdatedAt: new Date() },
      select: { id: true, status: true, statusUpdatedAt: true, updatedAt: true },
    });

    return NextResponse.json(pedidoActualizado);
  } catch (error) {
    console.error("[PATCH /api/distribuidor/orders/[id]]", error);
    return NextResponse.json(
      { error: "Error interno del servidor" },
      { status: 500 }
    );
  }
}
