/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 */
package f1;

public final class u
extends Enum {
    public static final /* enum */ u g;
    public static final /* enum */ u h;
    public static final /* enum */ u i;
    public static final /* enum */ u j;
    private static final u[] k;

    static {
        u u2;
        u u3;
        u u4;
        u u5;
        g = u5 = new u("SUCCESS", 0);
        h = u4 = new u("PERMANENT_FAILURE", 1);
        i = u3 = new u("RETRIABLE_FAILURE", 2);
        j = u2 = new u("BUFFERED", 3);
        k = new u[]{u5, u4, u3, u2};
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private u() {
        void var2_-1;
        void var1_-1;
    }

    public static u[] values() {
        return (u[])k.clone();
    }
}

