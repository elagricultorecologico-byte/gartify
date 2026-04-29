/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package I0;

import I0.b;

public abstract class g {
    public static g a() {
        return new b(a.i, -1L);
    }

    public static g d() {
        return new b(a.j, -1L);
    }

    public static g e(long l2) {
        return new b(a.g, l2);
    }

    public static g f() {
        return new b(a.h, -1L);
    }

    public abstract long b();

    public abstract a c();

    public static final class a
    extends Enum {
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        public static final /* enum */ a j;
        private static final a[] k;

        static {
            a a2;
            a a3;
            a a4;
            a a5;
            g = a5 = new a("OK", 0);
            h = a4 = new a("TRANSIENT_ERROR", 1);
            i = a3 = new a("FATAL_ERROR", 2);
            j = a2 = new a("INVALID_PAYLOAD", 3);
            k = new a[]{a5, a4, a3, a2};
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private a() {
            void var2_-1;
            void var1_-1;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf(a.class, (String)string);
        }

        public static a[] values() {
            return (a[])k.clone();
        }
    }
}

