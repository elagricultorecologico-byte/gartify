/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  com.google.android.gms.internal.ads.bf
 *  com.google.android.gms.internal.ads.cf
 *  com.google.android.gms.internal.ads.dn
 *  com.google.android.gms.internal.ads.en
 *  com.google.android.gms.internal.ads.np
 *  com.google.android.gms.internal.ads.op
 *  java.lang.Object
 *  java.lang.String
 */
package b1;

import C1.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import b1.h2;
import b1.o0;
import com.google.android.gms.internal.ads.bf;
import com.google.android.gms.internal.ads.cf;
import com.google.android.gms.internal.ads.dn;
import com.google.android.gms.internal.ads.en;
import com.google.android.gms.internal.ads.np;
import com.google.android.gms.internal.ads.op;

public abstract class n0
extends bf
implements o0 {
    public n0() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    protected final boolean K5(int n3, Parcel object, Parcel parcel, int n4) {
        switch (n3) {
            default: {
                return false;
            }
            case 18: {
                a a3 = a.a.Z(object.readStrongBinder());
                op op2 = np.L5((IBinder)object.readStrongBinder());
                n3 = object.readInt();
                cf.h((Parcel)object);
                object = this.q1(a3, op2, n3);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 17: {
                a a4 = a.a.Z(object.readStrongBinder());
                op op3 = np.L5((IBinder)object.readStrongBinder());
                n3 = object.readInt();
                cf.h((Parcel)object);
                object = this.w5(a4, op3, n3);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 16: {
                a a5 = a.a.Z(object.readStrongBinder());
                op op4 = np.L5((IBinder)object.readStrongBinder());
                n3 = object.readInt();
                en en2 = dn.L5((IBinder)object.readStrongBinder());
                cf.h((Parcel)object);
                object = this.l3(a5, op4, n3, en2);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 15: {
                a a6 = a.a.Z(object.readStrongBinder());
                op op5 = np.L5((IBinder)object.readStrongBinder());
                n3 = object.readInt();
                cf.h((Parcel)object);
                object = this.f3(a6, op5, n3);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 14: {
                a a7 = a.a.Z(object.readStrongBinder());
                op op6 = np.L5((IBinder)object.readStrongBinder());
                n3 = object.readInt();
                cf.h((Parcel)object);
                object = this.g4(a7, op6, n3);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 13: {
                a a8 = a.a.Z(object.readStrongBinder());
                h2 h22 = (h2)cf.b((Parcel)object, h2.CREATOR);
                String string = object.readString();
                op op7 = np.L5((IBinder)object.readStrongBinder());
                n3 = object.readInt();
                cf.h((Parcel)object);
                object = this.X0(a8, h22, string, op7, n3);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 12: {
                a a9 = a.a.Z(object.readStrongBinder());
                String string = object.readString();
                op op8 = np.L5((IBinder)object.readStrongBinder());
                n3 = object.readInt();
                cf.h((Parcel)object);
                object = this.z2(a9, string, op8, n3);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 11: {
                a a10 = a.a.Z(object.readStrongBinder());
                a a11 = a.a.Z(object.readStrongBinder());
                a a12 = a.a.Z(object.readStrongBinder());
                cf.h((Parcel)object);
                object = this.h4(a10, a11, a12);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 10: {
                a a13 = a.a.Z(object.readStrongBinder());
                h2 h23 = (h2)cf.b((Parcel)object, h2.CREATOR);
                String string = object.readString();
                n3 = object.readInt();
                cf.h((Parcel)object);
                object = this.s5(a13, h23, string, n3);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 9: {
                a a14 = a.a.Z(object.readStrongBinder());
                n3 = object.readInt();
                cf.h((Parcel)object);
                object = this.J5(a14, n3);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 8: {
                a a15 = a.a.Z(object.readStrongBinder());
                cf.h((Parcel)object);
                object = this.s0(a15);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 7: {
                a.a.Z(object.readStrongBinder());
                cf.h((Parcel)object);
                parcel.writeNoException();
                cf.e((Parcel)parcel, null);
                break;
            }
            case 6: {
                a a16 = a.a.Z(object.readStrongBinder());
                op op9 = np.L5((IBinder)object.readStrongBinder());
                n3 = object.readInt();
                cf.h((Parcel)object);
                object = this.I3(a16, op9, n3);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 5: {
                a a17 = a.a.Z(object.readStrongBinder());
                a a18 = a.a.Z(object.readStrongBinder());
                cf.h((Parcel)object);
                object = this.I5(a17, a18);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 4: {
                a.a.Z(object.readStrongBinder());
                cf.h((Parcel)object);
                parcel.writeNoException();
                cf.e((Parcel)parcel, null);
                break;
            }
            case 3: {
                a a19 = a.a.Z(object.readStrongBinder());
                String string = object.readString();
                op op10 = np.L5((IBinder)object.readStrongBinder());
                n3 = object.readInt();
                cf.h((Parcel)object);
                object = this.S1(a19, string, op10, n3);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 2: {
                a a20 = a.a.Z(object.readStrongBinder());
                h2 h24 = (h2)cf.b((Parcel)object, h2.CREATOR);
                String string = object.readString();
                op op11 = np.L5((IBinder)object.readStrongBinder());
                n3 = object.readInt();
                cf.h((Parcel)object);
                object = this.V3(a20, h24, string, op11, n3);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
                break;
            }
            case 1: {
                a a21 = a.a.Z(object.readStrongBinder());
                h2 h25 = (h2)cf.b((Parcel)object, h2.CREATOR);
                String string = object.readString();
                op op12 = np.L5((IBinder)object.readStrongBinder());
                n3 = object.readInt();
                cf.h((Parcel)object);
                object = this.h5(a21, h25, string, op12, n3);
                parcel.writeNoException();
                cf.e((Parcel)parcel, (IInterface)object);
            }
        }
        return true;
    }
}

