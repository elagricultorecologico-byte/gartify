/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.AutoCloseable
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.ProtocolException
 *  java.net.Proxy$Type
 *  java.util.concurrent.TimeUnit
 */
package t3;

import b3.h;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import m3.A;
import m3.m;
import m3.s;
import m3.t;
import m3.w;
import s3.i;
import s3.k;
import z3.v;
import z3.x;
import z3.y;

public final class b
implements s3.d {
    public static final d h = new d(null);
    private final w a;
    private final r3.f b;
    private final z3.d c;
    private final z3.c d;
    private int e;
    private final t3.a f;
    private s g;

    public b(w w2, r3.f f2, z3.d d2, z3.c c2) {
        V2.k.e(f2, "connection");
        V2.k.e(d2, "source");
        V2.k.e(c2, "sink");
        this.a = w2;
        this.b = f2;
        this.c = d2;
        this.d = c2;
        this.f = new t3.a(d2);
    }

    private final void r(z3.h h2) {
        y y2 = h2.i();
        h2.j(y.e);
        y2.a();
        y2.b();
    }

    private final boolean s(m3.y y2) {
        return b3.h.u("chunked", y2.d("Transfer-Encoding"), true);
    }

    private final boolean t(A a2) {
        return b3.h.u("chunked", A.L(a2, "Transfer-Encoding", null, 2, null), true);
    }

    private final v u() {
        int n2 = this.e;
        if (n2 == 1) {
            this.e = 2;
            return new b(this);
        }
        throw new IllegalStateException(V2.k.j("state: ", n2).toString());
    }

    private final x v(t t2) {
        int n2 = this.e;
        if (n2 == 4) {
            this.e = 5;
            return new c(this, t2);
        }
        throw new IllegalStateException(V2.k.j("state: ", n2).toString());
    }

    private final x w(long l2) {
        int n2 = this.e;
        if (n2 == 4) {
            this.e = 5;
            return new e(this, l2);
        }
        throw new IllegalStateException(V2.k.j("state: ", n2).toString());
    }

    private final v x() {
        int n2 = this.e;
        if (n2 == 1) {
            this.e = 2;
            return new f(this);
        }
        throw new IllegalStateException(V2.k.j("state: ", n2).toString());
    }

    private final x y() {
        int n2 = this.e;
        if (n2 == 4) {
            this.e = 5;
            this.h().y();
            return new g(this);
        }
        throw new IllegalStateException(V2.k.j("state: ", n2).toString());
    }

    public final void A(s s2, String string) {
        V2.k.e(s2, "headers");
        V2.k.e(string, "requestLine");
        int n2 = this.e;
        if (n2 == 0) {
            this.d.w0(string).w0("\r\n");
            int n3 = s2.size();
            for (n2 = 0; n2 < n3; ++n2) {
                this.d.w0(s2.f(n2)).w0(": ").w0(s2.i(n2)).w0("\r\n");
            }
            this.d.w0("\r\n");
            this.e = 1;
            return;
        }
        throw new IllegalStateException(V2.k.j("state: ", n2).toString());
    }

    @Override
    public x a(A a2) {
        V2.k.e(a2, "response");
        if (!s3.e.b(a2)) {
            return this.w(0L);
        }
        if (this.t(a2)) {
            return this.v(a2.i0().i());
        }
        long l2 = n3.d.v(a2);
        if (l2 != -1L) {
            return this.w(l2);
        }
        return this.y();
    }

    @Override
    public void b(m3.y y2) {
        V2.k.e(y2, "request");
        i i2 = i.a;
        Object object = this.h().z().b().type();
        V2.k.d(object, "connection.route().proxy.type()");
        object = i2.a(y2, (Proxy.Type)object);
        this.A(y2.e(), (String)object);
    }

    @Override
    public void c() {
        this.d.flush();
    }

    @Override
    public void cancel() {
        this.h().d();
    }

    @Override
    public v d(m3.y y2, long l2) {
        V2.k.e(y2, "request");
        if (y2.a() != null && y2.a().d()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        }
        if (this.s(y2)) {
            return this.u();
        }
        if (l2 != -1L) {
            return this.x();
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override
    public long e(A a2) {
        V2.k.e(a2, "response");
        if (!s3.e.b(a2)) {
            return 0L;
        }
        if (this.t(a2)) {
            return -1L;
        }
        return n3.d.v(a2);
    }

    @Override
    public void f() {
        this.d.flush();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public A.a g(boolean bl) {
        A.a a2;
        k k2;
        int n2 = this.e;
        if (n2 != 1) {
            if (n2 != 3) throw new IllegalStateException(V2.k.j("state: ", n2).toString());
        }
        try {
            k2 = k.d.a(this.f.b());
            a2 = new A.a();
            a2 = a2.q(k2.a).g(k2.b).n(k2.c).l(this.f.a());
            if (bl && k2.b == 100) {
                return null;
            }
        }
        catch (EOFException eOFException) {
            throw new IOException(V2.k.j("unexpected end of stream on ", this.h().z().a().l().n()), (Throwable)eOFException);
        }
        if (k2.b == 100) {
            this.e = 3;
            return a2;
        }
        this.e = 4;
        return a2;
    }

    @Override
    public r3.f h() {
        return this.b;
    }

    public final void z(A object) {
        V2.k.e(object, "response");
        long l2 = n3.d.v((A)object);
        if (l2 == -1L) {
            return;
        }
        object = this.w(l2);
        n3.d.L((x)object, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        object.close();
    }

    private abstract class a
    implements x {
        private final z3.h g;
        private boolean h;
        final b i;

        public a(b b2) {
            V2.k.e(b2, "this$0");
            this.i = b2;
            this.g = new z3.h(b2.c.h());
        }

        protected final boolean a() {
            return this.h;
        }

        public final void f() {
            if (this.i.e == 6) {
                return;
            }
            if (this.i.e == 5) {
                this.i.r(this.g);
                this.i.e = 6;
                return;
            }
            throw new IllegalStateException(V2.k.j("state: ", this.i.e));
        }

        @Override
        public y h() {
            return this.g;
        }

        protected final void i(boolean bl) {
            this.h = bl;
        }

        @Override
        public long j0(z3.b b2, long l2) {
            V2.k.e(b2, "sink");
            try {
                l2 = this.i.c.j0(b2, l2);
                return l2;
            }
            catch (IOException iOException) {
                this.i.h().y();
                this.f();
                throw iOException;
            }
        }
    }

    private final class b
    implements v,
    AutoCloseable {
        private final z3.h g;
        private boolean h;
        final b i;

        public b(b b2) {
            V2.k.e(b2, "this$0");
            this.i = b2;
            this.g = new z3.h(b2.d.h());
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void close() {
            b b2 = this;
            synchronized (b2) {
                boolean bl = this.h;
                if (bl) {
                    return;
                }
                this.h = true;
                this.i.d.w0("0\r\n\r\n");
                this.i.r(this.g);
                this.i.e = 3;
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void flush() {
            b b2 = this;
            synchronized (b2) {
                boolean bl = this.h;
                if (bl) {
                    return;
                }
                this.i.d.flush();
                return;
            }
        }

        @Override
        public y h() {
            return this.g;
        }

        @Override
        public void q(z3.b b2, long l2) {
            V2.k.e(b2, "source");
            if (!this.h) {
                if (l2 == 0L) {
                    return;
                }
                this.i.d.r(l2);
                this.i.d.w0("\r\n");
                this.i.d.q(b2, l2);
                this.i.d.w0("\r\n");
                return;
            }
            throw new IllegalStateException("closed");
        }
    }

    private final class c
    extends a {
        private final t j;
        private long k;
        private boolean l;
        final b m;

        public c(b b2, t t2) {
            V2.k.e(b2, "this$0");
            V2.k.e(t2, "url");
            this.m = b2;
            super(b2);
            this.j = t2;
            this.k = -1L;
            this.l = true;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        private final void j() {
            Object object;
            block4: {
                Object object2;
                if (this.k != -1L) {
                    this.m.c.J();
                }
                try {
                    boolean bl;
                    this.k = this.m.c.D0();
                    object = b3.h.t0(this.m.c.J()).toString();
                    if (this.k < 0L || object.length() > 0 && !(bl = b3.h.E((String)object, ";", false, 2, null))) break block4;
                    if (this.k != 0L) return;
                    this.l = false;
                    object2 = this.m;
                }
                catch (NumberFormatException numberFormatException) {
                    throw new ProtocolException(numberFormatException.getMessage());
                }
                ((b)object2).g = ((b)object2).f.a();
                object2 = this.m.a;
                V2.k.b(object2);
                m m2 = ((w)object2).l();
                object2 = this.j;
                object = this.m.g;
                V2.k.b(object);
                s3.e.f(m2, (t)object2, (s)object);
                this.f();
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("expected chunk size and optional extensions but was \"");
            stringBuilder.append(this.k);
            stringBuilder.append((String)object);
            stringBuilder.append('\"');
            ProtocolException protocolException = new ProtocolException(stringBuilder.toString());
            throw protocolException;
        }

        @Override
        public void close() {
            if (this.a()) {
                return;
            }
            if (this.l && !n3.d.s(this, 100, TimeUnit.MILLISECONDS)) {
                this.m.h().y();
                this.f();
            }
            this.i(true);
        }

        @Override
        public long j0(z3.b b2, long l2) {
            V2.k.e(b2, "sink");
            if (l2 >= 0L) {
                if (!this.a()) {
                    if (!this.l) {
                        return -1L;
                    }
                    long l3 = this.k;
                    if (l3 == 0L || l3 == -1L) {
                        this.j();
                        if (!this.l) {
                            return -1L;
                        }
                    }
                    if ((l2 = super.j0(b2, Math.min((long)l2, (long)this.k))) != -1L) {
                        this.k -= l2;
                        return l2;
                    }
                    this.m.h().y();
                    b2 = new ProtocolException("unexpected end of stream");
                    this.f();
                    throw b2;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException(V2.k.j("byteCount < 0: ", l2).toString());
        }
    }

    public static final class d {
        private d() {
        }

        public /* synthetic */ d(V2.g g2) {
            this();
        }
    }

    private final class e
    extends a {
        private long j;
        final b k;

        public e(b b2, long l2) {
            V2.k.e(b2, "this$0");
            this.k = b2;
            super(b2);
            this.j = l2;
            if (l2 == 0L) {
                this.f();
            }
        }

        @Override
        public void close() {
            if (this.a()) {
                return;
            }
            if (this.j != 0L && !n3.d.s(this, 100, TimeUnit.MILLISECONDS)) {
                this.k.h().y();
                this.f();
            }
            this.i(true);
        }

        @Override
        public long j0(z3.b b2, long l2) {
            V2.k.e(b2, "sink");
            if (l2 >= 0L) {
                if (!this.a()) {
                    long l3 = this.j;
                    if (l3 == 0L) {
                        return -1L;
                    }
                    if ((l2 = super.j0(b2, Math.min((long)l3, (long)l2))) != -1L) {
                        this.j = l3 = this.j - l2;
                        if (l3 == 0L) {
                            this.f();
                        }
                        return l2;
                    }
                    this.k.h().y();
                    b2 = new ProtocolException("unexpected end of stream");
                    this.f();
                    throw b2;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException(V2.k.j("byteCount < 0: ", l2).toString());
        }
    }

    private final class f
    implements v,
    AutoCloseable {
        private final z3.h g;
        private boolean h;
        final b i;

        public f(b b2) {
            V2.k.e(b2, "this$0");
            this.i = b2;
            this.g = new z3.h(b2.d.h());
        }

        @Override
        public void close() {
            if (this.h) {
                return;
            }
            this.h = true;
            this.i.r(this.g);
            this.i.e = 3;
        }

        @Override
        public void flush() {
            if (this.h) {
                return;
            }
            this.i.d.flush();
        }

        @Override
        public y h() {
            return this.g;
        }

        @Override
        public void q(z3.b b2, long l2) {
            V2.k.e(b2, "source");
            if (!this.h) {
                n3.d.l(b2.A0(), 0L, l2);
                this.i.d.q(b2, l2);
                return;
            }
            throw new IllegalStateException("closed");
        }
    }

    private final class g
    extends a {
        private boolean j;
        final b k;

        public g(b b2) {
            V2.k.e(b2, "this$0");
            this.k = b2;
            super(b2);
        }

        @Override
        public void close() {
            if (this.a()) {
                return;
            }
            if (!this.j) {
                this.f();
            }
            this.i(true);
        }

        @Override
        public long j0(z3.b b2, long l2) {
            V2.k.e(b2, "sink");
            if (l2 >= 0L) {
                if (!this.a()) {
                    if (this.j) {
                        return -1L;
                    }
                    if ((l2 = super.j0(b2, l2)) == -1L) {
                        this.j = true;
                        this.f();
                        return -1L;
                    }
                    return l2;
                }
                throw new IllegalStateException("closed");
            }
            throw new IllegalArgumentException(V2.k.j("byteCount < 0: ", l2).toString());
        }
    }
}

