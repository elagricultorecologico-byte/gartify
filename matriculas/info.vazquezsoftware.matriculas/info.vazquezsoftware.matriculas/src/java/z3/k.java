/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.AssertionError
 *  java.lang.AutoCloseable
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package z3;

import java.io.IOException;
import java.io.InputStream;
import z3.b;
import z3.l;
import z3.s;
import z3.t;
import z3.x;
import z3.y;

class k
implements x,
AutoCloseable {
    private final InputStream g;
    private final y h;

    public k(InputStream inputStream, y y2) {
        V2.k.e(inputStream, "input");
        V2.k.e(y2, "timeout");
        this.g = inputStream;
        this.h = y2;
    }

    @Override
    public void close() {
        this.g.close();
    }

    @Override
    public y h() {
        return this.h;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public long j0(b b2, long l2) {
        AssertionError assertionError2;
        block4: {
            V2.k.e(b2, "sink");
            long l3 = l2 - 0L;
            long l4 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
            if (l4 == false) {
                return 0L;
            }
            l4 = l4 >= 0 ? (long)1 : (long)0;
            if (l4 == false) throw new IllegalArgumentException(V2.k.j("byteCount < 0: ", l2).toString());
            try {
                this.h.f();
                s s2 = b2.K0(1);
                l4 = (int)Math.min((long)l2, (long)(8192 - s2.c));
                l4 = this.g.read(s2.a, s2.c, (int)l4);
                if (l4 == -1) {
                    if (s2.b != s2.c) return -1L;
                    b2.g = s2.b();
                    t.b(s2);
                    return -1L;
                }
            }
            catch (AssertionError assertionError2) {
                break block4;
            }
            s2.c += l4;
            long l5 = b2.A0();
            l2 = l4;
            b2.s0(l5 + l2);
            return l2;
        }
        if (!l.c(assertionError2)) throw assertionError2;
        throw new IOException((Throwable)assertionError2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("source(");
        stringBuilder.append((Object)this.g);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

