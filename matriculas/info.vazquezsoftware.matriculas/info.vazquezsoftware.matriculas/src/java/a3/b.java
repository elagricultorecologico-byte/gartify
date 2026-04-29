/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  z3.b
 *  z3.e
 */
package A3;

import H2.q;
import V2.k;
import z3.e;

public abstract class b {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static final /* synthetic */ int a(byte[] byArray, int n2) {
        return b.c(byArray, n2);
    }

    public static final /* synthetic */ int b(char c2) {
        return b.e(c2);
    }

    private static final int c(byte[] byArray, int n2) {
        int n3 = 1;
        int n4 = byArray.length;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        block0: while (n5 < n4) {
            q q2;
            int n8;
            int n9;
            int n10;
            int n11 = byArray[n5];
            if (n11 >= 0) {
                n10 = n7 + 1;
                if (n7 == n2) break;
                if (n11 != 10 && n11 != 13 && (n11 >= 0 && n11 <= 31 || 127 <= n11 && n11 <= 159) || n11 == 65533) {
                    return -1;
                }
                n7 = n11 < 65536 ? n3 : 2;
                n7 = n6 + n7;
                n11 = n5 + n3;
                n6 = n10;
                n10 = n7;
                while (true) {
                    n9 = n6;
                    n5 = n11;
                    n6 = n10;
                    n7 = n9;
                    if (n11 >= n4) continue block0;
                    n8 = byArray[n11];
                    n5 = n11;
                    n6 = n10;
                    n7 = n9;
                    if (n8 < 0) continue block0;
                    n11 += n3;
                    n5 = n9 + 1;
                    if (n9 == n2) {
                        return n10;
                    }
                    if (n8 != 10 && n8 != 13 && (n8 >= 0 && n8 <= 31 || 127 <= n8 && n8 <= 159) || n8 == 65533) {
                        return -1;
                    }
                    n6 = n8 < 65536 ? n3 : 2;
                    n10 += n6;
                    n6 = n5;
                }
            }
            if (n11 >> 5 == -2) {
                n10 = n5 + 1;
                if (n4 <= n10) {
                    if (n7 == n2) break;
                    return -1;
                }
                if (((n10 = byArray[n10]) & 0xC0) == 128) {
                    if ((n11 = n10 ^ 0xF80 ^ n11 << 6) < 128) {
                        if (n7 == n2) break;
                        return -1;
                    }
                    n10 = n7 + 1;
                    if (n7 == n2) break;
                    if (n11 != 10 && n11 != 13 && (n11 >= 0 && n11 <= 31 || 127 <= n11 && n11 <= 159) || n11 == 65533) {
                        return -1;
                    }
                    n7 = n11 < 65536 ? n3 : 2;
                    n6 += n7;
                    q2 = q.a;
                    n5 += 2;
                    n7 = n10;
                    continue;
                }
                if (n7 == n2) break;
                return -1;
            }
            if (n11 >> 4 == -2) {
                n9 = n5 + 2;
                if (n4 <= n9) {
                    if (n7 == n2) break;
                    return -1;
                }
                n10 = byArray[n5 + 1];
                if ((n10 & 0xC0) == 128) {
                    if (((n9 = byArray[n9]) & 0xC0) == 128) {
                        if ((n11 = n9 ^ 0xFFFE1F80 ^ n10 << 6 ^ n11 << 12) < 2048) {
                            if (n7 == n2) break;
                            return -1;
                        }
                        if (55296 <= n11 && n11 <= 57343) {
                            if (n7 == n2) break;
                            return -1;
                        }
                        n10 = n7 + 1;
                        if (n7 == n2) break;
                        if (n11 != 10 && n11 != 13 && (n11 >= 0 && n11 <= 31 || 127 <= n11 && n11 <= 159) || n11 == 65533) {
                            return -1;
                        }
                        n7 = n11 < 65536 ? n3 : 2;
                        n6 += n7;
                        q2 = q.a;
                        n5 += 3;
                        n7 = n10;
                        continue;
                    }
                    if (n7 == n2) break;
                    return -1;
                }
                if (n7 == n2) break;
                return -1;
            }
            if (n11 >> 3 == -2) {
                n8 = n5 + 3;
                if (n4 <= n8) {
                    if (n7 == n2) break;
                    return -1;
                }
                n10 = byArray[n5 + 1];
                if ((n10 & 0xC0) == 128) {
                    n9 = byArray[n5 + 2];
                    if ((n9 & 0xC0) == 128) {
                        if (((n8 = byArray[n8]) & 0xC0) == 128) {
                            if ((n11 = n8 ^ 0x381F80 ^ n9 << 6 ^ n10 << 12 ^ n11 << 18) > 0x10FFFF) {
                                if (n7 == n2) break;
                                return -1;
                            }
                            if (55296 <= n11 && n11 <= 57343) {
                                if (n7 == n2) break;
                                return -1;
                            }
                            if (n11 < 65536) {
                                if (n7 == n2) break;
                                return -1;
                            }
                            n10 = n7 + 1;
                            if (n7 == n2) break;
                            if (n11 != 10 && n11 != 13 && (n11 >= 0 && n11 <= 31 || 127 <= n11 && n11 <= 159) || n11 == 65533) {
                                return -1;
                            }
                            n7 = n11 < 65536 ? n3 : 2;
                            n6 += n7;
                            q2 = q.a;
                            n5 += 4;
                            n7 = n10;
                            continue;
                        }
                        if (n7 == n2) break;
                        return -1;
                    }
                    if (n7 == n2) break;
                    return -1;
                }
                if (n7 == n2) break;
                return -1;
            }
            if (n7 == n2) break;
            return -1;
        }
        return n6;
    }

    public static final void d(e e2, z3.b b2, int n2, int n3) {
        k.e(e2, "<this>");
        k.e(b2, "buffer");
        b2.N0(e2.h(), n2, n3);
    }

    private static final int e(char c2) {
        if ('0' <= c2 && c2 <= '9') {
            return c2 - 48;
        }
        if ('a' <= c2 && c2 <= 'f') {
            return c2 - 87;
        }
        if ('A' <= c2 && c2 <= 'F') {
            return c2 - 55;
        }
        throw new IllegalArgumentException(k.j("Unexpected hex digit: ", Character.valueOf((char)c2)));
    }

    public static final char[] f() {
        return a;
    }
}

