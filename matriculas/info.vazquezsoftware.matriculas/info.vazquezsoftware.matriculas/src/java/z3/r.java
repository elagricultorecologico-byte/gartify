/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.AutoCloseable
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.nio.charset.Charset
 */
package z3;

import V2.k;
import b3.a;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import z3.C;
import z3.b;
import z3.d;
import z3.e;
import z3.o;
import z3.x;
import z3.y;

public final class r
implements d,
AutoCloseable {
    public final x g;
    public final b h;
    public boolean i;

    public r(x x2) {
        k.e(x2, "source");
        this.g = x2;
        this.h = new b();
    }

    @Override
    public int D() {
        this.u0(4L);
        return this.h.D();
    }

    @Override
    public long D0() {
        int n2;
        this.u0(1L);
        int n3 = 0;
        while (this.p(n2 = n3 + 1)) {
            byte by = this.h.L(n3);
            if (by >= (byte)48 && by <= (byte)57 || by >= (byte)97 && by <= (byte)102 || by >= (byte)65 && by <= (byte)70) {
                n3 = n2;
                continue;
            }
            if (n3 != 0) break;
            String string = Integer.toString((int)by, (int)a.a(a.a(16)));
            k.d(string, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
            throw new NumberFormatException(k.j("Expected leading [0-9a-fA-F] character but was 0x", string));
        }
        return this.h.D0();
    }

    @Override
    public String E0(Charset charset) {
        k.e(charset, "charset");
        this.h.O0(this.g);
        return this.h.E0(charset);
    }

    @Override
    public InputStream F0() {
        return new AutoCloseable(this){
            final r g;
            {
                this.g = r2;
            }

            public int available() {
                r r2 = this.g;
                if (!r2.i) {
                    return (int)Math.min((long)r2.h.A0(), (long)Integer.MAX_VALUE);
                }
                throw new IOException("closed");
            }

            public void close() {
                this.g.close();
            }

            public int read() {
                r r2 = this.g;
                if (!r2.i) {
                    if (r2.h.A0() == 0L) {
                        r2 = this.g;
                        if (r2.g.j0(r2.h, 8192L) == -1L) {
                            return -1;
                        }
                    }
                    return this.g.h.G0() & 0xFF;
                }
                throw new IOException("closed");
            }

            public int read(byte[] byArray, int n2, int n3) {
                k.e(byArray, "data");
                if (!this.g.i) {
                    C.b(byArray.length, n2, n3);
                    if (this.g.h.A0() == 0L) {
                        r r2 = this.g;
                        if (r2.g.j0(r2.h, 8192L) == -1L) {
                            return -1;
                        }
                    }
                    return this.g.h.Y(byArray, n2, n3);
                }
                throw new IOException("closed");
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((Object)this.g);
                stringBuilder.append(".inputStream()");
                return stringBuilder.toString();
            }
        };
    }

    @Override
    public byte G0() {
        this.u0(1L);
        return this.h.G0();
    }

    @Override
    public int H0(o o2) {
        k.e(o2, "options");
        if (!this.i) {
            do {
                int n2;
                if ((n2 = A3.a.c(this.h, o2, true)) == -2) continue;
                if (n2 != -1) {
                    int n3 = o2.k()[n2].u();
                    this.h.x(n3);
                    return n2;
                }
                return -1;
            } while (this.g.j0(this.h, 8192L) != -1L);
            return -1;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public String J() {
        return this.d0(Long.MAX_VALUE);
    }

    @Override
    public boolean O() {
        if (!this.i) {
            return this.h.O() && this.g.j0(this.h, 8192L) == -1L;
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public byte[] S(long l2) {
        this.u0(l2);
        return this.h.S(l2);
    }

    public long a(byte by) {
        return this.f(by, 0L, Long.MAX_VALUE);
    }

    @Override
    public void close() {
        if (this.i) {
            return;
        }
        this.i = true;
        this.g.close();
        this.h.a();
    }

    @Override
    public String d0(long l2) {
        boolean bl = l2 >= 0L;
        if (bl) {
            byte by = (byte)10;
            long l3 = l2 == Long.MAX_VALUE ? Long.MAX_VALUE : l2 + 1L;
            long l4 = this.f(by, 0L, l3);
            if (l4 != -1L) {
                return A3.a.b(this.h, l4);
            }
            if (l3 < Long.MAX_VALUE && this.p(l3) && this.h.L(l3 - 1L) == (byte)13 && this.p(l3 + 1L) && this.h.L(l3) == by) {
                return A3.a.b(this.h, l3);
            }
            b b2 = new b();
            b b3 = this.h;
            l3 = b3.A0();
            b3.I(b2, 0L, Math.min((long)32, (long)l3));
            b3 = new StringBuilder();
            b3.append("\\n not found: limit=");
            b3.append(Math.min((long)this.h.A0(), (long)l2));
            b3.append(" content=");
            b3.append(b2.a0().m());
            b3.append('\u2026');
            throw new EOFException(b3.toString());
        }
        throw new IllegalArgumentException(k.j("limit < 0: ", l2).toString());
    }

    public long f(byte by, long l2, long l3) {
        if (!this.i) {
            boolean bl;
            boolean bl2 = bl = false;
            if (0L <= l2) {
                bl2 = bl;
                if (l2 <= l3) {
                    bl2 = true;
                }
            }
            if (bl2) {
                while (l2 < l3) {
                    long l4 = this.h.M(by, l2, l3);
                    if (l4 != -1L) {
                        return l4;
                    }
                    l4 = this.h.A0();
                    if (l4 >= l3 || this.g.j0(this.h, 8192L) == -1L) break;
                    l2 = Math.max((long)l2, (long)l4);
                }
                return -1L;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("fromIndex=");
            stringBuilder.append(l2);
            stringBuilder.append(" toIndex=");
            stringBuilder.append(l3);
            throw new IllegalArgumentException(stringBuilder.toString().toString());
        }
        throw new IllegalStateException("closed");
    }

    @Override
    public short f0() {
        this.u0(2L);
        return this.h.f0();
    }

    @Override
    public b g() {
        return this.h;
    }

    @Override
    public y h() {
        return this.g.h();
    }

    public int i() {
        this.u0(4L);
        return this.h.c0();
    }

    public boolean isOpen() {
        return this.i ^ true;
    }

    public short j() {
        this.u0(2L);
        return this.h.i0();
    }

    @Override
    public long j0(b b2, long l2) {
        k.e(b2, "sink");
        boolean bl = l2 >= 0L;
        if (bl) {
            if (!this.i) {
                if (this.h.A0() == 0L && this.g.j0(this.h, 8192L) == -1L) {
                    return -1L;
                }
                l2 = Math.min((long)l2, (long)this.h.A0());
                return this.h.j0(b2, l2);
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(k.j("byteCount < 0: ", l2).toString());
    }

    public boolean p(long l2) {
        boolean bl = l2 >= 0L;
        if (bl) {
            if (!this.i) {
                while (this.h.A0() < l2) {
                    if (this.g.j0(this.h, 8192L) != -1L) continue;
                    return false;
                }
                return true;
            }
            throw new IllegalStateException("closed");
        }
        throw new IllegalArgumentException(k.j("byteCount < 0: ", l2).toString());
    }

    public int read(ByteBuffer byteBuffer) {
        k.e(byteBuffer, "sink");
        if (this.h.A0() == 0L && this.g.j0(this.h, 8192L) == -1L) {
            return -1;
        }
        return this.h.read(byteBuffer);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buffer(");
        stringBuilder.append((Object)this.g);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override
    public e u(long l2) {
        this.u0(l2);
        return this.h.u(l2);
    }

    @Override
    public void u0(long l2) {
        if (this.p(l2)) {
            return;
        }
        throw new EOFException();
    }

    @Override
    public void x(long l2) {
        if (!this.i) {
            while (l2 > 0L) {
                if (this.h.A0() == 0L && this.g.j0(this.h, 8192L) == -1L) {
                    throw new EOFException();
                }
                long l3 = Math.min((long)l2, (long)this.h.A0());
                this.h.x(l3);
                l2 -= l3;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }
}

