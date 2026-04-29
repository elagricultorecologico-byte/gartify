/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  com.google.android.gms.internal.ads.vx
 *  java.lang.Object
 */
package d1;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.vx;
import d1.r;

public final class t {
    public final int a;
    public final ViewGroup.LayoutParams b;
    public final ViewGroup c;
    public final Context d;

    public t(vx vx2) {
        this.b = vx2.getLayoutParams();
        ViewParent viewParent = vx2.getParent();
        this.d = vx2.R();
        if (viewParent instanceof ViewGroup) {
            viewParent = (ViewGroup)viewParent;
            this.c = viewParent;
            this.a = viewParent.indexOfChild(vx2.l0());
            viewParent.removeView(vx2.l0());
            vx2.e1(true);
            return;
        }
        throw new r("Could not get the parent of the WebView for an overlay.");
    }
}

