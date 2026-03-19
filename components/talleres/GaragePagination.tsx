"use client";
import { useRouter, useSearchParams } from "next/navigation";
import { Button } from "@/components/ui/button";
import { ChevronLeft, ChevronRight } from "lucide-react";

const PAGE_SIZE_OPTIONS = [5, 10, 20, 50];

export function GaragePagination({
  page,
  totalPages,
  total,
  pageSize,
}: {
  page: number;
  totalPages: number;
  total: number;
  pageSize: number;
}) {
  const router = useRouter();
  const sp = useSearchParams();

  function goTo(p: number) {
    const params = new URLSearchParams(sp.toString());
    if (p === 1) params.delete("page");
    else params.set("page", String(p));
    router.push(`/talleres?${params.toString()}`);
  }

  function changePageSize(size: number) {
    const params = new URLSearchParams(sp.toString());
    params.set("pageSize", String(size));
    params.delete("page");
    router.push(`/talleres?${params.toString()}`);
  }

  const from = (page - 1) * pageSize + 1;
  const to = Math.min(page * pageSize, total);

  return (
    <div className="flex flex-wrap items-center justify-between gap-3 pt-2 text-xs text-gartify-gray">
      {/* Left: counter + page size selector */}
      <div className="flex items-center gap-2">
        <span>{from}–{to} de {total} talleres</span>
        <span className="text-gray-300">|</span>
        <label htmlFor="pageSize" className="text-xs">Mostrar:</label>
        <select
          id="pageSize"
          value={pageSize}
          onChange={(e) => changePageSize(Number(e.target.value))}
          className="h-7 rounded border border-gray-200 bg-white px-1.5 text-xs text-gartify-blue font-medium focus:outline-none focus:ring-1 focus:ring-gartify-blue/40"
        >
          {PAGE_SIZE_OPTIONS.map((n) => (
            <option key={n} value={n}>{n} por página</option>
          ))}
        </select>
      </div>

      {/* Right: nav buttons */}
      <div className="flex items-center gap-1">
        <Button size="sm" variant="ghost" className="h-8 w-8 p-0" onClick={() => goTo(1)} disabled={page === 1}>
          <ChevronLeft className="h-3.5 w-3.5" /><ChevronLeft className="h-3.5 w-3.5 -ml-2.5" />
        </Button>
        <Button size="sm" variant="ghost" className="h-8 w-8 p-0" onClick={() => goTo(page - 1)} disabled={page === 1}>
          <ChevronLeft className="h-3.5 w-3.5" />
        </Button>
        <span className="px-3 font-medium text-gartify-blue">{page} / {totalPages}</span>
        <Button size="sm" variant="ghost" className="h-8 w-8 p-0" onClick={() => goTo(page + 1)} disabled={page === totalPages}>
          <ChevronRight className="h-3.5 w-3.5" />
        </Button>
        <Button size="sm" variant="ghost" className="h-8 w-8 p-0" onClick={() => goTo(totalPages)} disabled={page === totalPages}>
          <ChevronRight className="h-3.5 w-3.5" /><ChevronRight className="h-3.5 w-3.5 -ml-2.5" />
        </Button>
      </div>
    </div>
  );
}
