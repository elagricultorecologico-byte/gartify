/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.ProtocolException
 */
package r3;

import V2.k;
import java.io.IOException;
import java.net.ProtocolException;
import m3.A;
import m3.B;
import m3.q;
import m3.y;
import m3.z;
import r3.d;
import r3.e;
import r3.f;
import s3.h;
import z3.g;
import z3.l;
import z3.v;
import z3.x;

public final class c {
    private final e a;
    private final q b;
    private final d c;
    private final s3.d d;
    private boolean e;
    private final f f;

    public c(e e2, q q2, d d2, s3.d d3) {
        k.e(e2, "call");
        k.e(q2, "eventListener");
        k.e(d2, "finder");
        k.e(d3, "codec");
        this.a = e2;
        this.b = q2;
        this.c = d2;
        this.d = d3;
        this.f = d3.h();
    }

    private final void s(IOException iOException) {
        this.c.h(iOException);
        this.d.h().G(this.a, iOException);
    }

    public final IOException a(long l2, boolean bl, boolean bl2, IOException iOException) {
        if (iOException != null) {
            this.s(iOException);
        }
        if (bl2) {
            if (iOException != null) {
                this.b.r(this.a, iOException);
            } else {
                this.b.p(this.a, l2);
            }
        }
        if (bl) {
            if (iOException != null) {
                this.b.w(this.a, iOException);
            } else {
                this.b.u(this.a, l2);
            }
        }
        return this.a.s(this, bl2, bl, iOException);
    }

    public final void b() {
        this.d.cancel();
    }

    public final v c(y y2, boolean bl) {
        k.e(y2, "request");
        this.e = bl;
        z z2 = y2.a();
        k.b(z2);
        long l2 = z2.a();
        this.b.q(this.a);
        return new a(this, this.d.d(y2, l2), l2);
    }

    public final void d() {
        this.d.cancel();
        this.a.s(this, true, true, null);
    }

    public final void e() {
        try {
            this.d.c();
            return;
        }
        catch (IOException iOException) {
            this.b.r(this.a, iOException);
            this.s(iOException);
            throw iOException;
        }
    }

    public final void f() {
        try {
            this.d.f();
            return;
        }
        catch (IOException iOException) {
            this.b.r(this.a, iOException);
            this.s(iOException);
            throw iOException;
        }
    }

    public final e g() {
        return this.a;
    }

    public final f h() {
        return this.f;
    }

    public final q i() {
        return this.b;
    }

    public final d j() {
        return this.c;
    }

    public final boolean k() {
        return k.a(this.c.d().l().h(), this.f.z().a().l().h()) ^ true;
    }

    public final boolean l() {
        return this.e;
    }

    public final void m() {
        this.d.h().y();
    }

    public final void n() {
        this.a.s(this, true, false, null);
    }

    public final B o(A object) {
        k.e(object, "response");
        try {
            String string = A.L(object, "Content-Type", null, 2, null);
            long l2 = this.d.e((A)object);
            object = this.d.a((A)object);
            b b2 = new b(this, (x)object, l2);
            object = new h(string, l2, l.b(b2));
            return object;
        }
        catch (IOException iOException) {
            this.b.w(this.a, iOException);
            this.s(iOException);
            throw iOException;
        }
    }

    public final A.a p(boolean bl) {
        A.a a2;
        block3: {
            try {
                a2 = this.d.g(bl);
                if (a2 != null) break block3;
                return a2;
            }
            catch (IOException iOException) {
                this.b.w(this.a, iOException);
                this.s(iOException);
                throw iOException;
            }
        }
        a2.m(this);
        return a2;
    }

    public final void q(A a2) {
        k.e(a2, "response");
        this.b.x(this.a, a2);
    }

    public final void r() {
        this.b.y(this.a);
    }

    public final void t(y y2) {
        k.e(y2, "request");
        try {
            this.b.t(this.a);
            this.d.b(y2);
            this.b.s(this.a, y2);
            return;
        }
        catch (IOException iOException) {
            this.b.r(this.a, iOException);
            this.s(iOException);
            throw iOException;
        }
    }

    private final class a
    extends z3.f {
        private final long h;
        private boolean i;
        private long j;
        private boolean k;
        final c l;

        public a(c c2, v v2, long l2) {
            V2.k.e(c2, "this$0");
            V2.k.e(v2, "delegate");
            this.l = c2;
            super(v2);
            this.h = l2;
        }

        private final IOException a(IOException iOException) {
            if (this.i) {
                return iOException;
            }
            this.i = true;
            return this.l.a(this.j, false, true, iOException);
        }

        @Override
        public void close() {
            if (this.k) {
                return;
            }
            this.k = true;
            long l2 = this.h;
            if (l2 != -1L && this.j != l2) {
                throw new ProtocolException("unexpected end of stream");
            }
            try {
                super.close();
                this.a(null);
                return;
            }
            catch (IOException iOException) {
                throw this.a(iOException);
            }
        }

        @Override
        public void flush() {
            try {
                super.flush();
                return;
            }
            catch (IOException iOException) {
                throw this.a(iOException);
            }
        }

        @Override
        public void q(z3.b b2, long l2) {
            V2.k.e(b2, "source");
            if (!this.k) {
                long l3 = this.h;
                if (l3 != -1L && this.j + l2 > l3) {
                    b2 = new StringBuilder();
                    b2.append("expected ");
                    b2.append(this.h);
                    b2.append(" bytes but received ");
                    b2.append(this.j + l2);
                    throw new ProtocolException(b2.toString());
                }
                try {
                    super.q(b2, l2);
                    this.j += l2;
                    return;
                }
                catch (IOException iOException) {
                    throw this.a(iOException);
                }
            }
            throw new IllegalStateException("closed");
        }
    }

    public final class b
    extends g {
        private final long h;
        private long i;
        private boolean j;
        private boolean k;
        private boolean l;
        final c m;

        public b(c c2, x x2, long l2) {
            V2.k.e(c2, "this$0");
            V2.k.e(x2, "delegate");
            this.m = c2;
            super(x2);
            this.h = l2;
            this.j = true;
            if (l2 == 0L) {
                this.f(null);
            }
        }

        @Override
        public void close() {
            if (this.l) {
                return;
            }
            this.l = true;
            try {
                super.close();
                this.f(null);
                return;
            }
            catch (IOException iOException) {
                throw this.f(iOException);
            }
        }

        public final IOException f(IOException iOException) {
            if (this.k) {
                return iOException;
            }
            this.k = true;
            if (iOException == null && this.j) {
                this.j = false;
                this.m.i().v(this.m.g());
            }
            return this.m.a(this.i, true, false, iOException);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public long j0(z3.b b2, long l2) {
            long l3;
            V2.k.e(b2, "sink");
            if (this.l) throw new IllegalStateException("closed");
            try {
                l3 = this.a().j0(b2, l2);
                if (this.j) {
                    this.j = false;
                    this.m.i().v(this.m.g());
                }
            }
            catch (IOException iOException) {
                throw this.f(iOException);
            }
            if (l3 == -1L) {
                this.f(null);
                return -1L;
            }
            long l4 = this.i + l3;
            l2 = this.h;
            if (l2 != -1L && l4 > l2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("expected ");
                stringBuilder.append(this.h);
                stringBuilder.append(" bytes but received ");
                stringBuilder.append(l4);
                b2 = new ProtocolException(stringBuilder.toString());
                throw b2;
            }
            this.i = l4;
            if (l4 != l2) return l3;
            this.f(null);
            return l3;
        }
    }
}

