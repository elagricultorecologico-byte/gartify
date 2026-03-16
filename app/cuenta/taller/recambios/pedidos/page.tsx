import type { Metadata } from "next";
import { redirect } from "next/navigation";
import Link from "next/link";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { ArrowLeft, Package, ClipboardList } from "lucide-react";
import { formatPrice } from "@/lib/utils";

export const dynamic = "force-dynamic";

export const metadata: Metadata = {
  title: "Mis pedidos de recambios",
  robots: { index: false, follow: false },
};

const STATUS: Record<string, { label: string; color: string }> = {
  PENDING:   { label: "Pendiente",   color: "bg-yellow-100 text-yellow-700 border-yellow-200" },
  CONFIRMED: { label: "Confirmado",  color: "bg-blue-100 text-blue-700 border-blue-200" },
  SHIPPED:   { label: "En camino",   color: "bg-purple-100 text-purple-700 border-purple-200" },
  DELIVERED: { label: "Entregado",   color: "bg-green-100 text-green-700 border-green-200" },
  CANCELLED: { label: "Cancelado",   color: "bg-red-100 text-red-700 border-red-200" },
};

export default async function PedidosRecambiosPage() {
  const session = await auth();
  const user = session?.user as { id?: string; role?: string } | undefined;
  if (!user?.id) redirect("/login");
  if (user.role !== "GARAGE_OWNER") redirect("/cuenta");

  const garage = await db.garage.findUnique({
    where: { ownerId: user.id },
    select: { id: true },
  });
  if (!garage) redirect("/cuenta/taller/perfil");

  const orders = await db.partOrder.findMany({
    where: { garageId: garage.id },
    include: {
      distributor: { select: { name: true } },
      lines: {
        include: {
          distributorPart: {
            include: { part: { select: { nombre: true, referenciaOem: true } } },
          },
        },
      },
    },
    orderBy: { createdAt: "desc" },
  });

  return (
    <div className="container max-w-4xl py-10">
      <div className="flex items-center gap-3 mb-8">
        <Link href="/cuenta/taller/recambios" className="text-gartify-blue hover:text-gartify-blue/70 transition">
          <ArrowLeft className="h-5 w-5" />
        </Link>
        <div>
          <h1 className="text-2xl font-bold text-gartify-blue flex items-center gap-2">
            <ClipboardList className="h-6 w-6 text-gartify-orange" />
            Mis pedidos de recambios
          </h1>
          <p className="text-muted-foreground text-sm mt-0.5">{orders.length} pedido{orders.length !== 1 ? "s" : ""} realizados</p>
        </div>
      </div>

      {orders.length === 0 ? (
        <div className="text-center py-16 rounded-xl border border-dashed border-gray-200 bg-gray-50">
          <Package className="h-10 w-10 mx-auto mb-3 text-gray-300" />
          <p className="font-semibold text-gray-500">Aún no has realizado pedidos</p>
          <p className="text-sm text-gray-400 mt-1 mb-5">Busca recambios y añádelos al carrito</p>
          <Link
            href="/cuenta/taller/recambios"
            className="inline-flex items-center gap-2 bg-gartify-blue text-white text-sm font-semibold px-4 py-2 rounded-lg hover:bg-gartify-blue/90 transition"
          >
            <Package className="h-4 w-4" />
            Buscar recambios
          </Link>
        </div>
      ) : (
        <div className="space-y-4">
          {orders.map((order) => {
            const s = STATUS[order.status] ?? STATUS["PENDING"];
            return (
              <article key={order.id} className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
                {/* Header */}
                <div className="flex items-center justify-between px-5 py-3 bg-gray-50 border-b border-gray-100">
                  <div>
                    <p className="font-bold text-gartify-blue text-sm">{order.distributor.name}</p>
                    <p className="text-xs text-gray-400">
                      {new Date(order.createdAt).toLocaleDateString("es-ES", {
                        day: "numeric", month: "long", year: "numeric", hour: "2-digit", minute: "2-digit",
                      })}
                    </p>
                  </div>
                  <div className="flex items-center gap-3">
                    <span className={`text-xs font-semibold border rounded-full px-2.5 py-1 ${s.color}`}>
                      {s.label}
                    </span>
                    <span className="font-bold text-gartify-orange">{formatPrice(order.totalAmount)}</span>
                  </div>
                </div>

                {/* Lines */}
                <div className="divide-y divide-gray-50">
                  {order.lines.map((line) => (
                    <div key={line.id} className="flex items-center justify-between px-5 py-2.5 text-sm">
                      <div>
                        <p className="font-medium text-gray-700">{line.distributorPart.part.nombre}</p>
                        <p className="text-xs font-mono text-gray-400">{line.distributorPart.part.referenciaOem}</p>
                      </div>
                      <div className="text-right shrink-0 ml-4">
                        <p className="text-xs text-gray-400">{line.cantidad} × {formatPrice(line.precioUnitario)}</p>
                        <p className="font-bold text-gartify-orange">{formatPrice(line.precioUnitario * line.cantidad)}</p>
                      </div>
                    </div>
                  ))}
                </div>

                {order.notes && (
                  <div className="px-5 py-2.5 border-t border-gray-100 text-xs text-gray-500 italic">
                    Notas: {order.notes}
                  </div>
                )}
              </article>
            );
          })}
        </div>
      )}
    </div>
  );
}
