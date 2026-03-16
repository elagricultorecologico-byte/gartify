import NextAuth from "next-auth";
import Credentials from "next-auth/providers/credentials";
import Google from "next-auth/providers/google";
import bcrypt from "bcryptjs";
import { z } from "zod";
import { db } from "./db";
import { authConfig } from "./auth.config";

export const { auth, signIn, signOut, handlers } = NextAuth({
  ...authConfig,
  providers: [
    Google({
      clientId:     process.env.GOOGLE_CLIENT_ID,
      clientSecret: process.env.GOOGLE_CLIENT_SECRET,
    }),
    Credentials({
      async authorize(credentials) {
        const parsed = z
          .object({ email: z.string().email(), password: z.string().min(6) })
          .safeParse(credentials);

        if (!parsed.success) return null;
        const { email, password } = parsed.data;

        const user = await db.user.findUnique({ where: { email } });
        if (!user?.password) return null;

        const ok = await bcrypt.compare(password, user.password);
        if (!ok) return null;

        return { id: user.id, name: user.name, email: user.email, role: user.role };
      },
    }),
  ],
  callbacks: {
    // Keep edge-safe authorized check from config
    authorized: authConfig.callbacks!.authorized,

    // Upsert Google users into our DB on first sign-in
    async signIn({ user, account }) {
      if (account?.provider === "google" && user.email) {
        await db.user.upsert({
          where:  { email: user.email },
          update: { name: user.name ?? undefined },
          create: { email: user.email, name: user.name, role: "CUSTOMER" },
        });
      }
      return true;
    },

    // Attach id + role to JWT token
    async jwt({ token, user, account }) {
      // Credentials login — user object is present
      if (user) {
        token.id   = user.id;
        token.role = (user as { role?: string }).role;
      }
      // Google login — look up user in DB to get id + role
      if (account?.provider === "google" && token.email) {
        const dbUser = await db.user.findUnique({ where: { email: token.email } });
        if (dbUser) {
          token.id   = dbUser.id;
          token.role = dbUser.role;
        }
      }
      return token;
    },

    // Expose id + role on the session object
    session({ session, token }) {
      if (token && session.user) {
        session.user.id = token.id as string;
        (session.user as { role?: string }).role = token.role as string;
      }
      return session;
    },
  },
  session: { strategy: "jwt" },
});
