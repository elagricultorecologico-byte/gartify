import { notFound, redirect } from "next/navigation";
import type { Metadata } from "next";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Star } from "lucide-react";
import { ReviewForm } from "@/components/booking/ReviewForm";
import { formatDateTime, SERVICE_LABELS } from "@/lib/utils";

export const metadata: Metadata = {
  title: "Dejar valoración",
  robots: { index: false, follow: false },
};

export default async function ResenaPage({ params }: { params: { id: string } }) {
  const session = await auth();
  if (!session?.user?.id) redirect(`/login?callbackUrl=/reserva/${params.id}/resena`);

  const booking = await db.booking.findUnique({
    where: { id: params.id },
    select: {
      id:     true,
      userId: true,
      status: true,
      date:   true,
      review: { select: { id: true } },
      garage:  { select: { name: true, city: true } },
      service: { select: { name: true, type: true } },
    },
  });

  if (!booking) notFound();
  if (booking.userId !== session.user.id) notFound();
  if (booking.status !== "COMPLETED") redirect(`/reserva/${params.id}`);
  if (booking.review) redirect(`/reserva/${params.id}`);

  return (
    <div className="container max-w-lg py-12">
      {/* Header */}
      <div className="text-center mb-8">
        <div className="mx-auto mb-4 flex h-16 w-16 items-center justify-center rounded-full bg-yellow-50 border border-yellow-200">
          <Star className="h-8 w-8 fill-yellow-400 text-yellow-400" />
        </div>
        <h1 className="text-2xl font-bold text-gartify-blue mb-1">Valora tu experiencia</h1>
        <p className="text-sm text-muted-foreground">
          Tu opinión es pública y ayuda a otros conductores a elegir bien.
        </p>
      </div>

      {/* Booking summary */}
      <div className="bg-white rounded-xl border border-gray-200 shadow-sm p-4 mb-6">
        <div className="flex items-start justify-between gap-2">
          <div>
            <p className="font-bold text-gartify-blue">{booking.garage.name}</p>
            <p className="text-xs text-muted-foreground">{booking.garage.city}</p>
          </div>
          <span className="inline-flex items-center rounded-full bg-blue-50 text-gartify-hero text-xs px-2.5 py-0.5 font-medium border border-blue-100 shrink-0">
            {SERVICE_LABELS[booking.service.type] ?? booking.service.type}
          </span>
        </div>
        <p className="text-xs text-muted-foreground mt-2">{formatDateTime(booking.date)}</p>
      </div>

      {/* Form */}
      <div className="bg-white rounded-xl border border-gray-200 shadow-sm p-6">
        <ReviewForm bookingId={booking.id} garageName={booking.garage.name} />
      </div>
    </div>
  );
}
