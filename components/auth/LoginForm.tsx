"use client";
import { useState } from "react";
import { signIn } from "next-auth/react";
import { useRouter, useSearchParams } from "next/navigation";
import Link from "next/link";
import { Wrench, AlertCircle, Loader2, Car, Building2 } from "lucide-react";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";

function GoogleButton({ loading, onClick }: { loading: boolean; onClick: () => void }) {
  return (
    <button
      type="button"
      onClick={onClick}
      disabled={loading}
      aria-label="Continuar con Google"
      className="w-full flex items-center justify-center gap-3 h-11 border border-gray-300 bg-white hover:bg-gray-50 text-sm font-semibold text-gray-700 transition-colors disabled:opacity-50"
    >
      <svg width="18" height="18" viewBox="0 0 18 18" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
        <path d="M17.64 9.2c0-.637-.057-1.251-.164-1.84H9v3.481h4.844c-.209 1.125-.843 2.078-1.796 2.716v2.259h2.908c1.702-1.567 2.684-3.875 2.684-6.615z" fill="#4285F4"/>
        <path d="M9 18c2.43 0 4.467-.806 5.956-2.184l-2.908-2.259c-.806.54-1.837.86-3.048.86-2.344 0-4.328-1.584-5.036-3.711H.957v2.332A8.997 8.997 0 0 0 9 18z" fill="#34A853"/>
        <path d="M3.964 10.706A5.41 5.41 0 0 1 3.682 9c0-.593.102-1.17.282-1.706V4.962H.957A8.996 8.996 0 0 0 0 9c0 1.452.348 2.827.957 4.038l3.007-2.332z" fill="#FBBC05"/>
        <path d="M9 3.58c1.321 0 2.508.454 3.44 1.345l2.582-2.58C13.463.891 11.426 0 9 0A8.997 8.997 0 0 0 .957 4.962L3.964 7.294C4.672 5.163 6.656 3.58 9 3.58z" fill="#EA4335"/>
      </svg>
      {loading ? "Redirigiendo..." : "Continuar con Google"}
    </button>
  );
}

function EmailPasswordForm({
  onSubmit,
  loading,
  error,
  submitLabel,
}: {
  onSubmit: (e: React.FormEvent<HTMLFormElement>) => void;
  loading: boolean;
  error: string;
  submitLabel: string;
}) {
  return (
    <form onSubmit={onSubmit} className="space-y-4" noValidate>
      <div className="space-y-1.5">
        <Label htmlFor="email" className="text-xs font-semibold text-gartify-blue">Email</Label>
        <Input id="email" name="email" type="email" placeholder="tu@email.es" autoComplete="email" required />
      </div>
      <div className="space-y-1.5">
        <Label htmlFor="password" className="text-xs font-semibold text-gartify-blue">Contraseña</Label>
        <Input id="password" name="password" type="password" placeholder="••••••••" autoComplete="current-password" required />
      </div>
      {error && (
        <div role="alert" className="flex items-center gap-2 bg-red-50 border border-red-100 px-3 py-2 text-sm text-red-600">
          <AlertCircle className="h-4 w-4 shrink-0" aria-hidden="true" />
          {error}
        </div>
      )}
      <Button type="submit" className="w-full h-11 bg-gartify-green hover:bg-gartify-green/90 text-white font-semibold" disabled={loading}>
        {loading ? <><Loader2 className="h-4 w-4 animate-spin mr-2" aria-hidden="true" />Entrando...</> : submitLabel}
      </Button>
    </form>
  );
}

export function LoginForm() {
  const router = useRouter();
  const searchParams = useSearchParams();
  const callbackUrl = searchParams.get("callbackUrl") ?? "/cuenta";
  const defaultTab = searchParams.get("tipo") === "taller" ? "taller" : "conductor";

  const [tab, setTab] = useState<"conductor" | "taller">(defaultTab);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);
  const [googleLoading, setGoogleLoading] = useState(false);

  function switchTab(t: "conductor" | "taller") {
    setTab(t);
    setError("");
  }

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

    if (res?.error) {
      setError("Email o contraseña incorrectos");
    } else {
      router.push(tab === "taller" ? "/cuenta/taller" : callbackUrl);
      router.refresh();
    }
  }

  async function handleGoogle() {
    setGoogleLoading(true);
    await signIn("google", { callbackUrl });
  }

  return (
    <div className="min-h-[calc(100vh-4rem)] flex items-center justify-center py-12 px-4 bg-blue-50">
      <div className="w-full max-w-md">
        <div className="bg-white border border-gray-200 overflow-hidden">

          {/* Cabecera dinámica */}
          <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
            <div className="flex items-center gap-3">
              <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
                {tab === "taller"
                  ? <Wrench className="h-5 w-5 text-gartify-blue" aria-hidden="true" />
                  : <Car className="h-5 w-5 text-gartify-blue" aria-hidden="true" />
                }
              </div>
              <div>
                <h1 className="text-base font-bold text-gartify-blue">Iniciar sesión</h1>
                <p className="text-xs text-gartify-gray mt-0.5">
                  {tab === "taller" ? "Accede al portal de tu taller" : "Accede a tu cuenta de conductor"}
                </p>
              </div>
            </div>
          </div>

          <div className="p-6 space-y-5">

            {/* Selector de tipo */}
            <div role="tablist" aria-label="Tipo de cuenta" className="flex gap-2 p-1 bg-blue-50 border border-blue-100">
              <button
                role="tab"
                type="button"
                aria-selected={tab === "conductor"}
                onClick={() => switchTab("conductor")}
                className={`flex-1 flex items-center justify-center gap-2 py-2.5 px-4 text-sm font-semibold transition-all ${
                  tab === "conductor" ? "bg-gartify-blue text-white shadow-sm" : "text-gartify-gray hover:text-gartify-blue"
                }`}
              >
                <Car className="h-4 w-4" aria-hidden="true" />
                Soy conductor
              </button>
              <button
                role="tab"
                type="button"
                aria-selected={tab === "taller"}
                onClick={() => switchTab("taller")}
                className={`flex-1 flex items-center justify-center gap-2 py-2.5 px-4 text-sm font-semibold transition-all ${
                  tab === "taller" ? "bg-gartify-blue text-white shadow-sm" : "text-gartify-gray hover:text-gartify-blue"
                }`}
              >
                <Building2 className="h-4 w-4" aria-hidden="true" />
                Tengo un taller
              </button>
            </div>

            {/* — CONDUCTOR — */}
            {tab === "conductor" && (
              <>
                <GoogleButton loading={googleLoading} onClick={handleGoogle} />
                <div className="flex items-center gap-3" role="separator">
                  <div className="flex-1 h-px bg-gray-200" />
                  <span className="text-xs text-muted-foreground font-medium">o con email y contraseña</span>
                  <div className="flex-1 h-px bg-gray-200" />
                </div>
                <EmailPasswordForm onSubmit={handleSubmit} loading={loading} error={error} submitLabel="Entrar" />
                <p className="text-center text-sm text-muted-foreground">
                  ¿No tienes cuenta?{" "}
                  <Link href="/registro" className="text-gartify-orange font-semibold hover:underline">
                    Regístrate gratis
                  </Link>
                </p>
              </>
            )}

            {/* — TALLER — */}
            {tab === "taller" && (
              <>
                <EmailPasswordForm onSubmit={handleSubmit} loading={loading} error={error} submitLabel="Acceder al portal" />
                <p className="text-center text-sm text-muted-foreground">
                  ¿Todavía no tienes cuenta?{" "}
                  <Link href="/registro?tipo=taller" className="text-gartify-orange font-semibold hover:underline">
                    Registra tu taller
                  </Link>
                </p>
              </>
            )}

          </div>
        </div>
      </div>
    </div>
  );
}
