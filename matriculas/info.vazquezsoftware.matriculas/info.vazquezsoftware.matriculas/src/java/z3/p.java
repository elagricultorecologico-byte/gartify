/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.OutputStream
 *  java.lang.AutoCloseable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package z3;

import V2.k;
import java.io.OutputStream;
import z3.C;
import z3.b;
import z3.s;
import z3.t;
import z3.v;
import z3.y;

final class p
implements v,
AutoCloseable {
    private final OutputStream g;
    private final y h;

    public p(OutputStream outputStream, y y2) {
        k.e(outputStream, "out");
        k.e(y2, "timeout");
        this.g = outputStream;
        this.h = y2;
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
        return this.h;
    }

    @Override
    public void q(b b2, long l2) {
        k.e(b2, "source");
        C.b(b2.A0(), 0L, l2);
        while (l2 > 0L) {
            this.h.f();
            s s2 = b2.g;
            k.b(s2);
            int n2 = (int)Math.min((long)l2, (long)(s2.c - s2.b));
            this.g.write(s2.a, s2.b, n2);
            s2.b += n2;
            long l3 = n2;
            long l4 = l2 - l3;
            b2.s0(b2.A0() - l3);
            l2 = l4;
            if (s2.b != s2.c) continue;
            b2.g = s2.b();
            t.b(s2);
            l2 = l4;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sink(");
        stringBuilder.append((Object)this.g);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

