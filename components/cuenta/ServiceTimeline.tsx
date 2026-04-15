import { CheckCircle, Wrench, Calendar, Gauge, User, Euro } from "lucide-react";
import { formatDate, formatPrice } from "@/lib/utils";

// ─── Tipos ────────────────────────────────────────────────────────────────────

export type ServiceRecordItem = {
  id: string;
  date: Date | string;
  mileage: number | null;
  workDone: string;
  nextReviewDate: Date | string | null;
  nextMileage: number | null;
  price: number | null;
  stampedBy: string | null;
  vehiclePlate: string | null;
  vehicleModel: string | null;
  garage: { name: string; city: string };
};

interface Props {
  records: ServiceRecordItem[];
}

// ─── Componente principal ─────────────────────────────────────────────────────

export function ServiceTimeline({ records }: Props) {
  return (
    <ol className="relative" aria-label="Historial de revisiones">
      {/* Línea vertical del timeline */}
      <div
        className="absolute left-4 top-0 bottom-0 w-0.5 bg-gartify-blue/20"
        aria-hidden="true"
      />

      <div className="space-y-6">
        {records.map((record, indice) => (
          <EntradaTimeline
            key={record.id}
            record={record}
            esMasReciente={indice === 0}
          />
        ))}
      </div>
    </ol>
  );
}

// ─── Entrada individual del timeline ─────────────────────────────────────────

interface PropsEntrada {
  record: ServiceRecordItem;
  esMasReciente: boolean;
}

function EntradaTimeline({ record, esMasReciente }: PropsEntrada) {
  return (
    <li className="relative pl-12">
      {/* Dot/círculo naranja conectado a la línea */}
      <div
        className="absolute left-0 top-5 flex h-8 w-8 items-center justify-center rounded-full bg-gartify-orange shadow-sm ring-4 ring-white"
        aria-hidden="true"
      >
        <Wrench className="h-3.5 w-3.5 text-white" />
      </div>

      {/* Tarjeta de la revisión */}
      <article
        className={`bg-white rounded-2xl shadow-sm border transition-shadow hover:shadow-md ${
          esMasReciente
            ? "border-gartify-orange/50 ring-1 ring-gartify-orange/20"
            : "border-gray-200"
        }`}
      >
        {/* Cabecera de la tarjeta */}
        <div className="flex flex-wrap items-start justify-between gap-3 p-4 pb-3 border-b border-gray-100">
          <div>
            <p className="font-bold text-gartify-blue text-sm">
              {record.garage.name}
            </p>
            <p className="text-xs text-muted-foreground">{record.garage.city}</p>
          </div>
          <div className="text-right shrink-0">
            <time
              dateTime={new Date(record.date).toISOString()}
              className="text-sm font-semibold text-foreground"
            >
              {formatDate(record.date)}
            </time>
            {esMasReciente && (
              <p className="text-xs text-gartify-orange font-medium">
                Más reciente
              </p>
            )}
          </div>
        </div>

        {/* Cuerpo de la tarjeta */}
        <div className="p-4 space-y-3">
          {/* Sello oficial */}
          <SelloOficial stampedBy={record.stampedBy} />

          {/* Trabajo realizado */}
          <div>
            <p className="text-xs font-semibold text-foreground/60 uppercase tracking-wide mb-1">
              Trabajo realizado
            </p>
            <p className="text-sm text-foreground leading-relaxed whitespace-pre-line">
              {record.workDone}
            </p>
          </div>

          {/* Detalles adicionales */}
          <DetallesRevision record={record} />
        </div>
      </article>
    </li>
  );
}

// ─── Sello oficial ────────────────────────────────────────────────────────────

function SelloOficial({ stampedBy }: { stampedBy: string | null }) {
  return (
    <div className="inline-flex items-center gap-1.5 border-2 border-dashed border-gartify-blue/40 rounded-lg px-3 py-1 bg-blue-50/50">
      <CheckCircle className="h-3.5 w-3.5 text-gartify-blue" aria-hidden="true" />
      <span className="text-xs font-bold text-gartify-blue uppercase tracking-wider">
        Revisado
      </span>
      {stampedBy && (
        <span className="text-xs text-gartify-gray">· {stampedBy}</span>
      )}
    </div>
  );
}

// ─── Detalles de la revisión ──────────────────────────────────────────────────

function DetallesRevision({ record }: { record: ServiceRecordItem }) {
  const tieneDetalles =
    record.mileage !== null ||
    record.nextReviewDate !== null ||
    record.nextMileage !== null ||
    record.price !== null ||
    record.stampedBy !== null;

  if (!tieneDetalles) return null;

  return (
    <dl className="grid grid-cols-1 sm:grid-cols-2 gap-x-6 gap-y-2 pt-2 border-t border-gray-100">
      {/* Precio */}
      {record.price !== null && (
        <DetalleItem
          icono={<Euro className="h-3.5 w-3.5 text-gartify-green" aria-hidden="true" />}
          etiqueta="Importe"
          valor={formatPrice(record.price)}
        />
      )}

      {/* Kilometraje en el servicio */}
      {record.mileage !== null && (
        <DetalleItem
          icono={<Gauge className="h-3.5 w-3.5 text-gartify-orange" aria-hidden="true" />}
          etiqueta="Km en el servicio"
          valor={`${record.mileage.toLocaleString("es-ES")} km`}
        />
      )}

      {/* Responsable */}
      {record.stampedBy && (
        <DetalleItem
          icono={<User className="h-3.5 w-3.5 text-gartify-gray" aria-hidden="true" />}
          etiqueta="Responsable"
          valor={record.stampedBy}
        />
      )}

      {/* Próxima revisión — fecha */}
      {record.nextReviewDate !== null && (
        <DetalleItem
          icono={<Calendar className="h-3.5 w-3.5 text-gartify-blue" aria-hidden="true" />}
          etiqueta="Próxima revisión"
          valor={formatDate(record.nextReviewDate)}
        />
      )}

      {/* Próxima revisión — kilómetros */}
      {record.nextMileage !== null && (
        <DetalleItem
          icono={<Gauge className="h-3.5 w-3.5 text-gartify-blue" aria-hidden="true" />}
          etiqueta="Próxima revisión (km)"
          valor={`${record.nextMileage.toLocaleString("es-ES")} km`}
        />
      )}
    </dl>
  );
}

// ─── Detalle individual ───────────────────────────────────────────────────────

function DetalleItem({
  icono,
  etiqueta,
  valor,
}: {
  icono: React.ReactNode;
  etiqueta: string;
  valor: string;
}) {
  return (
    <div className="flex items-center gap-2 text-xs">
      {icono}
      <dt className="text-muted-foreground font-medium">{etiqueta}:</dt>
      <dd className="text-foreground">{valor}</dd>
    </div>
  );
}
