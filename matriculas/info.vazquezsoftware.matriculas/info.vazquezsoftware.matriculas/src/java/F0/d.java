/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Choreographer$FrameCallback
 *  androidx.profileinstaller.ProfileInstallerInitializer
 *  java.lang.Object
 */
package f0;

import android.content.Context;
import android.view.Choreographer;
import androidx.profileinstaller.ProfileInstallerInitializer;

public final class d
implements Choreographer.FrameCallback {
    public final ProfileInstallerInitializer a;
    public final Context b;

    public /* synthetic */ d(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.a = profileInstallerInitializer;
        this.b = context;
    }

    public final void doFrame(long l2) {
        ProfileInstallerInitializer.e((ProfileInstallerInitializer)this.a, (Context)this.b, (long)l2);
    }
}

