/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.profileinstaller.ProfileInstallerInitializer
 *  java.lang.Object
 *  java.lang.Runnable
 */
package f0;

import android.content.Context;
import androidx.profileinstaller.ProfileInstallerInitializer;

public final class f
implements Runnable {
    public final Context g;

    public /* synthetic */ f(Context context) {
        this.g = context;
    }

    public final void run() {
        ProfileInstallerInitializer.c((Context)this.g);
    }
}

