import { db } from "@/lib/db";

interface Props {
  params: { token: string };
}

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

function ResultadoVerificacion({ tipo }: { tipo: TipoResultado }) {
  const config: Record<TipoResultado, { emoji: string; titulo: string; texto: string; colorBg: string; colorBorde: string; colorTexto: string }> = {
    ok: {
      emoji:       "✅",
      titulo:      "Email verificado",
      texto:       "Tu cuenta está activa. Ya puedes recibir reservas y gestionar tu taller.",
      colorBg:     "#f0fdf4",
      colorBorde:  "#bbf7d0",
      colorTexto:  "#166534",
    },
    invalido: {
      emoji:       "❌",
      titulo:      "Enlace no válido",
      texto:       "Este enlace de verificación no existe o ya fue eliminado.",
      colorBg:     "#fef2f2",
      colorBorde:  "#fecaca",
      colorTexto:  "#991b1b",
    },
    expirado: {
      emoji:       "⏰",
      titulo:      "Enlace caducado",
      texto:       "El enlace de verificación ha expirado (válido 24 h). Inicia sesión en tu portal para solicitar uno nuevo.",
      colorBg:     "#fffbeb",
      colorBorde:  "#fde68a",
      colorTexto:  "#92400e",
    },
    yaVerificado: {
      emoji:       "ℹ️",
      titulo:      "Ya verificado",
      texto:       "Este email ya fue verificado anteriormente. Puedes iniciar sesión normalmente.",
      colorBg:     "#eff6ff",
      colorBorde:  "#bfdbfe",
      colorTexto:  "#1e40af",
    },
  };

  const c = config[tipo];

  return (
    <html lang="es">
      <head>
        <meta charSet="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Gartify — Verificación de email</title>
        <style>{`
          body { font-family: sans-serif; display: flex; align-items: center;
                 justify-content: center; min-height: 100vh; margin: 0; background: #f0f4ff; }
          .card { background: #fff; border-radius: 16px; padding: 2.5rem 2rem;
                  box-shadow: 0 4px 24px rgba(0,0,0,.08); text-align: center;
                  max-width: 400px; width: 100%; }
          .logo { font-weight: 800; font-size: 1.3rem; color: #1E40AF; margin-bottom: 1.5rem; }
          .badge { display: inline-flex; align-items: center; justify-content: center;
                   width: 64px; height: 64px; border-radius: 50%; font-size: 2rem;
                   background: ${c.colorBg}; border: 2px solid ${c.colorBorde};
                   margin-bottom: 1rem; }
          .title { font-size: 1.25rem; font-weight: 800; color: #1e3a8a; margin: 0 0 .75rem; }
          .texto { font-size: .9rem; color: #64748b; margin: 0 0 1.5rem; line-height: 1.5; }
          .msg { background: ${c.colorBg}; border: 1px solid ${c.colorBorde};
                 color: ${c.colorTexto}; border-radius: 8px; padding: .75rem 1rem;
                 font-size: .85rem; margin-bottom: 1.5rem; }
          .btn { display: block; padding: .75rem 1.5rem; border-radius: 8px;
                 background: #1e40af; color: #fff; font-weight: 700; font-size: .95rem;
                 text-decoration: none; }
          .btn:hover { background: #1d3a9a; }
        `}</style>
      </head>
      <body>
        <div className="card">
          <div className="logo">🔧 Gartify</div>
          <div className="badge">{c.emoji}</div>
          <h1 className="title">{c.titulo}</h1>
          <p className="texto">{c.texto}</p>
          <a className="btn" href="/cuenta/taller">Ir a mi portal</a>
        </div>
      </body>
    </html>
  );
}
