/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package t0;

public final class n
extends Enum {
    public static final /* enum */ n g;
    public static final /* enum */ n h;
    private static final n[] i;

    static {
        n n2;
        n n3;
        g = n3 = new n("RUN_AS_NON_EXPEDITED_WORK_REQUEST", 0);
        h = n2 = new n("DROP_WORK_REQUEST", 1);
        i = new n[]{n3, n2};
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private n() {
        void var2_-1;
        void var1_-1;
    }

    public static n valueOf(String string) {
        return (n)Enum.valueOf(n.class, (String)string);
    }

    public static n[] values() {
        return (n[])i.clone();
    }
}

