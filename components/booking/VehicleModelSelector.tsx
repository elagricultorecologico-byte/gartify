"use client";

import { useState, useEffect, useRef } from "react";
import { ChevronDown, X } from "lucide-react";

type OpcionSelector = { value: string; label: string; img?: string };
type RespuestaAPI = { options: OpcionSelector[]; error?: string };

interface Props {
  value: string;
  onChange: (value: string) => void;
}

const CLASES_SELECT =
  "flex h-9 w-full rounded-md border border-input bg-background px-3 py-1 text-sm " +
  "shadow-sm transition-colors focus-visible:outline-none focus-visible:ring-1 " +
  "focus-visible:ring-ring disabled:cursor-not-allowed disabled:opacity-50";

export function VehicleModelSelector({ onChange }: Props) {
  const [marcas, setMarcas] = useState<OpcionSelector[]>([]);
  const [modelos, setModelos] = useState<OpcionSelector[]>([]);
  const [vehiculos, setVehiculos] = useState<OpcionSelector[]>([]);

  const [marcaId, setMarcaId] = useState("");
  const [modeloId, setModeloId] = useState("");

  const [marcaLabel, setMarcaLabel] = useState("");
  const [marcaImg, setMarcaImg] = useState("");
  const [modeloLabel, setModeloLabel] = useState("");

  const [cargandoMarcas, setCargandoMarcas] = useState(false);
  const [cargandoModelos, setCargandoModelos] = useState(false);
  const [cargandoVehiculos, setCargandoVehiculos] = useState(false);

  // Dropdown de marca
  const [abierto, setAbierto] = useState(false);
  const [busqueda, setBusqueda] = useState("");
  const dropdownRef = useRef<HTMLDivElement>(null);
  const searchRef = useRef<HTMLInputElement>(null);

  // Cerrar al hacer clic fuera
  useEffect(() => {
    function handleClickOutside(e: MouseEvent) {
      if (dropdownRef.current && !dropdownRef.current.contains(e.target as Node)) {
        setAbierto(false);
      }
    }
    document.addEventListener("mousedown", handleClickOutside);
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, []);

  // Foco en búsqueda al abrir
  useEffect(() => {
    if (abierto) setTimeout(() => searchRef.current?.focus(), 50);
  }, [abierto]);

  // Carga marcas al montar
  useEffect(() => {
    async function cargarMarcas() {
      setCargandoMarcas(true);
      try {
        const res = await fetch("/api/vehicle-selector?step=manufacturers");
        const data = await res.json() as RespuestaAPI;
        setMarcas(data.options ?? []);
      } catch {
        setMarcas([]);
      } finally {
        setCargandoMarcas(false);
      }
    }
    void cargarMarcas();
  }, []);

  // Carga modelos al cambiar marca
  useEffect(() => {
    if (!marcaId) { setModelos([]); setModeloId(""); setModeloLabel(""); setVehiculos([]); return; }
    async function cargarModelos() {
      setCargandoModelos(true);
      setModelos([]); setModeloId(""); setModeloLabel(""); setVehiculos([]);
      try {
        const res = await fetch(`/api/vehicle-selector?step=models&makeId=${marcaId}`);
        const data = await res.json() as RespuestaAPI;
        setModelos(data.options ?? []);
      } catch { setModelos([]); }
      finally { setCargandoModelos(false); }
    }
    void cargarModelos();
  }, [marcaId]);

  // Carga vehículos al cambiar modelo
  useEffect(() => {
    if (!marcaId || !modeloId) { setVehiculos([]); return; }
    async function cargarVehiculos() {
      setCargandoVehiculos(true);
      setVehiculos([]);
      try {
        const res = await fetch(`/api/vehicle-selector?step=versions&modelId=${modeloId}`);
        const data = await res.json() as RespuestaAPI;
        setVehiculos(data.options ?? []);
      } catch { setVehiculos([]); }
      finally { setCargandoVehiculos(false); }
    }
    void cargarVehiculos();
  }, [marcaId, modeloId]);

  function seleccionarMarca(m: OpcionSelector) {
    setMarcaId(m.value);
    setMarcaLabel(m.label);
    setMarcaImg(m.img ?? "");
    setAbierto(false);
    setBusqueda("");
    onChange("");
  }

  function limpiarMarca() {
    setMarcaId(""); setMarcaLabel(""); setMarcaImg("");
    setModelos([]); setModeloId(""); setModeloLabel("");
    setVehiculos([]);
    onChange("");
  }

  function handleModeloChange(e: React.ChangeEvent<HTMLSelectElement>) {
    const id = e.target.value;
    const label = modelos.find((m) => m.value === id)?.label ?? "";
    setModeloId(id);
    setModeloLabel(label);
    onChange("");
  }

  function handleVehiculoChange(e: React.ChangeEvent<HTMLSelectElement>) {
    const vehiculoLabel = vehiculos.find((v) => v.value === e.target.value)?.label ?? "";
    if (!vehiculoLabel) { onChange(""); return; }
    const valorFinal = `${marcaLabel} ${modeloLabel} ${vehiculoLabel}`.replace(/\s+/g, " ").trim();
    onChange(valorFinal);
  }

  const marcasFiltradas = busqueda
    ? marcas.filter((m) => m.label.toLowerCase().startsWith(busqueda.toLowerCase()))
    : marcas;

  return (
    <div className="space-y-2">
      {/* ── Selector de Marca (combobox con logo y filtro por texto) ── */}
      <div className="relative" ref={dropdownRef}>
        {/* Trigger combobox */}
        <div className={`${CLASES_SELECT} flex items-center gap-2 pr-2`}>
          {/* Logo de la marca seleccionada */}
          {marcaImg && !abierto && (
            // eslint-disable-next-line @next/next/no-img-element
            <img src={marcaImg} alt={marcaLabel} width={28} height={28} className="shrink-0 object-contain" />
          )}
          {/* Input que actúa como trigger y buscador a la vez */}
          <input
            ref={searchRef}
            type="text"
            value={abierto ? busqueda : marcaLabel}
            placeholder={cargandoMarcas ? "Cargando..." : "Marca"}
            disabled={cargandoMarcas}
            onChange={(e) => {
              setBusqueda(e.target.value);
              setAbierto(true);
            }}
            onFocus={() => {
              setBusqueda("");
              setAbierto(true);
            }}
            className="flex-1 min-w-0 bg-transparent outline-none text-sm placeholder:text-muted-foreground"
          />
          {/* Botón limpiar / chevron */}
          <span className="flex items-center gap-1 shrink-0">
            {marcaId && (
              <span
                role="button"
                tabIndex={0}
                onMouseDown={(e) => { e.preventDefault(); limpiarMarca(); }}
                className="p-0.5 rounded hover:bg-gray-100 text-muted-foreground hover:text-foreground"
                aria-label="Limpiar marca"
              >
                <X className="h-3 w-3" />
              </span>
            )}
            <ChevronDown className={`h-4 w-4 text-muted-foreground transition-transform ${abierto ? "rotate-180" : ""}`} />
          </span>
        </div>

        {/* Dropdown con resultados */}
        {abierto && (
          <div className="absolute z-50 mt-1 w-full bg-white border border-input rounded-md shadow-lg overflow-hidden">
            <ul className="max-h-56 overflow-y-auto py-1" role="listbox">
              {marcasFiltradas.length === 0 ? (
                <li className="px-3 py-2 text-sm text-muted-foreground">Sin resultados</li>
              ) : (
                marcasFiltradas.map((m) => (
                  <li
                    key={m.value}
                    role="option"
                    aria-selected={m.value === marcaId}
                    onMouseDown={(e) => { e.preventDefault(); seleccionarMarca(m); }}
                    className={`flex items-center gap-2.5 px-3 py-1.5 text-sm cursor-pointer hover:bg-gray-50 ${
                      m.value === marcaId ? "bg-blue-50 text-gartify-blue font-medium" : ""
                    }`}
                  >
                    {m.img && (
                      // eslint-disable-next-line @next/next/no-img-element
                      <img src={m.img} alt={m.label} width={32} height={32} className="object-contain shrink-0" />
                    )}
                    {m.label}
                  </li>
                ))
              )}
            </ul>
          </div>
        )}
      </div>

      {/* ── Selector de Modelo ── */}
      <select
        className={CLASES_SELECT}
        value={modeloId}
        onChange={handleModeloChange}
        disabled={!marcaId || cargandoModelos}
      >
        <option value="">
          {!marcaId ? "Modelo" : cargandoModelos ? "Cargando..." : modelos.length === 0 ? "Sin modelos" : "Modelo"}
        </option>
        {modelos.map((m) => (
          <option key={m.value} value={m.value}>{m.label}</option>
        ))}
      </select>

      {/* ── Selector de Vehículo ── */}
      <select
        className={CLASES_SELECT}
        defaultValue=""
        onChange={handleVehiculoChange}
        disabled={!modeloId || cargandoVehiculos}
      >
        <option value="">
          {!modeloId ? "Vehículo" : cargandoVehiculos ? "Cargando..." : vehiculos.length === 0 ? "Sin versiones" : "Vehículo"}
        </option>
        {vehiculos.map((v) => (
          <option key={v.value} value={v.value}>{v.label}</option>
        ))}
      </select>
    </div>
  );
}
