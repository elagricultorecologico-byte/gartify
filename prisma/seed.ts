import { PrismaClient, Role, ServiceType } from "@prisma/client";
import bcrypt from "bcryptjs";

const prisma = new PrismaClient();

async function main() {
  console.log("🌱 Seeding database...");

  // Garage owners
  const owner1 = await prisma.user.upsert({
    where: { email: "taller1@gartify.es" },
    update: {},
    create: {
      name: "Carlos Martínez",
      email: "taller1@gartify.es",
      password: await bcrypt.hash("password123", 10),
      phone: "91 123 45 67",
      role: Role.GARAGE_OWNER,
    },
  });

  const owner2 = await prisma.user.upsert({
    where: { email: "taller2@gartify.es" },
    update: {},
    create: {
      name: "Ana López",
      email: "taller2@gartify.es",
      password: await bcrypt.hash("password123", 10),
      phone: "91 234 56 78",
      role: Role.GARAGE_OWNER,
    },
  });

  const owner3 = await prisma.user.upsert({
    where: { email: "taller3@gartify.es" },
    update: {},
    create: {
      name: "Pedro Sánchez",
      email: "taller3@gartify.es",
      password: await bcrypt.hash("password123", 10),
      phone: "91 345 67 89",
      role: Role.GARAGE_OWNER,
    },
  });

  // Demo customer
  await prisma.user.upsert({
    where: { email: "cliente@gartify.es" },
    update: {},
    create: {
      name: "María García",
      email: "cliente@gartify.es",
      password: await bcrypt.hash("password123", 10),
      phone: "600 123 456",
      role: Role.CUSTOMER,
    },
  });

  // Garage 1
  const garage1 = await prisma.garage.upsert({
    where: { ownerId: owner1.id },
    update: {},
    create: {
      name: "Taller Martínez Auto",
      description: "Taller mecánico con más de 20 años de experiencia en Madrid. Especialistas en ITV, revisiones y reparaciones de todo tipo de vehículos.",
      address: "Calle Alcalá, 142",
      city: "Madrid",
      postalCode: "28009",
      phone: "91 123 45 67",
      email: "info@tallerMartinez.es",
      lat: 40.4194,
      lng: -3.6877,
      rating: 4.7,
      reviewCount: 89,
      isVerified: true,
      isActive: true,
      ownerId: owner1.id,
    },
  });

  await prisma.garageService.createMany({
    skipDuplicates: true,
    data: [
      { garageId: garage1.id, type: ServiceType.ITV, name: "ITV Completa", description: "Inspección técnica oficial con pre-diagnóstico previo", price: 55, duration: 90 },
      { garageId: garage1.id, type: ServiceType.PRE_ITV, name: "Pre-ITV", description: "Revisión previa para garantizar el paso de la ITV", price: 25, duration: 45 },
      { garageId: garage1.id, type: ServiceType.REVISION, name: "Revisión Completa", description: "Revisión de 30 puntos con cambio de aceite y filtros incluidos", price: 89, duration: 120 },
      { garageId: garage1.id, type: ServiceType.FRENOS, name: "Revisión de Frenos", description: "Diagnóstico y sustitución de pastillas y discos", price: 45, duration: 60 },
      { garageId: garage1.id, type: ServiceType.DIAGNOSTICO, name: "Diagnóstico Electrónico", description: "Lectura de errores con escáner OBD2 profesional", price: 35, duration: 30 },
    ],
  });

  // Garage 2
  const garage2 = await prisma.garage.upsert({
    where: { ownerId: owner2.id },
    update: {},
    create: {
      name: "AutoService López",
      description: "Centro de mantenimiento y reparación oficial. Trabajamos con todas las marcas. Presupuesto gratuito sin compromiso.",
      address: "Paseo de la Castellana, 89",
      city: "Madrid",
      postalCode: "28046",
      phone: "91 234 56 78",
      email: "autoservice@lopez.es",
      lat: 40.4448,
      lng: -3.6922,
      rating: 4.5,
      reviewCount: 134,
      isVerified: true,
      isActive: true,
      ownerId: owner2.id,
    },
  });

  await prisma.garageService.createMany({
    skipDuplicates: true,
    data: [
      { garageId: garage2.id, type: ServiceType.REVISION, name: "Revisión Básica", description: "Cambio de aceite, filtro y 15 puntos de revisión", price: 59, duration: 60 },
      { garageId: garage2.id, type: ServiceType.NEUMATICOS, name: "Cambio de Neumáticos", description: "Montaje y equilibrado de 4 neumáticos", price: 30, duration: 45 },
      { garageId: garage2.id, type: ServiceType.CLIMATIZACION, name: "Carga de Aire Acondicionado", description: "Recarga de gas refrigerante R-134a o R-1234yf", price: 65, duration: 60 },
      { garageId: garage2.id, type: ServiceType.ELECTRICIDAD, name: "Reparación Eléctrica", description: "Diagnóstico y reparación de sistemas eléctricos", price: 50, duration: 90 },
      { garageId: garage2.id, type: ServiceType.FRENOS, name: "Cambio de Pastillas", description: "Sustitución de pastillas de freno eje delantero", price: 55, duration: 60 },
    ],
  });

  // Garage 3
  const garage3 = await prisma.garage.upsert({
    where: { ownerId: owner3.id },
    update: {},
    create: {
      name: "Mecánica Rápida Vallecas",
      description: "Servicio rápido y económico en el barrio de Vallecas. Cita previa en menos de 24 horas. Sin sorpresas en el presupuesto.",
      address: "Calle de Payaso Fofó, 5",
      city: "Madrid",
      postalCode: "28053",
      phone: "91 345 67 89",
      email: "mecanica@vallecas.es",
      lat: 40.3894,
      lng: -3.6524,
      rating: 4.3,
      reviewCount: 57,
      isVerified: false,
      isActive: true,
      ownerId: owner3.id,
    },
  });

  await prisma.garageService.createMany({
    skipDuplicates: true,
    data: [
      { garageId: garage3.id, type: ServiceType.CAMBIO_ACEITE, name: "Cambio de Aceite", description: "Cambio de aceite sintético y filtro de aceite", price: 39, duration: 30 },
      { garageId: garage3.id, type: ServiceType.PRE_ITV, name: "Pre-ITV Express", description: "Revisión rápida de los puntos críticos de la ITV", price: 20, duration: 30 },
      { garageId: garage3.id, type: ServiceType.DIAGNOSTICO, name: "Diagnóstico", description: "Diagnóstico completo de averías con escáner", price: 30, duration: 30 },
      { garageId: garage3.id, type: ServiceType.FRENOS, name: "Frenos Completo", description: "Revisión, sustitución de pastillas y líquido de frenos", price: 40, duration: 60 },
    ],
  });

  console.log("✅ Seed completado:");
  console.log(`   - ${await prisma.garage.count()} talleres`);
  console.log(`   - ${await prisma.garageService.count()} servicios`);
  console.log(`   - ${await prisma.user.count()} usuarios`);
  console.log("\n📋 Cuentas de prueba:");
  console.log("   Cliente:  cliente@gartify.es / password123");
  console.log("   Taller 1: taller1@gartify.es / password123");
  console.log("   Taller 2: taller2@gartify.es / password123");
}

main()
  .catch((e) => { console.error(e); process.exit(1); })
  .finally(async () => { await prisma.$disconnect(); });
