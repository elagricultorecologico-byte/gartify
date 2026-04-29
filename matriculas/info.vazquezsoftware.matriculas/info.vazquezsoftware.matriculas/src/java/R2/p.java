/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences$Editor
 *  java.lang.Object
 *  java.lang.String
 *  java.text.SimpleDateFormat
 *  java.util.Date
 *  java.util.Locale
 */
package r2;

import android.content.Context;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class p {
    public static void a(Context context) {
        context = context.getSharedPreferences("app_preferences", 0);
        SharedPreferences.Editor editor = context.edit();
        String string = p.c();
        String string2 = context.getString("ia_report_date", "");
        int n2 = context.getInt("ia_report_count", 0);
        if (!string.equals((Object)string2)) {
            editor.putString("ia_report_date", string);
            editor.putInt("ia_report_count", 1);
        } else {
            editor.putInt("ia_report_count", n2 + 1);
        }
        editor.apply();
    }

    public static boolean b(Context context) {
        context = context.getSharedPreferences("app_preferences", 0);
        if (!p.c().equals((Object)context.getString("ia_report_date", ""))) {
            return true;
        }
        return context.getInt("ia_report_count", 0) < 3;
    }

    private static String c() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
    }

    public static boolean d(Context context) {
        return context.getSharedPreferences("app_preferences", 0).getBoolean("has_used_informe_ia", false);
    }

    public static boolean e(Context context) {
        boolean bl = (context = context.getSharedPreferences("app_preferences", 0)).getBoolean("is_first_run", true);
        if (bl) {
            context = context.edit();
            context.putBoolean("is_first_run", false);
            context.apply();
        }
        return bl;
    }

    public static boolean f(Context context) {
        return context.getSharedPreferences("app_preferences", 0).getBoolean("is_premium", false);
    }

    public static void g(Context context, boolean bl) {
        context = context.getSharedPreferences("app_preferences", 0).edit();
        context.putBoolean("is_premium", bl);
        context.apply();
    }

    public static void h(Context context, boolean bl) {
        context = context.getSharedPreferences("app_preferences", 0).edit();
        context.putBoolean("has_used_informe_ia", bl);
        context.apply();
    }
}

