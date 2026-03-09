import { redirect } from "next/navigation";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";
import { ChevronLeft, Clock } from "lucide-react";
import Link from "next/link";
import { formatPrice, SERVICE_LABELS } from "@/lib/utils";
import { ServiceForm } from "@/components/cuenta/ServiceForm";

export default async function ServiciosPage() {
  const session = await auth();
  if (!session?.user?.id) redirect("/login");
  const user = session.user as { id: string; role?: string };
  if (user.role !== "GARAGE_OWNER") redirect("/cuenta");

  const garage = await db.garage.findUnique({
    where: { ownerId: user.id },
    include: { services: { orderBy: { createdAt: "asc" } } },
  });

  if (!garage) redirect("/cuenta/taller/perfil");

  return (
    <div className="container max-w-3xl py-10">
      <Link href="/cuenta/taller" className="inline-flex items-center gap-1.5 text-sm text-muted-foreground hover:text-foreground mb-6">
        <ChevronLeft className="h-4 w-4" />
        Panel del taller
      </Link>
      <div className="flex items-center justify-between mb-6">
        <h1 className="text-2xl font-bold text-foreground">Servicios</h1>
      </div>

      {/* Add service */}
      <Card className="mb-6 border-gartify-orange/20">
        <CardHeader><CardTitle className="text-base">Añadir servicio</CardTitle></CardHeader>
        <CardContent><ServiceForm garageId={garage.id} /></CardContent>
      </Card>

      {/* Existing services */}
      <div className="space-y-3">
        {garage.services.map((s) => (
          <Card key={s.id} className={s.isActive ? "" : "opacity-50"}>
            <CardContent className="p-4 flex items-center justify-between gap-4">
              <div>
                <div className="flex items-center gap-2 mb-0.5">
                  <Badge variant="outline" className="text-xs">{SERVICE_LABELS[s.type]}</Badge>
                  {!s.isActive && <Badge variant="secondary" className="text-xs">Inactivo</Badge>}
                </div>
                <p className="font-medium text-foreground text-sm">{s.name}</p>
                <div className="flex items-center gap-1 text-xs text-muted-foreground mt-1">
                  <Clock className="h-3.5 w-3.5" /> {s.duration} min
                </div>
              </div>
              <p className="text-lg font-bold text-gartify-orange shrink-0">{formatPrice(s.price)}</p>
            </CardContent>
          </Card>
        ))}
      </div>
    </div>
  );
}
