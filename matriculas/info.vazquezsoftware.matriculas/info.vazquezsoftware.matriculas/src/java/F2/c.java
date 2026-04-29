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
 *  java.util.Random
 */
package F2;

import F2.a;
import F2.b;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public abstract class c {
    public static String a = "D";

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static /* synthetic */ void a(a var0) {
        block5: {
            try {
                var1_1 = new URL("http://46.183.114.102/app/matriculas/v48");
                var1_1 = (HttpURLConnection)var1_1.openConnection();
            }
            catch (Exception var1_2) {
                var0.c("Connection error.");
                return;
            }
            try {
                var3_5 /* !! */  = new InputStreamReader(var1_1.getInputStream());
                var2_3 = new BufferedReader((Reader)var3_5 /* !! */ );
                var3_5 /* !! */  = var2_3.readLine();
                if (var3_5 /* !! */  == null) break block5;
                c.a = var3_5 /* !! */ .trim();
            }
            catch (Throwable var2_4) {
                ** GOTO lbl22
            }
        }
        var2_3.close();
        var0.b(c.a);
        {
            var1_1.disconnect();
            return;
lbl22:
            // 1 sources

            var1_1.disconnect();
            throw var2_4;
        }
    }

    public static void b(a a2) {
        new Thread((Runnable)new b(a2)).start();
    }

    public static String c(String string) {
        if (!a.equals((Object)"D") && a.length() > 1) {
            if ((string = a.replace((CharSequence)string, (CharSequence)"")).isEmpty()) {
                return "D";
            }
            int n2 = new Random().nextInt(string.length());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string.charAt(n2));
            stringBuilder.append("");
            return stringBuilder.toString();
        }
        return "D";
    }

    public static String d() {
        String string;
        String string2 = string = a;
        if (!string.equals((Object)"D")) {
            int n2 = new Random().nextInt(a.length());
            string2 = new StringBuilder();
            string2.append(a.charAt(n2));
            string2.append("");
            string2 = string2.toString();
        }
        return string2;
    }
}

