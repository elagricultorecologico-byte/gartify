import type { Metadata } from "next";
import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { DistributorManager } from "@/components/admin/DistributorManager";

export const dynamic = "force-dynamic";
export const metadata: Metadata = { title: "Distribuidores — Admin" };

export default async function AdminDistribuidoresPage() {
  const session = await auth();
  const user = session?.user as { role?: string } | undefined;
  if (user?.role !== "ADMIN") redirect("/");

  const distributors = await db.distributor.findMany({
    orderBy: { name: "asc" },
    include: { _count: { select: { parts: true, orders: true } } },
  });

  return (
    <div className="container max-w-5xl py-10">
      <div className="mb-8">
        <h1 className="text-2xl font-bold text-gartify-blue">Distribuidores de recambios</h1>
        <p className="text-sm text-muted-foreground mt-1">
          Gestiona los proveedores y su catálogo de piezas
        </p>
      </div>
      <DistributorManager initialDistributors={distributors} />
    </div>
  );
}
