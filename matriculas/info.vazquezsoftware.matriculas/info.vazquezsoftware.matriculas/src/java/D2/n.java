/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  android.graphics.RectF
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package d2;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import c2.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class n {
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    private final List g = new ArrayList();
    private final List h = new ArrayList();
    private boolean i;

    public n() {
        this.n(0.0f, 0.0f);
    }

    private void b(float f2) {
        float f3;
        if (this.g() == f2 || (f3 = (f2 - this.g() + 360.0f) % 360.0f) > 180.0f) {
            return;
        }
        d d2 = new d(this.i(), this.j(), this.i(), this.j());
        d2.s(this.g());
        d2.t(f3);
        this.h.add((Object)new b(d2));
        this.p(f2);
    }

    private void c(g g2, float f2, float f3) {
        this.b(f2);
        this.h.add((Object)g2);
        this.p(f3);
    }

    private float g() {
        return this.e;
    }

    private float h() {
        return this.f;
    }

    private void p(float f2) {
        this.e = f2;
    }

    private void q(float f2) {
        this.f = f2;
    }

    private void r(float f2) {
        this.c = f2;
    }

    private void s(float f2) {
        this.d = f2;
    }

    private void t(float f2) {
        this.a = f2;
    }

    private void u(float f2) {
        this.b = f2;
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        Object object = new d(f2, f3, f4, f5);
        ((d)object).s(f6);
        ((d)object).t(f7);
        this.g.add(object);
        object = new b((d)object);
        float f8 = f6 + f7;
        boolean bl = f7 < 0.0f;
        f7 = f6;
        if (bl) {
            f7 = (f6 + 180.0f) % 360.0f;
        }
        f6 = bl ? (180.0f + f8) % 360.0f : f8;
        this.c((g)object, f7, f6);
        f6 = (f4 - f2) / 2.0f;
        double d2 = f8;
        this.r((f2 + f4) * 0.5f + f6 * (float)Math.cos((double)Math.toRadians((double)d2)));
        this.s((f3 + f5) * 0.5f + (f5 - f3) / 2.0f * (float)Math.sin((double)Math.toRadians((double)d2)));
    }

    public void d(Matrix matrix, Path path) {
        int n2 = this.g.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            ((f)this.g.get(i2)).a(matrix, path);
        }
    }

    boolean e() {
        return this.i;
    }

    g f(Matrix matrix) {
        this.b(this.h());
        matrix = new Matrix(matrix);
        return new g(this, (List)new ArrayList((Collection)this.h), matrix){
            final List c;
            final Matrix d;
            final n e;
            {
                this.e = n2;
                this.c = list;
                this.d = matrix;
            }

            @Override
            public void a(Matrix matrix, a a2, int n2, Canvas canvas) {
                matrix = this.c.iterator();
                while (matrix.hasNext()) {
                    ((g)matrix.next()).a(this.d, a2, n2, canvas);
                }
            }
        };
    }

    float i() {
        return this.c;
    }

    float j() {
        return this.d;
    }

    float k() {
        return this.a;
    }

    float l() {
        return this.b;
    }

    public void m(float f2, float f3) {
        Object object = new e();
        d2.n$e.c((e)object, f2);
        d2.n$e.e((e)object, f3);
        this.g.add(object);
        object = new c((e)object, this.i(), this.j());
        this.c((g)object, ((c)object).c() + 270.0f, ((c)object).c() + 270.0f);
        this.r(f2);
        this.s(f3);
    }

    public void n(float f2, float f3) {
        this.o(f2, f3, 270.0f, 0.0f);
    }

    public void o(float f2, float f3, float f4, float f5) {
        this.t(f2);
        this.u(f3);
        this.r(f2);
        this.s(f3);
        this.p(f4);
        this.q((f4 + f5) % 360.0f);
        this.g.clear();
        this.h.clear();
        this.i = false;
    }

    static class b
    extends g {
        private final d c;

        public b(d d2) {
            this.c = d2;
        }

        @Override
        public void a(Matrix matrix, a a2, int n2, Canvas canvas) {
            float f2 = this.c.m();
            float f3 = this.c.n();
            a2.a(canvas, matrix, new RectF(this.c.k(), this.c.o(), this.c.l(), this.c.j()), n2, f2, f3);
        }
    }

    static class c
    extends g {
        private final e c;
        private final float d;
        private final float e;

        public c(e e2, float f2, float f3) {
            this.c = e2;
            this.d = f2;
            this.e = f3;
        }

        @Override
        public void a(Matrix matrix, a a2, int n2, Canvas canvas) {
            float f2 = this.c.c;
            float f3 = this.e;
            float f4 = this.c.b;
            float f5 = this.d;
            RectF rectF = new RectF(0.0f, 0.0f, (float)Math.hypot((double)(f2 - f3), (double)(f4 - f5)), 0.0f);
            this.a.set(matrix);
            this.a.preTranslate(this.d, this.e);
            this.a.preRotate(this.c());
            a2.b(canvas, this.a, rectF, n2);
        }

        float c() {
            return (float)Math.toDegrees((double)Math.atan((double)((this.c.c - this.e) / (this.c.b - this.d))));
        }
    }

    public static class d
    extends f {
        private static final RectF h = new RectF();
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;

        public d(float f2, float f3, float f4, float f5) {
            this.q(f2);
            this.u(f3);
            this.r(f4);
            this.p(f5);
        }

        private float j() {
            return this.e;
        }

        private float k() {
            return this.b;
        }

        private float l() {
            return this.d;
        }

        private float m() {
            return this.f;
        }

        private float n() {
            return this.g;
        }

        private float o() {
            return this.c;
        }

        private void p(float f2) {
            this.e = f2;
        }

        private void q(float f2) {
            this.b = f2;
        }

        private void r(float f2) {
            this.d = f2;
        }

        private void s(float f2) {
            this.f = f2;
        }

        private void t(float f2) {
            this.g = f2;
        }

        private void u(float f2) {
            this.c = f2;
        }

        @Override
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            matrix2 = h;
            matrix2.set(this.k(), this.o(), this.l(), this.j());
            path.arcTo((RectF)matrix2, this.m(), this.n(), false);
            path.transform(matrix);
        }
    }

    public static class e
    extends f {
        private float b;
        private float c;

        static /* synthetic */ float c(e e2, float f2) {
            e2.b = f2;
            return f2;
        }

        static /* synthetic */ float e(e e2, float f2) {
            e2.c = f2;
            return f2;
        }

        @Override
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.b, this.c);
            path.transform(matrix);
        }
    }

    public static abstract class f {
        protected final Matrix a = new Matrix();

        public abstract void a(Matrix var1, Path var2);
    }

    static abstract class g {
        static final Matrix b = new Matrix();
        final Matrix a = new Matrix();

        g() {
        }

        public abstract void a(Matrix var1, a var2, int var3, Canvas var4);

        public final void b(a a2, int n2, Canvas canvas) {
            this.a(b, a2, n2, canvas);
        }
    }
}

