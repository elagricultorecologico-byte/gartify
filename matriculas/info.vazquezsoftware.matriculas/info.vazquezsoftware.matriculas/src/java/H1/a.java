/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.util.List
 */
package h1;

import T0.v;
import android.content.Context;
import android.os.RemoteException;
import h1.b;
import h1.d;
import h1.g;
import h1.h;
import h1.j;
import h1.k;
import h1.m;
import h1.o;
import java.util.List;

public abstract class a {
    public abstract v getSDKVersionInfo();

    public abstract v getVersionInfo();

    public abstract void initialize(Context var1, b var2, List<j> var3);

    public void loadAppOpenAd(g g3, d d2) {
        d2.a(new T0.b(7, this.getClass().getSimpleName().concat(" does not support app open ads."), "com.google.android.gms.ads"));
    }

    public void loadBannerAd(h h3, d d2) {
        d2.a(new T0.b(7, this.getClass().getSimpleName().concat(" does not support banner ads."), "com.google.android.gms.ads"));
    }

    public void loadInterstitialAd(k k2, d d2) {
        d2.a(new T0.b(7, this.getClass().getSimpleName().concat(" does not support interstitial ads."), "com.google.android.gms.ads"));
    }

    @Deprecated
    public void loadNativeAd(m m2, d d2) {
        d2.a(new T0.b(7, this.getClass().getSimpleName().concat(" does not support native ads."), "com.google.android.gms.ads"));
    }

    public void loadNativeAdMapper(m m2, d d2) {
        throw new RemoteException("Method is not found");
    }

    public void loadRewardedAd(o o2, d d2) {
        d2.a(new T0.b(7, this.getClass().getSimpleName().concat(" does not support rewarded ads."), "com.google.android.gms.ads"));
    }

    public void loadRewardedInterstitialAd(o o2, d d2) {
        d2.a(new T0.b(7, this.getClass().getSimpleName().concat(" does not support rewarded interstitial ads."), "com.google.android.gms.ads"));
    }
}

