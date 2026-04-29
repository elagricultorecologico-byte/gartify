/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  com.google.android.gms.internal.ads.af
 *  com.google.android.gms.internal.ads.cf
 *  java.lang.Object
 *  java.lang.Override
 */
package b1;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b1.N1;
import b1.c0;
import com.google.android.gms.internal.ads.af;
import com.google.android.gms.internal.ads.cf;

public final class a0
extends af
implements c0 {
    a0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdPreloadCallback");
    }

    @Override
    public final void H4(N1 n12) {
        Parcel parcel = this.a();
        cf.c((Parcel)parcel, (Parcelable)n12);
        this.c0(2, parcel);
    }

    @Override
    public final void O1(N1 n12) {
        Parcel parcel = this.a();
        cf.c((Parcel)parcel, (Parcelable)n12);
        this.c0(1, parcel);
    }
}

