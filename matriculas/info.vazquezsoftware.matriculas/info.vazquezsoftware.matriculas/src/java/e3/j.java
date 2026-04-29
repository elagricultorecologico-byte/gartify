/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicReferenceArray
 */
package e3;

import U2.l;
import V2.k;
import c3.N0;
import e3.d;
import e3.e;
import e3.i;
import e3.p;
import h3.A;
import h3.w;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class j
extends A {
    private final d e;
    private final AtomicReferenceArray f;

    public j(long l2, j j2, d d2, int n2) {
        super(l2, j2, n2);
        this.e = d2;
        this.f = new AtomicReferenceArray(e3.e.b * 2);
    }

    private final void E(int n2, Object object) {
        this.z().set(n2 * 2, object);
    }

    private final /* synthetic */ AtomicReferenceArray z() {
        return this.f;
    }

    public final Object A(int n2) {
        return this.z().get(n2 * 2);
    }

    public final Object B(int n2) {
        return this.z().get(n2 * 2 + 1);
    }

    public final void C(int n2, boolean bl) {
        if (bl) {
            this.y().O0(this.c * (long)e3.e.b + (long)n2);
        }
        this.t();
    }

    public final Object D(int n2) {
        Object object = this.A(n2);
        this.w(n2);
        return object;
    }

    public final void F(int n2, Object object) {
        this.z().set(n2 * 2 + 1, object);
    }

    public final void G(int n2, Object object) {
        this.E(n2, object);
    }

    @Override
    public int r() {
        return e3.e.b;
    }

    @Override
    public void s(int n2, Throwable object, L2.i i2) {
        block8: {
            int n3 = e3.e.b;
            boolean bl = n2 >= n3;
            int n4 = n2;
            if (bl) {
                n4 = n2 - n3;
            }
            Object object2 = this.A(n4);
            while (true) {
                Object object3;
                if (!((object3 = this.B(n4)) instanceof N0) && !(object3 instanceof p)) {
                    if (object3 != e3.e.j() && object3 != e3.e.i()) {
                        if (object3 == e3.e.o() || object3 == e3.e.p()) continue;
                        if (object3 != e3.e.f() && object3 != e3.e.d && object3 != e3.e.y()) {
                            object = new StringBuilder();
                            object.append("unexpected state: ");
                            object.append(object3);
                            throw new IllegalStateException(object.toString().toString());
                        }
                    } else {
                        this.w(n4);
                        if (bl && (object = this.y().c) != null) {
                            w.a((l)object, object2, i2);
                            return;
                        }
                    }
                    break block8;
                }
                object = bl ? e3.e.j() : e3.e.i();
                if (this.v(n4, object3, object)) break;
            }
            this.w(n4);
            this.C(n4, bl ^ true);
            if (bl && (object = this.y().c) != null) {
                w.a((l)object, object2, i2);
            }
        }
    }

    public final boolean v(int n2, Object object, Object object2) {
        return i.a(this.z(), n2 * 2 + 1, object, object2);
    }

    public final void w(int n2) {
        this.E(n2, null);
    }

    public final Object x(int n2, Object object) {
        return this.z().getAndSet(n2 * 2 + 1, object);
    }

    public final d y() {
        d d2 = this.e;
        k.b(d2);
        return d2;
    }
}

