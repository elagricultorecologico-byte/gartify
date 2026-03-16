"use client";
import { useState } from "react";
import { useRouter } from "next/navigation";
import { Star, CheckCircle, AlertCircle, Loader2 } from "lucide-react";
import { Button } from "@/components/ui/button";
import { Textarea } from "@/components/ui/textarea";
import { cn } from "@/lib/utils";

const LABELS = ["Muy malo", "Malo", "Regular", "Bueno", "Excelente"];

export function ReviewForm({
  bookingId,
  garageName,
}: {
  bookingId: string;
  garageName: string;
}) {
  const router = useRouter();
  const [hovered,  setHovered]  = useState(0);
  const [selected, setSelected] = useState(0);
  const [comment,  setComment]  = useState("");
  const [loading,  setLoading]  = useState(false);
  const [error,    setError]    = useState("");
  const [done,     setDone]     = useState(false);

  const active = hovered || selected;

  async function handleSubmit(e: React.FormEvent) {
    e.preventDefault();
    if (!selected) return;
    setLoading(true);
    setError("");

    const res = await fetch("/api/reviews", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ bookingId, rating: selected, comment: comment || undefined }),
    });

    setLoading(false);
    if (!res.ok) {
      const d = await res.json() as { error?: string };
      setError(d.error ?? "Error al enviar la valoración");
      return;
    }
    setDone(true);
    router.refresh();
  }

  if (done) {
    return (
      <div className="flex flex-col items-center gap-4 py-10 text-center">
        <div className="flex h-16 w-16 items-center justify-center rounded-full bg-green-50 border border-green-200">
          <CheckCircle className="h-8 w-8 text-gartify-green" />
        </div>
        <div>
          <p className="text-lg font-bold text-gartify-blue">¡Gracias por tu valoración!</p>
          <p className="text-sm text-muted-foreground mt-1">
            Tu opinión ayuda a otros conductores a elegir mejor.
          </p>
        </div>
        <a href="/cuenta">
          <Button variant="outline" className="border-gray-300 text-gartify-gray mt-2">
            Volver a mis reservas
          </Button>
        </a>
      </div>
    );
  }

  return (
    <form onSubmit={handleSubmit} className="space-y-6">
      {/* Stars */}
      <div className="flex flex-col items-center gap-3">
        <p className="text-sm font-semibold text-gartify-blue">
          ¿Cómo fue tu experiencia en {garageName}?
        </p>
        <div
          className="flex gap-2"
          onMouseLeave={() => setHovered(0)}
        >
          {[1, 2, 3, 4, 5].map((i) => (
            <button
              key={i}
              type="button"
              onClick={() => setSelected(i)}
              onMouseEnter={() => setHovered(i)}
              className="transition-transform hover:scale-110 focus:outline-none"
              aria-label={`${i} estrellas`}
            >
              <Star
                className={cn(
                  "h-10 w-10 transition-colors",
                  i <= active
                    ? "fill-yellow-400 text-yellow-400"
                    : "fill-gray-100 text-gray-300"
                )}
              />
            </button>
          ))}
        </div>
        <p className={cn(
          "text-sm font-medium transition-opacity h-5",
          active ? "text-gartify-blue opacity-100" : "opacity-0"
        )}>
          {active ? LABELS[active - 1] : ""}
        </p>
      </div>

      {/* Comment */}
      <div className="space-y-1.5">
        <label className="text-sm font-semibold text-gartify-blue">
          Comentario{" "}
          <span className="font-normal text-gartify-gray">(opcional)</span>
        </label>
        <Textarea
          placeholder="Cuéntanos cómo fue el servicio, el trato, el tiempo de espera..."
          rows={4}
          value={comment}
          onChange={(e) => setComment(e.target.value)}
          maxLength={1000}
          className="resize-none text-sm"
        />
        <p className="text-xs text-muted-foreground text-right">
          {comment.length}/1000
        </p>
      </div>

      {error && (
        <div role="alert" className="flex items-center gap-2 rounded-lg bg-red-50 border border-red-100 px-3 py-2 text-sm text-red-600">
          <AlertCircle className="h-4 w-4 shrink-0" />
          {error}
        </div>
      )}

      <div className="flex gap-3">
        <a href="/cuenta" className="flex-none">
          <Button type="button" variant="outline" className="border-gray-300 text-gartify-gray">
            Cancelar
          </Button>
        </a>
        <Button
          type="submit"
          disabled={!selected || loading}
          className="flex-1 bg-gartify-green hover:bg-gartify-green/90 text-white font-semibold h-11 gap-2"
        >
          {loading ? (
            <><Loader2 className="h-4 w-4 animate-spin" />Enviando...</>
          ) : (
            <><Star className="h-4 w-4" />Publicar valoración</>
          )}
        </Button>
      </div>
    </form>
  );
}
