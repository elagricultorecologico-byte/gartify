/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package C0;

import android.app.ActivityManager;
import java.util.List;

public abstract class c {
    public static /* bridge */ /* synthetic */ List a(ActivityManager activityManager, String string, int n2, int n3) {
        return activityManager.getHistoricalProcessExitReasons(string, n2, n3);
    }
}

