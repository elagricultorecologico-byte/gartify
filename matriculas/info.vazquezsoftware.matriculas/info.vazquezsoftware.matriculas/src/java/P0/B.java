/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Trace
 *  android.util.Log
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.NoClassDefFoundError
 *  java.lang.NoSuchMethodError
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package p0;

import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p0.a;
import p0.c;

public abstract class b {
    private static long a;
    private static Method b;

    public static void a(String string) {
        c.a(string);
    }

    public static void b() {
        c.b();
    }

    private static void c(String string, Exception exception) {
        if (exception instanceof InvocationTargetException) {
            string = exception.getCause();
            if (string instanceof RuntimeException) {
                throw (RuntimeException)((Object)string);
            }
            throw new RuntimeException((Throwable)string);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to call ");
        stringBuilder.append(string);
        stringBuilder.append(" via reflection");
        Log.v((String)"Trace", (String)stringBuilder.toString(), (Throwable)exception);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean d() {
        try {
            if (b != null) return p0.b.e();
            return p0.a.a();
        }
        catch (NoClassDefFoundError | NoSuchMethodError throwable) {
            return p0.b.e();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean e() {
        try {
            if (b != null) return (Boolean)b.invoke(null, new Object[]{a});
            a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
            b = Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});
            return (Boolean)b.invoke(null, new Object[]{a});
        }
        catch (Exception exception) {}
        p0.b.c("isTagEnabled", exception);
        return false;
    }
}

