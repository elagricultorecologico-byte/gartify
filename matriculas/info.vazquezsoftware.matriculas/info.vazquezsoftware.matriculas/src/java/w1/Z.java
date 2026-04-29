/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.DeadObjectException
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  androidx.appcompat.app.E
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.util.b
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 *  java.util.Queue
 *  java.util.Set
 */
package w1;

import L1.j;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.appcompat.app.E;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import p.a;
import u1.d;
import v1.a;
import v1.f;
import v1.h;
import w1.B;
import w1.D;
import w1.H;
import w1.N;
import w1.O;
import w1.U;
import w1.V;
import w1.b;
import w1.e;
import w1.i;
import w1.q;
import w1.v;
import w1.w;
import w1.y;
import x1.m;
import x1.n;

public final class z
implements f.a,
f.b {
    private final Queue g;
    private final a.f h;
    private final b i;
    private final q j;
    private final Set k;
    private final Map l;
    private final int m;
    private final O n;
    private boolean o;
    private final List p;
    private u1.b q;
    private int r;
    final e s;

    public z(e e2, v1.e e3) {
        a.f f2;
        this.s = e2;
        this.g = new LinkedList();
        this.k = new HashSet();
        this.l = new HashMap();
        this.p = new ArrayList();
        this.q = null;
        this.r = 0;
        this.h = f2 = e3.j(e.n(e2).getLooper(), this);
        this.i = e3.g();
        this.j = new q();
        this.m = e3.i();
        if (f2.o()) {
            this.n = e3.k(e.m(e2), e.n(e2));
            return;
        }
        this.n = null;
    }

    static /* bridge */ /* synthetic */ void A(z z2, B object) {
        if (z2.p.remove(object)) {
            Object[] objectArray;
            e.n(z2.s).removeMessages(15, object);
            e.n(z2.s).removeMessages(16, object);
            object = B.a((B)object);
            ArrayList arrayList = new ArrayList(z2.g.size());
            for (V v2 : z2.g) {
                if (!(v2 instanceof H) || (objectArray = ((H)v2).g(z2)) == null || !com.google.android.gms.common.util.b.b((Object[])objectArray, (Object)object)) continue;
                arrayList.add((Object)v2);
            }
            int n2 = arrayList.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                objectArray = (V)arrayList.get(i2);
                z2.g.remove((Object)objectArray);
                objectArray.b((Exception)((Object)new h((d)object)));
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean K(z z2) {
        return z2.o;
    }

    private final d d(d[] dArray) {
        if (dArray != null && dArray.length != 0) {
            d d2;
            int n2;
            Object object = this.h.i();
            int n3 = 0;
            d[] dArray2 = object;
            if (object == null) {
                dArray2 = new d[]{};
            }
            object = new a(dArray2.length);
            for (n2 = 0; n2 < dArray2.length; ++n2) {
                d2 = dArray2[n2];
                object.put((Object)d2.b(), (Object)d2.c());
            }
            int n4 = dArray.length;
            for (n2 = n3; n2 < n4; ++n2) {
                d2 = dArray[n2];
                dArray2 = (d[])object.get((Object)d2.b());
                if (dArray2 != null && dArray2.longValue() >= d2.c()) {
                    continue;
                }
                return d2;
            }
        }
        return null;
    }

    private final void e(u1.b b2) {
        Iterator iterator = this.k.iterator();
        if (iterator.hasNext()) {
            E.a((Object)iterator.next());
            if (x1.m.a(b2, u1.b.l)) {
                this.h.k();
            }
            throw null;
        }
        this.k.clear();
    }

    private final void f(Status status) {
        x1.n.d(e.n(this.s));
        this.g(status, null, false);
    }

    private final void g(Status status, Exception exception, boolean bl) {
        x1.n.d(e.n(this.s));
        boolean bl2 = true;
        boolean bl3 = status == null;
        if (exception != null) {
            bl2 = false;
        }
        if (bl3 != bl2) {
            Iterator iterator = this.g.iterator();
            while (iterator.hasNext()) {
                V v2 = (V)iterator.next();
                if (bl && v2.a != 2) continue;
                if (status != null) {
                    v2.a(status);
                } else {
                    v2.b(exception);
                }
                iterator.remove();
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    private final void h() {
        ArrayList arrayList = new ArrayList((Collection)this.g);
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            V v2 = (V)arrayList.get(i2);
            if (!this.h.a()) break;
            if (!this.n(v2)) continue;
            this.g.remove((Object)v2);
        }
    }

    private final void i() {
        this.B();
        this.e(u1.b.l);
        this.m();
        Iterator iterator = this.l.values().iterator();
        if (!iterator.hasNext()) {
            this.h();
            this.k();
            return;
        }
        E.a((Object)iterator.next());
        throw null;
    }

    private final void j(int n2) {
        this.B();
        this.o = true;
        Object object = this.h.l();
        this.j.c(n2, (String)object);
        b b2 = this.i;
        object = this.s;
        e.n((e)object).sendMessageDelayed(Message.obtain((Handler)e.n((e)object), (int)9, (Object)b2), 5000L);
        b2 = this.i;
        object = this.s;
        e.n((e)object).sendMessageDelayed(Message.obtain((Handler)e.n((e)object), (int)11, (Object)b2), 120000L);
        e.u(this.s).c();
        object = this.l.values().iterator();
        if (!object.hasNext()) {
            return;
        }
        E.a((Object)object.next());
        throw null;
    }

    private final void k() {
        b b2 = this.i;
        e.n(this.s).removeMessages(12, (Object)b2);
        b2 = this.i;
        e e2 = this.s;
        e.n(e2).sendMessageDelayed(e.n(e2).obtainMessage(12, (Object)b2), e.l(this.s));
    }

    private final void l(V v2) {
        v2.d(this.j, this.b());
        try {
            v2.c(this);
            return;
        }
        catch (DeadObjectException deadObjectException) {
            this.a(1);
            this.h.d("DeadObjectException thrown while running ApiCallRunner.");
            return;
        }
    }

    private final void m() {
        if (this.o) {
            e e2 = this.s;
            b b2 = this.i;
            e.n(e2).removeMessages(11, (Object)b2);
            e2 = this.s;
            b2 = this.i;
            e.n(e2).removeMessages(9, (Object)b2);
            this.o = false;
        }
    }

    private final boolean n(V object) {
        if (!(object instanceof H)) {
            this.l((V)object);
            return true;
        }
        H h2 = (H)object;
        Object object2 = this.d(h2.g(this));
        if (object2 == null) {
            this.l((V)object);
            return true;
        }
        object = this.h.getClass().getName();
        String string = ((d)object2).b();
        long l2 = ((d)object2).c();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append(" could not execute call because it requires feature (");
        stringBuilder.append(string);
        stringBuilder.append(", ");
        stringBuilder.append(l2);
        stringBuilder.append(").");
        Log.w((String)"GoogleApiManager", (String)stringBuilder.toString());
        if (e.c(this.s) && h2.f(this)) {
            object = new B(this.i, (d)object2, null);
            int n2 = this.p.indexOf(object);
            if (n2 >= 0) {
                object = (B)this.p.get(n2);
                e.n(this.s).removeMessages(15, object);
                object2 = this.s;
                e.n((e)object2).sendMessageDelayed(Message.obtain((Handler)e.n((e)object2), (int)15, (Object)object), 5000L);
            } else {
                this.p.add(object);
                object2 = this.s;
                e.n((e)object2).sendMessageDelayed(Message.obtain((Handler)e.n((e)object2), (int)15, (Object)object), 5000L);
                object2 = this.s;
                e.n((e)object2).sendMessageDelayed(Message.obtain((Handler)e.n((e)object2), (int)16, (Object)object), 120000L);
                object = new u1.b(2, null);
                if (!this.o((u1.b)object)) {
                    this.s.e((u1.b)object, this.m);
                }
            }
            return false;
        }
        h2.b((Exception)((Object)new h((d)object2)));
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final boolean o(u1.b b2) {
        Object object;
        Object object2 = object = e.v();
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                try {
                    e e2 = this.s;
                    if (e.r(e2) != null && e.x(e2).contains((Object)this.i)) {
                        e.r(this.s).s(b2, this.m);
                        return true;
                    }
                }
                catch (Throwable throwable2) {
                    break block4;
                }
                return false;
            }
            throw throwable2;
        }
    }

    private final boolean p(boolean bl) {
        x1.n.d(e.n(this.s));
        if (this.h.a() && this.l.isEmpty()) {
            if (this.j.e()) {
                if (bl) {
                    this.k();
                }
            } else {
                this.h.d("Timing out service connection.");
                return true;
            }
        }
        return false;
    }

    static /* bridge */ /* synthetic */ a.f s(z z2) {
        return z2.h;
    }

    static /* bridge */ /* synthetic */ b u(z z2) {
        return z2.i;
    }

    static /* bridge */ /* synthetic */ void w(z z2, Status status) {
        z2.f(status);
    }

    static /* bridge */ /* synthetic */ void x(z z2) {
        z2.i();
    }

    static /* bridge */ /* synthetic */ void y(z z2, int n2) {
        z2.j(n2);
    }

    static /* bridge */ /* synthetic */ void z(z z2, B b2) {
        if (z2.p.contains((Object)b2) && !z2.o) {
            if (!z2.h.a()) {
                z2.C();
                return;
            }
            z2.h();
        }
    }

    public final void B() {
        x1.n.d(e.n(this.s));
        this.q = null;
    }

    public final void C() {
        block7: {
            IllegalStateException illegalStateException2;
            block8: {
                Object object;
                block6: {
                    int n2;
                    x1.n.d(e.n(this.s));
                    if (this.h.a() || this.h.h()) break block7;
                    try {
                        object = this.s;
                        n2 = e.u((e)object).b(e.m((e)object), this.h);
                        if (n2 == 0) break block6;
                    }
                    catch (IllegalStateException illegalStateException2) {}
                    u1.b b2 = new u1.b(n2, null);
                    String string = this.h.getClass().getName();
                    String string2 = b2.toString();
                    object = new StringBuilder();
                    object.append("The service for ");
                    object.append(string);
                    object.append(" is not available: ");
                    object.append(string2);
                    Log.w((String)"GoogleApiManager", (String)object.toString());
                    this.F(b2, null);
                    return;
                    break block8;
                }
                Object object2 = this.s;
                object = this.h;
                object2 = new D((e)object2, object, this.i);
                if (object.o()) {
                    ((O)x1.n.i(this.n)).Q1((N)object2);
                }
                try {
                    this.h.j(object2);
                    return;
                }
                catch (SecurityException securityException) {
                    this.F(new u1.b(10), (Exception)((Object)securityException));
                    return;
                }
            }
            this.F(new u1.b(10), (Exception)((Object)illegalStateException2));
        }
    }

    public final void D(V object) {
        x1.n.d(e.n(this.s));
        if (this.h.a()) {
            if (this.n((V)object)) {
                this.k();
                return;
            }
            this.g.add(object);
            return;
        }
        this.g.add(object);
        object = this.q;
        if (object != null && ((u1.b)object).g()) {
            this.F(this.q, null);
            return;
        }
        this.C();
    }

    final void E() {
        ++this.r;
    }

    public final void F(u1.b object, Exception object2) {
        x1.n.d(e.n(this.s));
        Object object3 = this.n;
        if (object3 != null) {
            ((O)object3).u2();
        }
        this.B();
        e.u(this.s).c();
        this.e((u1.b)object);
        if (this.h instanceof z1.e && ((u1.b)object).b() != 24) {
            e.y(this.s, true);
            object3 = this.s;
            e.n((e)object3).sendMessageDelayed(e.n((e)object3).obtainMessage(19), 300000L);
        }
        if (((u1.b)object).b() == 4) {
            this.f(e.p());
            return;
        }
        if (this.g.isEmpty()) {
            this.q = object;
            return;
        }
        if (object2 != null) {
            x1.n.d(e.n(this.s));
            this.g(null, (Exception)((Object)object2), false);
            return;
        }
        if (e.c(this.s)) {
            this.g(e.q(this.i, (u1.b)object), null, true);
            if (!(this.g.isEmpty() || this.o((u1.b)object) || this.s.e((u1.b)object, this.m))) {
                if (((u1.b)object).b() == 18) {
                    this.o = true;
                }
                if (this.o) {
                    object = this.s;
                    object2 = this.i;
                    e.n((e)object).sendMessageDelayed(Message.obtain((Handler)e.n((e)object), (int)9, (Object)object2), 5000L);
                    return;
                }
                this.f(e.q(this.i, (u1.b)object));
            }
            return;
        }
        this.f(e.q(this.i, (u1.b)object));
    }

    public final void G(u1.b b2) {
        x1.n.d(e.n(this.s));
        a.f f2 = this.h;
        String string = f2.getClass().getName();
        String string2 = String.valueOf((Object)b2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSignInFailed for ");
        stringBuilder.append(string);
        stringBuilder.append(" with ");
        stringBuilder.append(string2);
        f2.d(stringBuilder.toString());
        this.F(b2, null);
    }

    public final void H() {
        x1.n.d(e.n(this.s));
        if (this.o) {
            this.C();
        }
    }

    public final void I() {
        x1.n.d(e.n(this.s));
        this.f(e.v);
        this.j.d();
        i[] iArray = this.l.keySet();
        for (i i2 : (i[])iArray.toArray((Object[])new i[0])) {
            this.D(new U(null, new j()));
        }
        this.e(new u1.b(4));
        if (this.h.a()) {
            this.h.c(new y(this));
        }
    }

    public final void J() {
        x1.n.d(e.n(this.s));
        if (this.o) {
            this.m();
            e e2 = this.s;
            e2 = e.o(e2).g(e.m(e2)) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error.");
            this.f((Status)e2);
            this.h.d("Timing out connection while resuming.");
        }
    }

    @Override
    public final void Z(u1.b b2) {
        this.F(b2, null);
    }

    @Override
    public final void a(int n2) {
        e e2 = this.s;
        if (Looper.myLooper() == e.n(e2).getLooper()) {
            this.j(n2);
            return;
        }
        e.n(this.s).post((Runnable)new w(this, n2));
    }

    public final boolean b() {
        return this.h.o();
    }

    public final boolean c() {
        return this.p(true);
    }

    @Override
    public final void c0(Bundle object) {
        object = this.s;
        if (Looper.myLooper() == e.n((e)object).getLooper()) {
            this.i();
            return;
        }
        e.n(this.s).post((Runnable)new v(this));
    }

    public final int q() {
        return this.m;
    }

    final int r() {
        return this.r;
    }

    public final a.f t() {
        return this.h;
    }

    public final Map v() {
        return this.l;
    }
}

