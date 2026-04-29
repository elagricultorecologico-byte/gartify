/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Reader
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package G3;

import F3.b;
import F3.h;
import G3.a;
import G3.d;
import G3.e;
import G3.f;
import G3.g;
import G3.i;
import G3.k;
import java.io.Reader;
import java.util.ArrayList;

abstract class m {
    protected g a;
    a b;
    k c;
    protected F3.f d;
    protected ArrayList e;
    protected String f;
    protected i g;
    protected f h;
    private i.h i = new i.h();
    private i.g j = new i.g();

    m() {
    }

    protected h a() {
        int n2 = this.e.size();
        if (n2 > 0) {
            return (h)this.e.get(n2 - 1);
        }
        return null;
    }

    abstract f b();

    protected void c(String string) {
        e e2 = this.a.a();
        if (e2.c()) {
            e2.add(new d(this.b.I(), string));
        }
    }

    protected void d(Reader reader, String string, g g2) {
        F3.f f2;
        D3.e.k(reader, "String input must not be null");
        D3.e.k(string, "BaseURI must not be null");
        D3.e.j(g2);
        this.d = f2 = new F3.f(string);
        f2.S0(g2);
        this.a = g2;
        this.h = g2.e();
        this.b = new a(reader);
        this.g = null;
        this.c = new k(this.b, g2.a());
        this.e = new ArrayList(32);
        this.f = string;
    }

    F3.f e(Reader reader, String string, g g2) {
        this.d(reader, string, g2);
        this.j();
        this.b.d();
        this.b = null;
        this.c = null;
        this.e = null;
        return this.d;
    }

    protected abstract boolean f(i var1);

    protected boolean g(String string) {
        i i2 = this.g;
        i.g g2 = this.j;
        if (i2 == g2) {
            return this.f(new i.g().B(string));
        }
        return this.f(g2.F().B(string));
    }

    protected boolean h(String string) {
        i.h h2 = this.i;
        if (this.g == h2) {
            return this.f(new i.h().B(string));
        }
        return this.f(h2.F().B(string));
    }

    public boolean i(String string, b b2) {
        i.h h2 = this.i;
        if (this.g == h2) {
            return this.f(new i.h().I(string, b2));
        }
        h2.F();
        h2.I(string, b2);
        return this.f(h2);
    }

    protected void j() {
        i i2;
        k k2 = this.c;
        i.j j2 = i.j.l;
        do {
            i2 = k2.v();
            this.f(i2);
            i2.m();
        } while (i2.a != j2);
    }
}

