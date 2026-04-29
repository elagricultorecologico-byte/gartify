/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package H3;

import F3.h;
import F3.m;
import H3.c;
import H3.d;
import H3.e;
import H3.f;
import H3.g;

public abstract class a {
    public static c a(d d2, h h2) {
        c c2 = new c();
        f.b(new a(h2, c2, d2), h2);
        return c2;
    }

    public static h b(d object, h h2) {
        object = new b(h2, (d)object);
        f.a((e)object, h2);
        return ((b)object).b;
    }

    private static class a
    implements g {
        private final h a;
        private final c b;
        private final d c;

        a(h h2, c c2, d d2) {
            this.a = h2;
            this.b = c2;
            this.c = d2;
        }

        @Override
        public void a(m m2, int n2) {
        }

        @Override
        public void b(m m2, int n2) {
            if (m2 instanceof h && this.c.a(this.a, (h)(m2 = (h)m2))) {
                this.b.add(m2);
            }
        }
    }

    private static class b
    implements e {
        private final h a;
        private h b = null;
        private final d c;

        b(h h2, d d2) {
            this.a = h2;
            this.c = d2;
        }

        @Override
        public e.a a(m m2, int n2) {
            return e.a.g;
        }

        @Override
        public e.a b(m m2, int n2) {
            if (m2 instanceof h && this.c.a(this.a, (h)(m2 = (h)m2))) {
                this.b = m2;
                return e.a.k;
            }
            return e.a.g;
        }
    }
}

