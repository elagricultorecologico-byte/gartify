/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  android.text.TextUtils
 *  android.util.Log
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.IllegalFormatException
 *  java.util.Locale
 */
package i2;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.util.IllegalFormatException;
import java.util.Locale;

public final class i {
    private final String a;

    public i(String string) {
        int n2 = Process.myUid();
        int n3 = Process.myPid();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UID: [");
        stringBuilder.append(n2);
        stringBuilder.append("]  PID: [");
        stringBuilder.append(n3);
        stringBuilder.append("] ");
        this.a = stringBuilder.toString().concat(string);
    }

    private static String e(String string, String string2, Object ... object) {
        String string3 = string2;
        if (((Object[])object).length > 0) {
            try {
                string3 = String.format((Locale)Locale.US, (String)string2, (Object[])object);
            }
            catch (IllegalFormatException illegalFormatException) {
                Log.e((String)"PlayCore", (String)"Unable to format ".concat(String.valueOf((Object)string2)), (Throwable)illegalFormatException);
                object = TextUtils.join((CharSequence)", ", (Object[])object);
                string3 = new StringBuilder();
                string3.append(string2);
                string3.append(" [");
                string3.append((String)object);
                string3.append("]");
                string3 = string3.toString();
            }
        }
        string2 = new StringBuilder();
        string2.append(string);
        string2.append(" : ");
        string2.append(string3);
        return string2.toString();
    }

    public final int a(String string, Object ... objectArray) {
        if (Log.isLoggable((String)"PlayCore", (int)6)) {
            return Log.e((String)"PlayCore", (String)i.e(this.a, "Play Store app is either not installed or not the official version", objectArray));
        }
        return 0;
    }

    public final int b(Throwable throwable, String string, Object ... objectArray) {
        if (Log.isLoggable((String)"PlayCore", (int)6)) {
            return Log.e((String)"PlayCore", (String)i.e(this.a, string, objectArray), (Throwable)throwable);
        }
        return 0;
    }

    public final int c(String string, Object ... objectArray) {
        if (Log.isLoggable((String)"PlayCore", (int)4)) {
            return Log.i((String)"PlayCore", (String)i.e(this.a, string, objectArray));
        }
        return 0;
    }

    public final int d(String string, Object ... objectArray) {
        if (Log.isLoggable((String)"PlayCore", (int)5)) {
            return Log.w((String)"PlayCore", (String)i.e(this.a, string, objectArray));
        }
        return 0;
    }
}

