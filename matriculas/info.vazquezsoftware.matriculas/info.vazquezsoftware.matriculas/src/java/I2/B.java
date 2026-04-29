/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  java.lang.Object
 *  java.lang.String
 */
package i2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b
extends Binder
implements IInterface {
    protected b(String string) {
        this.attachInterface(this, "com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
    }

    protected abstract boolean a(int var1, Parcel var2, Parcel var3, int var4);

    public final IBinder asBinder() {
        return this;
    }

    public final boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) {
        if (n2 > 0xFFFFFF) {
            if (super.onTransact(n2, parcel, parcel2, n3)) {
                return true;
            }
        } else {
            parcel.enforceInterface(this.getInterfaceDescriptor());
        }
        return this.a(n2, parcel, parcel2, n3);
    }
}

