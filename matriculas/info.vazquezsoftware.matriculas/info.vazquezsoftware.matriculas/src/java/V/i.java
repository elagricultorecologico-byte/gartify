/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.ArrayList
 */
package v;

import java.util.ArrayList;
import u.a;
import u.d;
import u.e;
import u.f;
import u.g;
import u.h;
import u.j;
import v.b;
import v.o;

public abstract class i {
    public static o a(e e2, int n2, ArrayList arrayList, o object) {
        Object object2;
        int n3;
        int n4;
        int n5;
        block15: {
            n5 = n2 == 0 ? e2.I0 : e2.J0;
            n4 = 0;
            if (n5 != -1 && (object == null || n5 != ((o)object).c())) {
                n3 = 0;
                while (true) {
                    object2 = object;
                    if (n3 >= arrayList.size()) break block15;
                    object2 = (o)arrayList.get(n3);
                    if (((o)object2).c() == n5) {
                        if (object != null) {
                            ((o)object).g(n2, (o)object2);
                            arrayList.remove(object);
                        }
                        break block15;
                    }
                    ++n3;
                }
            }
            object2 = object;
            if (n5 != -1) {
                return object;
            }
        }
        object = object2;
        if (object2 == null) {
            object = object2;
            if (e2 instanceof j) {
                n3 = ((j)e2).t1(n2);
                object = object2;
                if (n3 != -1) {
                    n5 = 0;
                    while (true) {
                        object = object2;
                        if (n5 >= arrayList.size() || ((o)(object = (o)arrayList.get(n5))).c() == n3) break;
                        ++n5;
                    }
                }
            }
            object2 = object;
            if (object == null) {
                object2 = new o(n2);
            }
            arrayList.add(object2);
            object = object2;
        }
        if (((o)object).a(e2)) {
            if (e2 instanceof h) {
                object2 = (h)e2;
                d d2 = ((h)object2).s1();
                n5 = n4;
                if (((h)object2).t1() == 0) {
                    n5 = 1;
                }
                d2.c(n5, arrayList, (o)object);
            }
            if (n2 == 0) {
                e2.I0 = ((o)object).c();
                e2.O.c(n2, arrayList, (o)object);
                e2.Q.c(n2, arrayList, (o)object);
            } else {
                e2.J0 = ((o)object).c();
                e2.P.c(n2, arrayList, (o)object);
                e2.S.c(n2, arrayList, (o)object);
                e2.R.c(n2, arrayList, (o)object);
            }
            e2.V.c(n2, arrayList, (o)object);
        }
        return object;
    }

    private static o b(ArrayList arrayList, int n2) {
        int n3 = arrayList.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            o o2 = (o)arrayList.get(i2);
            if (n2 != o2.c()) continue;
            return o2;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static boolean c(f var0, b.b var1_1) {
        var19_2 = var0.s1();
        var3_3 = var19_2.size();
        for (var2_4 = 0; var2_4 < var3_3; ++var2_4) {
            var8_5 = (e)var19_2.get(var2_4);
            if (!i.d(var0.A(), var0.T(), var8_5.A(), var8_5.T())) {
                return false;
            }
            if (!(var8_5 instanceof g)) continue;
            return false;
        }
        var14_6 /* !! */  = null;
        var8_5 = null;
        var10_7 = null;
        var9_8 = null;
        var12_9 = null;
        var11_10 = null;
        for (var2_4 = 0; var2_4 < var3_3; ++var2_4) {
            var20_17 = (e)var19_2.get(var2_4);
            if (!i.d(var0.A(), var0.T(), var20_17.A(), var20_17.T())) {
                f.U1(0, var20_17, var1_1, var0.p1, b.a.k);
            }
            var7_11 = var20_17 instanceof h;
            var16_14 /* !! */  = var14_6 /* !! */ ;
            var15_13 = var10_7;
            if (var7_11) {
                var17_15 = (h)var20_17;
                var13_12 /* !! */  = var10_7;
                if (var17_15.t1() == 0) {
                    var13_12 /* !! */  = var10_7;
                    if (var10_7 == null) {
                        var13_12 /* !! */  = new ArrayList();
                    }
                    var13_12 /* !! */ .add(var17_15);
                }
                var16_14 /* !! */  = var14_6 /* !! */ ;
                var15_13 = var13_12 /* !! */ ;
                if (var17_15.t1() == 1) {
                    var10_7 = var14_6 /* !! */ ;
                    if (var14_6 /* !! */  == null) {
                        var10_7 = new ArrayList();
                    }
                    var10_7.add(var17_15);
                    var15_13 = var13_12 /* !! */ ;
                    var16_14 /* !! */  = var10_7;
                }
            }
            var10_7 = var8_5;
            var13_12 /* !! */  = var9_8;
            if (var20_17 instanceof j) {
                if (var20_17 instanceof a) {
                    var17_15 = (a)var20_17;
                    var14_6 /* !! */  = var8_5;
                    if (var17_15.y1() == 0) {
                        var14_6 /* !! */  = var8_5;
                        if (var8_5 == null) {
                            var14_6 /* !! */  = new ArrayList();
                        }
                        var14_6 /* !! */ .add(var17_15);
                    }
                    var10_7 = var14_6 /* !! */ ;
                    var13_12 /* !! */  = var9_8;
                    if (var17_15.y1() == 1) {
                        var13_12 /* !! */  = var9_8;
                        if (var9_8 == null) {
                            var13_12 /* !! */  = new ArrayList();
                        }
                        var13_12 /* !! */ .add(var17_15);
                        var10_7 = var14_6 /* !! */ ;
                    }
                } else {
                    var14_6 /* !! */  = (j)var20_17;
                    var10_7 = var8_5;
                    if (var8_5 == null) {
                        var10_7 = new ArrayList();
                    }
                    var10_7.add(var14_6 /* !! */ );
                    var13_12 /* !! */  = var9_8;
                    if (var9_8 == null) {
                        var13_12 /* !! */  = new ArrayList();
                    }
                    var13_12 /* !! */ .add((Object)var14_6 /* !! */ );
                }
            }
            var17_15 = var12_9;
            if (var20_17.O.f == null) {
                var17_15 = var12_9;
                if (var20_17.Q.f == null) {
                    var17_15 = var12_9;
                    if (!var7_11) {
                        var17_15 = var12_9;
                        if (!(var20_17 instanceof a)) {
                            var8_5 = var12_9;
                            if (var12_9 == null) {
                                var8_5 = new ArrayList();
                            }
                            var8_5.add((Object)var20_17);
                            var17_15 = var8_5;
                        }
                    }
                }
            }
            var18_16 = var11_10;
            if (var20_17.P.f == null) {
                var18_16 = var11_10;
                if (var20_17.R.f == null) {
                    var18_16 = var11_10;
                    if (var20_17.S.f == null) {
                        var18_16 = var11_10;
                        if (!var7_11) {
                            var18_16 = var11_10;
                            if (!(var20_17 instanceof a)) {
                                var8_5 = var11_10;
                                if (var11_10 == null) {
                                    var8_5 = new ArrayList();
                                }
                                var8_5.add((Object)var20_17);
                                var18_16 = var8_5;
                            }
                        }
                    }
                }
            }
            var14_6 /* !! */  = var16_14 /* !! */ ;
            var8_5 = var10_7;
            var10_7 = var15_13;
            var9_8 = var13_12 /* !! */ ;
            var12_9 = var17_15;
            var11_10 = var18_16;
        }
        var13_12 /* !! */  = new ArrayList();
        if (var14_6 /* !! */  != null) {
            var4_18 = var14_6 /* !! */ .size();
            for (var2_4 = 0; var2_4 < var4_18; ++var2_4) {
                var1_1 = var14_6 /* !! */ .get(var2_4);
                i.a((h)var1_1, 0, var13_12 /* !! */ , null);
            }
        }
        if (var8_5 != null) {
            var4_18 = var8_5.size();
            for (var2_4 = 0; var2_4 < var4_18; ++var2_4) {
                var1_1 = var8_5.get(var2_4);
                var14_6 /* !! */  = (j)var1_1;
                var1_1 = i.a(var14_6 /* !! */ , 0, var13_12 /* !! */ , null);
                var14_6 /* !! */ .s1(var13_12 /* !! */ , 0, (o)var1_1);
                var1_1.b(var13_12 /* !! */ );
            }
        }
        if ((var1_1 = var0.o(d.a.h)).d() != null) {
            var1_1 = var1_1.d().iterator();
            while (var1_1.hasNext()) {
                i.a(((d)var1_1.next()).d, 0, var13_12 /* !! */ , null);
            }
        }
        if ((var1_1 = var0.o(d.a.j)).d() != null) {
            var1_1 = var1_1.d().iterator();
            while (var1_1.hasNext()) {
                i.a(((d)var1_1.next()).d, 0, var13_12 /* !! */ , null);
            }
        }
        if ((var1_1 = var0.o(d.a.m)).d() != null) {
            var1_1 = var1_1.d().iterator();
            while (var1_1.hasNext()) {
                i.a(((d)var1_1.next()).d, 0, var13_12 /* !! */ , null);
            }
        }
        if (var12_9 != null) {
            var4_18 = var12_9.size();
            for (var2_4 = 0; var2_4 < var4_18; ++var2_4) {
                var1_1 = var12_9.get(var2_4);
                i.a((e)var1_1, 0, var13_12 /* !! */ , null);
            }
        }
        if (var10_7 != null) {
            var4_18 = var10_7.size();
            for (var2_4 = 0; var2_4 < var4_18; ++var2_4) {
                var1_1 = var10_7.get(var2_4);
                i.a((h)var1_1, 1, var13_12 /* !! */ , null);
            }
        }
        if (var9_8 != null) {
            var4_18 = var9_8.size();
            for (var2_4 = 0; var2_4 < var4_18; ++var2_4) {
                var1_1 = var9_8.get(var2_4);
                var1_1 = (j)var1_1;
                var8_5 = i.a((e)var1_1, 1, var13_12 /* !! */ , null);
                var1_1.s1(var13_12 /* !! */ , 1, (o)var8_5);
                var8_5.b(var13_12 /* !! */ );
            }
        }
        if ((var1_1 = var0.o(d.a.i)).d() != null) {
            var1_1 = var1_1.d().iterator();
            while (var1_1.hasNext()) {
                i.a(((d)var1_1.next()).d, 1, var13_12 /* !! */ , null);
            }
        }
        if ((var1_1 = var0.o(d.a.l)).d() != null) {
            var1_1 = var1_1.d().iterator();
            while (var1_1.hasNext()) {
                i.a(((d)var1_1.next()).d, 1, var13_12 /* !! */ , null);
            }
        }
        if ((var1_1 = var0.o(d.a.k)).d() != null) {
            var1_1 = var1_1.d().iterator();
            while (var1_1.hasNext()) {
                i.a(((d)var1_1.next()).d, 1, var13_12 /* !! */ , null);
            }
        }
        if ((var1_1 = var0.o(d.a.m)).d() != null) {
            var1_1 = var1_1.d().iterator();
            while (var1_1.hasNext()) {
                i.a(((d)var1_1.next()).d, 1, var13_12 /* !! */ , null);
            }
        }
        if (var11_10 != null) {
            var4_18 = var11_10.size();
            for (var2_4 = 0; var2_4 < var4_18; ++var2_4) {
                var1_1 = var11_10.get(var2_4);
                i.a((e)var1_1, 1, var13_12 /* !! */ , null);
            }
        }
        for (var2_4 = 0; var2_4 < var3_3; ++var2_4) {
            var8_5 = (e)var19_2.get(var2_4);
            if (!var8_5.s0()) continue;
            var1_1 = i.b(var13_12 /* !! */ , var8_5.I0);
            var8_5 = i.b(var13_12 /* !! */ , var8_5.J0);
            if (var1_1 == null || var8_5 == null) continue;
            var1_1.g(0, (o)var8_5);
            var8_5.i(2);
            var13_12 /* !! */ .remove(var1_1);
        }
        if (var13_12 /* !! */ .size() <= 1) {
            return false;
        }
        if (var0.A() != e.b.h) ** GOTO lbl-1000
        var6_19 = var13_12 /* !! */ .size();
        var1_1 = null;
        var3_3 = 0;
        var2_4 = 0;
        while (var2_4 < var6_19) {
            var8_5 = var13_12 /* !! */ .get(var2_4);
            var4_18 = var2_4 + 1;
            if ((var8_5 = (o)var8_5).d() == 1) {
                var2_4 = var4_18;
                continue;
            }
            var8_5.h(false);
            var5_20 = var8_5.f(var0.M1(), 0);
            var2_4 = var4_18;
            if (var5_20 <= var3_3) continue;
            var1_1 = var8_5;
            var3_3 = var5_20;
            var2_4 = var4_18;
        }
        if (var1_1 != null) {
            var0.Q0(e.b.g);
            var0.l1(var3_3);
            var1_1.h(true);
            var8_5 = var1_1;
        } else lbl-1000:
        // 2 sources

        {
            var8_5 = null;
        }
        if (var0.T() != e.b.h) ** GOTO lbl-1000
        var6_19 = var13_12 /* !! */ .size();
        var1_1 = null;
        var2_4 = 0;
        var3_3 = 0;
        while (var2_4 < var6_19) {
            var9_8 = var13_12 /* !! */ .get(var2_4);
            var4_18 = var2_4 + 1;
            if ((var9_8 = (o)var9_8).d() == 0) {
                var2_4 = var4_18;
                continue;
            }
            var9_8.h(false);
            var5_20 = var9_8.f(var0.M1(), 1);
            var2_4 = var4_18;
            if (var5_20 <= var3_3) continue;
            var1_1 = var9_8;
            var3_3 = var5_20;
            var2_4 = var4_18;
        }
        if (var1_1 != null) {
            var0.h1(e.b.g);
            var0.M0(var3_3);
            var1_1.h(true);
        } else lbl-1000:
        // 2 sources

        {
            var1_1 = null;
        }
        return var8_5 != null || var1_1 != null;
        {
        }
    }

    public static boolean d(e.b b2, e.b b3, e.b b4, e.b b5) {
        e.b b6;
        e.b b7 = e.b.g;
        boolean bl = b4 == b7 || b4 == (b6 = e.b.h) || b4 == e.b.j && b2 != b6;
        boolean bl2 = b5 == b7 || b5 == (b2 = e.b.h) || b5 == e.b.j && b3 != b2;
        return bl || bl2;
        {
        }
    }
}

