/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.DisplayMetrics
 *  android.view.WindowManager
 *  f1.g
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  y1.c
 */
package b1;

import T0.A;
import T0.h;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import b1.i2;
import b1.x;
import f1.g;
import y1.a;
import y1.c;

public final class h2
extends a {
    public static final Parcelable.Creator<h2> CREATOR = new i2();
    public final String g;
    public final int h;
    public final int i;
    public final boolean j;
    public final int k;
    public final int l;
    public final h2[] m;
    public final boolean n;
    public final boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;

    public h2() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false, false, false);
    }

    public h2(Context context, h h3) {
        this(context, new h[]{h3});
    }

    /*
     * Unable to fully structure code
     */
    public h2(Context var1_1, h[] var2_2) {
        block18: {
            block17: {
                super();
                var13_3 = var2_2[0];
                this.j = false;
                this.o = var12_4 = var13_3.f();
                this.s = A.f((h)var13_3);
                this.t = A.g((h)var13_3);
                this.u = A.d((h)var13_3);
                this.v = A.i((h)var13_3);
                if (var12_4) {
                    var14_5 = T0.h.j;
                    this.k = var14_5.d();
                    this.h = var6_6 = var14_5.b();
                } else if (this.t) {
                    this.k = var13_3.d();
                    this.h = var6_6 = A.h((h)var13_3);
                } else if (this.u) {
                    this.k = var13_3.d();
                    this.h = var6_6 = A.e((h)var13_3);
                } else {
                    this.k = var13_3.d();
                    this.h = var6_6 = var13_3.b();
                }
                var7_7 = this.k == -1 ? 1 : 0;
                var8_8 = var6_6 == -2;
                var14_5 = var1_1.getResources().getDisplayMetrics();
                if (var7_7 == 0) break block17;
                x.a();
                if (var1_1.getResources().getConfiguration().orientation != 2) ** GOTO lbl-1000
                var15_9 = var1_1.getResources().getDisplayMetrics();
                if ((int)((float)var15_9.heightPixels / var15_9.density) >= 600) ** GOTO lbl-1000
                x.a();
                var15_9 = var1_1.getResources().getDisplayMetrics();
                var16_10 = (WindowManager)var1_1.getSystemService("window");
                if (var16_10 == null) ** GOTO lbl-1000
                var16_10 = var16_10.getDefaultDisplay();
                var16_10.getRealMetrics(var15_9);
                var6_6 = var15_9.heightPixels;
                var9_11 = var15_9.widthPixels;
                var16_10.getMetrics(var15_9);
                var10_12 = var15_9.heightPixels;
                var11_13 = var15_9.widthPixels;
                if (var10_12 == var6_6 && var11_13 == var9_11) {
                    var9_11 = var14_5.widthPixels;
                    x.a();
                    var6_6 = var1_1.getResources().getIdentifier("navigation_bar_width", "dimen", "android");
                    var6_6 = var6_6 > 0 ? var1_1.getResources().getDimensionPixelSize(var6_6) : 0;
                    this.l = var6_6 = var9_11 - var6_6;
                } else lbl-1000:
                // 4 sources

                {
                    this.l = var6_6 = var14_5.widthPixels;
                }
                var5_14 = var14_5.density;
                var3_15 = (float)var6_6 / var5_14;
                var6_6 = var9_11 = (int)var3_15;
                if (var3_15 - (double)var9_11 >= 0.01) {
                    var6_6 = var9_11 + 1;
                }
                break block18;
            }
            var6_6 = this.k;
            x.a();
            this.l = f1.g.C((DisplayMetrics)var14_5, (int)this.k);
        }
        var9_11 = var8_8 != false ? h2.g((DisplayMetrics)var14_5) : this.h;
        x.a();
        this.i = f1.g.C((DisplayMetrics)var14_5, (int)var9_11);
        if (var7_7 != 0 || var8_8) ** GOTO lbl92
        if (!this.t && !this.u) {
            if (var12_4) {
                var13_3 = "320x50_mb";
lbl74:
                // 2 sources

                while (true) {
                    this.g = var13_3;
                    break;
                }
            } else {
                this.g = var13_3.toString();
            }
        } else {
            var6_6 = this.k;
            var7_7 = this.h;
            var13_3 = new StringBuilder(String.valueOf((int)var6_6).length() + 1 + String.valueOf((int)var7_7).length() + 3);
            var13_3.append(var6_6);
            var13_3.append("x");
            var13_3.append(var7_7);
            var13_3.append("_as");
            var13_3 = var13_3.toString();
            ** continue;
lbl92:
            // 1 sources

            var13_3 = new StringBuilder(String.valueOf((int)var6_6).length() + 1 + String.valueOf((int)var9_11).length() + 3);
            var13_3.append(var6_6);
            var13_3.append("x");
            var13_3.append(var9_11);
            var13_3.append("_as");
            this.g = var13_3.toString();
        }
        var6_6 = var2_2.length;
        if (var6_6 > 1) {
            this.m = new h2[var6_6];
            for (var6_6 = 0; var6_6 < var2_2.length; ++var6_6) {
                this.m[var6_6] = new h2(var1_1, var2_2[var6_6]);
            }
        } else {
            this.m = null;
        }
        this.n = false;
        this.p = false;
    }

    h2(String string, int n3, int n4, boolean bl, int n5, int n6, h2[] h2Array, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10) {
        this.g = string;
        this.h = n3;
        this.i = n4;
        this.j = bl;
        this.k = n5;
        this.l = n6;
        this.m = h2Array;
        this.n = bl2;
        this.o = bl3;
        this.p = bl4;
        this.q = bl5;
        this.r = bl6;
        this.s = bl7;
        this.t = bl8;
        this.u = bl9;
        this.v = bl10;
    }

    public static int a(DisplayMetrics displayMetrics) {
        return (int)((float)h2.g(displayMetrics) * displayMetrics.density);
    }

    public static h2 b() {
        return new h2("320x50_mb", 0, 0, false, 0, 0, null, true, false, false, false, false, false, false, false, false);
    }

    public static h2 c() {
        return new h2("reward_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false, false, false);
    }

    public static h2 f() {
        return new h2("interstitial_mb", 0, 0, false, 0, 0, null, false, false, false, false, true, false, false, false, false);
    }

    private static int g(DisplayMetrics displayMetrics) {
        int n3 = (int)((float)displayMetrics.heightPixels / displayMetrics.density);
        if (n3 <= 400) {
            return 32;
        }
        if (n3 <= 720) {
            return 50;
        }
        return 90;
    }

    public final void writeToParcel(Parcel parcel, int n3) {
        String string = this.g;
        int n4 = c.a((Parcel)parcel);
        c.n((Parcel)parcel, (int)2, (String)string, (boolean)false);
        c.h((Parcel)parcel, (int)3, (int)this.h);
        c.h((Parcel)parcel, (int)4, (int)this.i);
        c.c((Parcel)parcel, (int)5, (boolean)this.j);
        c.h((Parcel)parcel, (int)6, (int)this.k);
        c.h((Parcel)parcel, (int)7, (int)this.l);
        c.q((Parcel)parcel, (int)8, (Parcelable[])this.m, (int)n3, (boolean)false);
        c.c((Parcel)parcel, (int)9, (boolean)this.n);
        c.c((Parcel)parcel, (int)10, (boolean)this.o);
        c.c((Parcel)parcel, (int)11, (boolean)this.p);
        c.c((Parcel)parcel, (int)12, (boolean)this.q);
        c.c((Parcel)parcel, (int)13, (boolean)this.r);
        c.c((Parcel)parcel, (int)14, (boolean)this.s);
        c.c((Parcel)parcel, (int)15, (boolean)this.t);
        c.c((Parcel)parcel, (int)16, (boolean)this.u);
        c.c((Parcel)parcel, (int)17, (boolean)this.v);
        c.b((Parcel)parcel, (int)n4);
    }
}

