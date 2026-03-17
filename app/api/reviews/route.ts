import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { z } from "zod";

const schema = z.object({
  bookingId: z.string(),
  rating:    z.number().int().min(1).max(5),
  comment:   z.string().max(1000).optional(),
});

export async function POST(req: Request) {
  const session = await auth();
  if (!session?.user?.id) return NextResponse.json({ error: "No autenticado" }, { status: 401 });

  const body = await req.json();
  const parsed = schema.safeParse(body);
  if (!parsed.success) return NextResponse.json({ error: "Datos inválidos" }, { status: 400 });

  const { bookingId, rating, comment } = parsed.data;

  // Validate booking: must belong to the user, be COMPLETED, have no review yet
  const booking = await db.booking.findUnique({
    where: { id: bookingId },
    select: { id: true, userId: true, garageId: true, status: true, review: { select: { id: true } } },
  });

  if (!booking) return NextResponse.json({ error: "Reserva no encontrada" }, { status: 404 });
  if (booking.userId !== session.user.id) return NextResponse.json({ error: "Sin acceso" }, { status: 403 });
  if (booking.status !== "COMPLETED") return NextResponse.json({ error: "Solo se puede valorar una reserva completada" }, { status: 400 });
  if (booking.review) return NextResponse.json({ error: "Ya has valorado esta reserva" }, { status: 409 });

  // Create review + recalculate garage rating in a transaction
  const [review] = await db.$transaction(async (tx) => {
    const newReview = await tx.review.create({
      data: {
        userId:    session.user!.id as string,
        garageId:  booking.garageId,
        bookingId,
        rating,
        comment:   comment || undefined,
      },
    });

    // Recalculate aggregate rating
    const agg = await tx.review.aggregate({
      where: { garageId: booking.garageId },
      _avg:   { rating: true },
      _count: { rating: true },
    });

    await tx.garage.update({
      where: { id: booking.garageId },
      data: {
        rating:      Math.round((agg._avg.rating ?? 0) * 10) / 10,
        reviewCount: agg._count.rating,
      },
    });

    return [newReview];
  });

  return NextResponse.json({ reviewId: review.id });
}
