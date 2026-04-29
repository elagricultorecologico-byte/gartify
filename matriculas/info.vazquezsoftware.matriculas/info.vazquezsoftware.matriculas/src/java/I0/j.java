/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  R0.a
 *  android.content.Context
 *  java.lang.Object
 */
package I0;

import I0.i;
import J0.b;
import R0.a;
import android.content.Context;

public final class j
implements b {
    private final G2.a a;
    private final G2.a b;
    private final G2.a c;

    public j(G2.a a2, G2.a a3, G2.a a4) {
        this.a = a2;
        this.b = a3;
        this.c = a4;
    }

    public static j a(G2.a a2, G2.a a3, G2.a a4) {
        return new j(a2, a3, a4);
    }

    public static i c(Context context, a a2, a a3) {
        return new i(context, a2, a3);
    }

    public i b() {
        return j.c((Context)this.a.get(), (a)this.b.get(), (a)this.c.get());
    }
}

