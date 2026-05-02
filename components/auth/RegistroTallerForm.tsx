"use client";

import { useState } from "react";
import { useRouter } from "next/navigation";
import { signIn } from "next-auth/react";
import Link from "next/link";
import {
  Wrench,
  AlertCircle,
  Loader2,
  ArrowLeft,
  User,
  Lock,
  Car,
  Euro,
  ChevronRight,
  MessageCircle,
  Check,
} from "lucide-react";
import PhoneInput, { isValidPhoneNumber } from "react-phone-number-input";
import { VEHICLE_TYPES, VEHICLE_LABELS, VEHICLE_ICONS } from "@/lib/utils";
import { usePostalCodeLookup } from "@/lib/hooks/usePostalCodeLookup";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Textarea } from "@/components/ui/textarea";
import {
  RegistroServicePicker,
  type ServicioSeleccionado,
} from "@/components/auth/RegistroServicePicker";

// ── Tipos del estado del wizard ───────────────────────────────────────────────

type PasoWizard = 1 | 2 | 3;

interface EstadoPaso1 {
  garageName: string;
  address: string;
  postalCode: string;
  city: string;
  province: string;
  community: string;
  description: string;
  vehicleTypes: string[];
}

interface EstadoPaso2 {
  serviciosSeleccionados: ServicioSeleccionado[];
  laborRate: string;
}

interface EstadoPaso3 {
  ownerName: string;
  phone: string | undefined;
  whatsappOptIn: boolean;
  email: string;
  password: string;
  acceptLegal: boolean;
  acceptComercial: boolean;
}

// ── Indicador de progreso ─────────────────────────────────────────────────────

interface IndicadorProgresoProps {
  pasoActual: PasoWizard;
}

const PASOS_LABELS = ["Tu taller", "Servicios", "Tu cuenta"] as const;

function IndicadorProgreso({ pasoActual }: IndicadorProgresoProps) {
  return (
    <div className="flex items-center justify-between px-6 pt-5 pb-4">
      {PASOS_LABELS.map((label, i) => {
        const numPaso = (i + 1) as PasoWizard;
        const completado = numPaso < pasoActual;
        const activo = numPaso === pasoActual;

        return (
          <div key={numPaso} className="flex items-center flex-1">
            {/* Círculo numerado */}
            <div className="flex flex-col items-center">
              <div
                className={`flex h-8 w-8 items-center justify-center rounded-full border-2 text-xs font-bold transition-all shrink-0 ${
                  completado
                    ? "bg-gartify-blue border-gartify-blue text-white"
                    : activo
                    ? "bg-gartify-orange border-gartify-orange text-white"
                    : "bg-white border-gray-300 text-gartify-gray"
                }`}
              >
                {completado ? <Check className="h-4 w-4" /> : numPaso}
              </div>
              <span
                className={`mt-1 text-[10px] font-semibold whitespace-nowrap ${
                  activo
                    ? "text-gartify-orange"
                    : completado
                    ? "text-gartify-blue"
                    : "text-gartify-gray"
                }`}
              >
                {label}
              </span>
            </div>

            {/* Línea conectora (no después del último paso) */}
            {i < PASOS_LABELS.length - 1 && (
              <div
                className={`h-0.5 flex-1 mx-2 mb-5 transition-all ${
                  completado ? "bg-gartify-blue" : "bg-gray-200"
                }`}
              />
            )}
          </div>
        );
      })}
    </div>
  );
}

// ── Componente principal ──────────────────────────────────────────────────────

export function RegistroTallerForm() {
  const router = useRouter();

  const [paso, setPaso] = useState<PasoWizard>(1);
  const [errorPaso, setErrorPaso] = useState("");
  const [loading, setLoading] = useState(false);

  // Estado del Paso 1 — Datos del taller
  const [paso1, setPaso1] = useState<EstadoPaso1>({
    garageName:   "",
    address:      "",
    postalCode:   "",
    city:         "",
    province:     "",
    community:    "",
    description:  "",
    vehicleTypes: ["COCHE"],
  });

  // Estado del Paso 2 — Servicios
  const [paso2, setPaso2] = useState<EstadoPaso2>({
    serviciosSeleccionados: [],
    laborRate:              "",
  });

  // Estado del Paso 3 — Cuenta
  const [paso3, setPaso3] = useState<EstadoPaso3>({
    ownerName:       "",
    phone:           undefined,
    whatsappOptIn:   false,
    email:           "",
    password:        "",
    acceptLegal:     false,
    acceptComercial: false,
  });

  const { lookup, loading: cpLoading } = usePostalCodeLookup();

  // ── Helpers de actualización de estado ────────────────────────────────────

  function actualizarPaso1<K extends keyof EstadoPaso1>(
    campo: K,
    valor: EstadoPaso1[K],
  ) {
    setPaso1((prev) => ({ ...prev, [campo]: valor }));
  }

  function actualizarPaso3<K extends keyof EstadoPaso3>(
    campo: K,
    valor: EstadoPaso3[K],
  ) {
    setPaso3((prev) => ({ ...prev, [campo]: valor }));
  }

  function toggleVehiculo(type: string) {
    setPaso1((prev) => ({
      ...prev,
      vehicleTypes: prev.vehicleTypes.includes(type)
        ? prev.vehicleTypes.length > 1
          ? prev.vehicleTypes.filter((t) => t !== type)
          : prev.vehicleTypes
        : [...prev.vehicleTypes, type],
    }));
  }

  // ── Lookup de código postal ────────────────────────────────────────────────

  async function handleCodigoPostalChange(cp: string) {
    actualizarPaso1("postalCode", cp);
    if (/^\d{5}$/.test(cp)) {
      const result = await lookup(cp);
      if (result) {
        actualizarPaso1("city",      result.city);
        actualizarPaso1("province",  result.province);
        actualizarPaso1("community", result.community);
      }
    }
  }

  // ── Validaciones por paso ─────────────────────────────────────────────────

  function validarPaso1(): string | null {
    if (!paso1.garageName.trim())  return "El nombre del taller es obligatorio";
    if (!paso1.address.trim())     return "La dirección es obligatoria";
    if (!/^\d{5}$/.test(paso1.postalCode.trim()))
      return "Introduce un código postal válido (5 dígitos)";
    if (!paso1.city.trim())        return "La población es obligatoria";
    if (!paso1.province.trim())    return "La provincia es obligatoria";
    if (paso1.vehicleTypes.length === 0)
      return "Selecciona al menos un tipo de vehículo";
    return null;
  }

  function validarPaso2(): string | null {
    // El paso 2 es completamente opcional (0 servicios y sin laborRate son válidos)
    const laborRaw = paso2.laborRate.trim();
    if (laborRaw && (isNaN(parseFloat(laborRaw)) || parseFloat(laborRaw) <= 0)) {
      return "La mano de obra debe ser un número positivo";
    }
    return null;
  }

  function validarPaso3(): string | null {
    if (!paso3.ownerName.trim())   return "El nombre del responsable es obligatorio";
    if (!paso3.email.trim() || !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(paso3.email))
      return "Introduce un email válido";
    if (paso3.password.length < 6) return "La contraseña debe tener al menos 6 caracteres";
    if (!paso3.phone || !isValidPhoneNumber(paso3.phone))
      return "Introduce un teléfono móvil válido";
    if (!paso3.acceptLegal)
      return "Debes aceptar los Términos y la Política de privacidad";
    return null;
  }

  // ── Navegación entre pasos ────────────────────────────────────────────────

  function avanzarPaso() {
    setErrorPaso("");
    let errorValidacion: string | null = null;

    if (paso === 1) errorValidacion = validarPaso1();
    if (paso === 2) errorValidacion = validarPaso2();

    if (errorValidacion) {
      setErrorPaso(errorValidacion);
      return;
    }
    setPaso((p) => (p < 3 ? ((p + 1) as PasoWizard) : p));
  }

  function retrocederPaso() {
    setErrorPaso("");
    setPaso((p) => (p > 1 ? ((p - 1) as PasoWizard) : p));
  }

  // ── Submit final (paso 3) ─────────────────────────────────────────────────

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setErrorPaso("");

    const errorValidacion = validarPaso3();
    if (errorValidacion) { setErrorPaso(errorValidacion); return; }

    setLoading(true);

    const laborRateRaw = paso2.laborRate.trim();
    const body = {
      ownerName:    paso3.ownerName.trim(),
      email:        paso3.email.trim(),
      password:     paso3.password,
      phone:        paso3.phone,
      whatsappOptIn: paso3.whatsappOptIn,
      garageName:   paso1.garageName.trim(),
      address:      paso1.address.trim(),
      city:         paso1.city.trim(),
      province:     paso1.province.trim(),
      community:    paso1.community.trim(),
      postalCode:   paso1.postalCode.trim(),
      description:  paso1.description.trim() || undefined,
      vehicleTypes: paso1.vehicleTypes,
      ...(laborRateRaw && { laborRate: parseFloat(laborRateRaw) }),
      ...(paso2.serviciosSeleccionados.length > 0 && {
        initialServices: paso2.serviciosSeleccionados,
      }),
    };

    const res = await fetch("/api/garage/register", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
    });
    const data = (await res.json()) as { error?: string };
    if (!res.ok) {
      setErrorPaso(data.error ?? "Error al registrar el taller");
      setLoading(false);
      return;
    }

    await signIn("credentials", {
      email:    paso3.email.trim(),
      password: paso3.password,
      redirect: false,
    });
    router.push("/cuenta/taller");
    router.refresh();
  }

  // ── Render de cada paso ───────────────────────────────────────────────────

  function renderPaso1() {
    return (
      <div className="space-y-4">
        {/* Nombre del taller */}
        <div className="space-y-1.5">
          <Label htmlFor="garageName" className="text-xs font-semibold text-gartify-blue">
            Nombre del taller <span className="text-red-500">*</span>
          </Label>
          <Input
            id="garageName"
            placeholder="Taller Martínez Auto"
            value={paso1.garageName}
            onChange={(e) => actualizarPaso1("garageName", e.target.value)}
            autoComplete="organization"
          />
        </div>

        {/* Dirección */}
        <div className="space-y-1.5">
          <Label htmlFor="address" className="text-xs font-semibold text-gartify-blue">
            Dirección <span className="text-red-500">*</span>
          </Label>
          <Input
            id="address"
            placeholder="Calle Alcalá, 142"
            value={paso1.address}
            onChange={(e) => actualizarPaso1("address", e.target.value)}
            autoComplete="street-address"
          />
        </div>

        {/* Código postal + Ciudad */}
        <div className="grid grid-cols-2 gap-3">
          <div className="space-y-1.5">
            <Label htmlFor="postalCode" className="text-xs font-semibold text-gartify-blue">
              Código postal <span className="text-red-500">*</span>
            </Label>
            <Input
              id="postalCode"
              placeholder="28009"
              maxLength={5}
              value={paso1.postalCode}
              onChange={(e) => handleCodigoPostalChange(e.target.value)}
              autoComplete="postal-code"
            />
          </div>
          <div className="space-y-1.5">
            <Label
              htmlFor="city"
              className="text-xs font-semibold text-gartify-blue flex items-center gap-1.5"
            >
              Población {cpLoading && <Loader2 className="h-3 w-3 animate-spin" />}
            </Label>
            <Input
              id="city"
              placeholder="Madrid"
              value={paso1.city}
              onChange={(e) => actualizarPaso1("city", e.target.value)}
            />
          </div>
        </div>

        {/* Provincia + Comunidad autónoma (readonly) */}
        <div className="grid grid-cols-2 gap-3">
          <div className="space-y-1.5">
            <Label htmlFor="province" className="text-xs font-semibold text-gartify-blue">
              Provincia
            </Label>
            <Input
              id="province"
              value={paso1.province}
              readOnly
              placeholder="—"
              className="h-9 text-sm bg-gray-50 text-gartify-gray cursor-default"
            />
          </div>
          <div className="space-y-1.5">
            <Label className="text-xs font-semibold text-gartify-blue">
              Comunidad autónoma
            </Label>
            <Input
              value={paso1.community}
              readOnly
              placeholder="—"
              className="h-9 text-sm bg-gray-50 text-gartify-gray cursor-default"
            />
          </div>
        </div>

        {/* Descripción */}
        <div className="space-y-1.5">
          <Label htmlFor="description" className="text-xs font-semibold text-gartify-blue">
            Descripción{" "}
            <span className="font-normal text-gartify-gray">(opcional)</span>
          </Label>
          <Textarea
            id="description"
            placeholder="Especialistas en ITV, revisiones, frenos..."
            rows={2}
            value={paso1.description}
            onChange={(e) => actualizarPaso1("description", e.target.value)}
          />
        </div>

        {/* Tipos de vehículo */}
        <div className="pt-1">
          <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3 flex items-center gap-1.5">
            <Car className="h-3.5 w-3.5" />
            Vehículos que admite <span className="text-red-500 normal-case tracking-normal font-normal">*</span>
          </p>
          <div className="grid grid-cols-3 gap-2">
            {VEHICLE_TYPES.map((type) => {
              const activo = paso1.vehicleTypes.includes(type);
              return (
                <button
                  key={type}
                  type="button"
                  onClick={() => toggleVehiculo(type)}
                  className={`flex items-center gap-2 px-3 py-2 border text-xs font-medium transition-all ${
                    activo
                      ? "border-gartify-blue bg-blue-50 text-gartify-blue"
                      : "border-gray-200 bg-white text-gartify-gray hover:border-gartify-blue/40"
                  }`}
                >
                  <span aria-hidden="true">{VEHICLE_ICONS[type]}</span>
                  {VEHICLE_LABELS[type]}
                </button>
              );
            })}
          </div>
        </div>
      </div>
    );
  }

  function renderPaso2() {
    return (
      <div className="space-y-4">
        {/* Encabezado descriptivo */}
        <div>
          <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-1 flex items-center gap-1.5">
            <Euro className="h-3.5 w-3.5" />
            Servicios de tu taller
          </p>
          <p className="text-sm font-semibold text-gartify-blue">
            Añade hasta 3 servicios a tu perfil
          </p>
          <p className="text-xs text-gartify-gray mt-0.5">
            Los clientes podrán reservarlos directamente. Podrás añadir más después.
          </p>
        </div>

        {/* Selector de servicios del catálogo */}
        <RegistroServicePicker
          selected={paso2.serviciosSeleccionados}
          onChange={(servicios) =>
            setPaso2((prev) => ({ ...prev, serviciosSeleccionados: servicios }))
          }
          maxServices={3}
        />

        {/* Mano de obra */}
        <div className="pt-2 border-t border-gray-100">
          <div className="space-y-1.5">
            <Label htmlFor="laborRate" className="text-xs font-semibold text-gartify-blue">
              Mano de obra{" "}
              <span className="font-normal text-gartify-gray">(€/hora, opcional)</span>
            </Label>
            <Input
              id="laborRate"
              type="number"
              min="0"
              step="1"
              placeholder="Ej: 45"
              value={paso2.laborRate}
              onChange={(e) =>
                setPaso2((prev) => ({ ...prev, laborRate: e.target.value }))
              }
            />
          </div>
        </div>
      </div>
    );
  }

  function renderPaso3() {
    return (
      <form onSubmit={handleSubmit} className="space-y-4" noValidate>
        {/* Nombre del responsable */}
        <div className="space-y-1.5">
          <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3 flex items-center gap-1.5">
            <User className="h-3.5 w-3.5" />
            Responsable del taller
          </p>
          <Label htmlFor="ownerName" className="text-xs font-semibold text-gartify-blue">
            Tu nombre <span className="text-red-500">*</span>
          </Label>
          <Input
            id="ownerName"
            placeholder="Carlos Martínez"
            value={paso3.ownerName}
            onChange={(e) => actualizarPaso3("ownerName", e.target.value)}
            autoComplete="name"
          />
        </div>

        {/* Teléfono */}
        <div className="space-y-1.5">
          <Label htmlFor="tphone" className="text-xs font-semibold text-gartify-blue">
            Teléfono móvil <span className="text-red-500">*</span>
          </Label>
          <PhoneInput
            id="tphone"
            defaultCountry="ES"
            value={paso3.phone}
            onChange={(val) => {
              actualizarPaso3("phone", val);
              if (!val) actualizarPaso3("whatsappOptIn", false);
            }}
            placeholder="666 666 666"
            className="phone-input-gartify"
          />
        </div>

        {/* WhatsApp opt-in */}
        <label
          className={`flex items-center gap-2.5 cursor-pointer border p-3 transition-colors ${
            paso3.whatsappOptIn && paso3.phone
              ? "border-green-200 bg-green-50"
              : "border-gray-200 bg-gray-50"
          }`}
        >
          <input
            type="checkbox"
            checked={paso3.whatsappOptIn}
            onChange={(e) => actualizarPaso3("whatsappOptIn", e.target.checked)}
            className="h-4 w-4 border-gray-300 accent-green-600 shrink-0"
          />
          <MessageCircle className="h-4 w-4 text-green-600 shrink-0" />
          <span className="text-xs text-gray-700 leading-snug">
            Recibir avisos por WhatsApp — Confirmaciones de reserva y recordatorios
            directamente en tu WhatsApp.
          </span>
        </label>

        {/* Email + Contraseña */}
        <div className="pt-2">
          <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3 flex items-center gap-1.5">
            <Lock className="h-3.5 w-3.5" />
            Acceso
          </p>
          <div className="space-y-3">
            <div className="space-y-1.5">
              <Label htmlFor="temail" className="text-xs font-semibold text-gartify-blue">
                Email <span className="text-red-500">*</span>
              </Label>
              <Input
                id="temail"
                type="email"
                placeholder="taller@email.es"
                value={paso3.email}
                onChange={(e) => actualizarPaso3("email", e.target.value)}
                autoComplete="email"
              />
            </div>
            <div className="space-y-1.5">
              <Label htmlFor="tpassword" className="text-xs font-semibold text-gartify-blue">
                Contraseña <span className="text-red-500">*</span>
              </Label>
              <Input
                id="tpassword"
                type="password"
                placeholder="Mínimo 6 caracteres"
                value={paso3.password}
                onChange={(e) => actualizarPaso3("password", e.target.value)}
                autoComplete="new-password"
                minLength={6}
              />
            </div>
          </div>
        </div>

        {/* Checks legales */}
        <div className="space-y-2 pt-1">
          <label className="flex items-start gap-2.5 cursor-pointer">
            <input
              type="checkbox"
              checked={paso3.acceptLegal}
              onChange={(e) => actualizarPaso3("acceptLegal", e.target.checked)}
              className="mt-0.5 h-4 w-4 rounded border-gray-300 accent-gartify-blue shrink-0"
            />
            <span className="text-xs text-gray-600 leading-relaxed">
              He leído y acepto los{" "}
              <Link
                href="/terminos"
                target="_blank"
                className="text-gartify-blue underline hover:no-underline"
              >
                Términos y condiciones
              </Link>{" "}
              y la{" "}
              <Link
                href="/privacidad"
                target="_blank"
                className="text-gartify-blue underline hover:no-underline"
              >
                Política de privacidad
              </Link>
              . <span className="text-red-500">*</span>
            </span>
          </label>
          <label className="flex items-start gap-2.5 cursor-pointer">
            <input
              type="checkbox"
              checked={paso3.acceptComercial}
              onChange={(e) => actualizarPaso3("acceptComercial", e.target.checked)}
              className="mt-0.5 h-4 w-4 rounded border-gray-300 accent-gartify-blue shrink-0"
            />
            <span className="text-xs text-gray-600 leading-relaxed">
              Acepto recibir comunicaciones comerciales de Gartify.
            </span>
          </label>
        </div>

        {/* Error de validación */}
        {errorPaso && (
          <div
            role="alert"
            className="flex items-center gap-2 bg-red-50 border border-red-100 px-3 py-2 text-sm text-red-600"
          >
            <AlertCircle className="h-4 w-4 shrink-0" />
            {errorPaso}
          </div>
        )}

        {/* Botones de navegación del paso 3 */}
        <div className="flex gap-3 pt-1">
          <Button
            type="button"
            variant="outline"
            onClick={retrocederPaso}
            className="flex-none border-gray-200 text-gartify-gray hover:text-gartify-dark gap-1.5"
            disabled={loading}
          >
            <ArrowLeft className="h-4 w-4" />
            Anterior
          </Button>
          <Button
            type="submit"
            className="flex-1 h-11 bg-gartify-orange hover:bg-orange-600 text-white font-bold gap-2"
            disabled={loading}
          >
            {loading ? (
              <>
                <Loader2 className="h-4 w-4 animate-spin" />
                Registrando taller...
              </>
            ) : (
              <>
                <ChevronRight className="h-4 w-4" />
                Registrar mi taller gratis
              </>
            )}
          </Button>
        </div>
      </form>
    );
  }

  // ── Layout general del wizard ─────────────────────────────────────────────

  return (
    <div className="min-h-[calc(100vh-4rem)] flex items-center justify-center py-12 px-4 bg-blue-50">
      <div className="w-full max-w-lg">
        <div className="bg-white border border-gray-200 overflow-hidden">

          {/* Cabecera fija */}
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

          {/* Indicador de progreso */}
          <div className="border-b border-gray-100">
            <IndicadorProgreso pasoActual={paso} />
          </div>

          {/* Contenido del paso activo */}
          <div className="p-6">
            {paso === 1 && (
              <>
                {renderPaso1()}

                {errorPaso && (
                  <div
                    role="alert"
                    className="flex items-center gap-2 bg-red-50 border border-red-100 px-3 py-2 text-sm text-red-600 mt-4"
                  >
                    <AlertCircle className="h-4 w-4 shrink-0" />
                    {errorPaso}
                  </div>
                )}

                <div className="flex justify-end mt-5">
                  <Button
                    type="button"
                    onClick={avanzarPaso}
                    className="bg-gartify-orange hover:bg-orange-600 text-white font-bold gap-2"
                  >
                    Siguiente
                    <ChevronRight className="h-4 w-4" />
                  </Button>
                </div>
              </>
            )}

            {paso === 2 && (
              <>
                {renderPaso2()}

                {errorPaso && (
                  <div
                    role="alert"
                    className="flex items-center gap-2 bg-red-50 border border-red-100 px-3 py-2 text-sm text-red-600 mt-4"
                  >
                    <AlertCircle className="h-4 w-4 shrink-0" />
                    {errorPaso}
                  </div>
                )}

                <div className="flex gap-3 mt-5">
                  <Button
                    type="button"
                    variant="outline"
                    onClick={retrocederPaso}
                    className="flex-none border-gray-200 text-gartify-gray hover:text-gartify-dark gap-1.5"
                  >
                    <ArrowLeft className="h-4 w-4" />
                    Anterior
                  </Button>
                  <Button
                    type="button"
                    onClick={avanzarPaso}
                    className="flex-1 bg-gartify-orange hover:bg-orange-600 text-white font-bold gap-2"
                  >
                    Siguiente
                    <ChevronRight className="h-4 w-4" />
                  </Button>
                </div>
              </>
            )}

            {paso === 3 && renderPaso3()}
          </div>

          {/* Footer con enlace a login */}
          <div className="px-6 pb-5 flex items-center justify-between text-sm border-t border-gray-100 pt-4">
            <Link
              href="/registro"
              className="flex items-center gap-1 text-gartify-gray hover:text-gartify-dark transition-colors text-xs"
            >
              <ArrowLeft className="h-3.5 w-3.5" />
              Volver
            </Link>
            <p className="text-muted-foreground text-xs">
              ¿Ya tienes cuenta?{" "}
              <Link
                href="/login/taller"
                className="text-gartify-orange font-semibold hover:underline"
              >
                Inicia sesión
              </Link>
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}
