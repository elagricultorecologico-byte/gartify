/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.Objects
 */
package f1;

import android.content.Context;
import f1.g;
import f1.v;
import java.util.Objects;

final class d
extends Thread {
    final Context g;
    final String h;

    d(g g2, Context context, String string) {
        this.g = context;
        this.h = string;
        Objects.requireNonNull((Object)g2);
    }

    public final void run() {
        new v(this.g, null).c(this.h, null);
    }
}

