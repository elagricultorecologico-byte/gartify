/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.AutoCloseable
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package u3;

import V2.g;
import V2.k;
import Y2.d;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import u3.d;
import u3.e;
import u3.m;
import z3.x;
import z3.y;

public final class h
implements Closeable,
AutoCloseable {
    public static final a k = new a(null);
    private static final Logger l;
    private final z3.d g;
    private final boolean h;
    private final b i;
    private final d.a j;

    static {
        Logger logger = Logger.getLogger((String)e.class.getName());
        V2.k.d(logger, "getLogger(Http2::class.java.name)");
        l = logger;
    }

    public h(z3.d x2, boolean bl) {
        V2.k.e(x2, "source");
        this.g = x2;
        this.h = bl;
        x2 = new b((z3.d)x2);
        this.i = x2;
        this.j = new d.a(x2, 4096, 0, 4, null);
    }

    private final List A(int n2, int n3, int n4, int n5) {
        this.i.j(n2);
        b b2 = this.i;
        b2.p(b2.a());
        this.i.A(n3);
        this.i.i(n4);
        this.i.F(n5);
        this.j.k();
        return this.j.e();
    }

    private final void F(c c2, int n2, int n3, int n4) {
        if (n4 != 0) {
            int n5 = 0;
            boolean bl = (n3 & 1) != 0;
            if ((n3 & 8) != 0) {
                n5 = n3.d.d(this.g.G0(), 255);
            }
            int n6 = n2;
            if ((n3 & 0x20) != 0) {
                this.L(c2, n4);
                n6 = n2 - 5;
            }
            c2.k(bl, n4, -1, this.A(k.b(n6, n3, n5), n5, n3, n4));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
    }

    private final void I(c c2, int n2, int n3, int n4) {
        if (n2 == 8) {
            if (n4 == 0) {
                n2 = this.g.D();
                n4 = this.g.D();
                boolean bl = true;
                if ((n3 & 1) == 0) {
                    bl = false;
                }
                c2.f(bl, n2, n4);
                return;
            }
            throw new IOException("TYPE_PING streamId != 0");
        }
        throw new IOException(V2.k.j("TYPE_PING length != 8: ", n2));
    }

    private final void L(c c2, int n2) {
        int n3 = this.g.D();
        boolean bl = (Integer.MIN_VALUE & n3) != 0;
        c2.i(n2, n3 & Integer.MAX_VALUE, n3.d.d(this.g.G0(), 255) + 1, bl);
    }

    private final void M(c c2, int n2, int n3, int n4) {
        if (n2 == 5) {
            if (n4 != 0) {
                this.L(c2, n4);
                return;
            }
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
        c2 = new StringBuilder();
        c2.append("TYPE_PRIORITY length: ");
        c2.append(n2);
        c2.append(" != 5");
        throw new IOException(c2.toString());
    }

    private final void P(c c2, int n2, int n3, int n4) {
        if (n4 != 0) {
            int n5 = (n3 & 8) != 0 ? n3.d.d(this.g.G0(), 255) : 0;
            c2.n(n4, this.g.D() & Integer.MAX_VALUE, this.A(k.b(n2 - 4, n3, n5), n5, n3, n4));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }

    private final void X(c c2, int n2, int n3, int n4) {
        if (n2 == 4) {
            if (n4 != 0) {
                n2 = this.g.D();
                u3.b b2 = u3.b.h.a(n2);
                if (b2 != null) {
                    c2.b(n4, b2);
                    return;
                }
                throw new IOException(V2.k.j("TYPE_RST_STREAM unexpected error code: ", n2));
            }
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        c2 = new StringBuilder();
        c2.append("TYPE_RST_STREAM length: ");
        c2.append(n2);
        c2.append(" != 4");
        throw new IOException(c2.toString());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final void Y(c c2, int n2, int n3, int n4) {
        m m2;
        block16: {
            int n5;
            int n6;
            block15: {
                block14: {
                    if (n4 != 0) throw new IOException("TYPE_SETTINGS streamId != 0");
                    if ((n3 & 1) != 0) {
                        if (n2 != 0) throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
                        c2.e();
                        return;
                    }
                    if (n2 % 6 != 0) throw new IOException(V2.k.j("TYPE_SETTINGS length % 6 != 0: ", n2));
                    m2 = new m();
                    Y2.a a2 = d.g(d.h(0, n2), 6);
                    n2 = a2.c();
                    n6 = a2.f();
                    n5 = a2.h();
                    if (n5 <= 0) break block14;
                    n3 = n2;
                    if (n2 <= n6) break block15;
                }
                if (n5 >= 0 || n6 > n2) break block16;
                n3 = n2;
            }
            while (true) {
                n4 = n3.d.e(this.g.f0(), 65535);
                int n7 = this.g.D();
                if (n4 != 2) {
                    if (n4 != 3) {
                        if (n4 != 4) {
                            if (n4 != 5) {
                                n2 = n4;
                            } else {
                                if (n7 < 16384 || n7 > 0xFFFFFF) throw new IOException(V2.k.j("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", n7));
                                n2 = n4;
                            }
                        } else {
                            if (n7 < 0) throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                            n2 = 7;
                        }
                    } else {
                        n2 = 4;
                    }
                } else {
                    n2 = n4;
                    if (n7 != 0) {
                        if (n7 != 1) throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                        n2 = n4;
                    }
                }
                m2.h(n2, n7);
                if (n3 == n6) break;
                n3 += n5;
            }
        }
        c2.m(false, m2);
    }

    private final void Z(c c2, int n2, int n3, int n4) {
        if (n2 == 4) {
            long l2 = n3.d.f(this.g.D(), Integer.MAX_VALUE);
            if (l2 != 0L) {
                c2.l(n4, l2);
                return;
            }
            throw new IOException("windowSizeIncrement was 0");
        }
        throw new IOException(V2.k.j("TYPE_WINDOW_UPDATE length !=4: ", n2));
    }

    private final void j(c c2, int n2, int n3, int n4) {
        if (n4 != 0) {
            int n5 = 0;
            boolean bl = (n3 & 1) != 0;
            if ((n3 & 0x20) == 0) {
                if ((n3 & 8) != 0) {
                    n5 = n3.d.d(this.g.G0(), 255);
                }
                n2 = k.b(n2, n3, n5);
                c2.c(bl, n4, this.g, n2);
                this.g.x(n5);
                return;
            }
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
    }

    private final void p(c c2, int n2, int n3, int n4) {
        if (n2 >= 8) {
            if (n4 == 0) {
                n4 = this.g.D();
                n3 = this.g.D();
                n2 -= 8;
                u3.b b2 = u3.b.h.a(n3);
                if (b2 != null) {
                    z3.e e2 = z3.e.k;
                    if (n2 > 0) {
                        e2 = this.g.u(n2);
                    }
                    c2.o(n4, b2, e2);
                    return;
                }
                throw new IOException(V2.k.j("TYPE_GOAWAY unexpected error code: ", n3));
            }
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        throw new IOException(V2.k.j("TYPE_GOAWAY length < 8: ", n2));
    }

    public void close() {
        this.g.close();
    }

    public final boolean f(boolean bl, c c2) {
        V2.k.e(c2, "handler");
        try {
            this.g.u0(9L);
        }
        catch (EOFException eOFException) {
            return false;
        }
        int n2 = n3.d.J(this.g);
        if (n2 <= 16384) {
            int n3 = n3.d.d(this.g.G0(), 255);
            int n4 = n3.d.d(this.g.G0(), 255);
            int n5 = this.g.D() & Integer.MAX_VALUE;
            Logger logger = l;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(e.a.c(true, n5, n2, n3, n4));
            }
            if (bl && n3 != 4) {
                throw new IOException(V2.k.j("Expected a SETTINGS frame but was ", e.a.b(n3)));
            }
            switch (n3) {
                default: {
                    this.g.x(n2);
                    break;
                }
                case 8: {
                    this.Z(c2, n2, n4, n5);
                    break;
                }
                case 7: {
                    this.p(c2, n2, n4, n5);
                    break;
                }
                case 6: {
                    this.I(c2, n2, n4, n5);
                    break;
                }
                case 5: {
                    this.P(c2, n2, n4, n5);
                    break;
                }
                case 4: {
                    this.Y(c2, n2, n4, n5);
                    break;
                }
                case 3: {
                    this.X(c2, n2, n4, n5);
                    break;
                }
                case 2: {
                    this.M(c2, n2, n4, n5);
                    break;
                }
                case 1: {
                    this.F(c2, n2, n4, n5);
                    break;
                }
                case 0: {
                    this.j(c2, n2, n4, n5);
                }
            }
            return true;
        }
        throw new IOException(V2.k.j("FRAME_SIZE_ERROR: ", n2));
    }

    public final void i(c object) {
        Object object2;
        block8: {
            block7: {
                block6: {
                    V2.k.e(object, "handler");
                    if (!this.h) break block6;
                    if (!this.f(true, (c)object)) {
                        throw new IOException("Required SETTINGS preface not received");
                    }
                    break block7;
                }
                object2 = this.g;
                object = e.b;
                object2 = object2.u(((z3.e)object).u());
                Logger logger = l;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(n3.d.t(V2.k.j("<< CONNECTION ", ((z3.e)object2).m()), new Object[0]));
                }
                if (!V2.k.a(object, object2)) break block8;
            }
            return;
        }
        throw new IOException(V2.k.j("Expected a connection header but was ", ((z3.e)object2).x()));
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final Logger a() {
            return l;
        }

        public final int b(int n2, int n3, int n4) {
            int n5 = n2;
            if ((n3 & 8) != 0) {
                n5 = n2 - 1;
            }
            if (n4 <= n5) {
                return n5 - n4;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PROTOCOL_ERROR padding ");
            stringBuilder.append(n4);
            stringBuilder.append(" > remaining length ");
            stringBuilder.append(n5);
            throw new IOException(stringBuilder.toString());
        }
    }

    public static final class b
    implements x,
    AutoCloseable {
        private final z3.d g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;

        public b(z3.d d2) {
            V2.k.e(d2, "source");
            this.g = d2;
        }

        private final void f() {
            int n2;
            int n3;
            int n4 = this.j;
            this.k = n3 = n3.d.J(this.g);
            this.h = n3;
            n3 = n3.d.d(this.g.G0(), 255);
            this.i = n3.d.d(this.g.G0(), 255);
            a a2 = k;
            if (a2.a().isLoggable(Level.FINE)) {
                a2.a().fine(e.a.c(true, this.j, this.h, n3, this.i));
            }
            this.j = n2 = this.g.D() & Integer.MAX_VALUE;
            if (n3 == 9) {
                if (n2 == n4) {
                    return;
                }
                throw new IOException("TYPE_CONTINUATION streamId changed");
            }
            a2 = new StringBuilder();
            a2.append(n3);
            a2.append(" != TYPE_CONTINUATION");
            throw new IOException(a2.toString());
        }

        public final void A(int n2) {
            this.l = n2;
        }

        public final void F(int n2) {
            this.j = n2;
        }

        public final int a() {
            return this.k;
        }

        @Override
        public void close() {
        }

        @Override
        public y h() {
            return this.g.h();
        }

        public final void i(int n2) {
            this.i = n2;
        }

        public final void j(int n2) {
            this.k = n2;
        }

        @Override
        public long j0(z3.b b2, long l2) {
            int n2;
            V2.k.e(b2, "sink");
            while ((n2 = this.k) == 0) {
                this.g.x(this.l);
                this.l = 0;
                if ((this.i & 4) != 0) {
                    return -1L;
                }
                this.f();
            }
            if ((l2 = this.g.j0(b2, Math.min((long)l2, (long)n2))) == -1L) {
                return -1L;
            }
            this.k -= (int)l2;
            return l2;
        }

        public final void p(int n2) {
            this.h = n2;
        }
    }

    public static interface c {
        public void b(int var1, u3.b var2);

        public void c(boolean var1, int var2, z3.d var3, int var4);

        public void e();

        public void f(boolean var1, int var2, int var3);

        public void i(int var1, int var2, int var3, boolean var4);

        public void k(boolean var1, int var2, int var3, List var4);

        public void l(int var1, long var2);

        public void m(boolean var1, m var2);

        public void n(int var1, int var2, List var3);

        public void o(int var1, u3.b var2, z3.e var3);
    }
}

