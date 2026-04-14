import type { Metadata } from 'next';

export const metadata: Metadata = {
  title: 'Política de Cookies',
  robots: { index: false, follow: false },
};

export default function CookiesPage() {
  return (
    <main className="container max-w-3xl py-12 px-4 sm:px-8 mx-auto">
      <h1 className="text-3xl font-bold text-gartify-dark mb-2">Política de Cookies</h1>
      <p className="text-sm text-gray-500 mb-10">Última actualización: abril de 2026</p>

      <hr className="my-8 border-gray-200" />

      {/* Qué son las cookies */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">Qué son las cookies</h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Las cookies son pequeños archivos de texto que un sitio web deposita en el dispositivo del
          usuario cuando este lo visita. Permiten recordar preferencias, mantener sesiones activas y
          analizar el uso del sitio para mejorarlo.
        </p>
      </section>

      {/* Tipos de cookies que podemos usar */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          Tipos de cookies que podemos usar
        </h2>

        <div className="space-y-5">
          <div>
            <h3 className="text-sm font-semibold text-gartify-dark mb-1">Cookies necesarias</h3>
            <p className="text-sm text-gray-700 leading-relaxed">
              Son imprescindibles para el funcionamiento básico del sitio, como mantener la sesión
              iniciada o recordar las preferencias de cookies. No requieren consentimiento del
              usuario.
            </p>
          </div>

          <div>
            <h3 className="text-sm font-semibold text-gartify-dark mb-1">
              Cookies de preferencias
            </h3>
            <p className="text-sm text-gray-700 leading-relaxed">
              Permiten recordar configuraciones elegidas por el usuario, como el idioma o la región,
              para ofrecer una experiencia más personalizada.
            </p>
          </div>

          <div>
            <h3 className="text-sm font-semibold text-gartify-dark mb-1">
              Cookies de análisis o medición
            </h3>
            <p className="text-sm text-gray-700 leading-relaxed">
              Recopilan información sobre cómo los usuarios interactúan con el sitio (páginas
              visitadas, tiempo de permanencia, errores encontrados) con el objetivo de mejorar su
              funcionamiento.
            </p>
          </div>

          <div>
            <h3 className="text-sm font-semibold text-gartify-dark mb-1">Cookies de marketing</h3>
            <p className="text-sm text-gray-700 leading-relaxed">
              Permiten personalizar las comunicaciones y los anuncios en función de los intereses
              del usuario, detectados a partir de sus hábitos de navegación.
            </p>
          </div>
        </div>
      </section>

      {/* Base legal para su uso */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          Base legal para su uso
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Las cookies necesarias se instalan sin necesidad de consentimiento previo, al ser
          indispensables para la prestación del servicio. El resto de cookies requieren una base
          legal habilitante, que en la mayoría de los casos es el consentimiento expreso del usuario
          obtenido a través del panel de gestión de cookies.
        </p>
      </section>

      {/* Gestión de cookies */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">Gestión de cookies</h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Al acceder a Gartify por primera vez, se muestra un panel de preferencias de cookies donde
          puedes aceptar o rechazar las distintas categorías. Puedes modificar tus preferencias en
          cualquier momento accediendo de nuevo al panel de configuración de cookies.
        </p>
      </section>

      {/* Cookies de terceros */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">Cookies de terceros</h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Algunos servicios integrados en la plataforma (herramientas de analítica, soporte, mapas
          o publicidad) pueden instalar sus propias cookies. El uso de dichas cookies queda sujeto a
          las políticas de privacidad de cada proveedor externo.
        </p>
      </section>

      {/* Cómo desactivar o eliminar cookies */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          Cómo desactivar o eliminar cookies
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed mb-3">
          Además del panel de preferencias de Gartify, puedes gestionar las cookies directamente
          desde la configuración de tu navegador. A continuación encontrarás las instrucciones para
          los navegadores más habituales:
        </p>
        <ul className="list-disc pl-5 space-y-1 text-sm text-gray-700">
          <li>
            <a
              href="https://support.google.com/chrome/answer/95647"
              target="_blank"
              rel="noopener noreferrer"
              className="text-gartify-blue underline hover:opacity-80"
            >
              Google Chrome
            </a>
          </li>
          <li>
            <a
              href="https://support.mozilla.org/es/kb/habilitar-y-deshabilitar-cookies-sitios-web-rastrear-preferencias"
              target="_blank"
              rel="noopener noreferrer"
              className="text-gartify-blue underline hover:opacity-80"
            >
              Mozilla Firefox
            </a>
          </li>
          <li>
            <a
              href="https://support.apple.com/es-es/guide/safari/sfri11471/mac"
              target="_blank"
              rel="noopener noreferrer"
              className="text-gartify-blue underline hover:opacity-80"
            >
              Apple Safari
            </a>
          </li>
          <li>
            <a
              href="https://support.microsoft.com/es-es/microsoft-edge/eliminar-las-cookies-en-microsoft-edge-63947406-40ac-c3b8-57b9-2a946a29ae09"
              target="_blank"
              rel="noopener noreferrer"
              className="text-gartify-blue underline hover:opacity-80"
            >
              Microsoft Edge
            </a>
          </li>
        </ul>
        <p className="text-sm text-gray-700 leading-relaxed mt-3">
          Ten en cuenta que bloquear determinadas cookies puede afectar al correcto funcionamiento
          de algunas partes del sitio web.
        </p>
      </section>

      <hr className="my-8 border-gray-200" />

      {/* Actualizaciones */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">Actualizaciones</h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Podremos actualizar esta Política de Cookies para reflejar cambios en las tecnologías
          utilizadas o en la normativa aplicable. La versión vigente es siempre la publicada en esta
          página.
        </p>
      </section>
    </main>
  );
}
