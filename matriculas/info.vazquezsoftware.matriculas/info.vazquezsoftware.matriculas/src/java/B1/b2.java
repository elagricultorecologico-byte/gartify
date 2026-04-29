/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.op
 *  f1.p
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 */
package b1;

import C1.a;
import C1.b;
import C1.c;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import b1.f0;
import b1.h0;
import b1.i0;
import com.google.android.gms.internal.ads.op;
import f1.p;

public final class b2
extends c {
    public b2() {
        super("com.google.android.gms.ads.AdPreloaderRemoteCreatorImpl");
    }

    @Override
    protected final /* synthetic */ Object a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloaderCreator");
        if (iInterface instanceof i0) {
            return (i0)iInterface;
        }
        return new i0(iBinder);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final h0 c(Context object, op op2) {
        void var1_5;
        try {
            a a3 = b.h1(object);
            op2 = ((i0)((Object)this.b((Context)object))).z1(a3, op2, 260910000);
            if (op2 == null) {
                return null;
            }
            object = op2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloader");
            if (!(object instanceof h0)) return new f0((IBinder)op2);
            return (h0)object;
        }
        catch (NullPointerException nullPointerException) {
        }
        catch (c.a a4) {
        }
        catch (RemoteException remoteException) {}
        p.g((String)"Could not get remote AdPreloaderCreator.", (Throwable)var1_5);
        return null;
    }
}

