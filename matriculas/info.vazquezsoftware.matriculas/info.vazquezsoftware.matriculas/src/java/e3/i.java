/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicReferenceArray
 */
package e3;

import java.util.concurrent.atomic.AtomicReferenceArray;

public abstract class i {
    public static /* synthetic */ boolean a(AtomicReferenceArray atomicReferenceArray, int n2, Object object, Object object2) {
        do {
            if (!atomicReferenceArray.compareAndSet(n2, object, object2)) continue;
            return true;
        } while (atomicReferenceArray.get(n2) == object);
        return false;
    }
}

