import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

// ─── DELETE /api/garage/offers/[id] ──────────────────────────────────────────
// Elimina una oferta. Solo el propietario del taller puede borrar sus propias ofertas.
export async function DELETE(
  _request: Request,
  { params }: { params: { id: string } }
) {
  const sesion = await auth();
  if (!sesion?.user?.id) {
    return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  }

  const usuario = sesion.user as { id: string; role?: string };
  if (usuario.role !== "GARAGE_OWNER") {
    return NextResponse.json({ error: "No autorizado" }, { status: 403 });
  }

  // Verificar que la oferta existe y pertenece al taller del usuario
  const oferta = await db.garageOffer.findUnique({
    where: { id: params.id },
    select: {
      id:     true,
      garage: { select: { ownerId: true } },
    },
  });

  if (!oferta) {
    return NextResponse.json({ error: "Oferta no encontrada" }, { status: 404 });
  }

  if (oferta.garage.ownerId !== usuario.id) {
    return NextResponse.json({ error: "No tienes permiso para eliminar esta oferta" }, { status: 403 });
  }

  await db.garageOffer.delete({ where: { id: params.id } });

  return NextResponse.json({ ok: true });
}
