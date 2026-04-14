"use client";

import { useState } from "react";
import { useRouter } from "next/navigation";
import Link from "next/link";
import { Car, Plus, Pencil, Trash2, Fuel, Gauge, CalendarCheck, X, BookOpen } from "lucide-react";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
import { VehicleModelSelector } from "@/components/booking/VehicleModelSelector";
import { cn } from "@/lib/utils";

// ─── Tipos ────────────────────────────────────────────────────────────────────

type Vehiculo = {
  id: string;
  alias: string | null;
  plate: string;
  brand: string;
  model: string;
  year: number | null;
  color: string | null;
  fuel: string | null;
  mileage: number | null;
  itvDate: Date | string | null;
  createdAt: Date | string;
};

type DatosFormulario = {
  alias: string;
  plate: string;
  brand: string;
  model: string;
  year: string;
  color: string;
  fuel: string;
  mileage: string;
  itvDate: string;
};

const FORMULARIO_VACIO: DatosFormulario = {
  alias:   "",
  plate:   "",
  brand:   "",
  model:   "",
  year:    "",
  color:   "",
  fuel:    "",
  mileage: "",
  itvDate: "",
};

const OPCIONES_COMBUSTIBLE = [
  "Gasolina",
  "Diésel",
  "Híbrido",
  "Eléctrico",
  "GLP",
] as const;

// ─── Utilidades ───────────────────────────────────────────────────────────────

function formatearFechaItv(fecha: Date | string | null): string {
  if (!fecha) return "—";
  const d = fecha instanceof Date ? fecha : new Date(fecha);
  return new Intl.DateTimeFormat("es-ES", { day: "2-digit", month: "2-digit", year: "numeric" }).format(d);
}

function fechaParaInput(fecha: Date | string | null): string {
  if (!fecha) return "";
  const d = fecha instanceof Date ? fecha : new Date(fecha);
  // Formato YYYY-MM-DD requerido por <input type="date">
  return d.toISOString().split("T")[0];
}

// ─── Componente principal ─────────────────────────────────────────────────────

interface Props {
  vehiculosIniciales: Vehiculo[];
}

export function VehicleList({ vehiculosIniciales }: Props) {
  const router = useRouter();

  const [vehiculos, setVehiculos]         = useState<Vehiculo[]>(vehiculosIniciales);
  const [mostrarFormulario, setMostrarFormulario] = useState(false);
  const [vehiculoEditando, setVehiculoEditando]   = useState<string | null>(null);
  const [datos, setDatos]                 = useState<DatosFormulario>(FORMULARIO_VACIO);
  const [error, setError]                 = useState<string | null>(null);
  const [cargando, setCargando]           = useState(false);
  const [eliminando, setEliminando]       = useState<string | null>(null);

  // ── Abrir formulario para añadir ────────────────────────────────────────────
  function abrirFormularioNuevo() {
    setVehiculoEditando(null);
    setDatos(FORMULARIO_VACIO);
    setError(null);
    setMostrarFormulario(true);
  }

  // ── Abrir formulario para editar ────────────────────────────────────────────
  function abrirFormularioEditar(v: Vehiculo) {
    setVehiculoEditando(v.id);
    setDatos({
      alias:   v.alias ?? "",
      plate:   v.plate,
      brand:   v.brand,
      model:   v.model,
      year:    v.year?.toString() ?? "",
      color:   v.color ?? "",
      fuel:    v.fuel ?? "",
      mileage: v.mileage?.toString() ?? "",
      itvDate: fechaParaInput(v.itvDate),
    });
    setError(null);
    setMostrarFormulario(true);
  }

  // ── Cerrar formulario ───────────────────────────────────────────────────────
  function cerrarFormulario() {
    setMostrarFormulario(false);
    setVehiculoEditando(null);
    setDatos(FORMULARIO_VACIO);
    setError(null);
  }

  // ── Construir payload para la API ───────────────────────────────────────────
  function construirPayload() {
    return {
      ...(datos.alias.trim() ? { alias: datos.alias.trim() } : {}),
      plate:   datos.plate.trim(),
      brand:   datos.brand.trim(),
      model:   datos.model.trim(),
      ...(datos.year    ? { year:    parseInt(datos.year, 10) }    : {}),
      ...(datos.color   ? { color:   datos.color }                 : {}),
      ...(datos.fuel    ? { fuel:    datos.fuel }                  : {}),
      ...(datos.mileage ? { mileage: parseInt(datos.mileage, 10) } : {}),
      ...(datos.itvDate ? { itvDate: new Date(datos.itvDate).toISOString() } : {}),
    };
  }

  // ── Guardar (crear o actualizar) ────────────────────────────────────────────
  async function guardar(e: React.FormEvent) {
    e.preventDefault();
    setError(null);

    if (!datos.plate.trim() || !datos.brand.trim() || !datos.model.trim()) {
      setError("Los campos matrícula, marca y modelo son obligatorios.");
      return;
    }

    setCargando(true);
    try {
      const esEdicion = vehiculoEditando !== null;
      const url    = esEdicion ? `/api/vehicles/${vehiculoEditando}` : "/api/vehicles";
      const metodo = esEdicion ? "PATCH" : "POST";

      const respuesta = await fetch(url, {
        method: metodo,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(construirPayload()),
      });

      if (!respuesta.ok) {
        const cuerpo = await respuesta.json() as { error?: string };
        setError(cuerpo.error ?? "Error al guardar el vehículo.");
        return;
      }

      const vehiculoGuardado = await respuesta.json() as Vehiculo;

      if (esEdicion) {
        setVehiculos((prev) =>
          prev.map((v) => (v.id === vehiculoEditando ? vehiculoGuardado : v))
        );
      } else {
        setVehiculos((prev) => [vehiculoGuardado, ...prev]);
      }

      cerrarFormulario();
      router.refresh();
    } catch {
      setError("Error de conexión. Inténtalo de nuevo.");
    } finally {
      setCargando(false);
    }
  }

  // ── Eliminar vehículo ───────────────────────────────────────────────────────
  async function eliminar(id: string) {
    if (!confirm("¿Seguro que quieres eliminar este vehículo?")) return;

    setEliminando(id);
    try {
      const respuesta = await fetch(`/api/vehicles/${id}`, { method: "DELETE" });
      if (!respuesta.ok) {
        const cuerpo = await respuesta.json() as { error?: string };
        alert(cuerpo.error ?? "Error al eliminar el vehículo.");
        return;
      }
      setVehiculos((prev) => prev.filter((v) => v.id !== id));
      router.refresh();
    } catch {
      alert("Error de conexión. Inténtalo de nuevo.");
    } finally {
      setEliminando(null);
    }
  }

  // ── Render ──────────────────────────────────────────────────────────────────
  return (
    <div className="space-y-6">

      {/* Botón añadir vehículo */}
      <div className="flex justify-end">
        <Button
          onClick={mostrarFormulario && vehiculoEditando === null ? cerrarFormulario : abrirFormularioNuevo}
          className="bg-gartify-blue hover:bg-gartify-blue/90 text-white gap-2"
        >
          {mostrarFormulario && vehiculoEditando === null ? (
            <><X className="h-4 w-4" aria-hidden="true" /> Cancelar</>
          ) : (
            <><Plus className="h-4 w-4" aria-hidden="true" /> Añadir vehículo</>
          )}
        </Button>
      </div>

      {/* Formulario inline (expandible) */}
      {mostrarFormulario && (
        <FormularioVehiculo
          datos={datos}
          onChange={setDatos}
          onSubmit={guardar}
          onCancelar={cerrarFormulario}
          esEdicion={vehiculoEditando !== null}
          cargando={cargando}
          error={error}
        />
      )}

      {/* Estado vacío */}
      {vehiculos.length === 0 && !mostrarFormulario ? (
        <div className="text-center py-16 rounded-xl border border-dashed border-gray-200 bg-gray-50">
          <Car
            className="h-12 w-12 mx-auto mb-3 text-gartify-gray opacity-40"
            aria-hidden="true"
          />
          <p className="font-semibold text-foreground">Aún no tienes vehículos registrados</p>
          <p className="text-sm text-muted-foreground mt-1 mb-6">
            Añade tu vehículo para agilizar futuras reservas en los talleres
          </p>
          <Button
            onClick={abrirFormularioNuevo}
            className="bg-gartify-blue hover:bg-gartify-blue/90 text-white gap-2"
          >
            <Plus className="h-4 w-4" aria-hidden="true" />
            Añadir mi primer vehículo
          </Button>
        </div>
      ) : (
        /* Grid de tarjetas */
        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">
          {vehiculos.map((v) => (
            <TarjetaVehiculo
              key={v.id}
              vehiculo={v}
              estaEliminando={eliminando === v.id}
              onEditar={() => abrirFormularioEditar(v)}
              onEliminar={() => eliminar(v.id)}
            />
          ))}
        </div>
      )}
    </div>
  );
}

// ─── Tarjeta de vehículo ──────────────────────────────────────────────────────

interface PropsTarjeta {
  vehiculo: Vehiculo;
  estaEliminando: boolean;
  onEditar: () => void;
  onEliminar: () => void;
}

function TarjetaVehiculo({ vehiculo: v, estaEliminando, onEditar, onEliminar }: PropsTarjeta) {
  return (
    <article className="bg-white border border-gray-200 rounded-2xl shadow-sm hover:shadow-md hover:border-gartify-blue/30 transition-all flex flex-col">
      {/* Cabecera de tarjeta */}
      <div className="flex items-start gap-3 p-4 pb-3 border-b border-gray-100">
        <div
          className="h-10 w-10 rounded-xl bg-gradient-to-br from-gartify-blue to-blue-400 flex items-center justify-center shrink-0"
          aria-hidden="true"
        >
          <Car className="h-5 w-5 text-white" />
        </div>
        <div className="flex-1 min-w-0">
          <p className="font-bold text-gartify-blue text-sm leading-tight">
            {v.alias || `${v.brand} ${v.model}`}
          </p>
          {v.alias && (
            <p className="text-xs text-muted-foreground leading-tight">{v.brand} {v.model}</p>
          )}
          {/* Matrícula destacada */}
          <span className="inline-block mt-1 font-mono font-bold text-xs tracking-widest bg-gartify-orange/10 text-gartify-orange border border-gartify-orange/20 rounded-md px-2 py-0.5">
            {v.plate}
          </span>
        </div>
        {v.year && (
          <span className="text-xs text-muted-foreground font-medium shrink-0">{v.year}</span>
        )}
      </div>

      {/* Detalles */}
      <div className="flex-1 p-4 pt-3 space-y-2">
        {v.color && (
          <DetalleVehiculo
            icono={<span className="h-3.5 w-3.5 rounded-full border border-gray-200 shrink-0" style={{ background: "currentColor", width: "0.875rem", height: "0.875rem" }} aria-hidden="true" />}
            etiqueta="Color"
            valor={v.color}
          />
        )}
        {v.fuel && (
          <DetalleVehiculo
            icono={<Fuel className="h-3.5 w-3.5 text-gartify-orange" aria-hidden="true" />}
            etiqueta="Combustible"
            valor={v.fuel}
          />
        )}
        {v.mileage !== null && (
          <DetalleVehiculo
            icono={<Gauge className="h-3.5 w-3.5 text-gartify-orange" aria-hidden="true" />}
            etiqueta="Kilometraje"
            valor={`${v.mileage.toLocaleString("es-ES")} km`}
          />
        )}
        {v.itvDate && (
          <DetalleVehiculo
            icono={<CalendarCheck className="h-3.5 w-3.5 text-gartify-orange" aria-hidden="true" />}
            etiqueta="Próxima ITV"
            valor={formatearFechaItv(v.itvDate)}
          />
        )}
      </div>

      {/* Acciones */}
      <div className="flex gap-2 px-4 pb-4">
        {/* Historial de revisiones */}
        <Link href={`/cuenta/vehiculos/${v.id}`} className="flex-1">
          <Button
            variant="outline"
            size="sm"
            className="w-full gap-1.5 text-xs text-gartify-blue border-gartify-blue/30 hover:bg-gartify-blue/5"
          >
            <BookOpen className="h-3.5 w-3.5" aria-hidden="true" />
            Historial
          </Button>
        </Link>
        <Button
          variant="outline"
          size="sm"
          onClick={onEditar}
          className="flex-1 gap-1.5 text-xs text-gartify-blue border-gartify-blue/30 hover:bg-gartify-blue/5"
        >
          <Pencil className="h-3.5 w-3.5" aria-hidden="true" />
          Editar
        </Button>
        <Button
          variant="outline"
          size="sm"
          onClick={onEliminar}
          disabled={estaEliminando}
          className={cn(
            "flex-1 gap-1.5 text-xs border-red-200 text-red-500 hover:bg-red-50",
            estaEliminando && "opacity-60 pointer-events-none"
          )}
        >
          <Trash2 className="h-3.5 w-3.5" aria-hidden="true" />
          {estaEliminando ? "Eliminando…" : "Eliminar"}
        </Button>
      </div>
    </article>
  );
}

// ─── Detalle individual en tarjeta ────────────────────────────────────────────

function DetalleVehiculo({
  icono,
  etiqueta,
  valor,
}: {
  icono: React.ReactNode;
  etiqueta: string;
  valor: string;
}) {
  return (
    <div className="flex items-center gap-2 text-xs text-muted-foreground">
      {icono}
      <span className="font-medium text-foreground/70">{etiqueta}:</span>
      <span>{valor}</span>
    </div>
  );
}

// ─── Formulario inline ────────────────────────────────────────────────────────

interface PropsFormulario {
  datos: DatosFormulario;
  onChange: (d: DatosFormulario) => void;
  onSubmit: (e: React.FormEvent) => Promise<void>;
  onCancelar: () => void;
  esEdicion: boolean;
  cargando: boolean;
  error: string | null;
}

function FormularioVehiculo({
  datos,
  onChange,
  onSubmit,
  onCancelar,
  esEdicion,
  cargando,
  error,
}: PropsFormulario) {
  // Actualiza un campo por nombre
  function actualizar(campo: keyof DatosFormulario, valor: string) {
    onChange({ ...datos, [campo]: valor });
  }

  return (
    <div className="bg-white border border-gartify-blue/20 rounded-2xl shadow-sm p-6">
      <h2 className="text-base font-bold text-gartify-blue mb-5">
        {esEdicion ? "Editar vehículo" : "Añadir nuevo vehículo"}
      </h2>

      <form onSubmit={onSubmit} noValidate>
        <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4">

          {/* Alias */}
          <div className="space-y-1.5 sm:col-span-2 lg:col-span-3">
            <Label htmlFor="veh-alias" className="text-xs font-semibold text-foreground/80">
              Nombre personalizado <span className="text-muted-foreground font-normal">(opcional)</span>
            </Label>
            <Input
              id="veh-alias"
              value={datos.alias}
              onChange={(e) => actualizar("alias", e.target.value)}
              placeholder={datos.brand && datos.model ? `${datos.brand} ${datos.model}` : "Ej: Mi Seat, Coche de Ana…"}
              maxLength={30}
            />
          </div>

          {/* Matrícula */}
          <div className="space-y-1.5">
            <Label htmlFor="veh-plate" className="text-xs font-semibold text-foreground/80">
              Matrícula <span className="text-red-500">*</span>
            </Label>
            <Input
              id="veh-plate"
              value={datos.plate}
              onChange={(e) => actualizar("plate", e.target.value)}
              placeholder="1234 ABC"
              maxLength={20}
              required
              className="uppercase tracking-widest font-mono"
            />
          </div>

          {/* Marca y Modelo (selector en cascada) */}
          <div className="space-y-1.5 sm:col-span-2">
            <Label className="text-xs font-semibold text-foreground/80">
              Marca y modelo <span className="text-red-500">*</span>
            </Label>
            <VehicleModelSelector
              value={`${datos.brand} ${datos.model}`.trim()}
              onChange={() => {/* combinado no usado aquí */}}
              onDetalle={({ marca, modelo }) =>
                onChange({ ...datos, brand: marca, model: modelo })
              }
            />
            {/* Fallback manual si el selector no encuentra la marca/modelo */}
            {(datos.brand || datos.model) && (
              <p className="text-xs text-muted-foreground">
                Seleccionado: <span className="font-medium text-foreground">{datos.brand} {datos.model}</span>
              </p>
            )}
          </div>

          {/* Año */}
          <div className="space-y-1.5">
            <Label htmlFor="veh-year" className="text-xs font-semibold text-foreground/80">
              Año de fabricación
            </Label>
            <Input
              id="veh-year"
              type="number"
              value={datos.year}
              onChange={(e) => actualizar("year", e.target.value)}
              placeholder="2019"
              min={1960}
              max={new Date().getFullYear() + 1}
            />
          </div>

          {/* Color */}
          <div className="space-y-1.5">
            <Label htmlFor="veh-color" className="text-xs font-semibold text-foreground/80">
              Color
            </Label>
            <Input
              id="veh-color"
              value={datos.color}
              onChange={(e) => actualizar("color", e.target.value)}
              placeholder="Ej: Blanco, Gris Plata…"
              maxLength={30}
            />
          </div>

          {/* Combustible */}
          <div className="space-y-1.5">
            <Label htmlFor="veh-fuel" className="text-xs font-semibold text-foreground/80">
              Tipo de combustible
            </Label>
            <Select
              value={datos.fuel}
              onValueChange={(v) => actualizar("fuel", v)}
            >
              <SelectTrigger id="veh-fuel" className="w-full">
                <SelectValue placeholder="Selecciona combustible" />
              </SelectTrigger>
              <SelectContent>
                {OPCIONES_COMBUSTIBLE.map((c) => (
                  <SelectItem key={c} value={c}>
                    {c}
                  </SelectItem>
                ))}
              </SelectContent>
            </Select>
          </div>

          {/* Kilometraje */}
          <div className="space-y-1.5">
            <Label htmlFor="veh-mileage" className="text-xs font-semibold text-foreground/80">
              Kilometraje actual
            </Label>
            <Input
              id="veh-mileage"
              type="number"
              value={datos.mileage}
              onChange={(e) => actualizar("mileage", e.target.value)}
              placeholder="ej: 45000"
              min={0}
            />
          </div>

          {/* Próxima ITV */}
          <div className="space-y-1.5">
            <Label htmlFor="veh-itv" className="text-xs font-semibold text-foreground/80">
              Próxima ITV
            </Label>
            <Input
              id="veh-itv"
              type="date"
              value={datos.itvDate}
              onChange={(e) => actualizar("itvDate", e.target.value)}
            />
          </div>
        </div>

        {/* Mensaje de error */}
        {error && (
          <p className="mt-4 text-sm text-red-600 bg-red-50 border border-red-200 rounded-lg px-3 py-2">
            {error}
          </p>
        )}

        {/* Botones del formulario */}
        <div className="flex gap-3 mt-6 justify-end">
          <Button
            type="button"
            variant="outline"
            onClick={onCancelar}
            disabled={cargando}
            className="text-gartify-gray"
          >
            Cancelar
          </Button>
          <Button
            type="submit"
            disabled={cargando}
            className="bg-gartify-blue hover:bg-gartify-blue/90 text-white min-w-[120px]"
          >
            {cargando
              ? "Guardando…"
              : esEdicion
                ? "Guardar cambios"
                : "Añadir vehículo"}
          </Button>
        </div>
      </form>
    </div>
  );
}
