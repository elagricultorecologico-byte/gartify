import type { Metadata } from "next";
import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { CustomerProfileForm } from "@/components/cuenta/CustomerProfileForm";

export const dynamic = "force-dynamic";

export const metadata: Metadata = {
  title: "Mi perfil",
  robots: { index: false, follow: false },
};

export default async function PerfilPage() {
  const session = await auth();
  if (!session?.user?.id) redirect("/login");

  const user = await db.user.findUnique({
    where: { id: session.user.id },
    select: { id: true, name: true, email: true, phone: true },
  });

  if (!user) redirect("/login");

  return (
    <div className="container max-w-xl py-10 px-4 sm:px-8">
      <h1 className="text-2xl font-bold text-gartify-blue mb-1">Mi perfil</h1>
      <p className="text-muted-foreground text-sm mb-8">
        Actualiza tus datos personales de contacto.
      </p>
      <CustomerProfileForm user={user} />
    </div>
  );
}
