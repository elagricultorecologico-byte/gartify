/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.graphics.RectF
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  java.lang.Object
 *  java.lang.Override
 */
package d2;

import android.graphics.Outline;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import d2.k;
import d2.l;
import d2.p;

class q
extends p {
    private boolean f = false;
    private float g = 0.0f;

    q(View view) {
        this.m(view);
    }

    private float l() {
        RectF rectF;
        l l2 = this.c;
        if (l2 != null && (rectF = this.d) != null) {
            return l2.f.a(rectF);
        }
        return 0.0f;
    }

    private void m(View view) {
        view.setOutlineProvider(new ViewOutlineProvider(this){
            final q a;
            {
                this.a = q2;
            }

            public void getOutline(View object, Outline outline) {
                object = this.a;
                if (object.c != null && !object.d.isEmpty()) {
                    object = this.a;
                    RectF rectF = object.d;
                    outline.setRoundRect((int)rectF.left, (int)rectF.top, (int)rectF.right, (int)rectF.bottom, ((q)object).g);
                }
            }
        });
    }

    private boolean n() {
        l l2;
        if (!this.d.isEmpty() && (l2 = this.c) != null) {
            return l2.v(this.d);
        }
        return false;
    }

    private boolean o() {
        block2: {
            block4: {
                float f2;
                float f3;
                float f4;
                float f5;
                l l2;
                block6: {
                    block5: {
                        float f6;
                        block3: {
                            if (this.d.isEmpty() || (l2 = this.c) == null || !this.b || l2.v(this.d) || !q.p(this.c)) break block2;
                            f5 = this.c.r().a(this.d);
                            f4 = this.c.t().a(this.d);
                            f3 = this.c.j().a(this.d);
                            f2 = this.c.l().a(this.d);
                            float f7 = f5 - 0.0f;
                            f6 = f7 == 0.0f ? 0 : (f7 > 0.0f ? 1 : -1);
                            if (f6 != false || f3 != 0.0f || f4 != f2) break block3;
                            l2 = this.d;
                            l2.set(((RectF)l2).left - f4, ((RectF)l2).top, ((RectF)l2).right, ((RectF)l2).bottom);
                            this.g = f4;
                            break block4;
                        }
                        if (f6 != false || f4 != 0.0f || f3 != f2) break block5;
                        l2 = this.d;
                        l2.set(((RectF)l2).left, ((RectF)l2).top - f3, ((RectF)l2).right, ((RectF)l2).bottom);
                        this.g = f3;
                        break block4;
                    }
                    if (f4 != 0.0f || f2 != 0.0f || f5 != f3) break block6;
                    l2 = this.d;
                    l2.set(((RectF)l2).left, ((RectF)l2).top, ((RectF)l2).right + f5, ((RectF)l2).bottom);
                    this.g = f5;
                    break block4;
                }
                if (f3 != 0.0f || f2 != 0.0f || f5 != f4) break block2;
                l2 = this.d;
                l2.set(((RectF)l2).left, ((RectF)l2).top, ((RectF)l2).right, ((RectF)l2).bottom + f5);
                this.g = f5;
            }
            return true;
        }
        return false;
    }

    private static boolean p(l l2) {
        return l2.q() instanceof k && l2.s() instanceof k && l2.i() instanceof k && l2.k() instanceof k;
    }

    @Override
    void b(View view) {
        this.g = this.l();
        boolean bl = this.n() || this.o();
        this.f = bl;
        view.setClipToOutline(this.i() ^ true);
        if (this.i()) {
            view.invalidate();
            return;
        }
        view.invalidateOutline();
    }

    @Override
    boolean i() {
        return !this.f || this.a;
        {
        }
    }
}

