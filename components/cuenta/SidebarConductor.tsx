"use client";
import Link from "next/link";
import { usePathname } from "next/navigation";
import { signOut } from "next-auth/react";
import { CalendarDays, Car, User, LogOut, Search } from "lucide-react";

interface ItemNavegacion {
  href: string;
  icon: React.ComponentType<{ className?: string }>;
  label: string;
  exact?: boolean;
}

const ITEMS_NAVEGACION: ItemNavegacion[] = [
  { href: "/cuenta",           icon: CalendarDays, label: "Mis reservas",  exact: true },
  { href: "/cuenta/vehiculos", icon: Car,          label: "Mis vehículos" },
  { href: "/cuenta/perfil",    icon: User,         label: "Mi perfil" },
  { href: "/talleres",         icon: Search,       label: "Buscar taller" },
];

function ItemNav({ item, pathname }: { item: ItemNavegacion; pathname: string }) {
  const estaActivo = item.exact
    ? pathname === item.href
    : pathname.startsWith(item.href);

  const Icon = item.icon;

  return (
    <Link
      href={item.href}
      className={[
        "flex items-center gap-3 px-3 py-2 text-sm font-medium transition-colors",
        estaActivo
          ? "bg-gartify-blue text-white"
          : "text-gray-600 hover:bg-gartify-blue/5 hover:text-gartify-blue",
      ].join(" ")}
    >
      <Icon className="h-4 w-4 shrink-0" aria-hidden="true" />
      <span>{item.label}</span>
    </Link>
  );
}

function ContenidoSidebar({ pathname }: { pathname: string }) {
  return (
    <div className="flex flex-col h-full py-4">
      <nav className="flex-1 px-2 space-y-0.5" aria-label="Navegación del conductor">
        {ITEMS_NAVEGACION.map((item) => (
          <ItemNav key={item.href} item={item} pathname={pathname} />
        ))}
      </nav>

      <div className="px-2 pt-3 border-t border-gray-200">
        <button
          onClick={() => signOut({ callbackUrl: "/" })}
          className="w-full flex items-center gap-3 px-3 py-2 text-sm font-medium text-red-500 hover:bg-red-50 transition-colors"
        >
          <LogOut className="h-4 w-4 shrink-0" aria-hidden="true" />
          Cerrar sesión
        </button>
      </div>
    </div>
  );
}

export function SidebarConductor() {
  const pathname = usePathname();

  return (
    <aside className="hidden lg:flex flex-col w-56 shrink-0 sticky top-16 h-[calc(100vh-4rem)] overflow-y-auto bg-white border-r border-gray-200">
      <ContenidoSidebar pathname={pathname} />
    </aside>
  );
}
