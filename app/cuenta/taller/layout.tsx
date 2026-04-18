import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { TallerShell } from "@/components/cuenta/TallerShell";

export const dynamic = "force-dynamic";

/**
 * Layout compartido para todas las rutas del portal de taller.
 * Verifica autenticación y rol, carga los datos del garage necesarios
 * para el sidebar y envuelve el contenido en el TallerShell.
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
