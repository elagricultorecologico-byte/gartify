import { SidebarConductor } from "@/components/cuenta/SidebarConductor";

export function ConductorShell({ children }: { children: React.ReactNode }) {
  return (
    <div className="flex min-h-[calc(100vh-4rem)]">
      <SidebarConductor />
      <div className="flex-1 min-w-0 overflow-x-hidden">
        {children}
      </div>
    </div>
  );
}
