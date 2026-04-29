/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.Dr
 *  com.google.android.gms.internal.ads.Zs
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package p1;

import T0.g;
import android.content.Context;
import com.google.android.gms.internal.ads.Dr;
import com.google.android.gms.internal.ads.Zs;
import p1.d;

final class e
implements Runnable {
    private final Context g;
    private final String h;
    private final g i;
    private final d j;

    /* synthetic */ e(Context context, String string, g g2, d d3) {
        this.g = context;
        this.h = string;
        this.i = g2;
        this.j = d3;
    }

    public final /* synthetic */ void run() {
        d d3 = this.j;
        g g2 = this.i;
        Context context = this.g;
        String string = this.h;
        try {
            Zs zs = new Zs(context, string);
            zs.d(g2.a(), d3);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            Dr.c((Context)context).b((Throwable)illegalStateException, "RewardedAd.load");
            return;
        }
    }
}

