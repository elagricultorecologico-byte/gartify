/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 */
package c3;

import U2.l;
import c3.u0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

final class n0
extends u0 {
    private static final AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(n0.class, (String)"_invoked$volatile");
    private volatile int _invoked$volatile;
    private final l e;

    public n0(l l2) {
        this.e = l2;
        this._invoked$volatile = 0;
    }

    @Override
    public boolean w() {
        return true;
    }

    @Override
    public void x(Throwable throwable) {
        if (n0.f.compareAndSet((Object)this, 0, 1)) {
            this.e.j(throwable);
        }
    }
}

