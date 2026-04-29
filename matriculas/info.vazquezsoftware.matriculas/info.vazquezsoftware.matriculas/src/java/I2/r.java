/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  java.lang.Object
 *  java.lang.Runnable
 */
package i2;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import i2.p;
import i2.q;
import i2.s;
import i2.t;

final class r
implements ServiceConnection {
    final t a;

    /* synthetic */ r(t t2, s s2) {
        this.a = t2;
    }

    public final void onServiceConnected(ComponentName object, IBinder iBinder) {
        t.f(this.a).c("ServiceConnectionImpl.onServiceConnected(%s)", object);
        object = new p(this, iBinder);
        this.a.c().post((Runnable)object);
    }

    public final void onServiceDisconnected(ComponentName object) {
        t.f(this.a).c("ServiceConnectionImpl.onServiceDisconnected(%s)", object);
        object = new q(this);
        this.a.c().post((Runnable)object);
    }
}

