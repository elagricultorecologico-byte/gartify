/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.Dr
 *  com.google.android.gms.internal.ads.Sn
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package g1;

import T0.e;
import T0.g;
import android.content.Context;
import com.google.android.gms.internal.ads.Dr;
import com.google.android.gms.internal.ads.Sn;
import g1.b;

final class c
implements Runnable {
    private final Context g;
    private final String h;
    private final g i;
    private final b j;

    /* synthetic */ c(Context context, String string, g g3, b b2) {
        this.g = context;
        this.h = string;
        this.i = g3;
        this.j = b2;
    }

    public final /* synthetic */ void run() {
        b b2 = this.j;
        g g3 = this.i;
        Context context = this.g;
        String string = this.h;
        try {
            Sn sn = new Sn(context, string);
            sn.f(g3.a(), (e)b2);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            Dr.c((Context)context).b((Throwable)illegalStateException, "InterstitialAd.load");
            return;
        }
    }
}

