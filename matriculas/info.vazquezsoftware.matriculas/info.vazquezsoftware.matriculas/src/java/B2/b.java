/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedReader
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.zip.GZIPInputStream
 *  m3.w
 *  m3.y
 *  m3.y$a
 *  org.json.JSONArray
 *  org.json.JSONObject
 *  r2.k
 *  r2.r
 */
package B2;

import B2.a;
import B2.c;
import B2.d;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.zip.GZIPInputStream;
import m3.w;
import m3.y;
import org.json.JSONArray;
import org.json.JSONObject;
import r2.k;
import r2.r;

public abstract class b {
    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void a(String string, c c2) {
        Exception exception222222;
        Throwable throwable222;
        StringBuilder stringBuilder;
        block15: {
            block14: {
                block13: {
                    boolean bl;
                    Object object = new w();
                    Object object2 = r.b((String)"\u00c3\u00df\u00df\u00db\u00d8\u0091\u0084\u0084\u00ca\u00db\u00c2\u0085\u00c6\u00c2\u00d8\u00df\u00ce\u00d9\u0086\u00ca\u00de\u00df\u00c4\u0085\u00c8\u00c4\u00c6\u0084\u00dd\u009a\u0084\u00dd\u00ce\u00c3\u00c2\u00c8\u00c7\u00ce\u0084\u00cc\u00c7\u00c4\u00c9\u00ca\u00c7\u0086\u00db\u00c7\u00ca\u00df\u00ce\u00d8\u0084\u00dd\u0099\u0084\u00ee\u00f8\u0084");
                    y.a a2 = new y.a();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append((String)object2);
                    stringBuilder.append(string.toUpperCase());
                    string = a2.m(stringBuilder.toString()).a("Accept", "application/json").a("Accept-Encoding", "gzip").a("Connection", "Keep-Alive").a("Host", "api.mister-auto.com").a("only-ktype", "false").a("token-plate", "EBF8EE8E46384F3C1BB1231FF626B").a("User-Agent", "okhttp/4.10.0 NewAppMA").b();
                    stringBuilder = object.w((y)string).f();
                    try {
                        if (!stringBuilder.P() || stringBuilder.a() == null) break block13;
                        string = stringBuilder.a().a();
                        object = new GZIPInputStream((InputStream)string);
                        object2 = new InputStreamReader((InputStream)object);
                        string = new BufferedReader((Reader)object2);
                        object2 = new StringBuilder();
                        while ((object = string.readLine()) != null) {
                            object2.append((String)object);
                        }
                        string = object2.toString();
                        if (string.length() < 50) {
                            c2.a("Plate not found.");
                            break block14;
                        }
                        object2 = new d();
                        a2 = new JSONObject(string);
                        bl = a2.has("make");
                        object = "";
                        string = bl ? b.c(a2.getJSONArray("make")) : "";
                    }
                    catch (Throwable throwable222) {
                        break block15;
                    }
                    ((d)object2).a = string;
                    ((d)object2).a = r.a((String)string);
                    string = a2.has("model") ? b.c(a2.getJSONArray("model")) : "";
                    ((d)object2).b = string;
                    ((d)object2).b = r.a((String)string);
                    string = a2.has("version") ? b.c(a2.getJSONArray("version")) : "";
                    ((d)object2).c = string;
                    ((d)object2).c = r.a((String)string);
                    string = a2.has("fuel_type") ? b.c(a2.getJSONArray("fuel_type")) : "";
                    ((d)object2).e = string;
                    ((d)object2).e = string = string.replace((CharSequence)"PETROL", (CharSequence)"Gasolina");
                    ((d)object2).e = string = string.replace((CharSequence)"ELECTRIC", (CharSequence)"El\u00e9ctrico");
                    ((d)object2).e = string.replace((CharSequence)"DIESEL", (CharSequence)"Diesel");
                    string = object;
                    if (a2.has("max_net_power_hp")) {
                        string = new StringBuilder();
                        string.append(b.c(a2.getJSONArray("max_net_power_hp")));
                        string.append(" cv");
                        string = string.toString();
                    }
                    ((d)object2).d = string;
                    bl = a2.has("vin");
                    string = "vin: ";
                    if (bl) {
                        string = new StringBuilder();
                        string.append("vin: ");
                        string.append(b.c(a2.getJSONArray("vin")));
                        string = string.toString();
                    }
                    ((d)object2).f = string;
                    string = new StringBuilder();
                    string.append("Origen: MA: Resultado: ");
                    string.append(((d)object2).a);
                    string.append(" ");
                    string.append(((d)object2).b);
                    string.append(" (");
                    string.append(((d)object2).e);
                    string.append(")");
                    k.a((String)"XXX", (String)string.toString());
                    c2.b((d)object2);
                    break block14;
                }
                string = new StringBuilder();
                string.append("MA HTTP Error: ");
                string.append(stringBuilder.p());
                k.a((String)"XXX", (String)string.toString());
                string = new StringBuilder();
                string.append("Error HTTP: ");
                string.append(stringBuilder.p());
                c2.a(string.toString());
            }
            stringBuilder.close();
            return;
            {
                catch (Exception exception222222) {}
            }
        }
        if (stringBuilder == null) throw throwable222;
        try {
            stringBuilder.close();
            throw throwable222;
        }
        catch (Throwable throwable3) {
            throwable222.addSuppressed(throwable3);
            throw throwable222;
        }
        exception222222.printStackTrace();
        string = new StringBuilder();
        string.append("MA Error: ");
        string.append(exception222222.getMessage());
        k.a((String)"XXX", (String)string.toString());
        c2.a(exception222222.getMessage());
    }

    public static void b(String string, c c2) {
        new Thread((Runnable)new a(string, c2)).start();
    }

    private static String c(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() > 0) {
            return jSONArray.getString(0);
        }
        return "";
    }
}

