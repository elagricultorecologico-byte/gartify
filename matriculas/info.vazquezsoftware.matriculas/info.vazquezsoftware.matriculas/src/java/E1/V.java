/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.Objects
 */
package e1;

import android.content.Context;
import b1.J0;
import b1.a1;
import e1.y;
import java.util.Objects;

final class v
extends J0 {
    final Context g;
    final y h;

    v(y y2, Context context) {
        this.g = context;
        Objects.requireNonNull((Object)y2);
        this.h = y2;
    }

    @Override
    public final void z0(a1 a12) {
        if (a12 == null) {
            return;
        }
        this.h.n(this.g, a12.h, true, true);
    }
}

