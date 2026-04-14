import type { Metadata } from "next";
import Link from "next/link";
import { notFound, redirect } from "next/navigation";
import {
  ArrowLeft,
  Car,
  CalendarCheck,
  Fuel,
  Gauge,
  Palette,
  ClipboardList,
} from "lucide-react";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { ServiceTimeline } from "@/components/cuenta/ServiceTimeline";
import { formatDate } from "@/lib/utils";

export const dynamic = "force-dynamic";

export const metadata: Metadata = {
  title: "Historial del vehículo",
  robots: { index: false, follow: false },
};

// ─── Página ───────────────────────────────────────────────────────────────────

interface Props {
  params: Promise<{ id: string }>;
}

export default async function HistorialVehiculoPage({ params }: Props) {
  const { id } = await params;

  // Verificación de sesión
  const sesion = await auth();
  if (!sesion?.user?.id) redirect("/login");

  const usuario = sesion.user as { id: string; role?: string };

  // Solo clientes tienen historial de vehículos
  if (usuario.role === "GARAGE_OWNER") redirect("/cuenta/taller");
  if (usuario.role === "ADMIN") redirect("/admin");

  // Cargar vehículo con sus revisiones, verificando propiedad
  const vehiculo = await db.vehicle.findUnique({
    where: { id },
    select: {
      id: true,
      alias: true,
      plate: true,
      brand: true,
      model: true,
      year: true,
      color: true,
      fuel: true,
      mileage: true,
      itvDate: true,
      userId: true,
      serviceRecords: {
        select: {
          id: true,
          date: true,
          mileage: true,
          workDone: true,
          nextReviewDate: true,
          nextMileage: true,
          stampedBy: true,
          vehiclePlate: true,
          vehicleModel: true,
          garage: { select: { name: true, city: true } },
        },
        orderBy: { date: "desc" },
      },
    },
  });

  // Verificar existencia y propiedad del vehículo
  if (!vehiculo || vehiculo.userId !== usuario.id) notFound();

  const nombreVehiculo = vehiculo.alias ?? `${vehiculo.brand} ${vehiculo.model}`;

  return (
    <div className="container max-w-3xl py-10 px-4 sm:px-8">

      {/* Enlace de vuelta */}
      <Link
        href="/cuenta/vehiculos"
        className="inline-flex items-center gap-1.5 text-sm text-gartify-gray hover:text-gartify-blue transition-colors mb-6"
      >
        <ArrowLeft className="h-4 w-4" aria-hidden="true" />
        Mis vehículos
      </Link>

      {/* Cabecera */}
      <div className="mb-8">
        <h1 className="text-2xl font-bold text-gartify-blue">{nombreVehiculo}</h1>
        <p className="text-muted-foreground text-sm mt-1">
          Historial completo de revisiones y sellos de taller
        </p>
      </div>

      {/* Tarjeta de datos del vehículo */}
      <TarjetaVehiculo vehiculo={vehiculo} />

      {/* Libro de revisiones */}
      <section className="mt-10" aria-labelledby="titulo-revisiones">
        <div className="flex items-center gap-2 mb-6">
          <ClipboardList
            className="h-5 w-5 text-gartify-orange"
            aria-hidden="true"
          />
          <h2
            id="titulo-revisiones"
            className="text-lg font-bold text-foreground"
          >
            Libro de revisiones
          </h2>
          {vehiculo.serviceRecords.length > 0 && (
            <span className="ml-auto text-xs font-medium text-muted-foreground bg-gray-100 rounded-full px-2.5 py-0.5">
              {vehiculo.serviceRecords.length}{" "}
              {vehiculo.serviceRecords.length === 1 ? "entrada" : "entradas"}
            </span>
          )}
        </div>

        {vehiculo.serviceRecords.length === 0 ? (
          <EstadoVacio />
        ) : (
          <ServiceTimeline records={vehiculo.serviceRecords} />
        )}
      </section>
    </div>
  );
}

// ─── Tarjeta de datos del vehículo ────────────────────────────────────────────

type VehiculoResumen = {
  alias: string | null;
  plate: string;
  brand: string;
  model: string;
  year: number | null;
  color: string | null;
  fuel: string | null;
  mileage: number | null;
  itvDate: Date | string | null;
};

function TarjetaVehiculo({ vehiculo: v }: { vehiculo: VehiculoResumen }) {
  return (
    <div className="bg-white border border-gray-200 rounded-2xl shadow-sm overflow-hidden">
      {/* Banda de color superior */}
      <div className="h-1.5 bg-gradient-to-r from-gartify-blue to-gartify-orange" />

      <div className="p-5">
        {/* Cabecera: icono + nombre + matrícula */}
        <div className="flex items-start gap-4 mb-5">
          <div
            className="h-12 w-12 rounded-xl bg-gradient-to-br from-gartify-blue to-blue-400 flex items-center justify-center shrink-0"
            aria-hidden="true"
          >
            <Car className="h-6 w-6 text-white" />
          </div>
          <div>
            <p className="font-bold text-gartify-blue text-base leading-tight">
              {v.alias ? v.alias : `${v.brand} ${v.model}`}
            </p>
            {v.alias && (
              <p className="text-sm text-muted-foreground">
                {v.brand} {v.model}
              </p>
            )}
            <span className="inline-block mt-1.5 font-mono font-bold text-sm tracking-widest bg-gartify-orange/10 text-gartify-orange border border-gartify-orange/20 rounded-md px-2.5 py-0.5">
              {v.plate}
            </span>
          </div>
          {v.year && (
            <span className="ml-auto text-sm font-semibold text-muted-foreground">
              {v.year}
            </span>
          )}
        </div>

        {/* Grid de datos */}
        <dl className="grid grid-cols-2 sm:grid-cols-4 gap-4">
          {v.fuel && (
            <DatoVehiculo
              icono={<Fuel className="h-4 w-4 text-gartify-orange" aria-hidden="true" />}
              etiqueta="Combustible"
              valor={v.fuel}
            />
          )}
          {v.color && (
            <DatoVehiculo
              icono={<Palette className="h-4 w-4 text-gartify-orange" aria-hidden="true" />}
              etiqueta="Color"
              valor={v.color}
            />
          )}
          {v.mileage !== null && (
            <DatoVehiculo
              icono={<Gauge className="h-4 w-4 text-gartify-orange" aria-hidden="true" />}
              etiqueta="Kilometraje"
              valor={`${v.mileage.toLocaleString("es-ES")} km`}
            />
          )}
          {v.itvDate && (
            <DatoVehiculo
              icono={<CalendarCheck className="h-4 w-4 text-gartify-orange" aria-hidden="true" />}
              etiqueta="Próxima ITV"
              valor={formatDate(v.itvDate)}
            />
          )}
        </dl>
      </div>
    </div>
  );
}

function DatoVehiculo({
  icono,
  etiqueta,
  valor,
}: {
  icono: React.ReactNode;
  etiqueta: string;
  valor: string;
}) {
  return (
    <div className="flex flex-col gap-1">
      <dt className="flex items-center gap-1.5 text-xs text-muted-foreground font-medium">
        {icono}
        {etiqueta}
      </dt>
      <dd className="text-sm font-semibold text-foreground pl-5">{valor}</dd>
    </div>
  );
}

// ─── Estado vacío ─────────────────────────────────────────────────────────────

function EstadoVacio() {
  return (
    <div className="text-center py-14 rounded-2xl border border-dashed border-gray-200 bg-gray-50">
      <ClipboardList
        className="h-10 w-10 mx-auto mb-3 text-gartify-gray opacity-40"
        aria-hidden="true"
      />
      <p className="font-semibold text-foreground">
        Este vehículo aún no tiene revisiones registradas
      </p>
      <p className="text-sm text-muted-foreground mt-1 max-w-xs mx-auto">
        Cuando un taller complete tu reserva y emita el sello de revisión,
        aparecerá aquí.
      </p>
    </div>
  );
}
