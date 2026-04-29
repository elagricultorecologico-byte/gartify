/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  com.google.android.gms.internal.ads.af
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package b1;

import android.os.IBinder;
import android.os.Parcel;
import b1.l0;
import com.google.android.gms.internal.ads.af;

public final class j0
extends af
implements l0 {
    j0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    @Override
    public final void M0(String string, String string2) {
        Parcel parcel = this.a();
        parcel.writeString(string);
        parcel.writeString(string2);
        this.c0(1, parcel);
    }
}

