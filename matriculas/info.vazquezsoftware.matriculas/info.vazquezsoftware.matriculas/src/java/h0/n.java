/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package H0;

import F0.b;
import F0.c;
import F0.e;
import H0.c;
import H0.o;

abstract class n {
    n() {
    }

    public static a a() {
        return new c.b();
    }

    public abstract b b();

    abstract c c();

    public byte[] d() {
        return (byte[])this.e().apply(this.c().b());
    }

    abstract e e();

    public abstract o f();

    public abstract String g();

    public static abstract class a {
        public abstract n a();

        abstract a b(b var1);

        abstract a c(c var1);

        abstract a d(e var1);

        public abstract a e(o var1);

        public abstract a f(String var1);
    }
}

