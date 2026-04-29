/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.ResultReceiver
 *  java.lang.Object
 */
package h2;

import L1.j;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import h2.h;

final class g
extends ResultReceiver {
    final j g;

    g(h h3, Handler handler, j j2) {
        this.g = j2;
        super(handler);
    }

    public final void onReceiveResult(int n2, Bundle bundle) {
        this.g.e(null);
    }
}

