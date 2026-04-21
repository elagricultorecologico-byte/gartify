import type { Metadata } from "next";
import Link from "next/link";
import { Car, Building2, ChevronRight } from "lucide-react";

export const metadata: Metadata = {
  title: "Crear cuenta",
  description: "Regístrate en Gartify de forma gratuita.",
  robots: { index: false, follow: false },
};

export default function RegistroPage() {
  return (
    <div className="min-h-[calc(100vh-4rem)] flex items-center justify-center py-12 px-4 bg-blue-50">
      <div className="w-full max-w-md space-y-4">

        <div className="text-center mb-8">
          <h1 className="text-2xl font-extrabold text-gartify-dark">¿Cómo quieres unirte?</h1>
          <p className="text-gartify-gray text-sm mt-1">Crea tu cuenta gratuita en segundos</p>
        </div>

        {/* Card conductor */}
        <Link
          href="/registro/conductor"
          className="group flex items-center justify-between bg-white border border-gray-200 hover:border-gartify-blue/40 hover:shadow-sm transition-all px-6 py-5"
        >
          <div className="flex items-center gap-4">
            <div className="flex h-12 w-12 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <Car className="h-6 w-6 text-gartify-blue" />
            </div>
            <div>
              <p className="font-bold text-gartify-dark">Soy conductor</p>
              <p className="text-xs text-gartify-gray mt-0.5">Reserva citas y gestiona tu coche</p>
            </div>
          </div>
          <ChevronRight className="h-5 w-5 text-gartify-gray group-hover:text-gartify-blue transition-colors shrink-0" />
        </Link>

        {/* Card taller */}
        <Link
          href="/registro/taller"
          className="group flex items-center justify-between bg-white border border-gray-200 hover:border-gartify-orange/40 hover:shadow-sm transition-all px-6 py-5"
        >
          <div className="flex items-center gap-4">
            <div className="flex h-12 w-12 items-center justify-center bg-gartify-orange/10 border border-gartify-orange/20 shrink-0">
              <Building2 className="h-6 w-6 text-gartify-orange" />
            </div>
            <div>
              <p className="font-bold text-gartify-dark">Tengo un taller</p>
              <p className="text-xs text-gartify-gray mt-0.5">Recibe reservas y gestiona tu agenda</p>
            </div>
          </div>
          <ChevronRight className="h-5 w-5 text-gartify-gray group-hover:text-gartify-orange transition-colors shrink-0" />
        </Link>

        <p className="text-center text-sm text-muted-foreground pt-2">
          ¿Ya tienes cuenta?{" "}
          <Link href="/login" className="text-gartify-orange font-semibold hover:underline">
            Inicia sesión
          </Link>
        </p>

      </div>
    </div>
  );
}
