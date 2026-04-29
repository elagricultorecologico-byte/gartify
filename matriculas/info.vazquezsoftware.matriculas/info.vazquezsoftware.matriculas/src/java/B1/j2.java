/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 *  y1.c
 */
package b1;

import android.os.Parcel;
import android.os.Parcelable;
import b1.k2;
import org.json.JSONObject;
import y1.a;
import y1.c;

public final class j2
extends a {
    public static final Parcelable.Creator<j2> CREATOR = new k2();
    public final int g;
    public final int h;
    public final String i;
    public final long j;

    public j2(int n3, int n4, String string, long l3) {
        this.g = n3;
        this.h = n4;
        this.i = string;
        this.j = l3;
    }

    public static j2 a(JSONObject jSONObject) {
        return new j2(jSONObject.getInt("type_num"), jSONObject.getInt("precision_num"), jSONObject.getString("currency"), jSONObject.getLong("value"));
    }

    public final void writeToParcel(Parcel parcel, int n3) {
        int n4 = this.g;
        n3 = c.a((Parcel)parcel);
        c.h((Parcel)parcel, (int)1, (int)n4);
        c.h((Parcel)parcel, (int)2, (int)this.h);
        c.n((Parcel)parcel, (int)3, (String)this.i, (boolean)false);
        c.l((Parcel)parcel, (int)4, (long)this.j);
        c.b((Parcel)parcel, (int)n3);
    }
}

