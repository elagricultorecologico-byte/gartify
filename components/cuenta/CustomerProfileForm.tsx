"use client";

import { useState } from "react";
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
  const [name, setName] = useState(user.name ?? "");
  const [phone, setPhone] = useState(user.phone ?? "");
  const [whatsappOptIn, setWhatsappOptIn] = useState(user.whatsappOptIn);
  const [saving, setSaving] = useState(false);
  const [saved, setSaved] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const hasPhone = phone.trim().length > 0;

  // Si se borra el teléfono, desactivamos el opt-in automáticamente
  function handlePhoneChange(val: string) {
    setPhone(val);
    if (!val.trim()) setWhatsappOptIn(false);
  }

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
        phone: phone.trim(),
        whatsappOptIn: hasPhone ? whatsappOptIn : false,
      }),
    });

    setSaving(false);
    if (res.ok) {
      setSaved(true);
      setTimeout(() => setSaved(false), 3000);
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
        <input
          id="cp-phone"
          type="tel"
          value={phone}
          onChange={(e) => handlePhoneChange(e.target.value)}
          className="w-full border border-gray-200 px-4 py-3 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-blue focus:border-transparent transition"
          placeholder="Ej: 612 345 678"
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
