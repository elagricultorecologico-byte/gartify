"use client";
import { useState } from "react";
import { useRouter, useSearchParams } from "next/navigation";
import { signIn } from "next-auth/react";
import Link from "next/link";
import { Car, AlertCircle, Loader2, ArrowLeft, Lock, Mail, Phone, MessageCircle } from "lucide-react";
import PhoneInput, { isValidPhoneNumber } from "react-phone-number-input";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";

export function RegistroConductorForm() {
  const router = useRouter();
  const searchParams = useSearchParams();
  const callbackUrl = searchParams.get("callbackUrl") ?? "/cuenta";

  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);
  const [googleLoading, setGoogleLoading] = useState(false);
  const [acceptLegal, setAcceptLegal] = useState(false);
  const [acceptComercial, setAcceptComercial] = useState(false);
  const [whatsappOptIn, setWhatsappOptIn] = useState(false);
  const [phone, setPhone] = useState<string | undefined>(undefined);

  async function handleGoogle() {
    setGoogleLoading(true);
    await signIn("google", { callbackUrl });
  }

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setError("");
    const fd = new FormData(e.currentTarget);
    const name = (fd.get("name") as string ?? "").trim();
    const email = (fd.get("email") as string ?? "").trim();
    const password = (fd.get("password") as string) ?? "";

    if (!name) return setError("El nombre es obligatorio");
    if (!email || !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) return setError("Introduce un email válido");
    if (password.length < 6) return setError("La contraseña debe tener al menos 6 caracteres");
    if (!phone || !isValidPhoneNumber(phone)) return setError("Introduce un teléfono móvil válido");
    if (!acceptLegal) return setError("Debes aceptar los Términos y la Política de privacidad");

    setLoading(true);
    const res = await fetch("/api/register", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name, email, password, phone, whatsappOptIn }),
    });
    const data = await res.json() as { error?: string };
    if (!res.ok) { setError(data.error ?? "Error al crear la cuenta"); setLoading(false); return; }
    await signIn("credentials", { email, password, redirect: false });
    router.push(callbackUrl);
    router.refresh();
  }

  return (
    <div className="min-h-[calc(100vh-4rem)] flex items-center justify-center py-12 px-4 bg-blue-50">
      <div className="w-full max-w-lg">
        <div className="bg-white border border-gray-200 overflow-hidden">

          <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
            <div className="flex items-center gap-3">
              <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
                <Car className="h-5 w-5 text-gartify-blue" aria-hidden="true" />
              </div>
              <div>
                <h1 className="text-base font-bold text-gartify-blue">Crear cuenta de conductor</h1>
                <p className="text-xs text-gartify-gray mt-0.5">Únete a Gartify de forma gratuita</p>
              </div>
            </div>
          </div>

          <div className="p-6 space-y-4">
            {/* Micro-beneficios */}
            <div className="flex items-center justify-center gap-4 text-xs text-gartify-gray">
              <span className="flex items-center gap-1"><span className="text-gartify-green font-bold">✓</span> Gratis</span>
              <span className="flex items-center gap-1"><span className="text-gartify-green font-bold">✓</span> Sin permanencia</span>
              <span className="flex items-center gap-1"><span className="text-gartify-green font-bold">✓</span> Reserva en segundos</span>
            </div>

            {/* Google */}
            <button
              type="button"
              onClick={handleGoogle}
              disabled={googleLoading}
              className="w-full flex items-center justify-center gap-3 h-11 border border-gray-300 bg-white hover:bg-gray-50 text-sm font-semibold text-gray-700 transition-colors disabled:opacity-50"
            >
              <svg width="18" height="18" viewBox="0 0 18 18" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                <path d="M17.64 9.2c0-.637-.057-1.251-.164-1.84H9v3.481h4.844c-.209 1.125-.843 2.078-1.796 2.716v2.259h2.908c1.702-1.567 2.684-3.875 2.684-6.615z" fill="#4285F4"/>
                <path d="M9 18c2.43 0 4.467-.806 5.956-2.184l-2.908-2.259c-.806.54-1.837.86-3.048.86-2.344 0-4.328-1.584-5.036-3.711H.957v2.332A8.997 8.997 0 0 0 9 18z" fill="#34A853"/>
                <path d="M3.964 10.706A5.41 5.41 0 0 1 3.682 9c0-.593.102-1.17.282-1.706V4.962H.957A8.996 8.996 0 0 0 0 9c0 1.452.348 2.827.957 4.038l3.007-2.332z" fill="#FBBC05"/>
                <path d="M9 3.58c1.321 0 2.508.454 3.44 1.345l2.582-2.58C13.463.891 11.426 0 9 0A8.997 8.997 0 0 0 .957 4.962L3.964 7.294C4.672 5.163 6.656 3.58 9 3.58z" fill="#EA4335"/>
              </svg>
              {googleLoading ? "Redirigiendo..." : "Registrarse con Google"}
            </button>

            <div className="flex items-center gap-3">
              <div className="flex-1 h-px bg-gray-200" />
              <span className="text-xs text-muted-foreground font-medium">o con email</span>
              <div className="flex-1 h-px bg-gray-200" />
            </div>

            <form onSubmit={handleSubmit} className="space-y-3" noValidate>
              <div className="space-y-1.5">
                <Label htmlFor="name" className="text-xs font-semibold text-gartify-blue">Nombre completo <span className="text-red-500">*</span></Label>
                <Input id="name" name="name" placeholder="Juan García" autoComplete="name" required />
              </div>
              <div className="space-y-1.5">
                <Label htmlFor="email" className="text-xs font-semibold text-gartify-blue flex items-center gap-1">
                  <Mail className="h-3 w-3" />Email <span className="text-red-500">*</span>
                </Label>
                <Input id="email" name="email" type="email" placeholder="tu@email.es" autoComplete="email" required />
              </div>
              <div className="space-y-1.5">
                <Label htmlFor="password" className="text-xs font-semibold text-gartify-blue flex items-center gap-1">
                  <Lock className="h-3 w-3" />Contraseña <span className="text-red-500">*</span>
                </Label>
                <Input id="password" name="password" type="password" placeholder="Mínimo 6 caracteres" autoComplete="new-password" required minLength={6} />
              </div>
              <div className="space-y-1.5">
                <Label htmlFor="reg-phone" className="text-xs font-semibold text-gartify-blue flex items-center gap-1">
                  <Phone className="h-3 w-3" />Teléfono móvil <span className="text-red-500">*</span>
                </Label>
                <PhoneInput
                  id="reg-phone"
                  defaultCountry="ES"
                  value={phone}
                  onChange={(val) => { setPhone(val); if (!val) setWhatsappOptIn(false); }}
                  placeholder="666 666 666"
                  className="phone-input-gartify"
                />
              </div>

              {/* WhatsApp opt-in */}
              <div className={`border p-3 transition-colors ${whatsappOptIn && phone ? "border-green-200 bg-green-50" : "border-gray-200 bg-gray-50"}`}>
                <label className="flex items-start gap-2.5 cursor-pointer">
                  <input type="checkbox" checked={whatsappOptIn} onChange={(e) => setWhatsappOptIn(e.target.checked)} className="mt-0.5 h-4 w-4 border-gray-300 accent-green-600 shrink-0" />
                  <div>
                    <div className="flex items-center gap-1.5 mb-0.5">
                      <MessageCircle className="h-3.5 w-3.5 text-green-600 shrink-0" />
                      <span className="text-xs font-semibold text-gray-800">Recibir avisos por WhatsApp</span>
                    </div>
                    <p className="text-xs text-gray-500 leading-snug">Confirmaciones de reserva y recordatorios directamente en tu WhatsApp.</p>
                  </div>
                </label>
              </div>

              {/* Checks legales */}
              <div className="space-y-2 pt-1">
                <label className="flex items-start gap-2.5 cursor-pointer">
                  <input type="checkbox" checked={acceptLegal} onChange={(e) => setAcceptLegal(e.target.checked)} className="mt-0.5 h-4 w-4 rounded border-gray-300 accent-gartify-blue shrink-0" />
                  <span className="text-xs text-gray-600 leading-relaxed">
                    He leído y acepto los{" "}
                    <Link href="/terminos" target="_blank" className="text-gartify-blue underline hover:no-underline">Términos y condiciones</Link>
                    {" "}y la{" "}
                    <Link href="/privacidad" target="_blank" className="text-gartify-blue underline hover:no-underline">Política de privacidad</Link>
                    . <span className="text-red-500">*</span>
                  </span>
                </label>
                <label className="flex items-start gap-2.5 cursor-pointer">
                  <input type="checkbox" checked={acceptComercial} onChange={(e) => setAcceptComercial(e.target.checked)} className="mt-0.5 h-4 w-4 rounded border-gray-300 accent-gartify-blue shrink-0" />
                  <span className="text-xs text-gray-600 leading-relaxed">Acepto recibir comunicaciones comerciales de Gartify.</span>
                </label>
              </div>

              {error && (
                <div role="alert" className="flex items-center gap-2 bg-red-50 border border-red-100 px-3 py-2 text-sm text-red-600">
                  <AlertCircle className="h-4 w-4 shrink-0" />{error}
                </div>
              )}

              <Button type="submit" className="w-full h-11 bg-gartify-green hover:bg-gartify-green/90 text-white font-semibold gap-2" disabled={loading}>
                {loading ? <><Loader2 className="h-4 w-4 animate-spin" />Creando cuenta...</> : "Crear cuenta gratis"}
              </Button>
            </form>

            <div className="flex items-center justify-between text-sm pt-1">
              <Link href="/registro" className="flex items-center gap-1 text-gartify-gray hover:text-gartify-dark transition-colors text-xs">
                <ArrowLeft className="h-3.5 w-3.5" />Volver
              </Link>
              <p className="text-muted-foreground">
                ¿Ya tienes cuenta?{" "}
                <Link href="/login/conductor" className="text-gartify-orange font-semibold hover:underline">Inicia sesión</Link>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
