import type { Metadata } from "next";
import Link from "next/link";
import { Car, ChevronRight } from "lucide-react";

export const metadata: Metadata = {
  title: "Iniciar sesión",
  description: "Accede a tu cuenta de Gartify.",
  robots: { index: false, follow: false },
};

export default function LoginPage() {
  return (
    <div className="min-h-[calc(100vh-4rem)] flex items-center justify-center py-12 px-4 bg-blue-50">
      <div className="w-full max-w-md space-y-4">

        <div className="text-center mb-8">
          <h1 className="text-2xl font-extrabold text-gartify-dark">Iniciar sesión</h1>
          <p className="text-gartify-gray text-sm mt-1">Accede a tus reservas y citas</p>
        </div>

        <Link
          href="/login/conductor"
          className="group flex items-center justify-between bg-white border border-gray-200 hover:border-gartify-blue/40 hover:shadow-sm transition-all px-6 py-5"
        >
          <div className="flex items-center gap-4">
            <div className="flex h-12 w-12 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <Car className="h-6 w-6 text-gartify-blue" />
            </div>
            <div>
              <p className="font-bold text-gartify-dark">Soy conductor</p>
              <p className="text-xs text-gartify-gray mt-0.5">Accede a tus reservas y citas</p>
            </div>
          </div>
          <ChevronRight className="h-5 w-5 text-gartify-gray group-hover:text-gartify-blue transition-colors shrink-0" />
        </Link>

        <p className="text-center text-sm text-muted-foreground pt-2">
          ¿No tienes cuenta?{" "}
          <Link href="/registro" className="text-gartify-orange font-semibold hover:underline">
            Regístrate gratis
          </Link>
        </p>

        <p className="text-center text-xs text-gartify-gray pt-1">
          ¿Tienes un taller?{" "}
          <Link href="/para-talleres" className="text-gartify-blue font-semibold hover:underline">
            Accede desde aquí
          </Link>
        </p>

      </div>
    </div>
  );
}
