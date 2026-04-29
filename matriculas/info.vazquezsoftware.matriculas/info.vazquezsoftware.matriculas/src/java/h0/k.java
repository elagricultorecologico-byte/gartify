/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  J0.d
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.Executor
 */
package H0;

import H0.j;
import J0.b;
import J0.d;
import java.util.concurrent.Executor;

public final class k
implements b {
    public static k a() {
        return a.a;
    }

    public static Executor b() {
        return (Executor)d.c((Object)j.a(), (String)"Cannot return null from a non-@Nullable @Provides method");
    }

    public Executor c() {
        return k.b();
    }

    private static final abstract class a {
        private static final k a = new k();
    }
}

