/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.AutoCloseable
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package u3;

import V2.g;
import V2.k;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import n3.d;
import u3.b;
import u3.d;
import u3.e;
import u3.m;
import z3.c;

public final class j
implements Closeable,
AutoCloseable {
    public static final a m = new a(null);
    private static final Logger n = Logger.getLogger((String)e.class.getName());
    private final c g;
    private final boolean h;
    private final z3.b i;
    private int j;
    private boolean k;
    private final d.b l;

    public j(c c2, boolean bl) {
        V2.k.e(c2, "sink");
        this.g = c2;
        this.h = bl;
        c2 = new z3.b();
        this.i = c2;
        this.j = 16384;
        this.l = new d.b(0, false, (z3.b)c2, 3, null);
    }

    private final void Z(int n2, long l2) {
        while (l2 > 0L) {
            long l3 = Math.min((long)this.j, (long)l2);
            int n3 = (int)l3;
            int n4 = (l2 -= l3) == 0L ? 4 : 0;
            this.p(n2, n3, 9, n4);
            this.g.q(this.i, l3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void A(int n2, b object, byte[] byArray) {
        j j2 = this;
        synchronized (j2) {
            Throwable throwable2;
            block7: {
                block6: {
                    try {
                        V2.k.e(object, "errorCode");
                        V2.k.e(byArray, "debugData");
                        if (this.k) {
                            object = new IOException("closed");
                            throw object;
                        }
                        if (((b)((Object)object)).e() == -1) {
                            object = new IllegalArgumentException("errorCode.httpCode == -1");
                            throw object;
                        }
                        int n3 = byArray.length;
                        int n4 = 0;
                        this.p(0, n3 + 8, 7, 0);
                        this.g.E(n2);
                        this.g.E(((b)((Object)object)).e());
                        n2 = n4;
                        if (byArray.length == 0) {
                            n2 = 1;
                        }
                        if (n2 != 0) break block6;
                        this.g.W(byArray);
                    }
                    catch (Throwable throwable2) {
                        break block7;
                    }
                }
                this.g.flush();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void F(boolean bl, int n2, List object) {
        j j2 = this;
        synchronized (j2) {
            Throwable throwable2;
            block5: {
                block6: {
                    try {
                        V2.k.e(object, "headerBlock");
                        if (this.k) break block5;
                        this.l.g((List)object);
                        long l2 = this.i.A0();
                        long l3 = Math.min((long)this.j, (long)l2);
                        long l4 = l2 == l3 ? 0 : (l2 < l3 ? -1 : 1);
                        int n3 = l4 == false ? 4 : 0;
                        int n4 = n3;
                        if (bl) {
                            n4 = n3 | 1;
                        }
                        this.p(n2, (int)l3, 1, n4);
                        this.g.q(this.i, l3);
                        if (l4 <= 0) break block6;
                        this.Z(n2, l2 - l3);
                    }
                    catch (Throwable throwable2) {}
                }
                return;
            }
            object = new IOException("closed");
            throw object;
            throw throwable2;
        }
    }

    public final int I() {
        return this.j;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void L(boolean bl, int n2, int n3) {
        j j2 = this;
        synchronized (j2) {
            Throwable throwable2;
            block4: {
                try {
                    if (!this.k) {
                        this.p(0, 8, 6, bl ? 1 : 0);
                        this.g.E(n2);
                        this.g.E(n3);
                        this.g.flush();
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block4;
                }
                IOException iOException = new IOException("closed");
                throw iOException;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void M(int n2, int n3, List object) {
        j j2 = this;
        synchronized (j2) {
            Throwable throwable2;
            block4: {
                block5: {
                    try {
                        V2.k.e(object, "requestHeaders");
                        if (this.k) break block4;
                        this.l.g((List)object);
                        long l2 = this.i.A0();
                        int n4 = (int)Math.min((long)((long)this.j - 4L), (long)l2);
                        long l3 = n4;
                        long l4 = l2 == l3 ? 0 : (l2 < l3 ? -1 : 1);
                        int n5 = l4 == false ? 4 : 0;
                        this.p(n2, n4 + 4, 5, n5);
                        this.g.E(n3 & Integer.MAX_VALUE);
                        this.g.q(this.i, l3);
                        if (l4 <= 0) break block5;
                        this.Z(n2, l2 - l3);
                    }
                    catch (Throwable throwable2) {}
                }
                return;
            }
            object = new IOException("closed");
            throw object;
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void P(int n2, b object) {
        j j2 = this;
        synchronized (j2) {
            Throwable throwable2;
            block5: {
                try {
                    V2.k.e(object, "errorCode");
                    if (this.k) {
                        object = new IOException("closed");
                        throw object;
                    }
                    if (((b)((Object)object)).e() != -1) {
                        this.p(n2, 4, 3, 0);
                        this.g.E(((b)((Object)object)).e());
                        this.g.flush();
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                object = new IllegalArgumentException("Failed requirement.");
                throw object;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void X(m object) {
        j j2 = this;
        synchronized (j2) {
            try {
                int n2;
                V2.k.e(object, "settings");
                if (!this.k) {
                    n2 = ((m)object).i();
                    this.p(0, n2 * 6, 4, 0);
                } else {
                    object = new IOException("closed");
                    throw object;
                }
                for (int i2 = 0; i2 < 10; ++i2) {
                    if (!((m)object).f(i2)) continue;
                    n2 = i2 != 4 ? (i2 != 7 ? i2 : 4) : 3;
                    this.g.y(n2);
                    this.g.E(((m)object).a(i2));
                }
                this.g.flush();
                return;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void Y(int n2, long l2) {
        j j2 = this;
        synchronized (j2) {
            Throwable throwable2;
            block5: {
                try {
                    if (this.k) {
                        IOException iOException = new IOException("closed");
                        throw iOException;
                    }
                    if (l2 != 0L && l2 <= Integer.MAX_VALUE) {
                        this.p(n2, 4, 8, 0);
                        this.g.E((int)l2);
                        this.g.flush();
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                String string = V2.k.j("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: ", l2);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string.toString());
                throw illegalArgumentException;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(m object) {
        j j2 = this;
        synchronized (j2) {
            Throwable throwable2;
            block5: {
                block4: {
                    try {
                        V2.k.e(object, "peerSettings");
                        if (this.k) {
                            object = new IOException("closed");
                            throw object;
                        }
                        this.j = ((m)object).e(this.j);
                        if (((m)object).b() == -1) break block4;
                        this.l.e(((m)object).b());
                    }
                    catch (Throwable throwable2) {
                        break block5;
                    }
                }
                this.p(0, 0, 4, 1);
                this.g.flush();
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        j j2 = this;
        synchronized (j2) {
            this.k = true;
            this.g.close();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void f() {
        j j2 = this;
        synchronized (j2) {
            Throwable throwable2;
            block7: {
                block5: {
                    block6: {
                        try {
                            if (this.k) break block5;
                            boolean bl = this.h;
                            if (bl) break block6;
                        }
                        catch (Throwable throwable2) {
                            break block7;
                        }
                        return;
                    }
                    Logger logger = n;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(d.t(V2.k.j(">> CONNECTION ", e.b.m()), new Object[0]));
                    }
                    this.g.U(e.b);
                    this.g.flush();
                    return;
                }
                IOException iOException = new IOException("closed");
                throw iOException;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void flush() {
        j j2 = this;
        synchronized (j2) {
            Throwable throwable2;
            block4: {
                try {
                    if (!this.k) {
                        this.g.flush();
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block4;
                }
                IOException iOException = new IOException("closed");
                throw iOException;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void i(boolean bl, int n2, z3.b object, int n3) {
        j j2 = this;
        synchronized (j2) {
            Throwable throwable2;
            block4: {
                try {
                    if (!this.k) {
                        this.j(n2, bl ? 1 : 0, (z3.b)object, n3);
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block4;
                }
                object = new IOException("closed");
                throw object;
            }
            throw throwable2;
        }
    }

    public final void j(int n2, int n3, z3.b b2, int n4) {
        this.p(n2, n4, 0, n3);
        if (n4 > 0) {
            c c2 = this.g;
            V2.k.b(b2);
            c2.q(b2, n4);
        }
    }

    public final void p(int n2, int n3, int n4, int n5) {
        Logger logger = n;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(e.a.c(false, n2, n3, n4, n5));
        }
        if (n3 <= this.j) {
            if ((Integer.MIN_VALUE & n2) == 0) {
                d.Z(this.g, n3);
                this.g.Q(n4 & 0xFF);
                this.g.Q(n5 & 0xFF);
                this.g.E(Integer.MAX_VALUE & n2);
                return;
            }
            throw new IllegalArgumentException(V2.k.j("reserved bit set: ", n2).toString());
        }
        logger = new StringBuilder();
        logger.append("FRAME_SIZE_ERROR length > ");
        logger.append(this.j);
        logger.append(": ");
        logger.append(n3);
        throw new IllegalArgumentException(logger.toString().toString());
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }
}

