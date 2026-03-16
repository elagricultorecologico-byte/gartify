import type { Metadata } from "next";
import { Suspense } from "react";
import { RegistroForm } from "@/components/auth/RegistroForm";
import { Loader2 } from "lucide-react";

export const metadata: Metadata = {
  title: "Crear cuenta",
  description: "Regístrate en Gartify de forma gratuita. Únete como conductor para reservar citas, o registra tu taller mecánico.",
  robots: { index: false, follow: false },
};

export default function RegistroPage() {
  return (
    <Suspense
      fallback={
        <div className="min-h-[calc(100vh-4rem)] flex items-center justify-center bg-blue-50">
          <Loader2 className="h-8 w-8 animate-spin text-gartify-mid" />
        </div>
      }
    >
      <RegistroForm />
    </Suspense>
  );
}
