/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.FrameLayout
 *  java.lang.Object
 *  java.util.Objects
 */
package b1;

import android.content.Context;
import android.widget.FrameLayout;
import b1.v;
import b1.w;
import java.util.Objects;

final class u
extends w {
    final FrameLayout b;
    final FrameLayout c;
    final Context d;
    final v e;

    u(v v2, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.b = frameLayout;
        this.c = frameLayout2;
        this.d = context;
        Objects.requireNonNull((Object)v2);
        this.e = v2;
    }
}

