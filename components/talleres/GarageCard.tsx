import Link from "next/link";
import { MapPin, Star, Clock, ShieldCheck } from "lucide-react";
import { Card, CardContent } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";
import { Button } from "@/components/ui/button";
import { formatPrice, SERVICE_LABELS } from "@/lib/utils";

type Service = { id: string; type: string; name: string; price: number; duration: number };

type GarageCardProps = {
  id: string;
  name: string;
  description: string | null;
  city: string;
  address: string;
  rating: number;
  reviewCount: number;
  isVerified: boolean;
  services: Service[];
};

export function GarageCard({ id, name, description, city, address, rating, reviewCount, isVerified, services }: GarageCardProps) {
  const cheapest = services.length > 0 ? Math.min(...services.map((s) => s.price)) : null;

  return (
    <Card className="hover:border-gartify-orange/30 transition-colors">
      <CardContent className="p-5">
        <div className="flex items-start justify-between gap-4">
          <div className="flex-1 min-w-0">
            <div className="flex items-center gap-2 mb-1">
              <h3 className="font-semibold text-foreground truncate">{name}</h3>
              {isVerified && (
                <ShieldCheck className="h-4 w-4 text-gartify-orange shrink-0" title="Taller verificado" />
              )}
            </div>
            <div className="flex items-center gap-1 text-sm text-muted-foreground mb-2">
              <MapPin className="h-3.5 w-3.5 shrink-0" />
              <span className="truncate">{address}, {city}</span>
            </div>
            {description && (
              <p className="text-sm text-muted-foreground line-clamp-2 mb-3">{description}</p>
            )}
            {/* Services chips */}
            <div className="flex flex-wrap gap-1.5">
              {services.slice(0, 4).map((s) => (
                <Badge key={s.id} variant="outline" className="text-xs">
                  {SERVICE_LABELS[s.type] ?? s.name}
                </Badge>
              ))}
              {services.length > 4 && (
                <Badge variant="outline" className="text-xs text-muted-foreground">
                  +{services.length - 4} más
                </Badge>
              )}
            </div>
          </div>

          {/* Right: rating + price + CTA */}
          <div className="flex flex-col items-end gap-3 shrink-0">
            <div className="flex items-center gap-1">
              <Star className="h-4 w-4 fill-yellow-400 text-yellow-400" />
              <span className="font-semibold text-foreground text-sm">{rating.toFixed(1)}</span>
              <span className="text-xs text-muted-foreground">({reviewCount})</span>
            </div>
            {cheapest !== null && (
              <div className="text-right">
                <p className="text-xs text-muted-foreground">desde</p>
                <p className="text-lg font-bold text-gartify-orange">{formatPrice(cheapest)}</p>
              </div>
            )}
            <Link href={`/talleres/${id}`}>
              <Button size="sm">Ver taller</Button>
            </Link>
          </div>
        </div>
      </CardContent>
    </Card>
  );
}
