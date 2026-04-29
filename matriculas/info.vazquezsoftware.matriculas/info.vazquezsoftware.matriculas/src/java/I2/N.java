/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  i2.t
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Throwable
 */
package i2;

import i2.j;
import i2.t;

final class n
extends j {
    final t h;

    n(t t2) {
        this.h = t2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void a() {
        Object object;
        Object object2 = object = t.g((t)this.h);
        synchronized (object2) {
            Throwable throwable2;
            block5: {
                try {
                    if (t.i((t)this.h).get() > 0 && t.i((t)this.h).decrementAndGet() > 0) {
                        t.f((t)this.h).c("Leaving the connection open for other ongoing calls.", new Object[0]);
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                t t2 = this.h;
                if (t.d((t)t2) != null) {
                    t.f((t)t2).c("Unbind from service.", new Object[0]);
                    t2 = this.h;
                    t.a((t)t2).unbindService(t.b((t)t2));
                    t.l((t)this.h, (boolean)false);
                    t.m((t)this.h, null);
                    t.k((t)this.h, null);
                }
                t.o((t)this.h);
                return;
            }
            throw throwable2;
        }
    }
}

