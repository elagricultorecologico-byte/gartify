"use client";
import { useCallback, useState } from "react";

interface CPResult {
  city: string;
  province: string;
  community: string;
}

const CP_PREFIX_TO_PROVINCE: Record<string, string> = {
  "01": "Álava",           "02": "Albacete",       "03": "Alicante",
  "04": "Almería",         "05": "Ávila",           "06": "Badajoz",
  "07": "Illes Balears",   "08": "Barcelona",       "09": "Burgos",
  "10": "Cáceres",         "11": "Cádiz",           "12": "Castellón",
  "13": "Ciudad Real",     "14": "Córdoba",         "15": "A Coruña",
  "16": "Cuenca",          "17": "Girona",          "18": "Granada",
  "19": "Guadalajara",     "20": "Gipuzkoa",        "21": "Huelva",
  "22": "Huesca",          "23": "Jaén",            "24": "León",
  "25": "Lleida",          "26": "La Rioja",        "27": "Lugo",
  "28": "Madrid",          "29": "Málaga",          "30": "Murcia",
  "31": "Navarra",         "32": "Ourense",         "33": "Asturias",
  "34": "Palencia",        "35": "Las Palmas",      "36": "Pontevedra",
  "37": "Salamanca",       "38": "Santa Cruz de Tenerife", "39": "Cantabria",
  "40": "Segovia",         "41": "Sevilla",         "42": "Soria",
  "43": "Tarragona",       "44": "Teruel",          "45": "Toledo",
  "46": "Valencia",        "47": "Valladolid",      "48": "Bizkaia",
  "49": "Zamora",          "50": "Zaragoza",        "51": "Ceuta",
  "52": "Melilla",
};

const PROVINCE_TO_COMMUNITY: Record<string, string> = {
  "Álava":                   "País Vasco",
  "Albacete":                "Castilla-La Mancha",
  "Alicante":                "Comunidad Valenciana",
  "Almería":                 "Andalucía",
  "Ávila":                   "Castilla y León",
  "Badajoz":                 "Extremadura",
  "Illes Balears":           "Illes Balears",
  "Barcelona":               "Cataluña",
  "Burgos":                  "Castilla y León",
  "Cáceres":                 "Extremadura",
  "Cádiz":                   "Andalucía",
  "Castellón":               "Comunidad Valenciana",
  "Ciudad Real":             "Castilla-La Mancha",
  "Córdoba":                 "Andalucía",
  "A Coruña":                "Galicia",
  "Cuenca":                  "Castilla-La Mancha",
  "Girona":                  "Cataluña",
  "Granada":                 "Andalucía",
  "Guadalajara":             "Castilla-La Mancha",
  "Gipuzkoa":                "País Vasco",
  "Huelva":                  "Andalucía",
  "Huesca":                  "Aragón",
  "Jaén":                    "Andalucía",
  "León":                    "Castilla y León",
  "Lleida":                  "Cataluña",
  "La Rioja":                "La Rioja",
  "Lugo":                    "Galicia",
  "Madrid":                  "Comunidad de Madrid",
  "Málaga":                  "Andalucía",
  "Murcia":                  "Región de Murcia",
  "Navarra":                 "Comunidad Foral de Navarra",
  "Ourense":                 "Galicia",
  "Asturias":                "Principado de Asturias",
  "Palencia":                "Castilla y León",
  "Las Palmas":              "Canarias",
  "Pontevedra":              "Galicia",
  "Salamanca":               "Castilla y León",
  "Santa Cruz de Tenerife":  "Canarias",
  "Cantabria":               "Cantabria",
  "Segovia":                 "Castilla y León",
  "Sevilla":                 "Andalucía",
  "Soria":                   "Castilla y León",
  "Tarragona":               "Cataluña",
  "Teruel":                  "Aragón",
  "Toledo":                  "Castilla-La Mancha",
  "Valencia":                "Comunidad Valenciana",
  "Valladolid":              "Castilla y León",
  "Bizkaia":                 "País Vasco",
  "Zamora":                  "Castilla y León",
  "Zaragoza":                "Aragón",
  "Ceuta":                   "Ceuta",
  "Melilla":                 "Melilla",
};

export function usePostalCodeLookup() {
  const [loading, setLoading] = useState(false);

  const lookup = useCallback(async (cp: string): Promise<CPResult | null> => {
    if (!/^\d{5}$/.test(cp)) return null;

    const province  = CP_PREFIX_TO_PROVINCE[cp.slice(0, 2)] ?? "";
    const community = province ? (PROVINCE_TO_COMMUNITY[province] ?? "") : "";

    setLoading(true);
    try {
      const res = await fetch(`https://api.zippopotam.us/es/${cp}`);
      if (!res.ok) return { city: "", province, community };
      const data = await res.json() as {
        places?: Array<{ "place name": string }>;
      };
      const city = data.places?.[0]?.["place name"] ?? "";
      return { city, province, community };
    } catch {
      return { city: "", province, community };
    } finally {
      setLoading(false);
    }
  }, []);

  return { lookup, loading };
}
