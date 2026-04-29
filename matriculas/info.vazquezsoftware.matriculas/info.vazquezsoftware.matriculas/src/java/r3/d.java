/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.net.Socket
 *  java.util.List
 */
package r3;

import H2.q;
import V2.k;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import m3.C;
import m3.t;
import m3.w;
import r3.e;
import r3.f;
import r3.g;
import r3.i;
import r3.j;
import u3.a;
import u3.b;
import u3.n;

public final class d {
    private final g a;
    private final m3.a b;
    private final e c;
    private final m3.q d;
    private j.b e;
    private j f;
    private int g;
    private int h;
    private int i;
    private C j;

    public d(g g2, m3.a a2, e e2, m3.q q2) {
        k.e(g2, "connectionPool");
        k.e(a2, "address");
        k.e(e2, "call");
        k.e(q2, "eventListener");
        this.a = g2;
        this.b = a2;
        this.c = e2;
        this.d = q2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final f b(int var1_1, int var2_2, int var3_3, int var4_4, boolean var5_5) {
        block24: {
            block23: {
                if (this.c.r()) {
                    throw new IOException("Canceled");
                }
                var7_6 = this.c.l();
                if (var7_6 != null) {
                    var9_7 = var7_6;
                    synchronized (var9_7) {
                        block21: {
                            block20: {
                                try {
                                    if (var7_6.p() || !this.g(var7_6.z().a().l())) break block20;
                                    var6_8 = null;
                                    break block21;
                                }
                                catch (Throwable var6_9) {
                                    ** break block22
                                }
                            }
                            var6_8 = this.c.u();
                        }
                        var8_11 = q.a;
                        ** if (this.c.l() == null) goto lbl21
                    }
lbl-1000:
                    // 1 sources

                    {
                        if (var6_8 == null) {
                            return var7_6;
                        }
                        throw new IllegalStateException("Check failed.");
                    }
lbl21:
                    // 1 sources

                    if (var6_8 != null) {
                        n3.d.n((Socket)var6_8);
                    }
                    this.d.k(this.c, (m3.i)var7_6);
                    break block23;
lbl-1000:
                    // 1 sources

                    {
                        throw var6_9;
                    }
                }
            }
            this.g = 0;
            this.h = 0;
            this.i = 0;
            if (this.a.a(this.b, this.c, null, false)) {
                var6_8 = this.c.l();
                k.b(var6_8);
                this.d.j(this.c, (m3.i)var6_8);
                return var6_8;
            }
            var6_8 = this.j;
            if (var6_8 == null) break block24;
            k.b(var6_8);
            this.j = null;
            ** GOTO lbl49
        }
        var6_8 = this.e;
        if (var6_8 == null) ** GOTO lbl-1000
        k.b(var6_8);
        if (var6_8.b()) {
            var6_8 = this.e;
            k.b(var6_8);
            var6_8 = var6_8.c();
lbl49:
            // 2 sources

            var7_6 = null;
        } else lbl-1000:
        // 2 sources

        {
            var6_8 = var7_6 = this.f;
            if (var7_6 == null) {
                this.f = var6_8 = new j(this.b, this.c.k().s(), this.c, this.d);
            }
            this.e = var6_8 = var6_8.c();
            var7_6 = var6_8.a();
            if (this.c.r()) {
                throw new IOException("Canceled");
            }
            if (this.a.a(this.b, this.c, (List)var7_6, false)) {
                var6_8 = this.c.l();
                k.b(var6_8);
                this.d.j(this.c, (m3.i)var6_8);
                return var6_8;
            }
            var6_8 = var6_8.c();
        }
        var8_11 = new f(this.a, (C)var6_8);
        this.c.w((f)var8_11);
        var8_11.f(var1_1, var2_2, var3_3, var4_4, var5_5, this.c, this.d);
        this.c.k().s().a(var8_11.z());
        if (this.a.a(this.b, this.c, (List)var7_6, true)) {
            var7_6 = this.c.l();
            k.b(var7_6);
            this.j = var6_8;
            n3.d.n(var8_11.D());
            this.d.j(this.c, (m3.i)var7_6);
            return var7_6;
        }
        var10_12 = var8_11;
        synchronized (var10_12) {
            this.a.e((f)var8_11);
            this.c.a((f)var8_11);
            var6_8 = q.a;
        }
        this.d.j(this.c, (m3.i)var8_11);
        return var8_11;
        finally {
            this.c.w(null);
        }
    }

    private final f c(int n2, int n3, int n4, int n5, boolean bl, boolean bl2) {
        while (true) {
            Object object;
            if (((f)(object = this.b(n2, n3, n4, n5, bl))).u(bl2)) {
                return object;
            }
            ((f)object).y();
            if (this.j != null) continue;
            object = this.e;
            boolean bl3 = true;
            boolean bl4 = object == null ? true : ((j.b)object).b();
            if (!bl4 && !(bl4 = (object = this.f) == null ? bl3 : ((j)object).a())) break;
        }
        throw new IOException("exhausted all routes");
    }

    private final C f() {
        if (this.g <= 1 && this.h <= 1 && this.i <= 0) {
            f f2 = this.c.l();
            if (f2 == null) {
                return null;
            }
            f f3 = f2;
            synchronized (f3) {
                block8: {
                    block7: {
                        int n2 = f2.q();
                        if (n2 == 0) break block7;
                        return null;
                    }
                    boolean bl = n3.d.j(f2.z().a().l(), this.d().l());
                    if (bl) break block8;
                    return null;
                }
                C c2 = f2.z();
                return c2;
            }
        }
        return null;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final s3.d a(w object, s3.g g2) {
        void var1_5;
        block7: {
            void var1_3;
            block6: {
                boolean bl2;
                boolean bl;
                int n5;
                int n4;
                int n3;
                int n2;
                k.e(object, "client");
                k.e(g2, "chain");
                try {
                    n2 = g2.f();
                    n3 = g2.h();
                    n4 = g2.j();
                    n5 = ((w)object).x();
                    bl = ((w)object).D();
                    bl2 = k.a(g2.i().g(), "GET");
                }
                catch (IOException iOException) {
                    break block6;
                }
                catch (i i3) {
                    break block7;
                }
                try {
                    return this.c(n2, n3, n4, n5, bl, bl2 ^ true).w((w)object, g2);
                }
                catch (IOException iOException) {
                }
                catch (i i2) {
                    break block7;
                }
            }
            this.h((IOException)var1_3);
            throw new i((IOException)var1_3);
        }
        this.h(var1_5.c());
        throw var1_5;
    }

    public final m3.a d() {
        return this.b;
    }

    public final boolean e() {
        if (this.g == 0 && this.h == 0 && this.i == 0) {
            return false;
        }
        if (this.j != null) {
            return true;
        }
        Object object = this.f();
        if (object != null) {
            this.j = object;
            return true;
        }
        object = this.e;
        if (object != null && ((j.b)object).b()) {
            return true;
        }
        object = this.f;
        if (object == null) {
            return true;
        }
        return ((j)object).a();
    }

    public final boolean g(t t2) {
        k.e(t2, "url");
        t t3 = this.b.l();
        return t2.l() == t3.l() && k.a(t2.h(), t3.h());
    }

    public final void h(IOException iOException) {
        k.e((Object)iOException, "e");
        this.j = null;
        if (iOException instanceof n && ((n)iOException).g == u3.b.p) {
            ++this.g;
            return;
        }
        if (iOException instanceof a) {
            ++this.h;
            return;
        }
        ++this.i;
    }
}

