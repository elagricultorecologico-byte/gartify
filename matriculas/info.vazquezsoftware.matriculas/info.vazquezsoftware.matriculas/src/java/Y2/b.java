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
 *  org.json.JSONObject
 */
package y2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import r2.k;
import r2.r;
import y2.a;
import y2.c;
import y2.d;

public abstract class b {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void a(String string, c c2) {
        Exception exception2;
        block6: {
            Throwable throwable2;
            block7: {
                StringBuilder stringBuilder;
                Object object;
                Object object2;
                try {
                    object2 = new StringBuilder();
                    object2.append(r.b("\u00c3\u00df\u00df\u00db\u00d8\u0091\u0084\u0084\u00dc\u00dc\u00dc\u0085\u00cf\u00c2\u00d8\u00df\u00d9\u00c2\u0086\u00ca\u00de\u00df\u00c4\u0085\u00ce\u00d8\u0084\u00ca\u00c1\u00ca\u00d3\u0084\u00d8\u00ce\u00ca\u00d9\u00c8\u00c3\u0084\u00dd\u00ce\u00c3\u00c2\u00c8\u00c7\u00ce\u0086\u00c9\u00d2\u0086\u00db\u00c7\u00ca\u00df\u00ce\u0084\u0094\u00d8\u00ce\u00ca\u00d9\u00c8\u00c3\u00f4\u00dd\u00ce\u00c3\u00c2\u00c8\u00c7\u00ce\u00f4\u00c9\u00d2\u00f4\u00db\u00c7\u00ca\u00df\u00ce\u00f0\u00c7\u00c2\u00c8\u00ce\u00c5\u00c8\u00ce\u00fb\u00c7\u00ca\u00df\u00ce\u00f6\u0096"));
                    object2.append(string);
                    object2 = object2.toString();
                    string = new URL((String)object2);
                    string = (HttpURLConnection)string.openConnection();
                    string.setConnectTimeout(15000);
                    string.setReadTimeout(15000);
                }
                catch (Exception exception2) {
                    break block6;
                }
                try {
                    object = new InputStreamReader(string.getInputStream());
                    object2 = new BufferedReader((Reader)object);
                    stringBuilder = new StringBuilder();
                    while ((object = object2.readLine()) != null) {
                        stringBuilder.append((String)object);
                        stringBuilder.append("\n");
                    }
                }
                catch (Throwable throwable2) {
                    break block7;
                }
                object2.close();
                object = stringBuilder.toString();
                object2 = new JSONObject((String)object);
                stringBuilder = object2.getJSONObject("vehicle").getJSONObject("modelSeries");
                object = stringBuilder.getJSONObject("translations");
                stringBuilder = stringBuilder.getJSONObject("manufacturer").getJSONObject("translations");
                Object object3 = object2.getString("url");
                Object object4 = new StringBuilder();
                object4.append(stringBuilder.getString("slug"));
                object4.append(" ");
                object4.append(object.getString("modelSlug"));
                object4 = object4.toString();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Origen: ");
                stringBuilder2.append((String)object4);
                stringBuilder2.append(" URL: ");
                stringBuilder2.append((String)object3);
                k.a("XXX", stringBuilder2.toString());
                object3 = new d(stringBuilder.getString("slug"), object.getString("modelSlug"), object2.getString("url"));
                c2.b((d)object3);
                string.disconnect();
                return;
            }
            string.disconnect();
            throw throwable2;
        }
        string = new StringBuilder();
        string.append("Error: Origen: ");
        string.append(exception2.getMessage());
        k.a("XXX", string.toString());
        c2.a(exception2.getMessage());
    }

    public static void b(String string, c c2) {
        new Thread((Runnable)new a(string, c2)).start();
    }
}

