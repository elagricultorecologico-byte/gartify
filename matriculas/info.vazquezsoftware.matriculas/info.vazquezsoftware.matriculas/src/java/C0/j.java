/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Process
 *  android.text.TextUtils
 *  androidx.work.a
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  t0.j
 */
package C0;

import C0.i;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.work.a;

public abstract class j {
    private static final String a = t0.j.f((String)"ProcessUtils");

    public static String a(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return i.a();
        }
        try {
            Object object = Class.forName((String)"android.app.ActivityThread", (boolean)false, (ClassLoader)j.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            object.setAccessible(true);
            object = object.invoke(null, null);
            if (object instanceof String) {
                object = (String)object;
                return object;
            }
        }
        catch (Throwable throwable) {
            t0.j.c().a(a, "Unable to check ActivityThread for processName", new Throwable[]{throwable});
        }
        int n2 = Process.myPid();
        if ((context = (ActivityManager)context.getSystemService("activity")) != null && (context = context.getRunningAppProcesses()) != null && !context.isEmpty()) {
            for (Object object : context) {
                if (object.pid != n2) continue;
                return object.processName;
            }
        }
        return null;
    }

    public static boolean b(Context context, a a2) {
        String string = j.a(context);
        if (!TextUtils.isEmpty((CharSequence)a2.c())) {
            return TextUtils.equals((CharSequence)string, (CharSequence)a2.c());
        }
        return TextUtils.equals((CharSequence)string, (CharSequence)context.getApplicationInfo().processName);
    }
}

