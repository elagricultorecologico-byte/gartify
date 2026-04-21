import type { Metadata } from "next";
import { Suspense } from "react";
import { LoginConductorForm } from "@/components/auth/LoginConductorForm";
import { Loader2 } from "lucide-react";

export const metadata: Metadata = {
  title: "Iniciar sesión — Conductor",
  robots: { index: false, follow: false },
};

export default function LoginConductorPage() {
  return (
    <Suspense fallback={
      <div className="min-h-[calc(100vh-4rem)] flex items-center justify-center bg-blue-50">
        <Loader2 className="h-8 w-8 animate-spin text-gartify-mid" />
      </div>
    }>
      <LoginConductorForm />
    </Suspense>
  );
}
