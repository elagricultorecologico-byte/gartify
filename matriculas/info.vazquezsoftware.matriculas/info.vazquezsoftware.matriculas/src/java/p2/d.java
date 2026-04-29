/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package p2;

public @interface d {
    public a intEncoding() default a.g;

    public int tag();

    public static final class a
    extends Enum {
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        private static final a[] j;

        static {
            a a2;
            a a3;
            a a4;
            g = a4 = new a("DEFAULT", 0);
            h = a3 = new a("SIGNED", 1);
            i = a2 = new a("FIXED", 2);
            j = new a[]{a4, a3, a2};
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
            return (a[])j.clone();
        }
    }
}

