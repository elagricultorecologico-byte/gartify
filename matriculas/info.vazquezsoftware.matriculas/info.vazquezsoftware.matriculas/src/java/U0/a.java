/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  androidx.core.os.g
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 */
package u0;

import android.os.Handler;
import android.os.Looper;
import androidx.core.os.g;
import t0.q;

public class a
implements q {
    private final Handler a = g.a((Looper)Looper.getMainLooper());

    @Override
    public void a(long l2, Runnable runnable) {
        this.a.postDelayed(runnable, l2);
    }

    @Override
    public void b(Runnable runnable) {
        this.a.removeCallbacks(runnable);
    }
}

