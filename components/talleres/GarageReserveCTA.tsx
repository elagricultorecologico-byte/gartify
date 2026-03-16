"use client";
import { useState, useEffect } from "react";
import Link from "next/link";
import { Button } from "@/components/ui/button";
import { CalendarCheck } from "lucide-react";
import { formatPrice } from "@/lib/utils";

interface Props {
  garageId: string;
  minPrice: number;
}

export function GarageReserveCTA({ garageId, minPrice }: Props) {
  const [visible, setVisible] = useState(false);

  useEffect(() => {
    const onScroll = () => setVisible(window.scrollY > 300);
    window.addEventListener("scroll", onScroll, { passive: true });
    return () => window.removeEventListener("scroll", onScroll);
  }, []);

  if (!visible) return null;

  return (
    <div className="fixed bottom-6 left-4 right-4 z-50 lg:hidden animate-in slide-in-from-bottom-4 duration-300">
      <div className="bg-white rounded-2xl shadow-2xl border border-gray-200 p-3 flex items-center gap-3">
        <div className="flex-1 min-w-0">
          <p className="text-xs text-muted-foreground leading-none">Desde</p>
          <p className="text-lg font-bold text-gartify-blue leading-tight">{formatPrice(minPrice)}</p>
        </div>
        <Link href={`/talleres/${garageId}/reservar`} className="shrink-0">
          <Button
            size="lg"
            className="bg-gartify-green hover:bg-gartify-green/90 text-white font-bold h-12 px-6 rounded-xl"
          >
            <CalendarCheck className="h-5 w-5 mr-1.5" />
            Pedir cita
          </Button>
        </Link>
      </div>
    </div>
  );
}
