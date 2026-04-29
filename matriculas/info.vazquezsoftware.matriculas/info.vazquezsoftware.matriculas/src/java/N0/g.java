/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package N0;

import J0.b;
import J0.d;
import N0.f;
import R0.a;

public final class g
implements b {
    private final G2.a a;

    public g(G2.a a2) {
        this.a = a2;
    }

    public static O0.f a(a a2) {
        return (O0.f)d.c(f.a(a2), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g b(G2.a a2) {
        return new g(a2);
    }

    public O0.f c() {
        return g.a((a)this.a.get());
    }
}

