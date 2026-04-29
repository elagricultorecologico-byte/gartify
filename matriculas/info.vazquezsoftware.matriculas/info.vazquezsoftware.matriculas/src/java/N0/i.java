/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
package N0;

import J0.b;
import N0.h;
import O0.f;
import O0.x;
import P0.d;
import R0.a;
import android.content.Context;

public final class i
implements b {
    private final G2.a a;
    private final G2.a b;
    private final G2.a c;
    private final G2.a d;

    public i(G2.a a2, G2.a a3, G2.a a4, G2.a a5) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
        this.d = a5;
    }

    public static i a(G2.a a2, G2.a a3, G2.a a4, G2.a a5) {
        return new i(a2, a3, a4, a5);
    }

    public static x c(Context context, d d2, f f2, a a2) {
        return (x)J0.d.c(h.a(context, d2, f2, a2), "Cannot return null from a non-@Nullable @Provides method");
    }

    public x b() {
        return i.c((Context)this.a.get(), (d)this.b.get(), (f)this.c.get(), (a)this.d.get());
    }
}

