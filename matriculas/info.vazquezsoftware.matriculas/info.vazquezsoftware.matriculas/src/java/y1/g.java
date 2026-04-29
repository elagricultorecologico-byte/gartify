/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.util.Property
 *  android.view.Gravity
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  androidx.activity.b
 *  java.lang.Float
 *  java.lang.Object
 */
package Y1;

import M1.c;
import U.b;
import Y1.a;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.util.Property;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

public class g
extends a {
    private final float g;
    private final float h;
    private final float i;

    public g(View view) {
        super(view);
        view = view.getResources();
        this.g = view.getDimension(M1.c.k);
        this.h = view.getDimension(M1.c.j);
        this.i = view.getDimension(M1.c.l);
    }

    private boolean g(int n3, int n4) {
        return (Gravity.getAbsoluteGravity((int)n3, (int)this.b.getLayoutDirection()) & n4) == n4;
    }

    private int i(boolean bl) {
        ViewGroup.LayoutParams layoutParams = this.b.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            layoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
            if (bl) {
                return layoutParams.leftMargin;
            }
            return layoutParams.rightMargin;
        }
        return 0;
    }

    public void f() {
        if (super.b() == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat((Object)this.b, (Property)View.SCALE_X, (float[])new float[]{1.0f}), ObjectAnimator.ofFloat((Object)this.b, (Property)View.SCALE_Y, (float[])new float[]{1.0f})});
        View view = this.b;
        if (view instanceof ViewGroup) {
            view = (ViewGroup)view;
            for (int i3 = 0; i3 < view.getChildCount(); ++i3) {
                animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat((Object)view.getChildAt(i3), (Property)View.SCALE_Y, (float[])new float[]{1.0f})});
            }
        }
        animatorSet.setDuration((long)this.e);
        animatorSet.start();
    }

    public void h(androidx.activity.b b3, int n3, Animator.AnimatorListener animatorListener, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        boolean bl = b3.b() == 0;
        boolean bl2 = this.g(n3, 3);
        float f3 = (float)this.b.getWidth() * this.b.getScaleX() + (float)this.i(bl2);
        View view = this.b;
        Property property = View.TRANSLATION_X;
        float f4 = f3;
        if (bl2) {
            f4 = -f3;
        }
        view = ObjectAnimator.ofFloat((Object)view, (Property)property, (float[])new float[]{f4});
        if (animatorUpdateListener != null) {
            view.addUpdateListener(animatorUpdateListener);
        }
        view.setInterpolator((TimeInterpolator)new b());
        view.setDuration((long)N1.a.c(this.c, this.d, b3.a()));
        view.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, bl, n3){
            final boolean a;
            final int b;
            final g c;
            {
                this.c = g3;
                this.a = bl;
                this.b = n3;
            }

            public void onAnimationEnd(Animator animator) {
                this.c.b.setTranslationX(0.0f);
                this.c.k(0.0f, this.a, this.b);
            }
        });
        if (animatorListener != null) {
            view.addListener(animatorListener);
        }
        view.start();
    }

    public void j(androidx.activity.b b3) {
        super.d(b3);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void k(float f3, boolean bl, int n3) {
        float f4 = this.a(f3);
        boolean bl2 = this.g(n3, 3);
        int n4 = 0;
        n3 = bl == bl2 ? 1 : 0;
        int n5 = this.b.getWidth();
        int n6 = this.b.getHeight();
        f3 = n5;
        if (f3 <= 0.0f) return;
        float f5 = n6;
        if (f5 <= 0.0f) {
            return;
        }
        float f6 = this.g / f3;
        float f7 = this.h / f3;
        float f8 = this.i / f5;
        View view = this.b;
        if (bl2) {
            f3 = 0.0f;
        }
        view.setPivotX(f3);
        f3 = n3 != 0 ? f7 : -f6;
        f5 = N1.a.a(0.0f, f3, f4);
        f6 = f5 + 1.0f;
        f4 = 1.0f - N1.a.a(0.0f, f8, f4);
        if (Float.isNaN((float)f6)) return;
        if (Float.isNaN((float)f4)) {
            return;
        }
        this.b.setScaleX(f6);
        this.b.setScaleY(f4);
        view = this.b;
        if (!(view instanceof ViewGroup)) return;
        ViewGroup viewGroup = (ViewGroup)view;
        while (n4 < viewGroup.getChildCount()) {
            view = viewGroup.getChildAt(n4);
            n6 = bl2 ? n5 - view.getRight() + view.getWidth() : -view.getLeft();
            f3 = n6;
            view.setPivotX(f3);
            view.setPivotY((float)(-view.getTop()));
            f3 = n3 != 0 ? 1.0f - f5 : 1.0f;
            f7 = f4 != 0.0f ? f6 / f4 * f3 : 1.0f;
            if (!Float.isNaN((float)f3) && !Float.isNaN((float)f7)) {
                view.setScaleX(f3);
                view.setScaleY(f7);
            }
            ++n4;
        }
    }

    public void l(androidx.activity.b b3, int n3) {
        if (super.e(b3) == null) {
            return;
        }
        boolean bl = b3.b() == 0;
        this.k(b3.a(), bl, n3);
    }
}

