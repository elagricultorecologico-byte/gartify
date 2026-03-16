import type { Metadata } from "next";
import { LoginForm } from "@/components/auth/LoginForm";

export const metadata: Metadata = {
  title: "Iniciar sesión",
  description: "Accede a tu cuenta de Gartify para gestionar tus reservas en talleres mecánicos.",
  robots: { index: false, follow: false },
};

export default function LoginPage() {
  return <LoginForm />;
}
