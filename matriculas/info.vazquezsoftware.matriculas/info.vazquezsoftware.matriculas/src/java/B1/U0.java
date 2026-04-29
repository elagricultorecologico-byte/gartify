/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  com.google.android.gms.internal.ads.bf
 *  com.google.android.gms.internal.ads.cf
 *  java.lang.Object
 */
package b1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b1.t0;
import b1.v0;
import com.google.android.gms.internal.ads.bf;
import com.google.android.gms.internal.ads.cf;

public abstract class u0
extends bf
implements v0 {
    public u0() {
        super("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    public static v0 asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.ILiteSdkInfo");
        if (iInterface instanceof v0) {
            return (v0)iInterface;
        }
        return new t0(iBinder);
    }

    protected final boolean K5(int n3, Parcel object, Parcel parcel, int n4) {
        if (n3 != 1) {
            if (n3 != 2) {
                return false;
            }
            object = this.getAdapterCreator();
            parcel.writeNoException();
            cf.e((Parcel)parcel, (IInterface)object);
        } else {
            object = this.getLiteSdkVersion();
            parcel.writeNoException();
            cf.d((Parcel)parcel, (Parcelable)object);
        }
        return true;
    }
}

