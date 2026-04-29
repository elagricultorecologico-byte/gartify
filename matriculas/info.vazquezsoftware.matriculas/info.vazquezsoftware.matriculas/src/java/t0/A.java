/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package t0;

public final class a
extends Enum {
    public static final /* enum */ a g;
    public static final /* enum */ a h;
    private static final a[] i;

    static {
        a a2;
        a a3;
        g = a3 = new a("EXPONENTIAL", 0);
        h = a2 = new a("LINEAR", 1);
        i = new a[]{a3, a2};
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
        return (a[])i.clone();
    }
}

