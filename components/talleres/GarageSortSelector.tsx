"use client";
import { useRouter, useSearchParams } from "next/navigation";
import {
  Select, SelectContent, SelectItem, SelectTrigger, SelectValue,
} from "@/components/ui/select";

const SORT_OPTIONS = [
  { value: "recomendados", label: "Recomendados" },
  { value: "distancia",    label: "Distancia" },
  { value: "precio",       label: "Precio (menor a mayor)" },
  { value: "valoracion",   label: "Valoración" },
];

export function GarageSortSelector() {
  const router = useRouter();
  const searchParams = useSearchParams();
  const current = searchParams.get("sort") ?? "recomendados";

  function handleChange(value: string) {
    const params = new URLSearchParams(searchParams.toString());
    if (value === "recomendados") {
      params.delete("sort");
    } else {
      params.set("sort", value);
    }
    params.delete("page");
    router.push(`/talleres?${params.toString()}`);
  }

  return (
    <div className="flex items-center gap-2 shrink-0">
      <span className="text-sm text-muted-foreground whitespace-nowrap hidden sm:inline">Ordenar por:</span>
      <Select value={current} onValueChange={handleChange}>
        <SelectTrigger className="h-8 text-sm w-44 bg-white border-gray-200">
          <SelectValue />
        </SelectTrigger>
        <SelectContent>
          {SORT_OPTIONS.map((o) => (
            <SelectItem key={o.value} value={o.value} className="text-sm">
              {o.label}
            </SelectItem>
          ))}
        </SelectContent>
      </Select>
    </div>
  );
}
