/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  z3.B
 *  z3.b
 *  z3.o
 *  z3.s
 */
package A3;

import V2.k;
import z3.B;
import z3.b;
import z3.o;
import z3.s;

public abstract class a {
    private static final byte[] a = B.a((String)"0123456789abcdef");

    public static final byte[] a() {
        return a;
    }

    public static final String b(b b2, long l2) {
        long l3;
        k.e(b2, "<this>");
        if (l2 > 0L && b2.L(l3 = l2 - 1L) == (byte)13) {
            String string = b2.n0(l3);
            b2.x(2L);
            return string;
        }
        String string = b2.n0(l2);
        b2.x(1L);
        return string;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final int c(b var0, o var1_1, boolean var2_2) {
        k.e(var0 /* !! */ , "<this>");
        k.e(var1_1 /* !! */ , "options");
        var12_3 = var0 /* !! */ .g;
        if (var12_3 == null) {
            if (var2_2) {
                return -2;
            }
            return -1;
        }
        var0 /* !! */  = (b)var12_3.a;
        var3_4 /* !! */  = var12_3.b;
        var4_5 = var12_3.c;
        var14_6 = var1_1 /* !! */ .l();
        var11_7 /* !! */  = var12_3;
        var6_8 = -1;
        var5_9 /* !! */  = 0;
        var1_1 /* !! */  = var0 /* !! */ ;
        block0: while (true) {
            block20: {
                var10_13 = var14_6[var5_9 /* !! */ ];
                var7_10 = var5_9 /* !! */  + 2;
                if ((var5_9 /* !! */  = var14_6[var5_9 /* !! */  + 1]) != -1) {
                    var6_8 = var5_9 /* !! */ ;
                }
                if (var11_7 /* !! */  == null) ** GOTO lbl39
                if (var10_13 >= 0) break block20;
                var5_9 /* !! */  = var7_10;
                while (true) {
                    block24: {
                        block22: {
                            block21: {
                                block23: {
                                    var9_12 = var3_4 /* !! */  + 1;
                                    var3_4 /* !! */  = (int)var1_1 /* !! */ [var3_4 /* !! */ ];
                                    var8_11 = var5_9 /* !! */  + 1;
                                    if ((var3_4 /* !! */  & 255) != var14_6[var5_9 /* !! */ ]) ** GOTO lbl68
                                    var5_9 /* !! */  = var8_11 == var7_10 + var10_13 * -1 ? 1 : 0;
                                    if (var9_12 != var4_5) break block21;
                                    k.b(var11_7 /* !! */ );
                                    var0 /* !! */  = var11_7 /* !! */ .f;
                                    k.b(var0 /* !! */ );
                                    var4_5 = var0 /* !! */ .b;
                                    var1_1 /* !! */  = (o)var0 /* !! */ .a;
                                    var3_4 /* !! */  = var0 /* !! */ .c;
                                    if (var0 /* !! */  != var12_3) break block22;
                                    if (var5_9 /* !! */  != 0) break block23;
lbl39:
                                    // 2 sources

                                    if (var2_2) {
                                        return -2;
                                    }
                                    ** GOTO lbl68
                                }
                                var0 /* !! */  = null;
                                break block22;
                            }
                            var0 /* !! */  = var11_7 /* !! */ ;
                            var3_4 /* !! */  = var4_5;
                            var4_5 = var9_12;
                        }
                        if (var5_9 /* !! */  == 0) break block24;
                        var7_10 = var14_6[var8_11];
                        var5_9 /* !! */  = var3_4 /* !! */ ;
                        var3_4 /* !! */  = var4_5;
                        ** GOTO lbl92
                    }
                    var5_9 /* !! */  = var3_4 /* !! */ ;
                    var3_4 /* !! */  = var4_5;
                    var4_5 = var5_9 /* !! */ ;
                    var5_9 /* !! */  = var8_11;
                    var11_7 /* !! */  = var0 /* !! */ ;
                }
            }
            var8_11 = var3_4 /* !! */  + 1;
            var5_9 /* !! */  = (int)var1_1 /* !! */ [var3_4 /* !! */ ];
            var3_4 /* !! */  = var7_10;
            while (true) {
                block26: {
                    block25: {
                        if (var3_4 /* !! */  != var7_10 + var10_13) break block25;
lbl68:
                        // 3 sources

                        return var6_8;
                    }
                    if ((var5_9 /* !! */  & 255) != var14_6[var3_4 /* !! */ ]) break block26;
                    var7_10 = var9_12 = var14_6[var3_4 /* !! */  + var10_13];
                    var5_9 /* !! */  = var4_5;
                    var0 /* !! */  = var11_7 /* !! */ ;
                    var3_4 /* !! */  = var8_11;
                    if (var8_11 == var4_5) {
                        var13_14 = var11_7 /* !! */ .f;
                        k.b(var13_14);
                        var4_5 = var13_14.b;
                        var11_7 /* !! */  = (s)var13_14.a;
                        var8_11 = var13_14.c;
                        var1_1 /* !! */  = var11_7 /* !! */ ;
                        var7_10 = var9_12;
                        var5_9 /* !! */  = var8_11;
                        var0 /* !! */  = var13_14;
                        var3_4 /* !! */  = var4_5;
                        if (var13_14 == var12_3) {
                            var0 /* !! */  = null;
                            var3_4 /* !! */  = var4_5;
                            var5_9 /* !! */  = var8_11;
                            var7_10 = var9_12;
                            var1_1 /* !! */  = var11_7 /* !! */ ;
                        }
                    }
lbl92:
                    // 6 sources

                    if (var7_10 >= 0) {
                        return var7_10;
                    }
                    var7_10 = -var7_10;
                    var4_5 = var5_9 /* !! */ ;
                    var5_9 /* !! */  = var7_10;
                    var11_7 /* !! */  = var0 /* !! */ ;
                    continue block0;
                }
                ++var3_4 /* !! */ ;
            }
            break;
        }
    }

    public static /* synthetic */ int d(b b2, o o2, boolean bl, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        return A3.a.c(b2, o2, bl);
    }
}

