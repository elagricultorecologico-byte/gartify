/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.util.TypedValue
 *  androidx.appcompat.widget.f0
 *  g.a
 *  java.lang.Object
 */
package a2;

import a2.e;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.appcompat.widget.f0;
import g.a;

public abstract class c {
    public static ColorStateList a(Context context, TypedArray typedArray, int n3) {
        int n4;
        if (typedArray.hasValue(n3) && (n4 = typedArray.getResourceId(n3, 0)) != 0 && (context = a.a((Context)context, (int)n4)) != null) {
            return context;
        }
        return typedArray.getColorStateList(n3);
    }

    public static ColorStateList b(Context context, f0 f02, int n3) {
        int n4;
        if (f02.s(n3) && (n4 = f02.n(n3, 0)) != 0 && (context = a.a((Context)context, (int)n4)) != null) {
            return context;
        }
        return f02.c(n3);
    }

    public static int c(Context context, TypedArray typedArray, int n3, int n4) {
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(n3, typedValue) && typedValue.type == 2) {
            context = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
            n3 = context.getDimensionPixelSize(0, n4);
            context.recycle();
            return n3;
        }
        return typedArray.getDimensionPixelSize(n3, n4);
    }

    public static Drawable d(Context context, TypedArray typedArray, int n3) {
        int n4;
        if (typedArray.hasValue(n3) && (n4 = typedArray.getResourceId(n3, 0)) != 0 && (context = a.b((Context)context, (int)n4)) != null) {
            return context;
        }
        return typedArray.getDrawable(n3);
    }

    static int e(TypedArray typedArray, int n3, int n4) {
        if (typedArray.hasValue(n3)) {
            return n3;
        }
        return n4;
    }

    public static e f(Context context, TypedArray typedArray, int n3) {
        if (typedArray.hasValue(n3) && (n3 = typedArray.getResourceId(n3, 0)) != 0) {
            return new e(context, n3);
        }
        return null;
    }

    public static boolean g(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean h(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}

