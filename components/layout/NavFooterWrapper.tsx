"use client";

import { usePathname } from "next/navigation";
import { Navbar } from "@/components/layout/Navbar";
import { Footer } from "@/components/layout/Footer";

export function NavFooterWrapper({ children }: { children: React.ReactNode }) {
  const pathname = usePathname();

  // Rutas donde se oculta todo el chrome (navbar + footer)
  const hideChrome =
    pathname.includes("/cuenta/taller/tv") ||
    pathname.startsWith("/confirmar/") ||
    pathname.startsWith("/reagendar/") ||
    pathname.startsWith("/rechazar/") ||
    pathname.endsWith("/pdf");

  // El portal de taller tiene su propio layout con sidebar;
  // ocultamos el footer para evitar que aparezca debajo del contenido.
  const hideFooter =
    hideChrome || pathname.startsWith("/cuenta/taller");

  return (
    <>
      {!hideChrome && <Navbar />}
      <main>{children}</main>
      {!hideChrome && !hideFooter && <Footer />}
    </>
  );
}
