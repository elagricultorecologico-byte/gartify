/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  y1.c
 */
package f1;

import android.os.Parcel;
import android.os.Parcelable;
import f1.z;
import y1.c;

public final class a
extends y1.a {
    public static final Parcelable.Creator<a> CREATOR = new z();
    public String g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;

    public a(int n2, int n3, boolean bl) {
        this(n2, n3, bl, false, false);
    }

    public a(int n2, int n3, boolean bl, boolean bl2) {
        this(n2, n3, bl, false, bl2);
    }

    public a(int n2, int n3, boolean bl, boolean bl2, boolean bl3) {
        String string = bl ? "0" : (bl2 ? "2" : "1");
        StringBuilder stringBuilder = new StringBuilder(String.valueOf((int)n2).length() + 13 + String.valueOf((int)n3).length() + 2);
        stringBuilder.append("afma-sdk-a-v");
        stringBuilder.append(n2);
        stringBuilder.append(".");
        stringBuilder.append(n3);
        stringBuilder.append(".");
        stringBuilder.append(string);
        this(stringBuilder.toString(), n2, n3, bl, bl3);
    }

    a(String string, int n2, int n3, boolean bl, boolean bl2) {
        this.g = string;
        this.h = n2;
        this.i = n3;
        this.j = bl;
        this.k = bl2;
    }

    public static a a() {
        return new a(12451000, 12451000, true);
    }

    public void writeToParcel(Parcel parcel, int n2) {
        n2 = c.a((Parcel)parcel);
        c.n((Parcel)parcel, (int)2, (String)this.g, (boolean)false);
        c.h((Parcel)parcel, (int)3, (int)this.h);
        c.h((Parcel)parcel, (int)4, (int)this.i);
        c.c((Parcel)parcel, (int)5, (boolean)this.j);
        c.c((Parcel)parcel, (int)6, (boolean)this.k);
        c.b((Parcel)parcel, (int)n2);
    }
}

