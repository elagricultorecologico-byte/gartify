/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.IBinder$DeathRecipient
 *  android.os.IInterface
 *  android.os.RemoteException
 *  androidx.appcompat.app.E
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicInteger
 */
package i2;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.appcompat.app.E;
import i2.i;
import i2.j;
import i2.k;
import i2.l;
import i2.m;
import i2.n;
import i2.o;
import i2.r;
import i2.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class t {
    private static final Map n = new HashMap();
    private final Context a;
    private final i b;
    private final String c;
    private final List d = new ArrayList();
    private final Set e = new HashSet();
    private final Object f = new Object();
    private boolean g;
    private final Intent h;
    private final WeakReference i;
    private final IBinder.DeathRecipient j = new k(this);
    private final AtomicInteger k = new AtomicInteger(0);
    private ServiceConnection l;
    private IInterface m;

    public t(Context context, i i2, String string, Intent intent, h2.i i3, o o2) {
        this.a = context;
        this.b = i2;
        this.c = "com.google.android.finsky.inappreviewservice.InAppReviewService";
        this.h = intent;
        this.i = new WeakReference(null);
    }

    static /* bridge */ /* synthetic */ Context a(t t2) {
        return t2.a;
    }

    static /* bridge */ /* synthetic */ ServiceConnection b(t t2) {
        return t2.l;
    }

    static /* bridge */ /* synthetic */ IInterface d(t t2) {
        return t2.m;
    }

    static /* bridge */ /* synthetic */ i f(t t2) {
        return t2.b;
    }

    static /* bridge */ /* synthetic */ Object g(t t2) {
        return t2.f;
    }

    static /* bridge */ /* synthetic */ List h(t t2) {
        return t2.d;
    }

    static /* bridge */ /* synthetic */ AtomicInteger i(t t2) {
        return t2.k;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void j(t t2) {
        t2.b.c("reportBinderDeath", new Object[0]);
        E.a((Object)t2.i.get());
        t2.b.c("%s : Binder has died.", t2.c);
        Object object = t2.d.iterator();
        while (true) {
            if (!object.hasNext()) {
                t2.d.clear();
                Object object2 = object = t2.f;
                synchronized (object2) {
                    t2.w();
                    return;
                }
            }
            ((j)object.next()).c((Exception)t2.v());
        }
    }

    static /* bridge */ /* synthetic */ void k(t t2, ServiceConnection serviceConnection) {
        t2.l = null;
    }

    static /* bridge */ /* synthetic */ void l(t t2, boolean bl) {
        t2.g = false;
    }

    static /* bridge */ /* synthetic */ void m(t t2, IInterface iInterface) {
        t2.m = iInterface;
    }

    static /* bridge */ /* synthetic */ void n(t t2, L1.j j2) {
        t2.e.add((Object)j2);
        j2.a().b(new l(t2, j2));
    }

    static /* bridge */ /* synthetic */ void o(t t2) {
        t2.w();
    }

    static /* bridge */ /* synthetic */ void p(t t2, j object) {
        if (t2.m == null && !t2.g) {
            t2.b.c("Initiate binding to the service.", new Object[0]);
            t2.d.add(object);
            object = new r(t2, null);
            t2.l = object;
            t2.g = true;
            if (!t2.a.bindService(t2.h, (ServiceConnection)object, 1)) {
                t2.b.c("Failed to bind to the service.", new Object[0]);
                t2.g = false;
                object = t2.d.iterator();
                while (object.hasNext()) {
                    ((j)object.next()).c((Exception)new u());
                }
                t2.d.clear();
            }
            return;
        }
        if (t2.g) {
            t2.b.c("Waiting to bind to the service.", new Object[0]);
            t2.d.add(object);
            return;
        }
        ((j)object).run();
    }

    static /* bridge */ /* synthetic */ void q(t t2) {
        t2.b.c("linkToDeath", new Object[0]);
        try {
            t2.m.asBinder().linkToDeath(t2.j, 0);
            return;
        }
        catch (RemoteException remoteException) {
            t2.b.b(remoteException, "linkToDeath failed", new Object[0]);
            return;
        }
    }

    static /* bridge */ /* synthetic */ void r(t t2) {
        t2.b.c("unlinkToDeath", new Object[0]);
        t2.m.asBinder().unlinkToDeath(t2.j, 0);
    }

    private final RemoteException v() {
        return new RemoteException(String.valueOf((Object)this.c).concat(" : Binder has died."));
    }

    private final void w() {
        Iterator iterator = this.e.iterator();
        while (iterator.hasNext()) {
            ((L1.j)iterator.next()).d((Exception)this.v());
        }
        this.e.clear();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Handler c() {
        Map map;
        Map map2 = map = n;
        synchronized (map2) {
            try {
                if (map.containsKey((Object)this.c)) return (Handler)map.get((Object)this.c);
                HandlerThread handlerThread = new HandlerThread(this.c, 10);
                handlerThread.start();
                Object object = this.c;
                Handler handler = new Handler(handlerThread.getLooper());
                map.put(object, (Object)handler);
                return (Handler)map.get((Object)this.c);
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public final IInterface e() {
        return this.m;
    }

    public final void s(j j2, L1.j j3) {
        j2 = new m(this, j2.b(), j3, j2);
        this.c().post((Runnable)j2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final /* synthetic */ void t(L1.j j2, L1.i object) {
        Object object2 = object = this.f;
        synchronized (object2) {
            this.e.remove((Object)j2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void u(L1.j object) {
        Object object2;
        Object object3 = object2 = this.f;
        synchronized (object3) {
            this.e.remove(object);
        }
        object = new n(this);
        this.c().post((Runnable)object);
    }
}

