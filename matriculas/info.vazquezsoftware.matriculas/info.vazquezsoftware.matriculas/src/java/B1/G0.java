/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  com.google.android.gms.internal.ads.bf
 *  com.google.android.gms.internal.ads.cf
 *  com.google.android.gms.internal.ads.np
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package b1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b1.N1;
import b1.a0;
import b1.c0;
import b1.d0;
import b1.e0;
import b1.h0;
import com.google.android.gms.internal.ads.bf;
import com.google.android.gms.internal.ads.cf;
import com.google.android.gms.internal.ads.np;
import java.util.ArrayList;
import java.util.List;

public abstract class g0
extends bf
implements h0 {
    public g0() {
        super("com.google.android.gms.ads.internal.client.IAdPreloader");
    }

    protected final boolean K5(int n3, Parcel object, Parcel parcel, int n4) {
        N1 n12 = null;
        Object object2 = null;
        switch (n3) {
            default: {
                return false;
            }
            case 18: {
                n3 = object.readInt();
                cf.h((Parcel)object);
                this.r0(n3);
                parcel.writeNoException();
                break;
            }
            case 17: {
                n3 = object.readInt();
                object2 = object.readString();
                cf.h((Parcel)object);
                n3 = this.R2(n3, (String)object2) ? 1 : 0;
                parcel.writeNoException();
                parcel.writeInt(n3);
                break;
            }
            case 16: {
                n3 = object.readInt();
                object2 = object.readString();
                cf.h((Parcel)object);
                n3 = this.Z3(n3, (String)object2);
                parcel.writeNoException();
                parcel.writeInt(n3);
                break;
            }
            case 15: {
                n3 = object.readInt();
                cf.h((Parcel)object);
                object = this.b0(n3);
                parcel.writeNoException();
                cf.d((Parcel)parcel, (Parcelable)object);
                break;
            }
            case 14: {
                n3 = object.readInt();
                object2 = object.readString();
                cf.h((Parcel)object);
                object = this.F1(n3, (String)object2);
                parcel.writeNoException();
                cf.d((Parcel)parcel, (Parcelable)object);
                break;
            }
            case 13: {
                object2 = object.readString();
                cf.h((Parcel)object);
                object = this.h0((String)object2);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 12: {
                object2 = object.readString();
                cf.h((Parcel)object);
                object = this.Q0((String)object2);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 11: {
                object2 = object.readString();
                cf.h((Parcel)object);
                object = this.t0((String)object2);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 10: {
                n3 = object.readInt();
                object2 = object.readString();
                cf.h((Parcel)object);
                n3 = this.L4(n3, (String)object2) ? 1 : 0;
                parcel.writeNoException();
                parcel.writeInt(n3);
                break;
            }
            case 9: {
                String string = object.readString();
                n12 = (N1)cf.b((Parcel)object, N1.CREATOR);
                IBinder iBinder = object.readStrongBinder();
                if (iBinder != null) {
                    object2 = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloadCallbackV2");
                    object2 = object2 instanceof e0 ? (e0)object2 : new d0(iBinder);
                }
                cf.h((Parcel)object);
                n3 = this.q5(string, n12, (e0)object2) ? 1 : 0;
                parcel.writeNoException();
                parcel.writeInt(n3);
                break;
            }
            case 8: {
                np.L5((IBinder)object.readStrongBinder());
                cf.h((Parcel)object);
                parcel.writeNoException();
                break;
            }
            case 7: {
                object2 = object.readString();
                cf.h((Parcel)object);
                object = this.C0((String)object2);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 6: {
                object2 = object.readString();
                cf.h((Parcel)object);
                n3 = this.P3((String)object2) ? 1 : 0;
                parcel.writeNoException();
                parcel.writeInt(n3);
                break;
            }
            case 5: {
                object2 = object.readString();
                cf.h((Parcel)object);
                object = this.V((String)object2);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 4: {
                object2 = object.readString();
                cf.h((Parcel)object);
                n3 = this.P((String)object2) ? 1 : 0;
                parcel.writeNoException();
                parcel.writeInt(n3);
                break;
            }
            case 3: {
                object2 = object.readString();
                cf.h((Parcel)object);
                object = this.Y((String)object2);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 2: {
                object2 = object.readString();
                cf.h((Parcel)object);
                n3 = this.u((String)object2) ? 1 : 0;
                parcel.writeNoException();
                parcel.writeInt(n3);
                break;
            }
            case 1: {
                ArrayList arrayList = object.createTypedArrayList(N1.CREATOR);
                object2 = object.readStrongBinder();
                object2 = object2 == null ? n12 : ((n12 = object2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloadCallback")) instanceof c0 ? (c0)((Object)n12) : new a0((IBinder)object2));
                cf.h((Parcel)object);
                this.p3((List)arrayList, (c0)object2);
                parcel.writeNoException();
            }
        }
        return true;
    }
}

