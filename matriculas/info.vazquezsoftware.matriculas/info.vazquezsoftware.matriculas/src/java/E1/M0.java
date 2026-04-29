/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  com.google.android.gms.internal.ads.Su
 *  java.lang.Object
 */
package e1;

import a1.t;
import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.gms.internal.ads.Su;

public final class m0 {
    private final View a;
    private Activity b;
    private boolean c;
    private boolean d;
    private boolean e;
    private final ViewTreeObserver.OnGlobalLayoutListener f;

    public m0(Activity activity, View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.b = activity;
        this.a = view;
        this.f = onGlobalLayoutListener;
    }

    private final void f() {
        if (!this.c) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
            Activity activity = this.b;
            if (activity != null) {
                onGlobalLayoutListener = this.f;
                if ((activity = m0.h(activity)) != null) {
                    activity.addOnGlobalLayoutListener(onGlobalLayoutListener);
                }
            }
            activity = this.a;
            onGlobalLayoutListener = this.f;
            t.c();
            Su.a((View)activity, (ViewTreeObserver.OnGlobalLayoutListener)onGlobalLayoutListener);
            this.c = true;
        }
    }

    private final void g() {
        Activity activity = this.b;
        if (activity != null && this.c) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.f;
            if ((activity = m0.h(activity)) != null) {
                activity.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            this.c = false;
        }
    }

    private static ViewTreeObserver h(Activity activity) {
        if ((activity = activity.getWindow()) != null && (activity = activity.getDecorView()) != null) {
            return activity.getViewTreeObserver();
        }
        return null;
    }

    public final void a(Activity activity) {
        this.b = activity;
    }

    public final void b() {
        this.e = true;
        if (this.d) {
            this.f();
        }
    }

    public final void c() {
        this.e = false;
        this.g();
    }

    public final void d() {
        this.d = true;
        if (this.e) {
            this.f();
        }
    }

    public final void e() {
        this.d = false;
        this.g();
    }
}

