/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.Pair
 *  com.google.android.gms.internal.ads.FS
 *  com.google.android.gms.internal.ads.Fu
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.QS
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.qf0
 *  com.google.android.gms.internal.ads.rc0
 *  com.google.android.gms.internal.ads.zc0
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Map
 */
package l1;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import b1.A;
import b1.b0;
import b1.c2;
import com.google.android.gms.internal.ads.FS;
import com.google.android.gms.internal.ads.Fu;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.QS;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.qf0;
import com.google.android.gms.internal.ads.rc0;
import com.google.android.gms.internal.ads.zc0;
import java.util.Map;
import l1.g0;

public abstract class h0 {
    public static boolean a(rc0 rc02) {
        return h0.g(rc02.a.a) != 1;
    }

    public static String b(String string) {
        int n2;
        block23: {
            if (TextUtils.isEmpty((CharSequence)string)) {
                return "unspecified";
            }
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 1743582870: {
                    if (!string.equals((Object)"requester_type_8")) break;
                    n2 = 8;
                    break block23;
                }
                case 1743582869: {
                    if (!string.equals((Object)"requester_type_7")) break;
                    n2 = 7;
                    break block23;
                }
                case 1743582868: {
                    if (!string.equals((Object)"requester_type_6")) break;
                    n2 = 6;
                    break block23;
                }
                case 1743582867: {
                    if (!string.equals((Object)"requester_type_5")) break;
                    n2 = 5;
                    break block23;
                }
                case 1743582866: {
                    if (!string.equals((Object)"requester_type_4")) break;
                    n2 = 4;
                    break block23;
                }
                case 1743582865: {
                    if (!string.equals((Object)"requester_type_3")) break;
                    n2 = 3;
                    break block23;
                }
                case 1743582864: {
                    if (!string.equals((Object)"requester_type_2")) break;
                    n2 = 2;
                    break block23;
                }
                case 1743582863: {
                    if (!string.equals((Object)"requester_type_1")) break;
                    n2 = 1;
                    break block23;
                }
                case 1743582862: {
                    if (!string.equals((Object)"requester_type_0")) break;
                    n2 = 0;
                    break block23;
                }
            }
            n2 = -1;
        }
        switch (n2) {
            default: {
                return string;
            }
            case 8: {
                return "8";
            }
            case 7: {
                return "7";
            }
            case 6: {
                return "6";
            }
            case 5: {
                return "5";
            }
            case 4: {
                return "4";
            }
            case 3: {
                return "3";
            }
            case 2: {
                return "2";
            }
            case 1: {
                return "1";
            }
            case 0: 
        }
        return "0";
    }

    public static String c(c2 c22) {
        if (c22 != null && (c22 = c22.i) != null) {
            return c22.getString("query_info_type");
        }
        return "unspecified";
    }

    public static qf0 d(Bundle object) {
        int n2;
        block24: {
            Bundle bundle = object.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
            if (bundle != null) {
                object = bundle;
            }
            if (TextUtils.isEmpty((CharSequence)(object = object.getString("query_info_type")))) {
                return qf0.i;
            }
            switch (object.hashCode()) {
                default: {
                    break;
                }
                case 1743582870: {
                    if (!object.equals((Object)"requester_type_8")) break;
                    n2 = 8;
                    break block24;
                }
                case 1743582869: {
                    if (!object.equals((Object)"requester_type_7")) break;
                    n2 = 7;
                    break block24;
                }
                case 1743582868: {
                    if (!object.equals((Object)"requester_type_6")) break;
                    n2 = 6;
                    break block24;
                }
                case 1743582867: {
                    if (!object.equals((Object)"requester_type_5")) break;
                    n2 = 5;
                    break block24;
                }
                case 1743582866: {
                    if (!object.equals((Object)"requester_type_4")) break;
                    n2 = 4;
                    break block24;
                }
                case 1743582865: {
                    if (!object.equals((Object)"requester_type_3")) break;
                    n2 = 3;
                    break block24;
                }
                case 1743582864: {
                    if (!object.equals((Object)"requester_type_2")) break;
                    n2 = 2;
                    break block24;
                }
                case 1743582863: {
                    if (!object.equals((Object)"requester_type_1")) break;
                    n2 = 1;
                    break block24;
                }
                case 1743582862: {
                    if (!object.equals((Object)"requester_type_0")) break;
                    n2 = 0;
                    break block24;
                }
            }
            n2 = -1;
        }
        switch (n2) {
            default: {
                return qf0.i;
            }
            case 8: {
                return qf0.q;
            }
            case 7: {
                return qf0.p;
            }
            case 6: {
                return qf0.o;
            }
            case 5: {
                return qf0.n;
            }
            case 4: {
                return qf0.m;
            }
            case 3: {
                return qf0.l;
            }
            case 2: {
                return qf0.k;
            }
            case 1: {
                return qf0.j;
            }
            case 0: 
        }
        return qf0.h;
    }

    public static void e(QS qS, FS fS, String string, Pair ... pairArray) {
        fS = Yi.T7;
        if (!((Boolean)A.c().d((Oi)fS)).booleanValue()) {
            return;
        }
        Fu.a.execute((Runnable)new g0(qS, null, string, pairArray));
    }

    static /* synthetic */ void f(QS qS, FS fS, String string, Pair[] pairArray) {
        fS = qS.d();
        h0.h((Map)fS, "action", string);
        for (int i2 = 0; i2 < pairArray.length; ++i2) {
            string = pairArray[i2];
            h0.h((Map)fS, (String)((Pair)string).first, (String)((Pair)string).second);
        }
        qS.b((Map)fS);
    }

    public static int g(zc0 object) {
        if (object.s) {
            return 2;
        }
        object = object.d;
        b0 b02 = object.y;
        if (b02 == null && object.D == null) {
            return 1;
        }
        if (b02 != null && object.D != null) {
            return 5;
        }
        if (b02 != null) {
            return 3;
        }
        return 4;
    }

    private static void h(Map map, String string, String string2) {
        if (!TextUtils.isEmpty((CharSequence)string) && !TextUtils.isEmpty((CharSequence)string2)) {
            map.put((Object)string, (Object)string2);
        }
    }
}

