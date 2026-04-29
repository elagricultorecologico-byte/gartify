/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.util.Log
 *  android.view.View
 *  android.view.animation.PathInterpolator
 *  androidx.activity.b
 *  java.lang.Object
 *  java.lang.String
 */
package Y1;

import Y1.h;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.activity.b;

public abstract class a {
    private final TimeInterpolator a = new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);
    protected final View b;
    protected final int c;
    protected final int d;
    protected final int e;
    private b f;

    public a(View view) {
        this.b = view;
        view = view.getContext();
        this.c = h.f((Context)view, M1.a.v, 300);
        this.d = h.f((Context)view, M1.a.y, 150);
        this.e = h.f((Context)view, M1.a.x, 100);
    }

    public float a(float f3) {
        return this.a.getInterpolation(f3);
    }

    protected b b() {
        if (this.f == null) {
            Log.w((String)"MaterialBackHelper", (String)"Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        b b3 = this.f;
        this.f = null;
        return b3;
    }

    public b c() {
        b b3 = this.f;
        this.f = null;
        return b3;
    }

    protected void d(b b3) {
        this.f = b3;
    }

    protected b e(b b3) {
        if (this.f == null) {
            Log.w((String)"MaterialBackHelper", (String)"Must call startBackProgress() before updateBackProgress()");
        }
        b b4 = this.f;
        this.f = b3;
        return b4;
    }
}

