/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.String
 */
package j3;

import L2.i;
import c3.h0;
import j3.a;

public abstract class f
extends h0 {
    private final int j;
    private final int k;
    private final long l;
    private final String m;
    private a n;

    public f(int n2, int n3, long l2, String string) {
        this.j = n2;
        this.k = n3;
        this.l = l2;
        this.m = string;
        this.n = this.N0();
    }

    private final a N0() {
        return new a(this.j, this.k, this.l, this.m);
    }

    @Override
    public void J0(i i2, Runnable runnable) {
        a.M(this.n, runnable, false, false, 6, null);
    }

    public final void O0(Runnable runnable, boolean bl, boolean bl2) {
        this.n.L(runnable, bl, bl2);
    }
}

