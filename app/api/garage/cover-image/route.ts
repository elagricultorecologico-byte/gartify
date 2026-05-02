import { NextResponse } from "next/server";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";
import { cloudinary } from "@/lib/cloudinary";

// Tamaño máximo permitido: 5 MB
const TAMANO_MAX_BYTES = 5 * 1024 * 1024;

export const runtime = "nodejs";

export async function POST(req: Request) {
  console.log("[cover-image] POST recibido");
  // Verificar sesión
  const sesion = await auth();
  if (!sesion?.user?.id) {
    return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  }

  // Verificar que el usuario es propietario de un taller
  const taller = await db.garage.findUnique({
    where: { ownerId: sesion.user.id },
    select: { id: true },
  });
  if (!taller) {
    return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });
  }

  // Leer el FormData
  let form: FormData;
  try {
    form = await req.formData();
  } catch (e) {
    console.error("[cover-image] formData error:", e);
    return NextResponse.json({ error: "No se pudo leer el formulario" }, { status: 400 });
  }

  const archivo = form.get("file");
  if (!(archivo instanceof File)) {
    return NextResponse.json({ error: "No se recibió ningún archivo" }, { status: 400 });
  }

  // Validar tipo MIME (solo imágenes)
  if (!archivo.type.startsWith("image/")) {
    return NextResponse.json({ error: "Solo se permiten imágenes" }, { status: 400 });
  }

  // Validar tamaño (máx. 5 MB)
  if (archivo.size > TAMANO_MAX_BYTES) {
    return NextResponse.json({ error: "La imagen no puede superar 5 MB" }, { status: 400 });
  }

  // Convertir File a Buffer para subir a Cloudinary
  const bytes = await archivo.arrayBuffer();
  const buffer = Buffer.from(bytes);

  // Subir a Cloudinary con transformación de banner (1200×400, recorte inteligente)
  let resultado: { secure_url: string };
  try {
    resultado = await new Promise<{ secure_url: string }>((resolve, reject) => {
      cloudinary.uploader
        .upload_stream(
          {
            folder:         `gartify/garages/${taller.id}`,
            public_id:      "cover",
            overwrite:      true,
            transformation: [
              { width: 1200, height: 400, crop: "fill", gravity: "auto" },
            ],
          },
          (err, res) => {
            if (err || !res) {
              reject(err ?? new Error("Respuesta vacía de Cloudinary"));
            } else {
              resolve(res as { secure_url: string });
            }
          }
        )
        .end(buffer);
    });
  } catch (err) {
    console.error("[cover-image] Error al subir a Cloudinary:", err);
    return NextResponse.json(
      { error: "Error al subir la imagen. Inténtalo de nuevo." },
      { status: 500 }
    );
  }

  // Guardar la URL en la base de datos
  await db.garage.update({
    where: { id: taller.id },
    data:  { coverImage: resultado.secure_url },
  });

  return NextResponse.json({ url: resultado.secure_url });
}
