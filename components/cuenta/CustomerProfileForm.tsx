"use client";

import { useState } from "react";
import { Button } from "@/components/ui/button";
import { CheckCircle2 } from "lucide-react";

interface Props {
  user: { id: string; name: string | null; email: string; phone: string | null };
}

export function CustomerProfileForm({ user }: Props) {
  const [name, setName] = useState(user.name ?? "");
  const [phone, setPhone] = useState(user.phone ?? "");
  const [saving, setSaving] = useState(false);
  const [saved, setSaved] = useState(false);
  const [error, setError] = useState<string | null>(null);

  async function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    setSaving(true);
    setError(null);
    setSaved(false);

    const res = await fetch("/api/cuenta/perfil", {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name: name.trim(), phone: phone.trim() }),
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
    <form onSubmit={handleSubmit} className="space-y-5 bg-white rounded-2xl border border-gray-100 shadow-sm p-6">
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
          className="w-full rounded-xl border border-gray-200 px-4 py-3 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-blue focus:border-transparent transition"
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
          className="w-full rounded-xl border border-gray-200 px-4 py-3 text-sm bg-gray-50 text-gray-400 cursor-not-allowed"
        />
        <p className="text-xs text-muted-foreground mt-1">El email no se puede modificar.</p>
      </div>

      {/* Teléfono */}
      <div>
        <label htmlFor="cp-phone" className="block text-sm font-semibold text-gray-700 mb-1.5">
          Teléfono
        </label>
        <input
          id="cp-phone"
          type="tel"
          value={phone}
          onChange={(e) => setPhone(e.target.value)}
          className="w-full rounded-xl border border-gray-200 px-4 py-3 text-sm focus:outline-none focus:ring-2 focus:ring-gartify-blue focus:border-transparent transition"
          placeholder="Ej: 612 345 678"
        />
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
