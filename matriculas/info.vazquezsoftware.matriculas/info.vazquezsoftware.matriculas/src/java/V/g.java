/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Override
 */
package v;

import v.d;
import v.f;
import v.l;
import v.p;

class g
extends f {
    public int m;

    g(p p2) {
        super(p2);
        if (p2 instanceof l) {
            this.e = f.a.h;
            return;
        }
        this.e = f.a.i;
    }

    @Override
    public void d(int n2) {
        if (!this.j) {
            this.j = true;
            this.g = n2;
            for (d d2 : this.k) {
                d2.a(d2);
            }
        }
    }
}

