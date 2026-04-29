/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AutoCloseable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package z3;

import V2.k;
import z3.b;
import z3.v;
import z3.y;

public abstract class f
implements v,
AutoCloseable {
    private final v g;

    public f(v v2) {
        k.e(v2, "delegate");
        this.g = v2;
    }

    @Override
    public void close() {
        this.g.close();
    }

    @Override
    public void flush() {
        this.g.flush();
    }

    @Override
    public y h() {
        return this.g.h();
    }

    @Override
    public void q(b b2, long l2) {
        k.e(b2, "source");
        this.g.q(b2, l2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)this.getClass().getSimpleName());
        stringBuilder.append('(');
        stringBuilder.append((Object)this.g);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

