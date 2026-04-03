import twilio from "twilio";
import { formatDateTime } from "@/lib/utils";

const accountSid    = process.env.TWILIO_ACCOUNT_SID;
const authToken     = process.env.TWILIO_AUTH_TOKEN;
const from          = process.env.TWILIO_WHATSAPP_FROM ?? "whatsapp:+14155238886";
// Content SID para producción con botones nativos de WhatsApp
// const CONTENT_SID = "HX37ed2b05561756c3f145930cee20702b";

function getClient() {
  if (!accountSid || !authToken) {
    console.warn("[WhatsApp] Twilio credentials not configured — TWILIO_ACCOUNT_SID:", accountSid ? "OK" : "MISSING", "TWILIO_AUTH_TOKEN:", authToken ? "OK" : "MISSING");
    return null;
  }
  return twilio(accountSid, authToken);
}

export interface NuevaReservaParams {
  garagePhone:         string;
  customerName:        string;
  serviceName:         string;
  serviceDescription?: string;
  date:                Date;
  vehicleModel?:       string;
  vehiclePlate?:       string;
  bookingId:           string;
}

export async function sendNuevaReservaWhatsApp(params: NuevaReservaParams) {
  const client = getClient();
  if (!client) return;

  const { garagePhone, customerName, serviceName, serviceDescription, date, vehicleModel, vehiclePlate, bookingId } = params;

  const baseUrl         = process.env.NEXTAUTH_URL ?? "https://gartify.es";
  const tokenConfirm    = Buffer.from(`${bookingId}:ok`).toString("base64url");
  const tokenReject     = Buffer.from(`${bookingId}:no`).toString("base64url");
  const tokenReschedule = Buffer.from(`${bookingId}:reschedule`).toString("base64url");

  const vehiculoInfo    = [vehicleModel, vehiclePlate].filter(Boolean).join(" · ") || "—";
  const descripcion     = serviceDescription || serviceName;
  const reagendarUrl    = `${baseUrl}/reserva/${bookingId}/reagendar?t=${tokenReschedule}`;

  const to = `whatsapp:${garagePhone.replace(/\s/g, "")}`;

  console.log("[WhatsApp] Sending to:", to, "from:", from);

  const body = [
    `🔧 *Nueva reserva en Gartify*`,
    ``,
    `👤 Cliente: ${customerName}`,
    `🛠️ Servicio: ${serviceName}`,
    `📝 ${descripcion}`,
    `📅 Fecha: ${formatDateTime(date)}`,
    `🚗 Vehículo: ${vehiculoInfo}`,
    ``,
    `✅ Confirmar: ${baseUrl}/api/booking-action?t=${tokenConfirm}`,
    `🔄 Otro horario: ${reagendarUrl}`,
    `❌ Rechazar: ${baseUrl}/api/booking-action?t=${tokenReject}`,
  ].join("\n");

  try {
    const msg = await client.messages.create({ from, to, body });
    console.log("[WhatsApp] Sent OK — SID:", msg.sid, "status:", msg.status);
  } catch (err) {
    console.error("[WhatsApp] Error sending message:", err);
  }
}
