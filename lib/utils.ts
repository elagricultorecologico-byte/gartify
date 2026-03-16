import { clsx, type ClassValue } from "clsx"
import { twMerge } from "tailwind-merge"

export function cn(...inputs: ClassValue[]) {
  return twMerge(clsx(inputs))
}

export { SERVICE_LABELS } from "@/lib/constants"

export const BOOKING_STATUS_LABELS: Record<string, string> = {
  PENDING:   "Pendiente",
  CONFIRMED: "Confirmada",
  COMPLETED: "Completada",
  CANCELLED: "Cancelada",
}

export const BOOKING_STATUS_COLORS: Record<string, string> = {
  PENDING:   "bg-yellow-500/10 text-yellow-500",
  CONFIRMED: "bg-blue-500/10 text-blue-400",
  COMPLETED: "bg-green-500/10 text-green-500",
  CANCELLED: "bg-red-500/10 text-red-400",
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
