/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  java.lang.Object
 *  java.lang.Override
 */
package x1;

import H1.n;
import H1.o;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import x1.W;
import x1.j;

public abstract class j0
extends n
implements j {
    public j0() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override
    protected final boolean a(int n2, Parcel parcel, Parcel parcel2, int n3) {
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return false;
                }
                n2 = parcel.readInt();
                IBinder iBinder = parcel.readStrongBinder();
                W w2 = (W)o.a(parcel, W.CREATOR);
                o.c(parcel);
                this.c5(n2, iBinder, w2);
            } else {
                n2 = parcel.readInt();
                Bundle bundle = (Bundle)o.a(parcel, Bundle.CREATOR);
                o.c(parcel);
                this.B3(n2, bundle);
            }
        } else {
            n2 = parcel.readInt();
            IBinder iBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle)o.a(parcel, Bundle.CREATOR);
            o.c(parcel);
            this.H5(n2, iBinder, bundle);
        }
        parcel2.writeNoException();
        return true;
    }
}

