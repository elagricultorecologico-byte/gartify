"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import { UserCheck, UserX, Loader2, Link as LinkIcon } from "lucide-react";

// ─── Tipos ────────────────────────────────────────────────────────────────────

type DistribuidorResumen = {
  id: string;
  name: string;
  userId: string | null;
  userName: string | null;
  userEmail: string | null;
};

type UsuarioSinVincular = {
  id: string;
  name: string | null;
  email: string;
};

type Props = {
  distribuidores: DistribuidorResumen[];
  usuariosSinVincular: UsuarioSinVincular[];
};

// ─── Componente ───────────────────────────────────────────────────────────────

export function DistributorUserLinker({ distribuidores, usuariosSinVincular }: Props) {
  const router = useRouter();
  const [cargando, setCargando] = useState<string | null>(null);
  const [error, setError] = useState("");

  // Distribuidores que ya tienen usuario vinculado
  const conCuenta = distribuidores.filter((d) => d.userId !== null);

  async function vincular(distributorId: string, userId: string) {
    setCargando(distributorId);
    setError("");
    const res = await fetch(`/api/admin/distributor/${distributorId}/link-user`, {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ userId }),
    });
    setCargando(null);
    if (res.ok) {
      router.refresh();
    } else {
      const data = await res.json() as { error?: string };
      setError(data.error ?? "Error al vincular usuario");
    }
  }

  async function desvincular(distributorId: string) {
    setCargando(distributorId);
    setError("");
    const res = await fetch(`/api/admin/distributor/${distributorId}/link-user`, {
      method: "DELETE",
    });
    setCargando(null);
    if (res.ok) {
      router.refresh();
    } else {
      const data = await res.json() as { error?: string };
      setError(data.error ?? "Error al desvincular usuario");
    }
  }

  // Distribuidores sin cuenta y con usuarios disponibles para vincular
  const distribuidoresSinCuenta = distribuidores.filter((d) => d.userId === null);
  const hayQueVincular = distribuidoresSinCuenta.length > 0 && usuariosSinVincular.length > 0;

  if (!hayQueVincular && conCuenta.length === 0) return null;

  return (
    <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
      <div className="px-5 py-3 border-b border-gray-100 flex items-center gap-2">
        <UserCheck className="h-4 w-4 text-gartify-blue" />
        <h2 className="text-sm font-bold text-gartify-blue">Cuentas de distribuidor</h2>
      </div>

      <div className="divide-y divide-gray-100">
        {/* Distribuidores con cuenta activa */}
        {conCuenta.map((d) => (
          <div key={d.id} className="flex items-center justify-between gap-4 px-5 py-3">
            <div className="flex-1 min-w-0">
              <p className="text-sm font-semibold text-gray-800">{d.name}</p>
              <p className="text-xs text-green-700 flex items-center gap-1 mt-0.5">
                <UserCheck className="h-3.5 w-3.5" />
                {d.userName ?? d.userEmail} · {d.userEmail}
              </p>
            </div>
            <button
              type="button"
              disabled={cargando === d.id}
              onClick={() => desvincular(d.id)}
              className="flex items-center gap-1.5 text-xs text-red-500 border border-red-200 rounded-lg px-3 py-1.5 hover:bg-red-50 transition disabled:opacity-50"
            >
              {cargando === d.id ? (
                <Loader2 className="h-3.5 w-3.5 animate-spin" />
              ) : (
                <UserX className="h-3.5 w-3.5" />
              )}
              Desvincular
            </button>
          </div>
        ))}

        {/* Formularios de vinculación para distribuidores sin cuenta */}
        {hayQueVincular && distribuidoresSinCuenta.map((d) => (
          <div key={d.id} className="flex items-center gap-4 px-5 py-3 bg-yellow-50/40">
            <div className="flex-1 min-w-0">
              <p className="text-sm font-semibold text-gray-800">{d.name}</p>
              <p className="text-xs text-muted-foreground mt-0.5">Sin cuenta vinculada</p>
            </div>
            <div className="flex items-center gap-2 shrink-0">
              <select
                id={`select-${d.id}`}
                className="text-xs border border-gray-200 rounded-lg px-2 py-1.5 focus:outline-none focus:border-gartify-blue/50 bg-white"
                defaultValue=""
              >
                <option value="" disabled>Seleccionar usuario…</option>
                {usuariosSinVincular.map((u) => (
                  <option key={u.id} value={u.id}>
                    {u.name ?? u.email} · {u.email}
                  </option>
                ))}
              </select>
              <button
                type="button"
                disabled={cargando === d.id}
                onClick={() => {
                  const select = document.getElementById(`select-${d.id}`) as HTMLSelectElement;
                  if (select.value) vincular(d.id, select.value);
                }}
                className="flex items-center gap-1.5 text-xs text-white bg-gartify-blue hover:bg-gartify-blue/90 rounded-lg px-3 py-1.5 transition disabled:opacity-50"
              >
                {cargando === d.id ? (
                  <Loader2 className="h-3.5 w-3.5 animate-spin" />
                ) : (
                  <LinkIcon className="h-3.5 w-3.5" />
                )}
                Vincular
              </button>
            </div>
          </div>
        ))}
      </div>

      {error && (
        <div className="px-5 py-3 border-t border-red-100 bg-red-50 text-xs text-red-600">
          {error}
        </div>
      )}
    </div>
  );
}
