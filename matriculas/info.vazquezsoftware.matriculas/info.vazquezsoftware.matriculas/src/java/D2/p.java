/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Path
 *  android.graphics.RectF
 *  android.os.Build$VERSION
 *  android.view.View
 *  java.lang.Object
 */
package d2;

import P1.a;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import d2.l;
import d2.m;
import d2.q;
import d2.r;

public abstract class p {
    boolean a = false;
    boolean b = false;
    l c;
    RectF d = new RectF();
    final Path e = new Path();

    public static p a(View view) {
        if (Build.VERSION.SDK_INT >= 33) {
            return new r(view);
        }
        return new q(view);
    }

    private boolean c() {
        RectF rectF = this.d;
        return rectF.left <= rectF.right && rectF.top <= rectF.bottom;
    }

    private void j() {
        if (this.c() && this.c != null) {
            m.l().d(this.c, 1.0f, this.d, this.e);
        }
    }

    abstract void b(View var1);

    public void d(Canvas canvas, a.a a2) {
        if (this.i() && !this.e.isEmpty()) {
            canvas.save();
            canvas.clipPath(this.e);
            a2.a(canvas);
            canvas.restore();
            return;
        }
        a2.a(canvas);
    }

    public void e(View view, RectF rectF) {
        this.d = rectF;
        this.j();
        this.b(view);
    }

    public void f(View view, l l2) {
        this.c = l2;
        this.j();
        this.b(view);
    }

    public void g(View view, boolean bl) {
        if (bl != this.a) {
            this.a = bl;
            this.b(view);
        }
    }

    public void h(View view, boolean bl) {
        this.b = bl;
        this.b(view);
    }

    abstract boolean i();
}

