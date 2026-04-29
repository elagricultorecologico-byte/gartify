/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  com.google.android.gms.internal.ads.Dn
 *  com.google.android.gms.internal.ads.af
 *  com.google.android.gms.internal.ads.cf
 *  com.google.android.gms.internal.ads.op
 *  com.google.android.gms.internal.ads.wn
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package b1;

import C1.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b1.P1;
import b1.y0;
import com.google.android.gms.internal.ads.Dn;
import com.google.android.gms.internal.ads.af;
import com.google.android.gms.internal.ads.cf;
import com.google.android.gms.internal.ads.op;
import com.google.android.gms.internal.ads.wn;
import java.util.ArrayList;
import java.util.List;

public final class w0
extends af
implements y0 {
    w0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override
    public final void C() {
        this.c0(19, this.a());
    }

    @Override
    public final void E1(op op2) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)op2);
        this.c0(11, parcel);
    }

    @Override
    public final void G1(Dn dn2) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)dn2);
        this.c0(12, parcel);
    }

    @Override
    public final void R3(P1 p12) {
        Parcel parcel = this.a();
        cf.c((Parcel)parcel, (Parcelable)p12);
        this.c0(14, parcel);
    }

    @Override
    public final void c() {
        this.c0(1, this.a());
    }

    @Override
    public final void d0(String string) {
        Parcel parcel = this.a();
        parcel.writeString(string);
        this.c0(18, parcel);
    }

    @Override
    public final void e1(String string, a a3) {
        string = this.a();
        string.writeString(null);
        cf.e((Parcel)string, (IInterface)a3);
        this.c0(6, (Parcel)string);
    }

    @Override
    public final List m() {
        Parcel parcel = this.Z(13, this.a());
        ArrayList arrayList = parcel.createTypedArrayList(wn.CREATOR);
        parcel.recycle();
        return arrayList;
    }
}

