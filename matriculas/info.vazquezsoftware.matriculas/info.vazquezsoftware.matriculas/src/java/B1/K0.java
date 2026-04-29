/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  com.google.android.gms.internal.ads.bf
 *  com.google.android.gms.internal.ads.cf
 *  java.lang.Object
 *  java.lang.String
 */
package b1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import b1.j0;
import b1.l0;
import com.google.android.gms.internal.ads.bf;
import com.google.android.gms.internal.ads.cf;

public abstract class k0
extends bf
implements l0 {
    public k0() {
        super("com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    public static l0 L5(IBinder iBinder) {
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
        if (iInterface instanceof l0) {
            return (l0)iInterface;
        }
        return new j0(iBinder);
    }

    protected final boolean K5(int n3, Parcel parcel, Parcel parcel2, int n4) {
        if (n3 == 1) {
            String string = parcel.readString();
            String string2 = parcel.readString();
            cf.h((Parcel)parcel);
            this.M0(string, string2);
            parcel2.writeNoException();
            return true;
        }
        return false;
    }
}

