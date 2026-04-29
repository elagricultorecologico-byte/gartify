/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicIntegerFieldUpdater
 */
package c3;

import V2.g;
import c3.M;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class x {
    private static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(x.class, (String)"_handled$volatile");
    private volatile int _handled$volatile;
    public final Throwable a;

    public x(Throwable throwable, boolean bl) {
        this.a = throwable;
        this._handled$volatile = bl ? 1 : 0;
    }

    public /* synthetic */ x(Throwable throwable, boolean bl, int n2, g g2) {
        if ((n2 & 2) != 0) {
            bl = false;
        }
        this(throwable, bl);
    }

    public final boolean a() {
        return x.b.get((Object)this) != 0;
    }

    public final boolean c() {
        return x.b.compareAndSet((Object)this, 0, 1);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(M.a(this));
        stringBuilder.append('[');
        stringBuilder.append((Object)this.a);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

