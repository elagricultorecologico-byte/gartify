/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 */
package b3;

import V2.k;
import b3.b;
import b3.q;

abstract class r
extends q {
    public static Integer m(String string) {
        k.e(string, "<this>");
        return r.n(string, 10);
    }

    public static final Integer n(String string, int n3) {
        k.e(string, "<this>");
        b.a(n3);
        int n4 = string.length();
        if (n4 == 0) {
            return null;
        }
        int n5 = 0;
        char c3 = string.charAt(0);
        int n6 = k.f(c3, 48);
        int n7 = -2147483647;
        if (n6 < 0) {
            n6 = 1;
            if (n4 == 1) {
                return null;
            }
            if (c3 != '+') {
                if (c3 != '-') {
                    return null;
                }
                n7 = Integer.MIN_VALUE;
                c3 = '\u0001';
            } else {
                c3 = '\u0000';
            }
        } else {
            c3 = '\u0000';
            n6 = 0;
        }
        int n8 = -59652323;
        for (int i3 = n6; i3 < n4; ++i3) {
            int n9;
            block14: {
                block15: {
                    n9 = b.b(string.charAt(i3), n3);
                    if (n9 < 0) {
                        return null;
                    }
                    n6 = n8;
                    if (n5 >= n8) break block14;
                    if (n8 != -59652323) break block15;
                    n6 = n8 = n7 / n3;
                    if (n5 >= n8) break block14;
                }
                return null;
            }
            if ((n8 = n5 * n3) < n7 + n9) {
                return null;
            }
            n5 = n8 - n9;
            n8 = n6;
        }
        if (c3 != '\u0000') {
            return n5;
        }
        return -n5;
    }

    public static Long o(String string) {
        k.e(string, "<this>");
        return r.p(string, 10);
    }

    public static final Long p(String string, int n3) {
        k.e(string, "<this>");
        b.a(n3);
        int n4 = string.length();
        Long l3 = null;
        if (n4 == 0) {
            return null;
        }
        int n5 = 0;
        int n6 = string.charAt(0);
        int n7 = k.f(n6, 48);
        long l4 = -9223372036854775807L;
        if (n7 < 0) {
            n7 = 1;
            if (n4 == 1) {
                return null;
            }
            if (n6 != 43) {
                if (n6 != 45) {
                    return null;
                }
                l4 = Long.MIN_VALUE;
                n5 = 1;
            } else {
                n7 = 0;
                n5 = 1;
            }
        } else {
            n7 = 0;
        }
        long l5 = 0L;
        long l6 = -256204778801521550L;
        while (n5 < n4) {
            n6 = b.b(string.charAt(n5), n3);
            if (n6 < 0) {
                return l3;
            }
            long l7 = l6;
            if (l5 < l6) {
                if (l6 == -256204778801521550L) {
                    l7 = l6 = l4 / (long)n3;
                    if (l5 < l6) {
                        return l3;
                    }
                } else {
                    return l3;
                }
            }
            if ((l5 *= (long)n3) < l4 + (l6 = (long)n6)) {
                return l3;
            }
            l5 -= l6;
            ++n5;
            l6 = l7;
        }
        if (n7 != 0) {
            return l5;
        }
        return -l5;
    }
}

