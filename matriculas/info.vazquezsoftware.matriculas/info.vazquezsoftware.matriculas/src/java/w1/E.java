/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  androidx.appcompat.app.E
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.util.i
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.atomic.AtomicInteger
 */
package w1;

import L1.i;
import L1.j;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.appcompat.app.E;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import u1.g;
import w1.B;
import w1.I;
import w1.J;
import w1.K;
import w1.T;
import w1.b;
import w1.c;
import w1.m;
import w1.n;
import w1.r;
import w1.t;
import w1.u;
import w1.z;
import x1.D;
import x1.h;
import x1.l;
import x1.o;
import x1.p;
import x1.q;
import x1.s;

public class e
implements Handler.Callback {
    public static final Status v = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status w = new Status(4, "The user must be signed in to make this API call.");
    private static final Object x = new Object();
    private static e y;
    private long g = 10000L;
    private boolean h = false;
    private q i;
    private s j;
    private final Context k;
    private final g l;
    private final D m;
    private final AtomicInteger n = new AtomicInteger(1);
    private final AtomicInteger o = new AtomicInteger(0);
    private final Map p = new ConcurrentHashMap(5, 0.75f, 1);
    private r q = null;
    private final Set r = new p.b();
    private final Set s = new p.b();
    private final Handler t;
    private volatile boolean u = true;

    private e(Context context, Looper object, g g2) {
        this.k = context;
        object = new G1.h((Looper)object, this);
        this.t = object;
        this.l = g2;
        this.m = new D(g2);
        if (com.google.android.gms.common.util.i.a((Context)context)) {
            this.u = false;
        }
        object.sendMessage(object.obtainMessage(6));
    }

    static /* bridge */ /* synthetic */ boolean c(e e2) {
        return e2.u;
    }

    private static Status f(b object, u1.b b2) {
        object = ((b)object).b();
        String string = String.valueOf((Object)b2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("API: ");
        stringBuilder.append((String)object);
        stringBuilder.append(" is not available on this device. Connection failed with: ");
        stringBuilder.append(string);
        return new Status(b2, stringBuilder.toString());
    }

    private final z g(v1.e e2) {
        Object object = this.p;
        b b2 = e2.g();
        z z2 = (z)object.get((Object)b2);
        object = z2;
        if (z2 == null) {
            object = new z(this, e2);
            this.p.put((Object)b2, object);
        }
        if (((z)object).b()) {
            this.s.add((Object)b2);
        }
        ((z)object).C();
        return object;
    }

    private final s h() {
        if (this.j == null) {
            this.j = x1.r.a(this.k);
        }
        return this.j;
    }

    private final void i() {
        q q2 = this.i;
        if (q2 != null) {
            if (q2.a() > 0 || this.d()) {
                this.h().a(q2);
            }
            this.i = null;
        }
    }

    private final void j(j object, int n2, v1.e object2) {
        if (n2 != 0 && (object2 = I.b(this, n2, ((v1.e)object2).g())) != null) {
            object = ((j)object).a();
            Handler handler = this.t;
            handler.getClass();
            ((i)object).c(new t(handler), (L1.e)object2);
        }
    }

    static /* bridge */ /* synthetic */ long l(e e2) {
        return e2.g;
    }

    static /* bridge */ /* synthetic */ Context m(e e2) {
        return e2.k;
    }

    static /* bridge */ /* synthetic */ Handler n(e e2) {
        return e2.t;
    }

    static /* bridge */ /* synthetic */ g o(e e2) {
        return e2.l;
    }

    static /* bridge */ /* synthetic */ Status p() {
        return w;
    }

    static /* bridge */ /* synthetic */ Status q(b b2, u1.b b3) {
        return e.f(b2, b3);
    }

    static /* bridge */ /* synthetic */ r r(e e2) {
        return e2.q;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static e t(Context object) {
        Object object2;
        Object object3 = object2 = x;
        synchronized (object3) {
            try {
                e e2;
                if (y != null) return y;
                Looper looper = x1.h.b().getLooper();
                y = e2 = new e(object.getApplicationContext(), looper, u1.g.m());
                return y;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    static /* bridge */ /* synthetic */ D u(e e2) {
        return e2.m;
    }

    static /* bridge */ /* synthetic */ Object v() {
        return x;
    }

    static /* bridge */ /* synthetic */ Map w(e e2) {
        return e2.p;
    }

    static /* bridge */ /* synthetic */ Set x(e e2) {
        return e2.r;
    }

    static /* bridge */ /* synthetic */ void y(e e2, boolean bl) {
        e2.h = true;
    }

    final void A(l object, int n2, long l2, int n3) {
        object = new J((l)object, n2, l2, n3);
        object = this.t.obtainMessage(18, object);
        this.t.sendMessage((Message)object);
    }

    public final void B(u1.b b2, int n2) {
        if (!this.e(b2, n2)) {
            Handler handler = this.t;
            handler.sendMessage(handler.obtainMessage(5, n2, 0, (Object)b2));
        }
    }

    public final void C() {
        Handler handler = this.t;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public final void D(v1.e e2) {
        Handler handler = this.t;
        handler.sendMessage(handler.obtainMessage(7, (Object)e2));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(r r2) {
        Object object;
        Object object2 = object = x;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        if (this.q == r2) break block3;
                        this.q = r2;
                        this.r.clear();
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                this.r.addAll((Collection)r2.t());
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
    final void b(r r2) {
        Object object;
        Object object2 = object = x;
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        if (this.q != r2) break block3;
                        this.q = null;
                        this.r.clear();
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    final boolean d() {
        if (this.h) {
            return false;
        }
        p p2 = x1.o.b().a();
        if (p2 != null && !p2.c()) {
            return false;
        }
        int n2 = this.m.a(this.k, 203400000);
        return n2 == -1 || n2 == 0;
        {
        }
    }

    final boolean e(u1.b b2, int n2) {
        return this.l.w(this.k, b2, n2);
    }

    public final boolean handleMessage(Message object4) {
        int n2 = ((Message)object4).what;
        long l2 = 300000L;
        Object object22 = null;
        switch (n2) {
            default: {
                object4 = new StringBuilder();
                object4.append("Unknown message id: ");
                object4.append(n2);
                Log.w((String)"GoogleApiManager", (String)object4.toString());
                return false;
            }
            case 19: {
                this.h = false;
                break;
            }
            case 18: {
                object4 = (J)((Message)object4).obj;
                if (((J)object4).c == 0L) {
                    object4 = new q(((J)object4).b, Arrays.asList((Object[])new l[]{((J)object4).a}));
                    this.h().a((q)object4);
                    break;
                }
                object22 = this.i;
                if (object22 != null) {
                    List list = ((q)object22).b();
                    if (((q)object22).a() == ((J)object4).b && (list == null || list.size() < ((J)object4).d)) {
                        this.i.c(((J)object4).a);
                    } else {
                        this.t.removeMessages(17);
                        this.i();
                    }
                }
                if (this.i != null) break;
                object22 = new ArrayList();
                object22.add((Object)((J)object4).a);
                this.i = new q(((J)object4).b, (List)object22);
                object22 = this.t;
                object22.sendMessageDelayed(object22.obtainMessage(17), ((J)object4).c);
                break;
            }
            case 17: {
                this.i();
                break;
            }
            case 16: {
                object4 = (B)((Message)object4).obj;
                if (!this.p.containsKey((Object)B.b((B)object4))) break;
                z.A((z)this.p.get((Object)B.b((B)object4)), (B)object4);
                break;
            }
            case 15: {
                object4 = (B)((Message)object4).obj;
                if (!this.p.containsKey((Object)B.b((B)object4))) break;
                z.z((z)this.p.get((Object)B.b((B)object4)), (B)object4);
                break;
            }
            case 14: {
                E.a((Object)((Message)object4).obj);
                throw null;
            }
            case 12: {
                if (!this.p.containsKey(((Message)object4).obj)) break;
                ((z)this.p.get(((Message)object4).obj)).c();
                break;
            }
            case 11: {
                if (!this.p.containsKey(((Message)object4).obj)) break;
                ((z)this.p.get(((Message)object4).obj)).J();
                break;
            }
            case 10: {
                for (Object object22 : this.s) {
                    if ((object22 = (z)this.p.remove(object22)) == null) continue;
                    ((z)object22).I();
                }
                this.s.clear();
                break;
            }
            case 9: {
                if (!this.p.containsKey(((Message)object4).obj)) break;
                ((z)this.p.get(((Message)object4).obj)).H();
                break;
            }
            case 7: {
                this.g((v1.e)((Message)object4).obj);
                break;
            }
            case 6: {
                if (!(this.k.getApplicationContext() instanceof Application)) break;
                c.c((Application)this.k.getApplicationContext());
                c.b().a(new u(this));
                if (c.b().e(true)) break;
                this.g = 300000L;
                break;
            }
            case 5: {
                n2 = ((Message)object4).arg1;
                u1.b b2 = (u1.b)((Message)object4).obj;
                Object object3 = this.p.values().iterator();
                do {
                    object4 = object22;
                } while (object3.hasNext() && ((z)(object4 = (z)object3.next())).q() != n2);
                if (object4 != null) {
                    if (b2.b() == 13) {
                        object22 = this.l.e(b2.b());
                        object3 = b2.c();
                        b2 = new StringBuilder();
                        b2.append("Error resolution was canceled by the user, original error message: ");
                        b2.append((String)object22);
                        b2.append(": ");
                        b2.append((String)object3);
                        z.w((z)object4, new Status(17, b2.toString()));
                        break;
                    }
                    z.w((z)object4, e.f(z.u((z)object4), b2));
                    break;
                }
                object4 = new StringBuilder();
                object4.append("Could not find API instance ");
                object4.append(n2);
                object4.append(" while trying to fail enqueued calls.");
                Log.wtf((String)"GoogleApiManager", (String)object4.toString(), (Throwable)new Exception());
                break;
            }
            case 4: 
            case 8: 
            case 13: {
                K k2 = (K)((Message)object4).obj;
                object4 = object22 = (z)this.p.get((Object)k2.c.g());
                if (object22 == null) {
                    object4 = this.g(k2.c);
                }
                if (((z)object4).b() && this.o.get() != k2.b) {
                    k2.a.a(v);
                    ((z)object4).I();
                    break;
                }
                ((z)object4).D(k2.a);
                break;
            }
            case 3: {
                for (Object object22 : this.p.values()) {
                    ((z)object22).B();
                    ((z)object22).C();
                }
                break;
            }
            case 2: {
                E.a((Object)((Message)object4).obj);
                throw null;
            }
            case 1: {
                if (((Boolean)((Message)object4).obj).booleanValue()) {
                    l2 = 10000L;
                }
                this.g = l2;
                this.t.removeMessages(12);
                for (Object object4 : this.p.keySet()) {
                    object22 = this.t;
                    object22.sendMessageDelayed(object22.obtainMessage(12, object4), this.g);
                }
            }
        }
        return true;
    }

    public final int k() {
        return this.n.getAndIncrement();
    }

    final z s(b b2) {
        return (z)this.p.get((Object)b2);
    }

    public final void z(v1.e object, int n2, n n3, j j2, m m2) {
        this.j(j2, n3.d(), (v1.e)object);
        object = new K(new T(n2, n3, j2, m2), this.o.get(), (v1.e)object);
        object = this.t.obtainMessage(4, object);
        this.t.sendMessage((Message)object);
    }
}

