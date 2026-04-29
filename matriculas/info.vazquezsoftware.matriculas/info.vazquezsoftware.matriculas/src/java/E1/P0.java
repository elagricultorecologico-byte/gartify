/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.Message
 *  com.google.android.gms.internal.ads.qk0
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Throwable
 */
package e1;

import a1.t;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.ads.qk0;
import e1.F0;

public final class p0
extends qk0 {
    public p0(Looper looper) {
        super(looper);
    }

    protected final void a(Message message) {
        try {
            super.a(message);
            return;
        }
        catch (Throwable throwable) {
            t.g();
            F0.p(t.l().s(), throwable);
            throw throwable;
        }
    }

    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
            return;
        }
        catch (Exception exception) {
            t.l().j((Throwable)exception, "AdMobHandler.handleMessage");
            return;
        }
    }
}

