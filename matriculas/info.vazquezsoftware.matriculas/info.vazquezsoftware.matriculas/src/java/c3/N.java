/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.CancellationException
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 */
package c3;

import L2.e;
import c3.x;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class n
extends x {
    private static final AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(n.class, (String)"_resumed$volatile");
    private volatile int _resumed$volatile;

    public n(e e2, Throwable throwable, boolean bl) {
        Throwable throwable2 = throwable;
        if (throwable == null) {
            throwable = new StringBuilder();
            throwable.append("Continuation ");
            throwable.append((Object)e2);
            throwable.append(" was cancelled normally");
            throwable2 = new CancellationException(throwable.toString());
        }
        super(throwable2, bl);
        this._resumed$volatile = 0;
    }

    public final boolean e() {
        return n.c.compareAndSet((Object)this, 0, 1);
    }
}

