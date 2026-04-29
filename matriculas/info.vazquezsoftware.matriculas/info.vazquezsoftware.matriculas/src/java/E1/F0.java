/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.os.StrictMode$ThreadPolicy$Builder
 *  com.google.android.gms.internal.ads.Dr
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.concurrent.Callable
 */
package e1;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.internal.ads.Dr;
import f1.p;
import java.util.concurrent.Callable;

public abstract class f0 {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object a(Context context, Callable object) {
        StrictMode.ThreadPolicy threadPolicy;
        try {
            threadPolicy = StrictMode.getThreadPolicy();
        }
        catch (Throwable throwable) {}
        try {
            StrictMode.ThreadPolicy.Builder builder = new StrictMode.ThreadPolicy.Builder(threadPolicy);
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)builder.permitDiskReads().permitDiskWrites().build());
            object = object.call();
        }
        catch (Throwable throwable) {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
            throw throwable;
        }
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        return object;
        p.d("Unexpected exception.", throwable);
        Dr.c((Context)context).b(throwable, "StrictModeUtil.runWithLaxStrictMode");
        return null;
    }
}

