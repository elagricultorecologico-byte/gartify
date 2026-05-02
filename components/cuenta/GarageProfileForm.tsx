"use client";
import { useState, useRef, useEffect } from "react";
import { useRouter } from "next/navigation";
import PhoneInput from "react-phone-number-input";
import type { Country } from "react-phone-number-input";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Textarea } from "@/components/ui/textarea";
import {
  CheckCircle, AlertCircle, Loader2, Building2,
  MapPin, Phone, Mail, ChevronRight, Camera, X, Car, PackageCheck, Wrench, Globe, Lock,
} from "lucide-react";
import { cn, VEHICLE_TYPES, VEHICLE_LABELS, VEHICLE_ICONS, type VehicleType } from "@/lib/utils";
import { GARAGE_CATEGORIES } from "@/lib/constants";
import { usePostalCodeLookup } from "@/lib/hooks/usePostalCodeLookup";
import { CoverImageUploader } from "@/components/cuenta/CoverImageUploader";
import type { Garage } from "@prisma/client";

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

export function GarageProfileForm({ garage }: { garage: Garage }) {
  const router = useRouter();

  // — Estado perfil —
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");
  const [success, setSuccess] = useState(false);

  // — Estado slug (URL personalizada, solo PRO/PREMIUM) —
  const esPlanPremium = garage.plan === "PRO" || garage.plan === "PREMIUM";
  const [slug, setSlug] = useState<string>((garage as { slug?: string | null }).slug ?? "");
  const [slugError, setSlugError] = useState("");

  const [phone, setPhone] = useState<string | undefined>(garage.phone ?? undefined);
  const [defaultCountry, setDefaultCountry] = useState<Country>("ES");

  useEffect(() => {
    try {
      const tz = Intl.DateTimeFormat().resolvedOptions().timeZone;
      const country = TZ_TO_COUNTRY[tz] ?? navigator.language?.split("-")[1]?.toUpperCase() ?? "ES";
      setDefaultCountry(country as Country);
      setPhone((prev) => {
        if (!prev || prev.startsWith("+")) return prev;
        const digits = prev.replace(/\D/g, "");
        const callingCode = COUNTRY_CALLING_CODE[country] ?? "34";
        return `+${callingCode}${digits}`;
      });
    } catch { /* mantiene ES */ }
  }, []);

  const [courtesyCar, setCourtesyCar] = useState(garage.courtesyCar ?? false);
  const [pickupService, setPickupService] = useState(garage.pickupService ?? false);

  const [city, setCity] = useState(garage.city);
  const [province, setProvince] = useState((garage as { province?: string }).province ?? "");
  const [community, setCommunity] = useState("");
  const { lookup, loading: cpLoading } = usePostalCodeLookup();

  // Parsear el JSON de vehicleTypes almacenado en SQLite como string
  const vehicleTypesParsados = (() => {
    try {
      const parsed = JSON.parse(garage.vehicleTypes ?? '["COCHE"]') as string[];
      return parsed.filter((v): v is VehicleType =>
        (VEHICLE_TYPES as readonly string[]).includes(v)
      );
    } catch {
      return ["COCHE"] as VehicleType[];
    }
  })();
  const [selectedVehicleTypes, setSelectedVehicleTypes] = useState<VehicleType[]>(vehicleTypesParsados);

  function toggleVehicleType(tipo: VehicleType) {
    setSelectedVehicleTypes((prev) => {
      const yaSeleccionado = prev.includes(tipo);
      // Al menos un tipo debe quedar seleccionado
      if (yaSeleccionado && prev.length === 1) return prev;
      return yaSeleccionado ? prev.filter((t) => t !== tipo) : [...prev, tipo];
    });
  }

  // Parsear el JSON de categories almacenado en SQLite como string
  // Se usa el cast porque el campo puede no existir en el tipo Prisma hasta el db push
  const categoriasParsadas = (() => {
    try {
      return JSON.parse((garage as { categories?: string }).categories ?? "[]") as string[];
    } catch {
      return [] as string[];
    }
  })();
  const [selectedCategories, setSelectedCategories] = useState<string[]>(categoriasParsadas);

  function toggleCategoria(cat: string) {
    setSelectedCategories((prev) =>
      prev.includes(cat) ? prev.filter((c) => c !== cat) : [...prev, cat]
    );
  }

  // — Estado logo —
  const [logoPreview, setLogoPreview] = useState<string | null>(garage.logo ?? null);
  const [logoFile, setLogoFile] = useState<File | null>(null);
  const [logoLoading, setLogoLoading] = useState(false);
  const [logoError, setLogoError] = useState("");
  const [logoSuccess, setLogoSuccess] = useState(false);
  const fileInputRef = useRef<HTMLInputElement>(null);

  function handleFileChange(e: React.ChangeEvent<HTMLInputElement>) {
    const file = e.target.files?.[0];
    if (!file) return;

    const validTypes = ["image/jpeg", "image/png", "image/webp"];
    if (!validTypes.includes(file.type)) {
      setLogoError("Formato no válido. Usa JPG, PNG o WebP.");
      return;
    }
    if (file.size > 2 * 1024 * 1024) {
      setLogoError("La imagen no puede superar 2 MB.");
      return;
    }

    setLogoError("");
    setLogoFile(file);
    setLogoPreview(URL.createObjectURL(file));
  }

  async function handleLogoUpload() {
    if (!logoFile) return;
    setLogoLoading(true);
    setLogoError("");
    setLogoSuccess(false);

    const fd = new FormData();
    fd.append("logo", logoFile);

    const res = await fetch("/api/garage/logo", { method: "POST", body: fd });
    const data = await res.json() as { logo?: string; error?: string };

    setLogoLoading(false);
    if (!res.ok) {
      setLogoError(data.error ?? "Error al subir la imagen");
      return;
    }
    setLogoFile(null);
    setLogoSuccess(true);
    router.refresh();
  }

  function handleRemovePreview() {
    setLogoFile(null);
    setLogoPreview(garage.logo ?? null);
    setLogoError("");
    if (fileInputRef.current) fileInputRef.current.value = "";
  }

  function validarSlug(valor: string): string {
    if (valor === "") return ""; // campo opcional: vacío es válido
    if (valor.length < 3) return "Mínimo 3 caracteres";
    if (valor.length > 60) return "Máximo 60 caracteres";
    if (!/^[a-z0-9-]+$/.test(valor)) return "Solo letras minúsculas, números y guiones";
    return "";
  }

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setLoading(true);
    setError("");
    setSuccess(false);

    // Validar slug antes de enviar
    const errorSlug = validarSlug(slug);
    if (errorSlug) {
      setSlugError(errorSlug);
      setLoading(false);
      return;
    }

    const fd = new FormData(e.currentTarget);

    const res = await fetch("/api/garage/profile", {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        name:        fd.get("name"),
        description: fd.get("description"),
        address:     fd.get("address"),
        city,
        province,
        postalCode:  fd.get("postalCode"),
        phone:       phone ?? "",
        email:       fd.get("email"),
        courtesyCar,
        pickupService,
        vehicleTypes: selectedVehicleTypes,
        categories: selectedCategories,
        // Solo enviar slug si el taller tiene plan PRO/PREMIUM y hay valor
        ...(esPlanPremium && slug.trim() !== "" && { slug: slug.trim() }),
      }),
    });

    setLoading(false);
    if (!res.ok) {
      const d = await res.json() as { error?: string };
      // Si el servidor indica conflicto de slug (409), mostrar el error junto al campo
      if (res.status === 409) {
        setSlugError(d.error ?? "Esta URL ya está en uso");
      } else {
        setError(d.error ?? "Error al guardar");
      }
      return;
    }
    setSlugError("");
    setSuccess(true);
    router.refresh();
  }

  return (
    <div className="space-y-6">

      {/* ── Sección logo ── */}
      <div className="bg-white border border-gray-200 overflow-hidden">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-4">
          <div className="flex items-center gap-3">
            <div className="flex h-9 w-9 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <Camera className="h-4 w-4 text-gartify-blue" aria-hidden="true" />
            </div>
            <div>
              <h2 className="text-sm font-bold text-gartify-blue">Imagen del taller</h2>
              <p className="text-xs text-gartify-gray mt-0.5">Aparece en los listados y en tu perfil público</p>
            </div>
          </div>
        </div>

        <div className="p-6">
          <div className="flex items-start gap-5 flex-wrap sm:flex-nowrap">
            {/* Preview */}
            <div className="shrink-0">
              <div className="h-24 w-24 overflow-hidden border-2 border-gray-200 bg-white flex items-center justify-center">
                {/* eslint-disable-next-line @next/next/no-img-element */}
                <img
                  src={logoPreview ?? "/logo-letra-fondo-azul.png"}
                  alt="Vista previa del logo"
                  className={logoPreview && logoPreview !== "/logo-letra-fondo-azul.png"
                    ? "w-full h-full object-cover"
                    : "w-full h-full object-cover"}
                />
              </div>
              {logoPreview && logoPreview !== (garage.logo ?? null) && logoFile && (
                <p className="text-xs text-gartify-gray mt-1.5 text-center">Vista previa</p>
              )}
            </div>

            {/* Upload controls */}
            <div className="flex-1 min-w-0 space-y-3">
              <div>
                <p className="text-sm font-semibold text-gartify-blue mb-1">
                  {garage.logo ? "Cambiar imagen" : "Subir imagen"}
                </p>
                <p className="text-xs text-muted-foreground">
                  JPG, PNG o WebP · Máximo 2 MB · Recomendado 400×400 px
                </p>
              </div>

              <div className="flex flex-wrap gap-2">
                <label
                  htmlFor="logo-upload"
                  className="inline-flex items-center gap-2 cursor-pointer px-4 py-2 border border-gartify-blue/30 bg-gartify-blue/5 text-gartify-blue text-sm font-semibold hover:bg-gartify-blue/10 transition-colors"
                >
                  <Camera className="h-4 w-4" aria-hidden="true" />
                  Seleccionar imagen
                </label>
                <input
                  id="logo-upload"
                  ref={fileInputRef}
                  type="file"
                  accept="image/jpeg,image/png,image/webp"
                  onChange={handleFileChange}
                  className="sr-only"
                />

                {logoFile && (
                  <>
                    <Button
                      type="button"
                      size="sm"
                      onClick={handleLogoUpload}
                      disabled={logoLoading}
                      className="bg-gartify-green hover:bg-gartify-green/90 text-white font-semibold gap-2"
                    >
                      {logoLoading ? (
                        <><Loader2 className="h-3.5 w-3.5 animate-spin" aria-hidden="true" />Subiendo...</>
                      ) : (
                        <><CheckCircle className="h-3.5 w-3.5" aria-hidden="true" />Guardar imagen</>
                      )}
                    </Button>
                    <button
                      type="button"
                      onClick={handleRemovePreview}
                      className="inline-flex items-center gap-1 px-3 py-2 text-sm text-gartify-gray hover:text-red-500 transition-colors"
                      aria-label="Cancelar selección"
                    >
                      <X className="h-4 w-4" aria-hidden="true" />
                      Cancelar
                    </button>
                  </>
                )}
              </div>

              {logoError && (
                <div role="alert" className="flex items-center gap-2 bg-red-50 border border-red-100 px-3 py-2 text-xs text-red-600">
                  <AlertCircle className="h-3.5 w-3.5 shrink-0" aria-hidden="true" />
                  {logoError}
                </div>
              )}
              {logoSuccess && (
                <div role="status" className="flex items-center gap-2 bg-green-50 border border-green-100 px-3 py-2 text-xs text-green-700">
                  <CheckCircle className="h-3.5 w-3.5 shrink-0" aria-hidden="true" />
                  Imagen actualizada correctamente.
                </div>
              )}
            </div>
          </div>

          {/* Separador */}
          <div className="border-t border-gray-100 mt-4 pt-4">
            <CoverImageUploader urlActual={(garage as { coverImage?: string | null }).coverImage} />
          </div>
        </div>
      </div>

      {/* ── Datos del perfil ── */}
      <div className="bg-white border border-gray-200 overflow-hidden">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
          <div className="flex items-center gap-3">
            <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <Building2 className="h-5 w-5 text-gartify-blue" aria-hidden="true" />
            </div>
            <div>
              <h2 className="text-base font-bold text-gartify-blue">Editar perfil del taller</h2>
              <p className="text-xs text-gartify-gray mt-0.5">Actualiza la información pública de tu taller</p>
            </div>
          </div>
        </div>

        <form onSubmit={handleSubmit} className="p-6 space-y-5" noValidate>

          {/* — Datos del taller — */}
          <div>
            <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3 flex items-center gap-1.5">
              <Building2 className="h-3.5 w-3.5" aria-hidden="true" />Datos del taller
            </p>
            <div className="space-y-3">
              <div className="space-y-1.5">
                <Label htmlFor="name" className="text-xs font-semibold text-gartify-blue">
                  Nombre del taller
                </Label>
                <Input
                  id="name"
                  name="name"
                  defaultValue={garage.name}
                  required
                  placeholder="Taller Martínez Auto"
                />
              </div>
              <div className="space-y-1.5">
                <Label htmlFor="description" className="text-xs font-semibold text-gartify-blue">
                  Descripción{" "}
                  <span className="font-normal text-gartify-gray">(opcional)</span>
                </Label>
                <Textarea
                  id="description"
                  name="description"
                  defaultValue={garage.description ?? ""}
                  rows={3}
                  placeholder="Describe tu taller, especialidades, años de experiencia..."
                />
              </div>
            </div>
          </div>

          {/* — Ubicación — */}
          <div className="pt-1">
            <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3 flex items-center gap-1.5">
              <MapPin className="h-3.5 w-3.5" aria-hidden="true" />Ubicación
            </p>
            <div className="space-y-3">
              <div className="space-y-1.5">
                <Label htmlFor="address" className="text-xs font-semibold text-gartify-blue flex items-center gap-1">
                  <MapPin className="h-3 w-3" aria-hidden="true" />Dirección
                </Label>
                <Input
                  id="address"
                  name="address"
                  defaultValue={garage.address}
                  required
                  placeholder="Calle Alcalá, 142"
                  autoComplete="street-address"
                />
              </div>
              <div className="grid grid-cols-3 gap-3">
                <div className="space-y-1.5">
                  <Label htmlFor="postalCode" className="text-xs font-semibold text-gartify-blue">
                    Código postal
                  </Label>
                  <Input
                    id="postalCode"
                    name="postalCode"
                    defaultValue={garage.postalCode}
                    maxLength={5}
                    required
                    placeholder="28009"
                    autoComplete="postal-code"
                    onChange={async (e) => {
                      const cp = e.target.value;
                      if (/^\d{5}$/.test(cp)) {
                        const result = await lookup(cp);
                        if (result) { setCity(result.city); setProvince(result.province); setCommunity(result.community); }
                      }
                    }}
                  />
                </div>
                <div className="col-span-2 space-y-1.5">
                  <Label htmlFor="city" className="text-xs font-semibold text-gartify-blue flex items-center gap-1.5">
                    Población {cpLoading && <Loader2 className="h-3 w-3 animate-spin" />}
                  </Label>
                  <Input
                    id="city"
                    value={city}
                    onChange={e => setCity(e.target.value)}
                    required
                    placeholder="Madrid"
                  />
                </div>
              </div>
              <div className="grid grid-cols-2 gap-3">
                <div className="space-y-1.5">
                  <Label className="text-xs font-semibold text-gartify-blue">Provincia</Label>
                  <Input
                    value={province} readOnly
                    placeholder="—"
                    className="h-9 text-sm bg-gray-50 text-gartify-gray cursor-default"
                  />
                </div>
                <div className="space-y-1.5">
                  <Label className="text-xs font-semibold text-gartify-blue">Comunidad autónoma</Label>
                  <Input
                    value={community} readOnly
                    placeholder="—"
                    className="h-9 text-sm bg-gray-50 text-gartify-gray cursor-default"
                  />
                </div>
              </div>
            </div>
          </div>

          {/* — Contacto — */}
          <div className="pt-1">
            <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3 flex items-center gap-1.5">
              <Phone className="h-3.5 w-3.5" aria-hidden="true" />Contacto
            </p>
            <div className="grid grid-cols-2 gap-3">
              <div className="space-y-1.5">
                <Label htmlFor="phone" className="text-xs font-semibold text-gartify-blue flex items-center gap-1">
                  <Phone className="h-3 w-3" aria-hidden="true" />Teléfono
                </Label>
                <PhoneInput
                  id="phone"
                  defaultCountry={defaultCountry}
                  value={phone}
                  onChange={(val) => setPhone(val)}
                  placeholder="643 703 220"
                  className="phone-input-gartify"
                />
              </div>
              <div className="space-y-1.5">
                <Label htmlFor="email" className="text-xs font-semibold text-gartify-blue flex items-center gap-1">
                  <Mail className="h-3 w-3" aria-hidden="true" />Email{" "}
                  <span className="font-normal text-gartify-gray">(opcional)</span>
                </Label>
                <Input
                  id="email"
                  name="email"
                  type="email"
                  defaultValue={garage.email ?? ""}
                  placeholder="info@taller.es"
                  autoComplete="email"
                />
              </div>
            </div>
          </div>

          {/* — Tipos de vehículo — */}
          <div className="pt-1">
            <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3 flex items-center gap-1.5">
              <Car className="h-3.5 w-3.5" aria-hidden="true" />Tipos de vehículo que atiendes
            </p>
            <div className="flex flex-wrap gap-2">
              {VEHICLE_TYPES.map((tipo) => {
                const activo = selectedVehicleTypes.includes(tipo);
                return (
                  <button
                    key={tipo}
                    type="button"
                    onClick={() => toggleVehicleType(tipo)}
                    aria-pressed={activo}
                    className={cn(
                      "flex items-center gap-2 px-3 py-2 rounded-none border text-sm font-medium transition-all",
                      activo
                        ? "bg-gartify-hero/10 border-gartify-hero/40 text-gartify-hero"
                        : "bg-white border-gray-200 text-gartify-gray hover:bg-gray-50"
                    )}
                  >
                    <span aria-hidden="true">{VEHICLE_ICONS[tipo]}</span>
                    {VEHICLE_LABELS[tipo]}
                    {activo && <CheckCircle className="h-3.5 w-3.5 ml-1 text-gartify-hero" aria-hidden="true" />}
                  </button>
                );
              })}
            </div>
            <p className="text-xs text-gartify-gray mt-2">
              Selecciona al menos un tipo. Los clientes podrán filtrar talleres por tipo de vehículo.
            </p>
          </div>

          {/* — Categorías del taller — */}
          <div className="pt-1">
            <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3 flex items-center gap-1.5">
              <Wrench className="h-3.5 w-3.5" aria-hidden="true" />Categorías del taller
            </p>
            <p className="text-xs text-gartify-gray mb-3">
              Selecciona las categorías que mejor describen tu taller. Los conductores podrán filtrar por ellas.
            </p>
            <div className="flex flex-wrap gap-2">
              {GARAGE_CATEGORIES.map((cat) => {
                const activo = selectedCategories.includes(cat.value);
                return (
                  <button
                    key={cat.value}
                    type="button"
                    onClick={() => toggleCategoria(cat.value)}
                    aria-pressed={activo}
                    className={cn(
                      "flex items-center gap-2 px-3 py-2 rounded-none border text-sm font-medium transition-all",
                      activo
                        ? "bg-gartify-hero/10 border-gartify-hero/40 text-gartify-hero"
                        : "bg-white border-gray-200 text-gartify-gray hover:bg-gray-50"
                    )}
                  >
                    {cat.label}
                    {activo && <CheckCircle className="h-3.5 w-3.5 ml-1 text-gartify-hero" aria-hidden="true" />}
                  </button>
                );
              })}
            </div>
          </div>

          {/* — Servicios adicionales — */}
          <div className="pt-1">
            <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3 flex items-center gap-1.5">
              <Car className="h-3.5 w-3.5" aria-hidden="true" />Servicios adicionales
            </p>
            <div className="flex flex-col gap-2 sm:flex-row">
              <button
                type="button"
                onClick={() => setCourtesyCar(!courtesyCar)}
                className={cn(
                  "flex items-center gap-2.5 px-4 py-2.5 rounded-none border text-sm font-medium transition-all",
                  courtesyCar
                    ? "bg-gartify-hero/10 border-gartify-hero/40 text-gartify-hero"
                    : "bg-white border-gray-200 text-gartify-gray hover:bg-gray-50"
                )}
              >
                <Car className="h-4 w-4 shrink-0" aria-hidden="true" />
                Vehículo de cortesía disponible
                {courtesyCar && <CheckCircle className="h-4 w-4 ml-2 text-gartify-hero" aria-hidden="true" />}
              </button>
              <button
                type="button"
                onClick={() => setPickupService(!pickupService)}
                className={cn(
                  "flex items-center gap-2.5 px-4 py-2.5 rounded-none border text-sm font-medium transition-all",
                  pickupService
                    ? "bg-gartify-hero/10 border-gartify-hero/40 text-gartify-hero"
                    : "bg-white border-gray-200 text-gartify-gray hover:bg-gray-50"
                )}
              >
                <PackageCheck className="h-4 w-4 shrink-0" aria-hidden="true" />
                Servicio de recogida
                {pickupService && <CheckCircle className="h-4 w-4 ml-2 text-gartify-hero" aria-hidden="true" />}
              </button>
            </div>
          </div>

          {/* — URL personalizada (solo PRO/PREMIUM) — */}
          <div className="pt-1">
            <p className="text-xs font-bold uppercase tracking-widest text-gartify-gray mb-3 flex items-center gap-1.5">
              <Globe className="h-3.5 w-3.5" aria-hidden="true" />URL pública del taller
            </p>
            {esPlanPremium ? (
              <div className="space-y-2">
                <p className="text-xs text-gartify-gray">
                  Tu taller tendrá una página pública en{" "}
                  <span className="font-mono text-gartify-dark">gartify.es/t/<strong>{slug || "tu-taller"}</strong></span>.
                  Solo letras minúsculas, números y guiones.
                </p>
                <div className="flex items-center gap-0 max-w-sm">
                  <span className="inline-flex items-center px-3 py-2 border border-r-0 border-gray-200 bg-gray-50 text-xs text-gartify-gray font-mono shrink-0">
                    gartify.es/t/
                  </span>
                  <Input
                    id="slug"
                    value={slug}
                    onChange={(e) => {
                      const valor = e.target.value.toLowerCase().replace(/[^a-z0-9-]/g, "");
                      setSlug(valor);
                      setSlugError(validarSlug(valor));
                    }}
                    placeholder="martinez-auto"
                    maxLength={60}
                    className={cn(
                      "font-mono text-sm",
                      slugError ? "border-red-400 focus-visible:ring-red-400" : ""
                    )}
                    aria-describedby={slugError ? "slug-error" : undefined}
                  />
                </div>
                {slugError && (
                  <p id="slug-error" role="alert" className="flex items-center gap-1.5 text-xs text-red-600">
                    <AlertCircle className="h-3.5 w-3.5 shrink-0" aria-hidden="true" />
                    {slugError}
                  </p>
                )}
              </div>
            ) : (
              <div className="flex items-start gap-3 p-3 bg-gray-50 border border-gray-200 max-w-sm">
                <Lock className="h-4 w-4 text-gartify-gray shrink-0 mt-0.5" aria-hidden="true" />
                <p className="text-xs text-gartify-gray">
                  La URL personalizada está disponible a partir del{" "}
                  <span className="font-semibold text-gartify-dark">plan Pro</span>.
                </p>
              </div>
            )}
          </div>

          {/* Feedback */}
          {error && (
            <div role="alert" className="flex items-center gap-2 bg-red-50 border border-red-100 px-3 py-2 text-sm text-red-600">
              <AlertCircle className="h-4 w-4 shrink-0" aria-hidden="true" />
              {error}
            </div>
          )}
          {success && (
            <div role="status" className="flex items-center gap-2 bg-green-50 border border-green-100 px-3 py-2 text-sm text-green-700">
              <CheckCircle className="h-4 w-4 shrink-0" aria-hidden="true" />
              Perfil actualizado correctamente.
            </div>
          )}

          {/* Acciones */}
          <div className="flex gap-3 pt-2 border-t border-gray-100">
            <Button
              type="submit"
              disabled={loading}
              className="bg-gartify-green hover:bg-gartify-green/90 text-white font-semibold gap-2"
            >
              {loading ? (
                <><Loader2 className="h-4 w-4 animate-spin" aria-hidden="true" />Guardando...</>
              ) : (
                <><ChevronRight className="h-4 w-4" aria-hidden="true" />Guardar cambios</>
              )}
            </Button>
            <Button
              type="button"
              className="bg-gartify-orange hover:bg-gartify-orange/90 text-white font-semibold"
              onClick={() => router.back()}
            >
              Cancelar
            </Button>
          </div>
        </form>
      </div>
    </div>
  );
}
