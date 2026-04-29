/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Throwable
 */
package c3;

import L2.e;
import M2.b;
import c3.p0;
import c3.s;
import c3.v0;
import c3.x;

final class t
extends v0
implements s {
    public t(p0 p02) {
        super(true);
        this.R(p02);
    }

    @Override
    public boolean E() {
        return true;
    }

    @Override
    public boolean L(Throwable throwable) {
        return this.W(new x(throwable, false, 2, null));
    }

    @Override
    public boolean P(Object object) {
        return this.W(object);
    }

    @Override
    public Object k0(e object) {
        object = this.m((e)object);
        b.e();
        return object;
    }

    @Override
    public Object p() {
        return this.z();
    }
}

