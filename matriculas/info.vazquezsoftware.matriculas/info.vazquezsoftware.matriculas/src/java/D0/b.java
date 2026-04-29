/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Runnable
 *  java.util.concurrent.Executor
 */
package D0;

import C0.k;
import D0.a;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class b
implements a {
    private final k a;
    private final Handler b = new Handler(Looper.getMainLooper());
    private final Executor c = new Executor(this){
        final b g;
        {
            this.g = b2;
        }

        public void execute(Runnable runnable) {
            this.g.d(runnable);
        }
    };

    public b(Executor executor) {
        this.a = new k(executor);
    }

    @Override
    public Executor a() {
        return this.c;
    }

    @Override
    public void b(Runnable runnable) {
        this.a.execute(runnable);
    }

    @Override
    public k c() {
        return this.a;
    }

    public void d(Runnable runnable) {
        this.b.post(runnable);
    }
}

