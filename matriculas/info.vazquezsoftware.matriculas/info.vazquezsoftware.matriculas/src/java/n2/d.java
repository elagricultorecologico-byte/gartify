/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  V2.k
 *  java.lang.Object
 *  java.lang.Override
 */
package N2;

import L2.e;
import L2.f;
import L2.i;
import N2.a;
import N2.c;
import V2.k;

public abstract class d
extends a {
    private final i h;
    private transient e i;

    public d(e e2) {
        i i2 = e2 != null ? e2.getContext() : null;
        this(e2, i2);
    }

    public d(e e2, i i2) {
        super(e2);
        this.h = i2;
    }

    @Override
    public i getContext() {
        i i2 = this.h;
        k.b((Object)i2);
        return i2;
    }

    @Override
    protected void p() {
        e e2 = this.i;
        if (e2 != null && e2 != this) {
            i.b b2 = this.getContext().i(f.a);
            k.b((Object)b2);
            ((f)b2).a0(e2);
        }
        this.i = c.g;
    }

    public final e q() {
        Object object;
        block2: {
            block4: {
                block3: {
                    e e2 = this.i;
                    object = e2;
                    if (e2 != null) break block2;
                    object = (f)this.getContext().i(f.a);
                    if (object == null) break block3;
                    e2 = object.i0(this);
                    object = e2;
                    if (e2 != null) break block4;
                }
                object = this;
            }
            this.i = object;
        }
        return object;
    }
}

