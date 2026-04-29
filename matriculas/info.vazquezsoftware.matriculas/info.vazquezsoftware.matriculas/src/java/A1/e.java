/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.KS
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 */
package a1;

import a1.f;
import com.google.android.gms.internal.ads.KS;

final class e
implements Runnable {
    private final KS g;
    private final Long h;

    /* synthetic */ e(f f3, KS kS, Long l3) {
        this.g = kS;
        this.h = l3;
    }

    public final /* synthetic */ void run() {
        f.e(this.g, this.h);
    }
}

