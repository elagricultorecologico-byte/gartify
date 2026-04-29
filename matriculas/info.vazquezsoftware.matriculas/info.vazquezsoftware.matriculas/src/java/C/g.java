/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Thread
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.ForkJoinPool
 *  java.util.concurrent.TimeUnit
 */
package C;

import android.os.Build;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public abstract class g {
    public static /* synthetic */ void a(ExecutorService executorService) {
        boolean bl;
        if (!(Build.VERSION.SDK_INT > 23 && executorService == ForkJoinPool.commonPool() || (bl = executorService.isTerminated()))) {
            boolean bl2;
            executorService.shutdown();
            boolean bl3 = false;
            while (!(bl2 = bl)) {
                try {
                    bl = executorService.awaitTermination(1L, TimeUnit.DAYS);
                }
                catch (InterruptedException interruptedException) {
                    bl = bl2;
                    if (bl3) continue;
                    executorService.shutdownNow();
                    bl3 = true;
                    bl = bl2;
                }
            }
            if (bl3) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

