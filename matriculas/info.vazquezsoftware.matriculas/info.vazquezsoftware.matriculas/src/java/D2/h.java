/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Outline
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  android.graphics.Xfermode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build$VERSION
 *  android.os.Looper
 *  android.util.AttributeSet
 *  android.util.Log
 *  com.google.android.material.drawable.d
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Override
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.BitSet
 */
package d2;

import O.i;
import O.k;
import X1.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import d2.b;
import d2.j;
import d2.l;
import d2.m;
import d2.n;
import d2.o;
import d2.t;
import java.util.BitSet;

public class h
extends Drawable
implements o {
    private static final String L = "h";
    static final l M;
    private static final Paint N;
    private static final e[] O;
    private PorterDuffColorFilter A;
    private int B;
    private final RectF C;
    private boolean D;
    private boolean E;
    private l F;
    private O.l G;
    k[] H;
    private float[] I;
    private float[] J;
    private d K;
    private final l.c g = new l.c(this){
        final h a;
        {
            this.a = h3;
        }

        @Override
        public d2.d a(d2.d d2) {
            if (d2 instanceof j) {
                return d2;
            }
            return new b(-this.a.I(), d2);
        }
    };
    private c h;
    private final n.g[] i = new n.g[4];
    private final n.g[] j = new n.g[4];
    private final BitSet k = new BitSet(8);
    private boolean l;
    private boolean m;
    private final Matrix n = new Matrix();
    private final Path o = new Path();
    private final Path p = new Path();
    private final RectF q = new RectF();
    private final RectF r = new RectF();
    private final Region s = new Region();
    private final Region t = new Region();
    private final Paint u;
    private final Paint v;
    private final c2.a w;
    private final m.b x;
    private final m y;
    private PorterDuffColorFilter z;

    static {
        e[] eArray = d2.l.a();
        M = eArray.q(0, 0.0f).m();
        eArray = new Paint(1);
        N = eArray;
        eArray.setColor(-1);
        eArray.setXfermode((Xfermode)new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        O = new e[4];
        for (int i2 = 0; i2 < (eArray = O).length; ++i2) {
            eArray[i2] = new e(i2);
        }
    }

    public h() {
        this(new l());
    }

    public h(Context context, AttributeSet attributeSet, int n2, int n3) {
        this(d2.l.e(context, attributeSet, n2, n3).m());
    }

    protected h(c c2) {
        Paint paint;
        Paint paint2;
        this.u = paint2 = new Paint(1);
        this.v = paint = new Paint(1);
        this.w = new c2.a();
        m m2 = Looper.getMainLooper().getThread() == Thread.currentThread() ? d2.m.l() : new m();
        this.y = m2;
        this.C = new RectF();
        this.D = true;
        this.E = true;
        this.H = new k[4];
        this.h = c2;
        paint.setStyle(Paint.Style.STROKE);
        paint2.setStyle(Paint.Style.FILL);
        this.p0();
        this.l0(this.getState());
        this.x = new m.b(this){
            final h a;
            {
                this.a = h3;
            }

            @Override
            public void a(n n2, Matrix matrix, int n3) {
                this.a.k.set(n3, n2.e());
                ((h)this.a).i[n3] = n2.f(matrix);
            }

            @Override
            public void b(n n2, Matrix matrix, int n3) {
                this.a.k.set(n3 + 4, n2.e());
                ((h)this.a).j[n3] = n2.f(matrix);
            }
        };
    }

    public h(l l2) {
        this(new c(l2, null));
    }

    private float I() {
        if (this.P()) {
            return this.v.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean N() {
        c c2 = this.h;
        int n2 = c2.r;
        return n2 != 1 && c2.s > 0 && (n2 == 2 || this.X());
    }

    private boolean O() {
        Paint.Style style = this.h.w;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
        {
        }
    }

    private boolean P() {
        Paint.Style style = this.h.w;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.v.getStrokeWidth() > 0.0f;
    }

    private void R() {
        super.invalidateSelf();
    }

    private void U(Canvas canvas) {
        if (!this.N()) {
            return;
        }
        canvas.save();
        this.W(canvas);
        if (!this.D) {
            this.s(canvas);
            canvas.restore();
            return;
        }
        int n2 = (int)(this.C.width() - (float)this.getBounds().width());
        int n3 = (int)(this.C.height() - (float)this.getBounds().height());
        if (n2 >= 0 && n3 >= 0) {
            Bitmap bitmap = Bitmap.createBitmap((int)((int)this.C.width() + this.h.s * 2 + n2), (int)((int)this.C.height() + this.h.s * 2 + n3), (Bitmap.Config)Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmap);
            float f2 = this.getBounds().left - this.h.s - n2;
            float f3 = this.getBounds().top - this.h.s - n3;
            canvas2.translate(-f2, -f3);
            this.s(canvas2);
            canvas.drawBitmap(bitmap, f2, f3, null);
            bitmap.recycle();
            canvas.restore();
            return;
        }
        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
    }

    private static int V(int n2, int n3) {
        return n2 * (n3 + (n3 >>> 7)) >>> 8;
    }

    private void W(Canvas canvas) {
        int n2 = this.F();
        int n3 = this.G();
        canvas.translate((float)n2, (float)n3);
    }

    static /* synthetic */ boolean h(h h3, boolean bl) {
        h3.l = bl;
        return bl;
    }

    static /* synthetic */ boolean i(h h3, boolean bl) {
        h3.m = bl;
        return bl;
    }

    private PorterDuffColorFilter j(Paint paint, boolean bl) {
        if (bl) {
            int n2;
            int n3 = paint.getColor();
            this.B = n2 = this.q(n3);
            if (n2 != n3) {
                return new PorterDuffColorFilter(n2, PorterDuff.Mode.SRC_IN);
            }
        }
        return null;
    }

    private void k(RectF rectF, Path path) {
        this.l(rectF, path);
        if (this.h.k != 1.0f) {
            this.n.reset();
            Matrix matrix = this.n;
            float f2 = this.h.k;
            matrix.setScale(f2, f2, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.n);
        }
        path.computeBounds(this.C, true);
    }

    private boolean l0(int[] nArray) {
        boolean bl;
        int n2;
        int n3;
        if (this.h.e != null && (n3 = this.u.getColor()) != (n2 = this.h.e.getColorForState(nArray, n3))) {
            this.u.setColor(n2);
            bl = true;
        } else {
            bl = false;
        }
        if (this.h.f != null && (n3 = this.v.getColor()) != (n2 = this.h.f.getColorForState(nArray, n3))) {
            this.v.setColor(n2);
            return true;
        }
        return bl;
    }

    private float m(RectF rectF, l l2, float[] fArray) {
        if (fArray == null) {
            if (l2.v(rectF)) {
                return l2.r().a(rectF);
            }
        } else if (a.a(fArray) && l2.u()) {
            return fArray[0];
        }
        return -1.0f;
    }

    private void m0(int[] nArray) {
        this.n0(nArray, false);
    }

    private void n() {
        this.o0();
        this.y.f(this.F, this.J, this.h.l, this.y(), null, this.p);
    }

    private void n0(int[] object, boolean bl) {
        RectF rectF = this.x();
        if (this.h.b != null && !rectF.isEmpty()) {
            Object object2 = this.G;
            int n2 = 0;
            int n3 = object2 == null ? 1 : 0;
            boolean bl2 = bl | n3;
            if (this.I == null) {
                this.I = new float[4];
            }
            object = this.h.b.d((int[])object);
            for (n3 = n2; n3 < 4; ++n3) {
                float f2 = this.y.h(n3, (l)object).a(rectF);
                if (bl2) {
                    this.I[n3] = f2;
                }
                if ((object2 = this.H[n3]) == null) continue;
                ((k)object2).l(f2);
                if (!bl2) continue;
                this.H[n3].q();
            }
            if (bl2) {
                this.invalidateSelf();
            }
        }
    }

    private PorterDuffColorFilter o(ColorStateList colorStateList, PorterDuff.Mode mode, boolean bl) {
        int n2;
        int n3 = n2 = colorStateList.getColorForState(this.getState(), 0);
        if (bl) {
            n3 = this.q(n2);
        }
        this.B = n3;
        return new PorterDuffColorFilter(n3, mode);
    }

    private void o0() {
        this.F = this.H().z(this.g);
        float[] fArray = this.I;
        if (fArray == null) {
            this.J = null;
            return;
        }
        if (this.J == null) {
            this.J = new float[fArray.length];
        }
        float f2 = this.I();
        for (int i2 = 0; i2 < (fArray = this.I).length; ++i2) {
            this.J[i2] = Math.max((float)0.0f, (float)(fArray[i2] - f2));
        }
    }

    private PorterDuffColorFilter p(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean bl) {
        if (colorStateList != null && mode != null) {
            return this.o(colorStateList, mode, bl);
        }
        return this.j(paint, bl);
    }

    private boolean p0() {
        PorterDuffColorFilter porterDuffColorFilter = this.z;
        PorterDuffColorFilter porterDuffColorFilter2 = this.A;
        c c2 = this.h;
        this.z = this.p(c2.h, c2.i, this.u, true);
        c2 = this.h;
        this.A = this.p(c2.g, c2.i, this.v, false);
        c2 = this.h;
        if (c2.v) {
            this.w.d(c2.h.getColorForState(this.getState(), 0));
        }
        return !D.c.a(porterDuffColorFilter, this.z) || !D.c.a(porterDuffColorFilter2, this.A);
        {
        }
    }

    private void q0() {
        float f2 = this.M();
        this.h.s = (int)Math.ceil((double)(0.75f * f2));
        this.h.t = (int)Math.ceil((double)(f2 * 0.25f));
        this.p0();
        this.R();
    }

    public static h r(Context context, float f2, ColorStateList object) {
        ColorStateList colorStateList = object;
        if (object == null) {
            colorStateList = ColorStateList.valueOf((int)T1.a.c(context, M1.a.f, h.class.getSimpleName()));
        }
        object = new h();
        ((h)object).Q(context);
        ((h)object).b0(colorStateList);
        ((h)object).a0(f2);
        return object;
    }

    private void s(Canvas canvas) {
        int n2;
        if (this.k.cardinality() > 0) {
            Log.w((String)L, (String)"Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.h.t != 0) {
            canvas.drawPath(this.o, this.w.c());
        }
        for (n2 = 0; n2 < 4; ++n2) {
            this.i[n2].b(this.w, this.h.s, canvas);
            this.j[n2].b(this.w, this.h.s, canvas);
        }
        if (this.D) {
            int n3 = this.F();
            n2 = this.G();
            canvas.translate((float)(-n3), (float)(-n2));
            canvas.drawPath(this.o, N);
            canvas.translate((float)n3, (float)n2);
        }
    }

    private void t(Canvas canvas) {
        this.v(canvas, this.u, this.o, this.h.a, this.I, this.x());
    }

    private void v(Canvas canvas, Paint paint, Path path, l l2, float[] fArray, RectF rectF) {
        float f2 = this.m(rectF, l2, fArray);
        if (f2 >= 0.0f) {
            canvas.drawRoundRect(rectF, f2 *= this.h.l, f2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    private RectF y() {
        this.r.set(this.x());
        float f2 = this.I();
        this.r.inset(f2, f2);
        return this.r;
    }

    public float A() {
        return this.h.p;
    }

    public ColorStateList B() {
        return this.h.e;
    }

    public float C() {
        return this.h.l;
    }

    public float D() {
        return this.h.o;
    }

    public int E() {
        return this.B;
    }

    public int F() {
        c c2 = this.h;
        return (int)((double)c2.t * Math.sin((double)Math.toRadians((double)c2.u)));
    }

    public int G() {
        c c2 = this.h;
        return (int)((double)c2.t * Math.cos((double)Math.toRadians((double)c2.u)));
    }

    public l H() {
        return this.h.a;
    }

    public float J() {
        float[] fArray = this.I;
        if (fArray != null) {
            return fArray[3];
        }
        return this.h.a.r().a(this.x());
    }

    public float K() {
        float[] fArray = this.I;
        if (fArray != null) {
            return fArray[0];
        }
        return this.h.a.t().a(this.x());
    }

    public float L() {
        return this.h.q;
    }

    public float M() {
        return this.A() + this.L();
    }

    public void Q(Context context) {
        this.h.c = new V1.a(context);
        this.q0();
    }

    public boolean S() {
        V1.a a2 = this.h.c;
        return a2 != null && a2.d();
    }

    public boolean T() {
        float[] fArray;
        return this.h.a.v(this.x()) || (fArray = this.I) != null && a.a(fArray) && this.h.a.u();
        {
        }
    }

    public boolean X() {
        return !this.T() && !this.o.isConvex() && Build.VERSION.SDK_INT < 29;
    }

    public void Y(d2.d d2) {
        this.setShapeAppearanceModel(this.h.a.y(d2));
    }

    public void Z(O.l l2) {
        if (this.G != l2) {
            k[] kArray;
            this.G = l2;
            for (int i2 = 0; i2 < (kArray = this.H).length; ++i2) {
                if (kArray[i2] == null) {
                    kArray[i2] = new k(this, O[i2]);
                }
                this.H[i2].p(new O.l().f(l2.a()).h(l2.c()));
            }
            this.n0(this.getState(), true);
            this.invalidateSelf();
        }
    }

    public void a0(float f2) {
        c c2 = this.h;
        if (c2.p != f2) {
            c2.p = f2;
            this.q0();
        }
    }

    public void b0(ColorStateList colorStateList) {
        c c2 = this.h;
        if (c2.e != colorStateList) {
            c2.e = colorStateList;
            this.onStateChange(this.getState());
        }
    }

    public void c0(float f2) {
        c c2 = this.h;
        if (c2.l != f2) {
            c2.l = f2;
            this.l = true;
            this.m = true;
            this.invalidateSelf();
        }
    }

    public void d0(d d2) {
        this.K = d2;
    }

    public void draw(Canvas canvas) {
        this.u.setColorFilter((ColorFilter)this.z);
        int n2 = this.u.getAlpha();
        this.u.setAlpha(d2.h.V(n2, this.h.n));
        this.v.setColorFilter((ColorFilter)this.A);
        this.v.setStrokeWidth(this.h.m);
        int n3 = this.v.getAlpha();
        this.v.setAlpha(d2.h.V(n3, this.h.n));
        if (this.O()) {
            if (this.l) {
                this.k(this.x(), this.o);
                this.l = false;
            }
            this.U(canvas);
            this.t(canvas);
        }
        if (this.P()) {
            if (this.m) {
                this.n();
                this.m = false;
            }
            this.w(canvas);
        }
        this.u.setAlpha(n2);
        this.v.setAlpha(n3);
    }

    public void e0(int n2, int n3, int n4, int n5) {
        c c2 = this.h;
        if (c2.j == null) {
            c2.j = new Rect();
        }
        this.h.j.set(n2, n3, n4, n5);
        this.invalidateSelf();
    }

    public void f0(float f2) {
        c c2 = this.h;
        if (c2.o != f2) {
            c2.o = f2;
            this.q0();
        }
    }

    public void g0(t t2) {
        c c2 = this.h;
        if (c2.b != t2) {
            c2.b = t2;
            this.n0(this.getState(), true);
            this.invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.h.n;
    }

    public Drawable.ConstantState getConstantState() {
        return this.h;
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        RectF rectF;
        if (this.h.r == 2 || (rectF = this.x()).isEmpty()) {
            return;
        }
        float f2 = this.m(rectF, this.h.a, this.I);
        if (f2 >= 0.0f) {
            outline.setRoundRect(this.getBounds(), f2 * this.h.l);
            return;
        }
        if (this.l) {
            this.k(rectF, this.o);
            this.l = false;
        }
        com.google.android.material.drawable.d.i((Outline)outline, (Path)this.o);
    }

    public boolean getPadding(Rect rect) {
        Rect rect2 = this.h.j;
        if (rect2 != null) {
            rect.set(rect2);
            return true;
        }
        return super.getPadding(rect);
    }

    public Region getTransparentRegion() {
        Rect rect = this.getBounds();
        this.s.set(rect);
        this.k(this.x(), this.o);
        this.t.setPath(this.o, this.s);
        this.s.op(this.t, Region.Op.DIFFERENCE);
        return this.s;
    }

    public void h0(float f2, int n2) {
        this.k0(f2);
        this.j0(ColorStateList.valueOf((int)n2));
    }

    public void i0(float f2, ColorStateList colorStateList) {
        this.k0(f2);
        this.j0(colorStateList);
    }

    public void invalidateSelf() {
        this.l = true;
        this.m = true;
        super.invalidateSelf();
    }

    public boolean isStateful() {
        Object object;
        return super.isStateful() || (object = this.h.h) != null && object.isStateful() || (object = this.h.g) != null && object.isStateful() || (object = this.h.f) != null && object.isStateful() || (object = this.h.e) != null && object.isStateful() || (object = this.h.b) != null && ((t)object).f();
        {
        }
    }

    public void j0(ColorStateList colorStateList) {
        c c2 = this.h;
        if (c2.f != colorStateList) {
            c2.f = colorStateList;
            this.onStateChange(this.getState());
        }
    }

    public void k0(float f2) {
        this.h.m = f2;
        this.invalidateSelf();
    }

    protected final void l(RectF rectF, Path path) {
        m m2 = this.y;
        c c2 = this.h;
        m2.f(c2.a, this.I, c2.l, rectF, this.x, path);
    }

    public Drawable mutate() {
        this.h = new c(this.h);
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        this.l = true;
        this.m = true;
        super.onBoundsChange(rect);
        if (this.h.b != null && !rect.isEmpty()) {
            this.n0(this.getState(), this.E);
        }
        this.E = rect.isEmpty();
    }

    protected boolean onStateChange(int[] nArray) {
        if (this.h.b != null) {
            this.m0(nArray);
        }
        boolean bl = this.l0(nArray);
        boolean bl2 = this.p0();
        bl = bl || bl2;
        if (bl) {
            this.invalidateSelf();
        }
        return bl;
    }

    protected int q(int n2) {
        float f2 = this.M();
        float f3 = this.D();
        V1.a a2 = this.h.c;
        int n3 = n2;
        if (a2 != null) {
            n3 = a2.c(n2, f2 + f3);
        }
        return n3;
    }

    public void setAlpha(int n2) {
        c c2 = this.h;
        if (c2.n != n2) {
            c2.n = n2;
            this.R();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.h.d = colorFilter;
        this.R();
    }

    @Override
    public void setShapeAppearanceModel(l l2) {
        c c2 = this.h;
        c2.a = l2;
        c2.b = null;
        this.I = null;
        this.J = null;
        this.invalidateSelf();
    }

    public void setTint(int n2) {
        this.setTintList(ColorStateList.valueOf((int)n2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.h.h = colorStateList;
        this.p0();
        this.R();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        c c2 = this.h;
        if (c2.i != mode) {
            c2.i = mode;
            this.p0();
            this.R();
        }
    }

    protected void u(Canvas canvas, Paint paint, Path path, RectF rectF) {
        this.v(canvas, paint, path, this.h.a, this.I, rectF);
    }

    protected void w(Canvas canvas) {
        this.v(canvas, this.v, this.p, this.F, this.J, this.y());
    }

    protected RectF x() {
        this.q.set(this.getBounds());
        return this.q;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public float z() {
        float f2;
        float f3;
        float[] fArray = this.I;
        if (fArray != null) {
            f3 = fArray[3] + fArray[2] - fArray[1];
            f2 = fArray[0];
            return (f3 - f2) / 2.0f;
        }
        RectF rectF = this.x();
        f3 = this.y.h(3, this.H()).a(rectF) + this.y.h(2, this.H()).a(rectF) - this.y.h(1, this.H()).a(rectF);
        f2 = this.y.h(0, this.H()).a(rectF);
        return (f3 - f2) / 2.0f;
    }

    protected static class c
    extends Drawable.ConstantState {
        l a;
        t b;
        V1.a c;
        ColorFilter d;
        ColorStateList e = null;
        ColorStateList f = null;
        ColorStateList g = null;
        ColorStateList h = null;
        PorterDuff.Mode i = PorterDuff.Mode.SRC_IN;
        Rect j = null;
        float k = 1.0f;
        float l = 1.0f;
        float m;
        int n = 255;
        float o = 0.0f;
        float p = 0.0f;
        float q = 0.0f;
        int r = 0;
        int s = 0;
        int t = 0;
        int u = 0;
        boolean v = false;
        Paint.Style w = Paint.Style.FILL_AND_STROKE;

        public c(c c2) {
            this.a = c2.a;
            this.b = c2.b;
            this.c = c2.c;
            this.m = c2.m;
            this.d = c2.d;
            this.e = c2.e;
            this.f = c2.f;
            this.i = c2.i;
            this.h = c2.h;
            this.n = c2.n;
            this.k = c2.k;
            this.t = c2.t;
            this.r = c2.r;
            this.v = c2.v;
            this.l = c2.l;
            this.o = c2.o;
            this.p = c2.p;
            this.q = c2.q;
            this.s = c2.s;
            this.u = c2.u;
            this.g = c2.g;
            this.w = c2.w;
            if (c2.j != null) {
                this.j = new Rect(c2.j);
            }
        }

        public c(l l2, V1.a a2) {
            this.a = l2;
            this.c = a2;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            h h3 = new h(this);
            d2.h.h(h3, true);
            d2.h.i(h3, true);
            return h3;
        }
    }

    public static interface d {
        public void a(float var1);
    }

    private static class e
    extends i {
        private final int b;

        e(int n2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("cornerSizeAtIndex");
            stringBuilder.append(n2);
            super(stringBuilder.toString());
            this.b = n2;
        }

        public float c(h h3) {
            if (h3.I != null) {
                return h3.I[this.b];
            }
            return 0.0f;
        }

        public void d(h h3, float f2) {
            if (h3.I != null && h3.I[this.b] != f2) {
                ((h)h3).I[this.b] = f2;
                if (h3.K != null) {
                    h3.K.a(h3.z());
                }
                h3.invalidateSelf();
            }
        }
    }
}

