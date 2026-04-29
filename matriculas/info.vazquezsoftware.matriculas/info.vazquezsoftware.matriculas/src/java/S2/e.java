/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.google.android.gms.ads.MobileAds
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 */
package s2;

import T0.g;
import T0.l;
import T0.m;
import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.MobileAds;
import java.util.Map;
import r2.k;
import s2.d;

public class e {
    private static g g;
    private static boolean h;
    private static c i;
    private String a;
    private final String b;
    private final String c;
    private g1.a d;
    private g1.a e;
    private boolean f = false;

    public e(String string, String string2, String string3) {
        this.a = string;
        this.b = string2;
        this.c = string3;
    }

    public static /* synthetic */ void a(Z0.b object2) {
        Map map = object2.a();
        for (Object object2 : map.keySet()) {
            Z0.a a2 = (Z0.a)map.get(object2);
            k.a("XXX", String.format((String)"AdMob initialized: Adapter name: %s, Description: %s, Latency: %d", (Object[])new Object[]{object2, a2.getDescription(), a2.a()}));
        }
        h = true;
        s2.e.i();
    }

    private static void i() {
        c c3;
        if (h && (c3 = i) != null) {
            c3.a("AdMob initialized");
        }
    }

    public static void j(Context context, c c3) {
        i = c3;
        s2.e.k(context);
    }

    private static void k(Context context) {
        g = new g.a().k();
        MobileAds.a((Context)context, (Z0.c)new d());
    }

    private void m(Context context) {
        if (!this.f) {
            try {
                String string = this.b;
                g g2 = g;
                g1.b b2 = new g1.b(this, context){
                    final Context a;
                    final e b;
                    {
                        this.b = e2;
                        this.a = context;
                    }

                    @Override
                    public void a(m m2) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("The AdMob");
                        stringBuilder.append(this.b.a);
                        stringBuilder.append(" interstitial ad 1 failed to load: ");
                        stringBuilder.append(m2.c());
                        k.a("XXX", stringBuilder.toString());
                        this.b.d = null;
                        this.b.f = false;
                        this.b.n(this.a);
                    }

                    public void c(g1.a a2) {
                        this.b.f = true;
                        this.b.d = a2;
                        a2 = new StringBuilder();
                        a2.append("AdMob interstitial ad 1 load: ");
                        a2.append(this.b.a);
                        k.a("XXX", a2.toString());
                        this.b.d.c(new l(this){
                            final a a;
                            {
                                this.a = a2;
                            }

                            @Override
                            public void b() {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("The AdMob ");
                                stringBuilder.append(this.a.b.a);
                                stringBuilder.append(" Interstitial ad 1 was dismissed.");
                                k.a("XXX", stringBuilder.toString());
                                this.a.b.f = false;
                            }

                            @Override
                            public void c(T0.b b2) {
                                b2 = new StringBuilder();
                                b2.append("The AdMob ");
                                b2.append(this.a.b.a);
                                b2.append(" interstitial ad 1 failed to show.");
                                k.a("XXX", b2.toString());
                                this.a.b.f = false;
                            }

                            @Override
                            public void e() {
                                this.a.b.f = false;
                                this.a.b.d = null;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("The AdMob ");
                                stringBuilder.append(this.a.b.a);
                                stringBuilder.append(" interstitial ad 1 was shown.");
                                k.a("XXX", stringBuilder.toString());
                            }
                        });
                    }
                };
                g1.a.b(context, string, g2, b2);
                return;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Error loading the ");
                stringBuilder.append(this.a);
                stringBuilder.append(" interstitial ad 1.");
                k.a("XXX", stringBuilder.toString());
            }
        }
    }

    private void n(Context context) {
        try {
            String string = this.c;
            g g2 = g;
            g1.b b2 = new g1.b(this){
                final e a;
                {
                    this.a = e2;
                }

                @Override
                public void a(m m2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("The AdMob");
                    stringBuilder.append(this.a.a);
                    stringBuilder.append(" interstitial ad 2 failed to load: ");
                    stringBuilder.append(m2.c());
                    k.a("XXX", stringBuilder.toString());
                    this.a.e = null;
                    this.a.f = false;
                }

                public void c(g1.a a2) {
                    this.a.f = true;
                    this.a.e = a2;
                    a2 = new StringBuilder();
                    a2.append("AdMob interstitial ad 2 load: ");
                    a2.append(this.a.a);
                    k.a("XXX", a2.toString());
                    this.a.e.c(new l(this){
                        final b a;
                        {
                            this.a = b2;
                        }

                        @Override
                        public void b() {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("The AdMob ");
                            stringBuilder.append(this.a.a.a);
                            stringBuilder.append(" Interstitial ad 2 was dismissed.");
                            k.a("XXX", stringBuilder.toString());
                            this.a.a.f = false;
                        }

                        @Override
                        public void c(T0.b b2) {
                            b2 = new StringBuilder();
                            b2.append("The AdMob ");
                            b2.append(this.a.a.a);
                            b2.append(" interstitial ad 2 failed to show.");
                            k.a("XXX", b2.toString());
                            this.a.a.f = false;
                        }

                        @Override
                        public void e() {
                            this.a.a.f = false;
                            this.a.a.e = null;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("The AdMob ");
                            stringBuilder.append(this.a.a.a);
                            stringBuilder.append(" interstitial ad 2 was shown.");
                            k.a("XXX", stringBuilder.toString());
                        }
                    });
                }
            };
            g1.a.b(context, string, g2, b2);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error loading the ");
            stringBuilder.append(this.a);
            stringBuilder.append(" interstitial ad 2.");
            k.a("XXX", stringBuilder.toString());
            return;
        }
    }

    public void l(Context context) {
        this.m(context);
    }

    public void o(Activity activity) {
        block8: {
            block7: {
                g1.a a2;
                block6: {
                    a2 = this.d;
                    if (a2 == null) break block6;
                    try {
                        a2.e(activity);
                        activity = new StringBuilder();
                        activity.append("AdMob interstitial 1 ad show: ");
                        activity.append(this.a);
                        k.a("XXX", activity.toString());
                        return;
                    }
                    catch (Exception exception) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Error showing the AdMob ");
                        stringBuilder.append(this.a);
                        stringBuilder.append(" interstitial 1 ad.");
                        k.a("XXX", stringBuilder.toString());
                    }
                    break block7;
                }
                a2 = this.e;
                if (a2 == null) break block8;
                try {
                    a2.e(activity);
                    activity = new StringBuilder();
                    activity.append("AdMob interstitial 2 ad show: ");
                    activity.append(this.a);
                    k.a("XXX", activity.toString());
                    return;
                }
                catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Error showing the AdMob ");
                    stringBuilder.append(this.a);
                    stringBuilder.append(" interstitial 2 ad.");
                    k.a("XXX", stringBuilder.toString());
                }
            }
            return;
        }
        activity = new StringBuilder();
        activity.append("Nothing to show. The interstitial ");
        activity.append(this.a);
        activity.append(" is not loaded.");
        k.a("XXX", activity.toString());
    }

    public static interface c {
        public void a(String var1);
    }
}

