/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package e1;

import android.content.Context;
import e1.t0;

final class s0
implements Runnable {
    private final t0 g;
    private final Context h;
    private final String i;

    /* synthetic */ s0(t0 t02, Context context, String string) {
        this.g = t02;
        this.h = context;
        this.i = "admob";
    }

    public final /* synthetic */ void run() {
        this.g.O(this.h, this.i);
    }
}

