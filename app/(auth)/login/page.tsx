import type { Metadata } from "next";
import { Suspense } from "react";
import { LoginForm } from "@/components/auth/LoginForm";
import { Loader2 } from "lucide-react";

export const metadata: Metadata = {
  title: "Iniciar sesión",
  description: "Accede a tu cuenta de Gartify para gestionar tus reservas en talleres mecánicos.",
  robots: { index: false, follow: false },
};

export default function LoginPage() {
  return (
    <Suspense
      fallback={
        <div className="min-h-[calc(100vh-4rem)] flex items-center justify-center bg-blue-50">
          <Loader2 className="h-8 w-8 animate-spin text-gartify-mid" />
        </div>
      }
    >
      <LoginForm />
    </Suspense>
  );
}
