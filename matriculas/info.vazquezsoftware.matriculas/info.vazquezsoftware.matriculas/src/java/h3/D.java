/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.regex.Pattern
 */
package H3;

import java.util.regex.Pattern;

public abstract class d {
    protected d() {
    }

    public abstract boolean a(F3.h var1, F3.h var2);

    public static final class A
    extends o {
        public A(int n2, int n3) {
            super(n2, n3);
        }

        @Override
        protected int b(F3.h h2, F3.h h3) {
            if (h3.v0() == null) {
                return 0;
            }
            return h3.v0().d0().size() - h3.h0();
        }

        @Override
        protected String c() {
            return "nth-last-child";
        }
    }

    public static class B
    extends o {
        public B(int n2, int n3) {
            super(n2, n3);
        }

        @Override
        protected int b(F3.h object, F3.h h2) {
            object = h2.v0();
            int n2 = 0;
            if (object == null) {
                return 0;
            }
            object = h2.v0().d0();
            for (int i2 = h2.h0(); i2 < object.size(); ++i2) {
                int n3 = n2;
                if (((F3.h)object.get(i2)).F0().equals(h2.F0())) {
                    n3 = n2 + 1;
                }
                n2 = n3;
            }
            return n2;
        }

        @Override
        protected String c() {
            return "nth-last-of-type";
        }
    }

    public static class C
    extends o {
        public C(int n2, int n3) {
            super(n2, n3);
        }

        @Override
        protected int b(F3.h object, F3.h h2) {
            int n2;
            Object object2;
            object = h2.v0();
            int n3 = 0;
            if (object == null) {
                return 0;
            }
            object = h2.v0().d0();
            int n4 = object.size();
            int n5 = 0;
            do {
                n2 = n3;
                if (n5 >= n4) break;
                object2 = object.get(n5);
                ++n5;
                object2 = (F3.h)object2;
                n2 = n3;
                if (((F3.h)object2).F0().equals(h2.F0())) {
                    n2 = n3 + 1;
                }
                n3 = n2;
            } while (object2 != h2);
            return n2;
        }

        @Override
        protected String c() {
            return "nth-of-type";
        }
    }

    public static final class D
    extends d {
        @Override
        public boolean a(F3.h h2, F3.h h3) {
            h2 = h3.v0();
            return h2 != null && !(h2 instanceof F3.f) && h3.E0().isEmpty();
        }

        public String toString() {
            return ":only-child";
        }
    }

    public static final class E
    extends d {
        @Override
        public boolean a(F3.h object, F3.h h2) {
            object = h2.v0();
            if (object != null && !(object instanceof F3.f)) {
                H3.c c2 = ((F3.h)object).d0();
                int n2 = c2.size();
                int n3 = 0;
                int n4 = 0;
                while (n4 < n2) {
                    int n5;
                    object = c2.get(n4);
                    n4 = n5 = n4 + 1;
                    if (!((F3.h)object).F0().equals(h2.F0())) continue;
                    ++n3;
                    n4 = n5;
                }
                if (n3 == 1) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return ":only-of-type";
        }
    }

    public static final class F
    extends d {
        @Override
        public boolean a(F3.h h2, F3.h h3) {
            F3.h h4 = h2;
            if (h2 instanceof F3.f) {
                h4 = h2.b0(0);
            }
            return h3 == h4;
        }

        public String toString() {
            return ":root";
        }
    }

    public static final class G
    extends d {
        @Override
        public boolean a(F3.h h2, F3.h h3) {
            if (h3 instanceof F3.o) {
                return true;
            }
            for (F3.p p2 : h3.I0()) {
                F3.o o2 = new F3.o(G3.h.q(h3.G0()), h3.g(), h3.e());
                p2.M(o2);
                o2.V(p2);
            }
            return false;
        }

        public String toString() {
            return ":matchText";
        }
    }

    public static final class H
    extends d {
        private final Pattern a;

        public H(Pattern pattern) {
            this.a = pattern;
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return this.a.matcher((CharSequence)h3.H0()).find();
        }

        public String toString() {
            return String.format((String)":matches(%s)", (Object[])new Object[]{this.a});
        }
    }

    public static final class I
    extends d {
        private final Pattern a;

        public I(Pattern pattern) {
            this.a = pattern;
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return this.a.matcher((CharSequence)h3.t0()).find();
        }

        public String toString() {
            return String.format((String)":matchesOwn(%s)", (Object[])new Object[]{this.a});
        }
    }

    public static final class J
    extends d {
        private final String a;

        public J(String string) {
            this.a = string;
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return h3.s0().equals((Object)this.a);
        }

        public String toString() {
            return String.format((String)"%s", (Object[])new Object[]{this.a});
        }
    }

    public static final class K
    extends d {
        private final String a;

        public K(String string) {
            this.a = string;
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return h3.s0().endsWith(this.a);
        }

        public String toString() {
            return String.format((String)"%s", (Object[])new Object[]{this.a});
        }
    }

    public static final class a
    extends d {
        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    public static final class b
    extends d {
        private final String a;

        public b(String string) {
            this.a = string;
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return h3.s(this.a);
        }

        public String toString() {
            return String.format((String)"[%s]", (Object[])new Object[]{this.a});
        }
    }

    public static abstract class c
    extends d {
        String a;
        String b;

        public c(String string, String string2) {
            this(string, string2, true);
        }

        public c(String string, String string2, boolean bl) {
            D3.e.h(string);
            D3.e.h(string2);
            this.a = E3.b.b(string);
            boolean bl2 = string2.startsWith("'") && string2.endsWith("'") || string2.startsWith("\"") && string2.endsWith("\"");
            string = string2;
            if (bl2) {
                string = string2.substring(1, string2.length() - 1);
            }
            string = bl ? E3.b.b(string) : E3.b.c(string, bl2);
            this.b = string;
        }
    }

    public static final class d
    extends d {
        private final String a;

        public d(String string) {
            D3.e.h(string);
            this.a = E3.b.a(string);
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            h2 = h3.e().m().iterator();
            while (h2.hasNext()) {
                if (!E3.b.a(((F3.a)h2.next()).b()).startsWith(this.a)) continue;
                return true;
            }
            return false;
        }

        public String toString() {
            return String.format((String)"[^%s]", (Object[])new Object[]{this.a});
        }
    }

    public static final class e
    extends c {
        public e(String string, String string2) {
            super(string, string2);
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return h3.s(this.a) && this.b.equalsIgnoreCase(h3.d(this.a).trim());
        }

        public String toString() {
            return String.format((String)"[%s=%s]", (Object[])new Object[]{this.a, this.b});
        }
    }

    public static final class f
    extends c {
        public f(String string, String string2) {
            super(string, string2);
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return h3.s(this.a) && E3.b.a(h3.d(this.a)).contains((CharSequence)this.b);
        }

        public String toString() {
            return String.format((String)"[%s*=%s]", (Object[])new Object[]{this.a, this.b});
        }
    }

    public static final class g
    extends c {
        public g(String string, String string2) {
            super(string, string2, false);
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return h3.s(this.a) && E3.b.a(h3.d(this.a)).endsWith(this.b);
        }

        public String toString() {
            return String.format((String)"[%s$=%s]", (Object[])new Object[]{this.a, this.b});
        }
    }

    public static final class h
    extends d {
        String a;
        Pattern b;

        public h(String string, Pattern pattern) {
            this.a = E3.b.b(string);
            this.b = pattern;
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return h3.s(this.a) && this.b.matcher((CharSequence)h3.d(this.a)).find();
        }

        public String toString() {
            return String.format((String)"[%s~=%s]", (Object[])new Object[]{this.a, this.b.toString()});
        }
    }

    public static final class i
    extends c {
        public i(String string, String string2) {
            super(string, string2);
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return this.b.equalsIgnoreCase(h3.d(this.a)) ^ true;
        }

        public String toString() {
            return String.format((String)"[%s!=%s]", (Object[])new Object[]{this.a, this.b});
        }
    }

    public static final class j
    extends c {
        public j(String string, String string2) {
            super(string, string2, false);
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return h3.s(this.a) && E3.b.a(h3.d(this.a)).startsWith(this.b);
        }

        public String toString() {
            return String.format((String)"[%s^=%s]", (Object[])new Object[]{this.a, this.b});
        }
    }

    public static final class k
    extends d {
        private final String a;

        public k(String string) {
            this.a = string;
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return h3.k0(this.a);
        }

        public String toString() {
            return String.format((String)".%s", (Object[])new Object[]{this.a});
        }
    }

    public static final class l
    extends d {
        private final String a;

        public l(String string) {
            this.a = E3.b.a(string);
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return E3.b.a(h3.f0()).contains((CharSequence)this.a);
        }

        public String toString() {
            return String.format((String)":containsData(%s)", (Object[])new Object[]{this.a});
        }
    }

    public static final class m
    extends d {
        private final String a;

        public m(String string) {
            this.a = E3.b.a(string);
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return E3.b.a(h3.t0()).contains((CharSequence)this.a);
        }

        public String toString() {
            return String.format((String)":containsOwn(%s)", (Object[])new Object[]{this.a});
        }
    }

    public static final class n
    extends d {
        private final String a;

        public n(String string) {
            this.a = E3.b.a(string);
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return E3.b.a(h3.H0()).contains((CharSequence)this.a);
        }

        public String toString() {
            return String.format((String)":contains(%s)", (Object[])new Object[]{this.a});
        }
    }

    public static abstract class o
    extends d {
        protected final int a;
        protected final int b;

        public o(int n2, int n3) {
            this.a = n2;
            this.b = n3;
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            F3.h h4 = h3.v0();
            if (h4 != null && !(h4 instanceof F3.f)) {
                int n2 = this.b(h2, h3);
                int n3 = this.a;
                if (n3 == 0) {
                    return n2 == this.b;
                }
                int n4 = this.b;
                if ((n2 - n4) * n3 >= 0 && (n2 - n4) % n3 == 0) {
                    return true;
                }
            }
            return false;
        }

        protected abstract int b(F3.h var1, F3.h var2);

        protected abstract String c();

        public String toString() {
            if (this.a == 0) {
                return String.format((String)":%s(%d)", (Object[])new Object[]{this.c(), this.b});
            }
            if (this.b == 0) {
                return String.format((String)":%s(%dn)", (Object[])new Object[]{this.c(), this.a});
            }
            return String.format((String)":%s(%dn%+d)", (Object[])new Object[]{this.c(), this.a, this.b});
        }
    }

    public static final class p
    extends d {
        private final String a;

        public p(String string) {
            this.a = string;
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return this.a.equals((Object)h3.n0());
        }

        public String toString() {
            return String.format((String)"#%s", (Object[])new Object[]{this.a});
        }
    }

    public static final class q
    extends r {
        public q(int n2) {
            super(n2);
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return h3.h0() == this.a;
        }

        public String toString() {
            return String.format((String)":eq(%d)", (Object[])new Object[]{this.a});
        }
    }

    public static abstract class r
    extends d {
        int a;

        public r(int n2) {
            this.a = n2;
        }
    }

    public static final class s
    extends r {
        public s(int n2) {
            super(n2);
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return h3.h0() > this.a;
        }

        public String toString() {
            return String.format((String)":gt(%d)", (Object[])new Object[]{this.a});
        }
    }

    public static final class t
    extends r {
        public t(int n2) {
            super(n2);
        }

        @Override
        public boolean a(F3.h h2, F3.h h3) {
            return h2 != h3 && h3.h0() < this.a;
        }

        public String toString() {
            return String.format((String)":lt(%d)", (Object[])new Object[]{this.a});
        }
    }

    public static final class u
    extends d {
        @Override
        public boolean a(F3.h m22, F3.h h2) {
            for (F3.m m22 : h2.l()) {
                if (m22 instanceof F3.d || m22 instanceof F3.q || m22 instanceof F3.g) continue;
                return false;
            }
            return true;
        }

        public String toString() {
            return ":empty";
        }
    }

    public static final class v
    extends d {
        @Override
        public boolean a(F3.h h2, F3.h h3) {
            h2 = h3.v0();
            return h2 != null && !(h2 instanceof F3.f) && h3.h0() == 0;
        }

        public String toString() {
            return ":first-child";
        }
    }

    public static final class w
    extends C {
        public w() {
            super(0, 1);
        }

        @Override
        public String toString() {
            return ":first-of-type";
        }
    }

    public static final class x
    extends d {
        @Override
        public boolean a(F3.h h2, F3.h h3) {
            h2 = h3.v0();
            return h2 != null && !(h2 instanceof F3.f) && h3.h0() == h2.d0().size() - 1;
        }

        public String toString() {
            return ":last-child";
        }
    }

    public static final class y
    extends B {
        public y() {
            super(0, 1);
        }

        @Override
        public String toString() {
            return ":last-of-type";
        }
    }

    public static final class z
    extends o {
        public z(int n2, int n3) {
            super(n2, n3);
        }

        @Override
        protected int b(F3.h h2, F3.h h3) {
            return h3.h0() + 1;
        }

        @Override
        protected String c() {
            return "nth-child";
        }
    }
}

