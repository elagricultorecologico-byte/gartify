/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.animation.ValueAnimator
 *  java.lang.Math
 *  java.lang.Object
 *  java.util.Collection
 *  java.util.List
 */
package N1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.Collection;
import java.util.List;

public abstract class b {
    public static void a(AnimatorSet animatorSet, List list) {
        Animator animator;
        int n2 = list.size();
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            animator = (Animator)list.get(i2);
            l2 = Math.max((long)l2, (long)(animator.getStartDelay() + animator.getDuration()));
        }
        animator = ValueAnimator.ofInt((int[])new int[]{0, 0});
        animator.setDuration(l2);
        list.add(0, (Object)animator);
        animatorSet.playTogether((Collection)list);
    }
}

