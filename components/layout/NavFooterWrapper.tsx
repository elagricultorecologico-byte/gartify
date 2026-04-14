"use client";

import { usePathname } from "next/navigation";
import { Navbar } from "@/components/layout/Navbar";
import { Footer } from "@/components/layout/Footer";

export function NavFooterWrapper({ children }: { children: React.ReactNode }) {
  const pathname = usePathname();
  const hideChrome =
    pathname.includes("/cuenta/taller/tv") ||
    pathname.startsWith("/confirmar/") ||
    pathname.startsWith("/reagendar/") ||
    pathname.startsWith("/rechazar/") ||
    pathname.endsWith("/pdf");

  return (
    <>
      {!hideChrome && <Navbar />}
      <main>{children}</main>
      {!hideChrome && <Footer />}
    </>
  );
}
