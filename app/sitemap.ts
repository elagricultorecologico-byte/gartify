import type { MetadataRoute } from "next";
import { db } from "@/lib/db";

export default async function sitemap(): Promise<MetadataRoute.Sitemap> {
  const garages = await db.garage.findMany({
    where: { isActive: true },
    select: { id: true },
  });

  const staticRoutes: MetadataRoute.Sitemap = [
    { url: "https://gartify.es",               lastModified: new Date(), changeFrequency: "weekly",  priority: 1.0 },
    { url: "https://gartify.es/talleres",       lastModified: new Date(), changeFrequency: "daily",   priority: 0.9 },
    { url: "https://gartify.es/como-funciona",  lastModified: new Date(), changeFrequency: "monthly", priority: 0.7 },
    { url: "https://gartify.es/para-talleres",  lastModified: new Date(), changeFrequency: "monthly", priority: 0.7 },
    { url: "https://gartify.es/itv",            lastModified: new Date(), changeFrequency: "monthly", priority: 0.6 },
    { url: "https://gartify.es/contacto",       lastModified: new Date(), changeFrequency: "monthly", priority: 0.5 },
  ];

  const garageRoutes: MetadataRoute.Sitemap = garages.map((g) => ({
    url: `https://gartify.es/talleres/${g.id}`,
    lastModified: new Date(),
    changeFrequency: "weekly",
    priority: 0.8,
  }));

  return [...staticRoutes, ...garageRoutes];
}
