/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  com.google.android.gms.internal.ads.Cf
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.Yj
 *  com.google.android.gms.internal.ads.kp
 *  com.google.android.gms.internal.ads.op
 *  f1.g
 *  f1.p
 *  java.lang.Boolean
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicLong
 */
package b1;

import C1.b;
import T0.d;
import T0.h;
import T0.o;
import T0.u;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import b1.A;
import b1.E;
import b1.H;
import b1.M1;
import b1.Q0;
import b1.U1;
import b1.V;
import b1.W1;
import b1.X0;
import b1.a;
import b1.b1;
import b1.g2;
import b1.h2;
import b1.i1;
import b1.j1;
import b1.k;
import b1.k1;
import b1.l0;
import b1.p2;
import b1.v;
import b1.w;
import b1.x;
import b1.y;
import b1.z;
import com.google.android.gms.internal.ads.Cf;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.Yj;
import com.google.android.gms.internal.ads.kp;
import com.google.android.gms.internal.ads.op;
import f1.g;
import f1.p;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public final class l1 {
    private final kp a = new kp();
    private final g2 b;
    private final AtomicBoolean c;
    private final T0.w d = new T0.w();
    final y e = new j1(this);
    private a f;
    private d g;
    private h[] h;
    private U0.d i;
    private V j;
    private T0.x k;
    private String l;
    private final ViewGroup m;
    private int n;
    private boolean o;
    private final AtomicLong p = new AtomicLong();

    public l1(ViewGroup viewGroup, int n3) {
        this(viewGroup, null, false, g2.a, null, n3);
    }

    l1(ViewGroup viewGroup, AttributeSet object, boolean bl, g2 object2, V v2, int n3) {
        this.m = viewGroup;
        this.b = object2;
        this.j = null;
        this.c = new AtomicBoolean(false);
        this.n = n3;
        if (object != null) {
            v2 = viewGroup.getContext();
            try {
                object2 = new p2((Context)v2, (AttributeSet)object);
                this.h = ((p2)object2).a(bl);
                this.l = ((p2)object2).b();
            }
            catch (IllegalArgumentException illegalArgumentException) {
                x.a().m(viewGroup, new h2((Context)v2, T0.h.j), illegalArgumentException.getMessage(), illegalArgumentException.getMessage());
            }
            if (viewGroup.isInEditMode()) {
                object2 = x.a();
                object = this.h[0];
                n3 = this.n;
                if (((h)object).equals(T0.h.r)) {
                    object = new h2("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false, false, false);
                } else {
                    object = new h2((Context)v2, (h)object);
                    ((h2)object).p = l1.f(n3);
                }
                object2.n(viewGroup, (h2)object, "Ads by Google");
                return;
            }
        }
    }

    private static h2 e(Context object, h[] hArray, int n3) {
        int n4 = hArray.length;
        for (int i3 = 0; i3 < n4; ++i3) {
            if (!hArray[i3].equals(T0.h.r)) continue;
            return new h2("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false, false, false);
        }
        object = new h2((Context)object, hArray);
        object.p = l1.f(n3);
        return object;
    }

    private static boolean f(int n3) {
        return n3 == 1;
    }

    public final o A() {
        return null;
    }

    public final T0.w B() {
        return this.d;
    }

    public final b1 C() {
        Object object = this.j;
        if (object != null) {
            try {
                object = object.E();
                return object;
            }
            catch (RemoteException remoteException) {
                f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException);
            }
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(T0.x object) {
        this.k = object;
        try {
            V v2 = this.j;
            if (v2 == null) return;
            object = object == null ? null : new U1((T0.x)object);
            v2.b4((U1)object);
            return;
        }
        catch (RemoteException remoteException) {}
        f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException);
    }

    public final T0.x b() {
        return this.k;
    }

    final /* synthetic */ void c(C1.a a3) {
        a3 = (View)C1.b.c0(a3);
        this.m.addView((View)a3);
    }

    final /* synthetic */ T0.w d() {
        return this.d;
    }

    public final void g() {
        RemoteException remoteException2;
        block4: {
            block3: {
                V v2;
                try {
                    v2 = this.j;
                    if (v2 == null) break block3;
                }
                catch (RemoteException remoteException2) {}
                v2.d();
                return;
                break block4;
            }
            return;
        }
        f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException2);
    }

    public final d h() {
        return this.g;
    }

    public final h i() {
        Object object;
        block5: {
            object = this.j;
            if (object == null) break block5;
            object = object.o();
            if (object == null) break block5;
            try {
                object = T0.A.a(object.k, object.h, object.g);
                return object;
            }
            catch (RemoteException remoteException) {
                f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException);
            }
        }
        if ((object = this.h) != null) {
            return object[0];
        }
        return null;
    }

    public final h[] j() {
        return this.h;
    }

    public final String k() {
        V v2;
        if (this.l == null && (v2 = this.j) != null) {
            try {
                this.l = v2.t();
            }
            catch (RemoteException remoteException) {
                f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException);
            }
        }
        return this.l;
    }

    public final U0.d l() {
        return this.i;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void m(i1 object) {
        RemoteException remoteException3;
        block15: {
            Object object2;
            V v2;
            long l3;
            block11: {
                block12: {
                    RemoteException remoteException22;
                    block14: {
                        block13: {
                            Object object3;
                            try {
                                l3 = System.currentTimeMillis();
                                v2 = this.j;
                                if (v2 != null) break block11;
                                if ((this.h == null || this.l == null) && v2 == null) break block12;
                                v2 = this.m;
                                Context context = v2.getContext();
                                Object object4 = l1.e(context, this.h, this.n);
                                object2 = x.b();
                                String string = this.l;
                                kp kp2 = this.a;
                                object3 = new k((v)object2, context, (h2)object4, string, (op)kp2);
                                this.j = object3 = (V)((w)object3).d(context, false);
                                object2 = new W1(this.e);
                                object3.K3((H)object2);
                                object3 = this.f;
                                if (object3 != null) {
                                    object4 = this.j;
                                    object2 = new z((a)object3);
                                    object4.K1((E)object2);
                                }
                                if ((object4 = this.i) != null) {
                                    object3 = this.j;
                                    object2 = new Cf((U0.d)object4);
                                    object3.j4((l0)object2);
                                }
                                if (this.k != null) {
                                    object3 = this.j;
                                    object2 = new U1(this.k);
                                    object3.b4((U1)object2);
                                }
                                object2 = this.j;
                                object3 = new M1(null);
                                object2.S2((Q0)object3);
                                this.j.Y1(this.o);
                                object2 = this.j;
                                if (object2 == null) break block11;
                            }
                            catch (RemoteException remoteException3) {
                                break block15;
                            }
                            try {
                                object2 = object2.b();
                                if (object2 == null) break block11;
                                if (!((Boolean)Yj.f.e()).booleanValue()) break block13;
                                object3 = Yi.Cc;
                                if (!((Boolean)A.c().d((Oi)object3)).booleanValue()) break block13;
                                v2 = f1.g.b;
                                object3 = new k1(this, (C1.a)object2);
                                v2.post((Runnable)object3);
                                break block11;
                            }
                            catch (RemoteException remoteException22) {
                                break block14;
                            }
                        }
                        v2.addView((View)C1.b.c0((C1.a)object2));
                        break block11;
                    }
                    f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException22);
                    break block11;
                }
                object = new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                throw object;
            }
            ((i1)object).o(l3);
            if (((i1)object).q() != 0L) {
                this.p.set(((i1)object).q());
            }
            if ((v2 = this.j) == null) {
                throw null;
            }
            object2 = this.p;
            if (object2.get() != 0L) {
                v2.n2(object2.get());
            }
            v2.I0(this.b.a(this.m.getContext(), (i1)object));
            return;
        }
        f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException3);
    }

    public final void n() {
        RemoteException remoteException2;
        block4: {
            block3: {
                V v2;
                try {
                    v2 = this.j;
                    if (v2 == null) break block3;
                }
                catch (RemoteException remoteException2) {}
                v2.e();
                return;
                break block4;
            }
            return;
        }
        f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException2);
    }

    public final void o() {
        RemoteException remoteException2;
        block4: {
            block3: {
                V v2;
                try {
                    v2 = this.j;
                    if (v2 == null) break block3;
                }
                catch (RemoteException remoteException2) {}
                v2.f();
                return;
                break block4;
            }
            return;
        }
        f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException2);
    }

    public final void p(d d3) {
        this.g = d3;
        this.e.o(d3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void q(a object) {
        RemoteException remoteException2;
        block5: {
            block2: {
                V v2;
                block4: {
                    block3: {
                        try {
                            this.f = object;
                            v2 = this.j;
                            if (v2 == null) break block2;
                            if (object == null) break block3;
                            z z2 = new z((a)object);
                            object = z2;
                            break block4;
                        }
                        catch (RemoteException remoteException2) {
                            break block5;
                        }
                    }
                    object = null;
                }
                v2.K1((E)object);
            }
            return;
        }
        f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException2);
    }

    public final void r(h ... hArray) {
        if (this.h == null) {
            this.s(hArray);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void s(h ... object) {
        block3: {
            this.h = object;
            object = this.j;
            if (object == null) break block3;
            try {
                object.w4(l1.e(this.m.getContext(), this.h, this.n));
            }
            catch (RemoteException remoteException) {
                f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException);
            }
        }
        this.m.requestLayout();
    }

    public final void t(String string) {
        if (this.l == null) {
            this.l = string;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void u(U0.d d3) {
        RemoteException remoteException2;
        block5: {
            block2: {
                V v2;
                block4: {
                    block3: {
                        try {
                            this.i = d3;
                            v2 = this.j;
                            if (v2 == null) break block2;
                            if (d3 == null) break block3;
                            Cf cf2 = new Cf(d3);
                            d3 = cf2;
                            break block4;
                        }
                        catch (RemoteException remoteException2) {
                            break block5;
                        }
                    }
                    d3 = null;
                }
                v2.j4((l0)((Object)d3));
            }
            return;
        }
        f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException2);
    }

    public final void v(boolean bl) {
        RemoteException remoteException2;
        block4: {
            block3: {
                V v2;
                this.o = bl;
                try {
                    v2 = this.j;
                    if (v2 == null) break block3;
                }
                catch (RemoteException remoteException2) {}
                v2.Y1(bl);
                return;
                break block4;
            }
            return;
        }
        f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException2);
    }

    public final u w() {
        X0 x02;
        block3: {
            X0 x03 = null;
            V v2 = this.j;
            x02 = x03;
            if (v2 == null) break block3;
            try {
                x02 = v2.r();
            }
            catch (RemoteException remoteException) {
                f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException);
                x02 = x03;
            }
        }
        return u.e(x02);
    }

    public final void x(o o3) {
        RemoteException remoteException2;
        block4: {
            block3: {
                V v2;
                try {
                    v2 = this.j;
                    if (v2 == null) break block3;
                }
                catch (RemoteException remoteException2) {}
                M1 m12 = new M1(o3);
                v2.S2(m12);
                return;
                break block4;
            }
            return;
        }
        f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException2);
    }

    public final long y() {
        block4: {
            AtomicLong atomicLong = this.p;
            if (atomicLong.get() != 0L) {
                return atomicLong.get();
            }
            V v2 = this.j;
            if (v2 == null) break block4;
            try {
                atomicLong.set(v2.S());
                long l3 = atomicLong.get();
                return l3;
            }
            catch (RemoteException remoteException) {
                f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException);
            }
        }
        return 0L;
    }

    public final void z(long l3) {
        RemoteException remoteException2;
        block4: {
            block3: {
                V v2;
                this.p.set(l3);
                try {
                    v2 = this.j;
                    if (v2 == null) break block3;
                }
                catch (RemoteException remoteException2) {}
                v2.n2(l3);
                return;
                break block4;
            }
            return;
        }
        f1.p.i((String)"#007 Could not call remote method.", (Throwable)remoteException2);
    }
}

