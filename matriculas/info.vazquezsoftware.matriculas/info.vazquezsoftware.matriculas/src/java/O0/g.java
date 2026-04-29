/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package O0;

import H0.o;
import O0.r;

public final class g
implements Runnable {
    public final r g;
    public final o h;
    public final int i;
    public final Runnable j;

    public /* synthetic */ g(r r2, o o2, int n2, Runnable runnable) {
        this.g = r2;
        this.h = o2;
        this.i = n2;
        this.j = runnable;
    }

    public final void run() {
        r.i(this.g, this.h, this.i, this.j);
    }
}

