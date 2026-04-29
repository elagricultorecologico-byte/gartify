/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.AndroidRuntimeException
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.UnsupportedOperationException
 */
package O;

import O.h;
import O.i;
import O.l;
import android.util.AndroidRuntimeException;

public final class k
extends h {
    private l B = null;
    private float C = Float.MAX_VALUE;
    private boolean D = false;

    public k(Object object, i i2) {
        super(object, i2);
    }

    private void o() {
        l l2 = this.B;
        if (l2 != null) {
            double d2 = l2.b();
            if (!(d2 > (double)this.g)) {
                if (!(d2 < (double)this.h)) {
                    return;
                }
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }

    @Override
    public void i() {
        this.o();
        this.B.i(this.e());
        super.i();
    }

    @Override
    boolean k(long l2) {
        float f2;
        if (this.D) {
            float f3 = this.C;
            if (f3 != Float.MAX_VALUE) {
                this.B.g(f3);
                this.C = Float.MAX_VALUE;
            }
            this.b = this.B.b();
            this.a = 0.0f;
            this.D = false;
            return true;
        }
        if (this.C != Float.MAX_VALUE) {
            Object object = this.B;
            double d2 = this.b;
            double d3 = this.a;
            object = ((l)object).j(d2, d3, l2 /= 2L);
            this.B.g(this.C);
            this.C = Float.MAX_VALUE;
            object = this.B.j(((h.o)object).a, ((h.o)object).b, l2);
            this.b = ((h.o)object).a;
            this.a = ((h.o)object).b;
        } else {
            h.o o2 = this.B.j(this.b, this.a, l2);
            this.b = o2.a;
            this.a = o2.b;
        }
        this.b = f2 = Math.max((float)this.b, (float)this.h);
        this.b = f2 = Math.min((float)f2, (float)this.g);
        if (this.n(f2, this.a)) {
            this.b = this.B.b();
            this.a = 0.0f;
            return true;
        }
        return false;
    }

    public void l(float f2) {
        if (this.f()) {
            this.C = f2;
            return;
        }
        if (this.B == null) {
            this.B = new l(f2);
        }
        this.B.g(f2);
        this.i();
    }

    public boolean m() {
        return this.B.b > 0.0;
    }

    boolean n(float f2, float f3) {
        return this.B.e(f2, f3);
    }

    public k p(l l2) {
        this.B = l2;
        return this;
    }

    public void q() {
        if (this.m()) {
            if (this.c().j()) {
                if (this.f) {
                    this.D = true;
                }
                return;
            }
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        }
        throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
    }
}

