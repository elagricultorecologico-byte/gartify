import type { Metadata } from "next";
import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { DistributorManager } from "@/components/admin/DistributorManager";
import { DistributorUserLinker } from "@/components/admin/DistributorUserLinker";
import { Package, UserCheck, ClipboardList } from "lucide-react";

export const dynamic = "force-dynamic";
export const metadata: Metadata = { title: "Distribuidores — Admin" };

export default async function AdminDistribuidoresPage() {
  const session = await auth();
  const user = session?.user as { role?: string } | undefined;
  if (user?.role !== "ADMIN") redirect("/");

  const [distribuidores, usuariosDistribuidor] = await Promise.all([
    db.distributor.findMany({
      orderBy: { name: "asc" },
      include: {
        _count: { select: { parts: true, orders: true } },
        user: { select: { id: true, name: true, email: true } },
      },
    }),
    // Usuarios con rol DISTRIBUTOR que aún no están vinculados a ningún distribuidor
    db.user.findMany({
      where: {
        role: "DISTRIBUTOR",
        distributor: null,
      },
      select: { id: true, name: true, email: true },
      orderBy: { name: "asc" },
    }),
  ]);

  // Stats rápidas
  const totalPedidos = distribuidores.reduce((acc, d) => acc + d._count.orders, 0);
  const totalPiezas  = distribuidores.reduce((acc, d) => acc + d._count.parts,  0);
  const conCuenta    = distribuidores.filter((d) => d.user !== null).length;

  return (
    <div className="container max-w-5xl py-10">
      <div className="bg-white border border-gray-200 overflow-hidden mb-8">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
          <div className="flex items-center gap-3">
            <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <Package className="h-5 w-5 text-gartify-blue" />
            </div>
            <div>
              <h1 className="text-base font-bold text-gartify-blue">Distribuidores de recambios</h1>
              <p className="text-xs text-gartify-gray mt-0.5">Gestiona los proveedores, su catálogo de piezas y sus cuentas de acceso</p>
            </div>
          </div>
        </div>
      </div>

      {/* Stats */}
      <div className="grid grid-cols-3 gap-4 mb-8">
        <div className="rounded-xl border border-blue-100 bg-blue-50 p-4 flex items-center gap-3">
          <div className="h-9 w-9 rounded-full bg-white flex items-center justify-center shadow-sm shrink-0">
            <Package className="h-4 w-4 text-gartify-blue" />
          </div>
          <div>
            <p className="text-xs text-muted-foreground">Piezas catalogadas</p>
            <p className="font-bold text-lg">{totalPiezas}</p>
          </div>
        </div>
        <div className="rounded-xl border border-orange-100 bg-orange-50 p-4 flex items-center gap-3">
          <div className="h-9 w-9 rounded-full bg-white flex items-center justify-center shadow-sm shrink-0">
            <ClipboardList className="h-4 w-4 text-gartify-orange" />
          </div>
          <div>
            <p className="text-xs text-muted-foreground">Pedidos totales</p>
            <p className="font-bold text-lg">{totalPedidos}</p>
          </div>
        </div>
        <div className="rounded-xl border border-green-100 bg-green-50 p-4 flex items-center gap-3">
          <div className="h-9 w-9 rounded-full bg-white flex items-center justify-center shadow-sm shrink-0">
            <UserCheck className="h-4 w-4 text-green-600" />
          </div>
          <div>
            <p className="text-xs text-muted-foreground">Con cuenta activa</p>
            <p className="font-bold text-lg">{conCuenta} / {distribuidores.length}</p>
          </div>
        </div>
      </div>

      {/* Vinculador de usuarios a distribuidores */}
      {(usuariosDistribuidor.length > 0 || distribuidores.some((d) => d.user !== null)) && (
        <div className="mb-8">
          <DistributorUserLinker
            distribuidores={distribuidores.map((d) => ({
              id: d.id,
              name: d.name,
              userId: d.user?.id ?? null,
              userName: d.user?.name ?? null,
              userEmail: d.user?.email ?? null,
            }))}
            usuariosSinVincular={usuariosDistribuidor}
          />
        </div>
      )}

      {/* Gestor de distribuidores (crear + importar catálogo) */}
      <DistributorManager initialDistributors={distribuidores} />
    </div>
  );
}
