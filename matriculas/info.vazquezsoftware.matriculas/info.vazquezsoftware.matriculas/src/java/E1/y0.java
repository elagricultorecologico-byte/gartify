/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.qk0
 *  java.lang.Object
 *  java.util.concurrent.Callable
 */
package e1;

import a1.t;
import android.net.Uri;
import com.google.android.gms.internal.ads.qk0;
import e1.F0;
import java.util.concurrent.Callable;

final class y0
implements Callable {
    private final Uri a;

    /* synthetic */ y0(Uri uri) {
        this.a = uri;
    }

    public final /* synthetic */ Object call() {
        qk0 qk02 = F0.l;
        t.g();
        return F0.t(this.a);
    }
}

