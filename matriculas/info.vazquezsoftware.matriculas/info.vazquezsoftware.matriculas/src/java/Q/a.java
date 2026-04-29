/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package q;

import V2.k;

public abstract class a {
    public static final int[] a = new int[0];
    public static final long[] b = new long[0];
    public static final Object[] c = new Object[0];

    public static final int a(int[] nArray, int n2, int n3) {
        k.e(nArray, "array");
        --n2;
        int n4 = 0;
        while (n4 <= n2) {
            int n5 = n4 + n2 >>> 1;
            int n6 = nArray[n5];
            if (n6 < n3) {
                n4 = n5 + 1;
                continue;
            }
            if (n6 > n3) {
                n2 = n5 - 1;
                continue;
            }
            return n5;
        }
        return ~n4;
    }

    public static final int b(long[] lArray, int n2, long l2) {
        k.e(lArray, "array");
        --n2;
        int n3 = 0;
        while (n3 <= n2) {
            int n4 = n3 + n2 >>> 1;
            long l3 = lArray[n4] - l2;
            long l4 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
            if (l4 < 0) {
                n3 = n4 + 1;
                continue;
            }
            if (l4 > 0) {
                n2 = n4 - 1;
                continue;
            }
            return n4;
        }
        return ~n3;
    }

    public static final boolean c(Object object, Object object2) {
        return k.a(object, object2);
    }

    public static final int d(int n2) {
        for (int i2 = 4; i2 < 32; ++i2) {
            int n3 = (1 << i2) - 12;
            if (n2 > n3) continue;
            return n3;
        }
        return n2;
    }

    public static final int e(int n2) {
        return q.a.d(n2 * 4) / 4;
    }

    public static final int f(int n2) {
        return q.a.d(n2 * 8) / 8;
    }
}

