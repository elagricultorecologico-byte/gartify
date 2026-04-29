/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  com.google.android.gms.internal.ads.af
 *  com.google.android.gms.internal.ads.cf
 *  java.lang.Object
 */
package b1;

import C1.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.af;
import com.google.android.gms.internal.ads.cf;

public final class z0
extends af
implements IInterface {
    z0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
    }

    public final IBinder z1(a a3, int n3) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)a3);
        parcel.writeInt(260910000);
        parcel = this.Z(1, parcel);
        a3 = parcel.readStrongBinder();
        parcel.recycle();
        return a3;
    }
}

