/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.BadParcelableException
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.StringBuilder
 */
package i2;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import i2.b;
import i2.c;
import i2.h;

public abstract class g
extends b
implements h {
    public g() {
        super("com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
    }

    @Override
    protected final boolean a(int n2, Parcel parcel, Parcel object, int n3) {
        if (n2 == 2) {
            object = Bundle.CREATOR;
            n2 = c.a;
            object = parcel.readInt() == 0 ? null : (Parcelable)object.createFromParcel(parcel);
            object = (Bundle)object;
            n2 = parcel.dataAvail();
            if (n2 <= 0) {
                this.u0((Bundle)object);
                return true;
            }
            parcel = new StringBuilder();
            parcel.append("Parcel data not fully consumed, unread size: ");
            parcel.append(n2);
            throw new BadParcelableException(parcel.toString());
        }
        return false;
    }
}

