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

import F3.f;
import F3.l;

public class e
extends l {
    public e(String string) {
        this.j = string;
    }

    @Override
    void B(Appendable appendable, int n2, f.a a2) {
        appendable.append((CharSequence)this.X());
    }

    @Override
    void C(Appendable appendable, int n2, f.a a2) {
    }

    public e W() {
        return (e)super.m();
    }

    public String X() {
        return this.T();
    }

    @Override
    public String toString() {
        return this.z();
    }

    @Override
    public String x() {
        return "#data";
    }
}

