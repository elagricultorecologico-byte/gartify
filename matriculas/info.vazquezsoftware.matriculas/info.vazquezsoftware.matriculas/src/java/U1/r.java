/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package u1;

import G1.h;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import u1.g;

final class r
extends h {
    private final Context b;
    final g c;

    public r(g g2, Context context) {
        this.c = g2;
        g2 = Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper();
        super((Looper)g2);
        this.b = context.getApplicationContext();
    }

    public final void handleMessage(Message object) {
        int n2 = ((Message)object).what;
        if (n2 != 1) {
            object = new StringBuilder();
            object.append("Don't know how to handle this message: ");
            object.append(n2);
            Log.w((String)"GoogleApiAvailability", (String)object.toString());
            return;
        }
        object = this.c;
        n2 = ((g)object).g(this.b);
        if (((g)object).j(n2)) {
            this.c.o(this.b, n2);
        }
    }
}

