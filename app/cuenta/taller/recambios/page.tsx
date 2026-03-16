import type { Metadata } from "next";
import { redirect } from "next/navigation";
import Link from "next/link";
import { auth } from "@/lib/auth";
import { Package, ClipboardList } from "lucide-react";
import { RecambiosSearch } from "@/components/recambios/RecambiosSearch";

export const metadata: Metadata = {
  title: "Recambios — Gartify",
  robots: { index: false, follow: false },
};

export default async function RecambiosPage() {
  const session = await auth();
  const user = session?.user as { id?: string; role?: string } | undefined;
  if (!user?.id) redirect("/login");
  if (user.role !== "GARAGE_OWNER") redirect("/cuenta");

  return (
    <div className="container max-w-6xl py-10">
      <div className="flex items-center justify-between mb-8">
        <div>
          <h1 className="text-2xl font-bold text-gartify-blue flex items-center gap-2">
            <Package className="h-6 w-6 text-gartify-orange" />
            Recambios
          </h1>
          <p className="text-muted-foreground text-sm mt-1">
            Busca piezas y compara precios entre distribuidores en tiempo real
          </p>
        </div>
        <Link
          href="/cuenta/taller/recambios/pedidos"
          className="flex items-center gap-2 text-sm font-semibold text-gartify-blue hover:text-gartify-blue/80 border border-gartify-blue/20 rounded-lg px-3 py-2 hover:bg-blue-50 transition"
        >
          <ClipboardList className="h-4 w-4" />
          Mis pedidos
        </Link>
      </div>

      <RecambiosSearch />
    </div>
  );
}
