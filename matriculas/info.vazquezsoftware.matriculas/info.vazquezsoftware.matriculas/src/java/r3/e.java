/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.AssertionError
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.ref.Reference
 *  java.lang.ref.WeakReference
 *  java.net.Socket
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicBoolean
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLSocketFactory
 */
package r3;

import H2.q;
import I2.o;
import V2.k;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import m3.A;
import m3.i;
import m3.t;
import m3.w;
import m3.y;
import r3.c;
import r3.d;
import r3.f;
import r3.g;
import s3.j;

public final class e
implements m3.e {
    private final w g;
    private final y h;
    private final boolean i;
    private final g j;
    private final m3.q k;
    private final b l;
    private final AtomicBoolean m;
    private Object n;
    private d o;
    private f p;
    private boolean q;
    private c r;
    private boolean s;
    private boolean t;
    private boolean u;
    private volatile boolean v;
    private volatile c w;
    private volatile f x;

    public e(w object, y y2, boolean bl) {
        V2.k.e(object, "client");
        V2.k.e(y2, "originalRequest");
        this.g = object;
        this.h = y2;
        this.i = bl;
        this.j = ((w)object).i().a();
        this.k = ((w)object).o().a(this);
        object = new z3.a(this){
            final e m;
            {
                this.m = e2;
            }

            @Override
            protected void z() {
                this.m.d();
            }
        };
        ((z3.y)object).g(this.k().e(), TimeUnit.MILLISECONDS);
        this.l = object;
        this.m = new AtomicBoolean();
        this.u = true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private final IOException b(IOException object) {
        boolean bl = n3.d.h;
        if (bl && Thread.holdsLock((Object)this)) {
            object = new StringBuilder();
            object.append("Thread ");
            object.append((Object)Thread.currentThread().getName());
            object.append(" MUST NOT hold lock on ");
            object.append((Object)this);
            throw new AssertionError((Object)object.toString());
        }
        Object object2 = this.p;
        if (object2 != null) {
            if (bl && Thread.holdsLock((Object)object2)) {
                object = new StringBuilder();
                object.append("Thread ");
                object.append((Object)Thread.currentThread().getName());
                object.append(" MUST NOT hold lock on ");
                object.append(object2);
                throw new AssertionError((Object)object.toString());
            }
            f f2 = object2;
            // MONITORENTER : f2
            Socket socket = this.u();
            // MONITOREXIT : f2
            if (this.p == null) {
                if (socket != null) {
                    n3.d.n(socket);
                }
                this.k.k(this, (i)object2);
            } else if (socket != null) throw new IllegalStateException("Check failed.");
        }
        object2 = this.y((IOException)((Object)object));
        if (object != null) {
            object = this.k;
            V2.k.b(object2);
            ((m3.q)object).d(this, (IOException)((Object)object2));
            return object2;
        }
        this.k.c(this);
        return object2;
    }

    private final void c() {
        this.n = v3.k.a.g().h("response.body().close()");
        this.k.e(this);
    }

    private final m3.a g(t t2) {
        Object object;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (t2.i()) {
            sSLSocketFactory = this.g.F();
            hostnameVerifier = this.g.t();
            object = this.g.g();
        } else {
            sSLSocketFactory = null;
            object = hostnameVerifier = null;
        }
        return new m3.a(t2.h(), t2.l(), this.g.n(), this.g.E(), sSLSocketFactory, hostnameVerifier, (m3.f)object, this.g.A(), this.g.z(), this.g.y(), this.g.k(), this.g.B());
    }

    private final IOException y(IOException iOException) {
        if (this.q || !this.l.u()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause((Throwable)iOException);
        }
        return interruptedIOException;
    }

    public final void a(f f2) {
        V2.k.e(f2, "connection");
        if (n3.d.h && !Thread.holdsLock((Object)f2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append((Object)f2);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        if (this.p == null) {
            this.p = f2;
            f2.n().add((Object)new a(this, this.n));
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    public void d() {
        if (this.v) {
            return;
        }
        this.v = true;
        Object object = this.w;
        if (object != null) {
            ((c)object).b();
        }
        object = this.x;
        if (object != null) {
            ((f)object).d();
        }
        this.k.f(this);
    }

    public e e() {
        return new e(this.g, this.h, this.i);
    }

    @Override
    public A f() {
        if (this.m.compareAndSet(false, true)) {
            this.l.t();
            this.c();
            try {
                this.g.m().a(this);
                A a2 = this.o();
                return a2;
            }
            finally {
                this.g.m().d(this);
            }
        }
        throw new IllegalStateException("Already Executed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void h(y y2, boolean bl) {
        block4: {
            block5: {
                V2.k.e(y2, "request");
                if (this.r != null) throw new IllegalStateException("Check failed.");
                e e2 = this;
                // MONITORENTER : e2
                if (this.t) break block4;
                if (this.s) break block5;
                q q2 = H2.q.a;
                // MONITOREXIT : e2
                if (!bl) return;
                this.o = new d(this.j, this.g(y2.i()), this, this.k);
                return;
            }
            y2 = new IllegalStateException("Check failed.");
            throw y2;
        }
        y2 = new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
        throw y2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void i(boolean bl) {
        block4: {
            block5: {
                e e2 = this;
                // MONITORENTER : e2
                if (!this.u) break block4;
                Object object = H2.q.a;
                // MONITOREXIT : e2
                if (!bl || (object = this.w) == null) break block5;
                ((c)object).d();
            }
            this.r = null;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("released");
        throw illegalStateException;
    }

    public final w k() {
        return this.g;
    }

    public final f l() {
        return this.p;
    }

    public final m3.q m() {
        return this.k;
    }

    public final c n() {
        return this.r;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final A o() {
        boolean bl;
        boolean bl2;
        Object object;
        block8: {
            object = new ArrayList();
            I2.o.q((Collection)object, (Iterable)this.g.u());
            object.add((Object)new j(this.g));
            object.add((Object)new s3.a(this.g.l()));
            this.g.d();
            object.add((Object)new p3.a(null));
            object.add((Object)r3.a.a);
            if (!this.i) {
                I2.o.q((Collection)object, (Iterable)this.g.v());
            }
            object.add((Object)new s3.b(this.i));
            object = new s3.g(this, (List)object, 0, null, this.h, this.g.h(), this.g.C(), this.g.H());
            bl = bl2 = false;
            try {
                object = object.a(this.h);
                bl = bl2;
                boolean bl3 = this.r();
                if (bl3) break block8;
            }
            catch (IOException iOException) {
                bl = bl2 = true;
                Throwable throwable = this.t(iOException);
                if (throwable == null) {
                    bl = bl2;
                    bl = bl2;
                    throwable = new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    bl = bl2;
                    throw throwable;
                }
                bl = bl2;
                throw throwable;
            }
            this.t(null);
            return object;
        }
        bl = bl2;
        {
            n3.d.m((Closeable)object);
            bl = bl2;
            bl = bl2;
            object = new IOException("Canceled");
            bl = bl2;
            throw object;
        }
        catch (Throwable throwable2222222) {}
        if (!bl) {
            this.t(null);
        }
        throw throwable2222222;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final c q(s3.g object) {
        block6: {
            block7: {
                block8: {
                    V2.k.e(object, "chain");
                    e e2 = this;
                    // MONITORENTER : e2
                    if (!this.u) break block6;
                    if (this.t) break block7;
                    if (this.s) break block8;
                    Object object2 = H2.q.a;
                    // MONITOREXIT : e2
                    object2 = this.o;
                    V2.k.b(object2);
                    object = ((d)object2).a(this.g, (s3.g)object);
                    this.r = object = new c(this, this.k, (d)object2, (s3.d)object);
                    this.w = object;
                    e2 = this;
                    // MONITORENTER : e2
                    this.s = true;
                    this.t = true;
                    // MONITOREXIT : e2
                    if (this.v) throw new IOException("Canceled");
                    return object;
                }
                object = new IllegalStateException("Check failed.");
                throw object;
            }
            object = new IllegalStateException("Check failed.");
            throw object;
        }
        object = new IllegalStateException("released");
        throw object;
    }

    public boolean r() {
        return this.v;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final IOException s(c object, boolean bl, boolean bl2, IOException iOException) {
        boolean bl3;
        boolean bl4;
        block13: {
            block12: {
                boolean bl5;
                block11: {
                    V2.k.e(object, "exchange");
                    if (!V2.k.a(object, this.w)) {
                        return iOException;
                    }
                    e e2 = this;
                    // MONITORENTER : e2
                    bl4 = false;
                    bl5 = false;
                    if (bl) {
                        if (this.s) break block11;
                    }
                    if (!bl2 || !this.t) break block12;
                }
                if (bl) {
                    this.s = false;
                }
                if (bl2) {
                    this.t = false;
                }
                bl4 = !(bl = this.s) && !this.t;
                bl3 = bl5;
                if (bl) break block13;
                bl3 = bl5;
                if (!this.t) {
                    bl3 = bl5;
                    if (!this.u) {
                        bl3 = true;
                    }
                }
                break block13;
            }
            bl3 = false;
        }
        object = H2.q.a;
        // MONITOREXIT : e2
        if (bl4) {
            this.w = null;
            object = this.p;
            if (object != null) {
                ((f)object).s();
            }
        }
        if (!bl3) return iOException;
        return this.b(iOException);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final IOException t(IOException iOException) {
        e e2 = this;
        synchronized (e2) {
            try {
                boolean bl;
                boolean bl2 = this.u;
                boolean bl3 = bl = false;
                if (bl2) {
                    this.u = false;
                    bl3 = bl;
                    if (!this.s) {
                        bl3 = bl;
                        if (!this.t) {
                            bl3 = true;
                        }
                    }
                }
                Object object = H2.q.a;
                // MONITOREXIT @DISABLED, blocks:[0, 1] lbl14 : w: MONITOREXIT : var6_3
                object = iOException;
                if (!bl3) return object;
                return this.b(iOException);
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public final Socket u() {
        int n2;
        List list;
        f f2;
        block6: {
            f2 = this.p;
            V2.k.b(f2);
            if (n3.d.h && !Thread.holdsLock((Object)f2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Thread ");
                stringBuilder.append((Object)Thread.currentThread().getName());
                stringBuilder.append(" MUST hold lock on ");
                stringBuilder.append((Object)f2);
                throw new AssertionError((Object)stringBuilder.toString());
            }
            list = f2.n();
            Iterator iterator = list.iterator();
            n2 = 0;
            while (iterator.hasNext()) {
                if (!V2.k.a(((Reference)iterator.next()).get(), this)) {
                    ++n2;
                    continue;
                }
                break block6;
            }
            n2 = -1;
        }
        if (n2 != -1) {
            list.remove(n2);
            this.p = null;
            if (list.isEmpty()) {
                f2.B(System.nanoTime());
                if (this.j.c(f2)) {
                    return f2.D();
                }
            }
            return null;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final boolean v() {
        d d2 = this.o;
        V2.k.b(d2);
        return d2.e();
    }

    public final void w(f f2) {
        this.x = f2;
    }

    public final void x() {
        if (!this.q) {
            this.q = true;
            this.l.u();
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    public static final class a
    extends WeakReference {
        private final Object a;

        public a(e e2, Object object) {
            V2.k.e(e2, "referent");
            super((Object)e2);
            this.a = object;
        }

        public final Object a() {
            return this.a;
        }
    }
}

