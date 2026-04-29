/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  h3.l
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
package c3;

import I2.h;
import c3.F;
import c3.U;
import h3.l;

public abstract class a0
extends F {
    private long i;
    private boolean j;
    private h k;

    private final long O0(boolean bl) {
        if (bl) {
            return 0x100000000L;
        }
        return 1L;
    }

    public static /* synthetic */ void S0(a0 a02, boolean bl, int n3, Object object) {
        if (object == null) {
            if ((n3 & 1) != 0) {
                bl = false;
            }
            a02.R0(bl);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    @Override
    public final F L0(int n3, String string) {
        l.a((int)n3);
        return l.b((F)this, (String)string);
    }

    public final void N0(boolean bl) {
        long l3;
        this.i = l3 = this.i - this.O0(bl);
        if (l3 <= 0L && this.j) {
            this.shutdown();
        }
    }

    public final void P0(U u2) {
        h h3;
        h h4 = h3 = this.k;
        if (h3 == null) {
            this.k = h4 = new h();
        }
        h4.addLast(u2);
    }

    protected long Q0() {
        h h3 = this.k;
        if (h3 == null) {
            return Long.MAX_VALUE;
        }
        if (h3.isEmpty()) {
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final void R0(boolean bl) {
        this.i += this.O0(bl);
        if (!bl) {
            this.j = true;
        }
    }

    public final boolean T0() {
        return this.i >= this.O0(true);
    }

    public final boolean U0() {
        h h3 = this.k;
        if (h3 != null) {
            return h3.isEmpty();
        }
        return true;
    }

    public final boolean V0() {
        Object object = this.k;
        if (object == null) {
            return false;
        }
        if ((object = (U)object.q()) == null) {
            return false;
        }
        ((U)object).run();
        return true;
    }

    public abstract void shutdown();
}

