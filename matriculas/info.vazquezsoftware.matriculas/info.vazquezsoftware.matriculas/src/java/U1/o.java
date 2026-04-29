/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.Signature
 *  android.content.pm.SigningInfo
 *  android.os.Build$VERSION
 *  android.util.Log
 *  com.google.android.gms.common.util.a
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Arrays
 */
package u1;

import H1.e;
import H1.i;
import H1.s;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.util.a;
import java.util.Arrays;
import u1.A;
import u1.B;
import u1.D;
import u1.E;
import u1.l;
import u1.m;
import u1.n;

public class o {
    private static o b;
    private final Context a;

    public o(Context context) {
        this.a = context.getApplicationContext();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static o a(Context context) {
        x1.n.i(context);
        Class<o> clazz = o.class;
        synchronized (o.class) {
            Throwable throwable2;
            block4: {
                block3: {
                    try {
                        o o2;
                        if (b != null) break block3;
                        E.a(context);
                        b = o2 = new o(context);
                    }
                    catch (Throwable throwable2) {
                        break block4;
                    }
                }
                // ** MonitorExit[var2_2] (shouldn't be in output)
                return b;
            }
            // ** MonitorExit[var2_2] (shouldn't be in output)
            throw throwable2;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    static final boolean b(PackageInfo var0, boolean var1_1) {
        block24: {
            block28: {
                block22: {
                    block23: {
                        block27: {
                            block25: {
                                block26: {
                                    if (var0 /* !! */  == null) {
                                        return false;
                                    }
                                    var4_2 = var1_1;
                                    if (!var1_1) break block25;
                                    if ("com.android.vending".equals((Object)var0 /* !! */ .packageName)) break block26;
                                    var4_2 = var1_1;
                                    if (!"com.google.android.gms".equals((Object)var0 /* !! */ .packageName)) break block25;
                                }
                                if ((var5_3 /* !! */  = var0 /* !! */ .applicationInfo) == null) {
                                    while (true) {
                                        var4_2 = false;
                                        break;
                                    }
                                } else {
                                    if ((var5_3 /* !! */ .flags & 129) == 0) ** continue;
                                    var4_2 = true;
                                }
                            }
                            if (!var4_2) ** GOTO lbl20
                            var6_5 = D.c;
                            break block27;
lbl20:
                            // 1 sources

                            var6_5 = D.b;
                        }
                        var2_6 = com.google.android.gms.common.util.a.b;
                        var2_6 = Build.VERSION.SDK_INT;
                        if (var2_6 >= 28) break block22;
                        var8_7 /* !! */  = var0 /* !! */ .signatures;
                        var7_8 /* !! */  = null;
                        var5_3 /* !! */  = var7_8 /* !! */ ;
                        if (var8_7 /* !! */  == null) break block23;
                        var5_3 /* !! */  = var7_8 /* !! */ ;
                        if (var8_7 /* !! */ .length != 1) break block23;
                        var5_3 /* !! */  = (ApplicationInfo)var8_7 /* !! */ [0].toByteArray();
                    }
                    if (var5_3 /* !! */  == null) ** GOTO lbl39
                    var5_3 /* !! */  = i.m(var5_3 /* !! */ );
                    ** GOTO lbl62
lbl39:
                    // 1 sources

                    var5_3 /* !! */  = i.l();
                    ** GOTO lbl62
                }
                var1_1 = var2_6 >= 28;
                s.a(var1_1);
                var7_8 /* !! */  = l.a(var0 /* !! */ );
                if (var7_8 /* !! */  == null) ** GOTO lbl61
                if (m.a((SigningInfo)var7_8 /* !! */ ) || n.a((SigningInfo)var7_8 /* !! */ ) == null) ** GOTO lbl61
                var2_6 = i.i;
                var5_3 /* !! */  = new e();
                var7_8 /* !! */  = n.a((SigningInfo)var7_8 /* !! */ );
                var3_9 = var7_8 /* !! */ .length;
                for (var2_6 = 0; var2_6 < var3_9; ++var2_6) {
                    var5_3 /* !! */ .b(var7_8 /* !! */ [var2_6].toByteArray());
                    continue;
                }
                var5_3 /* !! */  = var5_3 /* !! */ .c();
                break block28;
lbl61:
                // 2 sources

                var5_3 /* !! */  = i.l();
            }
            if (var5_3 /* !! */ .isEmpty()) break block24;
            var8_7 /* !! */  = var5_3 /* !! */ .j();
            var3_9 = var8_7 /* !! */ .size();
            for (var2_6 = 0; var2_6 < var3_9; ++var2_6) {
                var5_3 /* !! */  = (ApplicationInfo)((byte[])var8_7 /* !! */ .get(var2_6));
                var7_8 /* !! */  = var6_5.q(0);
                while (var7_8 /* !! */ .hasNext()) {
                    if (!Arrays.equals((byte[])var5_3 /* !! */ , (byte[])((byte[])var7_8 /* !! */ .next()))) continue;
                    return true;
                }
                continue;
            }
            return false;
        }
        try {
            var5_3 /* !! */  = new IllegalArgumentException("Unable to obtain package certificate history.");
            throw var5_3 /* !! */ ;
        }
        catch (IllegalArgumentException var5_4) {
            Log.i((String)"GoogleSignatureVerifier", (String)"package info is not set correctly");
            var0 /* !! */  = var4_2 != false ? o.c(var0 /* !! */ , D.a) : o.c(var0 /* !! */ , new A[]{D.a[0]});
            return var0 /* !! */  != null;
        }
    }

    private static A c(PackageInfo object, A ... aArray) {
        Signature[] signatureArray = object.signatures;
        if (signatureArray != null) {
            if (signatureArray.length != 1) {
                Log.w((String)"GoogleSignatureVerifier", (String)"Package has more than one signature.");
                return null;
            }
            object = object.signatures;
            object = new B(object[0].toByteArray());
            for (int i2 = 0; i2 < aArray.length; ++i2) {
                if (!aArray[i2].equals(object)) continue;
                return aArray[i2];
            }
        }
        return null;
    }
}

