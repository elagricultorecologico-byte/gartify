/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  c3.q
 *  java.lang.Object
 *  java.lang.Override
 */
package c3;

import c3.p0;
import c3.q;
import c3.u0;
import c3.v;
import c3.v0;

public class r0
extends v0
implements v {
    private final boolean i;

    public r0(p0 p02) {
        super(true);
        this.R(p02);
        this.i = this.F0();
    }

    private final boolean F0() {
        Object object = this.H();
        object = object instanceof q ? (q)object : null;
        if (object != null) {
            v0 v02 = ((u0)object).v();
            object = v02;
            if (v02 != null) {
                do {
                    if (((v0)object).D()) {
                        return true;
                    }
                    if ((object = (object = ((v0)object).H()) instanceof q ? (q)object : null) == null) break;
                    v02 = ((u0)object).v();
                    object = v02;
                } while (v02 != null);
            }
        }
        return false;
    }

    @Override
    public boolean D() {
        return this.i;
    }

    @Override
    public boolean E() {
        return true;
    }
}

