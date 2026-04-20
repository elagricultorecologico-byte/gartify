import { auth } from "@/lib/auth";
import { redirect } from "next/navigation";
import { ConductorShell } from "@/components/cuenta/ConductorShell";

export const dynamic = "force-dynamic";

/**
 * Layout compartido para las rutas del conductor (/cuenta, /cuenta/perfil, /cuenta/vehiculos).
 * Las rutas de taller (/cuenta/taller/**) tienen su propio layout que ignora este shell.
 */
export default async function CuentaLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  const session = await auth();
  if (!session?.user?.id) redirect("/login");

  const user = session.user as { id: string; role?: string };

  // El taller tiene su propio layout con TallerShell — aquí solo renderizamos hijos
  if (user.role === "GARAGE_OWNER") {
    return <>{children}</>;
  }

  return <ConductorShell>{children}</ConductorShell>;
}
