/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebSettings
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.qk0
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.Callable
 */
package e1;

import android.content.Context;
import android.webkit.WebSettings;
import b1.A;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.qk0;
import e1.F0;
import java.util.concurrent.Callable;

final class x0
implements Callable {
    private final WebSettings a;
    private final Context b;

    /* synthetic */ x0(WebSettings webSettings, Context context) {
        this.a = webSettings;
        this.b = context;
    }

    public final /* synthetic */ Object call() {
        qk0 qk02 = F0.l;
        String string = this.b.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath();
        qk02 = this.a;
        qk02.setDatabasePath(string);
        qk02.setDatabaseEnabled(true);
        qk02.setDomStorageEnabled(true);
        qk02.setDisplayZoomControls(false);
        qk02.setBuiltInZoomControls(true);
        qk02.setSupportZoom(true);
        string = Yi.w1;
        if (((Boolean)A.c().d((Oi)string)).booleanValue()) {
            qk02.setTextZoom(100);
        }
        qk02.setAllowContentAccess(false);
        return Boolean.TRUE;
    }
}

