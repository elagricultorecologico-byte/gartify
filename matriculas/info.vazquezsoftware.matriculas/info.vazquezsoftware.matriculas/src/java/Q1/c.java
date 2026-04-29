/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.Dr
 *  com.google.android.gms.internal.ads.kt
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package q1;

import T0.g;
import android.content.Context;
import com.google.android.gms.internal.ads.Dr;
import com.google.android.gms.internal.ads.kt;
import q1.b;

final class c
implements Runnable {
    private final Context g;
    private final String h;
    private final g i;
    private final b j;

    /* synthetic */ c(Context context, String string, g g2, b b2) {
        this.g = context;
        this.h = string;
        this.i = g2;
        this.j = b2;
    }

    public final /* synthetic */ void run() {
        b b2 = this.j;
        g g2 = this.i;
        Context context = this.g;
        String string = this.h;
        try {
            kt kt2 = new kt(context, string);
            kt2.d(g2.a(), b2);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            Dr.c((Context)context).b((Throwable)illegalStateException, "RewardedInterstitialAd.load");
            return;
        }
    }
}

