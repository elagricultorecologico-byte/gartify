/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  z3.u
 */
package A3;

import V2.k;
import z3.u;

public abstract class c {
    public static final int a(int[] nArray, int n2, int n3, int n4) {
        k.e(nArray, "<this>");
        --n4;
        while (n3 <= n4) {
            int n5 = n3 + n4 >>> 1;
            int n6 = nArray[n5];
            if (n6 < n2) {
                n3 = n5 + 1;
                continue;
            }
            if (n6 > n2) {
                n4 = n5 - 1;
                continue;
            }
            return n5;
        }
        return -n3 - 1;
    }

    public static final int b(u u2, int n2) {
        k.e(u2, "<this>");
        n2 = c.a(u2.z(), n2 + 1, 0, u2.A().length);
        if (n2 >= 0) {
            return n2;
        }
        return ~n2;
    }
}

