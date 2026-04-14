import type { Metadata } from 'next';

export const metadata: Metadata = {
  title: 'Acerca de Gartify',
  robots: { index: false, follow: false },
};

export default function AcercaPage() {
  return (
    <main className="container max-w-3xl py-12 px-4 sm:px-8 mx-auto">
      <h1 className="text-3xl font-bold text-gartify-dark mb-10">Acerca de Gartify</h1>

      <hr className="my-8 border-gray-200" />

      {/* Quiénes somos */}
      <section className="mb-10">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">Quiénes somos</h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Gartify es una plataforma tecnológica española especializada en el sector de los talleres
          mecánicos. Nuestra misión es digitalizar y simplificar la relación entre conductores y
          talleres, haciendo que encontrar, comparar y reservar servicios de mantenimiento sea tan
          sencillo como reservar cualquier otro servicio online.
        </p>
      </section>

      {/* Nuestra misión */}
      <section className="mb-10">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">Nuestra misión</h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Creemos que el conductor merece transparencia: ver precios reales, leer reseñas auténticas
          y confirmar su cita en segundos. Y el taller merece herramientas digitales profesionales
          que le ayuden a captar clientes, gestionar su agenda y crecer sin complicaciones.
        </p>
      </section>

      {/* Qué ofrecemos */}
      <section className="mb-10">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">Qué ofrecemos</h2>

        <p className="text-sm font-semibold text-gartify-dark mb-2">Para conductores:</p>
        <ul className="list-disc pl-5 space-y-1 text-sm text-gray-700 mb-5">
          <li>Directorio de talleres verificados.</li>
          <li>Comparación de precios y servicios.</li>
          <li>Reserva online en segundos.</li>
          <li>Historial digital del vehículo (libro de revisiones).</li>
          <li>Reseñas reales de otros clientes.</li>
        </ul>

        <p className="text-sm font-semibold text-gartify-dark mb-2">Para talleres:</p>
        <ul className="list-disc pl-5 space-y-1 text-sm text-gray-700">
          <li>Perfil digital profesional.</li>
          <li>Gestión de reservas y agenda.</li>
          <li>Comunicación con clientes por WhatsApp.</li>
          <li>Estadísticas e informes de negocio.</li>
          <li>Herramientas de marketing digital.</li>
        </ul>
      </section>

      {/* Nuestros valores */}
      <section className="mb-10">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">Nuestros valores</h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Transparencia · Confianza · Simplicidad · Innovación al servicio del sector
        </p>
      </section>

      {/* Tecnología */}
      <section className="mb-10">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">Tecnología</h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Gartify es una empresa 100% tecnológica. Nuestro equipo combina experiencia en desarrollo
          de software, diseño de producto y conocimiento del sector automotriz para construir una
          plataforma que evoluciona continuamente.
        </p>
      </section>

      <hr className="my-8 border-gray-200" />

      {/* Contacto */}
      <section className="mb-8">
        <h2 className="text-xl font-semibold text-gartify-blue mb-3">Contacto</h2>
        <p className="text-sm text-gray-700 leading-relaxed">
          Para cualquier consulta puedes escribirnos a:{' '}
          <span className="text-gray-400 italic">[PENDIENTE]</span>
        </p>
      </section>
    </main>
  );
}
