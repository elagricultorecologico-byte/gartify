/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.op
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Objects
 */
package b1;

import android.content.Context;
import b1.v;
import b1.w;
import com.google.android.gms.internal.ads.op;
import java.util.Objects;

final class o
extends w {
    final Context b;
    final String c;
    final op d;
    final v e;

    o(v v2, Context context, String string, op op2) {
        this.b = context;
        this.c = string;
        this.d = op2;
        Objects.requireNonNull((Object)v2);
        this.e = v2;
    }
}

