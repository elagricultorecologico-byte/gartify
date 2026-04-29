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

final class m
extends j {
    final L1.j h;
    final j i;
    final t j;

    m(t t2, L1.j j2, L1.j j3, j j4) {
        this.h = j3;
        this.i = j4;
        this.j = t2;
        super(j2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void a() {
        Object object;
        Object object2 = object = t.g((t)this.j);
        synchronized (object2) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        t.n((t)this.j, (L1.j)this.h);
                        if (t.i((t)this.j).getAndIncrement() <= 0) break block3;
                        t.f((t)this.j).c("Already connected to the service.", new Object[0]);
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                t.p((t)this.j, (j)this.i);
                return;
            }
            throw throwable2;
        }
    }
}

