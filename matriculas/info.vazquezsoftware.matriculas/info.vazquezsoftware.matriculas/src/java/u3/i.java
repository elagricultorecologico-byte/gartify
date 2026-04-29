/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.AssertionError
 *  java.lang.AutoCloseable
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.SocketTimeoutException
 *  java.util.ArrayDeque
 */
package u3;

import H2.q;
import V2.g;
import V2.k;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import m3.s;
import u3.f;
import u3.n;
import z3.v;
import z3.x;
import z3.y;

public final class i {
    public static final a o = new a(null);
    private final int a;
    private final f b;
    private long c;
    private long d;
    private long e;
    private long f;
    private final ArrayDeque g;
    private boolean h;
    private final c i;
    private final b j;
    private final d k;
    private final d l;
    private u3.b m;
    private IOException n;

    public i(int n2, f f2, boolean bl, boolean bl2, s s2) {
        ArrayDeque arrayDeque;
        V2.k.e(f2, "connection");
        this.a = n2;
        this.b = f2;
        this.f = f2.L0().c();
        this.g = arrayDeque = new ArrayDeque();
        this.i = new c(this, f2.K0().c(), bl2);
        this.j = new b(this, bl);
        this.k = new d(this);
        this.l = new d(this);
        if (s2 != null) {
            if (!this.t()) {
                arrayDeque.add((Object)s2);
                return;
            }
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (this.t()) {
            return;
        }
        throw new IllegalStateException("remotely-initiated streams should have headers");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private final boolean e(u3.b object, IOException iOException) {
        block7: {
            boolean bl;
            block6: {
                if (n3.d.h && Thread.holdsLock((Object)this)) {
                    object = new StringBuilder();
                    object.append("Thread ");
                    object.append(Thread.currentThread().getName());
                    object.append(" MUST NOT hold lock on ");
                    object.append(this);
                    throw new AssertionError((Object)object.toString());
                }
                i i2 = this;
                // MONITORENTER : i2
                u3.b b2 = this.h();
                if (b2 == null) break block6;
                return false;
            }
            if (!this.p().f() || !(bl = this.o().i())) break block7;
            // MONITOREXIT : i2
            return false;
        }
        this.z((u3.b)((Object)object));
        this.A(iOException);
        this.notifyAll();
        object = q.a;
        // MONITOREXIT : i2
        this.b.a1(this.a);
        return true;
    }

    public final void A(IOException iOException) {
        this.n = iOException;
    }

    public final void B(long l2) {
        this.d = l2;
    }

    public final void C(long l2) {
        this.c = l2;
    }

    public final void D(long l2) {
        this.e = l2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final s E() {
        i i2 = this;
        synchronized (i2) {
            Throwable throwable3;
            block8: {
                Throwable throwable22;
                block9: {
                    Object object;
                    try {
                        this.k.t();
                    }
                    catch (Throwable throwable3) {
                        break block8;
                    }
                    try {
                        while (this.g.isEmpty() && this.m == null) {
                            this.F();
                        }
                    }
                    catch (Throwable throwable22) {
                        break block9;
                    }
                    this.k.A();
                    if (!this.g.isEmpty()) {
                        Object object2 = this.g.removeFirst();
                        V2.k.d(object2, "headersQueue.removeFirst()");
                        return (s)object2;
                    }
                    IOException iOException = object = this.n;
                    if (object != null) throw iOException;
                    object = this.m;
                    V2.k.b(object);
                    iOException = new n((u3.b)((Object)object));
                    throw iOException;
                }
                this.k.A();
                throw throwable22;
            }
            throw throwable3;
        }
    }

    public final void F() {
        try {
            this.wait();
            return;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final y G() {
        return this.l;
    }

    public final void a(long l2) {
        this.f += l2;
        if (l2 > 0L) {
            this.notifyAll();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void b() {
        boolean bl;
        block6: {
            block5: {
                if (n3.d.h && Thread.holdsLock((Object)this)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Thread ");
                    stringBuilder.append((Object)Thread.currentThread().getName());
                    stringBuilder.append(" MUST NOT hold lock on ");
                    stringBuilder.append((Object)this);
                    throw new AssertionError((Object)stringBuilder.toString());
                }
                i i2 = this;
                // MONITORENTER : i2
                if (this.p().f() || !this.p().a() || !this.o().i() && !this.o().f()) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        boolean bl2 = this.u();
        q q2 = q.a;
        // MONITOREXIT : i2
        if (bl) {
            this.d(u3.b.q, null);
            return;
        }
        if (bl2) return;
        this.b.a1(this.a);
    }

    public final void c() {
        if (!this.j.f()) {
            if (!this.j.i()) {
                if (this.m != null) {
                    IOException iOException;
                    Object object = iOException = this.n;
                    if (iOException == null) {
                        object = this.m;
                        V2.k.b(object);
                        object = new n((u3.b)((Object)object));
                    }
                    throw object;
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    public final void d(u3.b b2, IOException iOException) {
        V2.k.e((Object)b2, "rstStatusCode");
        if (!this.e(b2, iOException)) {
            return;
        }
        this.b.m1(this.a, b2);
    }

    public final void f(u3.b b2) {
        V2.k.e((Object)b2, "errorCode");
        if (!this.e(b2, null)) {
            return;
        }
        this.b.n1(this.a, b2);
    }

    public final f g() {
        return this.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final u3.b h() {
        i i2 = this;
        synchronized (i2) {
            return this.m;
        }
    }

    public final IOException i() {
        return this.n;
    }

    public final int j() {
        return this.a;
    }

    public final long k() {
        return this.d;
    }

    public final long l() {
        return this.c;
    }

    public final d m() {
        return this.k;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final v n() {
        i i2 = this;
        synchronized (i2) {
            Throwable throwable2;
            block4: {
                try {
                    if (!this.h && !this.t()) {
                        IllegalStateException illegalStateException = new IllegalStateException("reply before requesting the sink");
                        throw illegalStateException;
                    }
                }
                catch (Throwable throwable2) {
                    break block4;
                }
                q q2 = q.a;
                return this.j;
            }
            throw throwable2;
        }
    }

    public final b o() {
        return this.j;
    }

    public final c p() {
        return this.i;
    }

    public final long q() {
        return this.f;
    }

    public final long r() {
        return this.e;
    }

    public final d s() {
        return this.l;
    }

    public final boolean t() {
        boolean bl = (this.a & 1) == 1;
        return this.b.n0() == bl;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean u() {
        i i2 = this;
        synchronized (i2) {
            Throwable throwable2;
            block7: {
                boolean bl;
                block6: {
                    try {
                        u3.b b2 = this.m;
                        if (b2 == null) break block6;
                    }
                    catch (Throwable throwable2) {
                        break block7;
                    }
                    return false;
                }
                return !this.i.f() && !this.i.a() || !this.j.i() && !this.j.f() || !(bl = this.h);
                {
                }
            }
            throw throwable2;
        }
    }

    public final y v() {
        return this.k;
    }

    public final void w(z3.d d2, int n2) {
        V2.k.e(d2, "source");
        if (n3.d.h && Thread.holdsLock((Object)this)) {
            d2 = new StringBuilder();
            d2.append("Thread ");
            d2.append(Thread.currentThread().getName());
            d2.append(" MUST NOT hold lock on ");
            d2.append(this);
            throw new AssertionError((Object)d2.toString());
        }
        this.i.p(d2, n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void x(s object, boolean bl) {
        block6: {
            block5: {
                V2.k.e(object, "headers");
                if (n3.d.h && Thread.holdsLock((Object)this)) {
                    object = new StringBuilder();
                    object.append("Thread ");
                    object.append((Object)Thread.currentThread().getName());
                    object.append(" MUST NOT hold lock on ");
                    object.append((Object)this);
                    throw new AssertionError((Object)object.toString());
                }
                i i2 = this;
                // MONITORENTER : i2
                if (!this.h || !bl) break block5;
                this.p().I((s)object);
                break block6;
            }
            this.h = true;
            this.g.add(object);
        }
        if (bl) {
            this.p().F(true);
        }
        bl = this.u();
        this.notifyAll();
        object = q.a;
        // MONITOREXIT : i2
        if (bl) return;
        this.b.a1(this.a);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void y(u3.b b2) {
        i i2 = this;
        synchronized (i2) {
            Throwable throwable2;
            block5: {
                block4: {
                    try {
                        V2.k.e((Object)b2, "errorCode");
                        if (this.m != null) break block4;
                        this.m = b2;
                        this.notifyAll();
                    }
                    catch (Throwable throwable2) {
                        break block5;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    public final void z(u3.b b2) {
        this.m = b2;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

    public final class b
    implements v,
    AutoCloseable {
        private boolean g;
        private final z3.b h;
        private s i;
        private boolean j;
        final i k;

        public b(i i2, boolean bl) {
            V2.k.e(i2, "this$0");
            this.k = i2;
            this.g = bl;
            this.h = new z3.b();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        private final void a(boolean bl) {
            Throwable throwable2;
            i i2;
            block11: {
                i i3 = i2 = this.k;
                // MONITORENTER : i3
                i2.s().t();
                try {
                    while (i2.r() >= i2.q() && !this.i() && !this.f() && i2.h() == null) {
                        i2.F();
                    }
                }
                catch (Throwable throwable2) {
                    break block11;
                }
                i2.s().A();
                i2.c();
                long l2 = Math.min((long)(i2.q() - i2.r()), (long)this.h.A0());
                i2.D(i2.r() + l2);
                bl = bl && l2 == this.h.A0();
                q q2 = q.a;
                // MONITOREXIT : i3
                this.k.s().t();
                try {
                    this.k.g().j1(this.k.j(), bl, this.h, l2);
                    return;
                }
                finally {
                    this.k.s().A();
                }
            }
            i2.s().A();
            throw throwable2;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        @Override
        public void close() {
            Object object = this.k;
            if (n3.d.h && Thread.holdsLock((Object)object)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Thread ");
                stringBuilder.append((Object)Thread.currentThread().getName());
                stringBuilder.append(" MUST NOT hold lock on ");
                stringBuilder.append(object);
                throw new AssertionError((Object)stringBuilder.toString());
            }
            Object object2 = this.k;
            i i2 = object2;
            // MONITORENTER : i2
            boolean bl = this.f();
            if (bl) {
                // MONITOREXIT : i2
                return;
            }
            bl = ((i)object2).h() == null;
            object = q.a;
            // MONITOREXIT : i2
            if (!this.k.o().g) {
                int n2 = this.h.A0() > 0L ? 1 : 0;
                if (this.i != null) {
                    while (this.h.A0() > 0L) {
                        this.a(false);
                    }
                    object2 = this.k.g();
                    n2 = this.k.j();
                    object = this.i;
                    V2.k.b(object);
                    ((f)object2).k1(n2, bl, n3.d.O((s)object));
                } else if (n2 != 0) {
                    while (this.h.A0() > 0L) {
                        this.a(true);
                    }
                } else if (bl) {
                    this.k.g().j1(this.k.j(), true, null, 0L);
                }
            }
            object2 = this.k;
            i2 = object2;
            // MONITORENTER : i2
            this.j(true);
            object = q.a;
            // MONITOREXIT : i2
            this.k.g().flush();
            this.k.b();
        }

        public final boolean f() {
            return this.j;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void flush() {
            i i2 = this.k;
            if (n3.d.h && Thread.holdsLock((Object)i2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Thread ");
                stringBuilder.append((Object)Thread.currentThread().getName());
                stringBuilder.append(" MUST NOT hold lock on ");
                stringBuilder.append((Object)i2);
                throw new AssertionError((Object)stringBuilder.toString());
            }
            i i3 = i2 = this.k;
            synchronized (i3) {
                i2.c();
                q q2 = q.a;
            }
            while (this.h.A0() > 0L) {
                this.a(false);
                this.k.g().flush();
            }
            return;
        }

        @Override
        public y h() {
            return this.k.s();
        }

        public final boolean i() {
            return this.g;
        }

        public final void j(boolean bl) {
            this.j = bl;
        }

        @Override
        public void q(z3.b b2, long l2) {
            V2.k.e(b2, "source");
            i i2 = this.k;
            if (n3.d.h && Thread.holdsLock((Object)i2)) {
                b2 = new StringBuilder();
                b2.append("Thread ");
                b2.append(Thread.currentThread().getName());
                b2.append(" MUST NOT hold lock on ");
                b2.append(i2);
                throw new AssertionError((Object)b2.toString());
            }
            this.h.q(b2, l2);
            while (this.h.A0() >= 16384L) {
                this.a(false);
            }
        }
    }

    public final class c
    implements x,
    AutoCloseable {
        private final long g;
        private boolean h;
        private final z3.b i;
        private final z3.b j;
        private s k;
        private boolean l;
        final i m;

        public c(i i2, long l2, boolean bl) {
            V2.k.e(i2, "this$0");
            this.m = i2;
            this.g = l2;
            this.h = bl;
            this.i = new z3.b();
            this.j = new z3.b();
        }

        private final void L(long l2) {
            i i2 = this.m;
            if (n3.d.h && Thread.holdsLock((Object)i2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Thread ");
                stringBuilder.append((Object)Thread.currentThread().getName());
                stringBuilder.append(" MUST NOT hold lock on ");
                stringBuilder.append((Object)i2);
                throw new AssertionError((Object)stringBuilder.toString());
            }
            this.m.g().i1(l2);
        }

        public final void A(boolean bl) {
            this.l = bl;
        }

        public final void F(boolean bl) {
            this.h = bl;
        }

        public final void I(s s2) {
            this.k = s2;
        }

        public final boolean a() {
            return this.l;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        @Override
        public void close() {
            i i2;
            i i3 = i2 = this.m;
            // MONITORENTER : i3
            this.A(true);
            long l2 = this.i().A0();
            this.i().a();
            i2.notifyAll();
            q q2 = q.a;
            // MONITOREXIT : i3
            if (l2 > 0L) {
                this.L(l2);
            }
            this.m.b();
        }

        public final boolean f() {
            return this.h;
        }

        @Override
        public y h() {
            return this.m.m();
        }

        public final z3.b i() {
            return this.j;
        }

        public final z3.b j() {
            return this.i;
        }

        /*
         * Exception decompiling
         */
        @Override
        public long j0(z3.b var1_1, long var2_4) {
            /*
             * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
             * 
             * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 3[TRYBLOCK] [3 : 90->106)] java.lang.Throwable
             *     at fc.i.L0(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:227)
             *     at dc.f.b(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:196)
             *     at dc.f.c(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:7)
             *     at dc.f.a(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:157)
             *     at md.e.l(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:7)
             *     at kd.k.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:7)
             *     at kd.f.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:179)
             *     at kd.f.g(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:55)
             *     at og.h.r0(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:235)
             *     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.decompileWithCFR(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:784)
             *     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.doWork(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:141)
             *     at com.thesourceofcode.jadec.decompilers.BaseDecompiler.withAttempt(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:3)
             *     at z6.a.run(r8-map-id-5336d296fbf3284427aba3c9406dc63d81d5d24d9edcf157bc560c004a742559:31)
             *     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1154)
             *     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:652)
             *     at java.lang.Thread.run(Thread.java:1564)
             */
            throw new IllegalStateException("Decompilation failed");
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        public final void p(z3.d d2, long l2) {
            V2.k.e(d2, "source");
            i i2 = this.m;
            long l3 = l2;
            if (n3.d.h) {
                if (Thread.holdsLock((Object)i2)) {
                    d2 = new StringBuilder();
                    d2.append("Thread ");
                    d2.append(Thread.currentThread().getName());
                    d2.append(" MUST NOT hold lock on ");
                    d2.append(i2);
                    throw new AssertionError((Object)d2.toString());
                }
                l3 = l2;
            }
            while (l3 > 0L) {
                long l4;
                block13: {
                    boolean bl;
                    boolean bl2;
                    block12: {
                        i i3 = i2 = this.m;
                        // MONITORENTER : i3
                        boolean bl3 = this.f();
                        l2 = this.i().A0();
                        l4 = this.g;
                        bl2 = false;
                        bl = l2 + l3 > l4;
                        q q2 = q.a;
                        // MONITOREXIT : i3
                        if (bl) {
                            d2.x(l3);
                            this.m.f(u3.b.l);
                            return;
                        }
                        if (bl3) {
                            d2.x(l3);
                            return;
                        }
                        l2 = d2.j0(this.i, l3);
                        if (l2 == -1L) throw new EOFException();
                        l4 = l3 - l2;
                        i3 = i2 = this.m;
                        // MONITORENTER : i3
                        if (!this.a()) break block12;
                        l2 = this.j().A0();
                        this.j().a();
                        break block13;
                    }
                    bl = bl2;
                    if (this.i().A0() == 0L) {
                        bl = true;
                    }
                    this.i().O0(this.j());
                    if (bl) {
                        i2.notifyAll();
                    }
                    l2 = 0L;
                }
                // MONITOREXIT : i3
                l3 = l4;
                if (l2 <= 0L) continue;
                this.L(l2);
                l3 = l4;
            }
        }
    }

    public final class d
    extends z3.a {
        final i m;

        public d(i i2) {
            V2.k.e(i2, "this$0");
            this.m = i2;
        }

        public final void A() {
            if (!this.u()) {
                return;
            }
            throw this.v(null);
        }

        @Override
        protected IOException v(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause((Throwable)iOException);
            }
            return socketTimeoutException;
        }

        @Override
        protected void z() {
            this.m.f(u3.b.q);
            this.m.g().b1();
        }
    }
}

