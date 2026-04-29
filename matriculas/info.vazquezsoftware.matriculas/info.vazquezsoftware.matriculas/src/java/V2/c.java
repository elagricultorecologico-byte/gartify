/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package V2;

import V2.t;
import java.io.Serializable;

public abstract class c
implements Z2.a,
Serializable {
    public static final Object m = a.a();
    private transient Z2.a g;
    protected final Object h;
    private final Class i;
    private final String j;
    private final String k;
    private final boolean l;

    protected c(Object object, Class clazz, String string, String string2, boolean bl) {
        this.h = object;
        this.i = clazz;
        this.j = string;
        this.k = string2;
        this.l = bl;
    }

    public Z2.a b() {
        Z2.a a3;
        Z2.a a4 = a3 = this.g;
        if (a3 == null) {
            this.g = a4 = this.c();
        }
        return a4;
    }

    protected abstract Z2.a c();

    public Object e() {
        return this.h;
    }

    public String f() {
        return this.j;
    }

    public Z2.c i() {
        Class clazz = this.i;
        if (clazz == null) {
            return null;
        }
        if (this.l) {
            return t.c(clazz);
        }
        return t.b(clazz);
    }

    public String k() {
        return this.k;
    }

    private static class a
    implements Serializable {
        private static final a g = new a();

        private a() {
        }

        static /* synthetic */ a a() {
            return g;
        }
    }
}

