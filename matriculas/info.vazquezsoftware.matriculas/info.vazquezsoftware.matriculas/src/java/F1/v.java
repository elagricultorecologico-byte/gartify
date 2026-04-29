/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.TrafficStats
 *  com.google.android.gms.common.util.d
 *  com.google.android.gms.internal.ads.Dr
 *  com.google.android.gms.internal.ads.Oi
 *  com.google.android.gms.internal.ads.Yi
 *  com.google.android.gms.internal.ads.ck0
 *  java.io.IOException
 *  java.lang.Boolean
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.MalformedURLException
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.URL
 *  java.util.Map
 */
package f1;

import android.content.Context;
import android.net.TrafficStats;
import b1.A;
import b1.x;
import com.google.android.gms.common.util.d;
import com.google.android.gms.internal.ads.Dr;
import com.google.android.gms.internal.ads.Oi;
import com.google.android.gms.internal.ads.Yi;
import com.google.android.gms.internal.ads.ck0;
import f1.f;
import f1.m;
import f1.p;
import f1.u;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public final class v
implements f {
    private final Context a;
    private final String b;
    private String c;

    public v(Context context, String string) {
        this.a = context;
        this.b = string;
    }

    private final URL d(String string) {
        URI uRI;
        URI uRI2;
        block6: {
            URISyntaxException uRISyntaxException2;
            block7: {
                uRI2 = null;
                try {
                    uRI = new URI(string);
                    uRI = uRI.toURL();
                    break block6;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                }
                catch (MalformedURLException malformedURLException) {
                }
                catch (URISyntaxException uRISyntaxException2) {
                    break block7;
                }
                this.f(string, (Throwable)uRI);
                uRI = uRI2;
                break block6;
            }
            this.f(string, uRISyntaxException2);
            Oi oi = Yi.f;
            uRI = uRI2;
            if (((Boolean)A.c().d(oi)).booleanValue()) {
                uRI = this.e(string);
            }
        }
        uRI2 = uRI;
        if (uRI == null) {
            uRI = new StringBuilder(string.length() + 47);
            uRI.append("Falling back to direct new URL(\"");
            uRI.append(string);
            uRI.append("\") constructor.");
            p.a(uRI.toString());
            uRI2 = new URL(string);
        }
        return uRI2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final URL e(String string) {
        void var4_11;
        String string2;
        block9: {
            block8: {
                int n2;
                String string4;
                String string3;
                URL uRL;
                try {
                    p.a("Attempting to parse components, encode, and reconstruct URI.");
                    uRL = new URL(string);
                    string3 = uRL.getProtocol();
                    string4 = uRL.getUserInfo();
                    String string5 = uRL.getHost();
                    n2 = uRL.getPort();
                    String string6 = uRL.getPath();
                    string2 = uRL.getQuery();
                    String string7 = uRL.getRef();
                    uRL = new URI(string3, string4, string5, n2, string6, string2, string7);
                    string2 = uRL.toURL();
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    break block8;
                }
                catch (URISyntaxException uRISyntaxException) {
                    break block8;
                }
                catch (MalformedURLException malformedURLException) {
                    // empty catch block
                    break block8;
                }
                try {
                    string3 = uRL.toString();
                    int n3 = string.length();
                    n2 = string3.length();
                    string4 = new StringBuilder(n3 + 114 + n2);
                    string4.append("Successfully constructed URL after component encoding via new URI(parts).toURL() for original: \"");
                    string4.append(string);
                    string4.append("\" -> encoded URI: ");
                    string4.append(string3);
                    p.a(string4.toString());
                    return string2;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                }
                catch (URISyntaxException uRISyntaxException) {
                }
                catch (MalformedURLException malformedURLException) {}
                break block9;
            }
            string2 = null;
        }
        this.f(string, (Throwable)var4_11);
        return string2;
    }

    private final void f(String string, Throwable throwable) {
        String string2 = throwable.getMessage();
        int n2 = String.valueOf((Object)string2).length();
        StringBuilder stringBuilder = new StringBuilder(string.length() + 32 + n2);
        stringBuilder.append("Error while parsing ping URL: ");
        stringBuilder.append(string);
        stringBuilder.append(". ");
        stringBuilder.append(string2);
        p.f(stringBuilder.toString());
        stringBuilder = Dr.c((Context)this.a);
        string = Yi.ie;
        stringBuilder.a(throwable, "HttpUrlPinger.pingUrl", (float)((Integer)A.c().d((Oi)string)).intValue() / 100.0f);
    }

    public final String a() {
        return this.c;
    }

    @Override
    public final u b(String string) {
        return this.c(string, null);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final u c(String var1_1, Map var2_3) {
        block22: {
            block25: {
                block21: {
                    block24: {
                        block23: {
                            block20: {
                                var6_7 /* !! */  = u.h;
                                if (var1_1 == null) return var6_7 /* !! */ ;
                                var7_11 /* !! */  = Yi.g;
                                if (((Boolean)A.c().d(var7_11 /* !! */ )).booleanValue()) {
                                    if (var1_1.isEmpty() != false) return var6_7 /* !! */ ;
                                }
                                var7_11 /* !! */  = Yi.i3;
                                if (((Boolean)A.c().d(var7_11 /* !! */ )).booleanValue() && x.e()) {
                                    return var6_7 /* !! */ ;
                                }
                                var8_12 = var6_7 /* !! */ ;
                                var7_11 /* !! */  = var6_7 /* !! */ ;
                                try {
                                    if (!d.a()) break block20;
                                    var8_12 = var6_7 /* !! */ ;
                                    var7_11 /* !! */  = var6_7 /* !! */ ;
                                    TrafficStats.setThreadStatsTag((int)263);
                                }
                                catch (RuntimeException var2_4) {
                                    break block21;
                                }
                                catch (IOException var2_5) {
                                    break block21;
                                }
                                catch (MalformedURLException var6_8) {
                                    var2_3 /* !! */  = var8_12;
                                    ** GOTO lbl-1000
                                }
                                catch (IndexOutOfBoundsException var6_9) {
                                    var2_3 /* !! */  = var7_11 /* !! */ ;
                                    ** GOTO lbl-1000
                                }
                                catch (Throwable var1_2) {
                                    break block22;
                                }
                            }
                            var8_12 = var6_7 /* !! */ ;
                            var7_11 /* !! */  = var6_7 /* !! */ ;
                            var3_13 = var1_1.length();
                            var8_12 = var6_7 /* !! */ ;
                            var7_11 /* !! */  = var6_7 /* !! */ ;
                            var8_12 = var6_7 /* !! */ ;
                            var7_11 /* !! */  = var6_7 /* !! */ ;
                            var9_15 = new StringBuilder(var3_13 + 13);
                            var8_12 = var6_7 /* !! */ ;
                            var7_11 /* !! */  = var6_7 /* !! */ ;
                            var9_15.append("Pinging URL: ");
                            var8_12 = var6_7 /* !! */ ;
                            var7_11 /* !! */  = var6_7 /* !! */ ;
                            var9_15.append(var1_1);
                            var8_12 = var6_7 /* !! */ ;
                            var7_11 /* !! */  = var6_7 /* !! */ ;
                            p.a(var9_15.toString());
                            var8_12 = var6_7 /* !! */ ;
                            var7_11 /* !! */  = var6_7 /* !! */ ;
                            var9_15 = this.d(var1_1);
                            var8_12 = var6_7 /* !! */ ;
                            var7_11 /* !! */  = var6_7 /* !! */ ;
                            var3_13 = ck0.a;
                            var8_12 = var6_7 /* !! */ ;
                            var7_11 /* !! */  = var6_7 /* !! */ ;
                            var9_15 = (HttpURLConnection)var9_15.openConnection();
                            try {
                                x.a();
                                var7_11 /* !! */  = this.b;
                                var9_15.setConnectTimeout(60000);
                                var9_15.setInstanceFollowRedirects(true);
                                var9_15.setReadTimeout(60000);
                                if (var7_11 /* !! */  == null) break block23;
                                var9_15.setRequestProperty("User-Agent", (String)var7_11 /* !! */ );
                            }
                            catch (Throwable var2_6) {
                                break block24;
                            }
                        }
                        var9_15.setUseCaches(false);
                        if (var2_3 /* !! */  != null) {
                            for (Oi var7_11 : var2_3 /* !! */ .entrySet()) {
                                var9_15.addRequestProperty((String)var7_11 /* !! */ .getKey(), (String)var7_11 /* !! */ .getValue());
                            }
                        }
                        var2_3 /* !! */  = new m(null);
                        var2_3 /* !! */ .a((HttpURLConnection)var9_15, null);
                        var3_13 = var9_15.getResponseCode();
                        var2_3 /* !! */ .c((HttpURLConnection)var9_15, var3_13);
                        if (var3_13 >= 200 && var3_13 < 300) {
                            var2_3 /* !! */  = Yi.Y8;
                            if (((Boolean)A.c().d((Oi)var2_3 /* !! */ )).booleanValue()) {
                                this.c = var9_15.getHeaderField("X-Afma-Ad-Event-Value");
                            }
                            var2_3 /* !! */  = u.g;
                        } else {
                            var5_16 = String.valueOf((int)var3_13).length();
                            var4_14 = var1_1.length();
                            var2_3 /* !! */  = new StringBuilder(var5_16 + 54 + var4_14);
                            var2_3 /* !! */ .append("Received non-success response code ");
                            var2_3 /* !! */ .append(var3_13);
                            var2_3 /* !! */ .append(" from pinging URL: ");
                            var2_3 /* !! */ .append(var1_1);
                            p.f(var2_3 /* !! */ .toString());
                            var2_3 /* !! */  = var6_7 /* !! */ ;
                            if (var3_13 == 502) {
                                var2_3 /* !! */  = u.i;
                            }
                        }
                        var8_12 = var2_3 /* !! */ ;
                        var7_11 /* !! */  = var2_3 /* !! */ ;
                        {
                            var9_15.disconnect();
                        }
                        if (d.a() == false) return var2_3 /* !! */ ;
                        break block25;
                    }
                    var8_12 = var6_7 /* !! */ ;
                    var7_11 /* !! */  = var6_7 /* !! */ ;
                    {
                        var9_15.disconnect();
                        var8_12 = var6_7 /* !! */ ;
                        var7_11 /* !! */  = var6_7 /* !! */ ;
                        throw var2_6;
                    }
                }
                var6_7 /* !! */  = var2_3 /* !! */ .getMessage();
                var4_14 = var1_1.length();
                var3_13 = String.valueOf((Object)var6_7 /* !! */ ).length();
                var2_3 /* !! */  = new StringBuilder(var4_14 + 27 + var3_13);
                var2_3 /* !! */ .append("Error while pinging URL: ");
                var2_3 /* !! */ .append(var1_1);
                var2_3 /* !! */ .append(". ");
                var2_3 /* !! */ .append((String)var6_7 /* !! */ );
                p.f(var2_3 /* !! */ .toString());
                var2_3 /* !! */  = u.i;
                var1_1 = var2_3 /* !! */ ;
                if (d.a() == false) return var1_1;
                break block25;
lbl-1000:
                // 2 sources

                {
                    this.f(var1_1, (Throwable)var6_10);
                    var1_1 = var2_3 /* !! */ ;
                }
                if (d.a() == false) return var1_1;
            }
            TrafficStats.clearThreadStatsTag();
            return var2_3 /* !! */ ;
        }
        if (d.a() == false) throw var1_2;
        TrafficStats.clearThreadStatsTag();
        throw var1_2;
    }
}

