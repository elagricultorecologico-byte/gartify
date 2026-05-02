"use client";
import { useState } from "react";
import { Building2 } from "lucide-react";

interface PropsLogoTaller {
  src: string | null;
  nombre: string;
}

export function LogoTaller({ src, nombre }: PropsLogoTaller) {
  const [error, setError] = useState(false);

  if (!src || error) {
    return (
      <div className="w-full h-full flex items-center justify-center bg-white/10">
        <Building2 className="h-10 w-10 text-white/60" />
      </div>
    );
  }

  return (
    // eslint-disable-next-line @next/next/no-img-element
    <img
      src={src}
      alt={`Logo de ${nombre}`}
      className="w-full h-full object-cover"
      onError={() => setError(true)}
    />
  );
}
