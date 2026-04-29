/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  java.lang.Object
 *  java.lang.Runnable
 */
package d1;

import android.graphics.drawable.Drawable;
import d1.v;

final class u
implements Runnable {
    private final v g;
    private final Drawable h;

    /* synthetic */ u(v v2, Drawable drawable) {
        this.g = v2;
        this.h = drawable;
    }

    public final /* synthetic */ void run() {
        this.g.c.g.getWindow().setBackgroundDrawable(this.h);
    }
}

