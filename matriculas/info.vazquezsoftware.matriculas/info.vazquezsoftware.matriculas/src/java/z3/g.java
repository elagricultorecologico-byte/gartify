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
import z3.x;
import z3.y;

public abstract class g
implements x,
AutoCloseable {
    private final x g;

    public g(x x2) {
        k.e(x2, "delegate");
        this.g = x2;
    }

    public final x a() {
        return this.g;
    }

    @Override
    public void close() {
        this.g.close();
    }

    @Override
    public y h() {
        return this.g.h();
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

