import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { TallerShell } from "@/components/cuenta/TallerShell";

export const dynamic = "force-dynamic";

/**
 * Layout compartido para todas las rutas del portal de taller.
 * Verifica autenticación, rol y email verificado antes de dar acceso.
 */
export default async function TallerLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  const session = await auth();
  if (!session?.user?.id) redirect("/login");

  const user = session.user as { id: string; role?: string };
  if (user.role !== "GARAGE_OWNER") redirect("/cuenta");

  // Bloquear acceso si el email no está verificado
  const dbUser = await db.user.findUnique({
    where: { id: user.id },
    select: { emailVerified: true } as never,
  }) as { emailVerified: Date | null } | null;

  if (!dbUser?.emailVerified) redirect("/verificar-email/pendiente");

  // Cargamos solo los campos necesarios para el sidebar
  const garage = await db.garage.findUnique({
    where: { ownerId: user.id },
    select: {
      id: true,
      name: true,
      plan: true,
      stripeSubscriptionId: true,
    },
  });

  return (
    <TallerShell
      garageName={garage?.name ?? ""}
      plan={garage?.plan ?? "STARTER"}
      garageId={garage?.id ?? ""}
    >
      {children}
    </TallerShell>
  );
}
