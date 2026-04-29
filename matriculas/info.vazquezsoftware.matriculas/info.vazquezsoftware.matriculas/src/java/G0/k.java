/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package G0;

import G0.e;

public abstract class k {
    public static a a() {
        return new e.b();
    }

    public abstract G0.a b();

    public abstract b c();

    public static abstract class a {
        public abstract k a();

        public abstract a b(G0.a var1);

        public abstract a c(b var1);
    }

    public static final class b
    extends Enum {
        public static final /* enum */ b h;
        public static final /* enum */ b i;
        private static final b[] j;
        private final int g;

        static {
            b b2;
            b b3;
            h = b3 = new b("UNKNOWN", 0, 0);
            i = b2 = new b("ANDROID_FIREBASE", 1, 23);
            j = new b[]{b3, b2};
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private b() {
            void var3_2;
            void var2_-1;
            void var1_-1;
            this.g = var3_2;
        }

        public static b valueOf(String string) {
            return (b)Enum.valueOf(b.class, (String)string);
        }

        public static b[] values() {
            return (b[])j.clone();
        }
    }
}

