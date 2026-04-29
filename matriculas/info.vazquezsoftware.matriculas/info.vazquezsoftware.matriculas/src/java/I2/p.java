/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 */
package i2;

import android.os.IBinder;
import i2.e;
import i2.f;
import i2.j;
import i2.r;
import i2.t;

final class p
extends j {
    final IBinder h;
    final r i;

    p(r r2, IBinder iBinder) {
        this.h = iBinder;
        this.i = r2;
    }

    @Override
    public final void a() {
        f f2 = e.Z(this.h);
        t.m(this.i.a, f2);
        t.q(this.i.a);
        t.l(this.i.a, false);
        f2 = t.h(this.i.a).iterator();
        while (f2.hasNext()) {
            ((Runnable)f2.next()).run();
        }
        t.h(this.i.a).clear();
    }
}

