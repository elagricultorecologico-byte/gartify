/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.concurrent.Executor
 */
package w1;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class t
implements Executor {
    public final Handler g;

    public /* synthetic */ t(Handler handler) {
        this.g = handler;
    }

    public final void execute(Runnable runnable) {
        this.g.post(runnable);
    }
}

