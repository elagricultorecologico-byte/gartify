/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  com.google.android.gms.common.util.w
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package x1;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.util.w;

public abstract class n {
    public static void a(boolean bl) {
        if (bl) {
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void b(boolean bl, Object object) {
        if (bl) {
            return;
        }
        throw new IllegalArgumentException(String.valueOf((Object)object));
    }

    public static void c(boolean bl, String string, Object ... objectArray) {
        if (bl) {
            return;
        }
        throw new IllegalArgumentException(String.format((String)string, (Object[])objectArray));
    }

    public static void d(Handler object) {
        Object object2 = Looper.myLooper();
        if (object2 != object.getLooper()) {
            object2 = object2 != null ? object2.getThread().getName() : "null current looper";
            object = object.getLooper().getThread().getName();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf((Object)object).length() + 35 + String.valueOf((Object)object2).length() + 1);
            stringBuilder.append("Must be called on ");
            stringBuilder.append((String)object);
            stringBuilder.append(" thread, but got ");
            stringBuilder.append((String)object2);
            stringBuilder.append(".");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public static void e(String string) {
        if (w.a()) {
            return;
        }
        throw new IllegalStateException(string);
    }

    public static String f(String string) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            return string;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public static String g(String string, Object object) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            return string;
        }
        throw new IllegalArgumentException(String.valueOf((Object)object));
    }

    public static void h(String string) {
        if (!w.a()) {
            return;
        }
        throw new IllegalStateException(string);
    }

    public static Object i(Object object) {
        if (object != null) {
            return object;
        }
        throw new NullPointerException("null reference");
    }

    public static Object j(Object object, Object object2) {
        if (object != null) {
            return object;
        }
        throw new NullPointerException(String.valueOf((Object)object2));
    }

    public static void k(boolean bl) {
        if (bl) {
            return;
        }
        throw new IllegalStateException();
    }

    public static void l(boolean bl, Object object) {
        if (bl) {
            return;
        }
        throw new IllegalStateException(String.valueOf((Object)object));
    }
}

