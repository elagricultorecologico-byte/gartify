import type { Metadata } from "next";
import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { User } from "lucide-react";
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
      <div className="bg-white border border-gray-200 overflow-hidden">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
          <div className="flex items-center gap-3">
            <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <User className="h-5 w-5 text-gartify-blue" />
            </div>
            <div>
              <h1 className="text-base font-bold text-gartify-blue">Mi perfil</h1>
              <p className="text-xs text-gartify-gray mt-0.5">Actualiza tus datos personales de contacto</p>
            </div>
          </div>
        </div>
        <div className="p-6">
          <CustomerProfileForm user={user} />
        </div>
      </div>
    </div>
  );
}
