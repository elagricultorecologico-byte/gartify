/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 */
package w2;

import w2.f;

public final class e
implements Runnable {
    public final f.a g;
    public final Exception h;

    public /* synthetic */ e(f.a a2, Exception exception) {
        this.g = a2;
        this.h = exception;
    }

    public final void run() {
        f.d(this.g, this.h);
    }
}

