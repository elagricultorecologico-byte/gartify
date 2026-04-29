/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageInstaller$SessionInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.os.Build$VERSION
 *  android.os.UserManager
 *  android.util.Log
 *  com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException
 *  com.google.android.gms.common.GooglePlayServicesMissingManifestValueException
 *  com.google.android.gms.common.util.i
 *  com.google.android.gms.common.util.s
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package u1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesMissingManifestValueException;
import com.google.android.gms.common.util.i;
import com.google.android.gms.common.util.s;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import u1.b;
import u1.o;
import u1.p;
import x1.L;
import x1.n;

public abstract class k {
    public static final int a = 12451000;
    static final AtomicBoolean b = new AtomicBoolean();
    private static final AtomicBoolean c = new AtomicBoolean();

    public static int a(Context context) {
        try {
            context = context.getPackageManager().getPackageInfo("com.google.android.gms", 0);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Log.w((String)"GooglePlayServicesUtil", (String)"Google Play services is missing.");
            return 0;
        }
        return context.versionCode;
    }

    public static String b(int n2) {
        return u1.b.i(n2);
    }

    public static Context c(Context context) {
        try {
            context = context.createPackageContext("com.google.android.gms", 3);
            return context;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return null;
        }
    }

    public static Resources d(Context context) {
        try {
            context = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
            return context;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int e(Context context, int n2) {
        PackageInfo packageInfo;
        int n3;
        int n4;
        try {
            context.getResources().getString(p.a);
        }
        catch (Throwable throwable) {
            Log.e((String)"GooglePlayServicesUtil", (String)"The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals((Object)context.getPackageName()) && !c.get()) {
            n4 = L.a(context);
            if (n4 == 0) throw new GooglePlayServicesMissingManifestValueException();
            if (n4 != a) throw new GooglePlayServicesIncorrectManifestValueException(n4);
        }
        boolean bl = i.f((Context)context);
        int n5 = 1;
        n4 = !bl && !i.i((Context)context) ? 1 : 0;
        bl = n2 >= 0;
        n.a(bl);
        String string = context.getPackageName();
        PackageManager packageManager = context.getPackageManager();
        if (n4 != 0) {
            try {
                n3 = Build.VERSION.SDK_INT >= 28 ? 134225984 : 8256;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                Log.w((String)"GooglePlayServicesUtil", (String)String.valueOf((Object)string).concat(" requires the Google Play Store, but it is missing."));
                return 9;
            }
            packageInfo = packageManager.getPackageInfo("com.android.vending", n3);
        } else {
            packageInfo = null;
        }
        try {
            n3 = Build.VERSION.SDK_INT >= 28 ? 0x8000040 : 64;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Log.w((String)"GooglePlayServicesUtil", (String)String.valueOf((Object)string).concat(" requires Google Play services, but they are missing."));
            return n5;
        }
        PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", n3);
        o.a(context);
        if (!o.b(packageInfo2, true)) {
            Log.w((String)"GooglePlayServicesUtil", (String)String.valueOf((Object)string).concat(" requires Google Play services, but their signature is invalid."));
            return 9;
        }
        if (n4 != 0) {
            n.i(packageInfo);
            if (!o.b(packageInfo, true)) {
                Log.w((String)"GooglePlayServicesUtil", (String)String.valueOf((Object)string).concat(" requires Google Play Store, but its signature is invalid."));
                return 9;
            }
        }
        if (n4 != 0 && packageInfo != null && !packageInfo.signatures[0].equals((Object)packageInfo2.signatures[0])) {
            Log.w((String)"GooglePlayServicesUtil", (String)String.valueOf((Object)string).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services."));
            return 9;
        }
        if (s.a((int)packageInfo2.versionCode) < s.a((int)n2)) {
            n4 = packageInfo2.versionCode;
            context = new StringBuilder(String.valueOf((Object)string).length() + 49 + String.valueOf((int)n2).length() + 11 + String.valueOf((int)n4).length());
            context.append("Google Play services out of date for ");
            context.append(string);
            context.append(".  Requires ");
            context.append(n2);
            context.append(" but found ");
            context.append(n4);
            Log.w((String)"GooglePlayServicesUtil", (String)context.toString());
            return 2;
        }
        packageInfo = packageInfo2.applicationInfo;
        context = packageInfo;
        if (packageInfo == null) {
            try {
                context = packageManager.getApplicationInfo("com.google.android.gms", 0);
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                Log.wtf((String)"GooglePlayServicesUtil", (String)String.valueOf((Object)string).concat(" requires Google Play services, but they're missing when getting application info."), (Throwable)nameNotFoundException);
                return n5;
            }
        }
        if (context.enabled) return 0;
        return 3;
    }

    public static boolean f(Context context, int n2) {
        if (n2 == 18) {
            return true;
        }
        if (n2 == 1) {
            return k.i(context, "com.google.android.gms");
        }
        return false;
    }

    public static boolean g(Context context) {
        Object object = context.getSystemService("user");
        n.i(object);
        context = ((UserManager)object).getApplicationRestrictions(context.getPackageName());
        return context != null && "true".equals((Object)context.getString("restricted_profile"));
    }

    public static boolean h(int n2) {
        return n2 == 1 || n2 == 2 || n2 == 3 || n2 == 9;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static boolean i(Context context, String string) {
        List list;
        boolean bl = string.equals((Object)"com.google.android.gms");
        try {
            list = context.getPackageManager().getPackageInstaller().getAllSessions();
        }
        catch (Exception throwable) {
            return false;
        }
        list = list.iterator();
        while (list.hasNext()) {
            if (!string.equals((Object)((PackageInstaller.SessionInfo)list.next()).getAppPackageName())) continue;
            return true;
        }
        list = context.getPackageManager();
        {
            string = list.getApplicationInfo(string, 8192);
            if (bl) {
                return ((ApplicationInfo)string).enabled;
            }
            if (!((ApplicationInfo)string).enabled) return false;
            bl = k.g(context);
            if (bl) return false;
            return true;
        }
    }
}

