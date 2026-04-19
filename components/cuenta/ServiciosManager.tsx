"use client";
import { useState, useRef } from "react";
import { useRouter } from "next/navigation";
import { Clock, Lock, ToggleLeft, ToggleRight, Trash2, Check, X, ChevronLeft, ChevronRight, Wrench, Plus, List } from "lucide-react";
import { ServiceForm } from "@/components/cuenta/ServiceForm";
import { SERVICE_LABELS, VEHICLE_ICONS, VEHICLE_LABELS, VEHICLE_TYPES, type VehicleType } from "@/lib/utils";

const ANCHOR_TYPES = new Set(["REVISION", "PRE_ITV", "CLIMATIZACION"]);
const PAGE_SIZE = 7;

type ServiceItem = {
  id:           string;
  type:         string;
  name:         string | null;
  description:  string | null;
  price:        number;
  duration:     number;
  isActive:     boolean;
  vehicleTypes: string;
};

function parsearTipos(raw: string): VehicleType[] {
  try {
    const arr = JSON.parse(raw) as string[];
    return arr.filter((v): v is VehicleType => (VEHICLE_TYPES as readonly string[]).includes(v));
  } catch { return ["COCHE"]; }
}

function formatEur(n: number) {
  return new Intl.NumberFormat("es-ES", { style: "currency", currency: "EUR", minimumFractionDigits: 0, maximumFractionDigits: 0 }).format(n);
}

// ── Precio editable inline ────────────────────────────────────────────────────

function PriceCell({ serviceId, price, onUpdated }: { serviceId: string; price: number; onUpdated: (id: string, price: number) => void }) {
  const [editing, setEditing] = useState(false);
  const [val, setVal] = useState(String(price));
  const [saving, setSaving] = useState(false);
  const inputRef = useRef<HTMLInputElement>(null);

  function startEdit() { setVal(String(price)); setEditing(true); setTimeout(() => inputRef.current?.select(), 0); }

  async function save() {
    const n = parseFloat(val);
    if (!n || n <= 0 || n === price) { setEditing(false); return; }
    setSaving(true);
    const res = await fetch(`/api/garage/services/${serviceId}`, {
      method: "PATCH", headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ price: n }),
    });
    setSaving(false);
    if (res.ok) onUpdated(serviceId, n);
    setEditing(false);
  }

  if (editing) {
    return (
      <div className="flex items-center gap-1">
        <input
          ref={inputRef} type="number" min="1" step="1" value={val}
          onChange={e => setVal(e.target.value)}
          onKeyDown={e => { if (e.key === "Enter") save(); if (e.key === "Escape") setEditing(false); }}
          className="w-16 rounded border border-gartify-orange px-1.5 py-0.5 text-sm font-bold text-gartify-orange text-right focus:outline-none"
          disabled={saving}
        />
        <button onClick={save} disabled={saving} className="text-green-600 hover:text-green-700" aria-label="Guardar"><Check className="h-3 w-3" /></button>
        <button onClick={() => setEditing(false)} className="text-gray-400 hover:text-gray-600" aria-label="Cancelar"><X className="h-3 w-3" /></button>
      </div>
    );
  }

  return (
    <button onClick={startEdit} title="Clic para editar" className="text-base font-bold text-gartify-orange hover:underline underline-offset-2 decoration-dotted tabular-nums w-16 text-right">
      {formatEur(price)}
    </button>
  );
}

// ── Fila de servicio ──────────────────────────────────────────────────────────

// Ancho fijo para la columna de tipo badge: todos los nombres quedan alineados
const BADGE_W = "w-28 shrink-0";

function ServiceRow({ s, onUpdated, onToggle, onDelete }: {
  s: ServiceItem;
  onUpdated: (id: string, price: number) => void;
  onToggle: (id: string, active: boolean) => void;
  onDelete: (id: string) => void;
}) {
  const tipos = parsearTipos(s.vehicleTypes);
  const isAnchor = ANCHOR_TYPES.has(s.type);

  return (
    <div className={`flex items-center gap-2 px-2.5 py-2 border transition-all ${
      s.isActive
        ? isAnchor ? "bg-orange-50/50 border-gartify-orange/25" : "bg-white border-gray-100 hover:border-gartify-blue/20"
        : "bg-gray-50 border-gray-100 opacity-50"
    }`}>
      {/* Tipo — ancho fijo para alinear nombres */}
      <div className={`${BADGE_W} flex items-center gap-1`}>
        <span className="text-[10px] font-bold uppercase tracking-wide text-gartify-blue bg-blue-50 border border-blue-100 px-1.5 py-0.5 leading-tight truncate">
          {SERVICE_LABELS[s.type] ?? s.type}
        </span>
        {isAnchor && (
          <span title="Precio cerrado">
            <Lock className="h-3 w-3 text-gartify-orange shrink-0" />
          </span>
        )}
      </div>

      {/* Nombre */}
      <p className="flex-1 text-sm font-semibold text-gartify-dark truncate min-w-0">{s.name}</p>

      {/* Duración */}
      <div className="hidden sm:flex items-center justify-center w-16 shrink-0">
        <span className="flex items-center gap-0.5 text-[11px] text-muted-foreground tabular-nums">
          <Clock className="h-3 w-3" />{s.duration}m
        </span>
      </div>

      {/* Vehículos */}
      <div className="hidden sm:flex items-center justify-center w-16 shrink-0">
        <span className="flex gap-0.5">
          {tipos.slice(0, 3).map(t => (
            <span key={t} title={VEHICLE_LABELS[t]} className="text-xs leading-none">{VEHICLE_ICONS[t]}</span>
          ))}
          {tipos.length > 3 && <span className="text-[10px] text-muted-foreground">+{tipos.length - 3}</span>}
        </span>
      </div>

      {/* Precio editable */}
      <PriceCell serviceId={s.id} price={s.price} onUpdated={onUpdated} />

      {/* Acciones */}
      <div className="flex items-center gap-0.5 shrink-0">
        <button onClick={() => onToggle(s.id, !s.isActive)} title={s.isActive ? "Desactivar" : "Activar"} className="text-gray-300 hover:text-gartify-blue transition-colors p-0.5">
          {s.isActive ? <ToggleRight className="h-4 w-4 text-gartify-blue" /> : <ToggleLeft className="h-4 w-4" />}
        </button>
        <button onClick={() => onDelete(s.id)} title="Eliminar" className="text-gray-200 hover:text-red-400 transition-colors p-0.5">
          <Trash2 className="h-3.5 w-3.5" />
        </button>
      </div>
    </div>
  );
}

// ── Componente principal ──────────────────────────────────────────────────────

export function ServiciosManager({ garageId, initialServices }: { garageId: string; initialServices: ServiceItem[] }) {
  const router = useRouter();
  const [services, setServices] = useState<ServiceItem[]>(initialServices);
  const [page, setPage] = useState(0);

  // Lista unificada: primero activos, luego inactivos; dentro de cada grupo primero anchors
  const sorted = [
    ...services.filter(s => s.isActive && ANCHOR_TYPES.has(s.type)),
    ...services.filter(s => s.isActive && !ANCHOR_TYPES.has(s.type)),
    ...services.filter(s => !s.isActive),
  ];

  const totalPages = Math.ceil(sorted.length / PAGE_SIZE);
  const paginated = sorted.slice(page * PAGE_SIZE, (page + 1) * PAGE_SIZE);

  function handleUpdated(id: string, price: number) {
    setServices(prev => prev.map(s => s.id === id ? { ...s, price } : s));
  }

  async function handleToggle(id: string, active: boolean) {
    setServices(prev => prev.map(s => s.id === id ? { ...s, isActive: active } : s));
    await fetch(`/api/garage/services/${id}`, {
      method: "PATCH", headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ isActive: active }),
    });
  }

  async function handleDelete(id: string) {
    if (!confirm("¿Eliminar este servicio?")) return;
    setServices(prev => prev.filter(s => s.id !== id));
    // Ajustar página si la actual queda vacía
    setPage(p => {
      const newTotal = Math.ceil((services.length - 1) / PAGE_SIZE);
      return Math.min(p, Math.max(0, newTotal - 1));
    });
    await fetch(`/api/garage/services/${id}`, { method: "DELETE" });
  }

  function handleAdded() { router.refresh(); }

  const rowProps = { onUpdated: handleUpdated, onToggle: handleToggle, onDelete: handleDelete };

  // Tab para móvil
  const [mobileTab, setMobileTab] = useState<"lista" | "añadir">("lista");

  const Lista = (
    <div className="flex flex-col h-full">
      {/* Paginación */}
      <div className="shrink-0 pb-2 flex items-center justify-between">
        <span className="text-xs text-muted-foreground">{sorted.length} servicio{sorted.length !== 1 ? "s" : ""}</span>
        {totalPages > 1 && (
          <div className="flex items-center gap-1">
            <button onClick={() => setPage(p => Math.max(0, p - 1))} disabled={page === 0} className="p-1 rounded hover:bg-gray-100 disabled:opacity-30 transition-colors" aria-label="Anterior">
              <ChevronLeft className="h-4 w-4" />
            </button>
            {Array.from({ length: totalPages }, (_, i) => (
              <button key={i} onClick={() => setPage(i)} className={`h-6 w-6 rounded text-xs font-semibold transition-colors ${i === page ? "bg-gartify-blue text-white" : "hover:bg-gray-100 text-muted-foreground"}`}>
                {i + 1}
              </button>
            ))}
            <button onClick={() => setPage(p => Math.min(totalPages - 1, p + 1))} disabled={page === totalPages - 1} className="p-1 rounded hover:bg-gray-100 disabled:opacity-30 transition-colors" aria-label="Siguiente">
              <ChevronRight className="h-4 w-4" />
            </button>
          </div>
        )}
      </div>

      {/* Cabecera */}
      <div className="flex items-center gap-2 px-2.5 py-1.5 text-[10px] font-bold uppercase tracking-widest text-muted-foreground border-b border-gray-100 mb-1 shrink-0">
        <div className={BADGE_W}>Tipo</div>
        <div className="flex-1">Servicio</div>
        <div className="hidden sm:block w-16 text-center">Duración</div>
        <div className="hidden sm:block w-16 text-center">Vehículo</div>
        <div className="w-16 text-right">Precio</div>
        <div className="w-12" />
      </div>

      {/* Filas */}
      <div className="flex-1 space-y-1">
        {paginated.length > 0
          ? paginated.map(s => <ServiceRow key={s.id} s={s} {...rowProps} />)
          : (
            <div className="flex flex-col items-center justify-center pt-16 text-muted-foreground">
              <Wrench className="h-8 w-8 mb-2 opacity-30" />
              <p className="text-sm">Sin servicios todavía</p>
            </div>
          )
        }
      </div>
    </div>
  );

  const Formulario = (
    <div className="bg-white border border-gray-200 p-4">
      <h2 className="font-bold text-gartify-blue mb-3 text-sm flex items-center gap-2">
        <Wrench className="h-4 w-4 text-gartify-orange" />
        Añadir servicio
      </h2>
      <ServiceForm garageId={garageId} onAdded={handleAdded} />
    </div>
  );

  return (
    <>
      {/* ── Móvil: tabs ── */}
      <div className="md:hidden">
        <div className="flex gap-2 mb-4">
          <button
            onClick={() => setMobileTab("lista")}
            className={`flex-1 flex items-center justify-center gap-2 py-2 border text-sm font-semibold transition-colors ${mobileTab === "lista" ? "bg-gartify-blue text-white border-gartify-blue" : "bg-white text-gartify-gray border-gray-200"}`}
          >
            <List className="h-4 w-4" />Servicios
          </button>
          <button
            onClick={() => setMobileTab("añadir")}
            className={`flex-1 flex items-center justify-center gap-2 py-2 border text-sm font-semibold transition-colors ${mobileTab === "añadir" ? "bg-gartify-blue text-white border-gartify-blue" : "bg-white text-gartify-gray border-gray-200"}`}
          >
            <Plus className="h-4 w-4" />Añadir
          </button>
        </div>
        {mobileTab === "lista" ? Lista : Formulario}
      </div>

      {/* ── Desktop: dos columnas ── */}
      <div className="hidden md:grid md:grid-cols-[300px_1fr] gap-5" style={{ height: "calc(100vh - 10rem)" }}>
        <div className="overflow-y-auto">{Formulario}</div>
        {Lista}
      </div>
    </>
  );
}
