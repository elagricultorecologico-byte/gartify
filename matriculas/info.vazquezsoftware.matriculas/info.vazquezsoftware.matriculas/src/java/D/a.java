/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package d;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public final class a
implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator(){

        public a a(Parcel parcel) {
            return new a(parcel);
        }

        public a[] b(int n2) {
            return new a[n2];
        }
    };
    private final int g;
    private final Intent h;

    public a(int n2, Intent intent) {
        this.g = n2;
        this.h = intent;
    }

    a(Parcel object) {
        this.g = object.readInt();
        object = object.readInt() == 0 ? null : (Intent)Intent.CREATOR.createFromParcel(object);
        this.h = object;
    }

    public static String c(int n2) {
        if (n2 != -1) {
            if (n2 != 0) {
                return String.valueOf((int)n2);
            }
            return "RESULT_CANCELED";
        }
        return "RESULT_OK";
    }

    public Intent a() {
        return this.h;
    }

    public int b() {
        return this.g;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActivityResult{resultCode=");
        stringBuilder.append(a.c(this.g));
        stringBuilder.append(", data=");
        stringBuilder.append((Object)this.h);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeInt(this.g);
        int n3 = this.h == null ? 0 : 1;
        parcel.writeInt(n3);
        Intent intent = this.h;
        if (intent != null) {
            intent.writeToParcel(parcel, n2);
        }
    }
}

