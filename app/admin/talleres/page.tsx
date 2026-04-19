import type { Metadata } from "next";
import Link from "next/link";
import { db } from "@/lib/db";
import { formatPrice } from "@/lib/utils";
import { ChevronRight, Star, Building2 } from "lucide-react";

export const dynamic = "force-dynamic";
export const metadata: Metadata = { title: "Admin — Talleres" };

export default async function AdminTalleresPage() {
  const garages = await db.garage.findMany({
    orderBy: { name: "asc" },
    select: {
      id: true, name: true, city: true, isActive: true,
      isVerified: true, rating: true, reviewCount: true,
      _count: { select: { bookings: true } },
      bookings: {
        where: { status: "COMPLETED" },
        select: { totalPrice: true },
      },
    },
  });

  const rows = garages.map((g) => ({
    ...g,
    revenue: g.bookings.reduce((s, b) => s + b.totalPrice, 0),
  }));

  return (
    <div className="container max-w-5xl py-10">
      <div className="bg-white border border-gray-200 overflow-hidden mb-6">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
          <div className="flex items-center gap-3">
            <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <Building2 className="h-5 w-5 text-gartify-blue" />
            </div>
            <div>
              <h1 className="text-base font-bold text-gartify-blue">Talleres</h1>
              <p className="text-xs text-gartify-gray mt-0.5">{rows.length} talleres registrados</p>
            </div>
          </div>
        </div>
      </div>

      <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
        <table className="w-full text-sm">
          <thead className="bg-gray-50 border-b border-gray-100 text-xs font-bold uppercase tracking-wide text-gartify-gray">
            <tr>
              <th className="px-5 py-3 text-left">Taller</th>
              <th className="px-5 py-3 text-left hidden md:table-cell">Ciudad</th>
              <th className="px-4 py-3 text-right">Reservas</th>
              <th className="px-4 py-3 text-right">Ingresos</th>
              <th className="px-4 py-3 text-right hidden sm:table-cell">Valoración</th>
              <th className="px-4 py-3 text-center">Estado</th>
              <th className="px-4 py-3" />
            </tr>
          </thead>
          <tbody className="divide-y divide-gray-50">
            {rows.map((g) => (
              <tr key={g.id} className="hover:bg-gray-50/60 transition-colors">
                <td className="px-5 py-3 font-semibold text-gartify-blue">
                  {g.name}
                  {g.isVerified && (
                    <span className="ml-2 text-xs text-gartify-mid font-normal">✓ verificado</span>
                  )}
                </td>
                <td className="px-5 py-3 text-muted-foreground hidden md:table-cell">{g.city}</td>
                <td className="px-4 py-3 text-right">{g._count.bookings}</td>
                <td className="px-4 py-3 text-right font-semibold text-gartify-orange">
                  {formatPrice(g.revenue)}
                </td>
                <td className="px-4 py-3 text-right hidden sm:table-cell">
                  <span className="flex items-center gap-1 justify-end text-yellow-500">
                    <Star className="h-3.5 w-3.5 fill-yellow-400" />
                    {g.rating.toFixed(1)}
                    <span className="text-muted-foreground font-normal text-xs">({g.reviewCount})</span>
                  </span>
                </td>
                <td className="px-4 py-3 text-center">
                  <span className={`inline-flex rounded-full px-2 py-0.5 text-xs font-semibold ${
                    g.isActive
                      ? "bg-green-50 text-green-600 border border-green-100"
                      : "bg-gray-100 text-gray-500 border border-gray-200"
                  }`}>
                    {g.isActive ? "Activo" : "Inactivo"}
                  </span>
                </td>
                <td className="px-4 py-3 text-right">
                  <Link
                    href={`/admin/talleres/${g.id}`}
                    className="inline-flex items-center gap-1 text-xs text-gartify-mid hover:text-gartify-blue transition-colors font-medium"
                  >
                    Ver <ChevronRight className="h-3.5 w-3.5" />
                  </Link>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
