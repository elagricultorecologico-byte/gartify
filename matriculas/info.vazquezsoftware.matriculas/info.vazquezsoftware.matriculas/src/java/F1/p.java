/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.Cu0
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.Iterator
 */
package f1;

import android.util.Log;
import com.google.android.gms.internal.ads.Cu0;
import java.util.Iterator;

public abstract class p {
    protected static final Cu0 a = Cu0.c((int)4000);

    /*
     * Enabled aggressive block sorting
     */
    public static void a(String string) {
        if (p.j(3)) {
            if (string.length() <= 4000) {
                Log.d((String)"Ads", (String)string);
                return;
            }
            string = a.d((CharSequence)string).iterator();
            boolean bl = true;
            while (string.hasNext()) {
                String string2 = (String)string.next();
                if (bl) {
                    Log.d((String)"Ads", (String)string2);
                } else {
                    Log.d((String)"Ads-cont", (String)string2);
                }
                bl = false;
            }
        }
    }

    public static void b(String string, Throwable throwable) {
        if (p.j(3)) {
            Log.d((String)"Ads", (String)string, (Throwable)throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void c(String string) {
        if (!p.j(6)) return;
        if (string == null || string.length() <= 4000) {
            Log.e((String)"Ads", (String)string);
            return;
        } else {
            Iterator iterator = a.d((CharSequence)string).iterator();
            boolean bl = true;
            while (iterator.hasNext()) {
                string = (String)iterator.next();
                if (bl) {
                    Log.e((String)"Ads", (String)string);
                } else {
                    Log.e((String)"Ads-cont", (String)string);
                }
                bl = false;
            }
        }
    }

    public static void d(String string, Throwable throwable) {
        if (p.j(6)) {
            Log.e((String)"Ads", (String)string, (Throwable)throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void e(String string) {
        if (!p.j(4)) return;
        if (string == null || string.length() <= 4000) {
            Log.i((String)"Ads", (String)string);
            return;
        } else {
            Iterator iterator = a.d((CharSequence)string).iterator();
            boolean bl = true;
            while (iterator.hasNext()) {
                string = (String)iterator.next();
                if (bl) {
                    Log.i((String)"Ads", (String)string);
                } else {
                    Log.i((String)"Ads-cont", (String)string);
                }
                bl = false;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static void f(String string) {
        if (!p.j(5)) return;
        if (string == null || string.length() <= 4000) {
            Log.w((String)"Ads", (String)string);
            return;
        } else {
            string = a.d((CharSequence)string).iterator();
            boolean bl = true;
            while (string.hasNext()) {
                String string2 = (String)string.next();
                if (bl) {
                    Log.w((String)"Ads", (String)string2);
                } else {
                    Log.w((String)"Ads-cont", (String)string2);
                }
                bl = false;
            }
        }
    }

    public static void g(String string, Throwable throwable) {
        if (p.j(5)) {
            Log.w((String)"Ads", (String)string, (Throwable)throwable);
        }
    }

    static String h(String string) {
        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        String string2 = string;
        if (stackTraceElementArray.length >= 4) {
            int n2 = stackTraceElementArray[3].getLineNumber();
            string2 = new StringBuilder(string.length() + 2 + String.valueOf((int)n2).length());
            string2.append(string);
            string2.append(" @");
            string2.append(n2);
            string2 = string2.toString();
        }
        return string2;
    }

    public static void i(String string, Throwable throwable) {
        if (p.j(5)) {
            if (throwable != null) {
                p.g(p.h(string), throwable);
                return;
            }
            p.f(p.h(string));
        }
    }

    public static boolean j(int n2) {
        return n2 >= 5 || Log.isLoggable((String)"Ads", (int)n2);
        {
        }
    }
}

