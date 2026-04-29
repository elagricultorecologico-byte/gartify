/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package y0;

import B0.p;
import java.util.ArrayList;
import java.util.List;
import z0.d;

public abstract class c
implements x0.a {
    private final List a = new ArrayList();
    private Object b;
    private d c;
    private a d;

    c(d d2) {
        this.c = d2;
    }

    private void h(a a2, Object object) {
        if (!this.a.isEmpty() && a2 != null) {
            if (object != null && !this.c(object)) {
                a2.a(this.a);
                return;
            }
            a2.b(this.a);
        }
    }

    @Override
    public void a(Object object) {
        this.b = object;
        this.h(this.d, object);
    }

    abstract boolean b(p var1);

    abstract boolean c(Object var1);

    public boolean d(String string) {
        Object object = this.b;
        return object != null && this.c(object) && this.a.contains((Object)string);
    }

    public void e(Iterable iterable) {
        this.a.clear();
        for (p p2 : iterable) {
            if (!this.b(p2)) continue;
            this.a.add((Object)p2.a);
        }
        if (this.a.isEmpty()) {
            this.c.c(this);
        } else {
            this.c.a(this);
        }
        this.h(this.d, this.b);
    }

    public void f() {
        if (!this.a.isEmpty()) {
            this.a.clear();
            this.c.c(this);
        }
    }

    public void g(a a2) {
        if (this.d != a2) {
            this.d = a2;
            this.h(a2, this.b);
        }
    }

    public static interface a {
        public void a(List var1);

        public void b(List var1);
    }
}

