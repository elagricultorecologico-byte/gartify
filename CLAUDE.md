# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

```bash
# Development
npm run dev          # Start dev server at localhost:3000
npm run build        # Production build
npm run lint         # ESLint

# Database
npx prisma db push   # Apply schema changes to SQLite DB
npm run db:seed      # Seed 7 demo garages + demo accounts + reservas y reseñas de prueba
npm run db:studio    # Open Prisma Studio GUI
npm run db:generate  # Regenerate Prisma client after schema changes
```

> **Note:** `npm` is not in Git Bash PATH on this machine. Use Windows Terminal or PowerShell for npm commands.

## Demo Accounts (after seed)

| Rol | Email | Contraseña | Ubicación |
|-----|-------|-----------|-----------|
| Admin | admin@gartify.es | admin123 | — |
| Cliente | cliente@gartify.es | password123 | — |
| Taller 1 | taller1@gartify.es | password123 | Madrid - Alcalá |
| Taller 2 | taller2@gartify.es | password123 | Madrid - Castellana |
| Taller 3 | taller3@gartify.es | password123 | Madrid - Vallecas |
| Taller 4 | taller4@gartify.es | password123 | Barcelona - Eixample |
| Taller 5 | taller5@gartify.es | password123 | Barcelona - Gràcia |
| Taller 6 | taller6@gartify.es | password123 | Sant Feliu de Llobregat |
| Taller 7 | taller7@gartify.es | password123 | Sant Feliu de Llobregat |

## Tech Stack

| Capa | Tecnología |
|------|-----------|
| Framework | Next.js 14.2 (App Router) + React 18 |
| Lenguaje | TypeScript 5.5 strict |
| Estilos | Tailwind CSS 3.4 + shadcn/ui (Radix UI) |
| Autenticación | Auth.js v5 (`next-auth@5.0.0-beta.25`) — JWT + Credentials |
| Base de datos | Prisma 5 + SQLite (`prisma/dev.db`) |
| Mapa | Leaflet + react-leaflet (dynamic import, SSR disabled) |
| Validación | Zod 3 + bcryptjs |

> **Atención:** `next-auth@5` es beta. Usar `auth()` en lugar de `getServerSession()`. Separar `auth.config.ts` (Edge) de `auth.ts` (Node.js).

---

## Estructura del Proyecto

```
gartify/
├── app/
│   ├── (auth)/
│   │   ├── login/page.tsx
│   │   └── registro/page.tsx          # Tabs: cliente / taller
│   ├── api/
│   │   ├── auth/[...nextauth]/route.ts
│   │   ├── register/route.ts           # Registro cliente
│   │   ├── garage/
│   │   │   ├── register/route.ts       # Registro taller (User + Garage nested)
│   │   │   ├── services/route.ts       # POST → crear GarageService
│   │   │   └── profile/route.ts        # PATCH → editar datos del taller
│   │   └── bookings/
│   │       ├── route.ts                # GET (mis reservas) + POST (crear reserva)
│   │       └── [id]/route.ts           # PATCH (cambiar estado)
│   ├── talleres/
│   │   ├── page.tsx                    # Resultados + mapa Leaflet
│   │   └── [id]/
│   │       ├── page.tsx                # Perfil del taller
│   │       └── reservar/page.tsx       # Wizard de reserva (3 pasos)
│   ├── cuenta/
│   │   ├── page.tsx                    # Dashboard cliente (mis reservas)
│   │   └── taller/
│   │       ├── page.tsx                # Portal taller: stats + reservas
│   │       ├── servicios/page.tsx      # Listado + añadir servicios
│   │       └── perfil/page.tsx         # Editar datos del taller
│   ├── reserva/[id]/page.tsx           # Confirmación de reserva
│   ├── layout.tsx
│   └── page.tsx                        # Home: hero + SearchBar + cómo funciona
├── components/
│   ├── booking/BookingWizard.tsx       # Client: 3-step wizard con time slots
│   ├── cuenta/
│   │   ├── BookingStatusUpdater.tsx    # Select para cambiar estado de reserva
│   │   ├── ServiceForm.tsx             # Formulario añadir servicio
│   │   └── GarageProfileForm.tsx       # Formulario editar perfil del taller
│   ├── home/SearchBar.tsx              # Servicio + ciudad → /talleres?...
│   ├── layout/Navbar.tsx
│   ├── providers/SessionProvider.tsx
│   ├── talleres/
│   │   ├── GarageCard.tsx
│   │   ├── GarageFilters.tsx
│   │   └── GarageMap.tsx              # Leaflet (lazy, "use client")
│   └── ui/                            # shadcn/ui components
├── lib/
│   ├── auth.config.ts                 # Edge-safe (middleware)
│   ├── auth.ts                        # Full auth con Prisma
│   ├── db.ts                          # Prisma singleton
│   └── utils.ts                       # cn(), SERVICE_LABELS, formatPrice, formatDate
├── prisma/
│   ├── schema.prisma
│   └── seed.ts
└── middleware.ts                       # Protege /cuenta/**
```

---

## Architecture

### Auth Split (Critical)

Two auth files exist because middleware runs on the Edge:
- `lib/auth.config.ts` — Edge-safe (no Prisma, no bcrypt). Used by `middleware.ts`.
- `lib/auth.ts` — Full auth with Prisma Credentials provider. Used by server components and API routes.

Never import `lib/auth.ts` from middleware.

### DB Models

- **User** — `role: CUSTOMER | GARAGE_OWNER | ADMIN`
- **Garage** — one-to-one with `User` (`ownerId @unique`). Has `lat/lng Float?` for Leaflet.
- **GarageService** — `type: ServiceType` enum, `price Float`, `duration Int` (minutes)
- **Booking** — links User + Garage + GarageService; `status: BookingStatus` enum
- **Review** — one-to-one with Booking (`bookingId @unique`)

### Leaflet Map

`components/talleres/GarageMap.tsx` uses `react-leaflet` with a custom orange `divIcon`. Always import with `dynamic(() => import(...), { ssr: false })` to avoid SSR errors.

### Role-Based Routing

- `GARAGE_OWNER` visiting `/cuenta` is redirected to `/cuenta/taller`
- Middleware protects all `/cuenta/**` routes
- API routes verify garage ownership (`garage.ownerId === session.user.id`) before mutations

### Booking Wizard

`components/booking/BookingWizard.tsx` is fully client-side (useState). Steps:
1. Service selector cards
2. Date picker + auto-generated time slots (8:00–17:30, 30 min intervals)
3. Confirmation with vehicle info form

On submit → POST `/api/bookings` → redirect to `/reserva/[id]`.

## Agentes Especializados

Los agentes del proyecto están en `.claude/agents/` y trabajan en español:

| Agente | Archivo | Especialidad |
|--------|---------|-------------|
| `gartify-dev-es` | `gartify-dev-es.md` | Full-stack: Next.js, TypeScript, Prisma, Auth.js, Zod |
| `gartify-ux-automotive-designer-es` | `gartify-ux-automotive-designer-es.md` | UI/UX diseño web para plataformas del sector automotriz |
| `gartify-marketing-seo-es` | `gartify-marketing-seo-es.md` | SEO técnico, SEM, analítica y marketing digital para España |
| `gartify-qa-es` | `gartify-qa-es.md` | QA: TypeScript, seguridad, accesibilidad WCAG, SEO, responsive y flujo de reserva |

> **Convención de nombres:** prefijo `gartify-` + sufijo `-es` para todos los agentes del proyecto.

---

## Key Conventions

- **TypeScript strict** — `tsconfig.json` has `"strict": true`
- **Path alias** — `@/*` maps to project root
- **Tailwind custom colors**: `gartify-orange` (#FF5722), `gartify-blue` (#1E40AF), `gartify-dark` (#0F172A), `gartify-gray` (#64748B)
- **shadcn/ui** components in `components/ui/`
- **Server components by default** — add `"use client"` only for hooks/browser APIs
- `lib/utils.ts` exports `SERVICE_LABELS`, `BOOKING_STATUS_LABELS`, `BOOKING_STATUS_COLORS`, `formatPrice` (Intl EUR), `formatDate`, `formatDateTime`
