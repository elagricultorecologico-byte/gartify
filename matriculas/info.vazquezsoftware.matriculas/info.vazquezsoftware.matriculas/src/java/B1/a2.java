/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.Dr
 *  com.google.android.gms.internal.ads.Fr
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.op
 *  f1.p
 *  f1.s
 *  f1.t
 *  java.lang.Boolean
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
import b1.A;
import b1.T;
import b1.V;
import b1.W;
import b1.Z1;
import b1.h2;
import com.google.android.gms.internal.ads.Dr;
import com.google.android.gms.internal.ads.Fr;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.op;
import f1.p;
import f1.r;
import f1.s;
import f1.t;

public final class a2
extends c {
    private Fr c;

    public a2() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    @Override
    protected final /* synthetic */ Object a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (iInterface instanceof W) {
            return (W)iInterface;
        }
        return new W(iBinder);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final V c(Context object, h2 object2, String string, op op2, int n3) {
        void var1_3;
        Yi.a((Context)object);
        Object object3 = Yi.cc;
        if (((Boolean)A.c().d(object3)).booleanValue()) {
            void var2_7;
            try {
                object3 = b.h1(object);
                string = ((W)((Object)t.a((Context)object, (String)"com.google.android.gms.ads.ChimeraAdManagerCreatorImpl", (r)Z1.a))).z1((a)object3, (h2)object2, string, op2, 260910000, n3);
                if (string == null) {
                    return null;
                }
                object2 = string.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (!(object2 instanceof V)) return new T((IBinder)string);
                return (V)object2;
            }
            catch (NullPointerException nullPointerException) {
            }
            catch (RemoteException remoteException) {
            }
            catch (s s2) {}
            object = Dr.c((Context)object);
            this.c = object;
            object.b((Throwable)var2_7, "AdManagerCreator.newAdManagerByDynamiteLoader");
            p.i((String)"#007 Could not call remote method.", (Throwable)var2_7);
            return null;
        }
        try {
            object3 = b.h1(object);
            object = ((W)((Object)this.b((Context)object))).z1((a)object3, (h2)object2, string, op2, 260910000, n3);
            if (object == null) {
                return null;
            }
            object2 = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (!(object2 instanceof V)) return new T((IBinder)object);
            return (V)object2;
        }
        catch (c.a a3) {
        }
        catch (RemoteException remoteException) {}
        p.b((String)"Could not create remote AdManager.", (Throwable)var1_3);
        return null;
    }
}

