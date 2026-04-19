import { notFound } from "next/navigation";
import type { Metadata } from "next";
import { db } from "@/lib/db";
import { formatPrice, formatDateTime, BOOKING_STATUS_LABELS, BOOKING_STATUS_COLORS, SERVICE_LABELS } from "@/lib/utils";
import { Badge } from "@/components/ui/badge";
import { MapPin, Phone, Star, Euro, Calendar, Building2 } from "lucide-react";

export const dynamic = "force-dynamic";

export async function generateMetadata({ params }: { params: { id: string } }): Promise<Metadata> {
  const g = await db.garage.findUnique({ where: { id: params.id }, select: { name: true } });
  return { title: g ? `Admin — ${g.name}` : "Admin — Taller" };
}

export default async function AdminGarageDetailPage({ params }: { params: { id: string } }) {
  const garage = await db.garage.findUnique({
    where: { id: params.id },
    select: {
      id: true, name: true, city: true, address: true, phone: true,
      email: true, isActive: true, isVerified: true, rating: true, reviewCount: true,
      owner: { select: { name: true, email: true } },
      bookings: {
        orderBy: { date: "desc" },
        select: {
          id: true, status: true, date: true, totalPrice: true,
          vehicleModel: true, vehiclePlate: true,
          clientName: true, serviceLabel: true,
          user:    { select: { name: true } },
          service: { select: { type: true, name: true } },
        },
      },
    },
  });

  if (!garage) notFound();

  // Agrupar revenue por mes para los completados
  const completedBookings = garage.bookings.filter((b) => b.status === "COMPLETED");
  const monthlyMap = new Map<string, number>();
  for (const b of completedBookings) {
    const key = new Date(b.date).toISOString().slice(0, 7); // YYYY-MM
    monthlyMap.set(key, (monthlyMap.get(key) ?? 0) + b.totalPrice);
  }
  const monthly = Array.from(monthlyMap.entries())
    .sort((a, b) => b[0].localeCompare(a[0]))
    .slice(0, 12);

  const totalRevenue = completedBookings.reduce((s, b) => s + b.totalPrice, 0);

  return (
    <div className="container max-w-5xl py-10 space-y-8">
      {/* Header */}
      <div className="bg-white border border-gray-200 overflow-hidden">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
          <div className="flex items-start justify-between gap-4 flex-wrap">
            <div className="flex items-center gap-3">
              <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
                <Building2 className="h-5 w-5 text-gartify-blue" />
              </div>
              <div>
                <h1 className="text-base font-bold text-gartify-blue">{garage.name}</h1>
                <div className="flex flex-wrap items-center gap-3 mt-0.5 text-xs text-gartify-gray">
                  <span className="flex items-center gap-1"><MapPin className="h-3 w-3" />{garage.address}, {garage.city}</span>
                  <span className="flex items-center gap-1"><Phone className="h-3 w-3" />{garage.phone}</span>
                  <span className="flex items-center gap-1 text-yellow-500">
                    <Star className="h-3 w-3 fill-yellow-400" />
                    {garage.rating.toFixed(1)} ({garage.reviewCount} reseñas)
                  </span>
                </div>
                <p className="text-xs text-gartify-gray mt-0.5">
                  Propietario: {garage.owner.name} · {garage.owner.email}
                </p>
              </div>
            </div>
            <div className="flex gap-2 shrink-0">
              <span className={`inline-flex px-3 py-1 text-xs font-semibold ${
                garage.isActive ? "bg-green-50 text-green-600 border border-green-100" : "bg-gray-100 text-gray-500"
              }`}>{garage.isActive ? "Activo" : "Inactivo"}</span>
              {garage.isVerified && (
                <span className="inline-flex px-3 py-1 text-xs font-semibold bg-blue-50 text-gartify-mid border border-blue-100">
                  Verificado
                </span>
              )}
            </div>
          </div>
        </div>
      </div>

      {/* Stats + desglose mensual */}
      <div className="grid md:grid-cols-2 gap-6">
        <div className="bg-white rounded-xl border border-gray-200 shadow-sm p-5">
          <h2 className="text-xs font-bold uppercase tracking-wide text-gartify-gray mb-4">Resumen</h2>
          <dl className="space-y-3 text-sm">
            <div className="flex justify-between">
              <dt className="text-muted-foreground flex items-center gap-1"><Calendar className="h-3.5 w-3.5" /> Total reservas</dt>
              <dd className="font-semibold">{garage.bookings.length}</dd>
            </div>
            <div className="flex justify-between">
              <dt className="text-muted-foreground">Completadas</dt>
              <dd className="font-semibold text-green-600">{completedBookings.length}</dd>
            </div>
            <div className="flex justify-between">
              <dt className="text-muted-foreground">Canceladas</dt>
              <dd className="font-semibold text-red-400">{garage.bookings.filter(b => b.status === "CANCELLED").length}</dd>
            </div>
            <div className="h-px bg-gray-100" />
            <div className="flex justify-between">
              <dt className="text-muted-foreground flex items-center gap-1"><Euro className="h-3.5 w-3.5" /> Revenue total</dt>
              <dd className="font-bold text-gartify-orange text-base">{formatPrice(totalRevenue)}</dd>
            </div>
            <div className="flex justify-between">
              <dt className="text-muted-foreground">Fee estimado (10%)</dt>
              <dd className="font-bold text-green-600">{formatPrice(totalRevenue * 0.1)}</dd>
            </div>
          </dl>
        </div>

        <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
          <div className="px-5 py-3 border-b border-gray-100">
            <h2 className="text-xs font-bold uppercase tracking-wide text-gartify-gray">Revenue mensual (completadas)</h2>
          </div>
          {monthly.length === 0 ? (
            <p className="text-center py-8 text-sm text-muted-foreground">Sin datos</p>
          ) : (
            <table className="w-full text-sm">
              <tbody className="divide-y divide-gray-50">
                {monthly.map(([month, rev]) => (
                  <tr key={month} className="px-5">
                    <td className="px-5 py-2 text-muted-foreground">{month}</td>
                    <td className="px-5 py-2 text-right font-semibold text-gartify-orange">{formatPrice(rev)}</td>
                    <td className="px-5 py-2 text-right text-xs text-green-600">{formatPrice(rev * 0.1)}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          )}
        </div>
      </div>

      {/* Listado de reservas */}
      <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
        <div className="px-5 py-3 border-b border-gray-100">
          <h2 className="text-xs font-bold uppercase tracking-wide text-gartify-gray">
            Todas las reservas ({garage.bookings.length})
          </h2>
        </div>
        <div className="divide-y divide-gray-50">
          {garage.bookings.map((b) => (
            <div key={b.id} className="flex items-center justify-between px-5 py-3 gap-4 text-sm">
              <div className="flex-1 min-w-0">
                <p className="font-semibold text-foreground truncate">{b.user?.name ?? b.clientName ?? "—"}</p>
                <p className="text-xs text-muted-foreground truncate">
                  {b.service ? (SERVICE_LABELS[b.service.type] ?? b.service.name) : (b.serviceLabel ?? "—")}
                  {b.vehicleModel ? ` · ${b.vehicleModel}` : ""}
                  {b.vehiclePlate ? ` (${b.vehiclePlate})` : ""}
                </p>
              </div>
              <span className="text-xs text-muted-foreground shrink-0 hidden sm:block">
                {formatDateTime(b.date)}
              </span>
              <Badge className={`text-xs shrink-0 ${BOOKING_STATUS_COLORS[b.status]}`}>
                {BOOKING_STATUS_LABELS[b.status]}
              </Badge>
              <span className="font-bold text-gartify-orange shrink-0">{formatPrice(b.totalPrice)}</span>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
