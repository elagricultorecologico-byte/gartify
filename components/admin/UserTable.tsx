"use client";
import React, { useState } from "react";
import { useRouter } from "next/navigation";
import { Mail, Chrome, Pencil, Trash2, Loader2, X, Check, ChevronLeft, ChevronRight, Zap, Crown, Wrench, Search } from "lucide-react";
import { Badge } from "@/components/ui/badge";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";

const PAGE_SIZE_OPTIONS = [10, 25, 50, 100];

const PLAN_ICON: Record<string, React.ReactNode> = {
  STARTER: <Wrench className="h-3 w-3 text-gray-400" />,
  PRO:     <Zap    className="h-3 w-3 text-blue-500" />,
  PREMIUM: <Crown  className="h-3 w-3 text-amber-500" />,
};
const PLAN_LABEL: Record<string, string> = {
  STARTER: "Starter",
  PRO:     "Pro",
  PREMIUM: "Premium",
};

const ROLE_LABELS: Record<string, string> = {
  CUSTOMER:     "Conductor",
  GARAGE_OWNER: "Taller",
};
const ROLE_COLORS: Record<string, string> = {
  CUSTOMER:     "bg-blue-50 text-blue-700 border-blue-100",
  GARAGE_OWNER: "bg-orange-50 text-orange-700 border-orange-100",
};

type User = {
  id: string;
  name: string | null;
  email: string;
  phone: string | null;
  role: string;
  password: string | null;
  createdAt: Date;
  garage: { name: string; plan: string; phone: string | null } | null;
};

type EditState = {
  name: string;
  email: string;
  phone: string;
  role: string;
};

export function UserTable({ users: initial }: { users: User[] }) {
  const router = useRouter();
  const [users, setUsers] = useState(initial);
  const [editId, setEditId] = useState<string | null>(null);
  const [editData, setEditData] = useState<EditState>({ name: "", email: "", phone: "", role: "" });
  const [saving, setSaving] = useState(false);
  const [deletingId, setDeletingId] = useState<string | null>(null);
  const [pageSize, setPageSize] = useState(10);
  const [page, setPage] = useState(1);
  const [search, setSearch] = useState("");
  const [roleFilter, setRoleFilter] = useState<string>("ALL");

  const filteredUsers = users.filter(u => {
    const matchesRole = roleFilter === "ALL" || u.role === roleFilter;
    const q = search.toLowerCase();
    const matchesSearch = !q
      || (u.name ?? "").toLowerCase().includes(q)
      || u.email.toLowerCase().includes(q)
      || (u.phone ?? "").includes(q)
      || (u.garage?.name ?? "").toLowerCase().includes(q);
    return matchesRole && matchesSearch;
  });

  const totalPages = Math.max(1, Math.ceil(filteredUsers.length / pageSize));
  const safePage = Math.min(page, totalPages);
  const paginatedUsers = filteredUsers.slice((safePage - 1) * pageSize, safePage * pageSize);

  function startEdit(u: User) {
    setEditId(u.id);
    const phone = u.role === "GARAGE_OWNER" ? (u.garage?.phone ?? u.phone ?? "") : (u.phone ?? "");
    setEditData({ name: u.name ?? "", email: u.email, phone, role: u.role });
  }

  function cancelEdit() { setEditId(null); }

  async function saveEdit(id: string) {
    setSaving(true);
    const res = await fetch(`/api/admin/users/${id}`, {
      method: "PATCH",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        name:  editData.name  || undefined,
        email: editData.email || undefined,
        phone: editData.phone || null,
        role:  editData.role  || undefined,
      }),
    });
    if (res.ok) {
      setUsers(prev => prev.map(u => {
        if (u.id !== id) return u;
        const updated = { ...u, ...editData };
        if (u.role === "GARAGE_OWNER" && u.garage) {
          updated.garage = { ...u.garage, phone: editData.phone || null };
        }
        return updated;
      }));
      setEditId(null);
    }
    setSaving(false);
  }

  async function deleteUser(id: string) {
    if (!confirm("¿Eliminar este usuario? Esta acción no se puede deshacer.")) return;
    setDeletingId(id);
    const res = await fetch(`/api/admin/users/${id}`, { method: "DELETE" });
    if (res.ok) {
      setUsers(prev => {
        const next = prev.filter(u => u.id !== id);
        const newTotalPages = Math.max(1, Math.ceil(next.length / pageSize));
        setPage(p => Math.min(p, newTotalPages));
        return next;
      });
      router.refresh();
    }
    setDeletingId(null);
  }

  return (
    <div>
      {/* Barra de búsqueda y filtro */}
      <div className="flex items-center gap-2 px-3 py-3 border-b border-gray-100">
        <div className="relative flex-1 max-w-xs">
          <Search className="absolute left-2.5 top-1/2 -translate-y-1/2 h-3.5 w-3.5 text-gray-400" />
          <Input
            value={search}
            onChange={e => { setSearch(e.target.value); setPage(1); }}
            placeholder="Buscar por nombre, email, teléfono…"
            className="h-8 pl-8 text-sm"
          />
        </div>
        <select
          value={roleFilter}
          onChange={e => { setRoleFilter(e.target.value); setPage(1); }}
          className="h-8 border border-gray-200 rounded-md px-2 bg-white text-xs text-gartify-gray"
        >
          <option value="ALL">Todos los roles</option>
          <option value="CUSTOMER">Conductores</option>
          <option value="GARAGE_OWNER">Talleres</option>
        </select>
        {(search || roleFilter !== "ALL") && (
          <button
            onClick={() => { setSearch(""); setRoleFilter("ALL"); setPage(1); }}
            className="text-xs text-gartify-gray hover:text-red-500 flex items-center gap-1"
          >
            <X className="h-3 w-3" /> Limpiar
          </button>
        )}
      </div>

    <div className="overflow-x-auto">
      <table className="w-full text-sm">
        <thead>
          <tr className="border-b border-gray-100 bg-gray-50">
            <th className="text-left px-3 py-3 text-xs font-semibold text-gartify-gray">Nombre</th>
            <th className="text-left px-3 py-3 text-xs font-semibold text-gartify-gray">Email</th>
            <th className="text-left px-3 py-3 text-xs font-semibold text-gartify-gray">Teléfono</th>
            <th className="text-left px-3 py-3 text-xs font-semibold text-gartify-gray">Rol</th>
            <th className="text-left px-3 py-3 text-xs font-semibold text-gartify-gray">Acceso</th>
            <th className="text-left px-3 py-3 text-xs font-semibold text-gartify-gray">Alta</th>
            <th className="px-3 py-3" />
          </tr>
        </thead>
        <tbody className="divide-y divide-gray-50">
          {paginatedUsers.map((u) => {
            const isEditing = editId === u.id;
            return (
              <tr key={u.id} className="hover:bg-gray-50 transition-colors">
                {/* Nombre */}
                <td className="px-3 py-3">
                  {isEditing ? (
                    <Input
                      value={editData.name}
                      onChange={e => setEditData(d => ({ ...d, name: e.target.value }))}
                      className="h-8 text-sm w-36"
                    />
                  ) : (
                    <>
                      <p className="font-semibold text-gartify-blue">{u.name ?? "—"}</p>
                      {u.garage && (
                        <p className="text-xs text-muted-foreground flex items-center gap-1">
                          {u.garage.name}
                        </p>
                      )}
                    </>
                  )}
                </td>

                {/* Email */}
                <td className="px-3 py-3 max-w-[180px]">
                  {isEditing ? (
                    <Input
                      value={editData.email}
                      onChange={e => setEditData(d => ({ ...d, email: e.target.value }))}
                      className="h-8 text-sm w-44"
                    />
                  ) : (
                    <span className="flex items-center gap-1 text-gartify-gray min-w-0">
                      <Mail className="h-3 w-3 shrink-0" />
                      <span className="truncate" title={u.email}>{u.email}</span>
                    </span>
                  )}
                </td>

                {/* Teléfono */}
                <td className="px-3 py-3 whitespace-nowrap">
                  {isEditing ? (
                    <Input
                      value={editData.phone}
                      onChange={e => setEditData(d => ({ ...d, phone: e.target.value }))}
                      className="h-8 text-sm w-28"
                      placeholder="—"
                    />
                  ) : (
                    <span className="text-gartify-gray">
                      {(u.role === "GARAGE_OWNER" ? (u.garage?.phone ?? u.phone) : u.phone) ?? <span className="text-gray-300">—</span>}
                    </span>
                  )}
                </td>

                {/* Rol */}
                <td className="px-3 py-3">
                  {isEditing ? (
                    <select
                      value={editData.role}
                      onChange={e => setEditData(d => ({ ...d, role: e.target.value }))}
                      className="h-8 text-sm border border-gray-200 rounded-md px-2 bg-white"
                    >
                      <option value="CUSTOMER">Conductor</option>
                      <option value="GARAGE_OWNER">Taller</option>
                    </select>
                  ) : (
                    <div className="flex items-center gap-1.5">
                      <Badge className={`text-xs ${ROLE_COLORS[u.role] ?? ""}`}>
                        {ROLE_LABELS[u.role] ?? u.role}
                      </Badge>
                      {u.garage && (
                        <span
                          title={`Plan ${PLAN_LABEL[u.garage.plan] ?? u.garage.plan}`}
                          className="flex items-center"
                        >
                          {PLAN_ICON[u.garage.plan] ?? PLAN_ICON.STARTER}
                        </span>
                      )}
                    </div>
                  )}
                </td>

                {/* Acceso */}
                <td className="px-3 py-3">
                  {u.password ? (
                    <span className="flex items-center gap-1 text-xs text-gartify-gray">
                      <Mail className="h-3 w-3" /> Email
                    </span>
                  ) : (
                    <span className="flex items-center gap-1 text-xs text-gartify-gray">
                      <Chrome className="h-3 w-3" /> Google
                    </span>
                  )}
                </td>

                {/* Alta */}
                <td className="px-5 py-3 text-xs text-muted-foreground whitespace-nowrap">
                  {new Date(u.createdAt).toLocaleDateString("es-ES")}
                </td>

                {/* Acciones */}
                <td className="px-3 py-3">
                  {isEditing ? (
                    <div className="flex items-center gap-1">
                      <Button
                        size="sm"
                        variant="ghost"
                        className="h-7 w-7 p-0 text-green-600 hover:text-green-700"
                        onClick={() => saveEdit(u.id)}
                        disabled={saving}
                      >
                        {saving ? <Loader2 className="h-3.5 w-3.5 animate-spin" /> : <Check className="h-3.5 w-3.5" />}
                      </Button>
                      <Button
                        size="sm"
                        variant="ghost"
                        className="h-7 w-7 p-0 text-gray-400 hover:text-gray-600"
                        onClick={cancelEdit}
                      >
                        <X className="h-3.5 w-3.5" />
                      </Button>
                    </div>
                  ) : (
                    <div className="flex items-center gap-1">
                      <Button
                        size="sm"
                        variant="ghost"
                        className="h-7 w-7 p-0 text-gartify-gray hover:text-gartify-blue"
                        onClick={() => startEdit(u)}
                      >
                        <Pencil className="h-3.5 w-3.5" />
                      </Button>
                      <Button
                        size="sm"
                        variant="ghost"
                        className="h-7 w-7 p-0 text-gartify-gray hover:text-red-600"
                        onClick={() => deleteUser(u.id)}
                        disabled={deletingId === u.id}
                      >
                        {deletingId === u.id
                          ? <Loader2 className="h-3.5 w-3.5 animate-spin" />
                          : <Trash2 className="h-3.5 w-3.5" />
                        }
                      </Button>
                    </div>
                  )}
                </td>
              </tr>
            );
          })}
          {filteredUsers.length === 0 && (
            <tr>
              <td colSpan={7} className="px-5 py-10 text-center text-muted-foreground text-sm">
                {users.length === 0 ? "No hay usuarios registrados" : "No hay resultados para esta búsqueda"}
              </td>
            </tr>
          )}
        </tbody>
      </table>

      {/* Footer: filas por página + paginador */}
      <div className="flex items-center justify-between px-3 py-3 border-t border-gray-100 bg-gray-50 text-xs text-gartify-gray">
        <div className="flex items-center gap-2">
          <span>Filas por página</span>
          <select
            value={pageSize}
            onChange={e => { setPageSize(Number(e.target.value)); setPage(1); }}
            className="h-7 border border-gray-200 rounded-md px-2 bg-white text-xs"
          >
            {PAGE_SIZE_OPTIONS.map(n => (
              <option key={n} value={n}>{n}</option>
            ))}
          </select>
          <span className="text-gray-400">
            {filteredUsers.length === 0 ? "0" : `${(safePage - 1) * pageSize + 1}–${Math.min(safePage * pageSize, filteredUsers.length)}`} de {filteredUsers.length}
          </span>
        </div>

        <div className="flex items-center gap-1">
          <Button
            size="sm"
            variant="ghost"
            className="h-7 w-7 p-0"
            onClick={() => setPage(1)}
            disabled={safePage === 1}
          >
            <ChevronLeft className="h-3.5 w-3.5" />
            <ChevronLeft className="h-3.5 w-3.5 -ml-2.5" />
          </Button>
          <Button
            size="sm"
            variant="ghost"
            className="h-7 w-7 p-0"
            onClick={() => setPage(p => Math.max(1, p - 1))}
            disabled={safePage === 1}
          >
            <ChevronLeft className="h-3.5 w-3.5" />
          </Button>
          <span className="px-2 font-medium text-gartify-blue">
            {safePage} / {totalPages}
          </span>
          <Button
            size="sm"
            variant="ghost"
            className="h-7 w-7 p-0"
            onClick={() => setPage(p => Math.min(totalPages, p + 1))}
            disabled={safePage === totalPages}
          >
            <ChevronRight className="h-3.5 w-3.5" />
          </Button>
          <Button
            size="sm"
            variant="ghost"
            className="h-7 w-7 p-0"
            onClick={() => setPage(totalPages)}
            disabled={safePage === totalPages}
          >
            <ChevronRight className="h-3.5 w-3.5" />
            <ChevronRight className="h-3.5 w-3.5 -ml-2.5" />
          </Button>
        </div>
      </div>
    </div>
    </div>
  );
}
