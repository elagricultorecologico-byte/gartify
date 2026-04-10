import twilio from "twilio";
import { formatDateTime } from "@/lib/utils";

const accountSid    = process.env.TWILIO_ACCOUNT_SID;
const authToken     = process.env.TWILIO_AUTH_TOKEN;
const from               = process.env.TWILIO_WHATSAPP_FROM ?? "whatsapp:+16623986756";
const MESSAGING_SERVICE  = process.env.TWILIO_MESSAGING_SERVICE_SID ?? "";
const CONTENT_SID   = "HX9e29ae8ef1bf90fc018636a52d60b94c";

function toE164(phone: string): string {
  const digits = phone.replace(/\D/g, "");
  if (digits.startsWith("34") && digits.length === 11) return `+${digits}`;
  if (digits.length === 9) return `+34${digits}`;
  return `+${digits}`;
}

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
  notes?:              string;
  bookingId:           string;
}

export interface PropostaHoraParams {
  clientPhone:  string;
  clientName:   string;
  garageName:   string;
  serviceName:  string;
  proposedDate: Date;
  bookingId:    string;
}

export async function sendPropostaHoraWhatsApp(params: PropostaHoraParams) {
  const client = getClient();
  if (!client) return;

  const { clientPhone, clientName, garageName, serviceName, proposedDate, bookingId } = params;
  const baseUrl     = process.env.NEXTAUTH_URL ?? "https://gartify.es";
  const tokenOk     = Buffer.from(`${bookingId}:ok`).toString("base64url");
  const tokenReject = Buffer.from(`${bookingId}:no`).toString("base64url");
  const to          = `whatsapp:${toE164(clientPhone)}`;

  const body = [
    `🔄 *Propuesta de nuevo horario*`,
    ``,
    `Hola ${clientName}, el taller *${garageName}* te propone un nuevo horario para tu reserva de *${serviceName}*:`,
    ``,
    `📅 Nueva fecha propuesta: ${formatDateTime(proposedDate)}`,
    ``,
    `✅ Aceptar: ${baseUrl}/api/booking-action?t=${tokenOk}`,
    `❌ Rechazar: ${baseUrl}/api/booking-action?t=${tokenReject}`,
    ``,
    `Si tienes dudas, contacta directamente con el taller.`,
  ].join("\n");

  try {
    const msg = await client.messages.create({ from, to, body });
    console.log("[WhatsApp] PropostaHora sent OK — SID:", msg.sid);
  } catch (err) {
    console.error("[WhatsApp] Error sending PropostaHora:", err);
  }
}

export async function sendNuevaReservaWhatsApp(params: NuevaReservaParams) {
  const client = getClient();
  if (!client) return;

  const { garagePhone, customerName, serviceName, serviceDescription, date, vehicleModel, vehiclePlate, notes, bookingId } = params;

  const baseUrl         = process.env.NEXTAUTH_URL ?? "https://gartify.es";
  const tokenConfirm    = Buffer.from(`${bookingId}:ok`).toString("base64url");
  const tokenReject     = Buffer.from(`${bookingId}:no`).toString("base64url");
  const tokenReschedule = Buffer.from(`${bookingId}:reschedule`).toString("base64url");

  const vehiculoInfo    = [vehicleModel, vehiclePlate].filter(Boolean).join(" · ") || "—";
  const descripcion     = serviceDescription || serviceName;
  const reagendarUrl    = `${baseUrl}/reserva/${bookingId}/reagendar?t=${tokenReschedule}`;

  const to = `whatsapp:${toE164(garagePhone)}`;

  console.log("[WhatsApp] Sending to:", to, "from:", from);
  console.log("[WhatsApp] bookingId:", bookingId, "tokenConfirm:", tokenConfirm, "tokenReschedule:", tokenReschedule);

  try {
    const useTemplate = process.env.TWILIO_USE_TEMPLATE === "true";
    const msgParams = useTemplate
      ? {
          messagingServiceSid: MESSAGING_SERVICE,
          to,
          contentSid: CONTENT_SID,
          contentVariables: JSON.stringify({
            "1": customerName,
            "2": serviceName,
            "3": formatDateTime(date),
            "4": vehiculoInfo,
            "5": notes || "—",
            "7": tokenConfirm,
            "8": tokenReschedule,
          }),
        }
      : {
          from,
          to,
          body: [
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
          ].join("\n"),
        };

    const msg = await client.messages.create(msgParams);
    console.log("[WhatsApp] Sent OK — SID:", msg.sid, "status:", msg.status, useTemplate ? "(template)" : "(text)");
  } catch (err) {
    console.error("[WhatsApp] Error sending message:", err);
  }
}
