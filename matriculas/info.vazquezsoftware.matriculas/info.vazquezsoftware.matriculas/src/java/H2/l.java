/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Bundle
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package h2;

import L1.j;
import android.app.PendingIntent;
import android.os.Bundle;
import h2.e;
import h2.k;
import h2.m;
import i2.i;

final class l
extends k {
    l(m m2, j j2, String string) {
        super(m2, new i("OnRequestInstallCallback"), j2);
    }

    @Override
    public final void u0(Bundle object) {
        super.u0((Bundle)object);
        object = new e((PendingIntent)object.get("confirmation_intent"), object.getBoolean("is_review_no_op"));
        this.h.e(object);
    }
}

