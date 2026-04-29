/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 */
package y1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public abstract class b {
    public static Bundle a(Parcel parcel, int n2) {
        n2 = b.t(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(n3 + n2);
        return bundle;
    }

    public static byte[] b(Parcel parcel, int n2) {
        n2 = b.t(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        byte[] byArray = parcel.createByteArray();
        parcel.setDataPosition(n3 + n2);
        return byArray;
    }

    public static int[] c(Parcel parcel, int n2) {
        n2 = b.t(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        int[] nArray = parcel.createIntArray();
        parcel.setDataPosition(n3 + n2);
        return nArray;
    }

    public static ArrayList d(Parcel parcel, int n2) {
        int n3 = b.t(parcel, n2);
        int n4 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int n5 = parcel.readInt();
        for (n2 = 0; n2 < n5; ++n2) {
            arrayList.add((Object)parcel.readInt());
        }
        parcel.setDataPosition(n4 + n3);
        return arrayList;
    }

    public static Parcelable e(Parcel parcel, int n2, Parcelable.Creator creator) {
        int n3 = b.t(parcel, n2);
        n2 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        creator = (Parcelable)creator.createFromParcel(parcel);
        parcel.setDataPosition(n2 + n3);
        return creator;
    }

    public static String f(Parcel parcel, int n2) {
        int n3 = b.t(parcel, n2);
        n2 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(n2 + n3);
        return string;
    }

    public static String[] g(Parcel parcel, int n2) {
        int n3 = b.t(parcel, n2);
        n2 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        String[] stringArray = parcel.createStringArray();
        parcel.setDataPosition(n2 + n3);
        return stringArray;
    }

    public static ArrayList h(Parcel parcel, int n2) {
        n2 = b.t(parcel, n2);
        int n3 = parcel.dataPosition();
        if (n2 == 0) {
            return null;
        }
        ArrayList arrayList = parcel.createStringArrayList();
        parcel.setDataPosition(n3 + n2);
        return arrayList;
    }

    public static Object[] i(Parcel parcel, int n2, Parcelable.Creator objectArray) {
        int n3 = b.t(parcel, n2);
        n2 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        objectArray = parcel.createTypedArray((Parcelable.Creator)objectArray);
        parcel.setDataPosition(n2 + n3);
        return objectArray;
    }

    public static ArrayList j(Parcel parcel, int n2, Parcelable.Creator creator) {
        int n3 = b.t(parcel, n2);
        n2 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        creator = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(n2 + n3);
        return creator;
    }

    public static void k(Parcel parcel, int n2) {
        if (parcel.dataPosition() == n2) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf((int)n2).length() + 26);
        stringBuilder.append("Overread allowed size end=");
        stringBuilder.append(n2);
        throw new a(stringBuilder.toString(), parcel);
    }

    public static int l(int n2) {
        return (char)n2;
    }

    public static boolean m(Parcel parcel, int n2) {
        b.w(parcel, n2, 4);
        return parcel.readInt() != 0;
    }

    public static float n(Parcel parcel, int n2) {
        b.w(parcel, n2, 4);
        return parcel.readFloat();
    }

    public static int o(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder p(Parcel parcel, int n2) {
        int n3 = b.t(parcel, n2);
        n2 = parcel.dataPosition();
        if (n3 == 0) {
            return null;
        }
        IBinder iBinder = parcel.readStrongBinder();
        parcel.setDataPosition(n2 + n3);
        return iBinder;
    }

    public static int q(Parcel parcel, int n2) {
        b.w(parcel, n2, 4);
        return parcel.readInt();
    }

    public static Integer r(Parcel parcel, int n2) {
        int n3 = b.t(parcel, n2);
        if (n3 == 0) {
            return null;
        }
        b.x(parcel, n2, n3, 4);
        return parcel.readInt();
    }

    public static long s(Parcel parcel, int n2) {
        b.w(parcel, n2, 8);
        return parcel.readLong();
    }

    public static int t(Parcel parcel, int n2) {
        if ((n2 & 0xFFFF0000) != -65536) {
            return (char)(n2 >> 16);
        }
        return parcel.readInt();
    }

    public static void u(Parcel parcel, int n2) {
        n2 = b.t(parcel, n2);
        parcel.setDataPosition(parcel.dataPosition() + n2);
    }

    public static int v(Parcel parcel) {
        int n2 = b.o(parcel);
        int n3 = b.t(parcel, n2);
        int n4 = b.l(n2);
        int n5 = parcel.dataPosition();
        if (n4 == 20293) {
            n2 = n3 + n5;
            if (n2 >= n5 && n2 <= parcel.dataSize()) {
                return n2;
            }
            StringBuilder stringBuilder = new StringBuilder(String.valueOf((int)n5).length() + 32 + String.valueOf((int)n2).length());
            stringBuilder.append("Size read is invalid start=");
            stringBuilder.append(n5);
            stringBuilder.append(" end=");
            stringBuilder.append(n2);
            throw new a(stringBuilder.toString(), parcel);
        }
        throw new a("Expected object header. Got 0x".concat(String.valueOf((Object)Integer.toHexString((int)n2))), parcel);
    }

    private static void w(Parcel parcel, int n2, int n3) {
        if ((n2 = b.t(parcel, n2)) == n3) {
            return;
        }
        String string = Integer.toHexString((int)n2);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf((int)n3).length() + 19 + String.valueOf((int)n2).length() + 4 + String.valueOf((Object)string).length() + 1);
        stringBuilder.append("Expected size ");
        stringBuilder.append(n3);
        stringBuilder.append(" got ");
        stringBuilder.append(n2);
        stringBuilder.append(" (0x");
        stringBuilder.append(string);
        stringBuilder.append(")");
        throw new a(stringBuilder.toString(), parcel);
    }

    private static void x(Parcel parcel, int n2, int n3, int n4) {
        if (n3 == n4) {
            return;
        }
        String string = Integer.toHexString((int)n3);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf((int)n4).length() + 19 + String.valueOf((int)n3).length() + 4 + String.valueOf((Object)string).length() + 1);
        stringBuilder.append("Expected size ");
        stringBuilder.append(n4);
        stringBuilder.append(" got ");
        stringBuilder.append(n3);
        stringBuilder.append(" (0x");
        stringBuilder.append(string);
        stringBuilder.append(")");
        throw new a(stringBuilder.toString(), parcel);
    }

    public static class a
    extends RuntimeException {
        public a(String string, Parcel parcel) {
            int n2 = parcel.dataPosition();
            int n3 = parcel.dataSize();
            parcel = new StringBuilder(String.valueOf((Object)string).length() + 13 + String.valueOf((int)n2).length() + 6 + String.valueOf((int)n3).length());
            parcel.append(string);
            parcel.append(" Parcel: pos=");
            parcel.append(n2);
            parcel.append(" size=");
            parcel.append(n3);
            super(parcel.toString());
        }
    }
}

