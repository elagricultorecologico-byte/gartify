/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$FontMetricsInt
 *  android.graphics.RectF
 *  android.text.style.ReplacementSpan
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 */
package r2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;

public class q
extends ReplacementSpan {
    private final int a;
    private final int b;
    private final float c;
    private final float d;
    private final float e;

    public q(int n2, int n3) {
        this.a = n2;
        this.b = n3;
        this.c = 35.0f;
        this.d = 12.0f;
        this.e = 12.0f;
    }

    public void draw(Canvas canvas, CharSequence charSequence, int n2, int n3, float f2, int n4, int n5, int n6, Paint paint) {
        float f3 = paint.measureText(charSequence, n2, n3);
        n4 = paint.getColor();
        float f4 = n5;
        RectF rectF = new RectF(f2, paint.ascent() + f4 - this.d, f3 + f2 + this.c * 2.0f, paint.descent() + f4 + this.d);
        paint.setColor(this.a);
        f3 = this.e;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        paint.setColor(this.b);
        paint.setFakeBoldText(true);
        canvas.drawText(charSequence, n2, n3, f2 + this.c, f4, paint);
        paint.setColor(n4);
        paint.setFakeBoldText(false);
    }

    public int getSize(Paint paint, CharSequence charSequence, int n2, int n3, Paint.FontMetricsInt fontMetricsInt) {
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            float f2 = fontMetricsInt2.top;
            float f3 = this.d;
            fontMetricsInt.top = (int)(f2 - f3);
            fontMetricsInt.ascent = (int)((float)fontMetricsInt2.ascent - f3);
            fontMetricsInt.descent = (int)((float)fontMetricsInt2.descent + f3);
            fontMetricsInt.bottom = (int)((float)fontMetricsInt2.bottom + f3);
        }
        return Math.round((float)(paint.measureText(charSequence, n2, n3) + this.c * 2.0f));
    }
}

