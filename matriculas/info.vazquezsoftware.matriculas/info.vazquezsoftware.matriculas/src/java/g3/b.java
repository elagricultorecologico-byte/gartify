/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Reader
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.List
 */
package G3;

import D3.e;
import F3.k;
import F3.p;
import G3.c;
import G3.d;
import G3.f;
import G3.g;
import G3.h;
import G3.i;
import G3.l;
import G3.m;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class b
extends m {
    static final String[] A;
    static final String[] B;
    static final String[] C;
    static final String[] D;
    static final String[] x;
    static final String[] y;
    static final String[] z;
    private c k;
    private c l;
    private boolean m;
    private F3.h n;
    private k o;
    private F3.h p;
    private ArrayList q;
    private List r;
    private i.g s;
    private boolean t;
    private boolean u;
    private boolean v;
    private String[] w = new String[]{null};

    static {
        x = new String[]{"applet", "caption", "html", "marquee", "object", "table", "td", "th"};
        y = new String[]{"ol", "ul"};
        z = new String[]{"button"};
        A = new String[]{"html", "table"};
        B = new String[]{"optgroup", "option"};
        C = new String[]{"dd", "dt", "li", "optgroup", "option", "p", "rp", "rt"};
        D = new String[]{"address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};
    }

    private boolean K(String string, String[] stringArray, String[] stringArray2) {
        String[] stringArray3 = this.w;
        stringArray3[0] = string;
        return this.L(stringArray3, stringArray, stringArray2);
    }

    private boolean L(String[] stringArray, String[] stringArray2, String[] stringArray3) {
        int n2 = this.e.size();
        int n3 = n2 - 1;
        n2 = n3 > 100 ? (n2 -= 101) : 0;
        while (n3 >= n2) {
            String string = ((F3.h)this.e.get(n3)).s0();
            if (E3.c.d(string, stringArray)) {
                return true;
            }
            if (E3.c.d(string, stringArray2)) {
                return false;
            }
            if (stringArray3 != null && E3.c.d(string, stringArray3)) {
                return false;
            }
            --n3;
        }
        return false;
    }

    private void V(F3.m m2) {
        k k2;
        if (this.e.isEmpty()) {
            this.d.V(m2);
        } else if (this.a0()) {
            this.T(m2);
        } else {
            this.a().V(m2);
        }
        if (m2 instanceof F3.h && ((F3.h)(m2 = (F3.h)m2)).F0().g() && (k2 = this.o) != null) {
            k2.J0((F3.h)m2);
        }
    }

    private boolean Z(ArrayList arrayList, F3.h h2) {
        int n2 = arrayList.size();
        int n3 = n2 - 1;
        n2 = n3 >= 256 ? (n2 -= 257) : 0;
        while (n3 >= n2) {
            if ((F3.h)arrayList.get(n3) == h2) {
                return true;
            }
            --n3;
        }
        return false;
    }

    private boolean d0(F3.h h2, F3.h h3) {
        return h2.s0().equals((Object)h3.s0()) && h2.e().equals(h3.e());
    }

    private void n(String ... stringArray) {
        F3.h h2;
        for (int i2 = this.e.size() - 1; i2 >= 0 && !E3.c.c((h2 = (F3.h)this.e.get(i2)).s0(), stringArray) && !h2.s0().equals((Object)"html"); --i2) {
            this.e.remove(i2);
        }
    }

    private void z0(ArrayList arrayList, F3.h h2, F3.h h3) {
        int n2 = arrayList.lastIndexOf((Object)h2);
        boolean bl = n2 != -1;
        D3.e.d(bl);
        arrayList.set(n2, (Object)h3);
    }

    F3.h A(String string) {
        for (int i2 = this.e.size() - 1; i2 >= 0; --i2) {
            F3.h h2 = (F3.h)this.e.get(i2);
            if (!h2.s0().equals((Object)string)) continue;
            return h2;
        }
        return null;
    }

    void A0(F3.h h2, F3.h h3) {
        this.z0(this.e, h2, h3);
    }

    F3.h B() {
        return this.n;
    }

    void B0() {
        boolean bl = false;
        for (int i2 = this.e.size() - 1; i2 >= 0; --i2) {
            Object object = (F3.h)this.e.get(i2);
            if (i2 == 0) {
                object = this.p;
                bl = true;
            }
            if ("select".equals(object = object != null ? ((F3.h)object).s0() : "")) {
                this.G0(G3.c.v);
                return;
            }
            if (!("td".equals(object) || "th".equals(object) && !bl)) {
                if ("tr".equals(object)) {
                    this.G0(G3.c.t);
                    return;
                }
                if (!("tbody".equals(object) || "thead".equals(object) || "tfoot".equals(object))) {
                    if ("caption".equals(object)) {
                        this.G0(G3.c.q);
                        return;
                    }
                    if ("colgroup".equals(object)) {
                        this.G0(G3.c.r);
                        return;
                    }
                    if ("table".equals(object)) {
                        this.G0(G3.c.o);
                        return;
                    }
                    if ("head".equals(object)) {
                        this.G0(G3.c.m);
                        return;
                    }
                    if ("body".equals(object)) {
                        this.G0(G3.c.m);
                        return;
                    }
                    if ("frameset".equals(object)) {
                        this.G0(G3.c.y);
                        return;
                    }
                    if ("html".equals(object)) {
                        this.G0(G3.c.i);
                        return;
                    }
                    if (!bl) continue;
                    this.G0(G3.c.m);
                    return;
                }
                this.G0(G3.c.s);
                return;
            }
            this.G0(G3.c.u);
            break;
        }
    }

    List C() {
        return this.r;
    }

    void C0(k k2) {
        this.o = k2;
    }

    ArrayList D() {
        return this.e;
    }

    void D0(boolean bl) {
        this.u = bl;
    }

    boolean E(String string) {
        return this.H(string, z);
    }

    void E0(F3.h h2) {
        this.n = h2;
    }

    boolean F(String string) {
        return this.H(string, y);
    }

    c F0() {
        return this.k;
    }

    boolean G(String string) {
        return this.H(string, null);
    }

    void G0(c c2) {
        this.k = c2;
    }

    boolean H(String string, String[] stringArray) {
        return this.K(string, x, stringArray);
    }

    boolean I(String[] stringArray) {
        return this.L(stringArray, x, null);
    }

    boolean J(String string) {
        for (int i2 = this.e.size() - 1; i2 >= 0; --i2) {
            String string2 = ((F3.h)this.e.get(i2)).s0();
            if (string2.equals((Object)string)) {
                return true;
            }
            if (E3.c.d(string2, B)) continue;
            return false;
        }
        D3.e.a("Should not be reachable");
        return false;
    }

    boolean M(String string) {
        return this.K(string, A, null);
    }

    F3.h N(i.h object) {
        if (((i.i)object).z() && !((i.i)object).j.isEmpty() && ((i.i)object).j.r(this.h) > 0) {
            this.c("Duplicate attribute");
        }
        if (((i.i)object).A()) {
            object = this.R((i.h)object);
            this.e.add(object);
            this.c.w(G3.l.g);
            this.c.k(this.s.F().B(((F3.h)object).G0()));
            return object;
        }
        object = new F3.h(G3.h.r(((i.i)object).C(), this.h), null, this.h.b(((i.i)object).j));
        this.O((F3.h)object);
        return object;
    }

    void O(F3.h h2) {
        this.V(h2);
        this.e.add((Object)h2);
    }

    void P(i.c object) {
        Object object2 = this.a();
        F3.h h2 = object2;
        if (object2 == null) {
            h2 = this.d;
        }
        String string = h2.s0();
        object2 = ((i.c)object).q();
        object = ((i)object).f() ? new F3.c((String)object2) : (this.Y(string) ? new F3.e((String)object2) : new p((String)object2));
        h2.V((F3.m)object);
    }

    void Q(i.d d2) {
        this.V(new F3.d(d2.s()));
    }

    F3.h R(i.h h2) {
        h h3 = G3.h.r(h2.C(), this.h);
        F3.h h4 = new F3.h(h3, null, this.h.b(h2.j));
        this.V(h4);
        if (h2.A()) {
            if (h3.i()) {
                if (!h3.e()) {
                    this.c.t("Tag cannot be self closing; not a void tag");
                    return h4;
                }
            } else {
                h3.o();
            }
        }
        return h4;
    }

    k S(i.h object, boolean bl) {
        object = new k(G3.h.r(((i.i)object).C(), this.h), null, this.h.b(((i.i)object).j));
        this.C0((k)object);
        this.V((F3.m)object);
        if (bl) {
            this.e.add(object);
        }
        return object;
    }

    void T(F3.m m2) {
        F3.h h2;
        F3.h h3 = this.A("table");
        boolean bl = false;
        if (h3 != null) {
            if (h3.v0() != null) {
                h2 = h3.v0();
                bl = true;
            } else {
                h2 = this.k(h3);
            }
        } else {
            h2 = (F3.h)this.e.get(0);
        }
        if (bl) {
            D3.e.j(h3);
            h3.a0(m2);
            return;
        }
        h2.V(m2);
    }

    void U() {
        this.q.add(null);
    }

    void W(F3.h h2, F3.h h3) {
        int n2 = this.e.lastIndexOf((Object)h2);
        boolean bl = n2 != -1;
        D3.e.d(bl);
        this.e.add(n2 + 1, (Object)h3);
    }

    F3.h X(String object) {
        object = new F3.h(G3.h.r((String)object, this.h), null);
        this.O((F3.h)object);
        return object;
    }

    protected boolean Y(String string) {
        return string.equals((Object)"script") || string.equals((Object)"style");
        {
        }
    }

    boolean a0() {
        return this.u;
    }

    @Override
    f b() {
        return G3.f.c;
    }

    boolean b0() {
        return this.v;
    }

    boolean c0(F3.h h2) {
        return this.Z(this.q, h2);
    }

    @Override
    protected void d(Reader reader, String string, g g2) {
        super.d(reader, string, g2);
        this.k = G3.c.g;
        this.l = null;
        this.m = false;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new i.g();
        this.t = true;
        this.u = false;
        this.v = false;
    }

    boolean e0(F3.h h2) {
        return E3.c.d(h2.s0(), D);
    }

    @Override
    protected boolean f(i i2) {
        this.g = i2;
        return this.k.n(i2, this);
    }

    F3.h f0() {
        if (this.q.size() > 0) {
            ArrayList arrayList = this.q;
            return (F3.h)arrayList.get(arrayList.size() - 1);
        }
        return null;
    }

    void g0() {
        this.l = this.k;
    }

    void h0(F3.h object) {
        if (!this.m && (object = ((F3.m)object).a("href")).length() != 0) {
            this.f = object;
            this.m = true;
            this.d.O((String)object);
        }
    }

    void i0() {
        this.r = new ArrayList();
    }

    boolean j0(F3.h h2) {
        return this.Z(this.e, h2);
    }

    F3.h k(F3.h h2) {
        for (int i2 = this.e.size() - 1; i2 >= 0; --i2) {
            if ((F3.h)this.e.get(i2) != h2) continue;
            return (F3.h)this.e.get(i2 - 1);
        }
        return null;
    }

    c k0() {
        return this.l;
    }

    void l(F3.h h2) {
        F3.h h3;
        int n2 = 0;
        for (int i2 = this.q.size() - 1; i2 >= 0 && (h3 = (F3.h)this.q.get(i2)) != null; --i2) {
            int n3 = n2;
            if (this.d0(h2, h3)) {
                n3 = n2 + 1;
            }
            if (n3 == 3) {
                this.q.remove(i2);
                return;
            }
            n2 = n3;
        }
    }

    F3.h l0() {
        int n2 = this.e.size();
        return (F3.h)this.e.remove(n2 - 1);
    }

    void m() {
        while (!this.q.isEmpty() && this.x0() != null) {
        }
    }

    void m0(String string) {
        for (int i2 = this.e.size() - 1; i2 >= 0 && !((F3.h)this.e.get(i2)).s0().equals((Object)string); --i2) {
            this.e.remove(i2);
        }
    }

    F3.h n0(String string) {
        for (int i2 = this.e.size() - 1; i2 >= 0; --i2) {
            F3.h h2 = (F3.h)this.e.get(i2);
            this.e.remove(i2);
            if (!h2.s0().equals((Object)string)) continue;
            return h2;
        }
        return null;
    }

    void o() {
        this.n("tbody", "tfoot", "thead", "template");
    }

    void o0(String ... stringArray) {
        for (int i2 = this.e.size() - 1; i2 >= 0; --i2) {
            F3.h h2 = (F3.h)this.e.get(i2);
            this.e.remove(i2);
            if (E3.c.d(h2.s0(), stringArray)) break;
        }
    }

    void p() {
        this.n("table");
    }

    int p0(F3.h h2) {
        for (int i2 = 0; i2 < this.q.size(); ++i2) {
            if (h2 != this.q.get(i2)) continue;
            return i2;
        }
        return -1;
    }

    void q() {
        this.n("tr", "template");
    }

    boolean q0(i i2, c c2) {
        this.g = i2;
        return c2.n(i2, this);
    }

    void r(c c2) {
        if (this.a.a().c()) {
            this.a.a().add(new d(this.b.I(), "Unexpected token [%s] when in state [%s]", new Object[]{this.g.o(), c2}));
        }
    }

    void r0(F3.h h2) {
        this.e.add((Object)h2);
    }

    void s(boolean bl) {
        this.t = bl;
    }

    void s0(F3.h h2) {
        this.l(h2);
        this.q.add((Object)h2);
    }

    boolean t() {
        return this.t;
    }

    void t0(F3.h h2, int n2) {
        this.l(h2);
        this.q.add(n2, (Object)h2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TreeBuilder{currentToken=");
        stringBuilder.append((Object)this.g);
        stringBuilder.append(", state=");
        stringBuilder.append((Object)this.k);
        stringBuilder.append(", currentElement=");
        stringBuilder.append((Object)this.a());
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    void u() {
        this.v(null);
    }

    /*
     * Unable to fully structure code
     */
    void u0() {
        var5_1 = this.f0();
        if (var5_1 != null && !this.j0(var5_1)) {
            var1_2 = this.q.size();
            var3_3 = true;
            var1_2 = var4_4 = var1_2 - 1;
            while (var1_2 != 0) {
                var5_1 = this.q;
                var2_5 = var1_2 - 1;
                var5_1 = var6_6 = (F3.h)var5_1.get(var2_5);
                var1_2 = var2_5;
                if (var6_6 != null) {
                    var5_1 = var6_6;
                    var1_2 = var2_5;
                    if (!this.j0(var6_6)) continue;
                    var1_2 = var2_5;
                    var5_1 = var6_6;
                }
                while (true) {
                    var3_3 = false;
                    break;
                }
                break;
            }
            var2_5 = var1_2;
            if (!var3_3) {
                var5_1 = this.q;
                var2_5 = var1_2 + 1;
                var5_1 = (F3.h)var5_1.get(var2_5);
            }
            D3.e.j(var5_1);
            var6_6 = this.X(var5_1.s0());
            var6_6.e().l(var5_1.e());
            this.q.set(var2_5, (Object)var6_6);
            var1_2 = var2_5;
            if (var2_5 != var4_4) ** continue;
        }
    }

    void v(String string) {
        while (string != null && !this.a().s0().equals((Object)string) && E3.c.d(this.a().s0(), C)) {
            this.l0();
        }
    }

    void v0(F3.h h2) {
        for (int i2 = this.q.size() - 1; i2 >= 0; --i2) {
            if ((F3.h)this.q.get(i2) != h2) continue;
            this.q.remove(i2);
            return;
        }
    }

    F3.h w(String string) {
        F3.h h2;
        for (int i2 = this.q.size() - 1; i2 >= 0 && (h2 = (F3.h)this.q.get(i2)) != null; --i2) {
            if (!h2.s0().equals((Object)string)) continue;
            return h2;
        }
        return null;
    }

    boolean w0(F3.h h2) {
        for (int i2 = this.e.size() - 1; i2 >= 0; --i2) {
            if ((F3.h)this.e.get(i2) != h2) continue;
            this.e.remove(i2);
            return true;
        }
        return false;
    }

    String x() {
        return this.f;
    }

    F3.h x0() {
        int n2 = this.q.size();
        if (n2 > 0) {
            return (F3.h)this.q.remove(n2 - 1);
        }
        return null;
    }

    F3.f y() {
        return this.d;
    }

    void y0(F3.h h2, F3.h h3) {
        this.z0(this.q, h2, h3);
    }

    k z() {
        return this.o;
    }
}

