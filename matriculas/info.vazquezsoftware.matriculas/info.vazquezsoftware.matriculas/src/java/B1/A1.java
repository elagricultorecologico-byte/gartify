/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 *  y1.c
 */
package b1;

import T0.b;
import T0.m;
import T0.u;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b1.V0;
import b1.X0;
import b1.z1;
import y1.a;
import y1.c;

public final class a1
extends a {
    public static final Parcelable.Creator<a1> CREATOR = new z1();
    public final int g;
    public final String h;
    public final String i;
    public a1 j;
    public IBinder k;

    public a1(int n3, String string, String string2, a1 a12, IBinder iBinder) {
        this.g = n3;
        this.h = string;
        this.i = string2;
        this.j = a12;
        this.k = iBinder;
    }

    public final b a() {
        Object object;
        a1 a12 = this.j;
        if (a12 == null) {
            object = null;
        } else {
            String string = a12.i;
            object = a12.h;
            object = new b(a12.g, (String)object, string);
        }
        return new b(this.g, this.h, this.i, (b)object);
    }

    public final m b() {
        String string;
        Object object;
        Object object2 = this.j;
        IInterface iInterface = null;
        if (object2 == null) {
            object = null;
        } else {
            string = ((a1)object2).i;
            object = ((a1)object2).h;
            object = new b(((a1)object2).g, (String)object, string);
        }
        int n3 = this.g;
        object2 = this.h;
        string = this.i;
        IBinder iBinder = this.k;
        if (iBinder != null) {
            iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            iInterface = iInterface instanceof X0 ? (X0)iInterface : new V0(iBinder);
        }
        return new m(n3, (String)object2, string, (b)object, u.e((X0)iInterface));
    }

    public final void writeToParcel(Parcel parcel, int n3) {
        int n4 = this.g;
        int n5 = c.a((Parcel)parcel);
        c.h((Parcel)parcel, (int)1, (int)n4);
        c.n((Parcel)parcel, (int)2, (String)this.h, (boolean)false);
        c.n((Parcel)parcel, (int)3, (String)this.i, (boolean)false);
        c.m((Parcel)parcel, (int)4, (Parcelable)this.j, (int)n3, (boolean)false);
        c.g((Parcel)parcel, (int)5, (IBinder)this.k, (boolean)false);
        c.b((Parcel)parcel, (int)n5);
    }
}

