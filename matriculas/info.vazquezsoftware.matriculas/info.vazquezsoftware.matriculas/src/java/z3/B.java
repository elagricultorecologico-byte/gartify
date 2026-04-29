/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.EOFException
 *  java.io.InputStream
 *  java.lang.AssertionError
 *  java.lang.AutoCloseable
 *  java.lang.Cloneable
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.ByteBuffer
 *  java.nio.channels.ByteChannel
 *  java.nio.charset.Charset
 */
package z3;

import I2.i;
import V2.k;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import z3.C;
import z3.c;
import z3.d;
import z3.e;
import z3.o;
import z3.s;
import z3.t;
import z3.u;
import z3.x;
import z3.y;

public final class b
implements d,
c,
Cloneable,
ByteChannel,
AutoCloseable {
    public s g;
    private long h;

    public final long A() {
        long l2 = this.A0();
        if (l2 == 0L) {
            return 0L;
        }
        s s2 = this.g;
        k.b(s2);
        s2 = s2.g;
        k.b(s2);
        int n2 = s2.c;
        long l3 = l2;
        if (n2 < 8192) {
            l3 = l2;
            if (s2.e) {
                l3 = l2 - (long)(n2 - s2.b);
            }
        }
        return l3;
    }

    public final long A0() {
        return this.h;
    }

    @Override
    public int D() {
        if (this.A0() >= 4L) {
            s s2 = this.g;
            k.b(s2);
            int n2 = s2.b;
            int n3 = s2.c;
            if ((long)(n3 - n2) < 4L) {
                return (this.G0() & 0xFF) << 24 | (this.G0() & 0xFF) << 16 | (this.G0() & 0xFF) << 8 | this.G0() & 0xFF;
            }
            byte[] byArray = s2.a;
            byte by = byArray[n2];
            byte by2 = byArray[n2 + 1];
            byte by3 = byArray[n2 + 2];
            int n4 = n2 + 4;
            n2 = byArray[n2 + 3] & 0xFF | ((by2 & 0xFF) << 16 | (by & 0xFF) << 24 | (by3 & 0xFF) << 8);
            this.s0(this.A0() - 4L);
            if (n4 == n3) {
                this.g = s2.b();
                t.b(s2);
                return n2;
            }
            s2.b = n4;
            return n2;
        }
        throw new EOFException();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public long D0() {
        int n2;
        long l2;
        if (this.A0() == 0L) {
            throw new EOFException();
        }
        int n3 = 0;
        boolean bl = false;
        long l3 = 0L;
        do {
            boolean bl2;
            int n4;
            int n5;
            s s2;
            block9: {
                byte by;
                s2 = this.g;
                k.b(s2);
                byte[] byArray = s2.a;
                n5 = s2.b;
                n4 = s2.c;
                l2 = l3;
                n2 = n3;
                while (true) {
                    bl2 = bl;
                    if (n5 >= n4) break block9;
                    by = byArray[n5];
                    n3 = 48;
                    if (by >= n3 && by <= (byte)57) {
                        n3 = by - n3;
                    } else {
                        n3 = (byte)97;
                        if ((by < n3 || by > (byte)102) && (by < (n3 = (byte)65) || by > (byte)70)) break;
                        n3 = by - n3 + 10;
                    }
                    if ((0xF000000000000000L & l2) != 0L) {
                        throw new NumberFormatException(k.j("Number too large: ", new b().Q0(l2).P0(by).l0()));
                    }
                    l2 = l2 << 4 | (long)n3;
                    ++n5;
                    ++n2;
                }
                if (n2 == 0) {
                    throw new NumberFormatException(k.j("Expected leading [0-9a-fA-F] character but was 0x", C.f(by)));
                }
                bl2 = true;
            }
            if (n5 == n4) {
                this.g = s2.b();
                t.b(s2);
            } else {
                s2.b = n5;
            }
            if (bl2) break;
            n3 = n2;
            bl = bl2;
            l3 = l2;
        } while (this.g != null);
        this.s0(this.A0() - (long)n2);
        return l2;
    }

    @Override
    public String E0(Charset charset) {
        k.e(charset, "charset");
        return this.k0(this.h, charset);
    }

    public final b F() {
        s s2;
        b b2 = new b();
        if (this.A0() == 0L) {
            return b2;
        }
        s s3 = this.g;
        k.b(s3);
        b2.g = s2 = s3.d();
        s2.g = s2;
        s2.f = s2;
        s s4 = s3.f;
        while (s4 != s3) {
            s s5 = s2.g;
            k.b(s5);
            k.b(s4);
            s5.c(s4.d());
            s4 = s4.f;
        }
        b2.s0(this.A0());
        return b2;
    }

    @Override
    public InputStream F0() {
        return new AutoCloseable(this){
            final b g;
            {
                this.g = b2;
            }

            public int available() {
                return (int)Math.min((long)this.g.A0(), (long)Integer.MAX_VALUE);
            }

            public void close() {
            }

            public int read() {
                if (this.g.A0() > 0L) {
                    return this.g.G0() & 0xFF;
                }
                return -1;
            }

            public int read(byte[] byArray, int n2, int n3) {
                k.e(byArray, "sink");
                return this.g.Y(byArray, n2, n3);
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
        if (this.A0() != 0L) {
            s s2 = this.g;
            k.b(s2);
            int n2 = s2.b;
            int n3 = s2.c;
            byte[] byArray = s2.a;
            int n4 = n2 + 1;
            byte by = byArray[n2];
            this.s0(this.A0() - 1L);
            if (n4 == n3) {
                this.g = s2.b();
                t.b(s2);
                return by;
            }
            s2.b = n4;
            return by;
        }
        throw new EOFException();
    }

    @Override
    public int H0(o o2) {
        k.e(o2, "options");
        int n2 = A3.a.d(this, o2, false, 2, null);
        if (n2 == -1) {
            return -1;
        }
        this.x(o2.k()[n2].u());
        return n2;
    }

    public final b I(b b2, long l2, long l3) {
        k.e(b2, "out");
        long l4 = this.A0();
        C.b(l4, l2, l3);
        if (l3 != 0L) {
            int n2;
            b2.s0(b2.A0() + l3);
            s s2 = this.g;
            while (true) {
                k.b(s2);
                n2 = s2.c;
                int n3 = s2.b;
                if (l2 < (long)(n2 - n3)) break;
                l2 -= (long)(n2 - n3);
                s2 = s2.f;
            }
            while (l3 > 0L) {
                k.b(s2);
                s s3 = s2.d();
                s3.b = n2 = s3.b + (int)l2;
                s3.c = Math.min((int)(n2 + (int)l3), (int)s3.c);
                s s4 = b2.g;
                if (s4 == null) {
                    s3.g = s3;
                    s3.f = s3;
                    b2.g = s3;
                } else {
                    k.b(s4);
                    s4 = s4.g;
                    k.b(s4);
                    s4.c(s3);
                }
                l3 -= (long)(s3.c - s3.b);
                s2 = s2.f;
                l2 = 0L;
            }
        }
        return this;
    }

    public final e I0() {
        boolean bl = this.A0() <= Integer.MAX_VALUE;
        if (bl) {
            return this.J0((int)this.A0());
        }
        throw new IllegalStateException(k.j("size > Int.MAX_VALUE: ", this.A0()).toString());
    }

    @Override
    public String J() {
        return this.d0(Long.MAX_VALUE);
    }

    public final e J0(int n2) {
        if (n2 == 0) {
            return e.k;
        }
        C.b(this.A0(), 0L, n2);
        s s2 = this.g;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        while (n4 < n2) {
            k.b(s2);
            int n6 = s2.c;
            int n7 = s2.b;
            if (n6 != n7) {
                n4 += n6 - n7;
                ++n5;
                s2 = s2.f;
                continue;
            }
            throw new AssertionError((Object)"s.limit == s.pos");
        }
        byte[][] byArrayArray = new byte[n5][];
        int[] nArray = new int[n5 * 2];
        s2 = this.g;
        n4 = 0;
        while (n3 < n2) {
            k.b(s2);
            byArrayArray[n4] = s2.a;
            nArray[n4] = Math.min((int)(n3 += s2.c - s2.b), (int)n2);
            nArray[n4 + n5] = s2.b;
            s2.d = true;
            ++n4;
            s2 = s2.f;
        }
        return new u(byArrayArray, nArray);
    }

    public final s K0(int n2) {
        boolean bl = true;
        if (n2 < 1 || n2 > 8192) {
            bl = false;
        }
        if (bl) {
            s s2 = this.g;
            if (s2 == null) {
                this.g = s2 = t.c();
                s2.g = s2;
                s2.f = s2;
                return s2;
            }
            k.b(s2);
            s2 = s2.g;
            k.b(s2);
            if (s2.c + n2 <= 8192 && s2.e) {
                return s2;
            }
            return s2.c(t.c());
        }
        throw new IllegalArgumentException("unexpected capacity");
    }

    public final byte L(long l2) {
        C.b(this.A0(), l2, 1L);
        s s2 = this.g;
        if (s2 != null) {
            if (this.A0() - l2 < l2) {
                long l3;
                for (l3 = this.A0(); l3 > l2; l3 -= (long)(s2.c - s2.b)) {
                    s2 = s2.g;
                    k.b(s2);
                }
                k.b(s2);
                return s2.a[(int)((long)s2.b + l2 - l3)];
            }
            long l4 = 0L;
            while (true) {
                long l5;
                if ((l5 = (long)(s2.c - s2.b) + l4) > l2) {
                    k.b(s2);
                    return s2.a[(int)((long)s2.b + l2 - l4)];
                }
                s2 = s2.f;
                k.b(s2);
                l4 = l5;
            }
        }
        k.b(null);
        throw null;
    }

    public b L0(e e2) {
        k.e(e2, "byteString");
        e2.y(this, 0, e2.u());
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public long M(byte by, long l2, long l3) {
        int n2;
        long l4 = 0L;
        int n3 = n2 = 0;
        if (0L <= l2) {
            n3 = n2;
            if (l2 <= l3) {
                n3 = 1;
            }
        }
        if (n3 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("size=");
            stringBuilder.append(this.A0());
            stringBuilder.append(" fromIndex=");
            stringBuilder.append(l2);
            stringBuilder.append(" toIndex=");
            stringBuilder.append(l3);
            throw new IllegalArgumentException(stringBuilder.toString().toString());
        }
        long l5 = l3;
        if (l3 > this.A0()) {
            l5 = this.A0();
        }
        if (l2 == l5) {
            return -1L;
        }
        Object object = this.g;
        if (object == null) {
            return -1L;
        }
        l3 = l4;
        s s2 = object;
        if (this.A0() - l2 < l2) {
            long l6;
            l4 = this.A0();
            while (true) {
                l3 = l4;
                l6 = l2;
                s2 = object;
                if (l4 <= l2) break;
                object = ((s)object).g;
                k.b(object);
                l4 -= (long)(((s)object).c - ((s)object).b);
            }
            while (l3 < l5) {
                object = s2.a;
                n2 = (int)Math.min((long)s2.c, (long)((long)s2.b + l5 - l3));
                for (n3 = (int)((long)s2.b + l6 - l3); n3 < n2; ++n3) {
                    if (object[n3] != by) continue;
                    return (long)(n3 - s2.b) + l3;
                }
                s2 = s2.f;
                k.b(s2);
                l6 = l3 += (long)(s2.c - s2.b);
            }
            return -1L;
        }
        while ((l4 = (long)(s2.c - s2.b) + l3) <= l2) {
            s2 = s2.f;
            k.b(s2);
            l3 = l4;
        }
        while (l3 < l5) {
            object = s2.a;
            n2 = (int)Math.min((long)s2.c, (long)((long)s2.b + l5 - l3));
            for (n3 = (int)((long)s2.b + l2 - l3); n3 < n2; ++n3) {
                if (object[n3] != by) continue;
                return (long)(n3 - s2.b) + l3;
            }
            s2 = s2.f;
            k.b(s2);
            l2 = l3 += (long)(s2.c - s2.b);
        }
        return -1L;
    }

    public b M0(byte[] byArray) {
        k.e(byArray, "source");
        return this.N0(byArray, 0, byArray.length);
    }

    public b N0(byte[] byArray, int n2, int n3) {
        k.e(byArray, "source");
        long l2 = byArray.length;
        long l3 = n2;
        long l4 = n3;
        C.b(l2, l3, l4);
        int n4 = n3 + n2;
        while (n2 < n4) {
            s s2 = this.K0(1);
            int n5 = Math.min((int)(n4 - n2), (int)(8192 - s2.c));
            byte[] byArray2 = s2.a;
            int n6 = s2.c;
            n3 = n2 + n5;
            i.d(byArray, byArray2, n6, n2, n3);
            s2.c += n5;
            n2 = n3;
        }
        this.s0(this.A0() + l4);
        return this;
    }

    @Override
    public boolean O() {
        return this.h == 0L;
    }

    public long O0(x x2) {
        k.e(x2, "source");
        long l2 = 0L;
        long l3;
        while ((l3 = x2.j0(this, 8192L)) != -1L) {
            l2 += l3;
        }
        return l2;
    }

    public long P(e e2) {
        k.e(e2, "targetBytes");
        return this.X(e2, 0L);
    }

    public b P0(int n2) {
        s s2 = this.K0(1);
        byte[] byArray = s2.a;
        int n3 = s2.c;
        s2.c = n3 + 1;
        byArray[n3] = (byte)n2;
        this.s0(this.A0() + 1L);
        return this;
    }

    public b Q0(long l2) {
        if (l2 == 0L) {
            return this.P0(48);
        }
        long l3 = l2 >>> 1 | l2;
        l3 |= l3 >>> 2;
        l3 |= l3 >>> 4;
        l3 |= l3 >>> 8;
        l3 |= l3 >>> 16;
        l3 |= l3 >>> 32;
        l3 -= l3 >>> 1 & 0x5555555555555555L;
        l3 = (l3 >>> 2 & 0x3333333333333333L) + (l3 & 0x3333333333333333L);
        l3 = (l3 >>> 4) + l3 & 0xF0F0F0F0F0F0F0FL;
        l3 += l3 >>> 8;
        l3 += l3 >>> 16;
        int n2 = (int)(((l3 & 0x3FL) + (l3 >>> 32 & 0x3FL) + (long)3) / (long)4);
        s s2 = this.K0(n2);
        byte[] byArray = s2.a;
        int n3 = s2.c;
        for (int i2 = n3 + n2 - 1; i2 >= n3; --i2) {
            byArray[i2] = A3.a.a()[(int)(0xFL & l2)];
            l2 >>>= 4;
        }
        s2.c += n2;
        this.s0(this.A0() + (long)n2);
        return this;
    }

    public b R0(int n2) {
        s s2 = this.K0(4);
        byte[] byArray = s2.a;
        int n3 = s2.c;
        byArray[n3] = (byte)(n2 >>> 24 & 0xFF);
        byArray[n3 + 1] = (byte)(n2 >>> 16 & 0xFF);
        byArray[n3 + 2] = (byte)(n2 >>> 8 & 0xFF);
        byArray[n3 + 3] = (byte)(n2 & 0xFF);
        s2.c = n3 + 4;
        this.s0(this.A0() + 4L);
        return this;
    }

    @Override
    public byte[] S(long l2) {
        boolean bl = l2 >= 0L && l2 <= Integer.MAX_VALUE;
        if (bl) {
            if (this.A0() >= l2) {
                byte[] byArray = new byte[(int)l2];
                this.b0(byArray);
                return byArray;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(k.j("byteCount: ", l2).toString());
    }

    public b S0(int n2) {
        s s2 = this.K0(2);
        byte[] byArray = s2.a;
        int n3 = s2.c;
        byArray[n3] = (byte)(n2 >>> 8 & 0xFF);
        byArray[n3 + 1] = (byte)(n2 & 0xFF);
        s2.c = n3 + 2;
        this.s0(this.A0() + 2L);
        return this;
    }

    public b T0(String object, int n2, int n3, Charset charset) {
        k.e(object, "string");
        k.e(charset, "charset");
        boolean bl = true;
        boolean bl2 = n2 >= 0;
        if (bl2) {
            bl2 = n3 >= n2;
            if (bl2) {
                bl2 = n3 <= object.length() ? bl : false;
                if (bl2) {
                    if (k.a(charset, b3.d.b)) {
                        return this.V0((String)object, n2, n3);
                    }
                    object = object.substring(n2, n3);
                    k.d(object, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    if (object != null) {
                        object = object.getBytes(charset);
                        k.d(object, "(this as java.lang.String).getBytes(charset)");
                        return this.N0((byte[])object, 0, ((Object)object).length);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                charset = new StringBuilder();
                charset.append("endIndex > string.length: ");
                charset.append(n3);
                charset.append(" > ");
                charset.append(object.length());
                throw new IllegalArgumentException(charset.toString().toString());
            }
            object = new StringBuilder();
            object.append("endIndex < beginIndex: ");
            object.append(n3);
            object.append(" < ");
            object.append(n2);
            throw new IllegalArgumentException(object.toString().toString());
        }
        throw new IllegalArgumentException(k.j("beginIndex < 0: ", n2).toString());
    }

    public b U0(String string) {
        k.e(string, "string");
        return this.V0(string, 0, string.length());
    }

    /*
     * Enabled aggressive block sorting
     */
    public b V0(String string, int n2, int n3) {
        k.e(string, "string");
        int n4 = n2 >= 0 ? 1 : 0;
        if (n4 == 0) {
            throw new IllegalArgumentException(k.j("beginIndex < 0: ", n2).toString());
        }
        n4 = n3 >= n2 ? 1 : 0;
        if (n4 == 0) {
            string = new StringBuilder();
            string.append("endIndex < beginIndex: ");
            string.append(n3);
            string.append(" < ");
            string.append(n2);
            throw new IllegalArgumentException(string.toString().toString());
        }
        n4 = n3 <= string.length() ? 1 : 0;
        if (n4 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("endIndex > string.length: ");
            stringBuilder.append(n3);
            stringBuilder.append(" > ");
            stringBuilder.append(string.length());
            throw new IllegalArgumentException(stringBuilder.toString().toString());
        }
        while (n2 < n3) {
            int n5;
            int n6;
            Object object;
            char c2 = string.charAt(n2);
            if (c2 < '\u0080') {
                object = this.K0(1);
                byte[] byArray = ((s)object).a;
                n6 = ((s)object).c - n2;
                n5 = Math.min((int)n3, (int)(8192 - n6));
                n4 = n2 + 1;
                byArray[n2 + n6] = (byte)c2;
                n2 = n4;
            } else {
                if (c2 < '\u0800') {
                    s s2 = this.K0(2);
                    object = s2.a;
                    n4 = s2.c;
                    object[n4] = (byte)(c2 >> 6 | 0xC0);
                    object[n4 + 1] = (byte)(c2 & 0x3F | 0x80);
                    s2.c = n4 + 2;
                    this.s0(this.A0() + 2L);
                } else {
                    if (c2 >= '\ud800' && c2 <= '\udfff') {
                        n6 = n2 + 1;
                        n4 = n6 < n3 ? (int)string.charAt(n6) : 0;
                        if (c2 <= '\udbff' && 56320 <= n4 && n4 <= 57343) {
                            n4 = ((c2 & 0x3FF) << 10 | n4 & 0x3FF) + 65536;
                            object = this.K0(4);
                            byte[] byArray = ((s)object).a;
                            n6 = ((s)object).c;
                            byArray[n6] = (byte)(n4 >> 18 | 0xF0);
                            byArray[n6 + 1] = (byte)(n4 >> 12 & 0x3F | 0x80);
                            byArray[n6 + 2] = (byte)(n4 >> 6 & 0x3F | 0x80);
                            byArray[n6 + 3] = (byte)(n4 & 0x3F | 0x80);
                            ((s)object).c = n6 + 4;
                            this.s0(this.A0() + 4L);
                            n2 += 2;
                            continue;
                        }
                        this.P0(63);
                        n2 = n6;
                        continue;
                    }
                    s s3 = this.K0(3);
                    object = s3.a;
                    n4 = s3.c;
                    object[n4] = (byte)(c2 >> 12 | 0xE0);
                    object[n4 + 1] = (byte)(0x3F & c2 >> 6 | 0x80);
                    object[n4 + 2] = (byte)(c2 & 0x3F | 0x80);
                    s3.c = n4 + 3;
                    this.s0(this.A0() + 3L);
                }
                ++n2;
                continue;
            }
            while (n2 < n5 && (c2 = string.charAt(n2)) < '\u0080') {
                n4 = n2 + 1;
                byArray[n2 + n6] = (byte)c2;
                n2 = n4;
            }
            n4 = ((s)object).c;
            n6 = n6 + n2 - n4;
            ((s)object).c = n4 + n6;
            this.s0(this.A0() + (long)n6);
        }
        return this;
    }

    public b W0(int n2) {
        if (n2 < 128) {
            this.P0(n2);
            return this;
        }
        if (n2 < 2048) {
            s s2 = this.K0(2);
            byte[] byArray = s2.a;
            int n3 = s2.c;
            byArray[n3] = (byte)(n2 >> 6 | 0xC0);
            byArray[n3 + 1] = (byte)(n2 & 0x3F | 0x80);
            s2.c = n3 + 2;
            this.s0(this.A0() + 2L);
            return this;
        }
        if (55296 <= n2 && n2 <= 57343) {
            this.P0(63);
            return this;
        }
        if (n2 < 65536) {
            s s3 = this.K0(3);
            byte[] byArray = s3.a;
            int n4 = s3.c;
            byArray[n4] = (byte)(n2 >> 12 | 0xE0);
            byArray[n4 + 1] = (byte)(n2 >> 6 & 0x3F | 0x80);
            byArray[n4 + 2] = (byte)(n2 & 0x3F | 0x80);
            s3.c = n4 + 3;
            this.s0(this.A0() + 3L);
            return this;
        }
        if (n2 <= 0x10FFFF) {
            s s4 = this.K0(4);
            byte[] byArray = s4.a;
            int n5 = s4.c;
            byArray[n5] = (byte)(n2 >> 18 | 0xF0);
            byArray[n5 + 1] = (byte)(n2 >> 12 & 0x3F | 0x80);
            byArray[n5 + 2] = (byte)(n2 >> 6 & 0x3F | 0x80);
            byArray[n5 + 3] = (byte)(n2 & 0x3F | 0x80);
            s4.c = n5 + 4;
            this.s0(this.A0() + 4L);
            return this;
        }
        throw new IllegalArgumentException(k.j("Unexpected code point: 0x", C.g(n2)));
    }

    /*
     * Enabled aggressive block sorting
     */
    public long X(e object, long l2) {
        int n2;
        s s2;
        int n3;
        long l3;
        block19: {
            Object object2;
            block20: {
                block18: {
                    k.e(object, "targetBytes");
                    l3 = 0L;
                    n3 = l2 >= 0L ? 1 : 0;
                    if (n3 == 0) throw new IllegalArgumentException(k.j("fromIndex < 0: ", l2).toString());
                    object2 = this.g;
                    if (object2 == null) {
                        return -1L;
                    }
                    s2 = object2;
                    if (this.A0() - l2 < l2) {
                        s2 = object2;
                        for (l3 = this.A0(); l3 > l2; l3 -= (long)(s2.c - s2.b)) {
                            s2 = s2.g;
                            k.b(s2);
                        }
                        if (((e)object).u() == 2) {
                            byte by = ((e)object).g(0);
                            byte by2 = ((e)object).g(1);
                            while (l3 < this.A0()) {
                                object2 = s2.a;
                                n2 = (int)((long)s2.b + l2 - l3);
                                int n4 = s2.c;
                                while (n2 < n4) {
                                    Object object3 = object2[n2];
                                    l2 = l3;
                                    object = s2;
                                    n3 = n2++;
                                    if (object3 != by) {
                                        if (object3 != by2) continue;
                                        l2 = l3;
                                        object = s2;
                                        n3 = n2;
                                    }
                                    break block18;
                                }
                                s2 = s2.f;
                                k.b(s2);
                                l2 = l3 += (long)(s2.c - s2.b);
                            }
                            return -1L;
                        }
                        object = ((e)object).n();
                        while (l3 < this.A0()) {
                            object2 = s2.a;
                            int n5 = s2.c;
                            for (n3 = (int)((long)s2.b + l2 - l3); n3 < n5; ++n3) {
                                Object object4 = object2[n3];
                                for (Object object5 : object) {
                                    if (object4 != object5) continue;
                                    break block19;
                                }
                            }
                            s2 = s2.f;
                            k.b(s2);
                            l2 = l3 += (long)(s2.c - s2.b);
                        }
                        return -1L;
                    }
                    while (true) {
                        long l4;
                        if ((l4 = (long)(s2.c - s2.b) + l3) > l2) {
                            if (((e)object).u() == 2) break;
                            break block20;
                        }
                        s2 = s2.f;
                        k.b(s2);
                        l3 = l4;
                    }
                    byte by = ((e)object).g(0);
                    byte by3 = ((e)object).g(1);
                    while (l3 < this.A0()) {
                        object2 = s2.a;
                        n2 = (int)((long)s2.b + l2 - l3);
                        int n6 = s2.c;
                        while (n2 < n6) {
                            Object object6 = object2[n2];
                            l2 = l3;
                            object = s2;
                            n3 = n2++;
                            if (object6 != by) {
                                if (object6 != by3) continue;
                                l2 = l3;
                                object = s2;
                                n3 = n2;
                            }
                            break block18;
                        }
                        s2 = s2.f;
                        k.b(s2);
                        l2 = l3 += (long)(s2.c - s2.b);
                    }
                    return -1L;
                }
                n2 = ((s)object).b;
                return (long)(n3 - n2) + l2;
            }
            object = ((e)object).n();
            while (l3 < this.A0()) {
                object2 = s2.a;
                int n7 = s2.c;
                for (n3 = (int)((long)s2.b + l2 - l3); n3 < n7; ++n3) {
                    Object object7 = object2[n3];
                    for (Object object8 : object) {
                        if (object7 != object8) continue;
                        break block19;
                    }
                }
                s2 = s2.f;
                k.b(s2);
                l2 = l3 += (long)(s2.c - s2.b);
            }
            return -1L;
        }
        n2 = s2.b;
        l2 = l3;
        return (long)(n3 - n2) + l2;
    }

    public int Y(byte[] byArray, int n2, int n3) {
        k.e(byArray, "sink");
        C.b(byArray.length, n2, n3);
        s s2 = this.g;
        if (s2 == null) {
            return -1;
        }
        int n4 = Math.min((int)n3, (int)(s2.c - s2.b));
        byte[] byArray2 = s2.a;
        n3 = s2.b;
        i.d(byArray2, byArray, n2, n3, n3 + n4);
        s2.b += n4;
        this.s0(this.A0() - (long)n4);
        if (s2.b == s2.c) {
            this.g = s2.b();
            t.b(s2);
        }
        return n4;
    }

    public byte[] Z() {
        return this.S(this.A0());
    }

    public final void a() {
        this.x(this.A0());
    }

    public e a0() {
        return this.u(this.A0());
    }

    public void b0(byte[] byArray) {
        int n2;
        k.e(byArray, "sink");
        for (int i2 = 0; i2 < byArray.length; i2 += n2) {
            n2 = this.Y(byArray, i2, byArray.length - i2);
            if (n2 != -1) {
                continue;
            }
            throw new EOFException();
        }
    }

    public int c0() {
        return C.d(this.D());
    }

    @Override
    public void close() {
    }

    @Override
    public String d0(long l2) {
        boolean bl = l2 >= 0L;
        if (bl) {
            long l3 = Long.MAX_VALUE;
            if (l2 != Long.MAX_VALUE) {
                l3 = l2 + 1L;
            }
            byte by = (byte)10;
            long l4 = this.M(by, 0L, l3);
            if (l4 != -1L) {
                return A3.a.b(this, l4);
            }
            if (l3 < this.A0() && this.L(l3 - 1L) == (byte)13 && this.L(l3) == by) {
                return A3.a.b(this, l3);
            }
            b b2 = new b();
            l3 = this.A0();
            this.I(b2, 0L, Math.min((long)32, (long)l3));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\\n not found: limit=");
            stringBuilder.append(Math.min((long)this.A0(), (long)l2));
            stringBuilder.append(" content=");
            stringBuilder.append(b2.a0().m());
            stringBuilder.append('\u2026');
            throw new EOFException(stringBuilder.toString());
        }
        throw new IllegalArgumentException(k.j("limit < 0: ", l2).toString());
    }

    public boolean equals(Object object) {
        long l2;
        if (this == object) {
            return true;
        }
        if (!(object instanceof b)) {
            return false;
        }
        long l3 = this.A0();
        if (l3 != ((b)(object = (b)object)).A0()) {
            return false;
        }
        if (this.A0() == 0L) {
            return true;
        }
        Object object2 = this.g;
        k.b(object2);
        object = ((b)object).g;
        k.b(object);
        int n2 = ((s)object2).b;
        Object object3 = ((s)object).b;
        for (l3 = 0L; l3 < this.A0(); l3 += l2) {
            Object object4;
            l2 = Math.min((int)(((s)object2).c - n2), (int)(((s)object).c - object3));
            Object object5 = n2;
            Object object6 = object3;
            if (0L < l2) {
                long l4 = 0L;
                while (true) {
                    ++l4;
                    object4 = ((s)object2).a;
                    object6 = n2 + 1;
                    object5 = object4[n2];
                    object4 = ((s)object).a;
                    n2 = object3 + 1;
                    if (object5 != object4[object3]) {
                        return false;
                    }
                    if (l4 >= l2) {
                        object5 = object6;
                        object6 = n2;
                        break;
                    }
                    object3 = n2;
                    n2 = object6;
                }
            }
            object4 = object2;
            n2 = object5;
            if (object5 == ((s)object2).c) {
                object4 = ((s)object2).f;
                k.b(object4);
                n2 = ((s)object4).b;
            }
            object2 = object;
            object3 = object6;
            if (object6 == ((s)object).c) {
                object2 = ((s)object).f;
                k.b(object2);
                object3 = ((s)object2).b;
            }
            object = object2;
            object2 = object4;
        }
        return true;
    }

    @Override
    public short f0() {
        if (this.A0() >= 2L) {
            s s2 = this.g;
            k.b(s2);
            int n2 = s2.b;
            int n3 = s2.c;
            if (n3 - n2 < 2) {
                return (short)((this.G0() & 0xFF) << 8 | this.G0() & 0xFF);
            }
            byte[] byArray = s2.a;
            byte by = byArray[n2];
            int n4 = n2 + 2;
            n2 = byArray[n2 + 1];
            this.s0(this.A0() - 2L);
            if (n4 == n3) {
                this.g = s2.b();
                t.b(s2);
            } else {
                s2.b = n4;
            }
            return (short)(n2 & 0xFF | (by & 0xFF) << 8);
        }
        throw new EOFException();
    }

    @Override
    public void flush() {
    }

    @Override
    public b g() {
        return this;
    }

    @Override
    public y h() {
        return y.e;
    }

    public int hashCode() {
        int n2;
        s s2;
        s s3 = this.g;
        if (s3 == null) {
            return 0;
        }
        int n3 = 1;
        do {
            int n4 = s3.c;
            n2 = n3;
            for (int i2 = s3.b; i2 < n4; ++i2) {
                n2 = n2 * 31 + s3.a[i2];
            }
            s2 = s3.f;
            k.b(s2);
            s3 = s2;
            n3 = n2;
        } while (s2 != this.g);
        return n2;
    }

    public b i() {
        return this.F();
    }

    public short i0() {
        return C.e(this.f0());
    }

    public boolean isOpen() {
        return true;
    }

    @Override
    public long j0(b b2, long l2) {
        k.e(b2, "sink");
        boolean bl = l2 >= 0L;
        if (bl) {
            if (this.A0() == 0L) {
                return -1L;
            }
            long l3 = l2;
            if (l2 > this.A0()) {
                l3 = this.A0();
            }
            b2.q(this, l3);
            return l3;
        }
        throw new IllegalArgumentException(k.j("byteCount < 0: ", l2).toString());
    }

    public String k0(long l2, Charset object) {
        k.e(object, "charset");
        long l3 = l2 - 0L;
        long l4 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
        int n2 = l4 >= 0 && l2 <= Integer.MAX_VALUE ? 1 : 0;
        if (n2 != 0) {
            if (this.h >= l2) {
                if (l4 == false) {
                    return "";
                }
                s s2 = this.g;
                k.b(s2);
                n2 = s2.b;
                if ((long)n2 + l2 > (long)s2.c) {
                    return new String(this.S(l2), object);
                }
                byte[] byArray = s2.a;
                l4 = (int)l2;
                object = new String(byArray, n2, (int)l4, object);
                s2.b = n2 = s2.b + l4;
                this.h -= l2;
                if (n2 == s2.c) {
                    this.g = s2.b();
                    t.b(s2);
                }
                return object;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(k.j("byteCount: ", l2).toString());
    }

    public String l0() {
        return this.k0(this.h, b3.d.b);
    }

    public String n0(long l2) {
        return this.k0(l2, b3.d.b);
    }

    @Override
    public void q(b b2, long l2) {
        k.e(b2, "source");
        int n2 = b2 != this ? 1 : 0;
        if (n2 != 0) {
            C.b(b2.A0(), 0L, l2);
            while (l2 > 0L) {
                s s2;
                long l3;
                s s3 = b2.g;
                k.b(s3);
                n2 = s3.c;
                s3 = b2.g;
                k.b(s3);
                if (l2 < (long)(n2 - s3.b)) {
                    s3 = this.g;
                    if (s3 != null) {
                        k.b(s3);
                        s3 = s3.g;
                    } else {
                        s3 = null;
                    }
                    if (s3 != null && s3.e && (l3 = (long)s3.c) + l2 - (long)(n2 = s3.d ? 0 : s3.b) <= 8192L) {
                        s2 = b2.g;
                        k.b(s2);
                        s2.f(s3, (int)l2);
                        b2.s0(b2.A0() - l2);
                        this.s0(this.A0() + l2);
                        return;
                    }
                    s3 = b2.g;
                    k.b(s3);
                    b2.g = s3.e((int)l2);
                }
                s3 = b2.g;
                k.b(s3);
                l3 = s3.c - s3.b;
                b2.g = s3.b();
                s2 = this.g;
                if (s2 == null) {
                    this.g = s3;
                    s3.g = s3;
                    s3.f = s3;
                } else {
                    k.b(s2);
                    s2 = s2.g;
                    k.b(s2);
                    s2.c(s3).a();
                }
                b2.s0(b2.A0() - l3);
                this.s0(this.A0() + l3);
                l2 -= l3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this");
    }

    public int read(ByteBuffer byteBuffer) {
        int n2;
        k.e(byteBuffer, "sink");
        s s2 = this.g;
        if (s2 == null) {
            return -1;
        }
        int n3 = Math.min((int)byteBuffer.remaining(), (int)(s2.c - s2.b));
        byteBuffer.put(s2.a, s2.b, n3);
        s2.b = n2 = s2.b + n3;
        this.h -= (long)n3;
        if (n2 == s2.c) {
            this.g = s2.b();
            t.b(s2);
        }
        return n3;
    }

    public final void s0(long l2) {
        this.h = l2;
    }

    public String toString() {
        return this.I0().toString();
    }

    @Override
    public e u(long l2) {
        boolean bl = l2 >= 0L && l2 <= Integer.MAX_VALUE;
        if (bl) {
            if (this.A0() >= l2) {
                if (l2 >= 4096L) {
                    e e2 = this.J0((int)l2);
                    this.x(l2);
                    return e2;
                }
                return new e(this.S(l2));
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(k.j("byteCount: ", l2).toString());
    }

    @Override
    public void u0(long l2) {
        if (this.h >= l2) {
            return;
        }
        throw new EOFException();
    }

    public int write(ByteBuffer byteBuffer) {
        int n2;
        k.e(byteBuffer, "source");
        int n3 = n2 = byteBuffer.remaining();
        while (n3 > 0) {
            s s2 = this.K0(1);
            int n4 = Math.min((int)n3, (int)(8192 - s2.c));
            byteBuffer.get(s2.a, s2.c, n4);
            n3 -= n4;
            s2.c += n4;
        }
        this.h += (long)n2;
        return n2;
    }

    @Override
    public void x(long l2) {
        while (l2 > 0L) {
            s s2 = this.g;
            if (s2 != null) {
                int n2 = (int)Math.min((long)l2, (long)(s2.c - s2.b));
                long l3 = this.A0();
                long l4 = n2;
                this.s0(l3 - l4);
                l3 = l2 - l4;
                s2.b = n2 = s2.b + n2;
                l2 = l3;
                if (n2 != s2.c) continue;
                this.g = s2.b();
                t.b(s2);
                l2 = l3;
                continue;
            }
            throw new EOFException();
        }
    }

    public static final class a
    implements Closeable,
    AutoCloseable {
        public b g;
        private s h;
        public long i = -1L;
        public byte[] j;
        public int k = -1;
        public int l = -1;

        public final void a(s s2) {
            this.h = s2;
        }

        public void close() {
            boolean bl = this.g != null;
            if (bl) {
                this.g = null;
                this.a(null);
                this.i = -1L;
                this.j = null;
                this.k = -1;
                this.l = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }
    }
}

