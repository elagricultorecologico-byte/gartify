/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  com.google.android.gms.internal.ads.Os
 *  com.google.android.gms.internal.ads.Ps
 *  com.google.android.gms.internal.ads.Sk
 *  com.google.android.gms.internal.ads.Tk
 *  com.google.android.gms.internal.ads.Xq
 *  com.google.android.gms.internal.ads.Xt
 *  com.google.android.gms.internal.ads.Yq
 *  com.google.android.gms.internal.ads.Zt
 *  com.google.android.gms.internal.ads.af
 *  com.google.android.gms.internal.ads.cf
 *  com.google.android.gms.internal.ads.er
 *  com.google.android.gms.internal.ads.fr
 *  com.google.android.gms.internal.ads.op
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 */
package b1;

import C1.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b1.O;
import b1.Q;
import b1.R0;
import b1.T;
import b1.T0;
import b1.V;
import b1.f0;
import b1.h0;
import b1.h2;
import b1.o0;
import b1.w0;
import b1.y0;
import com.google.android.gms.internal.ads.Os;
import com.google.android.gms.internal.ads.Ps;
import com.google.android.gms.internal.ads.Sk;
import com.google.android.gms.internal.ads.Tk;
import com.google.android.gms.internal.ads.Xq;
import com.google.android.gms.internal.ads.Xt;
import com.google.android.gms.internal.ads.Yq;
import com.google.android.gms.internal.ads.Zt;
import com.google.android.gms.internal.ads.af;
import com.google.android.gms.internal.ads.cf;
import com.google.android.gms.internal.ads.er;
import com.google.android.gms.internal.ads.fr;
import com.google.android.gms.internal.ads.op;

public final class m0
extends af
implements o0 {
    m0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override
    public final Tk I5(a a3, a a4) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)a3);
        cf.e((Parcel)parcel, (IInterface)a4);
        a4 = this.Z(5, parcel);
        a3 = Sk.L5((IBinder)a4.readStrongBinder());
        a4.recycle();
        return a3;
    }

    @Override
    public final y0 J5(a object, int n3) {
        IInterface iInterface;
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)object);
        parcel.writeInt(260910000);
        parcel = this.Z(9, parcel);
        object = parcel.readStrongBinder();
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager")) instanceof y0 ? (y0)iInterface : new w0((IBinder)object));
        parcel.recycle();
        return object;
    }

    @Override
    public final Q S1(a object, String string, op op2, int n3) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)object);
        parcel.writeString(string);
        cf.e((Parcel)parcel, (IInterface)op2);
        parcel.writeInt(260910000);
        string = this.Z(3, parcel);
        object = string.readStrongBinder();
        object = object == null ? null : ((op2 = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder")) instanceof Q ? (Q)op2 : new O((IBinder)object));
        string.recycle();
        return object;
    }

    @Override
    public final V V3(a object, h2 h22, String string, op op2, int n3) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)object);
        cf.c((Parcel)parcel, (Parcelable)h22);
        parcel.writeString(string);
        cf.e((Parcel)parcel, (IInterface)op2);
        parcel.writeInt(260910000);
        h22 = this.Z(2, parcel);
        object = h22.readStrongBinder();
        object = object == null ? null : ((string = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager")) instanceof V ? (V)((Object)string) : new T((IBinder)object));
        h22.recycle();
        return object;
    }

    @Override
    public final V X0(a object, h2 h22, String string, op op2, int n3) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)object);
        cf.c((Parcel)parcel, (Parcelable)h22);
        parcel.writeString(string);
        cf.e((Parcel)parcel, (IInterface)op2);
        parcel.writeInt(260910000);
        h22 = this.Z(13, parcel);
        string = h22.readStrongBinder();
        object = string == null ? null : ((object = string.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager")) instanceof V ? (V)object : new T((IBinder)string));
        h22.recycle();
        return object;
    }

    @Override
    public final Yq f3(a a3, op op2, int n3) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)a3);
        cf.e((Parcel)parcel, (IInterface)op2);
        parcel.writeInt(260910000);
        a3 = this.Z(15, parcel);
        op2 = Xq.L5((IBinder)a3.readStrongBinder());
        a3.recycle();
        return op2;
    }

    @Override
    public final Zt g4(a a3, op op2, int n3) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)a3);
        cf.e((Parcel)parcel, (IInterface)op2);
        parcel.writeInt(260910000);
        a3 = this.Z(14, parcel);
        op2 = Xt.L5((IBinder)a3.readStrongBinder());
        a3.recycle();
        return op2;
    }

    @Override
    public final V h5(a object, h2 h22, String string, op op2, int n3) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)object);
        cf.c((Parcel)parcel, (Parcelable)h22);
        parcel.writeString(string);
        cf.e((Parcel)parcel, (IInterface)op2);
        parcel.writeInt(260910000);
        h22 = this.Z(1, parcel);
        object = h22.readStrongBinder();
        object = object == null ? null : ((string = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager")) instanceof V ? (V)((Object)string) : new T((IBinder)object));
        h22.recycle();
        return object;
    }

    @Override
    public final h0 q1(a object, op op2, int n3) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)object);
        cf.e((Parcel)parcel, (IInterface)op2);
        parcel.writeInt(260910000);
        op2 = this.Z(18, parcel);
        object = op2.readStrongBinder();
        object = object == null ? null : ((parcel = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloader")) instanceof h0 ? (h0)parcel : new f0((IBinder)object));
        op2.recycle();
        return object;
    }

    @Override
    public final fr s0(a a3) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)a3);
        a3 = this.Z(8, parcel);
        parcel = er.L5((IBinder)a3.readStrongBinder());
        a3.recycle();
        return parcel;
    }

    @Override
    public final T0 w5(a object, op op2, int n3) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)object);
        cf.e((Parcel)parcel, (IInterface)op2);
        parcel.writeInt(260910000);
        op2 = this.Z(17, parcel);
        object = op2.readStrongBinder();
        object = object == null ? null : ((parcel = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTester")) instanceof T0 ? (T0)parcel : new R0((IBinder)object));
        op2.recycle();
        return object;
    }

    @Override
    public final Ps z2(a a3, String string, op op2, int n3) {
        Parcel parcel = this.a();
        cf.e((Parcel)parcel, (IInterface)a3);
        parcel.writeString(string);
        cf.e((Parcel)parcel, (IInterface)op2);
        parcel.writeInt(260910000);
        a3 = this.Z(12, parcel);
        string = Os.L5((IBinder)a3.readStrongBinder());
        a3.recycle();
        return string;
    }
}

