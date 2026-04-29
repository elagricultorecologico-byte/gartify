/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Throwable
 */
package c3;

import c3.p;
import c3.p0;
import c3.r;
import c3.u0;

final class q
extends u0
implements p {
    public final r e;

    public q(r r2) {
        this.e = r2;
    }

    @Override
    public boolean b(Throwable throwable) {
        return this.v().u(throwable);
    }

    @Override
    public p0 getParent() {
        return this.v();
    }

    @Override
    public boolean w() {
        return true;
    }

    @Override
    public void x(Throwable throwable) {
        this.e.A0(this.v());
    }
}

