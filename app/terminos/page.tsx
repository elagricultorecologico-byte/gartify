import type { Metadata } from 'next';

export const metadata: Metadata = {
  title: 'Términos y Condiciones de Uso',
  robots: { index: false, follow: false },
};

export default function TerminosPage() {
  return (
    <main className="container max-w-3xl py-12 px-4 sm:px-8 mx-auto">
      <h1 className="text-3xl font-bold text-gartify-dark mb-2">
        Términos y Condiciones de Uso de Gartify
      </h1>
      <p className="text-sm text-gray-500 mb-10">Última actualización: abril de 2026</p>

      <hr className="my-8 border-gray-200" />

      {/* 1. Objeto y alcance */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">1. Objeto y alcance</h2>
        <p className="text-sm text-gray-700 leading-relaxed mb-3">
          Titular: GARTIFY, S.L. | NIF/CIF:{' '}
          <span className="text-gray-400 italic">[PENDIENTE]</span> | Domicilio social:{' '}
          <span className="text-gray-400 italic">[PENDIENTE]</span> | Correo electrónico de
          contacto: <span className="text-gray-400 italic">[PENDIENTE]</span> | Correo electrónico
          de privacidad: <span className="text-gray-400 italic">[PENDIENTE]</span>
        </p>
        <p className="text-sm text-gray-700 leading-relaxed mb-3">
          Gartify ofrece soluciones tecnológicas orientadas al sector de los talleres mecánicos,
          incluyendo herramientas de captación de clientes, gestión de servicios, recambios,
          presupuestos, facturación, reseñas, comunicación con clientes y acciones de marketing.
        </p>
        <p className="text-sm text-gray-700 leading-relaxed">
          Aplicable a: visitantes, usuarios que soliciten demo, talleres/empresas con acceso a la
          plataforma, usuarios finales que interactúen con funcionalidades de Gartify.
        </p>
      </section>

      {/* 2. Naturaleza del servicio */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          2. Naturaleza del servicio
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Gartify es una plataforma tecnológica. No presta directamente servicios de reparación,
          mantenimiento, diagnosis ni asistencia mecánica. No fabrica ni suministra recambios. No
          asume condición de taller ni intermediario asegurador. Facilita el entorno digital entre
          usuarios y talleres.
        </p>
      </section>

      {/* 3. Condición de usuario y capacidad */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          3. Condición de usuario y capacidad
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Personas físicas mayores de edad o jurídicas debidamente representadas. El usuario se
          compromete a facilitar información veraz.
        </p>
      </section>

      {/* 4. Registro y cuentas de acceso */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          4. Registro y cuentas de acceso
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          El usuario es responsable de custodiar sus credenciales, no compartirlas, y comunicar
          cualquier uso no autorizado de su cuenta a Gartify de forma inmediata.
        </p>
      </section>

      {/* 5. Contratación de servicios */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          5. Contratación de servicios
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          La contratación se formaliza mediante propuesta comercial, formulario online, activación
          de plan o contrato específico suscrito entre las partes.
        </p>
      </section>

      {/* 6. Planes, precios y facturación */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          6. Planes, precios y facturación
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Los importes se expresan sin impuestos. La facturación puede ser mensual, trimestral o
          anual según el plan contratado. El impago puede conllevar la suspensión del servicio.
        </p>
      </section>

      {/* 7. Pruebas, demos y versiones beta */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          7. Pruebas, demos y versiones beta
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Se ofrecen &quot;tal cual&quot;, con carácter temporal y revocable, sin garantía de
          continuidad ni disponibilidad.
        </p>
      </section>

      {/* 8. Uso permitido de la plataforma */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          8. Uso permitido de la plataforma
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed mb-3">Queda expresamente prohibido:</p>
        <ul className="list-disc pl-5 space-y-1 text-sm text-gray-700">
          <li>Uso ilícito o contrario a la legislación vigente.</li>
          <li>Acceso no autorizado a sistemas o cuentas de terceros.</li>
          <li>Distribución de malware o código malicioso.</li>
          <li>Ingeniería inversa sobre la plataforma.</li>
          <li>Reventa no autorizada del servicio.</li>
          <li>Envío de comunicaciones no solicitadas (spam).</li>
          <li>Falsear reseñas u opiniones.</li>
          <li>Tratar datos personales de terceros sin base jurídica habilitante.</li>
        </ul>
      </section>

      {/* 9. Contenidos y datos introducidos por el usuario */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          9. Contenidos y datos introducidos por el usuario
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          El usuario conserva la titularidad de los contenidos que introduce en la plataforma.
          Otorga a Gartify una licencia limitada, no exclusiva y revocable para alojar y procesar
          dichos datos con la finalidad exclusiva de prestar el servicio contratado.
        </p>
      </section>

      {/* 10. Datos personales y rol de las partes */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          10. Datos personales y rol de las partes
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          El tratamiento de datos personales se rige por nuestra{' '}
          <a href="/privacidad" className="text-gartify-blue underline hover:opacity-80">
            Política de Privacidad
          </a>
          . Los talleres actúan como responsables del tratamiento de datos de sus propios clientes,
          siendo Gartify encargado del tratamiento en dicho contexto.
        </p>
      </section>

      {/* 11. Disponibilidad, continuidad y soporte */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          11. Disponibilidad, continuidad y soporte
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Gartify realizará esfuerzos razonables para mantener la plataforma disponible, sin
          garantizar disponibilidad ininterrumpida. Pueden producirse mantenimientos programados,
          incidencias de terceros u otras circunstancias que afecten temporalmente al servicio.
        </p>
      </section>

      {/* 12. Evolución del producto y cambios funcionales */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          12. Evolución del producto y cambios funcionales
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Gartify puede actualizar, modificar o retirar funcionalidades de la plataforma. Comunicará
          los cambios materiales con una antelación razonable a través de los medios habituales.
        </p>
      </section>

      {/* 13. Integraciones y servicios de terceros */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          13. Integraciones y servicios de terceros
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Gartify no garantiza la continuidad, calidad ni disponibilidad de los servicios de
          terceros integrados en la plataforma. Su uso queda sujeto a los términos propios de cada
          proveedor.
        </p>
      </section>

      {/* 14. Propiedad intelectual e industrial */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          14. Propiedad intelectual e industrial
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Todos los derechos de propiedad intelectual e industrial sobre la plataforma, su diseño,
          código, marcas y logotipos pertenecen a Gartify o a sus licenciantes. Queda prohibida su
          reproducción o explotación sin autorización expresa.
        </p>
      </section>

      {/* 15. Confidencialidad */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">15. Confidencialidad</h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Ambas partes se comprometen a tratar como confidencial la información técnica y comercial
          intercambiada en el marco de la relación contractual.
        </p>
      </section>

      {/* 16. Responsabilidad de Gartify */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          16. Responsabilidad de Gartify
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed mb-3">
          Gartify responde por los daños directos causados por dolo o negligencia grave imputable a
          Gartify. No responde por daños indirectos, lucro cesante, decisiones adoptadas por el
          cliente a partir del uso de la plataforma, ni por fallos de servicios de terceros. La
          responsabilidad máxima de Gartify queda limitada a los importes abonados por el cliente
          en los últimos doce meses.
        </p>
      </section>

      {/* 17. Responsabilidad del cliente o usuario profesional */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          17. Responsabilidad del cliente o usuario profesional
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          El cliente responde de su actividad en la plataforma, de la veracidad de la información
          publicada y del cumplimiento de sus obligaciones fiscales y legales.
        </p>
      </section>

      {/* 18. Suspensión y terminación */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          18. Suspensión y terminación
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Gartify podrá suspender o terminar el acceso en caso de impago, incumplimiento grave de
          estos términos, uso ilícito de la plataforma o riesgo para la seguridad del sistema.
        </p>
      </section>

      {/* 19. Efectos de la terminación */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          19. Efectos de la terminación
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed mb-3">
          Tras la terminación cesa el derecho de uso de la plataforma. Continúan vigentes las
          obligaciones de pago pendientes. Sobreviven a la terminación las cláusulas de
          confidencialidad, propiedad intelectual y limitación de responsabilidad.
        </p>
      </section>

      {/* 20. Comunicaciones */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">20. Comunicaciones</h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Las comunicaciones entre las partes se realizarán por correo electrónico o mediante avisos
          publicados en la plataforma.
        </p>
      </section>

      {/* 21. Prueba electrónica */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">21. Prueba electrónica</h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Los registros y logs generados por los sistemas de Gartify podrán ser utilizados como
          medio de prueba válido ante cualquier conflicto derivado del uso de la plataforma.
        </p>
      </section>

      {/* 22. Nulidad parcial y no renuncia */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          22. Nulidad parcial y no renuncia
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          La nulidad o ineficacia de alguna cláusula no afectará al resto de las estipulaciones. La
          falta de ejercicio de algún derecho por parte de Gartify no implica renuncia al mismo.
        </p>
      </section>

      {/* 23. Modificación de los Términos */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          23. Modificación de los Términos
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Gartify puede modificar estos Términos. La versión vigente es siempre la publicada en
          este sitio web. El uso continuado de la plataforma tras la publicación de cambios implica
          la aceptación de los nuevos Términos.
        </p>
      </section>

      {/* 24. Legislación aplicable y jurisdicción */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          24. Legislación aplicable y jurisdicción
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Estos Términos se rigen por la legislación española. Las partes se someten a los Juzgados
          y Tribunales del domicilio social de Gartify para la resolución de cualquier controversia
          derivada de su aplicación.
        </p>
      </section>

      <hr className="my-8 border-gray-200" />

      {/* 25. Fecha de última actualización */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">
          25. Fecha de última actualización
        </h2>
        <p className="text-sm text-gray-700 leading-relaxed">Última actualización: abril de 2026.</p>
      </section>
    </main>
  );
}
