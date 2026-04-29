/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.ArrayList
 */
package u;

import java.util.ArrayList;
import r.c;
import u.e;

public abstract class m
extends e {
    public ArrayList L0 = new ArrayList();

    public void a(e e2) {
        this.L0.add((Object)e2);
        if (e2.K() != null) {
            ((m)e2.K()).u1(e2);
        }
        e2.d1(this);
    }

    public ArrayList s1() {
        return this.L0;
    }

    @Override
    public void t0() {
        this.L0.clear();
        super.t0();
    }

    public abstract void t1();

    public void u1(e e2) {
        this.L0.remove((Object)e2);
        e2.t0();
    }

    public void v1() {
        this.L0.clear();
    }

    @Override
    public void w0(c c3) {
        super.w0(c3);
        int n2 = this.L0.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((e)this.L0.get(i2)).w0(c3);
        }
    }
}

