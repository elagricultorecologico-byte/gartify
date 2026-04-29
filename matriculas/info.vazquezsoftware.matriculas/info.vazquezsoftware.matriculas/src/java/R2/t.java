/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.graphics.b
 *  androidx.core.view.F
 *  androidx.core.view.T
 *  androidx.core.view.t0
 *  androidx.core.view.t0$m
 *  java.lang.Object
 */
package r2;

import android.view.View;
import androidx.core.graphics.b;
import androidx.core.view.F;
import androidx.core.view.T;
import androidx.core.view.t0;
import r2.s;

public abstract class t {
    public static /* synthetic */ t0 a(int n2, View view, t0 t02) {
        b b2 = t02.f(t0.m.e());
        float f2 = view.getContext().getResources().getDisplayMetrics().density;
        n2 = (int)((float)n2 * f2);
        view.setPadding(b2.a + n2, b2.b + n2, b2.c + n2, b2.d + n2);
        return t02;
    }

    public static void b(View view, int n2) {
        if (view == null) {
            return;
        }
        T.q0((View)view, (F)new s(n2));
    }
}

