"use client";

import { useState, useEffect } from "react";
import { useRouter } from "next/navigation";
import PhoneInput from "react-phone-number-input";
import type { Country } from "react-phone-number-input";

const TZ_TO_COUNTRY: Record<string, string> = {
  "Europe/Madrid": "ES", "Atlantic/Canary": "ES", "Africa/Ceuta": "ES",
  "Europe/Lisbon": "PT", "Atlantic/Azores": "PT", "Atlantic/Madeira": "PT",
  "America/Mexico_City": "MX", "America/Cancun": "MX", "America/Merida": "MX",
  "America/Bogota": "CO", "America/Lima": "PE", "America/Santiago": "CL",
  "America/Argentina/Buenos_Aires": "AR", "America/Caracas": "VE",
  "America/La_Paz": "BO", "America/Guayaquil": "EC", "America/Asuncion": "PY",
  "America/Montevideo": "UY", "America/Panama": "PA", "America/Costa_Rica": "CR",
  "America/Guatemala": "GT", "America/Tegucigalpa": "HN", "America/Managua": "NI",
  "America/El_Salvador": "SV", "America/Santo_Domingo": "DO", "America/Havana": "CU",
};

const COUNTRY_CALLING_CODE: Record<string, string> = {
  ES: "34", PT: "351", MX: "52", CO: "57", PE: "51", CL: "56",
  AR: "54", VE: "58", BO: "591", EC: "593", PY: "595", UY: "598",
  PA: "507", CR: "506", GT: "502", HN: "504", NI: "505", SV: "503",
  DO: "1", CU: "53",
};
import { Button } from "@/components/ui/button";
import { CheckCircle2, MessageCircle } from "lucide-react";

interface Props {
  user: {
    id: string;
    name: string | null;
    email: string;
    phone: string | null;
    whatsappOptIn: boolean;
  };
}

export function CustomerProfileForm({ user }: Props) {
  const router = useRouter();
  const [name, setName] = useState(user.name ?? "");
  const [phone, setPhone] = useState<string | undefined>(user.phone ?? undefined);
  const [defaultCountry, setDefaultCountry] = useState<Country>("ES");

  useEffect(() => {
    try {
      const tz = Intl.DateTimeFormat().resolvedOptions().timeZone;
      const country = TZ_TO_COUNTRY[tz]
        ?? navigator.language?.split("-")[1]?.toUpperCase()
        ?? "ES";
      setDefaultCountry(country as Country);
      // Normalizar el teléfono a E.164 si no tiene prefijo "+"
      setPhone((prev) => {
        if (!prev || prev.startsWith("+")) return prev;
        const digits = prev.replace(/\D/g, "");
        const callingCode = COUNTRY_CALLING_CODE[country] ?? "34";
        return `+${callingCode}${digits}`;
      });
    } catch { /* mantiene ES */ }
  }, []);
  const [whatsappOptIn, setWhatsappOptIn] = useState(user.whatsappOptIn);
  const [saving, setSaving] = useState(false);
  const [saved, setSaved] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const hasPhone = !!phone && phone.trim().length > 0;

  async function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    setSaving(true);
    setError(null);
    setSaved(false);

    const res = await fetch("/api/cuenta/perfil", {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        name: name.trim(),
        phone: phone ?? "",
        whatsappOptIn: hasPhone ? whatsappOptIn : false,
      }),
    });

    setSaving(false);
    if (res.ok) {
      setSaved(true);
      setTimeout(() => setSaved(false), 3000);
      router.refresh();
    } else {
      setError("No se pudo guardar. Inténtalo de nuevo.");
    }
  }

  return (
    <form onSubmit={handleSubmit} className="space-y-5 bg-white border border-gray-100 p-6">
      {/* Nombre */}
      <div>
        <label htmlFor="cp-name" className="block text-sm font-semibold text-gray-700 mb-1.5">
          Nombre completo
        </label>
        <input
          id="cp-name"
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
          required
          className="w-full border border-gray-200 px-4 py-3 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-blue focus:border-transparent transition"
          placeholder="Tu nombre"
        />
      </div>

      {/* Email (solo lectura) */}
      <div>
        <label className="block text-sm font-semibold text-gray-700 mb-1.5">
          Email
        </label>
        <input
          type="email"
          value={user.email}
          disabled
          className="w-full border border-gray-200 px-4 py-3 text-sm bg-gray-50 text-gray-400 cursor-not-allowed"
        />
        <p className="text-xs text-muted-foreground mt-1">El email no se puede modificar.</p>
      </div>

      {/* Teléfono */}
      <div>
        <label htmlFor="cp-phone" className="block text-sm font-semibold text-gray-700 mb-1.5">
          Teléfono móvil
        </label>
        <PhoneInput
          id="cp-phone"
          defaultCountry={defaultCountry}
          value={phone}
          onChange={(val) => { setPhone(val); if (!val) setWhatsappOptIn(false); }}
          placeholder="666 666 666"
          className="phone-input-gartify"
        />
      </div>

      {/* WhatsApp opt-in */}
      <div className={`border p-4 transition-colors ${hasPhone ? "border-green-200 bg-green-50" : "border-gray-200 bg-gray-50"}`}>
        <label className={`flex items-start gap-3 ${hasPhone ? "cursor-pointer" : "cursor-not-allowed opacity-50"}`}>
          <input
            type="checkbox"
            checked={whatsappOptIn}
            disabled={!hasPhone}
            onChange={(e) => setWhatsappOptIn(e.target.checked)}
            className="mt-0.5 h-4 w-4 border-gray-300 accent-green-600 shrink-0"
          />
          <div className="flex-1">
            <div className="flex items-center gap-1.5 mb-0.5">
              <MessageCircle className="h-4 w-4 text-green-600 shrink-0" aria-hidden="true" />
              <span className="text-sm font-semibold text-gray-800">Notificaciones por WhatsApp</span>
              <span className="text-[10px] font-bold text-green-700 bg-green-100 px-1.5 py-0.5 ml-1">Opcional</span>
            </div>
            <p className="text-xs text-gray-600 leading-relaxed">
              Recibe confirmaciones de reserva, recordatorios y actualizaciones de estado directamente en tu WhatsApp.
            </p>
            {!hasPhone && (
              <p className="text-xs text-amber-600 mt-1 font-medium">
                Añade un teléfono móvil para activar esta opción.
              </p>
            )}
          </div>
        </label>
      </div>

      {error && <p className="text-sm text-red-500">{error}</p>}

      <div className="flex items-center gap-3 pt-1">
        <Button
          type="submit"
          disabled={saving}
          className="bg-gartify-blue hover:bg-gartify-blue/90 text-white"
        >
          {saving ? "Guardando..." : "Guardar cambios"}
        </Button>
        {saved && (
          <span className="flex items-center gap-1.5 text-sm text-green-600 font-medium">
            <CheckCircle2 className="h-4 w-4" />
            Guardado
          </span>
        )}
      </div>
    </form>
  );
}
