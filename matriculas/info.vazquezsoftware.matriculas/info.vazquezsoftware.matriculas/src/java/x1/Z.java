/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  java.lang.Object
 *  java.lang.Override
 */
package x1;

import android.content.Intent;
import w1.h;
import x1.A;

final class z
extends A {
    final Intent g;
    final h h;

    z(Intent intent, h h2, int n2) {
        this.g = intent;
        this.h = h2;
    }

    @Override
    public final void a() {
        Intent intent = this.g;
        if (intent != null) {
            this.h.startActivityForResult(intent, 2);
        }
    }
}

