/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.AutoCloseable
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Throwable
 *  java.util.zip.DataFormatException
 *  java.util.zip.Inflater
 */
package z3;

import V2.k;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import z3.b;
import z3.d;
import z3.s;
import z3.t;
import z3.x;
import z3.y;

public final class j
implements x,
AutoCloseable {
    private final d g;
    private final Inflater h;
    private int i;
    private boolean j;

    public j(d d2, Inflater inflater) {
        k.e(d2, "source");
        k.e(inflater, "inflater");
        this.g = d2;
        this.h = inflater;
    }

    private final void i() {
        int n2 = this.i;
        if (n2 == 0) {
            return;
        }
        this.i -= (n2 -= this.h.getRemaining());
        this.g.x(n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final long a(b b2, long l2) {
        s s2;
        k.e(b2, "sink");
        long l3 = l2 - 0L;
        long l4 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
        int n2 = l4 >= 0 ? 1 : 0;
        if (n2 == 0) throw new IllegalArgumentException(k.j("byteCount < 0: ", l2).toString());
        if (this.j) throw new IllegalStateException("closed");
        if (l4 == false) {
            return 0L;
        }
        try {
            s2 = b2.K0(1);
            n2 = (int)Math.min((long)l2, (long)(8192 - s2.c));
            this.f();
            n2 = this.h.inflate(s2.a, s2.c, n2);
            this.i();
            if (n2 > 0) {
                s2.c += n2;
                long l5 = b2.A0();
                l2 = n2;
                b2.s0(l5 + l2);
                return l2;
            }
        }
        catch (DataFormatException dataFormatException) {
            throw new IOException((Throwable)dataFormatException);
        }
        if (s2.b != s2.c) return 0L;
        b2.g = s2.b();
        t.b(s2);
        return 0L;
    }

    @Override
    public void close() {
        if (this.j) {
            return;
        }
        this.h.end();
        this.j = true;
        this.g.close();
    }

    public final boolean f() {
        if (!this.h.needsInput()) {
            return false;
        }
        if (this.g.O()) {
            return true;
        }
        s s2 = this.g.g().g;
        k.b(s2);
        int n2 = s2.c;
        int n3 = s2.b;
        this.i = n2 -= n3;
        this.h.setInput(s2.a, n3, n2);
        return false;
    }

    @Override
    public y h() {
        return this.g.h();
    }

    @Override
    public long j0(b b2, long l2) {
        block2: {
            k.e(b2, "sink");
            do {
                long l3;
                if ((l3 = this.a(b2, l2)) > 0L) {
                    return l3;
                }
                if (this.h.finished() || this.h.needsDictionary()) break block2;
            } while (!this.g.O());
            throw new EOFException("source exhausted prematurely");
        }
        return -1L;
    }
}

