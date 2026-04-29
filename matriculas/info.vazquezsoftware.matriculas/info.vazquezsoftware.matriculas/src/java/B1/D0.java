/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  com.google.android.gms.internal.ads.af
 *  com.google.android.gms.internal.ads.cf
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package b1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b1.X0;
import b1.a1;
import b1.e0;
import com.google.android.gms.internal.ads.af;
import com.google.android.gms.internal.ads.cf;

public final class d0
extends af
implements e0 {
    d0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdPreloadCallbackV2");
    }

    @Override
    public final void N2(String string, a1 a12) {
        Parcel parcel = this.a();
        parcel.writeString(string);
        cf.c((Parcel)parcel, (Parcelable)a12);
        this.c0(3, parcel);
    }

    @Override
    public final void i1(String string, X0 x02) {
        Parcel parcel = this.a();
        parcel.writeString(string);
        cf.e((Parcel)parcel, (IInterface)x02);
        this.c0(1, parcel);
    }

    @Override
    public final void u(String string) {
        Parcel parcel = this.a();
        parcel.writeString(string);
        this.c0(2, parcel);
    }
}

