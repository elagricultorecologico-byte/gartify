"use client";
import Link from "next/link";
import Image from "next/image";
import { useSession, signOut } from "next-auth/react";
import { Menu, X, User, LogOut, Settings } from "lucide-react";
import { useState } from "react";
import { Button } from "@/components/ui/button";

export function Navbar() {
  const { data: session } = useSession();
  const [open, setOpen] = useState(false);
  const isGarageOwner = (session?.user as { role?: string })?.role === "GARAGE_OWNER";

  return (
    <header className="sticky top-0 z-50 bg-gartify-blue shadow-md">
      <div className="container flex h-16 items-center justify-between">
        {/* Logo */}
        <Link href="/" className="flex items-center">
          <Image src="/logo.png" alt="Gartify" width={200} height={56} className="h-12 w-auto object-contain" priority />
        </Link>

        {/* Desktop nav */}
        <nav className="hidden md:flex items-center gap-8 text-sm font-bold tracking-wide uppercase">
          <Link href="/talleres" className="text-white/80 hover:text-white transition-colors">
            Buscar taller
          </Link>
          <Link href="/como-funciona" className="text-white/80 hover:text-white transition-colors">
            Cómo funciona
          </Link>
          <Link href="/para-talleres" className="text-white/80 hover:text-white transition-colors">
            Para talleres
          </Link>
          <Link href="/precios" className="text-white/80 hover:text-white transition-colors">
            Precios
          </Link>
        </nav>

        {/* Auth */}
        <div className="hidden md:flex items-center gap-2 text-sm font-bold tracking-wide uppercase">
          {session ? (
            <>
              {isGarageOwner ? (
                /* — Garage owner: accesos directos al portal — */
                <>
                  <Link href="/cuenta/taller">
                    <Button variant="ghost" size="sm" className="gap-2 text-white hover:text-white hover:bg-white/10">
                      <Settings className="h-4 w-4" />
                      Mi portal
                    </Button>
                  </Link>
                  <Link href="/cuenta/taller/servicios">
                    <Button variant="ghost" size="sm" className="text-white/80 hover:text-white hover:bg-white/10">
                      Servicios
                    </Button>
                  </Link>
                  <Link href="/cuenta/taller/perfil">
                    <Button variant="ghost" size="sm" className="text-white/80 hover:text-white hover:bg-white/10">
                      Perfil
                    </Button>
                  </Link>
                </>
              ) : (
                /* — Cliente: enlace a mis reservas — */
                <Link href="/cuenta">
                  <Button variant="ghost" size="sm" className="gap-2 text-white hover:text-white hover:bg-white/10">
                    <User className="h-4 w-4" />
                    {session.user?.name?.split(" ")[0] ?? "Mi cuenta"}
                  </Button>
                </Link>
              )}
              <Button
                variant="ghost"
                size="sm"
                className="text-white/70 hover:text-white hover:bg-white/10"
                onClick={() => signOut({ callbackUrl: "/" })}
                aria-label="Cerrar sesión"
              >
                <LogOut className="h-4 w-4" />
              </Button>
            </>
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
          <Link href="/talleres" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Buscar taller</Link>
          <Link href="/como-funciona" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Cómo funciona</Link>
          <Link href="/para-talleres" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Para talleres</Link>
          <Link href="/precios" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Precios</Link>
          {session ? (
            <>
              {isGarageOwner ? (
                <>
                  <Link href="/cuenta/taller" className="block text-sm text-white font-semibold" onClick={() => setOpen(false)}>Mi portal</Link>
                  <Link href="/cuenta/taller/servicios" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Servicios</Link>
                  <Link href="/cuenta/taller/perfil" className="block text-sm text-blue-200 hover:text-white" onClick={() => setOpen(false)}>Perfil del taller</Link>
                </>
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
