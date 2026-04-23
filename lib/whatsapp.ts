import twilio from "twilio";
import { formatDate, formatDateTime } from "@/lib/utils";

const accountSid    = process.env.TWILIO_ACCOUNT_SID;
const authToken     = process.env.TWILIO_AUTH_TOKEN;
const from               = process.env.TWILIO_WHATSAPP_FROM ?? "whatsapp:+16623986756";
const MESSAGING_SERVICE  = process.env.TWILIO_MESSAGING_SERVICE_SID ?? "";
const CONTENT_SID   = "HX83d57f2fbdf7d895fba60f9438497a3e";

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
  bookingCode?:        string;
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

  const { garagePhone, customerName, serviceName, serviceDescription, date, vehicleModel, vehiclePlate, notes, bookingId, bookingCode } = params;

  const baseUrl         = process.env.NEXTAUTH_URL ?? "https://gartify.es";
  const tokenConfirm    = Buffer.from(`${bookingId}:ok`).toString("base64url");
  const tokenReject     = Buffer.from(`${bookingId}:no`).toString("base64url");
  const tokenReschedule = Buffer.from(`${bookingId}:reschedule`).toString("base64url");

  const descripcion     = serviceDescription || serviceName;
  const reagendarUrl    = `${baseUrl}/reserva/${bookingId}/reagendar?t=${tokenReschedule}`;

  const to = `whatsapp:${toE164(garagePhone)}`;

  console.log("[WhatsApp] Sending to:", to, "from:", from);
  console.log("[WhatsApp] bookingId:", bookingId, "tokenConfirm:", tokenConfirm, "tokenReschedule:", tokenReschedule);

  // Desglosar vehicleModel en "Marca Modelo Motor" (viene como string concatenado)
  const partes  = (vehicleModel ?? "").trim().split(/\s+/);
  const marca   = partes[0] || "—";
  const modelo  = partes[1] || "—";
  const motor   = partes.slice(2).join(" ") || "—";

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
            "4": vehiclePlate || "—",
            "5": marca,
            "6": modelo,
            "7": motor,
            "8": notes || "—",
            "9": bookingCode || bookingId,
            "10": bookingId,
            "11": bookingId,
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
            `🚗 Matrícula: ${vehiclePlate || "—"}`,
            `🏷️ Marca: ${marca}`,
            `🚘 Modelo: ${modelo}`,
            `⚙️ Motor: ${motor}`,
            notes ? `📋 Nota: ${notes}` : null,
            ``,
            `✅ Confirmar: ${baseUrl}/api/booking-action?t=${tokenConfirm}`,
            `🔄 Otro horario: ${reagendarUrl}`,
            `❌ Rechazar: ${baseUrl}/api/booking-action?t=${tokenReject}`,
          ].filter(Boolean).join("\n"),
        };

    const msg = await client.messages.create(msgParams);
    console.log("[WhatsApp] Sent OK — SID:", msg.sid, "status:", msg.status, useTemplate ? "(template)" : "(text)");
  } catch (err) {
    console.error("[WhatsApp] Error sending message:", err);
  }
}

// ─── Confirmación de reserva al conductor ────────────────────────────────────
// Template: HXb6b3a08a7939272409d7e487828c758a
// {{1}} Nombre conductor  {{2}} Taller  {{3}} Marca  {{4}} Modelo
// {{5}} Matrícula  {{6}} Servicio  {{7}} Fecha  {{8}} Hora
// {{9}} Dirección taller  {{10}} Código reserva  {{11}} URL detalle

const CONFIRM_CONTENT_SID = "HXb6b3a08a7939272409d7e487828c758a";

export interface ConfirmacionReservaParams {
  clientPhone:   string;
  clientName:    string;
  garageName:    string;
  garageAddress: string;
  vehicleModel?: string;
  vehiclePlate?: string;
  serviceName:   string;
  date:          Date;
  bookingId:     string;
  bookingCode?:  string;
}

export async function sendConfirmacionReservaWhatsApp(params: ConfirmacionReservaParams) {
  const client = getClient();
  if (!client) return;

  const { clientPhone, clientName, garageName, garageAddress, vehicleModel, vehiclePlate, serviceName, date, bookingId, bookingCode } = params;

  const partes = (vehicleModel ?? "").trim().split(/\s+/);
  const marca  = partes[0] || "—";
  const modelo = partes.slice(1).join(" ") || "—";

  const hora = new Intl.DateTimeFormat("es-ES", { timeStyle: "short" }).format(date);
  const baseUrl = process.env.NEXTAUTH_URL ?? "https://gartify.es";

  const to = `whatsapp:${toE164(clientPhone)}`;

  try {
    const msg = await client.messages.create({
      messagingServiceSid: MESSAGING_SERVICE,
      to,
      contentSid: CONFIRM_CONTENT_SID,
      contentVariables: JSON.stringify({
        "1":  clientName,
        "2":  garageName,
        "3":  marca,
        "4":  modelo,
        "5":  vehiclePlate || "—",
        "6":  serviceName,
        "7":  formatDate(date),
        "8":  hora,
        "9":  garageAddress,
        "10": bookingCode || bookingId,
        "11": `${baseUrl}/reserva/${bookingId}`,
      }),
    });
    console.log("[WhatsApp] ConfirmacionReserva sent OK — SID:", msg.sid);
  } catch (err) {
    console.error("[WhatsApp] Error sending ConfirmacionReserva:", err);
  }
}
