/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.FS
 *  com.google.android.gms.internal.ads.QS
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package l1;

import android.util.Pair;
import com.google.android.gms.internal.ads.FS;
import com.google.android.gms.internal.ads.QS;
import l1.h0;

final class g0
implements Runnable {
    private final QS g;
    private final String h;
    private final Pair[] i;

    /* synthetic */ g0(QS qS, FS fS, String string, Pair[] pairArray) {
        this.g = qS;
        this.h = string;
        this.i = pairArray;
    }

    public final /* synthetic */ void run() {
        String string = this.h;
        Pair[] pairArray = this.i;
        h0.f(this.g, null, string, pairArray);
    }
}

