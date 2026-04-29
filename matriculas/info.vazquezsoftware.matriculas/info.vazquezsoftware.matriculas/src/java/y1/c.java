/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package y1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public abstract class c {
    public static int a(Parcel parcel) {
        return c.t(parcel, 20293);
    }

    public static void b(Parcel parcel, int n2) {
        c.u(parcel, n2);
    }

    public static void c(Parcel parcel, int n2, boolean bl) {
        c.s(parcel, n2, 4);
        parcel.writeInt(bl ? 1 : 0);
    }

    public static void d(Parcel parcel, int n2, Bundle bundle, boolean bl) {
        if (bundle == null) {
            if (bl) {
                c.s(parcel, n2, 0);
            }
            return;
        }
        n2 = c.t(parcel, n2);
        parcel.writeBundle(bundle);
        c.u(parcel, n2);
    }

    public static void e(Parcel parcel, int n2, byte[] byArray, boolean bl) {
        if (byArray == null) {
            if (bl) {
                c.s(parcel, n2, 0);
            }
            return;
        }
        n2 = c.t(parcel, n2);
        parcel.writeByteArray(byArray);
        c.u(parcel, n2);
    }

    public static void f(Parcel parcel, int n2, float f2) {
        c.s(parcel, n2, 4);
        parcel.writeFloat(f2);
    }

    public static void g(Parcel parcel, int n2, IBinder iBinder, boolean bl) {
        if (iBinder == null) {
            if (bl) {
                c.s(parcel, n2, 0);
            }
            return;
        }
        n2 = c.t(parcel, n2);
        parcel.writeStrongBinder(iBinder);
        c.u(parcel, n2);
    }

    public static void h(Parcel parcel, int n2, int n3) {
        c.s(parcel, n2, 4);
        parcel.writeInt(n3);
    }

    public static void i(Parcel parcel, int n2, int[] nArray, boolean bl) {
        if (nArray == null) {
            if (bl) {
                c.s(parcel, n2, 0);
            }
            return;
        }
        n2 = c.t(parcel, n2);
        parcel.writeIntArray(nArray);
        c.u(parcel, n2);
    }

    public static void j(Parcel parcel, int n2, List list, boolean bl) {
        int n3 = 0;
        if (list == null) {
            if (bl) {
                c.s(parcel, n2, 0);
            }
            return;
        }
        int n4 = c.t(parcel, n2);
        int n5 = list.size();
        parcel.writeInt(n5);
        for (n2 = n3; n2 < n5; ++n2) {
            parcel.writeInt(((Integer)list.get(n2)).intValue());
        }
        c.u(parcel, n4);
    }

    public static void k(Parcel parcel, int n2, Integer n3, boolean bl) {
        if (n3 == null) {
            if (bl) {
                c.s(parcel, n2, 0);
            }
            return;
        }
        c.s(parcel, n2, 4);
        parcel.writeInt(n3.intValue());
    }

    public static void l(Parcel parcel, int n2, long l2) {
        c.s(parcel, n2, 8);
        parcel.writeLong(l2);
    }

    public static void m(Parcel parcel, int n2, Parcelable parcelable, int n3, boolean bl) {
        if (parcelable == null) {
            if (bl) {
                c.s(parcel, n2, 0);
            }
            return;
        }
        n2 = c.t(parcel, n2);
        parcelable.writeToParcel(parcel, n3);
        c.u(parcel, n2);
    }

    public static void n(Parcel parcel, int n2, String string, boolean bl) {
        if (string == null) {
            if (bl) {
                c.s(parcel, n2, 0);
            }
            return;
        }
        n2 = c.t(parcel, n2);
        parcel.writeString(string);
        c.u(parcel, n2);
    }

    public static void o(Parcel parcel, int n2, String[] stringArray, boolean bl) {
        if (stringArray == null) {
            if (bl) {
                c.s(parcel, n2, 0);
            }
            return;
        }
        n2 = c.t(parcel, n2);
        parcel.writeStringArray(stringArray);
        c.u(parcel, n2);
    }

    public static void p(Parcel parcel, int n2, List list, boolean bl) {
        if (list == null) {
            if (bl) {
                c.s(parcel, n2, 0);
            }
            return;
        }
        n2 = c.t(parcel, n2);
        parcel.writeStringList(list);
        c.u(parcel, n2);
    }

    public static void q(Parcel parcel, int n2, Parcelable[] parcelableArray, int n3, boolean bl) {
        if (parcelableArray == null) {
            if (bl) {
                c.s(parcel, n2, 0);
            }
            return;
        }
        int n4 = c.t(parcel, n2);
        int n5 = parcelableArray.length;
        parcel.writeInt(n5);
        for (n2 = 0; n2 < n5; ++n2) {
            Parcelable parcelable = parcelableArray[n2];
            if (parcelable == null) {
                parcel.writeInt(0);
                continue;
            }
            c.v(parcel, parcelable, n3);
        }
        c.u(parcel, n4);
    }

    public static void r(Parcel parcel, int n2, List list, boolean bl) {
        if (list == null) {
            if (bl) {
                c.s(parcel, n2, 0);
            }
            return;
        }
        int n3 = c.t(parcel, n2);
        int n4 = list.size();
        parcel.writeInt(n4);
        for (n2 = 0; n2 < n4; ++n2) {
            Parcelable parcelable = (Parcelable)list.get(n2);
            if (parcelable == null) {
                parcel.writeInt(0);
                continue;
            }
            c.v(parcel, parcelable, 0);
        }
        c.u(parcel, n3);
    }

    private static void s(Parcel parcel, int n2, int n3) {
        parcel.writeInt(n2 | n3 << 16);
    }

    private static int t(Parcel parcel, int n2) {
        parcel.writeInt(n2 | 0xFFFF0000);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void u(Parcel parcel, int n2) {
        int n3 = parcel.dataPosition();
        parcel.setDataPosition(n2 - 4);
        parcel.writeInt(n3 - n2);
        parcel.setDataPosition(n3);
    }

    private static void v(Parcel parcel, Parcelable parcelable, int n2) {
        int n3 = parcel.dataPosition();
        parcel.writeInt(1);
        int n4 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, n2);
        n2 = parcel.dataPosition();
        parcel.setDataPosition(n3);
        parcel.writeInt(n2 - n4);
        parcel.setDataPosition(n2);
    }
}

