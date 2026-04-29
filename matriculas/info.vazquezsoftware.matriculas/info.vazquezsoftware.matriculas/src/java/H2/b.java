/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 */
package h2;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import h2.f;

public abstract class b
implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new f();

    abstract PendingIntent a();

    abstract boolean b();

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable((Parcelable)this.a(), 0);
        parcel.writeInt(this.b() ? 1 : 0);
    }
}

