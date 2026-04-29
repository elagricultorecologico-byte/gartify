/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.util.TypedValue
 *  android.view.animation.AnimationUtils
 *  android.view.animation.PathInterpolator
 *  androidx.core.graphics.d
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package Y1;

import M1.j;
import O.l;
import a2.b;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import androidx.core.graphics.d;

public abstract class h {
    private static float a(String[] stringBuilder, int n3) {
        float f3 = Float.parseFloat((String)stringBuilder[n3]);
        if (!(f3 < 0.0f) && !(f3 > 1.0f)) {
            return f3;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Motion easing control point value must be between 0 and 1; instead got: ");
        stringBuilder.append(f3);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static String b(String string, String string2) {
        return string.substring(string2.length() + 1, string.length() - 1);
    }

    private static TimeInterpolator c(String stringArray) {
        if (h.e((String)stringArray, "cubic-bezier")) {
            if ((stringArray = h.b((String)stringArray, "cubic-bezier").split(",")).length == 4) {
                return new PathInterpolator(h.a(stringArray, 0), h.a(stringArray, 1), h.a(stringArray, 2), h.a(stringArray, 3));
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: ");
            stringBuilder.append(stringArray.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (h.e((String)stringArray, "path")) {
            return new PathInterpolator(d.e((String)h.b((String)stringArray, "path")));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid motion easing type: ");
        stringBuilder.append((String)stringArray);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private static boolean d(String string) {
        return h.e(string, "cubic-bezier") || h.e(string, "path");
        {
        }
    }

    private static boolean e(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("(");
        return string.startsWith(stringBuilder.toString()) && string.endsWith(")");
    }

    public static int f(Context context, int n3, int n4) {
        return b.d(context, n3, n4);
    }

    public static TimeInterpolator g(Context context, int n3, TimeInterpolator object) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(n3, typedValue, true)) {
            return object;
        }
        if (typedValue.type == 3) {
            object = String.valueOf((Object)typedValue.string);
            if (h.d((String)object)) {
                return h.c((String)object);
            }
            return AnimationUtils.loadInterpolator((Context)context, (int)typedValue.resourceId);
        }
        throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static l h(Context context, int n3, int n4) {
        Throwable throwable2;
        block7: {
            Object object;
            block5: {
                block6: {
                    object = b.a(context, n3);
                    context = object == null ? context.obtainStyledAttributes(null, j.Y2, 0, n4) : context.obtainStyledAttributes(((TypedValue)object).resourceId, j.Y2);
                    object = new l();
                    try {
                        float f3 = context.getFloat(j.a3, Float.MIN_VALUE);
                        if (f3 == Float.MIN_VALUE) break block5;
                        float f4 = context.getFloat(j.Z2, Float.MIN_VALUE);
                        if (f4 == Float.MIN_VALUE) break block6;
                        ((l)object).h(f3);
                        ((l)object).f(f4);
                    }
                    catch (Throwable throwable2) {}
                    context.recycle();
                    return object;
                }
                object = new IllegalArgumentException("A MaterialSpring style must have a damping value.");
                throw object;
                break block7;
            }
            object = new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
            throw object;
        }
        context.recycle();
        throw throwable2;
    }
}

