/**
 * Gartify — Email HTML templates
 * All styles are inline (required for email client compatibility).
 * Brand colors: blue #1a3664 · mid #1e7fc2 · orange #F5A623 · green #22a855
 */

const BASE_URL = process.env.NEXT_PUBLIC_BASE_URL ?? "https://gartify.es";

// ─── Shared layout ────────────────────────────────────────────────────────────

function layout(content: string): string {
  return `<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Gartify</title>
</head>
<body style="margin:0;padding:0;background:#f1f5f9;font-family:Arial,sans-serif;">
  <table width="100%" cellpadding="0" cellspacing="0" style="background:#f1f5f9;padding:32px 16px;">
    <tr><td align="center">
      <table width="600" cellpadding="0" cellspacing="0" style="max-width:600px;width:100%;background:#ffffff;border-radius:12px;overflow:hidden;border:1px solid #e2e8f0;">

        <!-- HEADER -->
        <tr>
          <td style="background:#1a5496;padding:28px 32px;text-align:center;">
            <div style="font-size:28px;font-weight:900;letter-spacing:2px;color:#ffffff;font-family:Arial,sans-serif;">
              GAR<span style="color:#F5A623;">TIFY</span>
            </div>
            <div style="font-size:11px;color:#93c5fd;margin-top:6px;letter-spacing:2px;text-transform:uppercase;font-family:Arial,sans-serif;">
              Encuentra tu taller de confianza
            </div>
          </td>
        </tr>

        <!-- BODY -->
        <tr>
          <td style="padding:32px;">
            ${content}
          </td>
        </tr>

        <!-- FOOTER -->
        <tr>
          <td style="background:#1a3664;padding:20px 32px;text-align:center;">
            <p style="margin:0;font-size:12px;color:rgba(255,255,255,0.5);">
              © ${new Date().getFullYear()} Gartify · Encuentra tu taller de confianza en España
            </p>
            <p style="margin:6px 0 0;font-size:11px;">
              <a href="${BASE_URL}" style="color:#93c5fd;text-decoration:none;">gartify.es</a>
              &nbsp;·&nbsp;
              <a href="${BASE_URL}/privacidad" style="color:#93c5fd;text-decoration:none;">Privacidad</a>
              &nbsp;·&nbsp;
              <a href="${BASE_URL}/contacto" style="color:#93c5fd;text-decoration:none;">Contacto</a>
            </p>
          </td>
        </tr>

      </table>
    </td></tr>
  </table>
</body>
</html>`;
}

function detailRow(icon: string, label: string, value: string): string {
  return `<tr>
    <td style="padding:8px 12px;border-bottom:1px solid #f1f5f9;">
      <span style="font-size:14px;color:#64748b;">${icon} ${label}</span>
    </td>
    <td style="padding:8px 12px;border-bottom:1px solid #f1f5f9;text-align:right;">
      <span style="font-size:14px;font-weight:600;color:#1a3664;">${value}</span>
    </td>
  </tr>`;
}

function statusBadge(status: string): string {
  const map: Record<string, { label: string; bg: string; color: string }> = {
    PENDING:   { label: "Pendiente",  bg: "#fef9c3", color: "#a16207" },
    CONFIRMED: { label: "Confirmada", bg: "#dbeafe", color: "#1d4ed8" },
    COMPLETED: { label: "Completada", bg: "#dcfce7", color: "#15803d" },
    CANCELLED: { label: "Cancelada",  bg: "#fee2e2", color: "#b91c1c" },
  };
  const s = map[status] ?? { label: status, bg: "#f1f5f9", color: "#64748b" };
  return `<span style="display:inline-block;background:${s.bg};color:${s.color};font-size:12px;font-weight:700;padding:3px 10px;border-radius:20px;">${s.label}</span>`;
}

// ─── Template 1: Booking confirmation → Customer ──────────────────────────────

export interface BookingEmailData {
  customerName:  string;
  customerEmail: string;
  garageName:    string;
  garageAddress: string;
  garagePhone:   string;
  serviceName:   string;
  serviceType:   string;
  date:          Date;
  duration:      number;
  totalPrice:    number;
  vehiclePlate?: string;
  vehicleModel?: string;
  notes?:        string;
  bookingId:     string;
}

export function bookingConfirmationEmail(d: BookingEmailData): { subject: string; html: string } {
  const formattedDate = new Intl.DateTimeFormat("es-ES", {
    weekday: "long", day: "numeric", month: "long", year: "numeric",
    hour: "2-digit", minute: "2-digit",
  }).format(d.date);

  const formattedPrice = new Intl.NumberFormat("es-ES", { style: "currency", currency: "EUR" }).format(d.totalPrice);

  const html = layout(`
    <!-- Icon + title -->
    <div style="text-align:center;margin-bottom:28px;">
      <div style="display:inline-flex;align-items:center;justify-content:center;width:56px;height:56px;background:#dcfce7;border-radius:50%;border:2px solid #bbf7d0;margin-bottom:12px;">
        <span style="font-size:28px;">✓</span>
      </div>
      <h1 style="margin:0;font-size:22px;font-weight:800;color:#1a3664;">¡Reserva recibida!</h1>
      <p style="margin:6px 0 0;font-size:14px;color:#64748b;">Hola <strong>${d.customerName}</strong>, hemos enviado tu solicitud al taller.</p>
    </div>

    <!-- Status -->
    <div style="text-align:center;margin-bottom:24px;">
      ${statusBadge("PENDING")}
    </div>

    <!-- Booking detail card -->
    <div style="border:1px solid #e2e8f0;border-radius:10px;overflow:hidden;margin-bottom:20px;">
      <div style="background:#1a5496;padding:10px 16px;">
        <span style="font-size:11px;font-weight:800;letter-spacing:2px;text-transform:uppercase;color:rgba(255,255,255,0.75);">Detalle de la reserva</span>
      </div>
      <table width="100%" cellpadding="0" cellspacing="0">
        ${detailRow("📍", "Taller",        d.garageName)}
        ${detailRow("🏠", "Dirección",     d.garageAddress)}
        ${detailRow("📞", "Teléfono",      d.garagePhone)}
        ${detailRow("🔧", "Servicio",      d.serviceName)}
        ${detailRow("📅", "Fecha y hora",  formattedDate)}
        ${detailRow("⏱", "Duración",      `${d.duration} min`)}
        ${d.vehicleModel ? detailRow("🚗", "Vehículo", d.vehicleModel) : ""}
        ${d.vehiclePlate ? detailRow("🪪", "Matrícula", d.vehiclePlate) : ""}
        ${d.notes        ? detailRow("📝", "Notas",     d.notes)        : ""}
      </table>
      <!-- Price row -->
      <div style="padding:12px 16px;background:#f8fafc;display:flex;justify-content:space-between;align-items:center;">
        <span style="font-size:14px;font-weight:700;color:#1a3664;">Total a pagar en taller</span>
        <span style="font-size:20px;font-weight:900;color:#F5A623;">${formattedPrice}</span>
      </div>
    </div>

    <!-- Info note -->
    <div style="background:#eff6ff;border:1px solid #bfdbfe;border-radius:8px;padding:12px 16px;margin-bottom:24px;font-size:13px;color:#1d4ed8;">
      💡 El taller puede contactarte para confirmar la cita. El pago se realiza directamente en el taller al recoger tu vehículo.
    </div>

    <!-- CTA button -->
    <div style="text-align:center;margin-bottom:8px;">
      <a href="${BASE_URL}/reserva/${d.bookingId}"
         style="display:inline-block;background:#22a855;color:#ffffff;font-size:15px;font-weight:700;padding:13px 32px;border-radius:8px;text-decoration:none;">
        Ver mi reserva
      </a>
    </div>
  `);

  return {
    subject: `✅ Reserva recibida en ${d.garageName} — ${formattedDate}`,
    html,
  };
}

// ─── Template 2: New booking notification → Garage owner ─────────────────────

export function garageNewBookingEmail(d: BookingEmailData): { subject: string; html: string } {
  const formattedDate = new Intl.DateTimeFormat("es-ES", {
    weekday: "long", day: "numeric", month: "long", year: "numeric",
    hour: "2-digit", minute: "2-digit",
  }).format(d.date);

  const formattedPrice = new Intl.NumberFormat("es-ES", { style: "currency", currency: "EUR" }).format(d.totalPrice);

  const html = layout(`
    <!-- Title -->
    <div style="text-align:center;margin-bottom:28px;">
      <div style="display:inline-flex;align-items:center;justify-content:center;width:56px;height:56px;background:#dbeafe;border-radius:50%;border:2px solid #bfdbfe;margin-bottom:12px;">
        <span style="font-size:28px;">🔔</span>
      </div>
      <h1 style="margin:0;font-size:22px;font-weight:800;color:#1a3664;">Nueva reserva recibida</h1>
      <p style="margin:6px 0 0;font-size:14px;color:#64748b;">Un cliente ha solicitado cita en <strong>${d.garageName}</strong>.</p>
    </div>

    <!-- Status -->
    <div style="text-align:center;margin-bottom:24px;">
      ${statusBadge("PENDING")}
    </div>

    <!-- Customer info -->
    <div style="border:1px solid #e2e8f0;border-radius:10px;overflow:hidden;margin-bottom:20px;">
      <div style="background:#f8fafc;padding:10px 16px;border-bottom:1px solid #e2e8f0;">
        <span style="font-size:11px;font-weight:800;letter-spacing:2px;text-transform:uppercase;color:#64748b;">👤 Cliente</span>
      </div>
      <table width="100%" cellpadding="0" cellspacing="0">
        ${detailRow("👤", "Nombre",  d.customerName)}
        ${detailRow("✉️", "Email",   d.customerEmail)}
        ${d.vehicleModel ? detailRow("🚗", "Vehículo", d.vehicleModel) : ""}
        ${d.vehiclePlate ? detailRow("🪪", "Matrícula", d.vehiclePlate) : ""}
        ${d.notes        ? detailRow("📝", "Notas",     d.notes)        : ""}
      </table>
    </div>

    <!-- Booking detail -->
    <div style="border:1px solid #e2e8f0;border-radius:10px;overflow:hidden;margin-bottom:20px;">
      <div style="background:#1a5496;padding:10px 16px;">
        <span style="font-size:11px;font-weight:800;letter-spacing:2px;text-transform:uppercase;color:rgba(255,255,255,0.75);">Detalle de la cita</span>
      </div>
      <table width="100%" cellpadding="0" cellspacing="0">
        ${detailRow("🔧", "Servicio",     d.serviceName)}
        ${detailRow("📅", "Fecha y hora", formattedDate)}
        ${detailRow("⏱", "Duración",     `${d.duration} min`)}
      </table>
      <div style="padding:12px 16px;background:#f8fafc;">
        <span style="font-size:14px;font-weight:700;color:#1a3664;">Precio acordado: </span>
        <span style="font-size:20px;font-weight:900;color:#F5A623;">${formattedPrice}</span>
      </div>
    </div>

    <!-- CTA buttons -->
    <div style="text-align:center;margin-bottom:8px;">
      <a href="${BASE_URL}/cuenta/taller"
         style="display:inline-block;background:#1a3664;color:#ffffff;font-size:15px;font-weight:700;padding:13px 32px;border-radius:8px;text-decoration:none;margin-right:8px;">
        Gestionar reservas
      </a>
    </div>
  `);

  return {
    subject: `🔔 Nueva reserva — ${d.customerName} · ${formattedDate}`,
    html,
  };
}

// ─── Template 3: Welcome → new Customer ──────────────────────────────────────

export function welcomeCustomerEmail(name: string): { subject: string; html: string } {
  const html = layout(`
    <div style="text-align:center;margin-bottom:28px;">
      <div style="display:inline-flex;align-items:center;justify-content:center;width:56px;height:56px;background:#dcfce7;border-radius:50%;border:2px solid #bbf7d0;margin-bottom:12px;">
        <span style="font-size:28px;">👋</span>
      </div>
      <h1 style="margin:0;font-size:22px;font-weight:800;color:#1a3664;">¡Bienvenido a Gartify, ${name}!</h1>
      <p style="margin:8px 0 0;font-size:14px;color:#64748b;">Tu cuenta de conductor está lista. Ya puedes reservar cita en talleres verificados de toda España.</p>
    </div>

    <div style="border:1px solid #e2e8f0;border-radius:10px;overflow:hidden;margin-bottom:20px;">
      <div style="background:#1a5496;padding:10px 16px;">
        <span style="font-size:11px;font-weight:800;letter-spacing:2px;text-transform:uppercase;color:rgba(255,255,255,0.75);">¿Qué puedes hacer ahora?</span>
      </div>
      <table width="100%" cellpadding="0" cellspacing="0">
        ${detailRow("🔍", "Busca taller", "Por servicio, ciudad o código postal")}
        ${detailRow("📅", "Reserva online", "Sin llamadas, en segundos")}
        ${detailRow("⭐", "Valora", "Deja tu reseña tras cada servicio")}
        ${detailRow("0€", "Sin comisiones", "El pago se realiza directamente en el taller")}
      </table>
    </div>

    <div style="text-align:center;margin-bottom:8px;">
      <a href="${BASE_URL}/talleres"
         style="display:inline-block;background:#22a855;color:#ffffff;font-size:15px;font-weight:700;padding:13px 32px;border-radius:8px;text-decoration:none;">
        Buscar taller ahora
      </a>
    </div>
  `);
  return {
    subject: `¡Bienvenido a Gartify, ${name}! Tu cuenta está lista`,
    html,
  };
}

// ─── Template 4: Welcome → new Garage owner ───────────────────────────────────

export function welcomeGarageEmail(ownerName: string, garageName: string): { subject: string; html: string } {
  const html = layout(`
    <div style="text-align:center;margin-bottom:28px;">
      <div style="display:inline-flex;align-items:center;justify-content:center;width:56px;height:56px;background:#dbeafe;border-radius:50%;border:2px solid #bfdbfe;margin-bottom:12px;">
        <span style="font-size:28px;">🔧</span>
      </div>
      <h1 style="margin:0;font-size:22px;font-weight:800;color:#1a3664;">¡${garageName} ya está en Gartify!</h1>
      <p style="margin:8px 0 0;font-size:14px;color:#64748b;">Hola <strong>${ownerName}</strong>, tu taller ha sido registrado correctamente. Completa tu perfil para empezar a recibir reservas.</p>
    </div>

    <div style="border:1px solid #e2e8f0;border-radius:10px;overflow:hidden;margin-bottom:20px;">
      <div style="background:#1a5496;padding:10px 16px;">
        <span style="font-size:11px;font-weight:800;letter-spacing:2px;text-transform:uppercase;color:rgba(255,255,255,0.75);">Próximos pasos</span>
      </div>
      <table width="100%" cellpadding="0" cellspacing="0">
        ${detailRow("1️⃣", "Añade tus servicios", "Con precio y duración estimada")}
        ${detailRow("2️⃣", "Completa tu perfil", "Foto, descripción y horario")}
        ${detailRow("3️⃣", "Recibe reservas", "Los clientes ya pueden encontrarte")}
        ${detailRow("4️⃣", "Gestiona tu agenda", "Confirma, completa o cancela citas")}
      </table>
    </div>

    <div style="background:#eff6ff;border:1px solid #bfdbfe;border-radius:8px;padding:12px 16px;margin-bottom:24px;font-size:13px;color:#1d4ed8;">
      💡 Cuantos más servicios y mejor descripción tengas, más visibilidad tendrás en los resultados de búsqueda.
    </div>

    <div style="text-align:center;margin-bottom:8px;">
      <a href="${BASE_URL}/cuenta/taller"
         style="display:inline-block;background:#1a3664;color:#ffffff;font-size:15px;font-weight:700;padding:13px 32px;border-radius:8px;text-decoration:none;">
        Ir a mi portal
      </a>
    </div>
  `);
  return {
    subject: `¡Bienvenido a Gartify! ${garageName} ya aparece en el directorio`,
    html,
  };
}

// ─── Template 5: Email verification → new Garage owner ───────────────────────

export function verificacionEmailTaller(
  ownerName: string,
  garageName: string,
  verificationUrl: string,
): { subject: string; html: string } {
  const html = layout(`
    <div style="text-align:center;margin-bottom:28px;">
      <div style="display:inline-flex;align-items:center;justify-content:center;width:56px;height:56px;background:#dcfce7;border-radius:50%;border:2px solid #bbf7d0;margin-bottom:12px;">
        <span style="font-size:28px;">✉️</span>
      </div>
      <h1 style="margin:0;font-size:22px;font-weight:800;color:#1a3664;">Confirma tu email</h1>
      <p style="margin:8px 0 0;font-size:14px;color:#64748b;">Hola <strong>${ownerName}</strong>, gracias por registrar <strong>${garageName}</strong> en Gartify. Solo queda un paso.</p>
    </div>

    <div style="background:#f0fdf4;border:1px solid #bbf7d0;border-radius:8px;padding:16px;margin-bottom:24px;font-size:14px;color:#166534;text-align:center;">
      Haz clic en el botón para verificar tu dirección de email y activar tu cuenta.
    </div>

    <div style="text-align:center;margin-bottom:20px;">
      <a href="${verificationUrl}"
         style="display:inline-block;background:#16a34a;color:#ffffff;font-size:15px;font-weight:700;padding:13px 32px;border-radius:8px;text-decoration:none;">
        ✅ Verificar mi email
      </a>
    </div>

    <p style="font-size:12px;color:#94a3b8;text-align:center;margin:0;">
      Este enlace caduca en 24 horas. Si no creaste esta cuenta, ignora este mensaje.
    </p>
  `);
  return {
    subject: `Confirma tu email para activar tu taller en Gartify`,
    html,
  };
}

// ─── Template 6: Nuevo taller registrado → Gartify interno ──────────────────

export function nuevoTallerInternoEmail(
  ownerName: string,
  garageName: string,
  email: string,
  city: string,
  province: string,
): { subject: string; html: string } {
  const html = layout(`
    <div style="text-align:center;margin-bottom:24px;">
      <div style="display:inline-flex;align-items:center;justify-content:center;width:56px;height:56px;background:#dbeafe;border-radius:50%;border:2px solid #bfdbfe;margin-bottom:12px;">
        <span style="font-size:28px;">🔧</span>
      </div>
      <h1 style="margin:0;font-size:20px;font-weight:800;color:#1a3664;">Nuevo taller registrado</h1>
    </div>

    <div style="border:1px solid #e2e8f0;border-radius:10px;overflow:hidden;margin-bottom:20px;">
      <div style="background:#1a5496;padding:10px 16px;">
        <span style="font-size:11px;font-weight:800;letter-spacing:2px;text-transform:uppercase;color:rgba(255,255,255,0.75);">Datos del taller</span>
      </div>
      <table width="100%" cellpadding="0" cellspacing="0">
        ${detailRow("🏪", "Taller", garageName)}
        ${detailRow("👤", "Responsable", ownerName)}
        ${detailRow("✉️", "Email", email)}
        ${detailRow("📍", "Ubicación", `${city} (${province})`)}
      </table>
    </div>

    <div style="text-align:center;margin-bottom:8px;">
      <a href="${BASE_URL}/admin/talleres"
         style="display:inline-block;background:#1a3664;color:#ffffff;font-size:14px;font-weight:700;padding:11px 28px;border-radius:8px;text-decoration:none;">
        Ver en el panel de admin
      </a>
    </div>
  `);
  return {
    subject: `🔧 Nuevo taller: ${garageName} (${city})`,
    html,
  };
}

// ─── Template 7: Nuevo lead /para-talleres → Gartify interno ─────────────────

export function nuevoLeadEmail(data: {
  nombre:       string;
  nombreTaller: string;
  telefono:     string;
  email?:       string;
  ciudad?:      string;
  mensaje?:     string;
}): { subject: string; html: string } {
  const ahora = new Intl.DateTimeFormat("es-ES", {
    weekday: "long", day: "numeric", month: "long",
    hour: "2-digit", minute: "2-digit",
  }).format(new Date());

  const html = layout(`
    <div style="text-align:center;margin-bottom:24px;">
      <div style="display:inline-flex;align-items:center;justify-content:center;width:56px;height:56px;background:#fef3c7;border-radius:50%;border:2px solid #fde68a;margin-bottom:12px;">
        <span style="font-size:28px;">📞</span>
      </div>
      <h1 style="margin:0;font-size:20px;font-weight:800;color:#1a3664;">Nuevo lead — solicitud de llamada</h1>
      <p style="margin:6px 0 0;font-size:13px;color:#64748b;">Recibido el ${ahora}</p>
    </div>

    <div style="border:1px solid #e2e8f0;border-radius:10px;overflow:hidden;margin-bottom:20px;">
      <div style="background:#d97706;padding:10px 16px;">
        <span style="font-size:11px;font-weight:800;letter-spacing:2px;text-transform:uppercase;color:rgba(255,255,255,0.9);">Datos del prospecto</span>
      </div>
      <table width="100%" cellpadding="0" cellspacing="0">
        ${detailRow("👤", "Nombre", data.nombre)}
        ${detailRow("🏪", "Taller", data.nombreTaller)}
        ${detailRow("📞", "Teléfono", `<a href="tel:${data.telefono}" style="color:#FF5722;text-decoration:none;font-weight:700;">${data.telefono}</a>`)}
        ${data.email  ? detailRow("✉️", "Email",  `<a href="mailto:${data.email}" style="color:#1d4ed8;text-decoration:none;">${data.email}</a>`) : ""}
        ${data.ciudad ? detailRow("📍", "Ciudad", data.ciudad) : ""}
      </table>
    </div>

    ${data.mensaje ? `
    <div style="border:1px solid #e2e8f0;border-radius:10px;overflow:hidden;margin-bottom:20px;">
      <div style="background:#475569;padding:10px 16px;">
        <span style="font-size:11px;font-weight:800;letter-spacing:2px;text-transform:uppercase;color:rgba(255,255,255,0.75);">Mensaje</span>
      </div>
      <div style="padding:14px 16px;font-size:14px;color:#334155;background:#fff;line-height:1.6;">${data.mensaje}</div>
    </div>` : ""}

    <div style="background:#fffbeb;border:1px solid #fde68a;border-radius:8px;padding:12px 16px;margin-bottom:24px;font-size:13px;color:#92400e;">
      💡 Llamar preferiblemente antes de las 19:00. Origen: <strong>gartify.es/para-talleres</strong>
    </div>

    <div style="text-align:center;margin-bottom:8px;">
      <a href="tel:${data.telefono}"
         style="display:inline-block;background:#FF5722;color:#ffffff;font-size:15px;font-weight:700;padding:13px 32px;border-radius:8px;text-decoration:none;">
        📞 Llamar ahora
      </a>
    </div>
  `);

  return {
    subject: `📞 Nuevo lead: ${data.nombreTaller} — ${data.telefono}`,
    html,
  };
}

// ─── Template 8: Baja de cuenta → Usuario ────────────────────────────────────

export function cuentaEliminadaEmail(
  name: string,
  role: "CUSTOMER" | "GARAGE_OWNER",
): { subject: string; html: string } {
  const esGarage = role === "GARAGE_OWNER";
  const html = layout(`
    <div style="text-align:center;margin-bottom:28px;">
      <div style="display:inline-flex;align-items:center;justify-content:center;width:56px;height:56px;background:#f1f5f9;border-radius:50%;border:2px solid #e2e8f0;margin-bottom:12px;">
        <span style="font-size:28px;">👋</span>
      </div>
      <h1 style="margin:0;font-size:22px;font-weight:800;color:#1a3664;">Tu cuenta ha sido eliminada</h1>
      <p style="margin:8px 0 0;font-size:14px;color:#64748b;">Hola <strong>${name}</strong>, hemos procesado tu solicitud correctamente.</p>
    </div>

    <div style="border:1px solid #e2e8f0;border-radius:10px;padding:16px;margin-bottom:20px;background:#f8fafc;font-size:14px;color:#334155;line-height:1.6;">
      ${esGarage
        ? `Tu taller y todos sus datos han sido eliminados de Gartify. Las reservas completadas anteriores han sido anonimizadas para mantener la integridad de los registros.`
        : `Tu cuenta y todos tus datos personales han sido eliminados de Gartify. Tus reservas anteriores han sido anonimizadas.`
      }
    </div>

    <div style="background:#f0fdf4;border:1px solid #bbf7d0;border-radius:8px;padding:12px 16px;margin-bottom:24px;font-size:13px;color:#166534;">
      Si esto fue un error o cambias de opinión, puedes volver a registrarte en cualquier momento en <a href="${BASE_URL}" style="color:#1d4ed8;">${BASE_URL}</a>.
    </div>

    <p style="font-size:13px;color:#64748b;text-align:center;">
      Gracias por haber formado parte de Gartify. ¡Hasta pronto!
    </p>
  `);
  return {
    subject: `Tu cuenta en Gartify ha sido eliminada`,
    html,
  };
}

export function bajaUsuarioInternoEmail(
  name: string,
  email: string,
  role: "CUSTOMER" | "GARAGE_OWNER",
): { subject: string; html: string } {
  const ahora = new Intl.DateTimeFormat("es-ES", {
    weekday: "long", day: "numeric", month: "long",
    hour: "2-digit", minute: "2-digit",
  }).format(new Date());

  const html = layout(`
    <div style="text-align:center;margin-bottom:24px;">
      <div style="display:inline-flex;align-items:center;justify-content:center;width:56px;height:56px;background:#fee2e2;border-radius:50%;border:2px solid #fecaca;margin-bottom:12px;">
        <span style="font-size:28px;">🗑️</span>
      </div>
      <h1 style="margin:0;font-size:20px;font-weight:800;color:#1a3664;">Baja de cuenta</h1>
      <p style="margin:6px 0 0;font-size:13px;color:#64748b;">${ahora}</p>
    </div>

    <div style="border:1px solid #e2e8f0;border-radius:10px;overflow:hidden;margin-bottom:20px;">
      <div style="background:#dc2626;padding:10px 16px;">
        <span style="font-size:11px;font-weight:800;letter-spacing:2px;text-transform:uppercase;color:rgba(255,255,255,0.85);">Usuario dado de baja</span>
      </div>
      <table width="100%" cellpadding="0" cellspacing="0">
        ${detailRow("👤", "Nombre", name)}
        ${detailRow("✉️", "Email",  email)}
        ${detailRow("🏷️", "Rol",    role === "GARAGE_OWNER" ? "Taller" : "Cliente")}
      </table>
    </div>

    <div style="background:#fef2f2;border:1px solid #fecaca;border-radius:8px;padding:12px 16px;font-size:13px;color:#991b1b;">
      La cuenta y sus datos han sido eliminados permanentemente.
    </div>
  `);
  return {
    subject: `🗑️ Baja de ${role === "GARAGE_OWNER" ? "taller" : "cliente"}: ${email}`,
    html,
  };
}

// ─── Template 9: Reserva cancelada por cliente → Taller ─────────────────────

export function reservaCanceladaClienteEmail(data: {
  garageName:  string;
  customerName: string;
  serviceName:  string;
  date:         Date;
  bookingId:    string;
}): { subject: string; html: string } {
  const formattedDate = new Intl.DateTimeFormat("es-ES", {
    weekday: "long", day: "numeric", month: "long",
    hour: "2-digit", minute: "2-digit",
  }).format(data.date);

  const html = layout(`
    <div style="text-align:center;margin-bottom:28px;">
      <div style="display:inline-flex;align-items:center;justify-content:center;width:56px;height:56px;background:#fee2e2;border-radius:50%;border:2px solid #fecaca;margin-bottom:12px;">
        <span style="font-size:28px;">❌</span>
      </div>
      <h1 style="margin:0;font-size:22px;font-weight:800;color:#1a3664;">Reserva cancelada</h1>
      <p style="margin:8px 0 0;font-size:14px;color:#64748b;">El cliente ha cancelado su cita en <strong>${data.garageName}</strong>.</p>
    </div>

    <div style="border:1px solid #e2e8f0;border-radius:10px;overflow:hidden;margin-bottom:20px;">
      <div style="background:#dc2626;padding:10px 16px;">
        <span style="font-size:11px;font-weight:800;letter-spacing:2px;text-transform:uppercase;color:rgba(255,255,255,0.85);">Detalle de la reserva cancelada</span>
      </div>
      <table width="100%" cellpadding="0" cellspacing="0">
        ${detailRow("👤", "Cliente", data.customerName)}
        ${detailRow("🔧", "Servicio", data.serviceName)}
        ${detailRow("📅", "Fecha prevista", formattedDate)}
      </table>
    </div>

    <div style="background:#fef2f2;border:1px solid #fecaca;border-radius:8px;padding:12px 16px;margin-bottom:24px;font-size:13px;color:#991b1b;">
      Este hueco ha quedado libre en tu agenda. Puedes gestionarlo desde tu portal.
    </div>

    <div style="text-align:center;margin-bottom:8px;">
      <a href="${BASE_URL}/cuenta/taller"
         style="display:inline-block;background:#1a3664;color:#ffffff;font-size:15px;font-weight:700;padding:13px 32px;border-radius:8px;text-decoration:none;">
        Ir a mis reservas
      </a>
    </div>
  `);

  return {
    subject: `❌ Reserva cancelada — ${data.customerName}`,
    html,
  };
}

// ─── Template 8: Status update → Customer ────────────────────────────────────

export interface StatusUpdateEmailData {
  customerName: string;
  garageName:   string;
  garagePhone:  string;
  serviceName:  string;
  date:         Date;
  newStatus:    "CONFIRMED" | "CANCELLED" | "COMPLETED";
  bookingId:    string;
}

export function bookingStatusUpdateEmail(d: StatusUpdateEmailData): { subject: string; html: string } {
  const formattedDate = new Intl.DateTimeFormat("es-ES", {
    weekday: "long", day: "numeric", month: "long",
    hour: "2-digit", minute: "2-digit",
  }).format(d.date);

  const messages: Record<string, { emoji: string; title: string; body: string; iconBg: string }> = {
    CONFIRMED: {
      emoji:  "✅",
      title:  "¡Tu reserva está confirmada!",
      body:   `<strong>${d.garageName}</strong> ha confirmado tu cita. Recuerda acudir en la fecha acordada.`,
      iconBg: "#dcfce7",
    },
    CANCELLED: {
      emoji:  "❌",
      title:  "Tu reserva ha sido cancelada",
      body:   `Lamentablemente tu reserva en <strong>${d.garageName}</strong> ha sido cancelada. Si tienes dudas, contacta al taller.`,
      iconBg: "#fee2e2",
    },
    COMPLETED: {
      emoji:  "⭐",
      title:  "Servicio completado — ¡Gracias!",
      body:   `Tu servicio en <strong>${d.garageName}</strong> ha sido marcado como completado. ¿Te ayudamos a dejar una reseña?`,
      iconBg: "#fef9c3",
    },
  };

  const msg = messages[d.newStatus];

  const html = layout(`
    <!-- Icon + title -->
    <div style="text-align:center;margin-bottom:28px;">
      <div style="display:inline-flex;align-items:center;justify-content:center;width:56px;height:56px;background:${msg.iconBg};border-radius:50%;margin-bottom:12px;">
        <span style="font-size:28px;">${msg.emoji}</span>
      </div>
      <h1 style="margin:0;font-size:22px;font-weight:800;color:#1a3664;">${msg.title}</h1>
      <p style="margin:8px 0 0;font-size:14px;color:#64748b;">Hola <strong>${d.customerName}</strong>, ${msg.body}</p>
    </div>

    <!-- Status -->
    <div style="text-align:center;margin-bottom:24px;">
      ${statusBadge(d.newStatus)}
    </div>

    <!-- Summary -->
    <div style="border:1px solid #e2e8f0;border-radius:10px;overflow:hidden;margin-bottom:24px;">
      <div style="background:#1a5496;padding:10px 16px;">
        <span style="font-size:11px;font-weight:800;letter-spacing:2px;text-transform:uppercase;color:rgba(255,255,255,0.75);">Resumen</span>
      </div>
      <table width="100%" cellpadding="0" cellspacing="0">
        ${detailRow("📍", "Taller",        d.garageName)}
        ${detailRow("📞", "Teléfono",      d.garagePhone)}
        ${detailRow("🔧", "Servicio",      d.serviceName)}
        ${detailRow("📅", "Fecha y hora",  formattedDate)}
      </table>
    </div>

    <!-- CTA -->
    <div style="text-align:center;">
      <a href="${BASE_URL}/reserva/${d.bookingId}"
         style="display:inline-block;background:#22a855;color:#ffffff;font-size:15px;font-weight:700;padding:13px 32px;border-radius:8px;text-decoration:none;">
        Ver detalle de reserva
      </a>
    </div>
  `);

  const subjectMap: Record<string, string> = {
    CONFIRMED: `✅ Reserva confirmada — ${d.garageName}`,
    CANCELLED: `❌ Reserva cancelada — ${d.garageName}`,
    COMPLETED: `⭐ Servicio completado — ${d.garageName}`,
  };

  return { subject: subjectMap[d.newStatus], html };
}

// ─── ITV Reminder ─────────────────────────────────────────────────────────────

export function itvReminderEmail(data: {
  userName: string;
  vehicleName: string;
  plate: string;
  itvDate: Date;
  daysLeft: number;
}): { subject: string; html: string } {
  const fechaItv = new Intl.DateTimeFormat("es-ES", {
    day: "2-digit", month: "long", year: "numeric",
  }).format(data.itvDate);

  const urgency = data.daysLeft <= 7
    ? { color: "#dc2626", bg: "#fef2f2", border: "#fecaca", label: "¡Urgente!" }
    : { color: "#d97706", bg: "#fffbeb", border: "#fde68a", label: "Aviso" };

  const html = layout(`
    <div style="text-align:center;margin-bottom:28px;">
      <div style="font-size:48px;margin-bottom:8px;">🚗</div>
      <h1 style="margin:0;font-size:22px;font-weight:800;color:#1a3664;">
        Recordatorio de ITV
      </h1>
      <p style="margin:8px 0 0;color:#64748b;font-size:15px;">
        Hola <strong>${data.userName}</strong>, tu vehículo tiene la ITV próximamente.
      </p>
    </div>

    <div style="background:${urgency.bg};border:1px solid ${urgency.border};border-radius:10px;padding:20px 24px;margin-bottom:24px;text-align:center;">
      <p style="margin:0 0 4px;font-size:12px;font-weight:700;letter-spacing:2px;text-transform:uppercase;color:${urgency.color};">${urgency.label}</p>
      <p style="margin:0;font-size:28px;font-weight:900;color:${urgency.color};">
        ${data.daysLeft} ${data.daysLeft === 1 ? "día" : "días"}
      </p>
      <p style="margin:4px 0 0;font-size:13px;color:${urgency.color};opacity:0.8;">para la fecha límite</p>
    </div>

    <table width="100%" cellpadding="0" cellspacing="0" style="margin-bottom:24px;">
      ${detailRow("🚗", "Vehículo", data.vehicleName)}
      ${detailRow("🔖", "Matrícula", data.plate)}
      ${detailRow("📅", "Fecha ITV", fechaItv)}
    </table>

    <div style="text-align:center;margin-bottom:24px;">
      <a href="${BASE_URL}/talleres?servicio=PRE_ITV"
         style="display:inline-block;background:#F5A623;color:#ffffff;font-size:15px;font-weight:700;padding:13px 32px;border-radius:8px;text-decoration:none;">
        Reservar revisión pre-ITV
      </a>
    </div>

    <p style="margin:0;font-size:12px;color:#94a3b8;text-align:center;">
      Puedes gestionar tus vehículos en <a href="${BASE_URL}/cuenta/vehiculos" style="color:#1e7fc2;">Mis vehículos</a>.
    </p>
  `);

  const subject = data.daysLeft <= 7
    ? `⚠️ ITV en ${data.daysLeft} días — ${data.vehicleName} (${data.plate})`
    : `🔔 Recuerda: ITV en ${data.daysLeft} días — ${data.vehicleName}`;

  return { subject, html };
}
