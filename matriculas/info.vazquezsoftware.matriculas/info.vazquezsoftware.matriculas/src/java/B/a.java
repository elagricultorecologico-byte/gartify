/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Object
 *  java.lang.String
 */
package b;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public interface a
extends IInterface {
    public static final String b = "android$support$customtabs$ICustomTabsCallback".replace('$', '.');

    public void A5(Bundle var1);

    public void D4(Bundle var1);

    public Bundle E3(String var1, Bundle var2);

    public void M2(Bundle var1);

    public void U4(int var1, Uri var2, boolean var3, Bundle var4);

    public void Y4(Bundle var1);

    public void e3(int var1, Bundle var2);

    public void j2(String var1, Bundle var2);

    public void k1(int var1, int var2, Bundle var3);

    public void o4(String var1, Bundle var2);

    public void t2(int var1, int var2, int var3, int var4, int var5, Bundle var6);

    public static abstract class a
    extends Binder
    implements a {
        public a() {
            this.attachInterface(this, b);
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n3, Parcel parcel, Parcel parcel2, int n4) {
            String string = b;
            if (n3 >= 1 && n3 <= 0xFFFFFF) {
                parcel.enforceInterface(string);
            }
            if (n3 == 1598968902) {
                parcel2.writeString(string);
                return true;
            }
            switch (n3) {
                default: {
                    return super.onTransact(n3, parcel, parcel2, n4);
                }
                case 12: {
                    this.A5((Bundle)b.a$b.c(parcel, Bundle.CREATOR));
                    break;
                }
                case 11: {
                    this.Y4((Bundle)b.a$b.c(parcel, Bundle.CREATOR));
                    break;
                }
                case 10: {
                    this.t2(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), (Bundle)b.a$b.c(parcel, Bundle.CREATOR));
                    break;
                }
                case 9: {
                    this.M2((Bundle)b.a$b.c(parcel, Bundle.CREATOR));
                    break;
                }
                case 8: {
                    this.k1(parcel.readInt(), parcel.readInt(), (Bundle)b.a$b.c(parcel, Bundle.CREATOR));
                    break;
                }
                case 7: {
                    parcel = this.E3(parcel.readString(), (Bundle)b.a$b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    b.a$b.d(parcel2, (Parcelable)parcel, 1);
                    break;
                }
                case 6: {
                    n3 = parcel.readInt();
                    parcel2 = (Uri)b.a$b.c(parcel, Uri.CREATOR);
                    boolean bl = parcel.readInt() != 0;
                    this.U4(n3, (Uri)parcel2, bl, (Bundle)b.a$b.c(parcel, Bundle.CREATOR));
                    break;
                }
                case 5: {
                    this.o4(parcel.readString(), (Bundle)b.a$b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    break;
                }
                case 4: {
                    this.D4((Bundle)b.a$b.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    break;
                }
                case 3: {
                    this.j2(parcel.readString(), (Bundle)b.a$b.c(parcel, Bundle.CREATOR));
                    break;
                }
                case 2: {
                    this.e3(parcel.readInt(), (Bundle)b.a$b.c(parcel, Bundle.CREATOR));
                }
            }
            return true;
        }
    }

    public static abstract class b {
        private static Object c(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        private static void d(Parcel parcel, Parcelable parcelable, int n3) {
            if (parcelable != null) {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, n3);
                return;
            }
            parcel.writeInt(0);
        }
    }
}

