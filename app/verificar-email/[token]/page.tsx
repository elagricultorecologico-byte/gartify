import { db } from "@/lib/db";
import { CheckCircle2, XCircle, Clock, Info } from "lucide-react";

interface Props {
  params: { token: string };
}

export const metadata = {
  title: "Verificación de email — Gartify",
  robots: { index: false, follow: false },
};

export default async function VerificarEmailPage({ params }: Props) {
  const { token } = params;

  // eslint-disable-next-line @typescript-eslint/ban-ts-comment
  // @ts-ignore -- EmailVerification added in schema, Prisma client needs regeneration
  const registro = await db.emailVerification.findUnique({ where: { token } });

  // Token no existe
  if (!registro) {
    return <ResultadoVerificacion tipo="invalido" />;
  }

  // Ya usado
  if (registro.usedAt) {
    return <ResultadoVerificacion tipo="yaVerificado" />;
  }

  // Expirado
  if (new Date(registro.expiresAt) < new Date()) {
    return <ResultadoVerificacion tipo="expirado" />;
  }

  // Marcar como usado y verificar email del User
  // eslint-disable-next-line @typescript-eslint/ban-ts-comment
  // @ts-ignore
  await db.emailVerification.update({
    where: { token },
    data:  { usedAt: new Date() },
  });

  await db.user.update({
    where: { id: registro.userId },
    data:  { emailVerified: new Date() },
  });

  return <ResultadoVerificacion tipo="ok" />;
}

// ── Componente de resultado ───────────────────────────────────────────────────

type TipoResultado = "ok" | "invalido" | "expirado" | "yaVerificado";

const CONFIG: Record<TipoResultado, {
  icon: React.ComponentType<{ className?: string }>;
  iconBg: string;
  iconColor: string;
  titulo: string;
  texto: string;
  alertBg: string;
  alertBorder: string;
  alertText: string;
  alertMsg: string;
  cta: string;
  ctaHref: string;
}> = {
  ok: {
    icon:        CheckCircle2,
    iconBg:      "bg-green-100 border-green-200",
    iconColor:   "text-green-600",
    titulo:      "Email verificado",
    texto:       "Tu cuenta está activa. Ya puedes recibir reservas y gestionar tu taller.",
    alertBg:     "bg-green-50",
    alertBorder: "border-green-200",
    alertText:   "text-green-800",
    alertMsg:    "Verificación completada correctamente.",
    cta:         "Ir a mi portal",
    ctaHref:     "/cuenta/taller",
  },
  invalido: {
    icon:        XCircle,
    iconBg:      "bg-red-100 border-red-200",
    iconColor:   "text-red-600",
    titulo:      "Enlace no válido",
    texto:       "Este enlace de verificación no existe o ya fue eliminado.",
    alertBg:     "bg-red-50",
    alertBorder: "border-red-200",
    alertText:   "text-red-800",
    alertMsg:    "Si crees que es un error, solicita un nuevo enlace desde tu portal.",
    cta:         "Ir al inicio",
    ctaHref:     "/",
  },
  expirado: {
    icon:        Clock,
    iconBg:      "bg-amber-100 border-amber-200",
    iconColor:   "text-amber-600",
    titulo:      "Enlace caducado",
    texto:       "El enlace de verificación ha expirado (válido 24 h).",
    alertBg:     "bg-amber-50",
    alertBorder: "border-amber-200",
    alertText:   "text-amber-800",
    alertMsg:    "Inicia sesión en tu portal para solicitar un nuevo enlace.",
    cta:         "Ir a mi portal",
    ctaHref:     "/cuenta/taller",
  },
  yaVerificado: {
    icon:        Info,
    iconBg:      "bg-blue-100 border-blue-200",
    iconColor:   "text-gartify-blue",
    titulo:      "Ya verificado",
    texto:       "Este email ya fue verificado anteriormente.",
    alertBg:     "bg-blue-50",
    alertBorder: "border-blue-200",
    alertText:   "text-blue-800",
    alertMsg:    "Puedes iniciar sesión normalmente.",
    cta:         "Ir a mi portal",
    ctaHref:     "/cuenta/taller",
  },
};

function ResultadoVerificacion({ tipo }: { tipo: TipoResultado }) {
  const c = CONFIG[tipo];
  const Icon = c.icon;

  return (
    <div className="min-h-[calc(100vh-4rem)] flex items-center justify-center px-4 bg-blue-50">
      <div className="bg-white border border-gray-200 max-w-md w-full p-8 text-center">
        <div className="flex justify-center mb-5">
          <div className={`flex h-16 w-16 items-center justify-center rounded-full border-2 ${c.iconBg}`}>
            <Icon className={`h-8 w-8 ${c.iconColor}`} />
          </div>
        </div>

        <p className="text-lg font-extrabold text-gartify-blue mb-1">🔧 Gartify</p>
        <h1 className="text-xl font-bold text-gartify-blue mb-3">{c.titulo}</h1>
        <p className="text-sm text-gartify-gray mb-5 leading-relaxed">{c.texto}</p>

        <div className={`border rounded px-4 py-3 text-xs mb-6 text-left ${c.alertBg} ${c.alertBorder} ${c.alertText}`}>
          {c.alertMsg}
        </div>

        <a
          href={c.ctaHref}
          className="block w-full bg-gartify-blue hover:bg-blue-800 text-white font-bold py-2.5 px-4 text-sm transition-colors text-center"
        >
          {c.cta}
        </a>
      </div>
    </div>
  );
}
