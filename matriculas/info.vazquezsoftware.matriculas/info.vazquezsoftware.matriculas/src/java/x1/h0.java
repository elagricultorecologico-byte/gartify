/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 *  android.os.Parcel
 *  java.lang.Object
 *  java.lang.Override
 */
package x1;

import H1.n;
import H1.o;
import android.os.IInterface;
import android.os.Parcel;
import x1.i0;

public abstract class h0
extends n
implements i0 {
    public h0() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    @Override
    protected final boolean a(int n2, Parcel object, Parcel parcel, int n3) {
        if (n2 != 1) {
            if (n2 != 2) {
                return false;
            }
            n2 = this.c();
            parcel.writeNoException();
            parcel.writeInt(n2);
        } else {
            object = this.k();
            parcel.writeNoException();
            o.b(parcel, (IInterface)object);
        }
        return true;
    }
}

