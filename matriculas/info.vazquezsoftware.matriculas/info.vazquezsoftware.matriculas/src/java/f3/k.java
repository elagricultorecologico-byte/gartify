/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package F3;

import F3.b;
import F3.h;
import F3.m;
import H3.c;

public class k
extends h {
    private final c q = new c();

    public k(G3.h h2, String string, b b2) {
        super(h2, string, b2);
    }

    @Override
    protected void J(m m2) {
        super.J(m2);
        this.q.remove(m2);
    }

    public k J0(h h2) {
        this.q.add(h2);
        return this;
    }

    public k K0() {
        return (k)super.e0();
    }
}

