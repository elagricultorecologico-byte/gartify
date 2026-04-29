/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.util.concurrent.Callable
 */
package a1;

import a1.k;
import android.content.Context;
import java.util.concurrent.Callable;

final class j
implements Callable {
    private final k a;
    private final Context b;

    /* synthetic */ j(k k3, Context context) {
        this.a = k3;
        this.b = context;
    }

    public final /* synthetic */ Object call() {
        return this.a.b(this.b, null);
    }
}

