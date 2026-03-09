import { notFound } from "next/navigation";
import Link from "next/link";
import { db } from "@/lib/db";
import { Button } from "@/components/ui/button";
import { Card, CardContent } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";
import { Separator } from "@/components/ui/separator";
import { MapPin, Phone, Star, ShieldCheck, Clock, ChevronLeft } from "lucide-react";
import { formatPrice, SERVICE_LABELS } from "@/lib/utils";

export default async function GarageDetailPage({ params }: { params: { id: string } }) {
  const garage = await db.garage.findUnique({
    where: { id: params.id, isActive: true },
    include: {
      services: { where: { isActive: true }, orderBy: { price: "asc" } },
      reviews: { include: { user: { select: { name: true } } }, orderBy: { createdAt: "desc" }, take: 10 },
    },
  });

  if (!garage) notFound();

  return (
    <div className="container max-w-4xl py-8 space-y-8">
      <Link href="/talleres" className="inline-flex items-center gap-1.5 text-sm text-muted-foreground hover:text-foreground transition-colors">
        <ChevronLeft className="h-4 w-4" />
        Volver a resultados
      </Link>

      {/* Header */}
      <div className="flex flex-col md:flex-row md:items-start md:justify-between gap-6">
        <div>
          <div className="flex items-center gap-2 mb-2">
            <h1 className="text-3xl font-bold text-foreground">{garage.name}</h1>
            {garage.isVerified && <ShieldCheck className="h-5 w-5 text-gartify-orange" />}
          </div>
          <div className="flex items-center gap-4 text-sm text-muted-foreground">
            <span className="flex items-center gap-1">
              <MapPin className="h-4 w-4" />
              {garage.address}, {garage.city} {garage.postalCode}
            </span>
            <span className="flex items-center gap-1">
              <Phone className="h-4 w-4" />
              {garage.phone}
            </span>
          </div>
          {garage.description && (
            <p className="mt-3 text-muted-foreground max-w-xl">{garage.description}</p>
          )}
        </div>
        <div className="flex items-center gap-3 shrink-0">
          <div className="text-center">
            <div className="flex items-center gap-1 text-2xl font-bold text-foreground">
              <Star className="h-6 w-6 fill-yellow-400 text-yellow-400" />
              {garage.rating.toFixed(1)}
            </div>
            <p className="text-xs text-muted-foreground">{garage.reviewCount} reseñas</p>
          </div>
        </div>
      </div>

      <Separator />

      {/* Services */}
      <section>
        <h2 className="text-xl font-semibold text-foreground mb-4">Servicios y precios</h2>
        <div className="grid sm:grid-cols-2 gap-3">
          {garage.services.map((service) => (
            <Card key={service.id} className="hover:border-gartify-orange/30 transition-colors">
              <CardContent className="p-4 flex items-start justify-between gap-4">
                <div className="flex-1">
                  <div className="flex items-center gap-2 mb-1">
                    <Badge variant="outline" className="text-xs">{SERVICE_LABELS[service.type]}</Badge>
                  </div>
                  <p className="font-medium text-foreground">{service.name}</p>
                  {service.description && (
                    <p className="text-sm text-muted-foreground mt-0.5">{service.description}</p>
                  )}
                  <div className="flex items-center gap-1 mt-2 text-xs text-muted-foreground">
                    <Clock className="h-3.5 w-3.5" />
                    {service.duration} min
                  </div>
                </div>
                <div className="text-right shrink-0">
                  <p className="text-xl font-bold text-gartify-orange">{formatPrice(service.price)}</p>
                  <Link href={`/talleres/${garage.id}/reservar?servicio=${service.id}`}>
                    <Button size="sm" className="mt-2">Reservar</Button>
                  </Link>
                </div>
              </CardContent>
            </Card>
          ))}
        </div>
      </section>

      {/* Reviews */}
      {garage.reviews.length > 0 && (
        <>
          <Separator />
          <section>
            <h2 className="text-xl font-semibold text-foreground mb-4">
              Reseñas ({garage.reviewCount})
            </h2>
            <div className="space-y-4">
              {garage.reviews.map((review) => (
                <Card key={review.id}>
                  <CardContent className="p-4">
                    <div className="flex items-start justify-between gap-3">
                      <div>
                        <p className="font-medium text-foreground text-sm">
                          {review.user.name ?? "Usuario"}
                        </p>
                        {review.comment && (
                          <p className="text-sm text-muted-foreground mt-1">{review.comment}</p>
                        )}
                      </div>
                      <div className="flex items-center gap-1 shrink-0">
                        {Array.from({ length: 5 }).map((_, i) => (
                          <Star
                            key={i}
                            className={`h-4 w-4 ${i < review.rating ? "fill-yellow-400 text-yellow-400" : "text-muted-foreground"}`}
                          />
                        ))}
                      </div>
                    </div>
                  </CardContent>
                </Card>
              ))}
            </div>
          </section>
        </>
      )}
    </div>
  );
}
