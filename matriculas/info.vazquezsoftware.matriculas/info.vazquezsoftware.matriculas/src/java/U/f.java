/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.ref.WeakReference
 *  java.util.Arrays
 *  java.util.HashSet
 *  v.b
 *  v.b$a
 *  v.e
 *  v.h
 *  v.i
 */
package u;

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import r.i;
import u.a;
import u.b;
import u.c;
import u.d;
import u.e;
import u.h;
import u.k;
import u.l;
import u.m;
import v.b;

public class f
extends m {
    v.b M0 = new v.b(this);
    public v.e N0 = new v.e(this);
    private int O0;
    protected b.b P0 = null;
    private boolean Q0 = false;
    protected r.d R0 = new r.d();
    int S0;
    int T0;
    int U0;
    int V0;
    public int W0 = 0;
    public int X0 = 0;
    c[] Y0 = new c[4];
    c[] Z0 = new c[4];
    public boolean a1 = false;
    public boolean b1 = false;
    public boolean c1 = false;
    public int d1 = 0;
    public int e1 = 0;
    private int f1 = 257;
    public boolean g1 = false;
    private boolean h1 = false;
    private boolean i1 = false;
    int j1 = 0;
    private WeakReference k1 = null;
    private WeakReference l1 = null;
    private WeakReference m1 = null;
    private WeakReference n1 = null;
    HashSet o1 = new HashSet();
    public b.a p1 = new b.a();

    private void B1(d object, i i2) {
        object = this.R0.q(object);
        this.R0.h(i2, (i)object, 0, 5);
    }

    private void C1(d object, i i2) {
        object = this.R0.q(object);
        this.R0.h((i)object, i2, 0, 5);
    }

    private void D1(e e2) {
        int n2 = this.X0;
        Object[] objectArray = this.Y0;
        if (n2 + 1 >= objectArray.length) {
            this.Y0 = (c[])Arrays.copyOf((Object[])objectArray, (int)(objectArray.length * 2));
        }
        this.Y0[this.X0] = new c(e2, 1, this.R1());
        ++this.X0;
    }

    public static boolean U1(int n2, e e2, b.b b2, b.a a2, int n3) {
        if (b2 == null) {
            return false;
        }
        if (e2.V() != 8 && !(e2 instanceof h) && !(e2 instanceof a)) {
            a2.a = e2.A();
            a2.b = e2.T();
            a2.c = e2.W();
            a2.d = e2.x();
            a2.i = false;
            a2.j = n3;
            e.b b3 = a2.a;
            e.b b4 = e.b.i;
            n2 = b3 == b4 ? 1 : 0;
            n3 = a2.b == b4 ? 1 : 0;
            boolean bl = n2 != 0 && e2.d0 > 0.0f;
            boolean bl2 = n3 != 0 && e2.d0 > 0.0f;
            int n4 = n2;
            if (n2 != 0) {
                n4 = n2;
                if (e2.a0(0)) {
                    n4 = n2;
                    if (e2.w == 0) {
                        n4 = n2;
                        if (!bl) {
                            a2.a = e.b.h;
                            if (n3 != 0 && e2.x == 0) {
                                a2.a = e.b.g;
                            }
                            n4 = 0;
                        }
                    }
                }
            }
            n2 = n3;
            if (n3 != 0) {
                n2 = n3;
                if (e2.a0(1)) {
                    n2 = n3;
                    if (e2.x == 0) {
                        n2 = n3;
                        if (!bl2) {
                            a2.b = e.b.h;
                            if (n4 != 0 && e2.w == 0) {
                                a2.b = e.b.g;
                            }
                            n2 = 0;
                        }
                    }
                }
            }
            if (e2.n0()) {
                a2.a = e.b.g;
                n4 = 0;
            }
            if (e2.o0()) {
                a2.b = e.b.g;
                n2 = 0;
            }
            if (bl) {
                if (e2.y[0] == 4) {
                    a2.a = e.b.g;
                } else if (n2 == 0) {
                    b4 = a2.b;
                    b3 = e.b.g;
                    if (b4 == b3) {
                        n2 = a2.d;
                    } else {
                        a2.a = e.b.h;
                        b2.b(e2, a2);
                        n2 = a2.f;
                    }
                    a2.a = b3;
                    a2.c = (int)(e2.v() * (float)n2);
                }
            }
            if (bl2) {
                if (e2.y[1] == 4) {
                    a2.b = e.b.g;
                } else if (n4 == 0) {
                    b3 = a2.a;
                    b4 = e.b.g;
                    if (b3 == b4) {
                        n2 = a2.c;
                    } else {
                        a2.b = e.b.h;
                        b2.b(e2, a2);
                        n2 = a2.e;
                    }
                    a2.b = b4;
                    a2.d = e2.w() == -1 ? (int)((float)n2 / e2.v()) : (int)(e2.v() * (float)n2);
                }
            }
            b2.b(e2, a2);
            e2.l1(a2.e);
            e2.M0(a2.f);
            e2.L0(a2.h);
            e2.B0(a2.g);
            a2.j = b.a.k;
            return a2.i;
        }
        a2.e = 0;
        a2.f = 0;
        return false;
    }

    private void W1() {
        this.W0 = 0;
        this.X0 = 0;
    }

    private void y1(e e2) {
        int n2 = this.W0;
        Object[] objectArray = this.Z0;
        if (n2 + 1 >= objectArray.length) {
            this.Z0 = (c[])Arrays.copyOf((Object[])objectArray, (int)(objectArray.length * 2));
        }
        this.Z0[this.W0] = new c(e2, 0, this.R1());
        ++this.W0;
    }

    public void A1(d d3) {
        WeakReference weakReference = this.l1;
        if (weakReference != null && weakReference.get() != null && d3.e() <= ((d)this.l1.get()).e()) {
            return;
        }
        this.l1 = new WeakReference((Object)d3);
    }

    void E1(d d3) {
        WeakReference weakReference = this.m1;
        if (weakReference != null && weakReference.get() != null && d3.e() <= ((d)this.m1.get()).e()) {
            return;
        }
        this.m1 = new WeakReference((Object)d3);
    }

    void F1(d d3) {
        WeakReference weakReference = this.k1;
        if (weakReference != null && weakReference.get() != null && d3.e() <= ((d)this.k1.get()).e()) {
            return;
        }
        this.k1 = new WeakReference((Object)d3);
    }

    public boolean G1(boolean bl) {
        return this.N0.f(bl);
    }

    public boolean H1(boolean bl) {
        return this.N0.g(bl);
    }

    public boolean I1(boolean bl, int n2) {
        return this.N0.h(bl, n2);
    }

    public void J1(r.e e2) {
        this.R0.v(e2);
    }

    public b.b K1() {
        return this.P0;
    }

    public int L1() {
        return this.f1;
    }

    public r.d M1() {
        return this.R0;
    }

    public boolean N1() {
        return false;
    }

    @Override
    public void O(StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.o);
        stringBuilder2.append(":{\n");
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("  actualWidth:");
        stringBuilder2.append(this.b0);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("\n");
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("  actualHeight:");
        stringBuilder2.append(this.c0);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("\n");
        stringBuilder2 = this.s1();
        int n2 = stringBuilder2.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object = stringBuilder2.get(i2);
            ((e)object).O(stringBuilder);
            stringBuilder.append(",\n");
        }
        stringBuilder.append("}");
    }

    public void O1() {
        this.N0.j();
    }

    public void P1() {
        this.N0.k();
    }

    public boolean Q1() {
        return this.i1;
    }

    public boolean R1() {
        return this.Q0;
    }

    public boolean S1() {
        return this.h1;
    }

    public long T1(int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.S0 = n9;
        this.T0 = n10;
        return this.M0.d(this, n2, n9, n10, n3, n4, n5, n6, n7, n8);
    }

    public boolean V1(int n2) {
        return (this.f1 & n2) == n2;
    }

    public void X1(b.b b2) {
        this.P0 = b2;
        this.N0.n(b2);
    }

    public void Y1(int n2) {
        this.f1 = n2;
        r.d.s = this.V1(512);
    }

    public void Z1(int n2) {
        this.O0 = n2;
    }

    public void a2(boolean bl) {
        this.Q0 = bl;
    }

    public boolean b2(r.d d3, boolean[] object) {
        object[2] = false;
        boolean bl = this.V1(64);
        this.r1(d3, bl);
        int n2 = this.L0.size();
        boolean bl2 = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            object = (e)this.L0.get(i2);
            ((e)object).r1(d3, bl);
            if (!((e)object).c0()) continue;
            bl2 = true;
        }
        return bl2;
    }

    public void c2() {
        this.M0.e(this);
    }

    @Override
    public void q1(boolean bl, boolean bl2) {
        super.q1(bl, bl2);
        int n2 = this.L0.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((e)this.L0.get(i2)).q1(bl, bl2);
        }
    }

    @Override
    public void t0() {
        this.R0.E();
        this.S0 = 0;
        this.U0 = 0;
        this.T0 = 0;
        this.V0 = 0;
        this.g1 = false;
        super.t0();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void t1() {
        block47: {
            block46: {
                block48: {
                    block45: {
                        var5_1 = 0;
                        this.f0 = 0;
                        this.g0 = 0;
                        this.h1 = false;
                        this.i1 = false;
                        var13_2 = this.L0.size();
                        var2_3 = Math.max((int)0, (int)this.W());
                        var3_4 = Math.max((int)0, (int)this.x());
                        var15_5 /* !! */  = this.Z;
                        var16_10 = var15_5 /* !! */ [1];
                        var17_11 = var15_5 /* !! */ [0];
                        if (this.O0 == 0 && k.b(this.f1, 1)) {
                            v.h.h((f)this, (b.b)this.K1());
                            for (var1_12 = 0; var1_12 < var13_2; ++var1_12) {
                                var15_5 /* !! */  = (e)this.L0.get(var1_12);
                                if (!var15_5 /* !! */ .m0() || var15_5 /* !! */  instanceof h || var15_5 /* !! */  instanceof a || var15_5 /* !! */  instanceof l || var15_5 /* !! */ .l0()) continue;
                                var20_15 = var15_5 /* !! */ .u(0);
                                var18_13 /* !! */  = var15_5 /* !! */ .u(1);
                                var19_14 /* !! */  = e.b.i;
                                if (var20_15 == var19_14 /* !! */  && var15_5 /* !! */ .w != 1 && var18_13 /* !! */  == var19_14 /* !! */  && var15_5 /* !! */ .x != 1) continue;
                                var18_13 /* !! */  = new b.a();
                                u.f.U1(0, (e)var15_5 /* !! */ , this.P0, (b.a)var18_13 /* !! */ , b.a.k);
                            }
                        }
                        var4_16 = 2;
                        if (var13_2 > 2 && (var17_11 == (var15_5 /* !! */  = e.b.h) || var16_10 == var15_5 /* !! */ ) && k.b(this.f1, 1024) && v.i.c((f)this, (b.b)this.K1())) {
                            var1_12 = var2_3;
                            if (var17_11 == var15_5 /* !! */ ) {
                                if (var2_3 < this.W() && var2_3 > 0) {
                                    this.l1(var2_3);
                                    this.h1 = true;
                                    var1_12 = var2_3;
                                } else {
                                    var1_12 = this.W();
                                }
                            }
                            var2_3 = var3_4;
                            if (var16_10 == var15_5 /* !! */ ) {
                                if (var3_4 < this.x() && var3_4 > 0) {
                                    this.M0(var3_4);
                                    this.i1 = true;
                                    var2_3 = var3_4;
                                } else {
                                    var2_3 = this.x();
                                }
                            }
                            var9_17 = var1_12;
                            var1_12 = 1;
                            var10_18 = var2_3;
                        } else {
                            var1_12 = 0;
                            var10_18 = var3_4;
                            var9_17 = var2_3;
                        }
                        var2_3 = !this.V1(64) && !this.V1(128) ? 0 : 1;
                        var15_5 /* !! */  = this.R0;
                        var15_5 /* !! */ .i = false;
                        var15_5 /* !! */ .j = false;
                        if (this.f1 != 0 && var2_3 != 0) {
                            var15_5 /* !! */ .j = true;
                        }
                        var18_13 /* !! */  = this.L0;
                        var15_5 /* !! */  = this.A();
                        var11_19 = var15_5 /* !! */  == (var19_14 /* !! */  = e.b.h) || this.T() == var19_14 /* !! */ ;
                        this.W1();
                        for (var2_3 = 0; var2_3 < var13_2; ++var2_3) {
                            var15_5 /* !! */  = (e)this.L0.get(var2_3);
                            if (!(var15_5 /* !! */  instanceof m)) continue;
                            ((m)var15_5 /* !! */ ).t1();
                        }
                        var14_20 = this.V1(64);
                        var3_4 = var1_12;
                        var6_21 = 0;
                        var1_12 = 1;
                        var2_3 = var5_1;
                        var5_1 = var6_21;
                        block11: while (var1_12 != 0) {
                            var12_24 = var5_1 + 1;
                            try {
                                this.R0.E();
                                this.W1();
                                this.m(this.R0);
                                var6_21 = var2_3;
                            }
                            catch (Exception var15_9) {
                                var5_1 = var4_16;
                                var4_16 = var2_3;
                                var2_3 = var1_12;
                            }
lbl78:
                            // 2 sources

                            while (var6_21 < var13_2) {
                                var15_5 /* !! */  = (e)this.L0.get(var6_21);
                                var5_1 = var1_12;
                                break block45;
                            }
                            break block46;
lbl88:
                            // 3 sources

                            while (true) {
                                var15_5 /* !! */ .printStackTrace();
                                var19_14 /* !! */  = System.out;
                                var20_15 = new StringBuilder();
                                var20_15.append("EXCEPTION : ");
                                var20_15.append(var15_5 /* !! */ );
                                var19_14 /* !! */ .println(var20_15.toString());
                                var1_12 = var4_16;
lbl98:
                                // 3 sources

                                while (true) {
                                    if (var2_3 != 0) {
                                        var2_3 = (int)this.b2(this.R0, k.a);
                                    } else {
                                        this.r1(this.R0, var14_20);
                                        for (var2_3 = var1_12; var2_3 < var13_2; ++var2_3) {
                                            ((e)this.L0.get(var2_3)).r1(this.R0, var14_20);
                                        }
                                        var2_3 = var1_12;
                                    }
                                    if (var11_19 && var12_24 < 8 && k.a[var5_1]) {
                                        var7_22 = var6_21 = (var4_16 = var1_12);
                                        while (var4_16 < var13_2) {
                                            var15_5 /* !! */  = (e)this.L0.get(var4_16);
                                            var6_21 = Math.max((int)var6_21, (int)(var15_5 /* !! */ .f0 + var15_5 /* !! */ .W()));
                                            var7_22 = Math.max((int)var7_22, (int)(var15_5 /* !! */ .g0 + var15_5 /* !! */ .x()));
                                            ++var4_16;
                                        }
                                        var8_23 = Math.max((int)this.m0, (int)var6_21);
                                        var7_22 = Math.max((int)this.n0, (int)var7_22);
                                        var15_5 /* !! */  = e.b.h;
                                        var6_21 = var3_4;
                                        var4_16 = var2_3;
                                        if (var17_11 == var15_5 /* !! */ ) {
                                            var6_21 = var3_4;
                                            var4_16 = var2_3;
                                            if (this.W() < var8_23) {
                                                this.l1(var8_23);
                                                this.Z[var1_12] = var15_5 /* !! */ ;
                                                var4_16 = var6_21 = 1;
                                            }
                                        }
                                        var3_4 = var6_21;
                                        var2_3 = var4_16;
                                        if (var16_10 == var15_5 /* !! */ ) {
                                            var3_4 = var6_21;
                                            var2_3 = var4_16;
                                            if (this.x() < var7_22) {
                                                this.M0(var7_22);
                                                this.Z[1] = var15_5 /* !! */ ;
                                                var2_3 = var3_4 = 1;
                                            }
                                        }
                                    }
                                    var6_21 = Math.max((int)this.m0, (int)this.W());
                                    var4_16 = var3_4;
                                    var3_4 = var2_3;
                                    if (var6_21 > this.W()) {
                                        this.l1(var6_21);
                                        this.Z[var1_12] = e.b.g;
                                        var3_4 = var4_16 = 1;
                                    }
                                    var6_21 = Math.max((int)this.n0, (int)this.x());
                                    var2_3 = var4_16;
                                    if (var6_21 > this.x()) {
                                        this.M0(var6_21);
                                        this.Z[1] = e.b.g;
                                        var3_4 = var2_3 = 1;
                                    }
                                    var4_16 = var2_3;
                                    var6_21 = var3_4;
                                    if (var2_3 != 0) ** GOTO lbl-1000
                                    var15_5 /* !! */  = this.Z[var1_12];
                                    var19_14 /* !! */  = e.b.h;
                                    if (var15_5 /* !! */  == var19_14 /* !! */  && var9_17 > 0 && this.W() > var9_17) {
                                        this.h1 = true;
                                        this.Z[var1_12] = e.b.g;
                                        this.l1(var9_17);
                                        var3_4 = var2_3 = 1;
                                    }
                                    var4_16 = var2_3;
                                    var6_21 = var3_4;
                                    if (this.Z[1] != var19_14 /* !! */ ) ** GOTO lbl-1000
                                    var4_16 = var2_3;
                                    var6_21 = var3_4;
                                    if (var10_18 <= 0) ** GOTO lbl-1000
                                    var4_16 = var2_3;
                                    var6_21 = var3_4;
                                    if (this.x() > var10_18) {
                                        this.i1 = true;
                                        this.Z[1] = e.b.g;
                                        this.M0(var10_18);
                                        var3_4 = 1;
                                        var6_21 = 1;
                                    } else lbl-1000:
                                    // 4 sources

                                    {
                                        var3_4 = var4_16;
                                    }
                                    if (var12_24 > 8) {
                                        var6_21 = var1_12;
                                    }
                                    var2_3 = var12_24;
                                    var4_16 = var5_1;
                                    var5_1 = var2_3;
                                    var2_3 = var1_12;
                                    var1_12 = var6_21;
                                    continue block11;
                                    break;
                                }
                                break;
                            }
                        }
                        this.L0 = var18_13 /* !! */ ;
                        if (var3_4 != 0) {
                            var15_5 /* !! */  = this.Z;
                            var15_5 /* !! */ [var2_3] = var17_11;
                            var15_5 /* !! */ [1] = var16_10;
                        }
                        this.w0(this.R0.w());
                        return;
                    }
                    try {}
                    catch (Exception var15_6) {
                        var1_12 = var5_1;
lbl194:
                        // 2 sources

                        while (true) {
                            var5_1 = var4_16;
                            var4_16 = var2_3;
                            var2_3 = var1_12;
                            ** GOTO lbl88
                            break;
                        }
                    }
                    break block48;
                    catch (Exception var15_7) {
                        ** continue;
                    }
                }
                var15_5 /* !! */ .m(this.R0);
                ++var6_21;
                ** GOTO lbl78
            }
            var7_22 = var2_3;
            var6_21 = var4_16;
            var5_1 = var1_12;
            {
                var8_23 = this.x1(this.R0);
                var5_1 = var8_23;
                var15_5 /* !! */  = this.k1;
                if (var15_5 /* !! */  == null) break block47;
                var5_1 = var8_23;
                if (var15_5 /* !! */ .get() == null) break block47;
                var5_1 = var8_23;
                var15_5 /* !! */  = (d)this.k1.get();
                var5_1 = var8_23;
                var19_14 /* !! */  = this.R0;
            }
            try {
                this.C1((d)var15_5 /* !! */ , var19_14 /* !! */ .q(this.P));
                this.k1 = null;
            }
            catch (Exception var15_8) {
                var2_3 = var8_23;
                var4_16 = var7_22;
                var5_1 = var6_21;
                ** continue;
            }
        }
        if ((var15_5 /* !! */  = this.m1) != null && var15_5 /* !! */ .get() != null) {
            this.B1((d)this.m1.get(), this.R0.q(this.R));
            this.m1 = null;
        }
        if ((var15_5 /* !! */  = this.l1) != null && var15_5 /* !! */ .get() != null) {
            this.C1((d)this.l1.get(), this.R0.q(this.O));
            this.l1 = null;
        }
        if ((var15_5 /* !! */  = this.n1) != null && var15_5 /* !! */ .get() != null) {
            this.B1((d)this.n1.get(), this.R0.q(this.Q));
            this.n1 = null;
        }
        var2_3 = var8_23;
        var1_12 = var7_22;
        var5_1 = var6_21;
        if (var8_23 == 0) ** GOTO lbl98
        this.R0.A();
        var2_3 = var8_23;
        var1_12 = var7_22;
        var5_1 = var6_21;
        ** while (true)
    }

    void w1(e e2, int n2) {
        if (n2 == 0) {
            this.y1(e2);
            return;
        }
        if (n2 == 1) {
            this.D1(e2);
        }
    }

    public boolean x1(r.d d3) {
        Object object;
        e e2;
        int n2;
        boolean bl = this.V1(64);
        this.g(d3, bl);
        int n3 = this.L0.size();
        boolean bl2 = false;
        for (n2 = 0; n2 < n3; ++n2) {
            e2 = (e)this.L0.get(n2);
            e2.T0(0, false);
            e2.T0(1, false);
            if (!(e2 instanceof a)) continue;
            bl2 = true;
        }
        if (bl2) {
            for (n2 = 0; n2 < n3; ++n2) {
                e2 = (e)this.L0.get(n2);
                if (!(e2 instanceof a)) continue;
                ((a)e2).z1();
            }
        }
        this.o1.clear();
        for (n2 = 0; n2 < n3; ++n2) {
            e2 = (e)this.L0.get(n2);
            if (!e2.f()) continue;
            if (e2 instanceof l) {
                this.o1.add((Object)e2);
                continue;
            }
            e2.g(d3, bl);
        }
        while (this.o1.size() > 0) {
            n2 = this.o1.size();
            object = this.o1.iterator();
            while (object.hasNext()) {
                e2 = (l)((e)object.next());
                if (!((l)e2).w1(this.o1)) continue;
                e2.g(d3, bl);
                this.o1.remove((Object)e2);
                break;
            }
            if (n2 != this.o1.size()) continue;
            e2 = this.o1.iterator();
            while (e2.hasNext()) {
                ((e)e2.next()).g(d3, bl);
            }
            this.o1.clear();
        }
        if (r.d.s) {
            object = new HashSet();
            for (n2 = 0; n2 < n3; ++n2) {
                e2 = (e)this.L0.get(n2);
                if (e2.f()) continue;
                object.add((Object)e2);
            }
            n2 = this.A() == e.b.h ? 0 : 1;
            this.e(this, d3, (HashSet)object, n2, false);
            e2 = object.iterator();
            while (e2.hasNext()) {
                object = (e)e2.next();
                k.a(this, d3, (e)object);
                ((e)object).g(d3, bl);
            }
        } else {
            for (n2 = 0; n2 < n3; ++n2) {
                e2 = (e)this.L0.get(n2);
                if (e2 instanceof f) {
                    Object object2 = e2.Z;
                    object = object2[0];
                    object2 = object2[1];
                    e.b b2 = e.b.h;
                    if (object == b2) {
                        e2.Q0(e.b.g);
                    }
                    if (object2 == b2) {
                        e2.h1(e.b.g);
                    }
                    e2.g(d3, bl);
                    if (object == b2) {
                        e2.Q0((e.b)((Object)object));
                    }
                    if (object2 != b2) continue;
                    e2.h1((e.b)((Object)object2));
                    continue;
                }
                k.a(this, d3, e2);
                if (e2.f()) continue;
                e2.g(d3, bl);
            }
        }
        if (this.W0 > 0) {
            u.b.b(this, d3, null, 0);
        }
        if (this.X0 > 0) {
            u.b.b(this, d3, null, 1);
        }
        return true;
    }

    public void z1(d d3) {
        WeakReference weakReference = this.n1;
        if (weakReference != null && weakReference.get() != null && d3.e() <= ((d)this.n1.get()).e()) {
            return;
        }
        this.n1 = new WeakReference((Object)d3);
    }
}

