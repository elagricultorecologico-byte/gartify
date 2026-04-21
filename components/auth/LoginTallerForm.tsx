"use client";
import { useState } from "react";
import { signIn } from "next-auth/react";
import { useRouter } from "next/navigation";
import Link from "next/link";
import { Wrench, AlertCircle, Loader2, ArrowLeft } from "lucide-react";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";

export function LoginTallerForm() {
  const router = useRouter();
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setError("");
    const fd = new FormData(e.currentTarget);
    const email = (fd.get("email") as string ?? "").trim();
    const password = (fd.get("password") as string) ?? "";

    if (!email || !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) return setError("Introduce un email válido");
    if (password.length < 6) return setError("La contraseña debe tener al menos 6 caracteres");

    setLoading(true);
    const res = await signIn("credentials", { email, password, redirect: false });
    setLoading(false);
    if (res?.error) setError("Email o contraseña incorrectos");
    else { router.push("/cuenta/taller"); router.refresh(); }
  }

  return (
    <div className="min-h-[calc(100vh-4rem)] flex items-center justify-center py-12 px-4 bg-blue-50">
      <div className="w-full max-w-md">
        <div className="bg-white border border-gray-200 overflow-hidden">

          <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
            <div className="flex items-center gap-3">
              <div className="flex h-10 w-10 items-center justify-center bg-gartify-orange/10 border border-gartify-orange/20 shrink-0">
                <Wrench className="h-5 w-5 text-gartify-orange" aria-hidden="true" />
              </div>
              <div>
                <h1 className="text-base font-bold text-gartify-blue">Portal del taller</h1>
                <p className="text-xs text-gartify-gray mt-0.5">Accede a la gestión de tu taller</p>
              </div>
            </div>
          </div>

          <div className="p-6 space-y-5">
            <form onSubmit={handleSubmit} className="space-y-4" noValidate>
              <div className="space-y-1.5">
                <Label htmlFor="email" className="text-xs font-semibold text-gartify-blue">Email</Label>
                <Input id="email" name="email" type="email" placeholder="taller@email.es" autoComplete="email" required />
              </div>
              <div className="space-y-1.5">
                <Label htmlFor="password" className="text-xs font-semibold text-gartify-blue">Contraseña</Label>
                <Input id="password" name="password" type="password" placeholder="••••••••" autoComplete="current-password" required />
              </div>
              {error && (
                <div role="alert" className="flex items-center gap-2 bg-red-50 border border-red-100 px-3 py-2 text-sm text-red-600">
                  <AlertCircle className="h-4 w-4 shrink-0" />
                  {error}
                </div>
              )}
              <Button type="submit" className="w-full h-11 bg-gartify-orange hover:bg-orange-600 text-white font-bold" disabled={loading}>
                {loading ? <><Loader2 className="h-4 w-4 animate-spin mr-2" />Entrando...</> : "Acceder al portal"}
              </Button>
            </form>

            <div className="flex items-center justify-between text-sm pt-1">
              <Link href="/login" className="flex items-center gap-1 text-gartify-gray hover:text-gartify-dark transition-colors text-xs">
                <ArrowLeft className="h-3.5 w-3.5" />
                Volver
              </Link>
              <p className="text-muted-foreground">
                ¿Sin cuenta?{" "}
                <Link href="/registro/taller" className="text-gartify-orange font-semibold hover:underline">Registra tu taller</Link>
              </p>
            </div>
          </div>

        </div>
      </div>
    </div>
  );
}
