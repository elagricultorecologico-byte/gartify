"use client";

import { usePathname } from "next/navigation";
import { Navbar } from "@/components/layout/Navbar";
import { Footer } from "@/components/layout/Footer";

export function NavFooterWrapper({ children }: { children: React.ReactNode }) {
  const pathname = usePathname();
  const isTvMode = pathname.includes("/cuenta/taller/tv");

  return (
    <>
      {!isTvMode && <Navbar />}
      <main>{children}</main>
      {!isTvMode && <Footer />}
    </>
  );
}
