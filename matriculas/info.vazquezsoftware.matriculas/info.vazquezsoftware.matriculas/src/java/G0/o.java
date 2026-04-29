/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package G0;

import G0.i;
import android.util.SparseArray;

public abstract class o {
    public static a a() {
        return new i.b();
    }

    public abstract b b();

    public abstract c c();

    public static abstract class a {
        public abstract o a();

        public abstract a b(b var1);

        public abstract a c(c var1);
    }

    public static final class b
    extends Enum {
        public static final /* enum */ b A;
        public static final /* enum */ b B;
        private static final SparseArray C;
        private static final b[] D;
        public static final /* enum */ b h;
        public static final /* enum */ b i;
        public static final /* enum */ b j;
        public static final /* enum */ b k;
        public static final /* enum */ b l;
        public static final /* enum */ b m;
        public static final /* enum */ b n;
        public static final /* enum */ b o;
        public static final /* enum */ b p;
        public static final /* enum */ b q;
        public static final /* enum */ b r;
        public static final /* enum */ b s;
        public static final /* enum */ b t;
        public static final /* enum */ b u;
        public static final /* enum */ b v;
        public static final /* enum */ b w;
        public static final /* enum */ b x;
        public static final /* enum */ b y;
        public static final /* enum */ b z;
        private final int g;

        static {
            b b2;
            b b3;
            b b4;
            b b5;
            b b6;
            b b7;
            b b8;
            b b9;
            b b10;
            b b11;
            b b12;
            b b13;
            b b14;
            b b15;
            b b16;
            b b17;
            b b18;
            b b19;
            b b20;
            b b21;
            b b22;
            h = b22 = new b("UNKNOWN_MOBILE_SUBTYPE", 0, 0);
            i = b21 = new b("GPRS", 1, 1);
            j = b20 = new b("EDGE", 2, 2);
            k = b19 = new b("UMTS", 3, 3);
            l = b18 = new b("CDMA", 4, 4);
            m = b17 = new b("EVDO_0", 5, 5);
            n = b16 = new b("EVDO_A", 6, 6);
            o = b15 = new b("RTT", 7, 7);
            p = b14 = new b("HSDPA", 8, 8);
            q = b13 = new b("HSUPA", 9, 9);
            r = b12 = new b("HSPA", 10, 10);
            s = b11 = new b("IDEN", 11, 11);
            t = b10 = new b("EVDO_B", 12, 12);
            u = b9 = new b("LTE", 13, 13);
            v = b8 = new b("EHRPD", 14, 14);
            w = b7 = new b("HSPAP", 15, 15);
            x = b6 = new b("GSM", 16, 16);
            y = b5 = new b("TD_SCDMA", 17, 17);
            z = b4 = new b("IWLAN", 18, 18);
            A = b3 = new b("LTE_CA", 19, 19);
            B = b2 = new b("COMBINED", 20, 100);
            D = new b[]{b22, b21, b20, b19, b18, b17, b16, b15, b14, b13, b12, b11, b10, b9, b8, b7, b6, b5, b4, b3, b2};
            b2 = new SparseArray();
            C = b2;
            b2.put(0, (Object)b22);
            b2.put(1, (Object)b21);
            b2.put(2, (Object)b20);
            b2.put(3, (Object)b19);
            b2.put(4, (Object)b18);
            b2.put(5, (Object)b17);
            b2.put(6, (Object)b16);
            b2.put(7, (Object)b15);
            b2.put(8, (Object)b14);
            b2.put(9, (Object)b13);
            b2.put(10, (Object)b12);
            b2.put(11, (Object)b11);
            b2.put(12, (Object)b10);
            b2.put(13, (Object)b9);
            b2.put(14, (Object)b8);
            b2.put(15, (Object)b7);
            b2.put(16, (Object)b6);
            b2.put(17, (Object)b5);
            b2.put(18, (Object)b4);
            b2.put(19, (Object)b3);
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

        public static b d(int n2) {
            return (b)((Object)C.get(n2));
        }

        public static b valueOf(String string) {
            return (b)Enum.valueOf(b.class, (String)string);
        }

        public static b[] values() {
            return (b[])D.clone();
        }

        public int e() {
            return this.g;
        }
    }

    public static final class c
    extends Enum {
        private static final SparseArray A;
        private static final c[] B;
        public static final /* enum */ c h;
        public static final /* enum */ c i;
        public static final /* enum */ c j;
        public static final /* enum */ c k;
        public static final /* enum */ c l;
        public static final /* enum */ c m;
        public static final /* enum */ c n;
        public static final /* enum */ c o;
        public static final /* enum */ c p;
        public static final /* enum */ c q;
        public static final /* enum */ c r;
        public static final /* enum */ c s;
        public static final /* enum */ c t;
        public static final /* enum */ c u;
        public static final /* enum */ c v;
        public static final /* enum */ c w;
        public static final /* enum */ c x;
        public static final /* enum */ c y;
        public static final /* enum */ c z;
        private final int g;

        static {
            SparseArray sparseArray;
            c c2;
            c c3;
            c c4;
            c c5;
            c c6;
            c c7;
            c c8;
            c c9;
            c c10;
            c c11;
            c c12;
            c c13;
            c c14;
            c c15;
            c c16;
            c c17;
            c c18;
            c c19;
            c c20;
            h = c20 = new c("MOBILE", 0, 0);
            i = c19 = new c("WIFI", 1, 1);
            j = c18 = new c("MOBILE_MMS", 2, 2);
            k = c17 = new c("MOBILE_SUPL", 3, 3);
            l = c16 = new c("MOBILE_DUN", 4, 4);
            m = c15 = new c("MOBILE_HIPRI", 5, 5);
            n = c14 = new c("WIMAX", 6, 6);
            o = c13 = new c("BLUETOOTH", 7, 7);
            p = c12 = new c("DUMMY", 8, 8);
            q = c11 = new c("ETHERNET", 9, 9);
            r = c10 = new c("MOBILE_FOTA", 10, 10);
            s = c9 = new c("MOBILE_IMS", 11, 11);
            t = c8 = new c("MOBILE_CBS", 12, 12);
            u = c7 = new c("WIFI_P2P", 13, 13);
            v = c6 = new c("MOBILE_IA", 14, 14);
            w = c5 = new c("MOBILE_EMERGENCY", 15, 15);
            x = c4 = new c("PROXY", 16, 16);
            y = c3 = new c("VPN", 17, 17);
            z = c2 = new c("NONE", 18, -1);
            B = new c[]{c20, c19, c18, c17, c16, c15, c14, c13, c12, c11, c10, c9, c8, c7, c6, c5, c4, c3, c2};
            A = sparseArray = new SparseArray();
            sparseArray.put(0, (Object)c20);
            sparseArray.put(1, (Object)c19);
            sparseArray.put(2, (Object)c18);
            sparseArray.put(3, (Object)c17);
            sparseArray.put(4, (Object)c16);
            sparseArray.put(5, (Object)c15);
            sparseArray.put(6, (Object)c14);
            sparseArray.put(7, (Object)c13);
            sparseArray.put(8, (Object)c12);
            sparseArray.put(9, (Object)c11);
            sparseArray.put(10, (Object)c10);
            sparseArray.put(11, (Object)c9);
            sparseArray.put(12, (Object)c8);
            sparseArray.put(13, (Object)c7);
            sparseArray.put(14, (Object)c6);
            sparseArray.put(15, (Object)c5);
            sparseArray.put(16, (Object)c4);
            sparseArray.put(17, (Object)c3);
            sparseArray.put(-1, (Object)c2);
        }

        /*
         * WARNING - Possible parameter corruption
         * WARNING - void declaration
         */
        private c() {
            void var3_2;
            void var2_-1;
            void var1_-1;
            this.g = var3_2;
        }

        public static c d(int n2) {
            return (c)((Object)A.get(n2));
        }

        public static c valueOf(String string) {
            return (c)Enum.valueOf(c.class, (String)string);
        }

        public static c[] values() {
            return (c[])B.clone();
        }

        public int e() {
            return this.g;
        }
    }
}

