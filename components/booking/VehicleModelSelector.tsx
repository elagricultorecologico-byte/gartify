"use client";

import { useState, useEffect } from "react";

type OpcionSelector = { value: string; label: string };

type RespuestaAPI = { options: OpcionSelector[]; error?: string };

interface Props {
  /** Valor actual del campo (string legible ya compuesto o vacío) */
  value: string;
  /** Callback que recibe el string legible al completar la selección */
  onChange: (value: string) => void;
}

// Clases Tailwind que replican el estilo de los <Input> del BookingWizard
const CLASES_SELECT =
  "flex h-9 w-full rounded-md border border-input bg-background px-3 py-1 text-sm " +
  "shadow-sm transition-colors focus-visible:outline-none focus-visible:ring-1 " +
  "focus-visible:ring-ring disabled:cursor-not-allowed disabled:opacity-50";

const PLACEHOLDER_CARGANDO = "Cargando...";

/**
 * Selector encadenado de vehículo: Marca → Modelo → Motor/versión.
 * Los datos se obtienen desde el proxy /api/vehicle-selector que scrapea distri-auto.es.
 * Al completar la selección llama a onChange con un string legible tipo:
 * "Renault 5 (122_) 1.4 Alpine Turbo (122B) 79KW"
 */
export function VehicleModelSelector({ onChange }: Props) {
  // Listas de opciones para cada nivel
  const [marcas, setMarcas] = useState<OpcionSelector[]>([]);
  const [modelos, setModelos] = useState<OpcionSelector[]>([]);
  const [vehiculos, setVehiculos] = useState<OpcionSelector[]>([]);

  // Valores seleccionados (IDs numéricos como strings)
  const [marcaId, setMarcaId] = useState("");
  const [modeloId, setModeloId] = useState("");

  // Labels seleccionados para componer el string final
  const [marcaLabel, setMarcaLabel] = useState("");
  const [modeloLabel, setModeloLabel] = useState("");

  // Estados de carga por nivel
  const [cargandoMarcas, setCargandoMarcas] = useState(false);
  const [cargandoModelos, setCargandoModelos] = useState(false);
  const [cargandoVehiculos, setCargandoVehiculos] = useState(false);

  // Carga las marcas al montar el componente
  useEffect(() => {
    async function cargarMarcas() {
      setCargandoMarcas(true);
      try {
        const res = await fetch("/api/vehicle-selector?step=manufacturers");
        const data = await res.json() as RespuestaAPI;
        setMarcas(data.options ?? []);
      } catch {
        // Fallo silencioso: el campo queda vacío y el usuario puede escribir manualmente
        setMarcas([]);
      } finally {
        setCargandoMarcas(false);
      }
    }
    void cargarMarcas();
  }, []);

  // Carga modelos cuando cambia la marca seleccionada
  useEffect(() => {
    if (!marcaId) {
      setModelos([]);
      setModeloId("");
      setModeloLabel("");
      setVehiculos([]);
      return;
    }

    async function cargarModelos() {
      setCargandoModelos(true);
      setModelos([]);
      setModeloId("");
      setModeloLabel("");
      setVehiculos([]);
      try {
        const res = await fetch(
          `/api/vehicle-selector?step=models&manufacturerId=${marcaId}`
        );
        const data = await res.json() as RespuestaAPI;
        setModelos(data.options ?? []);
      } catch {
        setModelos([]);
      } finally {
        setCargandoModelos(false);
      }
    }
    void cargarModelos();
  }, [marcaId]);

  // Carga vehículos cuando cambia el modelo seleccionado
  useEffect(() => {
    if (!marcaId || !modeloId) {
      setVehiculos([]);
      return;
    }

    async function cargarVehiculos() {
      setCargandoVehiculos(true);
      setVehiculos([]);
      try {
        const res = await fetch(
          `/api/vehicle-selector?step=vehicles&manufacturerId=${marcaId}&modelId=${modeloId}`
        );
        const data = await res.json() as RespuestaAPI;
        setVehiculos(data.options ?? []);
      } catch {
        setVehiculos([]);
      } finally {
        setCargandoVehiculos(false);
      }
    }
    void cargarVehiculos();
  }, [marcaId, modeloId]);

  function handleMarcaChange(e: React.ChangeEvent<HTMLSelectElement>) {
    const id = e.target.value;
    const label = marcas.find((m) => m.value === id)?.label ?? "";
    setMarcaId(id);
    setMarcaLabel(label);
    // Al cambiar la marca, limpiamos la selección compuesta
    onChange("");
  }

  function handleModeloChange(e: React.ChangeEvent<HTMLSelectElement>) {
    const id = e.target.value;
    const label = modelos.find((m) => m.value === id)?.label ?? "";
    setModeloId(id);
    setModeloLabel(label);
    // Al cambiar el modelo sin haber seleccionado vehículo aún, limpiamos
    onChange("");
  }

  function handleVehiculoChange(e: React.ChangeEvent<HTMLSelectElement>) {
    const vehiculoLabel = vehiculos.find((v) => v.value === e.target.value)?.label ?? "";
    if (!vehiculoLabel) {
      onChange("");
      return;
    }
    // Compone el string legible final: "Marca Modelo Motor"
    const valorFinal = `${marcaLabel} ${modeloLabel} ${vehiculoLabel}`.replace(/\s+/g, " ").trim();
    onChange(valorFinal);
  }

  return (
    <div className="space-y-2">
      {/* Selector de marca */}
      <select
        className={CLASES_SELECT}
        value={marcaId}
        onChange={handleMarcaChange}
        disabled={cargandoMarcas}
        aria-label="Marca del vehículo"
      >
        <option value="">
          {cargandoMarcas ? PLACEHOLDER_CARGANDO : "Selecciona una marca"}
        </option>
        {marcas.map((m) => (
          <option key={m.value} value={m.value}>
            {m.label}
          </option>
        ))}
      </select>

      {/* Selector de modelo */}
      <select
        className={CLASES_SELECT}
        value={modeloId}
        onChange={handleModeloChange}
        disabled={!marcaId || cargandoModelos}
        aria-label="Modelo del vehículo"
      >
        <option value="">
          {!marcaId
            ? "Primero elige una marca"
            : cargandoModelos
            ? PLACEHOLDER_CARGANDO
            : modelos.length === 0
            ? "Sin modelos disponibles"
            : "Selecciona un modelo"}
        </option>
        {modelos.map((m) => (
          <option key={m.value} value={m.value}>
            {m.label}
          </option>
        ))}
      </select>

      {/* Selector de versión / motor */}
      <select
        className={CLASES_SELECT}
        defaultValue=""
        onChange={handleVehiculoChange}
        disabled={!modeloId || cargandoVehiculos}
        aria-label="Versión y motor del vehículo"
      >
        <option value="">
          {!modeloId
            ? "Primero elige un modelo"
            : cargandoVehiculos
            ? PLACEHOLDER_CARGANDO
            : vehiculos.length === 0
            ? "Sin versiones disponibles"
            : "Selecciona la versión"}
        </option>
        {vehiculos.map((v) => (
          <option key={v.value} value={v.value}>
            {v.label}
          </option>
        ))}
      </select>
    </div>
  );
}
