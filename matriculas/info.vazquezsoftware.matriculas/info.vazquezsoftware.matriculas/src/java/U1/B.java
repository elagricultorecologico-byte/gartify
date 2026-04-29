/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  u1.s
 *  x1.m
 *  x1.m$a
 *  y1.c
 */
package u1;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import u1.s;
import x1.m;
import y1.a;
import y1.c;

public final class b
extends a {
    public static final Parcelable.Creator<b> CREATOR;
    public static final b l;
    final int g;
    private final int h;
    private final PendingIntent i;
    private final String j;
    private final Integer k;

    static {
        l = new b(0);
        CREATOR = new s();
    }

    public b(int n2) {
        this(n2, null, null);
    }

    b(int n2, int n3, PendingIntent pendingIntent, String string, Integer n4) {
        this.g = n2;
        this.h = n3;
        this.i = pendingIntent;
        this.j = string;
        this.k = n4;
    }

    public b(int n2, PendingIntent pendingIntent) {
        this(n2, pendingIntent, null);
    }

    public b(int n2, PendingIntent pendingIntent, String string) {
        this(1, n2, pendingIntent, string, null);
    }

    static String i(int n2) {
        if (n2 != 99) {
            if (n2 != 1500) {
                switch (n2) {
                    default: {
                        switch (n2) {
                            default: {
                                StringBuilder stringBuilder = new StringBuilder(String.valueOf((int)n2).length() + 20);
                                stringBuilder.append("UNKNOWN_ERROR_CODE(");
                                stringBuilder.append(n2);
                                stringBuilder.append(")");
                                return stringBuilder.toString();
                            }
                            case 25: {
                                return "API_INSTALL_REQUIRED";
                            }
                            case 24: {
                                return "API_DISABLED_FOR_CONNECTION";
                            }
                            case 23: {
                                return "API_DISABLED";
                            }
                            case 22: {
                                return "RESOLUTION_ACTIVITY_NOT_FOUND";
                            }
                            case 21: {
                                return "API_VERSION_UPDATE_REQUIRED";
                            }
                            case 20: {
                                return "RESTRICTED_PROFILE";
                            }
                            case 19: {
                                return "SERVICE_MISSING_PERMISSION";
                            }
                            case 18: {
                                return "SERVICE_UPDATING";
                            }
                            case 17: {
                                return "SIGN_IN_FAILED";
                            }
                            case 16: {
                                return "API_UNAVAILABLE";
                            }
                            case 15: {
                                return "INTERRUPTED";
                            }
                            case 14: {
                                return "TIMEOUT";
                            }
                            case 13: 
                        }
                        return "CANCELED";
                    }
                    case 11: {
                        return "LICENSE_CHECK_FAILED";
                    }
                    case 10: {
                        return "DEVELOPER_ERROR";
                    }
                    case 9: {
                        return "SERVICE_INVALID";
                    }
                    case 8: {
                        return "INTERNAL_ERROR";
                    }
                    case 7: {
                        return "NETWORK_ERROR";
                    }
                    case 6: {
                        return "RESOLUTION_REQUIRED";
                    }
                    case 5: {
                        return "INVALID_ACCOUNT";
                    }
                    case 4: {
                        return "SIGN_IN_REQUIRED";
                    }
                    case 3: {
                        return "SERVICE_DISABLED";
                    }
                    case 2: {
                        return "SERVICE_VERSION_UPDATE_REQUIRED";
                    }
                    case 1: {
                        return "SERVICE_MISSING";
                    }
                    case 0: {
                        return "SUCCESS";
                    }
                    case -1: 
                }
                return "UNKNOWN";
            }
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        return "UNFINISHED";
    }

    public Integer a() {
        return this.k;
    }

    public int b() {
        return this.h;
    }

    public String c() {
        return this.j;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof b)) {
            return false;
        }
        object = (b)object;
        return this.h == ((b)object).h && m.a((Object)this.i, (Object)((b)object).i) && m.a((Object)this.j, (Object)((b)object).j) && m.a((Object)this.k, (Object)((b)object).k);
    }

    public PendingIntent f() {
        return this.i;
    }

    public boolean g() {
        return this.h != 0 && this.i != null;
    }

    public boolean h() {
        return this.h == 0;
    }

    public int hashCode() {
        return m.b((Object[])new Object[]{this.h, this.i, this.j, this.k});
    }

    public String toString() {
        m.a a2 = m.c((Object)this);
        a2.a("statusCode", (Object)b.i(this.h));
        a2.a("resolution", (Object)this.i);
        a2.a("message", (Object)this.j);
        a2.a("clientMethodKey", (Object)this.k);
        return a2.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        int n3 = this.g;
        int n4 = c.a((Parcel)parcel);
        c.h((Parcel)parcel, (int)1, (int)n3);
        c.h((Parcel)parcel, (int)2, (int)this.b());
        c.m((Parcel)parcel, (int)3, (Parcelable)this.f(), (int)n2, (boolean)false);
        c.n((Parcel)parcel, (int)4, (String)this.c(), (boolean)false);
        c.k((Parcel)parcel, (int)5, (Integer)this.a(), (boolean)false);
        c.b((Parcel)parcel, (int)n4);
    }
}

