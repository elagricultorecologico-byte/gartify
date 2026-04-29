/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  java.lang.Object
 *  java.lang.String
 */
package i2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class a
implements IInterface {
    private final IBinder g;
    private final String h;

    protected a(IBinder iBinder, String string) {
        this.g = iBinder;
        this.h = "com.google.android.play.core.inappreview.protocol.IInAppReviewService";
    }

    protected final void Z(int n2, Parcel parcel) {
        try {
            this.g.transact(2, parcel, null, 1);
            return;
        }
        finally {
            parcel.recycle();
        }
    }

    protected final Parcel a() {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken(this.h);
        return parcel;
    }

    public final IBinder asBinder() {
        return this.g;
    }
}

