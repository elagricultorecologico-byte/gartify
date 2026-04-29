/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
package P0;

import G2.a;
import J0.b;
import J0.d;
import P0.f;
import android.content.Context;

public final class h
implements b {
    private final a a;

    public h(a a2) {
        this.a = a2;
    }

    public static h a(a a2) {
        return new h(a2);
    }

    public static String c(Context context) {
        return (String)d.c(f.b(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    public String b() {
        return h.c((Context)this.a.get());
    }
}

