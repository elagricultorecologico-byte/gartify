/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.Path$Op
 *  android.graphics.PointF
 *  android.graphics.RectF
 *  java.lang.Math
 *  java.lang.Object
 */
package d2;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import d2.d;
import d2.e;
import d2.g;
import d2.l;
import d2.n;

public class m {
    private final n[] a = new n[4];
    private final Matrix[] b = new Matrix[4];
    private final Matrix[] c = new Matrix[4];
    private final PointF d = new PointF();
    private final Path e = new Path();
    private final Path f = new Path();
    private final n g = new n();
    private final float[] h = new float[2];
    private final float[] i = new float[2];
    private final Path j = new Path();
    private final Path k = new Path();
    private boolean l = true;

    public m() {
        for (int i2 = 0; i2 < 4; ++i2) {
            this.a[i2] = new n();
            this.b[i2] = new Matrix();
            this.c[i2] = new Matrix();
        }
    }

    private float a(int n2) {
        return (n2 + 1) % 4 * 90;
    }

    private void b(c object, int n2) {
        this.h[0] = this.a[n2].k();
        this.h[1] = this.a[n2].l();
        this.b[n2].mapPoints(this.h);
        if (n2 == 0) {
            Path path = ((c)object).b;
            float[] fArray = this.h;
            path.moveTo(fArray[0], fArray[1]);
        } else {
            Path path = ((c)object).b;
            float[] fArray = this.h;
            path.lineTo(fArray[0], fArray[1]);
        }
        this.a[n2].d(this.b[n2], ((c)object).b);
        object = ((c)object).d;
        if (object != null) {
            object.a(this.a[n2], this.b[n2], n2);
        }
    }

    private void c(c object, int n2) {
        int n3 = (n2 + 1) % 4;
        this.h[0] = this.a[n2].i();
        this.h[1] = this.a[n2].j();
        this.b[n2].mapPoints(this.h);
        this.i[0] = this.a[n3].k();
        this.i[1] = this.a[n3].l();
        this.b[n3].mapPoints(this.i);
        Object object2 = this.h;
        float f2 = object2[0];
        Object object3 = this.i;
        float f3 = Math.max((float)((float)Math.hypot((double)(f2 - object3[0]), (double)(object2[1] - object3[1])) - 0.001f), (float)0.0f);
        f2 = this.j(((c)object).c, n2);
        this.g.n(0.0f, 0.0f);
        object3 = this.k(n2, ((c)object).a);
        object3.b(f3, f2, ((c)object).e, this.g);
        this.j.reset();
        this.g.d(this.c[n2], this.j);
        if (this.l && (object3.a() || this.m(this.j, n2) || this.m(this.j, n3))) {
            object3 = this.j;
            object3.op((Path)object3, this.f, Path.Op.DIFFERENCE);
            this.h[0] = this.g.k();
            this.h[1] = this.g.l();
            this.c[n2].mapPoints(this.h);
            object2 = this.e;
            object3 = this.h;
            object2.moveTo(object3[0], object3[1]);
            this.g.d(this.c[n2], this.e);
        } else {
            this.g.d(this.c[n2], ((c)object).b);
        }
        object = ((c)object).d;
        if (object != null) {
            object.b(this.g, this.c[n2], n2);
        }
    }

    private void g(int n2, RectF rectF, PointF pointF) {
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    pointF.set(rectF.right, rectF.top);
                    return;
                }
                pointF.set(rectF.left, rectF.top);
                return;
            }
            pointF.set(rectF.left, rectF.bottom);
            return;
        }
        pointF.set(rectF.right, rectF.bottom);
    }

    private e i(int n2, l l2) {
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return l2.s();
                }
                return l2.q();
            }
            return l2.i();
        }
        return l2.k();
    }

    private float j(RectF rectF, int n2) {
        float[] fArray = this.h;
        n n3 = this.a[n2];
        fArray[0] = n3.c;
        fArray[1] = n3.d;
        this.b[n2].mapPoints(fArray);
        if (n2 != 1 && n2 != 3) {
            return Math.abs((float)(rectF.centerY() - this.h[1]));
        }
        return Math.abs((float)(rectF.centerX() - this.h[0]));
    }

    private g k(int n2, l l2) {
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return l2.o();
                }
                return l2.p();
            }
            return l2.n();
        }
        return l2.h();
    }

    public static m l() {
        return d2.m$a.a;
    }

    private boolean m(Path path, int n2) {
        this.k.reset();
        this.a[n2].d(this.b[n2], this.k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.k.computeBounds(rectF, true);
        path.op(this.k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || rectF.width() > 1.0f && rectF.height() > 1.0f;
        {
        }
    }

    private void n(c c2, int n2, float[] object) {
        object = object == null ? (Object)this.h(n2, c2.a) : (Object)new d2.c(object[n2]);
        this.i(n2, c2.a).b(this.a[n2], 90.0f, c2.e, c2.c, (d)object);
        float f2 = this.a(n2);
        this.b[n2].reset();
        this.g(n2, c2.c, this.d);
        object = this.b[n2];
        c2 = this.d;
        object.setTranslate(((PointF)c2).x, ((PointF)c2).y);
        this.b[n2].preRotate(f2);
    }

    private void o(int n2) {
        this.h[0] = this.a[n2].i();
        this.h[1] = this.a[n2].j();
        this.b[n2].mapPoints(this.h);
        float f2 = this.a(n2);
        this.c[n2].reset();
        Matrix matrix = this.c[n2];
        float[] fArray = this.h;
        matrix.setTranslate(fArray[0], fArray[1]);
        this.c[n2].preRotate(f2);
    }

    public void d(l l2, float f2, RectF rectF, Path path) {
        this.e(l2, f2, rectF, null, path);
    }

    public void e(l l2, float f2, RectF rectF, b b2, Path path) {
        this.f(l2, null, f2, rectF, b2, path);
    }

    public void f(l object, float[] fArray, float f2, RectF rectF, b b2, Path path) {
        path.rewind();
        this.e.rewind();
        this.f.rewind();
        this.f.addRect(rectF, Path.Direction.CW);
        object = new c((l)object, f2, rectF, b2, path);
        int n2 = 0;
        int n3 = 0;
        while (true) {
            if (n3 >= 4) break;
            this.n((c)object, n3, fArray);
            this.o(n3);
            ++n3;
        }
        for (int i2 = n2; i2 < 4; ++i2) {
            this.b((c)object, i2);
            this.c((c)object, i2);
        }
        path.close();
        this.e.close();
        if (!this.e.isEmpty()) {
            path.op(this.e, Path.Op.UNION);
        }
    }

    d h(int n2, l l2) {
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return l2.t();
                }
                return l2.r();
            }
            return l2.j();
        }
        return l2.l();
    }

    private static abstract class a {
        static final m a = new m();
    }

    public static interface b {
        public void a(n var1, Matrix var2, int var3);

        public void b(n var1, Matrix var2, int var3);
    }

    static final class c {
        public final l a;
        public final Path b;
        public final RectF c;
        public final b d;
        public final float e;

        c(l l2, float f2, RectF rectF, b b2, Path path) {
            this.d = b2;
            this.a = l2;
            this.e = f2;
            this.c = rectF;
            this.b = path;
        }
    }
}

