/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Reader
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package G3;

import D3.e;
import F3.c;
import F3.d;
import F3.f;
import F3.i;
import F3.p;
import G3.f;
import G3.g;
import G3.h;
import G3.i;
import G3.m;
import java.io.Reader;

public class n
extends m {
    private void o(F3.m m2) {
        this.a().V(m2);
    }

    private void p(i.g object) {
        int n2;
        Object object2;
        block4: {
            object2 = this.h.c(((i.i)object).b);
            for (n2 = this.e.size() - 1; n2 >= 0; --n2) {
                object = (F3.h)this.e.get(n2);
                if (!((F3.h)object).x().equals(object2)) {
                    continue;
                }
                break block4;
            }
            object = null;
        }
        if (object != null) {
            for (n2 = this.e.size() - 1; n2 >= 0; --n2) {
                object2 = (F3.h)this.e.get(n2);
                this.e.remove(n2);
                if (object2 == object) break;
            }
        }
    }

    @Override
    f b() {
        return G3.f.d;
    }

    @Override
    protected void d(Reader reader, String string, g g2) {
        super.d(reader, string, g2);
        this.e.add((Object)this.d);
        this.d.R0().q(f.a.a.h).g(i.c.k).m(false);
    }

    @Override
    protected boolean f(i i2) {
        switch (G3.n$a.a[i2.a.ordinal()]) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected token type: ");
                stringBuilder.append((Object)i2.a);
                D3.e.a(stringBuilder.toString());
                break;
            }
            case 5: {
                this.n(i2.c());
                break;
            }
            case 4: {
                this.l(i2.a());
                break;
            }
            case 3: {
                this.m(i2.b());
                break;
            }
            case 2: {
                this.p(i2.d());
                break;
            }
            case 1: {
                this.k(i2.e());
            }
            case 6: 
        }
        return true;
    }

    F3.h k(i.h h2) {
        h h3 = G3.h.r(h2.C(), this.h);
        if (h2.z()) {
            h2.j.r(this.h);
        }
        F3.h h4 = new F3.h(h3, null, this.h.b(h2.j));
        this.o(h4);
        if (h2.A()) {
            if (!h3.i()) {
                h3.o();
            }
            return h4;
        }
        this.e.add((Object)h4);
        return h4;
    }

    void l(i.c object) {
        String string = ((i.c)object).q();
        object = ((i)object).f() ? new c(string) : new p(string);
        this.o((F3.m)object);
    }

    void m(i.d object) {
        d d2 = new d(((i.d)object).s());
        Object object2 = d2;
        if (((i.d)object).d) {
            object2 = d2;
            if (d2.Z()) {
                object = d2.W();
                object2 = d2;
                if (object != null) {
                    object2 = object;
                }
            }
        }
        this.o((F3.m)object2);
    }

    void n(i.e e2) {
        F3.g g2 = new F3.g(this.h.c(e2.p()), e2.r(), e2.s());
        g2.X(e2.q());
        this.o(g2);
    }
}

