/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package i2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import i2.a;
import i2.c;
import i2.f;
import i2.h;

public final class d
extends a
implements f {
    d(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    @Override
    public final void p5(String string, Bundle bundle, h h3) {
        Parcel parcel = this.a();
        parcel.writeString(string);
        int n2 = c.a;
        parcel.writeInt(1);
        bundle.writeToParcel(parcel, 0);
        parcel.writeStrongBinder((IBinder)h3);
        this.Z(2, parcel);
    }
}

