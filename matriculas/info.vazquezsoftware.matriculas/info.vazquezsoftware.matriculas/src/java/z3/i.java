/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.AutoCloseable
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.zip.CRC32
 *  java.util.zip.Inflater
 */
package z3;

import V2.k;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import z3.b;
import z3.d;
import z3.j;
import z3.r;
import z3.s;
import z3.x;
import z3.y;

public final class i
implements x,
AutoCloseable {
    private byte g;
    private final r h;
    private final Inflater i;
    private final j j;
    private final CRC32 k;

    public i(x x2) {
        Inflater inflater;
        V2.k.e(x2, "source");
        x2 = new r(x2);
        this.h = x2;
        this.i = inflater = new Inflater(true);
        this.j = new j((d)x2, inflater);
        this.k = new CRC32();
    }

    private final void a(String string, int n2, int n3) {
        if (n3 == n2) {
            return;
        }
        string = String.format((String)"%s: actual 0x%08x != expected 0x%08x", (Object[])Arrays.copyOf((Object[])new Object[]{string, n3, n2}, (int)3));
        V2.k.d(string, "java.lang.String.format(this, *args)");
        throw new IOException(string);
    }

    private final void f() {
        long l2;
        this.h.u0(10L);
        byte by = this.h.h.L(3L);
        boolean bl = (by >> 1 & 1) == 1;
        if (bl) {
            this.j(this.h.h, 0L, 10L);
        }
        this.a("ID1ID2", 8075, this.h.f0());
        this.h.x(8L);
        if ((by >> 2 & 1) == 1) {
            this.h.u0(2L);
            if (bl) {
                this.j(this.h.h, 0L, 2L);
            }
            l2 = this.h.h.i0();
            this.h.u0(l2);
            if (bl) {
                this.j(this.h.h, 0L, l2);
            }
            this.h.x(l2);
        }
        if ((by >> 3 & 1) == 1) {
            l2 = this.h.a((byte)0);
            if (l2 != -1L) {
                if (bl) {
                    this.j(this.h.h, 0L, l2 + 1L);
                }
                this.h.x(l2 + 1L);
            } else {
                throw new EOFException();
            }
        }
        if ((by >> 4 & 1) == 1) {
            l2 = this.h.a((byte)0);
            if (l2 != -1L) {
                if (bl) {
                    this.j(this.h.h, 0L, l2 + 1L);
                }
                this.h.x(l2 + 1L);
            } else {
                throw new EOFException();
            }
        }
        if (bl) {
            this.a("FHCRC", this.h.j(), (short)this.k.getValue());
            this.k.reset();
        }
    }

    private final void i() {
        this.a("CRC", this.h.i(), (int)this.k.getValue());
        this.a("ISIZE", this.h.i(), (int)this.i.getBytesWritten());
    }

    private final void j(b object, long l2, long l3) {
        long l4;
        Object object2;
        int n2;
        int n3;
        object = ((b)object).g;
        V2.k.b(object);
        while (true) {
            n3 = ((s)object).c;
            n2 = ((s)object).b;
            object2 = object;
            l4 = l2;
            if (l2 < (long)(n3 - n2)) break;
            l2 -= (long)(n3 - n2);
            object = ((s)object).f;
            V2.k.b(object);
        }
        for (long i2 = l3; i2 > 0L; i2 -= (long)n2) {
            n3 = (int)((long)((s)object2).b + l4);
            n2 = (int)Math.min((long)(((s)object2).c - n3), (long)i2);
            this.k.update(((s)object2).a, n3, n2);
            object2 = ((s)object2).f;
            V2.k.b(object2);
            l4 = 0L;
        }
    }

    @Override
    public void close() {
        this.j.close();
    }

    @Override
    public y h() {
        return this.h.h();
    }

    @Override
    public long j0(b b2, long l2) {
        V2.k.e(b2, "sink");
        long l3 = l2 - 0L;
        long l4 = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
        boolean bl = l4 >= 0;
        if (bl) {
            if (l4 == false) {
                return 0L;
            }
            if (this.g == 0) {
                this.f();
                this.g = 1;
            }
            if (this.g == 1) {
                long l5 = b2.A0();
                if ((l2 = this.j.j0(b2, l2)) != -1L) {
                    this.j(b2, l5, l2);
                    return l2;
                }
                this.g = (byte)2;
            }
            if (this.g == 2) {
                this.i();
                this.g = (byte)3;
                if (!this.h.O()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
        throw new IllegalArgumentException(V2.k.j("byteCount < 0: ", l2).toString());
    }
}

