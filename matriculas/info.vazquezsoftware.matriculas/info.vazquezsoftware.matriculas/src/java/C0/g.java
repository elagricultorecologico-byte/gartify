/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  t0.j
 */
package C0;

import android.content.ComponentName;
import android.content.Context;
import t0.j;

public abstract class g {
    private static final String a = j.f((String)"PackageManagerHelper");

    public static void a(Context object, Class object2, boolean bl) {
        j j2;
        int n2;
        Object object3;
        Object object4;
        String string = "disabled";
        try {
            object4 = object.getPackageManager();
            object3 = new ComponentName(object, object2.getName());
            n2 = bl ? 1 : 2;
        }
        catch (Exception exception) {
            j2 = j.c();
            object4 = a;
            object2 = object2.getName();
            object = string;
            if (bl) {
                object = "enabled";
            }
            j2.a((String)object4, String.format((String)"%s could not be %s", (Object[])new Object[]{object2, object}), new Throwable[]{exception});
            return;
        }
        object4.setComponentEnabledSetting(object3, n2, 1);
        j2 = j.c();
        object3 = a;
        object4 = object2.getName();
        object = bl ? "enabled" : "disabled";
        j2.a((String)object3, String.format((String)"%s %s", (Object[])new Object[]{object4, object}), new Throwable[0]);
    }
}

