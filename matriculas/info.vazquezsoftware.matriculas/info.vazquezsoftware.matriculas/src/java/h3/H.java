/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package H3;

import D3.e;
import E3.b;
import E3.c;
import G3.j;
import H3.b;
import H3.d;
import H3.i;
import H3.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class h {
    private static final String[] d = new String[]{",", ">", "+", "~", " "};
    private static final String[] e = new String[]{"=", "!=", "^=", "$=", "*=", "~="};
    private static final Pattern f = Pattern.compile((String)"(([+-])?(\\d+)?)n(\\s*([+-])?\\s*\\d+)?", (int)2);
    private static final Pattern g = Pattern.compile((String)"([+-])?(\\d+)");
    private final j a;
    private final String b;
    private final List c = new ArrayList();

    private h(String string) {
        D3.e.h(string);
        this.b = string = string.trim();
        this.a = new j(string);
    }

    private void a() {
        this.c.add((Object)new d.a());
    }

    private void b() {
        j j2 = new j(this.a.a('[', ']'));
        String string = j2.h(e);
        D3.e.h(string);
        j2.i();
        if (j2.j()) {
            if (string.startsWith("^")) {
                this.c.add((Object)new d.d(string.substring(1)));
                return;
            }
            this.c.add((Object)new d.b(string));
            return;
        }
        if (j2.k("=")) {
            this.c.add((Object)new d.e(string, j2.q()));
            return;
        }
        if (j2.k("!=")) {
            this.c.add((Object)new d.i(string, j2.q()));
            return;
        }
        if (j2.k("^=")) {
            this.c.add((Object)new d.j(string, j2.q()));
            return;
        }
        if (j2.k("$=")) {
            this.c.add((Object)new d.g(string, j2.q()));
            return;
        }
        if (j2.k("*=")) {
            this.c.add((Object)new d.f(string, j2.q()));
            return;
        }
        if (j2.k("~=")) {
            this.c.add((Object)new d.h(string, Pattern.compile((String)j2.q())));
            return;
        }
        throw new i.a("Could not parse attribute query '%s': unexpected token at '%s'", this.b, j2.q());
    }

    private void c() {
        String string = this.a.e();
        D3.e.h(string);
        this.c.add((Object)new d.k(string.trim()));
    }

    private void d() {
        String string = this.a.e();
        D3.e.h(string);
        this.c.add((Object)new d.p(string));
    }

    private void e() {
        String string = E3.b.b(this.a.f());
        D3.e.h(string);
        if (string.startsWith("*|")) {
            this.c.add((Object)new b.b(new d.J(string), new d.K(string.replace((CharSequence)"*|", (CharSequence)":"))));
            return;
        }
        String string2 = string;
        if (string.contains((CharSequence)"|")) {
            string2 = string.replace((CharSequence)"|", (CharSequence)":");
        }
        this.c.add((Object)new d.J(string2));
    }

    /*
     * Enabled aggressive block sorting
     */
    private void f(char c2) {
        boolean bl;
        d d2;
        d d3;
        block9: {
            d d4;
            block13: {
                block14: {
                    block12: {
                        block11: {
                            block10: {
                                this.a.i();
                                d4 = h.t(this.h());
                                if (this.c.size() != 1) break block10;
                                d2 = d3 = (d)this.c.get(0);
                                if (!(d3 instanceof b.b)) break block11;
                                d2 = d3;
                                if (c2 == ',') break block11;
                                d2 = ((b.b)d3).c();
                                bl = true;
                                break block12;
                            }
                            d2 = new b.a((Collection)this.c);
                        }
                        d3 = d2;
                        bl = false;
                    }
                    this.c.clear();
                    if (c2 == ' ') break block13;
                    if (c2 == '>') break block14;
                    if (c2 != '~') {
                        if (c2 != '+') {
                            if (c2 != ',') {
                                d2 = new StringBuilder();
                                d2.append("Unknown combinator: ");
                                d2.append(c2);
                                throw new i.a(d2.toString(), new Object[0]);
                            }
                            if (d2 instanceof b.b) {
                                d2 = (b.b)d2;
                            } else {
                                b.b b2 = new b.b();
                                b2.e(d2);
                                d2 = b2;
                            }
                            ((b.b)d2).e(d4);
                            break block9;
                        } else {
                            d2 = new b.a(new j.c(d2), d4);
                        }
                        break block9;
                    } else {
                        d2 = new b.a(new j.f(d2), d4);
                    }
                    break block9;
                }
                d2 = new b.a(new j.b(d2), d4);
                break block9;
            }
            d2 = new b.a(new j.e(d2), d4);
        }
        if (bl) {
            ((b.b)d3).b(d2);
        } else {
            d3 = d2;
        }
        this.c.add((Object)d3);
    }

    private int g() {
        String string = this.a.b(")").trim();
        D3.e.e(E3.c.i(string), "Index must be numeric");
        return Integer.parseInt((String)string);
    }

    private String h() {
        StringBuilder stringBuilder = E3.c.b();
        while (!this.a.j()) {
            if (this.a.l("(")) {
                stringBuilder.append("(");
                stringBuilder.append(this.a.a('(', ')'));
                stringBuilder.append(")");
                continue;
            }
            if (this.a.l("[")) {
                stringBuilder.append("[");
                stringBuilder.append(this.a.a('[', ']'));
                stringBuilder.append("]");
                continue;
            }
            if (this.a.n(d)) break;
            stringBuilder.append(this.a.c());
        }
        return E3.c.n(stringBuilder);
    }

    private void i(boolean bl) {
        j j2 = this.a;
        String string = bl ? ":containsOwn" : ":contains";
        j2.d(string);
        string = j.s(this.a.a('(', ')'));
        D3.e.i(string, ":contains(text) query must not be empty");
        if (bl) {
            this.c.add((Object)new d.m(string));
            return;
        }
        this.c.add((Object)new d.n(string));
    }

    private void j() {
        this.a.d(":containsData");
        String string = j.s(this.a.a('(', ')'));
        D3.e.i(string, ":containsData(text) query must not be empty");
        this.c.add((Object)new d.l(string));
    }

    private void k(boolean bl, boolean bl2) {
        String string;
        block13: {
            int n2;
            int n3;
            block10: {
                Matcher matcher;
                block12: {
                    int n4;
                    Matcher matcher2;
                    block11: {
                        block9: {
                            n3 = 0;
                            n2 = 0;
                            string = E3.b.b(this.a.b(")"));
                            matcher2 = f.matcher((CharSequence)string);
                            matcher = g.matcher((CharSequence)string);
                            boolean bl3 = "odd".equals((Object)string);
                            n4 = 1;
                            if (!bl3) break block9;
                            n3 = 2;
                            n2 = 1;
                            break block10;
                        }
                        if (!"even".equals((Object)string)) break block11;
                        n2 = 0;
                        n3 = 2;
                        break block10;
                    }
                    if (!matcher2.matches()) break block12;
                    n3 = n4;
                    if (matcher2.group(3) != null) {
                        n3 = Integer.parseInt((String)matcher2.group(1).replaceFirst("^\\+", ""));
                    }
                    if (matcher2.group(4) != null) {
                        n2 = Integer.parseInt((String)matcher2.group(4).replaceFirst("^\\+", ""));
                    }
                    break block10;
                }
                if (!matcher.matches()) break block13;
                n2 = Integer.parseInt((String)matcher.group().replaceFirst("^\\+", ""));
            }
            if (bl2) {
                if (bl) {
                    this.c.add((Object)new d.B(n3, n2));
                    return;
                }
                this.c.add((Object)new d.C(n3, n2));
                return;
            }
            if (bl) {
                this.c.add((Object)new d.A(n3, n2));
                return;
            }
            this.c.add((Object)new d.z(n3, n2));
            return;
        }
        throw new i.a("Could not parse nth-index '%s': unexpected format", string);
    }

    private void l() {
        if (this.a.k("#")) {
            this.d();
            return;
        }
        if (this.a.k(".")) {
            this.c();
            return;
        }
        if (!this.a.p() && !this.a.l("*|")) {
            if (this.a.l("[")) {
                this.b();
                return;
            }
            if (this.a.k("*")) {
                this.a();
                return;
            }
            if (this.a.k(":lt(")) {
                this.p();
                return;
            }
            if (this.a.k(":gt(")) {
                this.o();
                return;
            }
            if (this.a.k(":eq(")) {
                this.n();
                return;
            }
            if (this.a.l(":has(")) {
                this.m();
                return;
            }
            if (this.a.l(":contains(")) {
                this.i(false);
                return;
            }
            if (this.a.l(":containsOwn(")) {
                this.i(true);
                return;
            }
            if (this.a.l(":containsData(")) {
                this.j();
                return;
            }
            if (this.a.l(":matches(")) {
                this.q(false);
                return;
            }
            if (this.a.l(":matchesOwn(")) {
                this.q(true);
                return;
            }
            if (this.a.l(":not(")) {
                this.r();
                return;
            }
            if (this.a.k(":nth-child(")) {
                this.k(false, false);
                return;
            }
            if (this.a.k(":nth-last-child(")) {
                this.k(true, false);
                return;
            }
            if (this.a.k(":nth-of-type(")) {
                this.k(false, true);
                return;
            }
            if (this.a.k(":nth-last-of-type(")) {
                this.k(true, true);
                return;
            }
            if (this.a.k(":first-child")) {
                this.c.add((Object)new d.v());
                return;
            }
            if (this.a.k(":last-child")) {
                this.c.add((Object)new d.x());
                return;
            }
            if (this.a.k(":first-of-type")) {
                this.c.add((Object)new d.w());
                return;
            }
            if (this.a.k(":last-of-type")) {
                this.c.add((Object)new d.y());
                return;
            }
            if (this.a.k(":only-child")) {
                this.c.add((Object)new d.D());
                return;
            }
            if (this.a.k(":only-of-type")) {
                this.c.add((Object)new d.E());
                return;
            }
            if (this.a.k(":empty")) {
                this.c.add((Object)new d.u());
                return;
            }
            if (this.a.k(":root")) {
                this.c.add((Object)new d.F());
                return;
            }
            if (this.a.k(":matchText")) {
                this.c.add((Object)new d.G());
                return;
            }
            throw new i.a("Could not parse query '%s': unexpected token at '%s'", this.b, this.a.q());
        }
        this.e();
    }

    private void m() {
        this.a.d(":has");
        String string = this.a.a('(', ')');
        D3.e.i(string, ":has(el) subselect must not be empty");
        this.c.add((Object)new j.a(h.t(string)));
    }

    private void n() {
        this.c.add((Object)new d.q(this.g()));
    }

    private void o() {
        this.c.add((Object)new d.s(this.g()));
    }

    private void p() {
        this.c.add((Object)new d.t(this.g()));
    }

    private void q(boolean bl) {
        j j2 = this.a;
        String string = bl ? ":matchesOwn" : ":matches";
        j2.d(string);
        string = this.a.a('(', ')');
        D3.e.i(string, ":matches(regex) query must not be empty");
        if (bl) {
            this.c.add((Object)new d.I(Pattern.compile((String)string)));
            return;
        }
        this.c.add((Object)new d.H(Pattern.compile((String)string)));
    }

    private void r() {
        this.a.d(":not");
        String string = this.a.a('(', ')');
        D3.e.i(string, ":not(selector) subselect must not be empty");
        this.c.add((Object)new j.d(h.t(string)));
    }

    public static d t(String object) {
        try {
            h h2 = new h((String)object);
            object = h2.s();
            return object;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new i.a(illegalArgumentException.getMessage(), new Object[0]);
        }
    }

    d s() {
        this.a.i();
        if (this.a.n(d)) {
            this.c.add((Object)new j.g());
            this.f(this.a.c());
        } else {
            this.l();
        }
        while (!this.a.j()) {
            boolean bl = this.a.i();
            if (this.a.n(d)) {
                this.f(this.a.c());
                continue;
            }
            if (bl) {
                this.f(' ');
                continue;
            }
            this.l();
        }
        if (this.c.size() == 1) {
            return (d)this.c.get(0);
        }
        return new b.a((Collection)this.c);
    }

    public String toString() {
        return this.b;
    }
}

