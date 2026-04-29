/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  i2.t
 *  i2.w
 *  java.lang.Object
 *  java.lang.String
 */
package h2;

import L1.l;
import android.content.Context;
import android.content.Intent;
import h2.a;
import h2.i;
import h2.j;
import i2.t;
import i2.w;

public final class m {
    private static final i2.i c = new i2.i("ReviewService");
    t a;
    private final String b;

    public m(Context context) {
        this.b = context.getPackageName();
        if (w.a((Context)context)) {
            Intent intent = new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending");
            this.a = new t(context, c, "com.google.android.finsky.inappreviewservice.InAppReviewService", intent, new i(), null);
        }
    }

    static /* bridge */ /* synthetic */ i2.i b() {
        return c;
    }

    static /* bridge */ /* synthetic */ String c(m m2) {
        return m2.b;
    }

    public final L1.i a() {
        Object object = this.b;
        i2.i i2 = c;
        i2.c("requestInAppReview (%s)", object);
        if (this.a == null) {
            i2.a("Play Store app is either not installed or not the official version", new Object[0]);
            return l.b(new a(-1));
        }
        object = new L1.j();
        this.a.s((i2.j)new j(this, (L1.j)object, (L1.j)object), (L1.j)object);
        return ((L1.j)object).a();
    }
}

