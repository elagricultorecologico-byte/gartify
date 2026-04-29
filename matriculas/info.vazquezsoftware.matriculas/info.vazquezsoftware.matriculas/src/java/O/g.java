/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Choreographer$FrameCallback
 *  java.lang.Object
 *  java.lang.Runnable
 */
package O;

import O.c;
import android.view.Choreographer;

public final class g
implements Choreographer.FrameCallback {
    public final Runnable a;

    public /* synthetic */ g(Runnable runnable) {
        this.a = runnable;
    }

    public final void doFrame(long l2) {
        c.f.c(this.a, l2);
    }
}

