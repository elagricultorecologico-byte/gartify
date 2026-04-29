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

import android.util.SparseArray;

public final class p
extends Enum {
    public static final /* enum */ p h;
    public static final /* enum */ p i;
    public static final /* enum */ p j;
    public static final /* enum */ p k;
    public static final /* enum */ p l;
    public static final /* enum */ p m;
    private static final SparseArray n;
    private static final p[] o;
    private final int g;

    static {
        SparseArray sparseArray;
        p p2;
        p p3;
        p p4;
        p p5;
        p p6;
        p p7;
        h = p7 = new p("DEFAULT", 0, 0);
        i = p6 = new p("UNMETERED_ONLY", 1, 1);
        j = p5 = new p("UNMETERED_OR_DAILY", 2, 2);
        k = p4 = new p("FAST_IF_RADIO_AWAKE", 3, 3);
        l = p3 = new p("NEVER", 4, 4);
        m = p2 = new p("UNRECOGNIZED", 5, -1);
        o = new p[]{p7, p6, p5, p4, p3, p2};
        n = sparseArray = new SparseArray();
        sparseArray.put(0, (Object)p7);
        sparseArray.put(1, (Object)p6);
        sparseArray.put(2, (Object)p5);
        sparseArray.put(3, (Object)p4);
        sparseArray.put(4, (Object)p3);
        sparseArray.put(-1, (Object)p2);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private p() {
        void var3_2;
        void var2_-1;
        void var1_-1;
        this.g = var3_2;
    }

    public static p valueOf(String string) {
        return (p)Enum.valueOf(p.class, (String)string);
    }

    public static p[] values() {
        return (p[])o.clone();
    }
}

