/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.HashSet
 *  v.b$a
 */
package u;

import java.util.HashSet;
import u.e;
import u.f;
import u.h;
import u.j;
import v.b;

public abstract class l
extends j {
    private int N0 = 0;
    private int O0 = 0;
    private int P0 = 0;
    private int Q0 = 0;
    private int R0 = 0;
    private int S0 = 0;
    private int T0 = 0;
    private int U0 = 0;
    private boolean V0 = false;
    private int W0 = 0;
    private int X0 = 0;
    protected b.a Y0 = new b.a();
    b.b Z0 = null;

    public int A1() {
        return this.T0;
    }

    public int B1() {
        return this.U0;
    }

    public int C1() {
        return this.N0;
    }

    public abstract void D1(int var1, int var2, int var3, int var4);

    protected void E1(e e2, e.b b2, int n2, e.b b3, int n3) {
        while (this.Z0 == null && this.K() != null) {
            this.Z0 = ((f)this.K()).K1();
        }
        b.a a2 = this.Y0;
        a2.a = b2;
        a2.b = b3;
        a2.c = n2;
        a2.d = n3;
        this.Z0.b(e2, a2);
        e2.l1(this.Y0.e);
        e2.M0(this.Y0.f);
        e2.L0(this.Y0.h);
        e2.B0(this.Y0.g);
    }

    protected boolean F1() {
        Object object = this.a0;
        object = object != null ? ((f)object).K1() : null;
        if (object == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.M0; ++i2) {
            e e2 = this.L0[i2];
            if (e2 == null || e2 instanceof h) continue;
            e.b b2 = e2.u(0);
            e.b b3 = e2.u(1);
            e.b b4 = e.b.i;
            if (b2 == b4 && e2.w != 1 && b3 == b4 && e2.x != 1) continue;
            e.b b5 = b2;
            if (b2 == b4) {
                b5 = e.b.h;
            }
            b2 = b3;
            if (b3 == b4) {
                b2 = e.b.h;
            }
            b3 = this.Y0;
            ((b.a)b3).a = b5;
            ((b.a)b3).b = b2;
            ((b.a)b3).c = e2.W();
            this.Y0.d = e2.x();
            object.b(e2, this.Y0);
            e2.l1(this.Y0.e);
            e2.M0(this.Y0.f);
            e2.B0(this.Y0.g);
        }
        return true;
    }

    public boolean G1() {
        return this.V0;
    }

    protected void H1(boolean bl) {
        this.V0 = bl;
    }

    public void I1(int n2, int n3) {
        this.W0 = n2;
        this.X0 = n3;
    }

    public void J1(int n2) {
        this.P0 = n2;
        this.N0 = n2;
        this.Q0 = n2;
        this.O0 = n2;
        this.R0 = n2;
        this.S0 = n2;
    }

    public void K1(int n2) {
        this.O0 = n2;
    }

    public void L1(int n2) {
        this.S0 = n2;
    }

    public void M1(int n2) {
        this.P0 = n2;
        this.T0 = n2;
    }

    public void N1(int n2) {
        this.Q0 = n2;
        this.U0 = n2;
    }

    public void O1(int n2) {
        this.R0 = n2;
        this.T0 = n2;
        this.U0 = n2;
    }

    public void P1(int n2) {
        this.N0 = n2;
    }

    @Override
    public void b(f f2) {
        this.v1();
    }

    public void u1(boolean bl) {
        int n2 = this.R0;
        if (n2 <= 0 && this.S0 <= 0) {
            return;
        }
        if (bl) {
            this.T0 = this.S0;
            this.U0 = n2;
            return;
        }
        this.T0 = n2;
        this.U0 = this.S0;
    }

    public void v1() {
        for (int i2 = 0; i2 < this.M0; ++i2) {
            e e2 = this.L0[i2];
            if (e2 == null) continue;
            e2.V0(true);
        }
    }

    public boolean w1(HashSet hashSet) {
        for (int i2 = 0; i2 < this.M0; ++i2) {
            if (!hashSet.contains((Object)this.L0[i2])) continue;
            return true;
        }
        return false;
    }

    public int x1() {
        return this.X0;
    }

    public int y1() {
        return this.W0;
    }

    public int z1() {
        return this.O0;
    }
}

