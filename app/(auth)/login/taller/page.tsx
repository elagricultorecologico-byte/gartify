import type { Metadata } from "next";
import { Suspense } from "react";
import { LoginTallerForm } from "@/components/auth/LoginTallerForm";
import { Loader2 } from "lucide-react";

export const metadata: Metadata = {
  title: "Iniciar sesión — Taller",
  robots: { index: false, follow: false },
};

export default function LoginTallerPage() {
  return (
    <Suspense fallback={
      <div className="min-h-[calc(100vh-4rem)] flex items-center justify-center bg-blue-50">
        <Loader2 className="h-8 w-8 animate-spin text-gartify-mid" />
      </div>
    }>
      <LoginTallerForm />
    </Suspense>
  );
}
