/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.concurrent.atomic.AtomicReferenceArray
 */
package h3;

import Y2.d;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class y {
    private volatile AtomicReferenceArray<Object> array;

    public y(int n2) {
        this.array = new AtomicReferenceArray(n2);
    }

    public final int a() {
        return this.array.length();
    }

    public final Object b(int n2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        if (n2 < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(n2);
        }
        return null;
    }

    public final void c(int n2, Object object) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        int n3 = atomicReferenceArray.length();
        if (n2 < n3) {
            atomicReferenceArray.set(n2, object);
            return;
        }
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(d.b(n2 + 1, n3 * 2));
        for (int i2 = 0; i2 < n3; ++i2) {
            atomicReferenceArray2.set(i2, atomicReferenceArray.get(i2));
        }
        atomicReferenceArray2.set(n2, object);
        this.array = atomicReferenceArray2;
    }
}

