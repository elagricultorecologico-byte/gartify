"use client";

import { usePathname } from "next/navigation";
import { SidebarTaller } from "@/components/cuenta/SidebarTaller";

interface PropsTallerShell {
  children: React.ReactNode;
  garageName: string;
  plan: string;
  garageId: string;
}

/**
 * Shell de layout para el portal de taller.
 * En modo TV (/cuenta/taller/tv/**) renderiza sin sidebar ni chrome adicional.
 * En el resto de rutas muestra el sidebar de navegación a la izquierda.
 */
export function TallerShell({
  children,
  garageName,
  plan,
}: PropsTallerShell) {
  const pathname = usePathname();

  // Modo TV: renderiza sin sidebar
  if (pathname.startsWith("/cuenta/taller/tv")) {
    return <>{children}</>;
  }

  return (
    <div className="flex min-h-[calc(100vh-4rem)]">
      <SidebarTaller />
      <div className="flex-1 min-w-0 overflow-x-hidden">
        {children}
      </div>
    </div>
  );
}
