import type { Metadata } from "next";
import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Package, ClipboardList, Building2, Store } from "lucide-react";
import { formatPrice } from "@/lib/utils";
import { OrderStatusUpdater } from "@/components/admin/OrderStatusUpdater";

export const dynamic = "force-dynamic";
export const metadata: Metadata = { title: "Pedidos de recambios — Admin" };

const STATUS_META: Record<string, { label: string; color: string }> = {
  PENDING:   { label: "Pendiente",  color: "bg-yellow-100 text-yellow-700 border-yellow-200" },
  CONFIRMED: { label: "Confirmado", color: "bg-blue-100 text-blue-700 border-blue-200" },
  SHIPPED:   { label: "En camino",  color: "bg-purple-100 text-purple-700 border-purple-200" },
  DELIVERED: { label: "Entregado",  color: "bg-green-100 text-green-700 border-green-200" },
  CANCELLED: { label: "Cancelado",  color: "bg-red-100 text-red-700 border-red-200" },
};

export default async function AdminPedidosPage() {
  const session = await auth();
  const user = session?.user as { role?: string } | undefined;
  if (user?.role !== "ADMIN") redirect("/");

  const orders = await db.partOrder.findMany({
    include: {
      garage:      { select: { name: true, city: true } },
      distributor: { select: { name: true, email: true } },
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

  const byStatus = {
    PENDING:   orders.filter((o) => o.status === "PENDING"),
    CONFIRMED: orders.filter((o) => o.status === "CONFIRMED"),
    SHIPPED:   orders.filter((o) => o.status === "SHIPPED"),
    DELIVERED: orders.filter((o) => o.status === "DELIVERED"),
    CANCELLED: orders.filter((o) => o.status === "CANCELLED"),
  };

  return (
    <div className="container max-w-6xl py-10">
      <div className="bg-white border border-gray-200 overflow-hidden mb-8">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
          <div className="flex items-center gap-3">
            <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <ClipboardList className="h-5 w-5 text-gartify-blue" />
            </div>
            <div>
              <h1 className="text-base font-bold text-gartify-blue">Pedidos de recambios</h1>
              <p className="text-xs text-gartify-gray mt-0.5">Gestiona el estado de todos los pedidos realizados por los talleres</p>
            </div>
          </div>
        </div>
      </div>

      {/* Stats rápidas */}
      <div className="grid grid-cols-2 md:grid-cols-5 gap-3 mb-8">
        {Object.entries(byStatus).map(([status, items]) => {
          const meta = STATUS_META[status];
          return (
            <div key={status} className={`rounded-xl border px-4 py-3 ${meta.color.replace("text-", "border-").split(" ")[0].replace("bg-", "border-")}`}>
              <p className={`text-2xl font-bold ${meta.color.split(" ")[1]}`}>{items.length}</p>
              <p className="text-xs text-gray-500 mt-0.5">{meta.label}</p>
            </div>
          );
        })}
      </div>

      {/* Lista de pedidos */}
      {orders.length === 0 ? (
        <div className="text-center py-20 rounded-xl border border-dashed border-gartify-blue/20 bg-blue-50/30">
          <Package className="h-10 w-10 mx-auto mb-3 text-gartify-blue/20" />
          <p className="font-semibold text-gartify-blue/60">Sin pedidos todavía</p>
          <p className="text-sm text-gray-400 mt-1">Los pedidos aparecerán aquí cuando los talleres los realicen</p>
        </div>
      ) : (
        <div className="space-y-4">
          {orders.map((order) => (
            <article key={order.id} className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
              {/* Header del pedido */}
              <div className="flex flex-wrap items-center justify-between gap-3 px-5 py-3 bg-gartify-blue/5 border-b border-gartify-blue/10">
                <div className="flex items-center gap-4 flex-wrap">
                  <div className="flex items-center gap-1.5">
                    <Store className="h-3.5 w-3.5 text-gartify-mid" />
                    <span className="text-sm font-bold text-gartify-blue">{order.garage.name}</span>
                    <span className="text-xs text-gartify-gray">· {order.garage.city}</span>
                  </div>
                  <div className="flex items-center gap-1.5">
                    <Building2 className="h-3.5 w-3.5 text-gartify-gray" />
                    <span className="text-sm font-semibold text-gartify-gray">{order.distributor.name}</span>
                  </div>
                  <span className="text-xs text-gray-400">
                    {new Date(order.createdAt).toLocaleDateString("es-ES", {
                      day: "numeric", month: "short", year: "numeric",
                      hour: "2-digit", minute: "2-digit",
                    })}
                  </span>
                </div>
                <div className="flex items-center gap-3">
                  <span className="font-bold text-gartify-orange text-sm">{formatPrice(order.totalAmount)}</span>
                  <OrderStatusUpdater orderId={order.id} initialStatus={order.status} />
                </div>
              </div>

              {/* Líneas del pedido */}
              <div className="divide-y divide-gray-50">
                {order.lines.map((line) => (
                  <div key={line.id} className="flex items-center justify-between px-5 py-2.5 text-sm">
                    <div>
                      <p className="font-medium text-gray-700">{line.distributorPart.part.nombre}</p>
                      <p className="text-xs font-mono text-gartify-gray">{line.distributorPart.part.referenciaOem}</p>
                    </div>
                    <div className="text-right shrink-0 ml-4">
                      <p className="text-xs text-gray-400">{line.cantidad} × {formatPrice(line.precioUnitario)}</p>
                      <p className="font-bold text-gartify-orange">{formatPrice(line.precioUnitario * line.cantidad)}</p>
                    </div>
                  </div>
                ))}
              </div>

              {order.notes && (
                <div className="px-5 py-2.5 border-t border-gray-100 text-xs text-gartify-gray italic bg-gray-50/50">
                  Notas: {order.notes}
                </div>
              )}
            </article>
          ))}
        </div>
      )}
    </div>
  );
}
