/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.ComponentCallbacks
 *  android.content.ComponentCallbacks2
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  com.google.android.gms.common.util.p
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package w1;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.p;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
implements Application.ActivityLifecycleCallbacks,
ComponentCallbacks2 {
    private static final c k = new c();
    private final AtomicBoolean g = new AtomicBoolean();
    private final AtomicBoolean h = new AtomicBoolean();
    private final ArrayList i = new ArrayList();
    private boolean j = false;

    private c() {
    }

    public static c b() {
        return k;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void c(Application application) {
        c c2;
        c c3 = c2 = k;
        synchronized (c3) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        if (c2.j) break block3;
                        application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)c2);
                        application.registerComponentCallbacks((ComponentCallbacks)c2);
                        c2.j = true;
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void f(boolean bl) {
        c c2;
        c c3 = c2 = k;
        synchronized (c3) {
            Throwable throwable2;
            block5: {
                try {
                    ArrayList arrayList = this.i;
                    int n2 = arrayList.size();
                    for (int i2 = 0; i2 < n2; ++i2) {
                        Object object = arrayList.get(i2);
                        ((a)object).a(bl);
                    }
                }
                catch (Throwable throwable2) {
                    break block5;
                }
                return;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(a a2) {
        c c2;
        c c3 = c2 = k;
        synchronized (c3) {
            this.i.add((Object)a2);
            return;
        }
    }

    public boolean d() {
        return this.g.get();
    }

    public boolean e(boolean bl) {
        AtomicBoolean atomicBoolean = this.h;
        if (!atomicBoolean.get()) {
            if (!p.a()) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                ActivityManager.getMyMemoryState((ActivityManager.RunningAppProcessInfo)runningAppProcessInfo);
                if (!atomicBoolean.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                    this.g.set(true);
                }
            } else {
                return bl;
            }
        }
        return this.d();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        activity = this.h;
        boolean bl = this.g.compareAndSet(true, false);
        activity.set(true);
        if (bl) {
            this.f(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        activity = this.h;
        boolean bl = this.g.compareAndSet(true, false);
        activity.set(true);
        if (bl) {
            this.f(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int n2) {
        if (n2 == 20 && this.g.compareAndSet(false, true)) {
            this.h.set(true);
            this.f(true);
        }
    }

    public static interface a {
        public void a(boolean var1);
    }
}

