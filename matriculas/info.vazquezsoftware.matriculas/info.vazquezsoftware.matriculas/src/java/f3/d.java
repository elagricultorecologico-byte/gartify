/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package F3;

import F3.f;
import F3.h;
import F3.l;
import F3.m;
import F3.n;
import F3.q;
import G3.g;

public class d
extends l {
    public d(String string) {
        this.j = string;
    }

    private static boolean a0(String string) {
        return string.length() > 1 && (string.startsWith("!") || string.startsWith("?"));
    }

    @Override
    void B(Appendable appendable, int n2, f.a a2) {
        m m2;
        if (a2.n() && (this.R() == 0 && (m2 = this.g) instanceof h && ((h)m2).F0().b() || a2.k())) {
            this.v(appendable, n2, a2);
        }
        appendable.append((CharSequence)"<!--").append((CharSequence)this.Y()).append((CharSequence)"-->");
    }

    @Override
    void C(Appendable appendable, int n2, f.a a2) {
    }

    public q W() {
        String string = this.Y();
        Object object = string.substring(1, string.length() - 1);
        boolean bl = d.a0((String)object);
        q q2 = null;
        if (bl) {
            return null;
        }
        Object object2 = new StringBuilder();
        object2.append("<");
        object2.append((String)object);
        object2.append(">");
        object = object2.toString();
        object = G3.g.b().f(G3.f.d).d((String)object, this.g());
        if (((f)object).J0().d0().size() > 0) {
            object2 = ((f)object).J0().b0(0);
            q2 = new q(n.b((m)object).e().c(((h)object2).G0()), string.startsWith("!"));
            q2.e().l(((h)object2).e());
        }
        return q2;
    }

    public d X() {
        return (d)super.m();
    }

    public String Y() {
        return this.T();
    }

    public boolean Z() {
        return d.a0(this.Y());
    }

    @Override
    public String toString() {
        return this.z();
    }

    @Override
    public String x() {
        return "#comment";
    }
}

