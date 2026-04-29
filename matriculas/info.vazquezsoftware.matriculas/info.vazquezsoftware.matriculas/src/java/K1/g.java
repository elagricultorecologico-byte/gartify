/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  java.lang.Object
 */
package K1;

import G1.a;
import G1.c;
import K1.f;
import K1.j;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class g
extends a
implements IInterface {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void h1(j j2, f f2) {
        Parcel parcel = this.a();
        c.c(parcel, j2);
        c.d(parcel, f2);
        this.Z(12, parcel);
    }
}

