/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.op
 *  java.lang.Object
 *  java.util.Objects
 */
package b1;

import android.content.Context;
import b1.v;
import b1.w;
import com.google.android.gms.internal.ads.op;
import java.util.Objects;

final class f
extends w {
    final Context b;
    final op c;

    f(v v2, Context context, op op2) {
        this.b = context;
        this.c = op2;
        Objects.requireNonNull((Object)v2);
    }
}

