/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 *  java.lang.Object
 *  java.lang.Override
 */
package x1;

import android.app.Activity;
import android.content.Intent;
import x1.A;

final class y
extends A {
    final Intent g;
    final Activity h;
    final int i;

    y(Intent intent, Activity activity, int n2) {
        this.g = intent;
        this.h = activity;
        this.i = n2;
    }

    @Override
    public final void a() {
        Intent intent = this.g;
        if (intent != null) {
            this.h.startActivityForResult(intent, this.i);
        }
    }
}

