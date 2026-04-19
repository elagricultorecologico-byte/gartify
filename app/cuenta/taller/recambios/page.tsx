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
    <div className="w-full max-w-6xl mx-auto py-6 px-4 sm:px-8">
      <div className="bg-white border border-gray-200 overflow-hidden mb-5">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
          <div className="flex items-center justify-between">
            <div className="flex items-center gap-3">
              <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
                <Package className="h-5 w-5 text-gartify-blue" />
              </div>
              <div>
                <h1 className="text-base font-bold text-gartify-blue">Recambios</h1>
                <p className="text-xs text-gartify-gray mt-0.5">Busca piezas y compara precios entre distribuidores en tiempo real</p>
              </div>
            </div>
            <Link
              href="/cuenta/taller/recambios/pedidos"
              className="flex items-center gap-2 text-sm font-semibold text-gartify-blue hover:text-gartify-blue/80 border border-gartify-blue/20 px-3 py-2 hover:bg-blue-50 transition"
            >
              <ClipboardList className="h-4 w-4" />
              Mis pedidos
            </Link>
          </div>
        </div>
      </div>
      <RecambiosSearch />
    </div>
  );
}
