/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedReader
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  org.json.JSONArray
 *  r2.k
 *  r2.r
 */
package C2;

import C2.a;
import C2.c;
import C2.d;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import r2.k;
import r2.r;

public abstract class b {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void a(String string, c c2) {
        Exception exception2;
        StringBuilder stringBuilder;
        block8: {
            Throwable throwable2;
            block9: {
                StringBuilder stringBuilder2;
                Object object;
                try {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(r.b((String)"\u00c3\u00df\u00df\u00db\u00d8\u0091\u0084\u0084\u00dc\u00dc\u00dc\u0085\u00c6\u00de\u00df\u00de\u00ca\u0085\u00ce\u00d8\u0084\u00d8\u00ce\u00cc\u00de\u00d9\u00c4\u00d8\u0086\u00c8\u00c4\u00c8\u00c3\u00ce\u0084\u00c8\u00ca\u00c7\u00c8\u00de\u00c7\u00ca\u00d9\u0084\u00ca\u00c8\u00df\u00c2\u00c4\u00c5\u0084\u00d8\u00ce\u00d9\u00dd\u00c2\u00c8\u00ce\u00d8\u0084\u00dd\u00ce\u00c3\u00c2\u00c8\u00de\u00c7\u00c4\u00d8\u0084\u00c4\u00c9\u00df\u00ce\u00c5\u00ce\u00d9\u0086\u00cf\u00ca\u00df\u00c4\u00d8\u0084"));
                    stringBuilder.append(string);
                    string = stringBuilder.toString();
                    stringBuilder = new URL(string);
                    string = (HttpURLConnection)stringBuilder.openConnection();
                }
                catch (Exception exception2) {
                    break block8;
                }
                try {
                    object = new InputStreamReader(string.getInputStream());
                    stringBuilder = new BufferedReader((Reader)object);
                    stringBuilder2 = new StringBuilder();
                    while ((object = stringBuilder.readLine()) != null) {
                        stringBuilder2.append((String)object);
                    }
                }
                catch (Throwable throwable2) {
                    break block9;
                }
                stringBuilder.close();
                object = b.c(stringBuilder2.toString());
                if (object != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Success: ");
                    stringBuilder.append(object.a);
                    stringBuilder.append(" ");
                    stringBuilder.append(object.b);
                    k.a((String)"XXX", (String)stringBuilder.toString());
                    c2.b((d)object);
                } else {
                    k.a((String)"XXX", (String)"Error: JSON parse devolvi\u00f3 null (probablemente sin resultados)");
                    c2.a("Error: Datos vac\u00edos o inv\u00e1lidos");
                }
                string.disconnect();
                return;
            }
            string.disconnect();
            throw throwable2;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Error: excepcion red/http: ");
        stringBuilder.append(exception2.getMessage());
        k.a((String)"XXX", (String)stringBuilder.toString());
        c2.a(exception2.getMessage());
    }

    public static void b(String string, c c2) {
        new Thread((Runnable)new a(string, c2)).start();
    }

    public static d c(String string) {
        try {
            JSONArray jSONArray = new JSONArray(string);
            string = jSONArray.getJSONObject(0);
            jSONArray = string.getJSONObject("datos");
            string = string.getJSONObject("caracteristicas");
            d d2 = new d();
            d2.a = r.a((String)jSONArray.getString("descripcionMarca"));
            d2.b = r.a((String)jSONArray.getString("descripcionModelo"));
            d2.c = r.a((String)jSONArray.getString("descripcionSubModelo"));
            d2.d = r.a((String)jSONArray.getString("descripcionTerminacion"));
            d2.e = r.a((String)string.getString("combustible"));
            jSONArray = new StringBuilder();
            jSONArray.append(string.optString("potencia", ""));
            jSONArray.append(" cv");
            d2.f = jSONArray.toString();
            return d2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }
}

