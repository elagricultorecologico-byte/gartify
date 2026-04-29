/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  com.google.android.gms.internal.ads.af
 *  com.google.android.gms.internal.ads.cf
 *  com.google.android.gms.internal.ads.np
 *  com.google.android.gms.internal.ads.op
 *  java.lang.Object
 *  java.lang.Override
 */
package b1;

import android.os.IBinder;
import android.os.Parcel;
import b1.v0;
import b1.y1;
import com.google.android.gms.internal.ads.af;
import com.google.android.gms.internal.ads.cf;
import com.google.android.gms.internal.ads.np;
import com.google.android.gms.internal.ads.op;

public final class t0
extends af
implements v0 {
    t0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    @Override
    public final op getAdapterCreator() {
        Parcel parcel = this.Z(2, this.a());
        op op2 = np.L5((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return op2;
    }

    @Override
    public final y1 getLiteSdkVersion() {
        Parcel parcel = this.Z(1, this.a());
        y1 y12 = (y1)cf.b((Parcel)parcel, y1.CREATOR);
        parcel.recycle();
        return y12;
    }
}

