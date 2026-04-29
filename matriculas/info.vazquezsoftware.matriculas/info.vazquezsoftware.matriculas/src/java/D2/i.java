/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  com.google.android.material.internal.t
 *  java.lang.Object
 */
package d2;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.t;
import d2.e;
import d2.f;
import d2.g;
import d2.h;
import d2.k;

public abstract class i {
    static e a(int n2) {
        if (n2 != 0) {
            if (n2 != 1) {
                return i.b();
            }
            return new f();
        }
        return new k();
    }

    static e b() {
        return new k();
    }

    static g c() {
        return new g();
    }

    public static void d(View view, float f2) {
        if ((view = view.getBackground()) instanceof h) {
            ((h)view).a0(f2);
        }
    }

    public static void e(View view) {
        Drawable drawable = view.getBackground();
        if (drawable instanceof h) {
            i.f(view, (h)drawable);
        }
    }

    public static void f(View view, h h3) {
        if (h3.S()) {
            h3.f0(t.f((View)view));
        }
    }
}

