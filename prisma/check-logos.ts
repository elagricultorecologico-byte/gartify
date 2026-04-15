import { PrismaClient } from "@prisma/client";
const db = new PrismaClient();
db.vehicleMake.findMany({ select: { id: true, name: true, logoUrl: true }, take: 10 })
  .then((r) => console.log(JSON.stringify(r, null, 2)))
  .finally(() => void db.$disconnect());
