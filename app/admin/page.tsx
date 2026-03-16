import type { Metadata } from "next";
import Link from "next/link";
import { db } from "@/lib/db";
import { Building2, Calendar, Euro, TrendingUp, ChevronRight } from "lucide-react";
import { formatPrice, formatDateTime, BOOKING_STATUS_LABELS, BOOKING_STATUS_COLORS, SERVICE_LABELS } from "@/lib/utils";
import { Badge } from "@/components/ui/badge";

export const dynamic = "force-dynamic";
export const metadata: Metadata = { title: "Admin — Dashboard" };

export default async function AdminDashboardPage() {
  const now   = new Date();
  const from  = new Date(now.getFullYear(), now.getMonth(), 1);
  const to    = new Date(now.getFullYear(), now.getMonth() + 1, 1);

  const [
    totalGarages,
    totalBookingsMonth,
    revenueMonth,
    pendingFees,
    recentBookings,
  ] = await Promise.all([
    db.garage.count({ where: { isActive: true } }),
    db.booking.count({ where: { createdAt: { gte: from, lt: to } } }),
    db.booking.aggregate({
      where: { status: "COMPLETED", date: { gte: from, lt: to } },
      _sum: { totalPrice: true },
    }),
    db.adminInvoice.aggregate({
      where: { status: "PENDING" },
      _sum: { feeAmount: true },
    }),
    db.booking.findMany({
      take: 10,
      orderBy: { createdAt: "desc" },
      select: {
        id: true, status: true, date: true, totalPrice: true,
        garage: { select: { name: true } },
        user:   { select: { name: true } },
        service: { select: { type: true, name: true } },
      },
    }),
  ]);

  const stats = [
    { icon: Building2,  label: "Talleres activos",       value: totalGarages,                                    color: "text-gartify-mid",    bg: "bg-blue-50",    border: "border-blue-100" },
    { icon: Calendar,   label: "Reservas este mes",       value: totalBookingsMonth,                              color: "text-yellow-500",     bg: "bg-yellow-50",  border: "border-yellow-100" },
    { icon: Euro,       label: "Facturado este mes",      value: formatPrice(revenueMonth._sum.totalPrice ?? 0),  color: "text-gartify-orange", bg: "bg-orange-50",  border: "border-orange-100" },
    { icon: TrendingUp, label: "Fees pendientes cobrar",  value: formatPrice(pendingFees._sum.feeAmount ?? 0),    color: "text-green-600",      bg: "bg-green-50",   border: "border-green-100" },
  ];

  return (
    <div className="container max-w-5xl py-10">
      <div className="mb-8">
        <h1 className="text-2xl font-bold text-gartify-blue">Dashboard</h1>
        <p className="text-sm text-muted-foreground mt-1">Visión global de la plataforma</p>
      </div>

      <div className="grid grid-cols-2 md:grid-cols-4 gap-4 mb-10">
        {stats.map(({ icon: Icon, label, value, color, bg, border }) => (
          <div key={label} className={`rounded-xl border ${border} ${bg} p-4 flex items-center gap-3`}>
            <div className="h-10 w-10 rounded-full bg-white flex items-center justify-center shadow-sm shrink-0">
              <Icon className={`h-5 w-5 ${color}`} />
            </div>
            <div>
              <p className="text-xs text-muted-foreground">{label}</p>
              <p className="font-bold text-foreground text-lg leading-tight">{value}</p>
            </div>
          </div>
        ))}
      </div>

      <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
        <div className="flex items-center justify-between px-5 py-3 border-b border-gray-100">
          <h2 className="text-sm font-bold text-gartify-blue">Últimas reservas</h2>
          <Link href="/admin/talleres" className="text-xs text-gartify-mid hover:underline flex items-center gap-1">
            Ver talleres <ChevronRight className="h-3 w-3" />
          </Link>
        </div>
        <div className="divide-y divide-gray-50">
          {recentBookings.map((b) => (
            <div key={b.id} className="flex items-center justify-between px-5 py-3 gap-4 text-sm">
              <div className="flex-1 min-w-0">
                <p className="font-semibold text-gartify-blue truncate">{b.garage.name}</p>
                <p className="text-xs text-muted-foreground truncate">
                  {b.user.name} · {SERVICE_LABELS[b.service.type] ?? b.service.name} · {formatDateTime(b.date)}
                </p>
              </div>
              <div className="flex items-center gap-3 shrink-0">
                <Badge className={`text-xs ${BOOKING_STATUS_COLORS[b.status]}`}>
                  {BOOKING_STATUS_LABELS[b.status]}
                </Badge>
                <span className="font-bold text-gartify-orange">{formatPrice(b.totalPrice)}</span>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
