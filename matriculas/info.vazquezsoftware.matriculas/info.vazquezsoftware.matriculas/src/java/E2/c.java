/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 *  android.view.ViewGroup$MarginLayoutParams
 *  com.google.android.material.sidesheet.SideSheetBehavior
 *  java.lang.Object
 */
package e2;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.sidesheet.SideSheetBehavior;

public final class c
implements ValueAnimator.AnimatorUpdateListener {
    public final SideSheetBehavior a;
    public final ViewGroup.MarginLayoutParams b;
    public final int c;
    public final View d;

    public /* synthetic */ c(SideSheetBehavior sideSheetBehavior, ViewGroup.MarginLayoutParams marginLayoutParams, int n2, View view) {
        this.a = sideSheetBehavior;
        this.b = marginLayoutParams;
        this.c = n2;
        this.d = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SideSheetBehavior.K((SideSheetBehavior)this.a, (ViewGroup.MarginLayoutParams)this.b, (int)this.c, (View)this.d, (ValueAnimator)valueAnimator);
    }
}

