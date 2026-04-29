/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.regex.Pattern
 */
package F3;

import F3.c;
import F3.d;
import F3.e;
import F3.f;
import F3.m;
import F3.n;
import F3.p;
import H3.a;
import H3.d;
import H3.f;
import H3.g;
import H3.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class h
extends m {
    private static final List n = Collections.EMPTY_LIST;
    private static final Pattern o = Pattern.compile((String)"\\s+");
    private static final String p = F3.b.A("baseUri");
    private G3.h j;
    private WeakReference k;
    List l;
    private F3.b m;

    public h(G3.h h2, String string) {
        this(h2, string, null);
    }

    public h(G3.h h2, String string, F3.b b2) {
        D3.e.j(h2);
        this.l = F3.m.i;
        this.m = b2;
        this.j = h2;
        if (string != null) {
            this.O(string);
        }
    }

    private static String B0(h h2, String string) {
        while (h2 != null) {
            F3.b b2 = h2.m;
            if (b2 != null && b2.u(string)) {
                return h2.m.s(string);
            }
            h2 = h2.v0();
        }
        return "";
    }

    private static void X(StringBuilder stringBuilder, p p2) {
        String string = p2.X();
        if (!F3.h.y0(p2.g) && !(p2 instanceof c)) {
            E3.c.a(stringBuilder, string, F3.p.Z(stringBuilder));
            return;
        }
        stringBuilder.append(string);
    }

    private static void Y(h h2, StringBuilder stringBuilder) {
        if (h2.j.c().equals((Object)"br") && !F3.p.Z(stringBuilder)) {
            stringBuilder.append(" ");
        }
    }

    private static int o0(h h2, List list) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (list.get(i2) != h2) continue;
            return i2;
        }
        return 0;
    }

    private boolean q0(f.a a2) {
        return this.j.b() || this.v0() != null && this.v0().F0().b() || a2.k();
        {
        }
    }

    private boolean r0(f.a a2) {
        return this.F0().h() && !this.F0().e() && (this.v0() == null || this.v0().p0()) && this.G() != null && !a2.k();
    }

    private void u0(StringBuilder stringBuilder) {
        for (m m2 : this.l) {
            if (m2 instanceof p) {
                F3.h.X(stringBuilder, (p)m2);
                continue;
            }
            if (!(m2 instanceof h)) continue;
            F3.h.Y((h)m2, stringBuilder);
        }
    }

    static boolean y0(m m2) {
        if (m2 instanceof h) {
            h h2;
            m2 = (h)m2;
            int n2 = 0;
            do {
                if (((h)m2).j.m()) {
                    return true;
                }
                h2 = ((h)m2).v0();
                if (++n2 >= 6) break;
                m2 = h2;
            } while (h2 != null);
        }
        return false;
    }

    public h A0() {
        return (h)super.N();
    }

    @Override
    void B(Appendable appendable, int n2, f.a a2) {
        if (a2.n() && this.q0(a2) && !this.r0(a2)) {
            if (appendable instanceof StringBuilder) {
                if (((StringBuilder)appendable).length() > 0) {
                    this.v(appendable, n2, a2);
                }
            } else {
                this.v(appendable, n2, a2);
            }
        }
        appendable.append('<').append((CharSequence)this.G0());
        F3.b b2 = this.m;
        if (b2 != null) {
            b2.x(appendable, a2);
        }
        if (this.l.isEmpty() && this.j.k()) {
            if (a2.o() == f.a.a.g && this.j.e()) {
                appendable.append('>');
                return;
            }
            appendable.append((CharSequence)" />");
            return;
        }
        appendable.append('>');
    }

    @Override
    void C(Appendable appendable, int n2, f.a a2) {
        if (this.l.isEmpty() && this.j.k()) {
            return;
        }
        if (a2.n() && !this.l.isEmpty() && (this.j.b() || a2.k() && (this.l.size() > 1 || this.l.size() == 1 && !(this.l.get(0) instanceof p)))) {
            this.v(appendable, n2, a2);
        }
        appendable.append((CharSequence)"</").append((CharSequence)this.G0()).append('>');
    }

    public H3.c C0(String string) {
        return H3.i.b(string, this);
    }

    public h D0(String string) {
        return H3.i.c(string, this);
    }

    public H3.c E0() {
        if (this.g == null) {
            return new H3.c(0);
        }
        List list = this.v0().c0();
        H3.c c2 = new H3.c(list.size() - 1);
        for (h h2 : list) {
            if (h2 == this) continue;
            c2.add(h2);
        }
        return c2;
    }

    public G3.h F0() {
        return this.j;
    }

    public String G0() {
        return this.j.c();
    }

    public String H0() {
        StringBuilder stringBuilder = E3.c.b();
        f.b(new g(this, stringBuilder){
            final StringBuilder a;
            final h b;
            {
                this.b = h2;
                this.a = stringBuilder;
            }

            @Override
            public void a(m m2, int n2) {
                if (m2 instanceof h && ((h)m2).p0() && m2.w() instanceof p && !F3.p.Z(this.a)) {
                    this.a.append(' ');
                }
            }

            @Override
            public void b(m m2, int n2) {
                if (m2 instanceof p) {
                    m2 = (p)m2;
                    F3.h.X(this.a, (p)m2);
                    return;
                }
                if (m2 instanceof h) {
                    m2 = (h)m2;
                    if (this.a.length() > 0 && (((h)m2).p0() || ((h)m2).j.c().equals((Object)"br")) && !F3.p.Z(this.a)) {
                        this.a.append(' ');
                    }
                }
            }
        }, this);
        return E3.c.n(stringBuilder).trim();
    }

    public List I0() {
        ArrayList arrayList = new ArrayList();
        for (m m2 : this.l) {
            if (!(m2 instanceof p)) continue;
            arrayList.add((Object)((p)m2));
        }
        return Collections.unmodifiableList((List)arrayList);
    }

    public h V(m m2) {
        D3.e.j(m2);
        this.K(m2);
        this.r();
        this.l.add((Object)m2);
        m2.Q(this.l.size() - 1);
        return this;
    }

    public h W(String object) {
        object = new h(G3.h.r((String)object, F3.n.b(this).e()), this.g());
        this.V((m)object);
        return object;
    }

    public h Z(String string, String string2) {
        super.c(string, string2);
        return this;
    }

    public h a0(m m2) {
        return (h)super.h(m2);
    }

    public h b0(int n2) {
        return (h)this.c0().get(n2);
    }

    List c0() {
        if (this.k() == 0) {
            return n;
        }
        WeakReference weakReference = this.k;
        if (weakReference != null && (weakReference = (List)weakReference.get()) != null) {
            return weakReference;
        }
        int n2 = this.l.size();
        weakReference = new ArrayList(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            m m2 = (m)this.l.get(i2);
            if (!(m2 instanceof h)) continue;
            weakReference.add((Object)((h)m2));
        }
        this.k = new WeakReference((Object)weakReference);
        return weakReference;
    }

    public H3.c d0() {
        return new H3.c(this.c0());
    }

    @Override
    public F3.b e() {
        if (this.m == null) {
            this.m = new F3.b();
        }
        return this.m;
    }

    public h e0() {
        return (h)super.m();
    }

    public String f0() {
        StringBuilder stringBuilder = E3.c.b();
        for (m m2 : this.l) {
            if (m2 instanceof e) {
                stringBuilder.append(((e)m2).X());
                continue;
            }
            if (m2 instanceof d) {
                stringBuilder.append(((d)m2).Y());
                continue;
            }
            if (m2 instanceof h) {
                stringBuilder.append(((h)m2).f0());
                continue;
            }
            if (!(m2 instanceof c)) continue;
            stringBuilder.append(((c)m2).X());
        }
        return E3.c.n(stringBuilder);
    }

    @Override
    public String g() {
        return F3.h.B0(this, p);
    }

    protected h g0(m object) {
        h h2 = (h)super.n((m)object);
        object = this.m;
        object = object != null ? ((F3.b)object).q() : null;
        h2.m = object;
        object = new b(h2, this.l.size());
        h2.l = object;
        object.addAll((Collection)this.l);
        return h2;
    }

    public int h0() {
        if (this.v0() == null) {
            return 0;
        }
        return F3.h.o0(this, this.v0().c0());
    }

    public h i0() {
        this.l.clear();
        return this;
    }

    public H3.c j0() {
        return a.a(new d.a(), this);
    }

    @Override
    public int k() {
        return this.l.size();
    }

    public boolean k0(String string) {
        Object object = this.m;
        if (object == null) {
            return false;
        }
        object = ((F3.b)object).t("class");
        int n2 = object.length();
        int n3 = string.length();
        if (n2 != 0 && n2 >= n3) {
            int n4;
            if (n2 == n3) {
                return string.equalsIgnoreCase((String)object);
            }
            int n5 = n4 = 0;
            for (int i2 = 0; i2 < n2; ++i2) {
                int n6;
                if (Character.isWhitespace((char)object.charAt(i2))) {
                    if (n4 != 0) {
                        if (i2 - n5 == n3 && object.regionMatches(true, n5, string, 0, n3)) {
                            return true;
                        }
                        n6 = 0;
                    } else {
                        n6 = n4;
                    }
                } else {
                    n6 = n4;
                    if (n4 == 0) {
                        n5 = i2;
                        n6 = 1;
                    }
                }
                n4 = n6;
            }
            if (n4 != 0 && n2 - n5 == n3) {
                return object.regionMatches(true, n5, string, 0, n3);
            }
        }
        return false;
    }

    public Appendable l0(Appendable appendable) {
        int n2 = this.l.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((m)this.l.get(i2)).A(appendable);
        }
        return appendable;
    }

    public String m0() {
        Object object = E3.c.b();
        this.l0((Appendable)object);
        String string = E3.c.n(object);
        object = string;
        if (F3.n.a(this).n()) {
            object = string.trim();
        }
        return object;
    }

    public String n0() {
        F3.b b2 = this.m;
        if (b2 != null) {
            return b2.t("id");
        }
        return "";
    }

    @Override
    protected void o(String string) {
        this.e().F(p, string);
    }

    public boolean p0() {
        return this.j.d();
    }

    @Override
    protected List r() {
        if (this.l == F3.m.i) {
            this.l = new b(this, 4);
        }
        return this.l;
    }

    public String s0() {
        return this.j.l();
    }

    @Override
    protected boolean t() {
        return this.m != null;
    }

    public String t0() {
        StringBuilder stringBuilder = E3.c.b();
        this.u0(stringBuilder);
        return E3.c.n(stringBuilder).trim();
    }

    public final h v0() {
        return (h)this.g;
    }

    public h w0(m m2) {
        D3.e.j(m2);
        this.b(0, m2);
        return this;
    }

    @Override
    public String x() {
        return this.j.c();
    }

    public h x0(String object) {
        object = new h(G3.h.r((String)object, F3.n.b(this).e()), this.g());
        this.w0((m)object);
        return object;
    }

    @Override
    void y() {
        super.y();
        this.k = null;
    }

    public h z0() {
        if (this.g == null) {
            return null;
        }
        List list = this.v0().c0();
        int n2 = F3.h.o0(this, list);
        if (n2 > 0) {
            return (h)list.get(n2 - 1);
        }
        return null;
    }

    private static final class b
    extends D3.a {
        private final h g;

        b(h h2, int n2) {
            super(n2);
            this.g = h2;
        }

        @Override
        public void c() {
            this.g.y();
        }
    }
}

