import type { Metadata } from "next";
import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Package, ClipboardList, Truck, CheckCircle2, ThumbsUp, Euro, TrendingUp, AlertTriangle } from "lucide-react";
import { OrdersTable } from "@/components/distribuidor/OrdersTable";
import { AutoRefresh } from "@/components/cuenta/AutoRefresh";

export const dynamic = "force-dynamic";
export const metadata: Metadata = { title: "Mi Dashboard — Distribuidor" };

export default async function DistribuidorDashboardPage() {
  // ─── Verificación de sesión y rol ─────────────────────────────────────────
  const sesion = await auth();
  const usuario = sesion?.user as { id?: string; role?: string } | undefined;

  if (!usuario?.id) redirect("/login");
  if (usuario.role !== "DISTRIBUTOR") redirect("/");

  // ─── Buscar distribuidor vinculado al usuario ──────────────────────────────
  const distribuidor = await db.distributor.findUnique({
    where: { userId: usuario.id },
    select: { id: true, name: true, email: true, isActive: true },
  });

  if (!distribuidor) {
    // El usuario tiene rol DISTRIBUTOR pero no hay registro Distributor vinculado
    return (
      <div className="container max-w-5xl py-10">
        <div className="rounded-xl border border-yellow-200 bg-yellow-50 p-6 text-center">
          <p className="font-semibold text-yellow-800">Cuenta en configuración</p>
          <p className="text-sm text-yellow-700 mt-1">
            Tu cuenta de distribuidor está siendo configurada. Contacta con el administrador.
          </p>
        </div>
      </div>
    );
  }

  // ─── Datos del panel ───────────────────────────────────────────────────────
  const [
    pedidosTotal,
    pedidosPendientes,
    pedidosConfirmados,
    pedidosEnviados,
    pedidosEntregados,
    facturacionMes,
    ticketMedioAgg,
    pedidosVencidos,
    listaPedidos,
  ] = await Promise.all([
    // Total de pedidos
    db.partOrder.count({
      where: { distributorId: distribuidor.id },
    }),
    // Pendientes de confirmar (estado PENDING)
    db.partOrder.count({
      where: { distributorId: distribuidor.id, status: "PENDING" },
    }),
    // Confirmados (estado CONFIRMED)
    db.partOrder.count({
      where: { distributorId: distribuidor.id, status: "CONFIRMED" },
    }),
    // En camino (estado SHIPPED)
    db.partOrder.count({
      where: { distributorId: distribuidor.id, status: "SHIPPED" },
    }),
    // Entregados (estado DELIVERED)
    db.partOrder.count({
      where: { distributorId: distribuidor.id, status: "DELIVERED" },
    }),
    // Facturación del mes actual (pedidos DELIVERED este mes)
    db.partOrder.aggregate({
      where: {
        distributorId: distribuidor.id,
        status: "DELIVERED",
        createdAt: {
          gte: new Date(new Date().getFullYear(), new Date().getMonth(), 1),
        },
      },
      _sum: { totalAmount: true },
    }),
    // Ticket medio (avg totalAmount de todos los pedidos)
    db.partOrder.aggregate({
      where: { distributorId: distribuidor.id },
      _avg: { totalAmount: true },
    }),
    // Pedidos activos con más de 24h en su estado actual sin avanzar
    db.partOrder.count({
      where: {
        distributorId: distribuidor.id,
        status: { in: ["PENDING", "CONFIRMED", "SHIPPED"] },
        statusUpdatedAt: {
          lte: new Date(Date.now() - 24 * 60 * 60 * 1000),
        },
      },
    }),
    // Lista completa de pedidos con relaciones necesarias
    db.partOrder.findMany({
      where: { distributorId: distribuidor.id },
      orderBy: { createdAt: "desc" },
      select: {
        id: true,
        createdAt: true,
        statusUpdatedAt: true,
        totalAmount: true,
        status: true,
        notes: true,
        garage: {
          select: { id: true, name: true },
        },
        lines: {
          select: {
            id: true,
            cantidad: true,
            precioUnitario: true,
            distributorPart: {
              select: {
                referenciaProveedor: true,
                part: { select: { nombre: true } },
              },
            },
          },
        },
      },
    }),
  ]);

  // ─── Stats cards ───────────────────────────────────────────────────────────
  const tarjetas = [
    {
      icono: ClipboardList,
      etiqueta: "Total pedidos",
      valor: pedidosTotal,
      color: "text-gartify-blue",
      bg: "bg-blue-50",
      borde: "border-blue-100",
    },
    {
      icono: Package,
      etiqueta: "Pendientes de confirmar",
      valor: pedidosPendientes,
      color: "text-yellow-600",
      bg: "bg-yellow-50",
      borde: "border-yellow-100",
    },
    {
      icono: ThumbsUp,
      etiqueta: "Confirmados",
      valor: pedidosConfirmados,
      color: "text-teal-600",
      bg: "bg-teal-50",
      borde: "border-teal-100",
    },
    {
      icono: Truck,
      etiqueta: "En camino",
      valor: pedidosEnviados,
      color: "text-gartify-orange",
      bg: "bg-orange-50",
      borde: "border-orange-100",
    },
    {
      icono: CheckCircle2,
      etiqueta: "Entregados",
      valor: pedidosEntregados,
      color: "text-green-600",
      bg: "bg-green-50",
      borde: "border-green-100",
    },
  ];

  // ─── Valores derivados de las nuevas queries ──────────────────────────────
  const facturacionMesValor = facturacionMes._sum?.totalAmount ?? 0;
  const ticketMedio = ticketMedioAgg._avg?.totalAmount ?? 0;

  // Serializar fechas (Date → string) para que el Client Component las pueda recibir
  type EstadoPedido = "PENDING" | "CONFIRMED" | "SHIPPED" | "DELIVERED" | "CANCELLED";
  const pedidosSerializados = listaPedidos.map((p) => ({
    ...p,
    status: p.status as EstadoPedido,
    createdAt: p.createdAt.toISOString(),
    statusUpdatedAt: p.statusUpdatedAt.toISOString(),
  }));

  return (
    <div className="container max-w-5xl py-10">
      {/* Encabezado */}
      <div className="mb-8 flex items-start justify-between gap-4">
        <div>
          <h1 className="text-2xl font-bold text-gartify-blue">
            Portal del distribuidor
          </h1>
          <p className="text-sm text-muted-foreground mt-1">
            {distribuidor.name} · {distribuidor.email}
          </p>
        </div>
        {!distribuidor.isActive && (
          <div className="rounded-lg border border-red-200 bg-red-50 px-3 py-2 text-xs font-semibold text-red-700">
            Cuenta inactiva
          </div>
        )}
      </div>

      {/* Fila 1: Total + 4 estados */}
      <div className="grid grid-cols-2 md:grid-cols-5 gap-4 mb-4">
        <div className="rounded-xl border-2 border-gartify-blue bg-gartify-blue p-4 flex items-center gap-3">
          <div className="h-10 w-10 rounded-full bg-white/20 flex items-center justify-center shrink-0">
            <ClipboardList className="h-5 w-5 text-white" />
          </div>
          <div>
            <p className="text-xs text-blue-100 font-medium">Total pedidos</p>
            <p className="font-bold text-white text-2xl leading-tight">{pedidosTotal}</p>
          </div>
        </div>
        {tarjetas.slice(1).map(({ icono: Icono, etiqueta, valor, color, bg, borde }) => (
          <div key={etiqueta} className={`rounded-xl border ${borde} ${bg} p-4 flex items-center gap-3`}>
            <div className="h-10 w-10 rounded-full bg-white flex items-center justify-center shadow-sm shrink-0">
              <Icono className={`h-5 w-5 ${color}`} />
            </div>
            <div>
              <p className="text-xs text-muted-foreground">{etiqueta}</p>
              <p className="font-bold text-foreground text-2xl leading-tight">{valor}</p>
            </div>
          </div>
        ))}
      </div>

      {/* Fila 2: KPIs financieros */}
      <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mb-8">
        <div className="rounded-xl border border-blue-100 bg-blue-50 p-4 flex items-center gap-3">
          <div className="h-10 w-10 rounded-full bg-white flex items-center justify-center shadow-sm shrink-0">
            <Euro className="h-5 w-5 text-gartify-blue" />
          </div>
          <div>
            <p className="text-xs text-muted-foreground">Facturación este mes</p>
            <p className="font-bold text-gartify-blue text-2xl leading-tight">
              {new Intl.NumberFormat("es-ES", { style: "currency", currency: "EUR" }).format(facturacionMesValor)}
            </p>
          </div>
        </div>
        <div className="rounded-xl border border-blue-100 bg-blue-50 p-4 flex items-center gap-3">
          <div className="h-10 w-10 rounded-full bg-white flex items-center justify-center shadow-sm shrink-0">
            <TrendingUp className="h-5 w-5 text-gartify-blue" />
          </div>
          <div>
            <p className="text-xs text-muted-foreground">Ticket medio</p>
            <p className="font-bold text-gartify-blue text-2xl leading-tight">
              {new Intl.NumberFormat("es-ES", { style: "currency", currency: "EUR" }).format(ticketMedio)}
            </p>
          </div>
        </div>
      </div>

      {/* Tabla de pedidos */}
      <div className="mb-4 flex items-end justify-between gap-4">
        <div>
          <h2 className="text-base font-bold text-gartify-blue">
            Pedidos recibidos
          </h2>
          <p className="text-xs text-muted-foreground mt-0.5">
            Gestiona el estado de cada pedido directamente desde aquí
          </p>
        </div>
        <AutoRefresh />
      </div>

      {/* Alerta pedidos sin atender */}
      {pedidosVencidos > 0 && (
        <div className="mb-4 flex items-start gap-3 rounded-xl border border-amber-200 bg-amber-50 px-4 py-3">
          <AlertTriangle className="h-4 w-4 text-amber-600 shrink-0 mt-0.5" />
          <p className="text-sm text-amber-800">
            <span className="font-semibold">{pedidosVencidos} {pedidosVencidos === 1 ? "pedido lleva" : "pedidos llevan"}</span>
            {" "}más de 24 h sin avanzar. Aparecen resaltados en la tabla.
          </p>
        </div>
      )}

      <OrdersTable pedidosIniciales={pedidosSerializados} />
    </div>
  );
}
