/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Appendable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package F3;

import E3.c;
import F3.f;
import F3.h;
import F3.i;
import F3.l;
import F3.m;

public class p
extends l {
    public p(String string) {
        this.j = string;
    }

    static boolean Z(StringBuilder stringBuilder) {
        return stringBuilder.length() != 0 && stringBuilder.charAt(stringBuilder.length() - 1) == ' ';
    }

    @Override
    void B(Appendable appendable, int n2, f.a a2) {
        m m2;
        boolean bl = a2.n();
        if (bl && (this.R() == 0 && (m2 = this.g) instanceof h && ((h)m2).F0().b() && !this.Y() || a2.k() && this.S().size() > 0 && !this.Y())) {
            this.v(appendable, n2, a2);
        }
        boolean bl2 = bl && !F3.h.y0(this.g);
        bl = bl && this.g instanceof f;
        F3.i.e(appendable, this.T(), a2, false, bl2, bl);
    }

    @Override
    void C(Appendable appendable, int n2, f.a a2) {
    }

    public p W() {
        return (p)super.m();
    }

    public String X() {
        return this.T();
    }

    public boolean Y() {
        return c.g(this.T());
    }

    @Override
    public String toString() {
        return this.z();
    }

    @Override
    public String x() {
        return "#text";
    }
}

