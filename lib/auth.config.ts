import type { NextAuthConfig } from "next-auth";
import { NextResponse } from "next/server";

export const authConfig: NextAuthConfig = {
  pages: {
    signIn: "/login",
  },
  callbacks: {
    authorized({ auth, request: { nextUrl } }) {
      const isLoggedIn = !!auth?.user;
      const rol = (auth?.user as { role?: string } | undefined)?.role;
      const pathname = nextUrl.pathname;

      const isOnCuenta      = pathname.startsWith("/cuenta");
      const isOnAdmin       = pathname.startsWith("/admin");
      const isOnDistribuidor = pathname.startsWith("/distribuidor");

      // Rutas protegidas: requieren sesión activa
      if (isOnCuenta || isOnAdmin || isOnDistribuidor) {
        if (!isLoggedIn) return false; // redirige a /login
      }

      // Si un DISTRIBUTOR accede a /cuenta, redirigir a su dashboard
      if (isOnCuenta && rol === "DISTRIBUTOR") {
        return NextResponse.redirect(new URL("/distribuidor/dashboard", nextUrl));
      }

      return true;
    },
    jwt({ token, user }) {
      if (user) {
        token.id = user.id;
        token.role = (user as { role?: string }).role;
      }
      return token;
    },
    session({ session, token }) {
      if (token && session.user) {
        session.user.id = token.id as string;
        (session.user as { role?: string }).role = token.role as string;
      }
      return session;
    },
  },
  providers: [],
};
