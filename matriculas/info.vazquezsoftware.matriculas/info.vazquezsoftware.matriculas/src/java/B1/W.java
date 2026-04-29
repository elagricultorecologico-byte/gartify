/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.RemoteException
 *  com.google.android.gms.dynamite.DynamiteModule
 *  com.google.android.gms.internal.ads.Uj
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.jk
 *  f1.g
 *  f1.p
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package b1;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import b1.m0;
import b1.o0;
import b1.v;
import b1.x;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.ads.Uj;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.jk;
import f1.g;
import f1.p;

abstract class w {
    private static final o0 a;

    static {
        Object object;
        block5: {
            IBinder iBinder;
            Object object2;
            block6: {
                object = null;
                object2 = v.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(null).newInstance(null);
                if (!(object2 instanceof IBinder)) {
                    p.f((String)"ClientApi class is not an instance of IBinder.");
                    break block5;
                }
                iBinder = (IBinder)object2;
                if (iBinder == null) break block5;
                object2 = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
                if (!(object2 instanceof o0)) break block6;
                object = object2 = (o0)object2;
            }
            try {
                object = object2 = new m0(iBinder);
            }
            catch (Exception exception) {
                p.f((String)"Failed to instantiate ClientApi class.");
            }
        }
        a = object;
    }

    w() {
    }

    private final Object e() {
        Object object = a;
        if (object != null) {
            try {
                object = this.c((o0)object);
                return object;
            }
            catch (RemoteException remoteException) {
                p.g((String)"Cannot invoke local loader using ClientApi class.", (Throwable)remoteException);
                return null;
            }
        }
        p.f((String)"ClientApi class cannot be loaded.");
        return null;
    }

    private final Object f() {
        try {
            Object object = this.b();
            return object;
        }
        catch (RemoteException remoteException) {
            p.g((String)"Cannot invoke remote loader.", (Throwable)remoteException);
            return null;
        }
    }

    protected abstract Object a();

    protected abstract Object b();

    protected abstract Object c(o0 var1);

    public final Object d(Context object, boolean bl) {
        Object object2;
        int n3;
        boolean n32 = bl;
        if (!bl) {
            x.a();
            boolean bl2 = bl;
            if (!g.F((Context)object, (int)12451000)) {
                p.a((String)"Google Play Services is not available.");
                n3 = 1;
            }
        }
        int n4 = DynamiteModule.a((Context)object, (String)"com.google.android.gms.ads.dynamite");
        int n5 = DynamiteModule.c((Context)object, (String)"com.google.android.gms.ads.dynamite");
        int n6 = 0;
        n4 = n4 > n5 ? 0 : 1;
        Yi.a((Context)object);
        if (((Boolean)Uj.a.e()).booleanValue()) {
            n5 = 0;
            n4 = n6;
            n6 = n5;
        } else if (((Boolean)Uj.b.e()).booleanValue()) {
            n6 = 1;
            n4 = 1;
        } else {
            n4 = n3 | n4 ^ 1;
            n6 = 0;
        }
        if (n4 != 0) {
            object = object2 = this.e();
            if (object2 == null) {
                object = object2;
                if (n6 == 0) {
                    object = this.f();
                }
            }
        } else {
            object2 = this.f();
            if (object2 == null) {
                n4 = ((Long)jk.a.e()).intValue();
                if (x.h().nextInt(n4) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", 1);
                    x.a().t((Context)object, x.g().g, "gmob-apps", bundle, true);
                }
            }
            object = object2 == null ? this.e() : object2;
        }
        object2 = object;
        if (object == null) {
            object2 = this.a();
        }
        return object2;
    }
}

