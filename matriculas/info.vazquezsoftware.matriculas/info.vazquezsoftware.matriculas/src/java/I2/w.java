/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.os.Build
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 */
package i2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import i2.i;
import i2.v;
import java.util.ArrayList;

public abstract class w {
    private static final i a = new i("PhoneskyVerificationUtils");

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean a(Context context) {
        block9: {
            StringBuilder stringBuilder;
            block8: {
                try {
                    boolean bl = context.getPackageManager().getApplicationInfo((String)"com.android.vending", (int)0).enabled;
                    if (bl) break block8;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    a.d("Play Store package is not found.", new Object[0]);
                    return false;
                }
                a.d("Play Store package is disabled.", new Object[0]);
                return false;
            }
            try {
                stringBuilder = context.getPackageManager().getPackageInfo((String)"com.android.vending", (int)64).signatures;
                if (stringBuilder == null) break block9;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                a.d("Play Store package is not found.", new Object[0]);
                return false;
            }
            int n2 = ((Signature[])stringBuilder).length;
            if (n2 != 0) {
                Object object;
                context = new ArrayList();
                for (int i2 = 0; i2 < n2; ++i2) {
                    String string = v.a(stringBuilder[i2].toByteArray());
                    context.add((Object)string);
                    if ("8P1sW0EPJcslw7UzRsiXL64w-O50Ed-RBICtay1g24M".equals((Object)string)) return true;
                    object = Build.TAGS;
                    if (!object.contains((CharSequence)"dev-keys") && !object.contains((CharSequence)"test-keys")) continue;
                    if ("GXWy8XF3vIml3_MfnmSmyuKBpT3B0dWbHRR_4cgq-gA".equals((Object)string)) return true;
                }
                object = a;
                stringBuilder = new StringBuilder();
                if ((context = context.iterator()).hasNext()) {
                    while (true) {
                        stringBuilder.append((CharSequence)context.next());
                        if (!context.hasNext()) break;
                        stringBuilder.append((CharSequence)", ");
                    }
                }
                ((i)object).d(String.format((String)"Play Store package certs are not valid. Found these sha256 certs: [%s].", (Object[])new Object[]{stringBuilder.toString()}), new Object[0]);
                return false;
            }
        }
        a.d("Play Store package is not signed -- possibly self-built package. Could not verify.", new Object[0]);
        return false;
    }
}

