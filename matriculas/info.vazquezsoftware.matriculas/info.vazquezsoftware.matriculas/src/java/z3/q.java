/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.AutoCloseable
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 */
package z3;

import V2.k;
import java.nio.ByteBuffer;
import z3.b;
import z3.c;
import z3.e;
import z3.v;
import z3.y;

public final class q
implements c,
AutoCloseable {
    public final v g;
    public final b h;
    public boolean i;

    public q(v v2) {
        k.e(v2, "sink");
        this.g = v2;
        this.h = new b();
    }

    @Override
    public c E(int n2) {
        if (!this.i) {
            this.h.R0(n2);
            return this.a();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public c Q(int n2) {
        if (!this.i) {
            this.h.P0(n2);
            return this.a();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public c U(e e2) {
        k.e(e2, "byteString");
        if (!this.i) {
            this.h.L0(e2);
            return this.a();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public c W(byte[] byArray) {
        k.e(byArray, "source");
        if (!this.i) {
            this.h.M0(byArray);
            return this.a();
        }
        throw new IllegalStateException("closed");
    }

    public c a() {
        if (!this.i) {
            long l2 = this.h.A();
            if (l2 > 0L) {
                this.g.q(this.h, l2);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public void close() {
        v v2;
        block10: {
            block9: {
                block8: {
                    b b2;
                    block7: {
                        block6: {
                            if (this.i) break block9;
                            try {
                                if (this.h.A0() <= 0L) break block6;
                                v2 = this.g;
                                b2 = this.h;
                                v2.q(b2, b2.A0());
                            }
                            catch (Throwable throwable) {
                                break block7;
                            }
                        }
                        b2 = null;
                    }
                    try {
                        this.g.close();
                        v2 = b2;
                    }
                    catch (Throwable throwable) {
                        v2 = b2;
                        if (b2 != null) break block8;
                        v2 = throwable;
                    }
                }
                this.i = true;
                if (v2 != null) break block10;
            }
            return;
        }
        throw v2;
    }

    @Override
    public void flush() {
        if (!this.i) {
            if (this.h.A0() > 0L) {
                v v2 = this.g;
                b b2 = this.h;
                v2.q(b2, b2.A0());
            }
            this.g.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public b g() {
        return this.h;
    }

    @Override
    public y h() {
        return this.g.h();
    }

    public boolean isOpen() {
        return this.i ^ true;
    }

    @Override
    public c k(byte[] byArray, int n2, int n3) {
        k.e(byArray, "source");
        if (!this.i) {
            this.h.N0(byArray, n2, n3);
            return this.a();
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public void q(b b2, long l2) {
        k.e(b2, "source");
        if (!this.i) {
            this.h.q(b2, l2);
            this.a();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public c r(long l2) {
        if (!this.i) {
            this.h.Q0(l2);
            return this.a();
        }
        throw new IllegalStateException("closed");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append((Object)this.g);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override
    public c w0(String string) {
        k.e(string, "string");
        if (!this.i) {
            this.h.U0(string);
            return this.a();
        }
        throw new IllegalStateException("closed");
    }

    public int write(ByteBuffer byteBuffer) {
        k.e(byteBuffer, "source");
        if (!this.i) {
            int n2 = this.h.write(byteBuffer);
            this.a();
            return n2;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public c y(int n2) {
        if (!this.i) {
            this.h.S0(n2);
            return this.a();
        }
        throw new IllegalStateException("closed");
    }
}

