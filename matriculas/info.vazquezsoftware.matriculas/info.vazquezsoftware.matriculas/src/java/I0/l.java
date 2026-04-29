/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
package I0;

import G2.a;
import I0.i;
import I0.k;
import J0.b;
import android.content.Context;

public final class l
implements b {
    private final a a;
    private final a b;

    public l(a a2, a a3) {
        this.a = a2;
        this.b = a3;
    }

    public static l a(a a2, a a3) {
        return new l(a2, a3);
    }

    public static k c(Context context, Object object) {
        return new k(context, (i)object);
    }

    public k b() {
        return l.c((Context)this.a.get(), this.b.get());
    }
}

