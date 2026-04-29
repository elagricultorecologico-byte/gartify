/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package t0;

public final class s
extends Enum {
    public static final /* enum */ s g;
    public static final /* enum */ s h;
    public static final /* enum */ s i;
    public static final /* enum */ s j;
    public static final /* enum */ s k;
    public static final /* enum */ s l;
    private static final s[] m;

    static {
        s s2;
        s s3;
        s s4;
        s s5;
        s s6;
        s s7;
        g = s7 = new s("ENQUEUED", 0);
        h = s6 = new s("RUNNING", 1);
        i = s5 = new s("SUCCEEDED", 2);
        j = s4 = new s("FAILED", 3);
        k = s3 = new s("BLOCKED", 4);
        l = s2 = new s("CANCELLED", 5);
        m = new s[]{s7, s6, s5, s4, s3, s2};
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private s() {
        void var2_-1;
        void var1_-1;
    }

    public static s valueOf(String string) {
        return (s)Enum.valueOf(s.class, (String)string);
    }

    public static s[] values() {
        return (s[])m.clone();
    }

    public boolean d() {
        return this == i || this == j || this == l;
        {
        }
    }
}

