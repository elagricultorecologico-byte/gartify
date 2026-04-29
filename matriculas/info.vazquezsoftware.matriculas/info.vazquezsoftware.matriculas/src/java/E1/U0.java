/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  androidx.browser.customtabs.d
 *  androidx.browser.customtabs.d$d
 *  com.google.android.gms.internal.ads.Aj
 *  com.google.android.gms.internal.ads.bS0
 *  com.google.android.gms.internal.ads.zj
 *  java.lang.Object
 *  java.util.Objects
 */
package e1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.d;
import com.google.android.gms.internal.ads.Aj;
import com.google.android.gms.internal.ads.bS0;
import com.google.android.gms.internal.ads.zj;
import e1.F0;
import java.util.Objects;

final class u0
implements zj {
    final Aj a;
    final Bundle b;
    final Context c;
    final Uri d;

    u0(F0 f02, Aj aj, Bundle bundle, Context context, Uri uri) {
        this.a = aj;
        this.b = bundle;
        this.c = context;
        this.d = uri;
        Objects.requireNonNull((Object)f02);
    }

    public final void a() {
        Aj aj = this.a;
        d.d d2 = new d.d(aj.c());
        F0.u(d2, this.b);
        d d3 = d2.a();
        Intent intent = d3.a;
        d2 = this.c;
        intent.setPackage(bS0.a((Context)d2));
        d3.a((Context)d2, this.d);
        aj.b((Activity)d2);
    }
}

