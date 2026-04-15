"use client";
import Link from "next/link";
import Image from "next/image";
import { useSession, signOut } from "next-auth/react";
import { Menu, X, LogOut, Settings, CreditCard, Wrench, Tag, CalendarClock, User, Truck } from "lucide-react";
import { useState, useRef, useEffect, useCallback } from "react";
import { Button } from "@/components/ui/button";

export function Navbar() {
  const { data: session } = useSession();
  const [open, setOpen] = useState(false);
  const [dropdownOpen, setDropdownOpen] = useState(false);
  const dropdownRef = useRef<HTMLDivElement>(null);
  const rol = (session?.user as { role?: string })?.role;
  const isGarageOwner = rol === "GARAGE_OWNER";
  const isAdmin = rol === "ADMIN";
  const isDistributor = rol === "DISTRIBUTOR";
  const firstName = session?.user?.name?.split(" ")[0] ?? "Usuario";
  const initial = session?.user?.name?.charAt(0).toUpperCase() ?? "U";

  const rolLabel = isAdmin ? "Administrador"
    : isGarageOwner ? "Taller"
    : isDistributor ? "Distribuidor"
    : "Conductor";
  const rolStyle = isAdmin ? "bg-purple-500/20 text-purple-200"
    : isGarageOwner ? "bg-blue-400/20 text-blue-200"
    : isDistributor ? "bg-orange-400/20 text-orange-200"
    : "bg-white/10 text-white/60";
  const [counts, setCounts] = useState<{ services: number; offers: number } | null>(null);

  const fetchCounts = useCallback(async () => {
    if (!isGarageOwner) return;
    const res = await fetch("/api/garage/counts");
    if (res.ok) setCounts(await res.json() as { services: number; offers: number });
  }, [isGarageOwner]);

  useEffect(() => {
    function handleClickOutside(e: MouseEvent) {
      if (dropdownRef.current && !dropdownRef.current.contains(e.target as Node)) {
        setDropdownOpen(false);
      }
    }
    document.addEventListener("mousedown", handleClickOutside);
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, []);

  useEffect(() => {
    if (dropdownOpen) fetchCounts();
  }, [dropdownOpen, fetchCounts]);

  return (
    <header className="sticky top-0 z-50 bg-gartify-blue shadow-md">
      <div className="container flex h-16 items-center justify-between">
        {/* Logo */}
        <Link href="/" className="flex items-center">
          <Image src="/logo.png" alt="Gartify" width={200} height={56} className="h-12 w-auto object-contain" priority />
        </Link>

        {/* Desktop nav */}
        <nav className="hidden md:flex items-center gap-8 text-sm font-bold tracking-wide uppercase">
          <Link href="/como-funciona" className="text-white/80 hover:text-white transition-colors">
            Cómo funciona
          </Link>
          <Link href="/para-talleres" className="text-white/80 hover:text-white transition-colors">
            Para talleres
          </Link>
        </nav>

        {/* Auth */}
        <div className="hidden md:flex items-center gap-2">
          {session ? (
            <div className="relative" ref={dropdownRef}>
              {/* Avatar trigger */}
              <button
                onClick={() => setDropdownOpen(!dropdownOpen)}
                className="flex items-center gap-2 rounded-full pl-1 pr-3 py-1 hover:bg-white/10 transition-colors"
              >
                <div className="h-8 w-8 rounded-full bg-gartify-orange flex items-center justify-center text-white text-sm font-bold shrink-0">
                  {initial}
                </div>
                <div className="flex flex-col items-start">
                  <span className="text-white text-sm font-semibold leading-tight">{firstName}</span>
                  <span className={`text-[10px] font-semibold px-1.5 py-0.5 rounded-full leading-tight ${rolStyle}`}>{rolLabel}</span>
                </div>
              </button>

              {/* Dropdown */}
              {dropdownOpen && (
                <div className="absolute right-0 top-full mt-2 w-52 bg-white rounded-xl shadow-lg border border-gray-100 py-1.5 z-50">
                  {/* Header */}
                  <div className="px-4 py-2 border-b border-gray-100">
                    <p className="text-xs text-muted-foreground">Conectado como</p>
                    <p className="text-sm font-semibold text-gartify-blue truncate">{session.user?.name}</p>
                  </div>

                  {/* Links según rol */}
                  {isGarageOwner ? (
                    <>
                      <Link href="/cuenta/taller" onClick={() => setDropdownOpen(false)} className="flex items-center gap-2.5 px-4 py-2 text-sm text-gray-700 hover:bg-gray-50">
                        <Settings className="h-4 w-4 text-gartify-blue" />Mi portal
                      </Link>
                      <Link href="/cuenta/taller/perfil" onClick={() => setDropdownOpen(false)} className="flex items-center gap-2.5 px-4 py-2 text-sm text-gray-700 hover:bg-gray-50">
                        <User className="h-4 w-4 text-gartify-blue" />Perfil del taller
                      </Link>
                      <Link href="/cuenta/taller/servicios" onClick={() => setDropdownOpen(false)} className="flex items-center gap-2.5 px-4 py-2 text-sm text-gray-700 hover:bg-gray-50">
                        <Wrench className="h-4 w-4 text-gartify-blue" />
                        Servicios
                        {counts && <span className="ml-auto text-xs text-muted-foreground">({counts.services})</span>}
                      </Link>
                      <Link href="/cuenta/taller/ofertas" onClick={() => setDropdownOpen(false)} className="flex items-center gap-2.5 px-4 py-2 text-sm text-gray-700 hover:bg-gray-50">
                        <Tag className="h-4 w-4 text-gartify-blue" />
                        Ofertas
                        {counts && <span className="ml-auto text-xs text-muted-foreground">({counts.offers})</span>}
                      </Link>
                      <Link href="/cuenta/taller/planes" onClick={() => setDropdownOpen(false)} className="flex items-center gap-2.5 px-4 py-2 text-sm text-gray-700 hover:bg-gray-50">
                        <CreditCard className="h-4 w-4 text-gartify-blue" />Planes
                      </Link>
                    </>
                  ) : isAdmin ? (
                    <Link href="/admin" onClick={() => setDropdownOpen(false)} className="flex items-center gap-2.5 px-4 py-2 text-sm text-gray-700 hover:bg-gray-50">
                      <Settings className="h-4 w-4 text-gartify-blue" />Panel admin
                    </Link>
                  ) : isDistributor ? (
                    <Link href="/distribuidor/dashboard" onClick={() => setDropdownOpen(false)} className="flex items-center gap-2.5 px-4 py-2 text-sm text-gray-700 hover:bg-gray-50">
                      <Truck className="h-4 w-4 text-gartify-blue" />Mi dashboard
                    </Link>
                  ) : (
                    <>
                      <Link href="/cuenta" onClick={() => setDropdownOpen(false)} className="flex items-center gap-2.5 px-4 py-2 text-sm text-gray-700 hover:bg-gray-50">
                        <CalendarClock className="h-4 w-4 text-gartify-blue" />Mis reservas
                      </Link>
                      <Link href="/cuenta/perfil" onClick={() => setDropdownOpen(false)} className="flex items-center gap-2.5 px-4 py-2 text-sm text-gray-700 hover:bg-gray-50">
                        <User className="h-4 w-4 text-gartify-blue" />Mi perfil
                      </Link>
                    </>
                  )}

                  {/* Cerrar sesión */}
                  <div className="border-t border-gray-100 mt-1 pt-1">
                    <button
                      onClick={() => signOut({ callbackUrl: "/" })}
                      className="flex items-center gap-2.5 px-4 py-2 text-sm text-red-500 hover:bg-red-50 w-full"
                    >
                      <LogOut className="h-4 w-4" />Cerrar sesión
                    </button>
                  </div>
                </div>
              )}
            </div>
          ) : (
            <>
              <Link href="/login">
                <Button variant="ghost" size="sm" className="text-white hover:text-white hover:bg-white/10">
                  Iniciar sesión
                </Button>
              </Link>
              <Link href="/registro">
                <Button size="sm" className="border border-gartify-orange bg-transparent text-gartify-orange hover:bg-gartify-orange hover:text-white">
                  Registrarse
                </Button>
              </Link>
            </>
          )}
        </div>

        {/* Mobile toggle */}
        <button className="md:hidden text-white" onClick={() => setOpen(!open)}>
          {open ? <X className="h-5 w-5" /> : <Menu className="h-5 w-5" />}
        </button>
      </div>

      {/* Mobile menu */}
      {open && (
        <div className="md:hidden border-t border-white/10 bg-gartify-blue px-4 py-4 space-y-3">
          <Link href="/como-funciona" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Cómo funciona</Link>
          <Link href="/para-talleres" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Para talleres</Link>
          {session ? (
            <>
              <div className="flex items-center gap-2 pb-2 border-b border-white/10">
                <div className="h-7 w-7 rounded-full bg-gartify-orange flex items-center justify-center text-white text-xs font-bold shrink-0">
                  {session.user?.name?.charAt(0).toUpperCase() ?? "U"}
                </div>
                <div className="flex flex-col">
                  <span className="text-white text-sm font-semibold leading-tight">{session.user?.name ?? "Usuario"}</span>
                  <span className={`text-[10px] font-semibold px-1.5 py-0.5 rounded-full leading-tight self-start ${rolStyle}`}>{rolLabel}</span>
                </div>
              </div>
              {isGarageOwner ? (
                <>
                  <Link href="/cuenta/taller" className="block text-sm text-white font-semibold" onClick={() => setOpen(false)}>Mi portal</Link>
                  <Link href="/cuenta/taller/servicios" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Servicios</Link>
                  <Link href="/cuenta/taller/perfil" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Perfil del taller</Link>
                  <Link href="/cuenta/taller/planes" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Planes y suscripcion</Link>
                </>
              ) : isDistributor ? (
                <Link href="/distribuidor/dashboard" className="block text-sm text-white font-semibold" onClick={() => setOpen(false)}>Mi dashboard</Link>
              ) : (
                <Link href="/cuenta" className="block text-sm text-white" onClick={() => setOpen(false)}>Mis reservas</Link>
              )}
              <button className="block text-sm text-red-300 pt-1" onClick={() => signOut({ callbackUrl: "/" })}>Cerrar sesión</button>
            </>
          ) : (
            <div className="flex gap-2 pt-2">
              <Link href="/login" onClick={() => setOpen(false)}>
                <Button variant="ghost" size="sm" className="text-white hover:bg-white/10">Iniciar sesión</Button>
              </Link>
              <Link href="/registro" onClick={() => setOpen(false)}>
                <Button size="sm" className="border border-gartify-orange bg-transparent text-gartify-orange hover:bg-gartify-orange hover:text-white">Registrarse</Button>
              </Link>
            </div>
          )}
        </div>
      )}
    </header>
  );
}
