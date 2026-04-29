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
 *  java.lang.Override
 */
package b1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import b1.h0;
import com.google.android.gms.internal.ads.af;
import com.google.android.gms.internal.ads.cf;
import com.google.android.gms.internal.ads.op;

public final class f0
extends af
implements h0 {
    f0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdPreloader");
    }

    @Override
    public final void r0(int n3) {
        Parcel parcel = this.a();
        parcel.writeInt(n3);
        this.c0(18, parcel);
    }

    @Override
    public final void z3(op op2) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)op2);
        this.c0(8, parcel);
    }
}

