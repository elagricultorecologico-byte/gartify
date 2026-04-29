/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.io.BufferedReader
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
 *  java.net.HttpURLConnection
 *  java.net.URL
 *  java.util.regex.Pattern
 */
package z2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;
import r2.k;
import r2.r;
import z2.a;
import z2.c;
import z2.d;

public abstract class b {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void a(String string, c c2) {
        Exception exception2;
        block14: {
            Throwable throwable2;
            block15: {
                Object object;
                Object object2;
                Object object3;
                Object object4;
                try {
                    object4 = new StringBuilder();
                    object4.append(r.b("\u00c3\u00df\u00df\u00db\u00d8\u0091\u0084\u0084\u00dc\u00dc\u00dc\u0085\u00cc\u00c7\u00c2\u00ca\u00db\u00db\u00d8\u0085\u00c8\u00c4\u00c6\u0084\u00ca\u00db\u00c2\u0084\u00cc\u00ce\u00df\u00fb\u00c7\u00ca\u00df\u00ce\u00e2\u00c5\u00cd\u00c4\u0085\u00db\u00c3\u00db\u0094\u00db\u00c7\u00ca\u00df\u00ce\u0096\u0083\u00ee\u0082"));
                    object4.append(string);
                    object4.append("&key=bebCBE1A8685FE3DD4A73EF32EFB17B3");
                    object4 = object4.toString();
                    string = new URL((String)object4);
                    string = (HttpURLConnection)string.openConnection();
                    string.setConnectTimeout(15000);
                    string.setReadTimeout(15000);
                }
                catch (Exception exception2) {
                    break block14;
                }
                try {
                    object3 = new InputStreamReader(string.getInputStream());
                    object2 = new BufferedReader((Reader)object3);
                    object = new StringBuilder();
                    while ((object3 = object2.readLine()) != null) {
                        object.append((String)object3);
                    }
                }
                catch (Throwable throwable2) {
                    break block15;
                }
                object2.close();
                object3 = object.toString();
                object2 = new d();
                object = Pattern.compile((String)"make:\\s*\"(.*?)\",").matcher((CharSequence)object3);
                if (object.find()) {
                    object = r.a(object.group(1));
                    object2.a = object;
                    object2.a = object.replaceAll("\\(.*?\\)", "");
                }
                if ((object = Pattern.compile((String)"power:\\s*\"(.*?)\",").matcher((CharSequence)object3)).find()) {
                    object2.b = object.group(1).toLowerCase();
                }
                if ((object3 = Pattern.compile((String)"(diesel|gasolina|gasoline)", (int)2).matcher((CharSequence)object3)).find()) {
                    if ((object3 = object3.group(1).toLowerCase()).equals((Object)"diesel")) {
                        object2.c = "Diesel";
                    } else if (object3.equals((Object)"gasolina") || object3.equals((Object)"gasoline")) {
                        object2.c = "Gasolina";
                    }
                }
                if ((object3 = object2.a) != null && object3.length() > 1) {
                    object4 = new StringBuilder();
                    object4.append("Origen: API | Resultado: ");
                    object4.append(object2.a);
                    object4.append(" | Combustible: ");
                    object4.append(object2.c);
                    k.a("XXX", object4.toString());
                    c2.b((d)object2);
                } else {
                    object2 = new StringBuilder();
                    object2.append("Origen: ");
                    object2.append((String)object4);
                    object2.append(" | Motivo: Matr\u00edcula no encontrada o datos vac\u00edos");
                    k.a("XXX", object2.toString());
                    c2.a("Plate not found.");
                }
                string.disconnect();
                return;
            }
            string.disconnect();
            throw throwable2;
        }
        string = new StringBuilder();
        string.append("Origen: ");
        string.append(exception2.getMessage());
        k.a("XXX", string.toString());
        c2.a(exception2.getMessage());
    }

    public static void b(String string, c c2) {
        new Thread((Runnable)new a(string, c2)).start();
    }
}

