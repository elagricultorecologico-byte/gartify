/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  com.google.android.gms.internal.ads.af
 *  com.google.android.gms.internal.ads.cf
 *  com.google.android.gms.internal.ads.op
 *  java.lang.Object
 */
package b1;

import C1.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.af;
import com.google.android.gms.internal.ads.cf;
import com.google.android.gms.internal.ads.op;

public final class i0
extends af
implements IInterface {
    i0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdPreloaderCreator");
    }

    public final IBinder z1(a a3, op op2, int n3) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)a3);
        cf.e((Parcel)parcel, (IInterface)op2);
        parcel.writeInt(260910000);
        a3 = this.Z(1, parcel);
        op2 = a3.readStrongBinder();
        a3.recycle();
        return op2;
    }
}

