/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.concurrent.CopyOnWriteArraySet
 *  java.util.logging.Handler
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package w3;

import I2.E;
import V2.k;
import android.util.Log;
import b3.h;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import m3.w;
import w3.f;

public final class e {
    public static final e a = new e();
    private static final CopyOnWriteArraySet b = new CopyOnWriteArraySet();
    private static final Map c;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object object = w.class.getPackage();
        object = object == null ? null : object.getName();
        if (object != null) {
            linkedHashMap.put(object, (Object)"OkHttp");
        }
        object = w.class.getName();
        k.d(object, "OkHttpClient::class.java.name");
        linkedHashMap.put(object, (Object)"okhttp.OkHttpClient");
        object = u3.e.class.getName();
        k.d(object, "Http2::class.java.name");
        linkedHashMap.put(object, (Object)"okhttp.Http2");
        object = q3.e.class.getName();
        k.d(object, "TaskRunner::class.java.name");
        linkedHashMap.put(object, (Object)"okhttp.TaskRunner");
        linkedHashMap.put((Object)"okhttp3.mockwebserver.MockWebServer", (Object)"okhttp.MockWebServer");
        c = E.k((Map)linkedHashMap);
    }

    private e() {
    }

    private final void c(String string, String string2) {
        Logger logger = Logger.getLogger((String)string);
        if (b.add((Object)logger)) {
            logger.setUseParentHandlers(false);
            string = Log.isLoggable((String)string2, (int)3) ? Level.FINE : (Log.isLoggable((String)string2, (int)4) ? Level.INFO : Level.WARNING);
            logger.setLevel((Level)string);
            logger.addHandler((Handler)f.a);
        }
    }

    private final String d(String string) {
        String string2 = (String)c.get((Object)string);
        if (string2 == null) {
            return h.w0(string, 23);
        }
        return string2;
    }

    public final void a(String string, int n2, String string2, Throwable throwable) {
        k.e(string, "loggerName");
        k.e(string2, "message");
        String string3 = this.d(string);
        if (Log.isLoggable((String)string3, (int)n2)) {
            string = string2;
            if (throwable != null) {
                string = new StringBuilder();
                string.append(string2);
                string.append('\n');
                string.append((Object)Log.getStackTraceString((Throwable)throwable));
                string = string.toString();
            }
            int n3 = string.length();
            int n4 = 0;
            block0: while (n4 < n3) {
                int n5 = h.R(string, '\n', n4, false, 4, null);
                if (n5 == -1) {
                    n5 = n3;
                }
                while (true) {
                    int n6 = Math.min((int)n5, (int)(n4 + 4000));
                    string2 = string.substring(n4, n6);
                    k.d(string2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    Log.println((int)n2, (String)string3, (String)string2);
                    if (n6 >= n5) {
                        n4 = n6 + 1;
                        continue block0;
                    }
                    n4 = n6;
                }
            }
        }
    }

    public final void b() {
        for (Map.Entry entry : c.entrySet()) {
            this.c((String)entry.getKey(), (String)entry.getValue());
        }
    }
}

