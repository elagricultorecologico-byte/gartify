"use client";

import { useState } from "react";
import { Bell, BellOff } from "lucide-react";

interface Props {
  vehicleId: string;
  initialValue: boolean;
}

export function ItvReminderToggle({ vehicleId, initialValue }: Props) {
  const [enabled, setEnabled] = useState(initialValue);
  const [saving, setSaving] = useState(false);

  async function toggle() {
    const next = !enabled;
    setSaving(true);
    setEnabled(next); // optimistic

    const res = await fetch(`/api/vehicles/${vehicleId}`, {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ itvReminder: next }),
    });

    setSaving(false);
    if (!res.ok) setEnabled(!next); // revert on error
  }

  return (
    <div className="flex items-center justify-between bg-white border border-gray-200 px-4 py-3">
      <div className="flex items-center gap-3">
        {enabled
          ? <Bell className="h-4 w-4 text-gartify-orange" />
          : <BellOff className="h-4 w-4 text-gray-400" />
        }
        <div>
          <p className="text-sm font-semibold text-foreground">
            Recordatorio de ITV
          </p>
          <p className="text-xs text-muted-foreground">
            {enabled
              ? "Te avisaremos 30 y 7 días antes por email"
              : "Actívalo para recibir aviso antes de la fecha límite"}
          </p>
        </div>
      </div>

      <button
        type="button"
        role="switch"
        aria-checked={enabled}
        disabled={saving}
        onClick={toggle}
        className={`relative inline-flex h-6 w-11 shrink-0 cursor-pointer rounded-full border-2 border-transparent transition-colors focus:outline-none focus:ring-2 focus:ring-gartify-orange focus:ring-offset-2 disabled:opacity-50 ${
          enabled ? "bg-gartify-orange" : "bg-gray-200"
        }`}
      >
        <span
          className={`pointer-events-none inline-block h-5 w-5 rounded-full bg-white shadow-sm transition-transform ${
            enabled ? "translate-x-5" : "translate-x-0"
          }`}
        />
      </button>
    </div>
  );
}
