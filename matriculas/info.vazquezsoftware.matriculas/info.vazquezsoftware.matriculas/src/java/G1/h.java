/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  java.lang.Object
 */
package G1;

import android.os.Handler;
import android.os.Looper;

public class h
extends Handler {
    private final Looper a = Looper.getMainLooper();

    public h(Looper looper) {
        super(looper);
    }

    public h(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }
}

