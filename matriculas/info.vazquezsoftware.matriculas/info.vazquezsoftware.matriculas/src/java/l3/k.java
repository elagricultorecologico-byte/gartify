/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicReferenceArray
 */
package l3;

import L2.i;
import h3.A;
import java.util.concurrent.atomic.AtomicReferenceArray;
import l3.j;

final class k
extends A {
    private final AtomicReferenceArray e = new AtomicReferenceArray(j.f());

    public k(long l2, k k2, int n2) {
        super(l2, k2, n2);
    }

    @Override
    public int r() {
        return j.f();
    }

    @Override
    public void s(int n2, Throwable object, i i2) {
        object = j.c();
        this.v().set(n2, object);
        this.t();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SemaphoreSegment[id=");
        stringBuilder.append(this.c);
        stringBuilder.append(", hashCode=");
        stringBuilder.append(this.hashCode());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final /* synthetic */ AtomicReferenceArray v() {
        return this.e;
    }
}

