import { NextResponse } from "next/server";
import { z } from "zod";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

// Días válidos para las ofertas de horario
const DIAS_SEMANA = ["LUN", "MAR", "MIE", "JUE", "VIE", "SAB", "DOM"] as const;
type DiaSemana = (typeof DIAS_SEMANA)[number];

// Patrón para validar formato HH:MM
const PATRON_HORA = /^([01]\d|2[0-3]):[0-5]\d$/;

const esquemaCrearOferta = z.object({
  label:     z.string().min(3, "La etiqueta debe tener al menos 3 caracteres").max(80, "Máximo 80 caracteres"),
  days:      z.array(z.enum(DIAS_SEMANA)).min(1, "Selecciona al menos un día"),
  startTime: z.string().regex(PATRON_HORA, "Formato de hora inválido (HH:MM)"),
  endTime:   z.string().regex(PATRON_HORA, "Formato de hora inválido (HH:MM)"),
  price:     z.number({ invalid_type_error: "El precio debe ser un número" }).positive("El precio debe ser positivo"),
});

// ─── GET /api/garage/offers ───────────────────────────────────────────────────
// Devuelve las ofertas activas del taller del usuario autenticado
export async function GET() {
  const sesion = await auth();
  if (!sesion?.user?.id) {
    return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  }

  const usuario = sesion.user as { id: string; role?: string };
  if (usuario.role !== "GARAGE_OWNER") {
    return NextResponse.json({ error: "No autorizado" }, { status: 403 });
  }

  const taller = await db.garage.findUnique({
    where: { ownerId: usuario.id },
    select: { id: true },
  });

  if (!taller) {
    return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });
  }

  const ofertas = await db.garageOffer.findMany({
    where:   { garageId: taller.id },
    orderBy: { createdAt: "desc" },
    select: {
      id:        true,
      label:     true,
      days:      true,
      startTime: true,
      endTime:   true,
      price:     true,
      isActive:  true,
      createdAt: true,
    },
  });

  return NextResponse.json(ofertas);
}

// ─── POST /api/garage/offers ──────────────────────────────────────────────────
// Crea una nueva oferta para el taller del usuario autenticado
export async function POST(request: Request) {
  const sesion = await auth();
  if (!sesion?.user?.id) {
    return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  }

  const usuario = sesion.user as { id: string; role?: string };
  if (usuario.role !== "GARAGE_OWNER") {
    return NextResponse.json({ error: "No autorizado" }, { status: 403 });
  }

  const cuerpo = await request.json() as unknown;
  const resultado = esquemaCrearOferta.safeParse(cuerpo);

  if (!resultado.success) {
    return NextResponse.json(
      { error: "Datos inválidos", detalles: resultado.error.flatten() },
      { status: 400 }
    );
  }

  const { label, days, startTime, endTime, price } = resultado.data;

  // Validar que la hora de inicio sea anterior a la de fin
  if (startTime >= endTime) {
    return NextResponse.json(
      { error: "La hora de inicio debe ser anterior a la hora de fin" },
      { status: 400 }
    );
  }

  const taller = await db.garage.findUnique({
    where: { ownerId: usuario.id },
    select: { id: true },
  });

  if (!taller) {
    return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });
  }

  const oferta = await db.garageOffer.create({
    data: {
      garageId:  taller.id,
      label,
      // Almacenamos el array de días como JSON serializado (SQLite no tiene tipo array nativo)
      days:      JSON.stringify(days satisfies DiaSemana[]),
      startTime,
      endTime,
      price,
    },
    select: {
      id:        true,
      label:     true,
      days:      true,
      startTime: true,
      endTime:   true,
      price:     true,
      isActive:  true,
      createdAt: true,
    },
  });

  return NextResponse.json(oferta, { status: 201 });
}
