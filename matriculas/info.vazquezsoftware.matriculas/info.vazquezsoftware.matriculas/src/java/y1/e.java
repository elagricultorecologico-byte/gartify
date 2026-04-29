/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  java.lang.Object
 */
package y1;

import android.os.Parcel;
import y1.d;

public abstract class e {
    public static byte[] a(d object) {
        Parcel parcel = Parcel.obtain();
        object.writeToParcel(parcel, 0);
        object = parcel.marshall();
        parcel.recycle();
        return object;
    }
}

