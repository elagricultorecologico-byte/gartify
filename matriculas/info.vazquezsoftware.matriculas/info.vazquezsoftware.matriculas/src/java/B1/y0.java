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
 */
package b1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import b1.b1;
import b1.c1;
import b1.e1;
import com.google.android.gms.internal.ads.af;
import com.google.android.gms.internal.ads.cf;

public final class Y0
extends af
implements b1 {
    Y0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    @Override
    public final void J3(e1 e12) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)e12);
        this.c0(8, parcel);
    }

    @Override
    public final float h() {
        throw null;
    }

    @Override
    public final float j() {
        throw null;
    }

    @Override
    public final float n() {
        throw null;
    }

    @Override
    public final e1 q() {
        Object object;
        Parcel parcel = this.Z(11, this.a());
        IBinder iBinder = parcel.readStrongBinder();
        object = iBinder == null ? null : ((object = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks")) instanceof e1 ? (e1)object : new c1(iBinder));
        parcel.recycle();
        return object;
    }
}

