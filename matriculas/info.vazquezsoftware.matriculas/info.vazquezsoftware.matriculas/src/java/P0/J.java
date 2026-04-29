/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package P0;

import J0.b;
import J0.d;
import P0.e;
import P0.f;

public final class j
implements b {
    public static j a() {
        return a.a;
    }

    public static e c() {
        return (e)d.c(f.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public e b() {
        return j.c();
    }

    private static final abstract class a {
        private static final j a = new j();
    }
}

