/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator$DurationScaleChangeListener
 *  java.lang.Object
 */
package O;

import O.c;
import android.animation.ValueAnimator;

public final class f
implements ValueAnimator.DurationScaleChangeListener {
    public final c.d a;

    public /* synthetic */ f(c.d d2) {
        this.a = d2;
    }

    public final void onChanged(float f2) {
        c.d.c(this.a, f2);
    }
}

