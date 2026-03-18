"use client";
import { useState } from "react";

function NewsletterForm() {
  const [email, setEmail] = useState("");
  const [submitted, setSubmitted] = useState(false);

  function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    if (!email) return;
    setSubmitted(true);
  }

  if (submitted) {
    return (
      <p className="text-sm text-gartify-green font-semibold">
        ¡Gracias! Te avisaremos de las novedades.
      </p>
    );
  }

  return (
    <form onSubmit={handleSubmit} className="flex flex-col sm:flex-row gap-2 w-full max-w-sm">
      <input
        type="email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
        placeholder="Correo electrónico"
        required
        className="flex-1 rounded-lg border border-white/20 bg-white/10 px-3 py-2 text-sm text-white placeholder:text-blue-300 focus:outline-none focus:border-white/50 focus:bg-white/15 transition-colors"
      />
      <button
        type="submit"
        className="shrink-0 w-full sm:w-auto rounded-lg bg-gartify-orange hover:bg-gartify-orange/90 px-4 py-2 text-sm font-bold text-white transition-colors"
      >
        Suscribirse
      </button>
    </form>
  );
}

export function Footer({ className }: { className?: string }) {
  return (
    <footer className={`bg-gartify-blue ${className ?? ""}`}>
      {/* Columns */}
      <div className="container py-12 grid grid-cols-1 sm:grid-cols-3 gap-10">
        {/* Col 1 */}
        <div>
          <h4 className="text-xs font-extrabold uppercase tracking-widest text-white mb-4 pb-2 border-b border-white/20">Gartify</h4>
          <ul className="space-y-2.5 text-sm text-blue-200">
            {[
              { label: "Cómo funciona",           href: "/como-funciona" },
              { label: "¿Por qué elegirnos?",     href: "/como-funciona" },
              { label: "Para talleres",            href: "/para-talleres" },
              { label: "Contacto",                 href: "/contacto" },
              { label: "Términos y condiciones",  href: "/terminos" },
              { label: "Política de privacidad",  href: "/privacidad" },
              { label: "Política de cookies",     href: "/cookies" },
              { label: "Acerca de",               href: "/acerca" },
            ].map(({ label, href }) => (
              <li key={label}><a href={href} className="hover:text-white transition-colors">{label}</a></li>
            ))}
          </ul>
        </div>

        {/* Col 2 */}
        <div>
          <h4 className="text-xs font-extrabold uppercase tracking-widest text-white mb-4 pb-2 border-b border-white/20">Conductores</h4>
          <ul className="space-y-2.5 text-sm text-blue-200">
            {[
              { label: "Buscar taller",            href: "/talleres" },
              { label: "Preguntas frecuentes",     href: "/faq" },
              { label: "Comprobador de ITV",       href: "/itv" },
              { label: "Vehículos eléctricos",     href: "/talleres?servicio=ELECTRICIDAD" },
              { label: "Inicio de sesión",         href: "/login" },
              { label: "Registrarse",              href: "/registro" },
            ].map(({ label, href }) => (
              <li key={label}><a href={href} className="hover:text-white transition-colors">{label}</a></li>
            ))}
          </ul>
        </div>

        {/* Col 3 */}
        <div>
          <h4 className="text-xs font-extrabold uppercase tracking-widest text-white mb-4 pb-2 border-b border-white/20">Talleres</h4>
          <ul className="space-y-2.5 text-sm text-blue-200">
            {[
              { label: "Únete al directorio",     href: "/registro?tipo=taller" },
              { label: "Portal del taller",       href: "/cuenta/taller" },
              { label: "Gestionar reservas",      href: "/cuenta/taller" },
              { label: "Editar perfil",           href: "/cuenta/taller/perfil" },
              { label: "Mis servicios",           href: "/cuenta/taller/servicios" },
            ].map(({ label, href }) => (
              <li key={label}><a href={href} className="hover:text-white transition-colors">{label}</a></li>
            ))}
          </ul>
        </div>
      </div>

      {/* Pagos + Newsletter */}
      <div className="border-t border-white/10">
        <div className="container py-8 flex flex-col md:flex-row gap-8 md:gap-16">

          {/* Métodos de pago */}
          <div className="flex-1">
            <h4 className="text-xs font-extrabold uppercase tracking-widest text-white mb-4">
              Métodos de pago aceptados
            </h4>
            <div className="flex flex-wrap gap-2">
              {/* Visa */}
              <span className="flex items-center justify-center rounded-md bg-white px-3 py-1.5 h-8">
                <span className="font-extrabold text-sm tracking-tight" style={{ color: "#1A1F71" }}>VISA</span>
              </span>
              {/* Mastercard */}
              <span className="flex items-center justify-center gap-0.5 rounded-md bg-white px-2 py-1.5 h-8">
                <span className="h-4 w-4 rounded-full bg-[#EB001B] inline-block" />
                <span className="h-4 w-4 rounded-full bg-[#F79E1B] inline-block -ml-2" />
              </span>
              {/* Maestro */}
              <span className="flex items-center justify-center gap-0.5 rounded-md bg-white px-2 py-1.5 h-8">
                <span className="h-4 w-4 rounded-full bg-[#0099DF] inline-block" />
                <span className="h-4 w-4 rounded-full bg-[#CC0000] inline-block -ml-2 opacity-90" />
              </span>
              {/* PayPal */}
              <span className="flex items-center justify-center rounded-md bg-white px-3 py-1.5 h-8">
                <span className="font-extrabold text-xs" style={{ color: "#003087" }}>Pay</span>
                <span className="font-extrabold text-xs" style={{ color: "#009CDE" }}>Pal</span>
              </span>
              {/* Apple Pay */}
              <span className="flex items-center justify-center rounded-md bg-black px-3 py-1.5 h-8">
                <span className="text-white font-semibold text-xs tracking-tight"> Pay</span>
              </span>
              {/* Google Pay */}
              <span className="flex items-center justify-center rounded-md bg-white px-3 py-1.5 h-8">
                <span className="font-bold text-xs">
                  <span style={{ color: "#4285F4" }}>G</span>
                  <span style={{ color: "#EA4335" }}>o</span>
                  <span style={{ color: "#FBBC05" }}>o</span>
                  <span style={{ color: "#4285F4" }}>g</span>
                  <span style={{ color: "#34A853" }}>le</span>
                </span>
                <span className="ml-1 font-bold text-xs text-gray-800">Pay</span>
              </span>
              {/* Bizum */}
              <span className="flex items-center justify-center rounded-md bg-white px-3 py-1.5 h-8">
                <span className="font-extrabold text-xs" style={{ color: "#4B1FCC" }}>bizum</span>
              </span>
              {/* Transferencia */}
              <span className="flex items-center justify-center rounded-md bg-white/10 border border-white/20 px-3 py-1.5 h-8">
                <span className="text-blue-200 text-xs font-medium">Transferencia</span>
              </span>
            </div>
          </div>

          {/* Newsletter */}
          <div className="flex-1 max-w-sm">
            <h4 className="text-xs font-extrabold uppercase tracking-widest text-white mb-1">
              Newsletter
            </h4>
            <p className="text-xs text-blue-300 mb-3 leading-relaxed">
              Recibe consejos de mantenimiento, ofertas de talleres y novedades de Gartify.
            </p>
            <NewsletterForm />
            <p className="mt-2 text-xs text-blue-400 leading-relaxed">
              Suscribiéndome acepto la{" "}
              <a href="/privacidad" className="underline hover:text-blue-200 transition-colors">
                Política de Privacidad
              </a>{" "}
              y el envío de información comercial.
            </p>
          </div>

        </div>
      </div>

      {/* Bottom bar */}
      <div className="border-t border-white/10 py-4">
        <div className="container flex flex-col sm:flex-row items-center justify-between gap-2 text-xs text-blue-300">
          <span>© {new Date().getFullYear()} Gartify · Encuentra tu taller de confianza en España</span>
          <span className="flex items-center gap-1">
            <span className="h-1.5 w-1.5 rounded-full bg-gartify-green inline-block" />
            Todos los derechos reservados
          </span>
        </div>
      </div>
    </footer>
  );
}
