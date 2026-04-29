/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 */
package r;

import java.util.ArrayList;
import r.c;
import r.d;
import r.i;

public class b
implements d.a {
    i a = null;
    float b = 0.0f;
    boolean c = false;
    ArrayList d = new ArrayList();
    public a e;
    boolean f = false;

    public b() {
    }

    public b(c c3) {
        this.e = new r.a(this, c3);
    }

    private boolean u(i i2, d d3) {
        return i2.s <= 1;
    }

    private i w(boolean[] blArray, i i2) {
        int n2 = this.e.f();
        i i3 = null;
        float f2 = 0.0f;
        for (int i4 = 0; i4 < n2; ++i4) {
            float f3;
            i i5;
            block5: {
                i i6;
                float f4;
                block7: {
                    block6: {
                        f4 = this.e.a(i4);
                        i5 = i3;
                        f3 = f2;
                        if (!(f4 < 0.0f)) break block5;
                        i6 = this.e.h(i4);
                        if (blArray == null) break block6;
                        i5 = i3;
                        f3 = f2;
                        if (blArray[i6.i]) break block5;
                    }
                    i5 = i3;
                    f3 = f2;
                    if (i6 == i2) break block5;
                    i.a a2 = i6.p;
                    if (a2 == i.a.i) break block7;
                    i5 = i3;
                    f3 = f2;
                    if (a2 != i.a.j) break block5;
                }
                i5 = i3;
                f3 = f2;
                if (f4 < f2) {
                    f3 = f4;
                    i5 = i6;
                }
            }
            i3 = i5;
            f2 = f3;
        }
        return i3;
    }

    public void A(d d3, i i2, boolean bl) {
        if (i2 != null && i2.m) {
            float f2 = this.e.c(i2);
            this.b += i2.l * f2;
            this.e.g(i2, bl);
            if (bl) {
                i2.g(this);
            }
            if (r.d.u && this.e.f() == 0) {
                this.f = true;
                d3.b = true;
            }
        }
    }

    public void B(d d3, b b2, boolean bl) {
        float f2 = this.e.e(b2, bl);
        this.b += b2.b * f2;
        if (bl) {
            b2.a.g(this);
        }
        if (r.d.u && this.a != null && this.e.f() == 0) {
            this.f = true;
            d3.b = true;
        }
    }

    public void C(d d3, i i2, boolean bl) {
        if (i2 != null && i2.t) {
            float f2 = this.e.c(i2);
            this.b += i2.v * f2;
            this.e.g(i2, bl);
            if (bl) {
                i2.g(this);
            }
            this.e.i(d3.o.d[i2.u], f2, bl);
            if (r.d.u && this.e.f() == 0) {
                this.f = true;
                d3.b = true;
            }
        }
    }

    public void D(d d3) {
        if (d3.h.length != 0) {
            boolean bl = false;
            while (!bl) {
                i i2;
                int n2;
                int n3 = this.e.f();
                for (n2 = 0; n2 < n3; ++n2) {
                    i2 = this.e.h(n2);
                    if (i2.j == -1 && !i2.m && !i2.t) continue;
                    this.d.add((Object)i2);
                }
                n3 = this.d.size();
                if (n3 > 0) {
                    for (n2 = 0; n2 < n3; ++n2) {
                        i2 = (i)this.d.get(n2);
                        if (i2.m) {
                            this.A(d3, i2, true);
                            continue;
                        }
                        if (i2.t) {
                            this.C(d3, i2, true);
                            continue;
                        }
                        this.B(d3, d3.h[i2.j], true);
                    }
                    this.d.clear();
                    continue;
                }
                bl = true;
            }
            if (r.d.u && this.a != null && this.e.f() == 0) {
                this.f = true;
                d3.b = true;
            }
        }
    }

    @Override
    public void a(d.a a2) {
        if (a2 instanceof b) {
            a2 = (b)a2;
            this.a = null;
            this.e.clear();
            for (int i2 = 0; i2 < ((b)a2).e.f(); ++i2) {
                i i3 = ((b)a2).e.h(i2);
                float f2 = ((b)a2).e.a(i2);
                this.e.i(i3, f2, true);
            }
        }
    }

    @Override
    public void b(i i2) {
        int n2 = i2.k;
        float f2 = 1.0f;
        if (n2 != 1) {
            if (n2 == 2) {
                f2 = 1000.0f;
            } else if (n2 == 3) {
                f2 = 1000000.0f;
            } else if (n2 == 4) {
                f2 = 1.0E9f;
            } else if (n2 == 5) {
                f2 = 1.0E12f;
            }
        }
        this.e.d(i2, f2);
    }

    @Override
    public i c(d d3, boolean[] blArray) {
        return this.w(blArray, null);
    }

    @Override
    public void clear() {
        this.e.clear();
        this.a = null;
        this.b = 0.0f;
    }

    public b d(d d3, int n2) {
        this.e.d(d3.o(n2, "ep"), 1.0f);
        this.e.d(d3.o(n2, "em"), -1.0f);
        return this;
    }

    b e(i i2, int n2) {
        this.e.d(i2, n2);
        return this;
    }

    boolean f(d object) {
        boolean bl;
        if ((object = this.g((d)object)) == null) {
            bl = true;
        } else {
            this.x((i)object);
            bl = false;
        }
        if (this.e.f() == 0) {
            this.f = true;
        }
        return bl;
    }

    /*
     * Unable to fully structure code
     */
    i g(d var1_1) {
        var8_2 = this.e.f();
        var17_3 = null;
        var6_4 = 0.0f;
        var5_5 = 0.0f;
        var11_8 = var12_7 = false;
        var16_9 = null;
        for (var7_6 = 0; var7_6 < var8_2; ++var7_6) {
            var2_10 = this.e.a(var7_6);
            var13_15 = this.e.h(var7_6);
            if (var13_15.p == i.a.g) {
                if (var17_3 == null) {
                    var9_13 = this.u(var13_15, var1_1);
lbl13:
                    // 2 sources

                    while (true) {
                        var14_16 = var13_15;
                        var15_17 = var16_9;
                        var10_14 = var11_8;
                        var3_11 = var2_10;
                        var4_12 = var5_5;
                        break;
                    }
                } else {
                    if (var6_4 > var2_10) {
                        var9_13 = this.u(var13_15, var1_1);
                        ** continue;
                    }
                    var14_16 = var17_3;
                    var15_17 = var16_9;
                    var9_13 = var12_7;
                    var10_14 = var11_8;
                    var3_11 = var6_4;
                    var4_12 = var5_5;
                    if (!var12_7) {
                        var14_16 = var17_3;
                        var15_17 = var16_9;
                        var9_13 = var12_7;
                        var10_14 = var11_8;
                        var3_11 = var6_4;
                        var4_12 = var5_5;
                        if (this.u(var13_15, var1_1)) {
                            var9_13 = true;
                            var14_16 = var13_15;
                            var15_17 = var16_9;
                            var10_14 = var11_8;
                            var3_11 = var2_10;
                            var4_12 = var5_5;
                        }
                    }
                }
            } else {
                var14_16 = var17_3;
                var15_17 = var16_9;
                var9_13 = var12_7;
                var10_14 = var11_8;
                var3_11 = var6_4;
                var4_12 = var5_5;
                if (var17_3 == null) {
                    var14_16 = var17_3;
                    var15_17 = var16_9;
                    var9_13 = var12_7;
                    var10_14 = var11_8;
                    var3_11 = var6_4;
                    var4_12 = var5_5;
                    if (var2_10 < 0.0f) {
                        if (var16_9 == null) {
                            var9_13 = this.u(var13_15, var1_1);
lbl60:
                            // 2 sources

                            while (true) {
                                var10_14 = var9_13;
                                var14_16 = var17_3;
                                var15_17 = var13_15;
                                var9_13 = var12_7;
                                var3_11 = var6_4;
                                var4_12 = var2_10;
                                break;
                            }
                        } else {
                            if (var5_5 > var2_10) {
                                var9_13 = this.u(var13_15, var1_1);
                                ** continue;
                            }
                            var14_16 = var17_3;
                            var15_17 = var16_9;
                            var9_13 = var12_7;
                            var10_14 = var11_8;
                            var3_11 = var6_4;
                            var4_12 = var5_5;
                            if (!var11_8) {
                                var14_16 = var17_3;
                                var15_17 = var16_9;
                                var9_13 = var12_7;
                                var10_14 = var11_8;
                                var3_11 = var6_4;
                                var4_12 = var5_5;
                                if (this.u(var13_15, var1_1)) {
                                    var10_14 = true;
                                    var4_12 = var2_10;
                                    var3_11 = var6_4;
                                    var9_13 = var12_7;
                                    var15_17 = var13_15;
                                    var14_16 = var17_3;
                                }
                            }
                        }
                    }
                }
            }
            var17_3 = var14_16;
            var16_9 = var15_17;
            var12_7 = var9_13;
            var11_8 = var10_14;
            var6_4 = var3_11;
            var5_5 = var4_12;
        }
        if (var17_3 != null) {
            return var17_3;
        }
        return var16_9;
    }

    @Override
    public i getKey() {
        return this.a;
    }

    b h(i i2, i i3, int n2, float f2, i i4, i i5, int n3) {
        float f3;
        block10: {
            block9: {
                block8: {
                    if (i3 == i4) {
                        this.e.d(i2, 1.0f);
                        this.e.d(i5, 1.0f);
                        this.e.d(i3, -2.0f);
                        return this;
                    }
                    if (f2 != 0.5f) break block8;
                    this.e.d(i2, 1.0f);
                    this.e.d(i3, -1.0f);
                    this.e.d(i4, -1.0f);
                    this.e.d(i5, 1.0f);
                    if (n2 > 0 || n3 > 0) {
                        this.b = -n2 + n3;
                        return this;
                    }
                    break block9;
                }
                if (f2 <= 0.0f) {
                    this.e.d(i2, -1.0f);
                    this.e.d(i3, 1.0f);
                    this.b = n2;
                    return this;
                }
                if (f2 >= 1.0f) {
                    this.e.d(i5, -1.0f);
                    this.e.d(i4, 1.0f);
                    this.b = -n3;
                    return this;
                }
                a a2 = this.e;
                f3 = 1.0f - f2;
                a2.d(i2, f3 * 1.0f);
                this.e.d(i3, f3 * -1.0f);
                this.e.d(i4, -1.0f * f2);
                this.e.d(i5, 1.0f * f2);
                if (n2 > 0 || n3 > 0) break block10;
            }
            return this;
        }
        this.b = (float)(-n2) * f3 + (float)n3 * f2;
        return this;
    }

    b i(i i2, int n2) {
        float f2;
        this.a = i2;
        i2.l = f2 = (float)n2;
        this.b = f2;
        this.f = true;
        return this;
    }

    @Override
    public boolean isEmpty() {
        return this.a == null && this.b == 0.0f && this.e.f() == 0;
    }

    b j(i i2, i i3, float f2) {
        this.e.d(i2, -1.0f);
        this.e.d(i3, f2);
        return this;
    }

    public b k(i i2, i i3, i i4, i i5, float f2) {
        this.e.d(i2, -1.0f);
        this.e.d(i3, 1.0f);
        this.e.d(i4, f2);
        this.e.d(i5, -f2);
        return this;
    }

    public b l(float f2, float f3, float f4, i i2, i i3, i i4, i i5) {
        this.b = 0.0f;
        if (f3 != 0.0f && f2 != f4) {
            if (f2 == 0.0f) {
                this.e.d(i2, 1.0f);
                this.e.d(i3, -1.0f);
                return this;
            }
            if (f4 == 0.0f) {
                this.e.d(i4, 1.0f);
                this.e.d(i5, -1.0f);
                return this;
            }
            f2 = f2 / f3 / (f4 / f3);
            this.e.d(i2, 1.0f);
            this.e.d(i3, -1.0f);
            this.e.d(i5, f2);
            this.e.d(i4, -f2);
            return this;
        }
        this.e.d(i2, 1.0f);
        this.e.d(i3, -1.0f);
        this.e.d(i5, 1.0f);
        this.e.d(i4, -1.0f);
        return this;
    }

    public b m(i i2, int n2) {
        if (n2 < 0) {
            this.b = n2 * -1;
            this.e.d(i2, 1.0f);
            return this;
        }
        this.b = n2;
        this.e.d(i2, -1.0f);
        return this;
    }

    public b n(i i2, i i3, int n2) {
        int n3 = 0;
        int n4 = 0;
        if (n2 != 0) {
            n3 = n4;
            n4 = n2;
            if (n2 < 0) {
                n4 = n2 * -1;
                n3 = 1;
            }
            this.b = n4;
        }
        if (n3 == 0) {
            this.e.d(i2, -1.0f);
            this.e.d(i3, 1.0f);
            return this;
        }
        this.e.d(i2, 1.0f);
        this.e.d(i3, -1.0f);
        return this;
    }

    public b o(i i2, i i3, i i4, int n2) {
        int n3 = 0;
        int n4 = 0;
        if (n2 != 0) {
            n3 = n4;
            n4 = n2;
            if (n2 < 0) {
                n4 = n2 * -1;
                n3 = 1;
            }
            this.b = n4;
        }
        if (n3 == 0) {
            this.e.d(i2, -1.0f);
            this.e.d(i3, 1.0f);
            this.e.d(i4, 1.0f);
            return this;
        }
        this.e.d(i2, 1.0f);
        this.e.d(i3, -1.0f);
        this.e.d(i4, -1.0f);
        return this;
    }

    public b p(i i2, i i3, i i4, int n2) {
        int n3 = 0;
        int n4 = 0;
        if (n2 != 0) {
            n3 = n4;
            n4 = n2;
            if (n2 < 0) {
                n4 = n2 * -1;
                n3 = 1;
            }
            this.b = n4;
        }
        if (n3 == 0) {
            this.e.d(i2, -1.0f);
            this.e.d(i3, 1.0f);
            this.e.d(i4, -1.0f);
            return this;
        }
        this.e.d(i2, 1.0f);
        this.e.d(i3, -1.0f);
        this.e.d(i4, 1.0f);
        return this;
    }

    public b q(i i2, i i3, i i4, i i5, float f2) {
        this.e.d(i4, 0.5f);
        this.e.d(i5, 0.5f);
        this.e.d(i2, -0.5f);
        this.e.d(i3, -0.5f);
        this.b = -f2;
        return this;
    }

    void r() {
        float f2 = this.b;
        if (f2 < 0.0f) {
            this.b = f2 * -1.0f;
            this.e.k();
        }
    }

    boolean s() {
        i i2 = this.a;
        return !(i2 == null || i2.p != i.a.g && this.b < 0.0f);
    }

    boolean t(i i2) {
        return this.e.b(i2);
    }

    public String toString() {
        return this.z();
    }

    public i v(i i2) {
        return this.w(null, i2);
    }

    void x(i i2) {
        i i3 = this.a;
        if (i3 != null) {
            this.e.d(i3, -1.0f);
            this.a.j = -1;
            this.a = null;
        }
        float f2 = this.e.g(i2, true) * -1.0f;
        this.a = i2;
        if (f2 == 1.0f) {
            return;
        }
        this.b /= f2;
        this.e.j(f2);
    }

    public void y() {
        this.a = null;
        this.e.clear();
        this.b = 0.0f;
        this.f = false;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    String z() {
        if (this.a == null) {
            var7_1 /* !! */  = new StringBuilder();
            var7_1 /* !! */ .append("");
            var7_1 /* !! */ .append("0");
            var7_1 /* !! */  = var7_1 /* !! */ .toString();
        } else {
            var7_1 /* !! */  = new StringBuilder();
            var7_1 /* !! */ .append("");
            var7_1 /* !! */ .append((Object)this.a);
            var7_1 /* !! */  = var7_1 /* !! */ .toString();
        }
        var8_2 /* !! */  = new StringBuilder();
        var8_2 /* !! */ .append((String)var7_1 /* !! */ );
        var8_2 /* !! */ .append(" = ");
        var7_1 /* !! */  = var8_2 /* !! */ .toString();
        var1_3 = this.b;
        var4_4 = 0;
        if (var1_3 != 0.0f) {
            var8_2 /* !! */  = new StringBuilder();
            var8_2 /* !! */ .append((String)var7_1 /* !! */ );
            var8_2 /* !! */ .append(this.b);
            var7_1 /* !! */  = var8_2 /* !! */ .toString();
            var3_5 = true;
        } else {
            var3_5 = false;
        }
        var5_6 = this.e.f();
        while (var4_4 < var5_6) {
            var8_2 /* !! */  = this.e.h(var4_4);
            if (var8_2 /* !! */  != null && (var6_8 = (cfr_temp_0 = (var2_7 = this.e.a(var4_4)) - 0.0f) == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1)) != false) {
                var9_9 = var8_2 /* !! */ .toString();
                if (!var3_5) {
                    var8_2 /* !! */  = var7_1 /* !! */ ;
                    var1_3 = var2_7;
                    if (var2_7 < 0.0f) {
                        var8_2 /* !! */  = new StringBuilder();
                        var8_2 /* !! */ .append((String)var7_1 /* !! */ );
                        var8_2 /* !! */ .append("- ");
                        var8_2 /* !! */  = var8_2 /* !! */ .toString();
lbl48:
                        // 2 sources

                        while (true) {
                            var1_3 = var2_7 * -1.0f;
                            break;
                        }
                    }
                } else if (var6_8 > 0) {
                    var8_2 /* !! */  = new StringBuilder();
                    var8_2 /* !! */ .append((String)var7_1 /* !! */ );
                    var8_2 /* !! */ .append(" + ");
                    var8_2 /* !! */  = var8_2 /* !! */ .toString();
                    var1_3 = var2_7;
                } else {
                    var8_2 /* !! */  = new StringBuilder();
                    var8_2 /* !! */ .append((String)var7_1 /* !! */ );
                    var8_2 /* !! */ .append(" - ");
                    var8_2 /* !! */  = var8_2 /* !! */ .toString();
                    ** continue;
                }
                if (var1_3 == 1.0f) {
                    var7_1 /* !! */  = new StringBuilder();
                    var7_1 /* !! */ .append((String)var8_2 /* !! */ );
                    var7_1 /* !! */ .append(var9_9);
                    var7_1 /* !! */  = var7_1 /* !! */ .toString();
                } else {
                    var7_1 /* !! */  = new StringBuilder();
                    var7_1 /* !! */ .append((String)var8_2 /* !! */ );
                    var7_1 /* !! */ .append(var1_3);
                    var7_1 /* !! */ .append(" ");
                    var7_1 /* !! */ .append(var9_9);
                    var7_1 /* !! */  = var7_1 /* !! */ .toString();
                }
                var3_5 = true;
            }
            ++var4_4;
        }
        var8_2 /* !! */  = var7_1 /* !! */ ;
        if (!var3_5) {
            var8_2 /* !! */  = new StringBuilder();
            var8_2 /* !! */ .append((String)var7_1 /* !! */ );
            var8_2 /* !! */ .append("0.0");
            var8_2 /* !! */  = var8_2 /* !! */ .toString();
        }
        return var8_2 /* !! */ ;
    }

    public static interface a {
        public float a(int var1);

        public boolean b(i var1);

        public float c(i var1);

        public void clear();

        public void d(i var1, float var2);

        public float e(b var1, boolean var2);

        public int f();

        public float g(i var1, boolean var2);

        public i h(int var1);

        public void i(i var1, float var2, boolean var3);

        public void j(float var1);

        public void k();
    }
}

