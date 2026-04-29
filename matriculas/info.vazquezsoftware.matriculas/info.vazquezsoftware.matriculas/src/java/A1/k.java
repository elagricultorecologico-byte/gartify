/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.View
 *  com.google.android.gms.internal.ads.Fu
 *  com.google.android.gms.internal.ads.Hj0
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Oi0
 *  com.google.android.gms.internal.ads.Pe
 *  com.google.android.gms.internal.ads.Uy0
 *  com.google.android.gms.internal.ads.Yc
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.ab
 *  com.google.android.gms.internal.ads.bb
 *  com.google.android.gms.internal.ads.ed
 *  com.google.android.gms.internal.ads.hd
 *  com.google.android.gms.internal.ads.ld
 *  com.google.android.gms.internal.ads.mj0
 *  com.google.android.gms.internal.ads.nj0
 *  e1.F0
 *  e1.o0
 *  f1.a
 *  f1.g
 *  f1.p
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.Vector
 *  java.util.concurrent.Callable
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.ExecutionException
 *  java.util.concurrent.Executor
 *  java.util.concurrent.Executors
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.TimeoutException
 *  java.util.concurrent.atomic.AtomicReference
 */
package a1;

import a1.h;
import a1.i;
import a1.j;
import a1.t;
import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import b1.A;
import b1.x;
import com.google.android.gms.internal.ads.Fu;
import com.google.android.gms.internal.ads.Hj0;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Oi0;
import com.google.android.gms.internal.ads.Pe;
import com.google.android.gms.internal.ads.Uy0;
import com.google.android.gms.internal.ads.Yc;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.ab;
import com.google.android.gms.internal.ads.bb;
import com.google.android.gms.internal.ads.ed;
import com.google.android.gms.internal.ads.hd;
import com.google.android.gms.internal.ads.ld;
import com.google.android.gms.internal.ads.mj0;
import com.google.android.gms.internal.ads.nj0;
import e1.F0;
import e1.o0;
import f1.g;
import f1.p;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import l2.a;

public final class k
implements Runnable,
hd {
    private static final long v = System.currentTimeMillis();
    private final List g = new Vector();
    private final AtomicReference h = new AtomicReference();
    private final AtomicReference i = new AtomicReference();
    protected boolean j;
    private final boolean k;
    private final boolean l;
    private final Executor m;
    private final Oi0 n;
    private Context o;
    private final Context p;
    private f1.a q;
    private final f1.a r;
    private final boolean s;
    final CountDownLatch t = new CountDownLatch(1);
    private int u;

    public k(Context context, f1.a a3) {
        boolean bl;
        this.o = context;
        this.p = context;
        this.q = a3;
        this.r = a3;
        a3 = Executors.newCachedThreadPool();
        this.m = a3;
        Oi oi = Yi.n3;
        this.s = bl = ((Boolean)A.c().d(oi)).booleanValue();
        this.n = Oi0.a((Context)context, (Executor)a3, (boolean)bl);
        context = Yi.k3;
        this.k = (Boolean)A.c().d((Oi)context);
        context = Yi.o3;
        this.l = (Boolean)A.c().d((Oi)context);
        context = Yi.m3;
        this.u = (Boolean)A.c().d((Oi)context) != false ? 2 : 1;
        context = Yi.p4;
        if (!((Boolean)A.c().d((Oi)context)).booleanValue()) {
            this.j = this.m();
        }
        context = Yi.m4;
        if (((Boolean)A.c().d((Oi)context)).booleanValue()) {
            Fu.a.execute((Runnable)this);
            return;
        }
        x.a();
        if (f1.g.b()) {
            Fu.a.execute((Runnable)this);
            return;
        }
        this.run();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void q() {
        List list = this.g;
        hd hd2 = this.s();
        if (list.isEmpty()) return;
        if (hd2 == null) {
            return;
        }
        list = list.iterator();
        while (true) {
            if (!list.hasNext()) {
                this.g.clear();
                return;
            }
            Object[] objectArray = (Object[])list.next();
            try {
                int n3 = objectArray.length;
                if (n3 == 1) {
                    hd2.h((MotionEvent)objectArray[0]);
                    continue;
                }
                if (n3 != 3) continue;
                hd2.c(((Integer)objectArray[0]).intValue(), ((Integer)objectArray[1]).intValue(), ((Integer)objectArray[2]).intValue());
            }
            catch (NullPointerException nullPointerException) {
            }
        }
    }

    private final void r(boolean bl) {
        String string = this.q.g;
        Context context = a1.k.t(this.o);
        ab ab2 = bb.h0();
        ab2.B(bl);
        ab2.A(string);
        context = ld.x((Context)context, (bb)((bb)ab2.w()));
        this.h.set((Object)context);
    }

    private final hd s() {
        if (this.p() == 2) {
            return (hd)this.i.get();
        }
        return (hd)this.h.get();
    }

    private static final Context t(Context context) {
        Context context2 = context.getApplicationContext();
        if (context2 == null) {
            return context;
        }
        return context2;
    }

    private static final ed u(Context context, f1.a a3, boolean bl, boolean bl2) {
        ab ab2 = bb.h0();
        ab2.B(bl);
        ab2.A(a3.g);
        a3 = (bb)ab2.w();
        return ed.a((Context)a1.k.t(context), (bb)a3, (boolean)bl2);
    }

    public final boolean a() {
        try {
            this.t.await();
            return true;
        }
        catch (InterruptedException interruptedException) {
            int n3 = o0.b;
            f1.p.g((String)"Interrupted during GADSignals creation.", (Throwable)interruptedException);
            return false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final String b(Context object, byte[] object2) {
        if (!this.a()) return "";
        hd hd2 = this.s();
        if (hd2 == null) return "";
        this.q();
        try {
            return hd2.f(a1.k.t(object));
        }
        catch (NullPointerException nullPointerException) {
            return "";
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void c(int n3, int n4, int n5) {
        hd hd2 = this.s();
        if (hd2 == null) {
            this.g.add((Object)new Object[]{n3, n4, n5});
            return;
        }
        this.q();
        try {
            hd2.c(n3, n4, n5);
            return;
        }
        catch (NullPointerException nullPointerException) {
            return;
        }
    }

    public final String d(Context context) {
        a a3 = Uy0.d((Callable)new j(this, context), (Executor)this.m);
        try {
            Object object = Yi.B3;
            object = (String)a3.get(((Integer)A.c().d(object)).intValue(), TimeUnit.MILLISECONDS);
            return object;
        }
        catch (TimeoutException timeoutException) {
            return Yc.a((Context)context, (String)this.r.g, (long)v, (boolean)true);
        }
        catch (InterruptedException | ExecutionException throwable) {
            return Integer.toString((int)17);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void e(StackTraceElement[] stackTraceElementArray) {
        Oi oi = Yi.H3;
        if (((Boolean)A.c().d(oi)).booleanValue()) {
            if (this.t.getCount() != 0L) return;
            oi = this.s();
            if (oi == null) return;
            try {
                oi.e(stackTraceElementArray);
                return;
            }
            catch (NullPointerException nullPointerException) {
                return;
            }
        }
        if (!this.a()) return;
        oi = this.s();
        if (oi == null) return;
        {
            oi.e(stackTraceElementArray);
            return;
        }
    }

    public final String f(Context context) {
        return this.b(context, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void g(View view) {
        hd hd2 = this.s();
        if (hd2 == null) return;
        try {
            hd2.g(view);
            return;
        }
        catch (NullPointerException nullPointerException) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void h(MotionEvent motionEvent) {
        hd hd2 = this.s();
        if (hd2 == null) {
            this.g.add((Object)new Object[]{motionEvent});
            return;
        }
        this.q();
        try {
            hd2.h(motionEvent);
            return;
        }
        catch (NullPointerException nullPointerException) {
            return;
        }
    }

    public final String i(Context context, String string, View view) {
        return this.j(context, string, view, null);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final String j(Context object, String string, View view, Activity activity) {
        void var3_5;
        if (!this.a()) return "";
        hd hd2 = this.s();
        Oi oi = Yi.bc;
        if (((Boolean)A.c().d(oi)).booleanValue()) {
            a1.t.g();
            F0.m((View)var3_5, (int)4, null);
        }
        if (hd2 == null) return "";
        this.q();
        try {
            void var4_6;
            void var2_4;
            return hd2.j(a1.k.t(object), (String)var2_4, (View)var3_5, (Activity)var4_6);
        }
        catch (NullPointerException nullPointerException) {
            return "";
        }
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final String k(Context object, View view, Activity activity) {
        void var3_6;
        void var2_5;
        Oi oi = Yi.ac;
        if (((Boolean)A.c().d(oi)).booleanValue()) {
            if (!this.a()) return "";
            hd hd2 = this.s();
            oi = Yi.bc;
            if (((Boolean)A.c().d(oi)).booleanValue()) {
                a1.t.g();
                F0.m((View)var2_5, (int)2, null);
            }
            if (hd2 == null) return "";
            return hd2.k(object, (View)var2_5, (Activity)var3_6);
        }
        oi = this.s();
        Oi oi2 = Yi.bc;
        if (((Boolean)A.c().d(oi2)).booleanValue()) {
            a1.t.g();
            F0.m((View)var2_5, (int)2, null);
        }
        if (oi == null) return "";
        try {
            return oi.k(object, (View)var2_5, (Activity)var3_6);
        }
        catch (NullPointerException nullPointerException) {
            return "";
        }
    }

    public final String l() {
        int n3 = this.u;
        if (n3 != 0) {
            if (n3 - 1 != 0) {
                return "2";
            }
            return "1";
        }
        throw null;
    }

    protected final boolean m() {
        Context context = this.o;
        h h3 = new h(this);
        Oi0 oi0 = this.n;
        Context context2 = this.o;
        context = mj0.b((Context)context, (Oi0)oi0);
        oi0 = Yi.l3;
        return new Hj0(context2, (Pe)context, (nj0)h3, ((Boolean)A.c().d((Oi)oi0)).booleanValue()).d(1);
    }

    final /* synthetic */ void n(boolean bl) {
        long l3 = System.currentTimeMillis();
        try {
            a1.k.u(this.p, this.r, bl, this.s).m();
            return;
        }
        catch (NullPointerException nullPointerException) {
            this.n.c(2027, System.currentTimeMillis() - l3, (Exception)((Object)nullPointerException));
            return;
        }
    }

    final /* synthetic */ Oi0 o() {
        return this.n;
    }

    protected final int p() {
        if (this.k && !this.j) {
            return 1;
        }
        return this.u;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Throwable throwable2;
        block11: {
            boolean bl;
            Oi oi;
            block10: {
                try {
                    oi = Yi.p4;
                    if (!((Boolean)A.c().d(oi)).booleanValue()) break block10;
                    this.j = this.m();
                }
                catch (Throwable throwable2) {
                    break block11;
                }
            }
            boolean bl2 = this.q.j;
            oi = Yi.I1;
            boolean bl3 = (Boolean)A.c().d(oi);
            boolean bl4 = bl = false;
            if (!bl3) {
                bl4 = bl;
                if (bl2) {
                    bl4 = true;
                }
            }
            if (this.p() == 1) {
                this.r(bl4);
                if (this.u == 2) {
                    oi = this.m;
                    i i3 = new i(this, bl4);
                    oi.execute((Runnable)i3);
                }
            } else {
                long l3 = System.currentTimeMillis();
                try {
                    oi = a1.k.u(this.o, this.q, bl4, this.s);
                    this.i.set((Object)oi);
                    if (this.l && !oi.b()) {
                        this.u = 1;
                        this.r(bl4);
                    }
                }
                catch (NullPointerException nullPointerException) {
                    this.u = 1;
                    this.r(bl4);
                    this.n.c(2031, System.currentTimeMillis() - l3, (Exception)((Object)nullPointerException));
                }
            }
            this.t.countDown();
            this.o = null;
            this.q = null;
            return;
        }
        this.t.countDown();
        this.o = null;
        this.q = null;
        throw throwable2;
    }
}

