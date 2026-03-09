"use client";
import Link from "next/link";
import { useSession, signOut } from "next-auth/react";
import { Wrench, Menu, X, User, LogOut, Settings } from "lucide-react";
import { useState } from "react";
import { Button } from "@/components/ui/button";

export function Navbar() {
  const { data: session } = useSession();
  const [open, setOpen] = useState(false);
  const isGarageOwner = (session?.user as { role?: string })?.role === "GARAGE_OWNER";

  return (
    <header className="sticky top-0 z-50 border-b border-border bg-background/95 backdrop-blur">
      <div className="container flex h-16 items-center justify-between">
        {/* Logo */}
        <Link href="/" className="flex items-center gap-2 font-bold text-xl">
          <div className="flex h-8 w-8 items-center justify-center rounded-lg bg-gartify-orange">
            <Wrench className="h-4 w-4 text-white" />
          </div>
          <span className="text-foreground">
            Gar<span className="text-gartify-orange">tify</span>
          </span>
        </Link>

        {/* Desktop nav */}
        <nav className="hidden md:flex items-center gap-6 text-sm">
          <Link href="/talleres" className="text-muted-foreground hover:text-foreground transition-colors">
            Buscar taller
          </Link>
          <Link href="/como-funciona" className="text-muted-foreground hover:text-foreground transition-colors">
            Cómo funciona
          </Link>
          <Link href="/para-talleres" className="text-muted-foreground hover:text-foreground transition-colors">
            Para talleres
          </Link>
        </nav>

        {/* Auth */}
        <div className="hidden md:flex items-center gap-3">
          {session ? (
            <>
              <Link href={isGarageOwner ? "/cuenta/taller" : "/cuenta"}>
                <Button variant="ghost" size="sm" className="gap-2">
                  <User className="h-4 w-4" />
                  {session.user?.name?.split(" ")[0]}
                </Button>
              </Link>
              {isGarageOwner && (
                <Link href="/cuenta/taller">
                  <Button variant="outline" size="sm" className="gap-2">
                    <Settings className="h-4 w-4" />
                    Mi taller
                  </Button>
                </Link>
              )}
              <Button variant="ghost" size="sm" onClick={() => signOut({ callbackUrl: "/" })}>
                <LogOut className="h-4 w-4" />
              </Button>
            </>
          ) : (
            <>
              <Link href="/login">
                <Button variant="ghost" size="sm">Iniciar sesión</Button>
              </Link>
              <Link href="/registro">
                <Button size="sm">Registrarse</Button>
              </Link>
            </>
          )}
        </div>

        {/* Mobile toggle */}
        <button className="md:hidden" onClick={() => setOpen(!open)}>
          {open ? <X className="h-5 w-5" /> : <Menu className="h-5 w-5" />}
        </button>
      </div>

      {/* Mobile menu */}
      {open && (
        <div className="md:hidden border-t border-border bg-background px-4 py-4 space-y-3">
          <Link href="/talleres" className="block text-sm text-muted-foreground hover:text-foreground" onClick={() => setOpen(false)}>Buscar taller</Link>
          <Link href="/como-funciona" className="block text-sm text-muted-foreground hover:text-foreground" onClick={() => setOpen(false)}>Cómo funciona</Link>
          <Link href="/para-talleres" className="block text-sm text-muted-foreground hover:text-foreground" onClick={() => setOpen(false)}>Para talleres</Link>
          {session ? (
            <>
              <Link href={isGarageOwner ? "/cuenta/taller" : "/cuenta"} className="block text-sm" onClick={() => setOpen(false)}>Mi cuenta</Link>
              <button className="block text-sm text-red-400" onClick={() => signOut({ callbackUrl: "/" })}>Cerrar sesión</button>
            </>
          ) : (
            <div className="flex gap-2 pt-2">
              <Link href="/login" onClick={() => setOpen(false)}><Button variant="outline" size="sm">Iniciar sesión</Button></Link>
              <Link href="/registro" onClick={() => setOpen(false)}><Button size="sm">Registrarse</Button></Link>
            </div>
          )}
        </div>
      )}
    </header>
  );
}
