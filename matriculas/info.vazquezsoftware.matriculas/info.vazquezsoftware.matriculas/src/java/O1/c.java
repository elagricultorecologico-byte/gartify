/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.xr
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package o1;

import T0.g;
import android.content.Context;
import b1.i1;
import com.google.android.gms.internal.ads.xr;
import o1.b;

final class c
implements Runnable {
    private final Context g;
    private final T0.c h;
    private final g i;
    private final String j;
    private final b k;

    /* synthetic */ c(Context context, T0.c c3, g g2, String string, b b2) {
        this.g = context;
        this.h = c3;
        this.i = g2;
        this.j = string;
        this.k = b2;
    }

    public final /* synthetic */ void run() {
        Object object = this.i;
        object = object == null ? null : ((g)object).a();
        b b2 = this.k;
        String string = this.j;
        T0.c c3 = this.h;
        new xr(this.g, c3, (i1)object, string).b(b2);
    }
}

