/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.dynamite.DynamiteModule
 *  com.google.android.gms.dynamite.DynamiteModule$b
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package f1;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
import f1.r;
import f1.s;

public abstract class t {
    public static Object a(Context object, String string, r r2) {
        try {
            object = r2.e(t.c(object).d(string));
            return object;
        }
        catch (Exception exception) {
            throw new s(exception);
        }
    }

    public static Context b(Context context) {
        return t.c(context).b();
    }

    private static DynamiteModule c(Context context) {
        try {
            context = DynamiteModule.e((Context)context, (DynamiteModule.b)DynamiteModule.b, (String)"com.google.android.gms.ads.dynamite");
            return context;
        }
        catch (Exception exception) {
            throw new s(exception);
        }
    }
}

