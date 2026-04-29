/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  c3.z
 *  h3.i
 *  java.lang.Object
 *  java.lang.Override
 */
package h3;

import M2.b;
import N2.e;
import c3.a;
import h3.i;

public class z
extends a
implements e {
    public final L2.e j;

    public z(L2.i i3, L2.e e3) {
        super(i3, true, true);
        this.j = e3;
    }

    @Override
    protected void F0(Object object) {
        L2.e e3 = this.j;
        e3.e(c3.z.a((Object)object, (L2.e)e3));
    }

    @Override
    protected final boolean U() {
        return true;
    }

    @Override
    public final e b() {
        L2.e e3 = this.j;
        if (e3 instanceof e) {
            return (e)((Object)e3);
        }
        return null;
    }

    @Override
    protected void j(Object object) {
        i.b((L2.e)b.c(this.j), (Object)c3.z.a((Object)object, (L2.e)this.j));
    }
}

