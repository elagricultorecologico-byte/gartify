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
import b1.a1;
import b1.s0;
import com.google.android.gms.internal.ads.af;
import com.google.android.gms.internal.ads.cf;

public final class q0
extends af
implements s0 {
    q0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    @Override
    public final void A1(a1 a12) {
        Parcel parcel = this.a();
        cf.c((Parcel)parcel, (Parcelable)a12);
        this.c0(1, parcel);
    }

    @Override
    public final void c() {
        this.c0(4, this.a());
    }

    @Override
    public final void d() {
        this.c0(2, this.a());
    }

    @Override
    public final void e() {
        this.c0(5, this.a());
    }

    @Override
    public final void k() {
        this.c0(3, this.a());
    }
}

