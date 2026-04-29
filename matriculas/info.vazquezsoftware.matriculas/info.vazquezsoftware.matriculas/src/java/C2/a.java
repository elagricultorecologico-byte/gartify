/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.LinearGradient
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.RadialGradient
 *  android.graphics.RectF
 *  android.graphics.Region$Op
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  androidx.core.graphics.a
 *  java.lang.Object
 */
package c2;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;

public class a {
    private static final int[] i = new int[3];
    private static final float[] j = new float[]{0.0f, 0.5f, 1.0f};
    private static final int[] k = new int[4];
    private static final float[] l = new float[]{0.0f, 0.0f, 0.5f, 1.0f};
    private final Paint a;
    private final Paint b;
    private final Paint c;
    private int d;
    private int e;
    private int f;
    private final Path g = new Path();
    private final Paint h;

    public a() {
        this(-16777216);
    }

    public a(int n3) {
        Paint paint;
        this.h = paint = new Paint();
        this.a = new Paint();
        this.d(n3);
        paint.setColor(0);
        this.b = paint = new Paint(4);
        paint.setStyle(Paint.Style.FILL);
        this.c = new Paint(paint);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int n3, float f3, float f4) {
        float f5;
        Object object;
        boolean bl = f4 < 0.0f;
        Path path = this.g;
        if (bl) {
            object = k;
            object[0] = 0;
            object[1] = this.f;
            object[2] = this.e;
            object[3] = this.d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f3, f4);
            path.close();
            f5 = -n3;
            rectF.inset(f5, f5);
            object = k;
            object[0] = 0;
            object[1] = this.d;
            object[2] = this.e;
            object[3] = this.f;
        }
        f5 = rectF.width() / 2.0f;
        if (f5 <= 0.0f) {
            return;
        }
        float f6 = 1.0f - (float)n3 / f5;
        float f7 = (1.0f - f6) / 2.0f;
        object = l;
        object[1] = (int)f6;
        object[2] = (int)(f7 + f6);
        object = new RadialGradient(rectF.centerX(), rectF.centerY(), f5, k, (float[])object, Shader.TileMode.CLAMP);
        this.b.setShader((Shader)object);
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!bl) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.h);
        }
        canvas.drawArc(rectF, f3, f4, true, this.b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int n3) {
        rectF.bottom += (float)n3;
        rectF.offset(0.0f, (float)(-n3));
        int[] nArray = i;
        nArray[0] = this.f;
        nArray[1] = this.e;
        nArray[2] = this.d;
        Paint paint = this.c;
        float f3 = rectF.left;
        paint.setShader((Shader)new LinearGradient(f3, rectF.top, f3, rectF.bottom, nArray, j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.c);
        canvas.restore();
    }

    public Paint c() {
        return this.a;
    }

    public void d(int n3) {
        this.d = androidx.core.graphics.a.k((int)n3, (int)68);
        this.e = androidx.core.graphics.a.k((int)n3, (int)20);
        this.f = androidx.core.graphics.a.k((int)n3, (int)0);
        this.a.setColor(this.d);
    }
}

