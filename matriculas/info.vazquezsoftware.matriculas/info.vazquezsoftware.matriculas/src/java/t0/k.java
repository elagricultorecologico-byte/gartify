/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package t0;

public final class k
extends Enum {
    public static final /* enum */ k g;
    public static final /* enum */ k h;
    public static final /* enum */ k i;
    public static final /* enum */ k j;
    public static final /* enum */ k k;
    public static final /* enum */ k l;
    private static final k[] m;

    static {
        k k2;
        k k3;
        k k4;
        k k5;
        k k6;
        k k7;
        g = k7 = new k("NOT_REQUIRED", 0);
        h = k6 = new k("CONNECTED", 1);
        i = k5 = new k("UNMETERED", 2);
        j = k4 = new k("NOT_ROAMING", 3);
        k = k3 = new k("METERED", 4);
        l = k2 = new k("TEMPORARILY_UNMETERED", 5);
        m = new k[]{k7, k6, k5, k4, k3, k2};
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private k() {
        void var2_-1;
        void var1_-1;
    }

    public static k valueOf(String string) {
        return (k)Enum.valueOf(k.class, (String)string);
    }

    public static k[] values() {
        return (k[])m.clone();
    }
}

