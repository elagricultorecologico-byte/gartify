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
 *  java.lang.Override
 *  java.lang.String
 */
package b1;

import C1.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import b1.T0;
import com.google.android.gms.internal.ads.af;
import com.google.android.gms.internal.ads.cf;

public final class R0
extends af
implements T0 {
    R0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOutOfContextTester");
    }

    @Override
    public final void b2(String string, a a3, a a4) {
        Parcel parcel = this.a();
        parcel.writeString(string);
        cf.e((Parcel)parcel, (IInterface)a3);
        cf.e((Parcel)parcel, (IInterface)a4);
        this.c0(1, parcel);
    }
}

