import type { MetadataRoute } from "next";

export default function robots(): MetadataRoute.Robots {
  return {
    rules: {
      userAgent: "*",
      allow: "/",
      disallow: ["/api/", "/cuenta/", "/reserva/"],
    },
    sitemap: "https://gartify.es/sitemap.xml",
  };
}
