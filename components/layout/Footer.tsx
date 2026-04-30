const REDES = [
  {
    label: "LinkedIn",
    href: "https://www.linkedin.com/company/gartify",
    svg: <path fill="currentColor" d="M20.447 20.452h-3.554v-5.569c0-1.328-.027-3.037-1.852-3.037-1.853 0-2.136 1.445-2.136 2.939v5.667H9.351V9h3.414v1.561h.046c.477-.9 1.637-1.85 3.37-1.85 3.601 0 4.267 2.37 4.267 5.455v6.286zM5.337 7.433c-1.144 0-2.063-.926-2.063-2.065 0-1.138.92-2.063 2.063-2.063 1.14 0 2.064.925 2.064 2.063 0 1.139-.925 2.065-2.064 2.065zm1.782 13.019H3.555V9h3.564v11.452zM22.225 0H1.771C.792 0 0 .774 0 1.729v20.542C0 23.227.792 24 1.771 24h20.451C23.2 24 24 23.227 24 22.271V1.729C24 .774 23.2 0 22.222 0h.003z" />,
  },
  {
    label: "Facebook",
    href: "https://www.facebook.com/gartify",
    svg: <path fill="currentColor" d="M24 12.073c0-6.627-5.373-12-12-12s-12 5.373-12 12c0 5.99 4.388 10.954 10.125 11.854v-8.385H7.078v-3.47h3.047V9.43c0-3.007 1.792-4.669 4.533-4.669 1.312 0 2.686.235 2.686.235v2.953H15.83c-1.491 0-1.956.925-1.956 1.874v2.25h3.328l-.532 3.47h-2.796v8.385C19.612 23.027 24 18.062 24 12.073z" />,
  },
  {
    label: "X / Twitter",
    href: "https://twitter.com/gartify",
    svg: <path fill="currentColor" d="M18.244 2.25h3.308l-7.227 8.26 8.502 11.24H16.17l-4.714-6.231-5.401 6.231H2.741l7.73-8.835L1.254 2.25H8.08l4.713 6.231zm-1.161 17.52h1.833L7.084 4.126H5.117z" />,
  },
  {
    label: "YouTube",
    href: "https://www.youtube.com/@gartify",
    svg: <path fill="currentColor" d="M23.498 6.186a3.016 3.016 0 0 0-2.122-2.136C19.505 3.545 12 3.545 12 3.545s-7.505 0-9.377.505A3.017 3.017 0 0 0 .502 6.186C0 8.07 0 12 0 12s0 3.93.502 5.814a3.016 3.016 0 0 0 2.122 2.136c1.871.505 9.376.505 9.376.505s7.505 0 9.377-.505a3.015 3.015 0 0 0 2.122-2.136C24 15.93 24 12 24 12s0-3.93-.502-5.814zM9.545 15.568V8.432L15.818 12l-6.273 3.568z" />,
  },
  {
    label: "Instagram",
    href: "https://www.instagram.com/gartify",
    svg: <path fill="currentColor" d="M12 2.163c3.204 0 3.584.012 4.85.07 3.252.148 4.771 1.691 4.919 4.919.058 1.265.069 1.645.069 4.849 0 3.205-.012 3.584-.069 4.849-.149 3.225-1.664 4.771-4.919 4.919-1.266.058-1.644.07-4.85.07-3.204 0-3.584-.012-4.849-.07-3.26-.149-4.771-1.699-4.919-4.92-.058-1.265-.07-1.644-.07-4.849 0-3.204.013-3.583.07-4.849.149-3.227 1.664-4.771 4.919-4.919 1.266-.057 1.645-.069 4.849-.069zm0-2.163c-3.259 0-3.667.014-4.947.072-4.358.2-6.78 2.618-6.98 6.98-.059 1.281-.073 1.689-.073 4.948 0 3.259.014 3.668.072 4.948.2 4.358 2.618 6.78 6.98 6.98 1.281.058 1.689.072 4.948.072 3.259 0 3.668-.014 4.948-.072 4.354-.2 6.782-2.618 6.979-6.98.059-1.28.073-1.689.073-4.948 0-3.259-.014-3.667-.072-4.947-.196-4.354-2.617-6.78-6.979-6.98-1.281-.059-1.69-.073-4.949-.073zm0 5.838c-3.403 0-6.162 2.759-6.162 6.162s2.759 6.163 6.162 6.163 6.162-2.759 6.162-6.163c0-3.403-2.759-6.162-6.162-6.162zm0 10.162c-2.209 0-4-1.79-4-4 0-2.209 1.791-4 4-4s4 1.791 4 4c0 2.21-1.791 4-4 4zm6.406-11.845c-.796 0-1.441.645-1.441 1.44s.645 1.44 1.441 1.44c.795 0 1.439-.645 1.439-1.44s-.644-1.44-1.439-1.44z" />,
  },
];

const SEO_CATEGORIAS = [
  { label: "Talleres de mecánica general",       href: "/talleres?categoria=MECANICA_GENERAL" },
  { label: "Talleres eléctricos y de baterías",  href: "/talleres?categoria=ELECTRICIDAD_AUTO" },
  { label: "Talleres de chapa y pintura",        href: "/talleres?categoria=CHAPA_PINTURA" },
  { label: "Talleres de neumáticos y ruedas",    href: "/talleres?categoria=NEUMATICOS_RUEDAS" },
  { label: "Talleres de climatización y A/C",    href: "/talleres?categoria=CLIMATIZACION_AC" },
  { label: "Diagnóstico electrónico OBD2",       href: "/talleres?categoria=DIAGNOSTICO_ELECTRONICO" },
  { label: "Estaciones de ITV homologadas",      href: "/talleres?categoria=ITV_STATION" },
  { label: "Talleres de motos y motocicletas",   href: "/talleres?categoria=MOTOS" },
];

const SEO_PROVINCIAS = [
  { label: "Talleres en Madrid",      href: "/talleres?ciudad=Madrid" },
  { label: "Talleres en Barcelona",   href: "/talleres?ciudad=Barcelona" },
  { label: "Talleres en Valencia",    href: "/talleres?ciudad=Valencia" },
  { label: "Talleres en Sevilla",     href: "/talleres?ciudad=Sevilla" },
  { label: "Talleres en Zaragoza",    href: "/talleres?ciudad=Zaragoza" },
  { label: "Talleres en Málaga",      href: "/talleres?ciudad=Málaga" },
  { label: "Talleres en Bilbao",      href: "/talleres?ciudad=Bilbao" },
  { label: "Talleres en Alicante",    href: "/talleres?ciudad=Alicante" },
];

const SEO_SERVICIOS = [
  { label: "Revisión completa del vehículo",       href: "/talleres?servicio=REVISION" },
  { label: "Cambio de aceite y filtros",           href: "/talleres?servicio=CAMBIO_ACEITE" },
  { label: "Reparación de frenos",                 href: "/talleres?servicio=FRENOS" },
  { label: "Cambio de neumáticos",                 href: "/talleres?servicio=NEUMATICOS" },
  { label: "Pre-ITV y acompañamiento ITV",         href: "/talleres?servicio=PRE_ITV" },
  { label: "Carga de aire acondicionado",          href: "/talleres?servicio=CLIMATIZACION" },
  { label: "Diagnóstico de averías",               href: "/talleres?servicio=DIAGNOSTICO" },
  { label: "Reparación eléctrica del coche",       href: "/talleres?servicio=ELECTRICIDAD" },
];

const SEO_CIUDADES = [
  { label: "Talleres en Murcia",         href: "/talleres?ciudad=Murcia" },
  { label: "Talleres en Valladolid",     href: "/talleres?ciudad=Valladolid" },
  { label: "Talleres en Palma",          href: "/talleres?ciudad=Palma" },
  { label: "Talleres en Las Palmas",     href: "/talleres?ciudad=Las+Palmas" },
  { label: "Talleres en Córdoba",        href: "/talleres?ciudad=Córdoba" },
  { label: "Talleres en Gijón",          href: "/talleres?ciudad=Gijón" },
  { label: "Talleres en Vitoria",        href: "/talleres?ciudad=Vitoria" },
  { label: "Talleres en Granada",        href: "/talleres?ciudad=Granada" },
];

export function Footer({ className }: { className?: string }) {
  return (
    <footer className={`bg-gartify-blue ${className ?? ""}`}>

      {/* SEO link grid — desactivado hasta implementar URLs limpias */}
      {false && <div className="border-b border-white/10">
        <div className="container py-10 grid grid-cols-2 sm:grid-cols-4 gap-8">
          <div>
            <h3 className="text-xs font-extrabold uppercase tracking-widest text-white mb-3">Tipos de taller</h3>
            <ul className="space-y-1.5">
              {SEO_CATEGORIAS.map(({ label, href }) => (
                <li key={href}><a href={href} className="text-xs text-blue-300 hover:text-white transition-colors leading-snug block">{label}</a></li>
              ))}
            </ul>
          </div>
          <div>
            <h3 className="text-xs font-extrabold uppercase tracking-widest text-white mb-3">Por provincia</h3>
            <ul className="space-y-1.5">
              {SEO_PROVINCIAS.map(({ label, href }) => (
                <li key={href}><a href={href} className="text-xs text-blue-300 hover:text-white transition-colors leading-snug block">{label}</a></li>
              ))}
            </ul>
          </div>
          <div>
            <h3 className="text-xs font-extrabold uppercase tracking-widest text-white mb-3">Servicios</h3>
            <ul className="space-y-1.5">
              {SEO_SERVICIOS.map(({ label, href }) => (
                <li key={href}><a href={href} className="text-xs text-blue-300 hover:text-white transition-colors leading-snug block">{label}</a></li>
              ))}
            </ul>
          </div>
          <div>
            <h3 className="text-xs font-extrabold uppercase tracking-widest text-white mb-3">Más ciudades</h3>
            <ul className="space-y-1.5">
              {SEO_CIUDADES.map(({ label, href }) => (
                <li key={href}><a href={href} className="text-xs text-blue-300 hover:text-white transition-colors leading-snug block">{label}</a></li>
              ))}
            </ul>
          </div>
        </div>
      </div>}

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


      {/* Bottom bar */}
      <div className="border-t border-white/10 py-4">
        <div className="container flex flex-col sm:flex-row items-center justify-between gap-3 text-xs text-blue-300">
          <span>© {new Date().getFullYear()} Gartify · Encuentra tu taller de confianza en España</span>
          <div className="flex items-center gap-2">
            {REDES.map(({ svg, href, label }) => (
              <a
                key={label}
                href={href}
                target="_blank"
                rel="noopener noreferrer"
                aria-label={label}
                className="flex items-center justify-center h-10 w-10 border border-white/20 text-blue-300 hover:text-white hover:border-gartify-orange hover:bg-gartify-orange/10 transition-all duration-200"
              >
                <svg viewBox="0 0 24 24" className="h-5 w-5" aria-hidden="true">{svg}</svg>
              </a>
            ))}
          </div>
        </div>
      </div>
    </footer>
  );
}
