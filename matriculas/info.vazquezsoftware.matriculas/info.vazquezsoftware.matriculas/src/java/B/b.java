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
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.Throwable
 */
package b;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public interface b
extends IInterface {
    public static final String c = "android$support$customtabs$ICustomTabsService".replace('$', '.');

    public boolean E2(b.a var1, Bundle var2);

    public boolean H1(b.a var1, Uri var2, Bundle var3);

    public boolean J4(long var1);

    public int V1(b.a var1, String var2, Bundle var3);

    public boolean f1(b.a var1, Uri var2);

    public boolean x5(b.a var1);

    public static abstract class b.b$a
    extends Binder
    implements b {
        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface(c);
            if (iInterface != null && iInterface instanceof b) {
                return (b)iInterface;
            }
            return new a(iBinder);
        }

        private static class a
        implements b {
            private IBinder g;

            a(IBinder iBinder) {
                this.g = iBinder;
            }

            @Override
            public boolean E2(b.a a3, Bundle bundle) {
                boolean bl;
                Parcel parcel;
                Parcel parcel2;
                block3: {
                    parcel2 = Parcel.obtain();
                    parcel = Parcel.obtain();
                    try {
                        parcel2.writeInterfaceToken(c);
                        parcel2.writeStrongInterface((IInterface)a3);
                        bl = false;
                    }
                    catch (Throwable throwable) {
                        parcel.recycle();
                        parcel2.recycle();
                        throw throwable;
                    }
                    b.b(parcel2, (Parcelable)bundle, 0);
                    this.g.transact(10, parcel2, parcel, 0);
                    parcel.readException();
                    int n3 = parcel.readInt();
                    if (n3 == 0) break block3;
                    bl = true;
                }
                parcel.recycle();
                parcel2.recycle();
                return bl;
            }

            @Override
            public boolean H1(b.a a3, Uri uri, Bundle bundle) {
                boolean bl;
                Parcel parcel;
                Parcel parcel2;
                block3: {
                    parcel2 = Parcel.obtain();
                    parcel = Parcel.obtain();
                    try {
                        parcel2.writeInterfaceToken(c);
                        parcel2.writeStrongInterface((IInterface)a3);
                        bl = false;
                    }
                    catch (Throwable throwable) {
                        parcel.recycle();
                        parcel2.recycle();
                        throw throwable;
                    }
                    b.b(parcel2, (Parcelable)uri, 0);
                    b.b(parcel2, (Parcelable)bundle, 0);
                    this.g.transact(11, parcel2, parcel, 0);
                    parcel.readException();
                    int n3 = parcel.readInt();
                    if (n3 == 0) break block3;
                    bl = true;
                }
                parcel.recycle();
                parcel2.recycle();
                return bl;
            }

            @Override
            public boolean J4(long l3) {
                boolean bl;
                Parcel parcel;
                Parcel parcel2;
                block3: {
                    IBinder iBinder;
                    parcel2 = Parcel.obtain();
                    parcel = Parcel.obtain();
                    try {
                        parcel2.writeInterfaceToken(c);
                        parcel2.writeLong(l3);
                        iBinder = this.g;
                        bl = false;
                    }
                    catch (Throwable throwable) {
                        parcel.recycle();
                        parcel2.recycle();
                        throw throwable;
                    }
                    iBinder.transact(2, parcel2, parcel, 0);
                    parcel.readException();
                    int n3 = parcel.readInt();
                    if (n3 == 0) break block3;
                    bl = true;
                }
                parcel.recycle();
                parcel2.recycle();
                return bl;
            }

            @Override
            public int V1(b.a a3, String string, Bundle bundle) {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken(c);
                    parcel.writeStrongInterface((IInterface)a3);
                    parcel.writeString(string);
                    b.b(parcel, (Parcelable)bundle, 0);
                    this.g.transact(8, parcel, parcel2, 0);
                    parcel2.readException();
                    int n3 = parcel2.readInt();
                    return n3;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            public IBinder asBinder() {
                return this.g;
            }

            @Override
            public boolean f1(b.a a3, Uri uri) {
                boolean bl;
                Parcel parcel;
                Parcel parcel2;
                block3: {
                    parcel2 = Parcel.obtain();
                    parcel = Parcel.obtain();
                    try {
                        parcel2.writeInterfaceToken(c);
                        parcel2.writeStrongInterface((IInterface)a3);
                        bl = false;
                    }
                    catch (Throwable throwable) {
                        parcel.recycle();
                        parcel2.recycle();
                        throw throwable;
                    }
                    b.b(parcel2, (Parcelable)uri, 0);
                    this.g.transact(7, parcel2, parcel, 0);
                    parcel.readException();
                    int n3 = parcel.readInt();
                    if (n3 == 0) break block3;
                    bl = true;
                }
                parcel.recycle();
                parcel2.recycle();
                return bl;
            }

            @Override
            public boolean x5(b.a a3) {
                boolean bl;
                Parcel parcel;
                Parcel parcel2;
                block3: {
                    parcel2 = Parcel.obtain();
                    parcel = Parcel.obtain();
                    try {
                        parcel2.writeInterfaceToken(c);
                        parcel2.writeStrongInterface((IInterface)a3);
                        a3 = this.g;
                        bl = false;
                    }
                    catch (Throwable throwable) {
                        parcel.recycle();
                        parcel2.recycle();
                        throw throwable;
                    }
                    a3.transact(3, parcel2, parcel, 0);
                    parcel.readException();
                    int n3 = parcel.readInt();
                    if (n3 == 0) break block3;
                    bl = true;
                }
                parcel.recycle();
                parcel2.recycle();
                return bl;
            }
        }
    }

    public static abstract class b {
        private static void b(Parcel parcel, Parcelable parcelable, int n3) {
            if (parcelable != null) {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, n3);
                return;
            }
            parcel.writeInt(0);
        }
    }
}

