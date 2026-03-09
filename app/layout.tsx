import type { Metadata } from "next";
import { Inter, Geist } from "next/font/google";
import "./globals.css";
import { SessionProvider } from "@/components/providers/SessionProvider";
import { Navbar } from "@/components/layout/Navbar";
import { cn } from "@/lib/utils";

const geist = Geist({subsets:['latin'],variable:'--font-sans'});

const inter = Inter({ subsets: ["latin"] });

export const metadata: Metadata = {
  title: "Gartify — Encuentra tu taller de confianza",
  description: "Compara precios, lee reseñas y reserva cita en talleres mecánicos de toda España.",
};

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="es" className={cn("dark", "font-sans", geist.variable)}>
      <body className={inter.className}>
        <SessionProvider>
          <Navbar />
          <main>{children}</main>
          <footer className="border-t border-border mt-16 py-8">
            <div className="container text-center text-sm text-muted-foreground">
              © {new Date().getFullYear()} Gartify · Encuentra tu taller de confianza en España
            </div>
          </footer>
        </SessionProvider>
      </body>
    </html>
  );
}
