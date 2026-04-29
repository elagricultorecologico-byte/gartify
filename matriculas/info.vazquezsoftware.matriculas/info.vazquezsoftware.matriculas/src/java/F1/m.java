/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonWriter
 *  com.google.android.gms.common.util.c
 *  com.google.android.gms.common.util.e
 *  com.google.android.gms.common.util.h
 *  java.io.IOException
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Class
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.UUID
 */
package f1;

import android.util.JsonWriter;
import com.google.android.gms.common.util.c;
import com.google.android.gms.common.util.e;
import f1.h;
import f1.i;
import f1.j;
import f1.k;
import f1.l;
import f1.p;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public final class m {
    private static final Object b = new Object();
    private static boolean c;
    private static boolean d;
    private static final e e;
    private static final Set f;
    public static final int g = 0;
    private final List a;

    static {
        e = com.google.android.gms.common.util.h.d();
        f = new HashSet((Collection)Arrays.asList((Object[])new String[0]));
    }

    public m(String string) {
        string = !m.j() ? new ArrayList() : Arrays.asList((Object[])new String[]{"network_request_".concat(String.valueOf((Object)UUID.randomUUID().toString()))});
        this.a = string;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void g() {
        Object object;
        Object object2 = object = b;
        synchronized (object2) {
            c = false;
            d = false;
            p.f("Ad debug logging enablement is out of date.");
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void h(boolean bl) {
        Object object;
        Object object2 = object = b;
        synchronized (object2) {
            c = true;
            d = bl;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean i() {
        Object object;
        Object object2 = object = b;
        synchronized (object2) {
            return c;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean j() {
        Object object;
        Object object2 = object = b;
        synchronized (object2) {
            try {
                boolean bl;
                boolean bl2 = c;
                boolean bl3 = bl = false;
                if (!bl2) return bl3;
                bl3 = bl;
                if (!d) return bl3;
                return true;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    static /* synthetic */ void k(String string, String string2, Map map, byte[] byArray, JsonWriter jsonWriter) {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value(string);
        jsonWriter.name("verb").value(string2);
        jsonWriter.endObject();
        m.p(jsonWriter, map);
        if (byArray != null) {
            jsonWriter.name("body").value(com.google.android.gms.common.util.c.a((byte[])byArray));
        }
        jsonWriter.endObject();
    }

    static /* synthetic */ void l(int n2, Map map, JsonWriter jsonWriter) {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value((long)n2);
        jsonWriter.endObject();
        m.p(jsonWriter, map);
        jsonWriter.endObject();
    }

    private final void m(String string, String string2, Map map, byte[] byArray) {
        this.q("onNetworkRequest", new k(string, string2, map, byArray));
    }

    private final void n(Map map, int n2) {
        this.q("onNetworkResponse", new h(n2, map));
    }

    private final void o(String string) {
        this.q("onNetworkRequestError", new j(string));
    }

    private static void p(JsonWriter jsonWriter, Map map) {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        for (Map.Entry entry : map.entrySet()) {
            String string = (String)entry.getKey();
            if (f.contains((Object)string)) continue;
            if (entry.getValue() instanceof List) {
                entry = ((List)entry.getValue()).iterator();
                while (entry.hasNext()) {
                    String string2 = (String)entry.next();
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(string);
                    jsonWriter.name("value").value(string2);
                    jsonWriter.endObject();
                }
                continue;
            }
            if (entry.getValue() instanceof String) {
                jsonWriter.beginObject();
                jsonWriter.name("name").value(string);
                jsonWriter.name("value").value((String)entry.getValue());
                jsonWriter.endObject();
                continue;
            }
            p.c("Connection headers should be either Map<String, String> or Map<String, List<String>>");
            break;
        }
        jsonWriter.endArray();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void q(String string, l l2) {
        StringWriter stringWriter;
        block4: {
            IOException iOException2;
            block3: {
                stringWriter = new StringWriter();
                JsonWriter jsonWriter = new JsonWriter((Writer)stringWriter);
                try {
                    jsonWriter.beginObject();
                    jsonWriter.name("timestamp").value(e.b());
                    jsonWriter.name("event").value(string);
                    jsonWriter.name("components").beginArray();
                    string = this.a.iterator();
                    while (string.hasNext()) {
                        jsonWriter.value((String)string.next());
                    }
                }
                catch (IOException iOException2) {
                    break block3;
                }
                jsonWriter.endArray();
                l2.a(jsonWriter);
                jsonWriter.endObject();
                jsonWriter.flush();
                jsonWriter.close();
                break block4;
            }
            p.d("unable to log", iOException2);
        }
        m.r(stringWriter.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void r(String string) {
        Class<m> clazz = m.class;
        synchronized (m.class) {
            try {
                p.e("GMA Debug BEGIN");
                int n2 = 0;
                while (true) {
                    if (n2 >= string.length()) {
                        p.e("GMA Debug FINISH");
                        // ** MonitorExit[var3_2] (shouldn't be in output)
                        return;
                    }
                    int n3 = n2 + 4000;
                    p.e("GMA Debug CONTENT ".concat(String.valueOf((Object)string.substring(n2, Math.min((int)n3, (int)string.length())))));
                    n2 = n3;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public final void a(HttpURLConnection httpURLConnection, byte[] byArray) {
        if (!m.j()) {
            return;
        }
        HashMap hashMap = httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties());
        this.m(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), (Map)hashMap, byArray);
    }

    public final void b(String string, String string2, Map map, byte[] byArray) {
        if (!m.j()) {
            return;
        }
        this.m(string, "GET", map, byArray);
    }

    public final void c(HttpURLConnection object, int n2) {
        Object var4_5;
        block5: {
            block4: {
                if (!m.j()) break block4;
                Object object2 = object.getHeaderFields();
                var4_5 = null;
                object2 = object2 == null ? null : new HashMap(object.getHeaderFields());
                this.n((Map)object2, n2);
                if (n2 < 200 || n2 >= 300) break block5;
            }
            return;
        }
        try {
            object = object.getResponseMessage();
        }
        catch (IOException iOException) {
            p.f("Can not get error message from error HttpURLConnection\n".concat(String.valueOf((Object)iOException.getMessage())));
            object = var4_5;
        }
        this.o((String)object);
    }

    public final void d(Map map, int n2) {
        block3: {
            block2: {
                if (!m.j()) break block2;
                this.n(map, n2);
                if (n2 < 200 || n2 >= 300) break block3;
            }
            return;
        }
        this.o(null);
    }

    public final void e(String string) {
        if (m.j() && string != null) {
            this.f(string.getBytes());
        }
    }

    public final void f(byte[] byArray) {
        this.q("onNetworkResponseBody", new i(byArray));
    }
}

