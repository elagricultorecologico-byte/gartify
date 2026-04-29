/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 */
package P2;

public abstract class c {
    private static final int a(int n2, int n3, int n4) {
        return c.c(c.c(n2, n4) - c.c(n3, n4), n4);
    }

    public static final int b(int n2, int n3, int n4) {
        block7: {
            block8: {
                block6: {
                    block5: {
                        if (n4 <= 0) break block5;
                        if (n2 < n3) {
                            return n3 - c.a(n3, n2, n4);
                        }
                        break block6;
                    }
                    if (n4 >= 0) break block7;
                    if (n2 > n3) break block8;
                }
                return n3;
            }
            return n3 + c.a(n2, n3, -n4);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final int c(int n2, int n3) {
        if ((n2 %= n3) >= 0) {
            return n2;
        }
        return n2 + n3;
    }
}

