/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorInflater
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.ValueAnimator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.Log
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  p.i
 */
package N1;

import N1.d;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import p.i;

public class c {
    private final i a = new i();
    private final i b = new i();

    private static void a(c c2, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            animator = (ObjectAnimator)animator;
            c2.e(animator.getPropertyName(), animator.getValues());
            c2.f(animator.getPropertyName(), d.a((ValueAnimator)animator));
            return;
        }
        c2 = new StringBuilder();
        c2.append("Animator must be an ObjectAnimator: ");
        c2.append(animator);
        throw new IllegalArgumentException(c2.toString());
    }

    public static c b(Context context, TypedArray typedArray, int n2) {
        if (typedArray.hasValue(n2) && (n2 = typedArray.getResourceId(n2, 0)) != 0) {
            return c.c(context, n2);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c c(Context object, int n2) {
        Exception exception2;
        block3: {
            Animator animator;
            try {
                animator = AnimatorInflater.loadAnimator((Context)object, (int)n2);
                if (animator instanceof AnimatorSet) {
                    return c.d((List)((AnimatorSet)animator).getChildAnimations());
                }
            }
            catch (Exception exception2) {
                break block3;
            }
            if (animator == null) return null;
            object = new ArrayList();
            object.add((Object)animator);
            return c.d((List)object);
        }
        object = new StringBuilder();
        object.append("Can't load animation resource ID #0x");
        object.append(Integer.toHexString((int)n2));
        Log.w((String)"MotionSpec", (String)object.toString(), (Throwable)exception2);
        return null;
    }

    private static c d(List list) {
        c c2 = new c();
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            c.a(c2, (Animator)list.get(i2));
        }
        return c2;
    }

    public void e(String string, PropertyValuesHolder[] propertyValuesHolderArray) {
        this.b.put((Object)string, (Object)propertyValuesHolderArray);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof c)) {
            return false;
        }
        object = (c)object;
        return this.a.equals((Object)((c)object).a);
    }

    public void f(String string, d d2) {
        this.a.put((Object)string, (Object)d2);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString((int)System.identityHashCode((Object)this)));
        stringBuilder.append(" timings: ");
        stringBuilder.append((Object)this.a);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}

