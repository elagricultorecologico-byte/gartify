import type { Metadata } from "next";

export const metadata: Metadata = {
  title: "Modo TV | Gartify",
  robots: { index: false, follow: false },
};

export default function TvLayout({ children }: { children: React.ReactNode }) {
  return <>{children}</>;
}
