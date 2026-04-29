/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package H3;

import F3.m;

public interface e {
    public a a(m var1, int var2);

    public a b(m var1, int var2);

    public static final class a
    extends Enum {
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        public static final /* enum */ a j;
        public static final /* enum */ a k;
        private static final a[] l;

        static {
            a a2;
            a a3;
            a a4;
            a a5;
            a a6;
            g = a6 = new a("CONTINUE", 0);
            h = a5 = new a("SKIP_CHILDREN", 1);
            i = a4 = new a("SKIP_ENTIRELY", 2);
            j = a3 = new a("REMOVE", 3);
            k = a2 = new a("STOP", 4);
            l = new a[]{a6, a5, a4, a3, a2};
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
            return (a[])l.clone();
        }
    }
}

