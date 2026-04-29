/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package G0;

import G0.f;
import G0.o;

public abstract class l {
    private static a a() {
        return new f.b();
    }

    public static a i(String string) {
        return l.a().g(string);
    }

    public static a j(byte[] byArray) {
        return l.a().f(byArray);
    }

    public abstract Integer b();

    public abstract long c();

    public abstract long d();

    public abstract o e();

    public abstract byte[] f();

    public abstract String g();

    public abstract long h();

    public static abstract class a {
        public abstract l a();

        public abstract a b(Integer var1);

        public abstract a c(long var1);

        public abstract a d(long var1);

        public abstract a e(o var1);

        abstract a f(byte[] var1);

        abstract a g(String var1);

        public abstract a h(long var1);
    }
}

