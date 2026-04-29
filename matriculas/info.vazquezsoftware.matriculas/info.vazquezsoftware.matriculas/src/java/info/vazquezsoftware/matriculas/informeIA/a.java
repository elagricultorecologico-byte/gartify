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
 *  java.nio.charset.Charset
 *  java.nio.charset.StandardCharsets
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package info.vazquezsoftware.matriculas.informeIA;

import A2.b;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONObject;
import r2.r;

public abstract class a {
    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void a(String var0, String var1_3, String var2_5, a var3_6) {
        block16: {
            block15: {
                block14: {
                    var6_7 = new URL(r.b("\u00c3\u00df\u00df\u00db\u00d8\u0091\u0084\u0084\u00ca\u00db\u00c2\u0085\u00cf\u00ce\u00ce\u00db\u00d8\u00ce\u00ce\u00c0\u0085\u00c8\u00c4\u00c6\u0084\u00c8\u00c3\u00ca\u00df\u0084\u00c8\u00c4\u00c6\u00db\u00c7\u00ce\u00df\u00c2\u00c4\u00c5\u00d8"));
                    var6_7 = (HttpURLConnection)var6_7.openConnection();
                    var6_7.setRequestMethod("POST");
                    var7_8 = new StringBuilder();
                    var7_8.append("Bearer ");
                    var7_8.append(r.b("\u00d8\u00c0\u0086\u00c8\u0093\u009a\u009b\u0099\u0099\u009f\u009a\u00ca\u009a\u009c\u00c8\u009f\u009e\u009d\u009c\u00c9\u0099\u00cd\u009e\u0092\u009c\u009d\u00ca\u00cd\u0093\u0092\u0099\u00c8\u009a\u00cd\u009f"));
                    var6_7.setRequestProperty("Authorization", var7_8.toString());
                    var6_7.setRequestProperty("Content-Type", "application/json");
                    var6_7.setConnectTimeout(20000);
                    var6_7.setReadTimeout(30000);
                    var6_7.setDoOutput(true);
                    var7_8 = new StringBuilder();
                    var7_8.append("Veh\u00edculo: ");
                    var7_8.append((String)var0);
                    var7_8.append(". Antig\u00fcedad: ");
                    var7_8.append(var1_3);
                    var7_8.append(". Distintivo Ambiental: ");
                    var7_8.append((String)var2_5);
                    var7_8.append(".");
                    var1_3 = var7_8.toString();
                    var0 = new JSONObject();
                    var0.put("model", (Object)"deepseek-chat");
                    var2_5 = new JSONObject();
                    var2_5.put("type", (Object)"json_object");
                    var0.put("response_format", var2_5);
                    var2_5 = new JSONArray();
                    var7_8 = new JSONObject();
                    var7_8.put("role", (Object)"system");
                    var7_8.put("content", (Object)"Eres un experto tasador de coches y mec\u00e1nico. Vas a analizar la idoneidad de compra de un veh\u00edculo de segunda mano.\nIMPORTANTE: Los precios reales actuales son un 30% m\u00e1s caros que los de tu base de datos. Aplica este incremento del 30% internamente al calcular la tasaci\u00f3n.\nREGLA ESTRICTA: NO menciones este incremento, ni hables de inflaci\u00f3n, ni expliques que has ajustado el precio. Muestra directamente la cifra final como si fuera el valor natural del mercado actual.\nSe te dar\u00e1n los datos del veh\u00edculo.\nDEBES responder \u00daNICAMENTE con un objeto JSON v\u00e1lido. NO incluyas formato markdown.\nEl JSON debe tener exactamente esta estructura:\n{\n  \"precio_estimado\": \"Rango de precio (aplica el incremento sin mencionarlo) y breve justificaci\u00f3n t\u00e9cnica basada SOLO en modelo y edad.\",\n  \"pros\": [\"pro 1\", \"pro 2\"],\n  \"contras\": [\"contra 1 (fallos comunes)\", \"contra 2\"],\n  \"conclusion\": \"Veredicto final sobre si es buena compra o qu\u00e9 revisar.\"\n}");
                    var2_5.put((Object)var7_8);
                    var7_8 = new JSONObject();
                    var7_8.put("role", (Object)"user");
                    var7_8.put("content", (Object)var1_3);
                    var2_5.put((Object)var7_8);
                    var0.put("messages", var2_5);
                    var1_3 = var6_7.getOutputStream();
                    var2_5 = var0.toString();
                    var0 = StandardCharsets.UTF_8;
                    var2_5 = var2_5.getBytes((Charset)var0);
                    var4_9 = ((Object)var2_5).length;
                    var5_10 = 0;
                    var1_3.write((byte[])var2_5, 0, var4_9);
                    var1_3.close();
                    var4_9 = var6_7.getResponseCode();
                    if (var4_9 < 200 || var4_9 >= 300) ** GOTO lbl100
                    var2_5 = new InputStreamReader(var6_7.getInputStream(), (Charset)var0);
                    var1_3 = new BufferedReader((Reader)var2_5);
                    var0 = new StringBuilder();
                    while ((var2_5 = var1_3.readLine()) != null) {
                        var0.append((String)var2_5);
                    }
                    var1_3.close();
                    var1_3 = new JSONObject(var0.toString());
                    var0 = var1_3.getJSONArray("choices").getJSONObject(0).getJSONObject("message").getString("content").replace((CharSequence)"```json", (CharSequence)"").replace((CharSequence)"```", (CharSequence)"").trim();
                    var1_3 = new JSONObject((String)var0);
                    var0 = new b();
                    var0.a = var1_3.optString("precio_estimado", "No disponible");
                    var0.d = var1_3.optString("conclusion", "Sin conclusi\u00f3n");
                    var2_5 = var1_3.optJSONArray("pros");
                    if (var2_5 == null) break block14;
                    for (var4_9 = 0; var4_9 < var2_5.length(); ++var4_9) {
                        var0.b.add((Object)var2_5.getString(var4_9));
                    }
                }
                var1_3 = var1_3.optJSONArray("contras");
                if (var1_3 == null) break block15;
                for (var4_9 = var5_10; var4_9 < var1_3.length(); ++var4_9) {
                    var0.c.add((Object)var1_3.getString(var4_9));
                }
            }
            var3_6.b((b)var0);
            break block16;
lbl100:
            // 1 sources

            var2_5 = new InputStreamReader(var6_7.getErrorStream(), (Charset)var0);
            var1_3 = new BufferedReader((Reader)var2_5);
            var0 = new StringBuilder();
            while ((var2_5 = var1_3.readLine()) != null) {
                var0.append((String)var2_5);
            }
            var1_3.close();
            var1_3 = new StringBuilder();
            var1_3.append("Error HTTP ");
            var1_3.append(var4_9);
            var1_3.append(": ");
            var1_3.append(var0.toString());
            var3_6.a(var1_3.toString());
        }
        var6_7.disconnect();
        return;
        catch (Throwable var0_2) {
            if (var1_3 == null) throw var0_2;
            try {
                var1_3.close();
                throw var0_2;
            }
            catch (Throwable var1_4) {
                try {
                    var0_2.addSuppressed(var1_4);
                    throw var0_2;
                }
                catch (Exception var0_1) {}
            }
        }
        var0_1.printStackTrace();
        var3_6.a(var0_1.getMessage());
    }

    public static void b(String string, String string2, String string3, a a2) {
        new Thread((Runnable)new A2.a(string, string2, string3, a2)).start();
    }

    public static interface a {
        public void a(String var1);

        public void b(b var1);
    }
}

