"use client";
import Link from "next/link";
import { usePathname } from "next/navigation";
import { signOut } from "next-auth/react";
import {
  LayoutDashboard,
  CalendarDays,
  Wrench,
  Clock,
  Tag,
  Package,
  CreditCard,
  Tv,
  User,
  LogOut,
} from "lucide-react";

// ── Tipos ────────────────────────────────────────────────────────────────────

interface ItemNavegacion {
  href: string;
  icon: React.ComponentType<{ className?: string }>;
  label: string;
  exact?: boolean;
}


// ── Datos estáticos de navegación ────────────────────────────────────────────

const ITEMS_NAVEGACION: ItemNavegacion[] = [
  { href: "/cuenta/taller",           icon: LayoutDashboard, label: "Reservas",  exact: true },
  { href: "/cuenta/taller/agenda",    icon: CalendarDays,    label: "Agenda" },
  { href: "/cuenta/taller/servicios", icon: Wrench,          label: "Servicios" },
  { href: "/cuenta/taller/horario",   icon: Clock,           label: "Horario" },
  { href: "/cuenta/taller/ofertas",   icon: Tag,             label: "Ofertas" },
  { href: "/cuenta/taller/recambios", icon: Package,         label: "Recambios" },
  { href: "/cuenta/taller/planes",    icon: CreditCard,      label: "Mi plan" },
  { href: "/cuenta/taller/perfil",   icon: User,            label: "Mi perfil" },
];

const ITEM_TV: ItemNavegacion = {
  href: "/cuenta/taller/tv",
  icon: Tv,
  label: "Modo TV",
};



// ── Sub-componente: ítem individual de navegación ────────────────────────────

function ItemNav({
  item,
  pathname,
  alCerrar,
}: {
  item: ItemNavegacion;
  pathname: string;
  alCerrar?: () => void;
}) {
  const estaActivo = item.exact
    ? pathname === item.href
    : pathname.startsWith(item.href);

  const Icon = item.icon;

  return (
    <Link
      href={item.href}
      onClick={alCerrar}
      className={[
        "flex items-center gap-3 rounded-lg px-3 py-2 text-sm font-medium transition-colors",
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

// ── Sub-componente: contenido interno del sidebar (reutilizado en desktop y drawer) ──

function ContenidoSidebar({
  pathname,
  alCerrar,
}: {
  pathname: string;
  alCerrar?: () => void;
}) {
  return (
    <div className="flex flex-col h-full py-4">
      {/* Ítems principales */}
      <nav className="flex-1 px-2 space-y-0.5" aria-label="Navegación del portal de taller">
        {ITEMS_NAVEGACION.map((item) => (
          <ItemNav
            key={item.href}
            item={item}
            pathname={pathname}
            alCerrar={alCerrar}
          />
        ))}
      </nav>

      {/* Pie: Modo TV + Cerrar sesión */}
      <div className="px-2 pt-3 border-t border-gray-200 space-y-0.5">
        <ItemNav item={ITEM_TV} pathname={pathname} alCerrar={alCerrar} />
        <button
          onClick={() => signOut({ callbackUrl: "/" })}
          className="w-full flex items-center gap-3 rounded-lg px-3 py-2 text-sm font-medium text-red-500 hover:bg-red-50 transition-colors"
        >
          <LogOut className="h-4 w-4 shrink-0" aria-hidden="true" />
          Cerrar sesión
        </button>
      </div>
    </div>
  );
}

// ── Componente principal ─────────────────────────────────────────────────────

export function SidebarTaller() {
  const pathname = usePathname();

  return (
    <aside className="hidden lg:flex flex-col w-56 shrink-0 sticky top-16 h-[calc(100vh-4rem)] overflow-y-auto bg-white border-r border-gray-200">
      <ContenidoSidebar pathname={pathname} />
    </aside>
  );
}
