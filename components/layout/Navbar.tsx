"use client";
import Link from "next/link";
import Image from "next/image";
import { useSession, signOut } from "next-auth/react";
import { Menu, X, LogOut, Settings, Truck, Zap, Crown, Wrench, Package } from "lucide-react";
import { useState, useRef, useEffect, useCallback } from "react";
import { Button } from "@/components/ui/button";

const TZ_TO_COUNTRY: Record<string, string> = {
  "Europe/Madrid": "ES", "Atlantic/Canary": "ES", "Africa/Ceuta": "ES",
  "Europe/Lisbon": "PT", "Atlantic/Azores": "PT", "Atlantic/Madeira": "PT",
  "America/Mexico_City": "MX", "America/Cancun": "MX", "America/Merida": "MX",
  "America/Bogota": "CO", "America/Lima": "PE", "America/Santiago": "CL",
  "America/Argentina/Buenos_Aires": "AR", "America/Caracas": "VE",
  "America/La_Paz": "BO", "America/Guayaquil": "EC", "America/Asuncion": "PY",
  "America/Montevideo": "UY", "America/Panama": "PA", "America/Costa_Rica": "CR",
  "America/Guatemala": "GT", "America/Tegucigalpa": "HN", "America/Managua": "NI",
  "America/El_Salvador": "SV", "America/Santo_Domingo": "DO", "America/Havana": "CU",
};

function useCountryCode() {
  const [code, setCode] = useState("ES");
  useEffect(() => {
    try {
      const tz = Intl.DateTimeFormat().resolvedOptions().timeZone;
      const country = TZ_TO_COUNTRY[tz]
        ?? navigator.language?.split("-")[1]?.toUpperCase()
        ?? "ES";
      setCode(country);
    } catch { /* mantiene ES */ }
  }, []);
  return code;
}

export function Navbar() {
  const { data: session } = useSession();
  const countryCode = useCountryCode();
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
  const [counts, setCounts] = useState<{ name: string; plan: string; services: number; offers: number } | null>(null);

  const fetchCounts = useCallback(async () => {
    if (!isGarageOwner) return;
    const res = await fetch("/api/garage/counts");
    if (res.ok) setCounts(await res.json() as { name: string; plan: string; services: number; offers: number });
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

  // Fetch garage data eagerly para GARAGE_OWNER (nombre + plan en el avatar)
  useEffect(() => {
    void fetchCounts();
  }, [fetchCounts]);

  useEffect(() => {
    if (dropdownOpen) void fetchCounts();
  }, [dropdownOpen, fetchCounts]);

  return (
    <header className="sticky top-0 z-50 bg-gartify-blue shadow-md">
      {/* ── Top bar ── */}
      <div className="hidden md:block bg-blue-700 border-b border-white/10">
        <div className="container flex items-center justify-end gap-6 h-8 text-xs">
          <Link href="/para-talleres" className="flex items-center gap-1.5 text-blue-100 hover:text-white transition-colors font-medium">
            <Wrench className="h-3.5 w-3.5" />
            Soy taller
          </Link>
          <span className="h-3 w-px bg-white/20" />
          <Link href="/contacto" className="flex items-center gap-1.5 text-blue-100 hover:text-white transition-colors font-medium">
            <Package className="h-3.5 w-3.5" />
            Soy casa de recambios
          </Link>
          <span className="h-3 w-px bg-white/20" />
          <span className="flex items-center gap-1.5 text-blue-100 font-medium select-none">
            {/* eslint-disable-next-line @next/next/no-img-element */}
            <img
              src={`https://flagcdn.com/20x15/${countryCode.toLowerCase()}.png`}
              width={20}
              height={15}
              alt={countryCode}
              className="shrink-0"
            />
            {countryCode}
          </span>
        </div>
      </div>

      <div className="container flex h-16 items-center justify-between">
        {/* Logo */}
        <Link href="/" className="flex items-center">
          <Image src="/logo.png" alt="Gartify" width={200} height={56} className="h-12 w-auto object-contain" priority />
        </Link>


        {/* Auth */}
        <div className="hidden md:flex items-center gap-2">
          {session ? (
            <div className="relative" ref={dropdownRef}>
              {/* Avatar — para GARAGE_OWNER: estático. Para otros roles: abre dropdown */}
              {isGarageOwner ? (
                <div className="flex items-center gap-1">
                  <Link href="/cuenta/taller" className="flex items-center gap-2 rounded-full pl-1 pr-3 py-1 hover:bg-white/10 transition-colors">
                    <div className="h-8 w-8 rounded-full bg-gartify-orange flex items-center justify-center text-white text-sm font-bold shrink-0">
                      {initial}
                    </div>
                    <div className="flex flex-col items-start">
                      {counts ? (
                        <>
                          <span className="text-white text-sm font-semibold leading-tight max-w-[140px] truncate">{counts.name}</span>
                          <span className={`text-[10px] font-bold px-1.5 py-0.5 rounded-full leading-tight inline-flex items-center gap-1 ${
                            counts.plan === "PRO"     ? "bg-blue-400/20 text-blue-200" :
                            counts.plan === "PREMIUM" ? "bg-amber-400/20 text-amber-200" :
                                                        "bg-white/10 text-white/60"
                          }`}>
                            {counts.plan === "PRO"     && <Zap   className="h-2.5 w-2.5" />}
                            {counts.plan === "PREMIUM" && <Crown className="h-2.5 w-2.5" />}
                            {counts.plan === "STARTER" ? "Starter" : counts.plan === "PRO" ? "Pro" : "Premium"}
                          </span>
                        </>
                      ) : (
                        <span className="text-white text-sm font-semibold leading-tight">{firstName}</span>
                      )}
                    </div>
                  </Link>
                </div>
              ) : !isAdmin && !isDistributor ? (
                /* Conductor — avatar estático, sin dropdown (usa sidebar) */
                <div className="relative group">
                  <Link href="/cuenta" className="flex items-center gap-2 pl-1 pr-3 py-1 hover:bg-white/10 transition-colors">
                    <div className="h-8 w-8 bg-gartify-orange flex items-center justify-center text-white text-sm font-bold shrink-0">
                      {initial}
                    </div>
                    <div className="flex flex-col items-start">
                      <span className="text-white text-sm font-semibold leading-tight">{firstName}</span>
                      <span className={`text-[10px] font-semibold px-1.5 py-0.5 leading-tight ${rolStyle}`}>{rolLabel}</span>
                    </div>
                  </Link>
                  {/* Tooltip */}
                  <div className="pointer-events-none absolute right-0 top-full mt-2 w-max bg-gartify-dark border border-white/10 px-3 py-1.5 text-xs text-white opacity-0 group-hover:opacity-100 transition-opacity duration-150 z-50 whitespace-nowrap">
                    Ir a mi panel
                  </div>
                </div>
              ) : (
                /* Admin / Distribuidor — con dropdown */
                <div className="flex items-center gap-1">
                  {(isAdmin || isDistributor) && (
                    <Link
                      href={isAdmin ? "/admin" : "/distribuidor/dashboard"}
                      className="px-3 py-1.5 rounded-lg text-xs font-semibold text-white/80 hover:text-white hover:bg-white/10 transition-colors"
                    >
                      {isAdmin ? "Panel admin" : "Mi dashboard"}
                    </Link>
                  )}
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
                </div>
              )}

              {/* Dropdown — solo admin y distribuidor */}
              {(isAdmin || isDistributor) && dropdownOpen && (
                <div className="absolute right-0 top-full mt-2 w-52 bg-white rounded-xl shadow-lg border border-gray-100 py-1.5 z-50">
                  <div className="px-4 py-2 border-b border-gray-100">
                    <p className="text-xs text-muted-foreground">Conectado como</p>
                    <p className="text-sm font-semibold text-gartify-blue truncate">{session.user?.name}</p>
                  </div>

                  {isAdmin ? (
                    <Link href="/admin" onClick={() => setDropdownOpen(false)} className="flex items-center gap-2.5 px-4 py-2 text-sm text-gray-700 hover:bg-gray-50">
                      <Settings className="h-4 w-4 text-gartify-blue" />Panel admin
                    </Link>
                  ) : (
                    <Link href="/distribuidor/dashboard" onClick={() => setDropdownOpen(false)} className="flex items-center gap-2.5 px-4 py-2 text-sm text-gray-700 hover:bg-gray-50">
                      <Truck className="h-4 w-4 text-gartify-blue" />Mi dashboard
                    </Link>
                  )}

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
                  Entrar
                </Button>
              </Link>
              <Link href="/talleres">
                <Button size="sm" className="bg-gartify-orange hover:bg-orange-600 text-white font-bold shadow-sm">
                  Buscar taller
                </Button>
              </Link>
            </>
          )}
        </div>

        {/* Mobile toggle */}
        <div className="md:hidden flex items-center gap-1">
          <button className="text-white p-1" onClick={() => setOpen(!open)}>
            {open ? <X className="h-5 w-5" /> : <Menu className="h-5 w-5" />}
          </button>
        </div>
      </div>

      {/* Mobile menu */}
      {open && (
        <div className="md:hidden border-t border-white/10 bg-gartify-blue px-4 py-4 space-y-3 max-h-[calc(100vh-4rem)] overflow-y-auto">
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
                  <Link href="/cuenta/taller" className="block text-sm text-white font-semibold" onClick={() => setOpen(false)}>Reservas</Link>
                  <Link href="/cuenta/taller/agenda" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Agenda</Link>
                  <Link href="/cuenta/taller/servicios" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Servicios</Link>
                  <Link href="/cuenta/taller/horario" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Horario</Link>
                  <Link href="/cuenta/taller/ofertas" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Ofertas</Link>
                  <Link href="/cuenta/taller/recambios" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Recambios</Link>
                  <Link href="/cuenta/taller/planes" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Mi plan</Link>
                  <Link href="/cuenta/taller/tv" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Modo TV</Link>
                </>
              ) : isDistributor ? (
                <Link href="/distribuidor/dashboard" className="block text-sm text-white font-semibold" onClick={() => setOpen(false)}>Mi dashboard</Link>
              ) : (
                <>
                  <Link href="/cuenta" className="block text-sm text-white" onClick={() => setOpen(false)}>Mis reservas</Link>
                  <Link href="/cuenta/vehiculos" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Mis vehículos</Link>
                  <Link href="/cuenta/perfil" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Mi perfil</Link>
                </>
              )}
              <button className="block text-sm text-red-300 pt-1" onClick={() => signOut({ callbackUrl: "/" })}>Cerrar sesión</button>
            </>
          ) : (
            <div className="flex flex-col gap-2 pt-2">
              <Link href="/talleres" onClick={() => setOpen(false)}>
                <Button size="sm" className="w-full bg-gartify-orange hover:bg-orange-600 text-white font-bold">Buscar taller</Button>
              </Link>
              <Link href="/login" onClick={() => setOpen(false)}>
                <Button variant="ghost" size="sm" className="w-full text-white hover:bg-white/10">Entrar</Button>
              </Link>
            </div>
          )}
        </div>
      )}
    </header>
  );
}
