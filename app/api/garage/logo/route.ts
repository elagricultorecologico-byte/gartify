import { NextResponse } from "next/server";
import { writeFile, mkdir } from "fs/promises";
import { join } from "path";
import { auth } from "@/lib/auth";
import { db } from "@/lib/db";

const VALID_TYPES = ["image/jpeg", "image/png", "image/webp"];
const MAX_SIZE_BYTES = 2 * 1024 * 1024; // 2 MB

export async function POST(req: Request) {
  const session = await auth();
  if (!session?.user?.id) {
    return NextResponse.json({ error: "No autenticado" }, { status: 401 });
  }

  const garage = await db.garage.findUnique({
    where: { ownerId: session.user.id },
    select: { id: true },
  });
  if (!garage) {
    return NextResponse.json({ error: "Taller no encontrado" }, { status: 404 });
  }

  let formData: FormData;
  try {
    formData = await req.formData();
  } catch {
    return NextResponse.json({ error: "Petición inválida" }, { status: 400 });
  }

  const file = formData.get("logo");
  if (!(file instanceof File)) {
    return NextResponse.json({ error: "No se ha proporcionado ninguna imagen" }, { status: 400 });
  }

  if (!VALID_TYPES.includes(file.type)) {
    return NextResponse.json(
      { error: "Formato no válido. Usa JPG, PNG o WebP." },
      { status: 400 }
    );
  }

  if (file.size > MAX_SIZE_BYTES) {
    return NextResponse.json(
      { error: "La imagen no puede superar 2 MB." },
      { status: 400 }
    );
  }

  const ext = file.type === "image/jpeg" ? "jpg" : file.type === "image/png" ? "png" : "webp";
  const filename = `garage-${garage.id}.${ext}`;
  const uploadDir = join(process.cwd(), "public", "uploads", "garages");

  await mkdir(uploadDir, { recursive: true });

  const bytes = await file.arrayBuffer();
  await writeFile(join(uploadDir, filename), Buffer.from(bytes));

  const logoUrl = `/uploads/garages/${filename}`;

  await db.garage.update({
    where: { id: garage.id },
    data: { logo: logoUrl },
  });

  return NextResponse.json({ logo: logoUrl });
}
