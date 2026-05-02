/**
 * Layout mínimo para las landing pages públicas de talleres (/t/[slug]).
 * No incluye navbar ni footer de Gartify — estas páginas están diseñadas
 * para compartirse externamente como página de aterrizaje independiente.
 */
export default function LayoutLandingTaller({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <div className="min-h-screen bg-white">
      {children}
    </div>
  );
}
