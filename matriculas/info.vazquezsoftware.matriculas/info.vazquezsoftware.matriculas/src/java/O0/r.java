/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Iterable
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Objects
 *  java.util.concurrent.Executor
 */
package O0;

import F0.b;
import I0.e;
import I0.f;
import I0.g;
import K0.c;
import O0.g;
import O0.h;
import O0.i;
import O0.j;
import O0.k;
import O0.l;
import O0.m;
import O0.n;
import O0.o;
import O0.p;
import O0.q;
import O0.x;
import P0.c;
import P0.d;
import Q0.b;
import R0.a;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

public class r {
    private final Context a;
    private final e b;
    private final d c;
    private final x d;
    private final Executor e;
    private final Q0.b f;
    private final a g;
    private final a h;
    private final c i;

    public r(Context context, e e2, d d2, x x2, Executor executor, Q0.b b2, a a2, a a3, c c2) {
        this.a = context;
        this.b = e2;
        this.c = d2;
        this.d = x2;
        this.e = executor;
        this.f = b2;
        this.g = a2;
        this.h = a3;
        this.i = c2;
    }

    public static /* synthetic */ Iterable a(r r2, H0.o o2) {
        return r2.c.o0(o2);
    }

    public static /* synthetic */ Object b(r r2, Iterable iterable, H0.o o2, long l2) {
        r2.c.r0(iterable);
        r2.c.G(o2, r2.g.a() + l2);
        return null;
    }

    public static /* synthetic */ Object c(r r2) {
        r2.i.j();
        return null;
    }

    public static /* synthetic */ Boolean d(r r2, H0.o o2) {
        return r2.c.z(o2);
    }

    public static /* synthetic */ Object e(r r2, Iterable iterable) {
        r2.c.o(iterable);
        return null;
    }

    public static /* synthetic */ Object f(r r2, H0.o o2, int n2) {
        r2.d.b(o2, n2 + 1);
        return null;
    }

    public static /* synthetic */ Object g(r r2, H0.o o2, long l2) {
        r2.c.G(o2, r2.g.a() + l2);
        return null;
    }

    public static /* synthetic */ Object h(r r2, Map map) {
        r2.getClass();
        for (Map.Entry entry : map.entrySet()) {
            r2.i.i(((Integer)entry.getValue()).intValue(), c.b.m, (String)entry.getKey());
        }
        return null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void i(r r2, H0.o o2, int n2, Runnable runnable) {
        Throwable throwable222222;
        block5: {
            r2.getClass();
            Object object = r2.f;
            d d2 = r2.c;
            Objects.requireNonNull((Object)d2);
            Object object2 = new i(d2);
            object.a((b.a)object2);
            if (!r2.k()) {
                object2 = r2.f;
                object = new j(r2, o2, n2);
                object2.a((b.a)object);
                break block5;
            }
            r2.l(o2, n2);
        }
        runnable.run();
        return;
        {
            catch (Throwable throwable222222) {
            }
            catch (Q0.a a2) {}
            {
                r2.d.b(o2, n2 + 1);
            }
            runnable.run();
            return;
        }
        runnable.run();
        throw throwable222222;
    }

    public H0.i j(I0.m m2) {
        Q0.b b2 = this.f;
        Object object = this.i;
        Objects.requireNonNull((Object)object);
        object = (K0.a)b2.a(new h((c)object));
        return m2.b(H0.i.a().i(this.g.a()).k(this.h.a()).j("GDT_CLIENT_METRICS").h(new H0.h(F0.b.b("proto"), ((K0.a)object).f())).d());
    }

    boolean k() {
        NetworkInfo networkInfo = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public I0.g l(H0.o object, int n2) {
        I0.m m2 = this.b.a(((H0.o)object).b());
        I0.g g2 = I0.g.e(0L);
        long l2 = 0L;
        H0.o o2 = object;
        object = g2;
        while (((Boolean)this.f.a(new k(this, o2))).booleanValue()) {
            long l3;
            Iterator iterator;
            g2 = (Iterable)this.f.a(new l(this, o2));
            if (!g2.iterator().hasNext()) {
                return object;
            }
            if (m2 == null) {
                L0.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", o2);
                object = I0.g.a();
            } else {
                object = new ArrayList();
                iterator = g2.iterator();
                while (iterator.hasNext()) {
                    object.add((Object)((P0.k)iterator.next()).b());
                }
                if (o2.e()) {
                    object.add((Object)this.j(m2));
                }
                object = m2.a(I0.f.a().b((Iterable)object).c(o2.c()).a());
            }
            if (((I0.g)object).c() == g.a.h) {
                this.f.a(new m(this, (Iterable)g2, o2, l2));
                this.d.a(o2, n2 + 1, true);
                return object;
            }
            this.f.a(new n(this, (Iterable)g2));
            if (((I0.g)object).c() == g.a.g) {
                l3 = Math.max((long)l2, (long)((I0.g)object).b());
                if (o2.e()) {
                    this.f.a(new o(this));
                }
            } else {
                l3 = l2;
                if (((I0.g)object).c() == g.a.j) {
                    iterator = new HashMap();
                    g2 = g2.iterator();
                    while (g2.hasNext()) {
                        String string = ((P0.k)g2.next()).b().j();
                        if (!iterator.containsKey((Object)string)) {
                            iterator.put((Object)string, (Object)1);
                            continue;
                        }
                        iterator.put((Object)string, (Object)((Integer)iterator.get((Object)string) + 1));
                    }
                    this.f.a(new p(this, (Map)iterator));
                    l3 = l2;
                }
            }
            l2 = l3;
        }
        this.f.a(new q(this, o2, l2));
        return object;
    }

    public void m(H0.o o2, int n2, Runnable runnable) {
        this.e.execute((Runnable)new g(this, o2, n2, runnable));
    }
}

