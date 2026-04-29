/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package t0;

public final class d
extends Enum {
    public static final /* enum */ d g;
    public static final /* enum */ d h;
    public static final /* enum */ d i;
    public static final /* enum */ d j;
    private static final d[] k;

    static {
        d d3;
        d d4;
        d d5;
        d d6;
        g = d6 = new d("REPLACE", 0);
        h = d5 = new d("KEEP", 1);
        i = d4 = new d("APPEND", 2);
        j = d3 = new d("APPEND_OR_REPLACE", 3);
        k = new d[]{d6, d5, d4, d3};
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private d() {
        void var2_-1;
        void var1_-1;
    }

    public static d valueOf(String string) {
        return (d)Enum.valueOf(d.class, (String)string);
    }

    public static d[] values() {
        return (d[])k.clone();
    }
}

