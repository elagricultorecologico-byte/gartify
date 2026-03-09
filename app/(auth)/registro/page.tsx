"use client";
import { useState } from "react";
import { useRouter, useSearchParams } from "next/navigation";
import { signIn } from "next-auth/react";
import Link from "next/link";
import { Wrench, User, Building2 } from "lucide-react";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Card, CardContent, CardHeader, CardTitle, CardDescription } from "@/components/ui/card";
import { Tabs, TabsList, TabsTrigger, TabsContent } from "@/components/ui/tabs";
import { Textarea } from "@/components/ui/textarea";

export default function RegistroPage() {
  const router = useRouter();
  const searchParams = useSearchParams();
  const defaultTab = searchParams.get("tipo") === "taller" ? "taller" : "cliente";
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  async function handleCliente(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setError("");
    setLoading(true);
    const fd = new FormData(e.currentTarget);
    const body = { name: fd.get("name"), email: fd.get("email"), password: fd.get("password"), phone: fd.get("phone") };

    const res = await fetch("/api/register", { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify(body) });
    const data = await res.json();

    if (!res.ok) { setError(data.error); setLoading(false); return; }

    await signIn("credentials", { email: body.email, password: body.password, redirect: false });
    router.push("/cuenta");
    router.refresh();
  }

  async function handleTaller(e: React.FormEvent<HTMLFormElement>) {
    e.preventDefault();
    setError("");
    setLoading(true);
    const fd = new FormData(e.currentTarget);
    const body = {
      ownerName: fd.get("ownerName"), email: fd.get("email"), password: fd.get("password"),
      phone: fd.get("phone"), garageName: fd.get("garageName"), address: fd.get("address"),
      city: fd.get("city"), postalCode: fd.get("postalCode"), description: fd.get("description"),
    };

    const res = await fetch("/api/garage/register", { method: "POST", headers: { "Content-Type": "application/json" }, body: JSON.stringify(body) });
    const data = await res.json();

    if (!res.ok) { setError(data.error); setLoading(false); return; }

    await signIn("credentials", { email: body.email, password: body.password, redirect: false });
    router.push("/cuenta/taller");
    router.refresh();
  }

  return (
    <div className="min-h-[calc(100vh-4rem)] flex items-center justify-center py-12 px-4">
      <Card className="w-full max-w-lg">
        <CardHeader className="text-center">
          <div className="mx-auto mb-4 flex h-12 w-12 items-center justify-center rounded-xl bg-gartify-orange">
            <Wrench className="h-6 w-6 text-white" />
          </div>
          <CardTitle className="text-2xl">Crear cuenta</CardTitle>
          <CardDescription>Elige tu tipo de cuenta</CardDescription>
        </CardHeader>
        <CardContent>
          <Tabs defaultValue={defaultTab}>
            <TabsList className="w-full mb-6">
              <TabsTrigger value="cliente" className="flex-1 gap-2"><User className="h-4 w-4" />Cliente</TabsTrigger>
              <TabsTrigger value="taller" className="flex-1 gap-2"><Building2 className="h-4 w-4" />Taller</TabsTrigger>
            </TabsList>

            {/* Cliente */}
            <TabsContent value="cliente">
              <form onSubmit={handleCliente} className="space-y-4">
                <div className="grid grid-cols-2 gap-3">
                  <div className="space-y-1.5">
                    <Label htmlFor="name">Nombre completo</Label>
                    <Input id="name" name="name" placeholder="Juan García" required />
                  </div>
                  <div className="space-y-1.5">
                    <Label htmlFor="phone">Teléfono</Label>
                    <Input id="phone" name="phone" placeholder="600 000 000" />
                  </div>
                </div>
                <div className="space-y-1.5">
                  <Label htmlFor="email">Email</Label>
                  <Input id="email" name="email" type="email" placeholder="tu@email.es" required />
                </div>
                <div className="space-y-1.5">
                  <Label htmlFor="password">Contraseña</Label>
                  <Input id="password" name="password" type="password" placeholder="Mínimo 6 caracteres" required minLength={6} />
                </div>
                {error && <p className="text-sm text-red-400">{error}</p>}
                <Button type="submit" className="w-full" disabled={loading}>
                  {loading ? "Creando cuenta..." : "Crear cuenta"}
                </Button>
              </form>
            </TabsContent>

            {/* Taller */}
            <TabsContent value="taller">
              <form onSubmit={handleTaller} className="space-y-4">
                <div className="grid grid-cols-2 gap-3">
                  <div className="space-y-1.5">
                    <Label htmlFor="ownerName">Tu nombre</Label>
                    <Input id="ownerName" name="ownerName" placeholder="Carlos Martínez" required />
                  </div>
                  <div className="space-y-1.5">
                    <Label htmlFor="tphone">Teléfono</Label>
                    <Input id="tphone" name="phone" placeholder="91 000 00 00" required />
                  </div>
                </div>
                <div className="space-y-1.5">
                  <Label htmlFor="garageName">Nombre del taller</Label>
                  <Input id="garageName" name="garageName" placeholder="Taller Martínez Auto" required />
                </div>
                <div className="grid grid-cols-3 gap-3">
                  <div className="col-span-2 space-y-1.5">
                    <Label htmlFor="address">Dirección</Label>
                    <Input id="address" name="address" placeholder="Calle Alcalá, 142" required />
                  </div>
                  <div className="space-y-1.5">
                    <Label htmlFor="postalCode">CP</Label>
                    <Input id="postalCode" name="postalCode" placeholder="28009" required maxLength={5} />
                  </div>
                </div>
                <div className="space-y-1.5">
                  <Label htmlFor="city">Ciudad</Label>
                  <Input id="city" name="city" placeholder="Madrid" required />
                </div>
                <div className="space-y-1.5">
                  <Label htmlFor="description">Descripción (opcional)</Label>
                  <Textarea id="description" name="description" placeholder="Especialistas en ITV y revisiones..." rows={2} />
                </div>
                <div className="space-y-1.5">
                  <Label htmlFor="temail">Email</Label>
                  <Input id="temail" name="email" type="email" placeholder="taller@email.es" required />
                </div>
                <div className="space-y-1.5">
                  <Label htmlFor="tpassword">Contraseña</Label>
                  <Input id="tpassword" name="password" type="password" placeholder="Mínimo 6 caracteres" required minLength={6} />
                </div>
                {error && <p className="text-sm text-red-400">{error}</p>}
                <Button type="submit" className="w-full" disabled={loading}>
                  {loading ? "Registrando taller..." : "Registrar mi taller"}
                </Button>
              </form>
            </TabsContent>
          </Tabs>

          <p className="mt-4 text-center text-sm text-muted-foreground">
            ¿Ya tienes cuenta?{" "}
            <Link href="/login" className="text-gartify-orange hover:underline">Inicia sesión</Link>
          </p>
        </CardContent>
      </Card>
    </div>
  );
}
