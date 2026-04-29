/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.api.Scope
 *  java.lang.Object
 *  java.lang.String
 */
package x1;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import u1.d;
import x1.Z;
import x1.a;
import x1.i;

public class f
extends y1.a {
    public static final Parcelable.Creator<f> CREATOR = new Z();
    static final Scope[] u = new Scope[0];
    static final d[] v = new d[0];
    final int g;
    final int h;
    final int i;
    String j;
    IBinder k;
    Scope[] l;
    Bundle m;
    Account n;
    d[] o;
    d[] p;
    final boolean q;
    final int r;
    boolean s;
    private final String t;

    f(int n2, int n3, int n4, String string, IBinder iBinder, Scope[] dArray, Bundle dArray2, Account account, d[] dArray3, d[] dArray4, boolean bl, int n5, boolean bl2, String string2) {
        d[] dArray5 = dArray;
        if (dArray == null) {
            dArray5 = u;
        }
        dArray = dArray2;
        if (dArray2 == null) {
            dArray = new Bundle();
        }
        dArray2 = dArray3;
        if (dArray3 == null) {
            dArray2 = v;
        }
        dArray3 = dArray4;
        if (dArray4 == null) {
            dArray3 = v;
        }
        this.g = n2;
        this.h = n3;
        this.i = n4;
        this.j = "com.google.android.gms".equals((Object)string) ? "com.google.android.gms" : string;
        if (n2 < 2) {
            string = iBinder != null ? a.c0(i.a.Z(iBinder)) : null;
            this.n = string;
        } else {
            this.k = iBinder;
            this.n = account;
        }
        this.l = dArray5;
        this.m = dArray;
        this.o = dArray2;
        this.p = dArray3;
        this.q = bl;
        this.r = n5;
        this.s = bl2;
        this.t = string2;
    }

    public String a() {
        return this.t;
    }

    public final void writeToParcel(Parcel parcel, int n2) {
        Z.a(this, parcel, n2);
    }
}

