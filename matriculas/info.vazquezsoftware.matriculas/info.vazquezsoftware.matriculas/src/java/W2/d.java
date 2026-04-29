/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 */
package w2;

import w2.f;

public final class d
implements Runnable {
    public final f.a g;
    public final int h;

    public /* synthetic */ d(f.a a2, int n2) {
        this.g = a2;
        this.h = n2;
    }

    public final void run() {
        f.e(this.g, this.h);
    }
}

