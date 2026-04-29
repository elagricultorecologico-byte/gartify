/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package z3;

import V2.k;
import z3.B;
import z3.e;

public abstract class A {
    private static final byte[] a;
    private static final byte[] b;

    static {
        e.a a2 = e.j;
        a = a2.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").h();
        b = a2.c("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").h();
    }

    public static final String a(byte[] byArray, byte[] byArray2) {
        int n2;
        k.e(byArray, "<this>");
        k.e(byArray2, "map");
        byte[] byArray3 = new byte[(byArray.length + 2) / 3 * 4];
        int n3 = byArray.length - byArray.length % 3;
        int n4 = 0;
        int n5 = 0;
        while ((n2 = n4) < n3) {
            byte by = byArray[n2];
            byte by2 = byArray[n2 + 1];
            n4 = n2 + 3;
            byte by3 = byArray[n2 + 2];
            byArray3[n5] = byArray2[(by & 0xFF) >> 2];
            byArray3[n5 + 1] = byArray2[(by & 3) << 4 | (by2 & 0xFF) >> 4];
            byArray3[n5 + 2] = byArray2[(by2 & 0xF) << 2 | (by3 & 0xFF) >> 6];
            n2 = n5 + 4;
            byArray3[n5 + 3] = byArray2[by3 & 0x3F];
            n5 = n2;
        }
        n4 = byArray.length - n3;
        if (n4 != 1) {
            if (n4 == 2) {
                n4 = byArray[n2];
                n2 = byArray[n2 + 1];
                byArray3[n5] = byArray2[(n4 & 0xFF) >> 2];
                byArray3[n5 + 1] = byArray2[(n4 & 3) << 4 | (n2 & 0xFF) >> 4];
                byArray3[n5 + 2] = byArray2[(n2 & 0xF) << 2];
                byArray3[n5 + 3] = (byte)61;
            }
        } else {
            byte by;
            n4 = byArray[n2];
            byArray3[n5] = byArray2[(n4 & 0xFF) >> 2];
            byArray3[n5 + 1] = byArray2[(n4 & 3) << 4];
            byArray3[n5 + 2] = by = (byte)61;
            byArray3[n5 + 3] = by;
        }
        return B.b(byArray3);
    }

    public static /* synthetic */ String b(byte[] byArray, byte[] byArray2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            byArray2 = a;
        }
        return A.a(byArray, byArray2);
    }
}

