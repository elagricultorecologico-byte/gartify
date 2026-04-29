/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.List
 */
package F3;

import D3.e;
import F3.b;
import F3.m;
import java.util.List;

abstract class l
extends m {
    Object j;

    l() {
    }

    private void V() {
        if (!this.t()) {
            Object object = this.j;
            b b2 = new b();
            this.j = b2;
            if (object != null) {
                b2.F(this.x(), (String)object);
            }
        }
    }

    String T() {
        return this.d(this.x());
    }

    protected l U(m m2) {
        m2 = (l)super.n(m2);
        if (this.t()) {
            ((l)m2).j = ((b)this.j).q();
        }
        return m2;
    }

    @Override
    public String a(String string) {
        this.V();
        return super.a(string);
    }

    @Override
    public m c(String string, String string2) {
        if (!this.t() && string.equals((Object)this.x())) {
            this.j = string2;
            return this;
        }
        this.V();
        super.c(string, string2);
        return this;
    }

    @Override
    public String d(String string) {
        e.j(string);
        if (!this.t()) {
            if (string.equals((Object)this.x())) {
                return (String)this.j;
            }
            return "";
        }
        return super.d(string);
    }

    @Override
    public final b e() {
        this.V();
        return (b)this.j;
    }

    @Override
    public String g() {
        if (this.u()) {
            return this.E().g();
        }
        return "";
    }

    @Override
    public int k() {
        return 0;
    }

    @Override
    protected void o(String string) {
    }

    @Override
    public m q() {
        return this;
    }

    @Override
    protected List r() {
        return m.i;
    }

    @Override
    public boolean s(String string) {
        this.V();
        return super.s(string);
    }

    @Override
    protected final boolean t() {
        return this.j instanceof b;
    }
}

