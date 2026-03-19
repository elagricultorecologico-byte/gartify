import { PrismaClient } from "@prisma/client";
import bcrypt from "bcryptjs";

const prisma = new PrismaClient();

async function main() {
  console.log("🌱 Seeding database...");

  // Limpiar en orden correcto (FK constraints)
  await prisma.review.deleteMany();
  await prisma.booking.deleteMany();
  await prisma.garageService.deleteMany();
  await prisma.garageOffer.deleteMany();
  await prisma.partOrderLine.deleteMany();
  await prisma.partOrder.deleteMany();
  await prisma.distributorPart.deleteMany();
  await prisma.part.deleteMany();
  await prisma.distributor.deleteMany();

  // Garage owners
  const owner1 = await prisma.user.upsert({
    where: { email: "taller1@gartify.es" },
    update: {},
    create: {
      name: "Carlos Martínez",
      email: "taller1@gartify.es",
      password: await bcrypt.hash("password123", 10),
      phone: "91 123 45 67",
      role: "GARAGE_OWNER",
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
      role: "GARAGE_OWNER",
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
      role: "GARAGE_OWNER",
    },
  });

  const owner4 = await prisma.user.upsert({
    where: { email: "taller4@gartify.es" },
    update: {},
    create: {
      name: "Jordi Puig",
      email: "taller4@gartify.es",
      password: await bcrypt.hash("password123", 10),
      phone: "93 412 55 66",
      role: "GARAGE_OWNER",
    },
  });

  const owner5 = await prisma.user.upsert({
    where: { email: "taller5@gartify.es" },
    update: {},
    create: {
      name: "Rosa Ferrer",
      email: "taller5@gartify.es",
      password: await bcrypt.hash("password123", 10),
      phone: "93 666 77 88",
      role: "GARAGE_OWNER",
    },
  });

  const owner6 = await prisma.user.upsert({
    where: { email: "taller6@gartify.es" },
    update: {},
    create: {
      name: "Marc Soler",
      email: "taller6@gartify.es",
      password: await bcrypt.hash("password123", 10),
      phone: "93 777 88 99",
      role: "GARAGE_OWNER",
    },
  });

  const owner7 = await prisma.user.upsert({
    where: { email: "taller7@gartify.es" },
    update: {},
    create: {
      name: "Laia Vidal",
      email: "taller7@gartify.es",
      password: await bcrypt.hash("password123", 10),
      phone: "93 555 44 33",
      role: "GARAGE_OWNER",
    },
  });

  // Admin
  await prisma.user.upsert({
    where: { email: "admin@gartify.es" },
    update: {},
    create: {
      name: "Admin Gartify",
      email: "admin@gartify.es",
      password: await bcrypt.hash("admin123", 10),
      role: "ADMIN",
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
      role: "CUSTOMER",
    },
  });

  // Garage 1
  const garage1 = await prisma.garage.upsert({
    where: { ownerId: owner1.id },
    update: { plan: "STARTER", vehicleTypes: JSON.stringify(["COCHE", "MOTO", "FURGONETA"]) },
    create: {
      name: "Taller Martínez Auto",
      plan: "STARTER",
      vehicleTypes: JSON.stringify(["COCHE", "MOTO", "FURGONETA"]),
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
    data: [
      { garageId: garage1.id, type: "ITV", name: "ITV Completa", description: "Inspección técnica oficial con pre-diagnóstico previo", price: 55, duration: 90 },
      { garageId: garage1.id, type: "PRE_ITV", name: "Pre-ITV", description: "Revisión previa para garantizar el paso de la ITV", price: 25, duration: 45 },
      { garageId: garage1.id, type: "REVISION", name: "Revisión Completa", description: "Revisión de 30 puntos con cambio de aceite y filtros incluidos", price: 89, duration: 120 },
      { garageId: garage1.id, type: "FRENOS", name: "Revisión de Frenos", description: "Diagnóstico y sustitución de pastillas y discos", price: 45, duration: 60 },
      { garageId: garage1.id, type: "DIAGNOSTICO", name: "Diagnóstico Electrónico", description: "Lectura de errores con escáner OBD2 profesional", price: 35, duration: 30 },
    ],
  });

  // Garage 2
  const garage2 = await prisma.garage.upsert({
    where: { ownerId: owner2.id },
    update: { plan: "STARTER", vehicleTypes: JSON.stringify(["COCHE", "FURGONETA", "AUTOCARAVANA"]) },
    create: {
      name: "AutoService López",
      plan: "STARTER",
      vehicleTypes: JSON.stringify(["COCHE", "FURGONETA", "AUTOCARAVANA"]),
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
      courtesyCar: true,
      pickupService: true,
      ownerId: owner2.id,
    },
  });

  await prisma.garageService.createMany({
    data: [
      { garageId: garage2.id, type: "REVISION", name: "Revisión Básica", description: "Cambio de aceite, filtro y 15 puntos de revisión", price: 59, duration: 60 },
      { garageId: garage2.id, type: "NEUMATICOS", name: "Cambio de Neumáticos", description: "Montaje y equilibrado de 4 neumáticos", price: 30, duration: 45 },
      { garageId: garage2.id, type: "CLIMATIZACION", name: "Carga de Aire Acondicionado", description: "Recarga de gas refrigerante R-134a o R-1234yf", price: 65, duration: 60 },
      { garageId: garage2.id, type: "ELECTRICIDAD", name: "Reparación Eléctrica", description: "Diagnóstico y reparación de sistemas eléctricos", price: 50, duration: 90 },
      { garageId: garage2.id, type: "FRENOS", name: "Cambio de Pastillas", description: "Sustitución de pastillas de freno eje delantero", price: 55, duration: 60 },
    ],
  });

  // Garage 3
  const garage3 = await prisma.garage.upsert({
    where: { ownerId: owner3.id },
    update: { plan: "STARTER", vehicleTypes: JSON.stringify(["COCHE", "MOTO"]) },
    create: {
      name: "Mecánica Rápida Vallecas",
      plan: "STARTER",
      vehicleTypes: JSON.stringify(["COCHE", "MOTO"]),
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
    data: [
      { garageId: garage3.id, type: "CAMBIO_ACEITE", name: "Cambio de Aceite", description: "Cambio de aceite sintético y filtro de aceite", price: 39, duration: 30 },
      { garageId: garage3.id, type: "PRE_ITV", name: "Pre-ITV Express", description: "Revisión rápida de los puntos críticos de la ITV", price: 20, duration: 30 },
      { garageId: garage3.id, type: "DIAGNOSTICO", name: "Diagnóstico", description: "Diagnóstico completo de averías con escáner", price: 30, duration: 30 },
      { garageId: garage3.id, type: "FRENOS", name: "Frenos Completo", description: "Revisión, sustitución de pastillas y líquido de frenos", price: 40, duration: 60 },
    ],
  });

  // Garage 4 — Barcelona Eixample
  const garage4 = await prisma.garage.upsert({
    where: { ownerId: owner4.id },
    update: { plan: "PRO", vehicleTypes: JSON.stringify(["COCHE", "MOTO", "FURGONETA", "CAMPER"]) },
    create: {
      name: "Taller Puig Motor",
      plan: "PRO",
      vehicleTypes: JSON.stringify(["COCHE", "MOTO", "FURGONETA", "CAMPER"]),
      description: "Taller familiar en el Eixample con 30 años de historia. Especialistas en marcas alemanas y japonesas. Presupuesto sin compromiso.",
      address: "Carrer de Muntaner, 212",
      city: "Barcelona",
      postalCode: "08036",
      phone: "93 412 55 66",
      email: "info@puigmotor.es",
      lat: 41.3879,
      lng: 2.1538,
      rating: 4.8,
      reviewCount: 203,
      isVerified: true,
      isActive: true,
      courtesyCar: true,
      ownerId: owner4.id,
    },
  });

  await prisma.garageService.createMany({
    data: [
      { garageId: garage4.id, type: "REVISION", name: "Revisión Completa", description: "Revisión de 40 puntos, cambio de aceite y filtros incluidos", price: 95, duration: 120 },
      { garageId: garage4.id, type: "ITV", name: "Acompañamiento ITV", description: "Llevamos tu coche a la ITV y te informamos del resultado", price: 60, duration: 90 },
      { garageId: garage4.id, type: "PRE_ITV", name: "Pre-ITV", description: "Revisión previa para garantizar el paso de la ITV", price: 28, duration: 45 },
      { garageId: garage4.id, type: "FRENOS", name: "Revisión de Frenos", description: "Diagnóstico y sustitución de pastillas y discos", price: 50, duration: 60 },
      { garageId: garage4.id, type: "CLIMATIZACION", name: "Aire Acondicionado", description: "Recarga de gas y revisión del sistema de climatización", price: 70, duration: 60 },
      { garageId: garage4.id, type: "DIAGNOSTICO", name: "Diagnóstico Electrónico", description: "Lectura de errores con escáner multimarca", price: 40, duration: 30 },
    ],
  });

  // Garage 5 — Barcelona Gràcia
  const garage5 = await prisma.garage.upsert({
    where: { ownerId: owner5.id },
    update: { plan: "PRO", vehicleTypes: JSON.stringify(["COCHE", "AUTOCARAVANA", "CAMPER"]) },
    create: {
      name: "AutoGràcia Ferrer",
      plan: "PRO",
      vehicleTypes: JSON.stringify(["COCHE", "AUTOCARAVANA", "CAMPER"]),
      description: "Taller de confianza en el barrio de Gràcia. Reparaciones rápidas, transparencia total en los presupuestos y recogida a domicilio disponible.",
      address: "Carrer de Verdi, 78",
      city: "Barcelona",
      postalCode: "08012",
      phone: "93 666 77 88",
      email: "autogracia@ferrer.es",
      lat: 41.4025,
      lng: 2.1553,
      rating: 4.6,
      reviewCount: 118,
      isVerified: true,
      isActive: true,
      ownerId: owner5.id,
    },
  });

  await prisma.garageService.createMany({
    data: [
      { garageId: garage5.id, type: "CAMBIO_ACEITE", name: "Cambio de Aceite", description: "Aceite sintético 5W30/5W40 con filtro incluido", price: 45, duration: 30 },
      { garageId: garage5.id, type: "NEUMATICOS", name: "Cambio de Neumáticos", description: "Montaje y equilibrado de 4 neumáticos con válvulas nuevas", price: 25, duration: 45 },
      { garageId: garage5.id, type: "ELECTRICIDAD", name: "Reparación Eléctrica", description: "Diagnóstico y reparación de sistemas eléctricos y electrónicos", price: 55, duration: 90 },
      { garageId: garage5.id, type: "SUSPENSION", name: "Suspensión y Dirección", description: "Revisión completa de amortiguadores, rótulas y dirección", price: 65, duration: 90 },
      { garageId: garage5.id, type: "FRENOS", name: "Frenos Completo", description: "Pastillas, discos y líquido de frenos en los 4 ejes", price: 120, duration: 90 },
    ],
  });

  // Garage 6 — Sant Feliu de Llobregat
  const garage6 = await prisma.garage.upsert({
    where: { ownerId: owner6.id },
    update: { plan: "PREMIUM", vehicleTypes: JSON.stringify(["COCHE", "MOTO", "FURGONETA", "CAMION"]) },
    create: {
      name: "Soler Automòbils",
      plan: "PREMIUM",
      vehicleTypes: JSON.stringify(["COCHE", "MOTO", "FURGONETA", "CAMION"]),
      description: "Taller mecánico oficial en Sant Feliu de Llobregat. Más de 15 años de experiencia. Servicio de sustitución y coche de cortesía disponible.",
      address: "Carrer de la Creu, 34",
      city: "Sant Feliu de Llobregat",
      postalCode: "08980",
      phone: "93 777 88 99",
      email: "soler@automobils.es",
      lat: 41.3828,
      lng: 2.0436,
      rating: 4.5,
      reviewCount: 76,
      isVerified: true,
      isActive: true,
      courtesyCar: true,
      pickupService: true,
      ownerId: owner6.id,
    },
  });

  await prisma.garageService.createMany({
    data: [
      { garageId: garage6.id, type: "ITV", name: "ITV Completa", description: "Inspección técnica con traslado al centro oficial", price: 58, duration: 90 },
      { garageId: garage6.id, type: "REVISION", name: "Revisión Básica", description: "Cambio de aceite, filtro de aire y revisión de 20 puntos", price: 69, duration: 75 },
      { garageId: garage6.id, type: "CLIMATIZACION", name: "Carga A/C", description: "Recarga de gas refrigerante con control de fugas", price: 65, duration: 60 },
      { garageId: garage6.id, type: "DIAGNOSTICO", name: "Diagnóstico OBD2", description: "Escáner completo y borrado de errores", price: 35, duration: 30 },
      { garageId: garage6.id, type: "FRENOS", name: "Cambio de Pastillas", description: "Sustitución de pastillas eje delantero o trasero", price: 48, duration: 60 },
    ],
  });

  // Garage 7 — Sant Feliu de Llobregat
  const garage7 = await prisma.garage.upsert({
    where: { ownerId: owner7.id },
    update: { plan: "PREMIUM", vehicleTypes: JSON.stringify(["COCHE", "MOTO"]) },
    create: {
      name: "TallerRàpid Sant Feliu",
      plan: "PREMIUM",
      vehicleTypes: JSON.stringify(["COCHE", "MOTO"]),
      description: "El taller más rápido del Baix Llobregat. Cita el mismo día, diagnóstico gratuito en la primera visita y recogida a domicilio.",
      address: "Avinguda de Can Nadal, 15",
      city: "Sant Feliu de Llobregat",
      postalCode: "08980",
      phone: "93 555 44 33",
      email: "info@tallerrapid.es",
      lat: 41.3800,
      lng: 2.0460,
      rating: 4.2,
      reviewCount: 41,
      isVerified: false,
      isActive: true,
      ownerId: owner7.id,
    },
  });

  await prisma.garageService.createMany({
    data: [
      { garageId: garage7.id, type: "CAMBIO_ACEITE", name: "Cambio de Aceite Express", description: "Cambio de aceite en menos de 30 minutos", price: 39, duration: 30 },
      { garageId: garage7.id, type: "PRE_ITV", name: "Pre-ITV Express", description: "Revisión rápida de los puntos críticos de la ITV", price: 22, duration: 30 },
      { garageId: garage7.id, type: "NEUMATICOS", name: "Cambio de Neumáticos", description: "Montaje, equilibrado y alineación incluida", price: 28, duration: 45 },
      { garageId: garage7.id, type: "ELECTRICIDAD", name: "Batería y Alternador", description: "Diagnóstico y sustitución de batería o alternador", price: 45, duration: 60 },
    ],
  });

  // ── Horarios por defecto para todos los talleres ──
  // Lun–Vie 08:00–18:00, Sáb 09:00–14:00, Dom cerrado
  const DEFAULT_SCHEDULE = (garageId: string) => [
    { garageId, dayOfWeek: 0, isOpen: false, openTime: "09:00", closeTime: "14:00" },
    { garageId, dayOfWeek: 1, isOpen: true,  openTime: "08:00", closeTime: "18:00" },
    { garageId, dayOfWeek: 2, isOpen: true,  openTime: "08:00", closeTime: "18:00" },
    { garageId, dayOfWeek: 3, isOpen: true,  openTime: "08:00", closeTime: "18:00" },
    { garageId, dayOfWeek: 4, isOpen: true,  openTime: "08:00", closeTime: "18:00" },
    { garageId, dayOfWeek: 5, isOpen: true,  openTime: "08:00", closeTime: "18:00" },
    { garageId, dayOfWeek: 6, isOpen: true,  openTime: "09:00", closeTime: "14:00" },
  ];

  for (const g of [garage1, garage2, garage3, garage4, garage5, garage6, garage7]) {
    await prisma.garageSchedule.deleteMany({ where: { garageId: g.id } });
    await prisma.garageSchedule.createMany({ data: DEFAULT_SCHEDULE(g.id) });
  }

  // ── Ofertas de horario demo ──────────────────────────────────────────────
  // Garage 1 (Taller Martínez Auto, Madrid): 2 ofertas
  await prisma.garageOffer.createMany({
    data: [
      {
        garageId:  garage1.id,
        label:     "Cambio de aceite express",
        days:      JSON.stringify(["LUN", "MAR"]),
        startTime: "10:00",
        endTime:   "12:00",
        price:     19.99,
        isActive:  true,
      },
      {
        garageId:  garage1.id,
        label:     "Pre-ITV urgente",
        days:      JSON.stringify(["MIE", "JUE", "VIE"]),
        startTime: "08:00",
        endTime:   "10:00",
        price:     15.00,
        isActive:  true,
      },
    ],
  });

  // Garage 3 (Mecánica Rápida Vallecas, Madrid): 1 oferta
  await prisma.garageOffer.createMany({
    data: [
      {
        garageId:  garage3.id,
        label:     "Diagnóstico gratuito primer servicio",
        days:      JSON.stringify(["LUN", "MIE", "VIE"]),
        startTime: "09:00",
        endTime:   "11:00",
        price:     0.01,
        isActive:  true,
      },
    ],
  });

  // Garage 5 (AutoGràcia Ferrer, Barcelona): 2 ofertas
  await prisma.garageOffer.createMany({
    data: [
      {
        garageId:  garage5.id,
        label:     "Cambio de neumáticos + equilibrado",
        days:      JSON.stringify(["SAB"]),
        startTime: "09:00",
        endTime:   "13:00",
        price:     89.90,
        isActive:  true,
      },
      {
        garageId:  garage5.id,
        label:     "Revisión frenos completo",
        days:      JSON.stringify(["MAR", "JUE"]),
        startTime: "16:00",
        endTime:   "19:00",
        price:     49.00,
        isActive:  true,
      },
    ],
  });

  // ── Reservas y reseñas demo ──────────────────────────────────────────────
  const clienteUser = await prisma.user.findUniqueOrThrow({ where: { email: "cliente@gartify.es" } });

  // Fetch one service per garage to use in bookings
  const [svc1, svc2, svc3, svc4, svc5] = await Promise.all([
    prisma.garageService.findFirst({ where: { garageId: garage1.id, type: "REVISION" } }),
    prisma.garageService.findFirst({ where: { garageId: garage2.id, type: "CAMBIO_ACEITE" } }),
    prisma.garageService.findFirst({ where: { garageId: garage3.id, type: "FRENOS" } }),
    prisma.garageService.findFirst({ where: { garageId: garage4.id, type: "ITV" } }),
    prisma.garageService.findFirst({ where: { garageId: garage5.id, type: "CLIMATIZACION" } }),
  ]);


  type DemoReview = { rating: number; comment: string };
  const demoBookings: Array<{
    garageId: string; serviceId: string; price: number;
    daysAgo: number; review: DemoReview;
  }> = [];

  if (svc1) demoBookings.push({ garageId: garage1.id, serviceId: svc1.id, price: svc1.price, daysAgo: 45, review: { rating: 5, comment: "Taller excelente. El personal muy amable y profesional. La revisión fue rápida y me explicaron todo con detalle. Totalmente recomendable." } });
  if (svc2) demoBookings.push({ garageId: garage2.id, serviceId: svc2.id, price: svc2.price, daysAgo: 30, review: { rating: 4, comment: "Buen servicio, cambio de aceite en menos de 30 minutos. Precio justo. Repetiré." } });
  if (svc3) demoBookings.push({ garageId: garage3.id, serviceId: svc3.id, price: svc3.price, daysAgo: 20, review: { rating: 5, comment: "Excelente atención. Detectaron un problema en los frenos traseros que no sabía que tenía. Gracias al diagnóstico evité un accidente." } });
  if (svc4) demoBookings.push({ garageId: garage4.id, serviceId: svc4.id, price: svc4.price, daysAgo: 15, review: { rating: 4, comment: "Pasé la ITV sin problemas. El taller hizo una pre-revisión muy completa. Solo me bajó una estrella por la espera." } });
  if (svc5) demoBookings.push({ garageId: garage5.id, serviceId: svc5.id, price: svc5.price, daysAgo: 8,  review: { rating: 5, comment: "Increíble taller. El aire acondicionado quedó como nuevo. Precio muy competitivo y el coche de cortesía fue un detalle genial." } });

  for (const b of demoBookings) {
    const date = new Date();
    date.setDate(date.getDate() - b.daysAgo);
    date.setHours(10, 0, 0, 0);

    const booking = await prisma.booking.create({
      data: {
        userId:     clienteUser.id,
        garageId:   b.garageId,
        serviceId:  b.serviceId,
        date,
        totalPrice: b.price,
        status:     "COMPLETED",
        vehicleModel: "Seat León 2020",
        vehiclePlate: "1234 ABC",
      },
    });

    await prisma.review.create({
      data: {
        userId:    clienteUser.id,
        garageId:  b.garageId,
        bookingId: booking.id,
        rating:    b.review.rating,
        comment:   b.review.comment,
        createdAt: date,
      },
    });
  }

  // Recompute garage ratings after inserting reviews
  for (const g of [garage1, garage2, garage3, garage4, garage5]) {
    const agg = await prisma.review.aggregate({
      where: { garageId: g.id },
      _avg:   { rating: true },
      _count: { rating: true },
    });
    if (agg._count.rating > 0) {
      await prisma.garage.update({
        where: { id: g.id },
        data: {
          rating:      Math.round((agg._avg.rating ?? 0) * 10) / 10,
          reviewCount: agg._count.rating,
        },
      });
    }
  }
  // ─────────────────────────────────────────────────────────────────────────
  // ── Distribuidores de recambios ──────────────────────────────────────────

  const dist1 = await prisma.distributor.create({
    data: {
      name: "Recambios García & Hijos",
      email: "pedidos@recambiosgarcia.es",
      phone: "91 400 12 34",
      website: "https://recambiosgarcia.es",
      isActive: true,
    },
  });

  const dist2 = await prisma.distributor.create({
    data: {
      name: "AutoPiezas Iberia",
      email: "ventas@autopiezasiberia.es",
      phone: "93 200 55 66",
      website: "https://autopiezasiberia.es",
      isActive: true,
    },
  });

  const dist3 = await prisma.distributor.create({
    data: {
      name: "Motor Norte Distribuciones",
      email: "stock@motornorte.es",
      phone: "94 500 88 77",
      website: "https://motornorte.es",
      isActive: true,
    },
  });

  // Piezas compartidas (referencias OEM universales)
  const partsData = [
    {
      referenciaOem: "OEM-FILTRO-ACEITE-001",
      nombre: "Filtro de aceite Mann HU 816 x",
      marcaFabricante: "Mann-Filter",
      categoria: "FILTROS",
      subcategoria: "Filtro aceite",
    },
    {
      referenciaOem: "OEM-PASTILLAS-DEL-BOSCH",
      nombre: "Pastillas de freno delanteras Bosch BP-1234",
      marcaFabricante: "Bosch",
      categoria: "FRENOS",
      subcategoria: "Pastillas delanteras",
    },
    {
      referenciaOem: "OEM-DISCO-DEL-BREMBO-280",
      nombre: "Disco de freno delantero Brembo 09.A862.11",
      marcaFabricante: "Brembo",
      categoria: "FRENOS",
      subcategoria: "Discos delanteros",
    },
    {
      referenciaOem: "OEM-FILTRO-AIRE-MAHLE-LX",
      nombre: "Filtro de aire Mahle LX 1004",
      marcaFabricante: "Mahle",
      categoria: "FILTROS",
      subcategoria: "Filtro aire",
    },
    {
      referenciaOem: "OEM-FILTRO-HAB-MANN-CU",
      nombre: "Filtro habitáculo Mann CU 2939",
      marcaFabricante: "Mann-Filter",
      categoria: "FILTROS",
      subcategoria: "Filtro habitáculo",
    },
    {
      referenciaOem: "OEM-BUJIAS-NGK-BKR5E",
      nombre: "Bujías NGK BKR5E (juego 4 uds)",
      marcaFabricante: "NGK",
      categoria: "ENCENDIDO",
      subcategoria: "Bujías",
    },
    {
      referenciaOem: "OEM-CORREA-GATES-K015PK",
      nombre: "Kit correa distribución Gates K015PK",
      marcaFabricante: "Gates",
      categoria: "MOTOR",
      subcategoria: "Distribución",
    },
    {
      referenciaOem: "OEM-AMORTIGUADOR-SACHS-309",
      nombre: "Amortiguador delantero Sachs 309 587",
      marcaFabricante: "Sachs",
      categoria: "SUSPENSION",
      subcategoria: "Amortiguadores",
    },
    {
      referenciaOem: "OEM-ACEITE-CASTROL-5W30-5L",
      nombre: "Aceite motor Castrol Edge 5W-30 5L",
      marcaFabricante: "Castrol",
      categoria: "LUBRICANTES",
      subcategoria: "Aceite motor",
    },
    {
      referenciaOem: "OEM-BATERIA-VARTA-60AH",
      nombre: "Batería Varta Blue Dynamic 60Ah 540A",
      marcaFabricante: "Varta",
      categoria: "ELECTRICO",
      subcategoria: "Baterías",
    },
  ];

  const createdParts = await Promise.all(
    partsData.map((p) => prisma.part.create({ data: p }))
  );

  // Precios por distribuidor: dist1 más barato, dist2 intermedio, dist3 más caro pero más stock y entrega rápida
  type PartPricing = { precioCoste: number; precioPvp: number; stock: number; plazoEntregaHoras: number };
  const pricing: Record<string, { d1: PartPricing; d2: PartPricing; d3: PartPricing }> = {
    "OEM-FILTRO-ACEITE-001":       { d1: { precioCoste: 4.20,  precioPvp: 7.50,   stock: 45, plazoEntregaHoras: 48 }, d2: { precioCoste: 4.80,  precioPvp: 8.20,   stock: 30, plazoEntregaHoras: 24 }, d3: { precioCoste: 5.10,  precioPvp: 8.90,   stock: 80, plazoEntregaHoras: 12 } },
    "OEM-PASTILLAS-DEL-BOSCH":     { d1: { precioCoste: 18.50, precioPvp: 32.00,  stock: 20, plazoEntregaHoras: 48 }, d2: { precioCoste: 19.90, precioPvp: 34.50,  stock: 15, plazoEntregaHoras: 24 }, d3: { precioCoste: 21.00, precioPvp: 36.00,  stock: 35, plazoEntregaHoras: 12 } },
    "OEM-DISCO-DEL-BREMBO-280":    { d1: { precioCoste: 28.00, precioPvp: 48.00,  stock: 10, plazoEntregaHoras: 72 }, d2: { precioCoste: 29.50, precioPvp: 51.00,  stock: 8,  plazoEntregaHoras: 48 }, d3: { precioCoste: 31.00, precioPvp: 54.00,  stock: 22, plazoEntregaHoras: 24 } },
    "OEM-FILTRO-AIRE-MAHLE-LX":    { d1: { precioCoste: 6.90,  precioPvp: 12.00,  stock: 38, plazoEntregaHoras: 48 }, d2: { precioCoste: 7.20,  precioPvp: 12.50,  stock: 25, plazoEntregaHoras: 24 }, d3: { precioCoste: 7.80,  precioPvp: 13.50,  stock: 60, plazoEntregaHoras: 12 } },
    "OEM-FILTRO-HAB-MANN-CU":      { d1: { precioCoste: 5.50,  precioPvp: 9.80,   stock: 42, plazoEntregaHoras: 48 }, d2: { precioCoste: 5.90,  precioPvp: 10.20,  stock: 28, plazoEntregaHoras: 24 }, d3: { precioCoste: 6.30,  precioPvp: 11.00,  stock: 55, plazoEntregaHoras: 12 } },
    "OEM-BUJIAS-NGK-BKR5E":        { d1: { precioCoste: 9.80,  precioPvp: 17.00,  stock: 25, plazoEntregaHoras: 48 }, d2: { precioCoste: 10.50, precioPvp: 18.00,  stock: 18, plazoEntregaHoras: 24 }, d3: { precioCoste: 11.20, precioPvp: 19.50,  stock: 40, plazoEntregaHoras: 12 } },
    "OEM-CORREA-GATES-K015PK":     { d1: { precioCoste: 42.00, precioPvp: 72.00,  stock: 8,  plazoEntregaHoras: 72 }, d2: { precioCoste: 44.00, precioPvp: 76.00,  stock: 5,  plazoEntregaHoras: 48 }, d3: { precioCoste: 46.50, precioPvp: 80.00,  stock: 15, plazoEntregaHoras: 24 } },
    "OEM-AMORTIGUADOR-SACHS-309":  { d1: { precioCoste: 38.00, precioPvp: 65.00,  stock: 6,  plazoEntregaHoras: 72 }, d2: { precioCoste: 40.00, precioPvp: 68.00,  stock: 4,  plazoEntregaHoras: 48 }, d3: { precioCoste: 43.00, precioPvp: 74.00,  stock: 12, plazoEntregaHoras: 24 } },
    "OEM-ACEITE-CASTROL-5W30-5L":  { d1: { precioCoste: 22.00, precioPvp: 38.00,  stock: 30, plazoEntregaHoras: 48 }, d2: { precioCoste: 23.50, precioPvp: 40.00,  stock: 20, plazoEntregaHoras: 24 }, d3: { precioCoste: 25.00, precioPvp: 43.00,  stock: 50, plazoEntregaHoras: 12 } },
    "OEM-BATERIA-VARTA-60AH":      { d1: { precioCoste: 58.00, precioPvp: 98.00,  stock: 5,  plazoEntregaHoras: 72 }, d2: { precioCoste: 61.00, precioPvp: 104.00, stock: 3,  plazoEntregaHoras: 48 }, d3: { precioCoste: 65.00, precioPvp: 112.00, stock: 10, plazoEntregaHoras: 24 } },
  };

  for (const part of createdParts) {
    const p = pricing[part.referenciaOem];
    if (!p) continue;
    await prisma.distributorPart.createMany({
      data: [
        { distributorId: dist1.id, partId: part.id, referenciaProveedor: `G-${part.referenciaOem}`, ...p.d1 },
        { distributorId: dist2.id, partId: part.id, referenciaProveedor: `I-${part.referenciaOem}`, ...p.d2 },
        { distributorId: dist3.id, partId: part.id, referenciaProveedor: `N-${part.referenciaOem}`, ...p.d3 },
      ],
    });
  }
  // ─────────────────────────────────────────────────────────────────────────

  console.log("✅ Seed completado:");
  console.log(`   - ${await prisma.garage.count()} talleres`);
  console.log(`   - ${await prisma.garageService.count()} servicios`);
  console.log(`   - ${await prisma.user.count()} usuarios`);
  console.log("\n📋 Cuentas de prueba:");
  console.log("   Admin:    admin@gartify.es / admin123");
  console.log("   Cliente:  cliente@gartify.es / password123");
  console.log("   Taller 1: taller1@gartify.es / password123 (Madrid - Alcalá)");
  console.log("   Taller 2: taller2@gartify.es / password123 (Madrid - Castellana)");
  console.log("   Taller 3: taller3@gartify.es / password123 (Madrid - Vallecas)");
  console.log("   Taller 4: taller4@gartify.es / password123 (Barcelona - Eixample)");
  console.log("   Taller 5: taller5@gartify.es / password123 (Barcelona - Gràcia)");
  console.log("   Taller 6: taller6@gartify.es / password123 (Sant Feliu de Llobregat)");
  console.log("   Taller 7: taller7@gartify.es / password123 (Sant Feliu de Llobregat)");
}

main()
  .catch((e) => { console.error(e); process.exit(1); })
  .finally(async () => { await prisma.$disconnect(); });
