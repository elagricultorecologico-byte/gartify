import { redirect } from "next/navigation";
import Link from "next/link";
import { auth } from "@/lib/auth";
import { LayoutDashboard, Building2, FileText, Package, ClipboardList, Users } from "lucide-react";

export default async function AdminLayout({ children }: { children: React.ReactNode }) {
  const session = await auth();
  const user = session?.user as { id?: string; role?: string } | undefined;
  if (!user?.id) redirect("/login");
  if (user.role !== "ADMIN") redirect("/");

  return (
    <div className="min-h-screen bg-gray-50">
      {/* Barra admin */}
      <nav className="bg-gartify-dark border-b border-white/10 px-6 py-3 flex items-center gap-6">
        <span className="text-white font-bold text-sm tracking-wide uppercase">
          Gartify Admin
        </span>
        <div className="flex gap-1">
          <Link
            href="/admin"
            className="flex items-center gap-1.5 px-3 py-1.5 rounded-lg text-xs font-medium text-white/70 hover:text-white hover:bg-white/10 transition-colors"
          >
            <LayoutDashboard className="h-3.5 w-3.5" />
            Dashboard
          </Link>
          <Link
            href="/admin/talleres"
            className="flex items-center gap-1.5 px-3 py-1.5 rounded-lg text-xs font-medium text-white/70 hover:text-white hover:bg-white/10 transition-colors"
          >
            <Building2 className="h-3.5 w-3.5" />
            Talleres
          </Link>
          <Link
            href="/admin/facturacion"
            className="flex items-center gap-1.5 px-3 py-1.5 rounded-lg text-xs font-medium text-white/70 hover:text-white hover:bg-white/10 transition-colors"
          >
            <FileText className="h-3.5 w-3.5" />
            Facturación
          </Link>
          <Link
            href="/admin/pedidos"
            className="flex items-center gap-1.5 px-3 py-1.5 rounded-lg text-xs font-medium text-white/70 hover:text-white hover:bg-white/10 transition-colors"
          >
            <ClipboardList className="h-3.5 w-3.5" />
            Pedidos
          </Link>
          <Link
            href="/admin/usuarios"
            className="flex items-center gap-1.5 px-3 py-1.5 rounded-lg text-xs font-medium text-white/70 hover:text-white hover:bg-white/10 transition-colors"
          >
            <Users className="h-3.5 w-3.5" />
            Usuarios
          </Link>
          <Link
            href="/admin/distribuidores"
            className="flex items-center gap-1.5 px-3 py-1.5 rounded-lg text-xs font-medium text-white/70 hover:text-white hover:bg-white/10 transition-colors"
          >
            <Package className="h-3.5 w-3.5" />
            Recambios
          </Link>
        </div>
      </nav>
      <main>{children}</main>
    </div>
  );
}
