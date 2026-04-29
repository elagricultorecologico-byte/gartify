/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package P0;

import J0.b;
import J0.d;
import P0.f;

public final class g
implements b {
    public static g a() {
        return a.a;
    }

    public static String b() {
        return (String)d.c(f.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public String c() {
        return g.b();
    }

    private static final abstract class a {
        private static final g a = new g();
    }
}

