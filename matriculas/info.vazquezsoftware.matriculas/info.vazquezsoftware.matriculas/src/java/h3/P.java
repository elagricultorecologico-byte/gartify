/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.b
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicReferenceFieldUpdater
 */
package h3;

import androidx.concurrent.futures.b;
import h3.q;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class p {
    private static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, (String)"_cur$volatile");
    private volatile Object _cur$volatile;

    public p(boolean bl) {
        this._cur$volatile = new q(8, bl);
    }

    public final boolean a(Object object) {
        q q2;
        int n2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = p.a;
        while ((n2 = (q2 = (q)atomicReferenceFieldUpdater.get((Object)this)).a(object)) != 0) {
            if (n2 != 1) {
                if (n2 != 2) continue;
                return false;
            }
            b.a((AtomicReferenceFieldUpdater)p.a, (Object)this, (Object)q2, (Object)q2.l());
        }
        return true;
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = p.a;
        q q2;
        while (!(q2 = (q)atomicReferenceFieldUpdater.get((Object)this)).d()) {
            b.a((AtomicReferenceFieldUpdater)p.a, (Object)this, (Object)q2, (Object)q2.l());
        }
        return;
    }

    public final int c() {
        return ((q)p.a.get((Object)this)).g();
    }

    public final Object e() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = p.a;
        q q2;
        Object object;
        while ((object = (q2 = (q)atomicReferenceFieldUpdater.get((Object)this)).m()) == q.h) {
            b.a((AtomicReferenceFieldUpdater)p.a, (Object)this, (Object)q2, (Object)q2.l());
        }
        return object;
    }
}

