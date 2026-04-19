import type { Metadata } from "next";
import { db } from "@/lib/db";
import { Users, Building2, User, UsersRound } from "lucide-react";
import { UserTable } from "@/components/admin/UserTable";

export const dynamic = "force-dynamic";
export const metadata: Metadata = { title: "Admin — Usuarios" };

export default async function AdminUsuariosPage() {
  const users = await db.user.findMany({
    where: { role: { not: "ADMIN" } },
    orderBy: { createdAt: "desc" },
    select: {
      id: true,
      name: true,
      email: true,
      phone: true,
      role: true,
      password: true,
      createdAt: true,
      garage: { select: { name: true, plan: true, phone: true } },
    },
  });

  const customers    = users.filter(u => u.role === "CUSTOMER");
  const garageOwners = users.filter(u => u.role === "GARAGE_OWNER");

  return (
    <div className="container max-w-5xl py-10">
      <div className="bg-white border border-gray-200 overflow-hidden mb-8">
        <div className="bg-gray-50 border-b border-gray-200 px-6 py-5">
          <div className="flex items-center gap-3">
            <div className="flex h-10 w-10 items-center justify-center bg-gartify-blue/10 border border-gartify-blue/20 shrink-0">
              <UsersRound className="h-5 w-5 text-gartify-blue" />
            </div>
            <div>
              <h1 className="text-base font-bold text-gartify-blue">Usuarios</h1>
              <p className="text-xs text-gartify-gray mt-0.5">{customers.length} conductores · {garageOwners.length} talleres</p>
            </div>
          </div>
        </div>
      </div>

      {/* Stats */}
      <div className="grid grid-cols-2 gap-4 mb-8">
        <div className="rounded-xl border border-blue-100 bg-blue-50 p-4 flex items-center gap-3">
          <div className="h-10 w-10 rounded-full bg-white flex items-center justify-center shadow-sm">
            <User className="h-5 w-5 text-gartify-mid" />
          </div>
          <div>
            <p className="text-xs text-muted-foreground">Conductores</p>
            <p className="font-bold text-lg">{customers.length}</p>
          </div>
        </div>
        <div className="rounded-xl border border-orange-100 bg-orange-50 p-4 flex items-center gap-3">
          <div className="h-10 w-10 rounded-full bg-white flex items-center justify-center shadow-sm">
            <Building2 className="h-5 w-5 text-gartify-orange" />
          </div>
          <div>
            <p className="text-xs text-muted-foreground">Propietarios de taller</p>
            <p className="font-bold text-lg">{garageOwners.length}</p>
          </div>
        </div>
      </div>

      {/* Tabla */}
      <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
        <div className="px-5 py-3 border-b border-gray-100 flex items-center gap-2">
          <Users className="h-4 w-4 text-gartify-mid" />
          <h2 className="text-sm font-bold text-gartify-blue">Todos los usuarios</h2>
        </div>
        <UserTable users={users} />
      </div>
    </div>
  );
}
