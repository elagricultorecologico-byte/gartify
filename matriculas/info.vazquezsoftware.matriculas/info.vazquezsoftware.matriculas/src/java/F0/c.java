/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.profileinstaller.f
 *  androidx.profileinstaller.f$c
 *  java.lang.Object
 *  java.lang.Runnable
 */
package f0;

import androidx.profileinstaller.f;

public final class c
implements Runnable {
    public final f.c g;
    public final int h;
    public final Object i;

    public /* synthetic */ c(f.c c2, int n2, Object object) {
        this.g = c2;
        this.h = n2;
        this.i = object;
    }

    public final void run() {
        f.a((f.c)this.g, (int)this.h, (Object)this.i);
    }
}

