/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 *  y1.c
 */
package d1;

import C1.a;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import d1.b;
import d1.l;
import y1.a;
import y1.c;

public final class m
extends a {
    public static final Parcelable.Creator<m> CREATOR = new l();
    public final String g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final Intent n;
    public final b o;
    public final boolean p;
    public final Bundle q;

    public m(Intent intent, b b2) {
        this(null, null, null, null, null, null, null, intent, C1.b.h1(b2).asBinder(), false, new Bundle());
    }

    public m(String string, String string2, String string3, String string4, String string5, String string6, String string7, Intent intent, IBinder iBinder, boolean bl, Bundle bundle) {
        this.g = string;
        this.h = string2;
        this.i = string3;
        this.j = string4;
        this.k = string5;
        this.l = string6;
        this.m = string7;
        this.n = intent;
        this.o = (b)C1.b.c0(a.a.Z(iBinder));
        this.p = bl;
        this.q = bundle;
    }

    public m(String string, String string2, String string3, String string4, String string5, String string6, String string7, b b2) {
        this(string, string2, string3, string4, string5, string6, string7, null, C1.b.h1(b2).asBinder(), false, new Bundle());
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        String string = this.g;
        int n3 = c.a((Parcel)parcel);
        c.n((Parcel)parcel, (int)2, (String)string, (boolean)false);
        c.n((Parcel)parcel, (int)3, (String)this.h, (boolean)false);
        c.n((Parcel)parcel, (int)4, (String)this.i, (boolean)false);
        c.n((Parcel)parcel, (int)5, (String)this.j, (boolean)false);
        c.n((Parcel)parcel, (int)6, (String)this.k, (boolean)false);
        c.n((Parcel)parcel, (int)7, (String)this.l, (boolean)false);
        c.n((Parcel)parcel, (int)8, (String)this.m, (boolean)false);
        c.m((Parcel)parcel, (int)9, (Parcelable)this.n, (int)n2, (boolean)false);
        c.g((Parcel)parcel, (int)10, (IBinder)C1.b.h1(this.o).asBinder(), (boolean)false);
        c.c((Parcel)parcel, (int)11, (boolean)this.p);
        c.d((Parcel)parcel, (int)12, (Bundle)this.q, (boolean)false);
        c.b((Parcel)parcel, (int)n3);
    }
}

