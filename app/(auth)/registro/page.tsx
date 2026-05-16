import { redirect } from "next/navigation";

export default function RegistroPage({
  searchParams,
}: {
  searchParams: { callbackUrl?: string };
}) {
  const qs = searchParams.callbackUrl
    ? `?callbackUrl=${encodeURIComponent(searchParams.callbackUrl)}`
    : "";
  redirect(`/registro/conductor${qs}`);
}
