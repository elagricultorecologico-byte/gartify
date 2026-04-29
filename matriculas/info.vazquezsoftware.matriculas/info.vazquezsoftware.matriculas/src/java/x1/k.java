/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.Throwable
 */
package x1;

import android.os.IBinder;
import android.os.Parcel;
import x1.Z;
import x1.f;
import x1.j;
import x1.k;

final class K
implements k {
    private final IBinder g;

    K(IBinder iBinder) {
        this.g = iBinder;
    }

    public final IBinder asBinder() {
        return this.g;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final void k5(j j2, f f2) {
        Throwable throwable2;
        Parcel parcel;
        Parcel parcel2;
        block4: {
            parcel2 = Parcel.obtain();
            parcel = Parcel.obtain();
            try {
                parcel2.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                j2 = j2 != null ? j2.asBinder() : null;
            }
            catch (Throwable throwable2) {
                break block4;
            }
            parcel2.writeStrongBinder((IBinder)j2);
            if (f2 != null) {
                parcel2.writeInt(1);
                Z.a(f2, parcel2, 0);
            } else {
                parcel2.writeInt(0);
            }
            this.g.transact(46, parcel2, parcel, 0);
            parcel.readException();
            parcel.recycle();
            parcel2.recycle();
            return;
        }
        parcel.recycle();
        parcel2.recycle();
        throw throwable2;
    }
}

