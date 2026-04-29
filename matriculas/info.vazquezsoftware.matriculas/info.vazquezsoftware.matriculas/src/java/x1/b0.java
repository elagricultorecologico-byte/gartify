/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.os.Message
 *  android.os.StrictMode
 *  android.os.StrictMode$VmPolicy
 *  com.google.android.gms.common.util.v
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Objects
 *  java.util.concurrent.Executor
 */
package x1;

import A1.a;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.StrictMode;
import com.google.android.gms.common.util.v;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import u1.b;
import x1.M;
import x1.O;
import x1.a0;
import x1.d0;
import x1.e0;

final class b0
implements ServiceConnection,
e0 {
    private final Map a;
    private int b;
    private boolean c;
    private IBinder d;
    private final a0 e;
    private ComponentName f;
    final d0 g;

    public b0(d0 d02, a0 a02) {
        Objects.requireNonNull((Object)d02);
        this.g = d02;
        this.e = a02;
        this.a = new HashMap();
        this.b = 2;
    }

    public final void a(String object) {
        object = this.e;
        d0 d02 = this.g;
        d02.h().removeMessages(1, object);
        d02.i().c(d02.g(), this);
        this.c = false;
        this.b = 2;
    }

    public final void b(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String string) {
        this.a.put((Object)serviceConnection, (Object)serviceConnection2);
    }

    public final void c(ServiceConnection serviceConnection, String string) {
        this.a.remove((Object)serviceConnection);
    }

    public final boolean d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f(ServiceConnection serviceConnection) {
        return this.a.containsKey((Object)serviceConnection);
    }

    public final boolean g() {
        return this.a.isEmpty();
    }

    public final IBinder h() {
        return this.d;
    }

    public final ComponentName i() {
        return this.f;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final /* synthetic */ b j(String object, Executor executor) {
        void var1_3;
        StrictMode.VmPolicy vmPolicy;
        block11: {
            block10: {
                d0 d02;
                block9: {
                    Intent intent = O.a(this.g.g(), this.e);
                    this.b = 3;
                    vmPolicy = v.a();
                    d02 = this.g;
                    a a2 = d02.i();
                    Context context = d02.g();
                    a0 a02 = this.e;
                    try {
                        boolean bl;
                        this.c = bl = a2.d(context, (String)object, intent, this, 4225, executor);
                        if (!bl) break block9;
                        object = d02.h().obtainMessage(1, (Object)a02);
                        d02.h().sendMessageDelayed((Message)object, d02.j());
                        object = u1.b.l;
                    }
                    catch (Throwable throwable) {}
                    StrictMode.setVmPolicy((StrictMode.VmPolicy)vmPolicy);
                    return object;
                }
                this.b = 2;
                try {
                    d02.i().c(d02.g(), this);
                    break block10;
                }
                catch (IllegalArgumentException illegalArgumentException) {}
                catch (Throwable throwable) {}
                break block11;
                catch (M m2) {
                    return m2.g;
                }
            }
            object = new b(16);
            break block11;
            StrictMode.setVmPolicy((StrictMode.VmPolicy)vmPolicy);
            return object;
        }
        StrictMode.setVmPolicy((StrictMode.VmPolicy)vmPolicy);
        throw var1_3;
    }

    public final void onBindingDied(ComponentName componentName) {
        this.onServiceDisconnected(componentName);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        d0 d02 = this.g;
        HashMap hashMap2 = hashMap = d02.f();
        synchronized (hashMap2) {
            try {
                d02.h().removeMessages(1, (Object)this.e);
                this.d = iBinder;
                this.f = componentName;
                d02 = this.a.values().iterator();
                while (true) {
                    if (!d02.hasNext()) {
                        this.b = 1;
                        return;
                    }
                    ((ServiceConnection)d02.next()).onServiceConnected(componentName, iBinder);
                }
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
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        d0 d02 = this.g;
        HashMap hashMap2 = hashMap = d02.f();
        synchronized (hashMap2) {
            try {
                d02.h().removeMessages(1, (Object)this.e);
                this.d = null;
                this.f = componentName;
                d02 = this.a.values().iterator();
                while (true) {
                    if (!d02.hasNext()) {
                        this.b = 2;
                        return;
                    }
                    ((ServiceConnection)d02.next()).onServiceDisconnected(componentName);
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }
}

