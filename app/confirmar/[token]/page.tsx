import { notFound } from "next/navigation";
import { db } from "@/lib/db";
import { formatDateTime } from "@/lib/utils";

interface Props {
  params: { token: string };
}

export default async function ConfirmarReservaPage({ params }: Props) {
  const { token } = params;

  let bookingId: string;
  let action: string = "ok";

  // Detectar si es bookingId directo o token base64url
  try {
    const decoded = Buffer.from(token, "base64url").toString("utf-8");
    const parts = decoded.split(":");
    if (parts.length === 2 && (parts[1] === "ok" || parts[1] === "no")) {
      bookingId = parts[0];
      action = parts[1];
    } else {
      bookingId = token; // bookingId directo
    }
  } catch {
    bookingId = token;
  }

  const isConfirm = action === "ok";

  const booking = await db.booking.findUnique({
    where: { id: bookingId },
    select: {
      id: true, status: true, date: true,
      clientName: true, serviceLabel: true,
      user:    { select: { name: true } },
      service: { select: { name: true } },
    },
  });

  if (!booking) notFound();

  const ACTIONABLE = ["PENDING", "PROPOSED"];
  const alreadyActioned = !ACTIONABLE.includes(booking.status);

  const tokenConfirm = Buffer.from(`${bookingId}:ok`).toString("base64url");
  const tokenReject  = Buffer.from(`${bookingId}:no`).toString("base64url");
  const actionToken  = isConfirm ? tokenConfirm : tokenReject;

  const actionLabel = isConfirm ? "Confirmar reserva" : "Rechazar reserva";
  const actionColor = isConfirm ? "#16a34a" : "#dc2626";
  const actionHover = isConfirm ? "#15803d" : "#b91c1c";
  const icon        = isConfirm ? "✅" : "❌";

  return (
    <html lang="es">
      <head>
        <meta charSet="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Gartify — {actionLabel}</title>
        <style>{`
          body { font-family: sans-serif; display: flex; align-items: center; justify-content: center;
                 min-height: 100vh; margin: 0; background: #f0f4ff; }
          .card { background: #fff; border-radius: 16px; padding: 2rem 2.5rem;
                  box-shadow: 0 4px 24px rgba(0,0,0,.08); text-align: center; max-width: 420px; width: 100%; }
          .logo { font-weight: 800; font-size: 1.3rem; color: #1E40AF; margin-bottom: 1.5rem; }
          .title { font-size: 1.2rem; font-weight: 700; color: #1e3a8a; margin-bottom: 1.25rem; }
          .info { background: #f8faff; border: 1px solid #dbeafe; border-radius: 10px;
                  padding: 1rem 1.25rem; text-align: left; margin-bottom: 1.5rem; }
          .info-row { display: flex; gap: .5rem; margin-bottom: .4rem; font-size: .9rem; color: #1e3a8a; }
          .info-row:last-child { margin-bottom: 0; }
          .label { font-weight: 600; min-width: 80px; }
          .notice { font-size: .9rem; color: #64748b; margin-bottom: 1.5rem; }
          .btn { display: block; width: 100%; padding: .75rem; border-radius: 8px; border: none;
                 font-size: 1rem; font-weight: 700; cursor: pointer; text-decoration: none;
                 margin-bottom: .75rem; box-sizing: border-box; }
          .btn-action { background: ${actionColor}; color: #fff; }
          .btn-action:hover { background: ${actionHover}; }
          .btn-cancel { background: #f1f5f9; color: #475569; }
          .btn-cancel:hover { background: #e2e8f0; }
        `}</style>
      </head>
      <body>
        <div className="card">
          <div className="logo">🔧 Gartify</div>

          {alreadyActioned ? (
            <>
              <p className="title">ℹ️ Esta reserva ya fue procesada</p>
              <p className="notice">Estado actual: <strong>{booking.status}</strong></p>
              <a className="btn btn-cancel" href="/cuenta/taller">Ir a Mis reservas</a>
            </>
          ) : (
            <>
              <p className="title">{icon} {actionLabel}</p>
              <div className="info">
                <div className="info-row"><span className="label">Cliente:</span> {booking.user?.name ?? booking.clientName ?? "—"}</div>
                <div className="info-row"><span className="label">Servicio:</span> {booking.service?.name ?? booking.serviceLabel ?? "—"}</div>
                <div className="info-row"><span className="label">Fecha:</span> {formatDateTime(booking.date)}</div>
              </div>
              <p className="notice">¿Confirmas esta acción?</p>
              <a className="btn btn-action" href={`/api/booking-action?t=${actionToken}`}>{icon} Sí, {isConfirm ? "confirmar" : "rechazar"}</a>
              <a className="btn btn-cancel" href="/cuenta/taller">Cancelar — volver a Mis reservas</a>
            </>
          )}
        </div>
      </body>
    </html>
  );
}
