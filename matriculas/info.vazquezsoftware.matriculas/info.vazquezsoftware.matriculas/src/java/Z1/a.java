/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  java.lang.Object
 */
package z1;

import G1.c;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import x1.q;

public final class a
extends G1.a
implements IInterface {
    a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void h1(q q2) {
        Parcel parcel = this.a();
        c.c(parcel, q2);
        this.c0(1, parcel);
    }
}

