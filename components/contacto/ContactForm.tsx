"use client";
import { useState } from "react";
import Link from "next/link";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Textarea } from "@/components/ui/textarea";
import {
  CheckCircle, AlertCircle, Loader2,
  ChevronRight, MessageSquare, Building2, HelpCircle, Wrench,
} from "lucide-react";

const TOPICS = [
  { value: "soporte",  label: "Soporte técnico",          icon: HelpCircle },
  { value: "taller",   label: "Registrar mi taller",      icon: Building2 },
  { value: "reserva",  label: "Problema con una reserva", icon: MessageSquare },
  { value: "otro",     label: "Otro motivo",              icon: Wrench },
];

export function ContactForm() {
  const [topic, setTopic] = useState("");
  const [submitted, setSubmitted] = useState(false);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setError("");
    setLoading(true);
    // TODO: reemplazar por llamada real a /api/contact cuando exista el endpoint
    await new Promise((r) => setTimeout(r, 1000));
    setLoading(false);
    setSubmitted(true);
  }

  if (submitted) {
    return (
      <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
        <div className="bg-gradient-to-r from-gartify-hero to-gartify-mid px-6 py-4">
          <p className="text-xs font-bold uppercase tracking-widest text-white/80">
            Envíanos un mensaje
          </p>
        </div>
        <div className="p-10 text-center">
          <div className="mx-auto mb-4 flex h-16 w-16 items-center justify-center rounded-full bg-green-50 border border-green-200">
            <CheckCircle className="h-8 w-8 text-gartify-green" aria-hidden="true" />
          </div>
          <h2 className="text-xl font-bold text-gartify-blue mb-2">¡Mensaje enviado!</h2>
          <p className="text-sm text-muted-foreground max-w-sm mx-auto">
            Hemos recibido tu consulta. Te responderemos en menos de 24 horas en
            el email que nos has indicado.
          </p>
        </div>
      </div>
    );
  }

  return (
    <div className="bg-white rounded-xl border border-gray-200 shadow-sm overflow-hidden">
      <div className="bg-gradient-to-r from-gartify-hero to-gartify-mid px-6 py-4">
        <p className="text-xs font-bold uppercase tracking-widest text-white/80">
          Envíanos un mensaje
        </p>
      </div>

      <form onSubmit={handleSubmit} className="p-6 space-y-5" noValidate>
        {/* Motivo de contacto */}
        <fieldset>
          <legend className="text-xs font-semibold text-gartify-blue mb-2">
            Motivo de contacto
          </legend>
          <div className="grid grid-cols-2 gap-2">
            {TOPICS.map(({ value, label, icon: Icon }) => (
              <button
                key={value}
                type="button"
                aria-pressed={topic === value}
                onClick={() => setTopic(value)}
                className={`flex items-center gap-2.5 px-3 py-2.5 rounded-lg border text-sm font-medium transition-all text-left ${
                  topic === value
                    ? "border-gartify-blue bg-gartify-blue/5 text-gartify-blue"
                    : "border-gray-200 text-gartify-gray hover:border-gartify-blue/40"
                }`}
              >
                <Icon
                  className={`h-4 w-4 shrink-0 ${topic === value ? "text-gartify-mid" : "text-gray-400"}`}
                  aria-hidden="true"
                />
                {label}
              </button>
            ))}
          </div>
        </fieldset>

        {/* Nombre + email */}
        <div className="grid sm:grid-cols-2 gap-4">
          <div className="space-y-1.5">
            <Label htmlFor="name" className="text-xs font-semibold text-gartify-blue">
              Nombre
            </Label>
            <Input
              id="name"
              name="name"
              placeholder="Juan García"
              autoComplete="name"
              required
            />
          </div>
          <div className="space-y-1.5">
            <Label htmlFor="email" className="text-xs font-semibold text-gartify-blue">
              Email
            </Label>
            <Input
              id="email"
              name="email"
              type="email"
              placeholder="tu@email.es"
              autoComplete="email"
              required
            />
          </div>
        </div>

        {/* Teléfono (opcional) */}
        <div className="space-y-1.5">
          <Label htmlFor="phone" className="text-xs font-semibold text-gartify-blue">
            Teléfono{" "}
            <span className="font-normal text-gartify-gray">(opcional)</span>
          </Label>
          <Input
            id="phone"
            name="phone"
            placeholder="600 000 000"
            autoComplete="tel"
          />
        </div>

        {/* Asunto */}
        <div className="space-y-1.5">
          <Label htmlFor="subject" className="text-xs font-semibold text-gartify-blue">
            Asunto
          </Label>
          <Input
            id="subject"
            name="subject"
            placeholder="Resumen breve de tu consulta"
            required
          />
        </div>

        {/* Mensaje */}
        <div className="space-y-1.5">
          <Label htmlFor="message" className="text-xs font-semibold text-gartify-blue">
            Mensaje
          </Label>
          <Textarea
            id="message"
            name="message"
            placeholder="Cuéntanos con detalle en qué podemos ayudarte..."
            rows={5}
            required
          />
        </div>

        {error && (
          <div
            role="alert"
            className="flex items-center gap-2 rounded-lg bg-red-50 border border-red-100 px-3 py-2 text-sm text-red-600"
          >
            <AlertCircle className="h-4 w-4 shrink-0" aria-hidden="true" />
            {error}
          </div>
        )}

        <Button
          type="submit"
          className="w-full h-11 bg-gartify-green hover:bg-gartify-green/90 text-white font-semibold gap-2"
          disabled={loading}
        >
          {loading ? (
            <>
              <Loader2 className="h-4 w-4 animate-spin" aria-hidden="true" />
              Enviando...
            </>
          ) : (
            <>
              <ChevronRight className="h-4 w-4" aria-hidden="true" />
              Enviar mensaje
            </>
          )}
        </Button>

        <p className="text-xs text-center text-muted-foreground">
          Al enviar este formulario aceptas nuestra{" "}
          <Link href="/privacidad" className="text-gartify-orange hover:underline">
            política de privacidad
          </Link>
          .
        </p>
      </form>
    </div>
  );
}
