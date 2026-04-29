/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  androidx.core.graphics.drawable.a
 *  java.lang.Math
 *  java.lang.Object
 */
package h;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import f.a;
import f.i;
import f.j;

public class d
extends Drawable {
    private static final float m = (float)Math.toRadians((double)45.0);
    private final Paint a;
    private float b;
    private float c;
    private float d;
    private float e;
    private boolean f;
    private final Path g;
    private final int h;
    private boolean i;
    private float j;
    private float k;
    private int l;

    public d(Context context) {
        Paint paint;
        this.a = paint = new Paint();
        this.g = new Path();
        this.i = false;
        this.l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        context = context.getTheme().obtainStyledAttributes(null, f.j.Z0, f.a.z, f.i.b);
        this.c(context.getColor(f.j.d1, 0));
        this.b(context.getDimension(f.j.h1, 0.0f));
        this.f(context.getBoolean(f.j.g1, true));
        this.d(Math.round((float)context.getDimension(f.j.f1, 0.0f)));
        this.h = context.getDimensionPixelSize(f.j.e1, 0);
        this.c = Math.round((float)context.getDimension(f.j.c1, 0.0f));
        this.b = Math.round((float)context.getDimension(f.j.a1, 0.0f));
        this.d = context.getDimension(f.j.b1, 0.0f);
        context.recycle();
    }

    private static float a(float f2, float f3, float f4) {
        return f2 + (f3 - f2) * f4;
    }

    public void b(float f2) {
        if (this.a.getStrokeWidth() != f2) {
            this.a.setStrokeWidth(f2);
            this.k = (float)((double)(f2 / 2.0f) * Math.cos((double)m));
            this.invalidateSelf();
        }
    }

    public void c(int n2) {
        if (n2 != this.a.getColor()) {
            this.a.setColor(n2);
            this.invalidateSelf();
        }
    }

    public void d(float f2) {
        if (f2 != this.e) {
            this.e = f2;
            this.invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        int n2;
        Rect rect;
        block6: {
            block7: {
                int n3;
                block8: {
                    rect = this.getBounds();
                    int n4 = this.l;
                    n2 = n3 = 0;
                    if (n4 == 0) break block6;
                    if (n4 == 1) break block7;
                    if (n4 == 3) break block8;
                    n2 = n3;
                    if (androidx.core.graphics.drawable.a.f((Drawable)this) != 1) break block6;
                    break block7;
                }
                n2 = n3;
                if (androidx.core.graphics.drawable.a.f((Drawable)this) != 0) break block6;
            }
            n2 = 1;
        }
        float f2 = this.b;
        f2 = (float)Math.sqrt((double)(f2 * f2 * 2.0f));
        float f3 = h.d.a(this.c, f2, this.j);
        float f4 = h.d.a(this.c, this.d, this.j);
        float f5 = Math.round((float)h.d.a(0.0f, this.k, this.j));
        float f6 = h.d.a(0.0f, m, this.j);
        f2 = n2 != 0 ? 0.0f : -180.0f;
        float f7 = n2 != 0 ? 180.0f : 0.0f;
        f2 = h.d.a(f2, f7, this.j);
        double d2 = f3;
        double d3 = f6;
        f3 = Math.round((double)(Math.cos((double)d3) * d2));
        f6 = Math.round((double)(d2 * Math.sin((double)d3)));
        this.g.rewind();
        float f8 = h.d.a(this.e + this.a.getStrokeWidth(), -this.k, this.j);
        f7 = -f4 / 2.0f;
        this.g.moveTo(f7 + f5, 0.0f);
        this.g.rLineTo(f4 - f5 * 2.0f, 0.0f);
        this.g.moveTo(f7, f8);
        this.g.rLineTo(f3, f6);
        this.g.moveTo(f7, -f8);
        this.g.rLineTo(f3, -f6);
        this.g.close();
        canvas.save();
        f4 = this.a.getStrokeWidth();
        f5 = rect.height();
        f7 = this.e;
        f5 = (int)(f5 - 3.0f * f4 - f7 * 2.0f) / 4 * 2;
        canvas.translate((float)rect.centerX(), f5 + (f4 * 1.5f + f7));
        if (this.f) {
            n2 = this.i ^ n2 ? -1 : 1;
            canvas.rotate(f2 * (float)n2);
        } else if (n2 != 0) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.g, this.a);
        canvas.restore();
    }

    public void e(float f2) {
        if (this.j != f2) {
            this.j = f2;
            this.invalidateSelf();
        }
    }

    public void f(boolean bl) {
        if (this.f != bl) {
            this.f = bl;
            this.invalidateSelf();
        }
    }

    public void g(boolean bl) {
        if (this.i != bl) {
            this.i = bl;
            this.invalidateSelf();
        }
    }

    public int getIntrinsicHeight() {
        return this.h;
    }

    public int getIntrinsicWidth() {
        return this.h;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int n2) {
        if (n2 != this.a.getAlpha()) {
            this.a.setAlpha(n2);
            this.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
        this.invalidateSelf();
    }
}

