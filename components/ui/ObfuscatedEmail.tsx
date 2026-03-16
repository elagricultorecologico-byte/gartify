"use client";
import { useState, useEffect } from "react";

interface ObfuscatedEmailProps {
  user: string;
  domain: string;
  className?: string;
}

/**
 * Renders an email link only after hydration so that the raw address
 * never appears in the static HTML — protecting it from spam scrapers.
 */
export function ObfuscatedEmail({ user, domain, className }: ObfuscatedEmailProps) {
  const [email, setEmail] = useState<string | null>(null);

  useEffect(() => {
    setEmail(`${user}@${domain}`);
  }, [user, domain]);

  if (!email) {
    return (
      <span className={className} aria-label="Cargando email">
        {user}&nbsp;[at]&nbsp;{domain}
      </span>
    );
  }

  return (
    <a href={`mailto:${email}`} className={className}>
      {email}
    </a>
  );
}
