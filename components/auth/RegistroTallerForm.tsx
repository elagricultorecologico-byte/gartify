"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import { signIn } from "next-auth/react";
import Link from "next/link";
import {
  Wrench, AlertCircle, Loader2, ArrowLeft,
  User, Building2, MapPin, Lock, Car, Euro, Tag, X, ChevronRight, MessageCircle,
} from "lucide-react";
import PhoneInput, { isValidPhoneNumber } from "react-phone-number-input";
import { VEHICLE_TYPES, VEHICLE_LABELS, VEHICLE_ICONS } from "@/lib/utils";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Textarea } from "@/components/ui/textarea";

export function RegistroTallerForm() {
  const router = useRouter();
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);
  const [vehicleTypes, setVehicleTypes] = useState<string[]>(["COCHE"]);
  const [excludedBrands, setExcludedBrands] = useState<string[]>([]);
  const [brandInput, setBrandInput] = useState("");
  const [acceptLegal, setAcceptLegal] = useState(false);
  const [acceptComercial, setAcceptComercial] = useState(false);
  const [phone, setPhone] = useState<string | undefined>(undefined);
  const [whatsappOptIn, setWhatsappOptIn] = useState(false);

  function addBrand(brand: string) {
    const b = brand.trim();
    if (b && !excludedBrands.includes(b.toUpperCase())) setExcludedBrands(prev => [...prev, b.toUpperCase()]);
    setBrandInput("");
  }
  function removeBrand(brand: string) { setExcludedBrands(prev => prev.filter(b => b !== brand)); }
  function toggleVehicle(type: string) {
    setVehicleTypes(prev => prev.includes(type) ? prev.length > 1 ? prev.filter(t => t !== type) : prev : [...prev, type]);
  }

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setError("");
    const fd = new FormData(e.currentTarget);
    const ownerName = (fd.get("ownerName") as string ?? "").trim();
    const email = (fd.get("email") as string ?? "").trim();
    const password = (fd.get("password") as string) ?? "";
    const garageName = (fd.get("garageName") as string ?? "").trim();
    const address = (fd.get("address") as string ?? "").trim();
    const city = (fd.get("city") as string ?? "").trim();
    const postalCode = (fd.get("postalCode") as string ?? "").trim();

    if (!ownerName) return setError("El nombre del responsable es obligatorio");
    if (!garageName) return setError("El nombre del taller es obligatorio");
    if (!address) return setError("La dirección es obligatoria");
    if (!city) return setError("La ciudad es obligatoria");
    if (!postalCode || !/^\d{5}$/.test(postalCode)) return setError("Introduce un código postal válido (5 dígitos)");
    if (!email || !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email)) return setError("Introduce un email válido");
    if (password.length < 6) return setError("La contraseña debe tener al menos 6 caracteres");
    if (!phone || !isValidPhoneNumber(phone)) return setError("Introduce un teléfono móvil válido");
    if (vehicleTypes.length === 0) return setError("Selecciona al menos un tipo de vehículo");
    if (!acceptLegal) return setError("Debes aceptar los Términos y la Política de privacidad");

    setLoading(true);
    const laborRateRaw = (fd.get("laborRate") as string ?? "").trim();
    const body = {
      ownerName, email, password,
      phone,
      whatsappOptIn,
      garageName, address, city, postalCode,
      description: fd.get("description"),
      vehicleTypes,
      ...(laborRateRaw && { laborRate: parseFloat(laborRateRaw) }),
      anchorPrices: {
        revisionBasica: parseFloat((fd.get("anchorRevision") as string) ?? "") || undefined,
        preItv: parseFloat((fd.get("anchorPreItv") as string) ?? "") || undefined,
        aireAcondicionado: parseFloat((fd.get("anchorAire") as string) ?? "") || undefined,
      },
      ...(excludedBrands.length > 0 && { excludedBrands }),
    };

    const res = await fetch("/api/garage/register", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
    });
    const data = await res.json() as { error?: string };
    if (!res.ok) { setError(data.error ?? "Error al registrar el taller"); setLoading(false); return; }
    await signIn("credentials", { email, password, redirect: false });
    router.push("/cuenta/taller");
    router.refresh();
  }

  return (
    <div className="min-h-[calc(100vh-4rem)] flex items-center justify-center py-12 px-4 bg-blue-50">
      <div className="w-full max-w-lg">
        <div className="bg-white border border-gray-200 overflow-hidden">

          <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
            <div className="flex items-center gap-3">
              <div className="flex h-10 w-10 items-center justify-center bg-gartify-orange/10 border border-gartify-orange/20 shrink-0">
                <Wrench className="h-5 w-5 text-gartify-orange" aria-hidden="true" />
              </div>
              <div>
                <h1 className="text-base font-bold text-gartify-blue">Registrar mi taller</h1>
                <p className="text-xs text-gartify-gray mt-0.5">Empieza a recibir reservas gratis</p>
              </div>
            </div>
          </div>

          <div className="p-6">
            <form onSubmit={handleSubmit} className="space-y-4" noValidate>

              {/* Responsable */}
              <div>
                <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3 flex items-center gap-1.5">
                  <User className="h-3.5 w-3.5" />Responsable
                </p>
                <div className="grid grid-cols-2 gap-3">
                  <div className="space-y-1.5">
                    <Label htmlFor="ownerName" className="text-xs font-semibold text-gartify-blue">Tu nombre</Label>
                    <Input id="ownerName" name="ownerName" placeholder="Carlos Martínez" autoComplete="name" required />
                  </div>
                  <div className="space-y-1.5">
                    <Label htmlFor="tphone" className="text-xs font-semibold text-gartify-blue">Teléfono móvil <span className="text-red-500">*</span></Label>
                    <PhoneInput
                      id="tphone"
                      defaultCountry="ES"
                      value={phone}
                      onChange={(val) => { setPhone(val); if (!val) setWhatsappOptIn(false); }}
                      placeholder="666 666 666"
                      className="phone-input-gartify"
                    />
                  </div>
                </div>
              </div>

              {/* WhatsApp opt-in */}
              <label className={`flex items-center gap-2.5 cursor-pointer border p-3 transition-colors ${whatsappOptIn && phone ? "border-green-200 bg-green-50" : "border-gray-200 bg-gray-50"}`}>
                <input type="checkbox" checked={whatsappOptIn} onChange={(e) => setWhatsappOptIn(e.target.checked)} className="h-4 w-4 border-gray-300 accent-green-600 shrink-0" />
                <MessageCircle className="h-4 w-4 text-green-600 shrink-0" />
                <span className="text-xs text-gray-700 leading-snug">Recibir avisos por WhatsApp — Confirmaciones de reserva y recordatorios directamente en tu WhatsApp.</span>
              </label>

              {/* Datos del taller */}
              <div className="pt-2">
                <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3 flex items-center gap-1.5">
                  <Building2 className="h-3.5 w-3.5" />Datos del taller
                </p>
                <div className="space-y-3">
                  <div className="space-y-1.5">
                    <Label htmlFor="garageName" className="text-xs font-semibold text-gartify-blue">Nombre del taller</Label>
                    <Input id="garageName" name="garageName" placeholder="Taller Martínez Auto" required />
                  </div>
                  <div className="grid grid-cols-3 gap-3">
                    <div className="col-span-2 space-y-1.5">
                      <Label htmlFor="address" className="text-xs font-semibold text-gartify-blue flex items-center gap-1">
                        <MapPin className="h-3 w-3" />Dirección
                      </Label>
                      <Input id="address" name="address" placeholder="Calle Alcalá, 142" autoComplete="street-address" required />
                    </div>
                    <div className="space-y-1.5">
                      <Label htmlFor="postalCode" className="text-xs font-semibold text-gartify-blue">C.P.</Label>
                      <Input id="postalCode" name="postalCode" placeholder="28009" autoComplete="postal-code" required maxLength={5} />
                    </div>
                  </div>
                  <div className="space-y-1.5">
                    <Label htmlFor="city" className="text-xs font-semibold text-gartify-blue">Ciudad</Label>
                    <Input id="city" name="city" placeholder="Madrid" autoComplete="address-level2" required />
                  </div>
                  <div className="space-y-1.5">
                    <Label htmlFor="description" className="text-xs font-semibold text-gartify-blue">
                      Descripción <span className="font-normal text-gartify-gray">(opcional)</span>
                    </Label>
                    <Textarea id="description" name="description" placeholder="Especialistas en ITV, revisiones, frenos..." rows={2} />
                  </div>
                </div>
              </div>

              {/* Tipos de vehículo */}
              <div className="pt-2">
                <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3 flex items-center gap-1.5">
                  <Car className="h-3.5 w-3.5" />Vehículos que admite
                </p>
                <div className="grid grid-cols-3 gap-2">
                  {VEHICLE_TYPES.map(type => {
                    const active = vehicleTypes.includes(type);
                    return (
                      <button key={type} type="button" onClick={() => toggleVehicle(type)}
                        className={`flex items-center gap-2 px-3 py-2 rounded-none border text-xs font-medium transition-all ${active ? "border-gartify-blue bg-blue-50 text-gartify-blue" : "border-gray-200 bg-white text-gartify-gray hover:border-gartify-blue/40"}`}>
                        <span aria-hidden="true">{VEHICLE_ICONS[type]}</span>
                        {VEHICLE_LABELS[type]}
                      </button>
                    );
                  })}
                </div>
              </div>

              {/* Precios */}
              <div className="pt-2">
                <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3 flex items-center gap-1.5">
                  <Euro className="h-3.5 w-3.5" />Precios orientativos <span className="font-normal normal-case tracking-normal">(opcional)</span>
                </p>
                <div className="space-y-3">
                  <div className="space-y-1.5">
                    <Label htmlFor="laborRate" className="text-xs font-semibold text-gartify-blue">Mano de obra <span className="font-normal text-gartify-gray">(€/hora)</span></Label>
                    <Input id="laborRate" name="laborRate" type="number" min="0" step="1" placeholder="Ej: 45" />
                  </div>
                  <p className="text-xs text-gartify-gray font-medium">Servicios gancho (precio cerrado):</p>
                  <div className="grid grid-cols-3 gap-2">
                    <div className="space-y-1.5">
                      <Label htmlFor="anchorRevision" className="text-[11px] font-semibold text-gartify-blue leading-tight">Revisión básica</Label>
                      <Input id="anchorRevision" name="anchorRevision" type="number" min="0" step="1" placeholder="€" />
                    </div>
                    <div className="space-y-1.5">
                      <Label htmlFor="anchorPreItv" className="text-[11px] font-semibold text-gartify-blue leading-tight">Pre-ITV</Label>
                      <Input id="anchorPreItv" name="anchorPreItv" type="number" min="0" step="1" placeholder="€" />
                    </div>
                    <div className="space-y-1.5">
                      <Label htmlFor="anchorAire" className="text-[11px] font-semibold text-gartify-blue leading-tight">Aire acond.</Label>
                      <Input id="anchorAire" name="anchorAire" type="number" min="0" step="1" placeholder="€" />
                    </div>
                  </div>
                </div>
              </div>

              {/* Marcas excluidas */}
              <div className="pt-2">
                <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3 flex items-center gap-1.5">
                  <Tag className="h-3.5 w-3.5" />Marcas con las que NO trabajas <span className="font-normal normal-case tracking-normal">(opcional)</span>
                </p>
                <div className="space-y-2">
                  <div className="flex gap-2">
                    <Input value={brandInput} onChange={e => setBrandInput(e.target.value)}
                      onKeyDown={e => { if (e.key === "Enter") { e.preventDefault(); addBrand(brandInput); } }}
                      placeholder="Ej: BMW, Lamborghini…" className="flex-1" />
                    <Button type="button" variant="outline" size="sm" onClick={() => addBrand(brandInput)} className="shrink-0">Añadir</Button>
                  </div>
                  {excludedBrands.length > 0 && (
                    <div className="flex flex-wrap gap-1.5">
                      {excludedBrands.map(b => (
                        <span key={b} className="inline-flex items-center gap-1 px-2 py-0.5 bg-red-50 border border-red-200 text-xs font-medium text-red-700">
                          {b}
                          <button type="button" onClick={() => removeBrand(b)} className="hover:text-red-900" aria-label={`Eliminar ${b}`}>
                            <X className="h-3 w-3" />
                          </button>
                        </span>
                      ))}
                    </div>
                  )}
                </div>
              </div>

              {/* Acceso */}
              <div className="pt-2">
                <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3 flex items-center gap-1.5">
                  <Lock className="h-3.5 w-3.5" />Acceso
                </p>
                <div className="space-y-3">
                  <div className="space-y-1.5">
                    <Label htmlFor="temail" className="text-xs font-semibold text-gartify-blue">Email</Label>
                    <Input id="temail" name="email" type="email" placeholder="taller@email.es" autoComplete="email" required />
                  </div>
                  <div className="space-y-1.5">
                    <Label htmlFor="tpassword" className="text-xs font-semibold text-gartify-blue">Contraseña</Label>
                    <Input id="tpassword" name="password" type="password" placeholder="Mínimo 6 caracteres" autoComplete="new-password" required minLength={6} />
                  </div>
                </div>
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

              <Button type="submit" className="w-full h-11 bg-gartify-orange hover:bg-orange-600 text-white font-bold gap-2" disabled={loading}>
                {loading ? <><Loader2 className="h-4 w-4 animate-spin" />Registrando taller...</> : <><ChevronRight className="h-4 w-4" />Registrar mi taller gratis</>}
              </Button>
            </form>

            <div className="flex items-center justify-between text-sm pt-4">
              <Link href="/registro" className="flex items-center gap-1 text-gartify-gray hover:text-gartify-dark transition-colors text-xs">
                <ArrowLeft className="h-3.5 w-3.5" />Volver
              </Link>
              <p className="text-muted-foreground">
                ¿Ya tienes cuenta?{" "}
                <Link href="/login/taller" className="text-gartify-orange font-semibold hover:underline">Inicia sesión</Link>
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
