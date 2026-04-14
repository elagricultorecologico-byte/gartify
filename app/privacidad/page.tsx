import type { Metadata } from 'next';

export const metadata: Metadata = {
  title: 'Política de Privacidad',
  robots: { index: false, follow: false },
};

export default function PrivacidadPage() {
  return (
    <main className="container max-w-3xl py-12 px-4 sm:px-8 mx-auto">
      <h1 className="text-3xl font-bold text-gartify-dark mb-2">Política de Privacidad</h1>
      <p className="text-sm text-gray-500 mb-6">Última actualización: abril de 2026</p>

      <p className="text-sm text-gray-700 leading-relaxed mb-4">
        <strong>Responsable del tratamiento:</strong> GARTIFY, S.L. | NIF/CIF{' '}
        <span className="text-gray-400 italic">[PENDIENTE]</span> | Domicilio{' '}
        <span className="text-gray-400 italic">[PENDIENTE]</span> | Contacto{' '}
        <span className="text-gray-400 italic">[PENDIENTE]</span> | Email de privacidad:{' '}
        <span className="text-gray-400 italic">[PENDIENTE]</span>
      </p>

      <hr className="my-8 border-gray-200" />

      {/* Qué datos podemos tratar */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          Qué datos podemos tratar
        </h2>
        <ul className="list-disc pl-5 space-y-1 text-sm text-gray-700">
          <li>Nombre y apellidos.</li>
          <li>Dirección de correo electrónico.</li>
          <li>Número de teléfono.</li>
          <li>Nombre de empresa o taller.</li>
          <li>Datos de acceso a la plataforma (credenciales cifradas).</li>
          <li>Información contractual y de facturación.</li>
          <li>Datos operativos generados durante el uso de la plataforma.</li>
          <li>Datos de navegación y logs técnicos.</li>
          <li>Información facilitada mediante formularios de contacto o demo.</li>
        </ul>
      </section>

      {/* Cómo obtenemos tus datos */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          Cómo obtenemos tus datos
        </h2>
        <ul className="list-disc pl-5 space-y-1 text-sm text-gray-700">
          <li>Formularios de registro, contacto o solicitud de demo.</li>
          <li>Uso de la web o de la plataforma.</li>
          <li>Actuación en nombre de un taller como usuario autorizado.</li>
          <li>Integraciones con herramientas tecnológicas de terceros.</li>
          <li>Fuentes públicas accesibles cuando sea pertinente.</li>
        </ul>
      </section>

      {/* Para qué utilizamos tus datos */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          Para qué utilizamos tus datos
        </h2>
        <ul className="list-disc pl-5 space-y-1 text-sm text-gray-700">
          <li>Atender solicitudes de información o de demo.</li>
          <li>Gestionar el alta y mantenimiento de cuentas de usuario.</li>
          <li>Prestar los servicios contratados.</li>
          <li>Proporcionar soporte técnico y atención al cliente.</li>
          <li>Gestionar la facturación y el cobro.</li>
          <li>Enviar comunicaciones comerciales sobre nuestros productos y novedades, con la base legal correspondiente.</li>
          <li>Analizar el uso de la plataforma para mejorar su funcionamiento.</li>
          <li>Garantizar la seguridad del sistema.</li>
          <li>Cumplir con obligaciones legales aplicables.</li>
        </ul>
      </section>

      {/* Base legal del tratamiento */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          Base legal del tratamiento
        </h2>
        <ul className="list-disc pl-5 space-y-1 text-sm text-gray-700">
          <li>
            <strong>Ejecución de contrato:</strong> para prestar los servicios solicitados.
          </li>
          <li>
            <strong>Obligaciones legales:</strong> para cumplir con normativas fiscales, contables y otras.
          </li>
          <li>
            <strong>Interés legítimo de Gartify:</strong> para análisis de uso, seguridad y mejora del servicio.
          </li>
          <li>
            <strong>Consentimiento:</strong> para comunicaciones comerciales cuando sea necesario.
          </li>
        </ul>
      </section>

      {/* Con quién compartimos los datos */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          Con quién compartimos los datos
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed mb-3">
          Podemos compartir datos con proveedores de servicios necesarios para operar la plataforma,
          incluyendo proveedores de hosting, procesadores de pago, herramientas de analítica y
          soporte, y asesoría jurídica o contable. También con las autoridades competentes cuando
          así lo exija la ley.
        </p>
        <p className="text-sm text-gray-700 leading-relaxed font-medium">
          Gartify NO vende datos personales a terceros.
        </p>
      </section>

      {/* Transferencias internacionales */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          Transferencias internacionales
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Algunos de nuestros proveedores pueden estar ubicados fuera del Espacio Económico Europeo.
          En dichos casos, nos aseguramos de que existan garantías adecuadas de protección de datos
          conforme a la normativa aplicable.
        </p>
      </section>

      {/* Durante cuánto tiempo conservamos los datos */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          Durante cuánto tiempo conservamos los datos
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Conservamos los datos durante el tiempo necesario para cumplir con la finalidad para la
          que fueron recabados, más los plazos de retención exigidos por la legislación aplicable
          (fiscal, mercantil, etc.).
        </p>
      </section>

      {/* Tus derechos */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">Tus derechos</h2>
        <p className="text-sm text-gray-700 leading-relaxed mb-3">
          Puedes ejercer en cualquier momento los siguientes derechos:
        </p>
        <ul className="list-disc pl-5 space-y-1 text-sm text-gray-700">
          <li>
            <strong>Acceso:</strong> conocer qué datos tratamos sobre ti.
          </li>
          <li>
            <strong>Rectificación:</strong> corregir datos inexactos o incompletos.
          </li>
          <li>
            <strong>Supresión:</strong> solicitar la eliminación de tus datos cuando proceda.
          </li>
          <li>
            <strong>Oposición:</strong> oponerte al tratamiento de tus datos en determinados supuestos.
          </li>
          <li>
            <strong>Limitación:</strong> solicitar que restrinjamos el uso de tus datos.
          </li>
          <li>
            <strong>Portabilidad:</strong> recibir tus datos en un formato estructurado y de uso común.
          </li>
          <li>
            <strong>Retirada del consentimiento:</strong> en cualquier momento cuando el tratamiento se base en él.
          </li>
        </ul>
        <p className="text-sm text-gray-700 leading-relaxed mt-3">
          También tienes derecho a presentar una reclamación ante la{' '}
          <strong>Agencia Española de Protección de Datos (AEPD)</strong> en{' '}
          <a
            href="https://www.aepd.es"
            target="_blank"
            rel="noopener noreferrer"
            className="text-gartify-blue underline hover:opacity-80"
          >
            www.aepd.es
          </a>
          .
        </p>
      </section>

      {/* Cómo ejercer tus derechos */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          Cómo ejercer tus derechos
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Envía tu solicitud al correo electrónico{' '}
          <span className="text-gray-400 italic">[PENDIENTE]</span>, indicando en el asunto
          &quot;Protección de Datos&quot; y adjuntando documento que acredite tu identidad.
        </p>
      </section>

      {/* Menores de edad */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">Menores de edad</h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Los servicios de Gartify no están dirigidos a menores de edad. No recabamos
          conscientemente datos de menores. Si detectamos que hemos recabado datos de un menor,
          procederemos a eliminarlos.
        </p>
      </section>

      {/* Seguridad */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">Seguridad</h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Aplicamos medidas técnicas y organizativas adecuadas para proteger los datos personales
          contra accesos no autorizados, pérdida, destrucción o alteración.
        </p>
      </section>

      {/* Uso de la plataforma por talleres */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          Uso de la plataforma por talleres
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Los talleres que utilizan Gartify para gestionar datos de sus propios clientes actúan como
          responsables del tratamiento. Gartify actúa en dicho contexto como encargado del
          tratamiento y procesará los datos exclusivamente según las instrucciones del taller y
          conforme a la normativa vigente.
        </p>
      </section>

      <hr className="my-8 border-gray-200" />

      {/* Actualizaciones */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">Actualizaciones</h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Podremos actualizar esta Política de Privacidad para adaptarla a cambios normativos o
          funcionales. La versión vigente es siempre la publicada en esta página.
        </p>
      </section>
    </main>
  );
}
