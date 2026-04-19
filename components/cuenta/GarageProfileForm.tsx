"use client";
import { useState, useRef } from "react";
import { useRouter } from "next/navigation";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Textarea } from "@/components/ui/textarea";
import {
  CheckCircle, AlertCircle, Loader2, Building2,
  MapPin, Phone, Mail, ChevronRight, Camera, X, Car, PackageCheck,
} from "lucide-react";
import { cn, VEHICLE_TYPES, VEHICLE_LABELS, VEHICLE_ICONS, type VehicleType } from "@/lib/utils";
import type { Garage } from "@prisma/client";

export function GarageProfileForm({ garage }: { garage: Garage }) {
  const router = useRouter();

  // — Estado perfil —
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");
  const [success, setSuccess] = useState(false);

  const [courtesyCar, setCourtesyCar] = useState(garage.courtesyCar ?? false);
  const [pickupService, setPickupService] = useState(garage.pickupService ?? false);

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

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setLoading(true);
    setError("");
    setSuccess(false);
    const fd = new FormData(e.currentTarget);

    const res = await fetch("/api/garage/profile", {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        name:        fd.get("name"),
        description: fd.get("description"),
        address:     fd.get("address"),
        city:        fd.get("city"),
        postalCode:  fd.get("postalCode"),
        phone:       fd.get("phone"),
        email:       fd.get("email"),
        courtesyCar,
        pickupService,
        vehicleTypes: selectedVehicleTypes,
      }),
    });

    setLoading(false);
    if (!res.ok) {
      const d = await res.json() as { error?: string };
      setError(d.error ?? "Error al guardar");
      return;
    }
    setSuccess(true);
    router.refresh();
  }

  return (
    <div className="space-y-6">

      {/* ── Sección logo ── */}
      <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
        <div className="bg-gradient-to-r from-gartify-hero to-gartify-mid px-6 py-4">
          <div className="flex items-center gap-3">
            <div className="flex h-9 w-9 items-center justify-center rounded-lg bg-white/20 border border-white/30 shrink-0">
              <Camera className="h-4 w-4 text-white" aria-hidden="true" />
            </div>
            <div>
              <h2 className="text-sm font-bold text-white">Imagen del taller</h2>
              <p className="text-xs text-blue-100 mt-0.5">Aparece en los listados y en tu perfil público</p>
            </div>
          </div>
        </div>

        <div className="p-6">
          <div className="flex items-start gap-5 flex-wrap sm:flex-nowrap">
            {/* Preview */}
            <div className="shrink-0">
              <div className="h-24 w-24 rounded-xl overflow-hidden border-2 border-gray-200 bg-white flex items-center justify-center">
                {/* eslint-disable-next-line @next/next/no-img-element */}
                <img
                  src={logoPreview ?? "/logo-letra-fondo-azul.png"}
                  alt="Vista previa del logo"
                  className={logoPreview && logoPreview !== "/logo-letra-fondo-azul.png"
                    ? "w-full h-full object-cover rounded-xl"
                    : "w-full h-full object-cover rounded-xl"}
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
                  className="inline-flex items-center gap-2 cursor-pointer px-4 py-2 rounded-lg border border-gartify-blue/30 bg-gartify-blue/5 text-gartify-blue text-sm font-semibold hover:bg-gartify-blue/10 transition-colors"
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
                      className="inline-flex items-center gap-1 px-3 py-2 rounded-lg text-sm text-gartify-gray hover:text-red-500 transition-colors"
                      aria-label="Cancelar selección"
                    >
                      <X className="h-4 w-4" aria-hidden="true" />
                      Cancelar
                    </button>
                  </>
                )}
              </div>

              {logoError && (
                <div role="alert" className="flex items-center gap-2 rounded-lg bg-red-50 border border-red-100 px-3 py-2 text-xs text-red-600">
                  <AlertCircle className="h-3.5 w-3.5 shrink-0" aria-hidden="true" />
                  {logoError}
                </div>
              )}
              {logoSuccess && (
                <div role="status" className="flex items-center gap-2 rounded-lg bg-green-50 border border-green-100 px-3 py-2 text-xs text-green-700">
                  <CheckCircle className="h-3.5 w-3.5 shrink-0" aria-hidden="true" />
                  Imagen actualizada correctamente.
                </div>
              )}
            </div>
          </div>
        </div>
      </div>

      {/* ── Datos del perfil ── */}
      <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
        <div className="bg-gradient-to-r from-gartify-hero to-gartify-mid px-6 py-5">
          <div className="flex items-center gap-3">
            <div className="flex h-10 w-10 items-center justify-center rounded-xl bg-white/20 border border-white/30 shrink-0">
              <Building2 className="h-5 w-5 text-white" aria-hidden="true" />
            </div>
            <div>
              <h2 className="text-base font-bold text-white">Editar perfil del taller</h2>
              <p className="text-xs text-blue-100 mt-0.5">Actualiza la información pública de tu taller</p>
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
                <div className="col-span-2 space-y-1.5">
                  <Label htmlFor="city" className="text-xs font-semibold text-gartify-blue">
                    Ciudad
                  </Label>
                  <Input
                    id="city"
                    name="city"
                    defaultValue={garage.city}
                    required
                    placeholder="Madrid"
                    autoComplete="address-level2"
                  />
                </div>
                <div className="space-y-1.5">
                  <Label htmlFor="postalCode" className="text-xs font-semibold text-gartify-blue">
                    C.P.
                  </Label>
                  <Input
                    id="postalCode"
                    name="postalCode"
                    defaultValue={garage.postalCode}
                    maxLength={5}
                    required
                    placeholder="28009"
                    autoComplete="postal-code"
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
                <Input
                  id="phone"
                  name="phone"
                  defaultValue={garage.phone}
                  required
                  placeholder="91 000 00 00"
                  autoComplete="tel"
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

          {/* Feedback */}
          {error && (
            <div role="alert" className="flex items-center gap-2 rounded-lg bg-red-50 border border-red-100 px-3 py-2 text-sm text-red-600">
              <AlertCircle className="h-4 w-4 shrink-0" aria-hidden="true" />
              {error}
            </div>
          )}
          {success && (
            <div role="status" className="flex items-center gap-2 rounded-lg bg-green-50 border border-green-100 px-3 py-2 text-sm text-green-700">
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
