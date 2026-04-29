/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.StringBuilder
 */
package Y2;

import V2.k;
import Y2.a;
import Y2.c;
import Y2.e;

abstract class f
extends e {
    public static int b(int n3, int n4) {
        if (n3 < n4) {
            return n4;
        }
        return n3;
    }

    public static int c(int n3, int n4) {
        if (n3 > n4) {
            return n4;
        }
        return n3;
    }

    public static long d(long l3, long l4) {
        if (l3 > l4) {
            return l4;
        }
        return l3;
    }

    public static int e(int n3, int n4, int n5) {
        if (n4 <= n5) {
            if (n3 < n4) {
                return n4;
            }
            if (n3 > n5) {
                return n5;
            }
            return n3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot coerce value to an empty range: maximum ");
        stringBuilder.append(n5);
        stringBuilder.append(" is less than minimum ");
        stringBuilder.append(n4);
        stringBuilder.append('.');
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static a f(int n3, int n4) {
        return a.j.a(n3, n4, -1);
    }

    public static a g(a a3, int n3) {
        k.e(a3, "<this>");
        boolean bl = n3 > 0;
        e.a(bl, (Number)Integer.valueOf((int)n3));
        a.a a4 = a.j;
        int n4 = a3.c();
        int n5 = a3.f();
        if (a3.h() <= 0) {
            n3 = -n3;
        }
        return a4.a(n4, n5, n3);
    }

    public static c h(int n3, int n4) {
        if (n4 <= Integer.MIN_VALUE) {
            return c.k.a();
        }
        return new c(n3, n4 - 1);
    }
}

