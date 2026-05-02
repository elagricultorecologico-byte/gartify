import { auth } from "@/lib/auth";
import { redirect } from "next/navigation";
import { db } from "@/lib/db";
import { MailCheck } from "lucide-react";
import { sendMail } from "@/lib/mailer";
import { verificacionEmailTaller } from "@/lib/emails/templates";
import crypto from "crypto";

export const dynamic = "force-dynamic";

export default async function VerificarEmailPendientePage() {
  const session = await auth();
  if (!session?.user?.id) redirect("/login");

  // Si ya verificó, mandarlo al portal
  const dbUser = await db.user.findUnique({
    where: { id: session.user.id },
    select: { emailVerified: true, email: true, name: true } as never,
  }) as { emailVerified: Date | null; email: string; name: string | null } | null;

  if (dbUser?.emailVerified) redirect("/cuenta/taller");

  const garage = await db.garage.findUnique({
    where: { ownerId: session.user.id },
    select: { name: true },
  });

  return (
    <div className="min-h-[calc(100vh-4rem)] flex items-center justify-center px-4 bg-blue-50">
      <div className="bg-white border border-gray-200 max-w-md w-full p-8 text-center">
        <div className="flex justify-center mb-5">
          <div className="flex h-16 w-16 items-center justify-center rounded-full bg-amber-100 border-2 border-amber-200">
            <MailCheck className="h-8 w-8 text-amber-600" />
          </div>
        </div>

        <h1 className="text-xl font-bold text-gartify-blue mb-2">
          Confirma tu email para continuar
        </h1>
        <p className="text-sm text-gartify-gray mb-6 leading-relaxed">
          Hemos enviado un enlace de verificación a{" "}
          <strong className="text-gartify-blue">{dbUser?.email}</strong>.
          Haz clic en él para activar tu cuenta y empezar a recibir reservas.
        </p>

        <div className="bg-amber-50 border border-amber-200 rounded px-4 py-3 text-xs text-amber-800 mb-6 text-left space-y-1">
          <p>• Revisa también la carpeta de <strong>spam o correo no deseado</strong>.</p>
          <p>• El enlace caduca en <strong>24 horas</strong>.</p>
        </div>

        <ReenviarForm
          userId={session.user.id}
          email={dbUser?.email ?? ""}
          ownerName={dbUser?.name ?? ""}
          garageName={garage?.name ?? ""}
        />

        <p className="mt-4 text-xs text-gartify-gray">
          ¿Email incorrecto?{" "}
          <a href="mailto:hola@gartify.es" className="text-gartify-blue underline hover:no-underline">
            Contacta con soporte
          </a>
        </p>
      </div>
    </div>
  );
}

// ── Server Action: reenviar email ─────────────────────────────────────────────

async function reenviarVerificacion(userId: string, email: string, ownerName: string, garageName: string) {
  "use server";

  // Invalidar tokens previos no usados creando uno nuevo
  const token = crypto.randomBytes(32).toString("hex");
  const expiresAt = new Date(Date.now() + 24 * 60 * 60 * 1000);

  // eslint-disable-next-line @typescript-eslint/ban-ts-comment
  // @ts-ignore
  await db.emailVerification.create({ data: { token, userId, expiresAt } });

  const baseUrl = process.env.NEXT_PUBLIC_BASE_URL ?? "https://gartify.es";
  const verificationUrl = `${baseUrl}/verificar-email/${token}`;
  const { subject, html } = verificacionEmailTaller(ownerName, garageName, verificationUrl);
  await sendMail({ to: email, subject, html });

  redirect("/verificar-email/pendiente?reenviado=1");
}

// ── Componente con botón de reenvío ──────────────────────────────────────────

function ReenviarForm({
  userId,
  email,
  ownerName,
  garageName,
}: {
  userId: string;
  email: string;
  ownerName: string;
  garageName: string;
}) {
  const action = reenviarVerificacion.bind(null, userId, email, ownerName, garageName);

  return (
    <form action={action}>
      <button
        type="submit"
        className="w-full bg-gartify-blue hover:bg-blue-800 text-white font-bold py-2.5 px-4 text-sm transition-colors"
      >
        Reenviar email de verificación
      </button>
    </form>
  );
}
