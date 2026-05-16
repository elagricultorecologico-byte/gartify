import { redirect } from "next/navigation";

export default function LoginPage({
  searchParams,
}: {
  searchParams: { callbackUrl?: string };
}) {
  const qs = searchParams.callbackUrl
    ? `?callbackUrl=${encodeURIComponent(searchParams.callbackUrl)}`
    : "";
  redirect(`/login/conductor${qs}`);
}
