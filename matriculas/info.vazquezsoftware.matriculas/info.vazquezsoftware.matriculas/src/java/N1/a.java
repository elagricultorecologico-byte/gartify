/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  f1.p
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package n1;

import T0.c;
import T0.z;
import android.content.Context;
import android.os.RemoteException;
import b1.h0;
import f1.p;

public abstract class a {
    protected final h0 a;
    private final c b;
    private final Context c;

    protected a(Context context, c c3) {
        this.a = z.a(context);
        this.c = context.getApplicationContext();
        this.b = c3;
    }

    public final void a() {
        try {
            this.a.r0(this.b.e());
            return;
        }
        catch (RemoteException remoteException) {
            p.i((String)"#007 Could not call remote method.", (Throwable)remoteException);
            return;
        }
    }
}

