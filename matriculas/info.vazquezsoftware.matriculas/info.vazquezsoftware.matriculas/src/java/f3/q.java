/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package F3;

import D3.e;
import F3.a;
import F3.f;
import F3.l;

public class q
extends l {
    private final boolean k;

    public q(String string, boolean bl) {
        e.j(string);
        this.j = string;
        this.k = bl;
    }

    private void X(Appendable appendable, f.a a2) {
        for (a a3 : this.e()) {
            if (a3.b().equals((Object)this.x())) continue;
            appendable.append(' ');
            a3.e(appendable, a2);
        }
    }

    @Override
    void B(Appendable appendable, int n2, f.a object) {
        Appendable appendable2 = appendable.append((CharSequence)"<");
        boolean bl = this.k;
        String string = "?";
        String string2 = bl ? "!" : "?";
        appendable2.append((CharSequence)string2).append((CharSequence)this.T());
        this.X(appendable, (f.a)object);
        object = string;
        if (this.k) {
            object = "!";
        }
        appendable.append((CharSequence)object).append((CharSequence)">");
    }

    @Override
    void C(Appendable appendable, int n2, f.a a2) {
    }

    public q W() {
        return (q)super.m();
    }

    public String Y() {
        return this.T();
    }

    @Override
    public String toString() {
        return this.z();
    }

    @Override
    public String x() {
        return "#declaration";
    }
}

