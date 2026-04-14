import { notFound, redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { formatDate } from "@/lib/utils";
import { PrintTrigger } from "@/components/cuenta/PrintTrigger";

export const dynamic = "force-dynamic";

// ─── Tipos ────────────────────────────────────────────────────────────────────

type RegistroItem = {
  id: string;
  date: Date;
  mileage: number | null;
  workDone: string;
  nextReviewDate: Date | null;
  nextMileage: number | null;
  stampedBy: string | null;
  garage: { name: string; city: string };
};

// ─── Props ────────────────────────────────────────────────────────────────────

interface Props {
  params: Promise<{ id: string }>;
}

// ─── Página ───────────────────────────────────────────────────────────────────

export default async function PdfHistorialVehiculoPage({ params }: Props) {
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
          garage: { select: { name: true, city: true } },
        },
        orderBy: { date: "desc" },
      },
    },
  });

  // Verificar existencia y propiedad del vehículo
  if (!vehiculo || vehiculo.userId !== usuario.id) notFound();

  const { serviceRecords: registros } = vehiculo;
  const nombreVehiculo = vehiculo.alias ?? `${vehiculo.brand} ${vehiculo.model}`;
  const fechaGeneracion = new Intl.DateTimeFormat("es-ES", {
    day: "2-digit",
    month: "2-digit",
    year: "numeric",
  }).format(new Date());

  return (
    <>
      {/* Estilos de impresión: oculta el navbar y ajusta márgenes de página */}
      <style>{`
        @media print {
          nav,
          header:not(.print-keep),
          .no-print {
            display: none !important;
          }
          @page {
            margin: 1.5cm;
            size: A4;
          }
          body {
            font-size: 11pt;
          }
          .print-page {
            padding: 0 !important;
            max-width: 100% !important;
          }
        }
      `}</style>

      <div className="print-page relative font-sans text-gray-900 bg-white min-h-screen p-8 max-w-3xl mx-auto">

        {/* Sello estilo tampón */}
        <div
          aria-hidden="true"
          style={{
            position: "absolute",
            top: "120px",
            right: "32px",
            width: "130px",
            height: "130px",
            border: "4px double #dc2626",
            borderRadius: "50%",
            transform: "rotate(-18deg)",
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            justifyContent: "center",
            opacity: 0.55,
            color: "#dc2626",
            pointerEvents: "none",
            userSelect: "none",
          }}
        >
          <span style={{ fontSize: "20px", fontWeight: 900, letterSpacing: "0.08em", lineHeight: 1.1 }}>GARTIFY</span>
          <span style={{ fontSize: "8px", fontWeight: 700, letterSpacing: "0.25em", marginTop: "2px" }}>VERIFICADO</span>
          <span style={{ fontSize: "8px", marginTop: "4px", letterSpacing: "0.1em" }}>gartify.es</span>
        </div>

        {/* Cabecera del documento */}
        <header className="print-keep flex items-start justify-between border-b-2 border-gray-900 pb-4 mb-6">
          <div>
            <h1 className="text-2xl font-extrabold tracking-tight">
              Libro de Revisiones
            </h1>
            <p className="text-sm text-gray-600 mt-1">
              {nombreVehiculo} · {vehiculo.plate}
            </p>
          </div>
          <div className="text-right text-xs text-gray-500">
            <p className="text-lg font-extrabold text-gartify-blue">Gartify</p>
            <p>gartify.es</p>
          </div>
        </header>

        {/* Datos del vehículo */}
        <section
          aria-label="Datos del vehículo"
          className="mb-8 grid grid-cols-2 sm:grid-cols-4 gap-4 bg-gray-50 rounded-lg p-4 text-sm"
        >
          {vehiculo.year && (
            <DatoVehiculo etiqueta="Año" valor={String(vehiculo.year)} />
          )}
          {vehiculo.fuel && (
            <DatoVehiculo etiqueta="Combustible" valor={vehiculo.fuel} />
          )}
          {vehiculo.color && (
            <DatoVehiculo etiqueta="Color" valor={vehiculo.color} />
          )}
          {vehiculo.mileage !== null && (
            <DatoVehiculo
              etiqueta="Kilometraje"
              valor={`${vehiculo.mileage.toLocaleString("es-ES")} km`}
            />
          )}
          {vehiculo.itvDate && (
            <DatoVehiculo
              etiqueta="Próxima ITV"
              valor={formatDate(vehiculo.itvDate)}
            />
          )}
        </section>

        {/* Registros de revisión */}
        <section aria-labelledby="titulo-revisiones-pdf">
          <h2
            id="titulo-revisiones-pdf"
            className="text-base font-bold mb-4 border-b pb-2"
          >
            Historial de revisiones
          </h2>

          {registros.length === 0 ? (
            <p className="text-sm text-gray-500 italic">
              Sin revisiones registradas.
            </p>
          ) : (
            (registros as RegistroItem[]).map((registro, indice) => (
              <div
                key={registro.id}
                className="mb-6 pb-6 border-b border-gray-200 last:border-0"
              >
                {/* Número de revisión + fecha + taller */}
                <div className="flex justify-between items-start mb-2">
                  <div>
                    <span className="text-xs font-bold bg-gray-900 text-white rounded px-2 py-0.5 mr-2">
                      #{registros.length - indice}
                    </span>
                    <span className="font-semibold">{registro.garage.name}</span>
                    <span className="text-gray-500 text-sm ml-2">
                      · {registro.garage.city}
                    </span>
                  </div>
                  <span className="text-sm text-gray-600 whitespace-nowrap">
                    {formatDate(registro.date)}
                  </span>
                </div>

                {/* Trabajo realizado */}
                <p className="text-sm mb-2">
                  <strong>Trabajo:</strong> {registro.workDone}
                </p>

                {/* Detalles opcionales en línea */}
                <div className="flex flex-wrap gap-4 text-xs text-gray-500">
                  {registro.mileage !== null && (
                    <span>
                      Km: {registro.mileage.toLocaleString("es-ES")} km
                    </span>
                  )}
                  {registro.nextReviewDate && (
                    <span>
                      Próx. revisión: {formatDate(registro.nextReviewDate)}
                    </span>
                  )}
                  {registro.nextMileage !== null && registro.nextMileage !== undefined && (
                    <span>
                      Próx. km: {registro.nextMileage.toLocaleString("es-ES")} km
                    </span>
                  )}
                  {registro.stampedBy && (
                    <span>Responsable: {registro.stampedBy}</span>
                  )}
                </div>
              </div>
            ))
          )}
        </section>

        {/* Footer con marca Gartify y fecha de generación */}
        <footer className="mt-10 pt-4 border-t border-gray-300 text-xs text-gray-400 flex justify-between">
          <span>Generado por Gartify.es el {fechaGeneracion}</span>
          <span>
            {vehiculo.plate} · {vehiculo.brand} {vehiculo.model}
          </span>
        </footer>

        {/* Dispara window.print() al cargar — Client Component mínimo */}
        <PrintTrigger />
      </div>
    </>
  );
}

// ─── Componente auxiliar: dato del vehículo ───────────────────────────────────

function DatoVehiculo({
  etiqueta,
  valor,
}: {
  etiqueta: string;
  valor: string;
}) {
  return (
    <dl className="flex flex-col gap-0.5">
      <dt className="text-xs text-gray-500 font-medium">{etiqueta}</dt>
      <dd className="text-sm font-semibold text-gray-900">{valor}</dd>
    </dl>
  );
}
