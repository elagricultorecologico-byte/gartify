import { clsx, type ClassValue } from "clsx"
import { twMerge } from "tailwind-merge"

export function cn(...inputs: ClassValue[]) {
  return twMerge(clsx(inputs))
}

export { SERVICE_LABELS } from "@/lib/constants"

// ── Tipos de vehículo ─────────────────────────────────────────────────────────

export const VEHICLE_TYPES = [
  "COCHE",
  "MOTO",
  "FURGONETA",
  "AUTOCARAVANA",
  "CAMPER",
  "CAMION_RIGIDO",
  "CAMION_ARTICULADO",
  "MAQUINARIA",
  "BICICLETA",
  "PATINETE",
] as const

export type VehicleType = (typeof VEHICLE_TYPES)[number]

export const VEHICLE_LABELS: Record<string, string> = {
  COCHE:              "Coche",
  MOTO:               "Moto",
  FURGONETA:          "Furgoneta / VAN",
  AUTOCARAVANA:       "Autocaravana",
  CAMPER:             "Camper",
  CAMION_RIGIDO:      "Camión rígido",
  CAMION_ARTICULADO:  "Camión articulado",
  MAQUINARIA:         "Maquinaria agrícola",
  BICICLETA:          "Bicicleta / E-bike",
  PATINETE:           "Patinete eléctrico",
}

export const VEHICLE_ICONS: Record<string, string> = {
  COCHE:              "🚗",
  MOTO:               "🏍️",
  FURGONETA:          "🚐",
  AUTOCARAVANA:       "🚌",
  CAMPER:             "🏕️",
  CAMION_RIGIDO:      "🚚",
  CAMION_ARTICULADO:  "🚛",
  MAQUINARIA:         "🚜",
  BICICLETA:          "🚲",
  PATINETE:           "🛴",
}

export const BOOKING_STATUS_LABELS: Record<string, string> = {
  PENDING:   "Pendiente",
  PROPOSED:  "Propuesta de hora",
  CONFIRMED: "Confirmada",
  COMPLETED: "Completada",
  CANCELLED: "Cancelada",
}

export const BOOKING_STATUS_COLORS: Record<string, string> = {
  PENDING:   "bg-yellow-100 text-yellow-800 border border-yellow-200",
  PROPOSED:  "bg-purple-100 text-purple-800 border border-purple-200",
  CONFIRMED: "bg-blue-100   text-blue-800   border border-blue-200",
  COMPLETED: "bg-green-100  text-green-800  border border-green-200",
  CANCELLED: "bg-red-100    text-red-700    border border-red-200",
}

export function formatPrice(amount: number): string {
  return new Intl.NumberFormat("es-ES", { style: "currency", currency: "EUR" }).format(amount)
}

export function formatDate(date: string | Date): string {
  return new Intl.DateTimeFormat("es-ES", { dateStyle: "medium" }).format(new Date(date))
}

export function formatDateTime(date: string | Date): string {
  return new Intl.DateTimeFormat("es-ES", { dateStyle: "medium", timeStyle: "short" }).format(new Date(date))
}
